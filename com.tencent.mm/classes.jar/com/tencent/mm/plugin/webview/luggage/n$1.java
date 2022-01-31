package com.tencent.mm.plugin.webview.luggage;

import android.view.MotionEvent;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;

final class n$1
  implements SwipeBackLayout.a
{
  n$1(n paramn, g.a parama) {}
  
  public final boolean aK(boolean paramBoolean)
  {
    if (this.rcL != null) {
      return this.rcL.aK(paramBoolean);
    }
    return false;
  }
  
  public final void e(int paramInt, float paramFloat)
  {
    if (this.rcL != null) {
      this.rcL.aI(paramFloat);
    }
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    if (this.rcL != null) {
      this.rcL.l(paramMotionEvent);
    }
  }
  
  public final void qs() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.n.1
 * JD-Core Version:    0.7.0.1
 */