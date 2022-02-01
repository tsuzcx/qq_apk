package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class VideoSegmentUI$c
  implements Runnable
{
  private int LaO;
  private int oTN;
  private WeakReference<c> viewRef;
  
  public VideoSegmentUI$c(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94484);
    this.viewRef = new WeakReference(paramc);
    this.LaO = paramInt1;
    this.oTN = paramInt2;
    AppMethodBeat.o(94484);
  }
  
  public final void run()
  {
    AppMethodBeat.i(94485);
    c localc = (c)this.viewRef.get();
    if (localc == null)
    {
      AppMethodBeat.o(94485);
      return;
    }
    localc.setCurrentCursorPosition(this.LaO / this.oTN);
    AppMethodBeat.o(94485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.c
 * JD-Core Version:    0.7.0.1
 */