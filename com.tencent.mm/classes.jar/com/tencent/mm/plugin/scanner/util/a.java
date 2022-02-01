package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.scanner.g.f.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimerTask;

public final class a
  implements com.tencent.mm.am.h
{
  private boolean ORR;
  private boolean OVu = false;
  public int OXB;
  private ArrayList<Integer> OXX = null;
  private boolean PhN;
  private int PhO = -1;
  public boolean PhP = false;
  public f.a PhQ;
  private com.tencent.mm.plugin.scanner.view.c PhR;
  private com.tencent.threadpool.i.d<?> PhS = null;
  private TimerTask PhT = null;
  private int hDc;
  public Bundle hDf;
  public Activity hHU;
  private String hVL;
  public ProgressDialog lzP;
  private String result;
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(52024);
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo initLoadingTimer");
    cancelLoading();
    this.PhT = new k(this.PhR, new k.b()
    {
      public final void onShow() {}
    }, parama);
    this.PhS = com.tencent.threadpool.h.ahAA.p(this.PhT, 500L);
    AppMethodBeat.o(52024);
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52026);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    this.lzP = com.tencent.mm.ui.base.k.a(this.hHU, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52020);
        if (parama != null) {
          parama.gTH();
        }
        if (a.a(a.this) != null) {
          a.a(a.this).w(1, null);
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
    if (this.PhR != null) {
      this.PhR.a(false, false, null);
    }
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    if (this.PhS != null) {
      this.PhS.cancel(false);
    }
    if (this.PhT != null) {
      this.PhT.cancel();
    }
    AppMethodBeat.o(52025);
  }
  
  private void gTF()
  {
    AppMethodBeat.i(52029);
    com.tencent.mm.kernel.h.aZW().b(1061, this);
    AppMethodBeat.o(52029);
  }
  
  private rc gTG()
  {
    AppMethodBeat.i(314211);
    if (this.PhN)
    {
      Log.w("MicroMsg.BarcodeStringHandler", "getBizScanTabBarInfo  processOfflineScan is false, return null");
      AppMethodBeat.o(314211);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    if ((this.OXX != null) && (this.OXX.size() > 0)) {
      localLinkedList.addAll(this.OXX);
    }
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BarcodeStringHandler", "getBizScanTabBarInfo  hasTabBar:%s, tabBarTypeList:%s", new Object[] { Boolean.valueOf(bool), localLinkedList });
      rc localrc = new rc();
      localrc.YVV = bool;
      localrc.YVW = localLinkedList;
      AppMethodBeat.o(314211);
      return localrc;
    }
  }
  
  public final void a(Activity paramActivity, final f.a parama, com.tencent.mm.plugin.scanner.view.c paramc, String paramString1, boolean paramBoolean1, int paramInt1, String paramString2, Bundle paramBundle, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, boolean paramBoolean4, int paramInt4, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(314236);
    Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarCode result: %s, processOfflineScan: %b, selectFromAlbum: %b, codeName: %s, mode: %d, disableJumpScanGoods: %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), paramString2, Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean4) });
    this.hHU = paramActivity;
    int i = e.e.boP(paramString2);
    this.hDf = paramBundle;
    this.result = paramString1;
    this.hVL = paramString2;
    this.hDc = paramInt1;
    this.OXB = paramInt2;
    this.PhN = paramBoolean2;
    this.ORR = paramBoolean1;
    this.PhO = paramInt3;
    this.OVu = paramBoolean3;
    this.PhQ = parama;
    this.PhR = paramc;
    this.PhP = paramBoolean4;
    this.OXX = paramArrayList;
    if (com.tencent.mm.kernel.h.aZW().bFQ() == 0)
    {
      paramBoolean4 = NetStatusUtil.isConnected(paramActivity);
      if (paramBoolean4)
      {
        paramInt3 = 2;
        Log.i("MicroMsg.BarcodeStringHandler", "alvinluo handleBarcode network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean4) });
        if (paramBoolean2) {
          break label334;
        }
        paramc = b.PhX;
        if (!b.Cx(paramBoolean3)) {
          break label334;
        }
        if (parama != null)
        {
          if (!paramBoolean4) {
            break label310;
          }
          paramInt2 = 7;
          label219:
          parama.w(paramInt2, null);
        }
        parama = b.PhX;
        parama = new OfflineScanContext(paramActivity, paramInt3, paramString1, i, paramInt1, paramString2, paramBoolean1, paramBundle);
        if (!paramBoolean4) {
          break label317;
        }
        paramActivity = paramActivity.getString(l.i.OLl);
        label268:
        b.a(parama, paramActivity, false);
        paramActivity = w.ORS;
        if (!paramBoolean1) {
          break label328;
        }
      }
      label310:
      label317:
      label328:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        w.b(paramString1, paramString2, paramInt1, paramInt3, 0);
        AppMethodBeat.o(314236);
        return;
        paramInt3 = 1;
        break;
        paramInt2 = 6;
        break label219;
        paramActivity = paramActivity.getString(l.i.OLo);
        break label268;
      }
      label334:
      if (!paramBoolean2) {
        break label433;
      }
      parama = b.PhX;
      if (!b.Cx(paramBoolean3)) {
        break label433;
      }
      parama = b.PhX;
      b.n(paramActivity, paramActivity.getString(l.i.OLk));
    }
    for (;;)
    {
      gTE();
      parama = new t(paramString2, paramString1, paramInt1, paramInt4, paramInt2, gTG());
      parama.ORN = paramBoolean1;
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      a(paramActivity.getString(l.i.OKM), new c.a()
      {
        public final void gTH()
        {
          AppMethodBeat.i(52022);
          a.b(a.this);
          com.tencent.mm.kernel.h.aZW().a(parama);
          AppMethodBeat.o(52022);
        }
      });
      AppMethodBeat.o(314236);
      return;
      label433:
      Toast.makeText(paramActivity, paramActivity.getString(l.i.fmt_iap_err), 0).show();
    }
  }
  
  public final void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52023);
    boolean bool2 = this.OVu;
    if (this.PhR == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.BarcodeStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.PhR != null) && (this.OVu))
    {
      a(parama);
      AppMethodBeat.o(52023);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52023);
  }
  
  public final void gTE()
  {
    AppMethodBeat.i(52028);
    com.tencent.mm.kernel.h.aZW().a(1061, this);
    AppMethodBeat.o(52028);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(52030);
    Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    gTF();
    cancelLoading();
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.k.a(this.hHU, l.i.OKK, l.i.app_tip, null);
      if (this.PhQ != null) {
        this.PhQ.w(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    paramString = b.PhX;
    if (b.Cx(this.OVu))
    {
      paramString = b.PhX;
      if (b.b(paramInt1, paramp))
      {
        if (!this.PhN)
        {
          if (this.PhQ != null) {
            this.PhQ.w(7, null);
          }
          Log.i("MicroMsg.BarcodeStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = b.PhX;
          b.a(new OfflineScanContext(this.hHU, 2, this.result, e.e.boP(this.hVL), this.hDc, this.hVL, this.ORR, this.hDf), this.hHU.getString(l.i.OLl), true);
          paramString = w.ORS;
          paramString = this.result;
          paramp = this.hVL;
          if (this.ORR) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            w.b(paramString, paramp, paramInt1, 2, 0);
            AppMethodBeat.o(52030);
            return;
          }
        }
        paramString = b.PhX;
        b.n(this.hHU, this.hHU.getString(l.i.OLk));
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
      if (com.tencent.mm.kernel.h.aZW().bFR())
      {
        com.tencent.mm.kernel.h.aZW().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ah.eb(this.hHU)) {
          com.tencent.mm.pluginsdk.ui.tools.m.lE(this.hHU);
        } else {
          Toast.makeText(this.hHU, this.hHU.getString(l.i.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.hHU, this.hHU.getString(l.i.fmt_iap_err), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.k.s(this.hHU, l.i.qrcode_ban_by_expose, l.i.app_tip);
      if (this.PhQ != null) {
        this.PhQ.w(5, null);
      }
      AppMethodBeat.o(52030);
      return;
    }
    if (paramp.getType() == 1061)
    {
      paramString = (t)paramp;
      if ((paramString.rr != null) && (c.c.b(paramString.rr.otC) != null)) {}
      for (qz localqz = (qz)c.c.b(paramString.rr.otC); localqz == null; localqz = null)
      {
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
        if (this.PhQ != null) {
          this.PhQ.w(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      Log.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[] { Integer.valueOf(localqz.vhJ) });
      if (Util.isNullOrNil(localqz.YTf))
      {
        if (this.PhQ != null) {
          this.PhQ.w(2, null);
        }
        AppMethodBeat.o(52030);
        return;
      }
      paramInt1 = localqz.vhJ;
      paramString = localqz.YTf;
      Activity localActivity = this.hHU;
      String str = this.hVL;
      paramInt2 = ((t)paramp).hDc;
      boolean bool1 = ((t)paramp).ORN;
      i = this.OXB;
      boolean bool2 = this.PhN;
      int j = this.PhO;
      boolean bool3 = this.OVu;
      boolean bool4 = this.PhP;
      if (Util.isNullOrNil(paramString)) {
        if (paramString == null)
        {
          bool1 = true;
          Log.e("MicroMsg.Scanner.ScanXmlHelper", "wrong args, xml == null ? [%s]", new Object[] { Boolean.valueOf(bool1) });
          paramInt1 = 2;
          label759:
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
        int k = q.aVj(paramString);
        Log.i("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s], respType: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt1) });
        if (k == 1)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!Util.isNullOrNil(paramString.username))) {
              break label942;
            }
            Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
            paramInt1 = 2;
            break;
            paramString = XmlParser.parseXml(paramString, "user", null);
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new q.c(Util.nullAsNil((String)paramString.get(".user.username")), Util.nullAsNil((String)paramString.get(".user.nickname")));
            }
          }
          label942:
          paramp = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString.username);
          if ((paramp != null) && ((int)paramp.maN > 0))
          {
            paramString = new Intent();
            paramString.putExtra("Contact_User", paramp.field_username);
            paramString.setFlags(65536);
            com.tencent.mm.plugin.scanner.m.dFc().c(paramString, localActivity);
            paramInt1 = 0;
            break label759;
          }
          new c().a(localActivity, paramString.username, 1, str, e.e.boP(str), paramInt2, null, i, bool2, j, bool3);
          paramInt1 = 1;
          break label759;
        }
        if (k == 2)
        {
          if (paramString == null) {
            paramString = null;
          }
          for (;;)
          {
            if ((paramString != null) && (!Util.isNullOrNil(paramString.link))) {
              break label1149;
            }
            Log.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
            paramInt1 = 2;
            break;
            paramString = XmlParser.parseXml(paramString, "url", null);
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = new q.b(Util.nullAsNil((String)paramString.get(".url.link")));
            }
          }
          label1149:
          Log.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[] { paramString.link });
          if (paramInt1 == 5)
          {
            paramString = paramString.link;
            paramp = (u)com.tencent.mm.kernel.h.ax(u.class);
            if (bool1) {}
            for (paramInt1 = 1032;; paramInt1 = 1025)
            {
              paramp.b(localActivity, paramString, paramInt1, null, null);
              paramInt1 = 0;
              break;
            }
          }
          if (paramInt1 == 6)
          {
            if (bool4)
            {
              paramInt1 = 4;
              break label759;
            }
            paramInt1 = 3;
            break label759;
          }
          paramp = new Intent();
          paramp.putExtra("rawUrl", paramString.link);
          paramp.setFlags(65536);
          com.tencent.mm.plugin.scanner.m.dFc().h(paramp, localActivity);
          paramInt1 = 0;
          break label759;
        }
        if ((k == 3) || (k == 4))
        {
          Log.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[] { Integer.valueOf(4), Boolean.TRUE });
          paramp = new Intent();
          paramp.setClass(localActivity, ProductUI.class);
          paramp.setFlags(65536);
          paramp.putExtra("key_Product_xml", paramString);
          paramp.putExtra("key_Product_funcType", 4);
          paramp.putExtra("key_ProductUI_addToDB", true);
          paramp.putExtra("key_need_add_to_history", true);
          paramp.putExtra("key_is_from_barcode", true);
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramString.aYi(), "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localActivity.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/scanner/util/ScanXmlHelper", "processReturnXmlProduct", "(ILjava/lang/String;Landroid/app/Activity;IZLcom/tencent/mm/plugin/scanner/result/ResultHandler$IResultHandleCallback;Ljava/lang/String;IZIZIZZ)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramInt1 = 0;
          break label759;
        }
        Log.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
        Log.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[] { paramString });
        paramInt1 = 2;
        break label759;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
        if (this.PhQ != null) {
          this.PhQ.w(3, null);
        }
        AppMethodBeat.o(52030);
        return;
        Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
        AppMethodBeat.o(52030);
        return;
        Log.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
        if (this.PhQ != null)
        {
          this.PhQ.w(2, null);
          AppMethodBeat.o(52030);
          return;
          Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_JUMP_SCAN_GOODS");
          paramString = new Bundle();
          try
          {
            paramString.putByteArray("key_scan_bar_code_response", localqz.toByteArray());
            if (this.PhQ == null) {
              continue;
            }
            this.PhQ.w(8, paramString);
            AppMethodBeat.o(52030);
            return;
          }
          catch (Exception paramp)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BarcodeStringHandler", paramp, "onSceneEnd BizScanBarcodeResponse toByteArray exception", new Object[0]);
            }
          }
          Log.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SCAN_GOODS_MERGE");
          paramString = new Bundle();
          try
          {
            paramString.putByteArray("key_scan_bar_code_response", localqz.toByteArray());
            paramString.putString("key_scan_bar_code_string", this.result);
            if (this.PhQ != null) {
              this.PhQ.w(9, paramString);
            }
          }
          catch (Exception paramp)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.BarcodeStringHandler", paramp, "onSceneEnd BizScanBarcodeResponse toByteArray exception", new Object[0]);
            }
          }
        }
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.hHU, this.hHU.getString(l.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.PhQ != null) {
        this.PhQ.w(2, null);
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