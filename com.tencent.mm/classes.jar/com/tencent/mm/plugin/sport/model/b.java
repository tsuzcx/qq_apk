package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fq.a;
import com.tencent.mm.g.a.fq.b;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<sn> spm;
  public f spn;
  public c sps;
  private long spt;
  private long spu;
  
  public b()
  {
    AppMethodBeat.i(93645);
    this.sps = new b.1(this);
    this.spm = new b.2(this);
    this.sps.alive();
    this.spm.alive();
    AppMethodBeat.o(93645);
  }
  
  private void mq(long paramLong)
  {
    AppMethodBeat.i(93648);
    this.spt = paramLong;
    k.af(515, paramLong);
    AppMethodBeat.o(93648);
  }
  
  private void mr(long paramLong)
  {
    AppMethodBeat.i(93650);
    this.spu = paramLong;
    k.ae(516, this.spu);
    AppMethodBeat.o(93650);
  }
  
  public final long cyE()
  {
    AppMethodBeat.i(93649);
    if (this.spu == 0L) {
      this.spu = k.ae(516, 0L);
    }
    long l = this.spu;
    AppMethodBeat.o(93649);
    return l;
  }
  
  final boolean h(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(93646);
    paramb = (fq)paramb;
    switch (paramb.ctM.action)
    {
    default: 
      AppMethodBeat.o(93646);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = h.cyP().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.ctN.ctQ = localJSONObject1.toString();
          }
          if (!bo.isNullOrNil(paramb.ctN.ctQ)) {
            continue;
          }
          paramb.ctN.ctS = 3905;
        }
        catch (Exception localException)
        {
          paramb.ctN.ctS = 3905;
          continue;
        }
        paramb.ctN.ctR = true;
        break;
        paramb.ctN.ctS = 1;
      }
    }
    long l4 = paramb.ctM.ctP;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.ctM.aJH;
    fq.b localb = paramb.ctN;
    int i;
    if (!n.cyu()) {
      i = 3906;
    }
    for (;;)
    {
      localb.ctS = i;
      if (paramb.ctN.ctS == 1)
      {
        if (this.spt == 0L) {
          this.spt = k.ae(515, 0L);
        }
        boolean bool1 = n.aa(this.spt, System.currentTimeMillis());
        boolean bool2 = n.ab(cyE(), l4);
        if ((bool1) && (bool2)) {
          mp(l4);
        }
      }
      paramb.ctN.ctR = true;
      break;
      if (!n.czb())
      {
        i = 3902;
      }
      else
      {
        long l3 = k.ae(513, 0L);
        long l2 = k.ae(512, 0L);
        ab.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          ab.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = h.cyP();
          long l1 = l3;
          if (!bo.N(l5, l3))
          {
            l1 = bo.dtU();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            ab.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label540;
            }
            ab.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label540:
          ab.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { n.ha(l5), Long.valueOf(l4) });
          k.af(513, l5);
          k.af(512, l4);
          k.af(514, l6);
          i = 1;
        }
      }
    }
  }
  
  final boolean mp(long paramLong)
  {
    AppMethodBeat.i(93647);
    if (this.spn != null) {
      g.Rc().a(this.spn);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    ab.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { n.ha(l), Long.valueOf(paramLong) });
    this.spn = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, bs.dyO(), 2);
    g.Rc().a(this.spn, 0);
    mq(l);
    mr(paramLong);
    AppMethodBeat.o(93647);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */