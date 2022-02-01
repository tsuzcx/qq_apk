package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a
  extends d
{
  public int a(MMActivity paramMMActivity, int paramInt)
  {
    return 2131765325;
  }
  
  public d a(Activity paramActivity, Bundle paramBundle)
  {
    J(new Object[] { "start", paramActivity, paramBundle });
    if (paramBundle != null) {
      paramBundle.putBoolean("key_is_bind_reg_process", true);
    }
    b(paramActivity, WalletBankcardIdUI.class, paramBundle);
    return this;
  }
  
  public void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    J(new Object[] { "forward", paramActivity, Integer.valueOf(paramInt), paramBundle });
    if (((paramActivity instanceof WalletBankcardIdUI)) || ((paramActivity instanceof WalletConfirmCardIDUI))) {
      b(paramActivity, WalletCardElementUI.class, paramBundle);
    }
    do
    {
      return;
      if ((paramActivity instanceof WalletVerifyCodeUI))
      {
        b(paramActivity, WalletSetPasswordUI.class, paramBundle);
        return;
      }
      if ((paramActivity instanceof WalletSetPasswordUI))
      {
        b(paramActivity, WalletPwdConfirmUI.class, paramBundle);
        return;
      }
    } while (!(paramActivity instanceof WalletOrderInfoUI));
    b(paramActivity, paramBundle);
  }
  
  public boolean a(final WalletBaseUI paramWalletBaseUI, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    ac.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
    h.a(paramWalletBaseUI, paramString, null, paramWalletBaseUI.getString(2131765078), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(69864);
        a.this.b(paramWalletBaseUI, a.this.dmf);
        if (paramWalletBaseUI.isTransparent()) {
          paramWalletBaseUI.finish();
        }
        paramWalletBaseUI.clearErr();
        AppMethodBeat.o(69864);
      }
    });
    return true;
  }
  
  public boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return paramActivity instanceof WalletOrderInfoUI;
  }
  
  public void g(Activity paramActivity, int paramInt)
  {
    J(new Object[] { "back", paramActivity, Integer.valueOf(paramInt) });
    if ((paramActivity instanceof WalletPwdConfirmUI))
    {
      a(paramActivity, WalletSetPasswordUI.class, paramInt);
      return;
    }
    Q(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a
 * JD-Core Version:    0.7.0.1
 */