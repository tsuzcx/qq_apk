package com.tencent.view;

import android.graphics.Bitmap;

public final class e
{
  private static final float[] xdk = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] xdl = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  public int height;
  public int texture = -20000;
  public int width;
  
  private e(int paramInt1, int paramInt2, int paramInt3)
  {
    this.texture = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
  }
  
  public static e ab(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new e(f.ac(paramBitmap), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.view.e
 * JD-Core Version:    0.7.0.1
 */