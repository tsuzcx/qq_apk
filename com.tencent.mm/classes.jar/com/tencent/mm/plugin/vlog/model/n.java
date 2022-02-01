package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "", "()V", "frames", "", "getFrames", "()I", "setFrames", "(I)V", "lastTick", "", "getLastTick", "()J", "setLastTick", "(J)V", "addFrame", "", "getFps", "reset", "plugin-vlog_release"})
public final class n
{
  public int frames;
  public long jkM;
  
  public final int getFps()
  {
    AppMethodBeat.i(190581);
    if (this.frames == 0)
    {
      AppMethodBeat.o(190581);
      return 0;
    }
    int i = (int)(this.frames * 1000 / Util.ticksToNow(this.jkM));
    AppMethodBeat.o(190581);
    return i;
  }
  
  public final void reset()
  {
    this.jkM = 0L;
    this.frames = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */