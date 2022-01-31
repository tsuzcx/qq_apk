package com.tencent.mm.plugin.wepkg.d;

import java.io.InputStream;

public final class a
  extends c
{
  int count;
  
  public a(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public final int ckc()
  {
    try
    {
      int i = this.count;
      this.count = 0;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int read()
  {
    int j = super.read();
    int k = this.count;
    if (j >= 0) {}
    for (int i = 1;; i = 0)
    {
      this.count = (i + k);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    int j = super.read(paramArrayOfByte);
    int k = this.count;
    if (j >= 0) {}
    for (int i = j;; i = 0)
    {
      this.count = (i + k);
      return j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    int i = this.count;
    if (paramInt2 >= 0) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      this.count = (paramInt1 + i);
      return paramInt2;
    }
  }
  
  public final long skip(long paramLong)
  {
    paramLong = super.skip(paramLong);
    this.count = ((int)(this.count + paramLong));
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.a
 * JD-Core Version:    0.7.0.1
 */