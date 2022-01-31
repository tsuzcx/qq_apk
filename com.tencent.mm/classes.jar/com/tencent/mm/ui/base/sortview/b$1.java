package com.tencent.mm.ui.base.sortview;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(107303);
    this.zsy.notifyDataSetChanged();
    AppMethodBeat.o(107303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b.1
 * JD-Core Version:    0.7.0.1
 */