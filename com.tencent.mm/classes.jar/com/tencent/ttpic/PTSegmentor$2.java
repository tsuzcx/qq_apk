package com.tencent.ttpic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.SegmentGLThread.OnSegDataReadyListener;

class PTSegmentor$2
  implements SegmentGLThread.OnSegDataReadyListener
{
  PTSegmentor$2(PTSegmentor paramPTSegmentor) {}
  
  public void onDataReady(SegmentDataPipe paramSegmentDataPipe)
  {
    AppMethodBeat.i(81599);
    PTSegmentor.access$000(this.this$0, paramSegmentDataPipe);
    AppMethodBeat.o(81599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.PTSegmentor.2
 * JD-Core Version:    0.7.0.1
 */