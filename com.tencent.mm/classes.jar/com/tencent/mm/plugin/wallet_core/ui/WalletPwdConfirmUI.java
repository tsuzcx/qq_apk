package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.xn;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  private TextView Apo;
  private boolean App;
  private av Apq;
  private c fjL;
  private TextView kEu;
  private PayInfo mPayInfo;
  private TextView nym;
  protected EditHintPasswdView swk;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(71113);
    this.App = false;
    this.Apq = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(71111);
        if (WalletPwdConfirmUI.c(WalletPwdConfirmUI.this))
        {
          WalletPwdConfirmUI.d(WalletPwdConfirmUI.this);
          WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
        }
        AppMethodBeat.o(71111);
        return false;
      }
    }, false);
    this.fjL = new c() {};
    AppMethodBeat.o(71113);
  }
  
  private void een()
  {
    AppMethodBeat.i(71118);
    Bundle localBundle = getInput();
    localBundle.putBoolean("intent_bind_end", true);
    com.tencent.mm.wallet_core.a.k(this, localBundle);
    AppMethodBeat.o(71118);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496029;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71115);
    this.kEu = ((TextView)findViewById(2131306825));
    this.nym = ((TextView)findViewById(2131306820));
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().cuB()))) {
      this.kEu.setText(2131765519);
    }
    this.nym.setText(2131765870);
    this.Apo = ((TextView)findViewById(2131301028));
    if (!bt.ai(getTips(0))) {
      this.Apo.setText(2131765875);
    }
    for (;;)
    {
      this.Apo.setVisibility(0);
      this.Apo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71108);
          Object localObject = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
          String str2 = WalletPwdConfirmUI.this.swk.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
          String str1 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
          com.tencent.mm.sdk.platformtools.ad.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + str1);
          if ((localObject != null) && (((String)localObject).equals(str2)))
          {
            localObject = new u();
            ((u)localObject).ijt = WalletPwdConfirmUI.this.swk.getText();
            ((u)localObject).uXi = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((u)localObject).token = paramAnonymousView;
            ((u)localObject).Ahs = str1;
            ((u)localObject).Aht = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.bo(WalletPwdConfirmUI.this).eez()) {}
            for (((u)localObject).flag = "1";; ((u)localObject).flag = "4")
            {
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((u)localObject).Abp = paramAnonymousView.Aee;
                ((u)localObject).Abq = paramAnonymousView.Aeb;
              }
              WalletPwdConfirmUI.this.getNetController().q(new Object[] { localObject });
              AppMethodBeat.o(71108);
              return;
            }
          }
          com.tencent.mm.wallet_core.a.t(WalletPwdConfirmUI.this, -1002);
          AppMethodBeat.o(71108);
        }
      });
      this.Apo.setEnabled(false);
      this.Apo.setClickable(false);
      this.swk = ((EditHintPasswdView)findViewById(2131301026));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.swk);
      this.swk.setEditTextMaxLength(6);
      this.swk.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71109);
          if (paramAnonymousBoolean)
          {
            String str1 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
            String str2 = WalletPwdConfirmUI.this.swk.getMd5Value();
            if ((str1 == null) || (!str1.equals(str2)))
            {
              com.tencent.mm.wallet_core.a.t(WalletPwdConfirmUI.this, -1002);
              AppMethodBeat.o(71109);
              return;
            }
            WalletPwdConfirmUI.b(WalletPwdConfirmUI.this).setEnabled(paramAnonymousBoolean);
            WalletPwdConfirmUI.b(WalletPwdConfirmUI.this).setClickable(paramAnonymousBoolean);
            AppMethodBeat.o(71109);
            return;
          }
          WalletPwdConfirmUI.b(WalletPwdConfirmUI.this).setEnabled(paramAnonymousBoolean);
          WalletPwdConfirmUI.b(WalletPwdConfirmUI.this).setClickable(paramAnonymousBoolean);
          AppMethodBeat.o(71109);
        }
      });
      findViewById(2131297268).setVisibility(8);
      setEditFocusListener(this.swk, 0, false);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71110);
          if (paramAnonymousBoolean)
          {
            WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, this.Aps, WalletPwdConfirmUI.b(WalletPwdConfirmUI.this));
            AppMethodBeat.o(71110);
            return;
          }
          this.Aps.scrollTo(0, 0);
          AppMethodBeat.o(71110);
        }
      });
      AppMethodBeat.o(71115);
      return;
      this.Apo.setText(2131755779);
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(187183);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(187183);
      return false;
    }
    AppMethodBeat.o(187183);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71114);
    super.onCreate(paramBundle);
    hideTitleView();
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    initView();
    f.a(this, getInput(), 6);
    findViewById(2131298365).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71107);
        if (WalletPwdConfirmUI.this.needConfirmFinish())
        {
          WalletPwdConfirmUI.this.hideVKB();
          WalletPwdConfirmUI.this.showDialog(1000);
          AppMethodBeat.o(71107);
          return;
        }
        WalletPwdConfirmUI.this.finish();
        AppMethodBeat.o(71107);
      }
    });
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131100705));
      if (Build.VERSION.SDK_INT >= 23) {
        paramBundle.getDecorView().setSystemUiVisibility(8192);
      }
    }
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(71114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(71117);
    super.onPause();
    com.tencent.mm.sdk.b.a.ESL.d(this.fjL);
    AppMethodBeat.o(71117);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71116);
    this.swk.requestFocus();
    super.onResume();
    com.tencent.mm.sdk.b.a.ESL.c(this.fjL);
    AppMethodBeat.o(71116);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71119);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.swk.getText());
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad)) {
        if (!this.App) {
          een();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71119);
        return true;
        if ((com.tencent.mm.wallet_core.a.bo(this) != null) && (com.tencent.mm.wallet_core.a.bo(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.dcE;; paramString = "")
          {
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.ad(paramString, 22));
            paramString = new xn();
            if (com.tencent.mm.sdk.b.a.ESL.aW(paramString.getClass()))
            {
              this.App = true;
              com.tencent.mm.sdk.b.a.ESL.l(paramString);
            }
            this.Apq.av(10000L, 10000L);
            break;
          }
        }
        com.tencent.mm.wallet_core.a.k(this, getInput());
      }
    }
    AppMethodBeat.o(71119);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */