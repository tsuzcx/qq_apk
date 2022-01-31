package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

public class mf
{
  private static boolean a = false;
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    w localw;
    int i;
    do
    {
      return;
      paramString = r.a(paramContext).g(paramString);
      localw = w.a(paramContext);
      a(localw);
      i = lq.b("4.1.1.2", localw.a("sdkVersion"));
      t.a(paramContext, paramString, "mapconfig.dat", "mapconfig.dat");
      t.a(paramContext, paramString, "poi_icon@2x.png", "poi_icon@2x.png");
      t.a(paramContext, paramString, "poi_icon_nav@2x.png", "poi_icon_nav@2x.png");
      t.a(paramContext, paramString, "poi_icon_dark@2x.png", "poi_icon_dark@2x.png");
      t.a(paramContext, paramString, "rtt_config.json", "rtt_config.json");
      t.a(paramContext, paramString, "indoormap_config.dat", "indoormap_config.dat");
      t.a(paramContext, paramString, "poi_icon_indoor@2x.png", "poi_icon_indoor@2x.png");
      t.a(paramContext, paramString, "style_normalmode.xml", "style_normalmode.xml");
      t.a(paramContext, paramString, "style_trafficmode.xml", "style_trafficmode.xml");
      t.a(paramContext, paramString, "blockicon.png", "blockicon.png");
    } while (i <= 0);
    localw.a("sdkVersion", "4.1.1.2");
  }
  
  private static void a(w paramw)
  {
    if (lq.b(paramw.a("sdkVersion"), "4.0.9.1") < 0) {
      paramw.a(new String[] { "mapConfigIndoorVersion", "mapPoiIconIndoorVersion" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mf
 * JD-Core Version:    0.7.0.1
 */