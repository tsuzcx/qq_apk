package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

final class n$2
  implements SwipeBackLayout.b
{
  n$2(n paramn, g.a parama) {}
  
  public final void aH(float paramFloat)
  {
    if (this.rcL != null) {
      this.rcL.aI(paramFloat);
    }
  }
  
  public final boolean aK(boolean paramBoolean)
  {
    if (this.rcL != null) {
      return this.rcL.aK(paramBoolean);
    }
    return false;
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    if (this.rcL != null) {
      this.rcL.l(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n.2
 * JD-Core Version:    0.7.0.1
 */