package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.tenpay.model.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private int BJn;
  protected WalletFormView BJo;
  private Button BJp;
  private String BJq;
  private boolean BJr;
  private a BJs;
  private TextView BJt;
  private TextView BJu;
  private boolean BJv;
  private boolean BJw;
  private com.tencent.mm.plugin.wallet_core.model.i BJx;
  private p.a BJy;
  private Authen Bgj;
  private Button fwU;
  private PayInfo mPayInfo;
  private String mVerifyCode;
  private Orders wSu;
  
  public WalletVerifyCodeUI()
  {
    AppMethodBeat.i(71271);
    this.BJn = 60000;
    this.BJo = null;
    this.BJr = false;
    this.BJs = null;
    this.BJv = false;
    this.BJw = true;
    this.BJx = new com.tencent.mm.plugin.wallet_core.model.i();
    this.BJy = new p.a()
    {
      public final void etT()
      {
        AppMethodBeat.i(71268);
        WalletVerifyCodeUI.this.etS();
        AppMethodBeat.o(71268);
      }
    };
    AppMethodBeat.o(71271);
  }
  
  private void cL()
  {
    AppMethodBeat.i(71279);
    Object localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    String str = etQ();
    if ((bs.isNullOrNil(str)) && (localObject != null))
    {
      str = ((Bankcard)localObject).field_mobile;
      getInput().putString("key_mobile", str);
    }
    for (;;)
    {
      this.BJu.setText(getString(2131765765, new Object[] { str }));
      localObject = getTips(0);
      if (!bs.aj((CharSequence)localObject))
      {
        this.BJt.setText((CharSequence)localObject);
        AppMethodBeat.o(71279);
        return;
      }
      this.BJt.setText(String.format(getString(2131765910), new Object[] { str }));
      AppMethodBeat.o(71279);
      return;
    }
  }
  
  protected final String etQ()
  {
    AppMethodBeat.i(71274);
    String str = bs.bG(getInput().getString("key_mobile"), "");
    if (bs.isNullOrNil(str))
    {
      Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
      if (localBankcard != null) {
        str = localBankcard.field_mobile;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(71274);
      return str;
    }
  }
  
  protected final void etR()
  {
    int j = 2;
    AppMethodBeat.i(71275);
    ac.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dqL != 0))
    {
      i = 1;
      if (!this.BJr) {
        break label168;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.BJr = true;
      this.BJp.setClickable(false);
      this.BJp.setEnabled(false);
      if (this.BJs != null)
      {
        this.BJs.cancel();
        this.BJs = null;
      }
      localObject = new a(this.BJn);
      this.BJs = ((a)localObject);
      ((a)localObject).start();
      if (!getNetController().A(new Object[] { this.mVerifyCode })) {
        break label173;
      }
      AppMethodBeat.o(71275);
      return;
      i = 2;
      break;
      label168:
      j = 1;
    }
    label173:
    if (resend(false))
    {
      AppMethodBeat.o(71275);
      return;
    }
    this.Bgj = ((Authen)getInput().getParcelable("key_authen"));
    if (this.Bgj == null)
    {
      ac.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      AppMethodBeat.o(71275);
      return;
    }
    f.euN();
    AppMethodBeat.o(71275);
  }
  
  protected final void etS()
  {
    AppMethodBeat.i(71280);
    Bundle localBundle = getInput();
    Object localObject = getInput().getString("key_pwd1");
    this.mVerifyCode = this.BJo.getText();
    com.tencent.mm.plugin.wallet_core.model.u localu = new com.tencent.mm.plugin.wallet_core.model.u();
    localu.iJA = ((String)localObject);
    localu.wfX = this.mPayInfo;
    localu.BzM = this.mVerifyCode;
    localu.token = bs.bG(getInput().getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localu.cZz = ((Bankcard)localObject).field_bankcardType;
      localu.vwo = ((Bankcard)localObject).field_bindSerial;
      localu.BtG = bs.bG(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      localObject = localBundle.getString("key_bind_card_user_token", null);
      if (!bs.isNullOrNil((String)localObject))
      {
        localu.BtQ = 1;
        localu.Bpa = ((String)localObject);
      }
      ac.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localu.wfX + " mVerifyCode: " + this.mVerifyCode);
      localBundle.putString("key_verify_code", this.mVerifyCode);
      com.tencent.mm.wallet_core.a.br(this);
      ac.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().s(new Object[] { this.mVerifyCode, localu }))));
      AppMethodBeat.o(71280);
      return;
      localu.cZz = getInput().getString("key_bank_type");
      if (bs.isNullOrNil(localu.cZz)) {
        localu.cZz = getInput().getString("key_bind_card_type", "");
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(71273);
    ac.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", new Object[] { bs.eWi() });
    super.finish();
    AppMethodBeat.o(71273);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131496040;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71276);
    Object localObject1 = com.tencent.mm.wallet_core.a.br(this);
    final Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    this.BJt = ((TextView)findViewById(2131297268));
    this.BJu = ((TextView)findViewById(2131297269));
    this.BJo = ((WalletFormView)findViewById(2131297252));
    this.BJo.setOnInputValidChangeListener(this);
    this.BJp = ((Button)findViewById(2131300583));
    this.BJp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71259);
        paramAnonymousView = WalletVerifyCodeUI.this.getProcess();
        final int i;
        if ((WalletVerifyCodeUI.a(WalletVerifyCodeUI.this)) && (paramAnonymousView != null) && ("PayProcess".equals(paramAnonymousView.cHN())))
        {
          if (localBankcard == null) {
            break label230;
          }
          if (localBankcard.eqR()) {
            i = 1;
          }
        }
        for (;;)
        {
          paramAnonymousView = new d.a(WalletVerifyCodeUI.this.getContext());
          paramAnonymousView.acF(2131765909);
          paramAnonymousView.aRI(WalletVerifyCodeUI.this.getString(2131765908, new Object[] { WalletVerifyCodeUI.this.etQ() }));
          paramAnonymousView.yf(true);
          paramAnonymousView.acM(2131765907);
          paramAnonymousView.acN(2131765906);
          paramAnonymousView.b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71257);
              WalletVerifyCodeUI.this.etR();
              com.tencent.mm.plugin.report.service.h.wUl.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
              AppMethodBeat.o(71257);
            }
          });
          paramAnonymousView.c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71258);
              paramAnonymous2DialogInterface = WalletVerifyCodeUI.this.getInput();
              paramAnonymous2DialogInterface.putInt("key_err_code", 417);
              paramAnonymous2DialogInterface.putBoolean("key_need_show_switch_phone", true);
              if ((WalletVerifyCodeUI.1.this.AYd == null) || (WalletVerifyCodeUI.1.this.AYd.eqR())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymous2DialogInterface.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                com.tencent.mm.plugin.report.service.h.wUl.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i) });
                AppMethodBeat.o(71258);
                return;
              }
            }
          });
          paramAnonymousView.fvp().show();
          com.tencent.mm.plugin.report.service.h.wUl.f(15443, new Object[] { Integer.valueOf(1) });
          WalletVerifyCodeUI.b(WalletVerifyCodeUI.this);
          AppMethodBeat.o(71259);
          return;
          if (localBankcard.eqS())
          {
            i = 3;
          }
          else
          {
            i = 2;
            continue;
            WalletVerifyCodeUI.this.etR();
            AppMethodBeat.o(71259);
            return;
            label230:
            i = 0;
          }
        }
      }
    });
    this.fwU = ((Button)findViewById(2131297249));
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71260);
        WalletVerifyCodeUI.this.hideVKB();
        if (WalletVerifyCodeUI.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.c(WalletVerifyCodeUI.this)))
        {
          AppMethodBeat.o(71260);
          return;
        }
        WalletVerifyCodeUI.this.etS();
        AppMethodBeat.o(71260);
      }
    });
    cL();
    this.BJp.setClickable(false);
    this.BJp.setEnabled(false);
    if (this.BJs != null)
    {
      this.BJs.cancel();
      this.BJs = null;
    }
    Object localObject2 = new a(this.BJn);
    this.BJs = ((a)localObject2);
    ((a)localObject2).start();
    TextView localTextView = (TextView)findViewById(2131297267);
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
    for (int i = ((PayInfo)localObject2).dqL;; i = 0)
    {
      if (bool2)
      {
        localTextView.setText(2131765916);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            boolean bool2 = true;
            AppMethodBeat.i(71261);
            ac.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
            ac.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
            paramAnonymousView = WalletVerifyCodeUI.this.getInput();
            paramAnonymousView.putInt("key_err_code", 417);
            paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
            WalletVerifyCodeUI.this.getInput().putBoolean("key_block_bind_new_card", true);
            boolean bool1 = bool2;
            if (localBankcard != null) {
              if (!localBankcard.eqR()) {
                break label107;
              }
            }
            label107:
            for (bool1 = bool2;; bool1 = false)
            {
              paramAnonymousView.putBoolean("key_isbalance", bool1);
              com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymousView);
              WalletVerifyCodeUI.this.finish();
              AppMethodBeat.o(71261);
              return;
            }
          }
        });
      }
      for (;;)
      {
        this.BJo.requestFocus();
        localObject1 = getInput().getString("key_QADNA_URL");
        if (!bs.isNullOrNil((String)localObject1)) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(71266);
              e.o(WalletVerifyCodeUI.this.getContext(), this.BJD, false);
              AppMethodBeat.o(71266);
              return true;
            }
          });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(71267);
            WalletVerifyCodeUI.this.hideVKB();
            if (WalletVerifyCodeUI.this.needConfirmFinish()) {
              WalletVerifyCodeUI.this.showDialog(1000);
            }
            for (;;)
            {
              AppMethodBeat.o(71267);
              return false;
              WalletVerifyCodeUI.this.finish();
            }
          }
        });
        AppMethodBeat.o(71276);
        return;
        localTextView.setVisibility(0);
        break;
        if ((localObject1 == null) || (!((com.tencent.mm.wallet_core.d)localObject1).fzI()) || (i == 11) || (i == 21)) {
          break label503;
        }
        if ((!localBankcard.eqR()) && (!localBankcard.eqS()))
        {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71263);
              com.tencent.mm.ui.base.h.d(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(2131765705, new Object[] { localBankcard.field_desc, localBankcard.field_mobile }), "", WalletVerifyCodeUI.this.getString(2131765704), WalletVerifyCodeUI.this.getString(2131755691), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(71262);
                  ac.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                  paramAnonymous2DialogInterface = WalletVerifyCodeUI.this.getInput();
                  paramAnonymous2DialogInterface.putInt("key_err_code", 408);
                  com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                  WalletVerifyCodeUI.this.finish();
                  AppMethodBeat.o(71262);
                }
              }, null);
              AppMethodBeat.o(71263);
            }
          });
        }
        else
        {
          localObject2 = getInput().getString("key_verify_tail_wording", getString(2131765916));
          localObject1 = localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            localObject1 = getString(2131765916);
          }
          localTextView.setText((CharSequence)localObject1);
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              boolean bool = false;
              AppMethodBeat.i(71264);
              ac.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
              ac.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
              if ((WalletVerifyCodeUI.d(WalletVerifyCodeUI.this) != null) && (WalletVerifyCodeUI.d(WalletVerifyCodeUI.this).erc())) {
                com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(9) });
              }
              paramAnonymousView = WalletVerifyCodeUI.this.getInput();
              paramAnonymousView.putInt("key_err_code", 417);
              paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
              if ((localBankcard == null) || (localBankcard.eqR())) {
                bool = true;
              }
              paramAnonymousView.putBoolean("key_isbalance", bool);
              com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymousView);
              AppMethodBeat.o(71264);
            }
          });
        }
      }
      label503:
      if (com.tencent.mm.model.u.axL()) {}
      for (localObject1 = getString(2131765913);; localObject1 = getString(2131765912))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71265);
            WalletVerifyCodeUI.e(WalletVerifyCodeUI.this);
            AppMethodBeat.o(71265);
          }
        });
        break;
      }
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(71285);
    boolean bool = getIntent().getBooleanExtra("key_need_confirm_finish", false);
    if (((this.mPayInfo != null) && (this.mPayInfo.teP)) || (bool))
    {
      AppMethodBeat.o(71285);
      return true;
    }
    bool = super.needConfirmFinish();
    AppMethodBeat.o(71285);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 2;
    AppMethodBeat.i(71272);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.WalletVertifyCodeUI", "on create");
    setMMTitle(2131765928);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.wSu = ((Orders)getInput().getParcelable("key_orders"));
    this.BJq = getInput().getString("key_bank_phone");
    this.BJx = new com.tencent.mm.plugin.wallet_core.model.i(getInput());
    this.BJr = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.h.wUl;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dqL != 0))
    {
      i = 1;
      if (!this.BJr) {
        break label310;
      }
    }
    for (;;)
    {
      paramBundle.f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f.euN();
      f.a(this, getInput(), 4);
      if (this.BJx.erc())
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13731, new Object[] { Integer.valueOf(5) });
        if (!bs.isNullOrNil(this.BJx.BvC.title)) {
          setMMTitle(this.BJx.BvC.title);
        }
        if (this.BJt != null) {
          this.BJt.setText(getString(2131765918));
        }
        if ((this.fwU != null) && (!bs.isNullOrNil(this.BJx.BvC.JEK))) {
          this.fwU.setText(this.BJx.BvC.JEK);
        }
      }
      this.mNetSceneMgr.addSceneEndListener(1580);
      AppMethodBeat.o(71272);
      return;
      i = 2;
      break;
      label310:
      j = 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71284);
    this.mNetSceneMgr.removeSceneEndListener(1580);
    super.onDestroy();
    AppMethodBeat.o(71284);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(71283);
    if (this.BJo.gX(null))
    {
      this.fwU.setEnabled(true);
      this.fwU.setClickable(true);
      AppMethodBeat.o(71283);
      return;
    }
    this.fwU.setEnabled(false);
    this.fwU.setClickable(false);
    AppMethodBeat.o(71283);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71282);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(71282);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71278);
    super.onNewIntent(paramIntent);
    cL();
    AppMethodBeat.o(71278);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71286);
    ac.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramn });
    if (((paramn instanceof p)) && (paramInt2 == 0))
    {
      this.BJv = true;
      t.makeText(this, 2131765617, 0).show();
      ac.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(71286);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71277);
    super.onResume();
    cL();
    AppMethodBeat.o(71277);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71281);
    ac.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramn instanceof p))
    {
      if ((paramInt2 != 0) && (((p)paramn).isBlock())) {
        com.tencent.mm.ui.base.h.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      AppMethodBeat.o(71281);
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.wallet_core.a.br(this);
      if ((paramn instanceof ad))
      {
        getInput().putBoolean("intent_bind_end", true);
        if ((paramString != null) && (!"realname_verify_process".equals(paramString.cHN()))) {
          com.tencent.mm.ui.base.h.cg(this, getString(2131765037));
        }
        ac.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramn instanceof v)) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(f.euO()) });
      }
      if ((this.Bgj != null) && ((paramn instanceof m)))
      {
        paramn = ((m)paramn).getToken();
        if (!bs.isNullOrNil(paramn)) {
          getInput().putString("kreq_token", paramn);
        }
      }
      if (paramInt1 != 0)
      {
        ac.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
        com.tencent.mm.wallet_core.a.k(this, getInput());
        if ((paramString == null) || (!paramString.cHN().equals("PayProcess")))
        {
          ac.i("MicroMsg.WalletVertifyCodeUI", "finish self");
          finish();
        }
        AppMethodBeat.o(71281);
        return true;
        if (!(paramn instanceof q))
        {
          if (paramString.c(this, null))
          {
            doSceneForceProgress(new ad(getPayReqKey(), 13));
            ac.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
          }
        }
        else {
          paramInt1 = 0;
        }
      }
      else
      {
        AppMethodBeat.o(71281);
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
  
  final class a
    extends CountDownTimer
  {
    public a(long paramLong)
    {
      super(1000L);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(71270);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setClickable(true);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setEnabled(true);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(2131765925));
      AppMethodBeat.o(71270);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(71269);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(2131765925) + "(" + paramLong / 1000L + ")");
      AppMethodBeat.o(71269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */