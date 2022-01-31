package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public final class uh
{
  private String a = "md5";
  private byte[] b;
  private int c = -1;
  
  public uh(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt;
  }
  
  public uh(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    this.b = paramArrayOfByte;
    this.c = paramInt;
    this.a = paramString;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final Bitmap b()
  {
    if (this.b == null) {
      return null;
    }
    return BitmapFactory.decodeByteArray(this.b, 0, this.b.length);
  }
  
  public final byte[] c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uh
 * JD-Core Version:    0.7.0.1
 */