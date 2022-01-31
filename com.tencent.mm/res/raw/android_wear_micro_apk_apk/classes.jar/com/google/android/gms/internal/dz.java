package com.google.android.gms.internal;

public final class dz
{
  static final int RD = 11;
  static final int RE = 12;
  static final int RF = 16;
  static final int RG = 26;
  public static final int[] RH = new int[0];
  public static final long[] RI = new long[0];
  public static final float[] RJ = new float[0];
  public static final double[] RK = new double[0];
  public static final boolean[] RL = new boolean[0];
  public static final String[] RM = new String[0];
  public static final byte[][] RN = new byte[0][];
  public static final byte[] RO = new byte[0];
  
  public static int ad(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int b(dn paramdn, int paramInt)
  {
    int i = 1;
    int j = paramdn.getPosition();
    paramdn.bq(paramInt);
    while (paramdn.jQ() == paramInt)
    {
      paramdn.bq(paramInt);
      i += 1;
    }
    paramdn.bt(j);
    return i;
  }
  
  static int bD(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int bE(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dz
 * JD-Core Version:    0.7.0.1
 */