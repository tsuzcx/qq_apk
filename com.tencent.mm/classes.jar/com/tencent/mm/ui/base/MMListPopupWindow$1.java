package com.tencent.mm.ui.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$1
  implements Runnable
{
  MMListPopupWindow$1(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void run()
  {
    AppMethodBeat.i(112505);
    View localView = this.zkQ.ahj;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.zkQ.show();
    }
    AppMethodBeat.o(112505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */