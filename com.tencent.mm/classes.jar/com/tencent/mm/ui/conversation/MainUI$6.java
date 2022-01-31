package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.f.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class MainUI$6
  implements f.a
{
  MainUI$6(MainUI paramMainUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(154006);
    MainUI.c(this.Alw).dMp();
    h localh;
    if (MainUI.b(this.Alw) != null)
    {
      localh = MainUI.b(this.Alw);
      if ((localh.zte != null) && (localh.AjY != null) && (!localh.AjY.isEmpty())) {}
    }
    else
    {
      MainUI.a(this.Alw).post(new MainUI.6.1(this));
      AppMethodBeat.o(154006);
      return;
    }
    if (localh.AjZ)
    {
      localh.zte.clear();
      localh.AjZ = false;
    }
    for (;;)
    {
      localh.AjY.clear();
      break;
      ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", new Object[] { Integer.valueOf(localh.AjY.size()) });
      Iterator localIterator = localh.AjY.iterator();
      while (localIterator.hasNext()) {
        localh.zte.remove(localIterator.next());
      }
    }
  }
  
  public final void dBh()
  {
    AppMethodBeat.i(154005);
    g.Cx(12);
    d locald = MainUI.c(this.Alw);
    locald.Ahp = -1;
    locald.Aho.clear();
    if ((locald.Ahr == null) || (locald.Ahq < 0) || (!locald.Ahr.dzM()))
    {
      locald.Ahp = 0;
      AppMethodBeat.o(154005);
      return;
    }
    if (locald.Ahr.AjZ)
    {
      locald.Ahp = 0;
      AppMethodBeat.o(154005);
      return;
    }
    if (locald.Ahr.AjX)
    {
      ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
      locald.Ahp = 0;
      locald.Ahr.AjX = false;
      AppMethodBeat.o(154005);
      return;
    }
    Object localObject1 = (HashSet)locald.Ahr.AjY.clone();
    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", new Object[] { Integer.valueOf(((HashSet)localObject1).size()) });
    if (((HashSet)localObject1).contains("floatbottle"))
    {
      locald.Ahp = 0;
      AppMethodBeat.o(154005);
      return;
    }
    ((HashSet)localObject1).remove("officialaccounts");
    if (((HashSet)localObject1).isEmpty())
    {
      locald.Ahp = 1;
      AppMethodBeat.o(154005);
      return;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = locald.Ahr;
      boolean bool;
      if (((h)localObject2).auG(str)) {
        bool = false;
      }
      for (;;)
      {
        if (bool) {
          break label351;
        }
        localObject2 = locald.auF(str);
        if (localObject2 != null) {
          break label353;
        }
        locald.Aho.put(str, Integer.valueOf(0));
        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(0) });
        break;
        localObject2 = (h.d)((h)localObject2).zte.get(str);
        if (localObject2 == null) {
          bool = false;
        } else if (t.lA(str)) {
          bool = ((h.d)localObject2).Aie;
        } else {
          bool = ((h.d)localObject2).Aia;
        }
      }
      label351:
      continue;
      label353:
      locald.Aho.put(str, Integer.valueOf(((au)localObject2).field_unReadCount));
      ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", new Object[] { str, Integer.valueOf(((au)localObject2).field_unReadCount) });
    }
    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", new Object[] { Integer.valueOf(locald.Aho.size()) });
    if (locald.Aho.isEmpty())
    {
      locald.Ahp = 1;
      AppMethodBeat.o(154005);
      return;
    }
    if (locald.Aho.size() > 20)
    {
      locald.Ahp = 0;
      AppMethodBeat.o(154005);
      return;
    }
    locald.Ahp = 2;
    AppMethodBeat.o(154005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.MainUI.6
 * JD-Core Version:    0.7.0.1
 */