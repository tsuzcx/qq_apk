package com.tencent.mm.plugin.voip.b;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "setGpuDeviceModelSharePreferenceChecked", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "setGpuRatingSharePreferenceChecked", "Companion", "plugin-voip_release"})
public final class b
{
  public static final b.a ALR;
  private HandlerThread gSR;
  public ao handler;
  private c.b hcg;
  
  static
  {
    AppMethodBeat.i(208620);
    ALR = new b.a((byte)0);
    AppMethodBeat.o(208620);
  }
  
  public final Object elD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(208619);
    for (;;)
    {
      try
      {
        if ((b.a.elH() != -1) && (b.a.elI() != null)) {
          continue;
        }
        this.gSR = d.gB("GpuDetectorUtil", 5);
        localObject1 = this.gSR;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).start();
        }
        localObject1 = this.gSR;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((HandlerThread)localObject1).getLooper();
        this.handler = new ao((Looper)localObject1);
        ao localao = this.handler;
        localObject1 = localObject2;
        if (localao != null)
        {
          boolean bool = localao.post((Runnable)new b(this));
          localObject1 = Boolean.valueOf(bool);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        ac.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        y localy = y.KTp;
        continue;
      }
      AppMethodBeat.o(208619);
      return localObject1;
      localObject1 = null;
      continue;
      ac.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      localObject1 = y.KTp;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(208617);
      Object localObject = this.ALS;
      c.a locala = c.gWJ;
      b.a((b)localObject, c.a.a(null, 1, 1, null, 16));
      b.elE();
      localObject = b.b(this.ALS);
      if (localObject != null) {
        ((ao)localObject).removeCallbacksAndMessages(null);
      }
      localObject = b.b(this.ALS);
      if (localObject != null)
      {
        ((ao)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208616);
            if (b.a(this.ALT.ALS) != null)
            {
              localObject = c.gWJ;
              localObject = b.a(this.ALT.ALS);
              if (localObject == null) {
                k.fOy();
              }
              c.a.a((c.b)localObject);
            }
            Object localObject = b.c(this.ALT.ALS);
            if (localObject != null)
            {
              ((HandlerThread)localObject).quitSafely();
              AppMethodBeat.o(208616);
              return;
            }
            AppMethodBeat.o(208616);
          }
        });
        AppMethodBeat.o(208617);
        return;
      }
      AppMethodBeat.o(208617);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(208618);
      if (b.a(this.ALS) != null)
      {
        localObject = c.gWJ;
        localObject = b.a(this.ALS);
        if (localObject == null) {
          k.fOy();
        }
        c.a.a((c.b)localObject);
      }
      Object localObject = b.c(this.ALS);
      if (localObject != null)
      {
        ((HandlerThread)localObject).quitSafely();
        AppMethodBeat.o(208618);
        return;
      }
      AppMethodBeat.o(208618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b
 * JD-Core Version:    0.7.0.1
 */