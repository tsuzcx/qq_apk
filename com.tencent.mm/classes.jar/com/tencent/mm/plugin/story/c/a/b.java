package com.tencent.mm.plugin.story.c.a;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCameraUseApi1", "StoryCameraUseApi2", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadCameraApiConfig", "", "loadConfig", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
public final class b
  extends com.tencent.mm.plugin.story.c.b<b.a>
{
  public static final b Baa;
  
  static
  {
    AppMethodBeat.i(118584);
    Baa = new b();
    AppMethodBeat.o(118584);
  }
  
  public final void ats()
  {
    int j = 1;
    AppMethodBeat.i(118583);
    Object localObject1 = (b.a)atq();
    Object localObject2 = g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    boolean bool;
    label99:
    int k;
    if (((e)localObject2).ajA().getInt(am.a.JaR, 2) == 2)
    {
      bool = true;
      ((b.a)localObject1).pXd = bool;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCameraApi2 debug : " + ((b.a)atq()).pXd);
      if (Z("VideoRecordUseCpuCrop", 0) != 1) {
        break label541;
      }
      bool = true;
      i = com.tencent.mm.compatible.deviceinfo.ae.geU.gdC;
      k = ay.aRW(a.b.AZW.name()).getInt("use_cpu_crop", 0);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + k);
      if (bool) {
        ((b.a)atq()).hrS = true;
      }
      if (i != -1)
      {
        localObject1 = (b.a)atq();
        if (i != 1) {
          break label547;
        }
        bool = true;
        label202:
        ((b.a)localObject1).hrS = bool;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((b.a)atq()).hrS);
      if (bv.fpT())
      {
        localObject1 = (b.a)atq();
        localObject2 = g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        if (((e)localObject2).ajA().getInt(am.a.IXC, 2) != 1) {
          break label553;
        }
        bool = true;
        label285:
        ((b.a)localObject1).hrS = bool;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((b.a)atq()).hrS);
      }
      if (com.tencent.mm.compatible.deviceinfo.ae.geU.gdy == -1) {
        break label593;
      }
      localObject1 = (b.a)atq();
      switch (com.tencent.mm.compatible.deviceinfo.ae.geU.gdy)
      {
      default: 
        i = 1080;
        label384:
        ((b.a)localObject1).gKf = i;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((b.a)atq()).gKf + "  value " + com.tencent.mm.compatible.deviceinfo.ae.geU.gdy);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.dpC();
        i = Z("Sight1080pRecordMinApiLevel", 19);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + i + "  screenSize x " + ((Point)localObject1).x + " y " + ((Point)localObject1).y);
        localObject2 = ak.getContext().getSystemService("activity");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(118583);
          throw ((Throwable)localObject1);
          bool = false;
          break;
          label541:
          bool = false;
          break label99;
          label547:
          bool = false;
          break label202;
          label553:
          bool = false;
          break label285;
          if (((b.a)atq()).hrS)
          {
            i = 540;
            break label384;
          }
          i = 720;
          break label384;
          i = 720;
          break label384;
          label593:
          i = 0;
          continue;
        }
        k = ((ActivityManager)localObject2).getLargeMemoryClass();
        double d = com.tencent.mm.plugin.mmsight.d.fT(ak.getContext());
        if (((com.tencent.mm.compatible.deviceinfo.ae.geU.gdx != -1) && ((com.tencent.mm.compatible.deviceinfo.ae.geU.gdx & 0x1) == 0)) || (!com.tencent.mm.compatible.util.d.lA(i)) || (k < 512) || (d < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label718;
        }
        ((b.a)atq()).gKf = 1080;
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        ((b.a)atq()).gKf = 720;
      }
      AppMethodBeat.o(118583);
      return;
      label718:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + (b.a)atq() + ".resolution");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.b
 * JD-Core Version:    0.7.0.1
 */