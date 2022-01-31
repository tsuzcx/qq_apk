precision highp float;

uniform sampler2D defaultSampler;

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

uniform mat4 m4ModelTrans;
uniform mat3 m3InverseTrans;

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

#define MAX_SHADOW_LIGHTS 3
uniform lowp int shadowLightNum;
uniform mat4 lightPOV[MAX_SHADOW_LIGHTS];

varying vec4 lightPOVCoord[MAX_SHADOW_LIGHTS];

uniform sampler2D shadowMap0Sampler;
uniform sampler2D shadowMap1Sampler;
uniform sampler2D shadowMap2Sampler;

vec3 ApplyLight(int index, Light light, vec3 surfaceColor, vec3 normal, vec3 surfacePos, vec3 surfaceToCamera) {
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
    vec3 ambient = light.ambientCoefficient * surfaceColor.rgb * light.intensities;
    
    // if is in shadow
    float shadowCoeff = 1.0;
    /*
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
     */
    
    
    //diffuse
    float diffuseCoefficient = max(0.0, dot(normal, surfaceToLight));
    vec3 diffuse = diffuseCoefficient * surfaceColor.rgb * light.intensities * light.intensities * (1.0 - light.ambientCoefficient);
    
    //specular
    float specularCoefficient = 0.0;
    if(diffuseCoefficient > 0.0 && materialShininess > 1.0)
        specularCoefficient = pow(max(0.0, dot(surfaceToCamera, reflect(-surfaceToLight, normal))), materialShininess);
    vec3 specular = specularCoefficient * materialSpecularColor * light.intensities;
    
    //linear color (color before gamma correction)
    return ambient + shadowCoeff * attenuation * (diffuse + specular);
}

void main() {
    vec3 normal = normalize(m3InverseTrans * fragNormal);
    vec3 surfacePos = vec3(m4ModelTrans * fragCoord);
    vec4 surfaceColor = texture2D(defaultSampler, fragTexCoord);
    vec3 surfaceToCamera = normalize(cameraPosition - surfacePos);
    vec3 linearColor = vec3(0);
    linearColor += ApplyLight(0, allLights[0], surfaceColor.rgb, normal, surfacePos, surfaceToCamera);
    gl_FragColor = vec4(linearColor, surfaceColor.a); // without gamma correction
}