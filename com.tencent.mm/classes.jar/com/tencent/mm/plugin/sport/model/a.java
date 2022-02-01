package com.tencent.mm.plugin.sport.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.wx_extension.service.PushProcessIPCService;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.storage.co;

public class a
{
  public c Sbm;
  private IMvvmObserver<Integer> Sbn;
  public e Sbo;
  private long Sbp;
  long Sbq;
  
  public a()
  {
    AppMethodBeat.i(149274);
    this.Sbn = new IMvvmObserver() {};
    ((com.tencent.mm.plugin.sport.a.c)MvvmEventCenter.getEvent(com.tencent.mm.plugin.sport.a.c.class)).observe(h.baC().mBP, "UploadSportStepEventHandle", this.Sbn);
    this.Sbm = new c();
    AppMethodBeat.o(149274);
  }
  
  public static long htX()
  {
    AppMethodBeat.i(149281);
    long l2 = p.hut();
    long l1 = -1L;
    Object localObject = n.Scc;
    localObject = n.hus();
    if (l2 == ((n.a)localObject).SbH)
    {
      l1 = ((n.a)localObject).SbF;
      localObject = "mmkv";
    }
    for (;;)
    {
      Log.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s todayStep %d", new Object[] { localObject, Long.valueOf(l1) });
      if (MIUI.ifMIUI()) {
        try
        {
          bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQJ, true);
          if (bool)
          {
            l2 = p.hux();
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
  
  private boolean vE(long paramLong)
  {
    AppMethodBeat.i(149276);
    if (paramLong <= 0L)
    {
      Log.i("MicroMsg.Sport.DeviceStepManager", "invalid step %d", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(149276);
      return false;
    }
    if (this.Sbo != null) {
      h.aZW().a(this.Sbo);
    }
    long l1 = p.hut();
    long l2 = cn.bDw();
    Log.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", new Object[] { p.iY(l2), Long.valueOf(paramLong) });
    this.Sbo = new e("", "gh_43f2581f6fd6", (int)(l1 / 1000L), (int)(l2 / 1000L), (int)paramLong, co.jcP(), 1);
    h.aZW().a(this.Sbo, 0);
    vG(l2);
    vF(paramLong);
    AppMethodBeat.o(149276);
    return true;
  }
  
  private void vF(long paramLong)
  {
    AppMethodBeat.i(149278);
    this.Sbp = paramLong;
    n localn = n.Scc;
    n.bI("KEY_LAST_UPLOAD_DEVICE_STEP_COUNT_LONG", this.Sbp);
    AppMethodBeat.o(149278);
  }
  
  private void vG(long paramLong)
  {
    AppMethodBeat.i(149279);
    this.Sbq = paramLong;
    n localn = n.Scc;
    n.bI("KEY_LAST_UPLOAD_DEVICE_STEP_TIME_LONG", paramLong);
    AppMethodBeat.o(149279);
  }
  
  public final void bbv(String paramString)
  {
    AppMethodBeat.i(149282);
    Bundle localBundle = new Bundle();
    localBundle.putString("config", paramString);
    com.tencent.mm.ipcinvoker.j.a(PushProcessIPCService.PROCESS_NAME, localBundle, j.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(149282);
  }
  
  public final void htV()
  {
    AppMethodBeat.i(149275);
    long l = htX();
    Log.i("MicroMsg.Sport.DeviceStepManager", "forceUploadDeviceStep %d", new Object[] { Long.valueOf(l) });
    vE(l);
    AppMethodBeat.o(149275);
  }
  
  public final long htW()
  {
    AppMethodBeat.i(149277);
    if (this.Sbp == 0L)
    {
      n localn = n.Scc;
      this.Sbp = n.bH("KEY_LAST_UPLOAD_DEVICE_STEP_COUNT_LONG", 0L);
    }
    long l = this.Sbp;
    AppMethodBeat.o(149277);
    return l;
  }
  
  public final void htY()
  {
    AppMethodBeat.i(263930);
    if (this.Sbm != null) {
      this.Sbm.hud();
    }
    com.tencent.mm.ipcinvoker.j.a(PushProcessIPCService.PROCESS_NAME, new Bundle(), f.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(263930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.a
 * JD-Core Version:    0.7.0.1
 */