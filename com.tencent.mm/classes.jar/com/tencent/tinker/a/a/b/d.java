package com.tencent.tinker.a.a.b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d
{
  public static byte[] c(InputStream paramInputStream, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 32768;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i);
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      paramInt = paramInputStream.read(arrayOfByte);
      if (paramInt <= 0) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, paramInt);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] r(InputStream paramInputStream)
  {
    return c(paramInputStream, 32768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */