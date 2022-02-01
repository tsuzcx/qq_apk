package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class l
  extends j
{
  private static final WeakReference<byte[]> Ng = new WeakReference(null);
  private WeakReference<byte[]> Nf = Ng;
  
  l(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  final byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])this.Nf.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = jdMethod_if();
        this.Nf = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] jdMethod_if();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.l
 * JD-Core Version:    0.7.0.1
 */