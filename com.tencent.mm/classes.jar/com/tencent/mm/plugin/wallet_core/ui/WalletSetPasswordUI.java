package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(19)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  private TextView iJG;
  private TextView ksU;
  protected EditHintPasswdView nID;
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971252;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47667);
    this.iJG = ((TextView)findViewById(2131825031));
    this.ksU = ((TextView)findViewById(2131829086));
    if ((getInput().getBoolean("key_is_forgot_process", false)) && (!bo.isNullOrNil(getInput().getString("key_identity"))) && (getInput().getInt("key_id_type", -1) != -1) && (!bo.isNullOrNil(getInput().getString("key_true_name")))) {
      this.ksU.setVisibility(4);
    }
    if ((getProcess() != null) && ("ModifyPwdProcess".equals(getProcess().bzC()))) {
      this.iJG.setText(2131305305);
    }
    TextView localTextView;
    if (getInput().getInt("key_err_code", 0) == -1002)
    {
      localTextView = (TextView)findViewById(2131829398);
      localTextView.setVisibility(0);
      if (!r.ZB()) {
        break label248;
      }
    }
    label248:
    for (String str = getString(2131305655);; str = getString(2131305654))
    {
      localTextView.setText(str);
      getInput().putInt("key_err_code", 0);
      this.nID = ((EditHintPasswdView)findViewById(2131825034));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.nID);
      findViewById(2131826700).setVisibility(8);
      this.nID.setOnInputValidListener(new WalletSetPasswordUI.2(this));
      setEditFocusListener(this.nID, 0, false);
      AppMethodBeat.o(47667);
      return;
    }
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47666);
    super.onCreate(paramBundle);
    hideTitleView();
    initView();
    d.a(this, getInput(), 5);
    findViewById(2131829085).setOnClickListener(new WalletSetPasswordUI.1(this));
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(2131690316));
      if (Build.VERSION.SDK_INT >= 23) {
        paramBundle.getDecorView().setSystemUiVisibility(8192);
      }
    }
    getContentView().setFitsSystemWindows(true);
    AppMethodBeat.o(47666);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47668);
    this.nID.requestFocus();
    super.onResume();
    AppMethodBeat.o(47668);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
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