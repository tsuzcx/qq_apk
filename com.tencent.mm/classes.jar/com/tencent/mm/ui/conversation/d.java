package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.mm.h.a.jm;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  Activity activity;
  HashMap<String, Integer> vPD = new HashMap();
  int vPE = -1;
  public int vPF = -1;
  h vPG;
  com.tencent.mm.sdk.b.c vPH = new d.1(this);
  com.tencent.mm.sdk.b.c vPI = new d.2(this);
  com.tencent.mm.sdk.b.c vPJ = new com.tencent.mm.sdk.b.c()
  {
    private final long INTERVAL = 3000L;
    long vPM = 0L;
    int vPN = -1;
  };
  ListView vPc;
  
  public final void ad(Activity paramActivity)
  {
    this.vPF = ((LauncherUI)paramActivity).uKP.uKi.czP();
  }
  
  final ak adX(String paramString)
  {
    if (this.vPG != null) {
      return (ak)this.vPG.bZ(paramString);
    }
    return null;
  }
  
  public final void cHV()
  {
    if (this.activity == null) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = (LauncherUI)this.activity;
    y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", new Object[] { Integer.valueOf(this.vPE) });
    switch (this.vPE)
    {
    case 1: 
    default: 
      this.vPF = ((LauncherUI)localObject1).uKP.uKi.czP();
      y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", new Object[] { Integer.valueOf(this.vPF), Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    Iterator localIterator = this.vPD.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", new Object[] { str, Integer.valueOf(j) });
      localObject2 = adX(str);
      if ((localObject2 == null) || (al.cAh().contains(str)))
      {
        j = 0 - j;
        y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
        label256:
        if ((j != 0) && (this.vPG.adY(str)))
        {
          y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", new Object[] { str });
          au.Hx();
          localObject2 = com.tencent.mm.model.c.Fw().abl(str);
          if (localObject2 == null) {
            continue;
          }
          if (!s.fn(str)) {
            break label398;
          }
          if (((ao)localObject2).cCy == 0) {
            continue;
          }
        }
      }
      for (;;)
      {
        i += j;
        y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", new Object[] { str, Integer.valueOf(j), Integer.valueOf(i) });
        break;
        j = ((as)localObject2).field_unReadCount - j + 0;
        y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", new Object[] { str, Integer.valueOf(j) });
        break label256;
        label398:
        if (((ad)localObject2).Bj()) {
          break;
        }
      }
    }
    this.vPF += i;
    localObject1 = ((LauncherUI)localObject1).uKP.uKi;
    int j = this.vPF;
    ((z)localObject1).uOE.Ga(j);
    y.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", new Object[] { Integer.valueOf(this.vPF), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d
 * JD-Core Version:    0.7.0.1
 */