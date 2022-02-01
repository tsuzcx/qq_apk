package com.tencent.xweb;

import android.graphics.Bitmap;
import java.io.File;

public abstract interface p
{
  public abstract File getCacheFileDir();
  
  public abstract int getMaxHeightSupported();
  
  public abstract File getResultFileDir();
  
  public abstract void onLongScreenshotFinished(int paramInt, String paramString);
  
  public abstract Bitmap overrideScreenshot(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.p
 * JD-Core Version:    0.7.0.1
 */