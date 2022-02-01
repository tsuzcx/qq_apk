package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g
{
  private static int hrX;
  private static VideoTransPara hxV;
  private static int scene;
  private static boolean xNp;
  private static boolean xNq;
  public static final g xNr;
  
  static
  {
    AppMethodBeat.i(75384);
    xNr = new g();
    hrX = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(163422);
    d.g.b.p.h(paramVideoTransPara, "videoTransPara");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    hxV = paramVideoTransPara;
    scene = paramInt;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = hxV;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hYi);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = hxV;
      if (paramVideoTransPara == null) {
        break label314;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label89:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      k.d(hxV);
      if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx == -1) || ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x1) == 0)) {
        break label319;
      }
      hrX = 1080;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label143:
      if (paramBoolean)
      {
        localObject = hxV;
        if ((localObject != null) && (k.wat.gdr == 2))
        {
          paramVideoTransPara = al.ck(ak.getContext());
          if (!al.ka(ak.getContext())) {
            break label1476;
          }
          paramVideoTransPara = al.fS(ak.getContext());
        }
      }
    }
    label314:
    label319:
    label1471:
    label1476:
    for (;;)
    {
      if (hxV != null)
      {
        if (!((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFK, true)) {
          break label609;
        }
        ((VideoTransPara)localObject).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject).height));
        ((VideoTransPara)localObject).width = d.KG(((VideoTransPara)localObject).width);
      }
      int i;
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
        if (hxV != null) {
          break label649;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        xNq = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label89;
        if ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx != -1) && ((com.tencent.mm.compatible.deviceinfo.ae.geT.gdx & 0x2) != 0))
        {
          hrX = 720;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label143;
        }
        if ((k.was) || (k.wat.waF > 1) || (k.dpS()))
        {
          hrX = k.wat.hrX;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + k.wat.waF + " resolutionLimit:" + hrX);
          break label143;
        }
        hrX = 1080;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (k.wat.gdr != 1) {
          break label143;
        }
        paramVideoTransPara = ak.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new v("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        i = d.fT(ak.getContext());
        paramVideoTransPara = d.dpC();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + i + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (i >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          hrX = 1080;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label143;
        }
        hrX = 540;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label143;
        label609:
        ((VideoTransPara)localObject).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject).width));
        ((VideoTransPara)localObject).height = d.KG(((VideoTransPara)localObject).height);
      }
      paramVideoTransPara = hxV;
      if (paramVideoTransPara != null)
      {
        if ((hrX < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          xNq = false;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.g.ab(a.class);
        d.g.b.p.g(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bu.getInt(((a)paramVideoTransPara).acL().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1159;
        }
        paramBoolean = true;
        label745:
        paramInt = com.tencent.mm.compatible.deviceinfo.ae.geU.gdC;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(paramBoolean)));
          xNp = paramBoolean;
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
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "checkEnableHevc, deviceSwEnableHevc:" + paramInt + ", deviceHwEnableHevc:" + i + ", exptSwEnableHevc:" + paramBoolean + ", exptHwEnableHevc:" + bool);
                  if ((paramBoolean) || (paramInt != -1))
                  {
                    if (paramInt != 1) {
                      break label1337;
                    }
                    paramVideoTransPara = hxV;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hYu = 1;
                    }
                  }
                  label1015:
                  if ((bool) || (i != -1))
                  {
                    if (i != 1) {
                      break label1398;
                    }
                    paramVideoTransPara = hxV;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hYt = 1;
                    }
                  }
                  paramVideoTransPara = hxV;
                  if ((paramVideoTransPara != null) && (paramVideoTransPara.hYu == 1)) {
                    k.wat.gdr = 1;
                  }
                  localObject = new StringBuilder("checkEnableHevc, hwEnableHevc:");
                  paramVideoTransPara = hxV;
                  if (paramVideoTransPara != null)
                  {
                    paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hYt);
                    label1094:
                    localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(", swEnableHevc:");
                    paramVideoTransPara = hxV;
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
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hYu);; paramVideoTransPara = null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          xNq = true;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label745;
          paramBoolean = false;
          break label802;
          paramInt = com.tencent.mm.compatible.deviceinfo.ae.geT.gdV;
          break label850;
          paramInt = com.tencent.mm.compatible.deviceinfo.ae.geT.gdW;
          break label850;
          i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdT;
          break label878;
          i = com.tencent.mm.compatible.deviceinfo.ae.geT.gdU;
          break label878;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qNa, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qMZ, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qMX, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qMY, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if ((paramBoolean) && (paramInt == 2))
          {
            paramVideoTransPara = hxV;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hYu = 0;
            break label1015;
          }
          if (paramBoolean)
          {
            paramVideoTransPara = hxV;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hYu = 1;
            break label1015;
          }
          paramVideoTransPara = hxV;
          if (paramVideoTransPara == null) {
            break label1015;
          }
          paramVideoTransPara.hYu = 0;
          break label1015;
          label1398:
          if ((bool) && (i == 2))
          {
            paramVideoTransPara = hxV;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hYt = 0;
            break label1043;
          }
          if (bool)
          {
            paramVideoTransPara = hxV;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hYt = 1;
            break label1043;
          }
          paramVideoTransPara = hxV;
          if (paramVideoTransPara == null) {
            break label1043;
          }
          paramVideoTransPara.hYt = 0;
          break label1043;
          paramVideoTransPara = null;
          break label1094;
        }
      }
    }
  }
  
  public static String dIK()
  {
    AppMethodBeat.i(206551);
    String str = "cpuCrop:" + dIO() + ", recorderType:" + dIM() + ", resolutionLimit:" + hrX + ", videoParams:" + hxV;
    AppMethodBeat.o(206551);
    return str;
  }
  
  public static VideoTransPara dIL()
  {
    return hxV;
  }
  
  public static int dIM()
  {
    if ((k.wat == null) || (!xNq)) {
      return 2;
    }
    return k.wat.gdr;
  }
  
  public static int dIN()
  {
    return hrX;
  }
  
  public static boolean dIO()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((k.wat == null) || (!xNq))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (k.wat.gdr == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(xNp).append(", swEnableHevc:");
      localObject1 = hxV;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hYu);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = hxV;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.hYt);
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!xNp))
      {
        localObject1 = hxV;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).hYu != 1)) {
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
  
  public static void dIP()
  {
    AppMethodBeat.i(75383);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (xNq)
    {
      if (dIM() == 1) {
        i = 39;
      }
      if (hrX != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static final void i(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    d.g.b.p.h(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + k.wat.gdr + ", resolutionLimit:" + hrX);
    paramPoint = hxV;
    if (paramPoint != null)
    {
      if (k.wat.gdr == 1)
      {
        if (j > paramPoint.width) {
          if (hrX == 1080)
          {
            paramPoint.width = (j / 2);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 1080p, videoWidth:" + paramPoint.width);
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg final videoSize:" + paramPoint.width + 'x' + paramPoint.height);
          AppMethodBeat.o(75382);
          return;
          if (hrX != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((hrX == 720) || (hrX == 540)) && (j < paramPoint.width))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + hrX + ", adjust video size");
        if (hrX != 540) {
          break label493;
        }
        paramPoint.width = j;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.KG(paramPoint.width);
        paramPoint.height = d.KG(paramPoint.height);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (hrX == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(75382);
  }
  
  public static final boolean isInit()
  {
    return xNq;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(75380);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightRecordConfig", "unInit");
    xNq = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.g
 * JD-Core Version:    0.7.0.1
 */