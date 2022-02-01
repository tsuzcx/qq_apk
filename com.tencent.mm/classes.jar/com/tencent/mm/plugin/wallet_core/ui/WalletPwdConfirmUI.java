package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.abj;
import com.tencent.mm.f.a.abk;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.utils.j;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(1)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  protected EditHintPasswdView DLa;
  private TextView Pbg;
  private boolean Pbh;
  private MTimerHandler Pbi;
  private IListener iQL;
  private PayInfo mPayInfo;
  private TextView pPT;
  private TextView tuS;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(71113);
    this.Pbh = false;
    this.Pbi = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.iQL = new IListener() {};
    AppMethodBeat.o(71113);
  }
  
  private void gLH()
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
    return a.g.wallet_set_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71115);
    this.pPT = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.tuS = ((TextView)findViewById(a.f.wallet_pwd_content));
    com.tencent.mm.wallet_core.ui.g.N(this.pPT);
    if (getProcess() != null) {
      "ModifyPwdProcess".equals(getProcess().epb());
    }
    this.tuS.setText(a.i.wallet_set_password_hint_2);
    this.Pbg = ((TextView)findViewById(a.f.input_finish));
    if (!Util.isNullOrNil(getTips(0))) {
      this.Pbg.setText(a.i.wallet_set_password_pay_tips);
    }
    for (;;)
    {
      this.Pbg.setVisibility(0);
      this.Pbg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71108);
          Object localObject1 = new b();
          ((b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
          Object localObject2 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
          String str = WalletPwdConfirmUI.this.DLa.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
          localObject1 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
          Log.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + (String)localObject1);
          if ((localObject2 != null) && (((String)localObject2).equals(str)))
          {
            localObject2 = new w();
            ((w)localObject2).mVf = WalletPwdConfirmUI.this.DLa.getText();
            ((w)localObject2).HzF = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((w)localObject2).token = paramAnonymousView;
            ((w)localObject2).OTh = ((String)localObject1);
            ((w)localObject2).OTi = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.bF(WalletPwdConfirmUI.this).gLV())
            {
              ((w)localObject2).flag = "1";
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((w)localObject2).OMY = paramAnonymousView.OPL;
                ((w)localObject2).OMZ = paramAnonymousView.OPI;
              }
              WalletPwdConfirmUI.this.getNetController().r(new Object[] { localObject2 });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71108);
            return;
            ((w)localObject2).flag = "4";
            break;
            com.tencent.mm.wallet_core.a.t(WalletPwdConfirmUI.this, -1002);
          }
        }
      });
      this.Pbg.setEnabled(false);
      this.Pbg.setClickable(false);
      this.DLa = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.DLa);
      this.DLa.setEditTextMaxLength(6);
      this.DLa.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71109);
          if (paramAnonymousBoolean)
          {
            String str1 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
            String str2 = WalletPwdConfirmUI.this.DLa.getMd5Value();
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
      findViewById(a.f.bind_wallet_verify_hint).setVisibility(8);
      hideKeyboardPushDownBtn();
      setEditFocusListener(this.DLa, 0, false);
      showTenpayKB();
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71110);
          if (paramAnonymousBoolean)
          {
            WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, this.Pbk, WalletPwdConfirmUI.b(WalletPwdConfirmUI.this));
            AppMethodBeat.o(71110);
            return;
          }
          this.Pbk.scrollTo(0, 0);
          AppMethodBeat.o(71110);
        }
      });
      AppMethodBeat.o(71115);
      return;
      this.Pbg.setText(a.i.app_finish);
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(258123);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(258123);
      return false;
    }
    AppMethodBeat.o(258123);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71114);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitle("");
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    initView();
    j.a(this, getInput(), 6);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(267823);
        if (WalletPwdConfirmUI.this.needConfirmFinish())
        {
          WalletPwdConfirmUI.this.hideVKB();
          WalletPwdConfirmUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(267823);
          return false;
          WalletPwdConfirmUI.this.finish();
        }
      }
    });
    if (com.tencent.mm.wallet_core.ui.g.ijx()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(71114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(71117);
    super.onPause();
    EventCenter.instance.removeListener(this.iQL);
    AppMethodBeat.o(71117);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71116);
    this.DLa.requestFocus();
    super.onResume();
    EventCenter.instance.addListener(this.iQL);
    AppMethodBeat.o(71116);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71119);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.DLa.getText());
      if ((paramq instanceof ae)) {
        if (!this.Pbh) {
          gLH();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71119);
        return true;
        if ((com.tencent.mm.wallet_core.a.bF(this) != null) && (com.tencent.mm.wallet_core.a.bF(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.fwv;; paramString = "")
          {
            doSceneForceProgress(new ae(paramString, 22));
            paramString = new abk();
            if (EventCenter.instance.hasListener(paramString.getClass()))
            {
              this.Pbh = true;
              EventCenter.instance.publish(paramString);
            }
            this.Pbi.startTimer(10000L);
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