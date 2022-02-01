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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.op.b;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.sn.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.i.a.u;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  implements com.tencent.mm.ak.f, a.a
{
  public String appId;
  private int dov;
  private int dow;
  public String doy;
  public String imagePath;
  public Activity mActivity;
  public ProgressDialog ofc;
  public int otZ;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  private boolean yCV;
  private int yFL;
  private boolean yFa;
  private boolean yOY;
  private int yOZ;
  private com.tencent.mm.plugin.scanner.view.b yPb;
  private Timer yPc;
  private TimerTask yPd;
  private int yPm;
  private String yPn;
  private Bundle yPo;
  com.tencent.mm.plugin.scanner.d.e.a yPp;
  private Map<com.tencent.mm.ak.n, Integer> yPq;
  boolean yPr;
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.yCV = false;
    this.yOZ = -1;
    this.yFa = false;
    this.ofc = null;
    this.yPp = null;
    this.yPb = null;
    this.yPq = new HashMap();
    this.yPc = null;
    this.yPd = null;
    this.yPr = false;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.g.ajj().a(106, this);
    com.tencent.mm.kernel.g.ajj().a(233, this);
    com.tencent.mm.kernel.g.ajj().a(666, this);
    com.tencent.mm.kernel.g.ajj().a(372, this);
    com.tencent.mm.kernel.g.ajj().a(3512, this);
    AppMethodBeat.o(52043);
  }
  
  private static int NW(int paramInt)
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
  
  private static int PA(int paramInt)
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
  
  private void PB(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.yPo != null)
    {
      localObject2 = this.yPo.getString("stat_url");
      if (((this.sourceType == 6) || (this.sourceType == 0)) && (!bu.isNullOrNil((String)localObject2)))
      {
        localObject1 = "";
        localObject4 = "";
      }
    }
    try
    {
      localObject2 = URLEncoder.encode(bu.nullAsNil((String)localObject2), "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode(bu.nullAsNil(this.yPn), "UTF-8");
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.QBarStringHandler", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
  }
  
  private void a(Activity paramActivity, int paramInt, final String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(52052);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, paramInt, 5, paramBoolean);
      this.yPq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajj().a(paramString, 0);
      paramString = new b.a()
      {
        public final void dQa()
        {
          AppMethodBeat.i(189515);
          com.tencent.mm.kernel.g.ajj().a(paramString);
          if (c.this.yPp != null) {
            c.this.yPp.t(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(189515);
        }
      };
      if (paramActivity == null) {
        break label127;
      }
      if ((!paramBoolean) || (!this.yPr)) {
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
    if (this.otZ > 0) {}
    for (int i = this.otZ;; i = PA(this.yPm))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.yPm), Integer.valueOf(i) });
      final com.tencent.mm.modelsimple.l locall = new com.tencent.mm.modelsimple.l(paramString1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0]);
      if (paramString1.startsWith("http://weixin.qq.com/r/"))
      {
        String str = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = com.tencent.mm.ui.e.a.ace(this.yPm);
        locall.setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!bu.isNullOrNil(str))
        {
          paramString2 = com.tencent.mm.model.z.aBG().Bp(str);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          locall.GN(paramString1);
          paramString2 = paramString1;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.yPq.put(locall, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajj().a(locall, 0);
      if (this.ofc != null) {
        this.ofc.dismiss();
      }
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dQa()
        {
          AppMethodBeat.i(52042);
          com.tencent.mm.kernel.g.ajj().a(locall);
          if (c.this.yPp != null) {
            c.this.yPp.t(1, null);
          }
          c.a(c.this, locall);
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
    boolean bool2 = this.yFa;
    if (this.yPb == null) {
      bool1 = true;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.yPb != null) && (this.yFa))
    {
      cancelLoading();
      this.yPc = new Timer();
      this.yPd = new h(this.yPb, new h.b()
      {
        public final void onShow()
        {
          c.this.yPr = true;
        }
      }, parama);
      this.yPc.schedule(this.yPd, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean ayl(String paramString)
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
    if (this.ofc != null) {
      this.ofc.dismiss();
    }
    this.ofc = com.tencent.mm.ui.base.h.b(this.mActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.dQa();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void c(String paramString, b.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.yFa;
    if (this.yPb == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.yPb == null) || (!this.yFa)) {
        break;
      }
      this.yPr = true;
      this.yPb.a(true, false, parama);
      AppMethodBeat.o(52045);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52045);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52046);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "alvinluo cancelLoading");
    if (this.yPb != null) {
      this.yPb.a(false, false, null);
    }
    if ((this.ofc != null) && (this.ofc.isShowing())) {
      this.ofc.dismiss();
    }
    if (this.yPc != null) {
      this.yPc.cancel();
    }
    if (this.yPd != null) {
      this.yPd.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int dEH()
  {
    switch (this.yPm)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "onPause");
    com.tencent.mm.kernel.g.ajj().b(106, this);
    com.tencent.mm.kernel.g.ajj().b(233, this);
    com.tencent.mm.kernel.g.ajj().b(666, this);
    com.tencent.mm.kernel.g.ajj().b(372, this);
    com.tencent.mm.kernel.g.ajj().b(3512, this);
    AppMethodBeat.o(52051);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.d.e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(52048);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.g.ajj().aFd()), Boolean.valueOf(paramBoolean2) });
    this.mActivity = paramActivity;
    this.yPm = paramInt1;
    this.yPn = paramString1;
    this.dov = paramInt2;
    this.dow = paramInt3;
    this.typeName = paramString2;
    this.yPp = parama;
    this.yPo = paramBundle;
    this.yOY = paramBoolean1;
    this.yFL = paramInt4;
    this.yFa = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.yCV = bool;
      this.yOZ = paramInt5;
      this.yPb = paramb;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!bu.isNullOrNil(paramString1)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(52048);
      return;
    }
    if (com.tencent.mm.kernel.g.ajj().aFd() == 0)
    {
      paramBoolean1 = az.isConnected(this.mActivity);
      if (this.yPp != null)
      {
        paramString2 = null;
        if (ayl(paramString1))
        {
          paramString2 = new Bundle();
          paramString2.putBoolean("key_offline_scan_show_tips", false);
        }
        this.yPp.t(0, paramString2);
        this.yPp.t(6, paramString2);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.yOY) {
          break label466;
        }
        paramString2 = b.yPj;
        if (!b.qR(paramBoolean2)) {
          break label466;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!ayl(paramString1))
        {
          paramString2 = b.yPj;
          paramString2 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.yCV, paramBundle);
          if (!paramBoolean1) {
            break label447;
          }
          paramActivity = this.mActivity.getString(2131762850);
          label400:
          b.a(paramString2, paramActivity, false);
        }
        paramActivity = o.yCW;
        paramActivity = this.typeName;
        if (!this.yCV) {
          break label461;
        }
      }
      label447:
      label461:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        o.d(paramString1, paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(52048);
        return;
        paramInt4 = 1;
        break;
        paramActivity = this.mActivity.getString(2131762853);
        break label400;
      }
      label466:
      if (this.yOY)
      {
        paramString1 = b.yPj;
        if (b.qR(paramBoolean2))
        {
          paramString1 = b.yPj;
          if (paramBoolean1) {}
          for (paramString1 = this.mActivity.getString(2131762850);; paramString1 = this.mActivity.getString(2131762853))
          {
            b.g(paramActivity, paramString1);
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
    if (!bu.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(52048);
      return;
    }
    if (ayl(paramString1))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = b.yPj;
        if (b.qR(paramBoolean2))
        {
          parama = o.yCW;
          parama = this.typeName;
          if (!this.yCV) {
            break label973;
          }
          paramInt1 = 2;
          o.d(paramString1, parama, paramInt1, 4, 0);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (paramString1.startsWith("weixin://wxpay/bizpayurl"))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt1 = PA(this.yPm);
      paramInt2 = NW(paramInt1);
      paramActivity = new op();
      paramActivity.dDB.url = paramString1;
      paramActivity.dDB.channel = paramInt2;
      paramActivity.dDB.scene = paramInt1;
      paramActivity.dDB.context = this.mActivity;
      if (paramInt2 == 13)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.dDB.source = this.source;
        paramActivity.dDB.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((c.this.mActivity == null) || (paramActivity.dDC == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dDC.ret == 1)
          {
            c.this.pJ(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dDC.ret == 2) {
            c.this.pJ(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.a(paramActivity, Looper.myLooper());
      if ((((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY"))) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          new aq(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(52037);
              if ((c.this.yPp != null) && ((paramActivity.dDC == null) || (paramActivity.dDC.ret != 1))) {
                c.this.a(false, null);
              }
              AppMethodBeat.o(52037);
            }
          }, 10000L);
        }
        PB(11);
        com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        label973:
        paramInt1 = 1;
        break;
      }
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt1 = NW(PA(this.yPm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      a(true, null);
      PB(11);
      com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt1 = NW(PA(this.yPm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 6, paramString1, paramInt1, null);
      a(true, null);
      PB(11);
      com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "go to reward");
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt2 = NW(PA(this.yPm));
      paramInt1 = 1;
      if (this.otZ == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, paramString1, paramInt2, paramString2, paramInt1);
        a(true, null);
        PB(11);
        com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        if (this.otZ == 38) {
          paramInt1 = 3;
        } else if (this.otZ == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith("https://payapp.weixin.qq.com/qr/"))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt1 = NW(PA(this.yPm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      a(true, null);
      PB(11);
      com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramInt1 = PA(this.yPm);
      paramInt2 = NW(paramInt1);
      paramActivity = new sn();
      paramActivity.dIe.dIg = paramString1;
      paramActivity.dIe.scene = paramInt1;
      paramActivity.dIe.type = 1;
      paramActivity.dIe.aWN = new WeakReference(this.mActivity);
      paramActivity.dIe.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52038);
          if (!bu.isNullOrNil(paramActivity.dIf.errMsg))
          {
            if (c.this.mActivity != null) {
              Toast.makeText(c.this.mActivity, paramActivity.dIf.errMsg, 1).show();
            }
            c.this.a(false, null);
            AppMethodBeat.o(52038);
            return;
          }
          if (bu.isNullOrNil(paramActivity.dIf.dIh))
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.QBarStringHandler", "resp url is null!");
            c.this.a(false, null);
            AppMethodBeat.o(52038);
            return;
          }
          if (paramActivity.dIf.actionType == 1)
          {
            com.tencent.mm.pluginsdk.wallet.f.a(c.this.mActivity, paramActivity.dIf.dIh, paramInt2, paramString2, paramInt1);
            c.this.a(true, null);
            AppMethodBeat.o(52038);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramActivity.dIf.dIh);
          com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, c.this.mActivity);
          c.this.a(true, null);
          AppMethodBeat.o(52038);
        }
      };
      com.tencent.mm.sdk.b.a.IvT.l(paramActivity);
      PB(11);
      com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(52048);
        return;
      }
      if (this.yPp != null) {
        this.yPp.t(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.br.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.g.yxI.f(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      PB(11);
      AppMethodBeat.o(52048);
      return;
    }
    paramString2 = new com.tencent.mm.plugin.scanner.c();
    paramString2.activity = paramActivity;
    paramString2.yyB = paramString1;
    paramString2.dov = paramInt2;
    paramString2.dow = paramInt3;
    com.tencent.mm.sdk.b.a.IvT.l(paramString2);
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.yPp != null) {
      this.yPp.t(5, null);
    }
    AppMethodBeat.o(52048);
  }
  
  final void a(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(189517);
    if (this.yPp != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("key_scan_qr_code_result", paramBoolean);
      this.yPp.t(3, localBundle);
    }
    AppMethodBeat.o(189517);
  }
  
  public final void dQe()
  {
    AppMethodBeat.i(52050);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.yPn = null;
    this.mActivity = null;
    onPause();
    AppMethodBeat.o(52050);
  }
  
  public final Context getContext()
  {
    return this.mActivity;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(52054);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramn == null)
    {
      if (paramn == null) {}
      for (bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.yPp != null) {
          this.yPp.t(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.yPq.containsKey(paramn))
    {
      if ((paramn instanceof com.tencent.mm.aq.c)) {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.yPq.remove(paramn);
      cancelLoading();
      if ((paramn.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new com.tencent.mm.modelsimple.l(((com.tencent.mm.openim.b.n)paramn).iKB, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
      this.yPq.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(52054);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
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
          if (c.this.yPp != null) {
            c.this.yPp.t(1, null);
          }
          AppMethodBeat.o(52031);
        }
      });
      AppMethodBeat.o(52054);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.yPp != null) {
            this.yPp.t(7, null);
          }
          if (this.mActivity != null)
          {
            paramString = b.yPj;
            b.a(new OfflineScanContext(this.mActivity, 2, this.yPn, this.yPm, this.dov, this.dow, this.typeName, this.yCV, this.yPo), this.mActivity.getString(2131762850), true);
            paramString = o.yCW;
            paramString = this.yPn;
            paramn = this.typeName;
            if (this.yCV) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              o.d(paramString, paramn, paramInt1, 2, 0);
              AppMethodBeat.o(52054);
              return;
            }
          }
        }
        else
        {
          paramString = b.yPj;
          b.g(this.mActivity, this.mActivity.getString(2131762848));
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
      if (this.yPp != null) {
        this.yPp.t(0, null);
      }
      AppMethodBeat.o(52054);
      return;
      if (com.tencent.mm.kernel.g.ajj().aFe())
      {
        com.tencent.mm.kernel.g.ajj().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (com.tencent.mm.network.ae.cR(this.mActivity)) {
          k.hI(this.mActivity);
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
      if (this.yPp != null) {
        this.yPp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.yPp != null) {
        this.yPp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    paramString = b.yPj;
    if ((b.m(paramn)) && (!this.yOY))
    {
      paramString = o.yCW;
      paramString = this.yPn;
      localObject1 = this.typeName;
      if (this.yCV)
      {
        i = 2;
        o.d(paramString, (String)localObject1, i, 4, 0);
      }
    }
    else
    {
      if (paramn.getType() != 106) {
        break label1967;
      }
      paramString = (com.tencent.mm.plugin.messenger.a.f)paramn;
      if (paramString.vVi) {
        break label1071;
      }
      paramString = paramString.doB();
      if ((!an.abz(paramString.Hhu)) || (paramString.HhB == null) || (bu.isNullOrNil(paramString.HhB.jgk)) || (!com.tencent.mm.modelappbrand.a.CA(paramString.HhB.jgk))) {
        break label1071;
      }
      if (this.otZ <= 0) {
        break label1060;
      }
      paramInt1 = this.otZ;
      label925:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.yPn, Integer.valueOf(this.yPm), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.l(this.yPn, null, 43, 0, 0, new byte[0]);
      this.yPq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.ajj().a(paramString, 0);
      if (this.ofc != null) {
        this.ofc.dismiss();
      }
      a(this.mActivity.getString(2131762131), new b.a()
      {
        public final void dQa()
        {
          AppMethodBeat.i(52034);
          com.tencent.mm.kernel.g.ajj().a(paramString);
          if (c.this.yPp != null) {
            c.this.yPp.t(1, null);
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
      paramInt1 = PA(this.yPm);
      break label925;
    }
    label1076:
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramn).doB();
    Object localObject2 = com.tencent.mm.platformtools.z.a(((cyw)localObject1).GuF);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((cyw)localObject1).GuF);
    p.aEA().h((String)localObject2, com.tencent.mm.platformtools.z.a(((cyw)localObject1).FNK));
    if ((this.ofc != null) && (this.ofc.isShowing()))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.ofc.dismiss();
    }
    cancelLoading();
    Object localObject3;
    Object localObject4;
    if (bu.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.contact.c.lO(((aw)localObject3).field_type)) && (((an)localObject3).fug()))
      {
        paramString = ag.aGp().Ef((String)localObject2);
        paramString.bX(false);
        localObject4 = paramString.cRb;
        if (((c.b)localObject4).cRf != null) {
          ((c.b)localObject4).cRw = ((c.b)localObject4).cRf.optInt("ScanQRCodeType", 0);
        }
        if (((c.b)localObject4).cRw == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramString.Kv())) {
            break label1414;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.h.iUz.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1942;
      }
      if (this.yPp != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", com.tencent.mm.platformtools.z.a(((com.tencent.mm.plugin.messenger.a.f)paramn).doB().GuF));
        paramString.putInt("geta8key_action_code", 4);
        a(true, paramString);
      }
      PB(4);
      AppMethodBeat.o(52054);
      return;
      paramInt1 = 0;
      break;
      label1414:
      paramInt1 = dEH();
      paramString = new Intent();
      com.tencent.mm.api.d.a(paramString, (cyw)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.contact.c.lO(((aw)localObject3).field_type))) {
        paramString.putExtra("Contact_IsLBSFriend", true);
      }
      if ((((cyw)localObject1).Hhu & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (an.abz(((cyw)localObject1).Hhu))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            paramString.putExtra("qbarScene", this.yPm);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!bu.isNullOrNil((String)localObject2))
            {
              Object localObject5 = com.tencent.mm.model.z.aBG().Bp((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((z.b)localObject5).getString("preUsername", null);
                localObject3 = ((z.b)localObject5).getString("preChatName", null);
                localObject4 = ((z.b)localObject5).getString("url", null);
                String str = ((z.b)localObject5).getString("rawUrl", null);
                paramInt1 = ((z.b)localObject5).getInt("Contact_Sub_Scene", 0);
                paramInt2 = y.aH((String)localObject2, (String)localObject3);
                localObject5 = ((z.b)localObject5).getString("Contact_Scene_Note", null);
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
        if (this.yPm != 0) {
          break label1862;
        }
        paramString.putExtra("Contact_Sub_Scene", 7);
        label1739:
        com.tencent.mm.plugin.scanner.h.iUz.c(paramString, this.mActivity);
        paramString = "";
        if (x.Ao(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        if (!an.abz(((cyw)localObject1).Hhu)) {
          break label1911;
        }
      }
      label1862:
      label1911:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject2).f(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.yPm), this.imagePath, this.yPn, bu.nullAsNil(this.doy), paramString });
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
    if (this.yPp != null) {
      this.yPp.t(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label1967:
    if (paramn.getType() == 372)
    {
      paramString = ((com.tencent.mm.openim.b.n)paramn).iKA;
      paramn = paramString.nIJ;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramn)));
      cancelLoading();
      if (bu.nullAsNil(paramn).length() > 0)
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramn);
        paramInt1 = dEH();
        localObject1 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject1, paramString, paramInt1);
        if ((paramn != null) && (!com.tencent.mm.contact.c.lO(paramn.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.h.iUz.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.g.yxI.f(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.yPm), this.imagePath, this.yPn, bu.nullAsNil(this.doy) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.yPp != null)
        {
          paramn = new Bundle();
          paramn.putString("geta8key_fullurl", paramString.nIJ);
          paramn.putInt("geta8key_action_code", 4);
          a(true, paramn);
        }
        PB(4);
        AppMethodBeat.o(52054);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131762876, 0).show();
        }
      }
      if (this.yPp != null) {
        this.yPp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 3512)
    {
      paramString = (apd)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
      if (paramString.GFl.size() > 0)
      {
        paramn = new Intent();
        paramn.putExtra("finder_username", ((FinderContact)paramString.GFl.get(0)).username);
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
      paramString = ((com.tencent.mm.modelsimple.l)paramn).aKO();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.l)paramn).aKQ());
      PB(((com.tencent.mm.modelsimple.l)paramn).aKQ());
      if (this.otZ > 0) {}
      for (paramInt1 = this.otZ;; paramInt1 = PA(this.yPm))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.w.a.a.a(this, (com.tencent.mm.modelsimple.l)paramn, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(52032);
            if (c.this.yPp != null) {
              c.this.yPp.t(1, null);
            }
            AppMethodBeat.o(52032);
          }
        }, this.yPn, paramInt1, this.yPm, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52033);
            c.this.a(true, null);
            AppMethodBeat.o(52033);
          }
        }, this.yPo);
        if ((bool) || (((com.tencent.mm.modelsimple.l)paramn).aKQ() != 4)) {
          break;
        }
        a(this.mActivity, this.yPm, paramString, true);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramn).aKQ() == 29))
      {
        paramn = this.mActivity;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new com.tencent.mm.openim.b.n(paramString, (byte)0);
        this.yPq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        paramString = new b.a()
        {
          public final void dQa()
          {
            AppMethodBeat.i(52040);
            com.tencent.mm.kernel.g.ajj().a(paramString);
            if (c.this.yPp != null) {
              c.this.yPp.t(1, null);
            }
            AppMethodBeat.o(52040);
          }
        };
        if (this.yPr)
        {
          c(paramn.getString(2131762836), paramString);
          AppMethodBeat.o(52054);
          return;
        }
        a(paramn.getString(2131762836), paramString);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramn).aKQ() == 37))
      {
        paramn = this.mActivity;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { paramString });
        localObject1 = new ArrayList();
        ((List)localObject1).add(paramString);
        paramString = new u((List)localObject1);
        this.yPq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        paramn.getString(2131755906);
        this.ofc = com.tencent.mm.ui.base.h.c(paramn, paramn.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(189516);
            com.tencent.mm.kernel.g.ajj().a(paramString);
            if (c.this.yPp != null) {
              c.this.yPp.t(1, null);
            }
            AppMethodBeat.o(189516);
          }
        });
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramn).aKQ() == 41))
      {
        paramn = new Intent();
        paramn.putExtra("key_qrcode_string", paramString);
        com.tencent.mm.br.d.b(this.mActivity, "account", ".friend.ui.RecoverAccountUI1", paramn);
        AppMethodBeat.o(52054);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.yPp != null)) {
        this.yPp.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof com.tencent.mm.aq.c))
        {
          paramString = ((com.tencent.mm.aq.c)paramn).aHK().ProductID;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramn = new Intent();
          paramn.putExtra("extra_id", paramString);
          paramn.putExtra("preceding_scence", 11);
          paramn.putExtra("download_entrance_scene", 14);
          com.tencent.mm.br.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramn);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          a(true, null);
          AppMethodBeat.o(52054);
        }
      }
      else {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(52054);
  }
  
  public final void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.yPp != null)
      {
        this.yPp.t(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else {
      a(true, null);
    }
    AppMethodBeat.o(52056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */