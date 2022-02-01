package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  HashMap<String, Integer> HaR;
  int HaS;
  int HaT;
  i HaU;
  com.tencent.mm.sdk.b.c HaV;
  com.tencent.mm.sdk.b.c HaW;
  com.tencent.mm.sdk.b.c HaX;
  ListView Hal;
  Activity activity;
  
  public e()
  {
    AppMethodBeat.i(38296);
    this.HaR = new HashMap();
    this.HaS = -1;
    this.HaT = -1;
    this.HaV = new com.tencent.mm.sdk.b.c() {};
    this.HaW = new com.tencent.mm.sdk.b.c() {};
    this.HaX = new com.tencent.mm.sdk.b.c()
    {
      long Hba;
      int Hbb;
      private final long INTERVAL;
    };
    AppMethodBeat.o(38296);
  }
  
  final am aLy(String paramString)
  {
    AppMethodBeat.i(38299);
    if (this.HaU != null)
    {
      paramString = (am)this.HaU.dU(paramString);
      AppMethodBeat.o(38299);
      return paramString;
    }
    AppMethodBeat.o(38299);
    return null;
  }
  
  public final void bi(Activity paramActivity)
  {
    AppMethodBeat.i(38297);
    this.HaT = ((LauncherUI)paramActivity).FMb.getMainTabUI().eRn();
    AppMethodBeat.o(38297);
  }
  
  public final void fbW()
  {
    AppMethodBeat.i(38298);
    if (this.activity == null)
    {
      AppMethodBeat.o(38298);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = (LauncherUI)this.activity;
    ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", new Object[] { Integer.valueOf(this.HaS) });
    switch (this.HaS)
    {
    default: 
      this.HaT = ((LauncherUI)localObject1).FMb.getMainTabUI().eRn();
      ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", new Object[] { Integer.valueOf(this.HaT), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(38298);
      return;
    case 2: 
      Iterator localIterator = this.HaR.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject2).getKey();
        j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
        ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", new Object[] { str, Integer.valueOf(j) });
        localObject2 = aLy(str);
        if ((localObject2 == null) || (aj.Za().contains(str)))
        {
          j = 0 - j;
          ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          label273:
          if ((j != 0) && (this.HaU.aLz(str)))
          {
            ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", new Object[] { str });
            az.arV();
            localObject2 = com.tencent.mm.model.c.apM().aHY(str);
            if (localObject2 == null) {
              continue;
            }
            if (!w.pF(str)) {
              break label415;
            }
            if (((au)localObject2).evx == 0) {
              continue;
            }
          }
        }
        for (;;)
        {
          i += j;
          ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(i) });
          break;
          j = ((ay)localObject2).field_unReadCount - j + 0;
          ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
          break label273;
          label415:
          if (((af)localObject2).Ny()) {
            break;
          }
        }
      }
      this.HaT += i;
      localObject1 = ((LauncherUI)localObject1).FMb.getMainTabUI();
      int j = this.HaT;
      ((MainTabUI)localObject1).FPE.Xu(j);
      ad.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", new Object[] { Integer.valueOf(this.HaT), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(38298);
      return;
    }
    AppMethodBeat.o(38298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e
 * JD-Core Version:    0.7.0.1
 */