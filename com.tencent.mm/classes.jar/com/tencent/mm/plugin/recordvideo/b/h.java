package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class h
{
  private static boolean HKd;
  private static boolean HKe;
  public static final h HKf;
  private static int laT;
  private static VideoTransPara lgX;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(75384);
    HKf = new h();
    laT = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(163422);
    p.k(paramVideoTransPara, "videoTransPara");
    Log.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    lgX = paramVideoTransPara;
    scene = paramInt;
    Object localObject2 = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = lgX;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.lJz);
      localObject2 = ((StringBuilder)localObject2).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = lgX;
      if (paramVideoTransPara == null) {
        break label319;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label94:
      Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      j.d(lgX);
      if ((af.juO.jtn == -1) || ((af.juO.jtn & 0x1) == 0)) {
        break label324;
      }
      laT = 1080;
      Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label148:
      if (paramBoolean)
      {
        localObject2 = lgX;
        if ((localObject2 != null) && (j.EZX.jth == 2))
        {
          paramVideoTransPara = ar.au(MMApplicationContext.getContext());
          if (!ar.kW(MMApplicationContext.getContext())) {
            break label1090;
          }
          paramVideoTransPara = ar.hv(MMApplicationContext.getContext());
        }
      }
    }
    label319:
    label1090:
    for (;;)
    {
      if (lgX != null)
      {
        if (!((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vFT, true)) {
          break label617;
        }
        ((VideoTransPara)localObject2).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject2).height));
        ((VideoTransPara)localObject2).width = d.WV(((VideoTransPara)localObject2).width);
      }
      for (;;)
      {
        Log.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject2).width), Integer.valueOf(((VideoTransPara)localObject2).height) });
        if (lgX != null) {
          break label657;
        }
        Log.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        HKe = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label94;
        label324:
        if ((af.juO.jtn != -1) && ((af.juO.jtn & 0x2) != 0))
        {
          laT = 720;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label148;
        }
        if ((j.EZW) || (j.EZX.Faj > 1) || (j.eTo()))
        {
          laT = j.EZX.laT;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + j.EZX.Faj + " resolutionLimit:" + laT);
          break label148;
        }
        laT = 1080;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (j.EZX.jth != 1) {
          break label148;
        }
        paramVideoTransPara = MMApplicationContext.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new t("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        int j = d.hw(MMApplicationContext.getContext());
        paramVideoTransPara = d.eSY();
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + j + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (j >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          laT = 1080;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label148;
        }
        laT = 540;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label148;
        label617:
        ((VideoTransPara)localObject2).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject2).width));
        ((VideoTransPara)localObject2).height = d.WV(((VideoTransPara)localObject2).height);
      }
      paramVideoTransPara = lgX;
      if (paramVideoTransPara != null)
      {
        if ((laT < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          HKe = false;
          Log.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.h.ae(a.class);
        p.j(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (Util.getInt(((a)paramVideoTransPara).axc().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1065;
        }
        paramBoolean = true;
        label753:
        paramInt = af.juP.jts;
        Log.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
        if (!paramBoolean) {
          break label1085;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramInt != -1)
        {
          if (paramInt == 1) {
            paramBoolean = true;
          }
        }
        else
        {
          Log.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(paramBoolean)));
          HKd = paramBoolean;
          if ((scene == 1) || (scene == 2))
          {
            paramVideoTransPara = e.HJM;
            paramBoolean = e.wu(false);
            paramVideoTransPara = e.HJM;
            boolean bool = e.wu(true);
            Log.i("MicroMsg.SightRecordConfig", "checkEnableHevc, hardwareEnableHevc:" + paramBoolean + ", softEnableHevc:" + bool);
            paramVideoTransPara = lgX;
            if (paramVideoTransPara != null)
            {
              if (!bool) {
                break label1075;
              }
              paramInt = 1;
              paramVideoTransPara.lJL = paramInt;
            }
            paramVideoTransPara = lgX;
            if (paramVideoTransPara != null)
            {
              paramInt = i;
              if (!bool)
              {
                paramInt = i;
                if (paramBoolean) {
                  paramInt = 1;
                }
              }
              paramVideoTransPara.lJK = paramInt;
            }
            paramVideoTransPara = lgX;
            if ((paramVideoTransPara != null) && (paramVideoTransPara.lJL == 1)) {
              j.EZX.jth = 1;
            }
            localObject2 = new StringBuilder("checkEnableHevc, hwEnableHevc:");
            paramVideoTransPara = lgX;
            if (paramVideoTransPara == null) {
              break label1080;
            }
          }
        }
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.lJK);; paramVideoTransPara = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(paramVideoTransPara).append(", swEnableHevc:");
          VideoTransPara localVideoTransPara = lgX;
          paramVideoTransPara = localObject1;
          if (localVideoTransPara != null) {
            paramVideoTransPara = Integer.valueOf(localVideoTransPara.lJL);
          }
          Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          HKe = true;
          Log.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label753;
          paramBoolean = false;
          break label810;
          paramInt = 0;
          break label910;
        }
      }
    }
  }
  
  public static String fvH()
  {
    AppMethodBeat.i(223239);
    String str = "cpuCrop:" + fvL() + ", recorderType:" + fvJ() + ", resolutionLimit:" + laT + ", videoParams:" + lgX;
    AppMethodBeat.o(223239);
    return str;
  }
  
  public static VideoTransPara fvI()
  {
    return lgX;
  }
  
  public static int fvJ()
  {
    if ((j.EZX == null) || (!HKe)) {
      return 2;
    }
    return j.EZX.jth;
  }
  
  public static int fvK()
  {
    return laT;
  }
  
  public static boolean fvL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((j.EZX == null) || (!HKe))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (j.EZX.jth == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(HKd).append(", swEnableHevc:");
      localObject1 = lgX;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).lJL);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = lgX;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.lJK);
      }
      Log.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!HKd))
      {
        localObject1 = lgX;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).lJL != 1)) {
          break label179;
        }
      }
      AppMethodBeat.o(75381);
      return true;
      bool = false;
      break;
    }
    label179:
    AppMethodBeat.o(75381);
    return false;
  }
  
  public static void fvM()
  {
    AppMethodBeat.i(75383);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (HKe)
    {
      if (fvJ() == 1) {
        i = 39;
      }
      if (laT != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static final boolean isInit()
  {
    return HKe;
  }
  
  public static final void j(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    p.k(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + j.EZX.jth + ", resolutionLimit:" + laT);
    paramPoint = lgX;
    if (paramPoint != null)
    {
      if (j.EZX.jth == 1)
      {
        if (j > paramPoint.width) {
          if (laT == 1080)
          {
            paramPoint.width = (j / 2);
            Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + paramPoint.width);
          }
        }
        for (paramPoint.height = ((int)(i / j * paramPoint.width));; paramPoint.height = i)
        {
          if (paramPoint.width % 2 != 0) {
            paramPoint.width -= 1;
          }
          if (paramPoint.height % 2 != 0) {
            paramPoint.height -= 1;
          }
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + paramPoint.width + 'x' + paramPoint.height);
          AppMethodBeat.o(75382);
          return;
          if (laT != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((laT == 720) || (laT == 540)) && (j < paramPoint.width))
      {
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + laT + ", adjust video size");
        if (laT != 540) {
          break label493;
        }
        paramPoint.width = j;
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.WV(paramPoint.width);
        paramPoint.height = d.WV(paramPoint.height);
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (laT == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(75382);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(75380);
    Log.i("MicroMsg.SightRecordConfig", "unInit");
    HKe = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.h
 * JD-Core Version:    0.7.0.1
 */