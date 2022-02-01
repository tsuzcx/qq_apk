#extension GL_OES_EGL_image_external : require
precision highp float;
uniform samplerExternalOES texture;
varying highp vec2 v_TexCoordinate;
varying highp vec2 textureCoordinateRGB;
varying highp vec2 textureCoordinateAlpha;
uniform highp vec2 vSurfaceWidth;



void main() {
    highp vec4 rgbColor = texture2D(texture, textureCoordinateRGB);
    highp vec4 alphaColor = texture2D(texture, textureCoordinateAlpha);

    float off = mod(floor(gl_FragCoord.x - 0.5) , 3.0);
    if (off < 0.5 || off > 2.8) {
        gl_FragColor = vec4(rgbColor.rgb * alphaColor.r, alphaColor.r);
    } else if (off < 1.5) {
        gl_FragColor = vec4(rgbColor.rgb * alphaColor.g, alphaColor.g);
    } else {
        gl_FragColor = vec4(rgbColor.rgb * alphaColor.b, alphaColor.b);
    }

}
