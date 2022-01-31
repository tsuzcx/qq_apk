package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.base.h;

final class u$1
  implements ap.a
{
  u$1(u paramu) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(27722);
    u localu = this.vUB;
    Context localContext = this.vUB.context;
    this.vUB.context.getString(2131297087);
    localu.mOt = h.b(localContext, this.vUB.context.getString(2131297112), true, new u.1.1(this));
    AppMethodBeat.o(27722);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u.1
 * JD-Core Version:    0.7.0.1
 */