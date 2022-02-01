package com.tencent.mm.videocomposition.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.player.Callback;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"<anonymous>", "", "call"})
final class a$d
  implements Callback
{
  a$d(long paramLong1, long paramLong2) {}
  
  public final void call()
  {
    AppMethodBeat.i(195019);
    System.currentTimeMillis();
    b.i("VideoCompositionPlayer", "seekTo:" + this.CgJ + " completed", new Object[0]);
    AppMethodBeat.o(195019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.videocomposition.play.a.d
 * JD-Core Version:    0.7.0.1
 */