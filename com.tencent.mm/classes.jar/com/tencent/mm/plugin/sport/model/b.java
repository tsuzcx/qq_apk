package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.gw;
import com.tencent.mm.autogen.a.gw.a;
import com.tencent.mm.autogen.a.gw.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.co;
import java.util.Calendar;
import org.json.JSONObject;

public class b
{
  private IMvvmObserver<Integer> Sbn;
  public e Sbo;
  public IListener Sbs;
  private long Sbt;
  private long Sbu;
  
  public b()
  {
    AppMethodBeat.i(149286);
    this.Sbs = new ExtApiStepManager.1(this, com.tencent.mm.app.f.hfK);
    this.Sbn = new IMvvmObserver() {};
    ((c)MvvmEventCenter.getEvent(c.class)).observe(h.baC().mBP, "UploadSportStepEventHandle", this.Sbn);
    this.Sbs.alive();
    AppMethodBeat.o(149286);
  }
  
  public static long htX()
  {
    AppMethodBeat.i(263911);
    long l1 = p.hut();
    Object localObject = n.Scc;
    long l2 = n.bH("KEY_EXT_API_LAST_STEP_TIME_LONG", 0L);
    localObject = n.Scc;
    long l3 = n.bH("KEY_EXT_API_TODAY_STEP_LONG", 0L);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l2);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(14, 0);
    if (l1 == ((Calendar)localObject).getTimeInMillis())
    {
      AppMethodBeat.o(263911);
      return l3;
    }
    AppMethodBeat.o(263911);
    return 0L;
  }
  
  private boolean i(IEvent paramIEvent)
  {
    AppMethodBeat.i(149287);
    gw localgw = (gw)paramIEvent;
    Object localObject;
    switch (localgw.hHt.action)
    {
    default: 
      AppMethodBeat.o(149287);
      return true;
    case 3: 
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = k.huj();
          localObject = localJSONObject.optJSONObject("extStepApiConfig");
          paramIEvent = (IEvent)localObject;
          if (localObject == null) {
            paramIEvent = localJSONObject.optJSONObject("stepExtConfig");
          }
          if (paramIEvent != null) {
            localgw.hHu.config = paramIEvent.toString();
          }
          if (!Util.isNullOrNil(localgw.hHu.config)) {
            continue;
          }
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 5L, 1L, false);
          localgw.hHu.hHy = 3905;
        }
        catch (Exception paramIEvent)
        {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 6L, 1L, false);
          localgw.hHu.hHy = 3905;
          continue;
        }
        localgw.hHu.hHx = true;
        break;
        localgw.hHu.hHy = 1;
      }
    }
    long l4 = localgw.hHt.hHw;
    long l5 = cn.bDw();
    long l6 = localgw.hHt.cTz;
    Log.i("MicroMsg.Sport.ExtApiStepManager", "ExtStepCountEvent PASSIVE_UPDATE stepCount:%s timestamp:%s version:%s", new Object[] { Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6) });
    paramIEvent = localgw.hHu;
    int i;
    if (!p.htT())
    {
      i = 3906;
      label261:
      paramIEvent.hHy = i;
      if (localgw.hHu.hHy != 1) {
        break label712;
      }
      boolean bool1 = p.bm(hua(), l5);
      boolean bool2 = p.bn(hub(), l4);
      if ((!bool1) || (!bool2)) {
        break label695;
      }
      vH(l4);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 1L, 1L, false);
    }
    for (;;)
    {
      localgw.hHu.hHx = true;
      break;
      if (!p.huw())
      {
        i = 3902;
        break label261;
      }
      localObject = n.Scc;
      long l3 = n.bH("KEY_EXT_API_LAST_STEP_TIME_LONG", 0L);
      localObject = n.Scc;
      long l2 = n.bH("KEY_EXT_API_TODAY_STEP_LONG", 0L);
      if (l5 - l3 < 300000L)
      {
        Log.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute, lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(l5), Long.valueOf(l4) });
        i = 3903;
        break label261;
      }
      localObject = k.huj();
      long l1 = l3;
      if (!Util.isSameDay(l5, l3))
      {
        l1 = p.hut();
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
          break label625;
        }
        Log.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l7) });
        i = 3904;
        break;
      }
      label625:
      Log.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[] { p.iY(l5), Long.valueOf(l4) });
      localObject = n.Scc;
      n.bI("KEY_EXT_API_LAST_STEP_TIME_LONG", l5);
      localObject = n.Scc;
      n.bI("KEY_EXT_API_TODAY_STEP_LONG", l4);
      localObject = n.Scc;
      n.bI("KEY_EXT_API_VERSION_LONG", l6);
      i = 1;
      break label261;
      label695:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 2L, 1L, false);
      continue;
      label712:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(625L, 4L, 1L, false);
    }
  }
  
  private boolean vH(long paramLong)
  {
    AppMethodBeat.i(149288);
    if (paramLong <= 0L)
    {
      Log.i("MicroMsg.Sport.ExtApiStepManager", "invalid step %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(149288);
      return false;
    }
    if (this.Sbo != null) {
      h.aZW().a(this.Sbo);
    }
    long l = cn.bDw();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    Log.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[] { p.iY(l), Long.valueOf(paramLong) });
    this.Sbo = new e("", "gh_43f2581f6fd6", (int)(localCalendar.getTimeInMillis() / 1000L), (int)(l / 1000L), (int)paramLong, co.jcP(), 2);
    h.aZW().a(this.Sbo, 0);
    vI(l);
    vJ(paramLong);
    AppMethodBeat.o(149288);
    return true;
  }
  
  private void vI(long paramLong)
  {
    AppMethodBeat.i(149289);
    this.Sbt = paramLong;
    n localn = n.Scc;
    n.bI("KEY_LAST_UPLOAD_EXT_API_STEP_TIME_LONG", paramLong);
    AppMethodBeat.o(149289);
  }
  
  private void vJ(long paramLong)
  {
    AppMethodBeat.i(149291);
    this.Sbu = paramLong;
    n localn = n.Scc;
    n.bI("KEY_LAST_UPLOAD_EXT_API_STEP_COUNT_LONG", this.Sbu);
    AppMethodBeat.o(149291);
  }
  
  public final long hua()
  {
    AppMethodBeat.i(263931);
    if (this.Sbt == 0L)
    {
      n localn = n.Scc;
      this.Sbt = n.bH("KEY_LAST_UPLOAD_EXT_API_STEP_TIME_LONG", 0L);
    }
    long l = this.Sbt;
    AppMethodBeat.o(263931);
    return l;
  }
  
  public final long hub()
  {
    AppMethodBeat.i(149290);
    if (this.Sbu == 0L)
    {
      n localn = n.Scc;
      this.Sbu = n.bH("KEY_LAST_UPLOAD_EXT_API_STEP_COUNT_LONG", 0L);
    }
    long l = this.Sbu;
    AppMethodBeat.o(149290);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.b
 * JD-Core Version:    0.7.0.1
 */