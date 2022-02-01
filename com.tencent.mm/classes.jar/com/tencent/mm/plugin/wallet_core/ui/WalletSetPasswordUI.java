package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  private TextView lHk;
  private TextView oLi;
  protected EditHintPasswdView uSv;
  
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
    AppMethodBeat.i(71235);
    this.lHk = ((TextView)findViewById(2131306825));
    this.oLi = ((TextView)findViewById(2131306820));
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!bu.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bu.isNullOrNil(getInput().getString("key_true_name")))) {
      this.oLi.setVisibility(4);
    }
    Object localObject;
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().cSH())))
    {
      this.lHk.setText(2131765519);
      if (getInput().getInt("key_err_code", 0) == -1002)
      {
        localObject = (TextView)findViewById(2131301025);
        ((TextView)localObject).setVisibility(0);
        if (!v.aAR()) {
          break label331;
        }
      }
    }
    label331:
    for (String str = getString(2131765874);; str = getString(2131765873))
    {
      ((TextView)localObject).setText(str);
      getInput().putInt("key_err_code", 0);
      this.uSv = ((EditHintPasswdView)findViewById(2131301026));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.uSv);
      findViewById(2131297268).setVisibility(8);
      this.uSv.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71233);
          if (paramAnonymousBoolean)
          {
            String str = WalletSetPasswordUI.this.uSv.getMd5Value();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_new_pwd1", str);
            WalletSetPasswordUI.this.uSv.dHv();
            com.tencent.mm.wallet_core.a.k(WalletSetPasswordUI.this, localBundle);
          }
          AppMethodBeat.o(71233);
        }
      });
      setEditFocusListener(this.uSv, 0, false);
      AppMethodBeat.o(71235);
      return;
      if ((getProcess() == null) || (!"ResetPwdProcessByToken".equals(getProcess().cSH()))) {
        break;
      }
      str = getInput().getString("key_pwd_title");
      localObject = getInput().getString("key_pwd_desc");
      if (!bu.isNullOrNil(str)) {
        this.lHk.setText(str);
      }
      if (bu.isNullOrNil((String)localObject)) {
        break;
      }
      this.oLi.setText((CharSequence)localObject);
      this.oLi.setVisibility(0);
      break;
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(190229);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(190229);
      return false;
    }
    AppMethodBeat.o(190229);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71234);
    super.onCreate(paramBundle);
    hideTitleView();
    initView();
    f.a(this, getInput(), 5);
    findViewById(2131298365).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71232);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletSetPasswordUI.this.needConfirmFinish())
        {
          WalletSetPasswordUI.this.hideVKB();
          WalletSetPasswordUI.this.showDialog(1000);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71232);
          return;
          WalletSetPasswordUI.this.finish();
        }
      }
    });
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131101179));
      if (Build.VERSION.SDK_INT >= 23) {
        paramBundle.getDecorView().setSystemUiVisibility(8192);
      }
    }
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(71234);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71236);
    this.uSv.requestFocus();
    super.onResume();
    AppMethodBeat.o(71236);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */