package com.tencent.mm.ui.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$1
  implements Runnable
{
  MMListPopupWindow$1(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void run()
  {
    AppMethodBeat.i(159182);
    View localView = this.adRR.ul;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.adRR.show();
    }
    AppMethodBeat.o(159182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */