package com.tencent.mm.ui.base;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$c
  extends DataSetObserver
{
  private MMListPopupWindow$c(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(159192);
    if (this.adRR.qjH.isShowing()) {
      this.adRR.show();
    }
    AppMethodBeat.o(159192);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(159193);
    this.adRR.dismiss();
    AppMethodBeat.o(159193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.c
 * JD-Core Version:    0.7.0.1
 */