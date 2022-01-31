package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(34173);
    ab.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
    this.Ahw.Ahv.Ahr.notifyDataSetChanged();
    this.Ahw.Ahv.dMp();
    AppMethodBeat.o(34173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d.1.1
 * JD-Core Version:    0.7.0.1
 */