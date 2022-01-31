package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class c$1
  extends DataSetObserver
{
  c$1(c paramc) {}
  
  public final void onChanged()
  {
    int i = 0;
    AppMethodBeat.i(107329);
    c localc = this.AoG;
    localc.mCount = 0;
    int j = localc.AoC.dNk();
    if (j == 0) {
      localc.mCount = localc.AoC.getCount();
    }
    for (;;)
    {
      this.AoG.notifyDataSetChanged();
      AppMethodBeat.o(107329);
      return;
      while (i < j)
      {
        localc.mCount += localc.AoC.QG(i) + localc.mNumColumns;
        i += 1;
      }
    }
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(107330);
    c.a(this.AoG).clear();
    this.AoG.notifyDataSetInvalidated();
    AppMethodBeat.o(107330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c.1
 * JD-Core Version:    0.7.0.1
 */