package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class f
{
  private static boolean HGD;
  private static ArrayList<b> HGE;
  private static kotlin.g.a.a<x> HGF;
  public static final f HGG;
  private static boolean isRunning;
  private static com.tencent.mm.loader.g.d<a> uVv;
  
  static
  {
    AppMethodBeat.i(75235);
    HGG = new f();
    HGE = new ArrayList();
    uVv = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static void Y(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(75232);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    HGF = parama;
    HGD = true;
    parama = ((Iterable)HGE).iterator();
    while (parama.hasNext())
    {
      kotlin.g.a.a locala = (kotlin.g.a.a)new d((b)parama.next());
      p.k(locala, "block");
      MMHandlerThread.removeRunnable((Runnable)new com.tencent.mm.ae.e(locala));
    }
    HGE.clear();
    if (!isRunning)
    {
      parama = HGF;
      if (parama != null) {
        parama.invoke();
      }
      HGF = null;
    }
    AppMethodBeat.o(75232);
  }
  
  public static boolean a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (paramc != null)
    {
      Log.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + paramc.field_taskId + ", reyTime:" + paramc.field_mixRetryTime);
      uVv.a((com.tencent.mm.loader.g.c)new a(paramc, paramCaptureVideoNormalModel), (com.tencent.mm.loader.g.f)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static boolean fvb()
  {
    AppMethodBeat.i(75231);
    Object localObject = e.HGz;
    localObject = e.fuZ();
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
  
  public static void fvc()
  {
    AppMethodBeat.i(75233);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    HGD = false;
    HGF = null;
    fvb();
    AppMethodBeat.o(75233);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
  static final class a
    extends com.tencent.mm.loader.g.c
  {
    c HGH;
    CaptureDataManager.CaptureVideoNormalModel HGI;
    int iWt;
    
    public a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.HGH = paramc;
      this.HGI = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    public final String aBG()
    {
      AppMethodBeat.i(75225);
      String str = "mixTask_" + this.HGH.field_taskId;
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      f localf = f.HGG;
      if (f.fve())
      {
        Log.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(j.kQf);
        AppMethodBeat.o(75224);
        return;
      }
      h.ZvG.d((Runnable)new a(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(75222);
        Log.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.HGJ.HGH.field_taskId + ", mixRetryTime:" + this.HGJ.HGH.field_mixRetryTime);
        Object localObject1 = (com.tencent.mm.cd.a)new ajd();
        Object localObject4 = this.HGJ.HGH.field_baseItemData;
        Object localObject3;
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (ajd)localObject1;
          if ((localObject1 != null) && (this.HGJ.HGH.fuO()))
          {
            localObject4 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
            com.tencent.mm.plugin.recordvideo.d.e.wG(((ajd)localObject1).lfl);
          }
          if (this.HGJ.HGH.field_mixRetryTime < 3)
          {
            localObject4 = e.HGz;
            localObject4 = this.HGJ.HGH.field_taskId;
            p.j(localObject4, "editorData.field_taskId");
            e.aVI((String)localObject4);
            if (localObject1 != null)
            {
              localObject1 = e.HGz;
              localObject1 = this.HGJ.HGH.field_taskId;
              p.j(localObject1, "editorData.field_taskId");
              localObject1 = e.aVH((String)localObject1);
              if (localObject1 != null)
              {
                localObject4 = this.HGJ;
                p.k(localObject1, "<set-?>");
                ((f.a)localObject4).HGH = ((c)localObject1);
              }
            }
            localObject1 = (com.tencent.mm.cd.a)new ame();
            localObject4 = this.HGJ.HGH.field_extraConfig;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
            localObject4 = (ame)localObject1;
            localObject1 = this.HGJ;
            Log.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(localObject4)));
            if (localObject4 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.HIC;
              localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.b(((f.a)localObject1).HGH, (ame)localObject4);
              boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
              int j = WXHardCoderJNI.hcEncodeVideoDelay;
              int k = WXHardCoderJNI.hcEncodeVideoCPU;
              int m = WXHardCoderJNI.hcEncodeVideoIO;
              if (WXHardCoderJNI.hcEncodeVideoThr)
              {
                i = Process.myTid();
                ((f.a)localObject1).iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                Log.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(((f.a)localObject1).iWt) });
                Object localObject6 = f.HGG;
                f.wt(true);
                localObject6 = a.HGl;
                i = ((f.a)localObject1).HGH.field_fromScene;
                localObject6 = ((f.a)localObject1).HGH.field_taskId;
                p.j(localObject6, "editorData.field_taskId");
                a.r(i, (String)localObject6, ((f.a)localObject1).HGH.field_mixRetryTime);
                long l1 = System.currentTimeMillis();
                long l2 = System.currentTimeMillis();
                if (localObject5 != null) {
                  ((com.tencent.mm.plugin.recordvideo.background.c.c)localObject5).e((r)new f.a.b((f.a)localObject1, l2, l1, (ame)localObject4));
                }
                if (localObject5 != null) {
                  break label600;
                }
                if (((f.a)localObject1).HGH.fuO())
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
                  com.tencent.mm.plugin.recordvideo.d.e.fxw();
                }
                ((f.a)localObject1).a(j.kQe);
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
            if (localObject3.HGH.fuO())
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
              com.tencent.mm.plugin.recordvideo.d.e.fxw();
            }
            localObject3.a(j.kQe);
            label600:
            AppMethodBeat.o(75222);
            return;
          }
        }
        Log.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.HGJ.HGH.field_taskId + " third and still failed");
        if ((localObject3 != null) && (this.HGJ.HGH.fuO()))
        {
          localObject4 = com.tencent.mm.plugin.recordvideo.d.e.HUH;
          com.tencent.mm.plugin.recordvideo.d.e.wI(localObject3.lfl);
        }
        this.HGJ.a(j.kQe);
        AppMethodBeat.o(75222);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
    static final class b
      extends q
      implements r<String, String, Boolean, Integer, x>
    {
      b(f.a parama, long paramLong1, long paramLong2, ame paramame)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
  static final class b
    implements Runnable
  {
    private CaptureDataManager.CaptureVideoNormalModel HGI;
    private String taskId;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.HGI = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      Object localObject = f.HGG;
      f.fvd().remove(this);
      localObject = e.HGz;
      localObject = e.aVH(this.taskId);
      f localf = f.HGG;
      f.a((c)localObject, this.HGI);
      AppMethodBeat.o(75227);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<f.a>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */