package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.a.ge.a;
import com.tencent.mm.g.a.ge.b;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import java.util.Calendar;
import org.json.JSONObject;

public final class b
{
  public IListener<wp> FiY;
  public e FiZ;
  public IListener Fjg;
  private long Fjh;
  private long Fji;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.Fjg = new IListener() {};
    this.FiY = new IListener() {};
    this.Fjg.alive();
    this.FiY.alive();
    AppMethodBeat.o(149286);
  }
  
  private void Ke(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.Fjh = paramLong;
    j.aK(515, paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void Kf(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.Fji = paramLong;
    j.aJ(516, this.Fji);
    AppMethodBeat.o(149291);
  }
  
  final boolean Kd(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (this.FiZ != null) {
      com.tencent.mm.kernel.g.azz().a(this.FiZ);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    Log.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { k.AF(l), Long.valueOf(paramLong) });
    this.FiZ = new e("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, ck.getFingerprint(), 2);
    com.tencent.mm.kernel.g.azz().a(this.FiZ, 0);
    Ke(l);
    Kf(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
  
  public final long fmo()
  {
    AppMethodBeat.i(149290);
    if (this.Fji == 0L) {
      this.Fji = j.aJ(516, 0L);
    }
    long l = this.Fji;
    AppMethodBeat.o(149290);
    return l;
  }
  
  final boolean i(IEvent paramIEvent)
  {
    AppMethodBeat.i(149287);
    paramIEvent = (ge)paramIEvent;
    switch (paramIEvent.dJP.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1 = g.fmy().optJSONObject("extStepApiConfig");
          if (localJSONObject1 != null) {
            paramIEvent.dJQ.config = localJSONObject1.toString();
          }
          if (!Util.isNullOrNil(paramIEvent.dJQ.config)) {
            continue;
          }
          paramIEvent.dJQ.dJU = 3905;
        }
        catch (Exception localException)
        {
          paramIEvent.dJQ.dJU = 3905;
          continue;
        }
        paramIEvent.dJQ.dJT = true;
        break;
        paramIEvent.dJQ.dJU = 1;
      }
    }
    long l4 = paramIEvent.dJP.dJS;
    long l5 = System.currentTimeMillis();
    long l6 = paramIEvent.dJP.bqc;
    ge.b localb = paramIEvent.dJQ;
    int i;
    if (!k.fmg()) {
      i = 3906;
    }
    for (;;)
    {
      localb.dJU = i;
      if (paramIEvent.dJQ.dJU == 1)
      {
        if (this.Fjh == 0L) {
          this.Fjh = j.aJ(515, 0L);
        }
        boolean bool1 = k.ar(this.Fjh, System.currentTimeMillis());
        boolean bool2 = k.as(fmo(), l4);
        if ((bool1) && (bool2)) {
          Kd(l4);
        }
      }
      paramIEvent.dJQ.dJT = true;
      break;
      if (!k.fmK())
      {
        i = 3902;
      }
      else
      {
        long l3 = j.aJ(513, 0L);
        long l2 = j.aJ(512, 0L);
        Log.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        if (l5 - l3 < 300000L)
        {
          Log.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
          i = 3903;
        }
        else
        {
          JSONObject localJSONObject2 = g.fmy();
          long l1 = l3;
          if (!Util.isSameDay(l5, l3))
          {
            l1 = Util.getBeginTimeOfToday();
            l2 = 0L;
          }
          l3 = l5 - l1;
          long l7 = l3 / 300000L;
          if (l3 % 300000L > 0L) {}
          for (i = 1;; i = 0)
          {
            long l8 = l7 + i;
            l7 = localJSONObject2.optInt("stepCounterMaxStep5m") * l8;
            Log.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
            l1 = l4 - l2;
            if ((l1 >= 0L) && (l1 <= l7)) {
              break label541;
            }
            Log.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
            i = 3904;
            break;
          }
          label541:
          Log.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { k.AF(l5), Long.valueOf(l4) });
          j.aK(513, l5);
          j.aK(512, l4);
          j.aK(514, l6);
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