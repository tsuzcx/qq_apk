package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class f
{
  private static boolean isRunning;
  private static com.tencent.mm.loader.g.d<a> pSn;
  private static boolean xus;
  private static ArrayList<b> xut;
  private static d.g.a.a<z> xuu;
  public static final f xuv;
  
  static
  {
    AppMethodBeat.i(75235);
    xuv = new f();
    xut = new ArrayList();
    pSn = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static void C(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(75232);
    ad.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    xuu = parama;
    xus = true;
    parama = ((Iterable)xut).iterator();
    while (parama.hasNext())
    {
      d.g.a.a locala = (d.g.a.a)new d((b)parama.next());
      p.h(locala, "block");
      aq.aA((Runnable)new com.tencent.mm.ad.e(locala));
    }
    xut.clear();
    if (!isRunning)
    {
      parama = xuu;
      if (parama != null) {
        parama.invoke();
      }
      xuu = null;
    }
    AppMethodBeat.o(75232);
  }
  
  public static boolean a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (paramc != null)
    {
      ad.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + paramc.field_taskId + ", reyTime:" + paramc.field_mixRetryTime);
      pSn.a((com.tencent.mm.loader.g.c)new a(paramc, paramCaptureVideoNormalModel), (com.tencent.mm.loader.g.f)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static boolean dET()
  {
    AppMethodBeat.i(75231);
    Object localObject = e.xuo;
    localObject = e.dER();
    if (localObject != null)
    {
      boolean bool = a((c)localObject, null);
      AppMethodBeat.o(75231);
      return bool;
    }
    ad.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
    AppMethodBeat.o(75231);
    return false;
  }
  
  public static void dEU()
  {
    AppMethodBeat.i(75233);
    ad.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    xus = false;
    xuu = null;
    dET();
    AppMethodBeat.o(75233);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
  static final class a
    extends com.tencent.mm.loader.g.c
  {
    int fKU;
    c xuw;
    CaptureDataManager.CaptureVideoNormalModel xux;
    
    public a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.xuw = paramc;
      this.xux = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    public final String aeK()
    {
      AppMethodBeat.i(75225);
      String str = "mixTask_" + this.xuw.field_taskId;
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      f localf = f.xuv;
      if (f.dEW())
      {
        ad.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(j.hfM);
        AppMethodBeat.o(75224);
        return;
      }
      h.LTJ.f((Runnable)new a(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(75222);
        ad.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.xuy.xuw.field_taskId + ", mixRetryTime:" + this.xuy.xuw.field_mixRetryTime);
        Object localObject1 = (com.tencent.mm.bx.a)new afy();
        Object localObject4 = this.xuy.xuw.field_baseItemData;
        Object localObject3;
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (afy)localObject1;
          if ((localObject1 != null) && (this.xuy.xuw.dEF()))
          {
            localObject4 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
            com.tencent.mm.plugin.recordvideo.d.e.pR(((afy)localObject1).htP);
          }
          if (this.xuy.xuw.field_mixRetryTime < 3)
          {
            localObject4 = e.xuo;
            localObject4 = this.xuy.xuw.field_taskId;
            p.g(localObject4, "editorData.field_taskId");
            e.avz((String)localObject4);
            if (localObject1 != null)
            {
              localObject1 = e.xuo;
              localObject1 = this.xuy.xuw.field_taskId;
              p.g(localObject1, "editorData.field_taskId");
              localObject1 = e.avy((String)localObject1);
              if (localObject1 != null)
              {
                localObject4 = this.xuy;
                p.h(localObject1, "<set-?>");
                ((f.a)localObject4).xuw = ((c)localObject1);
              }
            }
            localObject1 = (com.tencent.mm.bx.a)new aif();
            localObject4 = this.xuy.xuw.field_extraConfig;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
            localObject4 = (aif)localObject1;
            localObject1 = this.xuy;
            ad.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(localObject4)));
            if (localObject4 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.xwn;
              localObject5 = com.tencent.mm.plugin.recordvideo.background.c.d.b(((f.a)localObject1).xuw, (aif)localObject4);
              boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
              int j = WXHardCoderJNI.hcEncodeVideoDelay;
              int k = WXHardCoderJNI.hcEncodeVideoCPU;
              int m = WXHardCoderJNI.hcEncodeVideoIO;
              if (WXHardCoderJNI.hcEncodeVideoThr)
              {
                i = Process.myTid();
                ((f.a)localObject1).fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                ad.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(((f.a)localObject1).fKU) });
                Object localObject6 = f.xuv;
                f.pG(true);
                localObject6 = a.xua;
                i = ((f.a)localObject1).xuw.field_fromScene;
                localObject6 = ((f.a)localObject1).xuw.field_taskId;
                p.g(localObject6, "editorData.field_taskId");
                a.n(i, (String)localObject6, ((f.a)localObject1).xuw.field_mixRetryTime);
                long l1 = System.currentTimeMillis();
                long l2 = System.currentTimeMillis();
                if (localObject5 != null) {
                  ((com.tencent.mm.plugin.recordvideo.background.c.c)localObject5).c((r)new f.a.b((f.a)localObject1, l2, l1, (aif)localObject4));
                }
                if (localObject5 != null) {
                  break label600;
                }
                if (((f.a)localObject1).xuw.dEF())
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
                  com.tencent.mm.plugin.recordvideo.d.e.dGQ();
                }
                ((f.a)localObject1).a(j.hfL);
                AppMethodBeat.o(75222);
                return;
                localException1 = localException1;
                ad.l("safeParser", "", new Object[] { localException1 });
                Object localObject2 = null;
              }
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ad.l("safeParser", "", new Object[] { localException2 });
              localObject3 = null;
              continue;
              int i = 0;
            }
            if (localObject3.xuw.dEF())
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
              com.tencent.mm.plugin.recordvideo.d.e.dGQ();
            }
            localObject3.a(j.hfL);
            label600:
            AppMethodBeat.o(75222);
            return;
          }
        }
        ad.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.xuy.xuw.field_taskId + " third and still failed");
        if ((localObject3 != null) && (this.xuy.xuw.dEF()))
        {
          localObject4 = com.tencent.mm.plugin.recordvideo.d.e.xHl;
          com.tencent.mm.plugin.recordvideo.d.e.pT(localObject3.htP);
        }
        this.xuy.a(j.hfL);
        AppMethodBeat.o(75222);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
    static final class b
      extends q
      implements r<String, String, Boolean, Integer, z>
    {
      b(f.a parama, long paramLong1, long paramLong2, aif paramaif)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
  static final class b
    implements Runnable
  {
    private String taskId;
    private CaptureDataManager.CaptureVideoNormalModel xux;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.xux = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      Object localObject = f.xuv;
      f.dEV().remove(this);
      localObject = e.xuo;
      localObject = e.avy(this.taskId);
      f localf = f.xuv;
      f.a((c)localObject, this.xux);
      AppMethodBeat.o(75227);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<f.a>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */