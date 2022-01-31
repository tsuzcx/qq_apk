package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.u;

public class lk
{
  private static boolean a = false;
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(149168);
    if (u.a(paramContext).b("mapConfigStyle") != paramInt)
    {
      a = true;
      AppMethodBeat.o(149168);
      return;
    }
    a = false;
    AppMethodBeat.o(149168);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(149169);
    if (paramContext == null)
    {
      AppMethodBeat.o(149169);
      return;
    }
    paramString = p.a(paramContext).b(paramString);
    u localu = u.a(paramContext);
    a(localu);
    int i = ka.b("4.2.3.3", localu.a("sdkVersion"));
    r.a(paramContext, paramString, "mapconfig.dat", "mapconfig.dat");
    r.a(paramContext, paramString, "poi_icon@2x.png", "poi_icon@2x.png");
    r.a(paramContext, paramString, "poi_icon_nav@2x.png", "poi_icon_nav@2x.png");
    r.a(paramContext, paramString, "poi_icon_dark@2x.png", "poi_icon_dark@2x.png");
    r.a(paramContext, paramString, "rtt_config.json", "rtt_config.json");
    r.a(paramContext, paramString, "indoormap_config.dat", "indoormap_config.dat");
    r.a(paramContext, paramString, "poi_icon_indoor@2x.png", "poi_icon_indoor@2x.png");
    r.a(paramContext, paramString, "style_normalmode.xml", "style_normalmode.xml");
    r.a(paramContext, paramString, "style_trafficmode.xml", "style_trafficmode.xml");
    r.a(paramContext, paramString, "blockicon.png", "blockicon.png");
    if (i > 0) {
      localu.a("sdkVersion", "4.2.3.3");
    }
    AppMethodBeat.o(149169);
  }
  
  private static void a(u paramu)
  {
    AppMethodBeat.i(149170);
    if (ka.b(paramu.a("sdkVersion"), "4.0.9.1") < 0) {
      paramu.a(new String[] { "mapConfigIndoorVersion", "mapPoiIconIndoorVersion" });
    }
    AppMethodBeat.o(149170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lk
 * JD-Core Version:    0.7.0.1
 */