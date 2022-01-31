package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BorderFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}";
  
  public BorderFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform float borderWidth;\nuniform float width;\nuniform float height;\nuniform vec4 borderColor;\n\nvoid main()\n{\n    float borderX = borderWidth;\n    float borderY = borderWidth;\n    if (width > height) {\n        borderX = borderWidth * height / width;\n    } else {\n        borderY = borderWidth * width / height;\n    }\n    if (textureCoordinate.x < borderX || textureCoordinate.x > 1.0 - borderX || textureCoordinate.y < borderY || textureCoordinate.y > 1.0 - borderY) {\n        gl_FragColor = borderColor;\n    } else {\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n}");
    AppMethodBeat.i(82058);
    initParams();
    AppMethodBeat.o(82058);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82059);
    addParam(new m.f("borderWidth", 0.025F));
    addParam(new m.e("borderColor", 0.0F, 0.0F, 0.0F, 1.0F));
    AppMethodBeat.o(82059);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82062);
    addParam(new m.f("width", paramFloat1));
    addParam(new m.f("height", paramFloat2));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82062);
  }
  
  public void updateBorderColor(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82061);
    addParam(new m.e("borderColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
    AppMethodBeat.o(82061);
  }
  
  public void updateBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(82060);
    addParam(new m.f("borderWidth", paramFloat));
    AppMethodBeat.o(82060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.BorderFilter
 * JD-Core Version:    0.7.0.1
 */