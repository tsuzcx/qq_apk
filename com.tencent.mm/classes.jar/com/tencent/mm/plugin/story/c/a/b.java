package com.tencent.mm.plugin.story.c.a;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.x;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.c.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCameraUseApi1", "StoryCameraUseApi2", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadCameraApiConfig", "", "loadConfig", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
public final class b
  extends com.tencent.mm.plugin.story.c.b<a>
{
  public static final b ydD;
  
  static
  {
    AppMethodBeat.i(118584);
    ydD = new b();
    AppMethodBeat.o(118584);
  }
  
  public final void ajo()
  {
    int j = 1;
    AppMethodBeat.i(118583);
    Object localObject1 = (a)ajm();
    Object localObject2 = g.afB();
    k.g(localObject2, "MMKernel.storage()");
    boolean bool;
    label99:
    int k;
    if (((e)localObject2).afk().getInt(ae.a.FvR, 2) == 2)
    {
      bool = true;
      ((a)localObject1).oJA = bool;
      ad.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCameraApi2 debug : " + ((a)ajm()).oJA);
      if (P("VideoRecordUseCpuCrop", 0) != 1) {
        break label541;
      }
      bool = true;
      i = ae.fFE.fEn;
      k = ax.aFC(a.b.ydz.name()).getInt("use_cpu_crop", 0);
      ad.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + k);
      if (bool) {
        ((a)ajm()).gwB = true;
      }
      if (i != -1)
      {
        localObject1 = (a)ajm();
        if (i != 1) {
          break label547;
        }
        bool = true;
        label202:
        ((a)localObject1).gwB = bool;
      }
      ad.i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((a)ajm()).gwB);
      if (bu.eGT())
      {
        localObject1 = (a)ajm();
        localObject2 = g.afB();
        k.g(localObject2, "MMKernel.storage()");
        if (((e)localObject2).afk().getInt(ae.a.FsN, 2) != 1) {
          break label553;
        }
        bool = true;
        label285:
        ((a)localObject1).gwB = bool;
        ad.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((a)ajm()).gwB);
      }
      if (ae.fFE.fEj == -1) {
        break label593;
      }
      localObject1 = (a)ajm();
      switch (ae.fFE.fEj)
      {
      default: 
        i = 1080;
        label384:
        ((a)localObject1).oJx = i;
        ad.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((a)ajm()).oJx + "  value " + ae.fFE.fEj);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.cPz();
        i = P("Sight1080pRecordMinApiLevel", 19);
        ad.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + i + "  screenSize x " + ((Point)localObject1).x + " y " + ((Point)localObject1).y);
        localObject2 = aj.getContext().getSystemService("activity");
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
          if (((a)ajm()).gwB)
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
        double d = com.tencent.mm.plugin.mmsight.d.fw(aj.getContext());
        if (((ae.fFE.fEi != -1) && ((ae.fFE.fEi & 0x1) == 0)) || (!com.tencent.mm.compatible.util.d.lf(i)) || (k < 512) || (d < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label718;
        }
        ((a)ajm()).oJx = 1080;
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        ((a)ajm()).oJx = 720;
      }
      AppMethodBeat.o(118583);
      return;
      label718:
      ad.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + (a)ajm() + ".resolution");
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "useCameraApi2", "(IZZ)V", "getResolution", "()I", "setResolution", "(I)V", "getUseCameraApi2", "()Z", "setUseCameraApi2", "(Z)V", "getUseCpuCrop", "setUseCpuCrop", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
  public static final class a
  {
    boolean gwB = false;
    boolean oJA = false;
    int oJx = 720;
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.oJx != paramObject.oJx) || (this.gwB != paramObject.gwB) || (this.oJA != paramObject.oJA)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(118581);
      String str = "CameraPreviewConfig(resolution=" + this.oJx + ", useCpuCrop=" + this.gwB + ", useCameraApi2=" + this.oJA + ")";
      AppMethodBeat.o(118581);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.b
 * JD-Core Version:    0.7.0.1
 */