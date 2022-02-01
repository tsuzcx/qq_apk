package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class h
{
  private static boolean isRunning;
  private static com.tencent.mm.loader.g.d<a> poM;
  private static boolean wmF;
  private static ArrayList<b> wmG;
  private static d.g.a.a<y> wmH;
  public static final h wmI;
  
  static
  {
    AppMethodBeat.i(75235);
    wmI = new h();
    wmG = new ArrayList();
    poM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static boolean a(e parame, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (parame != null)
    {
      ac.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + parame.field_taskId + ", reyTime:" + parame.field_mixRetryTime);
      poM.a((com.tencent.mm.loader.g.c)new a(parame, paramCaptureVideoNormalModel), (com.tencent.mm.loader.g.f)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static boolean dux()
  {
    AppMethodBeat.i(75231);
    Object localObject = g.wmx;
    localObject = g.duv();
    if (localObject != null)
    {
      boolean bool = a((e)localObject, null);
      AppMethodBeat.o(75231);
      return bool;
    }
    ac.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
    AppMethodBeat.o(75231);
    return false;
  }
  
  public static void duy()
  {
    AppMethodBeat.i(75233);
    ac.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    wmF = false;
    wmH = null;
    dux();
    AppMethodBeat.o(75233);
  }
  
  public static void y(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(75232);
    ac.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    wmH = parama;
    wmF = true;
    parama = ((Iterable)wmG).iterator();
    while (parama.hasNext())
    {
      d.g.a.a locala = (d.g.a.a)new d((b)parama.next());
      k.h(locala, "block");
      ap.aB((Runnable)new com.tencent.mm.ac.e(locala));
    }
    wmG.clear();
    if (!isRunning)
    {
      parama = wmH;
      if (parama != null) {
        parama.invoke();
      }
      wmH = null;
    }
    AppMethodBeat.o(75232);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
  static final class a
    extends com.tencent.mm.loader.g.c
  {
    int fsu;
    e wmJ;
    CaptureDataManager.CaptureVideoNormalModel wmK;
    
    public a(e parame, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.wmJ = parame;
      this.wmK = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    public final String acg()
    {
      AppMethodBeat.i(75225);
      String str = "mixTask_" + this.wmJ.field_taskId;
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      h localh = h.wmI;
      if (h.duA())
      {
        ac.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(com.tencent.mm.loader.g.h.gLP);
        AppMethodBeat.o(75224);
        return;
      }
      com.tencent.e.h.JZN.f((Runnable)new a(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(h.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(75222);
        ac.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.wmL.wmJ.field_taskId + ", mixRetryTime:" + this.wmL.wmJ.field_mixRetryTime);
        Object localObject1 = (com.tencent.mm.bw.a)new adp();
        Object localObject4 = this.wmL.wmJ.field_baseItemData;
        Object localObject3;
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (adp)localObject1;
          if ((localObject1 != null) && (this.wmL.wmJ.duj()))
          {
            localObject4 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
            com.tencent.mm.plugin.recordvideo.d.e.pv(((adp)localObject1).hbH);
          }
          if (this.wmL.wmJ.field_mixRetryTime < 3)
          {
            localObject4 = g.wmx;
            localObject4 = this.wmL.wmJ.field_taskId;
            k.g(localObject4, "editorData.field_taskId");
            g.aqz((String)localObject4);
            if (localObject1 != null)
            {
              localObject1 = g.wmx;
              localObject1 = this.wmL.wmJ.field_taskId;
              k.g(localObject1, "editorData.field_taskId");
              localObject1 = g.aqy((String)localObject1);
              if (localObject1 != null)
              {
                localObject4 = this.wmL;
                k.h(localObject1, "<set-?>");
                ((h.a)localObject4).wmJ = ((e)localObject1);
              }
            }
            localObject1 = (com.tencent.mm.bw.a)new afq();
            localObject4 = this.wmL.wmJ.field_extraConfig;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject4);
            localObject4 = (afq)localObject1;
            localObject1 = this.wmL;
            ac.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(localObject4)));
            if (localObject4 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.recordvideo.background.b.d.wox;
              localObject5 = com.tencent.mm.plugin.recordvideo.background.b.d.b(((h.a)localObject1).wmJ, (afq)localObject4);
              boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
              int j = WXHardCoderJNI.hcEncodeVideoDelay;
              int k = WXHardCoderJNI.hcEncodeVideoCPU;
              int m = WXHardCoderJNI.hcEncodeVideoIO;
              if (WXHardCoderJNI.hcEncodeVideoThr)
              {
                i = Process.myTid();
                ((h.a)localObject1).fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                ac.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(((h.a)localObject1).fsu) });
                Object localObject6 = h.wmI;
                h.pj(true);
                localObject6 = a.wme;
                i = ((h.a)localObject1).wmJ.field_fromScene;
                localObject6 = ((h.a)localObject1).wmJ.field_taskId;
                k.g(localObject6, "editorData.field_taskId");
                a.n(i, (String)localObject6, ((h.a)localObject1).wmJ.field_mixRetryTime);
                long l1 = System.currentTimeMillis();
                long l2 = System.currentTimeMillis();
                if (localObject5 != null) {
                  ((com.tencent.mm.plugin.recordvideo.background.b.c)localObject5).c((r)new h.a.b((h.a)localObject1, l2, l1, (afq)localObject4));
                }
                if (localObject5 != null) {
                  break label600;
                }
                if (((h.a)localObject1).wmJ.duj())
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
                  com.tencent.mm.plugin.recordvideo.d.e.dww();
                }
                ((h.a)localObject1).a(com.tencent.mm.loader.g.h.gLO);
                AppMethodBeat.o(75222);
                return;
                localException1 = localException1;
                ac.l("safeParser", "", new Object[] { localException1 });
                Object localObject2 = null;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ac.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
              continue;
              int i = 0;
            }
            if (localObject3.wmJ.duj())
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
              com.tencent.mm.plugin.recordvideo.d.e.dww();
            }
            localObject3.a(com.tencent.mm.loader.g.h.gLO);
            label600:
            AppMethodBeat.o(75222);
            return;
          }
        }
        ac.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.wmL.wmJ.field_taskId + " third and still failed");
        if ((localObject3 != null) && (this.wmL.wmJ.duj()))
        {
          localObject4 = com.tencent.mm.plugin.recordvideo.d.e.wyr;
          com.tencent.mm.plugin.recordvideo.d.e.px(localObject3.hbH);
        }
        this.wmL.a(com.tencent.mm.loader.g.h.gLO);
        AppMethodBeat.o(75222);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements r<String, String, Boolean, Integer, y>
    {
      b(h.a parama, long paramLong1, long paramLong2, afq paramafq)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
  static final class b
    implements Runnable
  {
    private String taskId;
    private CaptureDataManager.CaptureVideoNormalModel wmK;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.wmK = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      Object localObject = h.wmI;
      h.duz().remove(this);
      localObject = g.wmx;
      localObject = g.aqy(this.taskId);
      h localh = h.wmI;
      h.a((e)localObject, this.wmK);
      AppMethodBeat.o(75227);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<h.a>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(h.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.h
 * JD-Core Version:    0.7.0.1
 */