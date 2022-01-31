package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.fn;
import com.tencent.mm.h.a.fn.a;
import com.tencent.mm.h.a.fn.b;
import com.tencent.mm.h.a.rb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public c<rb> ptc = new b.2(this);
  public f ptd;
  public c ptj = new b.1(this);
  private long ptk;
  private long ptl;
  
  public b()
  {
    this.ptj.cqo();
    this.ptc.cqo();
  }
  
  public final long bLk()
  {
    if (this.ptl == 0L) {
      this.ptl = i.Q(516, 0L);
    }
    return this.ptl;
  }
  
  final boolean gF(long paramLong)
  {
    if (this.ptd != null) {
      com.tencent.mm.kernel.g.Dk().c(this.ptd);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    y.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { n.ce(l), Long.valueOf(paramLong) });
    this.ptd = new f("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, bs.cwc(), 2);
    com.tencent.mm.kernel.g.Dk().a(this.ptd, 0);
    this.ptk = l;
    i.R(515, l);
    this.ptl = paramLong;
    i.Q(516, this.ptl);
    return true;
  }
  
  final boolean i(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (fn)paramb;
    switch (paramb.bMr.action)
    {
    default: 
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = g.bLn().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramb.bMs.bMw = localJSONObject1.toString();
          }
          if (!bk.bl(paramb.bMs.bMw)) {
            continue;
          }
          paramb.bMs.bMy = 3905;
        }
        catch (Exception localException)
        {
          paramb.bMs.bMy = 3905;
          continue;
        }
        paramb.bMs.bMx = true;
        break;
        paramb.bMs.bMy = 1;
      }
    }
    long l4 = paramb.bMr.bMu;
    long l5 = System.currentTimeMillis();
    long l6 = paramb.bMr.bMv;
    fn.b localb = paramb.bMs;
    int i;
    if (!n.bKY()) {
      i = 3906;
    }
    for (;;)
    {
      localb.bMy = i;
      if (paramb.bMs.bMy == 1)
      {
        if (this.ptk == 0L) {
          this.ptk = i.Q(515, 0L);
        }
        boolean bool1 = n.L(this.ptk, System.currentTimeMillis());
        boolean bool2 = n.M(bLk(), l4);
        if ((bool1) && (bool2)) {
          gF(l4);
        }
      }
      paramb.bMs.bMx = true;
      break;
      if (!n.bLu())
      {
        i = 3902;
      }
      else
      {
        long l3 = i.Q(513, 0L);
        long l2 = i.Q(512, 0L);
        y.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          y.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = g.bLn();
          long l1 = l3;
          if (!bk.B(l5, l3))
          {
            l1 = bk.crX();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            y.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label531;
            }
            y.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label531:
          y.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { n.ce(l5), Long.valueOf(l4) });
          i.R(513, l5);
          i.R(512, l4);
          i.R(514, l6);
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.b
 * JD-Core Version:    0.7.0.1
 */