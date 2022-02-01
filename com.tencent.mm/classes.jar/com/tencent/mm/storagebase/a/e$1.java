package com.tencent.mm.storagebase.a;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends DataSetObserver
{
  e$1(e parame) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(133444);
    e.a(this.VJU);
    AppMethodBeat.o(133444);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(133445);
    e.b(this.VJU);
    AppMethodBeat.o(133445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.e.1
 * JD-Core Version:    0.7.0.1
 */