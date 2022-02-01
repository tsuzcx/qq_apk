package com.tencent.mm.plugin.wepkg.d;

import java.io.FilterInputStream;
import java.io.InputStream;

public abstract class c
  extends FilterInputStream
{
  public c(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int available()
  {
    return this.in.available();
  }
  
  public void close()
  {
    this.in.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
  {
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return this.in.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
  {
    try
    {
      this.in.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    return this.in.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.d.c
 * JD-Core Version:    0.7.0.1
 */