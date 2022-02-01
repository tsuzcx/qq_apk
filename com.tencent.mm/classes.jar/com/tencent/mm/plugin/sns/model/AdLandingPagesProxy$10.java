package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

final class AdLandingPagesProxy$10
  implements Runnable
{
  AdLandingPagesProxy$10(AdLandingPagesProxy paramAdLandingPagesProxy, as paramas, bv parambv) {}
  
  public final void run()
  {
    AppMethodBeat.i(259407);
    try
    {
      if ((int)this.jkl.jxt == 0) {
        this.JTv.aw(this.jkl);
      }
      if ((int)this.jkl.jxt <= 0)
      {
        Log.e("AdLandingPagesProxy", "addContact : insert contact failed");
        AppMethodBeat.o(259407);
        return;
      }
      ab.H(this.jkl);
      AppMethodBeat.o(259407);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingPagesProxy", localThrowable.toString());
      AppMethodBeat.o(259407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.10
 * JD-Core Version:    0.7.0.1
 */