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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.ph.b;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tk.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.openim.b.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.am;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.scanner.view.c.a;
import com.tencent.mm.plugin.v.a.a.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  implements com.tencent.mm.ak.i, a.a
{
  private static final String CTl;
  private boolean CFK;
  private boolean CIS;
  private int CJz;
  private boolean CSX;
  private int CSY;
  private com.tencent.mm.plugin.scanner.view.c CTa;
  private Timer CTb;
  private TimerTask CTc;
  private int CTm;
  private String CTn;
  private Bundle CTo;
  private com.tencent.mm.plugin.scanner.f.e.a CTp;
  private Map<com.tencent.mm.ak.q, Integer> CTq;
  private boolean CTr;
  public String appId;
  private int dFL;
  private int dFM;
  public String dFO;
  public String imagePath;
  public Activity mActivity;
  public int pHw;
  public ProgressDialog pqa;
  public String source;
  public int sourceType;
  public String talker;
  private String typeName;
  
  static
  {
    AppMethodBeat.i(240823);
    CTl = "https://" + WeChatHosts.domainString(2131761732) + "/qr/";
    AppMethodBeat.o(240823);
  }
  
  public c()
  {
    AppMethodBeat.i(52043);
    this.CFK = false;
    this.CSY = -1;
    this.CIS = false;
    this.pqa = null;
    this.CTp = null;
    this.CTa = null;
    this.CTq = new HashMap();
    this.CTb = null;
    this.CTc = null;
    this.CTr = false;
    Log.i("MicroMsg.QBarStringHandler", "onResume");
    com.tencent.mm.kernel.g.azz().a(106, this);
    com.tencent.mm.kernel.g.azz().a(233, this);
    com.tencent.mm.kernel.g.azz().a(666, this);
    com.tencent.mm.kernel.g.azz().a(372, this);
    com.tencent.mm.kernel.g.azz().a(3512, this);
    AppMethodBeat.o(52043);
  }
  
  private static int Vl(int paramInt)
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
  
  private static int Xa(int paramInt)
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
  
  private void Xb(int paramInt)
  {
    AppMethodBeat.i(52055);
    Object localObject2;
    if (this.CTo != null)
    {
      localObject2 = this.CTo.getString("stat_url");
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
      String str = URLEncoder.encode(Util.nullAsNil(this.CTn), "UTF-8");
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
    com.tencent.mm.plugin.report.service.h.CyF.a(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(52055);
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
      this.CTq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
      paramString = new c.a()
      {
        public final void eRN()
        {
          AppMethodBeat.i(240808);
          com.tencent.mm.kernel.g.azz().a(paramString);
          if (c.b(c.this) != null) {
            c.b(c.this).r(1, null);
          }
          c.a(c.this, paramString);
          AppMethodBeat.o(240808);
        }
      };
      if (paramActivity == null) {
        break label127;
      }
      if ((!paramBoolean) || (!this.CTr)) {
        break;
      }
      c(paramActivity.getString(2131764943), paramString);
      AppMethodBeat.o(52052);
      return;
    }
    a(paramActivity.getString(2131764943), paramString);
    label127:
    AppMethodBeat.o(52052);
  }
  
  private void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(52053);
    int i;
    String str1;
    String str2;
    Object localObject2;
    if (this.pHw > 0)
    {
      i = this.pHw;
      Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.CTm), Integer.valueOf(i) });
      str1 = "";
      str2 = "";
      localObject1 = "";
      if (this.CTo == null) {
        break label372;
      }
      str1 = this.CTo.getString("stat_send_msg_user");
      localObject2 = this.CTo.getString("stat_msg_id");
      if (!Util.isNullOrNil((String)localObject2)) {
        localObject1 = ((String)localObject2).replace("msg_", "").replace("sns_", "");
      }
      str2 = this.CTo.getString("stat_chat_talker_username");
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = str2)
    {
      localObject1 = new com.tencent.mm.modelsimple.l(paramString1, (String)localObject1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0], str1, (String)localObject2);
      if ((paramString1.startsWith(com.tencent.mm.plugin.scanner.g.CAd)) || (paramString1.startsWith(com.tencent.mm.plugin.scanner.g.CAe)))
      {
        str1 = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = com.tencent.mm.ui.e.a.akL(this.CTm);
        ((com.tencent.mm.modelsimple.l)localObject1).setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!Util.isNullOrNil(str1))
        {
          paramString2 = ad.aVe().JV(str1);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          ((com.tencent.mm.modelsimple.l)localObject1).Pz(paramString1);
          paramString2 = paramString1;
        }
        Log.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.CTq.put(localObject1, Integer.valueOf(1));
      com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      if (this.pqa != null) {
        this.pqa.dismiss();
      }
      a(paramActivity.getString(2131764152), new c.a()
      {
        public final void eRN()
        {
          AppMethodBeat.i(163478);
          com.tencent.mm.kernel.g.azz().a(this.kIa);
          if (c.b(c.this) != null) {
            c.b(c.this).r(1, null);
          }
          c.a(c.this, this.kIa);
          AppMethodBeat.o(163478);
        }
      });
      AppMethodBeat.o(52053);
      return;
      i = Xa(this.CTm);
      break;
      label372:
      localObject2 = "";
    }
  }
  
  private void a(String paramString, c.a parama)
  {
    boolean bool1 = false;
    AppMethodBeat.i(52044);
    boolean bool2 = this.CIS;
    if (this.CTa == null) {
      bool1 = true;
    }
    Log.d("MicroMsg.QBarStringHandler", "alvinluo showLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if ((this.CTa != null) && (this.CIS))
    {
      cancelLoading();
      this.CTb = new Timer();
      this.CTc = new i(this.CTa, new i.b()
      {
        public final void onShow()
        {
          AppMethodBeat.i(240806);
          c.a(c.this);
          AppMethodBeat.o(240806);
        }
      }, parama);
      this.CTb.schedule(this.CTc, 500L);
      AppMethodBeat.o(52044);
      return;
    }
    b(paramString, parama);
    AppMethodBeat.o(52044);
  }
  
  private static boolean aMQ(String paramString)
  {
    AppMethodBeat.i(52049);
    if ((paramString.startsWith("weixin://wxpay/bizpayurl")) || (paramString.startsWith("https://wx.tenpay.com/f2f")) || (paramString.startsWith("wxp://f2f")) || (paramString.startsWith("wxhb://f2f")) || (paramString.startsWith("wxp://wbf2f")) || (paramString.startsWith("m")) || (paramString.startsWith(CTl)) || (paramString.startsWith("n")))
    {
      AppMethodBeat.o(52049);
      return true;
    }
    AppMethodBeat.o(52049);
    return false;
  }
  
  private void b(String paramString, final c.a parama)
  {
    AppMethodBeat.i(52047);
    if (this.pqa != null) {
      this.pqa.dismiss();
    }
    this.pqa = com.tencent.mm.ui.base.h.a(this.mActivity, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(52035);
        if (parama != null) {
          parama.eRN();
        }
        AppMethodBeat.o(52035);
      }
    });
    AppMethodBeat.o(52047);
  }
  
  private void b(boolean paramBoolean, Bundle paramBundle)
  {
    AppMethodBeat.i(240820);
    if (this.CTp != null)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("key_scan_qr_code_result", paramBoolean);
      this.CTp.r(3, localBundle);
    }
    AppMethodBeat.o(240820);
  }
  
  private void c(String paramString, c.a parama)
  {
    AppMethodBeat.i(52045);
    boolean bool2 = this.CIS;
    if (this.CTa == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.d("MicroMsg.QBarStringHandler", "alvinluo directShowLoading isFromScanUI: %b, loadingViewModel == null: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.CTa == null) || (!this.CIS)) {
        break;
      }
      this.CTr = true;
      this.CTa.a(true, false, parama);
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
    if (this.CTa != null) {
      this.CTa.a(false, false, null);
    }
    if ((this.pqa != null) && (this.pqa.isShowing())) {
      this.pqa.dismiss();
    }
    if (this.CTb != null) {
      this.CTb.cancel();
    }
    if (this.CTc != null) {
      this.CTc.cancel();
    }
    AppMethodBeat.o(52046);
  }
  
  private int eFd()
  {
    switch (this.CTm)
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
    com.tencent.mm.kernel.g.azz().b(106, this);
    com.tencent.mm.kernel.g.azz().b(233, this);
    com.tencent.mm.kernel.g.azz().b(666, this);
    com.tencent.mm.kernel.g.azz().b(372, this);
    com.tencent.mm.kernel.g.azz().b(3512, this);
    AppMethodBeat.o(52051);
  }
  
  public final void a(final Activity paramActivity, String paramString1, final int paramInt1, final String paramString2, final int paramInt2, int paramInt3, com.tencent.mm.plugin.scanner.f.e.a parama, com.tencent.mm.plugin.scanner.view.c paramc, Bundle paramBundle, int paramInt4, boolean paramBoolean1, int paramInt5, boolean paramBoolean2)
  {
    AppMethodBeat.i(52048);
    Log.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d, isFromScanUI: %b", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1), Integer.valueOf(com.tencent.mm.kernel.g.azz().aYS()), Boolean.valueOf(paramBoolean2) });
    this.mActivity = paramActivity;
    this.CTm = paramInt1;
    this.CTn = paramString1;
    this.dFL = paramInt2;
    this.dFM = paramInt3;
    this.typeName = paramString2;
    this.CTp = parama;
    this.CTo = paramBundle;
    this.CSX = paramBoolean1;
    this.CJz = paramInt4;
    this.CIS = paramBoolean2;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.CFK = bool;
      this.CSY = paramInt5;
      this.CTa = paramc;
      paramString2 = "";
      if (paramBundle != null) {
        paramString2 = paramBundle.getString("stat_url", "");
      }
      if (!Util.isNullOrNil(paramString1)) {
        break;
      }
      Log.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(52048);
      return;
    }
    if (com.tencent.mm.kernel.g.azz().aYS() == 0)
    {
      paramBoolean1 = NetStatusUtil.isConnected(this.mActivity);
      if (this.CTp != null)
      {
        paramString2 = null;
        if (aMQ(paramString1))
        {
          paramString2 = new Bundle();
          paramString2.putBoolean("key_offline_scan_show_tips", false);
        }
        this.CTp.r(0, paramString2);
        this.CTp.r(6, paramString2);
      }
      if (paramBoolean1)
      {
        paramInt4 = 2;
        if (this.CSX) {
          break label466;
        }
        paramString2 = b.CTi;
        if (!b.uk(paramBoolean2)) {
          break label466;
        }
        Log.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean1) });
        if (!aMQ(paramString1))
        {
          paramString2 = b.CTi;
          paramString2 = new OfflineScanContext(paramActivity, paramInt4, paramString1, paramInt1, paramInt2, paramInt3, this.typeName, this.CFK, paramBundle);
          if (!paramBoolean1) {
            break label447;
          }
          paramActivity = this.mActivity.getString(2131764957);
          label400:
          b.a(paramString2, paramActivity, false);
        }
        paramActivity = com.tencent.mm.plugin.scanner.model.q.CFL;
        paramActivity = this.typeName;
        if (!this.CFK) {
          break label461;
        }
      }
      label447:
      label461:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.q.b(paramString1, paramActivity, paramInt1, paramInt4, 0);
        AppMethodBeat.o(52048);
        return;
        paramInt4 = 1;
        break;
        paramActivity = this.mActivity.getString(2131764960);
        break label400;
      }
      label466:
      if (this.CSX)
      {
        paramString1 = b.CTi;
        if (b.uk(paramBoolean2))
        {
          paramString1 = b.CTi;
          if (paramBoolean1) {}
          for (paramString1 = this.mActivity.getString(2131764957);; paramString1 = this.mActivity.getString(2131764960))
          {
            b.k(paramActivity, paramString1);
            AppMethodBeat.o(52048);
            return;
          }
        }
      }
      Toast.makeText(paramActivity, paramActivity.getString(2131760826), 0).show();
      AppMethodBeat.o(52048);
      return;
    }
    parama = "";
    if (paramString1.startsWith("weixin://qr/")) {
      parama = paramString1.substring(12) + "@qr";
    }
    if (!Util.isNullOrNil(parama))
    {
      a(paramActivity, paramInt1, parama, false);
      AppMethodBeat.o(52048);
      return;
    }
    if (aMQ(paramString1))
    {
      Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean1)
      {
        parama = b.CTi;
        if (b.uk(paramBoolean2))
        {
          parama = com.tencent.mm.plugin.scanner.model.q.CFL;
          parama = this.typeName;
          if (!this.CFK) {
            break label947;
          }
        }
      }
    }
    label947:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      com.tencent.mm.plugin.scanner.model.q.b(paramString1, parama, paramInt1, 4, 0);
      Log.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
      if (!paramString1.startsWith("weixin://wxpay/bizpayurl")) {
        break;
      }
      Log.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramInt1 = Xa(this.CTm);
      paramInt2 = Vl(paramInt1);
      paramActivity = new ph();
      paramActivity.dVp.url = paramString1;
      paramActivity.dVp.channel = paramInt2;
      paramActivity.dVp.scene = paramInt1;
      paramActivity.dVp.context = this.mActivity;
      if (paramInt2 == 13)
      {
        Log.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.dVp.source = this.source;
        paramActivity.dVp.sourceType = this.sourceType;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(52036);
          if ((c.this.mActivity == null) || (paramActivity.dVq == null))
          {
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dVq.ret == 1)
          {
            c.this.sU(true);
            AppMethodBeat.o(52036);
            return;
          }
          if (paramActivity.dVq.ret == 2) {
            c.this.sU(false);
          }
          AppMethodBeat.o(52036);
        }
      };
      EventCenter.instance.asyncPublish(paramActivity, Looper.myLooper());
      if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(52037);
            if ((c.b(c.this) != null) && ((paramActivity.dVq == null) || (paramActivity.dVq.ret != 1))) {
              c.a(c.this, false);
            }
            AppMethodBeat.o(52037);
          }
        }, 10000L);
      }
      Xb(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(2), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      Log.d("MicroMsg.QBarStringHandler", "go to payment code");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayCode.checkAvailable(this.mActivity, new android.support.v4.e.c() {}))
      {
        AppMethodBeat.o(52048);
        return;
      }
      paramInt1 = Vl(Xa(this.CTm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      b(true, null);
      Xb(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(1), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramInt1 = Vl(Xa(this.CTm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 6, paramString1, paramInt1, null);
      b(true, null);
      Xb(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(3), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      Log.i("MicroMsg.QBarStringHandler", "go to reward");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(this.mActivity, new android.support.v4.e.c() {}))
      {
        AppMethodBeat.o(52048);
        return;
      }
      paramInt2 = Vl(Xa(this.CTm));
      paramInt1 = 1;
      if (this.pHw == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, paramString1, paramInt2, paramString2, paramInt1);
        b(true, null);
        Xb(11);
        com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(6), paramString1, paramString2 });
        AppMethodBeat.o(52048);
        return;
        if (this.pHw == 38) {
          paramInt1 = 3;
        } else if (this.pHw == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith(CTl))
    {
      Log.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramInt1 = Vl(Xa(this.CTm));
      com.tencent.mm.pluginsdk.wallet.f.a(this.mActivity, 1, paramString1, paramInt1, null);
      b(true, null);
      Xb(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(5), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      if (!WeChatBrands.Business.Entries.DiscoveryScanPayReward.checkAvailable(this.mActivity, new android.support.v4.e.c() {}))
      {
        if (this.CTp != null) {
          this.CTp.r(5, null);
        }
        AppMethodBeat.o(52048);
        return;
      }
      Log.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramInt1 = Xa(this.CTm);
      paramInt2 = Vl(paramInt1);
      paramActivity = new tk();
      paramActivity.dZQ.dZS = paramString1;
      paramActivity.dZQ.scene = paramInt1;
      paramActivity.dZQ.type = 1;
      paramActivity.dZQ.aWF = new WeakReference(this.mActivity);
      paramActivity.dZQ.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240818);
          if (!Util.isNullOrNil(paramActivity.dZR.errMsg))
          {
            if (c.this.mActivity != null) {
              Toast.makeText(c.this.mActivity, paramActivity.dZR.errMsg, 1).show();
            }
            c.a(c.this, false);
            AppMethodBeat.o(240818);
            return;
          }
          if (Util.isNullOrNil(paramActivity.dZR.dZT))
          {
            Log.w("MicroMsg.QBarStringHandler", "resp url is null!");
            c.a(c.this, false);
            AppMethodBeat.o(240818);
            return;
          }
          if (paramActivity.dZR.actionType == 1)
          {
            com.tencent.mm.pluginsdk.wallet.f.a(c.this.mActivity, paramActivity.dZR.dZT, paramInt2, paramString2, paramInt1);
            c.a(c.this, true);
            AppMethodBeat.o(240818);
            return;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramActivity.dZR.dZT);
          com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, c.this.mActivity);
          c.a(c.this, true);
          AppMethodBeat.o(240818);
        }
      };
      EventCenter.instance.publish(paramActivity);
      Xb(11);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(7), paramString1, paramString2 });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("weixin://wxpay/bindurl"))
    {
      Log.i("MicroMsg.QBarStringHandler", "fast bind card qrcode");
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramInt1 = Vl(Xa(this.CTm));
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startFastBindUseCase(paramString1, paramInt1, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240819);
          if (c.b(c.this) != null) {
            c.b(c.this).r(3, null);
          }
          AppMethodBeat.o(240819);
        }
      });
      AppMethodBeat.o(52048);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      Log.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(52048);
        return;
      }
      if (!WeChatBrands.Business.Entries.DiscoveryScanFace2Face.checkAvailable(this.mActivity, new android.support.v4.e.c() {}))
      {
        if (this.CTp != null) {
          this.CTp.r(5, null);
        }
        AppMethodBeat.o(52048);
        return;
      }
      if (this.CTp != null) {
        this.CTp.r(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.br.c.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1001);
      com.tencent.mm.plugin.report.service.h.CyF.a(16472, new Object[] { Integer.valueOf(4), paramString1, paramString2 });
      Xb(11);
      AppMethodBeat.o(52048);
      return;
    }
    paramString2 = new com.tencent.mm.plugin.scanner.c();
    paramString2.activity = paramActivity;
    paramString2.Czz = paramString1;
    paramString2.dFL = paramInt2;
    paramString2.dFM = paramInt3;
    EventCenter.instance.publish(paramString2);
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.CTp != null) {
      this.CTp.r(5, null);
    }
    AppMethodBeat.o(52048);
  }
  
  public final void eRR()
  {
    AppMethodBeat.i(52050);
    Log.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.CTn = null;
    this.mActivity = null;
    onPause();
    AppMethodBeat.o(52050);
  }
  
  public final Context getContext()
  {
    return this.mActivity;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
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
        if (this.CTp != null) {
          this.CTp.r(2, null);
        }
        AppMethodBeat.o(52054);
        return;
      }
    }
    if (!this.CTq.containsKey(paramq))
    {
      if ((paramq instanceof com.tencent.mm.aq.c)) {
        Log.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.CTq.remove(paramq);
      cancelLoading();
      if ((paramq.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label246;
      }
      paramString = new com.tencent.mm.modelsimple.l(((n)paramq).jHh, null, 50, 0, 0, new byte[0]);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
      this.CTq.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(52054);
      return;
    }
    Log.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
    AppMethodBeat.o(52054);
    return;
    label246:
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      if (this.mActivity != null) {
        com.tencent.mm.ui.base.h.a(this.mActivity, 2131764147, 2131755998, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(240811);
            if (c.b(c.this) != null) {
              c.b(c.this).r(1, null);
            }
            AppMethodBeat.o(240811);
          }
        });
      }
      AppMethodBeat.o(52054);
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
          Log.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          if (this.CTp != null) {
            this.CTp.r(7, null);
          }
          if (this.mActivity != null)
          {
            paramString = b.CTi;
            b.a(new OfflineScanContext(this.mActivity, 2, this.CTn, this.CTm, this.dFL, this.dFM, this.typeName, this.CFK, this.CTo), this.mActivity.getString(2131764957), true);
            paramString = com.tencent.mm.plugin.scanner.model.q.CFL;
            paramString = this.CTn;
            paramq = this.typeName;
            if (this.CFK) {}
            for (paramInt1 = 2;; paramInt1 = 1)
            {
              com.tencent.mm.plugin.scanner.model.q.b(paramString, paramq, paramInt1, 2, 0);
              AppMethodBeat.o(52054);
              return;
            }
          }
        }
        else if (this.mActivity != null)
        {
          paramString = b.CTi;
          b.k(this.mActivity, this.mActivity.getString(2131764955));
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
      if (this.CTp != null) {
        this.CTp.r(0, null);
      }
      AppMethodBeat.o(52054);
      return;
      if (com.tencent.mm.kernel.g.azz().aYT())
      {
        com.tencent.mm.kernel.g.azz().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (com.tencent.mm.network.ag.dm(this.mActivity)) {
          com.tencent.mm.pluginsdk.ui.tools.m.iC(this.mActivity);
        } else {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131760825, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.mActivity, this.mActivity.getString(2131760826), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      if (this.mActivity != null) {
        com.tencent.mm.ui.base.h.n(this.mActivity, 2131764139, 2131755998);
      }
      if (this.CTp != null) {
        this.CTp.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (this.mActivity != null) {
        Toast.makeText(this.mActivity, this.mActivity.getString(2131760877, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (this.CTp != null) {
        this.CTp.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    paramString = b.CTi;
    if ((b.o(paramq)) && (!this.CSX))
    {
      paramString = com.tencent.mm.plugin.scanner.model.q.CFL;
      paramString = this.CTn;
      localObject1 = this.typeName;
      if (this.CFK)
      {
        i = 2;
        com.tencent.mm.plugin.scanner.model.q.b(paramString, (String)localObject1, i, 4, 0);
      }
    }
    else
    {
      if (paramq.getType() != 106) {
        break label1998;
      }
      paramString = (com.tencent.mm.plugin.messenger.a.f)paramq;
      if (paramString.zpn) {
        break label1102;
      }
      paramString = paramString.eiq();
      if ((!as.akh(paramString.MmK)) || (paramString.MmR == null) || (Util.isNullOrNil(paramString.MmR.ken)) || (!com.tencent.mm.modelappbrand.a.Ll(paramString.MmR.ken))) {
        break label1102;
      }
      if (this.pHw <= 0) {
        break label1091;
      }
      paramInt1 = this.pHw;
      label955:
      Log.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.CTn, Integer.valueOf(this.CTm), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.l(this.CTn, null, 43, 0, 0, new byte[0]);
      this.CTq.put(paramString, Integer.valueOf(1));
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
      if (this.pqa != null) {
        this.pqa.dismiss();
      }
      a(this.mActivity.getString(2131764152), new c.a()
      {
        public final void eRN()
        {
          AppMethodBeat.i(240814);
          com.tencent.mm.kernel.g.azz().a(paramString);
          if (c.b(c.this) != null) {
            c.b(c.this).r(1, null);
          }
          AppMethodBeat.o(240814);
        }
      });
    }
    label1091:
    label1102:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label1107;
      }
      AppMethodBeat.o(52054);
      return;
      i = 1;
      break;
      paramInt1 = Xa(this.CTm);
      break label955;
    }
    label1107:
    Object localObject1 = ((com.tencent.mm.plugin.messenger.a.f)paramq).eiq();
    Object localObject2 = z.a(((drt)localObject1).Lqk);
    Log.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + ((drt)localObject1).Lqk);
    p.aYn().h((String)localObject2, z.a(((drt)localObject1).KHp));
    if ((this.pqa != null) && (this.pqa.isShowing()))
    {
      Log.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.pqa.dismiss();
    }
    cancelLoading();
    Object localObject3;
    Object localObject4;
    if (Util.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.contact.c.oR(((ax)localObject3).field_type)) && (((as)localObject3).gBM()))
      {
        paramString = com.tencent.mm.al.ag.bah().MT((String)localObject2);
        paramString.cG(false);
        localObject4 = paramString.dhv;
        if (((c.b)localObject4).dhz != null) {
          ((c.b)localObject4).dhQ = ((c.b)localObject4).dhz.optInt("ScanQRCodeType", 0);
        }
        if (((c.b)localObject4).dhQ == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (paramString.UF())) {
            break label1445;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.h.jRt.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1973;
      }
      if (this.CTp != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", z.a(((com.tencent.mm.plugin.messenger.a.f)paramq).eiq().Lqk));
        paramString.putInt("geta8key_action_code", 4);
        b(true, paramString);
      }
      Xb(4);
      AppMethodBeat.o(52054);
      return;
      paramInt1 = 0;
      break;
      label1445:
      paramInt1 = eFd();
      paramString = new Intent();
      com.tencent.mm.api.d.a(paramString, (drt)localObject1, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.contact.c.oR(((ax)localObject3).field_type))) {
        paramString.putExtra("Contact_IsLBSFriend", true);
      }
      if ((((drt)localObject1).MmK & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (as.akh(((drt)localObject1).MmK))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            paramString.putExtra("qbarScene", this.CTm);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!Util.isNullOrNil((String)localObject2))
            {
              Object localObject5 = ad.aVe().JV((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((ad.b)localObject5).getString("preUsername", null);
                localObject3 = ((ad.b)localObject5).getString("preChatName", null);
                localObject4 = ((ad.b)localObject5).getString("url", null);
                String str = ((ad.b)localObject5).getString("rawUrl", null);
                paramInt1 = ((ad.b)localObject5).getInt("Contact_Sub_Scene", 0);
                paramInt2 = ac.aJ((String)localObject2, (String)localObject3);
                localObject5 = ((ad.b)localObject5).getString("Contact_Scene_Note", null);
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
        if (this.CTm != 0) {
          break label1893;
        }
        paramString.putExtra("Contact_Sub_Scene", 7);
        label1770:
        com.tencent.mm.plugin.scanner.h.jRt.c(paramString, this.mActivity);
        paramString = "";
        if (ab.IT(this.talker)) {
          paramString = this.talker;
        }
        localObject2 = com.tencent.mm.plugin.report.service.h.CyF;
        if (!as.akh(((drt)localObject1).MmK)) {
          break label1942;
        }
      }
      label1942:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject2).a(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.sourceType), Integer.valueOf(this.CTm), this.imagePath, this.CTn, Util.nullAsNil(this.dFO), paramString });
        paramInt1 = 1;
        break;
        label1893:
        if (this.sourceType == 7)
        {
          paramString.putExtra("Contact_Sub_Scene", 4);
          break label1770;
        }
        if ((this.sourceType != 3) && (this.sourceType != 5)) {
          break label1770;
        }
        paramString.putExtra("Contact_Sub_Scene", 2);
        break label1770;
      }
      if (this.mActivity != null) {
        Toast.makeText(this.mActivity, 2131764987, 0).show();
      }
      paramInt1 = 0;
    }
    label1973:
    if (this.CTp != null) {
      this.CTp.r(1, null);
    }
    AppMethodBeat.o(52054);
    return;
    label1998:
    if (paramq.getType() == 372)
    {
      paramString = ((n)paramq).jHg;
      paramq = paramString.UserName;
      Log.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramq)));
      cancelLoading();
      if (Util.nullAsNil(paramq).length() > 0)
      {
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramq);
        paramInt1 = eFd();
        localObject1 = new Intent();
        com.tencent.mm.api.d.a((Intent)localObject1, paramString, paramInt1);
        if ((paramq != null) && (!com.tencent.mm.contact.c.oR(paramq.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.h.jRt.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.h.CyF.a(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.sourceType), Integer.valueOf(this.CTm), this.imagePath, this.CTn, Util.nullAsNil(this.dFO) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.CTp != null)
        {
          paramq = new Bundle();
          paramq.putString("geta8key_fullurl", paramString.UserName);
          paramq.putInt("geta8key_action_code", 4);
          b(true, paramq);
        }
        Xb(4);
        AppMethodBeat.o(52054);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131764987, 0).show();
        }
      }
      if (this.CTp != null) {
        this.CTp.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramq.getType() == 3512)
    {
      paramString = (atx)((com.tencent.mm.ak.d)paramq.getReqResp()).iLL.iLR;
      if (paramString.LCI.size() > 0)
      {
        paramq = new Intent();
        paramq.putExtra("finder_username", ((FinderContact)paramString.LCI.get(0)).username);
        paramq.putExtra("key_comment_scene", 10);
        paramq.putExtra("key_enter_profile_type", 3);
        paramq.putExtra("key_finder_teen_mode_check", true);
        paramq.putExtra("key_finder_teen_mode_scene", 6);
        paramq.putExtra("key_finder_teen_mode_user_name", ((FinderContact)paramString.LCI.get(0)).nickname);
        paramq.putExtra("key_finder_teen_mode_user_id", ((FinderContact)paramString.LCI.get(0)).username);
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(this.mActivity, paramq);
        b(true, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramq.getType() == 233)
    {
      paramString = ((com.tencent.mm.modelsimple.l)paramq).beQ();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.l)paramq).beS());
      Xb(((com.tencent.mm.modelsimple.l)paramq).beS());
      if (this.pHw > 0) {}
      for (paramInt1 = this.pHw;; paramInt1 = Xa(this.CTm))
      {
        Log.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.v.a.a.a(this, (com.tencent.mm.modelsimple.l)paramq, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(240812);
            if (c.b(c.this) != null) {
              c.b(c.this).r(1, null);
            }
            AppMethodBeat.o(240812);
          }
        }, this.CTn, paramInt1, this.CTm, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240813);
            c.a(c.this, true);
            AppMethodBeat.o(240813);
          }
        }, this.CTo);
        if ((bool) || (((com.tencent.mm.modelsimple.l)paramq).beS() != 4)) {
          break;
        }
        a(this.mActivity, this.CTm, paramString, true);
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramq).beS() == 29))
      {
        paramq = this.mActivity;
        Log.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new n(paramString, (byte)0);
        this.CTq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
        paramString = new c.a()
        {
          public final void eRN()
          {
            AppMethodBeat.i(240809);
            com.tencent.mm.kernel.g.azz().a(paramString);
            if (c.b(c.this) != null) {
              c.b(c.this).r(1, null);
            }
            AppMethodBeat.o(240809);
          }
        };
        if (paramq != null)
        {
          if (this.CTr)
          {
            c(paramq.getString(2131764943), paramString);
            AppMethodBeat.o(52054);
            return;
          }
          a(paramq.getString(2131764943), paramString);
        }
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramq).beS() == 37))
      {
        paramq = this.mActivity;
        Log.i("MicroMsg.QBarStringHandler", "search finder contact %s", new Object[] { paramString });
        localObject1 = new ArrayList();
        ((List)localObject1).add(paramString);
        paramString = new am((List)localObject1);
        this.CTq.put(paramString, Integer.valueOf(1));
        com.tencent.mm.kernel.g.azz().a(paramString, 0);
        paramq.getString(2131755998);
        this.pqa = com.tencent.mm.ui.base.h.b(paramq, paramq.getString(2131764943), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(240810);
            com.tencent.mm.kernel.g.azz().a(paramString);
            if (c.b(c.this) != null) {
              c.b(c.this).r(1, null);
            }
            AppMethodBeat.o(240810);
          }
        });
        AppMethodBeat.o(52054);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.l)paramq).beS() == 41))
      {
        paramq = new Intent();
        paramq.putExtra("key_qrcode_string", paramString);
        com.tencent.mm.br.c.b(this.mActivity, "account", ".friend.ui.RecoverAccountUI1", paramq);
        AppMethodBeat.o(52054);
        return;
      }
      Log.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.CTp != null)) {
        this.CTp.r(1, null);
      }
      AppMethodBeat.o(52054);
      return;
    }
    if (paramq.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.aq.c))
        {
          paramString = ((com.tencent.mm.aq.c)paramq).bbD().ProductID;
          Log.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramq = new Intent();
          paramq.putExtra("extra_id", paramString);
          paramq.putExtra("preceding_scence", 11);
          paramq.putExtra("download_entrance_scene", 14);
          com.tencent.mm.br.c.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramq);
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
  
  public final void sU(boolean paramBoolean)
  {
    AppMethodBeat.i(52056);
    if (paramBoolean)
    {
      if (this.CTp != null)
      {
        this.CTp.r(1, null);
        AppMethodBeat.o(52056);
      }
    }
    else {
      b(true, null);
    }
    AppMethodBeat.o(52056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.c
 * JD-Core Version:    0.7.0.1
 */