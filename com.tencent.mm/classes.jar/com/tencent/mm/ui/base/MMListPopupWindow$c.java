package com.tencent.mm.ui.base;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMListPopupWindow$c
  extends DataSetObserver
{
  private MMListPopupWindow$c(MMListPopupWindow paramMMListPopupWindow) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(112514);
    if (this.zkQ.gMK.isShowing()) {
      this.zkQ.show();
    }
    AppMethodBeat.o(112514);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(112515);
    this.zkQ.dismiss();
    AppMethodBeat.o(112515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMListPopupWindow.c
 * JD-Core Version:    0.7.0.1
 */