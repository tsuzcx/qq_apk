package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.network.ac;
import com.tencent.mm.plugin.appbrand.service.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;

public final class a
  implements com.tencent.mm.ai.f
{
  public Bundle cpJ;
  public Activity cup;
  public ProgressDialog eeN;
  
  final void cjl()
  {
    AppMethodBeat.i(81368);
    com.tencent.mm.kernel.g.Rc().b(1061, this);
    AppMethodBeat.o(81368);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81369);
    ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    cjl();
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.cup, 2131302246, 2131297087, null);
      AppMethodBeat.o(81369);
      return;
    }
    int i;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(81369);
      return;
      if (com.tencent.mm.kernel.g.Rc().adu())
      {
        com.tencent.mm.kernel.g.Rc().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ac.cm(this.cup)) {
          com.tencent.mm.pluginsdk.ui.tools.h.fY(this.cup);
        } else {
          Toast.makeText(this.cup, this.cup.getString(2131300043, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.cup, this.cup.getString(2131300044), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.h(this.cup, 2131302239, 2131297087);
      AppMethodBeat.o(81369);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.cup, this.cup.getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(81369);
      return;
    }
    if (paramm.getType() == 1061)
    {
      Object localObject = ((com.tencent.mm.plugin.scanner.model.g)paramm).cif();
      if (localObject == null)
      {
        ab.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        AppMethodBeat.o(81369);
        return;
      }
      ab.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(((ll)localObject).jKs) });
      if (bo.isNullOrNil(((ll)localObject).wyR))
      {
        AppMethodBeat.o(81369);
        return;
      }
      paramInt1 = ((ll)localObject).jKs;
      paramString = this.cup;
      localObject = ((ll)localObject).wyR;
      paramInt2 = ((com.tencent.mm.plugin.scanner.model.g)paramm).cpE;
      i = ((com.tencent.mm.plugin.scanner.model.g)paramm).cpF;
      f localf = new f();
      paramm = this.cpJ;
      int j = q.YK((String)localObject);
      ab.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(j) });
      q.c localc;
      if (j == 1)
      {
        localc = q.YL((String)localObject);
        if ((localc == null) || (bo.isNullOrNil(localc.username)))
        {
          ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
          paramInt1 = 2;
          switch (paramInt1)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(81369);
        return;
        localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(localc.username);
        if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).euF > 0))
        {
          paramm = new Intent();
          paramm.putExtra("Contact_User", ((aq)localObject).field_username);
          paramm.setFlags(65536);
          c.gmO.c(paramm, paramString);
          paramInt1 = 0;
          break;
        }
        localf.a(paramString, localc.username, 2, paramInt2, i, null, paramm);
        paramInt1 = 1;
        break;
        if (j == 2)
        {
          localObject = q.YM((String)localObject);
          if ((localObject == null) || (bo.isNullOrNil(((q.b)localObject).link)))
          {
            ab.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
          }
          ab.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { ((q.b)localObject).link });
          if (paramInt1 == 5)
          {
            ((k)com.tencent.mm.kernel.g.E(k.class)).b(paramString, ((q.b)localObject).link, 1031, paramm);
            paramInt1 = 0;
            break;
          }
          paramm = new Intent();
          paramm.putExtra("rawUrl", ((q.b)localObject).link);
          paramm.setFlags(65536);
          c.gmO.i(paramm, paramString);
          paramInt1 = 0;
          break;
        }
        if ((j == 3) || (j == 4))
        {
          ab.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
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
          break;
        }
        ab.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        ab.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { localObject });
        paramInt1 = 2;
        break;
        ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        AppMethodBeat.o(81369);
        return;
        ab.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(81369);
        return;
        ab.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
      }
    }
    AppMethodBeat.o(81369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */