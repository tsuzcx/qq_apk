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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.i;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a
  implements com.tencent.mm.ak.g
{
  private int dbY;
  public Bundle dcb;
  public Activity dgE;
  private String drB;
  public ProgressDialog fts;
  private String result;
  private boolean wZd;
  private int xbK;
  private boolean xbc = false;
  private boolean xkW;
  private int xkX = -1;
  private e.a xkY;
  private com.tencent.mm.plugin.scanner.view.b xkZ;
  private Timer xla = null;
  private TimerTask xlb = null;
  
  private void a(b.a parama)
  {
    AppMethodBeat.i(52024);
    ac.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.xla = new Timer();
    this.xlb = new h(this.xkZ, new h.b()
    {
      public final void onShow() {}
    }, parama);
    this.xla.schedule(this.xlb, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final b.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    this.fts = com.tencent.mm.ui.base.h.b(this.dgE, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.dBj();
        }
        AppMethodBeat.o(52020);
      }
    });
    AppMethodBeat.o(52026);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52025);
    ac.d("MicroMsg.BarcodeStringHandler", "alvinluo cancelLoading");
    if (this.xkZ != null) {
      this.xkZ.a(false, false, null);
    }
    if (this.fts != null) {
      this.fts.dismiss();
    }
    if (this.xla != null) {
      this.xla.cancel();
    }
    if (this.xlb != null) {
      this.xlb.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3)
  {
    AppMethodBeat.i(52027);
    ac.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode, processOfflineScan: %b, selectFromAlbum: %b", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1) });
    this.dgE = paramActivity;
    int i = d.d.aFG(paramString2);
    this.dcb = paramBundle;
    this.result = paramString1;
    this.drB = paramString2;
    this.dbY = paramInt1;
    this.xbK = paramInt2;
    this.xkW = paramBoolean2;
    this.wZd = paramBoolean1;
    this.xkX = paramInt3;
    this.xbc = paramBoolean3;
    this.xkY = parama;
    this.xkZ = paramb;
    if (com.tencent.mm.kernel.g.agi().aBK() == 0)
    {
      boolean bool = ax.isConnected(paramActivity);
      if (bool)
      {
        paramInt2 = 2;
        ac.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label291;
        }
        paramb = b.xlh;
        if (!b.ql(paramBoolean3)) {
          break label291;
        }
        if (parama != null)
        {
          if (!bool) {
            break label268;
          }
          paramInt3 = 7;
          label180:
          parama.s(paramInt3, null);
        }
        parama = b.xlh;
        parama = new OfflineScanContext(paramActivity, paramInt2, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label275;
        }
        paramActivity = paramActivity.getString(2131762850);
        label228:
        b.a(parama, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.l.wZe;
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
      parama = b.xlh;
      if (!b.ql(paramBoolean3)) {
        break label380;
      }
      parama = b.xlh;
      b.f(paramActivity, paramActivity.getString(2131762848));
    }
    for (;;)
    {
      dBh();
      parama = new i(paramString2, paramString1, paramInt1);
      parama.wYY = paramBoolean1;
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dBj()
        {
          AppMethodBeat.i(52022);
          a.this.dBi();
          com.tencent.mm.kernel.g.agi().a(parama);
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
    boolean bool2 = this.xbc;
    if (this.xkZ == null) {
      bool1 = true;
    }
    ac.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.xkZ != null) && (this.xbc))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(52028);
    com.tencent.mm.kernel.g.agi().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  final void dBi()
  {
    AppMethodBeat.i(52029);
    com.tencent.mm.kernel.g.agi().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52030);
    ac.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dBi();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.dgE, 2131762126, 2131755906, null);
      if (this.xkY != null) {
        this.xkY.s(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.xlh;
    if (b.ql(this.xbc))
    {
      paramString = b.xlh;
      if (b.b(paramInt1, paramn))
      {
        if (!this.xkW)
        {
          if (this.xkY != null) {
            this.xkY.s(7, null);
          }
          ac.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.xlh;
          b.a(new OfflineScanContext(this.dgE, 2, this.result, d.d.aFG(this.drB), this.dbY, this.drB, this.wZd, this.dcb), this.dgE.getString(2131762850), true);
          paramString = com.tencent.mm.plugin.scanner.model.l.wZe;
          paramString = this.drB;
          if (this.wZd) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.l.n(paramString, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.xlh;
        b.f(this.dgE, this.dgE.getString(2131762848));
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
      if (com.tencent.mm.kernel.g.agi().aBL())
      {
        com.tencent.mm.kernel.g.agi().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ae.cS(this.dgE)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hx(this.dgE);
        } else {
          Toast.makeText(this.dgE, this.dgE.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.dgE, this.dgE.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.l(this.dgE, 2131762118, 2131755906);
      if (this.xkY != null) {
        this.xkY.s(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramn.getType() == 1061)
    {
      paramString = (i)paramn;
      if ((paramString.rr != null) && (paramString.rr.hvs.hvw != null)) {}
      for (paramString = (nq)paramString.rr.hvs.hvw; paramString == null; paramString = null)
      {
        ac.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.xkY != null) {
          this.xkY.s(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      ac.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(paramString.ndI) });
      if (bs.isNullOrNil(paramString.Eci))
      {
        if (this.xkY != null) {
          this.xkY.s(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = paramString.ndI;
      paramString = paramString.Eci;
      Activity localActivity = this.dgE;
      String str = this.drB;
      paramInt2 = ((i)paramn).dbY;
      boolean bool1 = ((i)paramn).wYY;
      i = this.xbK;
      boolean bool2 = this.xkW;
      int j = this.xkX;
      boolean bool3 = this.xbc;
      if (bs.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          ac.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
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
        int k = k.arW(paramString);
        ac.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[] { Integer.valueOf(k) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!bs.isNullOrNil(paramString.username))) {
              break label902;
            }
            ac.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = bv.L(paramString, "user");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.c(bs.nullAsNil((String)paramString.get(".user.username")), bs.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label902:
          paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString.username);
          if ((paramn != null) && ((int)paramn.fLJ > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramn.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.g.iyx.c(paramString, localActivity);
            paramInt1 = 0;
            break label737;
          }
          new c().a(localActivity, paramString.username, 1, str, d.d.aFG(str), paramInt2, null, null, null, i, bool2, j, bool3);
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
            if ((paramString != null) && (!bs.isNullOrNil(paramString.link))) {
              break label1110;
            }
            ac.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = bv.L(paramString, "url");
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new k.b(bs.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1110:
          ac.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
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
          com.tencent.mm.plugin.scanner.g.iyx.i(paramn, localActivity);
          paramInt1 = 0;
          break label737;
        }
        if ((k == 3) || (k == 4))
        {
          ac.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
          paramn = new Intent();
          paramn.setClass(localActivity, ProductUI.class);
          paramn.setFlags(65536);
          paramn.putExtra("key_Product_xml", paramString);
          paramn.putExtra("key_Product_funcType", 4);
          paramn.putExtra("key_ProductUI_addToDB", true);
          paramn.putExtra("key_need_add_to_history", true);
          paramn.putExtra("key_is_from_barcode", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramString.aeD(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label737;
        }
        ac.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        ac.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label737;
        ac.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.xkY != null) {
          this.xkY.s(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        ac.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        ac.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.xkY != null) {
          this.xkY.s(2, null);
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.dgE, this.dgE.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.xkY != null) {
        this.xkY.s(2, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    AppMethodBeat.o(52030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */