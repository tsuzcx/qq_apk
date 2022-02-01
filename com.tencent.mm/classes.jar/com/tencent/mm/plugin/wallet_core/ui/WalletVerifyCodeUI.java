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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
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
  private Authen CGx;
  private int DjF;
  protected WalletFormView DjG;
  private Button DjH;
  private String DjI;
  private boolean DjJ;
  private a DjK;
  private TextView DjL;
  private TextView DjM;
  private boolean DjN;
  private boolean DjO;
  private com.tencent.mm.plugin.wallet_core.model.i DjP;
  private p.a DjQ;
  private Button fQh;
  private PayInfo mPayInfo;
  private String mVerifyCode;
  private Orders ygb;
  
  public WalletVerifyCodeUI()
  {
    AppMethodBeat.i(71271);
    this.DjF = 60000;
    this.DjG = null;
    this.DjJ = false;
    this.DjK = null;
    this.DjN = false;
    this.DjO = true;
    this.DjP = new com.tencent.mm.plugin.wallet_core.model.i();
    this.DjQ = new p.a()
    {
      public final void eHZ()
      {
        AppMethodBeat.i(71268);
        WalletVerifyCodeUI.this.eHY();
        AppMethodBeat.o(71268);
      }
    };
    AppMethodBeat.o(71271);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(71279);
    Object localObject = (Bankcard)getInput().getParcelable("key_bankcard");
    String str = eHW();
    if ((bt.isNullOrNil(str)) && (localObject != null))
    {
      str = ((Bankcard)localObject).field_mobile;
      getInput().putString("key_mobile", str);
    }
    for (;;)
    {
      this.DjM.setText(getString(2131765765, new Object[] { str }));
      localObject = getTips(0);
      if (!bt.ai((CharSequence)localObject))
      {
        this.DjL.setText((CharSequence)localObject);
        AppMethodBeat.o(71279);
        return;
      }
      this.DjL.setText(String.format(getString(2131765910), new Object[] { str }));
      AppMethodBeat.o(71279);
      return;
    }
  }
  
  protected final String eHW()
  {
    AppMethodBeat.i(71274);
    String str = bt.bI(getInput().getString("key_mobile"), "");
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
  
  protected final void eHX()
  {
    int j = 2;
    AppMethodBeat.i(71275);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
    Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dCC != 0))
    {
      i = 1;
      if (!this.DjJ) {
        break label168;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      this.DjJ = true;
      this.DjH.setClickable(false);
      this.DjH.setEnabled(false);
      if (this.DjK != null)
      {
        this.DjK.cancel();
        this.DjK = null;
      }
      localObject = new a(this.DjF);
      this.DjK = ((a)localObject);
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
    this.CGx = ((Authen)getInput().getParcelable("key_authen"));
    if (this.CGx == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
      AppMethodBeat.o(71275);
      return;
    }
    f.eIT();
    AppMethodBeat.o(71275);
  }
  
  protected final void eHY()
  {
    AppMethodBeat.i(71280);
    Bundle localBundle = getInput();
    Object localObject = getInput().getString("key_pwd1");
    this.mVerifyCode = this.DjG.getText();
    com.tencent.mm.plugin.wallet_core.model.v localv = new com.tencent.mm.plugin.wallet_core.model.v();
    localv.jcJ = ((String)localObject);
    localv.xnF = this.mPayInfo;
    localv.Daf = this.mVerifyCode;
    localv.token = bt.bI(getInput().getString("kreq_token"), "");
    localObject = (Bankcard)localBundle.getParcelable("key_bankcard");
    if (localObject != null)
    {
      localv.dkR = ((Bankcard)localObject).field_bankcardType;
      localv.wBI = ((Bankcard)localObject).field_bindSerial;
      localv.CTV = bt.bI(((Bankcard)localObject).field_arrive_type, "");
    }
    for (;;)
    {
      localObject = localBundle.getString("key_bind_card_user_token", null);
      if (!bt.isNullOrNil((String)localObject))
      {
        localv.CUf = 1;
        localv.CPp = ((String)localObject);
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + localv.xnF + " mVerifyCode: " + this.mVerifyCode);
      localBundle.putString("key_verify_code", this.mVerifyCode);
      com.tencent.mm.wallet_core.a.br(this);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(getNetController().s(new Object[] { this.mVerifyCode, localv }))));
      AppMethodBeat.o(71280);
      return;
      localv.dkR = getInput().getString("key_bank_type");
      if (bt.isNullOrNil(localv.dkR)) {
        localv.dkR = getInput().getString("key_bind_card_type", "");
      }
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(71273);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", new Object[] { bt.flS() });
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
    this.DjL = ((TextView)findViewById(2131297268));
    this.DjM = ((TextView)findViewById(2131297269));
    this.DjG = ((WalletFormView)findViewById(2131297252));
    this.DjG.setOnInputValidChangeListener(this);
    this.DjH = ((Button)findViewById(2131300583));
    this.DjH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71259);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = WalletVerifyCodeUI.this.getProcess();
        final int i;
        if ((WalletVerifyCodeUI.a(WalletVerifyCodeUI.this)) && (paramAnonymousView != null) && ("PayProcess".equals(paramAnonymousView.cQc())))
        {
          if (localBankcard == null) {
            break label268;
          }
          if (localBankcard.eER()) {
            i = 1;
          }
        }
        for (;;)
        {
          paramAnonymousView = new d.a(WalletVerifyCodeUI.this.getContext());
          paramAnonymousView.afe(2131765909);
          paramAnonymousView.aXG(WalletVerifyCodeUI.this.getString(2131765908, new Object[] { WalletVerifyCodeUI.this.eHW() }));
          paramAnonymousView.yR(true);
          paramAnonymousView.afl(2131765907);
          paramAnonymousView.afm(2131765906);
          paramAnonymousView.c(new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(71257);
              WalletVerifyCodeUI.this.eHX();
              com.tencent.mm.plugin.report.service.g.yhR.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i) });
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
              if ((WalletVerifyCodeUI.1.this.Cym == null) || (WalletVerifyCodeUI.1.this.Cym.eER())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymous2DialogInterface.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymous2DialogInterface);
                com.tencent.mm.plugin.report.service.g.yhR.f(15443, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i) });
                AppMethodBeat.o(71258);
                return;
              }
            }
          });
          paramAnonymousView.fMb().show();
          com.tencent.mm.plugin.report.service.g.yhR.f(15443, new Object[] { Integer.valueOf(1) });
          WalletVerifyCodeUI.b(WalletVerifyCodeUI.this);
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71259);
            return;
            if (localBankcard.eES())
            {
              i = 3;
              break;
            }
            i = 2;
            break;
            WalletVerifyCodeUI.this.eHX();
          }
          label268:
          i = 0;
        }
      }
    });
    this.fQh = ((Button)findViewById(2131297249));
    this.fQh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71260);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletVerifyCodeUI.this.hideVKB();
        if (WalletVerifyCodeUI.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.c(WalletVerifyCodeUI.this)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71260);
          return;
        }
        WalletVerifyCodeUI.this.eHY();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71260);
      }
    });
    updateView();
    this.DjH.setClickable(false);
    this.DjH.setEnabled(false);
    if (this.DjK != null)
    {
      this.DjK.cancel();
      this.DjK = null;
    }
    Object localObject2 = new a(this.DjF);
    this.DjK = ((a)localObject2);
    ((a)localObject2).start();
    TextView localTextView = (TextView)findViewById(2131297267);
    boolean bool1 = getInput().getBoolean("key_is_changing_balance_phone_num");
    boolean bool2 = getInput().getBoolean("key_need_show_switch_phone", false);
    if ((bool1) && (!bool2))
    {
      localTextView.setVisibility(8);
      localObject2 = (PayInfo)getInput().getParcelable("key_pay_info");
      if (localObject2 == null) {
        break label551;
      }
    }
    label551:
    for (int i = ((PayInfo)localObject2).dCC;; i = 0)
    {
      if (bool2)
      {
        localTextView.setText(2131765916);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71261);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
            paramAnonymousView = WalletVerifyCodeUI.this.getInput();
            paramAnonymousView.putInt("key_err_code", 417);
            paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
            WalletVerifyCodeUI.this.getInput().putBoolean("key_block_bind_new_card", true);
            if ((localBankcard == null) || (localBankcard.eER())) {}
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousView.putBoolean("key_isbalance", bool);
              com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymousView);
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
        this.DjG.requestFocus();
        localObject1 = getInput().getString("key_QADNA_URL");
        if (!bt.isNullOrNil((String)localObject1)) {
          addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(71266);
              e.o(WalletVerifyCodeUI.this.getContext(), this.DjV, false);
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
        if ((localObject1 == null) || (!((com.tencent.mm.wallet_core.d)localObject1).fQS()) || (i == 11) || (i == 21)) {
          break label501;
        }
        if ((!localBankcard.eER()) && (!localBankcard.eES()))
        {
          localTextView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(71263);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              h.e(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(2131765705, new Object[] { localBankcard.field_desc, localBankcard.field_mobile }), "", WalletVerifyCodeUI.this.getString(2131765704), WalletVerifyCodeUI.this.getString(2131755691), new DialogInterface.OnClickListener()
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
              AppMethodBeat.i(71264);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
              if ((WalletVerifyCodeUI.d(WalletVerifyCodeUI.this) != null) && (WalletVerifyCodeUI.d(WalletVerifyCodeUI.this).eFc())) {
                com.tencent.mm.plugin.report.service.g.yhR.f(13731, new Object[] { Integer.valueOf(9) });
              }
              paramAnonymousView = WalletVerifyCodeUI.this.getInput();
              paramAnonymousView.putInt("key_err_code", 417);
              paramAnonymousView.putBoolean("key_need_show_switch_phone", true);
              if ((localBankcard == null) || (localBankcard.eER())) {}
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousView.putBoolean("key_isbalance", bool);
                com.tencent.mm.wallet_core.a.k(WalletVerifyCodeUI.this, paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71264);
                return;
              }
            }
          });
        }
      }
      label501:
      if (u.aAB()) {}
      for (localObject1 = getString(2131765913);; localObject1 = getString(2131765912))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(71265);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletVerifyCodeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    if (((this.mPayInfo != null) && (this.mPayInfo.ucG)) || (bool))
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
    this.ygb = ((Orders)getInput().getParcelable("key_orders"));
    this.DjI = getInput().getString("key_bank_phone");
    this.DjP = new com.tencent.mm.plugin.wallet_core.model.i(getInput());
    this.DjJ = false;
    initView();
    paramBundle = com.tencent.mm.plugin.report.service.g.yhR;
    int i;
    if ((this.mPayInfo != null) && (this.mPayInfo.dCC != 0))
    {
      i = 1;
      if (!this.DjJ) {
        break label310;
      }
    }
    for (;;)
    {
      paramBundle.f(10706, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      f.eIT();
      f.a(this, getInput(), 4);
      if (this.DjP.eFc())
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(13731, new Object[] { Integer.valueOf(5) });
        if (!bt.isNullOrNil(this.DjP.CVR.title)) {
          setMMTitle(this.DjP.CVR.title);
        }
        if (this.DjL != null) {
          this.DjL.setText(getString(2131765918));
        }
        if ((this.fQh != null) && (!bt.isNullOrNil(this.DjP.CVR.LxO))) {
          this.fQh.setText(this.DjP.CVR.LxO);
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
    if (this.DjG.ho(null))
    {
      this.fQh.setEnabled(true);
      this.fQh.setClickable(true);
      AppMethodBeat.o(71283);
      return;
    }
    this.fQh.setEnabled(false);
    this.fQh.setClickable(false);
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
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71286);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramn });
    if (((paramn instanceof p)) && (paramInt2 == 0))
    {
      this.DjN = true;
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
    updateView();
    AppMethodBeat.o(71277);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71281);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramn instanceof p))
    {
      if ((paramInt2 != 0) && (((p)paramn).isBlock())) {
        h.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
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
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        getInput().putBoolean("intent_bind_end", true);
        if ((paramString != null) && (!"realname_verify_process".equals(paramString.cQc()))) {
          h.cl(this, getString(2131765037));
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.v)) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10707, new Object[] { Integer.valueOf(2), Integer.valueOf(f.eIU()) });
      }
      if ((this.CGx != null) && ((paramn instanceof m)))
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
        if ((paramString == null) || (!paramString.cQc().equals("PayProcess")))
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