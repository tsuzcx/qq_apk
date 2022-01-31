package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;

class SegmentGLThread$3
  implements Runnable
{
  SegmentGLThread$3(SegmentGLThread paramSegmentGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83775);
    if (BitmapUtils.isLegal(SegmentGLThread.access$1800(this.this$0)))
    {
      SegmentGLThread.access$1800(this.this$0).recycle();
      SegmentGLThread.access$1802(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$1900(this.this$0)))
    {
      SegmentGLThread.access$1900(this.this$0).recycle();
      SegmentGLThread.access$1902(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$2000(this.this$0)))
    {
      SegmentGLThread.access$2000(this.this$0).recycle();
      SegmentGLThread.access$2002(this.this$0, null);
    }
    if (BitmapUtils.isLegal(SegmentGLThread.access$2100(this.this$0)))
    {
      SegmentGLThread.access$2100(this.this$0).recycle();
      SegmentGLThread.access$2102(this.this$0, null);
    }
    SegmentGLThread.access$700(this.this$0).clear();
    SegmentGLThread.access$800(this.this$0).clear();
    SegmentGLThread.access$900(this.this$0).clear();
    SegmentGLThread.access$1000(this.this$0).clear();
    SegmentGLThread.access$200(this.this$0).ClearGLSL();
    SegmentGLThread.access$300(this.this$0).clearGLSLSelf();
    SegmentGLThread.access$400(this.this$0).clearGLSLSelf();
    SegmentGLThread.access$500(this.this$0).clearGLSLSelf();
    SegmentGLThread.access$600(this.this$0).clearGLSLSelf();
    GLES20.glDeleteTextures(SegmentGLThread.access$1100(this.this$0).length, SegmentGLThread.access$1100(this.this$0), 0);
    SegmentGLThread.access$100(this.this$0).release();
    SegmentGLThread.access$000(this.this$0).release();
    SegmentGLThread.access$2200(this.this$0).getLooper().quit();
    AppMethodBeat.o(83775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.3
 * JD-Core Version:    0.7.0.1
 */