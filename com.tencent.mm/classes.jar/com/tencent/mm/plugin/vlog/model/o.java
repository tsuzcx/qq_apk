package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "", "()V", "frames", "", "getFrames", "()I", "setFrames", "(I)V", "lastTick", "", "getLastTick", "()J", "setLastTick", "(J)V", "addFrame", "", "getFps", "reset", "plugin-vlog_release"})
public final class o
{
  public int frames;
  public long maN;
  
  public final int getFps()
  {
    AppMethodBeat.i(239221);
    if (this.frames == 0)
    {
      AppMethodBeat.o(239221);
      return 0;
    }
    int i = (int)(this.frames * 1000 / Util.ticksToNow(this.maN));
    AppMethodBeat.o(239221);
    return i;
  }
  
  public final void reset()
  {
    this.maN = 0L;
    this.frames = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o
 * JD-Core Version:    0.7.0.1
 */