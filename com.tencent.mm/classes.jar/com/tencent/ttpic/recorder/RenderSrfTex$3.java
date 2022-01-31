package com.tencent.ttpic.recorder;

import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.WindowSurface;

class RenderSrfTex$3
  implements Runnable
{
  RenderSrfTex$3(RenderSrfTex paramRenderSrfTex, VideoRecorderListener paramVideoRecorderListener) {}
  
  public void run()
  {
    AppMethodBeat.i(83709);
    if (RenderSrfTex.access$700(this.this$0) != null) {
      RenderSrfTex.access$700(this.this$0).stop();
    }
    if (RenderSrfTex.access$600(this.this$0) != null) {
      RenderSrfTex.access$600(this.this$0).release();
    }
    if (RenderSrfTex.access$900(this.this$0) != null) {
      RenderSrfTex.access$900(this.this$0).release();
    }
    RenderSrfTex.access$500(this.this$0).clearGLSLSelf();
    RenderSrfTex.access$400(this.this$0).clear();
    if ((this.val$listener != null) && (RenderSrfTex.access$700(this.this$0) != null)) {
      this.val$listener.onVideoRecordFinish(RenderSrfTex.access$700(this.this$0).getOutputPath());
    }
    if (RenderSrfTex.access$1100(this.this$0) != null)
    {
      RenderSrfTex.access$1100(this.this$0).quit();
      RenderSrfTex.access$1102(this.this$0, null);
    }
    if (RenderSrfTex.access$1200(this.this$0) != null) {
      RenderSrfTex.access$1202(this.this$0, null);
    }
    AppMethodBeat.o(83709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex.3
 * JD-Core Version:    0.7.0.1
 */