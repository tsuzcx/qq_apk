package com.tencent.mm.plugin.wallet_payu.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.a.a;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class g
  extends a
{
  public final c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48537);
    ab.d("MicroMsg.PayURemittanceProcess", "start Process : PayURemittanceProcess");
    b(paramActivity, PayURemittanceAdapterUI.class, paramBundle);
    AppMethodBeat.o(48537);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.a.g
 * JD-Core Version:    0.7.0.1
 */