package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class c
  implements Closeable
{
  private final RandomAccessFile a;
  private final File b;
  private final byte[] c = new byte[8];
  private boolean d;
  
  public c(File paramFile)
  {
    this.b = paramFile;
    this.a = new RandomAccessFile(this.b, "r");
  }
  
  public c(String paramString)
  {
    this(new File(paramString));
  }
  
  public final int a()
  {
    int j = this.a.readInt();
    int i = j;
    if (this.d) {
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8;
    }
    return i;
  }
  
  public final int a(char[] paramArrayOfChar)
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.a.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public void a(long paramLong)
  {
    this.a.seek(paramLong);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void close()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.c
 * JD-Core Version:    0.7.0.1
 */