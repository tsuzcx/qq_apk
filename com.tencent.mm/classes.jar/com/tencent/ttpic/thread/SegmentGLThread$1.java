package com.tencent.ttpic.thread;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.shader.ShaderManager;

class SegmentGLThread$1
  implements Runnable
{
  SegmentGLThread$1(SegmentGLThread paramSegmentGLThread, EGLContext paramEGLContext) {}
  
  public void run()
  {
    SegmentGLThread.access$002(this.this$0, new EglCore(this.val$shareContext, 0));
    SegmentGLThread.access$102(this.this$0, new OffscreenSurface(SegmentGLThread.access$000(this.this$0), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
    SegmentGLThread.access$100(this.this$0).makeCurrent();
    SegmentGLThread.access$200(this.this$0).ApplyGLSLFilter();
    SegmentGLThread.access$300(this.this$0).ApplyGLSLFilter();
    SegmentGLThread.access$400(this.this$0).ApplyGLSLFilter();
    SegmentGLThread.access$500(this.this$0).ApplyGLSLFilter();
    SegmentGLThread.access$600(this.this$0).ApplyGLSLFilter();
    SegmentGLThread.access$702(this.this$0, new GLSegSharedData(this.val$shareContext));
    SegmentGLThread.access$802(this.this$0, new h());
    SegmentGLThread.access$902(this.this$0, new h());
    SegmentGLThread.access$1002(this.this$0, new h());
    GLES20.glGenTextures(SegmentGLThread.access$1100(this.this$0).length, SegmentGLThread.access$1100(this.this$0), 0);
    SegmentGLThread.access$1200(this.this$0, 1);
    ShaderManager.getInstance().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.1
 * JD-Core Version:    0.7.0.1
 */