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
    AppMethodBeat.i(197314);
    this.TAG = ("CIImageFilter@" + Integer.toHexString(hashCode()));
    if (this.rgbFilter == null) {
      this.rgbFilter = new TextureFilter();
    }
    if (this.oesFilter == null) {
      this.oesFilter = new TextureFilter();
    }
    AppMethodBeat.o(197314);
  }
  
  private TextureInfo tryApplyOESFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(197319);
    paramTextureInfo = this.oesFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(197319);
    return paramTextureInfo;
  }
  
  private TextureInfo tryApplyRGBFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(197320);
    paramTextureInfo = this.rgbFilter.applyFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
    AppMethodBeat.o(197320);
    return paramTextureInfo;
  }
  
  public TextureInfo applyFilter(TextureInfo paramTextureInfo, Matrix paramMatrix1, Matrix paramMatrix2, float paramFloat, CGRect paramCGRect)
  {
    AppMethodBeat.i(197318);
    if (paramTextureInfo != null)
    {
      if (paramTextureInfo.textureType == 36197)
      {
        paramTextureInfo = tryApplyOESFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
        AppMethodBeat.o(197318);
        return paramTextureInfo;
      }
      paramTextureInfo = tryApplyRGBFilter(paramTextureInfo, paramMatrix1, paramMatrix2, paramFloat, paramCGRect);
      AppMethodBeat.o(197318);
      return paramTextureInfo;
    }
    AppMethodBeat.o(197318);
    return null;
  }
  
  public void clearBufferBuffer(int paramInt)
  {
    AppMethodBeat.i(197315);
    this.clearColor = paramInt;
    if (this.oesFilter != null) {
      this.oesFilter.clearBufferBuffer(paramInt);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.clearBufferBuffer(paramInt);
    }
    AppMethodBeat.o(197315);
  }
  
  public void release()
  {
    AppMethodBeat.i(197317);
    if (this.oesFilter != null) {
      this.oesFilter.release();
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.release();
    }
    AppMethodBeat.o(197317);
  }
  
  public void setOutputTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(197316);
    this.destTextureInfo = paramTextureInfo;
    if (this.oesFilter != null) {
      this.oesFilter.setOutputTextureInfo(paramTextureInfo);
    }
    if (this.rgbFilter != null) {
      this.rgbFilter.setOutputTextureInfo(paramTextureInfo);
    }
    AppMethodBeat.o(197316);
  }
  
  public String toString()
  {
    AppMethodBeat.i(197321);
    String str = "CIImageFilter{program=" + this.program + ", clearColor=" + this.clearColor + ", destTextureInfo=" + this.destTextureInfo + '}';
    AppMethodBeat.o(197321);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImageFilter
 * JD-Core Version:    0.7.0.1
 */