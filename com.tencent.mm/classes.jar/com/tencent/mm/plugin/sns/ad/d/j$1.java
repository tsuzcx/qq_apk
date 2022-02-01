package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

final class j$1
  implements Runnable
{
  j$1(SnsInfo paramSnsInfo) {}
  
  public final void run()
  {
    AppMethodBeat.i(309935);
    long l = System.currentTimeMillis();
    j.i(this.PNW);
    Log.i("AdWeAppPreloader", "---checkPreloadWeAppEnvForTimeLine, timeCost=" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(309935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.j.1
 * JD-Core Version:    0.7.0.1
 */