package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class MainUI$4
  implements Runnable
{
  MainUI$4(MainUI paramMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38622);
    a locala = MainUI.c(this.XCY);
    if (!locala.Xzs)
    {
      locala.Xzs = true;
      q.bhz().d(locala);
      bh.beI();
      c.aHp().add(locala);
      locala.hVT();
    }
    AppMethodBeat.o(38622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.4
 * JD-Core Version:    0.7.0.1
 */