package com.tencent.mm.plugin.recordvideo.b;

import a.l;
import a.v;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "unInit", "plugin-recordvideo_release"})
public final class c
{
  private static int eZQ;
  private static VideoTransPara fcu;
  private static boolean qbe;
  public static final c qbf;
  private static boolean ukj;
  
  static
  {
    AppMethodBeat.i(150582);
    qbf = new c();
    eZQ = -1;
    AppMethodBeat.o(150582);
  }
  
  public static void aoR()
  {
    AppMethodBeat.i(150580);
    ab.i("MicroMsg.SightRecordConfig", "unInit");
    qbe = false;
    AppMethodBeat.o(150580);
  }
  
  public static String cgi()
  {
    AppMethodBeat.i(150579);
    String str = "cpuCrop:" + cgm() + ", recorderType:" + cgk() + ", resolutionLimit:" + eZQ + ", videoParams:" + fcu;
    AppMethodBeat.o(150579);
    return str;
  }
  
  public static VideoTransPara cgj()
  {
    return fcu;
  }
  
  public static int cgk()
  {
    if ((com.tencent.mm.plugin.mmsight.model.j.oHG == null) || (!qbe)) {
      return 2;
    }
    return com.tencent.mm.plugin.mmsight.model.j.oHG.eqK;
  }
  
  public static int cgl()
  {
    return eZQ;
  }
  
  public static boolean cgm()
  {
    AppMethodBeat.i(156847);
    if ((com.tencent.mm.plugin.mmsight.model.j.oHG == null) || (!qbe))
    {
      AppMethodBeat.o(156847);
      return false;
    }
    if (com.tencent.mm.plugin.mmsight.model.j.oHG.eqK == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.SightRecordConfig", "cpuCrop: recorderTypeCpuCrop:" + bool + ", serverConfigUseCpuCrop:" + ukj);
      if ((!bool) && (!ukj)) {
        break;
      }
      AppMethodBeat.o(156847);
      return true;
    }
    AppMethodBeat.o(156847);
    return false;
  }
  
  public static void cgn()
  {
    AppMethodBeat.i(154634);
    h.qsU.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (qbe)
    {
      if (cgk() == 1) {
        i = 39;
      }
      if (eZQ != 720) {
        break label68;
      }
      i += 1;
    }
    for (;;)
    {
      h.qsU.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(154634);
      return;
      label68:
      i += 2;
    }
  }
  
  public static void d(VideoTransPara paramVideoTransPara)
  {
    boolean bool2 = true;
    AppMethodBeat.i(150578);
    a.f.b.j.q(paramVideoTransPara, "videoTransPara");
    ab.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    fcu = paramVideoTransPara;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = fcu;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.fAh);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = fcu;
      if (paramVideoTransPara == null) {
        break label337;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label88:
      ab.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      paramVideoTransPara = fcu;
      if ((paramVideoTransPara == null) || (paramVideoTransPara.fAh != 1))
      {
        paramVideoTransPara = fcu;
        if ((paramVideoTransPara == null) || (paramVideoTransPara.fAh != 2)) {}
      }
      else
      {
        paramVideoTransPara = fcu;
        if (paramVideoTransPara != null) {
          paramVideoTransPara.videoBitrate = 3000000;
        }
      }
      com.tencent.mm.plugin.mmsight.model.j.d(fcu);
      if ((ac.erB.eqQ == -1) || ((ac.erB.eqQ & 0x1) == 0)) {
        break label342;
      }
      eZQ = 1080;
      ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label188:
      paramVideoTransPara = fcu;
      if ((paramVideoTransPara != null) && (com.tencent.mm.plugin.mmsight.model.j.oHG.eqK == 2))
      {
        localObject = d.bQE();
        if ((localObject != null) && (fcu != null))
        {
          if (!((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWa, true)) {
            break label637;
          }
          paramVideoTransPara.width = ((int)(((Point)localObject).x / ((Point)localObject).y * paramVideoTransPara.height));
          paramVideoTransPara.width = d.zn(paramVideoTransPara.width);
        }
      }
    }
    label337:
    label342:
    int i;
    for (;;)
    {
      ab.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(paramVideoTransPara.width), Integer.valueOf(paramVideoTransPara.height) });
      if (fcu != null) {
        break label675;
      }
      ab.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
      qbe = false;
      AppMethodBeat.o(150578);
      return;
      paramVideoTransPara = null;
      break;
      paramVideoTransPara = null;
      break label88;
      if ((ac.erB.eqQ != -1) && ((ac.erB.eqQ & 0x2) != 0))
      {
        eZQ = 720;
        ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
        break label188;
      }
      if ((com.tencent.mm.plugin.mmsight.model.j.oHF) || (com.tencent.mm.plugin.mmsight.model.j.oHG.oHR > 1) || (com.tencent.mm.plugin.mmsight.model.j.bQV()))
      {
        eZQ = com.tencent.mm.plugin.mmsight.model.j.oHG.eZQ;
        ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + com.tencent.mm.plugin.mmsight.model.j.oHG.oHR + " resolutionLimit:" + eZQ);
        break label188;
      }
      eZQ = 1080;
      ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
      if (com.tencent.mm.plugin.mmsight.model.j.oHG.eqK != 1) {
        break label188;
      }
      paramVideoTransPara = ah.getContext().getSystemService("activity");
      if (paramVideoTransPara == null)
      {
        paramVideoTransPara = new v("null cannot be cast to non-null type android.app.ActivityManager");
        AppMethodBeat.o(150578);
        throw paramVideoTransPara;
      }
      i = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
      int j = d.ey(ah.getContext());
      paramVideoTransPara = d.bQE();
      ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + i + ", totalMemory:" + j + ", screenSize:" + paramVideoTransPara);
      if ((i >= 512) && (j >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
      {
        eZQ = 1080;
        ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
        break label188;
      }
      eZQ = 540;
      ab.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
      break label188;
      label637:
      paramVideoTransPara.height = ((int)(((Point)localObject).y / ((Point)localObject).x * paramVideoTransPara.width));
      paramVideoTransPara.height = d.zn(paramVideoTransPara.height);
    }
    label675:
    paramVideoTransPara = fcu;
    if (paramVideoTransPara != null)
    {
      if ((eZQ < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
      {
        qbe = false;
        ab.i("MicroMsg.SightRecordConfig", "init error, param error");
      }
    }
    else
    {
      paramVideoTransPara = g.E(com.tencent.mm.plugin.zero.b.a.class);
      a.f.b.j.p(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
      if (bo.getInt(((com.tencent.mm.plugin.zero.b.a)paramVideoTransPara).Nq().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
        break label869;
      }
      bool1 = true;
      label771:
      i = ac.erC.eqV;
      ab.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + bool1 + ", deviceConfigUseCpuCrop:" + i);
      if (!bool1) {
        break label882;
      }
    }
    label869:
    label882:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (i != -1) {
        if (i == 1) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(bool1)));
        ukj = bool1;
        AppMethodBeat.o(150578);
        return;
        qbe = true;
        ab.i("MicroMsg.SightRecordConfig", "init config succ");
        break;
        bool1 = false;
        break label771;
        bool1 = false;
      }
    }
  }
  
  public static void e(Point paramPoint)
  {
    AppMethodBeat.i(150581);
    a.f.b.j.q(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + com.tencent.mm.plugin.mmsight.model.j.oHG.eqK + ", resolutionLimit:" + eZQ);
    paramPoint = fcu;
    if (paramPoint != null)
    {
      if (com.tencent.mm.plugin.mmsight.model.j.oHG.eqK == 1)
      {
        if (j > paramPoint.width) {
          if (eZQ == 1080)
          {
            paramPoint.width = (j / 2);
            ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + paramPoint.width);
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
          ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + paramPoint.width + 'x' + paramPoint.height);
          AppMethodBeat.o(150581);
          return;
          if (eZQ != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((eZQ == 720) || (eZQ == 540)) && (j < paramPoint.width))
      {
        ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + eZQ + ", adjust video size");
        if (eZQ != 540) {
          break label491;
        }
        paramPoint.width = j;
        ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.zn(paramPoint.width);
        paramPoint.height = d.zn(paramPoint.height);
        ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(150581);
        return;
        label491:
        if (eZQ == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          ab.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(150581);
  }
  
  public static boolean isInit()
  {
    return qbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.c
 * JD-Core Version:    0.7.0.1
 */