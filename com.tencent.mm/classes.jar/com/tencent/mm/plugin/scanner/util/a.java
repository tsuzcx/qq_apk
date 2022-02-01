package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a
  implements com.tencent.mm.al.g
{
  private int deC;
  public Bundle deG;
  public Activity djj;
  private String dtQ;
  public ProgressDialog fpP;
  private String result;
  private boolean vOH;
  private boolean vQv = false;
  private int vRb;
  private boolean vZQ;
  private int vZR = -1;
  private e.a vZS;
  private com.tencent.mm.plugin.scanner.view.b vZT;
  private Timer vZU = null;
  private TimerTask vZV = null;
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(52024);
    ad.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.vZU = new Timer();
    this.vZV = new h(this.vZT, new h.b()
    {
      public final void onShow() {}
    }, parama);
    this.vZU.schedule(this.vZV, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final b.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    this.fpP = com.tencent.mm.ui.base.h.b(this.djj, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.dnb();
        }
        AppMethodBeat.o(52020);
      }
    });
    AppMethodBeat.o(52026);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52025);
    ad.d("MicroMsg.BarcodeStringHandler", "alvinluo cancelLoading");
    if (this.vZT != null) {
      this.vZT.a(false, false, null);
    }
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    if (this.vZU != null) {
      this.vZU.cancel();
    }
    if (this.vZV != null) {
      this.vZV.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(52027);
    ad.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode, processOfflineScan: %b, selectFromAlbum: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.djj = paramActivity;
    int i = d.d.aAo(paramString2);
    this.deG = paramBundle;
    this.result = paramString1;
    this.dtQ = paramString2;
    this.deC = paramInt1;
    this.vRb = paramInt2;
    this.vZQ = paramBoolean2;
    this.vOH = paramBoolean1;
    this.vZR = paramInt3;
    this.vQv = paramBoolean3;
    this.vZS = parama;
    this.vZT = paramb;
    if (com.tencent.mm.kernel.g.aeS().auR() == 0)
    {
      boolean bool = ay.isConnected(paramActivity);
      if (bool)
      {
        paramInt2 = 2;
        ad.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label291;
        }
        paramb = b.wab;
        if (!b.pm(paramBoolean3)) {
          break label291;
        }
        if (parama != null)
        {
          if (!bool) {
            break label268;
          }
          paramInt3 = 7;
          label180:
          parama.r(paramInt3, null);
        }
        parama = b.wab;
        parama = new OfflineScanContext(paramActivity, paramInt2, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label275;
        }
        paramActivity = paramActivity.getString(2131762850);
        label228:
        b.a(parama, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.l.vOI;
        if (!paramBoolean1) {
          break label285;
        }
      }
      label268:
      label275:
      label285:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.l.n(paramString2, paramInt1, paramInt2, 0);
        AppMethodBeat.o(52027);
        return;
        paramInt2 = 1;
        break;
        paramInt3 = 6;
        break label180;
        paramActivity = paramActivity.getString(2131762853);
        break label228;
      }
      label291:
      if (!paramBoolean2) {
        break label380;
      }
      parama = b.wab;
      if (!b.pm(paramBoolean3)) {
        break label380;
      }
      parama = b.wab;
      b.f(paramActivity, paramActivity.getString(2131762848));
    }
    for (;;)
    {
      dmZ();
      parama = new i(paramString2, paramString1, paramInt1);
      parama.vOC = paramBoolean1;
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dnb()
        {
          AppMethodBeat.i(52022);
          a.this.dna();
          com.tencent.mm.kernel.g.aeS().a(parama);
          AppMethodBeat.o(52022);
        }
      });
      AppMethodBeat.o(52027);
      return;
      label380:
      Toast.makeText(paramActivity, paramActivity.getString(2131759511), 0).show();
    }
  }
  
  public final void a(String paramString, b.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52023);
    boolean bool2 = this.vQv;
    if (this.vZT == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.vZT != null) && (this.vQv))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void dmZ()
  {
    AppMethodBeat.i(52028);
    com.tencent.mm.kernel.g.aeS().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  final void dna()
  {
    AppMethodBeat.i(52029);
    com.tencent.mm.kernel.g.aeS().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52030);
    ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dna();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.djj, 2131762126, 2131755906, null);
      if (this.vZS != null) {
        this.vZS.r(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.wab;
    if (b.pm(this.vQv))
    {
      paramString = b.wab;
      if (b.b(paramInt1, paramn))
      {
        if (!this.vZQ)
        {
          if (this.vZS != null) {
            this.vZS.r(7, null);
          }
          ad.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.wab;
          b.a(new OfflineScanContext(this.djj, 2, this.result, d.d.aAo(this.dtQ), this.deC, this.dtQ, this.vOH, this.deG), this.djj.getString(2131762850), true);
          paramString = com.tencent.mm.plugin.scanner.model.l.vOI;
          paramString = this.dtQ;
          if (this.vOH) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.l.n(paramString, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.wab;
        b.f(this.djj, this.djj.getString(2131762848));
        AppMethodBeat.o(52030);
        return;
      }
    }
    int i;
    switch (paramInt1)
    {
    default: 
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(52030);
      return;
      if (com.tencent.mm.kernel.g.aeS().auS())
      {
        com.tencent.mm.kernel.g.aeS().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cJ(this.djj)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hm(this.djj);
        } else {
          Toast.makeText(this.djj, this.djj.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.djj, this.djj.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.j(this.djj, 2131762118, 2131755906);
      if (this.vZS != null) {
        this.vZS.r(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramn.getType() == 1061)
    {
      paramString = (i)paramn;
      if ((paramString.rr != null) && (paramString.rr.gUT.gUX != null)) {}
      for (paramString = (nj)paramString.rr.gUT.gUX; paramString == null; paramString = null)
      {
        ad.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.vZS != null) {
          this.vZS.r(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      ad.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.mBH) });
      if (bt.isNullOrNil(paramString.CJG))
      {
        if (this.vZS != null) {
          this.vZS.r(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = paramString.mBH;
      paramString = paramString.CJG;
      Activity localActivity = this.djj;
      String str = this.dtQ;
      paramInt2 = ((i)paramn).deC;
      boolean bool1 = ((i)paramn).vOC;
      i = this.vRb;
      boolean bool2 = this.vZQ;
      int j = this.vZR;
      boolean bool3 = this.vQv;
      if (bt.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          ad.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
          paramInt1 = 2;
          label737:
          switch (paramInt1)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(52030);
        return;
        bool1 = false;
        break;
        int k = k.amN(paramString);
        ad.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(k) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bt.isNullOrNil(paramString.username))) {
              break label902;
            }
            ad.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = bw.K(paramString, "user");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.c(bt.nullAsNil((String)paramString.get(".user.username")), bt.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label902:
          paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString.username);
          if ((paramn != null) && ((int)paramn.fId > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramn.field_username);
            paramString.setFlags(65536);
            f.hYt.c(paramString, localActivity);
            paramInt1 = 0;
            break label737;
          }
          new c().a(localActivity, paramString.username, 1, str, d.d.aAo(str), paramInt2, null, null, null, i, bool2, j, bool3);
          paramInt1 = 1;
          break label737;
        }
        if (k == 2)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bt.isNullOrNil(paramString.link))) {
              break label1110;
            }
            ad.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = bw.K(paramString, "url");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.b(bt.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1110:
          ad.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramn = (o)com.tencent.mm.kernel.g.ab(o.class);
            paramString = paramString.link;
            if (bool1) {}
            for (paramInt1 = 1032;; paramInt1 = 1025)
            {
              paramn.b(localActivity, paramString, paramInt1, null);
              paramInt1 = 0;
              break;
            }
          }
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.link);
          paramn.setFlags(65536);
          f.hYt.i(paramn, localActivity);
          paramInt1 = 0;
          break label737;
        }
        if ((k == 3) || (k == 4))
        {
          ad.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
          paramn = new Intent();
          paramn.setClass(localActivity, ProductUI.class);
          paramn.setFlags(65536);
          paramn.putExtra("key_Product_xml", paramString);
          paramn.putExtra("key_Product_funcType", 4);
          paramn.putExtra("key_ProductUI_addToDB", true);
          paramn.putExtra("key_need_add_to_history", true);
          paramn.putExtra("key_is_from_barcode", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramString.adn(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label737;
        }
        ad.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        ad.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label737;
        ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.vZS != null) {
          this.vZS.r(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        ad.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.vZS != null) {
          this.vZS.r(2, null);
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.djj, this.djj.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.vZS != null) {
        this.vZS.r(2, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    AppMethodBeat.o(52030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */