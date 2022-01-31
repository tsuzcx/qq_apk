package com.tencent.ttpic;

import com.tencent.filter.h;
import com.tencent.ttpic.thread.SegmentGLThread;
import com.tencent.ttpic.util.OnSegmentReadyListener;

class PTSticker$2
  implements OnSegmentReadyListener
{
  PTSticker$2(PTSticker paramPTSticker, SegmentGLThread paramSegmentGLThread) {}
  
  public boolean needWait()
  {
    return this.val$mSegGLThread.needWait();
  }
  
  public void onTextureReady(h paramh, boolean paramBoolean)
  {
    this.val$mSegGLThread.postSegJob(paramh, paramBoolean);
  }
  
  public void reset()
  {
    this.val$mSegGLThread.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTSticker.2
 * JD-Core Version:    0.7.0.1
 */