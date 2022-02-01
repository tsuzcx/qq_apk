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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

@com.tencent.mm.ui.base.a(19)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  private TextView lfN;
  private TextView obn;
  protected EditHintPasswdView tDZ;
  
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
    this.lfN = ((TextView)findViewById(2131306825));
    this.obn = ((TextView)findViewById(2131306820));
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!bs.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bs.isNullOrNil(getInput().getString("key_true_name")))) {
      this.obn.setVisibility(4);
    }
    Object localObject;
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().cHN())))
    {
      this.lfN.setText(2131765519);
      if (getInput().getInt("key_err_code", 0) == -1002)
      {
        localObject = (TextView)findViewById(2131301025);
        ((TextView)localObject).setVisibility(0);
        if (!u.axL()) {
          break label331;
        }
      }
    }
    label331:
    for (String str = getString(2131765874);; str = getString(2131765873))
    {
      ((TextView)localObject).setText(str);
      getInput().putInt("key_err_code", 0);
      this.tDZ = ((EditHintPasswdView)findViewById(2131301026));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.tDZ);
      findViewById(2131297268).setVisibility(8);
      this.tDZ.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(71233);
          if (paramAnonymousBoolean)
          {
            String str = WalletSetPasswordUI.this.tDZ.getMd5Value();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_new_pwd1", str);
            WalletSetPasswordUI.this.tDZ.dtH();
            com.tencent.mm.wallet_core.a.k(WalletSetPasswordUI.this, localBundle);
          }
          AppMethodBeat.o(71233);
        }
      });
      setEditFocusListener(this.tDZ, 0, false);
      AppMethodBeat.o(71235);
      return;
      if ((getProcess() == null) || (!"ResetPwdProcessByToken".equals(getProcess().cHN()))) {
        break;
      }
      str = getInput().getString("key_pwd_title");
      localObject = getInput().getString("key_pwd_desc");
      if (!bs.isNullOrNil(str)) {
        this.lfN.setText(str);
      }
      if (bs.isNullOrNil((String)localObject)) {
        break;
      }
      this.obn.setText((CharSequence)localObject);
      this.obn.setVisibility(0);
      break;
    }
  }
  
  public boolean needConfirmFinish()
  {
    AppMethodBeat.i(207307);
    if ((getProcess() instanceof com.tencent.mm.plugin.wallet_core.id_verify.a))
    {
      AppMethodBeat.o(207307);
      return false;
    }
    AppMethodBeat.o(207307);
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
        if (WalletSetPasswordUI.this.needConfirmFinish())
        {
          WalletSetPasswordUI.this.hideVKB();
          WalletSetPasswordUI.this.showDialog(1000);
          AppMethodBeat.o(71232);
          return;
        }
        WalletSetPasswordUI.this.finish();
        AppMethodBeat.o(71232);
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
    this.tDZ.requestFocus();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */