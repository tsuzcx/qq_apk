package com.tencent.xweb;

import android.graphics.Bitmap;
import java.io.File;

public abstract interface q
{
  public abstract File getCacheFileDir();
  
  public abstract int getMaxHeightSupported();
  
  public abstract File getResultFileDir();
  
  public abstract void onLongScreenshotFinished(int paramInt, String paramString);
  
  public abstract Bitmap overrideScreenshot(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.q
 * JD-Core Version:    0.7.0.1
 */