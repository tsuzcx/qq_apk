package com.tencent.mm.ui.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.o;

final class c$3
  implements ap.a
{
  c$3(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(29960);
    c localc = this.zgu;
    ab.d("MicroMsg.AppBrandServiceImageBubble", "hide");
    if (localc.vYP != null) {
      localc.vYP.dismiss();
    }
    AppMethodBeat.o(29960);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c.3
 * JD-Core Version:    0.7.0.1
 */