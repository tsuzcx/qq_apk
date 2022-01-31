package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.ui.i;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class o
{
  public static String I(Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (paramInt < 0)) {
      return "";
    }
    if (paramInt == 0) {
      paramContext.getString(R.l.scan_product_type_unknown);
    }
    for (;;)
    {
      return paramContext.getString(R.l.scan_product_type_unknown);
      if (paramInt == 1) {
        paramContext.getString(R.l.scan_product_type_book);
      } else if (paramInt == 2) {
        paramContext.getString(R.l.scan_product_type_movie);
      } else if (paramInt == 3) {
        paramContext.getString(R.l.scan_product_type_cd);
      }
    }
  }
  
  public static int Mf(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      paramString = paramString.trim();
      if (paramString.startsWith("<user")) {
        return 1;
      }
      if (paramString.startsWith("<url")) {
        return 2;
      }
      if (paramString.startsWith("<product")) {
        return 3;
      }
    } while (!paramString.startsWith("<search"));
    return 4;
  }
  
  public static o.c Mg(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = bn.s(paramString, "user");
    } while (paramString == null);
    return new o.c(bk.pm((String)paramString.get(".user.username")), bk.pm((String)paramString.get(".user.nickname")));
  }
  
  public static o.b Mh(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = bn.s(paramString, "url");
    } while (paramString == null);
    return new o.b(bk.pm((String)paramString.get(".url.link")));
  }
  
  public static int a(int paramInt1, String paramString, i parami, int paramInt2, e.a parama, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((parami == null) || (paramString == null) || (parami.bxQ() == null) || (parami.bxQ().getContext() == null))
    {
      if (paramString == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        y.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(paramBoolean) });
        return 2;
      }
    }
    int i = Mf(paramString);
    y.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      o.c localc = Mg(paramString);
      if ((localc == null) || (bk.bl(localc.username)))
      {
        y.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
        return 2;
      }
      au.Hx();
      paramString = c.Fw().abl(localc.username);
      if ((paramString != null) && ((int)paramString.dBe > 0))
      {
        parama = new Intent();
        parama.putExtra("Contact_User", paramString.field_username);
        parama.setFlags(65536);
        b.eUR.d(parama, parami.bxQ().getContext());
        return 0;
      }
      parami.bxQ().a(localc.username, 1, paramInt3, paramInt4, parama);
      return 1;
    }
    if (i == 2)
    {
      paramString = Mh(paramString);
      if ((paramString == null) || (bk.bl(paramString.eAl)))
      {
        y.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
        return 2;
      }
      y.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.eAl });
      if (paramInt1 == 5)
      {
        parama = (e)g.r(e.class);
        parami = parami.bxQ().getContext();
        paramString = paramString.eAl;
        if (paramBoolean) {}
        for (paramInt1 = 1032;; paramInt1 = 1025)
        {
          parama.b(parami, paramString, paramInt1, null);
          return 0;
        }
      }
      parama = new Intent();
      parama.putExtra("rawUrl", paramString.eAl);
      parama.setFlags(65536);
      b.eUR.j(parama, parami.bxQ().getContext());
      return 0;
    }
    if ((i == 3) || (i == 4))
    {
      y.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(true) });
      parama = new Intent();
      parama.setClass(parami.bxQ().getContext(), ProductUI.class);
      parama.setFlags(65536);
      parama.putExtra("key_Product_xml", paramString);
      parama.putExtra("key_Product_funcType", paramInt2);
      parama.putExtra("key_ProductUI_addToDB", true);
      parama.putExtra("key_need_add_to_history", true);
      parama.putExtra("key_is_from_barcode", true);
      parami.bxQ().getContext().startActivity(parama);
      return 0;
    }
    y.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
    y.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
    return 2;
  }
  
  public static String c(o.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!bk.bl(parama.field_productid))
    {
      localStringBuilder.append("<productInfo><product type=\"" + parama.field_type + "\">");
      localStringBuilder.append("<id>" + bk.ZP(parama.field_productid) + "</id>");
      localStringBuilder.append("<title>" + bk.ZP(parama.field_title) + "</title>");
      localStringBuilder.append("<subtitle>" + bk.ZP(parama.field_subtitle) + "</subtitle>");
      localStringBuilder.append("<thumburl>" + bk.ZP(parama.field_thumburl) + "</thumburl>");
      localStringBuilder.append("<source>" + bk.ZP(parama.field_source) + "</source>");
      localStringBuilder.append("<shareurl>" + bk.ZP(parama.field_shareurl) + "</shareurl>");
      localStringBuilder.append("<playurl>" + bk.ZP(parama.field_playurl) + "</playurl>");
      localStringBuilder.append("<extinfo>" + bk.ZP(parama.field_extinfo) + "</extinfo>");
      localStringBuilder.append("<getaction>" + bk.ZP(new StringBuilder().append(parama.field_getaction).toString()) + "</getaction>");
      localStringBuilder.append("<certification>" + bk.ZP(new StringBuilder().append(parama.field_certification).toString()) + "</certification>");
      localStringBuilder.append("<headerbackgroundurl>" + bk.ZP(new StringBuilder().append(parama.field_headerbackgroundurl).toString()) + "</headerbackgroundurl>");
      localStringBuilder.append("<headermask>" + bk.ZP(new StringBuilder().append(parama.field_headermask).toString()) + "</headermask>");
      localStringBuilder.append("<detailurl>" + bk.ZP(new StringBuilder().append(parama.field_detailurl).toString()) + "</detailurl>");
      localStringBuilder.append("<certificationurl>" + bk.ZP(new StringBuilder().append(parama.field_certificationurl).toString()) + "</certificationurl>");
      localStringBuilder.append("</product>");
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (parama.field_xml == null)
      {
        y.e("MicroMsg.Scanner.ScanXmlHelper", "product.field_xml == null in getProductInfoXml()");
        return "";
      }
      if (parama.field_xml.startsWith("<productInfo")) {
        return parama.field_xml;
      }
      localStringBuilder.append("<productInfo>");
      localStringBuilder.append(parama.field_xml);
      localStringBuilder.append("<functionType>" + parama.field_functionType + "</functionType>");
      localStringBuilder.append("</productInfo>");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.o
 * JD-Core Version:    0.7.0.1
 */