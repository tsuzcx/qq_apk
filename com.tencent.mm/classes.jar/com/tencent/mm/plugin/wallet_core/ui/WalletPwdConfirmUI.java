package com.tencent.mm.plugin.wallet_core.ui;

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
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adg;
import com.tencent.mm.autogen.a.adh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.utils.m;
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
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(1)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  protected EditHintPasswdView JCc;
  private TextView VRK;
  private boolean VRL;
  private int VRM;
  private boolean VRN;
  private MTimerHandler VRO;
  private IListener lsH;
  private PayInfo mPayInfo;
  private TextView sUt;
  private TextView wzp;
  
  public WalletPwdConfirmUI()
  {
    AppMethodBeat.i(71113);
    this.VRL = false;
    this.VRM = 1;
    this.VRN = false;
    this.VRO = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.lsH = new IListener(f.hfK) {};
    AppMethodBeat.o(71113);
  }
  
  private void ikY()
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
    return a.g.wallet_set_pwd;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71115);
    this.sUt = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.wzp = ((TextView)findViewById(a.f.wallet_pwd_content));
    i.Q(this.sUt);
    if (getProcess() != null) {
      "ModifyPwdProcess".equals(getProcess().fud());
    }
    this.wzp.setText(a.i.wallet_set_password_hint_2);
    this.VRK = ((TextView)findViewById(a.f.input_finish));
    if (!Util.isNullOrNil(getTips(0))) {
      this.VRK.setText(a.i.wallet_set_password_pay_tips);
    }
    for (;;)
    {
      this.VRK.setVisibility(0);
      this.VRK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71108);
          Object localObject1 = new b();
          ((b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
          Object localObject2 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
          String str = WalletPwdConfirmUI.this.JCc.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.getInput().getString("kreq_token");
          localObject1 = WalletPwdConfirmUI.this.getInput().getString("key_verify_code");
          Log.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + (String)localObject1);
          if ((localObject2 != null) && (((String)localObject2).equals(str)))
          {
            localObject2 = new w();
            ((w)localObject2).pRM = WalletPwdConfirmUI.this.JCc.getText();
            ((w)localObject2).Nxi = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((w)localObject2).token = paramAnonymousView;
            ((w)localObject2).VJo = ((String)localObject1);
            ((w)localObject2).VJp = WalletPwdConfirmUI.this.getInput().getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.cm(WalletPwdConfirmUI.this).ill())
            {
              ((w)localObject2).flag = "1";
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.getInput().getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((w)localObject2).VCJ = paramAnonymousView.VFF;
                ((w)localObject2).VCK = paramAnonymousView.VFC;
              }
              WalletPwdConfirmUI.this.getNetController().t(new Object[] { localObject2 });
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletPwdConfirmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71108);
            return;
            ((w)localObject2).flag = "4";
            break;
            com.tencent.mm.wallet_core.a.v(WalletPwdConfirmUI.this, -1002);
          }
        }
      });
      this.VRK.setEnabled(false);
      this.VRK.setClickable(false);
      this.JCc = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.JCc);
      this.JCc.setEditTextMaxLength(6);
      if (this.VRL) {
        this.JCc.setEncrType(this.VRM);
      }
      this.JCc.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71109);
          if (paramAnonymousBoolean)
          {
            String str1 = WalletPwdConfirmUI.this.getInput().getString("key_new_pwd1");
            String str2 = WalletPwdConfirmUI.this.JCc.getMd5Value();
            if ((str1 == null) || (!str1.equals(str2)))
            {
              com.tencent.mm.wallet_core.a.v(WalletPwdConfirmUI.this, -1002);
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
      setEditFocusListener(this.JCc, 0, false);
      showTenpayKB();
      setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
      {
        public final void onVisibleStateChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71110);
          if (paramAnonymousBoolean)
          {
            WalletPwdConfirmUI.a(WalletPwdConfirmUI.this, this.VRQ, WalletPwdConfirmUI.b(WalletPwdConfirmUI.this));
            AppMethodBeat.o(71110);
            return;
          }
          this.VRQ.scrollTo(0, 0);
          AppMethodBeat.o(71110);
        }
      });
      AppMethodBeat.o(71115);
      return;
      this.VRK.setText(a.i.app_finish);
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(301248);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(301248);
      return false;
    }
    AppMethodBeat.o(301248);
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
    paramBundle = getInput();
    if (paramBundle != null)
    {
      this.VRL = paramBundle.getBoolean("isNeedSm2Encrypt", false);
      if (this.VRL)
      {
        this.VRM = paramBundle.getInt("Sm2EncryptType", 1);
        Log.i("Micromsg.WalletPwdConfirmUI", "pwd encrypt type need smc, type:%d", new Object[] { Integer.valueOf(this.VRM) });
      }
    }
    initView();
    m.a(this, getInput(), 6);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(301275);
        if (WalletPwdConfirmUI.this.needConfirmFinish())
        {
          WalletPwdConfirmUI.this.hideVKB();
          WalletPwdConfirmUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(301275);
          return false;
          WalletPwdConfirmUI.this.finish();
        }
      }
    });
    if (i.jPv()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(71114);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(71117);
    super.onPause();
    this.lsH.dead();
    AppMethodBeat.o(71117);
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71116);
    this.JCc.requestFocus();
    super.onResume();
    this.lsH.alive();
    AppMethodBeat.o(71116);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71119);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      getInput().putString("key_pwd1", this.JCc.getText());
      if ((paramp instanceof ae)) {
        if (!this.VRN) {
          ikY();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(71119);
        return true;
        if ((com.tencent.mm.wallet_core.a.cm(this) != null) && (com.tencent.mm.wallet_core.a.cm(this).c(this, null)))
        {
          if (this.mPayInfo != null) {}
          for (paramString = this.mPayInfo.hAT;; paramString = "")
          {
            doSceneForceProgress(new ae(paramString, 22));
            paramString = new adh();
            if (EventCenter.instance.hasListener(paramString.getClass()))
            {
              this.VRN = true;
              paramString.publish();
            }
            this.VRO.startTimer(10000L);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301231);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.g.class);
    AppMethodBeat.o(301231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */