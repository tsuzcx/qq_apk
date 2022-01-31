package com.tencent.mm.sdk.b;

import android.os.HandlerThread;
import junit.framework.Assert;

public final class c
{
  static int[] Yl = { 19, 16, 13, 10, 0, -2, -4, -5, -6, -8 };
  private static long Ym = 0L;
  private static long Yn = 0L;
  private static a Yo;
  private static d Yp;
  
  public static HandlerThread E(String paramString)
  {
    if (Yo == null) {
      Yo = new a(Yp);
    }
    Assert.assertNotNull("newThread arg name is null!", paramString);
    return new b("mmt_h" + paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */