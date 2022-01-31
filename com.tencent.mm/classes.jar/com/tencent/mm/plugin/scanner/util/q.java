package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class q
{
  public static String V(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(81475);
    if ((paramContext == null) || (paramInt < 0))
    {
      AppMethodBeat.o(81475);
      return "";
    }
    if (paramInt == 0) {
      paramContext.getString(2131302939);
    }
    for (;;)
    {
      paramContext = paramContext.getString(2131302939);
      AppMethodBeat.o(81475);
      return paramContext;
      if (paramInt == 1) {
        paramContext.getString(2131302932);
      } else if (paramInt == 2) {
        paramContext.getString(2131302938);
      } else if (paramInt == 3) {
        paramContext.getString(2131302933);
      }
    }
  }
  
  public static int YK(String paramString)
  {
    AppMethodBeat.i(81476);
    if (paramString == null)
    {
      AppMethodBeat.o(81476);
      return 0;
    }
    paramString = paramString.trim();
    if (paramString.startsWith("<user"))
    {
      AppMethodBeat.o(81476);
      return 1;
    }
    if (paramString.startsWith("<url"))
    {
      AppMethodBeat.o(81476);
      return 2;
    }
    if (paramString.startsWith("<product"))
    {
      AppMethodBeat.o(81476);
      return 3;
    }
    if (paramString.startsWith("<search"))
    {
      AppMethodBeat.o(81476);
      return 4;
    }
    AppMethodBeat.o(81476);
    return 0;
  }
  
  public static q.c YL(String paramString)
  {
    AppMethodBeat.i(81477);
    if (paramString == null)
    {
      AppMethodBeat.o(81477);
      return null;
    }
    paramString = br.F(paramString, "user");
    if (paramString == null)
    {
      AppMethodBeat.o(81477);
      return null;
    }
    paramString = new q.c(bo.nullAsNil((String)paramString.get(".user.username")), bo.nullAsNil((String)paramString.get(".user.nickname")));
    AppMethodBeat.o(81477);
    return paramString;
  }
  
  public static q.b YM(String paramString)
  {
    AppMethodBeat.i(81478);
    if (paramString == null)
    {
      AppMethodBeat.o(81478);
      return null;
    }
    paramString = br.F(paramString, "url");
    if (paramString == null)
    {
      AppMethodBeat.o(81478);
      return null;
    }
    paramString = new q.b(bo.nullAsNil((String)paramString.get(".url.link")));
    AppMethodBeat.o(81478);
    return paramString;
  }
  
  public static q.a YN(String paramString)
  {
    AppMethodBeat.i(81480);
    if (paramString == null)
    {
      AppMethodBeat.o(81480);
      return null;
    }
    Map localMap = br.F(paramString, "search");
    if (localMap == null)
    {
      AppMethodBeat.o(81480);
      return null;
    }
    q.a locala = new q.a();
    locala.field_xmlType = 4;
    locala.field_xml = paramString;
    locala.qDK = com.tencent.mm.plugin.scanner.model.a.l(localMap, ".search");
    AppMethodBeat.o(81480);
    return locala;
  }
  
  public static int a(int paramInt1, String paramString1, Activity paramActivity, i.b paramb, int paramInt2, f.a parama, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt6)
  {
    AppMethodBeat.i(156523);
    if ((paramString1 == null) || (paramActivity == null))
    {
      if (paramString1 == null) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ab.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(paramBoolean1) });
        AppMethodBeat.o(156523);
        return 2;
      }
    }
    int i = YK(paramString1);
    ab.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      q.c localc = YL(paramString1);
      if ((localc == null) || (bo.isNullOrNil(localc.username)))
      {
        ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
        AppMethodBeat.o(156523);
        return 2;
      }
      paramString1 = ((j)g.E(j.class)).YA().arw(localc.username);
      if ((paramString1 != null) && ((int)paramString1.euF > 0))
      {
        paramb = new Intent();
        paramb.putExtra("Contact_User", paramString1.field_username);
        paramb.setFlags(65536);
        c.gmO.c(paramb, paramActivity);
        AppMethodBeat.o(156523);
        return 0;
      }
      if (paramb != null) {
        paramb.a(localc.username, 1, paramInt3, paramInt4, paramString2, parama, null);
      }
      for (;;)
      {
        AppMethodBeat.o(156523);
        return 1;
        new f().a(paramActivity, localc.username, 1, paramInt3, paramInt4, paramString2, parama, null, paramInt5, paramBoolean2, paramInt6);
      }
    }
    if (i == 2)
    {
      paramString1 = YM(paramString1);
      if ((paramString1 == null) || (bo.isNullOrNil(paramString1.link)))
      {
        ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
        AppMethodBeat.o(156523);
        return 2;
      }
      ab.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString1.link });
      if (paramInt1 == 5)
      {
        paramb = (k)g.E(k.class);
        paramString1 = paramString1.link;
        if (paramBoolean1) {}
        for (paramInt1 = 1032;; paramInt1 = 1025)
        {
          paramb.b(paramActivity, paramString1, paramInt1, null);
          AppMethodBeat.o(156523);
          return 0;
        }
      }
      paramb = new Intent();
      paramb.putExtra("rawUrl", paramString1.link);
      paramb.setFlags(65536);
      c.gmO.i(paramb, paramActivity);
      AppMethodBeat.o(156523);
      return 0;
    }
    if ((i == 3) || (i == 4))
    {
      ab.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.TRUE });
      paramb = new Intent();
      paramb.setClass(paramActivity, ProductUI.class);
      paramb.setFlags(65536);
      paramb.putExtra("key_Product_xml", paramString1);
      paramb.putExtra("key_Product_funcType", paramInt2);
      paramb.putExtra("key_ProductUI_addToDB", true);
      paramb.putExtra("key_need_add_to_history", true);
      paramb.putExtra("key_is_from_barcode", true);
      paramActivity.startActivity(paramb);
      AppMethodBeat.o(156523);
      return 0;
    }
    ab.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
    ab.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString1 });
    AppMethodBeat.o(156523);
    return 2;
  }
  
  public static String c(q.a parama)
  {
    AppMethodBeat.i(81481);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!bo.isNullOrNil(parama.field_productid))
    {
      localStringBuilder.append("<productInfo><product type=\"" + parama.field_type + "\">");
      localStringBuilder.append("<id>" + bo.apT(parama.field_productid) + "</id>");
      localStringBuilder.append("<title>" + bo.apT(parama.field_title) + "</title>");
      localStringBuilder.append("<subtitle>" + bo.apT(parama.field_subtitle) + "</subtitle>");
      localStringBuilder.append("<thumburl>" + bo.apT(parama.field_thumburl) + "</thumburl>");
      localStringBuilder.append("<source>" + bo.apT(parama.field_source) + "</source>");
      localStringBuilder.append("<shareurl>" + bo.apT(parama.field_shareurl) + "</shareurl>");
      localStringBuilder.append("<playurl>" + bo.apT(parama.field_playurl) + "</playurl>");
      localStringBuilder.append("<extinfo>" + bo.apT(parama.field_extinfo) + "</extinfo>");
      localStringBuilder.append("<getaction>" + bo.apT(new StringBuilder().append(parama.field_getaction).toString()) + "</getaction>");
      localStringBuilder.append("<certification>" + bo.apT(new StringBuilder().append(parama.field_certification).toString()) + "</certification>");
      localStringBuilder.append("<headerbackgroundurl>" + bo.apT(new StringBuilder().append(parama.field_headerbackgroundurl).toString()) + "</headerbackgroundurl>");
      localStringBuilder.append("<headermask>" + bo.apT(new StringBuilder().append(parama.field_headermask).toString()) + "</headermask>");
      localStringBuilder.append("<detailurl>" + bo.apT(new StringBuilder().append(parama.field_detailurl).toString()) + "</detailurl>");
      localStringBuilder.append("<certificationurl>" + bo.apT(new StringBuilder().append(parama.field_certificationurl).toString()) + "</certificationurl>");
      localStringBuilder.append("</product>");
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
    for (;;)
    {
      parama = localStringBuilder.toString();
      AppMethodBeat.o(81481);
      return parama;
      if (parama.field_xml == null)
      {
        ab.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
        AppMethodBeat.o(81481);
        return "";
      }
      if (parama.field_xml.startsWith("<productInfo"))
      {
        parama = parama.field_xml;
        AppMethodBeat.o(81481);
        return parama;
      }
      localStringBuilder.append("<productInfo>");
      localStringBuilder.append(parama.field_xml);
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
  }
  
  public static q.a dh(String paramString, int paramInt)
  {
    AppMethodBeat.i(81479);
    if (paramString == null)
    {
      AppMethodBeat.o(81479);
      return null;
    }
    String str = "";
    Object localObject;
    if (paramString.startsWith("<productInfo"))
    {
      localObject = br.F(paramString, "productInfo");
      str = ".productInfo";
    }
    for (int i = 1; localObject == null; i = 0)
    {
      AppMethodBeat.o(81479);
      return null;
      localObject = br.F(paramString, "product");
    }
    q.a locala = new q.a();
    if (!bo.isNullOrNil((String)((Map)localObject).get(str + ".product.$type")))
    {
      locala.field_type = Integer.valueOf((String)((Map)localObject).get(str + ".product.$type")).intValue();
      locala.field_productid = bo.nullAsNil((String)((Map)localObject).get(str + ".product.id"));
      locala.field_subtitle = bo.nullAsNil((String)((Map)localObject).get(str + ".product.subtitle"));
      locala.field_shareurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.shareurl"));
      locala.field_playurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.playurl"));
      locala.field_xmlType = 3;
      locala.field_title = bo.nullAsNil((String)((Map)localObject).get(str + ".product.title"));
      locala.field_thumburl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.thumburl"));
      locala.field_source = bo.nullAsNil((String)((Map)localObject).get(str + ".product.source"));
      locala.field_feedbackurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.feedbackurl"));
      locala.field_extinfo = bo.nullAsNil((String)((Map)localObject).get(str + ".product.extinfo"));
      locala.field_introtitle = bo.nullAsNil((String)((Map)localObject).get(str + ".product.introtitle"));
      locala.field_introlink = bo.nullAsNil((String)((Map)localObject).get(str + ".product.introlink"));
      locala.field_getaction = bo.getInt((String)((Map)localObject).get(str + ".product.getaction"), 0);
      locala.field_certification = bo.nullAsNil((String)((Map)localObject).get(str + ".product.certification"));
      locala.field_headerbackgroundurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.headerbackgroundurl"));
      locala.field_headermask = bo.nullAsNil((String)((Map)localObject).get(str + ".product.headermask"));
      locala.field_detailurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.detailurl"));
      locala.field_certificationurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.certificationurl"));
      locala.field_exposeurl = bo.nullAsNil((String)((Map)localObject).get(str + ".product.exposeurl"));
      locala.qDK = com.tencent.mm.plugin.scanner.model.a.l((Map)localObject, str + ".product");
      locala.n((Map)localObject, str + ".product");
      localObject = (String)((Map)localObject).get(str + ".functionType");
      if (bo.isNullOrNil((String)localObject)) {
        break label984;
      }
      locala.field_functionType = Integer.valueOf((String)localObject).intValue();
      label956:
      if (i == 0) {
        break label993;
      }
    }
    for (locala.field_xml = paramString;; locala.field_xml = ((StringBuilder)localObject).toString())
    {
      AppMethodBeat.o(81479);
      return locala;
      locala.field_type = 0;
      break;
      label984:
      locala.field_functionType = paramInt;
      break label956;
      label993:
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("<productInfo>");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("<functionType>" + locala.field_functionType + "</functionType>");
      ((StringBuilder)localObject).append("</productInfo>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.q
 * JD-Core Version:    0.7.0.1
 */