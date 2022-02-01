package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.k;

public class WalletForgotPwdSelectUI
  extends WalletBaseUI
{
  private View VqE;
  private View VqF;
  
  private void igO()
  {
    AppMethodBeat.i(69647);
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
    getInput().putBoolean("key_select_bank_card", true);
    getProcess().a(this, 0, getInput());
    AppMethodBeat.o(69647);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_forgot_pwd_select_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(69648);
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    int i = localIntent.getIntExtra("err_code", 0);
    int j = localIntent.getIntExtra("scene", 0);
    int k = localIntent.getIntExtra("countFace", 0);
    long l = localIntent.getLongExtra("totalTime", 0L);
    int m = localIntent.getIntExtra("err_type", 6);
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(i)));
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(j)));
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(k)));
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(l)));
    Log.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(m)));
    if (paramInt1 == 233) {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
        if ((localIntent != null) && (localIntent.getExtras() != null))
        {
          paramIntent = localIntent.getExtras().getString("token");
          if ((getProcess() != null) && (!Util.isNullOrNil(paramIntent)))
          {
            h.OAn.b(15774, new Object[] { Integer.valueOf(getProcess().hPH.getInt("key_forgot_scene", 1)), Integer.valueOf(4) });
            h.OAn.b(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i) });
          }
          getInput().putString("key_face_action_result_token", paramIntent);
          getInput().putBoolean("key_is_set_pwd_after_face_action", true);
          getProcess().a(this, 0, getInput());
          finish();
          AppMethodBeat.o(69648);
        }
      }
      else if ((localIntent != null) && (localIntent.getExtras() != null))
      {
        paramIntent = localIntent.getExtras().getString("click_other_verify_btn");
        if ((Util.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label702;
        }
      }
    }
    label702:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      Log.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
        if (getProcess() != null)
        {
          h.OAn.b(15774, new Object[] { Integer.valueOf(getProcess().hPH.getInt("key_forgot_scene", 1)), Integer.valueOf(5) });
          h.OAn.b(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i) });
        }
        igO();
      }
      if (paramInt2 == 0)
      {
        Log.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
        if (getProcess() != null)
        {
          h.OAn.b(15774, new Object[] { Integer.valueOf(getProcess().hPH.getInt("key_forgot_scene", 1)), Integer.valueOf(6) });
          h.OAn.b(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
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
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    setMMTitleVisibility(8);
    this.VqE = findViewById(a.f.face_check_entry);
    this.VqF = findViewById(a.f.bankcard_entry);
    this.VqE.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315644);
        WalletForgotPwdSelectUI.a(WalletForgotPwdSelectUI.this);
        AppMethodBeat.o(315644);
      }
    });
    this.VqF.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(315645);
        if (WalletForgotPwdSelectUI.this.getProcess() != null) {
          h.OAn.b(15774, new Object[] { Integer.valueOf(WalletForgotPwdSelectUI.this.getProcess().hPH.getInt("key_forgot_scene", 1)), Integer.valueOf(3) });
        }
        WalletForgotPwdSelectUI.b(WalletForgotPwdSelectUI.this);
        AppMethodBeat.o(315645);
      }
    });
    AppMethodBeat.o(69646);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI
 * JD-Core Version:    0.7.0.1
 */