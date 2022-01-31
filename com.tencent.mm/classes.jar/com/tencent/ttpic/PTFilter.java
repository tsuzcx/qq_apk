package com.tencent.ttpic;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.a.a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.o;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.factory.TTPicFilterFactoryLocal;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.nio.ByteBuffer;

public class PTFilter
{
  private static final boolean HAS_FILTER = true;
  protected BaseFilter mFilter;
  protected h mFilterFrame;
  
  @Deprecated
  public static PTFilter createByFile(String paramString)
  {
    return null;
  }
  
  public static PTFilter createById(int paramInt1, int paramInt2)
  {
    if (!SupportedFilters.isSupportedFilterId(paramInt1)) {
      return null;
    }
    PTFilter localPTFilter = new PTFilter();
    localPTFilter.mFilter = a.dY(paramInt1);
    localPTFilter.mFilter.needFlipBlend = true;
    localPTFilter.mFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilter.setEffectIndex(paramInt2);
    localPTFilter.mFilterFrame = new h();
    return localPTFilter;
  }
  
  public static PTFilter createByLut(String paramString)
  {
    PTFilter localPTFilter = new PTFilter();
    Bitmap localBitmap2 = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), paramString, 1);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile(paramString);
    }
    localPTFilter.mFilter = TTPicFilterFactoryLocal.lutFilterWithBitmap(localBitmap1);
    if (localPTFilter.mFilter == null) {
      return null;
    }
    localPTFilter.mFilter.needFlipBlend = true;
    localPTFilter.mFilter.setSrcFilterIndex(-1);
    localPTFilter.mFilterFrame = new h();
    return localPTFilter;
  }
  
  public static PTFilter createCopyFilter()
  {
    return new PTFilter.PTCopyFilter();
  }
  
  public static PTFilter createYUV2RGBAFilter()
  {
    PTFilter localPTFilter = new PTFilter();
    localPTFilter.mFilter = new o();
    localPTFilter.mFilterFrame = new h();
    return localPTFilter;
  }
  
  public void destroy()
  {
    if (this.mFilter != null) {
      this.mFilter.ClearGLSL();
    }
    if (this.mFilterFrame != null) {
      this.mFilterFrame.clear();
    }
  }
  
  public int init()
  {
    if (this.mFilter == null) {
      return -1100;
    }
    this.mFilter.ApplyGLSLFilter(true, 1.0F, 1.0F);
    GlUtil.debugCheckGlError(this.mFilter);
    return 0;
  }
  
  public int processBuffer(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int i = GlUtil.createImageTexture(ByteBuffer.wrap(paramArrayOfByte1), paramInt1, paramInt2, 6408);
    processTexture(i, paramInt1, paramInt2, paramArrayOfByte2);
    GLES20.glDeleteTextures(1, new int[] { i }, 0);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, 0.0D, this.mFilterFrame);
    GlUtil.debugCheckGlError(this.mFilter);
    return 0;
  }
  
  public int processTexture(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.mFilterFrame);
    h localh = FrameUtil.getLastRenderFrame(this.mFilterFrame);
    System.arraycopy(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, localh.texture[0], paramInt2, paramInt3), 0, paramArrayOfByte, 0, paramInt2 * paramInt3 << 2);
    return 0;
  }
  
  public int processTextureToFrame(int paramInt1, int paramInt2, int paramInt3, h paramh)
  {
    this.mFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, paramh);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter
 * JD-Core Version:    0.7.0.1
 */