package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.SegmentDataPipe;

class FaceGestureDetGLThread$7
  implements Runnable
{
  FaceGestureDetGLThread$7(FaceGestureDetGLThread paramFaceGestureDetGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83751);
    if (FaceGestureDetGLThread.access$800(this.this$0) == null)
    {
      AppMethodBeat.o(83751);
      return;
    }
    SegmentDataPipe localSegmentDataPipe = FaceGestureDetGLThread.access$300(this.this$0).getFreeTexturePileMakeBusy();
    if (localSegmentDataPipe == null)
    {
      AppMethodBeat.o(83751);
      return;
    }
    localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
    localSegmentDataPipe.makeDataReady();
    FaceGestureDetGLThread.access$300(this.this$0).makeBrotherTextureFree(localSegmentDataPipe);
    FaceGestureDetGLThread.access$800(this.this$0).onDataReady(localSegmentDataPipe);
    AppMethodBeat.o(83751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.7
 * JD-Core Version:    0.7.0.1
 */