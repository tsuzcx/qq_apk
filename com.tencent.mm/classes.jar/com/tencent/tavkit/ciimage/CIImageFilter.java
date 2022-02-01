package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

class CIImageFilter
  extends TextureFilter
{
  private final String TAG;
  private int clearColor;
  private TextureInfo destTextureInfo;
  private TextureFilter oesFilter;
  private TextureFilter rgbFilter;
  
  CIImageFilter()
  {
    AppMethodBeat.i(191823);
    this.TAG = ("CIImageFilter@" + Integer.toHexString(hashCode()));
    if (this.rgbFilter == null) {
      this.rgbFilter = new TextureFilter();
    }
    if (this.oesFilter == null) {
      this.oesFilter = new TextureFilter();
    }
    AppMethodBeat.o(191823);
  }
  
  private TextureInfo tryApplyOESFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(191828);
    paramTextureInfo = this.oesFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(191828);
    return paramTextureInfo;
  }
  
  private TextureInfo tryApplyRGBFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(191829);
    paramTextureInfo = this.rgbFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(191829);
    return paramTextureInfo;
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(191827);
    if (paramTextureInfo != null)
    {
      if (paramTextureInfo.textureType == 36197)
      {
        paramTextureInfo = tryApplyOESFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
        AppMethodBeat.o(191827);
        return paramTextureInfo;
      }
      paramTextureInfo = tryApplyRGBFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
      AppMethodBeat.o(191827);
      return paramTextureInfo;
    }
    AppMethodBeat.o(191827);
    return null;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    AppMethodBeat.i(191824);
    this.clearColor = paramInt;
    if (this.oesFilter != null) {
      this.oesFilter.clearBufferBuffer(paramInt);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.clearBufferBuffer(paramInt);
    }
    AppMethodBeat.o(191824);
  }
  
  public void release()
  {
    AppMethodBeat.i(191826);
    if (this.oesFilter != null) {
      this.oesFilter.release();
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.release();
    }
    AppMethodBeat.o(191826);
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(191825);
    this.destTextureInfo = paramTextureInfo;
    if (this.oesFilter != null) {
      this.oesFilter.setOutputTextureInfo(paramTextureInfo);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.setOutputTextureInfo(paramTextureInfo);
    }
    AppMethodBeat.o(191825);
  }
  
  public String toString()
  {
    AppMethodBeat.i(191830);
    String str = "CIImageFilter{program=" + this.program + ", clearColor=" + this.clearColor + ", destTextureInfo=" + this.destTextureInfo + '}';
    AppMethodBeat.o(191830);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImageFilter
 * JD-Core Version:    0.7.0.1
 */