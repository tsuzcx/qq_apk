package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.f.e.a;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bv;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class a
  implements com.tencent.mm.ak.i
{
  private boolean CFK;
  private boolean CIS = false;
  public int CJz;
  private boolean CSX;
  private int CSY = -1;
  public e.a CSZ;
  private com.tencent.mm.plugin.scanner.view.c CTa;
  private Timer CTb = null;
  private TimerTask CTc = null;
  private int dFM;
  public Bundle dFP;
  public Activity dKq;
  private String dWl;
  public ProgressDialog gtM;
  private String result;
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(52024);
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.CTb = new Timer();
    this.CTc = new i(this.CTa, new i.b()
    {
      public final void onShow() {}
    }, parama);
    this.CTb.schedule(this.CTc, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    this.gtM = com.tencent.mm.ui.base.h.a(this.dKq, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.eRN();
        }
        if (a.this.CSZ != null) {
          a.this.CSZ.r(1, null);
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
    if (this.CTa != null) {
      this.CTa.a(false, false, null);
    }
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    if (this.CTb != null) {
      this.CTb.cancel();
    }
    if (this.CTc != null) {
      this.CTc.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  public final void a(Activity paramActivity, final e.a parama, com.tencent.mm.plugin.scanner.view.c paramc, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    AppMethodBeat.i(240805);
    Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode result: %s, processOfflineScan: %b, selectFromAlbum: %b, codeName: %s, mode: %d", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), paramString2, Integer.valueOf(paramInt4) });
    this.dKq = paramActivity;
    int i = e.d.bcV(paramString2);
    this.dFP = paramBundle;
    this.result = paramString1;
    this.dWl = paramString2;
    this.dFM = paramInt1;
    this.CJz = paramInt2;
    this.CSX = paramBoolean2;
    this.CFK = paramBoolean1;
    this.CSY = paramInt3;
    this.CIS = paramBoolean3;
    this.CSZ = parama;
    this.CTa = paramc;
    if (g.azz().aYS() == 0)
    {
      boolean bool = NetStatusUtil.isConnected(paramActivity);
      if (bool)
      {
        paramInt3 = 2;
        Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(bool) });
        if (paramBoolean2) {
          break label311;
        }
        paramc = b.CTi;
        if (!b.uk(paramBoolean3)) {
          break label311;
        }
        if (parama != null)
        {
          if (!bool) {
            break label288;
          }
          paramInt2 = 7;
          label198:
          parama.r(paramInt2, null);
        }
        parama = b.CTi;
        parama = new OfflineScanContext(paramActivity, paramInt3, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!bool) {
          break label295;
        }
        paramActivity = paramActivity.getString(2131764957);
        label246:
        b.a(parama, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.q.CFL;
        if (!paramBoolean1) {
          break label305;
        }
      }
      label288:
      label295:
      label305:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.q.b(paramString1, paramString2, paramInt1, paramInt3, 0);
        AppMethodBeat.o(240805);
        return;
        paramInt3 = 1;
        break;
        paramInt2 = 6;
        break label198;
        paramActivity = paramActivity.getString(2131764960);
        break label246;
      }
      label311:
      if (!paramBoolean2) {
        break label404;
      }
      parama = b.CTi;
      if (!b.uk(paramBoolean3)) {
        break label404;
      }
      parama = b.CTi;
      b.k(paramActivity, paramActivity.getString(2131764955));
    }
    for (;;)
    {
      eRL();
      parama = new com.tencent.mm.plugin.scanner.model.n(paramString2, paramString1, paramInt1, paramInt4, paramInt2);
      parama.CFF = paramBoolean1;
      g.azz().a(parama, 0);
      a(paramActivity.getString(2131764152), new c.a()
      {
        public final void eRN()
        {
          AppMethodBeat.i(52022);
          a.this.eRM();
          g.azz().a(parama);
          AppMethodBeat.o(52022);
        }
      });
      AppMethodBeat.o(240805);
      return;
      label404:
      Toast.makeText(paramActivity, paramActivity.getString(2131760826), 0).show();
    }
  }
  
  public final void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52023);
    boolean bool2 = this.CIS;
    if (this.CTa == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.CTa != null) && (this.CIS))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void eRL()
  {
    AppMethodBeat.i(52028);
    g.azz().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  final void eRM()
  {
    AppMethodBeat.i(52029);
    g.azz().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(52030);
    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eRM();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.dKq, 2131764147, 2131755998, null);
      if (this.CSZ != null) {
        this.CSZ.r(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.CTi;
    if (b.uk(this.CIS))
    {
      paramString = b.CTi;
      if (b.b(paramInt1, paramq))
      {
        if (!this.CSX)
        {
          if (this.CSZ != null) {
            this.CSZ.r(7, null);
          }
          Log.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.CTi;
          b.a(new OfflineScanContext(this.dKq, 2, this.result, e.d.bcV(this.dWl), this.dFM, this.dWl, this.CFK, this.dFP), this.dKq.getString(2131764957), true);
          paramString = com.tencent.mm.plugin.scanner.model.q.CFL;
          paramString = this.result;
          paramq = this.dWl;
          if (this.CFK) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.q.b(paramString, paramq, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.CTi;
        b.k(this.dKq, this.dKq.getString(2131764955));
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
      if (g.azz().aYT())
      {
        g.azz().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ag.dm(this.dKq)) {
          com.tencent.mm.pluginsdk.ui.tools.m.iC(this.dKq);
        } else {
          Toast.makeText(this.dKq, this.dKq.getString(2131760825, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.dKq, this.dKq.getString(2131760826), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.n(this.dKq, 2131764139, 2131755998);
      if (this.CSZ != null) {
        this.CSZ.r(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramq.getType() == 1061)
    {
      paramString = (com.tencent.mm.plugin.scanner.model.n)paramq;
      if ((paramString.rr != null) && (paramString.rr.iLL.iLR != null)) {}
      for (pu localpu = (pu)paramString.rr.iLL.iLR; localpu == null; localpu = null)
      {
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.CSZ != null) {
          this.CSZ.r(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      Log.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(localpu.oUv) });
      if (Util.isNullOrNil(localpu.KUw))
      {
        if (this.CSZ != null) {
          this.CSZ.r(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = localpu.oUv;
      paramString = localpu.KUw;
      Activity localActivity = this.dKq;
      String str = this.dWl;
      paramInt2 = ((com.tencent.mm.plugin.scanner.model.n)paramq).dFM;
      boolean bool1 = ((com.tencent.mm.plugin.scanner.model.n)paramq).CFF;
      i = this.CJz;
      boolean bool2 = this.CSX;
      int j = this.CSY;
      boolean bool3 = this.CIS;
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
        int k = n.aMS(paramString);
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
              paramString = new n.c(Util.nullAsNil((String)paramString.get(".user.username")), Util.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label930:
          paramq = ((l)g.af(l.class)).aSN().Kn(paramString.username);
          if ((paramq != null) && ((int)paramq.gMZ > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramq.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.h.jRt.c(paramString, localActivity);
            paramInt1 = 0;
            break label753;
          }
          new c().a(localActivity, paramString.username, 1, str, e.d.bcV(str), paramInt2, null, null, null, i, bool2, j, bool3);
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
              break label1139;
            }
            Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = XmlParser.parseXml(paramString, "url", null);
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new n.b(Util.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1139:
          Log.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramq = (s)g.af(s.class);
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
          com.tencent.mm.plugin.scanner.h.jRt.i(paramq, localActivity);
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
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, paramString.axQ(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label753;
        }
        Log.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        Log.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label753;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.CSZ != null) {
          this.CSZ.r(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.CSZ != null)
        {
          this.CSZ.r(2, null);
          AppMethodBeat.o(52030);
          return;
          Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_JUMP_SCAN_GOODS");
          paramString = new Bundle();
          try
          {
            paramString.putByteArray("key_scan_bar_code_response", localpu.toByteArray());
            if (this.CSZ != null) {
              this.CSZ.r(8, paramString);
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
      Toast.makeText(this.dKq, this.dKq.getString(2131760877, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.CSZ != null) {
        this.CSZ.r(2, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    AppMethodBeat.o(52030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.a
 * JD-Core Version:    0.7.0.1
 */