package com.tencent.ttpic.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;

class FaceGestureDetGLThread$6
  implements Runnable
{
  FaceGestureDetGLThread$6(FaceGestureDetGLThread paramFaceGestureDetGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83750);
    FaceGestureDetGLThread.access$300(this.this$0).clear();
    FaceGestureDetGLThread.access$400(this.this$0).clear();
    FaceGestureDetGLThread.access$200(this.this$0).ClearGLSL();
    FaceGestureDetGLThread.access$100(this.this$0).release();
    FaceGestureDetGLThread.access$000(this.this$0).release();
    FaceGestureDetGLThread.access$1600(this.this$0).getLooper().quit();
    AppMethodBeat.o(83750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.6
 * JD-Core Version:    0.7.0.1
 */