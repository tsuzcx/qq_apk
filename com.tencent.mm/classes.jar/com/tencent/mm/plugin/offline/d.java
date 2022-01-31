package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends b
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(43300);
    if ((paramMMActivity instanceof WalletVerifyCodeUI))
    {
      paramMMActivity = new d.1(this, paramMMActivity, parami);
      AppMethodBeat.o(43300);
      return paramMMActivity;
    }
    if ((paramMMActivity instanceof WalletPwdConfirmUI))
    {
      paramMMActivity = new d.2(this, paramMMActivity, parami);
      AppMethodBeat.o(43300);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(43300);
    return paramMMActivity;
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43298);
    a.ymk.l(new lk());
    c(paramActivity, WalletOfflineEntranceUI.class);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(43298);
  }
  
  public final String bzC()
  {
    return "OfflineBindCardRegProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43301);
    boolean bool = super.c(paramActivity, paramBundle);
    AppMethodBeat.o(43301);
    return bool;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(43299);
    super.e(paramActivity, paramInt);
    AppMethodBeat.o(43299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.d
 * JD-Core Version:    0.7.0.1
 */