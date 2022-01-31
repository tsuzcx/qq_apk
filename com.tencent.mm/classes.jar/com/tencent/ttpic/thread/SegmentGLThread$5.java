package com.tencent.ttpic.thread;

import com.tencent.ttpic.util.FabbyManager;

class SegmentGLThread$5
  implements Runnable
{
  SegmentGLThread$5(SegmentGLThread paramSegmentGLThread) {}
  
  public void run()
  {
    FabbyManager.getInstance().compileKernel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.5
 * JD-Core Version:    0.7.0.1
 */