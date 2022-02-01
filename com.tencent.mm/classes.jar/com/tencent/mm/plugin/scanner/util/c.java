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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.rs;
import com.tencent.mm.autogen.a.rs.b;
import com.tencent.mm.autogen.a.wb;
import com.tencent.mm.autogen.a.wb.b;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.findersdk.a.cs;
import com.tencent.mm.plugin.qrcode.model.a.a;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.qbar.ScanIdentifyReportInfo;
import com.tencent.threadpool.i;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public final class c
  implements com.tencent.mm.am.h, a.a
{
  private static final String Pia;
  public int AcJ;
  private boolean ORR;
  private boolean OVu;
  private int OXB;
  private boolean PhN;
  private int PhO;
  private com.tencent.mm.plugin.scanner.view.c PhR;
  private com.tencent.threadpool.i.d<?> PhS;
  private TimerTask PhT;
  private int Pib;
  private String Pic;
  private Bundle Pid;
  private com.tencent.mm.plugin.scanner.g.f.a Pie;
  private Map<p, Integer> Pif;
  private boolean Pig;
  public String appId;
  private int hDb;
  private int hDc;
  public String hDe;
  public String imagePath;
  public WeakReference<Activity> mActivityRef;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  public ProgressDialog vEG;
  
  static
  {
    AppMethodBeat.i(314311);
    Pia = "https://" + WeChatHosts.domainString(l.i.host_payapp_weixin_qq_com) + "/qr/";
    AppMethodBeat.o(314311);
  }
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.ORR = false;
    this.PhO = -1;
    this.OVu = false;
    this.vEG = null;
    this.Pie = null;
    this.PhR = null;
    this.Pif = new HashMap();
    this.PhS = null;
    this.PhT = null;
    this.Pig = false;
    Log.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.h.aZW().a(106, this);
    com.tencent.mm.kernel.h.aZW().a(233, this);
    com.tencent.mm.kernel.h.aZW().a(666, this);
    com.tencent.mm.kernel.h.aZW().a(372, this);
    com.tencent.mm.kernel.h.aZW().a(3512, this);
    com.tencent.mm.kernel.h.aZW().a(5900, this);
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
      this.Pif.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      paramString = new c.a()
      {
        public final void gTH()
        {
          AppMethodBeat.i(314083);
          com.tencent.mm.kernel.h.aZW().a(paramString);
          if (c.b(c.this) != null) {
            c.b(c.this).w(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(314083);
        }
      };
      if (paramActivity == null) {
        break label129;
      }
      if ((!paramBoolean) || (!this.Pig)) {
        break;
      }
      c(paramActivity.getString(l.i.gUc), paramString);
      AppMethodBeat.o(52052);
      return;
    }
    a(paramActivity.getString(l.i.gUc), paramString);
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
    if (this.AcJ > 0)
    {
      i = this.AcJ;
      Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.Pib), Integer.valueOf(i) });
      localObject4 = "";
      localObject3 = "";
      localObject1 = "";
      localObject6 = "";
      localObject5 = "";
      localObject2 = localObject1;
      if (this.Pid == null) {
        break label400;
      }
      String str1 = this.Pid.getString("stat_send_msg_user");
      localObject2 = this.Pid.getString("stat_msg_id");
      if (!Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((String)localObject2).replace("msg_", "").replace("sns_", "");
      }
      String str2 = this.Pid.getString("stat_chat_talker_username");
      String str3 = this.Pid.getString("wxappPathWithQuery");
      String str4 = this.Pid.getString("stat_url");
      localObject2 = localObject1;
      localObject5 = str4;
      localObject3 = str2;
      localObject6 = str3;
      localObject4 = str1;
      if (paramString2 != null) {
        break label400;
      }
      paramString2 = this.Pid.getString("stat_app_id");
      localObject5 = str4;
      localObject6 = str3;
      localObject4 = str1;
      localObject3 = str2;
    }
    for (;;)
    {
      paramString1 = new n(paramString1, (String)localObject3, i, paramInt1, paramInt2, paramString2, n.bMd(), new byte[0], (String)localObject4, (String)localObject1);
      paramInt1 = com.tencent.mm.ui.f.a.azW(this.Pib);
      paramString1.setSubScene(paramInt1);
      if ((localObject5 != null) && (((String)localObject5).startsWith("http"))) {
        paramString1.OW((String)localObject5);
      }
      paramString1.OX((String)localObject6);
      Log.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d, wxaPathWithQuery: %s, appId=%s", new Object[] { localObject5, Integer.valueOf(paramInt1), localObject6, paramString2 });
      this.Pif.put(paramString1, Integer.valueOf(1));
      com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
      if (this.vEG != null) {
        this.vEG.dismiss();
      }
      a(paramActivity.getString(l.i.OKM), new c.a()
      {
        public final void gTH()
        {
          AppMethodBeat.i(314094);
          com.tencent.mm.kernel.h.aZW().a(paramString1);
          if (c.b(c.this) != null) {
            c.b(c.this).w(1, null);
          }
          c.a(c.this, paramString1);
          AppMethodBeat.o(314094);
        }
      });
      AppMethodBeat.o(52053);
      return;
      i = aiD(this.Pib);
      break;
      label400:
      localObject1 = localObject2;
    }
  }
  
  private void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52044);
    boolean bool2 = this.OVu;
    if (this.PhR == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.PhR != null) && (this.OVu))
    {
      cancelLoading();
      this.PhT = new k(this.PhR, new k.b()
      {
        public final void onShow()
        {
          AppMethodBeat.i(314075);
          c.a(c.this);
          AppMethodBeat.o(314075);
        }
      }, parama);
      this.PhS = com.tencent.threadpool.h.ahAA.p(this.PhT, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean aVf(String paramString)
  {
    AppMethodBeat.i(52049);
    if ((paramString.startsWith("weixin://wxpay/bizpayurl")) || (paramString.startsWith("https://wx.tenpay.com/f2f")) || (paramString.startsWith("wxp://f2f")) || (paramString.startsWith("wxhb://f2f")) || (paramString.startsWith("wxp://wbf2f")) || (paramString.startsWith("m")) || (paramString.startsWith(Pia)) || (paramString.startsWith("n")))
    {
      AppMethodBeat.o(52049);
      return true;
    }
    AppMethodBeat.o(52049);
    return false;
  }
  
  private static int agh(int paramInt)
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
  
  private static int aiD(int paramInt)
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
  
  private void aiE(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.Pid != null)
    {
      localObject2 = this.Pid.getString("stat_url");
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
      String str = URLEncoder.encode(Util.nullAsNil(this.Pic), "UTF-8");
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
    com.tencent.mm.plugin.report.service.h.OAn.b(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52047);
    if (this.vEG != null) {
      this.vEG.dismiss();
    }
    if (this.mActivityRef != null) {}
    for (Context localContext = (Context)this.mActivityRef.get(); localContext == null; localContext = null)
    {
      AppMethodBeat.o(52047);
      return;
    }
    this.vEG = com.tencent.mm.ui.base.k.a(localContext, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.gTH();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(314283);
    if (this.Pie != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("key_scan_qr_code_result", paramBoolean);
      this.Pie.w(3, localBundle);
    }
    AppMethodBeat.o(314283);
  }
  
  private void c(String paramString, c.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.OVu;
    if (this.PhR == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.PhR == null) || (!this.OVu)) {
        break;
      }
      this.Pig = true;
      this.PhR.a(true, false, parama);
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
    if (this.PhR != null) {
      this.PhR.a(false, false, null);
    }
    if ((this.vEG != null) && (this.vEG.isShowing())) {
      this.vEG.dismiss();
    }
    if (this.PhS != null) {
      this.PhS.cancel(false);
    }
    if (this.PhT != null) {
      this.PhT.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int gTM()
  {
    AppMethodBeat.i(314272);
    if (this.AcJ > 0)
    {
      i = this.AcJ;
      AppMethodBeat.o(314272);
      return i;
    }
    int i = aiD(this.Pib);
    AppMethodBeat.o(314272);
    return i;
  }
  
  private int gTN()
  {
    switch (this.Pib)
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
    com.tencent.mm.kernel.h.aZW().b(106, this);
    com.tencent.mm.kernel.h.aZW().b(233, this);
    com.tencent.mm.kernel.h.aZW().b(666, this);
    com.tencent.mm.kernel.h.aZW().b(372, this);
    com.tencent.mm.kernel.h.aZW().b(3512, this);
    com.tencent.mm.kernel.h.aZW().b(5900, this);
    AppMethodBeat.o(52051);
  }
  
  public final void AO(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.Pie != null)
      {
        this.Pie.w(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else {
      b(true, null);
    }
    AppMethodBeat.o(52056);
  }
  
  public final void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(314318);
    a(paramActivity, paramString1, paramInt1, paramString2, paramInt2, paramInt3, null, null, paramBundle, paramInt4, paramBoolean1, paramInt5, paramBoolean2, null);
    AppMethodBeat.o(314318);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.g.f.a parama, final com.tencent.mm.plugin.scanner.view.c paramc, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2, ScanIdentifyReportInfo paramScanIdentifyReportInfo)
  {
    AppMethodBeat.i(314338);
    Log.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.h.aZW().bFQ()), Boolean.valueOf(paramBoolean2) });
    this.mActivityRef = new WeakReference(paramActivity);
    this.Pib = paramInt1;
    this.Pic = paramString1;
    this.hDb = paramInt2;
    this.hDc = paramInt3;
    this.typeName = paramString2;
    this.Pie = parama;
    this.Pid = paramBundle;
    this.PhN = paramBoolean1;
    this.OXB = paramInt4;
    this.OVu = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ORR = bool;
      this.PhO = paramInt5;
      this.PhR = paramc;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!Util.isNullOrNil(paramString1)) {
        break;
      }
      Log.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(314338);
      return;
    }
    paramc = (Context)this.mActivityRef.get();
    if (com.tencent.mm.kernel.h.aZW().bFQ() == 0)
    {
      paramBoolean1 = NetStatusUtil.isConnected(paramc);
      if (this.Pie != null)
      {
        paramString2 = null;
        if (aVf(paramString1))
        {
          paramString2 = new Bundle();
          paramString2.putBoolean("key_offline_scan_show_tips", false);
        }
        this.Pie.w(0, paramString2);
        this.Pie.w(6, paramString2);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.PhN) {
          break label480;
        }
        paramString2 = b.PhX;
        if (!b.Cx(paramBoolean2)) {
          break label480;
        }
        Log.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!aVf(paramString1))
        {
          paramString2 = b.PhX;
          paramString2 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.ORR, paramBundle);
          if (!paramBoolean1) {
            break label463;
          }
          paramActivity = paramc.getString(l.i.OLl);
          label416:
          b.a(paramString2, paramActivity, false);
        }
        paramActivity = w.ORS;
        paramActivity = this.typeName;
        if (!this.ORR) {
          break label475;
        }
      }
      label463:
      label475:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        w.b(paramString1, paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(314338);
        return;
        paramInt4 = 1;
        break;
        paramActivity = paramc.getString(l.i.OLo);
        break label416;
      }
      label480:
      if (this.PhN)
      {
        paramString1 = b.PhX;
        if (b.Cx(paramBoolean2))
        {
          paramString1 = b.PhX;
          if (paramBoolean1) {}
          for (paramString1 = paramc.getString(l.i.OLl);; paramString1 = paramc.getString(l.i.OLo))
          {
            b.n(paramActivity, paramString1);
            AppMethodBeat.o(314338);
            return;
          }
        }
      }
      Toast.makeText(paramActivity, paramActivity.getString(l.i.fmt_iap_err), 0).show();
      AppMethodBeat.o(314338);
      return;
    }
    parama = "";
    if (paramString1.startsWith("weixin://qr/")) {
      parama = paramString1.substring(12) + "@qr";
    }
    if (!Util.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(314338);
      return;
    }
    if (aVf(paramString1))
    {
      Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = b.PhX;
        if (b.Cx(paramBoolean2))
        {
          parama = w.ORS;
          parama = this.typeName;
          if (!this.ORR) {
            break label954;
          }
        }
      }
    }
    label954:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      w.b(paramString1, parama, paramInt1, 4, 0);
      Log.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
      if (!paramString1.startsWith("weixin://wxpay/bizpayurl")) {
        break;
      }
      Log.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      paramInt1 = aiD(this.Pib);
      paramInt2 = agh(paramInt1);
      paramActivity = new rs();
      paramActivity.hUL.url = paramString1;
      paramActivity.hUL.channel = paramInt2;
      paramActivity.hUL.scene = paramInt1;
      paramActivity.hUL.context = paramc;
      if (paramInt2 == 13)
      {
        Log.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.hUL.source = this.source;
        paramActivity.hUL.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((paramc == null) || (paramActivity.hUM == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.hUM.ret == 1)
          {
            c.this.AO(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.hUM.ret == 2) {
            c.this.AO(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      paramActivity.asyncPublish(Looper.myLooper());
      if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52037);
            if ((c.b(c.this) != null) && ((paramActivity.hUM == null) || (paramActivity.hUM.ret != 1))) {
              c.a(c.this, false);
            }
            AppMethodBeat.o(52037);
          }
        }, 10000L);
      }
      aiE(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
      AppMethodBeat.o(314338);
      return;
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      Log.d("MicroMsg.QBarStringHandler", "go to payment code");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayCode.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        AppMethodBeat.o(314338);
        return;
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 1, paramString1, agh(aiD(this.Pib)), null);
      b(true, null);
      aiE(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      if (paramScanIdentifyReportInfo != null) {
        paramScanIdentifyReportInfo.aZm(paramString1);
      }
      AppMethodBeat.o(314338);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 6, paramString1, agh(aiD(this.Pib)), null);
      b(true, null);
      aiE(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(314338);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      Log.i("MicroMsg.QBarStringHandler", "go to reward");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        AppMethodBeat.o(314338);
        return;
      }
      paramInt2 = agh(aiD(this.Pib));
      paramInt1 = 1;
      if (this.AcJ == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(paramc, paramString1, paramInt2, paramString2, paramInt1);
        b(true, null);
        aiE(11);
        com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(314338);
        return;
        if (this.AcJ == 38) {
          paramInt1 = 3;
        } else if (this.AcJ == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith(Pia))
    {
      Log.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      com.tencent.mm.pluginsdk.wallet.f.a(paramc, 1, paramString1, agh(aiD(this.Pib)), null);
      b(true, null);
      aiE(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      if (paramScanIdentifyReportInfo != null) {
        paramScanIdentifyReportInfo.aZm(paramString1);
      }
      AppMethodBeat.o(314338);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        if (this.Pie != null) {
          this.Pie.w(5, null);
        }
        AppMethodBeat.o(314338);
        return;
      }
      Log.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      paramInt1 = aiD(this.Pib);
      paramInt2 = agh(paramInt1);
      paramActivity = new wb();
      paramActivity.hZI.hZK = paramString1;
      paramActivity.hZI.scene = paramInt1;
      paramActivity.hZI.type = 1;
      paramActivity.hZI.contextRef = new WeakReference(paramc);
      paramActivity.hZI.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(314132);
          if (!Util.isNullOrNil(paramActivity.hZJ.errMsg))
          {
            if (paramc != null) {
              Toast.makeText(paramc, paramActivity.hZJ.errMsg, 1).show();
            }
            c.a(c.this, false);
            AppMethodBeat.o(314132);
            return;
          }
          if (Util.isNullOrNil(paramActivity.hZJ.hZL))
          {
            Log.w("MicroMsg.QBarStringHandler", "resp url is null!");
            c.a(c.this, false);
            AppMethodBeat.o(314132);
            return;
          }
          if (paramActivity.hZJ.actionType == 1)
          {
            com.tencent.mm.pluginsdk.wallet.f.a(paramc, paramActivity.hZJ.hZL, paramInt2, paramString2, paramInt1);
            c.a(c.this, true);
            AppMethodBeat.o(314132);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramActivity.hZJ.hZL);
          com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, paramc);
          c.a(c.this, true);
          AppMethodBeat.o(314132);
        }
      };
      paramActivity.publish();
      aiE(11);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(314338);
      return;
    }
    if (paramString1.startsWith("weixin://wxpay/bindurl"))
    {
      Log.i("MicroMsg.QBarStringHandler", "fast bind card qrcode");
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      paramInt1 = agh(aiD(this.Pib));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startFastBindUseCase(paramString1, paramInt1, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(314098);
          if (c.b(c.this) != null) {
            c.b(c.this).w(3, null);
          }
          AppMethodBeat.o(314098);
        }
      });
      AppMethodBeat.o(314338);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      Log.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(314338);
        return;
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanFace2Face.checkAvailable(paramc, new androidx.core.f.a() {}))
      {
        if (this.Pie != null) {
          this.Pie.w(5, null);
        }
        AppMethodBeat.o(314338);
        return;
      }
      if (this.Pie != null) {
        this.Pie.w(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.br.c.b(paramc, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.h.OAn.b(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      aiE(11);
      AppMethodBeat.o(314338);
      return;
    }
    paramString2 = new com.tencent.mm.plugin.scanner.d();
    paramString2.activity = paramActivity;
    paramString2.OGJ = paramString1;
    paramString2.hDb = paramInt2;
    paramString2.hDc = paramInt3;
    paramString2.publish();
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.Pie != null) {
      this.Pie.w(5, null);
    }
    AppMethodBeat.o(314338);
  }
  
  public final void gTL()
  {
    AppMethodBeat.i(52050);
    Log.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.Pic = null;
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
    AppMethodBeat.i(314394);
    if (this.mActivityRef != null)
    {
      Context localContext = (Context)this.mActivityRef.get();
      AppMethodBeat.o(314394);
      return localContext;
    }
    AppMethodBeat.o(314394);
    return null;
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    // Byte code:
    //   0: ldc_w 815
    //   3: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 170
    //   8: ldc_w 817
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: aload_3
    //   32: aastore
    //   33: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload 4
    //   38: ifnonnull +62 -> 100
    //   41: aload 4
    //   43: ifnonnull +51 -> 94
    //   46: iconst_1
    //   47: istore 6
    //   49: ldc 170
    //   51: ldc_w 819
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: iload 6
    //   62: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   65: aastore
    //   66: invokestatic 559	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   73: ifnull +14 -> 87
    //   76: aload_0
    //   77: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   80: iconst_2
    //   81: aconst_null
    //   82: invokeinterface 477 3 0
    //   87: ldc_w 815
    //   90: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: return
    //   94: iconst_0
    //   95: istore 6
    //   97: goto -48 -> 49
    //   100: aload_0
    //   101: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   104: aload 4
    //   106: invokeinterface 823 2 0
    //   111: ifne +19 -> 130
    //   114: aload 4
    //   116: instanceof 825
    //   119: ifeq +112 -> 231
    //   122: ldc 170
    //   124: ldc_w 827
    //   127: invokestatic 542	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   134: aload 4
    //   136: invokeinterface 831 2 0
    //   141: pop
    //   142: aload_0
    //   143: invokespecial 371	com/tencent/mm/plugin/scanner/util/c:cancelLoading	()V
    //   146: aload 4
    //   148: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   151: sipush 372
    //   154: if_icmpne +92 -> 246
    //   157: iload_1
    //   158: iconst_4
    //   159: if_icmpne +87 -> 246
    //   162: iload_2
    //   163: sipush -2034
    //   166: if_icmpne +80 -> 246
    //   169: new 280	com/tencent/mm/modelsimple/n
    //   172: dup
    //   173: aload 4
    //   175: checkcast 838	com/tencent/mm/openim/model/q
    //   178: getfield 841	com/tencent/mm/openim/model/q:psD	Ljava/lang/String;
    //   181: aconst_null
    //   182: bipush 50
    //   184: iconst_0
    //   185: iconst_0
    //   186: iconst_0
    //   187: newarray byte
    //   189: invokespecial 844	com/tencent/mm/modelsimple/n:<init>	(Ljava/lang/String;Ljava/lang/String;III[B)V
    //   192: astore_3
    //   193: invokestatic 848	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   196: pop
    //   197: invokestatic 852	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   200: getfield 858	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   203: aload_3
    //   204: iconst_0
    //   205: invokevirtual 216	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   208: pop
    //   209: aload_0
    //   210: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   213: aload_3
    //   214: iconst_1
    //   215: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokeinterface 213 3 0
    //   223: pop
    //   224: ldc_w 815
    //   227: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: return
    //   231: ldc 170
    //   233: ldc_w 860
    //   236: invokestatic 542	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: ldc_w 815
    //   242: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: return
    //   246: aload_0
    //   247: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   250: ifnull +59 -> 309
    //   253: aload_0
    //   254: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   257: invokevirtual 453	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   260: checkcast 224	android/app/Activity
    //   263: astore 7
    //   265: iload_1
    //   266: iconst_4
    //   267: if_icmpne +48 -> 315
    //   270: iload_2
    //   271: bipush 252
    //   273: if_icmpne +42 -> 315
    //   276: aload 7
    //   278: ifnull +24 -> 302
    //   281: aload 7
    //   283: getstatic 863	com/tencent/mm/plugin/scanner/l$i:OKK	I
    //   286: getstatic 866	com/tencent/mm/plugin/scanner/l$i:app_tip	I
    //   289: iconst_0
    //   290: new 50	com/tencent/mm/plugin/scanner/util/c$9
    //   293: dup
    //   294: aload_0
    //   295: invokespecial 867	com/tencent/mm/plugin/scanner/util/c$9:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;)V
    //   298: invokestatic 870	com/tencent/mm/ui/base/k:a	(Landroid/content/Context;IIZLandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mm/ui/widget/a/e;
    //   301: pop
    //   302: ldc_w 815
    //   305: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: return
    //   309: aconst_null
    //   310: astore 7
    //   312: goto -47 -> 265
    //   315: getstatic 331	com/tencent/mm/plugin/scanner/util/b:PhX	Lcom/tencent/mm/plugin/scanner/util/b;
    //   318: astore_3
    //   319: aload_0
    //   320: getfield 151	com/tencent/mm/plugin/scanner/util/c:OVu	Z
    //   323: invokestatic 555	com/tencent/mm/plugin/scanner/util/b:Cx	(Z)Z
    //   326: ifeq +183 -> 509
    //   329: getstatic 331	com/tencent/mm/plugin/scanner/util/b:PhX	Lcom/tencent/mm/plugin/scanner/util/b;
    //   332: astore_3
    //   333: iload_1
    //   334: aload 4
    //   336: invokestatic 873	com/tencent/mm/plugin/scanner/util/b:b	(ILcom/tencent/mm/am/p;)Z
    //   339: ifeq +170 -> 509
    //   342: aload_0
    //   343: getfield 338	com/tencent/mm/plugin/scanner/util/c:PhN	Z
    //   346: ifne +134 -> 480
    //   349: ldc 170
    //   351: ldc_w 875
    //   354: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   361: ifnull +15 -> 376
    //   364: aload_0
    //   365: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   368: bipush 7
    //   370: aconst_null
    //   371: invokeinterface 477 3 0
    //   376: aload 7
    //   378: ifnull +124 -> 502
    //   381: getstatic 331	com/tencent/mm/plugin/scanner/util/b:PhX	Lcom/tencent/mm/plugin/scanner/util/b;
    //   384: astore_3
    //   385: new 561	com/tencent/mm/plugin/scanner/model/OfflineScanContext
    //   388: dup
    //   389: aload 7
    //   391: iconst_2
    //   392: aload_0
    //   393: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   396: aload_0
    //   397: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   400: aload_0
    //   401: getfield 531	com/tencent/mm/plugin/scanner/util/c:hDb	I
    //   404: aload_0
    //   405: getfield 533	com/tencent/mm/plugin/scanner/util/c:hDc	I
    //   408: aload_0
    //   409: getfield 353	com/tencent/mm/plugin/scanner/util/c:typeName	Ljava/lang/String;
    //   412: aload_0
    //   413: getfield 147	com/tencent/mm/plugin/scanner/util/c:ORR	Z
    //   416: aload_0
    //   417: getfield 245	com/tencent/mm/plugin/scanner/util/c:Pid	Landroid/os/Bundle;
    //   420: invokespecial 564	com/tencent/mm/plugin/scanner/model/OfflineScanContext:<init>	(Landroid/app/Activity;ILjava/lang/String;IIILjava/lang/String;ZLandroid/os/Bundle;)V
    //   423: aload 7
    //   425: getstatic 567	com/tencent/mm/plugin/scanner/l$i:OLl	I
    //   428: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   431: iconst_1
    //   432: invokestatic 571	com/tencent/mm/plugin/scanner/util/b:a	(Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;Ljava/lang/String;Z)V
    //   435: getstatic 349	com/tencent/mm/plugin/scanner/model/w:ORS	Lcom/tencent/mm/plugin/scanner/model/w;
    //   438: astore_3
    //   439: aload_0
    //   440: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   443: astore_3
    //   444: aload_0
    //   445: getfield 353	com/tencent/mm/plugin/scanner/util/c:typeName	Ljava/lang/String;
    //   448: astore 4
    //   450: aload_0
    //   451: getfield 147	com/tencent/mm/plugin/scanner/util/c:ORR	Z
    //   454: ifeq +21 -> 475
    //   457: iconst_2
    //   458: istore_1
    //   459: aload_3
    //   460: aload 4
    //   462: iload_1
    //   463: iconst_2
    //   464: iconst_0
    //   465: invokestatic 357	com/tencent/mm/plugin/scanner/model/w:b	(Ljava/lang/String;Ljava/lang/String;III)V
    //   468: ldc_w 815
    //   471: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: iconst_1
    //   476: istore_1
    //   477: goto -18 -> 459
    //   480: aload 7
    //   482: ifnull +20 -> 502
    //   485: getstatic 331	com/tencent/mm/plugin/scanner/util/b:PhX	Lcom/tencent/mm/plugin/scanner/util/b;
    //   488: astore_3
    //   489: aload 7
    //   491: aload 7
    //   493: getstatic 878	com/tencent/mm/plugin/scanner/l$i:OLk	I
    //   496: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   499: invokestatic 577	com/tencent/mm/plugin/scanner/util/b:n	(Landroid/app/Activity;Ljava/lang/String;)V
    //   502: ldc_w 815
    //   505: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   508: return
    //   509: aload_0
    //   510: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   513: ifnull +72 -> 585
    //   516: aload_0
    //   517: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   520: invokevirtual 453	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   523: checkcast 455	android/content/Context
    //   526: astore_3
    //   527: iload_1
    //   528: tableswitch	default:+24 -> 552, 1:+62->590, 2:+151->679
    //   553: istore 5
    //   555: iload 5
    //   557: ifeq +147 -> 704
    //   560: aload_0
    //   561: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   564: ifnull +14 -> 578
    //   567: aload_0
    //   568: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   571: iconst_0
    //   572: aconst_null
    //   573: invokeinterface 477 3 0
    //   578: ldc_w 815
    //   581: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   584: return
    //   585: aconst_null
    //   586: astore_3
    //   587: goto -60 -> 527
    //   590: aload_3
    //   591: ifnull +31 -> 622
    //   594: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   597: invokevirtual 881	com/tencent/mm/am/s:bFR	()Z
    //   600: ifeq +28 -> 628
    //   603: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   606: invokevirtual 884	com/tencent/mm/am/s:getNetworkServerIp	()Ljava/lang/String;
    //   609: pop
    //   610: new 113	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 592	java/lang/StringBuilder:<init>	()V
    //   617: iload_2
    //   618: invokevirtual 887	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: iconst_1
    //   623: istore 5
    //   625: goto -70 -> 555
    //   628: aload_3
    //   629: invokestatic 892	com/tencent/mm/network/ah:eb	(Landroid/content/Context;)Z
    //   632: ifeq +11 -> 643
    //   635: aload_3
    //   636: invokestatic 897	com/tencent/mm/pluginsdk/ui/tools/m:lE	(Landroid/content/Context;)Z
    //   639: pop
    //   640: goto -18 -> 622
    //   643: aload_3
    //   644: aload_3
    //   645: getstatic 900	com/tencent/mm/plugin/scanner/l$i:fmt_http_err	I
    //   648: iconst_2
    //   649: anewarray 4	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: iconst_1
    //   655: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   658: aastore
    //   659: dup
    //   660: iconst_1
    //   661: iload_2
    //   662: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   665: aastore
    //   666: invokevirtual 903	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   669: iconst_1
    //   670: invokestatic 586	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   673: invokevirtual 589	android/widget/Toast:show	()V
    //   676: goto -54 -> 622
    //   679: aload_3
    //   680: ifnull +18 -> 698
    //   683: aload_3
    //   684: aload_3
    //   685: getstatic 580	com/tencent/mm/plugin/scanner/l$i:fmt_iap_err	I
    //   688: invokevirtual 568	android/content/Context:getString	(I)Ljava/lang/String;
    //   691: iconst_1
    //   692: invokestatic 586	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   695: invokevirtual 589	android/widget/Toast:show	()V
    //   698: iconst_1
    //   699: istore 5
    //   701: goto -146 -> 555
    //   704: iload_1
    //   705: iconst_4
    //   706: if_icmpne +52 -> 758
    //   709: iload_2
    //   710: sipush -2004
    //   713: if_icmpne +45 -> 758
    //   716: aload 7
    //   718: ifnull +15 -> 733
    //   721: aload 7
    //   723: getstatic 906	com/tencent/mm/plugin/scanner/l$i:qrcode_ban_by_expose	I
    //   726: getstatic 866	com/tencent/mm/plugin/scanner/l$i:app_tip	I
    //   729: invokestatic 910	com/tencent/mm/ui/base/k:s	(Landroid/content/Context;II)Lcom/tencent/mm/ui/widget/a/e;
    //   732: pop
    //   733: aload_0
    //   734: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   737: ifnull +14 -> 751
    //   740: aload_0
    //   741: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   744: iconst_1
    //   745: aconst_null
    //   746: invokeinterface 477 3 0
    //   751: ldc_w 815
    //   754: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: return
    //   758: iload_1
    //   759: ifne +7 -> 766
    //   762: iload_2
    //   763: ifeq +68 -> 831
    //   766: aload 7
    //   768: ifnull +38 -> 806
    //   771: aload 7
    //   773: aload 7
    //   775: getstatic 913	com/tencent/mm/plugin/scanner/l$i:fmt_search_err	I
    //   778: iconst_2
    //   779: anewarray 4	java/lang/Object
    //   782: dup
    //   783: iconst_0
    //   784: iload_1
    //   785: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: dup
    //   790: iconst_1
    //   791: iload_2
    //   792: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: aastore
    //   796: invokevirtual 914	android/app/Activity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   799: iconst_0
    //   800: invokestatic 586	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   803: invokevirtual 589	android/widget/Toast:show	()V
    //   806: aload_0
    //   807: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   810: ifnull +14 -> 824
    //   813: aload_0
    //   814: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   817: iconst_1
    //   818: aconst_null
    //   819: invokeinterface 477 3 0
    //   824: ldc_w 815
    //   827: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   830: return
    //   831: getstatic 331	com/tencent/mm/plugin/scanner/util/b:PhX	Lcom/tencent/mm/plugin/scanner/util/b;
    //   834: astore_3
    //   835: aload 4
    //   837: invokestatic 334	com/tencent/mm/plugin/scanner/util/b:o	(Lcom/tencent/mm/am/p;)Z
    //   840: ifeq +45 -> 885
    //   843: aload_0
    //   844: getfield 338	com/tencent/mm/plugin/scanner/util/c:PhN	Z
    //   847: ifne +38 -> 885
    //   850: getstatic 349	com/tencent/mm/plugin/scanner/model/w:ORS	Lcom/tencent/mm/plugin/scanner/model/w;
    //   853: astore_3
    //   854: aload_0
    //   855: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   858: astore_3
    //   859: aload_0
    //   860: getfield 353	com/tencent/mm/plugin/scanner/util/c:typeName	Ljava/lang/String;
    //   863: astore 8
    //   865: aload_0
    //   866: getfield 147	com/tencent/mm/plugin/scanner/util/c:ORR	Z
    //   869: ifeq +259 -> 1128
    //   872: iconst_2
    //   873: istore 5
    //   875: aload_3
    //   876: aload 8
    //   878: iload 5
    //   880: iconst_4
    //   881: iconst_0
    //   882: invokestatic 357	com/tencent/mm/plugin/scanner/model/w:b	(Ljava/lang/String;Ljava/lang/String;III)V
    //   885: aload 4
    //   887: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   890: bipush 106
    //   892: if_icmpne +1186 -> 2078
    //   895: aload 4
    //   897: checkcast 198	com/tencent/mm/plugin/messenger/a/f
    //   900: astore 7
    //   902: aload 7
    //   904: getfield 917	com/tencent/mm/plugin/messenger/a/f:KPI	Z
    //   907: ifne +243 -> 1150
    //   910: aload_0
    //   911: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   914: ifnull +220 -> 1134
    //   917: aload_0
    //   918: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   921: invokevirtual 453	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   924: checkcast 455	android/content/Context
    //   927: astore_3
    //   928: aload_3
    //   929: ifnull +221 -> 1150
    //   932: aload 7
    //   934: invokevirtual 921	com/tencent/mm/plugin/messenger/a/f:gaH	()Lcom/tencent/mm/protocal/protobuf/evg;
    //   937: astore 7
    //   939: aload 7
    //   941: getfield 926	com/tencent/mm/protocal/protobuf/evg:aaMm	I
    //   944: invokestatic 932	com/tencent/mm/storage/au:ayS	(I)Z
    //   947: ifeq +203 -> 1150
    //   950: aload 7
    //   952: getfield 936	com/tencent/mm/protocal/protobuf/evg:aaMt	Lcom/tencent/mm/protocal/protobuf/ahl;
    //   955: ifnull +195 -> 1150
    //   958: aload 7
    //   960: getfield 936	com/tencent/mm/protocal/protobuf/evg:aaMt	Lcom/tencent/mm/protocal/protobuf/ahl;
    //   963: getfield 941	com/tencent/mm/protocal/protobuf/ahl:pSu	Ljava/lang/String;
    //   966: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   969: ifne +181 -> 1150
    //   972: aload 7
    //   974: getfield 936	com/tencent/mm/protocal/protobuf/evg:aaMt	Lcom/tencent/mm/protocal/protobuf/ahl;
    //   977: getfield 941	com/tencent/mm/protocal/protobuf/ahl:pSu	Ljava/lang/String;
    //   980: invokestatic 946	com/tencent/mm/modelappbrand/b:KH	(Ljava/lang/String;)Z
    //   983: ifeq +167 -> 1150
    //   986: aload_0
    //   987: getfield 237	com/tencent/mm/plugin/scanner/util/c:AcJ	I
    //   990: ifle +149 -> 1139
    //   993: aload_0
    //   994: getfield 237	com/tencent/mm/plugin/scanner/util/c:AcJ	I
    //   997: istore_1
    //   998: ldc 170
    //   1000: ldc 239
    //   1002: iconst_3
    //   1003: anewarray 4	java/lang/Object
    //   1006: dup
    //   1007: iconst_0
    //   1008: aload_0
    //   1009: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_1
    //   1015: aload_0
    //   1016: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   1019: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1022: aastore
    //   1023: dup
    //   1024: iconst_2
    //   1025: iload_1
    //   1026: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: aastore
    //   1030: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1033: new 280	com/tencent/mm/modelsimple/n
    //   1036: dup
    //   1037: aload_0
    //   1038: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   1041: aconst_null
    //   1042: bipush 43
    //   1044: iconst_0
    //   1045: iconst_0
    //   1046: iconst_0
    //   1047: newarray byte
    //   1049: invokespecial 844	com/tencent/mm/modelsimple/n:<init>	(Ljava/lang/String;Ljava/lang/String;III[B)V
    //   1052: astore 7
    //   1054: aload_0
    //   1055: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   1058: aload 7
    //   1060: iconst_1
    //   1061: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1064: invokeinterface 213 3 0
    //   1069: pop
    //   1070: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   1073: aload 7
    //   1075: iconst_0
    //   1076: invokevirtual 216	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   1079: pop
    //   1080: aload_0
    //   1081: getfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   1084: ifnull +10 -> 1094
    //   1087: aload_0
    //   1088: getfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   1091: invokevirtual 314	android/app/ProgressDialog:dismiss	()V
    //   1094: aload_0
    //   1095: aload_3
    //   1096: getstatic 317	com/tencent/mm/plugin/scanner/l$i:OKM	I
    //   1099: invokevirtual 568	android/content/Context:getString	(I)Ljava/lang/String;
    //   1102: new 18	com/tencent/mm/plugin/scanner/util/c$13
    //   1105: dup
    //   1106: aload_0
    //   1107: aload 7
    //   1109: invokespecial 947	com/tencent/mm/plugin/scanner/util/c$13:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;Lcom/tencent/mm/modelsimple/n;)V
    //   1112: invokespecial 233	com/tencent/mm/plugin/scanner/util/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/view/c$a;)V
    //   1115: iconst_1
    //   1116: istore_1
    //   1117: iload_1
    //   1118: ifeq +37 -> 1155
    //   1121: ldc_w 815
    //   1124: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1127: return
    //   1128: iconst_1
    //   1129: istore 5
    //   1131: goto -256 -> 875
    //   1134: aconst_null
    //   1135: astore_3
    //   1136: goto -208 -> 928
    //   1139: aload_0
    //   1140: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   1143: invokestatic 323	com/tencent/mm/plugin/scanner/util/c:aiD	(I)I
    //   1146: istore_1
    //   1147: goto -149 -> 998
    //   1150: iconst_0
    //   1151: istore_1
    //   1152: goto -35 -> 1117
    //   1155: aload 4
    //   1157: checkcast 198	com/tencent/mm/plugin/messenger/a/f
    //   1160: invokevirtual 921	com/tencent/mm/plugin/messenger/a/f:gaH	()Lcom/tencent/mm/protocal/protobuf/evg;
    //   1163: astore 7
    //   1165: aload_0
    //   1166: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   1169: ifnull +351 -> 1520
    //   1172: aload_0
    //   1173: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   1176: invokevirtual 453	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1179: checkcast 224	android/app/Activity
    //   1182: astore_3
    //   1183: aload 7
    //   1185: getfield 951	com/tencent/mm/protocal/protobuf/evg:ZqL	Lcom/tencent/mm/protocal/protobuf/etl;
    //   1188: invokestatic 956	com/tencent/mm/platformtools/w:a	(Lcom/tencent/mm/protocal/protobuf/etl;)Ljava/lang/String;
    //   1191: astore 9
    //   1193: ldc 170
    //   1195: new 113	java/lang/StringBuilder
    //   1198: dup
    //   1199: ldc_w 958
    //   1202: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1205: aload 7
    //   1207: getfield 951	com/tencent/mm/protocal/protobuf/evg:ZqL	Lcom/tencent/mm/protocal/protobuf/etl;
    //   1210: invokevirtual 961	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 637	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1219: invokestatic 967	com/tencent/mm/modelavatar/q:bFp	()Lcom/tencent/mm/modelavatar/AvatarStorage;
    //   1222: aload 9
    //   1224: aload 7
    //   1226: getfield 971	com/tencent/mm/protocal/protobuf/evg:YFI	Lcom/tencent/mm/protocal/protobuf/gol;
    //   1229: invokestatic 974	com/tencent/mm/platformtools/w:a	(Lcom/tencent/mm/protocal/protobuf/gol;)[B
    //   1232: invokevirtual 980	com/tencent/mm/modelavatar/AvatarStorage:j	(Ljava/lang/String;[B)Z
    //   1235: pop
    //   1236: aload_0
    //   1237: getfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   1240: ifnull +28 -> 1268
    //   1243: aload_0
    //   1244: getfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   1247: invokevirtual 493	android/app/ProgressDialog:isShowing	()Z
    //   1250: ifeq +18 -> 1268
    //   1253: ldc 170
    //   1255: ldc_w 982
    //   1258: invokestatic 637	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: aload_0
    //   1262: getfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   1265: invokevirtual 314	android/app/ProgressDialog:dismiss	()V
    //   1268: aload_0
    //   1269: invokespecial 371	com/tencent/mm/plugin/scanner/util/c:cancelLoading	()V
    //   1272: aload 9
    //   1274: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   1277: invokevirtual 985	java/lang/String:length	()I
    //   1280: ifle +753 -> 2033
    //   1283: ldc_w 987
    //   1286: invokestatic 664	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1289: checkcast 987	com/tencent/mm/plugin/messenger/foundation/a/n
    //   1292: invokeinterface 991 1 0
    //   1297: aload 9
    //   1299: invokeinterface 997 2 0
    //   1304: astore 10
    //   1306: aload 10
    //   1308: ifnull +222 -> 1530
    //   1311: aload 10
    //   1313: getfield 1002	com/tencent/mm/autogen/b/az:field_type	I
    //   1316: invokestatic 1007	com/tencent/mm/contact/d:rs	(I)Z
    //   1319: ifeq +211 -> 1530
    //   1322: aload 10
    //   1324: invokevirtual 1010	com/tencent/mm/storage/au:iZC	()Z
    //   1327: ifeq +203 -> 1530
    //   1330: aload_3
    //   1331: ifnull +199 -> 1530
    //   1334: invokestatic 1016	com/tencent/mm/an/af:bHf	()Lcom/tencent/mm/an/f;
    //   1337: aload 9
    //   1339: invokevirtual 1022	com/tencent/mm/an/f:Mn	(Ljava/lang/String;)Lcom/tencent/mm/api/c;
    //   1342: astore 8
    //   1344: aload 8
    //   1346: ifnull +184 -> 1530
    //   1349: aload 8
    //   1351: iconst_0
    //   1352: invokevirtual 1028	com/tencent/mm/api/c:dO	(Z)Lcom/tencent/mm/api/c$b;
    //   1355: pop
    //   1356: aload 8
    //   1358: getfield 1032	com/tencent/mm/api/c:hcC	Lcom/tencent/mm/api/c$b;
    //   1361: astore 11
    //   1363: aload 11
    //   1365: getfield 1038	com/tencent/mm/api/c$b:hcG	Lorg/json/JSONObject;
    //   1368: ifnull +20 -> 1388
    //   1371: aload 11
    //   1373: aload 11
    //   1375: getfield 1038	com/tencent/mm/api/c$b:hcG	Lorg/json/JSONObject;
    //   1378: ldc_w 1040
    //   1381: iconst_0
    //   1382: invokevirtual 1046	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1385: putfield 1049	com/tencent/mm/api/c$b:hcX	I
    //   1388: aload 11
    //   1390: getfield 1049	com/tencent/mm/api/c$b:hcX	I
    //   1393: iconst_1
    //   1394: if_icmpne +131 -> 1525
    //   1397: iconst_1
    //   1398: istore_1
    //   1399: iload_1
    //   1400: ifeq +130 -> 1530
    //   1403: aload 8
    //   1405: invokevirtual 1052	com/tencent/mm/api/c:aAP	()Z
    //   1408: ifne +122 -> 1530
    //   1411: new 765	android/content/Intent
    //   1414: dup
    //   1415: invokespecial 766	android/content/Intent:<init>	()V
    //   1418: astore 7
    //   1420: aload 7
    //   1422: ldc_w 1054
    //   1425: aload 9
    //   1427: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1430: pop
    //   1431: aload 7
    //   1433: ldc_w 1056
    //   1436: iconst_1
    //   1437: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1440: pop
    //   1441: invokestatic 1065	com/tencent/mm/plugin/scanner/m:dFc	()Lcom/tencent/mm/pluginsdk/m;
    //   1444: aload 7
    //   1446: aload_3
    //   1447: invokeinterface 1070 3 0
    //   1452: iconst_1
    //   1453: istore_1
    //   1454: iload_1
    //   1455: ifeq +598 -> 2053
    //   1458: aload_0
    //   1459: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   1462: ifnull +46 -> 1508
    //   1465: new 249	android/os/Bundle
    //   1468: dup
    //   1469: invokespecial 465	android/os/Bundle:<init>	()V
    //   1472: astore_3
    //   1473: aload_3
    //   1474: ldc_w 1072
    //   1477: aload 4
    //   1479: checkcast 198	com/tencent/mm/plugin/messenger/a/f
    //   1482: invokevirtual 921	com/tencent/mm/plugin/messenger/a/f:gaH	()Lcom/tencent/mm/protocal/protobuf/evg;
    //   1485: getfield 951	com/tencent/mm/protocal/protobuf/evg:ZqL	Lcom/tencent/mm/protocal/protobuf/etl;
    //   1488: invokestatic 956	com/tencent/mm/platformtools/w:a	(Lcom/tencent/mm/protocal/protobuf/etl;)Ljava/lang/String;
    //   1491: invokevirtual 1075	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1494: aload_3
    //   1495: ldc_w 1077
    //   1498: iconst_4
    //   1499: invokevirtual 1081	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1502: aload_0
    //   1503: iconst_1
    //   1504: aload_3
    //   1505: invokespecial 362	com/tencent/mm/plugin/scanner/util/c:b	(ZLandroid/os/Bundle;)V
    //   1508: aload_0
    //   1509: iconst_4
    //   1510: invokespecial 685	com/tencent/mm/plugin/scanner/util/c:aiE	(I)V
    //   1513: ldc_w 815
    //   1516: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1519: return
    //   1520: aconst_null
    //   1521: astore_3
    //   1522: goto -339 -> 1183
    //   1525: iconst_0
    //   1526: istore_1
    //   1527: goto -128 -> 1399
    //   1530: aload_0
    //   1531: invokespecial 1083	com/tencent/mm/plugin/scanner/util/c:gTN	()I
    //   1534: istore_1
    //   1535: new 765	android/content/Intent
    //   1538: dup
    //   1539: invokespecial 766	android/content/Intent:<init>	()V
    //   1542: astore 8
    //   1544: aload 8
    //   1546: aload 7
    //   1548: iload_1
    //   1549: invokestatic 1088	com/tencent/mm/api/d:a	(Landroid/content/Intent;Lcom/tencent/mm/protocal/protobuf/evg;I)V
    //   1552: aload 10
    //   1554: ifnull +24 -> 1578
    //   1557: aload 10
    //   1559: getfield 1002	com/tencent/mm/autogen/b/az:field_type	I
    //   1562: invokestatic 1007	com/tencent/mm/contact/d:rs	(I)Z
    //   1565: ifne +13 -> 1578
    //   1568: aload 8
    //   1570: ldc_w 1090
    //   1573: iconst_1
    //   1574: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1577: pop
    //   1578: aload 7
    //   1580: getfield 926	com/tencent/mm/protocal/protobuf/evg:aaMm	I
    //   1583: bipush 8
    //   1585: iand
    //   1586: ifle +37 -> 1623
    //   1589: getstatic 436	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1592: sipush 10298
    //   1595: new 113	java/lang/StringBuilder
    //   1598: dup
    //   1599: invokespecial 592	java/lang/StringBuilder:<init>	()V
    //   1602: aload 9
    //   1604: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: ldc_w 1092
    //   1610: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: iload_1
    //   1614: invokevirtual 887	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1617: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1620: invokevirtual 1096	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   1623: aload_3
    //   1624: ifnull +348 -> 1972
    //   1627: aload 7
    //   1629: getfield 926	com/tencent/mm/protocal/protobuf/evg:aaMm	I
    //   1632: invokestatic 932	com/tencent/mm/storage/au:ayS	(I)Z
    //   1635: ifeq +203 -> 1838
    //   1638: aload_3
    //   1639: ifnull +199 -> 1838
    //   1642: aload 8
    //   1644: ldc_w 1098
    //   1647: aload_0
    //   1648: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   1651: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1654: pop
    //   1655: aload_3
    //   1656: invokevirtual 1105	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1659: ldc_w 1107
    //   1662: invokevirtual 1110	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1665: astore 9
    //   1667: aload 9
    //   1669: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1672: ifne +166 -> 1838
    //   1675: invokestatic 1116	com/tencent/mm/model/ad:bCb	()Lcom/tencent/mm/model/ad;
    //   1678: aload 9
    //   1680: invokevirtual 1120	com/tencent/mm/model/ad:Jm	(Ljava/lang/String;)Lcom/tencent/mm/model/ad$b;
    //   1683: astore 13
    //   1685: aload 13
    //   1687: ifnull +151 -> 1838
    //   1690: aload 13
    //   1692: ldc_w 1122
    //   1695: aconst_null
    //   1696: invokevirtual 1125	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1699: astore 9
    //   1701: aload 13
    //   1703: ldc_w 1127
    //   1706: aconst_null
    //   1707: invokevirtual 1125	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1710: astore 10
    //   1712: aload 13
    //   1714: ldc_w 1128
    //   1717: aconst_null
    //   1718: invokevirtual 1125	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1721: astore 11
    //   1723: aload 13
    //   1725: ldc_w 1130
    //   1728: aconst_null
    //   1729: invokevirtual 1125	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1732: astore 12
    //   1734: aload 13
    //   1736: ldc_w 1132
    //   1739: iconst_0
    //   1740: invokevirtual 1135	com/tencent/mm/model/ad$b:getInt	(Ljava/lang/String;I)I
    //   1743: istore_1
    //   1744: aload 9
    //   1746: aload 10
    //   1748: invokestatic 1141	com/tencent/mm/model/ac:aX	(Ljava/lang/String;Ljava/lang/String;)I
    //   1751: istore_2
    //   1752: aload 13
    //   1754: ldc_w 1143
    //   1757: aconst_null
    //   1758: invokevirtual 1125	com/tencent/mm/model/ad$b:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1761: astore 13
    //   1763: aload 8
    //   1765: ldc_w 1122
    //   1768: aload 9
    //   1770: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1773: pop
    //   1774: aload 8
    //   1776: ldc_w 1127
    //   1779: aload 10
    //   1781: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1784: pop
    //   1785: aload 8
    //   1787: ldc_w 1128
    //   1790: aload 11
    //   1792: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1795: pop
    //   1796: aload 8
    //   1798: ldc_w 1130
    //   1801: aload 12
    //   1803: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1806: pop
    //   1807: aload 8
    //   1809: ldc_w 1145
    //   1812: iload_2
    //   1813: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1816: pop
    //   1817: aload 8
    //   1819: ldc_w 1132
    //   1822: iload_1
    //   1823: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1826: pop
    //   1827: aload 8
    //   1829: ldc_w 1143
    //   1832: aload 13
    //   1834: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1837: pop
    //   1838: aload_0
    //   1839: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   1842: ifne +135 -> 1977
    //   1845: aload 8
    //   1847: ldc_w 1132
    //   1850: bipush 7
    //   1852: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1855: pop
    //   1856: invokestatic 1065	com/tencent/mm/plugin/scanner/m:dFc	()Lcom/tencent/mm/pluginsdk/m;
    //   1859: aload 8
    //   1861: aload_3
    //   1862: invokeinterface 1147 3 0
    //   1867: ldc 243
    //   1869: astore_3
    //   1870: aload_0
    //   1871: getfield 1149	com/tencent/mm/plugin/scanner/util/c:talker	Ljava/lang/String;
    //   1874: invokestatic 1154	com/tencent/mm/model/ab:IS	(Ljava/lang/String;)Z
    //   1877: ifeq +8 -> 1885
    //   1880: aload_0
    //   1881: getfield 1149	com/tencent/mm/plugin/scanner/util/c:talker	Ljava/lang/String;
    //   1884: astore_3
    //   1885: getstatic 436	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1888: astore 8
    //   1890: aload 7
    //   1892: getfield 926	com/tencent/mm/protocal/protobuf/evg:aaMm	I
    //   1895: invokestatic 932	com/tencent/mm/storage/au:ayS	(I)Z
    //   1898: ifeq +130 -> 2028
    //   1901: iconst_0
    //   1902: istore_1
    //   1903: aload 8
    //   1905: sipush 14268
    //   1908: bipush 7
    //   1910: anewarray 4	java/lang/Object
    //   1913: dup
    //   1914: iconst_0
    //   1915: iload_1
    //   1916: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1919: aastore
    //   1920: dup
    //   1921: iconst_1
    //   1922: aload_0
    //   1923: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   1926: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1929: aastore
    //   1930: dup
    //   1931: iconst_2
    //   1932: aload_0
    //   1933: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   1936: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1939: aastore
    //   1940: dup
    //   1941: iconst_3
    //   1942: aload_0
    //   1943: getfield 1156	com/tencent/mm/plugin/scanner/util/c:imagePath	Ljava/lang/String;
    //   1946: aastore
    //   1947: dup
    //   1948: iconst_4
    //   1949: aload_0
    //   1950: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   1953: aastore
    //   1954: dup
    //   1955: iconst_5
    //   1956: aload_0
    //   1957: getfield 1158	com/tencent/mm/plugin/scanner/util/c:hDe	Ljava/lang/String;
    //   1960: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   1963: aastore
    //   1964: dup
    //   1965: bipush 6
    //   1967: aload_3
    //   1968: aastore
    //   1969: invokevirtual 439	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   1972: iconst_1
    //   1973: istore_1
    //   1974: goto -520 -> 1454
    //   1977: aload_0
    //   1978: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   1981: bipush 7
    //   1983: if_icmpne +16 -> 1999
    //   1986: aload 8
    //   1988: ldc_w 1132
    //   1991: iconst_4
    //   1992: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1995: pop
    //   1996: goto -140 -> 1856
    //   1999: aload_0
    //   2000: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   2003: iconst_3
    //   2004: if_icmpeq +11 -> 2015
    //   2007: aload_0
    //   2008: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   2011: iconst_5
    //   2012: if_icmpne -156 -> 1856
    //   2015: aload 8
    //   2017: ldc_w 1132
    //   2020: iconst_2
    //   2021: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2024: pop
    //   2025: goto -169 -> 1856
    //   2028: iconst_1
    //   2029: istore_1
    //   2030: goto -127 -> 1903
    //   2033: aload_3
    //   2034: ifnull +14 -> 2048
    //   2037: aload_3
    //   2038: getstatic 1161	com/tencent/mm/plugin/scanner/l$i:OLz	I
    //   2041: iconst_0
    //   2042: invokestatic 1164	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   2045: invokevirtual 589	android/widget/Toast:show	()V
    //   2048: iconst_0
    //   2049: istore_1
    //   2050: goto -596 -> 1454
    //   2053: aload_0
    //   2054: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   2057: ifnull +14 -> 2071
    //   2060: aload_0
    //   2061: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   2064: iconst_1
    //   2065: aconst_null
    //   2066: invokeinterface 477 3 0
    //   2071: ldc_w 815
    //   2074: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2077: return
    //   2078: aload 4
    //   2080: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   2083: sipush 372
    //   2086: if_icmpne +329 -> 2415
    //   2089: aload 4
    //   2091: checkcast 838	com/tencent/mm/openim/model/q
    //   2094: getfield 1168	com/tencent/mm/openim/model/q:psC	Lcom/tencent/mm/protocal/protobuf/evx;
    //   2097: astore 4
    //   2099: aload 4
    //   2101: getfield 1173	com/tencent/mm/protocal/protobuf/evx:UserName	Ljava/lang/String;
    //   2104: astore 7
    //   2106: ldc 170
    //   2108: ldc_w 1175
    //   2111: aload 7
    //   2113: invokestatic 1178	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2116: invokevirtual 1181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2119: invokestatic 637	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2122: aload_0
    //   2123: invokespecial 371	com/tencent/mm/plugin/scanner/util/c:cancelLoading	()V
    //   2126: aload_0
    //   2127: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   2130: ifnull +235 -> 2365
    //   2133: aload_0
    //   2134: getfield 447	com/tencent/mm/plugin/scanner/util/c:mActivityRef	Ljava/lang/ref/WeakReference;
    //   2137: invokevirtual 453	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2140: checkcast 455	android/content/Context
    //   2143: astore_3
    //   2144: aload 7
    //   2146: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2149: invokevirtual 985	java/lang/String:length	()I
    //   2152: ifle +218 -> 2370
    //   2155: ldc_w 987
    //   2158: invokestatic 664	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   2161: checkcast 987	com/tencent/mm/plugin/messenger/foundation/a/n
    //   2164: invokeinterface 991 1 0
    //   2169: aload 7
    //   2171: invokeinterface 997 2 0
    //   2176: astore 7
    //   2178: aload_0
    //   2179: invokespecial 1083	com/tencent/mm/plugin/scanner/util/c:gTN	()I
    //   2182: istore_1
    //   2183: new 765	android/content/Intent
    //   2186: dup
    //   2187: invokespecial 766	android/content/Intent:<init>	()V
    //   2190: astore 8
    //   2192: aload 8
    //   2194: aload 4
    //   2196: iload_1
    //   2197: invokestatic 1184	com/tencent/mm/api/d:a	(Landroid/content/Intent;Lcom/tencent/mm/protocal/protobuf/evx;I)V
    //   2200: aload 7
    //   2202: ifnull +24 -> 2226
    //   2205: aload 7
    //   2207: getfield 1002	com/tencent/mm/autogen/b/az:field_type	I
    //   2210: invokestatic 1007	com/tencent/mm/contact/d:rs	(I)Z
    //   2213: ifne +13 -> 2226
    //   2216: aload 8
    //   2218: ldc_w 1090
    //   2221: iconst_1
    //   2222: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2225: pop
    //   2226: aload_3
    //   2227: ifnull +79 -> 2306
    //   2230: invokestatic 1065	com/tencent/mm/plugin/scanner/m:dFc	()Lcom/tencent/mm/pluginsdk/m;
    //   2233: aload 8
    //   2235: aload_3
    //   2236: invokeinterface 1147 3 0
    //   2241: getstatic 436	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2244: sipush 14268
    //   2247: bipush 6
    //   2249: anewarray 4	java/lang/Object
    //   2252: dup
    //   2253: iconst_0
    //   2254: iconst_2
    //   2255: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2258: aastore
    //   2259: dup
    //   2260: iconst_1
    //   2261: aload_0
    //   2262: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   2265: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2268: aastore
    //   2269: dup
    //   2270: iconst_2
    //   2271: aload_0
    //   2272: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   2275: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2278: aastore
    //   2279: dup
    //   2280: iconst_3
    //   2281: aload_0
    //   2282: getfield 1156	com/tencent/mm/plugin/scanner/util/c:imagePath	Ljava/lang/String;
    //   2285: aastore
    //   2286: dup
    //   2287: iconst_4
    //   2288: aload_0
    //   2289: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   2292: aastore
    //   2293: dup
    //   2294: iconst_5
    //   2295: aload_0
    //   2296: getfield 1158	com/tencent/mm/plugin/scanner/util/c:hDe	Ljava/lang/String;
    //   2299: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2302: aastore
    //   2303: invokevirtual 439	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   2306: iconst_1
    //   2307: istore_1
    //   2308: iload_1
    //   2309: ifeq +81 -> 2390
    //   2312: aload_0
    //   2313: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   2316: ifnull +37 -> 2353
    //   2319: new 249	android/os/Bundle
    //   2322: dup
    //   2323: invokespecial 465	android/os/Bundle:<init>	()V
    //   2326: astore_3
    //   2327: aload_3
    //   2328: ldc_w 1072
    //   2331: aload 4
    //   2333: getfield 1173	com/tencent/mm/protocal/protobuf/evx:UserName	Ljava/lang/String;
    //   2336: invokevirtual 1075	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2339: aload_3
    //   2340: ldc_w 1077
    //   2343: iconst_4
    //   2344: invokevirtual 1081	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2347: aload_0
    //   2348: iconst_1
    //   2349: aload_3
    //   2350: invokespecial 362	com/tencent/mm/plugin/scanner/util/c:b	(ZLandroid/os/Bundle;)V
    //   2353: aload_0
    //   2354: iconst_4
    //   2355: invokespecial 685	com/tencent/mm/plugin/scanner/util/c:aiE	(I)V
    //   2358: ldc_w 815
    //   2361: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2364: return
    //   2365: aconst_null
    //   2366: astore_3
    //   2367: goto -223 -> 2144
    //   2370: aload_3
    //   2371: ifnull +14 -> 2385
    //   2374: aload_3
    //   2375: getstatic 1161	com/tencent/mm/plugin/scanner/l$i:OLz	I
    //   2378: iconst_0
    //   2379: invokestatic 1164	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   2382: invokevirtual 589	android/widget/Toast:show	()V
    //   2385: iconst_0
    //   2386: istore_1
    //   2387: goto -79 -> 2308
    //   2390: aload_0
    //   2391: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   2394: ifnull +14 -> 2408
    //   2397: aload_0
    //   2398: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   2401: iconst_1
    //   2402: aconst_null
    //   2403: invokeinterface 477 3 0
    //   2408: ldc_w 815
    //   2411: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2414: return
    //   2415: aload 4
    //   2417: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   2420: sipush 5900
    //   2423: if_icmpne +270 -> 2693
    //   2426: aload 4
    //   2428: invokevirtual 1188	com/tencent/mm/am/p:getReqResp	()Lcom/tencent/mm/network/s;
    //   2431: checkcast 1190	com/tencent/mm/am/c
    //   2434: getfield 1194	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
    //   2437: invokestatic 1199	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
    //   2440: checkcast 1201	com/tencent/mm/protocal/protobuf/pl
    //   2443: astore_3
    //   2444: ldc 170
    //   2446: new 113	java/lang/StringBuilder
    //   2449: dup
    //   2450: ldc_w 1203
    //   2453: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2456: aload_3
    //   2457: getfield 1206	com/tencent/mm/protocal/protobuf/pl:hNv	I
    //   2460: invokevirtual 887	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2463: ldc_w 1208
    //   2466: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: aload_3
    //   2470: getfield 1211	com/tencent/mm/protocal/protobuf/pl:YST	Z
    //   2473: invokevirtual 1214	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2476: ldc_w 1216
    //   2479: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: aload_3
    //   2483: getfield 1217	com/tencent/mm/protocal/protobuf/pl:url	Ljava/lang/String;
    //   2486: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2489: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2492: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2495: aload_3
    //   2496: getfield 1206	com/tencent/mm/protocal/protobuf/pl:hNv	I
    //   2499: ifne +82 -> 2581
    //   2502: aload_3
    //   2503: getfield 1211	com/tencent/mm/protocal/protobuf/pl:YST	Z
    //   2506: ifeq +75 -> 2581
    //   2509: aload 7
    //   2511: ifnull +151 -> 2662
    //   2514: aload 7
    //   2516: ldc_w 1219
    //   2519: invokestatic 1225	androidx/core/app/a:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   2522: ifeq +27 -> 2549
    //   2525: aload 7
    //   2527: iconst_1
    //   2528: anewarray 264	java/lang/String
    //   2531: dup
    //   2532: iconst_0
    //   2533: ldc_w 1219
    //   2536: aastore
    //   2537: bipush 26
    //   2539: invokestatic 1228	androidx/core/app/a:a	(Landroid/app/Activity;[Ljava/lang/String;I)V
    //   2542: ldc_w 815
    //   2545: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2548: return
    //   2549: ldc_w 1230
    //   2552: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   2555: checkcast 1230	com/tencent/d/a/a/a/b
    //   2558: aload 7
    //   2560: new 1236	com/tencent/mm/plugin/scanner/util/c$$ExternalSyntheticLambda0
    //   2563: dup
    //   2564: aload_0
    //   2565: invokespecial 1237	com/tencent/mm/plugin/scanner/util/c$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;)V
    //   2568: iconst_1
    //   2569: invokeinterface 1241 4 0
    //   2574: ldc_w 815
    //   2577: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2580: return
    //   2581: aload_3
    //   2582: getfield 1217	com/tencent/mm/protocal/protobuf/pl:url	Ljava/lang/String;
    //   2585: invokestatic 1247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2588: ifne +81 -> 2669
    //   2591: new 765	android/content/Intent
    //   2594: dup
    //   2595: invokespecial 766	android/content/Intent:<init>	()V
    //   2598: astore 4
    //   2600: aload 4
    //   2602: ldc_w 1130
    //   2605: aload_3
    //   2606: getfield 1217	com/tencent/mm/protocal/protobuf/pl:url	Ljava/lang/String;
    //   2609: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2612: pop
    //   2613: aload 4
    //   2615: ldc_w 1249
    //   2618: iconst_0
    //   2619: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2622: pop
    //   2623: aload 4
    //   2625: ldc_w 1251
    //   2628: iconst_1
    //   2629: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2632: pop
    //   2633: aload 4
    //   2635: ldc_w 1253
    //   2638: iconst_0
    //   2639: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2642: pop
    //   2643: aload 7
    //   2645: ldc_w 1255
    //   2648: ldc_w 1257
    //   2651: aload 4
    //   2653: invokestatic 1260	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2656: aload_0
    //   2657: iconst_1
    //   2658: aconst_null
    //   2659: invokespecial 362	com/tencent/mm/plugin/scanner/util/c:b	(ZLandroid/os/Bundle;)V
    //   2662: ldc_w 815
    //   2665: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2668: return
    //   2669: aload 7
    //   2671: ifnull -15 -> 2656
    //   2674: aload 7
    //   2676: aload 7
    //   2678: invokevirtual 1264	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   2681: getstatic 1267	com/tencent/mm/plugin/scanner/l$i:OLs	I
    //   2684: invokevirtual 1270	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2687: invokestatic 1276	com/tencent/mm/ui/base/aa:showTextToast	(Landroid/content/Context;Ljava/lang/String;)V
    //   2690: goto -34 -> 2656
    //   2693: aload 4
    //   2695: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   2698: sipush 3512
    //   2701: if_icmpne +571 -> 3272
    //   2704: aload 4
    //   2706: invokevirtual 1188	com/tencent/mm/am/p:getReqResp	()Lcom/tencent/mm/network/s;
    //   2709: checkcast 1190	com/tencent/mm/am/c
    //   2712: getfield 1194	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
    //   2715: invokestatic 1199	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
    //   2718: checkcast 1278	com/tencent/mm/protocal/protobuf/bbi
    //   2721: astore 9
    //   2723: aload 9
    //   2725: getfield 1282	com/tencent/mm/protocal/protobuf/bbi:ZIt	Ljava/util/LinkedList;
    //   2728: invokevirtual 1287	java/util/LinkedList:size	()I
    //   2731: ifle +401 -> 3132
    //   2734: new 765	android/content/Intent
    //   2737: dup
    //   2738: invokespecial 766	android/content/Intent:<init>	()V
    //   2741: astore 8
    //   2743: aload 8
    //   2745: ldc_w 1289
    //   2748: aload 9
    //   2750: getfield 1282	com/tencent/mm/protocal/protobuf/bbi:ZIt	Ljava/util/LinkedList;
    //   2753: iconst_0
    //   2754: invokevirtual 1292	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2757: checkcast 1294	com/tencent/mm/protocal/protobuf/FinderContact
    //   2760: getfield 1297	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   2763: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2766: pop
    //   2767: aload 8
    //   2769: ldc_w 1299
    //   2772: bipush 10
    //   2774: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2777: pop
    //   2778: aload 8
    //   2780: ldc_w 1301
    //   2783: iconst_3
    //   2784: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2787: pop
    //   2788: aload 8
    //   2790: ldc_w 1303
    //   2793: iconst_1
    //   2794: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2797: pop
    //   2798: aload 8
    //   2800: ldc_w 1305
    //   2803: bipush 6
    //   2805: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2808: pop
    //   2809: aload 8
    //   2811: ldc_w 1307
    //   2814: aload 9
    //   2816: getfield 1282	com/tencent/mm/protocal/protobuf/bbi:ZIt	Ljava/util/LinkedList;
    //   2819: iconst_0
    //   2820: invokevirtual 1292	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2823: checkcast 1294	com/tencent/mm/protocal/protobuf/FinderContact
    //   2826: getfield 1310	com/tencent/mm/protocal/protobuf/FinderContact:nickname	Ljava/lang/String;
    //   2829: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2832: pop
    //   2833: aload 8
    //   2835: ldc_w 1312
    //   2838: aload 9
    //   2840: getfield 1282	com/tencent/mm/protocal/protobuf/bbi:ZIt	Ljava/util/LinkedList;
    //   2843: iconst_0
    //   2844: invokevirtual 1292	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2847: checkcast 1294	com/tencent/mm/protocal/protobuf/FinderContact
    //   2850: getfield 1297	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   2853: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2856: pop
    //   2857: aload 4
    //   2859: checkcast 1314	com/tencent/mm/plugin/findersdk/a/cs
    //   2862: getfield 1318	com/tencent/mm/plugin/findersdk/a/cs:HcC	Ljava/util/List;
    //   2865: astore_3
    //   2866: aload_3
    //   2867: ifnonnull +272 -> 3139
    //   2870: aconst_null
    //   2871: astore_3
    //   2872: aload_3
    //   2873: invokestatic 1247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2876: ifne +28 -> 2904
    //   2879: aload 8
    //   2881: ldc_w 1320
    //   2884: aload_3
    //   2885: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2888: pop
    //   2889: ldc 170
    //   2891: ldc_w 1322
    //   2894: aload_3
    //   2895: invokestatic 1178	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2898: invokevirtual 1181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2901: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2904: aload 9
    //   2906: getfield 1326	com/tencent/mm/protocal/protobuf/bbi:ZMa	Lcom/tencent/mm/protocal/protobuf/ejf;
    //   2909: ifnull +60 -> 2969
    //   2912: new 1328	com/tencent/mm/ad/i
    //   2915: dup
    //   2916: invokespecial 1329	com/tencent/mm/ad/i:<init>	()V
    //   2919: astore 4
    //   2921: aload 4
    //   2923: ldc_w 1331
    //   2926: aload 9
    //   2928: getfield 1326	com/tencent/mm/protocal/protobuf/bbi:ZMa	Lcom/tencent/mm/protocal/protobuf/ejf;
    //   2931: getfield 1334	com/tencent/mm/protocal/protobuf/ejf:scene	I
    //   2934: invokevirtual 1338	com/tencent/mm/ad/i:au	(Ljava/lang/String;I)Lcom/tencent/mm/ad/i;
    //   2937: pop
    //   2938: aload_3
    //   2939: invokestatic 1247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2942: ifne +13 -> 2955
    //   2945: aload 4
    //   2947: ldc_w 1340
    //   2950: aload_3
    //   2951: invokevirtual 1343	com/tencent/mm/ad/i:m	(Ljava/lang/String;Ljava/lang/Object;)Lcom/tencent/mm/ad/i;
    //   2954: pop
    //   2955: aload 8
    //   2957: ldc_w 1345
    //   2960: aload 4
    //   2962: invokevirtual 1346	com/tencent/mm/ad/i:toString	()Ljava/lang/String;
    //   2965: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2968: pop
    //   2969: bipush 32
    //   2971: istore_2
    //   2972: aload 9
    //   2974: getfield 1282	com/tencent/mm/protocal/protobuf/bbi:ZIt	Ljava/util/LinkedList;
    //   2977: iconst_0
    //   2978: invokevirtual 1292	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   2981: checkcast 1294	com/tencent/mm/protocal/protobuf/FinderContact
    //   2984: getfield 1297	com/tencent/mm/protocal/protobuf/FinderContact:username	Ljava/lang/String;
    //   2987: invokestatic 1351	com/tencent/mm/model/z:bAW	()Ljava/lang/String;
    //   2990: invokevirtual 1354	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2993: ifeq +6 -> 2999
    //   2996: bipush 33
    //   2998: istore_2
    //   2999: aload_0
    //   3000: getfield 419	com/tencent/mm/plugin/scanner/util/c:sourceType	I
    //   3003: tableswitch	default:+29 -> 3032, 0:+248->3251, 1:+233->3236, 2:+238->3241, 3:+243->3246
    //   3033: istore_1
    //   3034: ldc_w 1356
    //   3037: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   3040: checkcast 1356	com/tencent/mm/plugin/findersdk/a/cn
    //   3043: iload_1
    //   3044: bipush 16
    //   3046: iload_2
    //   3047: aload 8
    //   3049: invokeinterface 1360 5 0
    //   3054: pop
    //   3055: aload 7
    //   3057: ifnull +69 -> 3126
    //   3060: aconst_null
    //   3061: astore_3
    //   3062: aload_0
    //   3063: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3066: invokestatic 1366	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3069: ldc_w 1368
    //   3072: invokevirtual 1371	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3075: astore 4
    //   3077: aload 4
    //   3079: astore_3
    //   3080: aload 4
    //   3082: ifnonnull +6 -> 3088
    //   3085: ldc 243
    //   3087: astore_3
    //   3088: aload 8
    //   3090: ldc_w 1373
    //   3093: iconst_1
    //   3094: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   3097: pop
    //   3098: aload 8
    //   3100: ldc_w 1375
    //   3103: aload_3
    //   3104: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3107: pop
    //   3108: ldc_w 1356
    //   3111: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   3114: checkcast 1356	com/tencent/mm/plugin/findersdk/a/cn
    //   3117: aload 7
    //   3119: aload 8
    //   3121: invokeinterface 1379 3 0
    //   3126: aload_0
    //   3127: iconst_1
    //   3128: aconst_null
    //   3129: invokespecial 362	com/tencent/mm/plugin/scanner/util/c:b	(ZLandroid/os/Bundle;)V
    //   3132: ldc_w 815
    //   3135: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3138: return
    //   3139: aload_3
    //   3140: checkcast 1381	java/util/Collection
    //   3143: invokeinterface 1383 1 0
    //   3148: ifne +18 -> 3166
    //   3151: iconst_1
    //   3152: istore_1
    //   3153: iload_1
    //   3154: ifeq +17 -> 3171
    //   3157: aload_3
    //   3158: ifnonnull +18 -> 3176
    //   3161: aconst_null
    //   3162: astore_3
    //   3163: goto -291 -> 2872
    //   3166: iconst_0
    //   3167: istore_1
    //   3168: goto -15 -> 3153
    //   3171: aconst_null
    //   3172: astore_3
    //   3173: goto -16 -> 3157
    //   3176: aload_3
    //   3177: invokestatic 1389	kotlin/a/p:oL	(Ljava/util/List;)Ljava/lang/Object;
    //   3180: checkcast 264	java/lang/String
    //   3183: astore_3
    //   3184: aload_3
    //   3185: ifnonnull +8 -> 3193
    //   3188: aconst_null
    //   3189: astore_3
    //   3190: goto -318 -> 2872
    //   3193: aload_3
    //   3194: invokestatic 1366	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3197: ldc_w 1391
    //   3200: invokevirtual 1371	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3203: astore_3
    //   3204: goto -332 -> 2872
    //   3207: astore_3
    //   3208: ldc 170
    //   3210: new 113	java/lang/StringBuilder
    //   3213: dup
    //   3214: ldc_w 1393
    //   3217: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3220: aload_3
    //   3221: invokevirtual 1396	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3224: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3227: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3230: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3233: goto -264 -> 2969
    //   3236: iconst_2
    //   3237: istore_1
    //   3238: goto -204 -> 3034
    //   3241: iconst_3
    //   3242: istore_1
    //   3243: goto -209 -> 3034
    //   3246: iconst_4
    //   3247: istore_1
    //   3248: goto -214 -> 3034
    //   3251: bipush 22
    //   3253: istore_1
    //   3254: goto -220 -> 3034
    //   3257: astore 4
    //   3259: ldc 170
    //   3261: aload 4
    //   3263: invokevirtual 1396	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3266: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3269: goto -181 -> 3088
    //   3272: aload 4
    //   3274: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   3277: sipush 233
    //   3280: if_icmpne +1128 -> 4408
    //   3283: aload 4
    //   3285: checkcast 280	com/tencent/mm/modelsimple/n
    //   3288: invokevirtual 1399	com/tencent/mm/modelsimple/n:bLT	()Ljava/lang/String;
    //   3291: astore_3
    //   3292: new 249	android/os/Bundle
    //   3295: dup
    //   3296: invokespecial 465	android/os/Bundle:<init>	()V
    //   3299: astore 8
    //   3301: aload 8
    //   3303: ldc_w 1072
    //   3306: aload_3
    //   3307: invokevirtual 1075	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3310: aload 8
    //   3312: ldc_w 1077
    //   3315: aload 4
    //   3317: checkcast 280	com/tencent/mm/modelsimple/n
    //   3320: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3323: invokevirtual 1081	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3326: aload_0
    //   3327: aload 4
    //   3329: checkcast 280	com/tencent/mm/modelsimple/n
    //   3332: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3335: invokespecial 685	com/tencent/mm/plugin/scanner/util/c:aiE	(I)V
    //   3338: aload_0
    //   3339: invokespecial 1404	com/tencent/mm/plugin/scanner/util/c:gTM	()I
    //   3342: istore_1
    //   3343: ldc 170
    //   3345: ldc_w 1406
    //   3348: iconst_1
    //   3349: anewarray 4	java/lang/Object
    //   3352: dup
    //   3353: iconst_0
    //   3354: iload_1
    //   3355: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3358: aastore
    //   3359: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3362: aload_0
    //   3363: aload 4
    //   3365: checkcast 280	com/tencent/mm/modelsimple/n
    //   3368: new 12	com/tencent/mm/plugin/scanner/util/c$10
    //   3371: dup
    //   3372: aload_0
    //   3373: invokespecial 1407	com/tencent/mm/plugin/scanner/util/c$10:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;)V
    //   3376: aload_0
    //   3377: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3380: iload_1
    //   3381: aload_0
    //   3382: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   3385: new 14	com/tencent/mm/plugin/scanner/util/c$11
    //   3388: dup
    //   3389: aload_0
    //   3390: invokespecial 1408	com/tencent/mm/plugin/scanner/util/c$11:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;)V
    //   3393: aload_0
    //   3394: getfield 245	com/tencent/mm/plugin/scanner/util/c:Pid	Landroid/os/Bundle;
    //   3397: invokestatic 1413	com/tencent/mm/plugin/qrcode/model/a:a	(Lcom/tencent/mm/plugin/qrcode/model/a$a;Lcom/tencent/mm/modelsimple/n;Landroid/content/DialogInterface$OnClickListener;Ljava/lang/String;IILjava/lang/Runnable;Landroid/os/Bundle;)Z
    //   3400: istore 6
    //   3402: iload 6
    //   3404: ifne +39 -> 3443
    //   3407: aload 4
    //   3409: checkcast 280	com/tencent/mm/modelsimple/n
    //   3412: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3415: iconst_4
    //   3416: if_icmpne +27 -> 3443
    //   3419: aload 7
    //   3421: ifnull +15 -> 3436
    //   3424: aload_0
    //   3425: aload 7
    //   3427: aload_0
    //   3428: getfield 241	com/tencent/mm/plugin/scanner/util/c:Pib	I
    //   3431: aload_3
    //   3432: iconst_1
    //   3433: invokespecial 599	com/tencent/mm/plugin/scanner/util/c:a	(Landroid/app/Activity;ILjava/lang/String;Z)V
    //   3436: ldc_w 815
    //   3439: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3442: return
    //   3443: iload 6
    //   3445: ifne +56 -> 3501
    //   3448: aload 4
    //   3450: checkcast 280	com/tencent/mm/modelsimple/n
    //   3453: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3456: bipush 48
    //   3458: if_icmpne +43 -> 3501
    //   3461: new 1415	com/tencent/mm/plugin/scanner/model/o
    //   3464: dup
    //   3465: aload_3
    //   3466: invokespecial 1416	com/tencent/mm/plugin/scanner/model/o:<init>	(Ljava/lang/String;)V
    //   3469: astore_3
    //   3470: aload_0
    //   3471: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   3474: aload_3
    //   3475: iconst_1
    //   3476: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3479: invokeinterface 213 3 0
    //   3484: pop
    //   3485: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   3488: aload_3
    //   3489: iconst_0
    //   3490: invokevirtual 216	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   3493: pop
    //   3494: ldc_w 815
    //   3497: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3500: return
    //   3501: iload 6
    //   3503: ifne +132 -> 3635
    //   3506: aload 4
    //   3508: checkcast 280	com/tencent/mm/modelsimple/n
    //   3511: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3514: bipush 29
    //   3516: if_icmpne +119 -> 3635
    //   3519: aload 7
    //   3521: ifnull +107 -> 3628
    //   3524: ldc 170
    //   3526: ldc 193
    //   3528: iconst_1
    //   3529: anewarray 4	java/lang/Object
    //   3532: dup
    //   3533: iconst_0
    //   3534: aload_3
    //   3535: aastore
    //   3536: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3539: new 838	com/tencent/mm/openim/model/q
    //   3542: dup
    //   3543: aload_3
    //   3544: iconst_0
    //   3545: invokespecial 1418	com/tencent/mm/openim/model/q:<init>	(Ljava/lang/String;Z)V
    //   3548: astore_3
    //   3549: aload_0
    //   3550: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   3553: aload_3
    //   3554: iconst_1
    //   3555: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3558: invokeinterface 213 3 0
    //   3563: pop
    //   3564: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   3567: aload_3
    //   3568: iconst_0
    //   3569: invokevirtual 216	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   3572: pop
    //   3573: new 38	com/tencent/mm/plugin/scanner/util/c$4
    //   3576: dup
    //   3577: aload_0
    //   3578: aload_3
    //   3579: invokespecial 1421	com/tencent/mm/plugin/scanner/util/c$4:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;Lcom/tencent/mm/openim/model/q;)V
    //   3582: astore_3
    //   3583: aload 7
    //   3585: ifnull +43 -> 3628
    //   3588: aload_0
    //   3589: getfield 168	com/tencent/mm/plugin/scanner/util/c:Pig	Z
    //   3592: ifeq +23 -> 3615
    //   3595: aload_0
    //   3596: aload 7
    //   3598: getstatic 222	com/tencent/mm/plugin/scanner/l$i:gUc	I
    //   3601: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3604: aload_3
    //   3605: invokespecial 231	com/tencent/mm/plugin/scanner/util/c:c	(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/view/c$a;)V
    //   3608: ldc_w 815
    //   3611: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3614: return
    //   3615: aload_0
    //   3616: aload 7
    //   3618: getstatic 222	com/tencent/mm/plugin/scanner/l$i:gUc	I
    //   3621: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3624: aload_3
    //   3625: invokespecial 233	com/tencent/mm/plugin/scanner/util/c:a	(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/view/c$a;)V
    //   3628: ldc_w 815
    //   3631: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3634: return
    //   3635: iload 6
    //   3637: ifne +132 -> 3769
    //   3640: aload 4
    //   3642: checkcast 280	com/tencent/mm/modelsimple/n
    //   3645: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3648: bipush 37
    //   3650: if_icmpne +119 -> 3769
    //   3653: aload 7
    //   3655: ifnull +107 -> 3762
    //   3658: ldc 170
    //   3660: ldc_w 1423
    //   3663: iconst_1
    //   3664: anewarray 4	java/lang/Object
    //   3667: dup
    //   3668: iconst_0
    //   3669: aload_3
    //   3670: aastore
    //   3671: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3674: new 1425	java/util/ArrayList
    //   3677: dup
    //   3678: invokespecial 1426	java/util/ArrayList:<init>	()V
    //   3681: astore 4
    //   3683: aload 4
    //   3685: aload_3
    //   3686: invokeinterface 1431 2 0
    //   3691: pop
    //   3692: new 1314	com/tencent/mm/plugin/findersdk/a/cs
    //   3695: dup
    //   3696: aload 4
    //   3698: invokespecial 1434	com/tencent/mm/plugin/findersdk/a/cs:<init>	(Ljava/util/List;)V
    //   3701: astore_3
    //   3702: aload_0
    //   3703: getfield 162	com/tencent/mm/plugin/scanner/util/c:Pif	Ljava/util/Map;
    //   3706: aload_3
    //   3707: iconst_1
    //   3708: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3711: invokeinterface 213 3 0
    //   3716: pop
    //   3717: invokestatic 183	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   3720: aload_3
    //   3721: iconst_0
    //   3722: invokevirtual 216	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   3725: pop
    //   3726: aload 7
    //   3728: getstatic 866	com/tencent/mm/plugin/scanner/l$i:app_tip	I
    //   3731: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3734: pop
    //   3735: aload_0
    //   3736: aload 7
    //   3738: aload 7
    //   3740: getstatic 222	com/tencent/mm/plugin/scanner/l$i:gUc	I
    //   3743: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   3746: iconst_1
    //   3747: new 40	com/tencent/mm/plugin/scanner/util/c$5
    //   3750: dup
    //   3751: aload_0
    //   3752: aload_3
    //   3753: invokespecial 1437	com/tencent/mm/plugin/scanner/util/c$5:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;Lcom/tencent/mm/plugin/findersdk/a/cs;)V
    //   3756: invokestatic 1439	com/tencent/mm/ui/base/k:b	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/w;
    //   3759: putfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   3762: ldc_w 815
    //   3765: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3768: return
    //   3769: iload 6
    //   3771: ifne +123 -> 3894
    //   3774: aload 4
    //   3776: checkcast 280	com/tencent/mm/modelsimple/n
    //   3779: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3782: bipush 45
    //   3784: if_icmpne +110 -> 3894
    //   3787: ldc 243
    //   3789: astore_3
    //   3790: ldc 170
    //   3792: new 113	java/lang/StringBuilder
    //   3795: dup
    //   3796: ldc_w 1441
    //   3799: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3802: aload_0
    //   3803: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3806: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3809: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3812: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3815: aload_0
    //   3816: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3819: invokestatic 1366	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3822: ldc_w 1443
    //   3825: invokevirtual 1371	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3828: astore 4
    //   3830: aload 4
    //   3832: astore_3
    //   3833: aload_3
    //   3834: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3837: ifne +50 -> 3887
    //   3840: new 765	android/content/Intent
    //   3843: dup
    //   3844: invokespecial 766	android/content/Intent:<init>	()V
    //   3847: astore 4
    //   3849: aload 4
    //   3851: ldc_w 1445
    //   3854: aload_3
    //   3855: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3858: pop
    //   3859: aload 4
    //   3861: ldc_w 1447
    //   3864: iconst_1
    //   3865: invokevirtual 1059	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   3868: pop
    //   3869: ldc_w 1230
    //   3872: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   3875: checkcast 1230	com/tencent/d/a/a/a/b
    //   3878: aload 7
    //   3880: aload 4
    //   3882: invokeinterface 1450 3 0
    //   3887: ldc_w 815
    //   3890: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3893: return
    //   3894: iload 6
    //   3896: ifne +130 -> 4026
    //   3899: aload 4
    //   3901: checkcast 280	com/tencent/mm/modelsimple/n
    //   3904: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   3907: bipush 46
    //   3909: if_icmpne +117 -> 4026
    //   3912: ldc 243
    //   3914: astore_3
    //   3915: ldc 170
    //   3917: new 113	java/lang/StringBuilder
    //   3920: dup
    //   3921: ldc_w 1452
    //   3924: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3927: aload_0
    //   3928: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3931: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3934: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3937: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3940: aload_0
    //   3941: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   3944: invokestatic 1366	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   3947: ldc_w 1454
    //   3950: invokevirtual 1371	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   3953: astore 4
    //   3955: aload 4
    //   3957: astore_3
    //   3958: aload_3
    //   3959: invokestatic 260	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3962: ifne +57 -> 4019
    //   3965: ldc_w 1356
    //   3968: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   3971: checkcast 1356	com/tencent/mm/plugin/findersdk/a/cn
    //   3974: bipush 11
    //   3976: bipush 8
    //   3978: bipush 65
    //   3980: invokeinterface 1458 4 0
    //   3985: astore 4
    //   3987: invokestatic 1351	com/tencent/mm/model/z:bAW	()Ljava/lang/String;
    //   3990: astore 7
    //   3992: ldc_w 1356
    //   3995: invokestatic 1234	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   3998: checkcast 1356	com/tencent/mm/plugin/findersdk/a/cn
    //   4001: invokeinterface 1462 1 0
    //   4006: iconst_1
    //   4007: aload_3
    //   4008: aload 7
    //   4010: aload 4
    //   4012: ldc 243
    //   4014: invokeinterface 1468 6 0
    //   4019: ldc_w 815
    //   4022: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4025: return
    //   4026: iload 6
    //   4028: ifne +201 -> 4229
    //   4031: aload 4
    //   4033: checkcast 280	com/tencent/mm/modelsimple/n
    //   4036: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   4039: bipush 47
    //   4041: if_icmpne +188 -> 4229
    //   4044: aload 7
    //   4046: ifnull +177 -> 4223
    //   4049: iconst_1
    //   4050: istore 6
    //   4052: ldc 170
    //   4054: ldc_w 1470
    //   4057: iconst_2
    //   4058: anewarray 4	java/lang/Object
    //   4061: dup
    //   4062: iconst_0
    //   4063: iload 6
    //   4065: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4068: aastore
    //   4069: dup
    //   4070: iconst_1
    //   4071: aload_0
    //   4072: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   4075: aastore
    //   4076: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4079: aload 7
    //   4081: ifnull +135 -> 4216
    //   4084: aload_0
    //   4085: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   4088: astore 4
    //   4090: new 1472	com/tencent/mm/plugin/textstatus/a/z$a
    //   4093: dup
    //   4094: invokespecial 1473	com/tencent/mm/plugin/textstatus/a/z$a:<init>	()V
    //   4097: astore_3
    //   4098: aload_3
    //   4099: getfield 1477	com/tencent/mm/plugin/textstatus/a/z$a:ThX	Lcom/tencent/mm/plugin/textstatus/a/z;
    //   4102: aload 4
    //   4104: putfield 1482	com/tencent/mm/plugin/textstatus/a/z:Tox	Ljava/lang/String;
    //   4107: getstatic 607	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   4110: astore 4
    //   4112: aload_3
    //   4113: getfield 1477	com/tencent/mm/plugin/textstatus/a/z$a:ThX	Lcom/tencent/mm/plugin/textstatus/a/z;
    //   4116: aload 4
    //   4118: invokevirtual 1485	java/lang/Boolean:booleanValue	()Z
    //   4121: putfield 1488	com/tencent/mm/plugin/textstatus/a/z:Toy	Z
    //   4124: aload_3
    //   4125: getfield 1477	com/tencent/mm/plugin/textstatus/a/z$a:ThX	Lcom/tencent/mm/plugin/textstatus/a/z;
    //   4128: ldc2_w 1489
    //   4131: putfield 1494	com/tencent/mm/plugin/textstatus/a/z:Toz	J
    //   4134: aload_0
    //   4135: invokespecial 1404	com/tencent/mm/plugin/scanner/util/c:gTM	()I
    //   4138: istore_1
    //   4139: aload_3
    //   4140: getfield 1477	com/tencent/mm/plugin/textstatus/a/z$a:ThX	Lcom/tencent/mm/plugin/textstatus/a/z;
    //   4143: iload_1
    //   4144: putfield 1497	com/tencent/mm/plugin/textstatus/a/z:ToA	I
    //   4147: aload_3
    //   4148: getfield 1477	com/tencent/mm/plugin/textstatus/a/z$a:ThX	Lcom/tencent/mm/plugin/textstatus/a/z;
    //   4151: astore_3
    //   4152: ldc_w 1499
    //   4155: invokestatic 664	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4158: checkcast 1499	com/tencent/mm/plugin/textstatus/a/n
    //   4161: aload 7
    //   4163: aload_3
    //   4164: new 42	com/tencent/mm/plugin/scanner/util/c$6
    //   4167: dup
    //   4168: aload_0
    //   4169: aload 7
    //   4171: invokespecial 1502	com/tencent/mm/plugin/scanner/util/c$6:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;Landroid/app/Activity;)V
    //   4174: invokeinterface 1505 4 0
    //   4179: astore_3
    //   4180: aload 7
    //   4182: getstatic 866	com/tencent/mm/plugin/scanner/l$i:app_tip	I
    //   4185: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   4188: pop
    //   4189: aload_0
    //   4190: aload 7
    //   4192: aload 7
    //   4194: getstatic 222	com/tencent/mm/plugin/scanner/l$i:gUc	I
    //   4197: invokevirtual 227	android/app/Activity:getString	(I)Ljava/lang/String;
    //   4200: iconst_1
    //   4201: new 46	com/tencent/mm/plugin/scanner/util/c$7
    //   4204: dup
    //   4205: aload_0
    //   4206: aload_3
    //   4207: invokespecial 1508	com/tencent/mm/plugin/scanner/util/c$7:<init>	(Lcom/tencent/mm/plugin/scanner/util/c;Lcom/tencent/mm/plugin/textstatus/a/q;)V
    //   4210: invokestatic 1439	com/tencent/mm/ui/base/k:b	(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/DialogInterface$OnCancelListener;)Lcom/tencent/mm/ui/base/w;
    //   4213: putfield 153	com/tencent/mm/plugin/scanner/util/c:vEG	Landroid/app/ProgressDialog;
    //   4216: ldc_w 815
    //   4219: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4222: return
    //   4223: iconst_0
    //   4224: istore 6
    //   4226: goto -174 -> 4052
    //   4229: iload 6
    //   4231: ifne +70 -> 4301
    //   4234: aload 4
    //   4236: checkcast 280	com/tencent/mm/modelsimple/n
    //   4239: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   4242: bipush 49
    //   4244: if_icmpne +57 -> 4301
    //   4247: aload 7
    //   4249: ifnull +46 -> 4295
    //   4252: iconst_1
    //   4253: istore 6
    //   4255: ldc 170
    //   4257: ldc_w 1510
    //   4260: iconst_2
    //   4261: anewarray 4	java/lang/Object
    //   4264: dup
    //   4265: iconst_0
    //   4266: iload 6
    //   4268: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4271: aastore
    //   4272: dup
    //   4273: iconst_1
    //   4274: aload_0
    //   4275: getfield 351	com/tencent/mm/plugin/scanner/util/c:Pic	Ljava/lang/String;
    //   4278: aastore
    //   4279: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4282: aload 7
    //   4284: iconst_4
    //   4285: invokestatic 1516	com/tencent/mm/plugin/ringtone/PluginRingtone:enterRingtoneSettingUI	(Landroid/content/Context;I)V
    //   4288: ldc_w 815
    //   4291: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4294: return
    //   4295: iconst_0
    //   4296: istore 6
    //   4298: goto -43 -> 4255
    //   4301: iload 6
    //   4303: ifne +55 -> 4358
    //   4306: aload 4
    //   4308: checkcast 280	com/tencent/mm/modelsimple/n
    //   4311: invokevirtual 1402	com/tencent/mm/modelsimple/n:bLV	()I
    //   4314: bipush 41
    //   4316: if_icmpne +42 -> 4358
    //   4319: new 765	android/content/Intent
    //   4322: dup
    //   4323: invokespecial 766	android/content/Intent:<init>	()V
    //   4326: astore 4
    //   4328: aload 4
    //   4330: ldc_w 1518
    //   4333: aload_3
    //   4334: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4337: pop
    //   4338: aload 7
    //   4340: ldc_w 1520
    //   4343: ldc_w 1522
    //   4346: aload 4
    //   4348: invokestatic 1260	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   4351: ldc_w 815
    //   4354: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4357: return
    //   4358: ldc 170
    //   4360: ldc_w 1524
    //   4363: iconst_1
    //   4364: anewarray 4	java/lang/Object
    //   4367: dup
    //   4368: iconst_0
    //   4369: iload 6
    //   4371: invokestatic 343	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4374: aastore
    //   4375: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4378: iload 6
    //   4380: ifne +21 -> 4401
    //   4383: aload_0
    //   4384: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   4387: ifnull +14 -> 4401
    //   4390: aload_0
    //   4391: getfield 155	com/tencent/mm/plugin/scanner/util/c:Pie	Lcom/tencent/mm/plugin/scanner/g/f$a;
    //   4394: iconst_1
    //   4395: aconst_null
    //   4396: invokeinterface 477 3 0
    //   4401: ldc_w 815
    //   4404: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4407: return
    //   4408: aload 4
    //   4410: invokevirtual 836	com/tencent/mm/am/p:getType	()I
    //   4413: sipush 666
    //   4416: if_icmpne +130 -> 4546
    //   4419: iload_1
    //   4420: ifne +118 -> 4538
    //   4423: iload_2
    //   4424: ifne +114 -> 4538
    //   4427: aload 4
    //   4429: instanceof 825
    //   4432: ifeq +114 -> 4546
    //   4435: aload 4
    //   4437: checkcast 825	com/tencent/mm/modelemoji/c
    //   4440: invokevirtual 1528	com/tencent/mm/modelemoji/c:bIM	()Lcom/tencent/mm/protocal/protobuf/dfb;
    //   4443: getfield 1533	com/tencent/mm/protocal/protobuf/dfb:ProductID	Ljava/lang/String;
    //   4446: astore_3
    //   4447: ldc 170
    //   4449: ldc_w 1535
    //   4452: iconst_1
    //   4453: anewarray 4	java/lang/Object
    //   4456: dup
    //   4457: iconst_0
    //   4458: aload_3
    //   4459: aastore
    //   4460: invokestatic 368	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4463: new 765	android/content/Intent
    //   4466: dup
    //   4467: invokespecial 766	android/content/Intent:<init>	()V
    //   4470: astore 4
    //   4472: aload 4
    //   4474: ldc_w 1537
    //   4477: aload_3
    //   4478: invokevirtual 772	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4481: pop
    //   4482: aload 4
    //   4484: ldc_w 1539
    //   4487: bipush 11
    //   4489: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4492: pop
    //   4493: aload 4
    //   4495: ldc_w 1541
    //   4498: bipush 14
    //   4500: invokevirtual 1101	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   4503: pop
    //   4504: aload 7
    //   4506: ldc_w 1543
    //   4509: ldc_w 1545
    //   4512: aload 4
    //   4514: invokestatic 1260	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   4517: ldc 170
    //   4519: ldc_w 1547
    //   4522: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4525: aload_0
    //   4526: iconst_1
    //   4527: aconst_null
    //   4528: invokespecial 362	com/tencent/mm/plugin/scanner/util/c:b	(ZLandroid/os/Bundle;)V
    //   4531: ldc_w 815
    //   4534: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4537: return
    //   4538: ldc 170
    //   4540: ldc_w 1549
    //   4543: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   4546: ldc_w 815
    //   4549: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4552: return
    //   4553: astore 4
    //   4555: goto -597 -> 3958
    //   4558: astore 4
    //   4560: goto -727 -> 3833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4563	0	this	c
    //   0	4563	1	paramInt1	int
    //   0	4563	2	paramInt2	int
    //   0	4563	3	paramString	String
    //   0	4563	4	paramp	p
    //   553	577	5	i	int
    //   47	4332	6	bool	boolean
    //   263	4242	7	localObject1	Object
    //   863	2448	8	localObject2	Object
    //   1191	1782	9	localObject3	Object
    //   1304	476	10	localObject4	Object
    //   1361	430	11	localObject5	Object
    //   1732	70	12	str	String
    //   1683	150	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2921	2955	3207	java/lang/Exception
    //   2955	2969	3207	java/lang/Exception
    //   3062	3077	3257	java/lang/Exception
    //   3940	3955	4553	finally
    //   3815	3830	4558	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */