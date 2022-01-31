package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

public final class a
  implements f
{
  public Bundle bIo;
  public Activity bMV;
  public ProgressDialog dnm;
  
  final void byf()
  {
    au.Dk().b(1061, this);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    byf();
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4)) {
      h.a(this.bMV, R.l.qrcode_no_user_tip, R.l.app_tip, null);
    }
    label259:
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          i = 0;
        }
        while (i == 0)
        {
          if ((paramInt1 != 4) || (paramInt2 != -2004)) {
            break label259;
          }
          h.h(this.bMV, R.l.qrcode_ban_by_expose, R.l.app_tip);
          return;
          if (au.Dk().KH())
          {
            au.Dk().getNetworkServerIp();
            new StringBuilder().append(paramInt2);
          }
          for (;;)
          {
            i = 1;
            break;
            if (ab.bG(this.bMV)) {
              j.eY(this.bMV);
            } else {
              Toast.makeText(this.bMV, this.bMV.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
            }
          }
          Toast.makeText(this.bMV, this.bMV.getString(R.l.fmt_iap_err), 1).show();
          i = 1;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Toast.makeText(this.bMV, this.bMV.getString(R.l.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          return;
        }
      } while (paramm.getType() != 1061);
      localObject = ((com.tencent.mm.plugin.scanner.a.g)paramm).bxh();
      if (localObject == null)
      {
        y.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        return;
      }
      y.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(((jg)localObject).hQR) });
    } while (bk.bl(((jg)localObject).sDp));
    paramInt1 = ((jg)localObject).hQR;
    paramString = this.bMV;
    Object localObject = ((jg)localObject).sDp;
    paramInt2 = ((com.tencent.mm.plugin.scanner.a.g)paramm).bIj;
    int i = ((com.tencent.mm.plugin.scanner.a.g)paramm).bIk;
    e locale = new e();
    paramm = this.bIo;
    int j = o.Mf((String)localObject);
    y.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(j) });
    o.c localc;
    if (j == 1)
    {
      localc = o.Mg((String)localObject);
      if ((localc == null) || (bk.bl(localc.username)))
      {
        y.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
        paramInt1 = 2;
      }
    }
    for (;;)
    {
      switch (paramInt1)
      {
      default: 
        return;
      case 0: 
        y.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        return;
        au.Hx();
        localObject = c.Fw().abl(localc.username);
        if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe > 0))
        {
          paramm = new Intent();
          paramm.putExtra("Contact_User", ((ao)localObject).field_username);
          paramm.setFlags(65536);
          b.eUR.d(paramm, paramString);
          paramInt1 = 0;
        }
        else
        {
          locale.a(paramString, localc.username, 2, paramInt2, i, null, paramm);
          paramInt1 = 1;
          continue;
          if (j == 2)
          {
            localObject = o.Mh((String)localObject);
            if ((localObject == null) || (bk.bl(((o.b)localObject).eAl)))
            {
              y.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
              paramInt1 = 2;
            }
            else
            {
              y.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { ((o.b)localObject).eAl });
              if (paramInt1 == 5)
              {
                ((com.tencent.mm.plugin.appbrand.r.e)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.e.class)).b(paramString, ((o.b)localObject).eAl, 1031, paramm);
                paramInt1 = 0;
              }
              else
              {
                paramm = new Intent();
                paramm.putExtra("rawUrl", ((o.b)localObject).eAl);
                paramm.setFlags(65536);
                b.eUR.j(paramm, paramString);
                paramInt1 = 0;
              }
            }
          }
          else if ((j == 3) || (j == 4))
          {
            y.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.valueOf(true) });
            paramm = new Intent();
            paramm.setClass(paramString, ProductUI.class);
            paramm.setFlags(65536);
            paramm.putExtra("key_Product_xml", (String)localObject);
            paramm.putExtra("key_Product_funcType", 4);
            paramm.putExtra("key_ProductUI_addToDB", true);
            paramm.putExtra("key_need_add_to_history", true);
            paramm.putExtra("key_is_from_barcode", true);
            paramString.startActivity(paramm);
            paramInt1 = 0;
          }
          else
          {
            y.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
            y.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { localObject });
            paramInt1 = 2;
          }
        }
        break;
      }
    }
    y.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
    return;
    y.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */