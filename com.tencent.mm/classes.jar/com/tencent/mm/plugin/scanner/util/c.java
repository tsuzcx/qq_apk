package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.b;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rr.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.v.a.a.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.al.g, a.a
{
  public String appId;
  private int deB;
  private int deC;
  public String deF;
  public String imagePath;
  public Activity mActivity;
  public ProgressDialog mVv;
  public int niJ;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  private boolean vOH;
  private boolean vQv;
  private int vRb;
  private boolean vZQ;
  private int vZR;
  private com.tencent.mm.plugin.scanner.view.b vZT;
  private Timer vZU;
  private TimerTask vZV;
  private int wae;
  private String waf;
  private Bundle wag;
  com.tencent.mm.plugin.scanner.d.e.a wah;
  private Map<com.tencent.mm.al.n, Integer> wai;
  boolean waj;
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.vOH = false;
    this.vZR = -1;
    this.vQv = false;
    this.mVv = null;
    this.wah = null;
    this.vZT = null;
    this.wai = new HashMap();
    this.vZU = null;
    this.vZV = null;
    this.waj = false;
    ad.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.g.aeS().a(106, this);
    com.tencent.mm.kernel.g.aeS().a(233, this);
    com.tencent.mm.kernel.g.aeS().a(666, this);
    com.tencent.mm.kernel.g.aeS().a(372, this);
    com.tencent.mm.kernel.g.aeS().a(3512, this);
    AppMethodBeat.o(52043);
  }
  
  private static int JS(int paramInt)
  {
    if ((paramInt == 30) || (paramInt == 37) || (paramInt == 38) || (paramInt == 40)) {
      return 13;
    }
    if ((paramInt == 4) || (paramInt == 47)) {
      return 12;
    }
    if (paramInt == 34) {
      return 24;
    }
    return 0;
  }
  
  private static int Lr(int paramInt)
  {
    if (paramInt == 1) {
      return 34;
    }
    if (paramInt == 0) {
      return 4;
    }
    if (paramInt == 3) {
      return 42;
    }
    return 30;
  }
  
  private void Ls(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.wag != null)
    {
      localObject2 = this.wag.getString("stat_url");
      if (((this.sourceType == 6) || (this.sourceType == 0)) && (!bt.isNullOrNil((String)localObject2)))
      {
        localObject1 = "";
        localObject4 = "";
      }
    }
    try
    {
      localObject2 = URLEncoder.encode(bt.nullAsNil((String)localObject2), "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode(bt.nullAsNil(this.waf), "UTF-8");
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.QBarStringHandler", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
  }
  
  private void a(Activity paramActivity, int paramInt, final String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(52052);
    ad.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, paramInt, 5, paramBoolean);
      this.wai.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      paramString = new com.tencent.mm.plugin.scanner.view.b.a()
      {
        public final void dnb()
        {
          AppMethodBeat.i(195438);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          if (c.this.wah != null) {
            c.this.wah.r(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(195438);
        }
      };
      if (paramActivity == null) {
        break label127;
      }
      if ((!paramBoolean) || (!this.waj)) {
        break;
      }
      c(paramActivity.getString(2131762836), paramString);
      AppMethodBeat.o(52052);
      return;
    }
    a(paramActivity.getString(2131762836), paramString);
    label127:
    AppMethodBeat.o(52052);
  }
  
  private void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(52053);
    if (this.niJ > 0) {}
    for (int i = this.niJ;; i = Lr(this.wae))
    {
      ad.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.wae), Integer.valueOf(i) });
      final com.tencent.mm.modelsimple.k localk = new com.tencent.mm.modelsimple.k(paramString1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0]);
      if (paramString1.startsWith("http://weixin.qq.com/r/"))
      {
        String str = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = com.tencent.mm.ui.e.a.Xd(this.wae);
        localk.setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!bt.isNullOrNil(str))
        {
          paramString2 = y.arz().tB(str);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          localk.zb(paramString1);
          paramString2 = paramString1;
        }
        ad.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.wai.put(localk, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aeS().a(localk, 0);
      if (this.mVv != null) {
        this.mVv.dismiss();
      }
      a(paramActivity.getString(2131762131), new com.tencent.mm.plugin.scanner.view.b.a()
      {
        public final void dnb()
        {
          AppMethodBeat.i(52042);
          com.tencent.mm.kernel.g.aeS().a(localk);
          if (c.this.wah != null) {
            c.this.wah.r(1, null);
          }
          c.a(c.this, localk);
          AppMethodBeat.o(52042);
        }
      });
      AppMethodBeat.o(52053);
      return;
    }
  }
  
  private void a(String paramString, com.tencent.mm.plugin.scanner.view.b.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52044);
    boolean bool2 = this.vQv;
    if (this.vZT == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.vZT != null) && (this.vQv))
    {
      cancelLoading();
      this.vZU = new Timer();
      this.vZV = new h(this.vZT, new h.b()
      {
        public final void onShow()
        {
          c.this.waj = true;
        }
      }, parama);
      this.vZU.schedule(this.vZV, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean amM(String paramString)
  {
    AppMethodBeat.i(52049);
    if ((paramString.startsWith("weixin://wxpay/bizpayurl")) || (paramString.startsWith("https://wx.tenpay.com/f2f")) || (paramString.startsWith("wxp://f2f")) || (paramString.startsWith("wxhb://f2f")) || (paramString.startsWith("wxp://wbf2f")) || (paramString.startsWith("m")) || (paramString.startsWith("https://payapp.weixin.qq.com/qr/")) || (paramString.startsWith("n")))
    {
      AppMethodBeat.o(52049);
      return true;
    }
    AppMethodBeat.o(52049);
    return false;
  }
  
  private void b(String paramString, final com.tencent.mm.plugin.scanner.view.b.a parama)
  {
    AppMethodBeat.i(52047);
    if (this.mVv != null) {
      this.mVv.dismiss();
    }
    this.mVv = com.tencent.mm.ui.base.h.b(this.mActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.dnb();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void c(String paramString, com.tencent.mm.plugin.scanner.view.b.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.vQv;
    if (this.vZT == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.vZT == null) || (!this.vQv)) {
        break;
      }
      this.waj = true;
      this.vZT.a(true, false, parama);
      AppMethodBeat.o(52045);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52045);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52046);
    ad.i("MicroMsg.QBarStringHandler", "alvinluo cancelLoading");
    if (this.vZT != null) {
      this.vZT.a(false, false, null);
    }
    if ((this.mVv != null) && (this.mVv.isShowing())) {
      this.mVv.dismiss();
    }
    if (this.vZU != null) {
      this.vZU.cancel();
    }
    if (this.vZV != null) {
      this.vZV.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int ddf()
  {
    switch (this.wae)
    {
    case 0: 
    case 2: 
    default: 
      return 30;
    }
    return 45;
  }
  
  private void onPause()
  {
    AppMethodBeat.i(52051);
    ad.i("MicroMsg.QBarStringHandler", "onPause");
    com.tencent.mm.kernel.g.aeS().b(106, this);
    com.tencent.mm.kernel.g.aeS().b(233, this);
    com.tencent.mm.kernel.g.aeS().b(666, this);
    com.tencent.mm.kernel.g.aeS().b(372, this);
    com.tencent.mm.kernel.g.aeS().b(3512, this);
    AppMethodBeat.o(52051);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.d.e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(52048);
    ad.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.g.aeS().auR()), Boolean.valueOf(paramBoolean2) });
    this.mActivity = paramActivity;
    this.wae = paramInt1;
    this.waf = paramString1;
    this.deB = paramInt2;
    this.deC = paramInt3;
    this.typeName = paramString2;
    this.wah = parama;
    this.wag = paramBundle;
    this.vZQ = paramBoolean1;
    this.vRb = paramInt4;
    this.vQv = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.vOH = bool;
      this.vZR = paramInt5;
      this.vZT = paramb;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!bt.isNullOrNil(paramString1)) {
        break;
      }
      ad.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(52048);
      return;
    }
    if (com.tencent.mm.kernel.g.aeS().auR() == 0)
    {
      paramBoolean1 = ay.isConnected(this.mActivity);
      if (this.wah != null)
      {
        this.wah.r(0, null);
        this.wah.r(6, null);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.vZQ) {
          break label426;
        }
        paramString2 = b.wab;
        if (!b.pm(paramBoolean2)) {
          break label426;
        }
        ad.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        paramString2 = b.wab;
        paramString1 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.vOH, paramBundle);
        if (!paramBoolean1) {
          break label407;
        }
        paramActivity = this.mActivity.getString(2131762850);
        label362:
        b.a(paramString1, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.l.vOI;
        paramActivity = this.typeName;
        if (!this.vOH) {
          break label421;
        }
      }
      label407:
      label421:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.l.n(paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(52048);
        return;
        paramInt4 = 1;
        break;
        paramActivity = this.mActivity.getString(2131762853);
        break label362;
      }
      label426:
      if (this.vZQ)
      {
        paramString1 = b.wab;
        if (b.pm(paramBoolean2))
        {
          paramString1 = b.wab;
          if (paramBoolean1) {}
          for (paramString1 = this.mActivity.getString(2131762850);; paramString1 = this.mActivity.getString(2131762853))
          {
            b.f(paramActivity, paramString1);
            AppMethodBeat.o(52048);
            return;
          }
        }
      }
      Toast.makeText(paramActivity, paramActivity.getString(2131759511), 0).show();
      AppMethodBeat.o(52048);
      return;
    }
    parama = "";
    if (paramString1.startsWith("weixin://qr/")) {
      parama = paramString1.substring(12) + "@qr";
    }
    if (!bt.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(52048);
      return;
    }
    if (amM(paramString1))
    {
      ad.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = com.tencent.mm.plugin.scanner.model.l.vOI;
        parama = this.typeName;
        if (!this.vOH) {
          break label919;
        }
        paramInt1 = 2;
        com.tencent.mm.plugin.scanner.model.l.n(parama, paramInt1, 4, 0);
      }
    }
    ad.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (paramString1.startsWith("weixin://wxpay/bizpayurl"))
    {
      ad.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt1 = Lr(this.wae);
      paramInt2 = JS(paramInt1);
      paramActivity = new nw();
      paramActivity.dsV.url = paramString1;
      paramActivity.dsV.channel = paramInt2;
      paramActivity.dsV.scene = paramInt1;
      paramActivity.dsV.context = this.mActivity;
      if (paramInt2 == 13)
      {
        ad.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.dsV.source = this.source;
        paramActivity.dsV.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((c.this.mActivity == null) || (paramActivity.dsW == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dsW.ret == 1)
          {
            c.this.ok(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dsW.ret == 2) {
            c.this.ok(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      com.tencent.mm.sdk.b.a.ESL.a(paramActivity, Looper.myLooper());
      if ((((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY"))) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          new ap(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(52037);
              if ((c.this.wah != null) && ((paramActivity.dsW == null) || (paramActivity.dsW.ret != 1))) {
                c.this.wah.r(3, null);
              }
              AppMethodBeat.o(52037);
            }
          }, 10000L);
        }
        Ls(11);
        com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        label919:
        paramInt1 = 1;
        break;
      }
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt1 = JS(Lr(this.wae));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      if (this.wah != null) {
        this.wah.r(3, null);
      }
      Ls(11);
      com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt1 = JS(Lr(this.wae));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 6, paramString1, paramInt1, null);
      if (this.wah != null) {
        this.wah.r(3, null);
      }
      Ls(11);
      com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      ad.d("MicroMsg.QBarStringHandler", "go to reward");
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt2 = JS(Lr(this.wae));
      paramInt1 = 1;
      if (this.niJ == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, paramString1, paramInt2, paramString2, paramInt1);
        if (this.wah != null) {
          this.wah.r(3, null);
        }
        Ls(11);
        com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        if (this.niJ == 38) {
          paramInt1 = 3;
        } else if (this.niJ == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith("https://payapp.weixin.qq.com/qr/"))
    {
      ad.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt1 = JS(Lr(this.wae));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      if (this.wah != null) {
        this.wah.r(3, null);
      }
      Ls(11);
      com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      ad.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramInt1 = Lr(this.wae);
      paramInt2 = JS(paramInt1);
      paramActivity = new rr();
      paramActivity.dxk.dxm = paramString1;
      paramActivity.dxk.scene = paramInt1;
      paramActivity.dxk.type = 1;
      paramActivity.dxk.aLG = new WeakReference(this.mActivity);
      paramActivity.dxk.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52038);
          if (!bt.isNullOrNil(paramActivity.dxl.errMsg)) {
            if (c.this.mActivity != null) {
              Toast.makeText(c.this.mActivity, paramActivity.dxl.errMsg, 1).show();
            }
          }
          for (;;)
          {
            if (c.this.wah != null) {
              c.this.wah.r(3, null);
            }
            AppMethodBeat.o(52038);
            return;
            if (bt.isNullOrNil(paramActivity.dxl.dxn))
            {
              ad.w("MicroMsg.QBarStringHandler", "resp url is null!");
            }
            else if (paramActivity.dxl.actionType == 1)
            {
              com.tencent.mm.pluginsdk.wallet.f.a(c.this.mActivity, paramActivity.dxl.dxn, paramInt2, paramString2, paramInt1);
            }
            else
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramActivity.dxl.dxn);
              com.tencent.mm.plugin.scanner.f.hYt.i(localIntent, c.this.mActivity);
            }
          }
        }
      };
      com.tencent.mm.sdk.b.a.ESL.l(paramActivity);
      Ls(11);
      com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      ad.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(52048);
        return;
      }
      if (this.wah != null) {
        this.wah.r(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.bs.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.h.vKh.f(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      Ls(11);
      AppMethodBeat.o(52048);
      return;
    }
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.wah != null) {
      this.wah.r(5, null);
    }
    AppMethodBeat.o(52048);
  }
  
  public final void dnf()
  {
    AppMethodBeat.i(52050);
    ad.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.waf = null;
    this.mActivity = null;
    onPause();
    AppMethodBeat.o(52050);
  }
  
  public final Context getContext()
  {
    return this.mActivity;
  }
  
  public final void ok(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.wah != null)
      {
        this.wah.r(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else if (this.wah != null) {
      this.wah.r(3, null);
    }
    AppMethodBeat.o(52056);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(52054);
    ad.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramn == null)
    {
      if (paramn == null) {}
      for (bool = true;; bool = false)
      {
        ad.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.wah != null) {
          this.wah.r(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.wai.containsKey(paramn))
    {
      if ((paramn instanceof com.tencent.mm.ar.c)) {
        ad.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.wai.remove(paramn);
      cancelLoading();
      if ((paramn.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new com.tencent.mm.modelsimple.k(((com.tencent.mm.openim.b.n)paramn).hNP, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
      this.wai.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(52054);
      return;
    }
    ad.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
    AppMethodBeat.o(52054);
    return;
    label246:
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.mActivity, 2131762126, 2131755906, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(52031);
          if (c.this.wah != null) {
            c.this.wah.r(1, null);
          }
          AppMethodBeat.o(52031);
        }
      });
      AppMethodBeat.o(52054);
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
          ad.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.wah != null) {
            this.wah.r(7, null);
          }
          if (this.mActivity != null)
          {
            paramString = b.wab;
            b.a(new OfflineScanContext(this.mActivity, 2, this.waf, this.wae, this.deB, this.deC, this.typeName, this.vOH, this.wag), this.mActivity.getString(2131762850), true);
            paramString = com.tencent.mm.plugin.scanner.model.l.vOI;
            paramString = this.typeName;
            if (this.vOH) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              com.tencent.mm.plugin.scanner.model.l.n(paramString, paramInt1, 2, 0);
              AppMethodBeat.o(52054);
              return;
            }
          }
        }
        else
        {
          paramString = b.wab;
          b.f(this.mActivity, this.mActivity.getString(2131762848));
        }
        AppMethodBeat.o(52054);
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
      if (this.wah != null) {
        this.wah.r(1, null);
      }
      AppMethodBeat.o(52054);
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
        if (ae.cJ(this.mActivity)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hm(this.mActivity);
        } else {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.j(this.mActivity, 2131762118, 2131755906);
      if (this.wah != null) {
        this.wah.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.wah != null) {
        this.wah.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    paramString = b.wab;
    if ((b.n(paramn)) && (!this.vZQ))
    {
      paramString = com.tencent.mm.plugin.scanner.model.l.vOI;
      paramString = this.typeName;
      if (this.vOH)
      {
        i = 2;
        com.tencent.mm.plugin.scanner.model.l.n(paramString, i, 4, 0);
      }
    }
    else
    {
      if (paramn.getType() != 106) {
        break label1956;
      }
      paramString = (com.tencent.mm.plugin.messenger.a.g)paramn;
      if (paramString.txD) {
        break label1055;
      }
      paramString = paramString.cOA();
      if ((!com.tencent.mm.storage.af.Wy(paramString.DIV)) || (paramString.DJc == null) || (bt.isNullOrNil(paramString.DJc.ikb)) || (!com.tencent.mm.modelappbrand.a.uT(paramString.DJc.ikb))) {
        break label1055;
      }
      if (this.niJ <= 0) {
        break label1044;
      }
      paramInt1 = this.niJ;
      label909:
      ad.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.waf, Integer.valueOf(this.wae), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.k(this.waf, null, 43, 0, 0, new byte[0]);
      this.wai.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      if (this.mVv != null) {
        this.mVv.dismiss();
      }
      a(this.mActivity.getString(2131762131), new com.tencent.mm.plugin.scanner.view.b.a()
      {
        public final void dnb()
        {
          AppMethodBeat.i(52034);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          if (c.this.wah != null) {
            c.this.wah.r(1, null);
          }
          AppMethodBeat.o(52034);
        }
      });
    }
    label1044:
    label1055:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label1060;
      }
      AppMethodBeat.o(52054);
      return;
      i = 1;
      break;
      paramInt1 = Lr(this.wae);
      break label909;
    }
    label1060:
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.g)paramn).cOA();
    Object localObject2 = z.a(((cnl)localObject1).Dby);
    ad.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((cnl)localObject1).Dby);
    p.auq().h((String)localObject2, z.a(((cnl)localObject1).CxB));
    if ((this.mVv != null) && (this.mVv.isShowing()))
    {
      ad.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.mVv.dismiss();
    }
    cancelLoading();
    Object localObject3;
    Object localObject4;
    if (bt.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.n.b.ls(((au)localObject3).field_type)) && (((com.tencent.mm.storage.af)localObject3).eKB()))
      {
        paramString = com.tencent.mm.am.af.awe().wy((String)localObject2);
        paramString.bU(false);
        localObject4 = paramString.cIf;
        if (((c.b)localObject4).cIj != null) {
          ((c.b)localObject4).cIA = ((c.b)localObject4).cIj.optInt("ScanQRCodeType", 0);
        }
        if (((c.b)localObject4).cIA == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramString.Je())) {
            break label1403;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.f.hYt.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1931;
      }
      if (this.wah != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", z.a(((com.tencent.mm.plugin.messenger.a.g)paramn).cOA().Dby));
        paramString.putInt("geta8key_action_code", 4);
        this.wah.r(3, paramString);
      }
      Ls(4);
      AppMethodBeat.o(52054);
      return;
      paramInt1 = 0;
      break;
      label1403:
      paramInt1 = ddf();
      paramString = new Intent();
      com.tencent.mm.api.d.a(paramString, (cnl)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.n.b.ls(((au)localObject3).field_type))) {
        paramString.putExtra("Contact_IsLBSFriend", true);
      }
      if ((((cnl)localObject1).DIV & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (com.tencent.mm.storage.af.Wy(((cnl)localObject1).DIV))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            paramString.putExtra("qbarScene", this.wae);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!bt.isNullOrNil((String)localObject2))
            {
              Object localObject5 = y.arz().tB((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((y.b)localObject5).getString("preUsername", null);
                localObject3 = ((y.b)localObject5).getString("preChatName", null);
                localObject4 = ((y.b)localObject5).getString("url", null);
                String str = ((y.b)localObject5).getString("rawUrl", null);
                paramInt1 = ((y.b)localObject5).getInt("Contact_Sub_Scene", 0);
                paramInt2 = x.aw((String)localObject2, (String)localObject3);
                localObject5 = ((y.b)localObject5).getString("Contact_Scene_Note", null);
                paramString.putExtra("preUsername", (String)localObject2);
                paramString.putExtra("preChatName", (String)localObject3);
                paramString.putExtra("url", (String)localObject4);
                paramString.putExtra("rawUrl", str);
                paramString.putExtra("preChatTYPE", paramInt2);
                paramString.putExtra("Contact_Sub_Scene", paramInt1);
                paramString.putExtra("Contact_Scene_Note", (String)localObject5);
              }
            }
          }
        }
        if (this.wae != 0) {
          break label1851;
        }
        paramString.putExtra("Contact_Sub_Scene", 7);
        label1728:
        com.tencent.mm.plugin.scanner.f.hYt.c(paramString, this.mActivity);
        paramString = "";
        if (w.sE(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
        if (!com.tencent.mm.storage.af.Wy(((cnl)localObject1).DIV)) {
          break label1900;
        }
      }
      label1851:
      label1900:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).f(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.wae), this.imagePath, this.waf, bt.nullAsNil(this.deF), paramString });
        paramInt1 = 1;
        break;
        if (this.sourceType == 7)
        {
          paramString.putExtra("Contact_Sub_Scene", 4);
          break label1728;
        }
        if ((this.sourceType != 3) && (this.sourceType != 5)) {
          break label1728;
        }
        paramString.putExtra("Contact_Sub_Scene", 2);
        break label1728;
      }
      if (this.mActivity != null) {
        Toast.makeText(this.mActivity, 2131762876, 0).show();
      }
      paramInt1 = 0;
    }
    label1931:
    if (this.wah != null) {
      this.wah.r(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label1956:
    if (paramn.getType() == 372)
    {
      paramString = ((com.tencent.mm.openim.b.n)paramn).hNO;
      paramn = paramString.mAQ;
      ad.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramn)));
      cancelLoading();
      if (bt.nullAsNil(paramn).length() > 0)
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramn);
        paramInt1 = ddf();
        localObject1 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject1, paramString, paramInt1);
        if ((paramn != null) && (!com.tencent.mm.n.b.ls(paramn.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.f.hYt.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.h.vKh.f(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.wae), this.imagePath, this.waf, bt.nullAsNil(this.deF) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.wah != null)
        {
          paramn = new Bundle();
          paramn.putString("geta8key_fullurl", paramString.mAQ);
          paramn.putInt("geta8key_action_code", 4);
          this.wah.r(3, paramn);
        }
        Ls(4);
        AppMethodBeat.o(52054);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131762876, 0).show();
        }
      }
      if (this.wah != null) {
        this.wah.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 3512)
    {
      paramString = (ajk)((com.tencent.mm.al.b)paramn.getReqResp()).gUT.gUX;
      if (paramString.qMq.size() > 0)
      {
        paramn = new Intent();
        paramn.putExtra("finder_username", ((FinderContact)paramString.qMq.get(0)).username);
        paramn.putExtra("key_comment_scene", 10);
        paramn.putExtra("key_enter_profile_type", 3);
        ((j)com.tencent.mm.kernel.g.ad(j.class)).enterFinderProfileUI(this.mActivity, paramn);
        if (this.wah != null) {
          this.wah.r(3, null);
        }
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 233)
    {
      paramString = ((com.tencent.mm.modelsimple.k)paramn).aAq();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.k)paramn).aAs());
      Ls(((com.tencent.mm.modelsimple.k)paramn).aAs());
      if (this.niJ > 0) {}
      for (paramInt1 = this.niJ;; paramInt1 = Lr(this.wae))
      {
        ad.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.v.a.a.a(this, (com.tencent.mm.modelsimple.k)paramn, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(52032);
            if (c.this.wah != null) {
              c.this.wah.r(1, null);
            }
            AppMethodBeat.o(52032);
          }
        }, this.waf, paramInt1, this.wae, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52033);
            if (c.this.wah != null) {
              c.this.wah.r(3, null);
            }
            AppMethodBeat.o(52033);
          }
        }, this.wag);
        if ((bool) || (((com.tencent.mm.modelsimple.k)paramn).aAs() != 4)) {
          break;
        }
        a(this.mActivity, this.wae, paramString, true);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aAs() == 29))
      {
        paramn = this.mActivity;
        ad.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new com.tencent.mm.openim.b.n(paramString, (byte)0);
        this.wai.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        paramString = new com.tencent.mm.plugin.scanner.view.b.a()
        {
          public final void dnb()
          {
            AppMethodBeat.i(52040);
            com.tencent.mm.kernel.g.aeS().a(paramString);
            if (c.this.wah != null) {
              c.this.wah.r(1, null);
            }
            AppMethodBeat.o(52040);
          }
        };
        if (this.waj)
        {
          c(paramn.getString(2131762836), paramString);
          AppMethodBeat.o(52054);
          return;
        }
        a(paramn.getString(2131762836), paramString);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aAs() == 37))
      {
        if (((j)com.tencent.mm.kernel.g.ad(j.class)).showFinderEntry())
        {
          paramn = this.mActivity;
          ad.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { paramString });
          localObject1 = new ArrayList();
          ((List)localObject1).add(paramString);
          paramString = new com.tencent.mm.plugin.i.a.k((List)localObject1);
          this.wai.put(paramString, Integer.valueOf(1));
          com.tencent.mm.kernel.g.aeS().a(paramString, 0);
          paramn.getString(2131755906);
          this.mVv = com.tencent.mm.ui.base.h.c(paramn, paramn.getString(2131762836), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(195439);
              com.tencent.mm.kernel.g.aeS().a(paramString);
              if (c.this.wah != null) {
                c.this.wah.r(1, null);
              }
              AppMethodBeat.o(195439);
            }
          });
          AppMethodBeat.o(52054);
          return;
        }
        if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.prM, 0) != 0)
        {
          paramString = new Intent();
          paramString.putExtra("rawUrl", this.mActivity.getString(2131760810));
          com.tencent.mm.plugin.scanner.f.hYt.i(paramString, this.mActivity);
          AppMethodBeat.o(52054);
          return;
        }
        com.tencent.mm.bs.d.O(this.mActivity, "finder", ".ui.FinderUnOpenUI");
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aAs() == 41))
      {
        paramn = new Intent();
        paramn.putExtra("key_qrcode_string", paramString);
        com.tencent.mm.bs.d.b(this.mActivity, "account", ".friend.ui.RecoverAccountUI1", paramn);
        AppMethodBeat.o(52054);
        return;
      }
      ad.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.wah != null)) {
        this.wah.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof com.tencent.mm.ar.c))
        {
          paramString = ((com.tencent.mm.ar.c)paramn).axw().ProductID;
          ad.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramn = new Intent();
          paramn.putExtra("extra_id", paramString);
          paramn.putExtra("preceding_scence", 11);
          paramn.putExtra("download_entrance_scene", 14);
          com.tencent.mm.bs.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramn);
          ad.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          if (this.wah != null) {
            this.wah.r(3, null);
          }
          AppMethodBeat.o(52054);
        }
      }
      else {
        ad.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(52054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */