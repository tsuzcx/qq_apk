package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class MultiTrackCropView$f
  implements Runnable
{
  MultiTrackCropView$f(MultiTrackCropView paramMultiTrackCropView) {}
  
  public final void run()
  {
    AppMethodBeat.i(232234);
    Log.d("MicroMsg.MultiTrackCropView", "replayLastMoveEvent, lastMoveEvent:" + MultiTrackCropView.B(this.NDq));
    this.NDq.dispatchTouchEvent(MultiTrackCropView.B(this.NDq));
    AppMethodBeat.o(232234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.MultiTrackCropView.f
 * JD-Core Version:    0.7.0.1
 */