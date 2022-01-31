package com.tencent.ttpic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnFaceDetListener;

class PTFaceDetector$1
  implements FaceGestureDetGLThread.OnFaceDetListener
{
  PTFaceDetector$1(PTFaceDetector paramPTFaceDetector) {}
  
  public void onDataReady(SegmentDataPipe paramSegmentDataPipe)
  {
    AppMethodBeat.i(81574);
    PTFaceDetector.access$000(this.this$0, paramSegmentDataPipe);
    AppMethodBeat.o(81574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.PTFaceDetector.1
 * JD-Core Version:    0.7.0.1
 */