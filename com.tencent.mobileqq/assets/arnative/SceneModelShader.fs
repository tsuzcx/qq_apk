#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif

uniform sampler2D defaultSampler;

varying vec4 fragCoord;
varying vec2 fragTexCoord;
varying vec3 fragNormal;

void main()
{
    gl_FragColor = texture2D(defaultSampler, fragTexCoord.st, 0.0); 
}