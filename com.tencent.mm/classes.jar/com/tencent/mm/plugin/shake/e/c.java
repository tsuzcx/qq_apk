package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

public final class c
{
  public static c.a MD(String paramString)
  {
    if (paramString == null) {}
    Map localMap;
    do
    {
      return null;
      localMap = bn.s(paramString, "tv");
    } while (localMap == null);
    c.a locala = new c.a();
    locala.field_id = bk.pm((String)localMap.get("" + ".tv.id"));
    locala.field_topic = bk.pm((String)localMap.get("" + ".tv.topic"));
    locala.field_title = bk.pm((String)localMap.get("" + ".tv.title"));
    locala.field_subtitle = bk.pm((String)localMap.get("" + ".tv.subtitle"));
    locala.field_thumburl = bk.pm((String)localMap.get("" + ".tv.thumburl"));
    locala.field_shareurl = bk.pm((String)localMap.get("" + ".tv.shareurl"));
    locala.field_playurl = bk.pm((String)localMap.get("" + ".tv.playurl"));
    locala.field_playstatid = bk.pm((String)localMap.get("" + ".tv.playurl$statid"));
    locala.field_source = bk.pm((String)localMap.get("" + ".tv.source"));
    locala.nPR = a.l(localMap, "" + ".tv");
    locala.field_xml = paramString;
    return locala;
  }
  
  public static String a(Context paramContext, c.a parama)
  {
    g.a locala = new g.a();
    locala.title = parama.field_title;
    if (!bk.bl(parama.field_topic)) {}
    for (locala.description = parama.field_topic;; locala.description = parama.field_subtitle)
    {
      locala.type = 20;
      locala.url = parama.field_shareurl;
      locala.action = "";
      if (k.bzS())
      {
        locala.appName = paramContext.getString(R.l.scan_type_tv);
        locala.appId = "wxaf060266bfa9a35c";
      }
      locala.thumburl = parama.field_thumburl;
      locala.dRc = b(parama);
      return g.a.a(locala, null, null);
    }
  }
  
  public static String b(c.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("<tv>");
    if (!bk.bl(parama.field_id)) {
      localStringBuilder.append("<id>" + bk.ZP(parama.field_id) + "</id>");
    }
    localStringBuilder.append("<title>" + bk.ZP(parama.field_title) + "</title>");
    localStringBuilder.append("<subtitle>" + bk.ZP(parama.field_subtitle) + "</subtitle>");
    localStringBuilder.append("<topic>" + bk.ZP(parama.field_topic) + "</topic>");
    localStringBuilder.append("<thumburl>" + bk.ZP(parama.field_thumburl) + "</thumburl>");
    localStringBuilder.append("<shareurl>" + bk.ZP(parama.field_shareurl) + "</shareurl>");
    if (!bk.bl(parama.field_playstatid)) {
      localStringBuilder.append("<playurl statid=\"" + parama.field_playstatid + "\">" + bk.ZP(parama.field_playurl) + "</playurl>");
    }
    for (;;)
    {
      localStringBuilder.append("<source>" + bk.ZP(parama.field_source) + "</source>");
      localStringBuilder.append("</tv>");
      return localStringBuilder.toString();
      localStringBuilder.append("<playurl>" + bk.ZP(parama.field_playurl) + "</playurl>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.c
 * JD-Core Version:    0.7.0.1
 */