package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IX5WebViewBase$HitTestResult$ImageData
{
  public Bitmap mBmp;
  public int mImgHeight;
  public int mImgWidth;
  public String mPicUrl;
  public long mRawDataSize;
  
  public IX5WebViewBase$HitTestResult$ImageData(IX5WebViewBase.HitTestResult paramHitTestResult) {}
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(53221);
    Bitmap localBitmap = this.this$0.getBitmapData();
    AppMethodBeat.o(53221);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageData
 * JD-Core Version:    0.7.0.1
 */