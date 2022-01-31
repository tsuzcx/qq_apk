package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$5
  implements e
{
  k$5(k paramk, f paramf, Activity paramActivity) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(49045);
    if (this.AWR.dSl())
    {
      this.AWT.bOi();
      AppMethodBeat.o(49045);
      return;
    }
    this.gjR.finish();
    AppMethodBeat.o(49045);
  }
  
  public final void onEnter() {}
  
  public final void onUrlCancel()
  {
    AppMethodBeat.i(49047);
    if (this.AWR.dSl())
    {
      this.AWT.bOi();
      AppMethodBeat.o(49047);
      return;
    }
    this.gjR.finish();
    AppMethodBeat.o(49047);
  }
  
  public final void onUrlOk()
  {
    AppMethodBeat.i(49046);
    if (this.AWR.dSl()) {
      this.AWT.bOi();
    }
    AppMethodBeat.o(49046);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k.5
 * JD-Core Version:    0.7.0.1
 */