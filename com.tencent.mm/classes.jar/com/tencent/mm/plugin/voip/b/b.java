package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil;", "", "()V", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "checkForJni", "", "queryGpuInfo", "release", "reportKvInfo", "archName", "", "code", "coreSum", "name", "", "vendor", "version", "rating", "archNameDetail", "setGpuDeviceModelSharePreferenceChecked", "deviceModel", "Lcom/tencent/gpudetector/JniGPUDetector$GpuDeviceModel;", "setGpuRatingSharePreferenceChecked", "Companion", "plugin-voip_release"})
public final class b
{
  public static final a CCB;
  public aq handler;
  private HandlerThread hnG;
  private c.b hxc;
  
  static
  {
    AppMethodBeat.i(210356);
    CCB = new a((byte)0);
    CCB.getClass().getClassLoader();
    j.vN("GPUDetector");
    AppMethodBeat.o(210356);
  }
  
  public static final int eCX()
  {
    AppMethodBeat.i(210358);
    int i = a.eCX();
    AppMethodBeat.o(210358);
    return i;
  }
  
  public final Object eCV()
  {
    Object localObject2 = null;
    AppMethodBeat.i(210355);
    for (;;)
    {
      try
      {
        if ((a.eDa() != -1) && (a.eDb() != null)) {
          continue;
        }
        this.hnG = d.hi("GpuDetectorUtil", 5);
        localObject1 = this.hnG;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).start();
        }
        localObject1 = this.hnG;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((HandlerThread)localObject1).getLooper();
        this.handler = new aq((Looper)localObject1);
        aq localaq = this.handler;
        localObject1 = localObject2;
        if (localaq != null)
        {
          boolean bool = localaq.post((Runnable)new b(this));
          localObject1 = Boolean.valueOf(bool);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        ae.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
        z localz = z.Nhr;
        continue;
      }
      AppMethodBeat.o(210355);
      return localObject1;
      localObject1 = null;
      continue;
      ae.i("MicroMsg.GpuDetectorUtil", "sp has value and not to do queryGpuInfo");
      localObject1 = z.Nhr;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/util/GpuDetectorUtil$Companion;", "", "()V", "GPU_INFO_DEVICE_MODEL", "", "GPU_INFO_HAS_BEEN_QUERY", "GPU_INFO_RATING", "TAG", "checkGpuDeviceModelFormSharePreference", "checkGpuRatingFormSharePreference", "", "queryGpuDeviceModel", "queryGpuRating", "queryGpuRatingWithoutCheck", "plugin-voip_release"})
  public static final class a
  {
    public static int eCX()
    {
      AppMethodBeat.i(210348);
      try
      {
        int j = ak.getContext().getSharedPreferences(ak.fow(), 0).getInt("gpu_info_rating", -1);
        i = j;
        if (j == -1)
        {
          new b().eCV();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(210348);
      return i;
    }
    
    public static int eCY()
    {
      AppMethodBeat.i(210347);
      try
      {
        int j = eDa();
        i = j;
        if (j == -1)
        {
          new b().eCV();
          i = j;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          int i = -1;
        }
      }
      AppMethodBeat.o(210347);
      return i;
    }
    
    public static String eCZ()
    {
      AppMethodBeat.i(210349);
      try
      {
        String str2 = eDb();
        str1 = str2;
        if (str2 == null)
        {
          new b().eCV();
          str1 = str2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str1;
          ae.m("MicroMsg.GpuDetectorUtil", "error happened ".concat(String.valueOf(localException)), new Object[0]);
          Object localObject = null;
        }
      }
      AppMethodBeat.o(210349);
      return str1;
    }
    
    static int eDa()
    {
      AppMethodBeat.i(210350);
      if (g.ajM())
      {
        int i = ak.getContext().getSharedPreferences(ak.fow(), 0).getInt("gpu_info_rating", -1);
        AppMethodBeat.o(210350);
        return i;
      }
      AppMethodBeat.o(210350);
      return -1;
    }
    
    static String eDb()
    {
      AppMethodBeat.i(210351);
      if (g.ajM())
      {
        String str = ak.getContext().getSharedPreferences(ak.fow(), 0).getString("gpu_info_device_model", null);
        AppMethodBeat.o(210351);
        return str;
      }
      AppMethodBeat.o(210351);
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(210353);
      Object localObject = this.CCC;
      c.a locala = c.hrD;
      b.a((b)localObject, c.a.a(null, 1, 1, null, 16));
      b.eCW();
      localObject = b.b(this.CCC);
      if (localObject != null) {
        ((aq)localObject).removeCallbacksAndMessages(null);
      }
      localObject = b.b(this.CCC);
      if (localObject != null)
      {
        ((aq)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210352);
            if (b.a(this.CCD.CCC) != null)
            {
              localObject = c.hrD;
              localObject = b.a(this.CCD.CCC);
              if (localObject == null) {
                p.gkB();
              }
              c.a.a((c.b)localObject);
            }
            Object localObject = b.c(this.CCD.CCC);
            if (localObject != null)
            {
              ((HandlerThread)localObject).quitSafely();
              AppMethodBeat.o(210352);
              return;
            }
            AppMethodBeat.o(210352);
          }
        });
        AppMethodBeat.o(210353);
        return;
      }
      AppMethodBeat.o(210353);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  public static final class c
    implements Runnable
  {
    public c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(210354);
      if (b.a(this.CCC) != null)
      {
        localObject = c.hrD;
        localObject = b.a(this.CCC);
        if (localObject == null) {
          p.gkB();
        }
        c.a.a((c.b)localObject);
      }
      Object localObject = b.c(this.CCC);
      if (localObject != null)
      {
        ((HandlerThread)localObject).quitSafely();
        AppMethodBeat.o(210354);
        return;
      }
      AppMethodBeat.o(210354);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.b
 * JD-Core Version:    0.7.0.1
 */