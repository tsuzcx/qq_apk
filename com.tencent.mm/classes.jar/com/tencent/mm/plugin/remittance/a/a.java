package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c;

public class a
  extends c
{
  public c a(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44422);
    ab.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
    b(paramActivity, RemittanceAdapterUI.class, paramBundle);
    AppMethodBeat.o(44422);
    return this;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle) {}
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44423);
    super.aO(paramActivity);
    AppMethodBeat.o(44423);
  }
  
  public final String bzC()
  {
    return "RemittanceProcess";
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(44424);
    B(paramActivity);
    AppMethodBeat.o(44424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.a
 * JD-Core Version:    0.7.0.1
 */