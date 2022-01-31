package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$4$1
  implements Runnable
{
  m$4$1(m.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(34595);
    ab.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
    if (this.AlT.AlR.Ahr != null) {
      this.AlT.AlR.Ahr.notifyDataSetChanged();
    }
    AppMethodBeat.o(34595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.4.1
 * JD-Core Version:    0.7.0.1
 */