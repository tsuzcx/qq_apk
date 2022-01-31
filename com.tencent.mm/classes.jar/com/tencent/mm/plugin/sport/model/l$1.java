package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(93699);
    if ((paramm instanceof d))
    {
      g.Rc().b(1734, this.spX.fur);
      paramString = (d)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject = paramString.spD;
        Collections.sort(((aqe)localObject).xfC, new l.1.1(this));
        paramm = Calendar.getInstance();
        paramm.setTimeInMillis(((cgp)((aqe)localObject).xfC.get(0)).timestamp * 1000L);
        paramm.set(10, 0);
        paramm.set(12, 0);
        paramm.set(13, 0);
        long l = paramm.getTimeInMillis();
        ((PluginSport)g.G(PluginSport.class)).getSportStepStorage();
        m.Z(paramString.spC.wPH, paramString.spC.wPI);
        ab.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", new Object[] { this.spX.spW.format(new Date(l)) });
        paramm = new ArrayList();
        localObject = ((aqe)localObject).xfC.iterator();
        while (((Iterator)localObject).hasNext())
        {
          cgp localcgp = (cgp)((Iterator)localObject).next();
          e locale = new e();
          locale.field_step = localcgp.hAu;
          locale.field_timestamp = (localcgp.timestamp * 1000L);
          locale.field_date = this.spX.spW.format(new Date(locale.field_timestamp));
          paramm.add(locale);
        }
        ((PluginSport)g.G(PluginSport.class)).getSportStepStorage();
        m.dy(paramm);
        if (paramString.cyI() != null) {
          paramString.cyI().tT();
        }
        AppMethodBeat.o(93699);
        return;
      }
      if (paramString.cyI() != null) {
        paramString.cyI();
      }
    }
    AppMethodBeat.o(93699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.l.1
 * JD-Core Version:    0.7.0.1
 */