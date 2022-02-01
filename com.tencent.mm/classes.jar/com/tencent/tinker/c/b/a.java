package com.tencent.tinker.c.b;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.CRC32;

public final class a
{
  private static long Q(InputStream paramInputStream)
  {
    CRC32 localCRC32 = new CRC32();
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i);
    }
    return localCRC32.getValue();
  }
  
  public static long W(File paramFile)
  {
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
      long l;
      b.closeQuietly(localBufferedInputStream);
    }
    finally
    {
      try
      {
        l = Q(localBufferedInputStream);
        b.closeQuietly(localBufferedInputStream);
        return l;
      }
      finally {}
      paramFile = finally;
      localBufferedInputStream = null;
    }
    throw paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.c.b.a
 * JD-Core Version:    0.7.0.1
 */