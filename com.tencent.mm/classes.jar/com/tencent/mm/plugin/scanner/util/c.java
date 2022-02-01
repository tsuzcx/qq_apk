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
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.of;
import com.tencent.mm.g.a.of.b;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sa.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.ae;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.view.b.a;
import com.tencent.mm.plugin.v.a.a.a;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  implements com.tencent.mm.ak.g, a.a
{
  public String appId;
  private int dbX;
  private int dbY;
  public String dca;
  public String imagePath;
  public Activity mActivity;
  public int nLC;
  public ProgressDialog nxV;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  private boolean wZd;
  private int xbK;
  private boolean xbc;
  private boolean xkW;
  private int xkX;
  private com.tencent.mm.plugin.scanner.view.b xkZ;
  private Timer xla;
  private TimerTask xlb;
  private int xlk;
  private String xll;
  private Bundle xlm;
  com.tencent.mm.plugin.scanner.d.e.a xln;
  private Map<com.tencent.mm.ak.n, Integer> xlo;
  boolean xlp;
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.wZd = false;
    this.xkX = -1;
    this.xbc = false;
    this.nxV = null;
    this.xln = null;
    this.xkZ = null;
    this.xlo = new HashMap();
    this.xla = null;
    this.xlb = null;
    this.xlp = false;
    ac.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.g.agi().a(106, this);
    com.tencent.mm.kernel.g.agi().a(233, this);
    com.tencent.mm.kernel.g.agi().a(666, this);
    com.tencent.mm.kernel.g.agi().a(372, this);
    com.tencent.mm.kernel.g.agi().a(3512, this);
    AppMethodBeat.o(52043);
  }
  
  private static int LR(int paramInt)
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
  
  private static int Nr(int paramInt)
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
  
  private void Ns(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.xlm != null)
    {
      localObject2 = this.xlm.getString("stat_url");
      if (((this.sourceType == 6) || (this.sourceType == 0)) && (!bs.isNullOrNil((String)localObject2)))
      {
        localObject1 = "";
        localObject4 = "";
      }
    }
    try
    {
      localObject2 = URLEncoder.encode(bs.nullAsNil((String)localObject2), "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode(bs.nullAsNil(this.xll), "UTF-8");
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.QBarStringHandler", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
  }
  
  private void a(Activity paramActivity, int paramInt, final String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(52052);
    ac.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.g(paramString, paramInt, 5, paramBoolean);
      this.xlo.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      paramString = new b.a()
      {
        public final void dBj()
        {
          AppMethodBeat.i(199559);
          com.tencent.mm.kernel.g.agi().a(paramString);
          if (c.this.xln != null) {
            c.this.xln.s(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(199559);
        }
      };
      if (paramActivity == null) {
        break label127;
      }
      if ((!paramBoolean) || (!this.xlp)) {
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
    if (this.nLC > 0) {}
    for (int i = this.nLC;; i = Nr(this.xlk))
    {
      ac.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.xlk), Integer.valueOf(i) });
      final com.tencent.mm.modelsimple.k localk = new com.tencent.mm.modelsimple.k(paramString1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0]);
      if (paramString1.startsWith("http://weixin.qq.com/r/"))
      {
        String str = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = com.tencent.mm.ui.e.a.Zn(this.xlk);
        localk.setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!bs.isNullOrNil(str))
        {
          paramString2 = y.ayq().xH(str);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          localk.Dg(paramString1);
          paramString2 = paramString1;
        }
        ac.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.xlo.put(localk, Integer.valueOf(1));
      com.tencent.mm.kernel.g.agi().a(localk, 0);
      if (this.nxV != null) {
        this.nxV.dismiss();
      }
      a(paramActivity.getString(2131762131), new b.a()
      {
        public final void dBj()
        {
          AppMethodBeat.i(52042);
          com.tencent.mm.kernel.g.agi().a(localk);
          if (c.this.xln != null) {
            c.this.xln.s(1, null);
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
    boolean bool2 = this.xbc;
    if (this.xkZ == null) {
      bool1 = true;
    }
    ac.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.xkZ != null) && (this.xbc))
    {
      cancelLoading();
      this.xla = new Timer();
      this.xlb = new h(this.xkZ, new h.b()
      {
        public final void onShow()
        {
          c.this.xlp = true;
        }
      }, parama);
      this.xla.schedule(this.xlb, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean arV(String paramString)
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
    if (this.nxV != null) {
      this.nxV.dismiss();
    }
    this.nxV = com.tencent.mm.ui.base.h.b(this.mActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.dBj();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void c(String paramString, b.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.xbc;
    if (this.xkZ == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.xkZ == null) || (!this.xbc)) {
        break;
      }
      this.xlp = true;
      this.xkZ.a(true, false, parama);
      AppMethodBeat.o(52045);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52045);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52046);
    ac.i("MicroMsg.QBarStringHandler", "alvinluo cancelLoading");
    if (this.xkZ != null) {
      this.xkZ.a(false, false, null);
    }
    if ((this.nxV != null) && (this.nxV.isShowing())) {
      this.nxV.dismiss();
    }
    if (this.xla != null) {
      this.xla.cancel();
    }
    if (this.xlb != null) {
      this.xlb.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int dqN()
  {
    switch (this.xlk)
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
    ac.i("MicroMsg.QBarStringHandler", "onPause");
    com.tencent.mm.kernel.g.agi().b(106, this);
    com.tencent.mm.kernel.g.agi().b(233, this);
    com.tencent.mm.kernel.g.agi().b(666, this);
    com.tencent.mm.kernel.g.agi().b(372, this);
    com.tencent.mm.kernel.g.agi().b(3512, this);
    AppMethodBeat.o(52051);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.d.e.a parama, com.tencent.mm.plugin.scanner.view.b paramb, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(52048);
    ac.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.g.agi().aBK()), Boolean.valueOf(paramBoolean2) });
    this.mActivity = paramActivity;
    this.xlk = paramInt1;
    this.xll = paramString1;
    this.dbX = paramInt2;
    this.dbY = paramInt3;
    this.typeName = paramString2;
    this.xln = parama;
    this.xlm = paramBundle;
    this.xkW = paramBoolean1;
    this.xbK = paramInt4;
    this.xbc = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.wZd = bool;
      this.xkX = paramInt5;
      this.xkZ = paramb;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!bs.isNullOrNil(paramString1)) {
        break;
      }
      ac.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(52048);
      return;
    }
    if (com.tencent.mm.kernel.g.agi().aBK() == 0)
    {
      paramBoolean1 = ax.isConnected(this.mActivity);
      if (this.xln != null)
      {
        this.xln.s(0, null);
        this.xln.s(6, null);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.xkW) {
          break label426;
        }
        paramString2 = b.xlh;
        if (!b.ql(paramBoolean2)) {
          break label426;
        }
        ac.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        paramString2 = b.xlh;
        paramString1 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.wZd, paramBundle);
        if (!paramBoolean1) {
          break label407;
        }
        paramActivity = this.mActivity.getString(2131762850);
        label362:
        b.a(paramString1, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.l.wZe;
        paramActivity = this.typeName;
        if (!this.wZd) {
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
      if (this.xkW)
      {
        paramString1 = b.xlh;
        if (b.ql(paramBoolean2))
        {
          paramString1 = b.xlh;
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
    if (!bs.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(52048);
      return;
    }
    if (arV(paramString1))
    {
      ac.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = com.tencent.mm.plugin.scanner.model.l.wZe;
        parama = this.typeName;
        if (!this.wZd) {
          break label919;
        }
        paramInt1 = 2;
        com.tencent.mm.plugin.scanner.model.l.n(parama, paramInt1, 4, 0);
      }
    }
    ac.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (paramString1.startsWith("weixin://wxpay/bizpayurl"))
    {
      ac.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt1 = Nr(this.xlk);
      paramInt2 = LR(paramInt1);
      paramActivity = new of();
      paramActivity.dqF.url = paramString1;
      paramActivity.dqF.channel = paramInt2;
      paramActivity.dqF.scene = paramInt1;
      paramActivity.dqF.context = this.mActivity;
      if (paramInt2 == 13)
      {
        ac.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.dqF.source = this.source;
        paramActivity.dqF.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((c.this.mActivity == null) || (paramActivity.dqG == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dqG.ret == 1)
          {
            c.this.pe(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dqG.ret == 2) {
            c.this.pe(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      com.tencent.mm.sdk.b.a.GpY.a(paramActivity, Looper.myLooper());
      if ((((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY"))) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          new ao(Looper.getMainLooper()).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(52037);
              if ((c.this.xln != null) && ((paramActivity.dqG == null) || (paramActivity.dqG.ret != 1))) {
                c.this.xln.s(3, null);
              }
              AppMethodBeat.o(52037);
            }
          }, 10000L);
        }
        Ns(11);
        com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        label919:
        paramInt1 = 1;
        break;
      }
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt1 = LR(Nr(this.xlk));
      f.a(this.mActivity, 1, paramString1, paramInt1, null);
      if (this.xln != null) {
        this.xln.s(3, null);
      }
      Ns(11);
      com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt1 = LR(Nr(this.xlk));
      f.a(this.mActivity, 6, paramString1, paramInt1, null);
      if (this.xln != null) {
        this.xln.s(3, null);
      }
      Ns(11);
      com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      ac.d("MicroMsg.QBarStringHandler", "go to reward");
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt2 = LR(Nr(this.xlk));
      paramInt1 = 1;
      if (this.nLC == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        f.a(this.mActivity, paramString1, paramInt2, paramString2, paramInt1);
        if (this.xln != null) {
          this.xln.s(3, null);
        }
        Ns(11);
        com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        if (this.nLC == 38) {
          paramInt1 = 3;
        } else if (this.nLC == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith("https://payapp.weixin.qq.com/qr/"))
    {
      ac.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt1 = LR(Nr(this.xlk));
      f.a(this.mActivity, 1, paramString1, paramInt1, null);
      if (this.xln != null) {
        this.xln.s(3, null);
      }
      Ns(11);
      com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      ac.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramInt1 = Nr(this.xlk);
      paramInt2 = LR(paramInt1);
      paramActivity = new sa();
      paramActivity.duX.duZ = paramString1;
      paramActivity.duX.scene = paramInt1;
      paramActivity.duX.type = 1;
      paramActivity.duX.aMw = new WeakReference(this.mActivity);
      paramActivity.duX.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52038);
          if (!bs.isNullOrNil(paramActivity.duY.errMsg)) {
            if (c.this.mActivity != null) {
              Toast.makeText(c.this.mActivity, paramActivity.duY.errMsg, 1).show();
            }
          }
          for (;;)
          {
            if (c.this.xln != null) {
              c.this.xln.s(3, null);
            }
            AppMethodBeat.o(52038);
            return;
            if (bs.isNullOrNil(paramActivity.duY.dva))
            {
              ac.w("MicroMsg.QBarStringHandler", "resp url is null!");
            }
            else if (paramActivity.duY.actionType == 1)
            {
              f.a(c.this.mActivity, paramActivity.duY.dva, paramInt2, paramString2, paramInt1);
            }
            else
            {
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramActivity.duY.dva);
              com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, c.this.mActivity);
            }
          }
        }
      };
      com.tencent.mm.sdk.b.a.GpY.l(paramActivity);
      Ns(11);
      com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      ac.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(52048);
        return;
      }
      if (this.xln != null) {
        this.xln.s(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.br.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.h.wUl.f(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      Ns(11);
      AppMethodBeat.o(52048);
      return;
    }
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.xln != null) {
      this.xln.s(5, null);
    }
    AppMethodBeat.o(52048);
  }
  
  public final void dBn()
  {
    AppMethodBeat.i(52050);
    ac.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.xll = null;
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
    ac.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramn == null)
    {
      if (paramn == null) {}
      for (bool = true;; bool = false)
      {
        ac.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.xln != null) {
          this.xln.s(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.xlo.containsKey(paramn))
    {
      if ((paramn instanceof com.tencent.mm.aq.c)) {
        ac.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.xlo.remove(paramn);
      cancelLoading();
      if ((paramn.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new com.tencent.mm.modelsimple.k(((com.tencent.mm.openim.b.n)paramn).iol, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
      this.xlo.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(52054);
      return;
    }
    ac.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
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
          if (c.this.xln != null) {
            c.this.xln.s(1, null);
          }
          AppMethodBeat.o(52031);
        }
      });
      AppMethodBeat.o(52054);
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
          ac.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.xln != null) {
            this.xln.s(7, null);
          }
          if (this.mActivity != null)
          {
            paramString = b.xlh;
            b.a(new OfflineScanContext(this.mActivity, 2, this.xll, this.xlk, this.dbX, this.dbY, this.typeName, this.wZd, this.xlm), this.mActivity.getString(2131762850), true);
            paramString = com.tencent.mm.plugin.scanner.model.l.wZe;
            paramString = this.typeName;
            if (this.wZd) {}
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
          paramString = b.xlh;
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
      if (this.xln != null) {
        this.xln.s(1, null);
      }
      AppMethodBeat.o(52054);
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
        if (ae.cS(this.mActivity)) {
          com.tencent.mm.pluginsdk.ui.tools.k.hx(this.mActivity);
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
      if (this.xln != null) {
        this.xln.s(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131759560, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.xln != null) {
        this.xln.s(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    paramString = b.xlh;
    if ((b.m(paramn)) && (!this.xkW))
    {
      paramString = com.tencent.mm.plugin.scanner.model.l.wZe;
      paramString = this.typeName;
      if (this.wZd)
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
      if (paramString.uGb) {
        break label1055;
      }
      paramString = paramString.dcj();
      if ((!ai.YI(paramString.Feq)) || (paramString.Fex == null) || (bs.isNullOrNil(paramString.Fex.iKi)) || (!com.tencent.mm.modelappbrand.a.yZ(paramString.Fex.iKi))) {
        break label1055;
      }
      if (this.nLC <= 0) {
        break label1044;
      }
      paramInt1 = this.nLC;
      label909:
      ac.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.xll, Integer.valueOf(this.xlk), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.k(this.xll, null, 43, 0, 0, new byte[0]);
      this.xlo.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.agi().a(paramString, 0);
      if (this.nxV != null) {
        this.nxV.dismiss();
      }
      a(this.mActivity.getString(2131762131), new b.a()
      {
        public final void dBj()
        {
          AppMethodBeat.i(52034);
          com.tencent.mm.kernel.g.agi().a(paramString);
          if (c.this.xln != null) {
            c.this.xln.s(1, null);
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
      paramInt1 = Nr(this.xlk);
      break label909;
    }
    label1060:
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.g)paramn).dcj();
    Object localObject2 = z.a(((css)localObject1).EuE);
    ac.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((css)localObject1).EuE);
    p.aBh().h((String)localObject2, z.a(((css)localObject1).DPX));
    if ((this.nxV != null) && (this.nxV.isShowing()))
    {
      ac.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.nxV.dismiss();
    }
    cancelLoading();
    Object localObject3;
    Object localObject4;
    if (bs.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.n.b.ln(((av)localObject3).field_type)) && (((ai)localObject3).fad()))
      {
        paramString = af.aCW().AE((String)localObject2);
        paramString.bV(false);
        localObject4 = paramString.cFm;
        if (((c.b)localObject4).cFq != null) {
          ((c.b)localObject4).cFH = ((c.b)localObject4).cFq.optInt("ScanQRCodeType", 0);
        }
        if (((c.b)localObject4).cFH == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramString.IN())) {
            break label1403;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.g.iyx.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1931;
      }
      if (this.xln != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", z.a(((com.tencent.mm.plugin.messenger.a.g)paramn).dcj().EuE));
        paramString.putInt("geta8key_action_code", 4);
        this.xln.s(3, paramString);
      }
      Ns(4);
      AppMethodBeat.o(52054);
      return;
      paramInt1 = 0;
      break;
      label1403:
      paramInt1 = dqN();
      paramString = new Intent();
      com.tencent.mm.api.d.a(paramString, (css)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.n.b.ln(((av)localObject3).field_type))) {
        paramString.putExtra("Contact_IsLBSFriend", true);
      }
      if ((((css)localObject1).Feq & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (ai.YI(((css)localObject1).Feq))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            paramString.putExtra("qbarScene", this.xlk);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!bs.isNullOrNil((String)localObject2))
            {
              Object localObject5 = y.ayq().xH((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((y.b)localObject5).getString("preUsername", null);
                localObject3 = ((y.b)localObject5).getString("preChatName", null);
                localObject4 = ((y.b)localObject5).getString("url", null);
                String str = ((y.b)localObject5).getString("rawUrl", null);
                paramInt1 = ((y.b)localObject5).getInt("Contact_Sub_Scene", 0);
                paramInt2 = x.aE((String)localObject2, (String)localObject3);
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
        if (this.xlk != 0) {
          break label1851;
        }
        paramString.putExtra("Contact_Sub_Scene", 7);
        label1728:
        com.tencent.mm.plugin.scanner.g.iyx.c(paramString, this.mActivity);
        paramString = "";
        if (w.wH(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.h.wUl;
        if (!ai.YI(((css)localObject1).Feq)) {
          break label1900;
        }
      }
      label1851:
      label1900:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).f(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.xlk), this.imagePath, this.xll, bs.nullAsNil(this.dca), paramString });
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
    if (this.xln != null) {
      this.xln.s(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label1956:
    if (paramn.getType() == 372)
    {
      paramString = ((com.tencent.mm.openim.b.n)paramn).iok;
      paramn = paramString.ncR;
      ac.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramn)));
      cancelLoading();
      if (bs.nullAsNil(paramn).length() > 0)
      {
        paramn = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramn);
        paramInt1 = dqN();
        localObject1 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject1, paramString, paramInt1);
        if ((paramn != null) && (!com.tencent.mm.n.b.ln(paramn.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.g.iyx.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.h.wUl.f(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.xlk), this.imagePath, this.xll, bs.nullAsNil(this.dca) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.xln != null)
        {
          paramn = new Bundle();
          paramn.putString("geta8key_fullurl", paramString.ncR);
          paramn.putInt("geta8key_action_code", 4);
          this.xln.s(3, paramn);
        }
        Ns(4);
        AppMethodBeat.o(52054);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131762876, 0).show();
        }
      }
      if (this.xln != null) {
        this.xln.s(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 3512)
    {
      paramString = (all)((com.tencent.mm.ak.b)paramn.getReqResp()).hvs.hvw;
      if (paramString.rHC.size() > 0)
      {
        paramn = new Intent();
        paramn.putExtra("finder_username", ((FinderContact)paramString.rHC.get(0)).username);
        paramn.putExtra("key_comment_scene", 10);
        paramn.putExtra("key_enter_profile_type", 3);
        ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderProfileUI(this.mActivity, paramn);
        if (this.xln != null) {
          this.xln.s(3, null);
        }
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 233)
    {
      paramString = ((com.tencent.mm.modelsimple.k)paramn).aHg();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.k)paramn).aHi());
      Ns(((com.tencent.mm.modelsimple.k)paramn).aHi());
      if (this.nLC > 0) {}
      for (paramInt1 = this.nLC;; paramInt1 = Nr(this.xlk))
      {
        ac.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.v.a.a.a(this, (com.tencent.mm.modelsimple.k)paramn, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(52032);
            if (c.this.xln != null) {
              c.this.xln.s(1, null);
            }
            AppMethodBeat.o(52032);
          }
        }, this.xll, paramInt1, this.xlk, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52033);
            if (c.this.xln != null) {
              c.this.xln.s(3, null);
            }
            AppMethodBeat.o(52033);
          }
        }, this.xlm);
        if ((bool) || (((com.tencent.mm.modelsimple.k)paramn).aHi() != 4)) {
          break;
        }
        a(this.mActivity, this.xlk, paramString, true);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aHi() == 29))
      {
        paramn = this.mActivity;
        ac.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new com.tencent.mm.openim.b.n(paramString, (byte)0);
        this.xlo.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        paramString = new b.a()
        {
          public final void dBj()
          {
            AppMethodBeat.i(52040);
            com.tencent.mm.kernel.g.agi().a(paramString);
            if (c.this.xln != null) {
              c.this.xln.s(1, null);
            }
            AppMethodBeat.o(52040);
          }
        };
        if (this.xlp)
        {
          c(paramn.getString(2131762836), paramString);
          AppMethodBeat.o(52054);
          return;
        }
        a(paramn.getString(2131762836), paramString);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aHi() == 37))
      {
        paramn = this.mActivity;
        ac.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { paramString });
        localObject1 = new ArrayList();
        ((List)localObject1).add(paramString);
        paramString = new m((List)localObject1);
        this.xlo.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        paramn.getString(2131755906);
        this.nxV = com.tencent.mm.ui.base.h.c(paramn, paramn.getString(2131762836), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(199560);
            com.tencent.mm.kernel.g.agi().a(paramString);
            if (c.this.xln != null) {
              c.this.xln.s(1, null);
            }
            AppMethodBeat.o(199560);
          }
        });
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.k)paramn).aHi() == 41))
      {
        paramn = new Intent();
        paramn.putExtra("key_qrcode_string", paramString);
        com.tencent.mm.br.d.b(this.mActivity, "account", ".friend.ui.RecoverAccountUI1", paramn);
        AppMethodBeat.o(52054);
        return;
      }
      ac.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.xln != null)) {
        this.xln.s(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramn.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof com.tencent.mm.aq.c))
        {
          paramString = ((com.tencent.mm.aq.c)paramn).aEo().ProductID;
          ac.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramn = new Intent();
          paramn.putExtra("extra_id", paramString);
          paramn.putExtra("preceding_scence", 11);
          paramn.putExtra("download_entrance_scene", 14);
          com.tencent.mm.br.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramn);
          ac.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          if (this.xln != null) {
            this.xln.s(3, null);
          }
          AppMethodBeat.o(52054);
        }
      }
      else {
        ac.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(52054);
  }
  
  public final void pe(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.xln != null)
      {
        this.xln.s(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else if (this.xln != null) {
      this.xln.s(3, null);
    }
    AppMethodBeat.o(52056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */