package com.tencent.mm.plugin.recordvideo.b;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"})
public final class g
{
  private static boolean BNv;
  private static boolean BNw;
  public static final g BNx;
  private static int ilT;
  private static VideoTransPara irT;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(75384);
    BNx = new g();
    ilT = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(163422);
    kotlin.g.b.p.h(paramVideoTransPara, "videoTransPara");
    Log.i("MicroMsg.SightRecordConfig", "init videoTransPara:".concat(String.valueOf(paramVideoTransPara)));
    irT = paramVideoTransPara;
    scene = paramInt;
    Object localObject = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = irT;
    if (paramVideoTransPara != null)
    {
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.iTg);
      localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = irT;
      if (paramVideoTransPara == null) {
        break label314;
      }
      paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
      label89:
      Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      k.d(irT);
      if ((ae.gKA.gIV == -1) || ((ae.gKA.gIV & 0x1) == 0)) {
        break label319;
      }
      ilT = 1080;
      Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label143:
      if (paramBoolean)
      {
        localObject = irT;
        if ((localObject != null) && (k.zuy.gIP == 2))
        {
          paramVideoTransPara = ao.az(MMApplicationContext.getContext());
          if (!ao.jU(MMApplicationContext.getContext())) {
            break label1476;
          }
          paramVideoTransPara = ao.gx(MMApplicationContext.getContext());
        }
      }
    }
    label314:
    label319:
    label1471:
    label1476:
    for (;;)
    {
      if (irT != null)
      {
        if (!((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rYW, true)) {
          break label609;
        }
        ((VideoTransPara)localObject).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject).height));
        ((VideoTransPara)localObject).width = d.QH(((VideoTransPara)localObject).width);
      }
      int i;
      for (;;)
      {
        Log.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: %sx%s", new Object[] { Integer.valueOf(((VideoTransPara)localObject).width), Integer.valueOf(((VideoTransPara)localObject).height) });
        if (irT != null) {
          break label649;
        }
        Log.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        BNw = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = null;
        break;
        paramVideoTransPara = null;
        break label89;
        if ((ae.gKA.gIV != -1) && ((ae.gKA.gIV & 0x2) != 0))
        {
          ilT = 720;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label143;
        }
        if ((k.zux) || (k.zuy.zuK > 1) || (k.ejH()))
        {
          ilT = k.zuy.ilT;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + k.zuy.zuK + " resolutionLimit:" + ilT);
          break label143;
        }
        ilT = 1080;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (k.zuy.gIP != 1) {
          break label143;
        }
        paramVideoTransPara = MMApplicationContext.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new t("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        i = d.gy(MMApplicationContext.getContext());
        paramVideoTransPara = d.ejr();
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + i + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (i >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          ilT = 1080;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label143;
        }
        ilT = 540;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label143;
        label609:
        ((VideoTransPara)localObject).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject).width));
        ((VideoTransPara)localObject).height = d.QH(((VideoTransPara)localObject).height);
      }
      paramVideoTransPara = irT;
      if (paramVideoTransPara != null)
      {
        if ((ilT < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          BNw = false;
          Log.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        paramVideoTransPara = com.tencent.mm.kernel.g.af(a.class);
        kotlin.g.b.p.g(paramVideoTransPara, "MMKernel.service<IConfig…onfigService::class.java)");
        if (Util.getInt(((a)paramVideoTransPara).aqJ().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1159;
        }
        paramBoolean = true;
        label745:
        paramInt = ae.gKB.gJa;
        Log.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
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
          Log.i("MicroMsg.SightRecordConfig", "final set useCpuCrop:".concat(String.valueOf(paramBoolean)));
          BNv = paramBoolean;
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
                  Log.i("MicroMsg.SightRecordConfig", "checkEnableHevc, deviceSwEnableHevc:" + paramInt + ", deviceHwEnableHevc:" + i + ", exptSwEnableHevc:" + paramBoolean + ", exptHwEnableHevc:" + bool);
                  if ((paramBoolean) || (paramInt != -1))
                  {
                    if (paramInt != 1) {
                      break label1337;
                    }
                    paramVideoTransPara = irT;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.iTs = 1;
                    }
                  }
                  label1015:
                  if ((bool) || (i != -1))
                  {
                    if (i != 1) {
                      break label1398;
                    }
                    paramVideoTransPara = irT;
                    if (paramVideoTransPara != null) {
                      paramVideoTransPara.iTr = 1;
                    }
                  }
                  paramVideoTransPara = irT;
                  if ((paramVideoTransPara != null) && (paramVideoTransPara.iTs == 1)) {
                    k.zuy.gIP = 1;
                  }
                  localObject = new StringBuilder("checkEnableHevc, hwEnableHevc:");
                  paramVideoTransPara = irT;
                  if (paramVideoTransPara != null)
                  {
                    paramVideoTransPara = Integer.valueOf(paramVideoTransPara.iTr);
                    label1094:
                    localObject = ((StringBuilder)localObject).append(paramVideoTransPara).append(", swEnableHevc:");
                    paramVideoTransPara = irT;
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
        for (paramVideoTransPara = Integer.valueOf(paramVideoTransPara.iTs);; paramVideoTransPara = null)
        {
          Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          BNw = true;
          Log.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label745;
          paramBoolean = false;
          break label802;
          paramInt = ae.gKA.gJu;
          break label850;
          paramInt = ae.gKA.gJv;
          break label850;
          i = ae.gKA.gJs;
          break label878;
          i = ae.gKA.gJt;
          break label878;
          if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sjV, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sjU, 0) == 1)
          {
            paramBoolean = true;
            break label906;
          }
          paramBoolean = false;
          break label906;
          if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sjS, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sjT, 0) == 1)
          {
            bool = true;
            break label935;
          }
          bool = false;
          break label935;
          if ((paramBoolean) && (paramInt == 2))
          {
            paramVideoTransPara = irT;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.iTs = 0;
            break label1015;
          }
          if (paramBoolean)
          {
            paramVideoTransPara = irT;
            if (paramVideoTransPara == null) {
              break label1015;
            }
            paramVideoTransPara.iTs = 1;
            break label1015;
          }
          paramVideoTransPara = irT;
          if (paramVideoTransPara == null) {
            break label1015;
          }
          paramVideoTransPara.iTs = 0;
          break label1015;
          label1398:
          if ((bool) && (i == 2))
          {
            paramVideoTransPara = irT;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.iTr = 0;
            break label1043;
          }
          if (bool)
          {
            paramVideoTransPara = irT;
            if (paramVideoTransPara == null) {
              break label1043;
            }
            paramVideoTransPara.iTr = 1;
            break label1043;
          }
          paramVideoTransPara = irT;
          if (paramVideoTransPara == null) {
            break label1043;
          }
          paramVideoTransPara.iTr = 0;
          break label1043;
          paramVideoTransPara = null;
          break label1094;
        }
      }
    }
  }
  
  public static int eJA()
  {
    return ilT;
  }
  
  public static boolean eJB()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((k.zuy == null) || (!BNw))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (k.zuy.gIP == 1)
    {
      bool = true;
      localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(BNv).append(", swEnableHevc:");
      localObject1 = irT;
      if (localObject1 == null) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = Integer.valueOf(((VideoTransPara)localObject1).iTs);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      VideoTransPara localVideoTransPara = irT;
      localObject1 = localObject2;
      if (localVideoTransPara != null) {
        localObject1 = Integer.valueOf(localVideoTransPara.iTr);
      }
      Log.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!BNv))
      {
        localObject1 = irT;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).iTs != 1)) {
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
  
  public static void eJC()
  {
    AppMethodBeat.i(75383);
    h.CyF.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (BNw)
    {
      if (eJz() == 1) {
        i = 39;
      }
      if (ilT != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      h.CyF.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static String eJx()
  {
    AppMethodBeat.i(237256);
    String str = "cpuCrop:" + eJB() + ", recorderType:" + eJz() + ", resolutionLimit:" + ilT + ", videoParams:" + irT;
    AppMethodBeat.o(237256);
    return str;
  }
  
  public static VideoTransPara eJy()
  {
    return irT;
  }
  
  public static int eJz()
  {
    if ((k.zuy == null) || (!BNw)) {
      return 2;
    }
    return k.zuy.gIP;
  }
  
  public static final boolean isInit()
  {
    return BNw;
  }
  
  public static final void j(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    kotlin.g.b.p.h(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + k.zuy.gIP + ", resolutionLimit:" + ilT);
    paramPoint = irT;
    if (paramPoint != null)
    {
      if (k.zuy.gIP == 1)
      {
        if (j > paramPoint.width) {
          if (ilT == 1080)
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
          if (ilT != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffempg 720p, videoWidth:" + paramPoint.width);
          break;
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((ilT == 720) || (ilT == 540)) && (j < paramPoint.width))
      {
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + ilT + ", adjust video size");
        if (ilT != 540) {
          break label493;
        }
        paramPoint.width = j;
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 540p, videoWidth:" + paramPoint.width);
      }
      for (;;)
      {
        paramPoint.height = ((int)(i / j * paramPoint.width));
        paramPoint.width = d.QH(paramPoint.width);
        paramPoint.height = d.QH(paramPoint.height);
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
        AppMethodBeat.o(75382);
        return;
        label493:
        if (ilT == 720)
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
    BNw = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.g
 * JD-Core Version:    0.7.0.1
 */