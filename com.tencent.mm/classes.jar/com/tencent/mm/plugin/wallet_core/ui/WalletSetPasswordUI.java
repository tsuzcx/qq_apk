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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  private TextView mPa;
  private TextView pYW;
  protected EditHintPasswdView ykY;
  
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
    AppMethodBeat.i(71235);
    this.mPa = ((TextView)findViewById(2131310286));
    this.pYW = ((TextView)findViewById(2131310281));
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!Util.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!Util.isNullOrNil(getInput().getString("key_true_name")))) {
      this.pYW.setVisibility(4);
    }
    Object localObject;
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().dKC())))
    {
      this.mPa.setText(2131767968);
      if (getInput().getInt("key_err_code", 0) == -1002)
      {
        localObject = (TextView)findViewById(2131302673);
        ((TextView)localObject).setVisibility(0);
        if (!z.aUo()) {
          break label331;
        }
      }
    }
    label331:
    for (String str = getString(2131768327);; str = getString(2131768326))
    {
      ((TextView)localObject).setText(str);
      getInput().putInt("key_err_code", 0);
      this.ykY = ((EditHintPasswdView)findViewById(2131302674));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.ykY);
      findViewById(2131297424).setVisibility(8);
      this.ykY.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71233);
          if (paramAnonymousBoolean)
          {
            String str = WalletSetPasswordUI.this.ykY.getMd5Value();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_new_pwd1", str);
            WalletSetPasswordUI.this.ykY.eIj();
            com.tencent.mm.wallet_core.a.l(WalletSetPasswordUI.this, localBundle);
          }
          AppMethodBeat.o(71233);
        }
      });
      setEditFocusListener(this.ykY, 0, false);
      AppMethodBeat.o(71235);
      return;
      if ((getProcess() == null) || (!"ResetPwdProcessByToken".equals(getProcess().dKC()))) {
        break;
      }
      str = getInput().getString("key_pwd_title");
      localObject = getInput().getString("key_pwd_desc");
      if (!Util.isNullOrNil(str)) {
        this.mPa.setText(str);
      }
      if (Util.isNullOrNil((String)localObject)) {
        break;
      }
      this.pYW.setText((CharSequence)localObject);
      this.pYW.setVisibility(0);
      break;
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(214247);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(214247);
      return false;
    }
    AppMethodBeat.o(214247);
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71234);
    super.onCreate(paramBundle);
    hideTitleView();
    initView();
    f.b(this, getInput(), 5);
    findViewById(2131298771).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71232);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSetPasswordUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      paramBundle.setStatusBarColor(getResources().getColor(2131101424));
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
    this.ykY.requestFocus();
    super.onResume();
    AppMethodBeat.o(71236);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */