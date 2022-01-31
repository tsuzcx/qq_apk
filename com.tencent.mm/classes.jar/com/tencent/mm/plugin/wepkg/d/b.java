package com.tencent.mm.plugin.wepkg.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b
  extends InputStream
{
  private a rQg;
  private long size;
  
  public b(File paramFile, long paramLong1, long paramLong2)
  {
    this.size = paramLong2;
    this.rQg = new a(new FileInputStream(paramFile));
    gX(paramLong1);
    this.rQg.ckc();
  }
  
  private long ckd()
  {
    return this.size - this.rQg.count;
  }
  
  private long gW(long paramLong)
  {
    return Math.min(ckd(), paramLong);
  }
  
  private void gX(long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 += l2)
    {
      l2 = this.rQg.skip(paramLong - l1);
      if (l2 <= 0L) {
        break;
      }
    }
    if (l1 < paramLong) {
      throw new IOException("could not seek pos " + paramLong);
    }
  }
  
  public final int available()
  {
    return (int)gW(this.rQg.available());
  }
  
  public final int read()
  {
    if (ckd() <= 0L) {}
    for (int i = 1; i != 0; i = 0) {
      return -1;
    }
    return this.rQg.read();
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = gW(paramInt2);
    if ((l == 0L) && (paramInt2 > 0)) {
      return -1;
    }
    return this.rQg.read(paramArrayOfByte, paramInt1, (int)l);
  }
  
  public final long skip(long paramLong)
  {
    return this.rQg.skip(gW(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.b
 * JD-Core Version:    0.7.0.1
 */