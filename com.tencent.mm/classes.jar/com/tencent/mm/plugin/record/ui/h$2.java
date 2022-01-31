package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements Runnable
{
  h$2(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(24229);
    ab.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
    this.pZx.notifyDataSetChanged();
    AppMethodBeat.o(24229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h.2
 * JD-Core Version:    0.7.0.1
 */