package com.tencent.tinker.a.a.b;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d
{
  public static byte[] B(InputStream paramInputStream)
  {
    return f(paramInputStream, 32768);
  }
  
  public static byte[] f(InputStream paramInputStream, int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */