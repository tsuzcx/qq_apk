package com.tencent.mm.ui.base;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMHorList$2
  extends DataSetObserver
{
  MMHorList$2(MMHorList paramMMHorList) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(106654);
    MMHorList.a(this.zkK);
    this.zkK.invalidate();
    this.zkK.requestLayout();
    AppMethodBeat.o(106654);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(106655);
    MMHorList.b(this.zkK);
    this.zkK.invalidate();
    this.zkK.requestLayout();
    AppMethodBeat.o(106655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList.2
 * JD-Core Version:    0.7.0.1
 */