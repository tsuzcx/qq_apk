package com.tencent.tinker.d.a;

import java.io.EOFException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReference;

public final class f
{
  private static AtomicReference<byte[]> ahSv = new AtomicReference();
  
  public static int af(InputStream paramInputStream)
  {
    int i = -1;
    byte[] arrayOfByte = new byte[1];
    if (paramInputStream.read(arrayOfByte, 0, 1) != -1) {
      i = arrayOfByte[0] & 0xFF;
    }
    return i;
  }
  
  public static void b(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      if (paramInputStream == null) {
        throw new NullPointerException("in == null");
      }
      if (paramArrayOfByte == null) {
        throw new NullPointerException("dst == null");
      }
      b.checkOffsetAndCount(paramArrayOfByte.length, 0, paramInt2);
      while (paramInt2 > 0)
      {
        int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (i < 0) {
          throw new EOFException();
        }
        paramInt1 += i;
        paramInt2 -= i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.d.a.f
 * JD-Core Version:    0.7.0.1
 */