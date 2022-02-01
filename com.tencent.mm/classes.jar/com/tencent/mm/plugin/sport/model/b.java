package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.fw.a;
import com.tencent.mm.g.a.fw.b;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<ui> ybH;
  public f ybI;
  public c ybN;
  private long ybO;
  private long ybP;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.ybN = new c() {};
    this.ybH = new c() {};
    this.ybN.alive();
    this.ybH.alive();
    AppMethodBeat.o(149286);
  }
  
  private void tA(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.ybO = paramLong;
    k.ax(515, paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void tB(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.ybP = paramLong;
    k.aw(516, this.ybP);
    AppMethodBeat.o(149291);
  }
  
  public final long dFr()
  {
    AppMethodBeat.i(149290);
    if (this.ybP == 0L) {
      this.ybP = k.aw(516, 0L);
    }
    long l = this.ybP;
    AppMethodBeat.o(149290);
    return l;
  }
  
  final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(149287);
    paramb = (fw)paramb;
    switch (paramb.diH.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = h.dFB().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.diI.diL = localJSONObject1.toString();
          }
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(paramb.diI.diL)) {
            continue;
          }
          paramb.diI.diN = 3905;
        }
        catch (Exception localException)
        {
          paramb.diI.diN = 3905;
          continue;
        }
        paramb.diI.diM = true;
        break;
        paramb.diI.diN = 1;
      }
    }
    long l4 = paramb.diH.diK;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.diH.bfb;
    fw.b localb = paramb.diI;
    int i;
    if (!l.dFj()) {
      i = 3906;
    }
    for (;;)
    {
      localb.diN = i;
      if (paramb.diI.diN == 1)
      {
        if (this.ybO == 0L) {
          this.ybO = k.aw(515, 0L);
        }
        boolean bool1 = l.am(this.ybO, System.currentTimeMillis());
        boolean bool2 = l.an(dFr(), l4);
        if ((bool1) && (bool2)) {
          tz(l4);
        }
      }
      paramb.diI.diM = true;
      break;
      if (!l.dFN())
      {
        i = 3902;
      }
      else
      {
        long l3 = k.aw(513, 0L);
        long l2 = k.aw(512, 0L);
        ad.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          ad.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = h.dFB();
          long l1 = l3;
          if (!com.tencent.mm.sdk.platformtools.bt.V(l5, l3))
          {
            l1 = com.tencent.mm.sdk.platformtools.bt.eGJ();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            ad.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label540;
            }
            ad.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label540:
          ad.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { l.mz(l5), Long.valueOf(l4) });
          k.ax(513, l5);
          k.ax(512, l4);
          k.ax(514, l6);
          i = 1;
        }
      }
    }
  }
  
  final boolean tz(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (this.ybI != null) {
      g.aeS().a(this.ybI);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    ad.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { l.mz(l), Long.valueOf(paramLong) });
    this.ybI = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, com.tencent.mm.storage.bt.eMY(), 2);
    g.aeS().a(this.ybI, 0);
    tA(l);
    tB(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */