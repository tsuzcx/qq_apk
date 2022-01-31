package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.mk.b;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.network.ac;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.scanner.model.OfflineScanContext;
import com.tencent.mm.plugin.u.a.c.a;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.e.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  implements com.tencent.mm.ai.f, c.a
{
  public String appId;
  private int cpE;
  private int cpF;
  public int cpG;
  public String cpI;
  public String imagePath;
  private ProgressDialog jUQ;
  public int kbN;
  private Activity mActivity;
  private int qCr;
  private String qCs;
  private boolean qCt;
  private int qCu;
  private Bundle qCv;
  a qCw;
  private Map<m, Integer> qCx;
  private boolean qus;
  private int qwn;
  public String source;
  private String typeName;
  
  public f()
  {
    AppMethodBeat.i(81404);
    this.qus = false;
    this.qCu = -1;
    this.jUQ = null;
    this.qCw = null;
    this.qCx = new HashMap();
    onResume();
    AppMethodBeat.o(81404);
  }
  
  private static int CO(int paramInt)
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
  
  private void CP(int paramInt)
  {
    AppMethodBeat.i(81412);
    Object localObject2;
    if (this.qCv != null)
    {
      localObject2 = this.qCv.getString("stat_url");
      if (((this.cpG == 6) || (this.cpG == 0)) && (!bo.isNullOrNil((String)localObject2)))
      {
        localObject1 = "";
        localObject4 = "";
      }
    }
    try
    {
      localObject2 = URLEncoder.encode(bo.nullAsNil((String)localObject2), "UTF-8");
      localObject1 = localObject2;
      String str = URLEncoder.encode(bo.nullAsNil(this.qCs), "UTF-8");
      localObject1 = str;
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.QBarStringHandler", localUnsupportedEncodingException, "", new Object[0]);
        Object localObject3 = localObject4;
        localObject4 = localObject1;
      }
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(13329, new Object[] { localObject4, localObject2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(81412);
  }
  
  private static int Cd(int paramInt)
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
  
  private static boolean YJ(String paramString)
  {
    AppMethodBeat.i(151689);
    if ((paramString.startsWith("weixin://wxpay/bizpayurl")) || (paramString.startsWith("https://wx.tenpay.com/f2f")) || (paramString.startsWith("wxp://f2f")) || (paramString.startsWith("wxhb://f2f")) || (paramString.startsWith("wxp://wbf2f")) || (paramString.startsWith("m")) || (paramString.startsWith("https://payapp.weixin.qq.com/qr/")) || (paramString.startsWith("n")))
    {
      AppMethodBeat.o(151689);
      return true;
    }
    AppMethodBeat.o(151689);
    return false;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(81409);
    ab.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
    if (paramInt == 2) {}
    for (paramInt = i;; paramInt = 1)
    {
      paramString = new com.tencent.mm.plugin.messenger.a.f(paramString, paramInt, 5, paramBoolean);
      this.qCx.put(paramString, Integer.valueOf(1));
      g.Rc().a(paramString, 0);
      paramActivity.getString(2131297087);
      this.jUQ = com.tencent.mm.ui.base.h.b(paramActivity, paramActivity.getString(2131302913), new f.7(this, paramString));
      AppMethodBeat.o(81409);
      return;
    }
  }
  
  private void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(151690);
    if (this.kbN > 0) {}
    for (int i = this.kbN;; i = CO(this.qCr))
    {
      ab.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { paramString1, Integer.valueOf(this.qCr), Integer.valueOf(i) });
      com.tencent.mm.modelsimple.j localj = new com.tencent.mm.modelsimple.j(paramString1, i, paramInt1, paramInt2, paramString2, (int)System.currentTimeMillis(), new byte[0]);
      if (paramString1.startsWith("http://weixin.qq.com/r/"))
      {
        String str = paramActivity.getIntent().getStringExtra("img_gallery_session_id");
        paramInt1 = e.a.NY(this.qCr);
        localj.setSubScene(paramInt1);
        paramString1 = "";
        paramString2 = paramString1;
        if (!bo.isNullOrNil(str))
        {
          paramString2 = v.aae().oP(str);
          if (paramString2 != null) {
            paramString1 = paramString2.getString("url", null);
          }
          localj.uo(paramString1);
          paramString2 = paramString1;
        }
        ab.i("MicroMsg.QBarStringHandler", "getA8Key currentUrl:%s, qBarScene: %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
      }
      this.qCx.put(localj, Integer.valueOf(1));
      g.Rc().a(localj, 0);
      if (this.jUQ != null) {
        this.jUQ.dismiss();
      }
      paramActivity.getString(2131297087);
      this.jUQ = com.tencent.mm.ui.base.h.b(paramActivity, paramActivity.getString(2131302251), true, new f.9(this, localj));
      AppMethodBeat.o(151690);
      return;
    }
  }
  
  private int ccP()
  {
    switch (this.qCr)
    {
    case 0: 
    case 2: 
    default: 
      return 30;
    }
    return 45;
  }
  
  public final void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(151687);
    a(paramActivity, paramString, paramInt1, paramInt2, paramInt3, "", parama, paramBundle, 0, false, -1);
    AppMethodBeat.o(151687);
  }
  
  public final void a(final Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, a parama, Bundle paramBundle, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    AppMethodBeat.i(156520);
    ab.i("MicroMsg.QBarStringHandler", "dealQBarString %s, source:%d, codeType: %s, codeVersion: %s, scanEntryScene: %d, processOfflineScan: %b, networkStatus: %d", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean), Integer.valueOf(g.Rc().adt()) });
    this.mActivity = paramActivity;
    this.qCr = paramInt1;
    this.qCs = paramString1;
    this.cpE = paramInt2;
    this.cpF = paramInt3;
    this.typeName = paramString2;
    this.qCw = parama;
    this.qCv = paramBundle;
    this.qCt = paramBoolean;
    this.qwn = paramInt4;
    if (paramInt1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.qus = bool;
      this.qCu = paramInt5;
      parama = "";
      if (paramBundle != null) {
        parama = paramBundle.getString("stat_url", "");
      }
      if (!bo.isNullOrNil(paramString1)) {
        break;
      }
      ab.e("MicroMsg.QBarStringHandler", "qbarstring is null or nil");
      AppMethodBeat.o(156520);
      return;
    }
    if (g.Rc().adt() == 0)
    {
      if (this.qCw != null) {
        this.qCw.q(0, null);
      }
      paramBoolean = at.isConnected(this.mActivity);
      if (paramBoolean)
      {
        paramInt5 = 2;
        if (this.qCt) {
          break label390;
        }
        parama = c.qCh;
        if (!c.CL(paramInt4)) {
          break label390;
        }
        ab.e("MicroMsg.QBarStringHandler", "alvinluo dealQBarString network unavailable and deal with offline, isConnected: %b", new Object[] { Boolean.valueOf(paramBoolean) });
        parama = c.qCh;
        paramString1 = new OfflineScanContext(paramActivity, paramInt5, paramString1, paramInt1, paramInt2, paramInt3, paramString2, this.qus, paramBundle);
        if (!paramBoolean) {
          break label371;
        }
        paramActivity = this.mActivity.getString(2131302921);
        label330:
        c.a(paramString1, paramActivity, false);
        paramActivity = com.tencent.mm.plugin.scanner.model.j.qut;
        if (!this.qus) {
          break label385;
        }
      }
      label385:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        com.tencent.mm.plugin.scanner.model.j.l(paramString2, paramInt1, paramInt5, 0);
        AppMethodBeat.o(156520);
        return;
        paramInt5 = 1;
        break;
        label371:
        paramActivity = this.mActivity.getString(2131302922);
        break label330;
      }
      label390:
      if (this.qCt)
      {
        paramString1 = c.qCh;
        if (c.CL(paramInt4))
        {
          paramString1 = c.qCh;
          if (paramBoolean) {}
          for (paramString1 = this.mActivity.getString(2131302921);; paramString1 = this.mActivity.getString(2131302922))
          {
            c.a(paramActivity, paramString1, null);
            AppMethodBeat.o(156520);
            return;
          }
        }
      }
      Toast.makeText(paramActivity, paramActivity.getString(2131300044), 0).show();
      AppMethodBeat.o(156520);
      return;
    }
    paramBundle = "";
    if (paramString1.startsWith("weixin://qr/")) {
      paramBundle = paramString1.substring(12) + "@qr";
    }
    if (!bo.isNullOrNil(paramBundle))
    {
      a(paramActivity, paramInt1, paramBundle, false);
      AppMethodBeat.o(156520);
      return;
    }
    if (YJ(paramString1))
    {
      ab.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString isPayCode and report");
      if (!paramBoolean)
      {
        paramBundle = com.tencent.mm.plugin.scanner.model.j.qut;
        if (!this.qus) {
          break label877;
        }
        paramInt1 = 2;
        com.tencent.mm.plugin.scanner.model.j.l(paramString2, paramInt1, 4, 0);
      }
    }
    ab.d("MicroMsg.QBarStringHandler", "qbarString: %s, auth native: %s, remittance: %s", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (paramString1.startsWith("weixin://wxpay/bizpayurl"))
    {
      ab.i("MicroMsg.QBarStringHandler", "do native pay");
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt1 = CO(this.qCr);
      paramInt2 = Cd(paramInt1);
      paramActivity = new mk();
      paramActivity.cCw.url = paramString1;
      paramActivity.cCw.cCy = paramInt2;
      paramActivity.cCw.scene = paramInt1;
      paramActivity.cCw.context = this.mActivity;
      if (paramInt2 == 13)
      {
        ab.d("MicroMsg.QBarStringHandler", "add source and sourceType");
        paramActivity.cCw.source = this.source;
        paramActivity.cCw.cpG = this.cpG;
      }
      paramActivity.callback = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(81393);
          if ((f.this.getContext() == null) || (paramActivity.cCx == null))
          {
            AppMethodBeat.o(81393);
            return;
          }
          if (paramActivity.cCx.ret == 1)
          {
            f.this.kn(true);
            AppMethodBeat.o(81393);
            return;
          }
          if (paramActivity.cCx.ret == 2) {
            f.this.kn(false);
          }
          AppMethodBeat.o(81393);
        }
      };
      com.tencent.mm.sdk.b.a.ymk.a(paramActivity, Looper.myLooper());
      if ((((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).TenPaySDKABTestKindaEnable()) && (((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_NATIVE_PAY_SWTICH_KEY"))) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          new ak(Looper.getMainLooper()).postDelayed(new f.4(this, paramActivity), 10000L);
        }
        CP(11);
        com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(2), paramString1, parama });
        AppMethodBeat.o(156520);
        return;
        label877:
        paramInt1 = 1;
        break;
      }
    }
    if ((paramString1.startsWith("https://wx.tenpay.com/f2f")) || (paramString1.startsWith("wxp://f2f")))
    {
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt1 = Cd(CO(this.qCr));
      com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 1, paramString1, paramInt1, null);
      if (this.qCw != null) {
        this.qCw.q(3, null);
      }
      CP(11);
      com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(1), paramString1, parama });
      AppMethodBeat.o(156520);
      return;
    }
    if (paramString1.startsWith("wxp://wbf2f"))
    {
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt1 = Cd(CO(this.qCr));
      com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, 6, paramString1, paramInt1, null);
      if (this.qCw != null) {
        this.qCw.q(3, null);
      }
      CP(11);
      com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(3), paramString1, parama });
      AppMethodBeat.o(156520);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("m")))
    {
      ab.d("MicroMsg.QBarStringHandler", "go to reward");
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt2 = Cd(CO(this.qCr));
      paramInt1 = 1;
      if (this.kbN == 37) {
        paramInt1 = 2;
      }
      for (;;)
      {
        com.tencent.mm.pluginsdk.wallet.h.a(this.mActivity, paramString1, paramInt2, parama, paramInt1);
        if (this.qCw != null) {
          this.qCw.q(3, null);
        }
        CP(11);
        com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(6), paramString1, parama });
        AppMethodBeat.o(156520);
        return;
        if (this.kbN == 38) {
          paramInt1 = 3;
        } else if (this.kbN == 40) {
          paramInt1 = 4;
        }
      }
    }
    if (paramString1.startsWith("https://payapp.weixin.qq.com/qr/"))
    {
      ab.d("MicroMsg.QBarStringHandler", "f2f pay material");
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt1 = CO(this.qCr);
      paramInt2 = Cd(paramInt1);
      paramActivity = new pz();
      paramActivity.cGy.cGA = paramString1;
      paramActivity.cGy.scene = paramInt1;
      paramActivity.cGy.type = 0;
      paramActivity.cGy.aqU = new WeakReference(this.mActivity);
      paramActivity.cGy.callback = new f.5(this, paramActivity, paramInt2);
      com.tencent.mm.sdk.b.a.ymk.l(paramActivity);
      CP(11);
      com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(5), paramString1, parama });
      AppMethodBeat.o(156520);
      return;
    }
    if ((paramInt2 == 22) && (paramString1.startsWith("n")))
    {
      ab.d("MicroMsg.QBarStringHandler", "qr reward pay material");
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramInt1 = CO(this.qCr);
      paramInt2 = Cd(paramInt1);
      paramActivity = new pz();
      paramActivity.cGy.cGA = paramString1;
      paramActivity.cGy.scene = paramInt1;
      paramActivity.cGy.type = 1;
      paramActivity.cGy.aqU = new WeakReference(this.mActivity);
      paramActivity.cGy.callback = new f.6(this, paramActivity, paramInt2, parama, paramInt1);
      com.tencent.mm.sdk.b.a.ymk.l(paramActivity);
      CP(11);
      com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(7), paramString1, parama });
      AppMethodBeat.o(156520);
      return;
    }
    if (paramString1.startsWith("wxhb://f2f"))
    {
      ab.i("MicroMsg.QBarStringHandler", "scan f2f hb url");
      if (paramInt2 != 19)
      {
        AppMethodBeat.o(156520);
        return;
      }
      if (this.qCw != null) {
        this.qCw.q(5, null);
      }
      paramActivity = new Intent();
      paramActivity.putExtra("key_share_url", paramString1);
      com.tencent.mm.bq.d.b(this.mActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FReceiveUI", paramActivity, 1);
      com.tencent.mm.plugin.report.service.h.qsU.e(16472, new Object[] { Integer.valueOf(4), paramString1, parama });
      CP(11);
      AppMethodBeat.o(156520);
      return;
    }
    a(paramActivity, paramString1, paramInt2, paramInt3, this.appId);
    if (this.qCw != null) {
      this.qCw.q(5, null);
    }
    AppMethodBeat.o(156520);
  }
  
  public final void cjt()
  {
    AppMethodBeat.i(81406);
    ab.i("MicroMsg.QBarStringHandler", "cancel Deal");
    this.qCs = null;
    this.mActivity = null;
    onPause();
    AppMethodBeat.o(81406);
  }
  
  public final Context getContext()
  {
    return this.mActivity;
  }
  
  public final void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(81413);
    if (paramBoolean)
    {
      if (this.qCw != null)
      {
        this.qCw.q(1, null);
        AppMethodBeat.o(81413);
      }
    }
    else if (this.qCw != null) {
      this.qCw.q(3, null);
    }
    AppMethodBeat.o(81413);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(81408);
    ab.i("MicroMsg.QBarStringHandler", "onPause");
    g.Rc().b(106, this);
    g.Rc().b(233, this);
    g.Rc().b(666, this);
    g.Rc().b(372, this);
    AppMethodBeat.o(81408);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(81407);
    ab.i("MicroMsg.QBarStringHandler", "onResume");
    g.Rc().a(106, this);
    g.Rc().a(233, this);
    g.Rc().a(666, this);
    g.Rc().a(372, this);
    AppMethodBeat.o(81407);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    AppMethodBeat.i(81411);
    ab.i("MicroMsg.QBarStringHandler", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    boolean bool;
    if (paramm == null)
    {
      if (paramm == null) {}
      for (bool = true;; bool = false)
      {
        ab.e("MicroMsg.QBarStringHandler", "onSceneEnd() scene is null [%s]", new Object[] { Boolean.valueOf(bool) });
        if (this.qCw != null) {
          this.qCw.q(2, null);
        }
        AppMethodBeat.o(81411);
        return;
      }
    }
    if (!this.qCx.containsKey(paramm))
    {
      if ((paramm instanceof com.tencent.mm.ao.c)) {
        ab.e("MicroMsg.QBarStringHandler", "emotion scan scene");
      }
    }
    else
    {
      this.qCx.remove(paramm);
      if (this.jUQ != null)
      {
        this.jUQ.dismiss();
        this.jUQ = null;
      }
      if ((paramm.getType() != 372) || (paramInt1 != 4) || (paramInt2 != -2034)) {
        break label261;
      }
      paramString = new com.tencent.mm.modelsimple.j(((com.tencent.mm.openim.b.n)paramm).gfT, null, 50, 0, 0, new byte[0]);
      g.RM();
      g.RK().eHt.a(paramString, 0);
      this.qCx.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(81411);
      return;
    }
    ab.e("MicroMsg.QBarStringHandler", "not my scene, don't care it");
    AppMethodBeat.o(81411);
    return;
    label261:
    if ((paramInt1 == 4) && (paramInt2 == -4))
    {
      com.tencent.mm.ui.base.h.a(this.mActivity, 2131302246, 2131297087, new f.10(this));
      AppMethodBeat.o(81411);
      return;
    }
    paramString = c.qCh;
    if (c.CL(this.qwn))
    {
      paramString = c.qCh;
      if (c.b(paramInt1, paramm))
      {
        if (!this.qCt)
        {
          ab.i("MicroMsg.QBarStringHandler", "alvinluo dealQBarString onSceneEnd overtime and deal with offline");
          paramString = c.qCh;
          c.a(new OfflineScanContext(this.mActivity, 2, this.qCs, this.qCr, this.cpE, this.cpF, this.typeName, this.qus, this.qCv), this.mActivity.getString(2131302921), true);
          paramString = com.tencent.mm.plugin.scanner.model.j.qut;
          paramString = this.typeName;
          if (this.qus) {}
          for (paramInt1 = 2;; paramInt1 = 1)
          {
            com.tencent.mm.plugin.scanner.model.j.l(paramString, paramInt1, 2, 0);
            AppMethodBeat.o(81411);
            return;
          }
        }
        paramString = c.qCh;
        c.a(this.mActivity, this.mActivity.getString(2131302920), null);
        AppMethodBeat.o(81411);
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
      if (this.qCw != null) {
        this.qCw.q(1, null);
      }
      AppMethodBeat.o(81411);
      return;
      if (g.Rc().adu())
      {
        g.Rc().getNetworkServerIp();
        new StringBuilder().append(paramInt2);
      }
      for (;;)
      {
        i = 1;
        break;
        if (ac.cm(this.mActivity)) {
          com.tencent.mm.pluginsdk.ui.tools.h.fY(this.mActivity);
        } else {
          Toast.makeText(this.mActivity, this.mActivity.getString(2131300043, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 1).show();
        }
      }
      Toast.makeText(this.mActivity, this.mActivity.getString(2131300044), 1).show();
      i = 1;
    }
    if ((paramInt1 == 4) && (paramInt2 == -2004))
    {
      com.tencent.mm.ui.base.h.h(this.mActivity, 2131302239, 2131297087);
      if (this.qCw != null) {
        this.qCw.q(1, null);
      }
      AppMethodBeat.o(81411);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131300093, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      if (this.qCw != null) {
        this.qCw.q(1, null);
      }
      AppMethodBeat.o(81411);
      return;
    }
    paramString = c.qCh;
    label896:
    Object localObject1;
    if ((c.n(paramm)) && (!this.qCt))
    {
      paramString = com.tencent.mm.plugin.scanner.model.j.qut;
      paramString = this.typeName;
      if (this.qus)
      {
        i = 2;
        com.tencent.mm.plugin.scanner.model.j.l(paramString, i, 4, 0);
      }
    }
    else
    {
      if (paramm.getType() != 106) {
        break label1837;
      }
      paramString = (com.tencent.mm.plugin.messenger.a.f)paramm;
      if (paramString.oCW) {
        break label1064;
      }
      paramString = paramString.bPI();
      if ((!ad.Nt(paramString.xpe)) || (paramString.xpl == null) || (bo.isNullOrNil(paramString.xpl.gxe)) || (!com.tencent.mm.modelappbrand.a.qe(paramString.xpl.gxe))) {
        break label1064;
      }
      if (this.kbN <= 0) {
        break label1053;
      }
      paramInt1 = this.kbN;
      ab.i("MicroMsg.QBarStringHandler", "getA8Key text:%s, mQBarStringSource: %s, sceneValue: %s", new Object[] { this.qCs, Integer.valueOf(this.qCr), Integer.valueOf(paramInt1) });
      paramString = new com.tencent.mm.modelsimple.j(this.qCs, null, 43, 0, 0, new byte[0]);
      this.qCx.put(paramString, Integer.valueOf(1));
      g.Rc().a(paramString, 0);
      if (this.jUQ != null) {
        this.jUQ.dismiss();
      }
      localObject1 = this.mActivity;
      this.mActivity.getString(2131297087);
      this.jUQ = com.tencent.mm.ui.base.h.b((Context)localObject1, this.mActivity.getString(2131302251), true, new f.3(this, paramString));
    }
    label1053:
    label1064:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label1069;
      }
      AppMethodBeat.o(81411);
      return;
      i = 1;
      break;
      paramInt1 = CO(this.qCr);
      break label896;
    }
    label1069:
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
    Object localObject2 = aa.a(paramString.wOT);
    ab.d("MicroMsg.QBarStringHandler", "handle search contact result, username:" + paramString.wOT);
    o.acQ().n((String)localObject2, aa.a(paramString.woT));
    if ((this.jUQ != null) && (this.jUQ.isShowing()))
    {
      ab.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
      this.jUQ.dismiss();
    }
    Object localObject3;
    Object localObject4;
    if (bo.nullAsNil((String)localObject2).length() > 0)
    {
      localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw((String)localObject2);
      if ((localObject3 != null) && (com.tencent.mm.n.a.je(((aq)localObject3).field_type)) && (((ad)localObject3).dwz()))
      {
        localObject1 = z.afi().rK((String)localObject2);
        ((com.tencent.mm.aj.d)localObject1).cU(false);
        localObject4 = ((com.tencent.mm.aj.d)localObject1).fuY;
        if (((d.b)localObject4).fvc != null) {
          ((d.b)localObject4).fvs = ((d.b)localObject4).fvc.optInt("ScanQRCodeType", 0);
        }
        if (((d.b)localObject4).fvs == 1)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || (((com.tencent.mm.aj.d)localObject1).aeg())) {
            break label1408;
          }
          paramString = new Intent();
          paramString.putExtra("Chat_User", (String)localObject2);
          paramString.putExtra("finish_direct", true);
          com.tencent.mm.plugin.scanner.c.gmO.d(paramString, this.mActivity);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label1812;
      }
      if (this.qCw != null)
      {
        paramString = new Bundle();
        paramString.putString("geta8key_fullurl", aa.a(((com.tencent.mm.plugin.messenger.a.f)paramm).bPI().wOT));
        paramString.putInt("geta8key_action_code", 4);
        this.qCw.q(3, paramString);
      }
      CP(4);
      AppMethodBeat.o(81411);
      return;
      paramInt1 = 0;
      break;
      label1408:
      paramInt1 = ccP();
      localObject1 = new Intent();
      com.tencent.mm.api.b.a((Intent)localObject1, paramString, paramInt1);
      if ((localObject3 != null) && (!com.tencent.mm.n.a.je(((aq)localObject3).field_type))) {
        ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
      }
      if ((paramString.xpe & 0x8) > 0) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, (String)localObject2 + "," + paramInt1);
      }
      if (this.mActivity != null)
      {
        if (ad.Nt(paramString.xpe))
        {
          localObject2 = this.mActivity;
          if (localObject2 != null)
          {
            ((Intent)localObject1).putExtra("qbarScene", this.qCr);
            localObject2 = ((Activity)localObject2).getIntent().getStringExtra("img_gallery_session_id");
            if (!bo.isNullOrNil((String)localObject2))
            {
              Object localObject5 = v.aae().oP((String)localObject2);
              if (localObject5 != null)
              {
                localObject2 = ((v.b)localObject5).getString("preUsername", null);
                localObject3 = ((v.b)localObject5).getString("preChatName", null);
                localObject4 = ((v.b)localObject5).getString("url", null);
                localObject5 = ((v.b)localObject5).getString("rawUrl", null);
                paramInt1 = u.ah((String)localObject2, (String)localObject3);
                ((Intent)localObject1).putExtra("preUsername", (String)localObject2);
                ((Intent)localObject1).putExtra("preChatName", (String)localObject3);
                ((Intent)localObject1).putExtra("url", (String)localObject4);
                ((Intent)localObject1).putExtra("rawUrl", (String)localObject5);
                ((Intent)localObject1).putExtra("preChatTYPE", paramInt1);
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.c.gmO.c((Intent)localObject1, this.mActivity);
        localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
        if (!ad.Nt(paramString.xpe)) {
          break label1781;
        }
      }
      label1781:
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(14268, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.cpG), Integer.valueOf(this.qCr), this.imagePath, this.qCs, bo.nullAsNil(this.cpI) });
        paramInt1 = 1;
        break;
      }
      if (this.mActivity != null) {
        Toast.makeText(this.mActivity, 2131302940, 0).show();
      }
      paramInt1 = 0;
    }
    label1812:
    if (this.qCw != null) {
      this.qCw.q(1, null);
    }
    AppMethodBeat.o(81411);
    return;
    label1837:
    if (paramm.getType() == 372)
    {
      paramString = ((com.tencent.mm.openim.b.n)paramm).gfS;
      paramm = paramString.jJA;
      ab.d("MicroMsg.QBarStringHandler", "handle search openim contact result, username:".concat(String.valueOf(paramm)));
      if ((this.jUQ != null) && (this.jUQ.isShowing()))
      {
        ab.d("MicroMsg.QBarStringHandler", "tip dialog dismiss");
        this.jUQ.dismiss();
      }
      if (bo.nullAsNil(paramm).length() > 0)
      {
        paramm = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramm);
        paramInt1 = ccP();
        localObject1 = new Intent();
        com.tencent.mm.api.b.a((Intent)localObject1, paramString, paramInt1);
        if ((paramm != null) && (!com.tencent.mm.n.a.je(paramm.field_type))) {
          ((Intent)localObject1).putExtra("Contact_IsLBSFriend", true);
        }
        if (this.mActivity != null)
        {
          com.tencent.mm.plugin.scanner.c.gmO.c((Intent)localObject1, this.mActivity);
          com.tencent.mm.plugin.report.service.h.qsU.e(14268, new Object[] { Integer.valueOf(2), Integer.valueOf(this.cpG), Integer.valueOf(this.qCr), this.imagePath, this.qCs, bo.nullAsNil(this.cpI) });
        }
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        if (this.qCw != null)
        {
          paramm = new Bundle();
          paramm.putString("geta8key_fullurl", paramString.jJA);
          paramm.putInt("geta8key_action_code", 4);
          this.qCw.q(3, paramm);
        }
        CP(4);
        AppMethodBeat.o(81411);
        return;
        if (this.mActivity != null) {
          Toast.makeText(this.mActivity, 2131302940, 0).show();
        }
      }
      if (this.qCw != null) {
        this.qCw.q(1, null);
      }
      AppMethodBeat.o(81411);
      return;
    }
    if (paramm.getType() == 233)
    {
      paramString = ((com.tencent.mm.modelsimple.j)paramm).ajl();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("geta8key_fullurl", paramString);
      ((Bundle)localObject1).putInt("geta8key_action_code", ((com.tencent.mm.modelsimple.j)paramm).ajn());
      if (this.qCw != null) {
        this.qCw.q(4, (Bundle)localObject1);
      }
      CP(((com.tencent.mm.modelsimple.j)paramm).ajn());
      if (this.kbN > 0) {}
      for (paramInt1 = this.kbN;; paramInt1 = CO(this.qCr))
      {
        ab.i("MicroMsg.QBarStringHandler", "handleGetA8KeyRedirect, sceneValue: %s", new Object[] { Integer.valueOf(paramInt1) });
        bool = com.tencent.mm.plugin.u.a.c.a(this, (com.tencent.mm.modelsimple.j)paramm, new f.11(this), this.qCs, paramInt1, this.qCr, new f.2(this), this.qCv);
        if ((bool) || (((com.tencent.mm.modelsimple.j)paramm).ajn() != 4)) {
          break;
        }
        a(this.mActivity, this.qCr, paramString, true);
        AppMethodBeat.o(81411);
        return;
      }
      if ((!bool) && (((com.tencent.mm.modelsimple.j)paramm).ajn() == 29))
      {
        paramm = this.mActivity;
        ab.i("MicroMsg.QBarStringHandler", "start search contact %s", new Object[] { paramString });
        paramString = new com.tencent.mm.openim.b.n(paramString, (byte)0);
        this.qCx.put(paramString, Integer.valueOf(1));
        g.Rc().a(paramString, 0);
        paramm.getString(2131297087);
        this.jUQ = com.tencent.mm.ui.base.h.b(paramm, paramm.getString(2131302913), new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(81400);
            g.Rc().a(paramString);
            if (f.this.qCw != null) {
              f.this.qCw.q(1, null);
            }
            AppMethodBeat.o(81400);
          }
        });
        AppMethodBeat.o(81411);
        return;
      }
      ab.i("MicroMsg.QBarStringHandler", "scene geta8key, redirect result = [%s]", new Object[] { Boolean.valueOf(bool) });
      if ((!bool) && (this.qCw != null)) {
        this.qCw.q(1, null);
      }
      AppMethodBeat.o(81411);
      return;
    }
    if (paramm.getType() == 666) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramm instanceof com.tencent.mm.ao.c))
        {
          paramString = ((com.tencent.mm.ao.c)paramm).agu().ProductID;
          ab.d("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji productId:%s", new Object[] { paramString });
          paramm = new Intent();
          paramm.putExtra("extra_id", paramString);
          paramm.putExtra("preceding_scence", 11);
          paramm.putExtra("download_entrance_scene", 14);
          com.tencent.mm.bq.d.b(this.mActivity, "emoji", ".ui.EmojiStoreDetailUI", paramm);
          ab.i("MicroMsg.QBarStringHandler", "[oneliang]NetSceneScanEmoji onSceneEnd.");
          if (this.qCw != null) {
            this.qCw.q(3, null);
          }
          AppMethodBeat.o(81411);
        }
      }
      else {
        ab.i("MicroMsg.QBarStringHandler", "jump emotion detail failed.");
      }
    }
    AppMethodBeat.o(81411);
  }
  
  public static abstract interface a
  {
    public abstract void q(int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */