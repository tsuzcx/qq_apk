package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;

public class FaceColorFilter
  extends BaseFilter
{
  private static final String FOLDER = "assets://realtimeBeauty";
  private static final String FRAGMENT_SHADER;
  private float alpha = 0.7F;
  private float blendAlpha = 1.0F;
  private float colorMinBase = 0.0F;
  private float colorRangeInv = 1.0F;
  
  static
  {
    AppMethodBeat.i(82336);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceColorFragmentShader.dat");
    AppMethodBeat.o(82336);
  }
  
  public FaceColorFilter()
  {
    super(FRAGMENT_SHADER);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82331);
    Bitmap localBitmap1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile("assets://realtimeBeauty" + File.separator + "lookup_table.png");
    Bitmap localBitmap2 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile("assets://realtimeBeauty" + File.separator + "lookup_table_gray.png");
    Bitmap localBitmap3 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile("assets://realtimeBeauty" + File.separator + "lookup_table_origin.png");
    addParam(new m.k("inputImageTexture2", localBitmap2, 33986, true));
    addParam(new m.k("inputImageTexture3", localBitmap1, 33987, true));
    addParam(new m.k("inputImageTexture4", localBitmap3, 33988, true));
    addParam(new m.f("colorRangeInv", this.colorRangeInv));
    addParam(new m.f("colorMinBase", this.colorMinBase));
    addParam(new m.f("alpha", this.alpha));
    addParam(new m.f("blendAlpha", this.blendAlpha));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82331);
  }
  
  public void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(82332);
    this.alpha = paramFloat;
    addParam(new m.f("alpha", paramFloat));
    AppMethodBeat.o(82332);
  }
  
  public void setBlendAlpha(float paramFloat)
  {
    AppMethodBeat.i(82335);
    this.blendAlpha = paramFloat;
    addParam(new m.f("blendAlpha", paramFloat));
    AppMethodBeat.o(82335);
  }
  
  public void setColorMinBase(float paramFloat)
  {
    AppMethodBeat.i(82333);
    this.colorMinBase = paramFloat;
    addParam(new m.f("colorMinBase", paramFloat));
    AppMethodBeat.o(82333);
  }
  
  public void setColorRangeInv(float paramFloat)
  {
    AppMethodBeat.i(82334);
    this.colorRangeInv = paramFloat;
    addParam(new m.f("colorRangeInv", paramFloat));
    AppMethodBeat.o(82334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceColorFilter
 * JD-Core Version:    0.7.0.1
 */