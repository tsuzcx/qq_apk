package com.tencent.ttpic.recorder;

import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.WindowSurface;

class RenderSrfTex$2
  implements Runnable
{
  RenderSrfTex$2(RenderSrfTex paramRenderSrfTex, EGLContext paramEGLContext) {}
  
  public void run()
  {
    RenderSrfTex.access$800();
    Surface localSurface = RenderSrfTex.access$700(this.this$0).getInputSurface();
    RenderSrfTex.access$800();
    if (localSurface == null)
    {
      RenderSrfTex.access$602(this.this$0, null);
      RenderSrfTex.access$800();
      return;
    }
    RenderSrfTex.access$800();
    RenderSrfTex.access$902(this.this$0, new EglCore(this.val$eglContext, 0));
    RenderSrfTex.access$602(this.this$0, new WindowSurface(RenderSrfTex.access$900(this.this$0), RenderSrfTex.access$700(this.this$0).getInputSurface(), true));
    RenderSrfTex.access$800();
    RenderSrfTex.access$800();
    RenderSrfTex.access$600(this.this$0).makeCurrent();
    RenderSrfTex.access$800();
    RenderSrfTex.access$800();
    RenderSrfTex.access$1000(this.this$0);
    RenderSrfTex.access$800();
    try
    {
      RenderSrfTex.access$800();
      RenderSrfTex.access$700(this.this$0).start();
      RenderSrfTex.access$800();
      RenderSrfTex.access$800();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        RenderSrfTex.access$800();
        RenderSrfTex.access$700(this.this$0).releaseEncoder();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex.2
 * JD-Core Version:    0.7.0.1
 */