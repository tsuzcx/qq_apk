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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g
{
  private static int gXd;
  private static VideoTransPara hcZ;
  private static int scene;
  private static boolean wpC;
  private static boolean wpD;
  public static final g wpE;
  
  static
  {
    AppMethodBeat.i(75384);
    wpE = new g();
    gXd = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(163422);
    d.g.b.k.h(paramVideoTransPara, "videoTransPara");
    ac.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    hcZ = paramVideoTransPara;
    scene = paramInt;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = hcZ;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hCL);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = hcZ;
      if (paramVideoTransPara == null) {
        break label314;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label89:
      ac.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      com.tencent.mm.plugin.mmsight.model.k.d(hcZ);
      if ((ae.fJk.fHP == -1) || ((ae.fJk.fHP & 0x1) == 0)) {
        break label319;
      }
      gXd = 1080;
      ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label143:
      if (paramBoolean)
      {
        localObject = hcZ;
        if ((localObject != null) && (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ == 2))
        {
          paramVideoTransPara = aj.cl(ai.getContext());
          if (!aj.jH(ai.getContext())) {
            break label1476;
          }
          paramVideoTransPara = aj.fH(ai.getContext());
        }
      }
    }
    label314:
    label319:
    label1471:
    label1476:
    for (;;)
    {
      if (hcZ != null)
      {
        if (!((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pTY, true)) {
          break label609;
        }
        ((VideoTransPara)localObject).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject).height));
        ((VideoTransPara)localObject).width = d.IJ(((VideoTransPara)localObject).width);
      }
      int i;
      for (;;)
      {
        ac.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
        if (hcZ != null) {
          break label649;
        }
        ac.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        wpD = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label89;
        if ((ae.fJk.fHP != -1) && ((ae.fJk.fHP & 0x2) != 0))
        {
          gXd = 720;
          ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label143;
        }
        if ((com.tencent.mm.plugin.mmsight.model.k.uLj) || (com.tencent.mm.plugin.mmsight.model.k.uLk.uLw > 1) || (com.tencent.mm.plugin.mmsight.model.k.ddy()))
        {
          gXd = com.tencent.mm.plugin.mmsight.model.k.uLk.gXd;
          ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + com.tencent.mm.plugin.mmsight.model.k.uLk.uLw + " resolutionLimit:" + gXd);
          break label143;
        }
        gXd = 1080;
        ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ != 1) {
          break label143;
        }
        paramVideoTransPara = ai.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new v("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        i = d.fI(ai.getContext());
        paramVideoTransPara = d.ddi();
        ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + i + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (i >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          gXd = 1080;
          ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label143;
        }
        gXd = 540;
        ac.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label143;
        label609:
        ((VideoTransPara)localObject).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject).width));
        ((VideoTransPara)localObject).height = d.IJ(((VideoTransPara)localObject).height);
      }
      paramVideoTransPara = hcZ;
      if (paramVideoTransPara != null)
      {
        if ((gXd < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          wpD = false;
          ac.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.g.ab(a.class);
        d.g.b.k.g(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bs.getInt(((a)paramVideoTransPara).ZY().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1159;
        }
        paramBoolean = true;
        label745:
        paramInt = ae.fJl.fHU;
        ac.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
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
          ac.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(paramBoolean)));
          wpC = paramBoolean;
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
                  ac.i("MicroMsg.SightRecordConfig", "checkEnableHevc, deviceSwEnableHevc:" + paramInt + ", deviceHwEnableHevc:" + i + ", exptSwEnableHevc:" + paramBoolean + ", exptHwEnableHevc:" + bool);
                  if ((paramBoolean) || (paramInt != -1))
                  {
                    if (paramInt != 1) {
                      break label1337;
                    }
                    paramVideoTransPara = hcZ;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hCX = 1;
                    }
                  }
                  label1015:
                  if ((bool) || (i != -1))
                  {
                    if (i != 1) {
                      break label1398;
                    }
                    paramVideoTransPara = hcZ;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hCW = 1;
                    }
                  }
                  paramVideoTransPara = hcZ;
                  if ((paramVideoTransPara != null) && (paramVideoTransPara.hCX == 1)) {
                    com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ = 1;
                  }
                  localObject = new StringBuilder("checkEnableHevc, hwEnableHevc:");
                  paramVideoTransPara = hcZ;
                  if (paramVideoTransPara != null)
                  {
                    paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hCW);
                    label1094:
                    localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(", swEnableHevc:");
                    paramVideoTransPara = hcZ;
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
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hCX);; paramVideoTransPara = null)
        {
          ac.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          wpD = true;
          ac.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label745;
          paramBoolean = false;
          break label802;
          paramInt = ae.fJk.fIn;
          break label850;
          paramInt = ae.fJk.fIo;
          break label850;
          i = ae.fJk.fIl;
          break label878;
          i = ae.fJk.fIm;
          break label878;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pZZ, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pZY, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pZW, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pZX, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if ((paramBoolean) && (paramInt == 2))
          {
            paramVideoTransPara = hcZ;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hCX = 0;
            break label1015;
          }
          if (paramBoolean)
          {
            paramVideoTransPara = hcZ;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hCX = 1;
            break label1015;
          }
          paramVideoTransPara = hcZ;
          if (paramVideoTransPara == null) {
            break label1015;
          }
          paramVideoTransPara.hCX = 0;
          break label1015;
          label1398:
          if ((bool) && (i == 2))
          {
            paramVideoTransPara = hcZ;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hCW = 0;
            break label1043;
          }
          if (bool)
          {
            paramVideoTransPara = hcZ;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hCW = 1;
            break label1043;
          }
          paramVideoTransPara = hcZ;
          if (paramVideoTransPara == null) {
            break label1043;
          }
          paramVideoTransPara.hCW = 0;
          break label1043;
          paramVideoTransPara = null;
          break label1094;
        }
      }
    }
  }
  
  public static String duY()
  {
    AppMethodBeat.i(199263);
    String str = "cpuCrop:" + dvc() + ", recorderType:" + dva() + ", resolutionLimit:" + gXd + ", videoParams:" + hcZ;
    AppMethodBeat.o(199263);
    return str;
  }
  
  public static VideoTransPara duZ()
  {
    return hcZ;
  }
  
  public static int dva()
  {
    if ((com.tencent.mm.plugin.mmsight.model.k.uLk == null) || (!wpD)) {
      return 2;
    }
    return com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ;
  }
  
  public static int dvb()
  {
    return gXd;
  }
  
  public static boolean dvc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((com.tencent.mm.plugin.mmsight.model.k.uLk == null) || (!wpD))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(wpC).append(", swEnableHevc:");
      localObject1 = hcZ;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hCX);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = hcZ;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.hCW);
      }
      ac.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!wpC))
      {
        localObject1 = hcZ;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).hCX != 1)) {
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
  
  public static void dvd()
  {
    AppMethodBeat.i(75383);
    h.wUl.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (wpD)
    {
      if (dva() == 1) {
        i = 39;
      }
      if (gXd != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      h.wUl.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static final void g(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    d.g.b.k.h(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ + ", resolutionLimit:" + gXd);
    paramPoint = hcZ;
    if (paramPoint != null)
    {
      if (com.tencent.mm.plugin.mmsight.model.k.uLk.fHJ == 1)
      {
        if (j > paramPoint.width) {
          if (gXd == 1080)
          {
            paramPoint.width = (j / 2);
            ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + paramPoint.width);
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
          ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + paramPoint.width + 'x' + paramPoint.height);
          AppMethodBeat.o(75382);
          return;
          if (gXd != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((gXd == 720) || (gXd == 540)) && (j < paramPoint.width))
      {
        ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + gXd + ", adjust video size");
        if (gXd != 540) {
          break label493;
        }
        paramPoint.width = j;
        ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.IJ(paramPoint.width);
        paramPoint.height = d.IJ(paramPoint.height);
        ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (gXd == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          ac.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(75382);
  }
  
  public static final boolean isInit()
  {
    return wpD;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(75380);
    ac.i("MicroMsg.SightRecordConfig", "unInit");
    wpD = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.g
 * JD-Core Version:    0.7.0.1
 */