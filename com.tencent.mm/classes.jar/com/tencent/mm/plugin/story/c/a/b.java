package com.tencent.mm.plugin.story.c.a;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCameraUseApi1", "StoryCameraUseApi2", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadCameraApiConfig", "", "loadConfig", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.story.c.b<b.a>
{
  public static final b SiM;
  
  static
  {
    AppMethodBeat.i(118584);
    SiM = new b();
    AppMethodBeat.o(118584);
  }
  
  public final void boD()
  {
    int j = 1;
    AppMethodBeat.i(118583);
    Object localObject1 = (b.a)boB();
    boolean bool;
    label81:
    int k;
    if (h.baE().ban().getInt(at.a.acZB, 2) == 2)
    {
      bool = true;
      ((b.a)localObject1).ygy = bool;
      Log.i("MicroMsg.StoryCameraElementConfig", s.X("cameraPreviewConfig.useCameraApi2 debug : ", Boolean.valueOf(((b.a)boB()).ygy)));
      if (aC("VideoRecordUseCpuCrop", 0) != 1) {
        break label502;
      }
      bool = true;
      i = af.lYg.lWJ;
      k = MultiProcessMMKV.getMMKV(a.b.SiH.name()).getInt("use_cpu_crop", 0);
      Log.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + k);
      if (bool) {
        ((b.a)boB()).nFT = true;
      }
      if (i != -1)
      {
        localObject1 = (b.a)boB();
        if (i != 1) {
          break label508;
        }
        bool = true;
        label184:
        ((b.a)localObject1).nFT = bool;
      }
      Log.i("MicroMsg.StoryCameraElementConfig", s.X("final set useCpuCrop:", Boolean.valueOf(((b.a)boB()).nFT)));
      if (WeChatEnvironment.hasDebugger())
      {
        localObject1 = (b.a)boB();
        if (h.baE().ban().getInt(at.a.acVX, 2) != 1) {
          break label514;
        }
        bool = true;
        label249:
        ((b.a)localObject1).nFT = bool;
        Log.i("MicroMsg.StoryCameraElementConfig", s.X("cameraPreviewConfig.useCpuCrop debug : ", Boolean.valueOf(((b.a)boB()).nFT)));
      }
      if (af.lYg.lWF == -1) {
        break label554;
      }
      localObject1 = (b.a)boB();
      switch (af.lYg.lWF)
      {
      default: 
        i = 1080;
        label344:
        ((b.a)localObject1).mNl = i;
        Log.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((b.a)boB()).mNl + "  value " + af.lYg.lWF);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.gbR();
        i = aC("Sight1080pRecordMinApiLevel", 19);
        Log.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + i + "  screenSize x " + ((Point)localObject1).x + " y " + ((Point)localObject1).y);
        Object localObject2 = MMApplicationContext.getContext().getSystemService("activity");
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(118583);
          throw ((Throwable)localObject1);
          bool = false;
          break;
          label502:
          bool = false;
          break label81;
          label508:
          bool = false;
          break label184;
          label514:
          bool = false;
          break label249;
          if (((b.a)boB()).nFT)
          {
            i = 540;
            break label344;
          }
          i = 720;
          break label344;
          i = 720;
          break label344;
          label554:
          i = 0;
          continue;
        }
        k = ((ActivityManager)localObject2).getLargeMemoryClass();
        double d = com.tencent.mm.plugin.mmsight.d.iR(MMApplicationContext.getContext());
        if (((af.lYg.lWE != -1) && ((af.lYg.lWE & 0x1) == 0)) || (!com.tencent.mm.compatible.util.d.rb(i)) || (k < 512) || (d < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label679;
        }
        ((b.a)boB()).mNl = 1080;
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        ((b.a)boB()).mNl = 720;
      }
      AppMethodBeat.o(118583);
      return;
      label679:
      Log.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + boB() + ".resolution");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.b
 * JD-Core Version:    0.7.0.1
 */