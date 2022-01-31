package com.tencent.mm.ui.widget.textview;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;

final class a$6
  implements ViewTreeObserver.OnPreDrawListener
{
  a$6(a parama) {}
  
  public final boolean onPreDraw()
  {
    if (this.wsy.wsw)
    {
      this.wsy.wsw = false;
      a locala = this.wsy;
      locala.lh.removeCallbacks(locala.wsx);
      locala.lh.postDelayed(locala.wsx, 100L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.6
 * JD-Core Version:    0.7.0.1
 */