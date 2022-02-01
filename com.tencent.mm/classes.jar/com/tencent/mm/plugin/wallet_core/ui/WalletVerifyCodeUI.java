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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int AqT;
  protected WalletFormView AqU;
  private Button AqV;
  private String AqW;
  private boolean AqX;
  private a AqY;
  private TextView AqZ;
  private TextView Ara;
  private boolean Arb;
  private boolean Arc;
  private com.tencent.mm.plugin.wallet_core.model.i Ard;
  private p.a Are;
  private Button ftn;
  private PayInfo mPayInfo;
  private String mVerifyCode;
  private Orders vIq;
  private Authen zNP;
  
  public WalletVerifyCodeUI()
  {
    AppMethodBeat.i(71271);
    this.AqT = 60000;
    this.AqU = null;
    this.AqX = false;
    this.AqY = null;
    this.Arb = false;
    this.Arc = true;
    this.Ard = new com.tencent.mm.plugin.wallet_core.model.i();
    this.Are = new p.a()
    {
      public final void eey()
      {
        AppMethodBeat.i(71268);
        WalletVerifyCodeUI.this.eex();
        AppMethodBeat.o(71268);
      }
    };
    AppMethodBeat.o(71271);
  }
  
  private void cE()
  {
    AppMethodBeat.i(71279);
    Object localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    String str = eev();
    if ((bt.isNullOrNil(str)) && (localObject != null))
    {
      str = ((Bankcard)localObject).field_mobile;
      getInput().putString("key_mobile", str);
    }
    for (;;)
    {
      this.Ara.setText(getString(2131765765, new Object[] { str }));
      localObject = getTips(0);
      if (!bt.ai((CharSequence)localObject))
      {
        this.AqZ.setText((CharSequence)localObject);
        AppMethodBeat.o(71279);
        return;
      }
      this.AqZ.setText(String.format(getString(2131765910), new Object[] { str }));
      AppMethodBeat.o(71279);
      return;
    }
  }
  
  protected final String eev()
  {
    AppMethodBeat.i(71274);
    String str = bt.by(getInput().getString("key_mobile"), "");
    if (bt.isNullOrNil(str))
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
  
  protected final void eew()
  {
    int j = 2;
    AppMethodBeat.i(71275);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dtb != 0))
    {
      i = 1;
      if (!this.AqX) {
        break label168;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.AqX = true;
      this.AqV.setClickable(false);
      this.AqV.setEnabled(false);
      if (this.AqY != null)
      {
        this.AqY.cancel();
        this.AqY = null;
      }
      localObject = new a(this.AqT);
      this.AqY = ((a)localObject);
      ((a)localObject).start();
      if (!getNetController().y(new Object[] { this.mVerifyCode })) {
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
    this.zNP = ((Authen)getInput().getParcelable("key_authen"));
    if (this.zNP == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      AppMethodBeat.o(71275);
      return;
    }
    f.eft();
    AppMethodBeat.o(71275);
  }
  
  protected final void eex()
  {
    AppMethodBeat.i(71280);
    Bundle localBundle = getInput();
    Object localObject = getInput().getString("key_pwd1");
    this.mVerifyCode = this.AqU.getText();
    com.tencent.mm.plugin.wallet_core.model.u localu = new com.tencent.mm.plugin.wallet_core.model.u();
    localu.ijt = ((String)localObject);
    localu.uXi = this.mPayInfo;
    localu.Ahs = this.mVerifyCode;
    localu.token = bt.by(getInput().getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localu.dca = ((Bankcard)localObject).field_bankcardType;
      localu.uns = ((Bankcard)localObject).field_bindSerial;
      localu.Abm = bt.by(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      localObject = localBundle.getString("key_bind_card_user_token", null);
      if (!bt.isNullOrNil((String)localObject))
      {
        localu.Abw = 1;
        localu.zWG = ((String)localObject);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localu.uXi + " mVerifyCode: " + this.mVerifyCode);
      localBundle.putString("key_verify_code", this.mVerifyCode);
      com.tencent.mm.wallet_core.a.bo(this);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().q(new Object[] { this.mVerifyCode, localu }))));
      AppMethodBeat.o(71280);
      return;
      localu.dca = getInput().getString("key_bank_type");
      if (bt.isNullOrNil(localu.dca)) {
        localu.dca = getInput().getString("key_bind_card_type", "");
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(71273);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", new Object[] { bt.eGN() });
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
    Object localObject1 = com.tencent.mm.wallet_core.a.bo(this);
    final Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    this.AqZ = ((TextView)findViewById(2131297268));
    this.Ara = ((TextView)findViewById(2131297269));
    this.AqU = ((WalletFormView)findViewById(2131297252));
    this.AqU.setOnInputValidChangeListener(this);
    this.AqV = ((Button)findViewById(2131300583));
    this.AqV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71259);
        paramAnonymousView = WalletVerifyCodeUI.this.getProcess();
        final int i;
        if ((WalletVerifyCodeUI.a(WalletVerifyCodeUI.this)) && (paramAnonymousView != null) && ("PayProcess".equals(paramAnonymousView.cuB())))
        {
          if (localBankcard == null) {
            break label230;
          }
          if (localBankcard.ebv()) {
            i = 1;
          }
        }
        for (;;)
        {
          paramAnonymousView = new d.a(WalletVerifyCodeUI.this.getContext());
          paramAnonymousView.aau(2131765909);
          paramAnonymousView.aMg(WalletVerifyCodeUI.this.getString(2131765908, new Object[] { WalletVerifyCodeUI.this.eev() }));
          paramAnonymousView.wX(true);
          paramAnonymousView.aaB(2131765907);
          paramAnonymousView.aaC(2131765906);
          paramAnonymousView.b(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71257);
              WalletVerifyCodeUI.this.eew();
              com.tencent.mm.plugin.report.service.h.vKh.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
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
              if ((WalletVerifyCodeUI.1.this.zFQ == null) || (WalletVerifyCodeUI.1.this.zFQ.ebv())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymous2DialogInterface.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                com.tencent.mm.plugin.report.service.h.vKh.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i) });
                AppMethodBeat.o(71258);
                return;
              }
            }
          });
          paramAnonymousView.fft().show();
          com.tencent.mm.plugin.report.service.h.vKh.f(15443, new Object[] { Integer.valueOf(1) });
          WalletVerifyCodeUI.b(WalletVerifyCodeUI.this);
          AppMethodBeat.o(71259);
          return;
          if (localBankcard.ebw())
          {
            i = 3;
          }
          else
          {
            i = 2;
            continue;
            WalletVerifyCodeUI.this.eew();
            AppMethodBeat.o(71259);
            return;
            label230:
            i = 0;
          }
        }
      }
    });
    this.ftn = ((Button)findViewById(2131297249));
    this.ftn.setOnClickListener(new View.OnClickListener()
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
        WalletVerifyCodeUI.this.eex();
        AppMethodBeat.o(71260);
      }
    });
    cE();
    this.AqV.setClickable(false);
    this.AqV.setEnabled(false);
    if (this.AqY != null)
    {
      this.AqY.cancel();
      this.AqY = null;
    }
    Object localObject2 = new a(this.AqT);
    this.AqY = ((a)localObject2);
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
    for (int i = ((PayInfo)localObject2).dtb;; i = 0)
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
            paramAnonymousView = WalletVerifyCodeUI.this.getInput();
            paramAnonymousView.putInt("key_err_code", 417);
            paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
            WalletVerifyCodeUI.this.getInput().putBoolean("key_block_bind_new_card", true);
            boolean bool1 = bool2;
            if (localBankcard != null) {
              if (!localBankcard.ebv()) {
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
        this.AqU.requestFocus();
        localObject1 = getInput().getString("key_QADNA_URL");
        if (!bt.isNullOrNil((String)localObject1)) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(71266);
              e.p(WalletVerifyCodeUI.this.getContext(), this.Arj, false);
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
        if ((localObject1 == null) || (!((com.tencent.mm.wallet_core.d)localObject1).fjt()) || (i == 11) || (i == 21)) {
          break label503;
        }
        if ((!localBankcard.ebv()) && (!localBankcard.ebw()))
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
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
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
          if (bt.isNullOrNil((String)localObject2)) {
            localObject1 = getString(2131765916);
          }
          localTextView.setText((CharSequence)localObject1);
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              boolean bool = false;
              AppMethodBeat.i(71264);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
              if ((WalletVerifyCodeUI.d(WalletVerifyCodeUI.this) != null) && (WalletVerifyCodeUI.d(WalletVerifyCodeUI.this).ebG())) {
                com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(9) });
              }
              paramAnonymousView = WalletVerifyCodeUI.this.getInput();
              paramAnonymousView.putInt("key_err_code", 417);
              paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
              if ((localBankcard == null) || (localBankcard.ebv())) {
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
      if (com.tencent.mm.model.u.aqV()) {}
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
    if (((this.mPayInfo != null) && (this.mPayInfo.rWX)) || (bool))
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "on create");
    setMMTitle(2131765928);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.vIq = ((Orders)getInput().getParcelable("key_orders"));
    this.AqW = getInput().getString("key_bank_phone");
    this.Ard = new com.tencent.mm.plugin.wallet_core.model.i(getInput());
    this.AqX = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.h.vKh;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dtb != 0))
    {
      i = 1;
      if (!this.AqX) {
        break label310;
      }
    }
    for (;;)
    {
      paramBundle.f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f.eft();
      f.a(this, getInput(), 4);
      if (this.Ard.ebG())
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13731, new Object[] { Integer.valueOf(5) });
        if (!bt.isNullOrNil(this.Ard.Adi.title)) {
          setMMTitle(this.Ard.Adi.title);
        }
        if (this.AqZ != null) {
          this.AqZ.setText(getString(2131765918));
        }
        if ((this.ftn != null) && (!bt.isNullOrNil(this.Ard.Adi.Idi))) {
          this.ftn.setText(this.Ard.Adi.Idi);
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
    if (this.AqU.gF(null))
    {
      this.ftn.setEnabled(true);
      this.ftn.setClickable(true);
      AppMethodBeat.o(71283);
      return;
    }
    this.ftn.setEnabled(false);
    this.ftn.setClickable(false);
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
    cE();
    AppMethodBeat.o(71278);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71286);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramn });
    if (((paramn instanceof p)) && (paramInt2 == 0))
    {
      this.Arb = true;
      t.makeText(this, 2131765617, 0).show();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(71286);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71277);
    super.onResume();
    cE();
    AppMethodBeat.o(71277);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71281);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
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
      paramString = com.tencent.mm.wallet_core.a.bo(this);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        getInput().putBoolean("intent_bind_end", true);
        if ((paramString != null) && (!"realname_verify_process".equals(paramString.cuB()))) {
          com.tencent.mm.ui.base.h.cf(this, getString(2131765037));
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramn instanceof v)) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(f.efu()) });
      }
      if ((this.zNP != null) && ((paramn instanceof m)))
      {
        paramn = ((m)paramn).getToken();
        if (!bt.isNullOrNil(paramn)) {
          getInput().putString("kreq_token", paramn);
        }
      }
      if (paramInt1 != 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
        com.tencent.mm.wallet_core.a.k(this, getInput());
        if ((paramString == null) || (!paramString.cuB().equals("PayProcess")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "finish self");
          finish();
        }
        AppMethodBeat.o(71281);
        return true;
        if (!(paramn instanceof q))
        {
          if (paramString.c(this, null))
          {
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(getPayReqKey(), 13));
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
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