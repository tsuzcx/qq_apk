package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetector;

class FaceGestureDetGLThread$5
  implements Runnable
{
  FaceGestureDetGLThread$5(FaceGestureDetGLThread paramFaceGestureDetGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83749);
    BodyDetector.getInstance().reset();
    AppMethodBeat.o(83749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.5
 * JD-Core Version:    0.7.0.1
 */