package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.media.i.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.IntBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.i.d
{
  public XLabEffect fZP;
  private boolean gWY;
  private com.tencent.mm.media.i.b.a pvF;
  public com.tencent.mm.media.f.d pvI;
  private XEffectConfig wqP;
  private com.tencent.mm.media.i.b.a wxR;
  private boolean wxS;
  public m<? super Integer, ? super Integer, y> wxT;
  private String wxU;
  private float wxV;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(182865);
    this.wqP = new XEffectConfig();
    AppMethodBeat.o(182865);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(199354);
    k.h(paramXEffectConfig, "config");
    this.wqP = paramXEffectConfig;
    paramXEffectConfig = this.fZP;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.j(this.wqP.wqV, this.wqP.wqW, this.wqP.wqX, this.wqP.wqY, this.wqP.wqZ);
      AppMethodBeat.o(199354);
      return;
    }
    AppMethodBeat.o(199354);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(182860);
    if (this.gWY) {}
    for (com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, 2, this.scaleType);; locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.gqZ, this.gra, this.grV, this.grW, 2, this.scaleType))
    {
      this.pvF = locala;
      Object localObject = this.pvF;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).gVv = true;
      }
      localObject = this.wxR;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).release();
      }
      this.wxR = ((com.tencent.mm.media.i.b.a)new e(this.grV, this.grW, this.grV, this.grW, this.gVm, 1));
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).destroy();
      }
      this.fZP = new XLabEffect(0, 0, 0, false, 15);
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).j(this.wqP.wqV, this.wqP.wqW, this.wqP.wqX, this.wqP.wqY, this.wqP.wqZ);
      }
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).pt(this.wxS);
      }
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).m(this.wxU, this.wxV);
      }
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).uQ(false);
      }
      localObject = this.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).setSize(this.grV, this.grW);
      }
      localObject = this.pvI;
      if (localObject != null) {
        ((com.tencent.mm.media.f.d)localObject).close();
      }
      this.pvI = com.tencent.mm.media.f.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void ajG()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.ajG();
    Object localObject1 = this.pvF;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).gVr;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.fZP;
    if (localObject2 != null) {
      XLabEffect.a((XLabEffect)localObject2, (com.tencent.mm.media.f.d)localObject1);
    }
    localObject2 = this.pvI;
    if (localObject2 != null) {
      com.tencent.mm.media.f.d.a((com.tencent.mm.media.f.d)localObject2, this.grV, this.grW, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.f.d locald = this.pvI;
    localObject2 = localObject1;
    if (locald != null)
    {
      XLabEffect localXLabEffect = this.fZP;
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
      localObject1 = this.wxR;
      if (localObject1 != null) {
        ((com.tencent.mm.media.i.b.a)localObject1).no(((com.tencent.mm.media.f.d)localObject2).gRW);
      }
      localObject1 = this.wxR;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.i.b.a)localObject1).ajG();
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
  
  public final com.tencent.mm.media.f.d ajH()
  {
    return this.pvI;
  }
  
  public final void ari()
  {
    com.tencent.mm.media.i.b.a locala = this.wxR;
    if (locala != null) {
      locala.gVz = true;
    }
  }
  
  public final int arj()
  {
    com.tencent.mm.media.i.b.a locala = this.wxR;
    if (locala != null) {
      return locala.gVB;
    }
    return 0;
  }
  
  public final int ark()
  {
    com.tencent.mm.media.i.b.a locala = this.wxR;
    if (locala != null) {
      return locala.gVC;
    }
    return 0;
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.cR(paramInt1, paramInt2);
    Object localObject = this.wxR;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cS(this.grV, this.grW);
    }
    localObject = this.wxR;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).cR(this.grV, this.grW);
    }
    localObject = this.fZP;
    if (localObject != null) {
      ((XLabEffect)localObject).setSize(this.grV, this.grW);
    }
    localObject = this.wxT;
    if (localObject != null)
    {
      ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(182862);
      return;
    }
    AppMethodBeat.o(182862);
  }
  
  public final void l(d.g.a.b<? super IntBuffer, y> paramb)
  {
    AppMethodBeat.i(182861);
    k.h(paramb, "listener");
    com.tencent.mm.media.i.b.a locala = this.wxR;
    if (locala != null)
    {
      locala.gVx = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void pt(boolean paramBoolean)
  {
    AppMethodBeat.i(199355);
    this.wxS = paramBoolean;
    XLabEffect localXLabEffect = this.fZP;
    if (localXLabEffect != null)
    {
      localXLabEffect.pt(this.wxS);
      AppMethodBeat.o(199355);
      return;
    }
    AppMethodBeat.o(199355);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.wxR;
    if (localObject != null) {
      ((com.tencent.mm.media.i.b.a)localObject).release();
    }
    this.wxR = null;
    localObject = this.fZP;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fZP = null;
    localObject = this.pvI;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    this.pvI = null;
    AppMethodBeat.o(182864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */