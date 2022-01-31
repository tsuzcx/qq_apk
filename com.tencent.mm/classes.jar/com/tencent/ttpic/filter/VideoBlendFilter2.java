package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;

public class VideoBlendFilter2
  extends BaseFilter
{
  private static final String FRAGREMENT_SHADER = " precision highp float;\n varying vec2 canvasCoordinate;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec4 c1 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 c2 = texture2D(inputImageTexture, canvasCoordinate);\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     } else {\n        gl_FragColor = c1;\n     }\n}\n";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}";
  private int blendmode;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private float[] position;
  private int watermarkHeight;
  private int watermarkWidth;
  
  public VideoBlendFilter2()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}", " precision highp float;\n varying vec2 canvasCoordinate;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform int blendmode;\n void main()\n {\n     vec4 c1 = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 c2 = texture2D(inputImageTexture, canvasCoordinate);\n     if(blendmode == 0){\n        gl_FragColor = c2;\n     } else {\n        gl_FragColor = c1;\n     }\n}\n");
    AppMethodBeat.i(49937);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mCopyFrame = new h();
    this.position = GlUtil.ORIGIN_POSITION_COORDS;
    initParams();
    AppMethodBeat.o(49937);
  }
  
  private void setBlendMode(int paramInt)
  {
    AppMethodBeat.i(49938);
    this.blendmode = paramInt;
    addParam(new m.i("blendmode", paramInt));
    AppMethodBeat.o(49938);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(49942);
    super.ApplyGLSLFilter();
    setPositions(this.position);
    setTexCords(GlUtil.ORIGIN_TEX_COORDS_REVERSE);
    this.mCopyFilter.ApplyGLSLFilter();
    AppMethodBeat.o(49942);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(49943);
    super.clearGLSLSelf();
    this.mCopyFilter.clearGLSLSelf();
    this.mCopyFrame.tN();
    AppMethodBeat.o(49943);
  }
  
  public int getWatermarkHeight()
  {
    return this.watermarkHeight;
  }
  
  public int getWatermarkWidth()
  {
    return this.watermarkWidth;
  }
  
  public void initParams()
  {
    AppMethodBeat.i(49941);
    addParam(new m.i("blendmode", 0));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    AppMethodBeat.o(49941);
  }
  
  public boolean needRender()
  {
    return this.blendmode != 0;
  }
  
  public h renderWatermark(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(49944);
    GlUtil.setBlendMode(true);
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mCopyFrame);
    OnDrawFrameGLSL();
    renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(false);
    h localh = this.mCopyFrame;
    AppMethodBeat.o(49944);
    return localh;
  }
  
  public void setWatermarkBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49939);
    if (BitmapUtils.isLegal(paramBitmap))
    {
      this.watermarkWidth = paramBitmap.getWidth();
      this.watermarkHeight = paramBitmap.getHeight();
      paramBitmap = new m.k("inputImageTexture2", paramBitmap, 33986, true);
      paramBitmap.initialParams(getmProgramIds());
      addParam(paramBitmap);
      setBlendMode(1);
      AppMethodBeat.o(49939);
      return;
    }
    this.watermarkHeight = 0;
    this.watermarkWidth = 0;
    setBlendMode(0);
    AppMethodBeat.o(49939);
  }
  
  public void setWatermarkPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(49940);
    this.position = AlgoUtils.calPositions(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramInt5, paramInt6);
    setPositions(this.position);
    AppMethodBeat.o(49940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoBlendFilter2
 * JD-Core Version:    0.7.0.1
 */