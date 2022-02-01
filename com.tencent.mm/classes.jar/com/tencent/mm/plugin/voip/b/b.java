package com.tencent.mm.plugin.voip.b;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "setGpuDeviceModelSharePreferenceChecked", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "setGpuRatingSharePreferenceChecked", "Companion", "plugin-voip_release"})
public final class b
{
  public static final b.a CkW;
  public ap handler;
  private HandlerThread hkS;
  private c.b huo;
  
  static
  {
    AppMethodBeat.i(215935);
    CkW = new b.a((byte)0);
    CkW.getClass().getClassLoader();
    j.vr("GPUDetector");
    AppMethodBeat.o(215935);
  }
  
  public static final int ezp()
  {
    AppMethodBeat.i(215937);
    int i = b.a.ezp();
    AppMethodBeat.o(215937);
    return i;
  }
  
  public final Object ezn()
  {
    Object localObject2 = null;
    AppMethodBeat.i(215934);
    for (;;)
    {
      try
      {
        if ((b.a.ezs() != -1) && (b.a.ezt() != null)) {
          continue;
        }
        this.hkS = d.gZ("GpuDetectorUtil", 5);
        localObject1 = this.hkS;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).start();
        }
        localObject1 = this.hkS;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((HandlerThread)localObject1).getLooper();
        this.handler = new ap((Looper)localObject1);
        ap localap = this.handler;
        localObject1 = localObject2;
        if (localap != null)
        {
          boolean bool = localap.post((Runnable)new b(this));
          localObject1 = Boolean.valueOf(bool);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        ad.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        z localz = z.MKo;
        continue;
      }
      AppMethodBeat.o(215934);
      return localObject1;
      localObject1 = null;
      continue;
      ad.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      localObject1 = z.MKo;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(215932);
      Object localObject = this.CkX;
      c.a locala = c.hoP;
      b.a((b)localObject, c.a.a(null, 1, 1, null, 16));
      b.ezo();
      localObject = b.b(this.CkX);
      if (localObject != null) {
        ((ap)localObject).removeCallbacksAndMessages(null);
      }
      localObject = b.b(this.CkX);
      if (localObject != null)
      {
        ((ap)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215931);
            if (b.a(this.CkY.CkX) != null)
            {
              localObject = c.hoP;
              localObject = b.a(this.CkY.CkX);
              if (localObject == null) {
                p.gfZ();
              }
              c.a.a((c.b)localObject);
            }
            Object localObject = b.c(this.CkY.CkX);
            if (localObject != null)
            {
              ((HandlerThread)localObject).quitSafely();
              AppMethodBeat.o(215931);
              return;
            }
            AppMethodBeat.o(215931);
          }
        });
        AppMethodBeat.o(215932);
        return;
      }
      AppMethodBeat.o(215932);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(215933);
      if (b.a(this.CkX) != null)
      {
        localObject = c.hoP;
        localObject = b.a(this.CkX);
        if (localObject == null) {
          p.gfZ();
        }
        c.a.a((c.b)localObject);
      }
      Object localObject = b.c(this.CkX);
      if (localObject != null)
      {
        ((HandlerThread)localObject).quitSafely();
        AppMethodBeat.o(215933);
        return;
      }
      AppMethodBeat.o(215933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b
 * JD-Core Version:    0.7.0.1
 */