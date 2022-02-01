package com.tencent.mm.plugin.vlog.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.player.Callback;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "call"})
final class c$c
  implements Callback
{
  c$c(long paramLong) {}
  
  public final void call()
  {
    AppMethodBeat.i(207670);
    ac.i("MicroMsg.VLogCompositionPlayer", "seekTo:" + this.ApC + " completed");
    AppMethodBeat.o(207670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c.c
 * JD-Core Version:    0.7.0.1
 */