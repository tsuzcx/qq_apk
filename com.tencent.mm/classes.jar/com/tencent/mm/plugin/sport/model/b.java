package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gb.a;
import com.tencent.mm.g.a.gb.b;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cd;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<vp> AYe;
  public f AYf;
  public c AYk;
  private long AYl;
  private long AYm;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.AYk = new c() {};
    this.AYe = new c() {};
    this.AYk.alive();
    this.AYe.alive();
    AppMethodBeat.o(149286);
  }
  
  private void AZ(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.AYl = paramLong;
    k.aD(515, paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void Ba(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.AYm = paramLong;
    k.aC(516, this.AYm);
    AppMethodBeat.o(149291);
  }
  
  final boolean AY(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (this.AYf != null) {
      g.ajj().a(this.AYf);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    ae.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { l.sz(l), Long.valueOf(paramLong) });
    this.AYf = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, cd.fwK(), 2);
    g.ajj().a(this.AYf, 0);
    AZ(l);
    Ba(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
  
  public final long ejO()
  {
    AppMethodBeat.i(149290);
    if (this.AYm == 0L) {
      this.AYm = k.aC(516, 0L);
    }
    long l = this.AYm;
    AppMethodBeat.o(149290);
    return l;
  }
  
  final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(149287);
    paramb = (gb)paramb;
    switch (paramb.dsE.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = h.ejY().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.dsF.dsI = localJSONObject1.toString();
          }
          if (!bu.isNullOrNil(paramb.dsF.dsI)) {
            continue;
          }
          paramb.dsF.dsK = 3905;
        }
        catch (Exception localException)
        {
          paramb.dsF.dsK = 3905;
          continue;
        }
        paramb.dsF.dsJ = true;
        break;
        paramb.dsF.dsK = 1;
      }
    }
    long l4 = paramb.dsE.dsH;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.dsE.bqh;
    gb.b localb = paramb.dsF;
    int i;
    if (!l.ejG()) {
      i = 3906;
    }
    for (;;)
    {
      localb.dsK = i;
      if (paramb.dsF.dsK == 1)
      {
        if (this.AYl == 0L) {
          this.AYl = k.aC(515, 0L);
        }
        boolean bool1 = l.al(this.AYl, System.currentTimeMillis());
        boolean bool2 = l.am(ejO(), l4);
        if ((bool1) && (bool2)) {
          AY(l4);
        }
      }
      paramb.dsF.dsJ = true;
      break;
      if (!l.ekk())
      {
        i = 3902;
      }
      else
      {
        long l3 = k.aC(513, 0L);
        long l2 = k.aC(512, 0L);
        ae.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          ae.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = h.ejY();
          long l1 = l3;
          if (!bu.S(l5, l3))
          {
            l1 = bu.fpJ();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            ae.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label542;
            }
            ae.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label542:
          ae.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { l.sz(l5), Long.valueOf(l4) });
          k.aD(513, l5);
          k.aD(512, l4);
          k.aD(514, l6);
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */