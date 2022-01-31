package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.chatting.d.a;

final class t$3
  implements d.a
{
  t$3(t paramt) {}
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(31477);
    a.dJI().removeCallbacks(t.d(this.zGC));
    a.dJI().postDelayed(t.a(this.zGC, new t.3.1(this, paramString)), 1000L);
    AppMethodBeat.o(31477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.3
 * JD-Core Version:    0.7.0.1
 */