
precision highp float;

attribute vec4 inCoord;
attribute vec3 inNormal;
attribute vec2 inTexCoord;

uniform mat4 m4Projection;
uniform mat4 m4ModelTrans;

varying vec4 fragCoord;
varying vec3 fragNormal;
varying vec2 fragTexCoord;

vec4 getPosition()
{
    return inCoord;
}

vec3 getNormal()
{
    return inNormal;
}

void main()
{
    fragCoord = getPosition();
    fragTexCoord = inTexCoord;
    fragNormal = getNormal();
    
    gl_Position = m4Projection * m4ModelTrans * fragCoord;
}
