package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.wallet_core.d;

public class l
  extends d
{
  public final d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66272);
    b(paramActivity, WalletVerifyCodeUI.class, paramBundle);
    AppMethodBeat.o(66272);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66273);
    if ((paramActivity instanceof WalletVerifyCodeUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(66273);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(66274);
    paramBundle = new Intent(paramActivity, WalletOfflineCoinPurseUI.class);
    paramBundle.addFlags(67108864);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramBundle.ahE(), "com/tencent/mm/plugin/offline/VerifyProcess", "end", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramBundle.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/offline/VerifyProcess", "end", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(66274);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String cSH()
  {
    return "VerifyProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.l
 * JD-Core Version:    0.7.0.1
 */