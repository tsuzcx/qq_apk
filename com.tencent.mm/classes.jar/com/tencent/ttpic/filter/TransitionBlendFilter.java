package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.i;
import com.tencent.filter.m.l;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class TransitionBlendFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform int maskType;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n     \n     if (maskType == 0) { \n         gl_FragColor = mix(last, current, mask.a); \n     } else if (maskType == 2) { \n         gl_FragColor = mask; \n     } else { \n         gl_FragColor = mix(last, current, mask.r); \n     } \n }";
  private String dataPath;
  private int easeCurve;
  private StickerItem item;
  private m.l mMaskParam;
  private long transitionDuration;
  private long transitionStartTime;
  
  public TransitionBlendFilter()
  {
    super(" precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform int maskType;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n     \n     if (maskType == 0) { \n         gl_FragColor = mix(last, current, mask.a); \n     } else if (maskType == 2) { \n         gl_FragColor = mask; \n     } else { \n         gl_FragColor = mix(last, current, mask.r); \n     } \n }");
    AppMethodBeat.i(83045);
    this.transitionStartTime = -1L;
    this.mMaskParam = new m.l("inputImageTexture3");
    initParams();
    AppMethodBeat.o(83045);
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(83054);
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      paramDouble1 = paramDouble3 * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    for (;;)
    {
      AppMethodBeat.o(83054);
      return paramDouble1;
      paramDouble1 = -(paramDouble2 - paramDouble1);
      paramDouble1 = Math.cos(paramDouble3 * 1.570796326794897D) * paramDouble1 + paramDouble2;
      continue;
      paramDouble1 = Math.sin(paramDouble3 * 1.570796326794897D) * (paramDouble2 - paramDouble1) + paramDouble1;
      continue;
      paramDouble2 = -(paramDouble2 - paramDouble1) / 2.0D;
      paramDouble1 = (Math.cos(paramDouble3 * 3.141592653589793D) - 1.0D) * paramDouble2 + paramDouble1;
    }
  }
  
  private Bitmap getNextFrame(int paramInt)
  {
    AppMethodBeat.i(83051);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    AppMethodBeat.o(83051);
    return localObject;
  }
  
  private void initParams()
  {
    AppMethodBeat.i(83046);
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(this.mMaskParam);
    addParam(new m.i("maskType", 0));
    AppMethodBeat.o(83046);
  }
  
  private void updateTextureParam(long paramLong)
  {
    AppMethodBeat.i(83050);
    if ((this.item.frames <= 0) || (this.item.frameDuration <= 0.0D))
    {
      clearTextureParam();
      AppMethodBeat.o(83050);
      return;
    }
    Bitmap localBitmap = getNextFrame((int)((getDuration(this.transitionStartTime, this.transitionStartTime + this.transitionDuration, paramLong) - this.transitionStartTime) / Math.max(this.item.frameDuration, 1.0D)) % this.item.frames);
    if (!BitmapUtils.isLegal(localBitmap))
    {
      clearTextureParam();
      AppMethodBeat.o(83050);
      return;
    }
    m.l locall = this.mMaskParam;
    locall.bwy = localBitmap;
    if ((locall.bwy != null) && (!locall.bwy.isRecycled())) {}
    for (boolean bool = true;; bool = false)
    {
      locall.update = bool;
      AppMethodBeat.o(83050);
      return;
    }
  }
  
  protected void clearTextureParam()
  {
    AppMethodBeat.i(83052);
    setPositions(GlUtil.EMPTY_POSITIONS);
    this.transitionStartTime = -1L;
    AppMethodBeat.o(83052);
  }
  
  public void reset()
  {
    AppMethodBeat.i(83053);
    this.transitionStartTime = -1L;
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
    AppMethodBeat.o(83053);
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDuration(long paramLong)
  {
    this.transitionDuration = paramLong;
  }
  
  public void setEaseCurve(int paramInt)
  {
    this.easeCurve = paramInt;
  }
  
  public void setItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void setLastTex(int paramInt)
  {
    AppMethodBeat.i(83047);
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    AppMethodBeat.o(83047);
  }
  
  public void setMaskType(int paramInt)
  {
    AppMethodBeat.i(83048);
    addParam(new m.i("maskType", paramInt));
    AppMethodBeat.o(83048);
  }
  
  public void updatePreview(long paramLong)
  {
    AppMethodBeat.i(83049);
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
    AppMethodBeat.o(83049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionBlendFilter
 * JD-Core Version:    0.7.0.1
 */