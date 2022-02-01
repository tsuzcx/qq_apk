package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b
  extends e
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return a.i.wallet_set_password_finish_confirm;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69520);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69511);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(69511);
            return localObject;
          case 0: 
            localObject = this.activity.getString(a.i.wallet_check_pwd_modify_pwd_tip);
            AppMethodBeat.o(69511);
            return localObject;
          }
          Object localObject = this.activity.getString(a.i.wallet_password_setting_ui_modify);
          AppMethodBeat.o(69511);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69510);
          String str = (String)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[1];
          this.agTR.a(new x(str, 3, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(69510);
          return true;
        }
      };
      AppMethodBeat.o(69520);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
        {
          AppMethodBeat.i(69513);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pwd.a.p))
            {
              b.a(b.this).putInt("RESET_PWD_USER_ACTION", 1);
              b.this.a(this.activity, 0, b.b(b.this));
              k.cZ(this.activity, this.activity.getString(a.i.wallet_password_setting_success_tip));
            }
            AppMethodBeat.o(69513);
            return true;
          }
          if ((paramAnonymousp instanceof com.tencent.mm.plugin.wallet.pwd.a.p))
          {
            k.a(this.activity, paramAnonymousString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(69512);
                b.c(b.this).putInt("RESET_PWD_USER_ACTION", 2);
                b.this.a(b.2.a(b.2.this), 0, b.d(b.this));
                AppMethodBeat.o(69512);
              }
            });
            AppMethodBeat.o(69513);
            return true;
          }
          AppMethodBeat.o(69513);
          return false;
        }
        
        public final boolean t(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69514);
          paramAnonymousVarArgs = (w)paramAnonymousVarArgs[0];
          b.e(b.this).getString("key_pwd1");
          this.agTR.a(new com.tencent.mm.plugin.wallet.pwd.a.p(paramAnonymousVarArgs.pRM, paramAnonymousVarArgs.token), true, 1);
          AppMethodBeat.o(69514);
          return true;
        }
      };
      AppMethodBeat.o(69520);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69520);
    return paramMMActivity;
  }
  
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69516);
    Log.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
    b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    AppMethodBeat.o(69516);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69517);
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(69517);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(69517);
  }
  
  public final boolean a(final WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(69521);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(69521);
      return false;
    }
    k.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(a.i.wallet_set_password_finish_confirm), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69515);
        b.this.b(paramWalletBaseUI, b.f(b.this));
        if (paramWalletBaseUI.isTransparent()) {
          paramWalletBaseUI.finish();
        }
        paramWalletBaseUI.clearErr();
        AppMethodBeat.o(69515);
      }
    });
    AppMethodBeat.o(69521);
    return true;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69519);
    Intent localIntent = new Intent(paramActivity, WalletResetPwdAdapterUI.class);
    localIntent.putExtra("RESET_PWD_USER_ACTION", paramBundle.getInt("RESET_PWD_USER_ACTION", 0));
    a(paramActivity, WalletResetPwdAdapterUI.class, -1, localIntent, false);
    AppMethodBeat.o(69519);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "ResetPwdProcessByToken";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69518);
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
    }
    AppMethodBeat.o(69518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b
 * JD-Core Version:    0.7.0.1
 */