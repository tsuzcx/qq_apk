package com.tencent.mm.ui.base;

final class MMTagPanelScrollView$a
  implements Runnable
{
  public MMTagPanel uYE;
  
  public final void run()
  {
    if (this.uYE != null) {
      this.uYE.cBa();
    }
    this.uYE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanelScrollView.a
 * JD-Core Version:    0.7.0.1
 */