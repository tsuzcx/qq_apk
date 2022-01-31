package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetector;

class FaceGestureDetGLThread$4
  implements Runnable
{
  FaceGestureDetGLThread$4(FaceGestureDetGLThread paramFaceGestureDetGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83748);
    BodyDetector.getInstance().destroy();
    GestureDetector.getInstance().destroy();
    FaceGestureDetGLThread.access$500(this.this$0).clear();
    FaceGestureDetGLThread.access$500(this.this$0).destroy();
    AppMethodBeat.o(83748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.4
 * JD-Core Version:    0.7.0.1
 */