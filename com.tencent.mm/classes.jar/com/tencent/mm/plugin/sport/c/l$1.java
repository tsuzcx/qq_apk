package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.bvw;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class l$1
  implements f
{
  l$1(l paraml) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof d))
    {
      g.Dk().b(1734, this.ptG.eeo);
      paramString = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject = paramString.pto;
        Collections.sort(((akr)localObject).tgO, new l.1.1(this));
        paramm = Calendar.getInstance();
        paramm.setTimeInMillis(((bvw)((akr)localObject).tgO.get(0)).timestamp * 1000L);
        paramm.set(10, 0);
        paramm.set(12, 0);
        paramm.set(13, 0);
        long l = paramm.getTimeInMillis();
        ((PluginSport)g.t(PluginSport.class)).getSportStepStorage();
        m.K(paramString.ptn.sQR, paramString.ptn.sQS);
        y.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", new Object[] { this.ptG.ptF.format(new Date(l)) });
        paramm = new ArrayList();
        localObject = ((akr)localObject).tgO.iterator();
        while (((Iterator)localObject).hasNext())
        {
          bvw localbvw = (bvw)((Iterator)localObject).next();
          e locale = new e();
          locale.field_step = localbvw.ghE;
          locale.field_timestamp = (localbvw.timestamp * 1000L);
          locale.field_date = this.ptG.ptF.format(new Date(locale.field_timestamp));
          paramm.add(locale);
        }
        ((PluginSport)g.t(PluginSport.class)).getSportStepStorage();
        m.cM(paramm);
        if (paramString.ptp != null) {
          paramString.ptp.pP();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.l.1
 * JD-Core Version:    0.7.0.1
 */