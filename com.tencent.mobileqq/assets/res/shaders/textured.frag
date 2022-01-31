#extension GL_OES_EGL_image_external : require
#ifdef OPENGL_ES
#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif
#endif

#ifndef DIRECTIONAL_LIGHT_COUNT
#define DIRECTIONAL_LIGHT_COUNT 0
#endif
#ifndef SPOT_LIGHT_COUNT
#define SPOT_LIGHT_COUNT 0
#endif
#ifndef POINT_LIGHT_COUNT
#define POINT_LIGHT_COUNT 0
#endif
#if (DIRECTIONAL_LIGHT_COUNT > 0) || (POINT_LIGHT_COUNT > 0) || (SPOT_LIGHT_COUNT > 0)
#define LIGHTING
#endif

///////////////////////////////////////////////////////////
// Uniforms
uniform vec3 u_ambientColor;

#if defined(TEXTURECUBE)
uniform samplerCube u_diffuseTexture;
#else
    #if defined(SURFACE_TEXTURE)
      uniform samplerExternalOES u_diffuseTexture;
    #else
      uniform sampler2D u_diffuseTexture;
    #endif
#endif

#if defined(ANDROIDLATED_COLOR)
uniform vec3 u_androidlatedColor;
#endif
#if defined(LIGHTMAP)
uniform sampler2D u_lightmapTexture;
#endif

#if defined(LIGHTING)

#if defined(BUMPED)
uniform sampler2D u_normalmapTexture;
#endif

#if (DIRECTIONAL_LIGHT_COUNT > 0)
uniform vec3 u_directionalLightColor[DIRECTIONAL_LIGHT_COUNT];
#if !defined(BUMPED)
uniform vec3 u_directionalLightDirection[DIRECTIONAL_LIGHT_COUNT];
#endif
#endif

#if (POINT_LIGHT_COUNT > 0)
uniform vec3 u_pointLightColor[POINT_LIGHT_COUNT];
uniform vec3 u_pointLightPosition[POINT_LIGHT_COUNT];
uniform float u_pointLightRangeInverse[POINT_LIGHT_COUNT];
#endif

#if (SPOT_LIGHT_COUNT > 0)
uniform vec3 u_spotLightColor[SPOT_LIGHT_COUNT];
uniform float u_spotLightRangeInverse[SPOT_LIGHT_COUNT];
uniform float u_spotLightInnerAngleCos[SPOT_LIGHT_COUNT];
uniform float u_spotLightOuterAngleCos[SPOT_LIGHT_COUNT];
#if !defined(BUMPED)
uniform vec3 u_spotLightDirection[SPOT_LIGHT_COUNT];
#endif
#endif

#if defined(SPECULAR)
uniform float u_specularExponent;
#endif

#endif

#if defined(MODULATE_COLOR)
uniform vec4 u_modulateColor;
#endif

#if defined(MODULATE_ALPHA)
uniform float u_modulateAlpha;
#endif

///////////////////////////////////////////////////////////
// Variables
vec4 _baseColor;

///////////////////////////////////////////////////////////
// Varyings
#if defined(TEXTURECUBE)
varying vec3 v_texCoord;
#else
varying vec2 v_texCoord;
#endif

#if defined(LIGHTMAP)
varying vec2 v_texCoord1;
#endif

#if defined(LIGHTING)

#if !defined(BUMPED)
varying vec3 v_normalVector;
#endif

#if defined(BUMPED) && (DIRECTIONAL_LIGHT_COUNT > 0)
varying vec3 v_directionalLightDirection[DIRECTIONAL_LIGHT_COUNT];
#endif

#if (POINT_LIGHT_COUNT > 0)
varying vec3 v_vertexToPointLightDirection[POINT_LIGHT_COUNT];
#endif

#if (SPOT_LIGHT_COUNT > 0)
varying vec3 v_vertexToSpotLightDirection[SPOT_LIGHT_COUNT];
#if defined(BUMPED)
varying vec3 v_spotLightDirection[SPOT_LIGHT_COUNT];
#endif
#endif

#if defined(SPECULAR)
varying vec3 v_cameraDirection;
#endif

#include "lighting.frag"

#endif

#if defined(CLIP_PLANE)
varying float v_clipDistance;
#endif

///////////////////////////////////////////////////////////
// chroma key algrithm uniforms
#if defined(CHROMA_KEY)
uniform vec4 u_screenColor;

#if defined(SCREEN_WEIGHT)
uniform float u_screenWeight;
#endif

#if defined(BALANCE)
uniform float u_balance;
#endif

#if defined(CLIP_BLACK)
uniform float u_clipBlack;
#endif

#if defined(CLIP_WHITE)
uniform float u_clipWhite;
#endif
#endif


void main()
{
    #if defined(CLIP_PLANE)
    if(v_clipDistance < 0.0) discard;
    #endif

#if defined(TEXTURECUBE)
    _baseColor = textureCube(u_diffuseTexture, v_texCoord);
#else
    _baseColor = texture2D(u_diffuseTexture, v_texCoord);
#endif

    gl_FragColor.a = _baseColor.a;

    #if defined(TEXTURE_DISCARD_ALPHA)
    if (gl_FragColor.a < 0.5)
        discard;
    #endif

    #if defined(LIGHTING)

    gl_FragColor.rgb = getLitPixel();
    #else
    gl_FragColor.rgb = _baseColor.rgb;
    #endif

	#if defined(LIGHTMAP)
	vec4 lightColor = texture2D(u_lightmapTexture, v_texCoord1);
	gl_FragColor.rgb *= lightColor.rgb;
	#endif

    #if defined(MODULATE_COLOR)
    gl_FragColor *= u_modulateColor;
    #endif

    #if defined(MODULATE_ALPHA)
    gl_FragColor.a *= u_modulateAlpha;
    #endif

#if defined(FORCE_GRAY)
    float gray = dot(gl_FragColor.rgb, vec3(0.299, 0.587, 0.114));
    gl_FragColor.r = gray;
    gl_FragColor.g = gray;
    gl_FragColor.b = gray;
#endif

#if defined(ANDROIDLATED_COLOR)
    float maskY = 0.2989 * u_androidlatedColor.r + 0.5866 * u_androidlatedColor.g + 0.1145 * u_androidlatedColor.b;
    float maskCr = 0.7132 * (u_androidlatedColor.r - maskY);
    float maskCb = 0.5647 * (u_androidlatedColor.b - maskY);

    float Y = 0.2989 * gl_FragColor.r + 0.5866 * gl_FragColor.g + 0.1145 * gl_FragColor.b;
    float Cr = 0.7132 * (gl_FragColor.r - Y);
    float Cb = 0.5647 * (gl_FragColor.b - Y);

    gl_FragColor.a *= smoothstep(0.34, 0.5, distance(vec2(Cr, Cb), vec2(maskCr, maskCb)));//0.34 + 0.1,
#endif

#if defined(CHROMA_KEY)
    //chroma key算法，从github上抄的 brianchirls/Seriously.js/effects/seriously.chroma.js

#if !defined(SCREEN_WEIGHT)
    float u_screenWeight = 1.0;
#endif

#if !defined(BALANCE)
    float u_balance = 1.0;
#endif

#if !defined(CLIP_BLACK)
    float u_clipBlack = 0.0;
#endif

#if !defined(CLIP_WHITE)
    float u_clipWhite = 1.0;
#endif

    //待优化，screenPrimary，screenSat应该在CPU中计算，对于每个像素都是一样的
    float screenFmin = min(min(u_screenColor.r, u_screenColor.g), u_screenColor.b);
    float screenFmax = max(max(u_screenColor.r, u_screenColor.g), u_screenColor.b);
    vec3 screenPrimary = step(screenFmax, u_screenColor.rgb);
    float secondaryComponents = dot(1.0 - screenPrimary, u_screenColor.rgb);
    float screenSat = screenFmax - mix(secondaryComponents - screenFmin, secondaryComponents / 2.0, u_balance);

    float fmin = min(min(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
    float fmax = max(max(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
    //	luminance = fmax

    vec3 pixelPrimary = step(fmax, gl_FragColor.rgb);

    secondaryComponents = dot(1.0 - pixelPrimary, gl_FragColor.rgb);
    float pixelSat = fmax - mix(secondaryComponents - fmin, secondaryComponents / 2.0, u_balance); // Saturation

    // solid pixel if primary color component is not the same as the screen color
    float diffPrimary = dot(abs(pixelPrimary - screenPrimary), vec3(1.0));
    float solid = step(1.0, step(pixelSat, 0.1) + step(fmax, 0.1) + diffPrimary);

    /*
     Semi-transparent pixel if the primary component matches but if saturation is less
     than that of screen color. Otherwise totally transparent
     */
    float alpha = max(0.0, 1.0 - pixelSat / screenSat);
    alpha = smoothstep(u_clipBlack, u_clipWhite, alpha);
    vec4 semiTransparentPixel = vec4((gl_FragColor.rgb - (1.0 - alpha) * u_screenColor.rgb * u_screenWeight) / max(0.00001, alpha), alpha);

    vec4 pixel = mix(semiTransparentPixel, gl_FragColor, solid);

    gl_FragColor = pixel;
#endif
}
