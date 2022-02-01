package com.tencent.tinker.c.b;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public final class b
{
  public static void closeQuietly(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((paramObject instanceof Closeable))
        {
          ((Closeable)paramObject).close();
          return;
        }
        if ((paramObject instanceof AutoCloseable))
        {
          ((AutoCloseable)paramObject).close();
          return;
        }
        if ((paramObject instanceof ZipFile))
        {
          ((ZipFile)paramObject).close();
          return;
        }
      }
      catch (Throwable paramObject) {}
    }
  }
  
  public static void d(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    paramOutputStream.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.c.b.b
 * JD-Core Version:    0.7.0.1
 */