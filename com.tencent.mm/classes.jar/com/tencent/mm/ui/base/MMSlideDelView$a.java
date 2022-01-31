package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.y;

final class MMSlideDelView$a
  extends MMSlideDelView.h
  implements Runnable
{
  private MMSlideDelView$a(MMSlideDelView paramMMSlideDelView)
  {
    super(paramMMSlideDelView, (byte)0);
  }
  
  public final void run()
  {
    if ((this.uXT.hasWindowFocus()) && (MMSlideDelView.c(this.uXT) == this.uXU)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!MMSlideDelView.d(this.uXT)))
      {
        y.i("MicroMsg.MMSlideDelView", "is long press");
        if (this.uXT.getParent() != null)
        {
          MMSlideDelView.e(this.uXT);
          this.uXT.performLongClick();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.a
 * JD-Core Version:    0.7.0.1
 */