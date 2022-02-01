package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import java.nio.IntBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "scaleType", "", "(I)V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.j.d
{
  private XEffectConfig HLp;
  private com.tencent.mm.media.j.b.a HUf;
  private boolean HUg;
  public m<? super Integer, ? super Integer, x> HUh;
  private String HUi;
  private float HUj;
  public com.tencent.mm.plugin.xlabeffect.e jUF;
  private boolean laO;
  private com.tencent.mm.media.j.b.a vcs;
  public com.tencent.mm.media.g.d vcv;
  
  public b(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(220812);
    this.HLp = new XEffectConfig();
    AppMethodBeat.o(220812);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(220775);
    p.k(paramXEffectConfig, "config");
    this.HLp = paramXEffectConfig;
    com.tencent.mm.plugin.xlabeffect.e locale = this.jUF;
    if (locale != null) {
      locale.a(this.HLp);
    }
    locale = this.jUF;
    if (locale != null) {
      locale.DF(true);
    }
    locale = this.jUF;
    if (locale != null) {
      com.tencent.mm.plugin.xlabeffect.e.a(locale, true);
    }
    locale = this.jUF;
    if (locale != null) {
      locale.DE(true);
    }
    locale = this.jUF;
    if (locale != null) {
      locale.apl(paramXEffectConfig.yCP);
    }
    paramXEffectConfig = this.jUF;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.DG(true);
      AppMethodBeat.o(220775);
      return;
    }
    AppMethodBeat.o(220775);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(182860);
    if (this.laO) {}
    for (com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, 2, getScaleType());; locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.krg, this.krh, this.ksu, this.ksv, 2, getScaleType()))
    {
      this.vcs = locala;
      Object localObject = this.vcs;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).kYB = true;
      }
      localObject = this.HUf;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).release();
      }
      this.HUf = ((com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.e(this.ksu, this.ksv, this.ksu, this.ksv, aVh(), 1));
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).destroy();
      }
      this.jUF = new com.tencent.mm.plugin.xlabeffect.e();
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).o(this.HLp.QPt, this.HLp.QPu, this.HLp.QPv, this.HLp.QPw, this.HLp.QPx);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DF(true);
      }
      localObject = this.jUF;
      if (localObject != null) {
        com.tencent.mm.plugin.xlabeffect.e.a((com.tencent.mm.plugin.xlabeffect.e)localObject, true);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DE(true);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).apl(this.HLp.yCP);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DG(true);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).m(this.HUi, this.HUj);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DH(false);
      }
      localObject = this.jUF;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).setSize(this.ksu, this.ksv);
      }
      localObject = this.vcv;
      if (localObject != null) {
        ((com.tencent.mm.media.g.d)localObject).close();
      }
      this.vcv = com.tencent.mm.media.g.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void aMU()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.aMU();
    Object localObject1 = this.vcs;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).kYx;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.jUF;
    if (localObject2 != null) {
      com.tencent.mm.plugin.xlabeffect.e.a((com.tencent.mm.plugin.xlabeffect.e)localObject2, (com.tencent.mm.media.g.d)localObject1);
    }
    localObject2 = this.vcv;
    if (localObject2 != null) {
      com.tencent.mm.media.g.d.a((com.tencent.mm.media.g.d)localObject2, this.ksu, this.ksv, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.g.d locald = this.vcv;
    localObject2 = localObject1;
    if (locald != null)
    {
      com.tencent.mm.plugin.xlabeffect.e locale = this.jUF;
      localObject2 = localObject3;
      if (locale != null) {
        localObject2 = Integer.valueOf(com.tencent.mm.plugin.xlabeffect.e.a(locale, (com.tencent.mm.media.g.d)localObject1, locald, false, 60));
      }
      if (localObject2 == null) {
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = this.HUf;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).ua(((com.tencent.mm.media.g.d)localObject2).kVj);
      }
      localObject1 = this.HUf;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.j.b.a)localObject1).aMU();
      AppMethodBeat.o(182863);
      return;
    }
    if (((Integer)localObject2).intValue() == 0) {
      localObject1 = locald;
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      label174:
      AppMethodBeat.o(182863);
      return;
    }
  }
  
  public final com.tencent.mm.media.g.d aMV()
  {
    return this.vcv;
  }
  
  public final void aVe()
  {
    com.tencent.mm.media.j.b.a locala = this.HUf;
    if (locala != null) {
      locala.kYH = true;
    }
  }
  
  public final int aVf()
  {
    com.tencent.mm.media.j.b.a locala = this.HUf;
    if (locala != null) {
      return locala.kYJ;
    }
    return 0;
  }
  
  public final int aVg()
  {
    com.tencent.mm.media.j.b.a locala = this.HUf;
    if (locala != null) {
      return locala.kYK;
    }
    return 0;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.du(paramInt1, paramInt2);
    Object localObject = this.HUf;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).dv(this.ksu, this.ksv);
    }
    localObject = this.HUf;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).du(this.ksu, this.ksv);
    }
    localObject = this.jUF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.e)localObject).setSize(this.ksu, this.ksv);
    }
    localObject = this.HUh;
    if (localObject != null)
    {
      ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(182862);
      return;
    }
    AppMethodBeat.o(182862);
  }
  
  public final void m(kotlin.g.a.b<? super IntBuffer, x> paramb)
  {
    AppMethodBeat.i(182861);
    p.k(paramb, "listener");
    com.tencent.mm.media.j.b.a locala = this.HUf;
    if (locala != null)
    {
      locala.kYD = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.HUf;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    this.HUf = null;
    localObject = this.jUF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.e)localObject).destroy();
    }
    this.jUF = null;
    localObject = this.vcv;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    this.vcv = null;
    AppMethodBeat.o(182864);
  }
  
  public final void wE(boolean paramBoolean)
  {
    AppMethodBeat.i(220779);
    this.HUg = paramBoolean;
    com.tencent.mm.plugin.xlabeffect.e locale = this.jUF;
    if (locale != null)
    {
      locale.wE(this.HUg);
      AppMethodBeat.o(220779);
      return;
    }
    AppMethodBeat.o(220779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */