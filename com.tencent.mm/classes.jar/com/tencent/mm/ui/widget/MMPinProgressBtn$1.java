package com.tencent.mm.ui.widget;

import com.tencent.mm.sdk.platformtools.y;

final class MMPinProgressBtn$1
  implements Runnable
{
  MMPinProgressBtn$1(MMPinProgressBtn paramMMPinProgressBtn) {}
  
  public final void run()
  {
    if (this.wjB.getVisibility() != 0)
    {
      y.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
      return;
    }
    MMPinProgressBtn.a(this.wjB, MMPinProgressBtn.a(this.wjB) + 1);
    if (MMPinProgressBtn.a(this.wjB) >= MMPinProgressBtn.b(this.wjB))
    {
      MMPinProgressBtn.a(this.wjB, MMPinProgressBtn.a(this.wjB) - 1);
      y.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
      return;
    }
    this.wjB.invalidate();
    this.wjB.postDelayed(MMPinProgressBtn.c(this.wjB), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMPinProgressBtn.1
 * JD-Core Version:    0.7.0.1
 */