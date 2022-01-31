package com.tencent.mm.plugin.story.c.a;

import a.f.b.j;
import a.l;
import a.v;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.c.b.b;
import com.tencent.mm.plugin.story.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "()V", "CPU_CROP_AVAILABLE", "", "CPU_CROP_MMKV_KEY", "", "CPU_CROP_NOT_AVAILABLE", "RECORDER_CAPTURE_RESOLUTION_1080P", "RECORDER_CAPTURE_RESOLUTION_540P", "RECORDER_CAPTURE_RESOLUTION_720P", "RESOLUTION", "StoryCropSizeWithCPU", "StoryCropSizeWithGPU", "TAG", "USECPUCROP", "USE_HIGHEST_RESOLUTION_MEMORYCLASS_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB", "USE_HIGHEST_RESOLUTION_MEMORY_LIMIT_MB_BUFFER", "", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadCropTypeConfig", "loadDeviceResolutionConfig", "", "loadResolutionConfig", "markCpuCropNotAvailable", "setServerUseCpuCrop", "tryUse1080Preview", "use720Preview", "CameraPreviewConfig", "plugin-story_release"})
public final class b
  extends c<a>
{
  public static final b srP;
  
  static
  {
    AppMethodBeat.i(108956);
    srP = new b();
    AppMethodBeat.o(108956);
  }
  
  public final void Uv()
  {
    int j = 1;
    AppMethodBeat.i(108955);
    boolean bool;
    int k;
    Object localObject1;
    label125:
    Object localObject2;
    if (L("VideoRecordUseCpuCrop", 0) == 1)
    {
      bool = true;
      i = ac.erC.eqV;
      k = as.apq(b.b.srp.name()).getInt("use_cpu_crop", 0);
      ab.i("MicroMsg.StoryCameraElementConfig", "setServerUseCpuCrop, serverConfigUseCpuCrop:" + bool + ", deviceConfigUseCpuCrop:" + i + ", localCpuCropConfig:" + k);
      if (bool) {
        ((a)Ut()).eZM = true;
      }
      if (i != -1)
      {
        localObject1 = (a)Ut();
        if (i != 1) {
          break label465;
        }
        bool = true;
        ((a)localObject1).eZM = bool;
      }
      ab.i("MicroMsg.StoryCameraElementConfig", "final set useCpuCrop:" + ((a)Ut()).eZM);
      if (bp.dud())
      {
        localObject1 = (a)Ut();
        localObject2 = g.RL();
        j.p(localObject2, "MMKernel.storage()");
        if (((e)localObject2).Ru().getInt(ac.a.yJE, 2) != 1) {
          break label471;
        }
        bool = true;
        label208:
        ((a)localObject1).eZM = bool;
        ab.i("MicroMsg.StoryCameraElementConfig", "cameraPreviewConfig.useCpuCrop debug : " + ((a)Ut()).eZM);
      }
      if (ac.erC.eqR == -1) {
        break label511;
      }
      localObject1 = (a)Ut();
      switch (ac.erC.eqR)
      {
      default: 
        i = 1080;
        label308:
        ((a)localObject1).ltb = i;
        ab.i("MicroMsg.StoryCameraElementConfig", "loadDeviceResolutionConfig " + ((a)Ut()).ltb + "  value " + ac.erC.eqR);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = com.tencent.mm.plugin.mmsight.d.bQE();
        i = L("Sight1080pRecordMinApiLevel", 19);
        ab.i("MicroMsg.StoryCameraElementConfig", "record1080pApiLevel: " + i + "  screenSize x " + ((Point)localObject1).x + " y " + ((Point)localObject1).y);
        localObject2 = ah.getContext().getSystemService("activity");
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.app.ActivityManager");
          AppMethodBeat.o(108955);
          throw ((Throwable)localObject1);
          bool = false;
          break;
          label465:
          bool = false;
          break label125;
          label471:
          bool = false;
          break label208;
          if (((a)Ut()).eZM)
          {
            i = 540;
            break label308;
          }
          i = 720;
          break label308;
          i = 720;
          break label308;
          label511:
          i = 0;
          continue;
        }
        k = ((ActivityManager)localObject2).getLargeMemoryClass();
        double d = com.tencent.mm.plugin.mmsight.d.ey(ah.getContext());
        if (((ac.erC.eqQ != -1) && ((ac.erC.eqQ & 0x1) == 0)) || (!com.tencent.mm.compatible.util.d.fv(i)) || (k < 512) || (d < 1725.0D) || (Math.min(((Point)localObject1).x, ((Point)localObject1).y) < 1080)) {
          break label636;
        }
        ((a)Ut()).ltb = 1080;
      }
    }
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        ((a)Ut()).ltb = 720;
      }
      AppMethodBeat.o(108955);
      return;
      label636:
      ab.i("MicroMsg.StoryCameraElementConfig", "currentRecorderCaptureResolution is :" + (a)Ut() + ".resolution");
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryCameraElementConfig$CameraPreviewConfig;", "", "resolution", "", "useCpuCrop", "", "(IZ)V", "getResolution", "()I", "setResolution", "(I)V", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-story_release"})
  public static final class a
  {
    public boolean eZM = false;
    public int ltb = 720;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this != paramObject)
      {
        bool1 = bool2;
        if (!(paramObject instanceof a)) {
          break label65;
        }
        paramObject = (a)paramObject;
        if (this.ltb != paramObject.ltb) {
          break label67;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label65;
        }
        if (this.eZM != paramObject.eZM) {
          break label72;
        }
      }
      label65:
      label67:
      label72:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
        return bool1;
        i = 0;
        break;
      }
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(108953);
      String str = "CameraPreviewConfig(resolution=" + this.ltb + ", useCpuCrop=" + this.eZM + ")";
      AppMethodBeat.o(108953);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.b
 * JD-Core Version:    0.7.0.1
 */