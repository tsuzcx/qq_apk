package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;

final class MainUI$5
  implements h.b
{
  MainUI$5(MainUI paramMainUI) {}
  
  public final void dMN()
  {
    AppMethodBeat.i(154003);
    MainUI.b(this.Alw).clearCache();
    aw.aaz();
    c.YF().a(MainUI.b(this.Alw));
    aw.aaz();
    c.YA().a(MainUI.b(this.Alw));
    AppMethodBeat.o(154003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.5
 * JD-Core Version:    0.7.0.1
 */