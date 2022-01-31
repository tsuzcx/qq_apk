package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class MainUI$3
  implements Runnable
{
  MainUI$3(MainUI paramMainUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34494);
    a locala = MainUI.d(this.Alw);
    ab.i("MicroMsg.BannerHelper", "releaseBanner");
    a.fD(locala.AgF);
    a.fD(locala.AgG);
    a.fD(locala.AgH);
    a.fD(locala.AgI);
    Iterator localIterator = locala.AgJ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb != null) {
        localb.release();
      }
    }
    if (aw.RG()) {
      o.acQ().e(locala);
    }
    if (aw.RG())
    {
      aw.aaz();
      c.Ru().b(locala);
    }
    AppMethodBeat.o(34494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.3
 * JD-Core Version:    0.7.0.1
 */