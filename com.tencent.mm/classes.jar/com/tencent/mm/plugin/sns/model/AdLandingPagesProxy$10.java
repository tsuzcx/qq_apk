package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

final class AdLandingPagesProxy$10
  implements Runnable
{
  AdLandingPagesProxy$10(AdLandingPagesProxy paramAdLandingPagesProxy, au paramau, bx parambx) {}
  
  public final void run()
  {
    AppMethodBeat.i(309522);
    try
    {
      if ((int)this.lMP.maN == 0) {
        this.Qqx.aC(this.lMP);
      }
      if ((int)this.lMP.maN <= 0)
      {
        Log.e("AdLandingPagesProxy", "addContact : insert contact failed");
        AppMethodBeat.o(309522);
        return;
      }
      ab.I(this.lMP);
      AppMethodBeat.o(309522);
      return;
    }
    finally
    {
      Log.e("AdLandingPagesProxy", localObject.toString());
      AppMethodBeat.o(309522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.10
 * JD-Core Version:    0.7.0.1
 */