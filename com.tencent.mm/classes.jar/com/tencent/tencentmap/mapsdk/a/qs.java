package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class qs
{
  private static qs c;
  private qr a = new qv();
  private boolean b = false;
  
  public static qs a()
  {
    try
    {
      if (c == null) {
        c = new qs();
      }
      qs localqs = c;
      return localqs;
    }
    finally {}
  }
  
  public qt a(String paramString)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramString);
  }
  
  public qt a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramString1, paramString2);
  }
  
  public qt a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.a == null) {
      return null;
    }
    return this.a.a(paramString1, paramString2, paramArrayOfByte);
  }
  
  public void a(Context paramContext)
  {
    if (this.b) {}
    while (this.a == null) {
      return;
    }
    this.a.a(paramContext.getApplicationContext());
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.qs
 * JD-Core Version:    0.7.0.1
 */