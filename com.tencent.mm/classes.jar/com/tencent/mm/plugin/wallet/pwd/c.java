package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pwd.a.o;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c
  extends com.tencent.mm.wallet_core.c
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131305648;
  }
  
  public final com.tencent.mm.wallet_core.c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46160);
    ab.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
    b(paramActivity, WalletSetPasswordUI.class, paramBundle);
    AppMethodBeat.o(46160);
    return this;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(46164);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(46155);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(46155);
            return localObject;
          case 0: 
            localObject = this.hwZ.getString(2131305008);
            AppMethodBeat.o(46155);
            return localObject;
          }
          Object localObject = this.hwZ.getString(2131305429);
          AppMethodBeat.o(46155);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(46154);
          String str = (String)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[1];
          this.AXB.a(new com.tencent.mm.plugin.wallet_core.c.u(str, 3, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(46154);
          return true;
        }
      };
      AppMethodBeat.o(46164);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(46157);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousm instanceof o))
            {
              c.a(c.this).putInt("RESET_PWD_USER_ACTION", 1);
              c.this.a(this.hwZ, 0, c.b(c.this));
              h.bO(this.hwZ, this.hwZ.getString(2131305411));
            }
            AppMethodBeat.o(46157);
            return true;
          }
          if ((paramAnonymousm instanceof o))
          {
            h.a(this.hwZ, paramAnonymousString, "", false, new c.2.1(this));
            AppMethodBeat.o(46157);
            return true;
          }
          AppMethodBeat.o(46157);
          return false;
        }
        
        public final boolean p(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(46158);
          paramAnonymousVarArgs = (com.tencent.mm.plugin.wallet_core.model.u)paramAnonymousVarArgs[0];
          c.e(c.this).getString("key_pwd1");
          this.AXB.a(new o(paramAnonymousVarArgs.gww, paramAnonymousVarArgs.token), true, 1);
          AppMethodBeat.o(46158);
          return true;
        }
      };
      AppMethodBeat.o(46164);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(46164);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(46161);
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(46161);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(46161);
  }
  
  public final boolean a(WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(46165);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(46165);
      return false;
    }
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131305648), false, new c.3(this, paramWalletBaseUI));
    AppMethodBeat.o(46165);
    return true;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(46163);
    Intent localIntent = new Intent(paramActivity, WalletResetPwdAdapterUI.class);
    localIntent.putExtra("RESET_PWD_USER_ACTION", paramBundle.getInt("RESET_PWD_USER_ACTION", 0));
    a(paramActivity, WalletResetPwdAdapterUI.class, -1, localIntent, false);
    AppMethodBeat.o(46163);
  }
  
  public final String bzC()
  {
    return "ResetPwdProcessByToken";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(46162);
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
    }
    AppMethodBeat.o(46162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.c
 * JD-Core Version:    0.7.0.1
 */