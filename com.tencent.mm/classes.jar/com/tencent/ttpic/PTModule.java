package com.tencent.ttpic;

import android.opengl.EGLContext;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.VideoUtil;

public enum PTModule
{
  INSTANCE;
  
  private SegmentGLThread mSegGLThread;
  
  private PTModule() {}
  
  public static PTModule getInstance()
  {
    return INSTANCE;
  }
  
  public final void destroy()
  {
    if (this.mSegGLThread != null)
    {
      this.mSegGLThread.destroy();
      this.mSegGLThread = null;
    }
    PTFaceDetector.getInstance().destroy();
  }
  
  public final SegmentGLThread getSegGLThread()
  {
    return this.mSegGLThread;
  }
  
  public final void init(EGLContext paramEGLContext)
  {
    if ((VideoUtil.hasJellyBeanMR1()) && (this.mSegGLThread == null)) {
      this.mSegGLThread = new SegmentGLThread(paramEGLContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTModule
 * JD-Core Version:    0.7.0.1
 */