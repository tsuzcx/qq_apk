package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

final class j$2
  implements Runnable
{
  j$2(ArrayList paramArrayList, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(309930);
    long l = System.currentTimeMillis();
    j.k(this.PNX, this.PNY);
    Log.i("AdWeAppPreloader", "---checkPreloadWeAppEnvForNativeLandingPage, timeCost=" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(309930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.j.2
 * JD-Core Version:    0.7.0.1
 */