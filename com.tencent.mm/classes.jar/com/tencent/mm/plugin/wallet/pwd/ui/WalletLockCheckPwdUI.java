package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletLockCheckPwdUI
  extends WalletBaseUI
{
  private String Dx;
  private TextView iJG;
  private TextView ksU;
  private u tSm;
  private EditHintPasswdView tZD;
  private int tZE = -1;
  
  private void E(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(46345);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_token", paramString1);
    localIntent.putExtra("key_type", paramString2);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(46345);
  }
  
  private void Ir(int paramInt)
  {
    AppMethodBeat.i(46344);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(46344);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(46343);
    super.cleanUiData(paramInt);
    this.tZD.cfK();
    AppMethodBeat.o(46343);
  }
  
  public int getLayoutId()
  {
    return 2130971163;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(46347);
    if (paramIntent == null) {}
    for (;;)
    {
      ab.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(46347);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(46342);
    ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
    Ir(4);
    AppMethodBeat.o(46342);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46340);
    super.onCreate(paramBundle);
    hideTitleView();
    this.tZE = getIntent().getIntExtra("key_wallet_lock_type", -1);
    this.Dx = getIntent().getStringExtra("action");
    ab.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[] { Integer.valueOf(this.tZE), this.Dx });
    this.tZD = ((EditHintPasswdView)findViewById(2131825034));
    this.iJG = ((TextView)findViewById(2131825031));
    this.ksU = ((TextView)findViewById(2131829086));
    paramBundle = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
    if (this.tZE == 2)
    {
      this.iJG.setText(2131305770);
      if ((this.Dx.equals("action.touchlock_need_verify_paypwd")) && (!bo.isNullOrNil(paramBundle))) {
        this.ksU.setText(paramBundle);
      }
    }
    for (;;)
    {
      this.tZD.setOnInputValidListener(new WalletLockCheckPwdUI.3(this));
      setEditFocusListener(this.tZD, 0, false);
      setBackBtn(new WalletLockCheckPwdUI.1(this));
      findViewById(2131829085).setOnClickListener(new WalletLockCheckPwdUI.2(this));
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(getResources().getColor(2131690709));
        if (Build.VERSION.SDK_INT >= 23) {
          paramBundle.getDecorView().setSystemUiVisibility(8192);
        }
      }
      getContentView().setFitsSystemWindows(true);
      AppMethodBeat.o(46340);
      return;
      if (this.tZE == 1) {
        this.iJG.setText(2131305771);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(46341);
    super.onResume();
    if (this.tZD != null) {
      this.tZD.cfK();
    }
    AppMethodBeat.o(46341);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46346);
    ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof u))
    {
      paramm = (u)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action")))
        {
          ab.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
          paramString = new Intent();
          paramString.putExtra("action", "action.switch_on_pattern");
          paramString.putExtra("next_action", "next_action.switch_on_pattern");
          paramString.putExtra("token", paramm.token);
          paramString.putExtra("type", paramm.ubN);
          paramString.putExtra("key_wallet_lock_type", this.tZE);
          paramString.setPackage(ah.getPackageName());
          if (this.tZE == 2) {
            paramString.putExtra("key_pay_passwd", this.tZD.getText());
          }
          paramm = new ss();
          paramm.cJn.cJp = paramString;
          paramm.cJn.cup = this;
          paramm.cJn.requestCode = 1;
          a.ymk.l(paramm);
        }
        for (;;)
        {
          AppMethodBeat.o(46346);
          return true;
          E(0, paramm.token, paramm.ubN);
        }
      }
      if ((paramInt1 == 1000) && (paramInt2 == 3))
      {
        E(-1, null, null);
        AppMethodBeat.o(46346);
        return true;
      }
    }
    else
    {
      if ((paramm instanceof q))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          Ir(0);
        }
        for (;;)
        {
          AppMethodBeat.o(46346);
          return true;
          Ir(-1);
        }
      }
      if ((paramm instanceof e))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label347;
        }
        Ir(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46346);
      return false;
      label347:
      Ir(-1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */