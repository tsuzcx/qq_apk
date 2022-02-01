package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.IntBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.i.d
{
  private String LoM;
  private float LoN;
  public XLabEffect fVU;
  private boolean gwB;
  private com.tencent.mm.media.i.b.a oSu;
  public com.tencent.mm.media.f.d oSx;
  private XEffectConfig vif;
  private com.tencent.mm.media.i.b.a vpe;
  private boolean vpf;
  public m<? super Integer, ? super Integer, y> vpg;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(182865);
    this.vif = new XEffectConfig();
    AppMethodBeat.o(182865);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(204235);
    k.h(paramXEffectConfig, "config");
    this.vif = paramXEffectConfig;
    paramXEffectConfig = this.fVU;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.j(this.vif.vil, this.vif.vim, this.vif.vin, this.vif.vio, this.vif.vip);
      AppMethodBeat.o(204235);
      return;
    }
    AppMethodBeat.o(204235);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(182860);
    if (this.gwB) {}
    for (com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new e(this.guI, this.guJ, this.guK, this.guL, 2, this.scaleType);; locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.guI, this.guJ, this.guK, this.guL, 2, this.scaleType))
    {
      this.oSu = locala;
      Object localObject = this.oSu;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).guY = true;
      }
      localObject = this.vpe;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).release();
      }
      this.vpe = ((com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.d(this.guK, this.guL, this.guK, this.guL, this.guM, 1));
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).destroy();
      }
      this.fVU = new XLabEffect(0, 0, 0, false, 15);
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).j(this.vif.vil, this.vif.vim, this.vif.vin, this.vif.vio, this.vif.vip);
      }
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).tN(this.vpf);
      }
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).m(this.LoM, this.LoN);
      }
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).tP(false);
      }
      localObject = this.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).setSize(this.guK, this.guL);
      }
      localObject = this.oSx;
      if (localObject != null) {
        ((com.tencent.mm.media.f.d)localObject).close();
      }
      this.oSx = com.tencent.mm.media.f.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void akk()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.akk();
    Object localObject1 = this.oSu;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).guU;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.fVU;
    if (localObject2 != null) {
      XLabEffect.a((XLabEffect)localObject2, (com.tencent.mm.media.f.d)localObject1);
    }
    localObject2 = this.oSx;
    if (localObject2 != null) {
      com.tencent.mm.media.f.d.a((com.tencent.mm.media.f.d)localObject2, this.guK, this.guL, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.f.d locald = this.oSx;
    localObject2 = localObject1;
    if (locald != null)
    {
      XLabEffect localXLabEffect = this.fVU;
      localObject2 = localObject3;
      if (localXLabEffect != null) {
        localObject2 = Integer.valueOf(XLabEffect.a(localXLabEffect, (com.tencent.mm.media.f.d)localObject1, locald, false, 60));
      }
      if (localObject2 == null) {
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = this.vpe;
      if (localObject1 != null) {
        ((com.tencent.mm.media.i.b.a)localObject1).mA(((com.tencent.mm.media.f.d)localObject2).gro);
      }
      localObject1 = this.vpe;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.i.b.a)localObject1).akk();
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
  
  public final void akm()
  {
    com.tencent.mm.media.i.b.a locala = this.vpe;
    if (locala != null) {
      locala.gvc = true;
    }
  }
  
  public final int akn()
  {
    com.tencent.mm.media.i.b.a locala = this.vpe;
    if (locala != null) {
      return locala.gve;
    }
    return 0;
  }
  
  public final int ako()
  {
    com.tencent.mm.media.i.b.a locala = this.vpe;
    if (locala != null) {
      return locala.gvf;
    }
    return 0;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.cT(paramInt1, paramInt2);
    Object localObject = this.vpe;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cS(this.guK, this.guL);
    }
    localObject = this.vpe;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cT(this.guK, this.guL);
    }
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).setSize(this.guK, this.guL);
    }
    localObject = this.vpg;
    if (localObject != null)
    {
      ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(182862);
      return;
    }
    AppMethodBeat.o(182862);
  }
  
  public final com.tencent.mm.media.f.d czI()
  {
    return this.oSx;
  }
  
  public final void g(d.g.a.b<? super IntBuffer, y> paramb)
  {
    AppMethodBeat.i(182861);
    k.h(paramb, "listener");
    com.tencent.mm.media.i.b.a locala = this.vpe;
    if (locala != null)
    {
      locala.gva = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.vpe;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).release();
    }
    this.vpe = null;
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fVU = null;
    localObject = this.oSx;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    this.oSx = null;
    AppMethodBeat.o(182864);
  }
  
  public final void tN(boolean paramBoolean)
  {
    AppMethodBeat.i(204236);
    this.vpf = paramBoolean;
    XLabEffect localXLabEffect = this.fVU;
    if (localXLabEffect != null)
    {
      localXLabEffect.tN(this.vpf);
      AppMethodBeat.o(204236);
      return;
    }
    AppMethodBeat.o(204236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */