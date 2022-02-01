package com.tencent.tinker.d.a;

import java.nio.ByteOrder;

public final class d
  extends c
{
  private final ByteOrder IFA;
  private final byte[] buffer;
  private final int byteCount;
  private final int offset;
  private int position;
  
  private d(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    this.buffer = paramArrayOfByte;
    this.offset = 0;
    this.byteCount = paramInt;
    this.IFA = paramByteOrder;
  }
  
  public static c a(byte[] paramArrayOfByte, int paramInt, ByteOrder paramByteOrder)
  {
    return new d(paramArrayOfByte, paramInt, paramByteOrder);
  }
  
  public final void fpf()
  {
    this.position += 4;
  }
  
  public final int readInt()
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.offset + this.position;
    int k;
    int j;
    int m;
    if (this.IFA == ByteOrder.BIG_ENDIAN)
    {
      k = i + 1;
      i = arrayOfByte[i];
      j = k + 1;
      k = arrayOfByte[k];
      m = arrayOfByte[j];
    }
    for (i = (arrayOfByte[(j + 1)] & 0xFF) << 0 | (i & 0xFF) << 24 | (k & 0xFF) << 16 | (m & 0xFF) << 8;; i = (arrayOfByte[(j + 1)] & 0xFF) << 24 | (i & 0xFF) << 0 | (k & 0xFF) << 8 | (m & 0xFF) << 16)
    {
      this.position += 4;
      return i;
      k = i + 1;
      i = arrayOfByte[i];
      j = k + 1;
      k = arrayOfByte[k];
      m = arrayOfByte[j];
    }
  }
  
  public final short readShort()
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.offset + this.position;
    int j;
    if (this.IFA == ByteOrder.BIG_ENDIAN) {
      j = arrayOfByte[i];
    }
    for (short s = (short)(arrayOfByte[(i + 1)] & 0xFF | j << 8);; s = (short)(arrayOfByte[i] & 0xFF | j << 8))
    {
      this.position += 2;
      return s;
      j = arrayOfByte[(i + 1)];
    }
  }
  
  public final void seek(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.d.a.d
 * JD-Core Version:    0.7.0.1
 */