package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class WXRTEditText$3
  implements ap.a
{
  WXRTEditText$3(WXRTEditText paramWXRTEditText) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(26788);
    if ((WXRTEditText.o(this.vzr) != null) && (WXRTEditText.o(this.vzr).getType() == 1))
    {
      int i = WXRTEditText.o(this.vzr).vzZ;
      WXRTEditText.p(this.vzr);
      this.vzr.ay(i, false);
    }
    AppMethodBeat.o(26788);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.3
 * JD-Core Version:    0.7.0.1
 */