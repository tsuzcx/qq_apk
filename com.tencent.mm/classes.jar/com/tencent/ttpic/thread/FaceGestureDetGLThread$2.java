package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.List;

class FaceGestureDetGLThread$2
  implements FaceGestureDetGLThread.OnBodyDetListener
{
  FaceGestureDetGLThread$2(FaceGestureDetGLThread paramFaceGestureDetGLThread) {}
  
  public void onBodyDataReady(List<BodyDetectResult> paramList)
  {
    AppMethodBeat.i(83746);
    FaceGestureDetGLThread.access$700(this.this$0, paramList);
    AppMethodBeat.o(83746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.2
 * JD-Core Version:    0.7.0.1
 */