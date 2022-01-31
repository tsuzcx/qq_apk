package com.tencent.mm.plugin.mmsight.segment;

import java.lang.ref.WeakReference;

final class VideoSegmentUI$c
  implements Runnable
{
  private WeakReference<c> aoA;
  private int eAx;
  private int mnI;
  
  public VideoSegmentUI$c(c paramc, int paramInt1, int paramInt2)
  {
    this.aoA = new WeakReference(paramc);
    this.mnI = paramInt1;
    this.eAx = paramInt2;
  }
  
  public final void run()
  {
    c localc = (c)this.aoA.get();
    if (localc == null) {
      return;
    }
    localc.setCurrentCursorPosition(this.mnI / this.eAx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.c
 * JD-Core Version:    0.7.0.1
 */