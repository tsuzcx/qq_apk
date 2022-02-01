package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.qf;
import com.tencent.mm.f.a.qf.b;
import com.tencent.mm.f.a.ul;
import com.tencent.mm.f.a.ul.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.ag.a.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.ao;
import com.tencent.mm.plugin.scanner.g.e.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.o;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.f.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.an.i, a.a
{
  private static final String IYD;
  private boolean IKW;
  private boolean IOs;
  private int IPa;
  private int IYE;
  private String IYF;
  private Bundle IYG;
  private e.a IYH;
  private Map<com.tencent.mm.an.q, Integer> IYI;
  private boolean IYJ;
  private boolean IYp;
  private int IYq;
  private com.tencent.mm.plugin.scanner.view.c IYs;
  private com.tencent.e.i.d<?> IYt;
  private TimerTask IYu;
  public String appId;
  private int fys;
  private int fyt;
  public String fyv;
  public String imagePath;
  public WeakReference<Activity> mActivityRef;
  public String source;
  public int sourceType;
  public ProgressDialog syZ;
  public String talker;
  private String typeName;
  public int wGA;
  
  static
  {
    AppMethodBeat.i(220074);
    IYD = "https://" + WeChatHosts.domainString(l.i.host_payapp_weixin_qq_com) + "/qr/";
    AppMethodBeat.o(220074);
  }
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.IKW = false;
    this.IYq = -1;
    this.IOs = false;
    this.syZ = null;
    this.IYH = null;
    this.IYs = null;
    this.IYI = new HashMap();
    this.IYt = null;
    this.IYu = null;
    this.IYJ = false;
    Log.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.h.aGY().a(106, this);
    com.tencent.mm.kernel.h.aGY().a(233, this);
    com.tencent.mm.kernel.h.aGY().a(666, this);
    com.tencent.mm.kernel.h.aGY().a(372, this);
    com.tencent.mm.kernel.h.aGY().a(3512, this);
    com.tencent.mm.kernel.h.aGY().a(6889, this);
    AppMethodBeat.o(52043);
  }
  
  private void a(Activity paramActivity, int paramInt, final String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(52052);
    Log.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, paramInt, 5, paramBoolean);
      this.IYI.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      paramString = new c.a()
      {
        public final void fEM()
        {
          AppMethodBeat.i(218199);
          com.tencent.mm.kernel.h.aGY().a(paramString);
          if (c.b(c.this) != null) {
            c.b(c.this).t(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(218199);
        }
      };
      if (paramActivity == null) {
        break label129;
      }
      if ((!paramBoolean) || (!this.IYJ)) {
        break;
      }
      c(paramActivity.getString(l.i.eRw), paramString);
      AppMethodBeat.o(52052);
      return;
    }
    a(paramActivity.getString(l.i.eRw), paramString);
    label129:
    AppMethodBeat.o(52052);
  }
  
  private void a(Activity paramActivity, final String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(52053);
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject1;
    Object localObject6;
    Object localObject5;
    Object localObject2;
    if (this.wGA > 0)
    {
      i = this.wGA;
      Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.IYE), Integer.valueOf(i) });
      localObject4 = "";
      localObject3 = "";
      localObject1 = "";
      localObject6 = "";
      localObject5 = "";
      localObject2 = localObject1;
      if (this.IYG == null) {
        break label399;
      }
      String str1 = this.IYG.getString("stat_send_msg_user");
      localObject2 = this.IYG.getString("stat_msg_id");
      if (!Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((String)localObject2).replace("msg_", "").replace("sns_", "");
      }
      String str2 = this.IYG.getString("stat_chat_talker_username");
      String str3 = this.IYG.getString("wxappPathWithQuery");
      String str4 = this.IYG.getString("stat_url");
      localObject2 = localObject1;
      localObject5 = str4;
      localObject3 = str2;
      localObject6 = str3;
      localObject4 = str1;
      if (paramString2 != null) {
        break label399;
      }
      paramString2 = this.IYG.getString("stat_app_id");
      localObject5 = str4;
      localObject6 = str3;
      localObject4 = str1;
      localObject3 = str2;
    }
    for (;;)
    {
      paramString1 = new l(paramString1, (String)localObject3, i, paramInt1, paramInt2, paramString2, l.boo(), new byte[0], (String)localObject4, (String)localObject1);
      paramInt1 = f.a.atF(this.IYE);
      paramString1.setSubScene(paramInt1);
      if ((localObject5 != null) && (((String)localObject5).startsWith("http"))) {
        paramString1.WW((String)localObject5);
      }
      paramString1.WX((String)localObject6);
      Log.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d, wxaPathWithQuery: %s, appId=%s", new Object[] { localObject5, Integer.valueOf(paramInt1), localObject6, paramString2 });
      this.IYI.put(paramString1, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
      if (this.syZ != null) {
        this.syZ.dismiss();
      }
      a(paramActivity.getString(l.i.IEJ), new c.a()
      {
        public final void fEM()
        {
          AppMethodBeat.i(221802);
          com.tencent.mm.kernel.h.aGY().a(paramString1);
          if (c.b(c.this) != null) {
            c.b(c.this).t(1, null);
          }
          c.a(c.this, paramString1);
          AppMethodBeat.o(221802);
        }
      });
      AppMethodBeat.o(52053);
      return;
      i = adY(this.IYE);
      break;
      label399:
      localObject1 = localObject2;
    }
  }
  
  private void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52044);
    boolean bool2 = this.IOs;
    if (this.IYs == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.IYs != null) && (this.IOs))
    {
      cancelLoading();
      this.IYu = new i(this.IYs, new i.b()
      {
        public final void onShow()
        {
          AppMethodBeat.i(220797);
          c.a(c.this);
          AppMethodBeat.o(220797);
        }
      }, parama);
      this.IYt = com.tencent.e.h.ZvG.o(this.IYu, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean aXx(String paramString)
  {
    AppMethodBeat.i(52049);
    if ((paramString.startsWith("weixin://wxpay/bizpayurl")) || (paramString.startsWith("https://wx.tenpay.com/f2f")) || (paramString.startsWith("wxp://f2f")) || (paramString.startsWith("wxhb://f2f")) || (paramString.startsWith("wxp://wbf2f")) || (paramString.startsWith("m")) || (paramString.startsWith(IYD)) || (paramString.startsWith("n")))
    {
      AppMethodBeat.o(52049);
      return true;
    }
    AppMethodBeat.o(52049);
    return false;
  }
  
  private static int abT(int paramInt)
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
  
  private static int adY(int paramInt)
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
  
  private void adZ(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.IYG != null)
    {
      localObject2 = this.IYG.getString("stat_url");
      if (((this.sourceType == 6) || (this.sourceType == 0)) && (!Util.isNullOrNil((String)localObject2)))
      {
        localObject1 = "";
        localObject4 = "";
      }
    }
    try
    {
      localObject2 = URLEncoder.encode(Util.nullAsNil((String)localObject2), "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode(Util.nullAsNil(this.IYF), "UTF-8");
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.QBarStringHandler", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52047);
    if (this.syZ != null) {
      this.syZ.dismiss();
    }
    if (this.mActivityRef != null) {}
    for (Activity localActivity = (Activity)this.mActivityRef.get(); localActivity == null; localActivity = null)
    {
      AppMethodBeat.o(52047);
      return;
    }
    this.syZ = com.tencent.mm.ui.base.h.a(localActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.fEM();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(220056);
    if (this.IYH != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("key_scan_qr_code_result", paramBoolean);
      this.IYH.t(3, localBundle);
    }
    AppMethodBeat.o(220056);
  }
  
  private void c(String paramString, c.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.IOs;
    if (this.IYs == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.IYs == null) || (!this.IOs)) {
        break;
      }
      this.IYJ = true;
      this.IYs.a(true, false, parama);
      AppMethodBeat.o(52045);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52045);
  }
  
  private void cancelLoading()
  {
    AppMethodBeat.i(52046);
    Log.i("MicroMsg.QBarStringHandler", "alvinluo cancelLoading");
    if (this.IYs != null) {
      this.IYs.a(false, false, null);
    }
    if ((this.syZ != null) && (this.syZ.isShowing())) {
      this.syZ.dismiss();
    }
    if (this.IYt != null) {
      this.IYt.cancel(false);
    }
    if (this.IYu != null) {
      this.IYu.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int fqU()
  {
    switch (this.IYE)
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
    Log.i("MicroMsg.QBarStringHandler", "onPause");
    com.tencent.mm.kernel.h.aGY().b(106, this);
    com.tencent.mm.kernel.h.aGY().b(233, this);
    com.tencent.mm.kernel.h.aGY().b(666, this);
    com.tencent.mm.kernel.h.aGY().b(372, this);
    com.tencent.mm.kernel.h.aGY().b(3512, this);
    com.tencent.mm.kernel.h.aGY().b(6889, this);
    AppMethodBeat.o(52051);
  }
  
  private static void y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220061);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vOk, 0) == 0)
    {
      AppMethodBeat.o(220061);
      return;
    }
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      if (paramArrayOfByte == null) {}
      for (int i = 0;; i = paramArrayOfByte.length)
      {
        Log.e("MicroMsg.QBarStringHandler", String.format("result: %s, img: %d", new Object[] { paramString, Integer.valueOf(i) }));
        AppMethodBeat.o(220061);
        return;
      }
    }
    paramString = new com.tencent.mm.plugin.collect.model.n(paramString, new com.tencent.mm.cd.b(paramArrayOfByte));
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    AppMethodBeat.o(220061);
  }
  
  public final void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(219962);
    a(paramActivity, paramString1, paramInt1, paramString2, paramInt2, paramInt3, null, null, paramBundle, paramInt4, paramBoolean1, paramInt5, paramBoolean2, null);
    AppMethodBeat.o(219962);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, e.a parama, final com.tencent.mm.plugin.scanner.view.c paramc, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(219986);
    Log.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.h.aGY().bih()), Boolean.valueOf(paramBoolean2) });
    this.mActivityRef = new WeakReference(paramActivity);
    this.IYE = paramInt1;
    this.IYF = paramString1;
    this.fys = paramInt2;
    this.fyt = paramInt3;
    this.typeName = paramString2;
    this.IYH = parama;
    this.IYG = paramBundle;
    this.IYp = paramBoolean1;
    this.IPa = paramInt4;
    this.IOs = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.IKW = bool;
      this.IYq = paramInt5;
      this.IYs = paramc;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!Util.isNullOrNil(paramString1)) {
        break;
      }
      Log.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(219986);
      return;
    }
    paramc = (Context)this.mActivityRef.get();
    if (com.tencent.mm.kernel.h.aGY().bih() == 0)
    {
      paramBoolean1 = NetStatusUtil.isConnected(paramc);
      if (this.IYH != null)
      {
        paramString2 = null;
        if (aXx(paramString1))
        {
          paramString2 = new Bundle();
          paramString2.putBoolean("key_offline_scan_show_tips", false);
        }
        this.IYH.t(0, paramString2);
        this.IYH.t(6, paramString2);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.IYp) {
          break label480;
        }
        paramString2 = b.IYA;
        if (!b.xI(paramBoolean2)) {
          break label480;
        }
        Log.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!aXx(paramString1))
        {
          paramString2 = b.IYA;
          paramString2 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.IKW, paramBundle);
          if (!paramBoolean1) {
            break label463;
          }
          paramActivity = paramc.getString(l.i.IFe);
          label416:
          b.a(paramString2, paramActivity, false);
        }
        paramActivity = o.IKX;
        paramActivity = this.typeName;
        if (!this.IKW) {
          break label475;
        }
      }
      label463:
      label475:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        o.b(paramString1, paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(219986);
        return;
        paramInt4 = 1;
        break;
        paramActivity = paramc.getString(l.i.IFh);
        break label416;
      }
      label480:
      if (this.IYp)
      {
        paramString1 = b.IYA;
        if (b.xI(paramBoolean2))
        {
          paramString1 = b.IYA;
          if (paramBoolean1) {}
          for (paramString1 = paramc.getString(l.i.IFe);; paramString1 = paramc.getString(l.i.IFh))
          {
            b.k(paramActivity, paramString1);
            AppMethodBeat.o(219986);
            return;
          }
        }
      }
      Toast.makeText(paramActivity, paramActivity.getString(l.i.fmt_iap_err), 0).show();
      AppMethodBeat.o(219986);
      return;
    }
    parama = "";
    if (paramString1.startsWith("weixin://qr/")) {
      parama = paramString1.substring(12) + "@qr";
    }
    if (!Util.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(219986);
      return;
    }
    if (aXx(paramString1))
    {
      Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = b.IYA;
        if (b.xI(paramBoolean2))
        {
          parama = o.IKX;
          parama = this.typeName;
          if (!this.IKW) {
            break label957;
          }
        }
      }
    }
    label957:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      o.b(paramString1, parama, paramInt1, 4, 0);
      Log.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
      if (!paramString1.startsWith("weixin://wxpay/bizpayurl")) {
        break;
      }
      Log.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      paramInt1 = adY(this.IYE);
      paramInt2 = abT(paramInt1);
      paramActivity = new qf();
      paramActivity.fOS.url = paramString1;
      paramActivity.fOS.channel = paramInt2;
      paramActivity.fOS.scene = paramInt1;
      paramActivity.fOS.context = paramc;
      if (paramInt2 == 13)
      {
        Log.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.fOS.source = this.source;
        paramActivity.fOS.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((paramc == null) || (paramActivity.fOT == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.fOT.ret == 1)
          {
            c.this.wo(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.fOT.ret == 2) {
            c.this.wo(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      EventCenter.instance.asyncPublish(paramActivity, Looper.myLooper());
      if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52037);
            if ((c.b(c.this) != null) && ((paramActivity.fOT == null) || (paramActivity.fOT.ret != 1))) {
              c.a(c.this, false);
            }
            AppMethodBeat.o(52037);
          }
        }, 10000L);
      }
      adZ(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
      AppMethodBeat.o(219986);
      return;
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      Log.d("MicroMsg.QBarStringHandler", "go to payment code");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayCode.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        AppMethodBeat.o(219986);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 1, paramString1, abT(adY(this.IYE)), null);
      b(true, null);
      adZ(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      y(paramString1, paramArrayOfByte);
      AppMethodBeat.o(219986);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 6, paramString1, abT(adY(this.IYE)), null);
      b(true, null);
      adZ(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(219986);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      Log.i("MicroMsg.QBarStringHandler", "go to reward");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        AppMethodBeat.o(219986);
        return;
      }
      paramInt2 = abT(adY(this.IYE));
      paramInt1 = 1;
      if (this.wGA == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(paramc, paramString1, paramInt2, paramString2, paramInt1);
        b(true, null);
        adZ(11);
        com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(219986);
        return;
        if (this.wGA == 38) {
          paramInt1 = 3;
        } else if (this.wGA == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith(IYD))
    {
      Log.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 1, paramString1, abT(adY(this.IYE)), null);
      b(true, null);
      adZ(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      y(paramString1, paramArrayOfByte);
      AppMethodBeat.o(219986);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        if (this.IYH != null) {
          this.IYH.t(5, null);
        }
        AppMethodBeat.o(219986);
        return;
      }
      Log.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      paramInt1 = adY(this.IYE);
      paramInt2 = abT(paramInt1);
      paramActivity = new ul();
      paramActivity.fTK.fTM = paramString1;
      paramActivity.fTK.scene = paramInt1;
      paramActivity.fTK.type = 1;
      paramActivity.fTK.aFX = new WeakReference(paramc);
      paramActivity.fTK.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218560);
          if (!Util.isNullOrNil(paramActivity.fTL.errMsg))
          {
            if (paramc != null) {
              Toast.makeText(paramc, paramActivity.fTL.errMsg, 1).show();
            }
            c.a(c.this, false);
            AppMethodBeat.o(218560);
            return;
          }
          if (Util.isNullOrNil(paramActivity.fTL.fTN))
          {
            Log.w("MicroMsg.QBarStringHandler", "resp url is null!");
            c.a(c.this, false);
            AppMethodBeat.o(218560);
            return;
          }
          if (paramActivity.fTL.actionType == 1)
          {
            com.tencent.mm.pluginsdk.wallet.f.a(paramc, paramActivity.fTL.fTN, paramInt2, paramString2, paramInt1);
            c.a(c.this, true);
            AppMethodBeat.o(218560);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramActivity.fTL.fTN);
          com.tencent.mm.plugin.scanner.m.cYL().h(localIntent, paramc);
          c.a(c.this, true);
          AppMethodBeat.o(218560);
        }
      };
      EventCenter.instance.publish(paramActivity);
      adZ(11);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(219986);
      return;
    }
    if (paramString1.startsWith("weixin://wxpay/bindurl"))
    {
      Log.i("MicroMsg.QBarStringHandler", "fast bind card qrcode");
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      paramInt1 = abT(adY(this.IYE));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startFastBindUseCase(paramString1, paramInt1, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(218668);
          if (c.b(c.this) != null) {
            c.b(c.this).t(3, null);
          }
          AppMethodBeat.o(218668);
        }
      });
      AppMethodBeat.o(219986);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      Log.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(219986);
        return;
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanFace2Face.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        if (this.IYH != null) {
          this.IYH.t(5, null);
        }
        AppMethodBeat.o(219986);
        return;
      }
      if (this.IYH != null) {
        this.IYH.t(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.by.c.b(paramc, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.h.IzE.a(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      adZ(11);
      AppMethodBeat.o(219986);
      return;
    }
    paramString2 = new com.tencent.mm.plugin.scanner.d();
    paramString2.activity = paramActivity;
    paramString2.IAC = paramString1;
    paramString2.fys = paramInt2;
    paramString2.fyt = paramInt3;
    EventCenter.instance.publish(paramString2);
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.IYH != null) {
      this.IYH.t(5, null);
    }
    AppMethodBeat.o(219986);
  }
  
  public final void fEQ()
  {
    AppMethodBeat.i(52050);
    Log.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.IYF = null;
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    onPause();
    AppMethodBeat.o(52050);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(220055);
    if (this.mActivityRef != null)
    {
      Context localContext = (Context)this.mActivityRef.get();
      AppMethodBeat.o(220055);
      return localContext;
    }
    AppMethodBeat.o(220055);
    return null;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(52054);
    Log.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramq == null)
    {
      if (paramq == null) {}
      for (bool = true;; bool = false)
      {
        Log.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.IYH != null) {
          this.IYH.t(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.IYI.containsKey(paramq))
    {
      if ((paramq instanceof com.tencent.mm.at.c)) {
        Log.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.IYI.remove(paramq);
      cancelLoading();
      if ((paramq.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new l(((com.tencent.mm.openim.b.n)paramq).myl, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
      this.IYI.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(52054);
      return;
    }
    Log.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
    AppMethodBeat.o(52054);
    return;
    label246:
    if (this.mActivityRef != null) {}
    for (paramString = (Activity)this.mActivityRef.get(); (paramInt1 == 4) && (paramInt2 == -4); paramString = null)
    {
      if (paramString != null) {
        com.tencent.mm.ui.base.h.a(paramString, l.i.IEH, l.i.app_tip, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(223291);
            if (c.b(c.this) != null) {
              c.b(c.this).t(1, null);
            }
            AppMethodBeat.o(223291);
          }
        });
      }
      AppMethodBeat.o(52054);
      return;
    }
    Object localObject1 = b.IYA;
    if (b.xI(this.IOs))
    {
      localObject1 = b.IYA;
      if (b.b(paramInt1, paramq))
      {
        if (!this.IYp)
        {
          Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.IYH != null) {
            this.IYH.t(7, null);
          }
          if (paramString != null)
          {
            paramq = b.IYA;
            b.a(new OfflineScanContext(paramString, 2, this.IYF, this.IYE, this.fys, this.fyt, this.typeName, this.IKW, this.IYG), paramString.getString(l.i.IFe), true);
            paramString = o.IKX;
            paramString = this.IYF;
            paramq = this.typeName;
            if (this.IKW) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              o.b(paramString, paramq, paramInt1, 2, 0);
              AppMethodBeat.o(52054);
              return;
            }
          }
        }
        else if (paramString != null)
        {
          paramq = b.IYA;
          b.k(paramString, paramString.getString(l.i.IFd));
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    int i;
    if (this.mActivityRef != null)
    {
      localObject1 = (Activity)this.mActivityRef.get();
      switch (paramInt1)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label705;
      }
      if (this.IYH != null) {
        this.IYH.t(0, null);
      }
      AppMethodBeat.o(52054);
      return;
      localObject1 = null;
      break;
      if (localObject1 != null)
      {
        if (!com.tencent.mm.kernel.h.aGY().bii()) {
          break label622;
        }
        com.tencent.mm.kernel.h.aGY().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        label622:
        if (com.tencent.mm.network.ag.dj((Context)localObject1)) {
          com.tencent.mm.pluginsdk.ui.tools.n.jF((Context)localObject1);
        } else {
          Toast.makeText((Context)localObject1, ((Context)localObject1).getString(l.i.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      if (localObject1 != null) {
        Toast.makeText((Context)localObject1, ((Context)localObject1).getString(l.i.fmt_iap_err), 1).show();
      }
      i = 1;
    }
    label705:
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      if (paramString != null) {
        com.tencent.mm.ui.base.h.p(paramString, l.i.qrcode_ban_by_expose, l.i.app_tip);
      }
      if (this.IYH != null) {
        this.IYH.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramString != null) {
        Toast.makeText(paramString, paramString.getString(l.i.fmt_search_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.IYH != null) {
        this.IYH.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    localObject1 = b.IYA;
    Object localObject2;
    if ((b.o(paramq)) && (!this.IYp))
    {
      localObject1 = o.IKX;
      localObject1 = this.IYF;
      localObject2 = this.typeName;
      if (this.IKW)
      {
        i = 2;
        o.b((String)localObject1, (String)localObject2, i, 4, 0);
      }
    }
    else
    {
      if (paramq.getType() != 106) {
        break label2073;
      }
      localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramq;
      if (((com.tencent.mm.plugin.messenger.a.f)localObject1).EUK) {
        break label1150;
      }
      if (this.mActivityRef == null) {
        break label1134;
      }
      paramString = (Activity)this.mActivityRef.get();
      label928:
      if (paramString == null) {
        break label1150;
      }
      localObject1 = ((com.tencent.mm.plugin.messenger.a.f)localObject1).eRV();
      if ((!as.asD(((ebp)localObject1).TxF)) || (((ebp)localObject1).TxM == null) || (Util.isNullOrNil(((ebp)localObject1).TxM.mVN)) || (!com.tencent.mm.modelappbrand.a.SE(((ebp)localObject1).TxM.mVN))) {
        break label1150;
      }
      if (this.wGA <= 0) {
        break label1139;
      }
      paramInt1 = this.wGA;
      label998:
      Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.IYF, Integer.valueOf(this.IYE), Integer.valueOf(paramInt1) });
      localObject1 = new l(this.IYF, null, 43, 0, 0, new byte[0]);
      this.IYI.put(localObject1, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      if (this.syZ != null) {
        this.syZ.dismiss();
      }
      a(paramString.getString(l.i.IEJ), new c.a()
      {
        public final void fEM()
        {
          AppMethodBeat.i(222706);
          com.tencent.mm.kernel.h.aGY().a(this.IYM);
          if (c.b(c.this) != null) {
            c.b(c.this).t(1, null);
          }
          AppMethodBeat.o(222706);
        }
      });
    }
    label1134:
    label1139:
    label1150:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label1155;
      }
      AppMethodBeat.o(52054);
      return;
      i = 1;
      break;
      paramString = null;
      break label928;
      paramInt1 = adY(this.IYE);
      break label998;
    }
    label1155:
    localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramq).eRV();
    String str1;
    Object localObject3;
    Object localObject4;
    if (this.mActivityRef != null)
    {
      paramString = (Activity)this.mActivityRef.get();
      str1 = com.tencent.mm.platformtools.z.a(((ebp)localObject1).SrH);
      Log.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((ebp)localObject1).SrH);
      com.tencent.mm.am.q.bhz().h(str1, com.tencent.mm.platformtools.z.a(((ebp)localObject1).RIH));
      if ((this.syZ != null) && (this.syZ.isShowing()))
      {
        Log.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
        this.syZ.dismiss();
      }
      cancelLoading();
      if (Util.nullAsNil(str1).length() <= 0) {
        break label2028;
      }
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(str1);
      if ((localObject3 == null) || (!com.tencent.mm.contact.d.rk(((ax)localObject3).field_type)) || (!((as)localObject3).hxX()) || (paramString == null)) {
        break label1525;
      }
      localObject2 = af.bjv().Uo(str1);
      ((com.tencent.mm.api.c)localObject2).dc(false);
      localObject4 = ((com.tencent.mm.api.c)localObject2).eZc;
      if (((c.b)localObject4).eZg != null) {
        ((c.b)localObject4).eZx = ((c.b)localObject4).eZg.optInt("ScanQRCodeType", 0);
      }
      if (((c.b)localObject4).eZx != 1) {
        break label1520;
      }
      paramInt1 = 1;
      label1394:
      if ((paramInt1 == 0) || (((com.tencent.mm.api.c)localObject2).YX())) {
        break label1525;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("Chat_User", str1);
      ((Intent)localObject1).putExtra("finish_direct", true);
      com.tencent.mm.plugin.scanner.m.cYL().d((Intent)localObject1, paramString);
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label2048;
      }
      if (this.IYH != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", com.tencent.mm.platformtools.z.a(((com.tencent.mm.plugin.messenger.a.f)paramq).eRV().SrH));
        paramString.putInt("geta8key_action_code", 4);
        b(true, paramString);
      }
      adZ(4);
      AppMethodBeat.o(52054);
      return;
      paramString = null;
      break;
      label1520:
      paramInt1 = 0;
      break label1394;
      label1525:
      paramInt1 = fqU();
      localObject2 = new Intent();
      com.tencent.mm.api.d.a((Intent)localObject2, (ebp)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.contact.d.rk(((ax)localObject3).field_type))) {
        ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
      }
      if ((((ebp)localObject1).TxF & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, str1 + "," + paramInt1);
      }
      if (paramString != null)
      {
        if ((as.asD(((ebp)localObject1).TxF)) && (paramString != null))
        {
          ((Intent)localObject2).putExtra("qbarScene", this.IYE);
          str1 = paramString.getIntent().getStringExtra("img_gallery_session_id");
          if (!Util.isNullOrNil(str1))
          {
            Object localObject5 = ad.beh().Rn(str1);
            if (localObject5 != null)
            {
              str1 = ((ad.b)localObject5).getString("preUsername", null);
              localObject3 = ((ad.b)localObject5).getString("preChatName", null);
              localObject4 = ((ad.b)localObject5).getString("url", null);
              String str2 = ((ad.b)localObject5).getString("rawUrl", null);
              paramInt1 = ((ad.b)localObject5).getInt("Contact_Sub_Scene", 0);
              paramInt2 = ac.aN(str1, (String)localObject3);
              localObject5 = ((ad.b)localObject5).getString("Contact_Scene_Note", null);
              ((Intent)localObject2).putExtra("preUsername", str1);
              ((Intent)localObject2).putExtra("preChatName", (String)localObject3);
              ((Intent)localObject2).putExtra("url", (String)localObject4);
              ((Intent)localObject2).putExtra("rawUrl", str2);
              ((Intent)localObject2).putExtra("preChatTYPE", paramInt2);
              ((Intent)localObject2).putExtra("Contact_Sub_Scene", paramInt1);
              ((Intent)localObject2).putExtra("Contact_Scene_Note", (String)localObject5);
            }
          }
        }
        if (this.IYE != 0) {
          break label1972;
        }
        ((Intent)localObject2).putExtra("Contact_Sub_Scene", 7);
        label1851:
        com.tencent.mm.plugin.scanner.m.cYL().c((Intent)localObject2, paramString);
        paramString = "";
        if (ab.Qm(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        if (!as.asD(((ebp)localObject1).TxF)) {
          break label2023;
        }
      }
      label1972:
      label2023:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.IYE), this.imagePath, this.IYF, Util.nullAsNil(this.fyv), paramString });
        paramInt1 = 1;
        break;
        if (this.sourceType == 7)
        {
          ((Intent)localObject2).putExtra("Contact_Sub_Scene", 4);
          break label1851;
        }
        if ((this.sourceType != 3) && (this.sourceType != 5)) {
          break label1851;
        }
        ((Intent)localObject2).putExtra("Contact_Sub_Scene", 2);
        break label1851;
      }
      label2028:
      if (paramString != null) {
        Toast.makeText(paramString, l.i.IFq, 0).show();
      }
      paramInt1 = 0;
    }
    label2048:
    if (this.IYH != null) {
      this.IYH.t(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label2073:
    if (paramq.getType() == 372)
    {
      paramq = ((com.tencent.mm.openim.b.n)paramq).myk;
      localObject1 = paramq.UserName;
      Log.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(localObject1)));
      cancelLoading();
      if (this.mActivityRef != null)
      {
        paramString = (Activity)this.mActivityRef.get();
        if (Util.nullAsNil((String)localObject1).length() <= 0) {
          break label2365;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)localObject1);
        paramInt1 = fqU();
        localObject2 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject2, paramq, paramInt1);
        if ((localObject1 != null) && (!com.tencent.mm.contact.d.rk(((ax)localObject1).field_type))) {
          ((Intent)localObject2).putExtra("Contact_IsLBSFriend", true);
        }
        if (paramString != null)
        {
          com.tencent.mm.plugin.scanner.m.cYL().c((Intent)localObject2, paramString);
          com.tencent.mm.plugin.report.service.h.IzE.a(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.IYE), this.imagePath, this.IYF, Util.nullAsNil(this.fyv) });
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label2385;
        }
        if (this.IYH != null)
        {
          paramString = new Bundle();
          paramString.putString("geta8key_fullurl", paramq.UserName);
          paramString.putInt("geta8key_action_code", 4);
          b(true, paramString);
        }
        adZ(4);
        AppMethodBeat.o(52054);
        return;
        paramString = null;
        break;
        label2365:
        if (paramString != null) {
          Toast.makeText(paramString, l.i.IFq, 0).show();
        }
      }
      label2385:
      if (this.IYH != null) {
        this.IYH.t(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramq.getType() == 6889)
    {
      ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).handleGetBrandResult(paramString, paramq, this.IYE);
      b(true, null);
      AppMethodBeat.o(52054);
      return;
    }
    if (paramq.getType() == 3512)
    {
      paramq = (awa)d.c.b(((com.tencent.mm.an.d)paramq.getReqResp()).lBS);
      if (paramq.SFU.size() > 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("finder_username", ((FinderContact)paramq.SFU.get(0)).username);
        ((Intent)localObject1).putExtra("key_comment_scene", 10);
        ((Intent)localObject1).putExtra("key_enter_profile_type", 3);
        ((Intent)localObject1).putExtra("key_finder_teen_mode_check", true);
        ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 6);
        ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((FinderContact)paramq.SFU.get(0)).nickname);
        ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((FinderContact)paramq.SFU.get(0)).username);
        if (paramq.SIt != null) {
          localObject2 = new com.tencent.mm.ad.i();
        }
      }
      try
      {
        ((com.tencent.mm.ad.i)localObject2).al("qrcodeType", paramq.SIt.scene);
        ((Intent)localObject1).putExtra("key_udf_kv", ((com.tencent.mm.ad.i)localObject2).toString());
        paramInt2 = 32;
        if (((FinderContact)paramq.SFU.get(0)).username.equals(com.tencent.mm.model.z.bdh())) {
          paramInt2 = 33;
        }
        switch (this.sourceType)
        {
        default: 
          paramInt1 = 0;
          ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(paramInt1, 16, paramInt2, (Intent)localObject1);
          if (paramString != null) {
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(paramString, (Intent)localObject1);
          }
          b(true, null);
          AppMethodBeat.o(52054);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.QBarStringHandler", "[FinderGetUserResponse] err.msg = " + localException.getMessage());
          continue;
          paramInt1 = 2;
          continue;
          paramInt1 = 3;
          continue;
          paramInt1 = 4;
          continue;
          paramInt1 = 22;
        }
      }
    }
    if (paramq.getType() == 233)
    {
      localObject1 = ((l)paramq).bof();
      Bundle localBundle = new Bundle();
      localBundle.putString("geta8key_fullurl", (String)localObject1);
      localBundle.putInt("geta8key_action_code", ((l)paramq).boh());
      adZ(((l)paramq).boh());
      if (this.wGA > 0) {}
      for (paramInt1 = this.wGA;; paramInt1 = adY(this.IYE))
      {
        Log.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.ag.a.a.a(this, (l)paramq, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(223452);
            if (c.b(c.this) != null) {
              c.b(c.this).t(1, null);
            }
            AppMethodBeat.o(223452);
          }
        }, this.IYF, paramInt1, this.IYE, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(223682);
            c.a(c.this, true);
            AppMethodBeat.o(223682);
          }
        }, this.IYG);
        if ((bool) || (((l)paramq).boh() != 4)) {
          break;
        }
        if (paramString != null) {
          a(paramString, this.IYE, (String)localObject1, true);
        }
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((l)paramq).boh() == 29))
      {
        if (paramString != null)
        {
          Log.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { localObject1 });
          paramq = new com.tencent.mm.openim.b.n((String)localObject1, (byte)0);
          this.IYI.put(paramq, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aGY().a(paramq, 0);
          paramq = new c.a()
          {
            public final void fEM()
            {
              AppMethodBeat.i(219318);
              com.tencent.mm.kernel.h.aGY().a(paramq);
              if (c.b(c.this) != null) {
                c.b(c.this).t(1, null);
              }
              AppMethodBeat.o(219318);
            }
          };
          if (paramString != null)
          {
            if (this.IYJ)
            {
              c(paramString.getString(l.i.eRw), paramq);
              AppMethodBeat.o(52054);
              return;
            }
            a(paramString.getString(l.i.eRw), paramq);
          }
        }
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((l)paramq).boh() == 37))
      {
        if (paramString != null)
        {
          Log.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { localObject1 });
          paramq = new ArrayList();
          paramq.add(localObject1);
          paramq = new ao(paramq);
          this.IYI.put(paramq, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aGY().a(paramq, 0);
          paramString.getString(l.i.app_tip);
          this.syZ = com.tencent.mm.ui.base.h.b(paramString, paramString.getString(l.i.eRw), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(217810);
              com.tencent.mm.kernel.h.aGY().a(paramq);
              if (c.b(c.this) != null) {
                c.b(c.this).t(1, null);
              }
              AppMethodBeat.o(217810);
            }
          });
        }
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((l)paramq).boh() == 45))
      {
        paramq = "";
        Log.i("MicroMsg.QBarStringHandler", "GameLive, qbar:" + this.IYF);
      }
    }
    try
    {
      localObject1 = Uri.parse(this.IYF).getQueryParameter("ticket_s");
      paramq = (com.tencent.mm.an.q)localObject1;
    }
    catch (Throwable localThrowable)
    {
      label3372:
      break label3372;
    }
    if (!Util.isNullOrNil(paramq))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("KEY_TICKET", paramq);
      ((Intent)localObject1).putExtra("KEY_FROM_SCAN", true);
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderGameLiveAuthUI(paramString, (Intent)localObject1);
    }
    AppMethodBeat.o(52054);
    return;
    if ((!bool) && (((l)paramq).boh() == 46))
    {
      paramString = "";
      Log.i("MicroMsg.QBarStringHandler", "jumpLiveUIAndDoAction, qbar:" + this.IYF);
    }
    try
    {
      paramq = Uri.parse(this.IYF).getQueryParameter("id");
      paramString = paramq;
    }
    catch (Throwable paramq)
    {
      label3498:
      break label3498;
    }
    if (!Util.isNullOrNil(paramString))
    {
      paramq = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).genContextId(11, 8, 65);
      localObject1 = com.tencent.mm.model.z.bdh();
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderUtilApi().f(1, paramString, (String)localObject1, paramq, "");
    }
    AppMethodBeat.o(52054);
    return;
    if ((!bool) && (((l)paramq).boh() == 47))
    {
      if (paramString != null) {}
      for (bool = true;; bool = false)
      {
        Log.i("MicroMsg.QBarStringHandler", "jumpSetStatus, cnotnull:%s qbar:%s", new Object[] { Boolean.valueOf(bool), this.IYF });
        if (paramString != null)
        {
          paramq = this.IYF;
          paramq = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).createGetBrandInfoScene(paramq);
          this.IYI.put(paramq, Integer.valueOf(1));
          com.tencent.mm.kernel.h.aGY().a(paramq, 0);
          paramString.getString(l.i.app_tip);
          this.syZ = com.tencent.mm.ui.base.h.b(paramString, paramString.getString(l.i.eRw), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(222240);
              com.tencent.mm.kernel.h.aGY().a(paramq);
              if (c.b(c.this) != null) {
                c.b(c.this).t(1, null);
              }
              AppMethodBeat.o(222240);
            }
          });
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if ((!bool) && (((l)paramq).boh() == 41))
    {
      paramq = new Intent();
      paramq.putExtra("key_qrcode_string", (String)localObject1);
      com.tencent.mm.by.c.b(paramString, "account", ".friend.ui.RecoverAccountUI1", paramq);
      AppMethodBeat.o(52054);
      return;
    }
    Log.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
    if ((!bool) && (this.IYH != null)) {
      this.IYH.t(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    if (paramq.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.at.c))
        {
          paramq = ((com.tencent.mm.at.c)paramq).bkT().ProductID;
          Log.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramq });
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_id", paramq);
          ((Intent)localObject1).putExtra("preceding_scence", 11);
          ((Intent)localObject1).putExtra("download_entrance_scene", 14);
          com.tencent.mm.by.c.b(paramString, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject1);
          Log.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          b(true, null);
          AppMethodBeat.o(52054);
        }
      }
      else {
        Log.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(52054);
  }
  
  public final void wo(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.IYH != null)
      {
        this.IYH.t(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else {
      b(true, null);
    }
    AppMethodBeat.o(52056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */