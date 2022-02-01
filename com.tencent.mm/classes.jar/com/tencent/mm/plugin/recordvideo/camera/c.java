package com.tencent.mm.plugin.recordvideo.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController;", "", "cancelRecord", "", "release", "", "startPreview", "preview", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "config", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRecord", "configList", "", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$RecordConfig;", "stopPreView", "clearScreen", "stopRecord", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$RecordResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchCamera", "takePictureAndSave", "takePictureBitmap", "Landroid/graphics/Bitmap;", "IndependentCameraConfig", "PreviewConfig", "RecordConfig", "RecordResult", "plugin-recordvideo_release"})
public abstract interface c
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;", "", "select", "", "(I)V", "getSelect", "()I", "setSelect", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "plugin-recordvideo_release"})
  public static final class a
  {
    public static final a HJj;
    int HJi = 1;
    
    static
    {
      AppMethodBeat.i(218973);
      HJj = new a((byte)0);
      AppMethodBeat.o(218973);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.HJi != paramObject.HJi) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.HJi;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(218977);
      String str = "IndependentCameraConfig(select=" + this.HJi + ")";
      AppMethodBeat.o(218977);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig$Companion;", "", "()V", "defaultConfig", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;", "plugin-recordvideo_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;", "", "limitResolution", "", "ratio", "", "backCamera", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(ILjava/lang/Float;ZLcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getBackCamera", "()Z", "setBackCamera", "(Z)V", "getLimitResolution", "()I", "setLimitResolution", "(I)V", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/Float;ZLcom/tencent/mm/media/render/AbsSurfaceRenderer;)Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;", "equals", "other", "hashCode", "toString", "", "Companion", "plugin-recordvideo_release"})
  public static final class b
  {
    public static final a HJl;
    boolean Fie;
    int HJk;
    a kWg;
    Float laV;
    
    static
    {
      AppMethodBeat.i(218670);
      HJl = new a((byte)0);
      AppMethodBeat.o(218670);
    }
    
    private b(Float paramFloat, a parama)
    {
      AppMethodBeat.i(218666);
      this.HJk = 2000;
      this.laV = paramFloat;
      this.Fie = true;
      this.kWg = parama;
      AppMethodBeat.o(218666);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218682);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.HJk != paramObject.HJk) || (!p.h(this.laV, paramObject.laV)) || (this.Fie != paramObject.Fie) || (!p.h(this.kWg, paramObject.kWg))) {}
        }
      }
      else
      {
        AppMethodBeat.o(218682);
        return true;
      }
      AppMethodBeat.o(218682);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(218674);
      String str = "PreviewConfig(limitResolution=" + this.HJk + ", ratio=" + this.laV + ", backCamera=" + this.Fie + ", renderer=" + this.kWg + ")";
      AppMethodBeat.o(218674);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig$Companion;", "", "()V", "centerInsideConfig", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;", "ratio", "", "fullScreenConfig", "plugin-recordvideo_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.camera.c
 * JD-Core Version:    0.7.0.1
 */