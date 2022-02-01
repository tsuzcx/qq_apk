package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.LinkedList;
import java.util.Map;

public final class c
{
  public static String a(Context paramContext, a parama)
  {
    AppMethodBeat.i(28624);
    k.b localb = new k.b();
    localb.title = parama.field_title;
    if (!bt.isNullOrNil(parama.field_topic)) {}
    for (localb.description = parama.field_topic;; localb.description = parama.field_subtitle)
    {
      localb.type = 20;
      localb.url = parama.field_shareurl;
      localb.action = "";
      if (k.dOM())
      {
        localb.appName = paramContext.getString(2131762887);
        localb.appId = "wxaf060266bfa9a35c";
      }
      localb.thumburl = parama.field_thumburl;
      localb.hAr = b(parama);
      paramContext = k.b.a(localb, null, null);
      AppMethodBeat.o(28624);
      return paramContext;
    }
  }
  
  public static a axu(String paramString)
  {
    AppMethodBeat.i(28622);
    if (paramString == null)
    {
      AppMethodBeat.o(28622);
      return null;
    }
    Map localMap = bw.M(paramString, "tv");
    if (localMap == null)
    {
      AppMethodBeat.o(28622);
      return null;
    }
    a locala = new a();
    locala.field_id = bt.nullAsNil((String)localMap.get("" + ".tv.id"));
    locala.field_topic = bt.nullAsNil((String)localMap.get("" + ".tv.topic"));
    locala.field_title = bt.nullAsNil((String)localMap.get("" + ".tv.title"));
    locala.field_subtitle = bt.nullAsNil((String)localMap.get("" + ".tv.subtitle"));
    locala.field_thumburl = bt.nullAsNil((String)localMap.get("" + ".tv.thumburl"));
    locala.field_shareurl = bt.nullAsNil((String)localMap.get("" + ".tv.shareurl"));
    locala.field_playurl = bt.nullAsNil((String)localMap.get("" + ".tv.playurl"));
    locala.field_playstatid = bt.nullAsNil((String)localMap.get("" + ".tv.playurl$statid"));
    locala.field_source = bt.nullAsNil((String)localMap.get("" + ".tv.source"));
    locala.yAm = a.n(localMap, "" + ".tv");
    locala.field_xml = paramString;
    AppMethodBeat.o(28622);
    return locala;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(28623);
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("<tv>");
    if (!bt.isNullOrNil(parama.field_id)) {
      localStringBuilder.append("<id>" + bt.aRc(parama.field_id) + "</id>");
    }
    localStringBuilder.append("<title>" + bt.aRc(parama.field_title) + "</title>");
    localStringBuilder.append("<subtitle>" + bt.aRc(parama.field_subtitle) + "</subtitle>");
    localStringBuilder.append("<topic>" + bt.aRc(parama.field_topic) + "</topic>");
    localStringBuilder.append("<thumburl>" + bt.aRc(parama.field_thumburl) + "</thumburl>");
    localStringBuilder.append("<shareurl>" + bt.aRc(parama.field_shareurl) + "</shareurl>");
    if (!bt.isNullOrNil(parama.field_playstatid)) {
      localStringBuilder.append("<playurl statid=\"" + parama.field_playstatid + "\">" + bt.aRc(parama.field_playurl) + "</playurl>");
    }
    for (;;)
    {
      localStringBuilder.append("<source>" + bt.aRc(parama.field_source) + "</source>");
      localStringBuilder.append("</tv>");
      parama = localStringBuilder.toString();
      AppMethodBeat.o(28623);
      return parama;
      localStringBuilder.append("<playurl>" + bt.aRc(parama.field_playurl) + "</playurl>");
    }
  }
  
  public static final class a
  {
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
    public LinkedList<a> yAm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.e.c
 * JD-Core Version:    0.7.0.1
 */