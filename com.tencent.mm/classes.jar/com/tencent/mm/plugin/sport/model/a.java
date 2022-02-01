package com.tencent.mm.plugin.sport.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.wx_extension.service.PushProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.ILifecycleEventObserver;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.cl;
import java.util.Calendar;

public class a
{
  public c LxA;
  private ILifecycleEventObserver<Integer> LxB;
  public e LxC;
  private long LxD;
  long LxE;
  
  public a()
  {
    AppMethodBeat.i(149274);
    this.LxB = new ILifecycleEventObserver() {};
    ((com.tencent.mm.plugin.sport.a.c)LifecycleEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).observe(h.aHE().kbJ, "UploadSportStepEventHandle", this.LxB);
    this.LxA = new c();
    AppMethodBeat.o(149274);
  }
  
  private boolean Ru(long paramLong)
  {
    AppMethodBeat.i(149276);
    if (paramLong <= 0L)
    {
      Log.i("MicroMsg.Sport.DeviceStepManager", "invalid step %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(149276);
      return false;
    }
    if (this.LxC != null) {
      h.aGY().a(this.LxC);
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[] { n.GN(l2), Long.valueOf(paramLong) });
    this.LxC = new e("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), (int)paramLong, cl.hAM(), 1);
    h.aGY().a(this.LxC, 0);
    Rw(System.currentTimeMillis());
    Rv(paramLong);
    AppMethodBeat.o(149276);
    return true;
  }
  
  private void Rv(long paramLong)
  {
    AppMethodBeat.i(149278);
    this.LxD = paramLong;
    m localm = m.Lyn;
    m.bw("KEY_LAST_UPLOAD_DEVICE_STEP_COUNT_LONG", this.LxD);
    AppMethodBeat.o(149278);
  }
  
  private void Rw(long paramLong)
  {
    AppMethodBeat.i(149279);
    this.LxE = paramLong;
    m localm = m.Lyn;
    m.bw("KEY_LAST_UPLOAD_DEVICE_STEP_TIME_LONG", paramLong);
    AppMethodBeat.o(149279);
  }
  
  public static long gaG()
  {
    AppMethodBeat.i(149281);
    long l2 = n.gba();
    long l1 = -1L;
    Object localObject = m.Lyn;
    localObject = m.gaZ();
    if (l2 == ((m.a)localObject).LxU)
    {
      l1 = ((m.a)localObject).LxS;
      localObject = "mmkv";
    }
    for (;;)
    {
      Log.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s todayStep %d", new Object[] { localObject, Long.valueOf(l1) });
      if (MIUI.ifMIUI()) {
        try
        {
          bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCp, true);
          if (bool)
          {
            l2 = n.gbe();
            if (l2 > l1)
            {
              Log.i("MicroMsg.Sport.DeviceStepManager", "getTodayStep MIUI Step %d %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
              AppMethodBeat.o(149281);
              return l2;
              localObject = "unknown";
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
      }
    }
    AppMethodBeat.o(149281);
    return l1;
  }
  
  public final void bcH(String paramString)
  {
    AppMethodBeat.i(149282);
    Bundle localBundle = new Bundle();
    localBundle.putString("config", paramString);
    com.tencent.mm.ipcinvoker.j.a(PushProcessIPCService.PROCESS_NAME, localBundle, j.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(149282);
  }
  
  public final void gaE()
  {
    AppMethodBeat.i(149275);
    long l = gaG();
    Log.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", new Object[] { Long.valueOf(l) });
    Ru(l);
    AppMethodBeat.o(149275);
  }
  
  public final long gaF()
  {
    AppMethodBeat.i(149277);
    if (this.LxD == 0L)
    {
      m localm = m.Lyn;
      this.LxD = m.bv("KEY_LAST_UPLOAD_DEVICE_STEP_COUNT_LONG", 0L);
    }
    long l = this.LxD;
    AppMethodBeat.o(149277);
    return l;
  }
  
  public final void gaH()
  {
    AppMethodBeat.i(221480);
    if (this.LxA != null) {
      this.LxA.gaM();
    }
    com.tencent.mm.ipcinvoker.j.a(PushProcessIPCService.PROCESS_NAME, new Bundle(), f.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(221480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a
 * JD-Core Version:    0.7.0.1
 */