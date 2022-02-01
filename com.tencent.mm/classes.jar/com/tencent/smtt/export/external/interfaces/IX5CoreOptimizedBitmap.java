package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public abstract interface IX5CoreOptimizedBitmap
{
  public abstract Bitmap createX5OptimizedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean);
  
  public abstract boolean pinBitmap(Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void unpinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5CoreOptimizedBitmap
 * JD-Core Version:    0.7.0.1
 */