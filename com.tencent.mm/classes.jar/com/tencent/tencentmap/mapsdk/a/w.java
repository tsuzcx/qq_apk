package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class w
  extends s
{
  private static volatile w b;
  
  private w(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.a = paramContext.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
    b();
  }
  
  public static w a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new w(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  private void b()
  {
    if (b == null) {}
    String str;
    do
    {
      return;
      a(new String[] { "taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon" });
      str = a("sdkVersion");
    } while ((str == null) || (lq.b("4.1.0", str) <= 0));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.w
 * JD-Core Version:    0.7.0.1
 */