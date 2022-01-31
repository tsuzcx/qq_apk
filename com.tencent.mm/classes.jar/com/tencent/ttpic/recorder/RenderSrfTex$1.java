package com.tencent.ttpic.recorder;

import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.WindowSurface;
import com.tencent.ttpic.util.FrameRateUtil;

class RenderSrfTex$1
  implements Runnable
{
  RenderSrfTex$1(RenderSrfTex paramRenderSrfTex, int paramInt) {}
  
  public void run()
  {
    if (FrameRateUtil.mRecordStartTime == -1L)
    {
      FrameRateUtil.mRecordStartTime = System.currentTimeMillis();
      FrameRateUtil.mFrameCount = 0;
    }
    if ((RenderSrfTex.access$000(this.this$0) > 0L) && (System.currentTimeMillis() - FrameRateUtil.mRecordStartTime < FrameRateUtil.mFrameCount * RenderSrfTex.access$000(this.this$0))) {
      return;
    }
    FrameRateUtil.mFrameCount += 1;
    RenderSrfTex.access$500(this.this$0).RenderProcess(this.val$textureId, RenderSrfTex.access$100(this.this$0), RenderSrfTex.access$200(this.this$0), 0, RenderSrfTex.access$300(this.this$0), RenderSrfTex.access$400(this.this$0));
    if (RenderSrfTex.access$600(this.this$0) != null)
    {
      RenderSrfTex.access$600(this.this$0).swapBuffers();
      RenderSrfTex.access$600(this.this$0).setPresentationTime(System.nanoTime());
    }
    RenderSrfTex.access$700(this.this$0).swapBuffers();
    GlUtil.checkGlError("draw_E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex.1
 * JD-Core Version:    0.7.0.1
 */