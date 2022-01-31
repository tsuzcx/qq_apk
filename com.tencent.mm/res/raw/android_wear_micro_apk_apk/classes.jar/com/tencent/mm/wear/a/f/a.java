package com.tencent.mm.wear.a.f;

public final class a
{
  public static final double a(double paramDouble1, double paramDouble2)
  {
    if (Math.abs(paramDouble1 - paramDouble2) <= 2.0D) {
      return paramDouble1;
    }
    if (paramDouble2 > paramDouble1) {
      return paramDouble2 - 2.0D;
    }
    return paramDouble2 + 2.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.f.a
 * JD-Core Version:    0.7.0.1
 */