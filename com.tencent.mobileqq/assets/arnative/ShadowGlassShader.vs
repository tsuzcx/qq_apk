
precision highp float;

attribute vec4 inCoord;
attribute vec3 inNormal;
attribute vec2 inTexCoord;

uniform mat4 m4Projection;
uniform mat4 m4ModelTrans;

#define MAX_SHADOW_LIGHTS 3
uniform lowp int shadowLightNum;
uniform mat4 lightPOV[MAX_SHADOW_LIGHTS];

varying vec4 fragCoord;
varying vec4 lightPOVCoord[MAX_SHADOW_LIGHTS];

void main()
{
    fragCoord = inCoord;;
    lightPOVCoord[0] = lightPOV[0] * m4ModelTrans * fragCoord;
    gl_Position = m4Projection * m4ModelTrans * fragCoord;
}