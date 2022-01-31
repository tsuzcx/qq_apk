package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  ListView AgN;
  HashMap<String, Integer> Aho;
  int Ahp;
  int Ahq;
  h Ahr;
  com.tencent.mm.sdk.b.c Ahs;
  com.tencent.mm.sdk.b.c Aht;
  com.tencent.mm.sdk.b.c Ahu;
  Activity activity;
  
  public d()
  {
    AppMethodBeat.i(34181);
    this.Aho = new HashMap();
    this.Ahp = -1;
    this.Ahq = -1;
    this.Ahs = new d.1(this);
    this.Aht = new d.2(this);
    this.Ahu = new d.3(this);
    AppMethodBeat.o(34181);
  }
  
  public final void aF(Activity paramActivity)
  {
    AppMethodBeat.i(34182);
    this.Ahq = ((LauncherUI)paramActivity).yYT.getMainTabUI().dCJ();
    AppMethodBeat.o(34182);
  }
  
  final ak auF(String paramString)
  {
    AppMethodBeat.i(34184);
    if (this.Ahr != null)
    {
      paramString = (ak)this.Ahr.cE(paramString);
      AppMethodBeat.o(34184);
      return paramString;
    }
    AppMethodBeat.o(34184);
    return null;
  }
  
  public final void dMp()
  {
    AppMethodBeat.i(34183);
    if (this.activity == null)
    {
      AppMethodBeat.o(34183);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = (LauncherUI)this.activity;
    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", new Object[] { Integer.valueOf(this.Ahp) });
    switch (this.Ahp)
    {
    default: 
      this.Ahq = ((LauncherUI)localObject1).yYT.getMainTabUI().dCJ();
      ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", new Object[] { Integer.valueOf(this.Ahq), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(34183);
      return;
    case 2: 
      Iterator localIterator = this.Aho.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", new Object[] { str, Integer.valueOf(j) });
        localObject2 = auF(str);
        if ((localObject2 == null) || (ag.Nn().contains(str)))
        {
          j = 0 - j;
          ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          label273:
          if ((j != 0) && (this.Ahr.auG(str)))
          {
            ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", new Object[] { str });
            aw.aaz();
            localObject2 = com.tencent.mm.model.c.YA().arw(str);
            if (localObject2 == null) {
              continue;
            }
            if (!t.lA(str)) {
              break label415;
            }
            if (((aq)localObject2).dqK == 0) {
              continue;
            }
          }
        }
        for (;;)
        {
          i += j;
          ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(i) });
          break;
          j = ((au)localObject2).field_unReadCount - j + 0;
          ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          break label273;
          label415:
          if (((ad)localObject2).DP()) {
            break;
          }
        }
      }
      this.Ahq += i;
      localObject1 = ((LauncherUI)localObject1).yYT.getMainTabUI();
      int j = this.Ahq;
      ((MainTabUI)localObject1).zcx.Oo(j);
      ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", new Object[] { Integer.valueOf(this.Ahq), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(34183);
      return;
    }
    AppMethodBeat.o(34183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */