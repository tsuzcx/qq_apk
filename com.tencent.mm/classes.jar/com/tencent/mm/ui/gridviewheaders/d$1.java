package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  extends DataSetObserver
{
  d$1(d paramd) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(107405);
    this.Apk.notifyDataSetChanged();
    AppMethodBeat.o(107405);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(107406);
    this.Apk.notifyDataSetInvalidated();
    AppMethodBeat.o(107406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.d.1
 * JD-Core Version:    0.7.0.1
 */