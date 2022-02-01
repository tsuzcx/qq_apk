package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.m.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g
{
  private static VideoTransPara gCB;
  private static int gwG;
  private static int scene;
  private static boolean vgQ;
  private static boolean vgR;
  public static final g vgS;
  
  static
  {
    AppMethodBeat.i(75384);
    vgS = new g();
    gwG = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(75380);
    ad.i("MicroMsg.SightRecordConfig", "unInit");
    vgR = false;
    AppMethodBeat.o(75380);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(163422);
    d.g.b.k.h(paramVideoTransPara, "videoTransPara");
    ad.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    gCB = paramVideoTransPara;
    scene = paramInt;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = gCB;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hcj);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = gCB;
      if (paramVideoTransPara == null) {
        break label314;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label89:
      ad.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      com.tencent.mm.plugin.mmsight.model.k.d(gCB);
      if ((ae.fFD.fEi == -1) || ((ae.fFD.fEi & 0x1) == 0)) {
        break label319;
      }
      gwG = 1080;
      ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label143:
      if (paramBoolean)
      {
        localObject = gCB;
        if ((localObject != null) && (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc == 2))
        {
          paramVideoTransPara = ai.cf(aj.getContext());
          if (!ai.jw(aj.getContext())) {
            break label1476;
          }
          paramVideoTransPara = ai.fv(aj.getContext());
        }
      }
    }
    label314:
    label319:
    label1471:
    label1476:
    for (;;)
    {
      if (gCB != null)
      {
        if (!((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pqn, true)) {
          break label611;
        }
        ((VideoTransPara)localObject).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject).height));
        ((VideoTransPara)localObject).width = d.GN(((VideoTransPara)localObject).width);
      }
      int i;
      for (;;)
      {
        ad.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
        if (gCB != null) {
          break label651;
        }
        ad.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        vgR = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label89;
        if ((ae.fFD.fEi != -1) && ((ae.fFD.fEi & 0x2) != 0))
        {
          gwG = 720;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label143;
        }
        if ((com.tencent.mm.plugin.mmsight.model.k.tCM) || (com.tencent.mm.plugin.mmsight.model.k.tCN.tCZ > 1) || (com.tencent.mm.plugin.mmsight.model.k.cPQ()))
        {
          gwG = com.tencent.mm.plugin.mmsight.model.k.tCN.gwG;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + com.tencent.mm.plugin.mmsight.model.k.tCN.tCZ + " resolutionLimit:" + gwG);
          break label143;
        }
        gwG = 1080;
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc != 1) {
          break label143;
        }
        paramVideoTransPara = aj.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new v("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        i = d.fw(aj.getContext());
        paramVideoTransPara = d.cPz();
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + i + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (i >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          gwG = 1080;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label143;
        }
        gwG = 540;
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label143;
        label611:
        ((VideoTransPara)localObject).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject).width));
        ((VideoTransPara)localObject).height = d.GN(((VideoTransPara)localObject).height);
      }
      paramVideoTransPara = gCB;
      if (paramVideoTransPara != null)
      {
        if ((gwG < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          vgR = false;
          ad.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.g.ab(a.class);
        d.g.b.k.g(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bt.getInt(((a)paramVideoTransPara).Zd().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1159;
        }
        paramBoolean = true;
        label747:
        paramInt = ae.fFE.fEn;
        ad.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
        if (!paramBoolean) {
          break label1471;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        label850:
        label878:
        boolean bool;
        if (paramInt != -1)
        {
          if (paramInt == 1) {
            paramBoolean = true;
          }
        }
        else
        {
          ad.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(paramBoolean)));
          vgQ = paramBoolean;
          switch (scene)
          {
          default: 
            paramInt = -1;
            switch (scene)
            {
            default: 
              i = -1;
              switch (scene)
              {
              default: 
                paramBoolean = false;
                switch (scene)
                {
                default: 
                  bool = false;
                  ad.i("MicroMsg.SightRecordConfig", "checkEnableHevc, deviceSwEnableHevc:" + paramInt + ", deviceHwEnableHevc:" + i + ", exptSwEnableHevc:" + paramBoolean + ", exptHwEnableHevc:" + bool);
                  if ((paramBoolean) || (paramInt != -1))
                  {
                    if (paramInt != 1) {
                      break label1337;
                    }
                    paramVideoTransPara = gCB;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hcu = 1;
                    }
                  }
                  label1015:
                  if ((bool) || (i != -1))
                  {
                    if (i != 1) {
                      break label1398;
                    }
                    paramVideoTransPara = gCB;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hct = 1;
                    }
                  }
                  paramVideoTransPara = gCB;
                  if ((paramVideoTransPara != null) && (paramVideoTransPara.hcu == 1)) {
                    com.tencent.mm.plugin.mmsight.model.k.tCN.fEc = 1;
                  }
                  localObject = new StringBuilder("checkEnableHevc, hwEnableHevc:");
                  paramVideoTransPara = gCB;
                  if (paramVideoTransPara != null)
                  {
                    paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hct);
                    label1094:
                    localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(", swEnableHevc:");
                    paramVideoTransPara = gCB;
                    if (paramVideoTransPara == null) {
                      break label1466;
                    }
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
        }
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hcu);; paramVideoTransPara = null)
        {
          ad.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          vgR = true;
          ad.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label747;
          paramBoolean = false;
          break label804;
          paramInt = ae.fFD.fEG;
          break label850;
          paramInt = ae.fFD.fEH;
          break label850;
          i = ae.fFD.fEE;
          break label878;
          i = ae.fFD.fEF;
          break label878;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pvL, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pvK, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pvI, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pvJ, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if ((paramBoolean) && (paramInt == 2))
          {
            paramVideoTransPara = gCB;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hcu = 0;
            break label1015;
          }
          if (paramBoolean)
          {
            paramVideoTransPara = gCB;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hcu = 1;
            break label1015;
          }
          paramVideoTransPara = gCB;
          if (paramVideoTransPara == null) {
            break label1015;
          }
          paramVideoTransPara.hcu = 0;
          break label1015;
          label1398:
          if ((bool) && (i == 2))
          {
            paramVideoTransPara = gCB;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hct = 0;
            break label1043;
          }
          if (bool)
          {
            paramVideoTransPara = gCB;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hct = 1;
            break label1043;
          }
          paramVideoTransPara = gCB;
          if (paramVideoTransPara == null) {
            break label1043;
          }
          paramVideoTransPara.hct = 0;
          break label1043;
          paramVideoTransPara = null;
          break label1094;
        }
      }
    }
  }
  
  public static VideoTransPara dhs()
  {
    return gCB;
  }
  
  public static int dht()
  {
    if ((com.tencent.mm.plugin.mmsight.model.k.tCN == null) || (!vgR)) {
      return 2;
    }
    return com.tencent.mm.plugin.mmsight.model.k.tCN.fEc;
  }
  
  public static int dhu()
  {
    return gwG;
  }
  
  public static boolean dhv()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((com.tencent.mm.plugin.mmsight.model.k.tCN == null) || (!vgR))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(vgQ).append(", swEnableHevc:");
      localObject1 = gCB;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hcu);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = gCB;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.hct);
      }
      ad.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!vgQ))
      {
        localObject1 = gCB;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).hcu != 1)) {
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
  
  public static void dhw()
  {
    AppMethodBeat.i(75383);
    h.vKh.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (vgR)
    {
      if (dht() == 1) {
        i = 39;
      }
      if (gwG != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      h.vKh.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static final void e(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    d.g.b.k.h(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + com.tencent.mm.plugin.mmsight.model.k.tCN.fEc + ", resolutionLimit:" + gwG);
    paramPoint = gCB;
    if (paramPoint != null)
    {
      if (com.tencent.mm.plugin.mmsight.model.k.tCN.fEc == 1)
      {
        if (j > paramPoint.width) {
          if (gwG == 1080)
          {
            paramPoint.width = (j / 2);
            ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + paramPoint.width);
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
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + paramPoint.width + 'x' + paramPoint.height);
          AppMethodBeat.o(75382);
          return;
          if (gwG != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((gwG == 720) || (gwG == 540)) && (j < paramPoint.width))
      {
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + gwG + ", adjust video size");
        if (gwG != 540) {
          break label493;
        }
        paramPoint.width = j;
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.GN(paramPoint.width);
        paramPoint.height = d.GN(paramPoint.height);
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (gwG == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(75382);
  }
  
  public static String fXZ()
  {
    AppMethodBeat.i(204074);
    String str = "cpuCrop:" + dhv() + ", recorderType:" + dht() + ", resolutionLimit:" + gwG + ", videoParams:" + gCB;
    AppMethodBeat.o(204074);
    return str;
  }
  
  public static final boolean isInit()
  {
    return vgR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.g
 * JD-Core Version:    0.7.0.1
 */