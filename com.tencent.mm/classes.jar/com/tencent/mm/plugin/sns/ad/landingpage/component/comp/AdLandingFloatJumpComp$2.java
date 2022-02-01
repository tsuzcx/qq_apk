package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

class AdLandingFloatJumpComp$2
  extends IListener<yb>
{
  AdLandingFloatJumpComp$2(f paramf, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(310750);
    this.__eventId = yb.class.getName().hashCode();
    AppMethodBeat.o(310750);
  }
  
  private boolean hau()
  {
    AppMethodBeat.i(310758);
    try
    {
      localf = this.PQq;
      Log.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
      com.tencent.mm.plugin.sns.ad.landingpage.component.info.f localf1 = localf.PQd;
      if ((localf1 != null) && (localf1.PRU > 0))
      {
        if ((localf.PQk > 0) || (localf.PQl > 0)) {
          break label105;
        }
        if (localf.PQm <= 0) {
          break label71;
        }
      }
    }
    finally
    {
      for (;;)
      {
        f localf;
        label71:
        Log.w("SnsAd.FloatJumpComp", "onEventCall called has wrong!");
        continue;
        int i = 1;
        if (i == 0) {}
      }
    }
    Log.d("SnsAd.FloatJumpComp", "the comp is clicked, or the auto jump is less than 0!");
    for (;;)
    {
      AppMethodBeat.o(310758);
      return true;
      i = 0;
      break;
      localf.PQl += 1;
      localf.Dn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingFloatJumpComp.2
 * JD-Core Version:    0.7.0.1
 */