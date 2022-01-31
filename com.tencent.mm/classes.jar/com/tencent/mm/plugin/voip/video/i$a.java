package com.tencent.mm.plugin.voip.video;

final class i$a
  implements Runnable
{
  private long dFf;
  private int kCB;
  private boolean qbL;
  private int streamType;
  
  public i$a(i parami, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.kCB = paramInt1;
    this.dFf = paramLong;
    this.qbL = paramBoolean;
    this.streamType = paramInt2;
  }
  
  public final void run()
  {
    this.qbG.a(this.kCB, this.dFf, this.qbL, this.streamType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.i.a
 * JD-Core Version:    0.7.0.1
 */