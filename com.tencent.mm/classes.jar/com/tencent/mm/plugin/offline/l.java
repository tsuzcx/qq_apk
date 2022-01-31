package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.wallet_core.c;

public class l
  extends c
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43373);
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    AppMethodBeat.o(43373);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(43374);
    if ((paramActivity instanceof WalletVerifyCodeUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(43374);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(43375);
    paramBundle = new Intent(paramActivity, WalletOfflineCoinPurseUI.class);
    paramBundle.addFlags(67108864);
    paramActivity.startActivity(paramBundle);
    AppMethodBeat.o(43375);
  }
  
  public final String bzC()
  {
    return "VerifyProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.l
 * JD-Core Version:    0.7.0.1
 */