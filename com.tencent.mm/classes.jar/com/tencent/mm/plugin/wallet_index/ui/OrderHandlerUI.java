package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayReq;
import com.tencent.mm.opensdk.modelpay.WXJointPay.JointPayResp;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(3)
public class OrderHandlerUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private PayReq BQi;
  private PayResp BQj;
  private boolean BQk;
  private String BQl;
  private boolean BQm;
  private boolean BQn;
  private boolean BQo;
  private boolean BQp;
  private boolean BQq;
  private c BQr;
  public String TAG;
  private String dac;
  private String hRO;
  private int mScene;
  private long nnD;
  private PayReq.Options options;
  private c vGu;
  private boolean wOv;
  
  public OrderHandlerUI()
  {
    AppMethodBeat.i(71868);
    this.TAG = "MicroMsg.OrderHandlerUI";
    this.BQk = false;
    this.mScene = 0;
    this.BQl = "";
    this.BQm = false;
    this.nnD = 0L;
    this.BQn = false;
    this.BQo = false;
    this.BQp = false;
    this.wOv = false;
    this.BQq = false;
    this.vGu = new c() {};
    this.BQr = new c() {};
    AppMethodBeat.o(71868);
  }
  
  private void Ys(String paramString)
  {
    AppMethodBeat.i(71880);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(2131765901);
    }
    com.tencent.mm.ui.base.h.a(this, str, null, false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71867);
        paramAnonymousDialogInterface.dismiss();
        OrderHandlerUI.this.finish();
        AppMethodBeat.o(71867);
      }
    });
    AppMethodBeat.o(71880);
  }
  
  private PayReq bIj()
  {
    AppMethodBeat.i(71871);
    if (x.l(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
    for (Object localObject = new WXJointPay.JointPayReq();; localObject = new PayReq())
    {
      ((PayReq)localObject).fromBundle(x.bf(getIntent()));
      AppMethodBeat.o(71871);
      return localObject;
    }
  }
  
  private void bs(Context paramContext, String paramString)
  {
    AppMethodBeat.i(71879);
    if (paramContext == null)
    {
      ac.e(this.TAG, "startOuterApp context == null");
      AppMethodBeat.o(71879);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ac.e(this.TAG, "startOuterApp callbackUrl is empty");
      AppMethodBeat.o(71879);
      return;
    }
    ac.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(paramString)));
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.addFlags(268435456);
    if (bs.ah(paramContext, paramString))
    {
      paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramString.aeD(), "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramString.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/wallet_index/ui/OrderHandlerUI", "startOuterApp", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(71879);
  }
  
  private void ce(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71875);
    if (this.mScene == 1)
    {
      if ((TextUtils.isEmpty(this.BQl)) && (paramBoolean))
      {
        setContentViewVisibility(0);
        Ys(paramString);
        AppMethodBeat.o(71875);
        return;
      }
      bs(this, this.BQl);
      finish();
      AppMethodBeat.o(71875);
      return;
    }
    e.a(this, this.hRO, this.BQj, this.options);
    finish();
    AppMethodBeat.o(71875);
  }
  
  private void euW()
  {
    AppMethodBeat.i(71878);
    if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).canOpenKindaCashier(this))
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71865);
          OrderHandlerUI.this.finish();
          AppMethodBeat.o(71865);
        }
      });
      AppMethodBeat.o(71878);
      return;
    }
    if (((Boolean)com.tencent.mm.pluginsdk.wallet.g.eQA().get("key_pay_offline_is_auth_doing", Boolean.FALSE)).booleanValue())
    {
      com.tencent.mm.ui.base.h.a(this, getString(2131765336), "", getString(2131756757), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71866);
          OrderHandlerUI.this.finish();
          AppMethodBeat.o(71866);
        }
      });
      AppMethodBeat.o(71878);
      return;
    }
    og localog = new og();
    localog.dqH.ret = 1;
    com.tencent.mm.sdk.b.a.GpY.l(localog);
    AppMethodBeat.o(71878);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71876);
    ac.i(this.TAG, "finish hasFinish %s %s", new Object[] { Boolean.valueOf(this.wOv), bs.eWi().toString() });
    if (this.wOv)
    {
      AppMethodBeat.o(71876);
      return;
    }
    this.wOv = true;
    super.finish();
    AppMethodBeat.o(71876);
  }
  
  public int getLayoutId()
  {
    return 2131495060;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71874);
    ac.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", new Object[] { this.BQj, Boolean.valueOf(this.BQk) });
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_pay_reslut_type", 0);
      if (paramInt1 == 1000)
      {
        ac.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", new Object[] { this.BQj, Boolean.valueOf(this.BQk), Integer.valueOf(paramInt1) });
        finish();
        AppMethodBeat.o(71874);
        return;
      }
      if (paramInt1 == 1001)
      {
        AppMethodBeat.o(71874);
        return;
      }
    }
    if ((this.BQj != null) && (!this.BQk))
    {
      ac.e(this.TAG, "onActivityResult, onPayEnd not called");
      this.BQj.errCode = -2;
      ce("", false);
    }
    AppMethodBeat.o(71874);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(71877);
    super.onConfigurationChanged(paramConfiguration);
    ac.i(this.TAG, "onConfigurationChanged");
    AppMethodBeat.o(71877);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(71869);
    super.onCreate(paramBundle);
    this.TAG = ("MicroMsg.OrderHandlerUI@" + hashCode());
    this.nnD = getIntent().getLongExtra("wallet_pay_key_check_time", -1L);
    setContentViewVisibility(8);
    ab.fAq();
    com.tencent.mm.sdk.b.a.GpY.c(this.vGu);
    com.tencent.mm.sdk.b.a.GpY.c(this.BQr);
    com.tencent.mm.wallet_core.b.fzz();
    this.BQn = com.tencent.mm.wallet_core.b.b(b.a.pRO, true);
    if ((this.BQn) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_APP_PAY_SWTICH_KEY")))
    {
      bool1 = true;
      this.BQo = bool1;
      if ((!this.BQn) || (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_H5_PAY_SWTICH_KEY"))) {
        break label197;
      }
    }
    label197:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.BQp = bool1;
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.fDB();
      AppMethodBeat.o(71869);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71872);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(397, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(2655, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(283, this);
    com.tencent.mm.sdk.b.a.GpY.d(this.vGu);
    com.tencent.mm.sdk.b.a.GpY.d(this.BQr);
    super.onDestroy();
    AppMethodBeat.o(71872);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71870);
    super.onResume();
    PayReq localPayReq = bIj();
    Object localObject1;
    String str1;
    label388:
    String str2;
    Object localObject5;
    Object localObject4;
    if ((this.BQi == null) || ((localPayReq.prepayId != null) && (!localPayReq.prepayId.equals(this.BQi.prepayId))))
    {
      this.BQi = localPayReq;
      this.mScene = getIntent().getIntExtra("key_scene", 0);
      ac.i(this.TAG, "onCreate() mScene is " + this.mScene);
      if (this.mScene == 0)
      {
        this.hRO = getIntent().getStringExtra("_mmessage_appPackage");
        if ((this.hRO == null) || (this.hRO.length() == 0))
        {
          ac.e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
          finish();
          AppMethodBeat.o(71870);
          return;
        }
      }
      this.options = new PayReq.Options();
      this.options.fromBundle(getIntent().getExtras());
      if (x.l(getIntent().getExtras(), "_wxapi_command_type") == 27) {}
      for (localObject1 = new WXJointPay.JointPayResp();; localObject1 = new PayResp())
      {
        this.BQj = ((PayResp)localObject1);
        this.BQj.prepayId = localPayReq.prepayId;
        this.BQj.extData = localPayReq.extData;
        str1 = "";
        if (this.mScene != 0) {
          break label388;
        }
        if (localPayReq.checkArgs()) {
          break;
        }
        ac.e(this.TAG, "onCreate, PayReq checkArgs fail");
        this.BQj.errCode = -1;
        this.BQj.errStr = getString(2131761837);
        e.a(this, this.hRO, this.BQj, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
      }
      if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false))
      {
        ac.e(this.TAG, "onCreate, checkAppResult fail");
        this.BQj.errCode = -1;
        e.a(this, this.hRO, this.BQj, this.options);
        finish();
        AppMethodBeat.o(71870);
        return;
        if (this.mScene == 1) {
          str1 = "WAP";
        }
      }
      str2 = getIntent().getStringExtra("_mmessage_appPackage");
      localObject5 = "";
      localObject4 = "";
      for (;;)
      {
        try
        {
          getPackageManager().getPackageInfo(str2, 0);
          localObject1 = (String)getPackageManager().getPackageInfo(str2, 0).applicationInfo.loadLabel(getPackageManager());
          Object localObject2;
          boolean bool3;
          boolean bool4;
          boolean bool5;
          ac.printErrStackTrace(this.TAG, localNameNotFoundException1, "", new Object[0]);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          try
          {
            localObject2 = com.tencent.mm.pluginsdk.model.app.q.bJ(this, str2);
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = bIj();
            ((PayReq)localObject1).fromBundle(getIntent().getExtras());
            localObject1 = ((PayReq)localObject1).prepayId;
            bool3 = ((String)localObject1).startsWith("sns_");
            bool4 = ((String)localObject1).startsWith("tax_");
            bool5 = ((String)localObject1).startsWith("seb_ff_");
            if ((!bool3) && (!bool4) && (!bool5)) {
              break label663;
            }
            bool1 = true;
            bool3 = this.BQp;
            if (bool1) {
              break label668;
            }
            bool2 = true;
            this.BQp = (bool2 & bool3);
            bool3 = this.BQo;
            if (bool1) {
              break label673;
            }
            bool1 = true;
            this.BQo = (bool1 & bool3);
            if ((this.mScene != 1) || (!this.BQp)) {
              break;
            }
            euW();
            ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayH5Pay(this, getIntent().getExtras(), str1, str2, (String)localObject2, (String)localObject4);
            AppMethodBeat.o(71870);
            return;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException2)
          {
            boolean bool1;
            boolean bool2;
            Object localObject3;
            break label641;
          }
          localNameNotFoundException1 = localNameNotFoundException1;
          localObject1 = localObject5;
        }
        label641:
        localObject3 = localObject1;
        continue;
        label663:
        bool1 = false;
        continue;
        label668:
        bool2 = false;
        continue;
        label673:
        bool1 = false;
      }
      if ((this.mScene == 0) && (this.BQo))
      {
        euW();
        ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayAppPay(this, getIntent().getExtras(), str1, str2, localObject3, (String)localObject4);
        AppMethodBeat.o(71870);
        return;
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(397, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(2655, this);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(283, this);
      localObject5 = new com.tencent.mm.plugin.wallet_index.c.g(localPayReq, str1, str2, localObject3, (String)localObject4);
      localObject1 = localObject5;
      if (!bs.isNullOrNil(localPayReq.prepayId))
      {
        if (!localPayReq.prepayId.startsWith("up_")) {
          break label875;
        }
        localObject1 = new l(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject1, 0);
      AppMethodBeat.o(71870);
      return;
      label875:
      localObject1 = localObject5;
      if (localPayReq.prepayId.startsWith("sns_")) {
        localObject1 = new i(localPayReq, str1, str2, localObject3, (String)localObject4);
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71873);
    if ((paramn.getType() != 397) && (paramn.getType() != 2655) && (paramn.getType() != 283))
    {
      AppMethodBeat.o(71873);
      return;
    }
    PayInfo localPayInfo = new PayInfo();
    if (this.mScene == 1)
    {
      localPayInfo.dqL = 36;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(paramn.getType(), this);
      ac.i(this.TAG, "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
      localObject3 = (com.tencent.mm.plugin.wallet_index.c.g)paramn;
      paramn = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
      if (paramn != null) {
        break label233;
      }
      paramn = null;
      label154:
      this.BQl = paramn;
      if ((paramInt1 != 4) || (paramInt2 != -5)) {
        break label254;
      }
      ac.e(this.TAG, "onSceneEnd, auth access denied");
      this.BQj.errCode = -1;
      ce(paramString, true);
      paramInt1 = localPayInfo.dqL;
      if (this.BQi != null) {
        break label243;
      }
    }
    label233:
    label243:
    for (paramString = "";; paramString = this.BQi.prepayId)
    {
      af.x(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(71873);
      return;
      localPayInfo.dqL = 2;
      break;
      paramn = paramn.Fsm;
      break label154;
    }
    label254:
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
      this.BQj.errCode = -1;
      ce(paramString, true);
      paramInt1 = localPayInfo.dqL;
      if (this.BQi == null) {}
      for (paramString = "";; paramString = this.BQi.prepayId)
      {
        af.x(paramInt1, paramString, paramInt2);
        AppMethodBeat.o(71873);
        return;
      }
    }
    paramn = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
    label373:
    Object localObject1;
    label397:
    Object localObject2;
    if (paramn == null)
    {
      paramInt1 = -1;
      paramn = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
      if (paramn != null) {
        break label529;
      }
      paramn = null;
      localObject1 = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
      if (localObject1 != null) {
        break label539;
      }
      localObject1 = null;
      localObject2 = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
      if (localObject2 != null) {
        break label549;
      }
      localObject2 = null;
      label421:
      localObject3 = (cdm)((com.tencent.mm.plugin.wallet_index.c.g)localObject3).rr.hvs.hvw;
      if (localObject3 != null) {
        break label559;
      }
    }
    label529:
    label539:
    label549:
    label559:
    for (Object localObject3 = null;; localObject3 = ((cdm)localObject3).EJV)
    {
      ac.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[] { Integer.valueOf(paramInt1), paramn, localObject1, localObject2 });
      if (!bs.isNullOrNil((String)localObject1)) {
        break label569;
      }
      ac.e(this.TAG, "onSceneEnd, respPrepayId is null");
      this.BQj.errCode = -1;
      ce(paramString, true);
      AppMethodBeat.o(71873);
      return;
      paramInt1 = paramn.pAG;
      break;
      paramn = paramn.pAH;
      break label373;
      localObject1 = ((cdm)localObject1).EJP;
      break label397;
      localObject2 = ((cdm)localObject2).EJQ;
      break label421;
    }
    label569:
    af.x(localPayInfo.dqL, (String)localObject1, paramInt2);
    if ((localObject3 != null) && (!bs.isNullOrNil(((dvk)localObject3).GcR)))
    {
      this.BQq = true;
      paramString = new Intent();
      paramString.putExtra("prepayId", (String)localObject1);
      paramString.putExtra("is_jsapi_offline_pay", false);
      paramString.putExtra("pay_gate_url", ((dvk)localObject3).GcR);
      paramString.putExtra("need_dialog", ((dvk)localObject3).GcT);
      paramString.putExtra("dialog_text", ((dvk)localObject3).GcU);
      paramString.putExtra("max_count", ((dvk)localObject3).GcS.EhK);
      paramString.putExtra("inteval_time", ((dvk)localObject3).GcS.EhJ);
      paramString.putExtra("default_wording", ((dvk)localObject3).GcS.EhL);
      d.c(this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
    }
    for (;;)
    {
      this.dac = ((String)localObject1);
      this.BQk = false;
      AppMethodBeat.o(71873);
      return;
      localPayInfo.appId = this.BQi.appId;
      localPayInfo.dac = ((String)localObject1);
      localPayInfo.partnerId = this.BQi.partnerId;
      localPayInfo.BPA = ((String)localObject2);
      localPayInfo.DGK = String.valueOf(paramInt1);
      localPayInfo.errMsg = paramn;
      if (this.nnD > 0L)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 1L, 1L, true);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(641L, 2L, bs.Ap(this.nnD), true);
        if (localPayInfo.hbR == null) {
          localPayInfo.hbR = new Bundle();
        }
        localPayInfo.hbR.putLong("wallet_pay_key_check_time", this.nnD);
      }
      f.a(this, localPayInfo, 123);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI
 * JD-Core Version:    0.7.0.1
 */