package com.tencent.mm.plugin.recordvideo.background;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler;", "", "()V", "LOOP_WAIT_TIME", "", "MAX_RETRY_TIME", "", "TAG", "", "isRunning", "", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onCallback", "Lkotlin/Function0;", "", "stopFlag", "waitTaskList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "performCallback", "scene", "taskId", "success", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "resumeBgMix", "startBgMix", "videoEditorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "stopBgMix", "MixTask", "WaitTask", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f NDY;
  private static boolean NDZ;
  private static ArrayList<b> NEa;
  private static kotlin.g.a.a<ah> NEb;
  private static boolean Uz;
  private static com.tencent.mm.loader.f.d<a> yhY;
  
  static
  {
    AppMethodBeat.i(75235);
    NDY = new f();
    NEa = new ArrayList();
    yhY = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(5), new g(1, (byte)0), 1, "videoMixTask"));
    AppMethodBeat.o(75235);
  }
  
  public static boolean a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(75234);
    if (paramc != null)
    {
      Log.i("MicroMsg.mix_background.VideoMixHandler", "start background mix, taskId:" + paramc.field_taskId + ", reyTime:" + paramc.field_mixRetryTime);
      yhY.a((com.tencent.mm.loader.f.c)new a(paramc, paramCaptureVideoNormalModel), (com.tencent.mm.loader.f.e)new c());
      AppMethodBeat.o(75234);
      return true;
    }
    AppMethodBeat.o(75234);
    return true;
  }
  
  public static void bK(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(75232);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler stopBgMix!");
    NEb = parama;
    NDZ = true;
    parama = ((Iterable)NEa).iterator();
    while (parama.hasNext()) {
      com.tencent.mm.ae.d.A((kotlin.g.a.a)new d((b)parama.next()));
    }
    NEa.clear();
    if (!Uz)
    {
      parama = NEb;
      if (parama != null) {
        parama.invoke();
      }
      NEb = null;
    }
    AppMethodBeat.o(75232);
  }
  
  public static boolean gGR()
  {
    Boolean localBoolean = null;
    AppMethodBeat.i(75231);
    Object localObject = e.NDU;
    localObject = e.gGP();
    if (localObject == null) {}
    while (localBoolean == null)
    {
      Log.d("MicroMsg.mix_background.VideoMixHandler", "mix task is empty");
      AppMethodBeat.o(75231);
      return false;
      localBoolean = Boolean.valueOf(a((c)localObject, null));
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(75231);
    return bool;
  }
  
  public static void gGS()
  {
    AppMethodBeat.i(75233);
    Log.i("MicroMsg.mix_background.VideoMixHandler", "VideoMixHandler resumeBgMix!");
    NDZ = false;
    NEb = null;
    gGR();
    AppMethodBeat.o(75233);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getEditorData", "()Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "setEditorData", "(Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "startPerformance", "", "call", "", "runMix", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "setMoovHead", "path", "", "uniqueId", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends com.tencent.mm.loader.f.c
  {
    c NEc;
    CaptureDataManager.CaptureVideoNormalModel NEd;
    int lyw;
    
    public a(c paramc, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75226);
      this.NEc = paramc;
      this.NEd = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75226);
    }
    
    private static final void a(a parama)
    {
      AppMethodBeat.i(279462);
      s.u(parama, "this$0");
      Log.i("MicroMsg.mix_background.VideoMixHandler", "call background mix " + parama.NEc.field_taskId + ", mixRetryTime:" + parama.NEc.field_mixRetryTime);
      Object localObject1 = (com.tencent.mm.bx.a)new ami();
      Object localObject3 = parama.NEc.field_baseItemData;
      com.tencent.mm.plugin.recordvideo.f.e locale;
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (ami)localObject1;
        if ((localObject1 != null) && (parama.NEc.gGE()))
        {
          localObject3 = com.tencent.mm.plugin.recordvideo.f.e.NRz;
          com.tencent.mm.plugin.recordvideo.f.e.Bg(((ami)localObject1).nJW);
        }
        if (parama.NEc.field_mixRetryTime < 3)
        {
          localObject3 = e.NDU;
          localObject3 = parama.NEc.field_taskId;
          s.s(localObject3, "editorData.field_taskId");
          e.aSQ((String)localObject3);
          if (localObject1 != null)
          {
            localObject1 = e.NDU;
            localObject1 = parama.NEc.field_taskId;
            s.s(localObject1, "editorData.field_taskId");
            localObject1 = e.aSP((String)localObject1);
            if (localObject1 != null)
            {
              s.u(localObject1, "<set-?>");
              parama.NEc = ((c)localObject1);
            }
          }
          localObject1 = (com.tencent.mm.bx.a)new apw();
          localObject3 = parama.NEc.field_extraConfig;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject3);
          localObject1 = (apw)localObject1;
          Log.i("MicroMsg.mix_background.VideoMixHandler", s.X("runMix from VideoMixHandler extraConfig:", localObject1));
          if (localObject1 != null)
          {
            localObject3 = com.tencent.mm.plugin.recordvideo.background.c.d.NFT;
            localObject3 = com.tencent.mm.plugin.recordvideo.background.c.d.b(parama.NEc, (apw)localObject1);
            boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
            int j = WXHardCoderJNI.hcEncodeVideoDelay;
            int k = WXHardCoderJNI.hcEncodeVideoCPU;
            int m = WXHardCoderJNI.hcEncodeVideoIO;
            if (WXHardCoderJNI.hcEncodeVideoThr)
            {
              i = Process.myTid();
              parama.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, 35000, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.mix_background.VideoMixHandler");
              Log.i("MicroMsg.mix_background.VideoMixHandler", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(parama.lyw) });
              Object localObject4 = f.NDY;
              f.AS(true);
              localObject4 = a.NDM;
              i = parama.NEc.field_fromScene;
              localObject4 = parama.NEc.field_taskId;
              s.s(localObject4, "editorData.field_taskId");
              a.v(i, (String)localObject4, parama.NEc.field_mixRetryTime);
              long l1 = System.currentTimeMillis();
              final long l2 = System.currentTimeMillis();
              if (localObject3 != null) {
                ((com.tencent.mm.plugin.recordvideo.background.c.c)localObject3).f((r)new a(parama, l2, l1, (apw)localObject1));
              }
              if (localObject3 != null) {
                break label555;
              }
              if (parama.NEc.gGE())
              {
                localObject1 = com.tencent.mm.plugin.recordvideo.f.e.NRz;
                com.tencent.mm.plugin.recordvideo.f.e.gJl();
              }
              parama.a(com.tencent.mm.loader.f.i.nrH);
              AppMethodBeat.o(279462);
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
            locale = null;
            continue;
            int i = 0;
          }
          if (parama.NEc.gGE())
          {
            locale = com.tencent.mm.plugin.recordvideo.f.e.NRz;
            com.tencent.mm.plugin.recordvideo.f.e.gJl();
          }
          parama.a(com.tencent.mm.loader.f.i.nrH);
          label555:
          AppMethodBeat.o(279462);
          return;
        }
      }
      Log.i("MicroMsg.mix_background.VideoMixHandler", "retry mix taskId:" + parama.NEc.field_taskId + " third and still failed");
      if ((locale != null) && (parama.NEc.gGE()))
      {
        localObject3 = com.tencent.mm.plugin.recordvideo.f.e.NRz;
        com.tencent.mm.plugin.recordvideo.f.e.Bi(locale.nJW);
      }
      parama.a(com.tencent.mm.loader.f.i.nrH);
      AppMethodBeat.o(279462);
    }
    
    public final String aUE()
    {
      AppMethodBeat.i(75225);
      String str = s.X("mixTask_", this.NEc.field_taskId);
      AppMethodBeat.o(75225);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(75224);
      if (f.gGU())
      {
        Log.i("MicroMsg.mix_background.VideoMixHandler", "running forground task");
        a(com.tencent.mm.loader.f.i.nrI);
        AppMethodBeat.o(75224);
        return;
      }
      h.ahAA.g(new f.a..ExternalSyntheticLambda0(this), "VideoMixHandler");
      AppMethodBeat.o(75224);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "mixVideoPath", "", "mixThumbPath", "ret", "", "error", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements r<String, String, Boolean, Integer, ah>
    {
      a(f.a parama, long paramLong1, long paramLong2, apw paramapw)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$WaitTask;", "Ljava/lang/Runnable;", "taskId", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getModel", "()Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "setModel", "(Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "run", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements Runnable
  {
    private CaptureDataManager.CaptureVideoNormalModel NEd;
    private String taskId;
    
    public b(String paramString, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
    {
      AppMethodBeat.i(75228);
      this.taskId = paramString;
      this.NEd = paramCaptureVideoNormalModel;
      AppMethodBeat.o(75228);
    }
    
    public final void run()
    {
      AppMethodBeat.i(75227);
      f.gGT().remove(this);
      Object localObject = e.NDU;
      localObject = e.aSP(this.taskId);
      f localf = f.NDY;
      f.a((c)localObject, this.NEd);
      AppMethodBeat.o(75227);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/background/VideoMixHandler$startBgMix$3$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoMixHandler$MixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.f.e<f.a>
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(f.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.f
 * JD-Core Version:    0.7.0.1
 */