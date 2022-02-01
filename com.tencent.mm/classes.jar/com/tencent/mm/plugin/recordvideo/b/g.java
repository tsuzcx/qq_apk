package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g
{
  private static int hpj;
  private static VideoTransPara hvh;
  private static int scene;
  private static boolean xxs;
  private static boolean xxt;
  public static final g xxu;
  
  static
  {
    AppMethodBeat.i(75384);
    xxu = new g();
    hpj = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(163422);
    d.g.b.p.h(paramVideoTransPara, "videoTransPara");
    ad.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    hvh = paramVideoTransPara;
    scene = paramInt;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = hvh;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hVq);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = hvh;
      if (paramVideoTransPara == null) {
        break label314;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label89:
      ad.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      k.d(hvh);
      if ((ae.gcL.gbp == -1) || ((ae.gcL.gbp & 0x1) == 0)) {
        break label319;
      }
      hpj = 1080;
      ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label143:
      if (paramBoolean)
      {
        localObject = hvh;
        if ((localObject != null) && (k.vOq.gbj == 2))
        {
          paramVideoTransPara = al.ci(aj.getContext());
          if (!al.jT(aj.getContext())) {
            break label1476;
          }
          paramVideoTransPara = al.fM(aj.getContext());
        }
      }
    }
    label314:
    label319:
    label1471:
    label1476:
    for (;;)
    {
      if (hvh != null)
      {
        if (!((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qyE, true)) {
          break label609;
        }
        ((VideoTransPara)localObject).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject).height));
        ((VideoTransPara)localObject).width = d.Kg(((VideoTransPara)localObject).width);
      }
      int i;
      for (;;)
      {
        ad.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
        if (hvh != null) {
          break label649;
        }
        ad.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        xxt = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label89;
        if ((ae.gcL.gbp != -1) && ((ae.gcL.gbp & 0x2) != 0))
        {
          hpj = 720;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label143;
        }
        if ((k.vOp) || (k.vOq.vOC > 1) || (k.dmU()))
        {
          hpj = k.vOq.hpj;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + k.vOq.vOC + " resolutionLimit:" + hpj);
          break label143;
        }
        hpj = 1080;
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (k.vOq.gbj != 1) {
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
        i = d.fN(aj.getContext());
        paramVideoTransPara = d.dmE();
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + i + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (i >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          hpj = 1080;
          ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label143;
        }
        hpj = 540;
        ad.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label143;
        label609:
        ((VideoTransPara)localObject).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject).width));
        ((VideoTransPara)localObject).height = d.Kg(((VideoTransPara)localObject).height);
      }
      paramVideoTransPara = hvh;
      if (paramVideoTransPara != null)
      {
        if ((hpj < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          xxt = false;
          ad.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.g.ab(a.class);
        d.g.b.p.g(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bt.getInt(((a)paramVideoTransPara).acA().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1159;
        }
        paramBoolean = true;
        label745:
        paramInt = ae.gcM.gbu;
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
          xxs = paramBoolean;
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
                    paramVideoTransPara = hvh;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hVC = 1;
                    }
                  }
                  label1015:
                  if ((bool) || (i != -1))
                  {
                    if (i != 1) {
                      break label1398;
                    }
                    paramVideoTransPara = hvh;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.hVB = 1;
                    }
                  }
                  paramVideoTransPara = hvh;
                  if ((paramVideoTransPara != null) && (paramVideoTransPara.hVC == 1)) {
                    k.vOq.gbj = 1;
                  }
                  localObject = new StringBuilder("checkEnableHevc, hwEnableHevc:");
                  paramVideoTransPara = hvh;
                  if (paramVideoTransPara != null)
                  {
                    paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hVB);
                    label1094:
                    localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(", swEnableHevc:");
                    paramVideoTransPara = hvh;
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
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.hVC);; paramVideoTransPara = null)
        {
          ad.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          xxt = true;
          ad.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label745;
          paramBoolean = false;
          break label802;
          paramInt = ae.gcL.gbN;
          break label850;
          paramInt = ae.gcL.gbO;
          break label850;
          i = ae.gcL.gbL;
          break label878;
          i = ae.gcL.gbM;
          break label878;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFu, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFt, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFr, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qFs, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if ((paramBoolean) && (paramInt == 2))
          {
            paramVideoTransPara = hvh;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hVC = 0;
            break label1015;
          }
          if (paramBoolean)
          {
            paramVideoTransPara = hvh;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.hVC = 1;
            break label1015;
          }
          paramVideoTransPara = hvh;
          if (paramVideoTransPara == null) {
            break label1015;
          }
          paramVideoTransPara.hVC = 0;
          break label1015;
          label1398:
          if ((bool) && (i == 2))
          {
            paramVideoTransPara = hvh;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hVB = 0;
            break label1043;
          }
          if (bool)
          {
            paramVideoTransPara = hvh;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.hVB = 1;
            break label1043;
          }
          paramVideoTransPara = hvh;
          if (paramVideoTransPara == null) {
            break label1043;
          }
          paramVideoTransPara.hVB = 0;
          break label1043;
          paramVideoTransPara = null;
          break label1094;
        }
      }
    }
  }
  
  public static String dFt()
  {
    AppMethodBeat.i(200290);
    String str = "cpuCrop:" + dFx() + ", recorderType:" + dFv() + ", resolutionLimit:" + hpj + ", videoParams:" + hvh;
    AppMethodBeat.o(200290);
    return str;
  }
  
  public static VideoTransPara dFu()
  {
    return hvh;
  }
  
  public static int dFv()
  {
    if ((k.vOq == null) || (!xxt)) {
      return 2;
    }
    return k.vOq.gbj;
  }
  
  public static int dFw()
  {
    return hpj;
  }
  
  public static boolean dFx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((k.vOq == null) || (!xxt))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (k.vOq.gbj == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(xxs).append(", swEnableHevc:");
      localObject1 = hvh;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).hVC);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = hvh;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.hVB);
      }
      ad.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!xxs))
      {
        localObject1 = hvh;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).hVC != 1)) {
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
  
  public static void dFy()
  {
    AppMethodBeat.i(75383);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (xxt)
    {
      if (dFv() == 1) {
        i = 39;
      }
      if (hpj != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static final void h(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    d.g.b.p.h(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + k.vOq.gbj + ", resolutionLimit:" + hpj);
    paramPoint = hvh;
    if (paramPoint != null)
    {
      if (k.vOq.gbj == 1)
      {
        if (j > paramPoint.width) {
          if (hpj == 1080)
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
          if (hpj != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((hpj == 720) || (hpj == 540)) && (j < paramPoint.width))
      {
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + hpj + ", adjust video size");
        if (hpj != 540) {
          break label493;
        }
        paramPoint.width = j;
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.Kg(paramPoint.width);
        paramPoint.height = d.Kg(paramPoint.height);
        ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (hpj == 720)
        {
          paramPoint.width = ((int)(j * 0.75D));
          ad.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p, videoWidth:" + paramPoint.width);
        }
      }
    }
    AppMethodBeat.o(75382);
  }
  
  public static final boolean isInit()
  {
    return xxt;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(75380);
    ad.i("MicroMsg.SightRecordConfig", "unInit");
    xxt = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.g
 * JD-Core Version:    0.7.0.1
 */