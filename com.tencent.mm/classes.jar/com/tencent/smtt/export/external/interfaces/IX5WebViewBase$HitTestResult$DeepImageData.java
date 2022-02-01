package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IX5WebViewBase$HitTestResult$DeepImageData
{
  public Bitmap mBmp;
  public long mHeight;
  public String mPicUrl;
  public long mRawDataSize;
  public long mWidth;
  
  public IX5WebViewBase$HitTestResult$DeepImageData(IX5WebViewBase.HitTestResult paramHitTestResult) {}
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(53219);
    Bitmap localBitmap = this.this$0.getBitmapData();
    AppMethodBeat.o(53219);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.DeepImageData
 * JD-Core Version:    0.7.0.1
 */