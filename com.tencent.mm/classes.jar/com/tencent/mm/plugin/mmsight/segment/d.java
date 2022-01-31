package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;

public abstract interface d
{
  public abstract int getDurationMs();
  
  public abstract Bitmap getFrameAtTime(long paramLong);
  
  public abstract int getScaledHeight();
  
  public abstract int getScaledWidth();
  
  public abstract void init(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void release();
  
  public abstract void reuseBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.d
 * JD-Core Version:    0.7.0.1
 */