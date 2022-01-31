package com.tencent.mm.ui.base;

final class MMListPopupWindow$f
  implements Runnable
{
  private MMListPopupWindow$f(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void run()
  {
    if ((MMListPopupWindow.a(this.uWx) != null) && (MMListPopupWindow.a(this.uWx).getCount() > MMListPopupWindow.a(this.uWx).getChildCount()) && (MMListPopupWindow.a(this.uWx).getChildCount() <= this.uWx.aeR))
    {
      MMListPopupWindow.b(this.uWx).setInputMethodMode(2);
      this.uWx.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.f
 * JD-Core Version:    0.7.0.1
 */