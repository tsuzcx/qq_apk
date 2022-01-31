package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;

public final class rs
  implements Cloneable
{
  int a = 0;
  int b = 0;
  Bitmap c;
  
  public rs(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a = paramBitmap.getWidth();
      this.b = paramBitmap.getHeight();
      this.c = paramBitmap;
    }
  }
  
  private rs(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBitmap;
  }
  
  public final rs a()
  {
    return new rs(Bitmap.createBitmap(this.c), this.a, this.b);
  }
  
  public final Bitmap b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.a;
  }
  
  public final int d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rs
 * JD-Core Version:    0.7.0.1
 */