package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d;

public class a
  extends d
{
  public d a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(67333);
    Log.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
    b(paramActivity, RemittanceAdapterUI.class, paramBundle);
    AppMethodBeat.o(67333);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(67334);
    super.bA(paramActivity);
    AppMethodBeat.o(67334);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String dKC()
  {
    return "RemittanceProcess";
  }
  
  public final void g(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(67335);
    P(paramActivity);
    AppMethodBeat.o(67335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */