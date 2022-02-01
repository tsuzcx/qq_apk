package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e;

public class a
  extends com.tencent.mm.plugin.remittance.app.a
{
  public final e a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(72178);
    Log.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
    b(paramActivity, PayURemittanceAdapterUI.class, paramBundle);
    AppMethodBeat.o(72178);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */