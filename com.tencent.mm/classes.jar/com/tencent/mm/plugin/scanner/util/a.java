package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.scanner.g.e.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.l;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.TimerTask;

public final class a
  implements com.tencent.mm.an.i
{
  private boolean IKW;
  private boolean IOs = false;
  public int IPa;
  private boolean IYp;
  private int IYq = -1;
  public e.a IYr;
  private com.tencent.mm.plugin.scanner.view.c IYs;
  private com.tencent.e.i.d<?> IYt = null;
  private TimerTask IYu = null;
  public Activity fDf;
  private String fPQ;
  private int fyt;
  public Bundle fyw;
  public ProgressDialog iXX;
  private String result;
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(52024);
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.IYu = new i(this.IYs, new i.b()
    {
      public final void onShow() {}
    }, parama);
    this.IYt = com.tencent.e.h.ZvG.o(this.IYu, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    this.iXX = com.tencent.mm.ui.base.h.a(this.fDf, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.fEM();
        }
        if (a.a(a.this) != null) {
          a.a(a.this).t(1, null);
        }
        AppMethodBeat.o(52020);
      }
    });
    AppMethodBeat.o(52026);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52025);
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo cancelLoading");
    if (this.IYs != null) {
      this.IYs.a(false, false, null);
    }
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    if (this.IYt != null) {
      this.IYt.cancel(false);
    }
    if (this.IYu != null) {
      this.IYu.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  private void fEL()
  {
    AppMethodBeat.i(52029);
    com.tencent.mm.kernel.h.aGY().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.c paramc, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    AppMethodBeat.i(217845);
    Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode result: %s, processOfflineScan: %b, selectFromAlbum: %b, codeName: %s, mode: %d", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), paramString2, Integer.valueOf(paramInt4) });
    this.fDf = paramActivity;
    int i = e.d.boV(paramString2);
    this.fyw = paramBundle;
    this.result = paramString1;
    this.fPQ = paramString2;
    this.fyt = paramInt1;
    this.IPa = paramInt2;
    this.IYp = paramBoolean2;
    this.IKW = paramBoolean1;
    this.IYq = paramInt3;
    this.IOs = paramBoolean3;
    this.IYr = parama;
    this.IYs = paramc;
    if (com.tencent.mm.kernel.h.aGY().bih() == 0)
    {
      boolean bool = NetStatusUtil.isConnected(paramActivity);
      if (bool)
      {
        paramInt3 = 2;
        Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label313;
        }
        paramc = b.IYA;
        if (!b.xI(paramBoolean3)) {
          break label313;
        }
        if (parama != null)
        {
          if (!bool) {
            break label289;
          }
          paramInt2 = 7;
          label198:
          parama.t(paramInt2, null);
        }
        parama = b.IYA;
        parama = new OfflineScanContext(paramActivity, paramInt3, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label296;
        }
        paramActivity = paramActivity.getString(l.i.IFe);
        label247:
        b.a(parama, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.o.IKX;
        if (!paramBoolean1) {
          break label307;
        }
      }
      label289:
      label296:
      label307:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.o.b(paramString1, paramString2, paramInt1, paramInt3, 0);
        AppMethodBeat.o(217845);
        return;
        paramInt3 = 1;
        break;
        paramInt2 = 6;
        break label198;
        paramActivity = paramActivity.getString(l.i.IFh);
        break label247;
      }
      label313:
      if (!paramBoolean2) {
        break label408;
      }
      parama = b.IYA;
      if (!b.xI(paramBoolean3)) {
        break label408;
      }
      parama = b.IYA;
      b.k(paramActivity, paramActivity.getString(l.i.IFd));
    }
    for (;;)
    {
      fEK();
      parama = new l(paramString2, paramString1, paramInt1, paramInt4, paramInt2);
      parama.IKS = paramBoolean1;
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      a(paramActivity.getString(l.i.IEJ), new c.a()
      {
        public final void fEM()
        {
          AppMethodBeat.i(52022);
          a.b(a.this);
          com.tencent.mm.kernel.h.aGY().a(parama);
          AppMethodBeat.o(52022);
        }
      });
      AppMethodBeat.o(217845);
      return;
      label408:
      Toast.makeText(paramActivity, paramActivity.getString(l.i.fmt_iap_err), 0).show();
    }
  }
  
  public final void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52023);
    boolean bool2 = this.IOs;
    if (this.IYs == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.IYs != null) && (this.IOs))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void fEK()
  {
    AppMethodBeat.i(52028);
    com.tencent.mm.kernel.h.aGY().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(52030);
    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    fEL();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.fDf, l.i.IEH, l.i.app_tip, null);
      if (this.IYr != null) {
        this.IYr.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.IYA;
    if (b.xI(this.IOs))
    {
      paramString = b.IYA;
      if (b.b(paramInt1, paramq))
      {
        if (!this.IYp)
        {
          if (this.IYr != null) {
            this.IYr.t(7, null);
          }
          Log.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.IYA;
          b.a(new OfflineScanContext(this.fDf, 2, this.result, e.d.boV(this.fPQ), this.fyt, this.fPQ, this.IKW, this.fyw), this.fDf.getString(l.i.IFe), true);
          paramString = com.tencent.mm.plugin.scanner.model.o.IKX;
          paramString = this.result;
          paramq = this.fPQ;
          if (this.IKW) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.o.b(paramString, paramq, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.IYA;
        b.k(this.fDf, this.fDf.getString(l.i.IFd));
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
      if (com.tencent.mm.kernel.h.aGY().bii())
      {
        com.tencent.mm.kernel.h.aGY().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ag.dj(this.fDf)) {
          com.tencent.mm.pluginsdk.ui.tools.n.jF(this.fDf);
        } else {
          Toast.makeText(this.fDf, this.fDf.getString(l.i.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.fDf, this.fDf.getString(l.i.fmt_iap_err), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.p(this.fDf, l.i.qrcode_ban_by_expose, l.i.app_tip);
      if (this.IYr != null) {
        this.IYr.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramq.getType() == 1061)
    {
      paramString = (l)paramq;
      if ((paramString.rr != null) && (d.c.b(paramString.rr.lBS) != null)) {}
      for (pq localpq = (pq)d.c.b(paramString.rr.lBS); localpq == null; localpq = null)
      {
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.IYr != null) {
          this.IYr.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      Log.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(localpq.rWu) });
      if (Util.isNullOrNil(localpq.RVB))
      {
        if (this.IYr != null) {
          this.IYr.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = localpq.rWu;
      paramString = localpq.RVB;
      Activity localActivity = this.fDf;
      String str = this.fPQ;
      paramInt2 = ((l)paramq).fyt;
      boolean bool1 = ((l)paramq).IKS;
      i = this.IPa;
      boolean bool2 = this.IYp;
      int j = this.IYq;
      boolean bool3 = this.IOs;
      if (Util.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          Log.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
          paramInt1 = 2;
          label753:
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
        int k = o.aXB(paramString);
        Log.i("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s], respType: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt1) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!Util.isNullOrNil(paramString.username))) {
              break label930;
            }
            Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = XmlParser.parseXml(paramString, "user", null);
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new o.c(Util.nullAsNil((String)paramString.get(".user.username")), Util.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label930:
          paramq = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString.username);
          if ((paramq != null) && ((int)paramq.jxt > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramq.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.m.cYL().c(paramString, localActivity);
            paramInt1 = 0;
            break label753;
          }
          new c().a(localActivity, paramString.username, 1, str, e.d.boV(str), paramInt2, null, i, bool2, j, bool3);
          paramInt1 = 1;
          break label753;
        }
        if (k == 2)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!Util.isNullOrNil(paramString.link))) {
              break label1137;
            }
            Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = XmlParser.parseXml(paramString, "url", null);
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new o.b(Util.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1137:
          Log.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramq = (s)com.tencent.mm.kernel.h.ae(s.class);
            paramString = paramString.link;
            if (bool1) {}
            for (paramInt1 = 1032;; paramInt1 = 1025)
            {
              paramq.b(localActivity, paramString, paramInt1, null, null);
              paramInt1 = 0;
              break;
            }
          }
          if (paramInt1 == 6)
          {
            paramInt1 = 3;
            break label753;
          }
          paramq = new Intent();
          paramq.putExtra("rawUrl", paramString.link);
          paramq.setFlags(65536);
          com.tencent.mm.plugin.scanner.m.cYL().h(paramq, localActivity);
          paramInt1 = 0;
          break label753;
        }
        if ((k == 3) || (k == 4))
        {
          Log.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
          paramq = new Intent();
          paramq.setClass(localActivity, ProductUI.class);
          paramq.setFlags(65536);
          paramq.putExtra("key_Product_xml", paramString);
          paramq.putExtra("key_Product_funcType", 4);
          paramq.putExtra("key_ProductUI_addToDB", true);
          paramq.putExtra("key_need_add_to_history", true);
          paramq.putExtra("key_is_from_barcode", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
          com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramString.aFh(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label753;
        }
        Log.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        Log.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label753;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.IYr != null) {
          this.IYr.t(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.IYr != null)
        {
          this.IYr.t(2, null);
          AppMethodBeat.o(52030);
          return;
          Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_JUMP_SCAN_GOODS");
          paramString = new Bundle();
          try
          {
            paramString.putByteArray("key_scan_bar_code_response", localpq.toByteArray());
            if (this.IYr != null) {
              this.IYr.t(8, paramString);
            }
          }
          catch (Exception paramq)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BarcodeStringHandler", paramq, "onSceneEnd BizScanBarcodeResponse toByteArray exception", new Object[0]);
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.fDf, this.fDf.getString(l.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.IYr != null) {
        this.IYr.t(2, null);
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