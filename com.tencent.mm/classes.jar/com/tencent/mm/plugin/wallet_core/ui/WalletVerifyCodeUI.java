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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Orders Ivh;
  private Authen OvK;
  private int PcN;
  protected WalletFormView PcO;
  private Button PcP;
  private String PcQ;
  private boolean PcR;
  private a PcS;
  private TextView PcT;
  private TextView PcU;
  private boolean PcV;
  private boolean PcW;
  private com.tencent.mm.plugin.wallet_core.model.i PcX;
  private p.a PcY;
  private Button jbJ;
  private PayInfo mPayInfo;
  private String mVerifyCode;
  
  public WalletVerifyCodeUI()
  {
    AppMethodBeat.i(71271);
    this.PcN = 60000;
    this.PcO = null;
    this.PcR = false;
    this.PcS = null;
    this.PcV = false;
    this.PcW = true;
    this.PcX = new com.tencent.mm.plugin.wallet_core.model.i();
    this.PcY = new p.a()
    {
      public final void gLU()
      {
        AppMethodBeat.i(71268);
        WalletVerifyCodeUI.this.gLT();
        AppMethodBeat.o(71268);
      }
    };
    AppMethodBeat.o(71271);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(71279);
    Object localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    String str = gLR();
    if ((Util.isNullOrNil(str)) && (localObject != null))
    {
      str = ((Bankcard)localObject).field_mobile;
      getInput().putString("key_mobile", str);
    }
    for (;;)
    {
      this.PcU.setText(getString(a.i.wallet_receive_verify_code_phone, new Object[] { str }));
      localObject = getTips(0);
      if (!Util.isNullOrNil((CharSequence)localObject))
      {
        this.PcT.setText((CharSequence)localObject);
        AppMethodBeat.o(71279);
        return;
      }
      this.PcT.setText(String.format(getString(a.i.wallet_verify_code_common_hint), new Object[] { str }));
      AppMethodBeat.o(71279);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(71273);
    Log.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", new Object[] { Util.getStack() });
    super.finish();
    AppMethodBeat.o(71273);
  }
  
  protected final String gLR()
  {
    AppMethodBeat.i(71274);
    String str = Util.nullAs(getInput().getString("key_mobile"), "");
    if (Util.isNullOrNil(str))
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
  
  protected final void gLS()
  {
    int j = 2;
    AppMethodBeat.i(71275);
    Log.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.fOY != 0))
    {
      i = 1;
      if (!this.PcR) {
        break label168;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.PcR = true;
      this.PcP.setClickable(false);
      this.PcP.setEnabled(false);
      if (this.PcS != null)
      {
        this.PcS.cancel();
        this.PcS = null;
      }
      localObject = new a(this.PcN);
      this.PcS = ((a)localObject);
      ((a)localObject).start();
      if (!getNetController().B(new Object[] { this.mVerifyCode })) {
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
    this.OvK = ((Authen)getInput().getParcelable("key_authen"));
    if (this.OvK == null)
    {
      Log.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      AppMethodBeat.o(71275);
      return;
    }
    j.gMO();
    AppMethodBeat.o(71275);
  }
  
  protected final void gLT()
  {
    AppMethodBeat.i(71280);
    Bundle localBundle = getInput();
    Object localObject = getInput().getString("key_pwd1");
    this.mVerifyCode = this.PcO.getText();
    com.tencent.mm.plugin.wallet_core.model.w localw = new com.tencent.mm.plugin.wallet_core.model.w();
    localw.mVf = ((String)localObject);
    localw.HzF = this.mPayInfo;
    localw.OTh = this.mVerifyCode;
    localw.token = Util.nullAs(getInput().getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localw.fvP = ((Bankcard)localObject).field_bankcardType;
      localw.GGC = ((Bankcard)localObject).field_bindSerial;
      localw.OMV = Util.nullAs(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      localObject = localBundle.getString("key_bind_card_user_token", null);
      if (!Util.isNullOrNil((String)localObject))
      {
        localw.ONf = 1;
        localw.OIv = ((String)localObject);
      }
      Log.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localw.HzF + " mVerifyCode: " + this.mVerifyCode);
      localBundle.putString("key_verify_code", this.mVerifyCode);
      com.tencent.mm.wallet_core.a.bF(this);
      Log.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().r(new Object[] { this.mVerifyCode, localw }))));
      AppMethodBeat.o(71280);
      return;
      localw.fvP = getInput().getString("key_bank_type");
      if (Util.isNullOrNil(localw.fvP)) {
        localw.fvP = getInput().getString("key_bind_card_type", "");
      }
    }
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_verify_code;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71276);
    Object localObject1 = com.tencent.mm.wallet_core.a.bF(this);
    final Bankcard localBankcard = (Bankcard)getInput().getParcelable("key_bankcard");
    this.PcT = ((TextView)findViewById(a.f.bind_wallet_verify_hint));
    this.PcU = ((TextView)findViewById(a.f.bind_wallet_verify_mobile_tv));
    this.PcO = ((WalletFormView)findViewById(a.f.bind_mcontact_verify_num));
    this.PcO.setOnInputValidChangeListener(this);
    this.PcP = ((Button)findViewById(a.f.get_verify_btn));
    this.PcP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71259);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = WalletVerifyCodeUI.this.getProcess();
        final int i;
        if ((WalletVerifyCodeUI.a(WalletVerifyCodeUI.this)) && (paramAnonymousView != null) && ("PayProcess".equals(paramAnonymousView.epb())))
        {
          if (localBankcard == null) {
            break label272;
          }
          if (localBankcard.gIH()) {
            i = 1;
          }
        }
        for (;;)
        {
          paramAnonymousView = new d.a(WalletVerifyCodeUI.this.getContext());
          paramAnonymousView.ayc(a.i.wallet_verify_code_comfirm_title);
          paramAnonymousView.bBd(WalletVerifyCodeUI.this.getString(a.i.wallet_verify_code_comfirm_text, new Object[] { WalletVerifyCodeUI.this.gLR() }));
          paramAnonymousView.HG(true);
          paramAnonymousView.ayj(a.i.wallet_verify_code_comfirm_ok_btn);
          paramAnonymousView.ayk(a.i.wallet_verify_code_comfirm_cancel_btn);
          paramAnonymousView.c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71257);
              WalletVerifyCodeUI.this.gLS();
              com.tencent.mm.plugin.report.service.h.IzE.a(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
              AppMethodBeat.o(71257);
            }
          });
          paramAnonymousView.d(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71258);
              paramAnonymous2DialogInterface = WalletVerifyCodeUI.this.getInput();
              paramAnonymous2DialogInterface.putInt("key_err_code", 417);
              paramAnonymous2DialogInterface.putBoolean("key_need_show_switch_phone", true);
              if ((WalletVerifyCodeUI.1.this.Omw == null) || (WalletVerifyCodeUI.1.this.Omw.gIH())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymous2DialogInterface.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                com.tencent.mm.plugin.report.service.h.IzE.a(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i) });
                AppMethodBeat.o(71258);
                return;
              }
            }
          });
          paramAnonymousView.icu().show();
          com.tencent.mm.plugin.report.service.h.IzE.a(15443, new Object[] { Integer.valueOf(1) });
          WalletVerifyCodeUI.b(WalletVerifyCodeUI.this);
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71259);
            return;
            if (localBankcard.gII())
            {
              i = 3;
              break;
            }
            i = 2;
            break;
            WalletVerifyCodeUI.this.gLS();
          }
          label272:
          i = 0;
        }
      }
    });
    this.jbJ = ((Button)findViewById(a.f.bind_mcontact_verify_btn));
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71260);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletVerifyCodeUI.this.hideVKB();
        if (WalletVerifyCodeUI.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.c(WalletVerifyCodeUI.this)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71260);
          return;
        }
        WalletVerifyCodeUI.this.gLT();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71260);
      }
    });
    updateView();
    this.PcP.setClickable(false);
    this.PcP.setEnabled(false);
    if (this.PcS != null)
    {
      this.PcS.cancel();
      this.PcS = null;
    }
    Object localObject2 = new a(this.PcN);
    this.PcS = ((a)localObject2);
    ((a)localObject2).start();
    TextView localTextView = (TextView)findViewById(a.f.bind_wallet_reset_mobile);
    boolean bool1 = getInput().getBoolean("key_is_changing_balance_phone_num");
    boolean bool2 = getInput().getBoolean("key_need_show_switch_phone", false);
    if ((bool1) && (!bool2))
    {
      localTextView.setVisibility(8);
      localObject2 = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localObject2 == null) {
        break label554;
      }
    }
    label554:
    for (int i = ((PayInfo)localObject2).fOY;; i = 0)
    {
      if (bool2)
      {
        localTextView.setText(a.i.wallet_verify_code_get_failed_title);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71261);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
            Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
            paramAnonymousView = WalletVerifyCodeUI.this.getInput();
            paramAnonymousView.putInt("key_err_code", 417);
            paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
            WalletVerifyCodeUI.this.getInput().putBoolean("key_block_bind_new_card", true);
            if ((localBankcard == null) || (localBankcard.gIH())) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.putBoolean("key_isbalance", bool);
              com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, paramAnonymousView);
              WalletVerifyCodeUI.this.finish();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71261);
              return;
            }
          }
        });
      }
      for (;;)
      {
        this.PcO.requestFocus();
        localObject1 = getInput().getString("key_QADNA_URL");
        if (!Util.isNullOrNil((String)localObject1)) {
          addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(71266);
              com.tencent.mm.wallet_core.ui.g.p(WalletVerifyCodeUI.this.getContext(), this.Pdd, false);
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
        if ((localObject1 == null) || (!((com.tencent.mm.wallet_core.d)localObject1).iin()) || (i == 11) || (i == 21)) {
          break label504;
        }
        if ((!localBankcard.gIH()) && (!localBankcard.gII()))
        {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71263);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              com.tencent.mm.ui.base.h.c(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(a.i.wallet_pay_reset_info_tips, new Object[] { localBankcard.field_desc, localBankcard.field_mobile }), "", WalletVerifyCodeUI.this.getString(a.i.wallet_pay_reset_info), WalletVerifyCodeUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(71262);
                  Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                  paramAnonymous2DialogInterface = WalletVerifyCodeUI.this.getInput();
                  paramAnonymous2DialogInterface.putInt("key_err_code", 408);
                  com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                  WalletVerifyCodeUI.this.finish();
                  AppMethodBeat.o(71262);
                }
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(71263);
            }
          });
        }
        else
        {
          localObject2 = getInput().getString("key_verify_tail_wording", getString(a.i.wallet_verify_code_get_failed_title));
          localObject1 = localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            localObject1 = getString(a.i.wallet_verify_code_get_failed_title);
          }
          localTextView.setText((CharSequence)localObject1);
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71264);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              Log.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
              Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
              if ((WalletVerifyCodeUI.d(WalletVerifyCodeUI.this) != null) && (WalletVerifyCodeUI.d(WalletVerifyCodeUI.this).gIS())) {
                com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(9) });
              }
              paramAnonymousView = WalletVerifyCodeUI.this.getInput();
              paramAnonymousView.putInt("key_err_code", 417);
              paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
              if ((localBankcard == null) || (localBankcard.gIH())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousView.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.l(WalletVerifyCodeUI.this, paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71264);
                return;
              }
            }
          });
        }
      }
      label504:
      if (z.bdq()) {}
      for (localObject1 = getString(a.i.wallet_verify_code_get_failed_payu);; localObject1 = getString(a.i.wallet_verify_code_get_failed))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71265);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            WalletVerifyCodeUI.e(WalletVerifyCodeUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    if (((this.mPayInfo != null) && (this.mPayInfo.cpf)) || (bool))
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
    Log.i("MicroMsg.WalletVertifyCodeUI", "on create");
    setMMTitle(a.i.wallet_verify_phone);
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
    this.PcQ = getInput().getString("key_bank_phone");
    this.PcX = new com.tencent.mm.plugin.wallet_core.model.i(getInput());
    this.PcR = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.h.IzE;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.fOY != 0))
    {
      i = 1;
      if (!this.PcR) {
        break label310;
      }
    }
    for (;;)
    {
      paramBundle.a(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      j.gMO();
      j.a(this, getInput(), 4);
      if (this.PcX.gIS())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13731, new Object[] { Integer.valueOf(5) });
        if (!Util.isNullOrNil(this.PcX.OOP.title)) {
          setMMTitle(this.PcX.OOP.title);
        }
        if (this.PcT != null) {
          this.PcT.setText(getString(a.i.wallet_verify_code_install_cert_hint));
        }
        if ((this.jbJ != null) && (!Util.isNullOrNil(this.PcX.OOP.YUR))) {
          this.jbJ.setText(this.PcX.OOP.YUR);
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
    if (this.PcO.jf(null))
    {
      this.jbJ.setEnabled(true);
      this.jbJ.setClickable(true);
      AppMethodBeat.o(71283);
      return;
    }
    this.jbJ.setEnabled(false);
    this.jbJ.setClickable(false);
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
    updateView();
    AppMethodBeat.o(71278);
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(71286);
    Log.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramq });
    if (((paramq instanceof p)) && (paramInt2 == 0))
    {
      this.PcV = true;
      com.tencent.mm.ui.base.w.makeText(this, a.i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
      Log.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(71286);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71277);
    super.onResume();
    updateView();
    AppMethodBeat.o(71277);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(71281);
    Log.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramq instanceof p))
    {
      if ((paramInt2 != 0) && (((p)paramq).isBlock())) {
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
      paramString = com.tencent.mm.wallet_core.a.bF(this);
      if ((paramq instanceof ae))
      {
        getInput().putBoolean("intent_bind_end", true);
        if ((paramString != null) && (!"realname_verify_process".equals(paramString.epb()))) {
          com.tencent.mm.ui.base.h.cO(this, getString(a.i.wallet_bank_card_bind_success_tips));
        }
        Log.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramq instanceof com.tencent.mm.plugin.wallet_core.c.w)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(j.gMP()) });
      }
      if ((this.OvK != null) && ((paramq instanceof m)))
      {
        paramq = ((m)paramq).getToken();
        if (!Util.isNullOrNil(paramq)) {
          getInput().putString("kreq_token", paramq);
        }
      }
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
        com.tencent.mm.wallet_core.a.l(this, getInput());
        if ((paramString == null) || (!paramString.epb().equals("PayProcess")))
        {
          Log.i("MicroMsg.WalletVertifyCodeUI", "finish self");
          finish();
        }
        AppMethodBeat.o(71281);
        return true;
        if (!(paramq instanceof com.tencent.mm.wallet_core.tenpay.model.q))
        {
          if (paramString.c(this, null))
          {
            doSceneForceProgress(new ae(getPayReqKey(), 13));
            Log.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
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
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(a.i.wallet_verify_get_more_one));
      AppMethodBeat.o(71270);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(71269);
      WalletVerifyCodeUI.f(WalletVerifyCodeUI.this).setText(WalletVerifyCodeUI.this.getString(a.i.wallet_verify_get_more_one) + "(" + paramLong / 1000L + ")");
      AppMethodBeat.o(71269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */