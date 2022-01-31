package com.tencent.mm.sdk.platformtools;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.util.TimeZone;

public final class q
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  public static final long[] Ya = { 300L, 200L, 300L, 200L };
  private static final long[] Yb = { 300L, 50L, 300L, 50L };
  private static final BigInteger Yc = BigInteger.ONE.shiftLeft(64);
  private static final char[] Yd = { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
  private static final String[] Ye = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  
  public static boolean D(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static String F(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.toString();
    }
    return "null";
  }
  
  public static void b(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      f.a("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
    }
  }
  
  public static m lq()
  {
    return new m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q
 * JD-Core Version:    0.7.0.1
 */