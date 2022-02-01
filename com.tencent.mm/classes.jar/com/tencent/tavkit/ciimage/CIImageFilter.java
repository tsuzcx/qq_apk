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
    AppMethodBeat.i(219613);
    this.TAG = ("CIImageFilter@" + Integer.toHexString(hashCode()));
    if (this.rgbFilter == null) {
      this.rgbFilter = new TextureFilter();
    }
    if (this.oesFilter == null) {
      this.oesFilter = new TextureFilter();
    }
    AppMethodBeat.o(219613);
  }
  
  private TextureInfo tryApplyOESFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(219618);
    paramTextureInfo = this.oesFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(219618);
    return paramTextureInfo;
  }
  
  private TextureInfo tryApplyRGBFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(219619);
    paramTextureInfo = this.rgbFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(219619);
    return paramTextureInfo;
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(219617);
    if (paramTextureInfo != null)
    {
      if (paramTextureInfo.textureType == 36197)
      {
        paramTextureInfo = tryApplyOESFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
        AppMethodBeat.o(219617);
        return paramTextureInfo;
      }
      paramTextureInfo = tryApplyRGBFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
      AppMethodBeat.o(219617);
      return paramTextureInfo;
    }
    AppMethodBeat.o(219617);
    return null;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    AppMethodBeat.i(219614);
    this.clearColor = paramInt;
    if (this.oesFilter != null) {
      this.oesFilter.clearBufferBuffer(paramInt);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.clearBufferBuffer(paramInt);
    }
    AppMethodBeat.o(219614);
  }
  
  public void release()
  {
    AppMethodBeat.i(219616);
    if (this.oesFilter != null) {
      this.oesFilter.release();
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.release();
    }
    AppMethodBeat.o(219616);
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(219615);
    this.destTextureInfo = paramTextureInfo;
    if (this.oesFilter != null) {
      this.oesFilter.setOutputTextureInfo(paramTextureInfo);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.setOutputTextureInfo(paramTextureInfo);
    }
    AppMethodBeat.o(219615);
  }
  
  public String toString()
  {
    AppMethodBeat.i(219620);
    String str = "CIImageFilter{program=" + this.program + ", clearColor=" + this.clearColor + ", destTextureInfo=" + this.destTextureInfo + '}';
    AppMethodBeat.o(219620);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImageFilter
 * JD-Core Version:    0.7.0.1
 */