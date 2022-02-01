package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bq;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a
  implements f
{
  private String dEy;
  private int dow;
  public Bundle doz;
  public Activity dtg;
  public ProgressDialog fOC;
  private String result;
  private boolean yCV;
  private int yFL;
  private boolean yFa = false;
  private boolean yOY;
  private int yOZ = -1;
  public e.a yPa;
  private com.tencent.mm.plugin.scanner.view.b yPb;
  private Timer yPc = null;
  private TimerTask yPd = null;
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(52024);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.yPc = new Timer();
    this.yPd = new h(this.yPb, new h.b()
    {
      public final void onShow() {}
    }, parama);
    this.yPc.schedule(this.yPd, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final b.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    this.fOC = com.tencent.mm.ui.base.h.b(this.dtg, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.dQa();
        }
        if (a.this.yPa != null) {
          a.this.yPa.t(1, null);
        }
        AppMethodBeat.o(52020);
      }
    });
    AppMethodBeat.o(52026);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52025);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BarcodeStringHandler", "alvinluo cancelLoading");
    if (this.yPb != null) {
      this.yPb.a(false, false, null);
    }
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    if (this.yPc != null) {
      this.yPc.cancel();
    }
    if (this.yPd != null) {
      this.yPd.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(52027);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode, processOfflineScan: %b, selectFromAlbum: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.dtg = paramActivity;
    int i = e.d.aMC(paramString2);
    this.doz = paramBundle;
    this.result = paramString1;
    this.dEy = paramString2;
    this.dow = paramInt1;
    this.yFL = paramInt2;
    this.yOY = paramBoolean2;
    this.yCV = paramBoolean1;
    this.yOZ = paramInt3;
    this.yFa = paramBoolean3;
    this.yPa = parama;
    this.yPb = paramb;
    if (g.ajj().aFd() == 0)
    {
      boolean bool = az.isConnected(paramActivity);
      if (bool)
      {
        paramInt2 = 2;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label293;
        }
        paramb = b.yPj;
        if (!b.qR(paramBoolean3)) {
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
        parama = b.yPj;
        parama = new OfflineScanContext(paramActivity, paramInt2, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label277;
        }
        paramActivity = paramActivity.getString(2131762850);
        label228:
        b.a(parama, paramActivity, false);
        paramActivity = o.yCW;
        if (!paramBoolean1) {
          break label287;
        }
      }
      label270:
      label277:
      label287:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        o.d(paramString1, paramString2, paramInt1, paramInt2, 0);
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
      parama = b.yPj;
      if (!b.qR(paramBoolean3)) {
        break label382;
      }
      parama = b.yPj;
      b.g(paramActivity, paramActivity.getString(2131762848));
    }
    for (;;)
    {
      dPY();
      parama = new com.tencent.mm.plugin.scanner.model.l(paramString2, paramString1, paramInt1);
      parama.yCQ = paramBoolean1;
      g.ajj().a(parama, 0);
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dQa()
        {
          AppMethodBeat.i(52022);
          a.this.dPZ();
          g.ajj().a(parama);
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
    boolean bool2 = this.yFa;
    if (this.yPb == null) {
      bool1 = true;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.yPb != null) && (this.yFa))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void dPY()
  {
    AppMethodBeat.i(52028);
    g.ajj().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  final void dPZ()
  {
    AppMethodBeat.i(52029);
    g.ajj().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52030);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dPZ();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.dtg, 2131762126, 2131755906, null);
      if (this.yPa != null) {
        this.yPa.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.yPj;
    if (b.qR(this.yFa))
    {
      paramString = b.yPj;
      if (b.b(paramInt1, paramn))
      {
        if (!this.yOY)
        {
          if (this.yPa != null) {
            this.yPa.t(7, null);
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.yPj;
          b.a(new OfflineScanContext(this.dtg, 2, this.result, e.d.aMC(this.dEy), this.dow, this.dEy, this.yCV, this.doz), this.dtg.getString(2131762850), true);
          paramString = o.yCW;
          paramString = this.result;
          paramn = this.dEy;
          if (this.yCV) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            o.d(paramString, paramn, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.yPj;
        b.g(this.dtg, this.dtg.getString(2131762848));
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
      if (g.ajj().aFe())
      {
        g.ajj().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (com.tencent.mm.network.ae.cR(this.dtg)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hI(this.dtg);
        } else {
          Toast.makeText(this.dtg, this.dtg.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.dtg, this.dtg.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.l(this.dtg, 2131762118, 2131755906);
      if (this.yPa != null) {
        this.yPa.t(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramn.getType() == 1061)
    {
      paramString = (com.tencent.mm.plugin.scanner.model.l)paramn;
      if ((paramString.rr != null) && (paramString.rr.hQE.hQJ != null)) {}
      for (paramString = (ox)paramString.rr.hQE.hQJ; paramString == null; paramString = null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.yPa != null) {
          this.yPa.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.nJA) });
      if (bu.isNullOrNil(paramString.GaA))
      {
        if (this.yPa != null) {
          this.yPa.t(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = paramString.nJA;
      paramString = paramString.GaA;
      Activity localActivity = this.dtg;
      String str = this.dEy;
      paramInt2 = ((com.tencent.mm.plugin.scanner.model.l)paramn).dow;
      boolean bool1 = ((com.tencent.mm.plugin.scanner.model.l)paramn).yCQ;
      i = this.yFL;
      boolean bool2 = this.yOY;
      int j = this.yOZ;
      boolean bool3 = this.yFa;
      if (bu.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
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
        int k = k.aym(paramString);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(k) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bu.isNullOrNil(paramString.username))) {
              break label910;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = bx.M(paramString, "user");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.c(bu.nullAsNil((String)paramString.get(".user.username")), bu.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label910:
          paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramString.username);
          if ((paramn != null) && ((int)paramn.ght > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramn.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.h.iUz.c(paramString, localActivity);
            paramInt1 = 0;
            break label745;
          }
          new c().a(localActivity, paramString.username, 1, str, e.d.aMC(str), paramInt2, null, null, null, i, bool2, j, bool3);
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
            if ((paramString != null) && (!bu.isNullOrNil(paramString.link))) {
              break label1118;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = bx.M(paramString, "url");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.b(bu.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1118:
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramn = (com.tencent.mm.plugin.appbrand.service.q)g.ab(com.tencent.mm.plugin.appbrand.service.q.class);
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
          com.tencent.mm.plugin.scanner.h.iUz.i(paramn, localActivity);
          paramInt1 = 0;
          break label745;
        }
        if ((k == 3) || (k == 4))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
          paramn = new Intent();
          paramn.setClass(localActivity, ProductUI.class);
          paramn.setFlags(65536);
          paramn.putExtra("key_Product_xml", paramString);
          paramn.putExtra("key_Product_funcType", 4);
          paramn.putExtra("key_ProductUI_addToDB", true);
          paramn.putExtra("key_need_add_to_history", true);
          paramn.putExtra("key_is_from_barcode", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramString.ahE(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label745;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label745;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.yPa != null) {
          this.yPa.t(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.yPa != null) {
          this.yPa.t(2, null);
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.dtg, this.dtg.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.yPa != null) {
        this.yPa.t(2, null);
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