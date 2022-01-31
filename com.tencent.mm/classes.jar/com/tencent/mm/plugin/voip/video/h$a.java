package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$a
  implements Runnable
{
  private long interval;
  private int resId;
  private int streamType;
  private boolean tHx;
  
  public h$a(h paramh, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.resId = paramInt1;
    this.interval = paramLong;
    this.tHx = paramBoolean;
    this.streamType = paramInt2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(5100);
    this.tHs.a(this.resId, this.interval, this.tHx, this.streamType);
    AppMethodBeat.o(5100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.h.a
 * JD-Core Version:    0.7.0.1
 */