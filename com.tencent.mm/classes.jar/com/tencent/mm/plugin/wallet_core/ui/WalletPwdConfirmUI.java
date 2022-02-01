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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aac;
import com.tencent.mm.g.a.aad;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  private TextView IiQ;
  private boolean IiR;
  private MTimerHandler IiS;
  private IListener gmC;
  private TextView mPa;
  private PayInfo mPayInfo;
  private TextView pYW;
  protected EditHintPasswdView ykY;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(71113);
    this.IiR = false;
    this.IiS = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.gmC = new IListener() {};
    AppMethodBeat.o(71113);
  }
  
  private void fTb()
  {
    AppMethodBeat.i(71118);
    Bundle localBundle = getInput();
    localBundle.putBoolean("intent_bind_end", true);
    com.tencent.mm.wallet_core.a.l(this, localBundle);
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
    return 2131497009;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71115);
    this.mPa = ((TextView)findViewById(2131310286));
    this.pYW = ((TextView)findViewById(2131310281));
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().dKC()))) {
      this.mPa.setText(2131767968);
    }
    this.pYW.setText(2131768323);
    this.IiQ = ((TextView)findViewById(2131302676));
    if (!Util.isNullOrNil(getTips(0))) {
      this.IiQ.setText(2131768328);
    }
    for (;;)
    {
      this.IiQ.setVisibility(0);
      this.IiQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71108);
          Object localObject1 = new b();
          ((b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
          Object localObject2 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
          String str = WalletPwdConfirmUI.this.ykY.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
          localObject1 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
          Log.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + (String)localObject1);
          if ((localObject2 != null) && (((String)localObject2).equals(str)))
          {
            localObject2 = new v();
            ((v)localObject2).kdF = WalletPwdConfirmUI.this.ykY.getText();
            ((v)localObject2).BDB = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((v)localObject2).token = paramAnonymousView;
            ((v)localObject2).IaW = ((String)localObject1);
            ((v)localObject2).IaX = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.by(WalletPwdConfirmUI.this).fTp())
            {
              ((v)localObject2).flag = "1";
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((v)localObject2).HUX = paramAnonymousView.HXL;
                ((v)localObject2).HUY = paramAnonymousView.HXI;
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
            com.tencent.mm.wallet_core.a.s(WalletPwdConfirmUI.this, -1002);
          }
        }
      });
      this.IiQ.setEnabled(false);
      this.IiQ.setClickable(false);
      this.ykY = ((EditHintPasswdView)findViewById(2131302674));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
      this.ykY.setEditTextMaxLength(6);
      this.ykY.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71109);
          if (paramAnonymousBoolean)
          {
            String str1 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
            String str2 = WalletPwdConfirmUI.this.ykY.getMd5Value();
            if ((str1 == null) || (!str1.equals(str2)))
            {
              com.tencent.mm.wallet_core.a.s(WalletPwdConfirmUI.this, -1002);
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
      findViewById(2131297424).setVisibility(8);
      setEditFocusListener(this.ykY, 0, false);
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71110);
          if (paramAnonymousBoolean)
          {
            WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, this.IiU, WalletPwdConfirmUI.b(WalletPwdConfirmUI.this));
            AppMethodBeat.o(71110);
            return;
          }
          this.IiU.scrollTo(0, 0);
          AppMethodBeat.o(71110);
        }
      });
      AppMethodBeat.o(71115);
      return;
      this.IiQ.setText(2131755858);
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(214246);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(214246);
      return false;
    }
    AppMethodBeat.o(214246);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71114);
    super.onCreate(paramBundle);
    hideTitleView();
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    initView();
    f.b(this, getInput(), 6);
    findViewById(2131298771).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71107);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      paramBundle.setStatusBarColor(getResources().getColor(2131100898));
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
    EventCenter.instance.removeListener(this.gmC);
    AppMethodBeat.o(71117);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71116);
    this.ykY.requestFocus();
    super.onResume();
    EventCenter.instance.addListener(this.gmC);
    AppMethodBeat.o(71116);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71119);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.ykY.getText());
      if ((paramq instanceof ad)) {
        if (!this.IiR) {
          fTb();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71119);
        return true;
        if ((com.tencent.mm.wallet_core.a.by(this) != null) && (com.tencent.mm.wallet_core.a.by(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.dDL;; paramString = "")
          {
            doSceneForceProgress(new ad(paramString, 22));
            paramString = new aad();
            if (EventCenter.instance.hasListener(paramString.getClass()))
            {
              this.IiR = true;
              EventCenter.instance.publish(paramString);
            }
            this.IiS.startTimer(10000L);
            break;
          }
        }
        com.tencent.mm.wallet_core.a.l(this, getInput());
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