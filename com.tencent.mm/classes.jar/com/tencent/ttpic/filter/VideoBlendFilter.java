package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.i;
import com.tencent.filter.m.n;

public class VideoBlendFilter
  extends BaseFilter
{
  private static final String FRAGREMENT_SHADERS = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec4 c1 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n";
  private static final String FRAGREMENT_SHADERS_3D_GAME = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec2 c = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y); \n      vec4 c1 = texture2D(inputImageTexture2, c);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n";
  int blendmode = 0;
  
  public VideoBlendFilter(String paramString)
  {
    super(paramString);
  }
  
  public static VideoBlendFilter create3DGameBlendFilter()
  {
    return new VideoBlendFilter(" precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec2 c = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y); \n      vec4 c1 = texture2D(inputImageTexture2, c);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n");
  }
  
  public static VideoBlendFilter ctreateBlendFilter()
  {
    return new VideoBlendFilter(" precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec4 c1 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 c2 = texture2D(inputImageTexture, textureCoordinate);\n        c2.a = 1.0;\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     }\n     if(blendmode == 1){\n        gl_FragColor = mix(c1,c2,0.5);\n     }\n     if(blendmode == 2){\n        gl_FragColor = mix(c2,c1,c1.a);\n     }\n        gl_FragColor.a = 1.0;\n}\n");
  }
  
  public void ApplyGLSLFilter()
  {
    addParam(new m.i("blendmode", this.blendmode));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    super.ApplyGLSLFilter();
  }
  
  public void setBlendMode(int paramInt)
  {
    this.blendmode = paramInt;
    addParam(new m.i("blendmode", paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoBlendFilter
 * JD-Core Version:    0.7.0.1
 */