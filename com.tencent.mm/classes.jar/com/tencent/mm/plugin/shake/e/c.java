package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  public static String a(Context paramContext, a parama)
  {
    AppMethodBeat.i(28624);
    k.b localb = new k.b();
    localb.title = parama.field_title;
    if (!Util.isNullOrNil(parama.field_topic)) {}
    for (localb.description = parama.field_topic;; localb.description = parama.field_subtitle)
    {
      localb.type = 20;
      localb.url = parama.field_shareurl;
      localb.action = "";
      if (k.fHm())
      {
        localb.appName = paramContext.getString(R.l.eRI);
        localb.appId = "wxaf060266bfa9a35c";
      }
      localb.thumburl = parama.field_thumburl;
      localb.lmz = b(parama);
      paramContext = k.b.a(localb, null, null);
      AppMethodBeat.o(28624);
      return paramContext;
    }
  }
  
  public static a aYd(String paramString)
  {
    AppMethodBeat.i(28622);
    if (paramString == null)
    {
      AppMethodBeat.o(28622);
      return null;
    }
    Map localMap = XmlParser.parseXml(paramString, "tv", null);
    if (localMap == null)
    {
      AppMethodBeat.o(28622);
      return null;
    }
    a locala = new a();
    locala.field_id = Util.nullAsNil((String)localMap.get("" + ".tv.id"));
    locala.field_topic = Util.nullAsNil((String)localMap.get("" + ".tv.topic"));
    locala.field_title = Util.nullAsNil((String)localMap.get("" + ".tv.title"));
    locala.field_subtitle = Util.nullAsNil((String)localMap.get("" + ".tv.subtitle"));
    locala.field_thumburl = Util.nullAsNil((String)localMap.get("" + ".tv.thumburl"));
    locala.field_shareurl = Util.nullAsNil((String)localMap.get("" + ".tv.shareurl"));
    locala.field_playurl = Util.nullAsNil((String)localMap.get("" + ".tv.playurl"));
    locala.field_playstatid = Util.nullAsNil((String)localMap.get("" + ".tv.playurl$statid"));
    locala.field_source = Util.nullAsNil((String)localMap.get("" + ".tv.source"));
    locala.IZR = a.o(localMap, "" + ".tv");
    locala.field_xml = paramString;
    AppMethodBeat.o(28622);
    return locala;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(28623);
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("<tv>");
    if (!Util.isNullOrNil(parama.field_id)) {
      localStringBuilder.append("<id>" + Util.escapeStringForXml(parama.field_id) + "</id>");
    }
    localStringBuilder.append("<title>" + Util.escapeStringForXml(parama.field_title) + "</title>");
    localStringBuilder.append("<subtitle>" + Util.escapeStringForXml(parama.field_subtitle) + "</subtitle>");
    localStringBuilder.append("<topic>" + Util.escapeStringForXml(parama.field_topic) + "</topic>");
    localStringBuilder.append("<thumburl>" + Util.escapeStringForXml(parama.field_thumburl) + "</thumburl>");
    localStringBuilder.append("<shareurl>" + Util.escapeStringForXml(parama.field_shareurl) + "</shareurl>");
    if (!Util.isNullOrNil(parama.field_playstatid)) {
      localStringBuilder.append("<playurl statid=\"" + parama.field_playstatid + "\">" + Util.escapeStringForXml(parama.field_playurl) + "</playurl>");
    }
    for (;;)
    {
      localStringBuilder.append("<source>" + Util.escapeStringForXml(parama.field_source) + "</source>");
      localStringBuilder.append("</tv>");
      parama = localStringBuilder.toString();
      AppMethodBeat.o(28623);
      return parama;
      localStringBuilder.append("<playurl>" + Util.escapeStringForXml(parama.field_playurl) + "</playurl>");
    }
  }
  
  public static final class a
  {
    public LinkedList<a> IZR;
    public String field_id;
    public String field_playstatid;
    public String field_playurl;
    public String field_shareurl;
    public String field_source;
    public String field_subtitle;
    public String field_thumburl;
    public String field_title;
    public String field_topic;
    public String field_xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.c
 * JD-Core Version:    0.7.0.1
 */