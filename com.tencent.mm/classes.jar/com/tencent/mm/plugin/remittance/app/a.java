package com.tencent.mm.plugin.remittance.app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e;

public class a
  extends e
{
  public e a(Activity paramActivity, Bundle paramBundle)
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
    super.co(paramActivity);
    AppMethodBeat.o(67334);
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final String fud()
  {
    return "RemittanceProcess";
  }
  
  public final void i(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(67335);
    Z(paramActivity);
    AppMethodBeat.o(67335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.app.a
 * JD-Core Version:    0.7.0.1
 */