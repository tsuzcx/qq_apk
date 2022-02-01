package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.ga.a;
import com.tencent.mm.g.a.ga.b;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.cc;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<vl> AGB;
  public f AGC;
  public c AGH;
  private long AGI;
  private long AGJ;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.AGH = new c() {};
    this.AGB = new c() {};
    this.AGH.alive();
    this.AGB.alive();
    AppMethodBeat.o(149286);
  }
  
  private void AB(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.AGI = paramLong;
    k.aD(515, paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void AC(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.AGJ = paramLong;
    k.aC(516, this.AGJ);
    AppMethodBeat.o(149291);
  }
  
  final boolean AA(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (this.AGC != null) {
      g.aiU().a(this.AGC);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    ad.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { l.sm(l), Long.valueOf(paramLong) });
    this.AGC = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, cc.fsJ(), 2);
    g.aiU().a(this.AGC, 0);
    AB(l);
    AC(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
  
  public final long egg()
  {
    AppMethodBeat.i(149290);
    if (this.AGJ == 0L) {
      this.AGJ = k.aC(516, 0L);
    }
    long l = this.AGJ;
    AppMethodBeat.o(149290);
    return l;
  }
  
  final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(149287);
    paramb = (ga)paramb;
    switch (paramb.dry.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = h.egq().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.drz.drC = localJSONObject1.toString();
          }
          if (!bt.isNullOrNil(paramb.drz.drC)) {
            continue;
          }
          paramb.drz.drE = 3905;
        }
        catch (Exception localException)
        {
          paramb.drz.drE = 3905;
          continue;
        }
        paramb.drz.drD = true;
        break;
        paramb.drz.drE = 1;
      }
    }
    long l4 = paramb.dry.drB;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.dry.bqh;
    ga.b localb = paramb.drz;
    int i;
    if (!l.efY()) {
      i = 3906;
    }
    for (;;)
    {
      localb.drE = i;
      if (paramb.drz.drE == 1)
      {
        if (this.AGI == 0L) {
          this.AGI = k.aC(515, 0L);
        }
        boolean bool1 = l.am(this.AGI, System.currentTimeMillis());
        boolean bool2 = l.an(egg(), l4);
        if ((bool1) && (bool2)) {
          AA(l4);
        }
      }
      paramb.drz.drD = true;
      break;
      if (!l.egC())
      {
        i = 3902;
      }
      else
      {
        long l3 = k.aC(513, 0L);
        long l2 = k.aC(512, 0L);
        ad.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          ad.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = h.egq();
          long l1 = l3;
          if (!bt.T(l5, l3))
          {
            l1 = bt.flO();
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
              break label542;
            }
            ad.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label542:
          ad.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { l.sm(l5), Long.valueOf(l4) });
          k.aD(513, l5);
          k.aD(512, l4);
          k.aD(514, l6);
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */