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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bp;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a
  implements f
{
  private String dDt;
  private int dnu;
  public Bundle dnx;
  public Activity dsa;
  public ProgressDialog fMu;
  private String result;
  private boolean ymW;
  private int ypM;
  private boolean ypb = false;
  private boolean yyY;
  private int yyZ = -1;
  public e.a yza;
  private com.tencent.mm.plugin.scanner.view.b yzb;
  private Timer yzc = null;
  private TimerTask yzd = null;
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(52024);
    ad.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.yzc = new Timer();
    this.yzd = new h(this.yzb, new h.b()
    {
      public final void onShow() {}
    }, parama);
    this.yzc.schedule(this.yzd, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final b.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    this.fMu = com.tencent.mm.ui.base.h.b(this.dsa, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.dMH();
        }
        if (a.this.yza != null) {
          a.this.yza.t(1, null);
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
    if (this.yzb != null) {
      this.yzb.a(false, false, null);
    }
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    if (this.yzc != null) {
      this.yzc.cancel();
    }
    if (this.yzd != null) {
      this.yzd.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(52027);
    ad.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode, processOfflineScan: %b, selectFromAlbum: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.dsa = paramActivity;
    int i = e.d.aLg(paramString2);
    this.dnx = paramBundle;
    this.result = paramString1;
    this.dDt = paramString2;
    this.dnu = paramInt1;
    this.ypM = paramInt2;
    this.yyY = paramBoolean2;
    this.ymW = paramBoolean1;
    this.yyZ = paramInt3;
    this.ypb = paramBoolean3;
    this.yza = parama;
    this.yzb = paramb;
    if (com.tencent.mm.kernel.g.aiU().aEN() == 0)
    {
      boolean bool = ay.isConnected(paramActivity);
      if (bool)
      {
        paramInt2 = 2;
        ad.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label293;
        }
        paramb = b.yzj;
        if (!b.qK(paramBoolean3)) {
          break label293;
        }
        if (parama != null)
        {
          if (!bool) {
            break label270;
          }
          paramInt3 = 7;
          label180:
          parama.t(paramInt3, null);
        }
        parama = b.yzj;
        parama = new OfflineScanContext(paramActivity, paramInt2, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label277;
        }
        paramActivity = paramActivity.getString(2131762850);
        label228:
        b.a(parama, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.n.ymX;
        if (!paramBoolean1) {
          break label287;
        }
      }
      label270:
      label277:
      label287:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.n.d(paramString1, paramString2, paramInt1, paramInt2, 0);
        AppMethodBeat.o(52027);
        return;
        paramInt2 = 1;
        break;
        paramInt3 = 6;
        break label180;
        paramActivity = paramActivity.getString(2131762853);
        break label228;
      }
      label293:
      if (!paramBoolean2) {
        break label382;
      }
      parama = b.yzj;
      if (!b.qK(paramBoolean3)) {
        break label382;
      }
      parama = b.yzj;
      b.f(paramActivity, paramActivity.getString(2131762848));
    }
    for (;;)
    {
      dMF();
      parama = new com.tencent.mm.plugin.scanner.model.k(paramString2, paramString1, paramInt1);
      parama.ymR = paramBoolean1;
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dMH()
        {
          AppMethodBeat.i(52022);
          a.this.dMG();
          com.tencent.mm.kernel.g.aiU().a(parama);
          AppMethodBeat.o(52022);
        }
      });
      AppMethodBeat.o(52027);
      return;
      label382:
      Toast.makeText(paramActivity, paramActivity.getString(2131759511), 0).show();
    }
  }
  
  public final void a(String paramString, b.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52023);
    boolean bool2 = this.ypb;
    if (this.yzb == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.yzb != null) && (this.ypb))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void dMF()
  {
    AppMethodBeat.i(52028);
    com.tencent.mm.kernel.g.aiU().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  final void dMG()
  {
    AppMethodBeat.i(52029);
    com.tencent.mm.kernel.g.aiU().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(52030);
    ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dMG();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.dsa, 2131762126, 2131755906, null);
      if (this.yza != null) {
        this.yza.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.yzj;
    if (b.qK(this.ypb))
    {
      paramString = b.yzj;
      if (b.b(paramInt1, paramn))
      {
        if (!this.yyY)
        {
          if (this.yza != null) {
            this.yza.t(7, null);
          }
          ad.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.yzj;
          b.a(new OfflineScanContext(this.dsa, 2, this.result, e.d.aLg(this.dDt), this.dnu, this.dDt, this.ymW, this.dnx), this.dsa.getString(2131762850), true);
          paramString = com.tencent.mm.plugin.scanner.model.n.ymX;
          paramString = this.result;
          paramn = this.dDt;
          if (this.ymW) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.n.d(paramString, paramn, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.yzj;
        b.f(this.dsa, this.dsa.getString(2131762848));
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
      if (com.tencent.mm.kernel.g.aiU().aEO())
      {
        com.tencent.mm.kernel.g.aiU().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cP(this.dsa)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hC(this.dsa);
        } else {
          Toast.makeText(this.dsa, this.dsa.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.dsa, this.dsa.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.l(this.dsa, 2131762118, 2131755906);
      if (this.yza != null) {
        this.yza.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramn.getType() == 1061)
    {
      paramString = (com.tencent.mm.plugin.scanner.model.k)paramn;
      if ((paramString.rr != null) && (paramString.rr.hNL.hNQ != null)) {}
      for (paramString = (ov)paramString.rr.hNL.hNQ; paramString == null; paramString = null)
      {
        ad.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.yza != null) {
          this.yza.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      ad.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.nEf) });
      if (bt.isNullOrNil(paramString.FIe))
      {
        if (this.yza != null) {
          this.yza.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = paramString.nEf;
      paramString = paramString.FIe;
      Activity localActivity = this.dsa;
      String str = this.dDt;
      paramInt2 = ((com.tencent.mm.plugin.scanner.model.k)paramn).dnu;
      boolean bool1 = ((com.tencent.mm.plugin.scanner.model.k)paramn).ymR;
      i = this.ypM;
      boolean bool2 = this.yyY;
      int j = this.yyZ;
      boolean bool3 = this.ypb;
      if (bt.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          ad.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
          paramInt1 = 2;
          label745:
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
        int k = k.awX(paramString);
        ad.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(k) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bt.isNullOrNil(paramString.username))) {
              break label910;
            }
            ad.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = bw.M(paramString, "user");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.c(bt.nullAsNil((String)paramString.get(".user.username")), bt.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label910:
          paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramString.username);
          if ((paramn != null) && ((int)paramn.gfj > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramn.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.g.iRG.c(paramString, localActivity);
            paramInt1 = 0;
            break label745;
          }
          new c().a(localActivity, paramString.username, 1, str, e.d.aLg(str), paramInt2, null, null, null, i, bool2, j, bool3);
          paramInt1 = 1;
          break label745;
        }
        if (k == 2)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bt.isNullOrNil(paramString.link))) {
              break label1118;
            }
            ad.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = bw.M(paramString, "url");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.b(bt.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1118:
          ad.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramn = (p)com.tencent.mm.kernel.g.ab(p.class);
            paramString = paramString.link;
            if (bool1) {}
            for (paramInt1 = 1032;; paramInt1 = 1025)
            {
              paramn.b(localActivity, paramString, paramInt1, null, null);
              paramInt1 = 0;
              break;
            }
          }
          paramn = new Intent();
          paramn.putExtra("rawUrl", paramString.link);
          paramn.setFlags(65536);
          com.tencent.mm.plugin.scanner.g.iRG.i(paramn, localActivity);
          paramInt1 = 0;
          break label745;
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
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramString.ahp(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label745;
        }
        ad.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        ad.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label745;
        ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.yza != null) {
          this.yza.t(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        ad.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        ad.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.yza != null) {
          this.yza.t(2, null);
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.dsa, this.dsa.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.yza != null) {
        this.yza.t(2, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    AppMethodBeat.o(52030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */