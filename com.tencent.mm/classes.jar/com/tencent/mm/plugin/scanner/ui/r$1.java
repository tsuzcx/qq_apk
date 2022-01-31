package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;

final class r$1
  implements ap.a
{
  r$1(r paramr) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(81363);
    r localr = this.qBU;
    Context localContext = this.qBU.context;
    this.qBU.context.getString(2131297087);
    localr.mOt = h.b(localContext, this.qBU.context.getString(2131297112), true, new r.1.1(this));
    AppMethodBeat.o(81363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.r.1
 * JD-Core Version:    0.7.0.1
 */