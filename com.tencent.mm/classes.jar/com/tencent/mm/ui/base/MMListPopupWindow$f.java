package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$f
  implements Runnable
{
  private MMListPopupWindow$f(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void run()
  {
    AppMethodBeat.i(112519);
    if ((MMListPopupWindow.a(this.zkQ) != null) && (MMListPopupWindow.a(this.zkQ).getCount() > MMListPopupWindow.a(this.zkQ).getChildCount()) && (MMListPopupWindow.a(this.zkQ).getChildCount() <= this.zkQ.ahg))
    {
      MMListPopupWindow.b(this.zkQ).setInputMethodMode(2);
      this.zkQ.show();
    }
    AppMethodBeat.o(112519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.f
 * JD-Core Version:    0.7.0.1
 */