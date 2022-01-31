package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;

public class g
  extends e
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48516);
    b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
    AppMethodBeat.o(48516);
    return this;
  }
  
  public final com.tencent.mm.wallet_core.d.g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48518);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new g.1(this, paramMMActivity, parami, this.mEJ);
      AppMethodBeat.o(48518);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPayUPwdConfirmUI))
    {
      paramMMActivity = new g.2(this, paramMMActivity, parami);
      AppMethodBeat.o(48518);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48518);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48517);
    if ((paramActivity instanceof WalletPayUCheckPwdUI))
    {
      b(paramActivity, WalletPayUSetPasswordUI.class, paramBundle);
      AppMethodBeat.o(48517);
      return;
    }
    super.a(paramActivity, paramInt, paramBundle);
    AppMethodBeat.o(48517);
  }
  
  public final String bzC()
  {
    return "PayUModifyPasswordProcess";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.a.g
 * JD-Core Version:    0.7.0.1
 */