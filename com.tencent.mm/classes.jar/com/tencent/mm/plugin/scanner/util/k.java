package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Map;

public final class k
{
  public static String ad(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(52063);
    if ((paramContext == null) || (paramInt < 0))
    {
      AppMethodBeat.o(52063);
      return "";
    }
    if (paramInt == 0) {
      paramContext.getString(2131762873);
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131762873);
      AppMethodBeat.o(52063);
      return paramContext;
      if (paramInt == 1) {
        paramContext.getString(2131762866);
      } else if (paramInt == 2) {
        paramContext.getString(2131762872);
      } else if (paramInt == 3) {
        paramContext.getString(2131762867);
      }
    }
  }
  
  public static int arW(String paramString)
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
  
  public static a arX(String paramString)
  {
    AppMethodBeat.i(52066);
    if (paramString == null)
    {
      AppMethodBeat.o(52066);
      return null;
    }
    Map localMap = bv.L(paramString, "search");
    if (localMap == null)
    {
      AppMethodBeat.o(52066);
      return null;
    }
    a locala = new a();
    locala.field_xmlType = 4;
    locala.field_xml = paramString;
    locala.xml = a.m(localMap, ".search");
    AppMethodBeat.o(52066);
    return locala;
  }
  
  public static String c(a parama)
  {
    AppMethodBeat.i(52067);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!bs.isNullOrNil(parama.field_productid))
    {
      localStringBuilder.append("<productInfo><product type=\"" + parama.field_type + "\">");
      localStringBuilder.append("<id>" + bs.aLw(parama.field_productid) + "</id>");
      localStringBuilder.append("<title>" + bs.aLw(parama.field_title) + "</title>");
      localStringBuilder.append("<subtitle>" + bs.aLw(parama.field_subtitle) + "</subtitle>");
      localStringBuilder.append("<thumburl>" + bs.aLw(parama.field_thumburl) + "</thumburl>");
      localStringBuilder.append("<source>" + bs.aLw(parama.field_source) + "</source>");
      localStringBuilder.append("<shareurl>" + bs.aLw(parama.field_shareurl) + "</shareurl>");
      localStringBuilder.append("<playurl>" + bs.aLw(parama.field_playurl) + "</playurl>");
      localStringBuilder.append("<extinfo>" + bs.aLw(parama.field_extinfo) + "</extinfo>");
      localStringBuilder.append("<getaction>" + bs.aLw(new StringBuilder().append(parama.field_getaction).toString()) + "</getaction>");
      localStringBuilder.append("<certification>" + bs.aLw(new StringBuilder().append(parama.field_certification).toString()) + "</certification>");
      localStringBuilder.append("<headerbackgroundurl>" + bs.aLw(new StringBuilder().append(parama.field_headerbackgroundurl).toString()) + "</headerbackgroundurl>");
      localStringBuilder.append("<headermask>" + bs.aLw(new StringBuilder().append(parama.field_headermask).toString()) + "</headermask>");
      localStringBuilder.append("<detailurl>" + bs.aLw(new StringBuilder().append(parama.field_detailurl).toString()) + "</detailurl>");
      localStringBuilder.append("<certificationurl>" + bs.aLw(new StringBuilder().append(parama.field_certificationurl).toString()) + "</certificationurl>");
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
        ac.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
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
  
  public static a ew(String paramString, int paramInt)
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
      localObject = bv.L(paramString, "productInfo");
      str = ".productInfo";
    }
    for (int i = 1; localObject == null; i = 0)
    {
      AppMethodBeat.o(52065);
      return null;
      localObject = bv.L(paramString, "product");
    }
    a locala = new a();
    if (!bs.isNullOrNil((String)((Map)localObject).get(str + ".product.$type")))
    {
      locala.field_type = bs.getInt((String)((Map)localObject).get(str + ".product.$type"), 0);
      locala.field_productid = bs.nullAsNil((String)((Map)localObject).get(str + ".product.id"));
      locala.field_subtitle = bs.nullAsNil((String)((Map)localObject).get(str + ".product.subtitle"));
      locala.field_shareurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.shareurl"));
      locala.field_playurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.playurl"));
      locala.field_xmlType = 3;
      locala.field_title = bs.nullAsNil((String)((Map)localObject).get(str + ".product.title"));
      locala.field_thumburl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.thumburl"));
      locala.field_source = bs.nullAsNil((String)((Map)localObject).get(str + ".product.source"));
      locala.field_feedbackurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.feedbackurl"));
      locala.field_extinfo = bs.nullAsNil((String)((Map)localObject).get(str + ".product.extinfo"));
      locala.field_introtitle = bs.nullAsNil((String)((Map)localObject).get(str + ".product.introtitle"));
      locala.field_introlink = bs.nullAsNil((String)((Map)localObject).get(str + ".product.introlink"));
      locala.field_getaction = bs.getInt((String)((Map)localObject).get(str + ".product.getaction"), 0);
      locala.field_certification = bs.nullAsNil((String)((Map)localObject).get(str + ".product.certification"));
      locala.field_headerbackgroundurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.headerbackgroundurl"));
      locala.field_headermask = bs.nullAsNil((String)((Map)localObject).get(str + ".product.headermask"));
      locala.field_detailurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.detailurl"));
      locala.field_certificationurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.certificationurl"));
      locala.field_exposeurl = bs.nullAsNil((String)((Map)localObject).get(str + ".product.exposeurl"));
      locala.xml = a.m((Map)localObject, str + ".product");
      locala.o((Map)localObject, str + ".product");
      localObject = (String)((Map)localObject).get(str + ".functionType");
      if (bs.isNullOrNil((String)localObject)) {
        break label980;
      }
      locala.field_functionType = bs.getInt((String)localObject, 0);
      label952:
      if (i == 0) {
        break label989;
      }
    }
    for (locala.field_xml = paramString;; locala.field_xml = ((StringBuilder)localObject).toString())
    {
      AppMethodBeat.o(52065);
      return locala;
      locala.field_type = 0;
      break;
      label980:
      locala.field_functionType = paramInt;
      break label952;
      label989:
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("<productInfo>");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("<functionType>" + locala.field_functionType + "</functionType>");
      ((StringBuilder)localObject).append("</productInfo>");
    }
  }
  
  public static final class a
  {
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
    public LinkedList<a> xml;
    public a xmm;
    
    public final void o(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(52062);
      if (paramMap != null)
      {
        this.xmm = new a();
        this.xmm.xmn = new LinkedList();
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
            if (bs.isNullOrNil((String)localObject1)) {
              break label182;
            }
            localObject3 = new k.a.a.a();
            ((k.a.a.a)localObject3).link = ((String)localObject1);
            this.xmm.xmn.add(localObject3);
            i += 1;
            break;
          }
        }
        label182:
        this.xmm.xmo = new LinkedList();
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
            if ((bs.isNullOrNil(paramString)) && (bs.isNullOrNil((String)localObject2))) {
              break label384;
            }
            localObject3 = new k.a.a.b();
            ((k.a.a.b)localObject3).title = paramString;
            ((k.a.a.b)localObject3).desc = ((String)localObject2);
            this.xmm.xmo.add(localObject3);
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
      public LinkedList<a> xmn;
      public LinkedList<b> xmo;
      
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
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.k
 * JD-Core Version:    0.7.0.1
 */