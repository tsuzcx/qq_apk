package com.tencent.mm.plugin.recordvideo.c;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.k.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/SightRecordConfig;", "", "()V", "RECORDER_CAPTURE_RESOLUTION_1080P", "", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "TAG", "", "initSucc", "", "resolutionLimit", "scene", "svrConfigUseCpuCrop", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "afterCameraOpen", "", "cropPreviewSize", "Landroid/graphics/Point;", "checkEnableHevc", "cpuCrop", "doIDKeyReport", "init", "videoTransPara", "adjustVideoSizeByScreen", "isInit", "listConfig", "recorderType", "serverConfigUseCpuCrop", "setResolutionLimit", "setVideoSize", "setVideoSizeKeepRatio", "unInit", "useCameraApi2", "useImageStream", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h NHb;
  private static boolean NHc;
  private static boolean NHd;
  private static int nFY;
  private static VideoTransPara nLH;
  private static int scene;
  
  static
  {
    AppMethodBeat.i(75384);
    NHb = new h();
    nFY = -1;
    AppMethodBeat.o(75384);
  }
  
  public static void a(VideoTransPara paramVideoTransPara, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(163422);
    s.u(paramVideoTransPara, "videoTransPara");
    Log.i("MicroMsg.SightRecordConfig", s.X("init videoTransPara:", paramVideoTransPara));
    nLH = paramVideoTransPara;
    scene = paramInt;
    Object localObject2 = new StringBuilder("ABA: snstimeline Use ABA methods to improve the capturing bitrate, abaSwitch:");
    paramVideoTransPara = nLH;
    if (paramVideoTransPara == null)
    {
      paramVideoTransPara = null;
      localObject2 = ((StringBuilder)localObject2).append(paramVideoTransPara).append(" videoBitrate: ");
      paramVideoTransPara = nLH;
      if (paramVideoTransPara != null) {
        break label328;
      }
      paramVideoTransPara = null;
      label79:
      Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
      j.d(nLH);
      if ((af.lYf.lWE == -1) || ((af.lYf.lWE & 0x1) == 0)) {
        break label339;
      }
      nFY = 1080;
      Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 1080p");
      label133:
      if (paramBoolean)
      {
        localObject2 = nLH;
        if ((localObject2 != null) && (j.KVJ.lWy == 2))
        {
          paramVideoTransPara = aw.bf(MMApplicationContext.getContext());
          if (!aw.mZ(MMApplicationContext.getContext())) {
            break label1107;
          }
          paramVideoTransPara = aw.iQ(MMApplicationContext.getContext());
        }
      }
    }
    label328:
    label339:
    label1107:
    for (;;)
    {
      if ((paramVideoTransPara != null) && (nLH != null))
      {
        if (!((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yVt, true)) {
          break label632;
        }
        ((VideoTransPara)localObject2).width = ((int)(paramVideoTransPara.x / paramVideoTransPara.y * ((VideoTransPara)localObject2).height));
        ((VideoTransPara)localObject2).width = d.aaX(((VideoTransPara)localObject2).width);
      }
      for (;;)
      {
        Log.i("MicroMsg.SightRecordConfig", "setVideoSize, MediaCodec encode, video size: " + ((VideoTransPara)localObject2).width + 'x' + ((VideoTransPara)localObject2).height + " screenSize:" + paramVideoTransPara);
        if (nLH != null) {
          break label672;
        }
        Log.i("MicroMsg.SightRecordConfig", "init error, videoParams is null");
        NHd = false;
        AppMethodBeat.o(163422);
        return;
        paramVideoTransPara = Integer.valueOf(paramVideoTransPara.oCb);
        break;
        paramVideoTransPara = Integer.valueOf(paramVideoTransPara.videoBitrate);
        break label79;
        if ((af.lYf.lWE != -1) && ((af.lYf.lWE & 0x2) != 0))
        {
          nFY = 720;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use strategyMask 720p");
          break label133;
        }
        if ((j.KVI) || (j.KVJ.Ddk > 1) || (j.gch()))
        {
          nFY = j.KVJ.nFY;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit use recorderOption:" + j.KVJ.Ddk + " resolutionLimit:" + nFY);
          break label133;
        }
        nFY = 1080;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit default 1080p");
        if (j.KVJ.lWy != 1) {
          break label133;
        }
        paramVideoTransPara = MMApplicationContext.getContext().getSystemService("activity");
        if (paramVideoTransPara == null)
        {
          paramVideoTransPara = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(163422);
          throw paramVideoTransPara;
        }
        paramInt = ((ActivityManager)paramVideoTransPara).getLargeMemoryClass();
        int j = d.iR(MMApplicationContext.getContext());
        paramVideoTransPara = d.gbR();
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memoryClass:" + paramInt + ", totalMemory:" + j + ", screenSize:" + paramVideoTransPara);
        if ((paramInt >= 512) && (j >= 1725.0F) && (Math.min(paramVideoTransPara.x, paramVideoTransPara.y) >= 1080))
        {
          nFY = 1080;
          Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory fit use 1080p");
          break label133;
        }
        nFY = 540;
        Log.i("MicroMsg.SightRecordConfig", "config set setResolutionLimit ffmpeg memory not fit use 540p");
        break label133;
        label632:
        ((VideoTransPara)localObject2).height = ((int)(paramVideoTransPara.y / paramVideoTransPara.x * ((VideoTransPara)localObject2).width));
        ((VideoTransPara)localObject2).height = d.aaX(((VideoTransPara)localObject2).height);
      }
      paramVideoTransPara = nLH;
      if (paramVideoTransPara != null)
      {
        if ((nFY < 540) || (paramVideoTransPara.width <= 0) || (paramVideoTransPara.height <= 0) || (paramVideoTransPara.videoBitrate <= 0) || (paramVideoTransPara.fps <= 0))
        {
          NHd = false;
          Log.i("MicroMsg.SightRecordConfig", "init error, param error");
        }
      }
      else
      {
        if (Util.getInt(((a)com.tencent.mm.kernel.h.ax(a.class)).aRC().getValue("VideoRecordUseCpuCrop"), 0) != 1) {
          break label1060;
        }
        paramBoolean = true;
        label759:
        paramInt = af.lYg.lWJ;
        Log.i("MicroMsg.SightRecordConfig", "serverConfigUseCpuCrop, serverConfigUseCpuCrop:" + paramBoolean + ", deviceConfigUseCpuCrop:" + paramInt);
        if (!paramBoolean) {
          break label1102;
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
          Log.i("MicroMsg.SightRecordConfig", s.X("final set useCpuCrop:", Boolean.valueOf(paramBoolean)));
          NHc = paramBoolean;
          if ((scene == 1) || (scene == 2))
          {
            paramVideoTransPara = e.NGK;
            paramBoolean = e.AT(false);
            paramVideoTransPara = e.NGK;
            boolean bool = e.AT(true);
            Log.i("MicroMsg.SightRecordConfig", "checkEnableHevc, hardwareEnableHevc:" + paramBoolean + ", softEnableHevc:" + bool);
            paramVideoTransPara = nLH;
            if (paramVideoTransPara != null)
            {
              if (!bool) {
                break label1070;
              }
              paramInt = 1;
              paramVideoTransPara.oCn = paramInt;
            }
            paramVideoTransPara = nLH;
            if (paramVideoTransPara != null)
            {
              if ((bool) || (!paramBoolean)) {
                break label1075;
              }
              paramInt = 1;
              paramVideoTransPara.oCm = paramInt;
            }
            paramVideoTransPara = nLH;
            paramInt = i;
            if (paramVideoTransPara != null)
            {
              paramInt = i;
              if (paramVideoTransPara.oCn == 1) {
                paramInt = 1;
              }
            }
            if (paramInt != 0) {
              j.KVJ.lWy = 1;
            }
            localObject2 = new StringBuilder("checkEnableHevc, hwEnableHevc:");
            paramVideoTransPara = nLH;
            if (paramVideoTransPara != null) {
              break label1080;
            }
            paramVideoTransPara = null;
            label1000:
            localObject2 = ((StringBuilder)localObject2).append(paramVideoTransPara).append(", swEnableHevc:");
            paramVideoTransPara = nLH;
            if (paramVideoTransPara != null) {
              break label1091;
            }
          }
        }
        for (paramVideoTransPara = localObject1;; paramVideoTransPara = Integer.valueOf(paramVideoTransPara.oCn))
        {
          Log.i("MicroMsg.SightRecordConfig", paramVideoTransPara);
          AppMethodBeat.o(163422);
          return;
          NHd = true;
          Log.i("MicroMsg.SightRecordConfig", "init config succ");
          break;
          paramBoolean = false;
          break label759;
          paramBoolean = false;
          break label816;
          paramInt = 0;
          break label916;
          paramInt = 0;
          break label940;
          paramVideoTransPara = Integer.valueOf(paramVideoTransPara.oCm);
          break label1000;
        }
      }
    }
  }
  
  public static void gHA()
  {
    AppMethodBeat.i(75383);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, 0L, 1L, false);
    int i = 36;
    if (NHd)
    {
      if (gHx() == 1) {
        i = 39;
      }
      if (nFY != 720) {
        break label70;
      }
      i += 1;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(440L, i, 1L, false);
      AppMethodBeat.o(75383);
      return;
      label70:
      i += 2;
    }
  }
  
  public static String gHv()
  {
    AppMethodBeat.i(279729);
    String str = "cpuCrop:" + gHz() + ", recorderType:" + gHx() + ", resolutionLimit:" + nFY + ", videoParams:" + nLH;
    AppMethodBeat.o(279729);
    return str;
  }
  
  public static VideoTransPara gHw()
  {
    return nLH;
  }
  
  public static int gHx()
  {
    AppMethodBeat.i(279743);
    Object localObject = i.agtt;
    localObject = i.a(b.a.agrK, Integer.valueOf(0));
    if (!s.p(localObject, Integer.valueOf(0)))
    {
      if (s.p(localObject, Integer.valueOf(1)))
      {
        AppMethodBeat.o(279743);
        return 1;
      }
      AppMethodBeat.o(279743);
      return 2;
    }
    if ((j.KVJ == null) || (!NHd))
    {
      AppMethodBeat.o(279743);
      return 2;
    }
    int i = j.KVJ.lWy;
    AppMethodBeat.o(279743);
    return i;
  }
  
  public static int gHy()
  {
    return nFY;
  }
  
  public static boolean gHz()
  {
    Object localObject2 = null;
    AppMethodBeat.i(75381);
    if ((j.KVJ == null) || (!NHd))
    {
      AppMethodBeat.o(75381);
      return false;
    }
    boolean bool;
    Object localObject1;
    if (j.KVJ.lWy == 1)
    {
      bool = true;
      StringBuilder localStringBuilder = new StringBuilder("cpuCrop: recorderTypeCpuCrop:").append(bool).append(", serverConfigUseCpuCrop:").append(NHc).append(", swEnableHevc:");
      localObject1 = nLH;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = null;
      label84:
      localStringBuilder = localStringBuilder.append(localObject1).append(", hwEnableHevc:");
      localObject1 = nLH;
      if (localObject1 != null) {
        break label178;
      }
      localObject1 = localObject2;
      label108:
      Log.i("MicroMsg.SightRecordConfig", localObject1);
      if ((!bool) && (!NHc))
      {
        localObject1 = nLH;
        if ((localObject1 == null) || (((VideoTransPara)localObject1).oCn != 1)) {
          break label189;
        }
      }
    }
    label167:
    label178:
    label189:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label194;
      }
      AppMethodBeat.o(75381);
      return true;
      bool = false;
      break;
      localObject1 = Integer.valueOf(((VideoTransPara)localObject1).oCn);
      break label84;
      localObject1 = Integer.valueOf(((VideoTransPara)localObject1).oCm);
      break label108;
    }
    label194:
    AppMethodBeat.o(75381);
    return false;
  }
  
  public static final boolean isInit()
  {
    return NHd;
  }
  
  public static final void l(Point paramPoint)
  {
    AppMethodBeat.i(75382);
    s.u(paramPoint, "cropPreviewSize");
    int i = paramPoint.x;
    int j = paramPoint.y;
    Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen, cropPreviewWidth:" + i + ", cropPreviewHeight:" + j + ", recorderType:" + j.KVJ.lWy + ", resolutionLimit:" + nFY);
    paramPoint = nLH;
    if (paramPoint != null)
    {
      if (j.KVJ.lWy == 1)
      {
        if (j > paramPoint.width) {
          if (nFY == 1080)
          {
            paramPoint.width = (j / 2);
            Log.i("MicroMsg.SightRecordConfig", s.X("afterCameraOpen ffempg 1080p, videoWidth:", Integer.valueOf(paramPoint.width)));
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
          if (nFY != 720) {
            break;
          }
          paramPoint.width = ((int)(j * 0.75D));
          Log.i("MicroMsg.SightRecordConfig", s.X("afterCameraOpen ffempg 720p, videoWidth:", Integer.valueOf(paramPoint.width)));
          break;
          Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen ffmpeg use crop preview size");
          paramPoint.width = j;
        }
      }
      if (((nFY == 720) || (nFY == 540)) && (j < paramPoint.width))
      {
        Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen mediacodec 720p or 540p:" + nFY + ", adjust video size");
        if (nFY != 540) {
          break label472;
        }
        paramPoint.width = j;
        Log.i("MicroMsg.SightRecordConfig", s.X("afterCameraOpen mediacodec 540p, videoWidth:", Integer.valueOf(paramPoint.width)));
      }
    }
    for (;;)
    {
      paramPoint.height = ((int)(i / j * paramPoint.width));
      paramPoint.width = d.aaX(paramPoint.width);
      paramPoint.height = d.aaX(paramPoint.height);
      Log.i("MicroMsg.SightRecordConfig", "afterCameraOpen final adjust video size:" + paramPoint.width + 'x' + paramPoint.height);
      AppMethodBeat.o(75382);
      return;
      label472:
      if (nFY == 720)
      {
        paramPoint.width = ((int)(j * 0.75D));
        Log.i("MicroMsg.SightRecordConfig", s.X("afterCameraOpen mediacodec 720p, videoWidth:", Integer.valueOf(paramPoint.width)));
      }
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(75380);
    Log.i("MicroMsg.SightRecordConfig", "unInit");
    NHd = false;
    AppMethodBeat.o(75380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.h
 * JD-Core Version:    0.7.0.1
 */