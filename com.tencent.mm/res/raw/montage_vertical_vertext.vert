precision highp float;
attribute vec4 vPosition;
attribute vec4 vTexCoordinate;
varying vec2 textureCoordinateRGB;
varying vec2 textureCoordinateAlpha;
uniform mat4 textureTransform;
varying vec2 v_TexCoordinate;

void main() {
    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;
    gl_Position = vPosition;
    highp float offset = 0.5;
    textureCoordinateRGB = vec2((textureTransform * vTexCoordinate).x, (textureTransform * vTexCoordinate).y);
    textureCoordinateAlpha = vec2((textureTransform * vTexCoordinate).x, (textureTransform  * vec4(vTexCoordinate.x, vTexCoordinate.y / 2.0  - offset, vTexCoordinate.z, vTexCoordinate.w)).y);
}
