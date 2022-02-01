package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class f
{
  private static boolean BKt;
  private static ArrayList<b> BKu;
  private static kotlin.g.a.a<x> BKv;
  public static final f BKw;
  private static boolean isRunning;
  private static com.tencent.mm.loader.g.d<a> rpP;
  
  static
  {
    AppMethodBeat.i(75235);
    BKw = new f();
    BKu = new ArrayList();
    rpP = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static void V(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(75232);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    BKv = parama;
    BKt = true;
    parama = ((Iterable)BKu).iterator();
    while (parama.hasNext())
    {
      kotlin.g.a.a locala = (kotlin.g.a.a)new d((b)parama.next());
      p.h(locala, "block");
      MMHandlerThread.removeRunnable((Runnable)new com.tencent.mm.ac.e(locala));
    }
    BKu.clear();
    if (!isRunning)
    {
      parama = BKv;
      if (parama != null) {
        parama.invoke();
      }
      BKv = null;
    }
    AppMethodBeat.o(75232);
  }
  
  public static boolean a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (paramc != null)
    {
      Log.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + paramc.field_taskId + ", reyTime:" + paramc.field_mixRetryTime);
      rpP.a((com.tencent.mm.loader.g.c)new a(paramc, paramCaptureVideoNormalModel), (com.tencent.mm.loader.g.f)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static boolean eIX()
  {
    AppMethodBeat.i(75231);
    Object localObject = e.BKp;
    localObject = e.eIV();
    if (localObject != null)
    {
      boolean bool = a((c)localObject, null);
      AppMethodBeat.o(75231);
      return bool;
    }
    Log.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
    AppMethodBeat.o(75231);
    return false;
  }
  
  public static void eIY()
  {
    AppMethodBeat.i(75233);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    BKt = false;
    BKv = null;
    eIX();
    AppMethodBeat.o(75233);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
  static final class a
    extends com.tencent.mm.loader.g.c
  {
    c BKx;
    CaptureDataManager.CaptureVideoNormalModel BKy;
    int gsi;
    
    public a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.BKx = paramc;
      this.BKy = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    public final String auK()
    {
      AppMethodBeat.i(75225);
      String str = "mixTask_" + this.BKx.field_taskId;
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      f localf = f.BKw;
      if (f.eJa())
      {
        Log.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(j.iby);
        AppMethodBeat.o(75224);
        return;
      }
      h.RTc.b((Runnable)new a(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(75222);
        Log.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.BKz.BKx.field_taskId + ", mixRetryTime:" + this.BKz.BKx.field_mixRetryTime);
        Object localObject1 = (com.tencent.mm.bw.a)new aio();
        Object localObject4 = this.BKz.BKx.field_baseItemData;
        Object localObject3;
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (aio)localObject1;
          if ((localObject1 != null) && (this.BKz.BKx.eIJ()))
          {
            localObject4 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
            com.tencent.mm.plugin.recordvideo.d.e.tk(((aio)localObject1).iqf);
          }
          if (this.BKz.BKx.field_mixRetryTime < 3)
          {
            localObject4 = e.BKp;
            localObject4 = this.BKz.BKx.field_taskId;
            p.g(localObject4, "editorData.field_taskId");
            e.aLg((String)localObject4);
            if (localObject1 != null)
            {
              localObject1 = e.BKp;
              localObject1 = this.BKz.BKx.field_taskId;
              p.g(localObject1, "editorData.field_taskId");
              localObject1 = e.aLf((String)localObject1);
              if (localObject1 != null)
              {
                localObject4 = this.BKz;
                p.h(localObject1, "<set-?>");
                ((f.a)localObject4).BKx = ((c)localObject1);
              }
            }
            localObject1 = (com.tencent.mm.bw.a)new ald();
            localObject4 = this.BKz.BKx.field_extraConfig;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
            localObject4 = (ald)localObject1;
            localObject1 = this.BKz;
            Log.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(localObject4)));
            if (localObject4 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.BMq;
              localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.b(((f.a)localObject1).BKx, (ald)localObject4);
              boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
              int j = WXHardCoderJNI.hcEncodeVideoDelay;
              int k = WXHardCoderJNI.hcEncodeVideoCPU;
              int m = WXHardCoderJNI.hcEncodeVideoIO;
              if (WXHardCoderJNI.hcEncodeVideoThr)
              {
                i = Process.myTid();
                ((f.a)localObject1).gsi = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                Log.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(((f.a)localObject1).gsi) });
                Object localObject6 = f.BKw;
                f.sZ(true);
                localObject6 = a.BKb;
                i = ((f.a)localObject1).BKx.field_fromScene;
                localObject6 = ((f.a)localObject1).BKx.field_taskId;
                p.g(localObject6, "editorData.field_taskId");
                a.p(i, (String)localObject6, ((f.a)localObject1).BKx.field_mixRetryTime);
                long l1 = System.currentTimeMillis();
                long l2 = System.currentTimeMillis();
                if (localObject5 != null) {
                  ((com.tencent.mm.plugin.recordvideo.background.c.c)localObject5).e((r)new f.a.b((f.a)localObject1, l2, l1, (ald)localObject4));
                }
                if (localObject5 != null) {
                  break label600;
                }
                if (((f.a)localObject1).BKx.eIJ())
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
                  com.tencent.mm.plugin.recordvideo.d.e.eLd();
                }
                ((f.a)localObject1).a(j.ibx);
                AppMethodBeat.o(75222);
                return;
                localException1 = localException1;
                Log.printDebugStack("safeParser", "", new Object[] { localException1 });
                Object localObject2 = null;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
              continue;
              int i = 0;
            }
            if (localObject3.BKx.eIJ())
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
              com.tencent.mm.plugin.recordvideo.d.e.eLd();
            }
            localObject3.a(j.ibx);
            label600:
            AppMethodBeat.o(75222);
            return;
          }
        }
        Log.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.BKz.BKx.field_taskId + " third and still failed");
        if ((localObject3 != null) && (this.BKz.BKx.eIJ()))
        {
          localObject4 = com.tencent.mm.plugin.recordvideo.d.e.BXT;
          com.tencent.mm.plugin.recordvideo.d.e.tm(localObject3.iqf);
        }
        this.BKz.a(j.ibx);
        AppMethodBeat.o(75222);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
    static final class b
      extends q
      implements r<String, String, Boolean, Integer, x>
    {
      b(f.a parama, long paramLong1, long paramLong2, ald paramald)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
  static final class b
    implements Runnable
  {
    private CaptureDataManager.CaptureVideoNormalModel BKy;
    private String taskId;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.BKy = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      Object localObject = f.BKw;
      f.eIZ().remove(this);
      localObject = e.BKp;
      localObject = e.aLf(this.taskId);
      f localf = f.BKw;
      f.a((c)localObject, this.BKy);
      AppMethodBeat.o(75227);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<f.a>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */