package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.a;
import com.tencent.mm.plugin.ball.c.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "", "onAddResult"})
final class w$b
  implements b.a
{
  w$b(int paramInt, boolean paramBoolean, long paramLong) {}
  
  public final void BE(int paramInt)
  {
    AppMethodBeat.i(231213);
    Log.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(this.pnf), Boolean.valueOf(this.PpC), Integer.valueOf(paramInt) });
    a locala = (a)g.af(a.class);
    if (locala != null) {
      locala.l(this.PpD, paramInt);
    }
    AppMethodBeat.o(231213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.w.b
 * JD-Core Version:    0.7.0.1
 */