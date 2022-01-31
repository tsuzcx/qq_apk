package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public abstract class dv
{
  private static dv a = null;
  
  public static dv a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new dv.a(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, ds paramds);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.dv
 * JD-Core Version:    0.7.0.1
 */