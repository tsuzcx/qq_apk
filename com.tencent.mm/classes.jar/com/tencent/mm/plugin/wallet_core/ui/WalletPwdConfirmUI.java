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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.yx;
import com.tencent.mm.g.a.yy;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  private TextView DzE;
  private boolean DzF;
  private aw DzG;
  private c fHr;
  private TextView lHk;
  private PayInfo mPayInfo;
  private TextView oLi;
  protected EditHintPasswdView uSv;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(71113);
    this.DzF = false;
    this.DzG = new aw(new aw.a()
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
    this.fHr = new c() {};
    AppMethodBeat.o(71113);
  }
  
  private void eLw()
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
    this.lHk = ((TextView)findViewById(2131306825));
    this.oLi = ((TextView)findViewById(2131306820));
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().cSH()))) {
      this.lHk.setText(2131765519);
    }
    this.oLi.setText(2131765870);
    this.DzE = ((TextView)findViewById(2131301028));
    if (!bu.ah(getTips(0))) {
      this.DzE.setText(2131765875);
    }
    for (;;)
    {
      this.DzE.setVisibility(0);
      this.DzE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71108);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahF());
          Object localObject2 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
          String str = WalletPwdConfirmUI.this.uSv.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
          localObject1 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
          ae.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + (String)localObject1);
          if ((localObject2 != null) && (((String)localObject2).equals(str)))
          {
            localObject2 = new v();
            ((v)localObject2).jfC = WalletPwdConfirmUI.this.uSv.getText();
            ((v)localObject2).xDC = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((v)localObject2).token = paramAnonymousView;
            ((v)localObject2).DrK = ((String)localObject1);
            ((v)localObject2).DrL = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.bs(WalletPwdConfirmUI.this).eLI())
            {
              ((v)localObject2).flag = "1";
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((v)localObject2).DlE = paramAnonymousView.Dot;
                ((v)localObject2).DlF = paramAnonymousView.Doq;
              }
              WalletPwdConfirmUI.this.getNetController().r(new Object[] { localObject2 });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71108);
            return;
            ((v)localObject2).flag = "4";
            break;
            com.tencent.mm.wallet_core.a.t(WalletPwdConfirmUI.this, -1002);
          }
        }
      });
      this.DzE.setEnabled(false);
      this.DzE.setClickable(false);
      this.uSv = ((EditHintPasswdView)findViewById(2131301026));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.uSv);
      this.uSv.setEditTextMaxLength(6);
      this.uSv.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71109);
          if (paramAnonymousBoolean)
          {
            String str1 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
            String str2 = WalletPwdConfirmUI.this.uSv.getMd5Value();
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
      setEditFocusListener(this.uSv, 0, false);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71110);
          if (paramAnonymousBoolean)
          {
            WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, this.DzI, WalletPwdConfirmUI.b(WalletPwdConfirmUI.this));
            AppMethodBeat.o(71110);
            return;
          }
          this.DzI.scrollTo(0, 0);
          AppMethodBeat.o(71110);
        }
      });
      AppMethodBeat.o(71115);
      return;
      this.DzE.setText(2131755779);
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(190228);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(190228);
      return false;
    }
    AppMethodBeat.o(190228);
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
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletPwdConfirmUI.this.needConfirmFinish())
        {
          WalletPwdConfirmUI.this.hideVKB();
          WalletPwdConfirmUI.this.showDialog(1000);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71107);
          return;
          WalletPwdConfirmUI.this.finish();
        }
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
    com.tencent.mm.sdk.b.a.IvT.d(this.fHr);
    AppMethodBeat.o(71117);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71116);
    this.uSv.requestFocus();
    super.onResume();
    com.tencent.mm.sdk.b.a.IvT.c(this.fHr);
    AppMethodBeat.o(71116);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71119);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.uSv.getText());
      if ((paramn instanceof ad)) {
        if (!this.DzF) {
          eLw();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71119);
        return true;
        if ((com.tencent.mm.wallet_core.a.bs(this) != null) && (com.tencent.mm.wallet_core.a.bs(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.dmw;; paramString = "")
          {
            doSceneForceProgress(new ad(paramString, 22));
            paramString = new yy();
            if (com.tencent.mm.sdk.b.a.IvT.aZ(paramString.getClass()))
            {
              this.DzF = true;
              com.tencent.mm.sdk.b.a.IvT.l(paramString);
            }
            this.DzG.ay(10000L, 10000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */