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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oo.b;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.i.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  implements com.tencent.mm.al.f, a.a
{
  public String appId;
  private int dnt;
  private int dnu;
  public String dnw;
  public String imagePath;
  public Activity mActivity;
  public ProgressDialog nZt;
  public int ooi;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  private boolean ymW;
  private int ypM;
  private boolean ypb;
  private boolean yyY;
  private int yyZ;
  private com.tencent.mm.plugin.scanner.view.b yzb;
  private Timer yzc;
  private TimerTask yzd;
  private int yzm;
  private String yzn;
  private Bundle yzo;
  com.tencent.mm.plugin.scanner.d.e.a yzp;
  private Map<com.tencent.mm.al.n, Integer> yzq;
  boolean yzr;
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.ymW = false;
    this.yyZ = -1;
    this.ypb = false;
    this.nZt = null;
    this.yzp = null;
    this.yzb = null;
    this.yzq = new HashMap();
    this.yzc = null;
    this.yzd = null;
    this.yzr = false;
    ad.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.g.aiU().a(106, this);
    com.tencent.mm.kernel.g.aiU().a(233, this);
    com.tencent.mm.kernel.g.aiU().a(666, this);
    com.tencent.mm.kernel.g.aiU().a(372, this);
    com.tencent.mm.kernel.g.aiU().a(3512, this);
    AppMethodBeat.o(52043);
  }
  
  private static int Nq(int paramInt)
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
  
  private static int OT(int paramInt)
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
  
  private void OU(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.yzo != null)
    {
      localObject2 = this.yzo.getString("stat_url");
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
      String str = URLEncoder.encode(bt.nullAsNil(this.yzn), "UTF-8");
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
    com.tencent.mm.plugin.report.service.g.yhR.f(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
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
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, paramInt, 5, paramBoolean);
      this.yzq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aiU().a(paramString, 0);
      paramString = new b.a()
      {
        public final void dMH()
        {
          AppMethodBeat.i(186233);
          com.tencent.mm.kernel.g.aiU().a(paramString);
          if (c.this.yzp != null) {
            c.this.yzp.t(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(186233);
        }
      };
      if (paramActivity == null) {
        break label127;
      }
      if ((!paramBoolean) || (!this.yzr)) {
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
    if (this.ooi > 0) {}
    for (int i = this.ooi;; i = OT(this.yzm))
    {
      ad.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.yzm), Integer.valueOf(i) });
      final com.tencent.mm.modelsimple.k localk = new com.tencent.mm.modelsimple.k(paramString1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0]);
      if (paramString1.startsWith("http://weixin.qq.com/r/"))
      {
        String str = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = com.tencent.mm.ui.e.a.abw(this.yzm);
        localk.setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!bt.isNullOrNil(str))
        {
          paramString2 = y.aBq().AF(str);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          localk.Gl(paramString1);
          paramString2 = paramString1;
        }
        ad.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.yzq.put(localk, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aiU().a(localk, 0);
      if (this.nZt != null) {
        this.nZt.dismiss();
      }
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dMH()
        {
          AppMethodBeat.i(52042);
          com.tencent.mm.kernel.g.aiU().a(localk);
          if (c.this.yzp != null) {
            c.this.yzp.t(1, null);
          }
          c.a(c.this, localk);
          AppMethodBeat.o(52042);
        }
      });
      AppMethodBeat.o(52053);
      return;
    }
  }
  
  private void a(String paramString, b.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52044);
    boolean bool2 = this.ypb;
    if (this.yzb == null) {
      bool1 = true;
    }
    ad.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.yzb != null) && (this.ypb))
    {
      cancelLoading();
      this.yzc = new Timer();
      this.yzd = new h(this.yzb, new h.b()
      {
        public final void onShow()
        {
          c.this.yzr = true;
        }
      }, parama);
      this.yzc.schedule(this.yzd, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean awW(String paramString)
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
  
  private void b(String paramString, final b.a parama)
  {
    AppMethodBeat.i(52047);
    if (this.nZt != null) {
      this.nZt.dismiss();
    }
    this.nZt = com.tencent.mm.ui.base.h.b(this.mActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.dMH();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void c(String paramString, b.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.ypb;
    if (this.yzb == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.yzb == null) || (!this.ypb)) {
        break;
      }
      this.yzr = true;
      this.yzb.a(true, false, parama);
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
    if (this.yzb != null) {
      this.yzb.a(false, false, null);
    }
    if ((this.nZt != null) && (this.nZt.isShowing())) {
      this.nZt.dismiss();
    }
    if (this.yzc != null) {
      this.yzc.cancel();
    }
    if (this.yzd != null) {
      this.yzd.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int dBq()
  {
    switch (this.yzm)
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
    com.tencent.mm.kernel.g.aiU().b(106, this);
    com.tencent.mm.kernel.g.aiU().b(233, this);
    com.tencent.mm.kernel.g.aiU().b(666, this);
    com.tencent.mm.kernel.g.aiU().b(372, this);
    com.tencent.mm.kernel.g.aiU().b(3512, this);
    AppMethodBeat.o(52051);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.d.e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(52048);
    ad.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.g.aiU().aEN()), Boolean.valueOf(paramBoolean2) });
    this.mActivity = paramActivity;
    this.yzm = paramInt1;
    this.yzn = paramString1;
    this.dnt = paramInt2;
    this.dnu = paramInt3;
    this.typeName = paramString2;
    this.yzp = parama;
    this.yzo = paramBundle;
    this.yyY = paramBoolean1;
    this.ypM = paramInt4;
    this.ypb = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ymW = bool;
      this.yyZ = paramInt5;
      this.yzb = paramb;
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
    if (com.tencent.mm.kernel.g.aiU().aEN() == 0)
    {
      paramBoolean1 = ay.isConnected(this.mActivity);
      if (this.yzp != null)
      {
        paramString2 = null;
        if (awW(paramString1))
        {
          paramString2 = new Bundle();
          paramString2.putBoolean("key_offline_scan_show_tips", false);
        }
        this.yzp.t(0, paramString2);
        this.yzp.t(6, paramString2);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.yyY) {
          break label466;
        }
        paramString2 = b.yzj;
        if (!b.qK(paramBoolean2)) {
          break label466;
        }
        ad.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!awW(paramString1))
        {
          paramString2 = b.yzj;
          paramString2 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.ymW, paramBundle);
          if (!paramBoolean1) {
            break label447;
          }
          paramActivity = this.mActivity.getString(2131762850);
          label400:
          b.a(paramString2, paramActivity, false);
        }
        paramActivity = com.tencent.mm.plugin.scanner.model.n.ymX;
        paramActivity = this.typeName;
        if (!this.ymW) {
          break label461;
        }
      }
      label447:
      label461:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.n.d(paramString1, paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(52048);
        return;
        paramInt4 = 1;
        break;
        paramActivity = this.mActivity.getString(2131762853);
        break label400;
      }
      label466:
      if (this.yyY)
      {
        paramString1 = b.yzj;
        if (b.qK(paramBoolean2))
        {
          paramString1 = b.yzj;
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
    if (awW(paramString1))
    {
      ad.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = b.yzj;
        if (b.qK(paramBoolean2))
        {
          parama = com.tencent.mm.plugin.scanner.model.n.ymX;
          parama = this.typeName;
          if (!this.ymW) {
            break label973;
          }
          paramInt1 = 2;
          com.tencent.mm.plugin.scanner.model.n.d(paramString1, parama, paramInt1, 4, 0);
        }
      }
    }
    ad.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (paramString1.startsWith("weixin://wxpay/bizpayurl"))
    {
      ad.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt1 = OT(this.yzm);
      paramInt2 = Nq(paramInt1);
      paramActivity = new oo();
      paramActivity.dCw.url = paramString1;
      paramActivity.dCw.channel = paramInt2;
      paramActivity.dCw.scene = paramInt1;
      paramActivity.dCw.context = this.mActivity;
      if (paramInt2 == 13)
      {
        ad.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.dCw.source = this.source;
        paramActivity.dCw.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((c.this.mActivity == null) || (paramActivity.dCx == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dCx.ret == 1)
          {
            c.this.pB(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dCx.ret == 2) {
            c.this.pB(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      com.tencent.mm.sdk.b.a.IbL.a(paramActivity, Looper.myLooper());
      if ((((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY"))) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          new ap(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(52037);
              if ((c.this.yzp != null) && ((paramActivity.dCx == null) || (paramActivity.dCx.ret != 1))) {
                c.this.a(false, null);
              }
              AppMethodBeat.o(52037);
            }
          }, 10000L);
        }
        OU(11);
        com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        label973:
        paramInt1 = 1;
        break;
      }
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt1 = Nq(OT(this.yzm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      a(true, null);
      OU(11);
      com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt1 = Nq(OT(this.yzm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 6, paramString1, paramInt1, null);
      a(true, null);
      OU(11);
      com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      ad.d("MicroMsg.QBarStringHandler", "go to reward");
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt2 = Nq(OT(this.yzm));
      paramInt1 = 1;
      if (this.ooi == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, paramString1, paramInt2, paramString2, paramInt1);
        a(true, null);
        OU(11);
        com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        if (this.ooi == 38) {
          paramInt1 = 3;
        } else if (this.ooi == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith("https://payapp.weixin.qq.com/qr/"))
    {
      ad.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt1 = Nq(OT(this.yzm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      a(true, null);
      OU(11);
      com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      ad.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramInt1 = OT(this.yzm);
      paramInt2 = Nq(paramInt1);
      paramActivity = new sm();
      paramActivity.dGY.dHa = paramString1;
      paramActivity.dGY.scene = paramInt1;
      paramActivity.dGY.type = 1;
      paramActivity.dGY.aWN = new WeakReference(this.mActivity);
      paramActivity.dGY.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52038);
          if (!bt.isNullOrNil(paramActivity.dGZ.errMsg))
          {
            if (c.this.mActivity != null) {
              Toast.makeText(c.this.mActivity, paramActivity.dGZ.errMsg, 1).show();
            }
            c.this.a(false, null);
            AppMethodBeat.o(52038);
            return;
          }
          if (bt.isNullOrNil(paramActivity.dGZ.dHb))
          {
            ad.w("MicroMsg.QBarStringHandler", "resp url is null!");
            c.this.a(false, null);
            AppMethodBeat.o(52038);
            return;
          }
          if (paramActivity.dGZ.actionType == 1)
          {
            com.tencent.mm.pluginsdk.wallet.f.a(c.this.mActivity, paramActivity.dGZ.dHb, paramInt2, paramString2, paramInt1);
            c.this.a(true, null);
            AppMethodBeat.o(52038);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramActivity.dGZ.dHb);
          com.tencent.mm.plugin.scanner.g.iRG.i(localIntent, c.this.mActivity);
          c.this.a(true, null);
          AppMethodBeat.o(52038);
        }
      };
      com.tencent.mm.sdk.b.a.IbL.l(paramActivity);
      OU(11);
      com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
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
      if (this.yzp != null) {
        this.yzp.t(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.bs.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.g.yhR.f(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      OU(11);
      AppMethodBeat.o(52048);
      return;
    }
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.yzp != null) {
      this.yzp.t(5, null);
    }
    AppMethodBeat.o(52048);
  }
  
  final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(186235);
    if (this.yzp != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("key_scan_qr_code_result", paramBoolean);
      this.yzp.t(3, localBundle);
    }
    AppMethodBeat.o(186235);
  }
  
  public final void dML()
  {
    AppMethodBeat.i(52050);
    ad.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.yzn = null;
    this.mActivity = null;
    onPause();
    AppMethodBeat.o(52050);
  }
  
  public final Context getContext()
  {
    return this.mActivity;
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
        if (this.yzp != null) {
          this.yzp.t(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.yzq.containsKey(paramn))
    {
      if ((paramn instanceof com.tencent.mm.ar.c)) {
        ad.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.yzq.remove(paramn);
      cancelLoading();
      if ((paramn.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new com.tencent.mm.modelsimple.k(((com.tencent.mm.openim.b.n)paramn).iHI, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(paramString, 0);
      this.yzq.put(paramString, Integer.valueOf(1));
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
          if (c.this.yzp != null) {
            c.this.yzp.t(1, null);
          }
          AppMethodBeat.o(52031);
        }
      });
      AppMethodBeat.o(52054);
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
          ad.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.yzp != null) {
            this.yzp.t(7, null);
          }
          if (this.mActivity != null)
          {
            paramString = b.yzj;
            b.a(new OfflineScanContext(this.mActivity, 2, this.yzn, this.yzm, this.dnt, this.dnu, this.typeName, this.ymW, this.yzo), this.mActivity.getString(2131762850), true);
            paramString = com.tencent.mm.plugin.scanner.model.n.ymX;
            paramString = this.yzn;
            paramn = this.typeName;
            if (this.ymW) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              com.tencent.mm.plugin.scanner.model.n.d(paramString, paramn, paramInt1, 2, 0);
              AppMethodBeat.o(52054);
              return;
            }
          }
        }
        else
        {
          paramString = b.yzj;
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
      if (this.yzp != null) {
        this.yzp.t(0, null);
      }
      AppMethodBeat.o(52054);
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
        if (ae.cP(this.mActivity)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hC(this.mActivity);
        } else {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759511), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.l(this.mActivity, 2131762118, 2131755906);
      if (this.yzp != null) {
        this.yzp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.yzp != null) {
        this.yzp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    paramString = b.yzj;
    if ((b.m(paramn)) && (!this.yyY))
    {
      paramString = com.tencent.mm.plugin.scanner.model.n.ymX;
      paramString = this.yzn;
      localObject1 = this.typeName;
      if (this.ymW)
      {
        i = 2;
        com.tencent.mm.plugin.scanner.model.n.d(paramString, (String)localObject1, i, 4, 0);
      }
    }
    else
    {
      if (paramn.getType() != 106) {
        break label1967;
      }
      paramString = (com.tencent.mm.plugin.messenger.a.f)paramn;
      if (paramString.vJe) {
        break label1071;
      }
      paramString = paramString.dlC();
      if ((!am.aaR(paramString.GNU)) || (paramString.GOb == null) || (bt.isNullOrNil(paramString.GOb.jdr)) || (!com.tencent.mm.modelappbrand.a.BY(paramString.GOb.jdr))) {
        break label1071;
      }
      if (this.ooi <= 0) {
        break label1060;
      }
      paramInt1 = this.ooi;
      label925:
      ad.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.yzn, Integer.valueOf(this.yzm), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.k(this.yzn, null, 43, 0, 0, new byte[0]);
      this.yzq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.aiU().a(paramString, 0);
      if (this.nZt != null) {
        this.nZt.dismiss();
      }
      a(this.mActivity.getString(2131762131), new b.a()
      {
        public final void dMH()
        {
          AppMethodBeat.i(52034);
          com.tencent.mm.kernel.g.aiU().a(paramString);
          if (c.this.yzp != null) {
            c.this.yzp.t(1, null);
          }
          AppMethodBeat.o(52034);
        }
      });
    }
    label1060:
    label1071:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label1076;
      }
      AppMethodBeat.o(52054);
      return;
      i = 1;
      break;
      paramInt1 = OT(this.yzm);
      break label925;
    }
    label1076:
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramn).dlC();
    Object localObject2 = z.a(((cyc)localObject1).GbY);
    ad.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((cyc)localObject1).GbY);
    p.aEk().h((String)localObject2, z.a(((cyc)localObject1).Fvm));
    if ((this.nZt != null) && (this.nZt.isShowing()))
    {
      ad.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.nZt.dismiss();
    }
    cancelLoading();
    Object localObject3;
    Object localObject4;
    if (bt.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.o.b.lM(((aw)localObject3).field_type)) && (((am)localObject3).fqg()))
      {
        paramString = ag.aFZ().DD((String)localObject2);
        paramString.bX(false);
        localObject4 = paramString.cQr;
        if (((c.b)localObject4).cQv != null) {
          ((c.b)localObject4).cQM = ((c.b)localObject4).cQv.optInt("ScanQRCodeType", 0);
        }
        if (((c.b)localObject4).cQM == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramString.Kn())) {
            break label1414;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.g.iRG.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1942;
      }
      if (this.yzp != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", z.a(((com.tencent.mm.plugin.messenger.a.f)paramn).dlC().GbY));
        paramString.putInt("geta8key_action_code", 4);
        a(true, paramString);
      }
      OU(4);
      AppMethodBeat.o(52054);
      return;
      paramInt1 = 0;
      break;
      label1414:
      paramInt1 = dBq();
      paramString = new Intent();
      com.tencent.mm.api.d.a(paramString, (cyc)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.o.b.lM(((aw)localObject3).field_type))) {
        paramString.putExtra("Contact_IsLBSFriend", true);
      }
      if ((((cyc)localObject1).GNU & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (am.aaR(((cyc)localObject1).GNU))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            paramString.putExtra("qbarScene", this.yzm);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!bt.isNullOrNil((String)localObject2))
            {
              Object localObject5 = y.aBq().AF((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((y.b)localObject5).getString("preUsername", null);
                localObject3 = ((y.b)localObject5).getString("preChatName", null);
                localObject4 = ((y.b)localObject5).getString("url", null);
                String str = ((y.b)localObject5).getString("rawUrl", null);
                paramInt1 = ((y.b)localObject5).getInt("Contact_Sub_Scene", 0);
                paramInt2 = x.aG((String)localObject2, (String)localObject3);
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
        if (this.yzm != 0) {
          break label1862;
        }
        paramString.putExtra("Contact_Sub_Scene", 7);
        label1739:
        com.tencent.mm.plugin.scanner.g.iRG.c(paramString, this.mActivity);
        paramString = "";
        if (w.zE(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.g.yhR;
        if (!am.aaR(((cyc)localObject1).GNU)) {
          break label1911;
        }
      }
      label1862:
      label1911:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject2).f(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.yzm), this.imagePath, this.yzn, bt.nullAsNil(this.dnw), paramString });
        paramInt1 = 1;
        break;
        if (this.sourceType == 7)
        {
          paramString.putExtra("Contact_Sub_Scene", 4);
          break label1739;
        }
        if ((this.sourceType != 3) && (this.sourceType != 5)) {
          break label1739;
        }
        paramString.putExtra("Contact_Sub_Scene", 2);
        break label1739;
      }
      if (this.mActivity != null) {
        Toast.makeText(this.mActivity, 2131762876, 0).show();
      }
      paramInt1 = 0;
    }
    label1942:
    if (this.yzp != null) {
      this.yzp.t(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label1967:
    if (paramn.getType() == 372)
    {
      paramString = ((com.tencent.mm.openim.b.n)paramn).iHH;
      paramn = paramString.nDo;
      ad.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramn)));
      cancelLoading();
      if (bt.nullAsNil(paramn).length() > 0)
      {
        paramn = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramn);
        paramInt1 = dBq();
        localObject1 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject1, paramString, paramInt1);
        if ((paramn != null) && (!com.tencent.mm.o.b.lM(paramn.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.g.iRG.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.g.yhR.f(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.yzm), this.imagePath, this.yzn, bt.nullAsNil(this.dnw) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.yzp != null)
        {
          paramn = new Bundle();
          paramn.putString("geta8key_fullurl", paramString.nDo);
          paramn.putInt("geta8key_action_code", 4);
          a(true, paramn);
        }
        OU(4);
        AppMethodBeat.o(52054);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131762876, 0).show();
        }
      }
      if (this.yzp != null) {
        this.yzp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 3512)
    {
      paramString = (aoq)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
      if (paramString.Gmj.size() > 0)
      {
        paramn = new Intent();
        paramn.putExtra("finder_username", ((FinderContact)paramString.Gmj.get(0)).username);
        paramn.putExtra("key_comment_scene", 10);
        paramn.putExtra("key_enter_profile_type", 3);
        ((t)com.tencent.mm.kernel.g.ad(t.class)).enterFinderProfileUI(this.mActivity, paramn);
        a(true, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 233)
    {
      paramString = ((com.tencent.mm.modelsimple.k)paramn).aKr();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.k)paramn).aKt());
      OU(((com.tencent.mm.modelsimple.k)paramn).aKt());
      if (this.ooi > 0) {}
      for (paramInt1 = this.ooi;; paramInt1 = OT(this.yzm))
      {
        ad.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.w.a.a.a(this, (com.tencent.mm.modelsimple.k)paramn, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(52032);
            if (c.this.yzp != null) {
              c.this.yzp.t(1, null);
            }
            AppMethodBeat.o(52032);
          }
        }, this.yzn, paramInt1, this.yzm, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52033);
            c.this.a(true, null);
            AppMethodBeat.o(52033);
          }
        }, this.yzo);
        if ((bool) || (((com.tencent.mm.modelsimple.k)paramn).aKt() != 4)) {
          break;
        }
        a(this.mActivity, this.yzm, paramString, true);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aKt() == 29))
      {
        paramn = this.mActivity;
        ad.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new com.tencent.mm.openim.b.n(paramString, (byte)0);
        this.yzq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        paramString = new b.a()
        {
          public final void dMH()
          {
            AppMethodBeat.i(52040);
            com.tencent.mm.kernel.g.aiU().a(paramString);
            if (c.this.yzp != null) {
              c.this.yzp.t(1, null);
            }
            AppMethodBeat.o(52040);
          }
        };
        if (this.yzr)
        {
          c(paramn.getString(2131762836), paramString);
          AppMethodBeat.o(52054);
          return;
        }
        a(paramn.getString(2131762836), paramString);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aKt() == 37))
      {
        paramn = this.mActivity;
        ad.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { paramString });
        localObject1 = new ArrayList();
        ((List)localObject1).add(paramString);
        paramString = new u((List)localObject1);
        this.yzq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        paramn.getString(2131755906);
        this.nZt = com.tencent.mm.ui.base.h.c(paramn, paramn.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(186234);
            com.tencent.mm.kernel.g.aiU().a(paramString);
            if (c.this.yzp != null) {
              c.this.yzp.t(1, null);
            }
            AppMethodBeat.o(186234);
          }
        });
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aKt() == 41))
      {
        paramn = new Intent();
        paramn.putExtra("key_qrcode_string", paramString);
        com.tencent.mm.bs.d.b(this.mActivity, "account", ".friend.ui.RecoverAccountUI1", paramn);
        AppMethodBeat.o(52054);
        return;
      }
      ad.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.yzp != null)) {
        this.yzp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof com.tencent.mm.ar.c))
        {
          paramString = ((com.tencent.mm.ar.c)paramn).aHt().ProductID;
          ad.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramn = new Intent();
          paramn.putExtra("extra_id", paramString);
          paramn.putExtra("preceding_scence", 11);
          paramn.putExtra("download_entrance_scene", 14);
          com.tencent.mm.bs.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramn);
          ad.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          a(true, null);
          AppMethodBeat.o(52054);
        }
      }
      else {
        ad.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(52054);
  }
  
  public final void pB(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.yzp != null)
      {
        this.yzp.t(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else {
      a(true, null);
    }
    AppMethodBeat.o(52056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */