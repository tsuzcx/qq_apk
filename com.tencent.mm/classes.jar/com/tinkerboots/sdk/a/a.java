package com.tinkerboots.sdk.a;

import com.tinkerboots.sdk.a.a.b;

public final class a
{
  private static volatile a xnK;
  public long fPi = 10800000L;
  public boolean isDebug;
  public b xnJ;
  public final com.tinkerboots.sdk.a.b.a xnL = com.tinkerboots.sdk.a.b.a.cTZ();
  
  private a(b paramb)
  {
    this.xnJ = paramb;
  }
  
  public static a a(b paramb)
  {
    if (xnK != null) {
      throw new RuntimeException("tinker server client is already init");
    }
    if (xnK == null) {}
    try
    {
      if (xnK == null) {
        xnK = new a(paramb);
      }
      return xnK;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */