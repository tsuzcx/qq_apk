package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.r;
import d.g.b.k;
import d.g.b.v.e;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"})
public final class g
{
  private static boolean isRunning;
  private static com.tencent.mm.loader.g.d<a> oLs;
  private static boolean vdP;
  private static ArrayList<b> vdQ;
  private static d.g.a.a<y> vdR;
  public static final g vdS;
  
  static
  {
    AppMethodBeat.i(75235);
    vdS = new g();
    vdQ = new ArrayList();
    oLs = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static boolean a(d paramd, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (paramd != null)
    {
      ad.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + paramd.field_taskId + ", reyTime:" + paramd.field_mixRetryTime);
      oLs.a((com.tencent.mm.loader.g.c)new a(paramd, paramCaptureVideoNormalModel), (com.tencent.mm.loader.g.f)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static boolean dgP()
  {
    AppMethodBeat.i(75231);
    Object localObject = f.vdH;
    localObject = f.dgN();
    if (localObject != null)
    {
      boolean bool = a((d)localObject, null);
      AppMethodBeat.o(75231);
      return bool;
    }
    ad.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
    AppMethodBeat.o(75231);
    return false;
  }
  
  public static void dgQ()
  {
    AppMethodBeat.i(75233);
    ad.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    vdP = false;
    vdR = null;
    dgP();
    AppMethodBeat.o(75233);
  }
  
  public static void s(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(75232);
    ad.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    vdR = parama;
    vdP = true;
    parama = ((Iterable)vdQ).iterator();
    while (parama.hasNext())
    {
      d.g.a.a locala = (d.g.a.a)new d((b)parama.next());
      k.h(locala, "block");
      aq.az((Runnable)new e(locala));
    }
    vdQ.clear();
    if (!isRunning)
    {
      parama = vdR;
      if (parama != null) {
        parama.invoke();
      }
      vdR = null;
    }
    AppMethodBeat.o(75232);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"})
  static final class a
    extends com.tencent.mm.loader.g.c
  {
    int foV;
    d vdT;
    CaptureDataManager.CaptureVideoNormalModel vdU;
    
    public a(d paramd, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.vdT = paramd;
      this.vdU = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    public final String abi()
    {
      AppMethodBeat.i(75225);
      String str = "mixTask_" + this.vdT.field_taskId;
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      g localg = g.vdS;
      if (g.dgS())
      {
        ad.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(com.tencent.mm.loader.g.h.glc);
        AppMethodBeat.o(75224);
        return;
      }
      com.tencent.e.h.Iye.f((Runnable)new a(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(g.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(75222);
        ad.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + this.vdV.vdT.field_taskId + ", mixRetryTime:" + this.vdV.vdT.field_mixRetryTime);
        Object localObject1 = (com.tencent.mm.bx.a)new acq();
        Object localObject4 = this.vdV.vdT.field_baseItemData;
        Object localObject3;
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (acq)localObject1;
          if ((localObject1 != null) && (this.vdV.vdT.dgB()))
          {
            localObject4 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
            com.tencent.mm.plugin.recordvideo.d.d.ox(((acq)localObject1).gBl);
          }
          if (this.vdV.vdT.field_mixRetryTime < 3)
          {
            localObject4 = f.vdH;
            localObject4 = this.vdV.vdT.field_taskId;
            k.g(localObject4, "editorData.field_taskId");
            f.alA((String)localObject4);
            if (localObject1 != null)
            {
              localObject1 = f.vdH;
              localObject1 = this.vdV.vdT.field_taskId;
              k.g(localObject1, "editorData.field_taskId");
              localObject1 = f.alz((String)localObject1);
              if (localObject1 != null)
              {
                localObject4 = this.vdV;
                k.h(localObject1, "<set-?>");
                ((g.a)localObject4).vdT = ((d)localObject1);
              }
            }
            localObject1 = (com.tencent.mm.bx.a)new aer();
            localObject4 = this.vdV.vdT.field_extraConfig;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject4);
            localObject4 = (aer)localObject1;
            localObject1 = this.vdV;
            ad.i("MicroMsg.mix_background.VideoMixHandler", "runMix from VideoMixHandler extraConfig:".concat(String.valueOf(localObject4)));
            if (localObject4 != null)
            {
              Object localObject5 = com.tencent.mm.plugin.recordvideo.background.b.d.vfL;
              localObject5 = com.tencent.mm.plugin.recordvideo.background.b.d.b(((g.a)localObject1).vdT, (aer)localObject4);
              boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
              int j = WXHardCoderJNI.hcEncodeVideoDelay;
              int k = WXHardCoderJNI.hcEncodeVideoCPU;
              int m = WXHardCoderJNI.hcEncodeVideoIO;
              if (WXHardCoderJNI.hcEncodeVideoThr)
              {
                i = Process.myTid();
                ((g.a)localObject1).foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
                ad.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(((g.a)localObject1).foV) });
                Object localObject6 = g.vdS;
                g.op(true);
                localObject6 = a.vdo;
                i = ((g.a)localObject1).vdT.field_fromScene;
                localObject6 = ((g.a)localObject1).vdT.field_taskId;
                k.g(localObject6, "editorData.field_taskId");
                a.l(i, (String)localObject6, ((g.a)localObject1).vdT.field_mixRetryTime);
                long l1 = System.currentTimeMillis();
                long l2 = System.currentTimeMillis();
                if (localObject5 != null) {
                  ((com.tencent.mm.plugin.recordvideo.background.b.c)localObject5).b((r)new g.a.b((g.a)localObject1, l2, l1, (aer)localObject4));
                }
                if (localObject5 != null) {
                  break label600;
                }
                if (((g.a)localObject1).vdT.dgB())
                {
                  localObject4 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
                  com.tencent.mm.plugin.recordvideo.d.d.diD();
                }
                ((g.a)localObject1).a(com.tencent.mm.loader.g.h.glb);
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
            if (localObject3.vdT.dgB())
            {
              localObject4 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
              com.tencent.mm.plugin.recordvideo.d.d.diD();
            }
            localObject3.a(com.tencent.mm.loader.g.h.glb);
            label600:
            AppMethodBeat.o(75222);
            return;
          }
        }
        ad.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + this.vdV.vdT.field_taskId + " third and still failed");
        if ((localObject3 != null) && (this.vdV.vdT.dgB()))
        {
          localObject4 = com.tencent.mm.plugin.recordvideo.d.d.vpA;
          com.tencent.mm.plugin.recordvideo.d.d.oz(localObject3.gBl);
        }
        this.vdV.a(com.tencent.mm.loader.g.h.glb);
        AppMethodBeat.o(75222);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements r<String, String, Boolean, Integer, y>
    {
      b(g.a parama, long paramLong1, long paramLong2, aer paramaer)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"})
  static final class b
    implements Runnable
  {
    private String taskId;
    private CaptureDataManager.CaptureVideoNormalModel vdU;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.vdU = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      Object localObject = g.vdS;
      g.dgR().remove(this);
      localObject = f.vdH;
      localObject = f.alz(this.taskId);
      g localg = g.vdS;
      g.a((d)localObject, this.vdU);
      AppMethodBeat.o(75227);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"})
  public static final class c
    implements com.tencent.mm.loader.g.f<g.a>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(v.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(g.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.g
 * JD-Core Version:    0.7.0.1
 */