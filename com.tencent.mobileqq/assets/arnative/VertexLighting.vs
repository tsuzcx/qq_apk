
precision highp float;

attribute vec4 inCoord;
attribute vec3 inNormal;
attribute vec2 inTexCoord;

uniform mat4 m4Projection;
uniform mat4 m4ModelTrans;
uniform mat3 m3InverseTrans;

#define MAX_SHADOW_LIGHTS 3
uniform lowp int shadowLightNum;
uniform sampler2D shadowMap0Sampler;
uniform sampler2D shadowMap1Sampler;
uniform sampler2D shadowMap2Sampler;
uniform mat4 lightPOV[MAX_SHADOW_LIGHTS];

varying vec4 fragCoord;
varying vec3 fragNormal;
varying vec2 fragTexCoord;
varying vec4 lightPOVCoord[MAX_SHADOW_LIGHTS];

varying float lightCoeff;

uniform vec3 cameraPosition;
uniform float materialShininess;
uniform vec3 materialSpecularColor;
uniform int numLights;

#define MAX_LIGHTS 3
uniform struct Light {
    vec4 position;
    vec3 intensities; //a.k.a the color of the light
    float attenuation;
    float ambientCoefficient;
    float coneAngleCos;
    float outterAngleCos;
    vec3 coneDirection;
} allLights[MAX_LIGHTS];

#if defined(SKINNING)

// need to define SkinCount
attribute vec4 a_blendWeights;
attribute vec4 a_blendIndices;
uniform vec4 u_matrixPalette[SKINNING_JOINT_COUNT * 3];

vec4 _skinnedPosition;

void skinPosition(float blendWeight, int matrixIndex)
{
    vec4 tmp;
    tmp.x = dot(inCoord, u_matrixPalette[matrixIndex]);
    tmp.y = dot(inCoord, u_matrixPalette[matrixIndex + 1]);
    tmp.z = dot(inCoord, u_matrixPalette[matrixIndex + 2]);
    tmp.w = inCoord.w;
    _skinnedPosition += blendWeight * tmp;
}

vec4 getPosition()
{
    _skinnedPosition = vec4(0.0);
    float blendWeight = a_blendWeights[0];
    int matrixIndex = int (a_blendIndices[0]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[1];
    matrixIndex = int(a_blendIndices[1]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[2];
    matrixIndex = int(a_blendIndices[2]) * 3;
    skinPosition(blendWeight, matrixIndex);
    blendWeight = a_blendWeights[3];
    matrixIndex = int(a_blendIndices[3]) * 3;
    skinPosition(blendWeight, matrixIndex);
    return _skinnedPosition;
}

vec3 _skinnedNormal;

void skinTangentSpaceVector(vec3 vector, float blendWeight, int matrixIndex)
{
    vec3 tmp;
    tmp.x = dot(vector, u_matrixPalette[matrixIndex].xyz);
    tmp.y = dot(vector, u_matrixPalette[matrixIndex + 1].xyz);
    tmp.z = dot(vector, u_matrixPalette[matrixIndex + 2].xyz);
    _skinnedNormal += blendWeight * tmp;
}

vec3 getTangentSpaceVector(vec3 vector)
{
    _skinnedNormal = vec3(0.0);
    // Transform normal to view space using matrix palette with four matrices used to transform a vertex.
    float blendWeight = a_blendWeights[0];
    int matrixIndex = int (a_blendIndices[0]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[1];
    matrixIndex = int(a_blendIndices[1]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[2];
    matrixIndex = int(a_blendIndices[2]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    blendWeight = a_blendWeights[3];
    matrixIndex = int(a_blendIndices[3]) * 3;
    skinTangentSpaceVector(vector, blendWeight, matrixIndex);
    return _skinnedNormal;
}

vec3 getNormal()
{
    return getTangentSpaceVector(inNormal);
}

#else

vec4 getPosition()
{
    return inCoord;
}

vec3 getNormal()
{
    return inNormal;
}

#endif


float ApplyLight(int index, Light light, vec3 normal, vec3 surfacePos, vec3 surfaceToCamera) {
    vec3 surfaceToLight;
    float attenuation = 1.0;
    
    if(light.position.w == 0.0) {
        //directional light
        surfaceToLight = normalize(light.position.xyz);
        attenuation = 1.0; //no attenuation for directional lights
    } else {
        //point light
        surfaceToLight = normalize(light.position.xyz - surfacePos);
        float distanceToLight = length(light.position.xyz - surfacePos);
        attenuation = 1.0 / (1.0 + light.attenuation * distanceToLight * distanceToLight);
        
        //cone restrictions (affects attenuation)
        
        float curAngleCos = dot(-surfaceToLight, normalize(light.coneDirection));
        
        //float lightToSurfaceAngle = degrees(acos(cosCurAngle));
        float fade = clamp((curAngleCos - light.outterAngleCos) / (light.coneAngleCos - light.outterAngleCos), 0.0, 1.0);
        attenuation = attenuation * fade;
    }
    
    //ambient
    float ambient = light.ambientCoefficient;
    
    // if is in shadow
    float shadowCoeff = 1.0;
    if (index < shadowLightNum) {
        vec4 shadowMapCoord = lightPOVCoord[index]; //
        vec2 shadowUV;
        shadowUV.x = 0.5 * shadowMapCoord.x / shadowMapCoord.w + 0.5;
        shadowUV.y = 0.5 * shadowMapCoord.y / shadowMapCoord.w + 0.5;
        
        if (shadowUV.x < 1.0 && shadowUV.x > 0.0 && shadowUV.y < 1.0 && shadowUV.y > 0.0)
        {
            highp float depth = 0.5 * shadowMapCoord.z / shadowMapCoord.w + 0.5;
            highp float lightDepth = 0.0;
            if (index == 0) {
                lightDepth = texture2D(shadowMap0Sampler, shadowUV.st).x;
            } else if (index == 1) {
                lightDepth = texture2D(shadowMap1Sampler, shadowUV.st).x;
            } else if (index == 2) {
                lightDepth = texture2D(shadowMap2Sampler, shadowUV.st).x;
            }
            if (depth > lightDepth + 0.01)
                shadowCoeff = 0.2;
        }
    }
    
    
    //diffuse
    float diffuseCoefficient = max(0.0, dot(normal, surfaceToLight));
    float diffuse = diffuseCoefficient;
    
    //specular
    float specularCoefficient = 0.0;
    if(diffuseCoefficient > 0.0)
        specularCoefficient = pow(max(0.0, dot(surfaceToCamera, reflect(-surfaceToLight, normal))), materialShininess);
    float specular = specularCoefficient;
    
    //linear color (color before gamma correction)
    return ambient + shadowCoeff * attenuation * (diffuse + specular);
}

void main()
{
    fragCoord = getPosition();
    fragTexCoord = inTexCoord;
    fragNormal = getNormal();
    
    for (int i = 0; i < shadowLightNum; ++i) {
        lightPOVCoord[i] = lightPOV[i] * m4ModelTrans * fragCoord;
    }
    
    vec3 normal = normalize(m3InverseTrans * fragNormal);
    vec3 surfacePos = vec3(m4ModelTrans * fragCoord);
    vec3 surfaceToCamera = normalize(cameraPosition - surfacePos);
    
    //combine color from all the lights
    float lightC = 0.0;
    for(int i = 0; i < numLights; ++i){
        lightC += ApplyLight(i, allLights[i], normal, surfacePos, surfaceToCamera);
    }
    lightCoeff = lightC;
    
    gl_Position = m4Projection * m4ModelTrans * fragCoord;
}