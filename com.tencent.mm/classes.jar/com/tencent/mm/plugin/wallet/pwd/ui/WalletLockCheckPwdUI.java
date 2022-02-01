package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.a.s;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletLockCheckPwdUI
  extends WalletBaseUI
{
  private w CWK;
  private EditHintPasswdView Del;
  private int Dem = -1;
  private String Nb;
  private TextView lHk;
  private TextView oLi;
  
  private void M(int paramInt, String paramString1, String paramString2)
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
  
  private void Wa(int paramInt)
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
    this.Del.dHv();
    AppMethodBeat.o(69719);
  }
  
  public int getLayoutId()
  {
    return 2131495937;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    AppMethodBeat.i(69723);
    if (paramIntent == null) {}
    for (;;)
    {
      ae.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
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
    ae.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
    Wa(4);
    AppMethodBeat.o(69718);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69716);
    super.onCreate(paramBundle);
    hideTitleView();
    this.Dem = getIntent().getIntExtra("key_wallet_lock_type", -1);
    this.Nb = getIntent().getStringExtra("action");
    ae.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", new Object[] { Integer.valueOf(this.Dem), this.Nb });
    this.Del = ((EditHintPasswdView)findViewById(2131301026));
    this.lHk = ((TextView)findViewById(2131306825));
    this.oLi = ((TextView)findViewById(2131306820));
    paramBundle = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
    if (this.Dem == 2)
    {
      this.lHk.setText(2131765990);
      if ((this.Nb.equals("action.touchlock_need_verify_paypwd")) && (!bu.isNullOrNil(paramBundle))) {
        this.oLi.setText(paramBundle);
      }
    }
    for (;;)
    {
      this.Del.setOnInputValidListener(new EditHintPasswdView.a()
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
      setEditFocusListener(this.Del, 0, false);
      this.Del.fWA();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69713);
          ae.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
          WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
          AppMethodBeat.o(69713);
          return true;
        }
      });
      findViewById(2131298365).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(69714);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
          WalletLockCheckPwdUI.a(WalletLockCheckPwdUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletLockCheckPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(69714);
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
      AppMethodBeat.o(69716);
      return;
      if (this.Dem == 1) {
        this.lHk.setText(2131765991);
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
    if (this.Del != null) {
      this.Del.dHv();
    }
    AppMethodBeat.o(69717);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69722);
    ae.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof w))
    {
      paramn = (w)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action")))
        {
          ae.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
          paramString = new Intent();
          paramString.putExtra("action", "action.switch_on_pattern");
          paramString.putExtra("next_action", "next_action.switch_on_pattern");
          paramString.putExtra("token", paramn.token);
          paramString.putExtra("type", paramn.DgG);
          paramString.putExtra("key_wallet_lock_type", this.Dem);
          paramString.setPackage(ak.getPackageName());
          if (this.Dem == 2) {
            paramString.putExtra("key_pay_passwd", this.Del.getText());
          }
          paramn = new vw();
          paramn.dLv.dLx = paramString;
          paramn.dLv.dtg = this;
          paramn.dLv.requestCode = 1;
          com.tencent.mm.sdk.b.a.IvT.l(paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          M(0, paramn.token, paramn.DgG);
        }
      }
      if ((paramInt1 == 1000) && (paramInt2 == 3))
      {
        M(-1, null, null);
        AppMethodBeat.o(69722);
        return true;
      }
    }
    else
    {
      if ((paramn instanceof s))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          Wa(0);
        }
        for (;;)
        {
          AppMethodBeat.o(69722);
          return true;
          Wa(-1);
        }
      }
      if ((paramn instanceof e))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label347;
        }
        Wa(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(69722);
      return false;
      label347:
      Wa(-1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletLockCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */