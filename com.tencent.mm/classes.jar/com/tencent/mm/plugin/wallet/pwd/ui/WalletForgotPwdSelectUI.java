package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletForgotPwdSelectUI
  extends WalletBaseUI
{
  private View DdC;
  private View DdD;
  
  private void eHS()
  {
    AppMethodBeat.i(69647);
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "goToBankcard");
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
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "onActivityResult, requestCode: %s, resultCode: %s, data: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    int i = localIntent.getIntExtra("err_code", 0);
    int j = localIntent.getIntExtra("scene", 0);
    int k = localIntent.getIntExtra("countFace", 0);
    long l = localIntent.getLongExtra("totalTime", 0L);
    int m = localIntent.getIntExtra("err_type", 6);
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "errCode： ".concat(String.valueOf(i)));
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "scene： ".concat(String.valueOf(j)));
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "countFace： ".concat(String.valueOf(k)));
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "totalTime： ".concat(String.valueOf(l)));
    ae.i("MicroMsg.WalletForgotPwdSelectUI", "errorType： ".concat(String.valueOf(m)));
    if (paramInt1 == 233) {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_OK");
        if ((localIntent != null) && (localIntent.getExtras() != null))
        {
          paramIntent = localIntent.getExtras().getString("token");
          if ((getProcess() != null) && (!bu.isNullOrNil(paramIntent)))
          {
            g.yxI.f(15774, new Object[] { Integer.valueOf(getProcess().dyY.getInt("key_forgot_scene", 1)), Integer.valueOf(4) });
            g.yxI.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i) });
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
        if ((bu.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label702;
        }
      }
    }
    label702:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ae.i("MicroMsg.WalletForgotPwdSelectUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
      if (paramInt1 != 0)
      {
        ae.i("MicroMsg.WalletForgotPwdSelectUI", "check face failed, click other verify");
        if (getProcess() != null)
        {
          g.yxI.f(15774, new Object[] { Integer.valueOf(getProcess().dyY.getInt("key_forgot_scene", 1)), Integer.valueOf(5) });
          g.yxI.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(3), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(m), Integer.valueOf(i) });
        }
        eHS();
      }
      if (paramInt2 == 0)
      {
        ae.i("MicroMsg.WalletForgotPwdSelectUI", "resultCode：RESULT_CANCELED");
        if (getProcess() != null)
        {
          g.yxI.f(15774, new Object[] { Integer.valueOf(getProcess().dyY.getInt("key_forgot_scene", 1)), Integer.valueOf(6) });
          g.yxI.f(15711, new Object[] { Integer.valueOf(j), Integer.valueOf(2), Integer.valueOf(k), Long.valueOf(l), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i) });
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
    this.DdC = findViewById(2131299662);
    this.DdD = findViewById(2131297156);
    this.DdC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69644);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletForgotPwdSelectUI.a(WalletForgotPwdSelectUI.this);
        a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(69644);
      }
    });
    this.DdD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(69645);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletForgotPwdSelectUI.this.getProcess() != null) {
          g.yxI.f(15774, new Object[] { Integer.valueOf(WalletForgotPwdSelectUI.this.getProcess().dyY.getInt("key_forgot_scene", 1)), Integer.valueOf(3) });
        }
        WalletForgotPwdSelectUI.b(WalletForgotPwdSelectUI.this);
        a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletForgotPwdSelectUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI
 * JD-Core Version:    0.7.0.1
 */