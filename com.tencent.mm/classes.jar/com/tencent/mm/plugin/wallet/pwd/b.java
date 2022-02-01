package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet.pwd.a.l;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class b
  extends d
{
  public final int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131765867;
  }
  
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(69508);
    if ((paramMMActivity instanceof WalletCheckPwdUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final CharSequence getTips(int paramAnonymousInt)
        {
          AppMethodBeat.i(69499);
          switch (paramAnonymousInt)
          {
          default: 
            localObject = super.getTips(paramAnonymousInt);
            AppMethodBeat.o(69499);
            return localObject;
          case 0: 
            localObject = this.activity.getString(2131765200);
            AppMethodBeat.o(69499);
            return localObject;
          }
          Object localObject = this.activity.getString(2131765643);
          AppMethodBeat.o(69499);
          return localObject;
        }
        
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69498);
          String str = (String)paramAnonymousVarArgs[0];
          paramAnonymousVarArgs = (String)paramAnonymousVarArgs[1];
          this.LVJ.a(new w(str, 3, paramAnonymousVarArgs), true, 1);
          AppMethodBeat.o(69498);
          return true;
        }
      };
      AppMethodBeat.o(69508);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new g(paramMMActivity, parami)
      {
        public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
        {
          AppMethodBeat.i(69501);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if ((paramAnonymousn instanceof l))
            {
              b.this.a(this.activity, 0, b.a(b.this));
              h.cm(this.activity, this.activity.getString(2131765625));
            }
            AppMethodBeat.o(69501);
            return true;
          }
          if ((paramAnonymousn instanceof l))
          {
            h.a(this.activity, paramAnonymousString, "", false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(69500);
                b.this.g(b.2.this.activity, 0);
                AppMethodBeat.o(69500);
              }
            });
            AppMethodBeat.o(69501);
            return true;
          }
          AppMethodBeat.o(69501);
          return false;
        }
        
        public final boolean r(Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(69502);
          paramAnonymousVarArgs = (v)paramAnonymousVarArgs[0];
          String str = b.b(b.this).getString("key_pwd1");
          this.LVJ.a(new l(str, paramAnonymousVarArgs.jfC), true, 1);
          AppMethodBeat.o(69502);
          return true;
        }
      };
      AppMethodBeat.o(69508);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(69508);
    return paramMMActivity;
  }
  
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69504);
    ae.d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
    b(paramActivity, WalletCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(69504);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(69505);
    if ((paramActivity instanceof WalletCheckPwdUI))
    {
      b(paramActivity, WalletSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(69505);
      return;
    }
    if ((paramActivity instanceof WalletSetPasswordUI))
    {
      b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
      AppMethodBeat.o(69505);
      return;
    }
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(69505);
  }
  
  public final boolean a(final WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    AppMethodBeat.i(69509);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(69509);
      return false;
    }
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131765867), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69503);
        b.this.b(paramWalletBaseUI, b.c(b.this));
        if (paramWalletBaseUI.isTransparent()) {
          paramWalletBaseUI.finish();
        }
        paramWalletBaseUI.clearErr();
        AppMethodBeat.o(69503);
      }
    });
    AppMethodBeat.o(69509);
    return true;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69507);
    a(paramActivity, WalletPasswordSettingUI.class, -1, false);
    AppMethodBeat.o(69507);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cSH()
  {
    return "ModifyPwdProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69506);
    if ((paramActivity instanceof WalletPwdConfirmUI)) {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
    }
    AppMethodBeat.o(69506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.b
 * JD-Core Version:    0.7.0.1
 */