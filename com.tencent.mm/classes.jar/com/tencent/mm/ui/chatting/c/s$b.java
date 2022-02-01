package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "", "onAddResult"})
final class s$b
  implements c.a
{
  s$b(int paramInt, boolean paramBoolean, long paramLong) {}
  
  public final void xp(int paramInt)
  {
    AppMethodBeat.i(197007);
    ac.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", new Object[] { Integer.valueOf(this.nvc), Boolean.valueOf(this.HUr), Integer.valueOf(paramInt) });
    b localb = (b)g.ab(b.class);
    if (localb != null) {
      localb.n(this.HUs, paramInt);
    }
    AppMethodBeat.o(197007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s.b
 * JD-Core Version:    0.7.0.1
 */