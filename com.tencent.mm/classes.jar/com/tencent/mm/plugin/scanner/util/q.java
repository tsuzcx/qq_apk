package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class q
{
  public static String aR(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(52063);
    if ((paramContext == null) || (paramInt < 0))
    {
      AppMethodBeat.o(52063);
      return "";
    }
    if (paramInt == 0) {
      paramContext.getString(l.i.OLw);
    }
    for (;;)
    {
      paramContext = paramContext.getString(l.i.OLw);
      AppMethodBeat.o(52063);
      return paramContext;
      if (paramInt == 1) {
        paramContext.getString(l.i.OLt);
      } else if (paramInt == 2) {
        paramContext.getString(l.i.OLv);
      } else if (paramInt == 3) {
        paramContext.getString(l.i.OLu);
      }
    }
  }
  
  public static int aVj(String paramString)
  {
    AppMethodBeat.i(52064);
    if (paramString == null)
    {
      AppMethodBeat.o(52064);
      return 0;
    }
    paramString = paramString.trim();
    if (paramString.startsWith("<user"))
    {
      AppMethodBeat.o(52064);
      return 1;
    }
    if (paramString.startsWith("<url"))
    {
      AppMethodBeat.o(52064);
      return 2;
    }
    if (paramString.startsWith("<product"))
    {
      AppMethodBeat.o(52064);
      return 3;
    }
    if (paramString.startsWith("<search"))
    {
      AppMethodBeat.o(52064);
      return 4;
    }
    AppMethodBeat.o(52064);
    return 0;
  }
  
  public static a aVk(String paramString)
  {
    AppMethodBeat.i(52066);
    if (paramString == null)
    {
      AppMethodBeat.o(52066);
      return null;
    }
    Map localMap = XmlParser.parseXml(paramString, "search", null);
    if (localMap == null)
    {
      AppMethodBeat.o(52066);
      return null;
    }
    a locala = new a();
    locala.field_xmlType = 4;
    locala.field_xml = paramString;
    locala.PjJ = a.q(localMap, ".search");
    AppMethodBeat.o(52066);
    return locala;
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(52067);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!Util.isNullOrNil(parama.field_productid))
    {
      localStringBuilder.append("<productInfo><product type=\"" + parama.field_type + "\">");
      localStringBuilder.append("<id>" + Util.escapeStringForXml(parama.field_productid) + "</id>");
      localStringBuilder.append("<title>" + Util.escapeStringForXml(parama.field_title) + "</title>");
      localStringBuilder.append("<subtitle>" + Util.escapeStringForXml(parama.field_subtitle) + "</subtitle>");
      localStringBuilder.append("<thumburl>" + Util.escapeStringForXml(parama.field_thumburl) + "</thumburl>");
      localStringBuilder.append("<source>" + Util.escapeStringForXml(parama.field_source) + "</source>");
      localStringBuilder.append("<shareurl>" + Util.escapeStringForXml(parama.field_shareurl) + "</shareurl>");
      localStringBuilder.append("<playurl>" + Util.escapeStringForXml(parama.field_playurl) + "</playurl>");
      localStringBuilder.append("<extinfo>" + Util.escapeStringForXml(parama.field_extinfo) + "</extinfo>");
      localStringBuilder.append("<getaction>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_getaction).toString()) + "</getaction>");
      localStringBuilder.append("<certification>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_certification).toString()) + "</certification>");
      localStringBuilder.append("<headerbackgroundurl>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_headerbackgroundurl).toString()) + "</headerbackgroundurl>");
      localStringBuilder.append("<headermask>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_headermask).toString()) + "</headermask>");
      localStringBuilder.append("<detailurl>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_detailurl).toString()) + "</detailurl>");
      localStringBuilder.append("<certificationurl>" + Util.escapeStringForXml(new StringBuilder().append(parama.field_certificationurl).toString()) + "</certificationurl>");
      localStringBuilder.append("</product>");
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
    for (;;)
    {
      parama = localStringBuilder.toString();
      AppMethodBeat.o(52067);
      return parama;
      if (parama.field_xml == null)
      {
        Log.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
        AppMethodBeat.o(52067);
        return "";
      }
      if (parama.field_xml.startsWith("<productInfo"))
      {
        parama = parama.field_xml;
        AppMethodBeat.o(52067);
        return parama;
      }
      localStringBuilder.append("<productInfo>");
      localStringBuilder.append(parama.field_xml);
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
  }
  
  public static a gJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(52065);
    if (paramString == null)
    {
      AppMethodBeat.o(52065);
      return null;
    }
    String str = "";
    Object localObject;
    if (paramString.startsWith("<productInfo"))
    {
      localObject = XmlParser.parseXml(paramString, "productInfo", null);
      str = ".productInfo";
    }
    for (int i = 1; localObject == null; i = 0)
    {
      AppMethodBeat.o(52065);
      return null;
      localObject = XmlParser.parseXml(paramString, "product", null);
    }
    a locala = new a();
    if (!Util.isNullOrNil((String)((Map)localObject).get(str + ".product.$type")))
    {
      locala.field_type = Util.getInt((String)((Map)localObject).get(str + ".product.$type"), 0);
      locala.field_productid = Util.nullAsNil((String)((Map)localObject).get(str + ".product.id"));
      locala.field_subtitle = Util.nullAsNil((String)((Map)localObject).get(str + ".product.subtitle"));
      locala.field_shareurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.shareurl"));
      locala.field_playurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.playurl"));
      locala.field_xmlType = 3;
      locala.field_title = Util.nullAsNil((String)((Map)localObject).get(str + ".product.title"));
      locala.field_thumburl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.thumburl"));
      locala.field_source = Util.nullAsNil((String)((Map)localObject).get(str + ".product.source"));
      locala.field_feedbackurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.feedbackurl"));
      locala.field_extinfo = Util.nullAsNil((String)((Map)localObject).get(str + ".product.extinfo"));
      locala.field_introtitle = Util.nullAsNil((String)((Map)localObject).get(str + ".product.introtitle"));
      locala.field_introlink = Util.nullAsNil((String)((Map)localObject).get(str + ".product.introlink"));
      locala.field_getaction = Util.getInt((String)((Map)localObject).get(str + ".product.getaction"), 0);
      locala.field_certification = Util.nullAsNil((String)((Map)localObject).get(str + ".product.certification"));
      locala.field_headerbackgroundurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.headerbackgroundurl"));
      locala.field_headermask = Util.nullAsNil((String)((Map)localObject).get(str + ".product.headermask"));
      locala.field_detailurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.detailurl"));
      locala.field_certificationurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.certificationurl"));
      locala.field_exposeurl = Util.nullAsNil((String)((Map)localObject).get(str + ".product.exposeurl"));
      locala.PjJ = a.q((Map)localObject, str + ".product");
      locala.s((Map)localObject, str + ".product");
      localObject = (String)((Map)localObject).get(str + ".functionType");
      if (Util.isNullOrNil((String)localObject)) {
        break label982;
      }
      locala.field_functionType = Util.getInt((String)localObject, 0);
      label954:
      if (i == 0) {
        break label991;
      }
    }
    for (locala.field_xml = paramString;; locala.field_xml = ((StringBuilder)localObject).toString())
    {
      AppMethodBeat.o(52065);
      return locala;
      locala.field_type = 0;
      break;
      label982:
      locala.field_functionType = paramInt;
      break label954;
      label991:
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("<productInfo>");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("<functionType>" + locala.field_functionType + "</functionType>");
      ((StringBuilder)localObject).append("</productInfo>");
    }
  }
  
  public static final class a
  {
    public LinkedList<a> PjJ;
    public a PjK;
    public String field_certification;
    public String field_certificationurl;
    public String field_detailurl;
    public String field_exposeurl;
    public String field_extinfo;
    public String field_feedbackurl;
    public int field_functionType;
    public int field_getaction;
    public String field_headerbackgroundurl;
    public String field_headermask;
    public String field_introlink;
    public String field_introtitle;
    public String field_playurl;
    public String field_productid;
    public String field_shareurl;
    public String field_source;
    public String field_subtitle;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    public String field_xml;
    public int field_xmlType;
    
    public final void s(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(52062);
      if (paramMap != null)
      {
        this.PjK = new a();
        this.PjK.PjL = new LinkedList();
        Object localObject2 = paramString + ".bannerlist.banner";
        int i = 0;
        Object localObject3;
        if (i < 1000)
        {
          localObject3 = new StringBuilder().append((String)localObject2);
          if (i > 0) {}
          for (localObject1 = Integer.valueOf(i);; localObject1 = "")
          {
            localObject1 = localObject1;
            localObject1 = (String)paramMap.get((String)localObject1 + ".link");
            if (Util.isNullOrNil((String)localObject1)) {
              break label182;
            }
            localObject3 = new q.a.a.a();
            ((q.a.a.a)localObject3).link = ((String)localObject1);
            this.PjK.PjL.add(localObject3);
            i += 1;
            break;
          }
        }
        label182:
        this.PjK.PjM = new LinkedList();
        Object localObject1 = paramString + ".detaillist.detail";
        i = 0;
        if (i < 1000)
        {
          localObject2 = new StringBuilder().append((String)localObject1);
          if (i > 0) {}
          for (paramString = Integer.valueOf(i);; paramString = "")
          {
            localObject2 = paramString;
            paramString = (String)paramMap.get((String)localObject2 + ".title");
            localObject2 = (String)paramMap.get((String)localObject2 + ".desc");
            if ((Util.isNullOrNil(paramString)) && (Util.isNullOrNil((String)localObject2))) {
              break label384;
            }
            localObject3 = new q.a.a.b();
            ((q.a.a.b)localObject3).title = paramString;
            ((q.a.a.b)localObject3).desc = ((String)localObject2);
            this.PjK.PjM.add(localObject3);
            i += 1;
            break;
          }
        }
      }
      label384:
      AppMethodBeat.o(52062);
    }
    
    public static final class a
    {
      public LinkedList<a> PjL;
      public LinkedList<b> PjM;
      
      public static final class a
      {
        public String link;
      }
      
      public static final class b
      {
        public String desc;
        public String title;
      }
    }
  }
  
  public static final class b
  {
    public String link;
    
    public b(String paramString)
    {
      this.link = paramString;
    }
  }
  
  public static final class c
  {
    public String nickname;
    public String username;
    
    public c(String paramString1, String paramString2)
    {
      this.username = paramString1;
      this.nickname = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.q
 * JD-Core Version:    0.7.0.1
 */