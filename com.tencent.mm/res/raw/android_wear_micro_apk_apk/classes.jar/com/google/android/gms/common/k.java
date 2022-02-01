package com.google.android.gms.common;

import java.util.Arrays;

final class k
  extends j
{
  private final byte[] Ne;
  
  k(byte[] paramArrayOfByte)
  {
    super(Arrays.copyOfRange(paramArrayOfByte, 0, 25));
    this.Ne = paramArrayOfByte;
  }
  
  final byte[] getBytes()
  {
    return this.Ne;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.k
 * JD-Core Version:    0.7.0.1
 */