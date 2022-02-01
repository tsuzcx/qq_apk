package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "", "()V", "frames", "", "getFrames", "()I", "setFrames", "(I)V", "lastTick", "", "getLastTick", "()J", "setLastTick", "(J)V", "addFrame", "", "getFps", "reset", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public int frames;
  public long oTE;
  
  public final int getFps()
  {
    AppMethodBeat.i(283460);
    if (this.frames == 0)
    {
      AppMethodBeat.o(283460);
      return 0;
    }
    int i = (int)(this.frames * 1000 / Util.ticksToNow(this.oTE));
    AppMethodBeat.o(283460);
    return i;
  }
  
  public final void reset()
  {
    this.oTE = 0L;
    this.frames = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */