package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fx.a;
import com.tencent.mm.g.a.fx.b;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bw;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<us> zoH;
  public f zoI;
  public c zoN;
  private long zoO;
  private long zoP;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.zoN = new c() {};
    this.zoH = new c() {};
    this.zoN.alive();
    this.zoH.alive();
    AppMethodBeat.o(149286);
  }
  
  private void yd(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.zoO = paramLong;
    k.aw(515, paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void ye(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.zoP = paramLong;
    k.av(516, this.zoP);
    AppMethodBeat.o(149291);
  }
  
  public final long dTS()
  {
    AppMethodBeat.i(149290);
    if (this.zoP == 0L) {
      this.zoP = k.av(516, 0L);
    }
    long l = this.zoP;
    AppMethodBeat.o(149290);
    return l;
  }
  
  final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(149287);
    paramb = (fx)paramb;
    switch (paramb.dgc.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = h.dUc().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.dgd.dgg = localJSONObject1.toString();
          }
          if (!bs.isNullOrNil(paramb.dgd.dgg)) {
            continue;
          }
          paramb.dgd.dgi = 3905;
        }
        catch (Exception localException)
        {
          paramb.dgd.dgi = 3905;
          continue;
        }
        paramb.dgd.dgh = true;
        break;
        paramb.dgd.dgi = 1;
      }
    }
    long l4 = paramb.dgc.dgf;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.dgc.bfN;
    fx.b localb = paramb.dgd;
    int i;
    if (!l.dTK()) {
      i = 3906;
    }
    for (;;)
    {
      localb.dgi = i;
      if (paramb.dgd.dgi == 1)
      {
        if (this.zoO == 0L) {
          this.zoO = k.av(515, 0L);
        }
        boolean bool1 = l.aj(this.zoO, System.currentTimeMillis());
        boolean bool2 = l.ak(dTS(), l4);
        if ((bool1) && (bool2)) {
          yc(l4);
        }
      }
      paramb.dgd.dgh = true;
      break;
      if (!l.dUo())
      {
        i = 3902;
      }
      else
      {
        long l3 = k.av(513, 0L);
        long l2 = k.av(512, 0L);
        ac.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          ac.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = h.dUc();
          long l1 = l3;
          if (!bs.S(l5, l3))
          {
            l1 = bs.eWe();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            ac.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label540;
            }
            ac.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label540:
          ac.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { l.qn(l5), Long.valueOf(l4) });
          k.aw(513, l5);
          k.aw(512, l4);
          k.aw(514, l6);
          i = 1;
        }
      }
    }
  }
  
  final boolean yc(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (this.zoI != null) {
      g.agi().a(this.zoI);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    ac.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { l.qn(l), Long.valueOf(paramLong) });
    this.zoI = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, bw.fcC(), 2);
    g.agi().a(this.zoI, 0);
    yd(l);
    ye(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */