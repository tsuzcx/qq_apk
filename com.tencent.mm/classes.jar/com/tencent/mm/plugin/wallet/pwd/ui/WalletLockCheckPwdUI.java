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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.s;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletLockCheckPwdUI
  extends WalletBaseUI
{
  private w HCq;
  private EditHintPasswdView HKf;
  private int HKg = -1;
  private String Nl;
  private TextView mPa;
  private TextView pYW;
  
  private void P(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(69721);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    localIntent.putExtra("key_token", paramString1);
    localIntent.putExtra("key_type", paramString2);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(69721);
  }
  
  private void aeC(int paramInt)
  {
    AppMethodBeat.i(69720);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_err_code", paramInt);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(69720);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(69719);
    super.cleanUiData(paramInt);
    this.HKf.eIj();
    AppMethodBeat.o(69719);
  }
  
  public int getLayoutId()
  {
    return 2131496917;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(69723);
    if (paramIntent == null) {}
    for (;;)
    {
      Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      setResult(paramInt2, paramIntent);
      finish();
      AppMethodBeat.o(69723);
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(69718);
    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
    aeC(4);
    AppMethodBeat.o(69718);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69716);
    super.onCreate(paramBundle);
    hideTitleView();
    this.HKg = getIntent().getIntExtra("key_wallet_lock_type", -1);
    this.Nl = getIntent().getStringExtra("action");
    Log.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[] { Integer.valueOf(this.HKg), this.Nl });
    this.HKf = ((EditHintPasswdView)findViewById(2131302674));
    this.mPa = ((TextView)findViewById(2131310286));
    this.pYW = ((TextView)findViewById(2131310281));
    paramBundle = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
    if (this.HKg == 2)
    {
      this.mPa.setText(2131768443);
      if ((this.Nl.equals("action.touchlock_need_verify_paypwd")) && (!Util.isNullOrNil(paramBundle))) {
        this.pYW.setText(paramBundle);
      }
    }
    for (;;)
    {
      this.HKf.setOnInputValidListener(new EditHintPasswdView.a()
      {
        public final void onInputValidChange(boolean paramAnonymousBoolean)
        {
          int i = 8;
          AppMethodBeat.i(69715);
          if (paramAnonymousBoolean)
          {
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this) == null)
            {
              AppMethodBeat.o(69715);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.close_wallet_lock"))
            {
              WalletLockCheckPwdUI.c(WalletLockCheckPwdUI.this);
              AppMethodBeat.o(69715);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.verify_paypwd"))
            {
              if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) == 1) {
                i = 6;
              }
              for (;;)
              {
                WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this, new w(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText(), i, WalletLockCheckPwdUI.this.getPayReqKey()));
                WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.f(WalletLockCheckPwdUI.this));
                AppMethodBeat.o(69715);
                return;
                if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) != 2) {
                  i = -1;
                }
              }
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.touchlock_verify_by_paypwd"))
            {
              s locals = new s(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText());
              WalletLockCheckPwdUI.this.doSceneForceProgress(locals);
              AppMethodBeat.o(69715);
              return;
            }
            if (WalletLockCheckPwdUI.b(WalletLockCheckPwdUI.this).equals("action.touchlock_need_verify_paypwd")) {
              if (WalletLockCheckPwdUI.d(WalletLockCheckPwdUI.this) != 2) {
                break label280;
              }
            }
          }
          for (;;)
          {
            WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this, new w(WalletLockCheckPwdUI.e(WalletLockCheckPwdUI.this).getText(), i, WalletLockCheckPwdUI.this.getPayReqKey()));
            WalletLockCheckPwdUI.this.doSceneForceProgress(WalletLockCheckPwdUI.f(WalletLockCheckPwdUI.this));
            AppMethodBeat.o(69715);
            return;
            label280:
            i = -1;
          }
        }
      });
      setEditFocusListener(this.HKf, 0, false);
      this.HKf.hhY();
      setBackBtn(new WalletLockCheckPwdUI.1(this));
      findViewById(2131298771).setOnClickListener(new WalletLockCheckPwdUI.2(this));
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
      AppMethodBeat.o(69716);
      return;
      if (this.HKg == 1) {
        this.mPa.setText(2131768444);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(69717);
    super.onResume();
    if (this.HKf != null) {
      this.HKf.eIj();
    }
    AppMethodBeat.o(69717);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69722);
    Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof w))
    {
      paramq = (w)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action")))
        {
          Log.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
          paramString = new Intent();
          paramString.putExtra("action", "action.switch_on_pattern");
          paramString.putExtra("next_action", "next_action.switch_on_pattern");
          paramString.putExtra("token", paramq.token);
          paramString.putExtra("type", paramq.HPZ);
          paramString.putExtra("key_wallet_lock_type", this.HKg);
          paramString.setPackage(MMApplicationContext.getPackageName());
          if (this.HKg == 2) {
            paramString.putExtra("key_pay_passwd", this.HKf.getText());
          }
          paramq = new ww();
          paramq.edk.edm = paramString;
          paramq.edk.dKq = this;
          paramq.edk.requestCode = 1;
          EventCenter.instance.publish(paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          P(0, paramq.token, paramq.HPZ);
        }
      }
      if ((paramInt1 == 1000) && (paramInt2 == 3))
      {
        P(-1, null, null);
        AppMethodBeat.o(69722);
        return true;
      }
    }
    else
    {
      if ((paramq instanceof s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          aeC(0);
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          aeC(-1);
        }
      }
      if ((paramq instanceof e))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label347;
        }
        aeC(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(69722);
      return false;
      label347:
      aeC(-1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */