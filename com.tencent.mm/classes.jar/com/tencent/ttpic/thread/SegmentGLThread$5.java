package com.tencent.ttpic.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyManager;

class SegmentGLThread$5
  implements Runnable
{
  SegmentGLThread$5(SegmentGLThread paramSegmentGLThread) {}
  
  public void run()
  {
    AppMethodBeat.i(83777);
    FabbyManager.getInstance().compileKernel();
    AppMethodBeat.o(83777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread.5
 * JD-Core Version:    0.7.0.1
 */