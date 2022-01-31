package com.tencent.rtmp.ui;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.liteav.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCloudVideoView$a
  implements Runnable
{
  private View b;
  private MotionEvent c;
  
  private TXCloudVideoView$a(TXCloudVideoView paramTXCloudVideoView) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.c = paramMotionEvent;
  }
  
  public void a(View paramView)
  {
    this.b = paramView;
  }
  
  public void run()
  {
    AppMethodBeat.i(65568);
    if ((TXCloudVideoView.access$400(this.a) != null) && (TXCloudVideoView.access$700(this.a))) {
      TXCloudVideoView.access$400(this.a).a(this.c.getX() / this.b.getWidth(), this.c.getY() / this.b.getHeight());
    }
    if (TXCloudVideoView.access$700(this.a)) {
      this.a.onTouchFocus((int)this.c.getX(), (int)this.c.getY());
    }
    AppMethodBeat.o(65568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView.a
 * JD-Core Version:    0.7.0.1
 */