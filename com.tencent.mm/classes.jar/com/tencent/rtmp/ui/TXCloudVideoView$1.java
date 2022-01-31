package com.tencent.rtmp.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCloudVideoView$1
  implements Runnable
{
  TXCloudVideoView$1(TXCloudVideoView paramTXCloudVideoView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    AppMethodBeat.i(65569);
    TXCloudVideoView.access$002(this.e, this.e.getWidth() * this.a);
    TXCloudVideoView.access$102(this.e, this.e.getWidth() * this.b);
    TXCloudVideoView.access$202(this.e, this.e.getHeight() * this.c);
    TXCloudVideoView.access$302(this.e, this.e.getHeight() * this.d);
    if (this.e.mDashBoard != null) {
      this.e.mDashBoard.a((int)TXCloudVideoView.access$000(this.e), (int)TXCloudVideoView.access$200(this.e), (int)TXCloudVideoView.access$100(this.e), (int)TXCloudVideoView.access$300(this.e));
    }
    AppMethodBeat.o(65569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView.1
 * JD-Core Version:    0.7.0.1
 */