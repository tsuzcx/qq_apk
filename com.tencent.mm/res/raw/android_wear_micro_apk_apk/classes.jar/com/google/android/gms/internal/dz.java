package com.google.android.gms.internal;

public final class dz
{
  public static final boolean[] TA = new boolean[0];
  public static final String[] TB = new String[0];
  public static final byte[][] TC = new byte[0][];
  public static final byte[] TD = new byte[0];
  static final int Ts = 11;
  static final int Tt = 12;
  static final int Tu = 16;
  static final int Tv = 26;
  public static final int[] Tw = new int[0];
  public static final long[] Tx = new long[0];
  public static final float[] Ty = new float[0];
  public static final double[] Tz = new double[0];
  
  public static int af(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int b(dn paramdn, int paramInt)
  {
    int i = 1;
    int j = paramdn.getPosition();
    paramdn.bK(paramInt);
    while (paramdn.jZ() == paramInt)
    {
      paramdn.bK(paramInt);
      i += 1;
    }
    paramdn.bN(j);
    return i;
  }
  
  static int bY(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int bZ(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.dz
 * JD-Core Version:    0.7.0.1
 */