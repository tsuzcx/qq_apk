package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.gl;
import com.tencent.mm.f.a.gl.a;
import com.tencent.mm.f.a.gl.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.ILifecycleEventObserver;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cl;
import java.util.Calendar;
import org.json.JSONObject;

public class b
{
  private ILifecycleEventObserver<Integer> LxB;
  public e LxC;
  public IListener LxG;
  private long LxH;
  private long LxI;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.LxG = new b.1(this);
    this.LxB = new ILifecycleEventObserver() {};
    ((c)LifecycleEventCenter.getEvent(c.class)).observe(h.aHE().kbJ, "UploadSportStepEventHandle", this.LxB);
    this.LxG.alive();
    AppMethodBeat.o(149286);
  }
  
  private boolean Rx(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (paramLong <= 0L)
    {
      Log.i("MicroMsg.Sport.ExtApiStepManager", "invalid step %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(149288);
      return false;
    }
    if (this.LxC != null) {
      h.aGY().a(this.LxC);
    }
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    Log.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { n.GN(l), Long.valueOf(paramLong) });
    this.LxC = new e("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, cl.hAM(), 2);
    h.aGY().a(this.LxC, 0);
    Ry(l);
    Rz(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
  
  private void Ry(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.LxH = paramLong;
    m localm = m.Lyn;
    m.bw("KEY_LAST_UPLOAD_EXT_API_STEP_TIME_LONG", paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void Rz(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.LxI = paramLong;
    m localm = m.Lyn;
    m.bw("KEY_LAST_UPLOAD_EXT_API_STEP_COUNT_LONG", this.LxI);
    AppMethodBeat.o(149291);
  }
  
  public static long gaG()
  {
    AppMethodBeat.i(221630);
    long l1 = n.gba();
    Object localObject = m.Lyn;
    long l2 = m.bv("KEY_EXT_API_LAST_STEP_TIME_LONG", 0L);
    localObject = m.Lyn;
    long l3 = m.bv("KEY_EXT_API_TODAY_STEP_LONG", 0L);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l2);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(14, 0);
    if (l1 == ((Calendar)localObject).getTimeInMillis())
    {
      AppMethodBeat.o(221630);
      return l3;
    }
    AppMethodBeat.o(221630);
    return 0L;
  }
  
  private boolean i(IEvent paramIEvent)
  {
    AppMethodBeat.i(149287);
    gl localgl = (gl)paramIEvent;
    Object localObject;
    switch (localgl.fCE.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = k.gaS();
          localObject = localJSONObject.optJSONObject("extStepApiConfig");
          paramIEvent = (IEvent)localObject;
          if (localObject == null) {
            paramIEvent = localJSONObject.optJSONObject("stepExtConfig");
          }
          if (paramIEvent != null) {
            localgl.fCF.config = paramIEvent.toString();
          }
          if (!Util.isNullOrNil(localgl.fCF.config)) {
            continue;
          }
          localgl.fCF.fCJ = 3905;
        }
        catch (Exception paramIEvent)
        {
          localgl.fCF.fCJ = 3905;
          continue;
        }
        localgl.fCF.fCI = true;
        break;
        localgl.fCF.fCJ = 1;
      }
    }
    long l4 = localgl.fCE.fCH;
    long l5 = System.currentTimeMillis();
    long l6 = localgl.fCE.aZE;
    Log.i("MicroMsg.Sport.ExtApiStepManager", "ExtStepCountEvent PASSIVE_UPDATE stepCount:%s timestamp:%s version:%s", new Object[] { Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6) });
    paramIEvent = localgl.fCF;
    int i;
    if (!n.gaC())
    {
      i = 3906;
      label234:
      paramIEvent.fCJ = i;
      if (localgl.fCF.fCJ == 1)
      {
        boolean bool1 = n.aC(gaJ(), l5);
        boolean bool2 = n.aD(gaK(), l4);
        if ((!bool1) || (!bool2)) {
          break label678;
        }
        Rx(l4);
        f.Iyx.idkeyStat(323L, 7L, 1L, false);
      }
    }
    for (;;)
    {
      localgl.fCF.fCI = true;
      break;
      if (!n.gbd())
      {
        i = 3902;
        break label234;
      }
      localObject = m.Lyn;
      long l3 = m.bv("KEY_EXT_API_LAST_STEP_TIME_LONG", 0L);
      localObject = m.Lyn;
      long l2 = m.bv("KEY_EXT_API_TODAY_STEP_LONG", 0L);
      Log.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
      if (l5 - l3 < 300000L)
      {
        Log.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
        i = 3903;
        break label234;
      }
      localObject = k.gaS();
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
        l7 = ((JSONObject)localObject).optInt("stepCounterMaxStep5m") * l8;
        Log.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[] { Long.valueOf(l8), Long.valueOf(l3), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l7) });
        l1 = l4 - l2;
        if ((l1 >= 0L) && (l1 <= l7)) {
          break label608;
        }
        Log.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
        i = 3904;
        break;
      }
      label608:
      Log.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { n.GN(l5), Long.valueOf(l4) });
      localObject = m.Lyn;
      m.bw("KEY_EXT_API_LAST_STEP_TIME_LONG", l5);
      localObject = m.Lyn;
      m.bw("KEY_EXT_API_TODAY_STEP_LONG", l4);
      localObject = m.Lyn;
      m.bw("KEY_EXT_API_VERSION_LONG", l6);
      i = 1;
      break label234;
      label678:
      f.Iyx.idkeyStat(323L, 8L, 1L, false);
    }
  }
  
  public final long gaJ()
  {
    AppMethodBeat.i(221635);
    if (this.LxH == 0L)
    {
      m localm = m.Lyn;
      this.LxH = m.bv("KEY_LAST_UPLOAD_EXT_API_STEP_TIME_LONG", 0L);
    }
    long l = this.LxH;
    AppMethodBeat.o(221635);
    return l;
  }
  
  public final long gaK()
  {
    AppMethodBeat.i(149290);
    if (this.LxI == 0L)
    {
      m localm = m.Lyn;
      this.LxI = m.bv("KEY_LAST_UPLOAD_EXT_API_STEP_COUNT_LONG", 0L);
    }
    long l = this.LxI;
    AppMethodBeat.o(149290);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */