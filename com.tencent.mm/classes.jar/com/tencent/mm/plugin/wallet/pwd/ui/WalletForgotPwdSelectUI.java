package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletForgotPwdSelectUI
  extends WalletBaseUI
{
  private View BlF;
  private View BlG;
  
  private void eql()
  {
    AppMethodBeat.i(69647);
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
    getInput().putBoolean("key_select_bank_card", true);
    getProcess().a(this, 0, getInput());
    AppMethodBeat.o(69647);
  }
  
  public int getLayoutId()
  {
    return 2131495951;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69648);
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    int i = paramIntent.getIntExtra("err_code", 0);
    int j = paramIntent.getIntExtra("scene", 0);
    int k = paramIntent.getIntExtra("countFace", 0);
    long l = paramIntent.getLongExtra("totalTime", 0L);
    int m = paramIntent.getIntExtra("err_type", 6);
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(i)));
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(j)));
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(k)));
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(l)));
    ac.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(m)));
    if (paramInt1 == 233) {
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
        if ((paramIntent != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          if ((getProcess() != null) && (!bs.isNullOrNil(paramIntent)))
          {
            h.wUl.f(15774, new Object[] { Integer.valueOf(getProcess().dmf.getInt("key_forgot_scene", 1)), Integer.valueOf(4) });
            h.wUl.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i) });
          }
          getInput().putString("key_face_action_result_token", paramIntent);
          getInput().putBoolean("key_is_set_pwd_after_face_action", true);
          getProcess().a(this, 0, getInput());
          finish();
          AppMethodBeat.o(69648);
        }
      }
      else if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((bs.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label675;
        }
      }
    }
    label675:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ac.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
      if (paramInt1 != 0)
      {
        ac.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
        if (getProcess() != null)
        {
          h.wUl.f(15774, new Object[] { Integer.valueOf(getProcess().dmf.getInt("key_forgot_scene", 1)), Integer.valueOf(5) });
          h.wUl.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i) });
        }
        eql();
      }
      if (paramInt2 == 0)
      {
        ac.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
        if (getProcess() != null)
        {
          h.wUl.f(15774, new Object[] { Integer.valueOf(getProcess().dmf.getInt("key_forgot_scene", 1)), Integer.valueOf(6) });
          h.wUl.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
        }
      }
      AppMethodBeat.o(69648);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69646);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.BlF = findViewById(2131299662);
    this.BlG = findViewById(2131297156);
    this.BlF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69644);
        WalletForgotPwdSelectUI.a(WalletForgotPwdSelectUI.this);
        AppMethodBeat.o(69644);
      }
    });
    this.BlG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69645);
        if (WalletForgotPwdSelectUI.this.getProcess() != null) {
          h.wUl.f(15774, new Object[] { Integer.valueOf(WalletForgotPwdSelectUI.this.getProcess().dmf.getInt("key_forgot_scene", 1)), Integer.valueOf(3) });
        }
        WalletForgotPwdSelectUI.b(WalletForgotPwdSelectUI.this);
        AppMethodBeat.o(69645);
      }
    });
    AppMethodBeat.o(69646);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI
 * JD-Core Version:    0.7.0.1
 */