package com.tencent.mm.plugin.scanner.a;

import android.content.Context;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import java.util.Map;

public final class j
{
  public static String a(Context paramContext, o.a parama)
  {
    g.a locala = new g.a();
    locala.appId = wN(parama.field_functionType);
    locala.title = parama.field_title;
    locala.description = parama.field_source;
    locala.type = 10;
    locala.url = parama.field_shareurl;
    locala.action = "";
    locala.appName = o.I(paramContext, parama.field_type);
    locala.thumburl = parama.field_thumburl;
    locala.dQY = parama.field_type;
    locala.dQZ = o.c(parama);
    return g.a.a(locala, null, null);
  }
  
  public static o.a cm(String paramString, int paramInt)
  {
    if (bk.bl(paramString)) {}
    Object localObject1;
    label45:
    label949:
    label958:
    do
    {
      int i;
      do
      {
        do
        {
          return null;
          i = o.Mf(paramString);
          if (i != 3) {
            break;
          }
        } while (paramString == null);
        o.a locala;
        if (paramString.startsWith("<productInfo"))
        {
          localObject2 = bn.s(paramString, "productInfo");
          i = 1;
          localObject1 = ".productInfo";
          if (localObject2 == null) {
            break label938;
          }
          locala = new o.a();
          if (bk.bl((String)((Map)localObject2).get((String)localObject1 + ".product.$type"))) {
            break label940;
          }
          locala.field_type = Integer.valueOf((String)((Map)localObject2).get((String)localObject1 + ".product.$type")).intValue();
          locala.field_productid = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.id"));
          locala.field_subtitle = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.subtitle"));
          locala.field_shareurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.shareurl"));
          locala.field_playurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.playurl"));
          locala.field_xmlType = 3;
          locala.field_title = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.title"));
          locala.field_thumburl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.thumburl"));
          locala.field_source = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.source"));
          locala.field_feedbackurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.feedbackurl"));
          locala.field_extinfo = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.extinfo"));
          locala.field_introtitle = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.introtitle"));
          locala.field_introlink = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.introlink"));
          locala.field_getaction = bk.getInt((String)((Map)localObject2).get((String)localObject1 + ".product.getaction"), 0);
          locala.field_certification = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.certification"));
          locala.field_headerbackgroundurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.headerbackgroundurl"));
          locala.field_headermask = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.headermask"));
          locala.field_detailurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.detailurl"));
          locala.field_certificationurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.certificationurl"));
          locala.field_exposeurl = bk.pm((String)((Map)localObject2).get((String)localObject1 + ".product.exposeurl"));
          locala.nPR = a.l((Map)localObject2, (String)localObject1 + ".product");
          locala.n((Map)localObject2, (String)localObject1 + ".product");
          localObject1 = (String)((Map)localObject2).get((String)localObject1 + ".functionType");
          if (bk.bl((String)localObject1)) {
            break label949;
          }
          locala.field_functionType = Integer.valueOf((String)localObject1).intValue();
          if (i == 0) {
            break label958;
          }
        }
        for (locala.field_xml = paramString;; locala.field_xml = ((StringBuilder)localObject1).toString())
        {
          return locala;
          localObject2 = bn.s(paramString, "product");
          localObject1 = "";
          i = 0;
          break label45;
          break;
          locala.field_type = 0;
          break label134;
          locala.field_functionType = paramInt;
          break label911;
          localObject1 = new StringBuilder(256);
          ((StringBuilder)localObject1).append("<productInfo>");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append("<functionType>" + locala.field_functionType + "</functionType>");
          ((StringBuilder)localObject1).append("</productInfo>");
        }
      } while ((i != 4) || (paramString == null));
      localObject1 = bn.s(paramString, "search");
    } while (localObject1 == null);
    label134:
    label911:
    label938:
    label940:
    Object localObject2 = new o.a();
    ((o.a)localObject2).field_xmlType = 4;
    ((o.a)localObject2).field_xml = paramString;
    ((o.a)localObject2).nPR = a.l((Map)localObject1, ".search");
    return localObject2;
  }
  
  public static String wN(int paramInt)
  {
    if (paramInt == 4) {
      return "wxfbc915ff7c30e335";
    }
    if (paramInt == 3) {
      return "wx482a4001c37e2b74";
    }
    return "wxfbc915ff7c30e335";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.j
 * JD-Core Version:    0.7.0.1
 */