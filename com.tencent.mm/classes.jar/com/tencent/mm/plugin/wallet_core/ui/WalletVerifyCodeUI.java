package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.tenpay.model.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button gHb;
  private PayInfo mPayInfo;
  private String mVerifyCode;
  private Orders qrf;
  private Authen tTD;
  private int utZ;
  protected WalletFormView uua;
  private Button uub;
  private String uuc;
  private boolean uud;
  private WalletVerifyCodeUI.a uue;
  private TextView uuf;
  private TextView uug;
  private boolean uuh;
  private boolean uui;
  private k uuj;
  private n.a uuk;
  
  public WalletVerifyCodeUI()
  {
    AppMethodBeat.i(47703);
    this.utZ = 60000;
    this.uua = null;
    this.uud = false;
    this.uue = null;
    this.uuh = false;
    this.uui = true;
    this.uuj = new k();
    this.uuk = new WalletVerifyCodeUI.11(this);
    AppMethodBeat.o(47703);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(138558);
    Object localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    String str = cWa();
    if ((bo.isNullOrNil(str)) && (localObject != null))
    {
      str = ((Bankcard)localObject).field_mobile;
      getInput().putString("key_mobile", str);
    }
    for (;;)
    {
      this.uug.setText(getString(2131305550, new Object[] { str }));
      localObject = getTips(0);
      if (!bo.aa((CharSequence)localObject))
      {
        this.uuf.setText((CharSequence)localObject);
        AppMethodBeat.o(138558);
        return;
      }
      this.uuf.setText(String.format(getString(2131305691), new Object[] { str }));
      AppMethodBeat.o(138558);
      return;
    }
  }
  
  protected final String cWa()
  {
    AppMethodBeat.i(47706);
    String str = bo.bf(getInput().getString("key_mobile"), "");
    if (bo.isNullOrNil(str))
    {
      Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
      if (localBankcard != null) {
        str = localBankcard.field_mobile;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(47706);
      return str;
    }
  }
  
  protected final void cWb()
  {
    int j = 2;
    AppMethodBeat.i(47707);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.h.qsU;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD != 0))
    {
      i = 1;
      if (!this.uud) {
        break label168;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).e(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.uud = true;
      this.uub.setClickable(false);
      this.uub.setEnabled(false);
      if (this.uue != null)
      {
        this.uue.cancel();
        this.uue = null;
      }
      localObject = new WalletVerifyCodeUI.a(this, this.utZ);
      this.uue = ((WalletVerifyCodeUI.a)localObject);
      ((WalletVerifyCodeUI.a)localObject).start();
      if (!getNetController().y(new Object[] { this.mVerifyCode })) {
        break label173;
      }
      AppMethodBeat.o(47707);
      return;
      i = 2;
      break;
      label168:
      j = 1;
    }
    label173:
    if (resend(false))
    {
      AppMethodBeat.o(47707);
      return;
    }
    this.tTD = ((Authen)getInput().getParcelable("key_authen"));
    if (this.tTD == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      AppMethodBeat.o(47707);
      return;
    }
    d.cWY();
    AppMethodBeat.o(47707);
  }
  
  protected final void cWc()
  {
    AppMethodBeat.i(47709);
    Bundle localBundle = getInput();
    Object localObject = getInput().getString("key_pwd1");
    this.mVerifyCode = this.uua.getText();
    u localu = new u();
    localu.gww = ((String)localObject);
    localu.pVo = this.mPayInfo;
    localu.uld = this.mVerifyCode;
    localu.token = bo.bf(getInput().getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localu.poq = ((Bankcard)localObject).field_bankcardType;
      localu.por = ((Bankcard)localObject).field_bindSerial;
      localu.ufd = bo.bf(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localu.pVo + " mVerifyCode: " + this.mVerifyCode);
      localBundle.putString("key_verify_code", this.mVerifyCode);
      com.tencent.mm.wallet_core.a.aM(this);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().p(new Object[] { this.mVerifyCode, localu }))));
      AppMethodBeat.o(47709);
      return;
      localu.poq = getInput().getString("key_bank_type");
      if (bo.isNullOrNil(localu.poq)) {
        localu.poq = getInput().getString("key_bind_card_type", "");
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(47705);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", new Object[] { bo.dtY() });
    super.finish();
    AppMethodBeat.o(47705);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130971263;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47708);
    Object localObject1 = com.tencent.mm.wallet_core.a.aM(this);
    Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    this.uuf = ((TextView)findViewById(2131826700));
    this.uug = ((TextView)findViewById(2131829415));
    this.uua = ((WalletFormView)findViewById(2131821810));
    this.uua.setOnInputValidChangeListener(this);
    this.uub = ((Button)findViewById(2131826701));
    this.uub.setOnClickListener(new WalletVerifyCodeUI.1(this, localBankcard));
    this.gHb = ((Button)findViewById(2131821811));
    this.gHb.setOnClickListener(new WalletVerifyCodeUI.4(this));
    bJ();
    this.uub.setClickable(false);
    this.uub.setEnabled(false);
    if (this.uue != null)
    {
      this.uue.cancel();
      this.uue = null;
    }
    Object localObject2 = new WalletVerifyCodeUI.a(this, this.utZ);
    this.uue = ((WalletVerifyCodeUI.a)localObject2);
    ((WalletVerifyCodeUI.a)localObject2).start();
    TextView localTextView = (TextView)findViewById(2131826702);
    boolean bool1 = getInput().getBoolean("key_is_changing_balance_phone_num");
    boolean bool2 = getInput().getBoolean("key_need_show_switch_phone", false);
    if ((bool1) && (!bool2))
    {
      localTextView.setVisibility(8);
      localObject2 = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localObject2 == null) {
        break label553;
      }
    }
    label553:
    for (int i = ((PayInfo)localObject2).cCD;; i = 0)
    {
      if (bool2)
      {
        localTextView.setText(2131305697);
        localTextView.setOnClickListener(new WalletVerifyCodeUI.5(this, localBankcard));
      }
      for (;;)
      {
        this.uua.requestFocus();
        localObject1 = getInput().getString("key_QADNA_URL");
        if (!bo.isNullOrNil((String)localObject1)) {
          addIconOptionMenu(0, 2130840873, new WalletVerifyCodeUI.9(this, (String)localObject1));
        }
        setBackBtn(new WalletVerifyCodeUI.10(this));
        AppMethodBeat.o(47708);
        return;
        localTextView.setVisibility(0);
        break;
        if ((localObject1 == null) || (!((com.tencent.mm.wallet_core.c)localObject1).dRR()) || (i == 11) || (i == 21)) {
          break label503;
        }
        if ((!localBankcard.cTf()) && (!localBankcard.cTg()))
        {
          localTextView.setOnClickListener(new WalletVerifyCodeUI.6(this, localBankcard));
        }
        else
        {
          localObject2 = getInput().getString("key_verify_tail_wording", getString(2131305697));
          localObject1 = localObject2;
          if (bo.isNullOrNil((String)localObject2)) {
            localObject1 = getString(2131305697);
          }
          localTextView.setText((CharSequence)localObject1);
          localTextView.setOnClickListener(new WalletVerifyCodeUI.7(this, localBankcard));
        }
      }
      label503:
      if (r.ZB()) {}
      for (localObject1 = getString(2131305694);; localObject1 = getString(2131305693))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(47697);
            WalletVerifyCodeUI.e(WalletVerifyCodeUI.this);
            AppMethodBeat.o(47697);
          }
        });
        break;
      }
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(47714);
    boolean bool = getIntent().getBooleanExtra("key_need_confirm_finish", false);
    if (((this.mPayInfo != null) && (this.mPayInfo.nnQ)) || (bool))
    {
      AppMethodBeat.o(47714);
      return true;
    }
    bool = super.needConfirmFinish();
    AppMethodBeat.o(47714);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 2;
    AppMethodBeat.i(47704);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "on create");
    setMMTitle(2131305709);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    this.uuc = getInput().getString("key_bank_phone");
    this.uuj = new k(getInput());
    this.uud = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.h.qsU;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.cCD != 0))
    {
      i = 1;
      if (!this.uud) {
        break label310;
      }
    }
    for (;;)
    {
      paramBundle.e(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      d.cWY();
      d.a(this, getInput(), 4);
      if (this.uuj.cTq())
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13731, new Object[] { Integer.valueOf(5) });
        if (!bo.isNullOrNil(this.uuj.uhb.title)) {
          setMMTitle(this.uuj.uhb.title);
        }
        if (this.uuf != null) {
          this.uuf.setText(getString(2131305699));
        }
        if ((this.gHb != null) && (!bo.isNullOrNil(this.uuj.uhb.AWL))) {
          this.gHb.setText(this.uuj.uhb.AWL);
        }
      }
      this.mNetSceneMgr.addSceneEndListener(1580);
      AppMethodBeat.o(47704);
      return;
      i = 2;
      break;
      label310:
      j = 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47713);
    this.mNetSceneMgr.removeSceneEndListener(1580);
    super.onDestroy();
    AppMethodBeat.o(47713);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47712);
    if (this.uua.fE(null))
    {
      this.gHb.setEnabled(true);
      this.gHb.setClickable(true);
      AppMethodBeat.o(47712);
      return;
    }
    this.gHb.setEnabled(false);
    this.gHb.setClickable(false);
    AppMethodBeat.o(47712);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47711);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(47711);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(138557);
    super.onNewIntent(paramIntent);
    bJ();
    AppMethodBeat.o(138557);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(47715);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramm });
    if (((paramm instanceof n)) && (paramInt2 == 0))
    {
      this.uuh = true;
      com.tencent.mm.ui.base.t.makeText(this, 2131305403, 0).show();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(47715);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(138556);
    super.onResume();
    bJ();
    AppMethodBeat.o(138556);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(47710);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramm instanceof n))
    {
      if ((paramInt2 != 0) && (((n)paramm).isBlock())) {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, null, false, new WalletVerifyCodeUI.2(this));
      }
      AppMethodBeat.o(47710);
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.wallet_core.a.aM(this);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        getInput().putBoolean("intent_bind_end", true);
        com.tencent.mm.ui.base.h.bO(this, getString(2131304851));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.t)) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(d.cWZ()) });
      }
      if ((this.tTD != null) && ((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.m)))
      {
        paramm = ((com.tencent.mm.wallet_core.tenpay.model.m)paramm).getToken();
        if (!bo.isNullOrNil(paramm)) {
          getInput().putString("kreq_token", paramm);
        }
      }
      if (paramInt1 != 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
        com.tencent.mm.wallet_core.a.j(this, getInput());
        if ((paramString == null) || (!paramString.bzC().equals("PayProcess")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "finish self");
          finish();
        }
        AppMethodBeat.o(47710);
        return true;
        if (!(paramm instanceof q))
        {
          if (paramString.c(this, null))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ab(getPayReqKey(), 13));
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
          }
        }
        else {
          paramInt1 = 0;
        }
      }
      else
      {
        AppMethodBeat.o(47710);
        return false;
      }
      paramInt1 = 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */