package com.tencent.ttpic.thread;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.util.VideoBitmapUtil;

class SegmentGLThread$3
  implements Runnable
{
  SegmentGLThread$3(SegmentGLThread paramSegmentGLThread) {}
  
  public void run()
  {
    if (VideoBitmapUtil.isLegal(SegmentGLThread.access$1600(this.this$0)))
    {
      SegmentGLThread.access$1600(this.this$0).recycle();
      SegmentGLThread.access$1602(this.this$0, null);
    }
    if (VideoBitmapUtil.isLegal(SegmentGLThread.access$1700(this.this$0)))
    {
      SegmentGLThread.access$1700(this.this$0).recycle();
      SegmentGLThread.access$1702(this.this$0, null);
    }
    if (VideoBitmapUtil.isLegal(SegmentGLThread.access$1800(this.this$0)))
    {
      SegmentGLThread.access$1800(this.this$0).recycle();
      SegmentGLThread.access$1802(this.this$0, null);
    }
    if (VideoBitmapUtil.isLegal(SegmentGLThread.access$1900(this.this$0)))
    {
      SegmentGLThread.access$1900(this.this$0).recycle();
      SegmentGLThread.access$1902(this.this$0, null);
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
    SegmentGLThread.access$2000(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.3
 * JD-Core Version:    0.7.0.1
 */