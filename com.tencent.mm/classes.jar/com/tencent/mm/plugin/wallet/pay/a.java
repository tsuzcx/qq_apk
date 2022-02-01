package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;

public class a
  extends b
{
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(69202);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, "wallet", ".pay.ui.WalletPayUI", -1, localIntent, false);
    AppMethodBeat.o(69202);
  }
  
  public final String epb()
  {
    return "BindCardForPayProcess";
  }
  
  public final void h(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(69201);
    if (paramActivity != null) {
      paramActivity.finish();
    }
    AppMethodBeat.o(69201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.a
 * JD-Core Version:    0.7.0.1
 */