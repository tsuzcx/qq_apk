package com.tencent.ttpic.thread;

import android.opengl.EGLContext;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

class FaceGestureDetGLThread$1
  implements Runnable
{
  FaceGestureDetGLThread$1(FaceGestureDetGLThread paramFaceGestureDetGLThread, EGLContext paramEGLContext) {}
  
  public void run()
  {
    AppMethodBeat.i(83745);
    FaceGestureDetGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
    FaceGestureDetGLThread.access$102(this.this$0, new OffscreenSurface(FaceGestureDetGLThread.access$000(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    FaceGestureDetGLThread.access$100(this.this$0).makeCurrent();
    FaceGestureDetGLThread.access$200(this.this$0).ApplyGLSLFilter();
    FaceGestureDetGLThread.access$302(this.this$0, new GLSegSharedData(this.val$shareContext));
    FaceGestureDetGLThread.access$402(this.this$0, new h());
    if (FaceGestureDetGLThread.access$500(this.this$0).init() != 0)
    {
      FaceGestureDetGLThread.access$602(this.this$0, false);
      AppMethodBeat.o(83745);
      return;
    }
    FaceGestureDetGLThread.access$602(this.this$0, true);
    AppMethodBeat.o(83745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.1
 * JD-Core Version:    0.7.0.1
 */