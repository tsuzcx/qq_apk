#extension GL_OES_EGL_image_external : require
precision mediump float;
uniform samplerExternalOES texture;
varying vec2 v_TexCoordinate;
varying vec2 v_TexAlphaCoordinate;
void main () {
    vec4 color = texture2D(texture, v_TexCoordinate);
    float r = texture2D(texture, v_TexAlphaCoordinate).r;
    float g = texture2D(texture, v_TexAlphaCoordinate).g;
    float b = texture2D(texture, v_TexAlphaCoordinate).b;
    float alpha = min(r, min(g, b)) * texture2D(texture, v_TexAlphaCoordinate).a;
    gl_FragColor = color;
    gl_FragColor.a = gl_FragColor.a * alpha;
    gl_FragColor.r = gl_FragColor.r * alpha;
    gl_FragColor.g = gl_FragColor.g * alpha;
    gl_FragColor.b = gl_FragColor.b * alpha;
}