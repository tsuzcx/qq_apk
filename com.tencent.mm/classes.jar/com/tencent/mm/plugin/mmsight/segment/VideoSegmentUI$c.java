package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class VideoSegmentUI$c
  implements Runnable
{
  private WeakReference<c> aqT;
  private int fQq;
  private int oMQ;
  
  public VideoSegmentUI$c(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55049);
    this.aqT = new WeakReference(paramc);
    this.oMQ = paramInt1;
    this.fQq = paramInt2;
    AppMethodBeat.o(55049);
  }
  
  public final void run()
  {
    AppMethodBeat.i(55050);
    c localc = (c)this.aqT.get();
    if (localc == null)
    {
      AppMethodBeat.o(55050);
      return;
    }
    localc.setCurrentCursorPosition(this.oMQ / this.fQq);
    AppMethodBeat.o(55050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.c
 * JD-Core Version:    0.7.0.1
 */