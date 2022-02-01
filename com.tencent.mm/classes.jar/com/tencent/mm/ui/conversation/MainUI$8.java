package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

final class MainUI$8
  implements Runnable
{
  MainUI$8(MainUI paramMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(280829);
    a locala = MainUI.c(this.XCY);
    Log.i("MicroMsg.BannerHelper", "destroyBanner");
    locala.hFe();
    a.kP(locala.Xzi);
    a.kP(locala.Xzj);
    a.kP(locala.Xzk);
    a.kP(locala.Xzl);
    Iterator localIterator = locala.Xzm.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.destroy();
      }
    }
    bh.b(locala.MjF);
    EventCenter.instance.removeListener(locala.Xzo);
    EventCenter.instance.removeListener(locala.Xzp);
    if (bh.aHB())
    {
      bh.beI();
      c.b(locala);
    }
    locala.context = null;
    AppMethodBeat.o(280829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.8
 * JD-Core Version:    0.7.0.1
 */