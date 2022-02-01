package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;

public abstract interface IX5CoreWebIconDB
{
  public abstract void close();
  
  public abstract Bitmap getIconForPageUrl(String paramString);
  
  public abstract void open(String paramString);
  
  public abstract void releaseIconForPageUrl(String paramString);
  
  public abstract void removeAllIcons();
  
  public abstract void requestIconForPageUrl(String paramString, IconListener paramIconListener);
  
  public abstract void retainIconForPageUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB
 * JD-Core Version:    0.7.0.1
 */