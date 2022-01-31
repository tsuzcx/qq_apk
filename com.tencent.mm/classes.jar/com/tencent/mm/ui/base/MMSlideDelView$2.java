package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.y;

final class MMSlideDelView$2
  implements Runnable
{
  MMSlideDelView$2(MMSlideDelView paramMMSlideDelView) {}
  
  public final void run()
  {
    this.uXT.setPressed(false);
    y.v("MicroMsg.MMSlideDelView", "onClick");
    MMSlideDelView.b(this.uXT).D(this.uXT, MMSlideDelView.a(this.uXT));
    this.uXT.cAX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMSlideDelView.2
 * JD-Core Version:    0.7.0.1
 */