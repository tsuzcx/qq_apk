package com.google.android.gms.internal;

import java.io.IOException;

public abstract class dw
{
  protected volatile int Tq = -1;
  
  public static final <T extends dw> T a(T paramT, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = dn.a(paramArrayOfByte, 0, paramInt);
      paramT.a(paramArrayOfByte);
      paramArrayOfByte.bJ(0);
      return paramT;
    }
    catch (dv paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] c(dw paramdw)
  {
    byte[] arrayOfByte = new byte[paramdw.ks()];
    int i = arrayOfByte.length;
    try
    {
      do localdo = do.b(arrayOfByte, 0, i);
      paramdw.a(localdo);
      localdo.kh();
      return arrayOfByte;
    }
    catch (IOException paramdw)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramdw);
    }
  }
  
  public abstract dw a(dn paramdn);
  
  public void a(do paramdo) {}
  
  protected int jW()
  {
    return 0;
  }
  
  public dw ki()
  {
    return (dw)super.clone();
  }
  
  public final int kr()
  {
    if (this.Tq < 0) {
      ks();
    }
    return this.Tq;
  }
  
  public final int ks()
  {
    int i = jW();
    this.Tq = i;
    return i;
  }
  
  public String toString()
  {
    return dx.d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dw
 * JD-Core Version:    0.7.0.1
 */