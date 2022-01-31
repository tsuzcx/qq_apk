package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a
  extends DataSetObserver
{
  private f$a(f paramf) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(107412);
    f.a(this.Apn, this.Apn.a(f.a(this.Apn)));
    this.Apn.notifyDataSetChanged();
    AppMethodBeat.o(107412);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(107413);
    f.a(this.Apn, this.Apn.a(f.a(this.Apn)));
    this.Apn.notifyDataSetInvalidated();
    AppMethodBeat.o(107413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.f.a
 * JD-Core Version:    0.7.0.1
 */