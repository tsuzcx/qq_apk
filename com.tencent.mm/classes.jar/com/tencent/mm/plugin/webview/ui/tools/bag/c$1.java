package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.MotionEvent;

final class c$1
  implements g.a
{
  c$1(c paramc) {}
  
  public final void aI(float paramFloat)
  {
    float f1 = 1.0F;
    f localf = this.rrw.rru;
    if (paramFloat < 0.15F) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      localf.aJ(paramFloat);
      return;
      float f2 = 2.0F * paramFloat;
      paramFloat = f1;
      if (f2 <= 1.0F) {
        paramFloat = f2;
      }
    }
  }
  
  public final boolean aK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.rrw.rru.aJ(1.0F);
      this.rrw.rru.c(this.rrw.rrv, 21);
      return true;
    }
    this.rrw.rru.aJ(0.0F);
    return false;
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    this.rrw.rrv = paramMotionEvent.getRawX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.c.1
 * JD-Core Version:    0.7.0.1
 */