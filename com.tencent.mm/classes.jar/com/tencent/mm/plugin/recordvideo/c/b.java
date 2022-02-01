package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.IntBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.j.d
{
  public com.tencent.mm.plugin.xlabeffect.b gvS;
  private boolean hrS;
  private com.tencent.mm.media.j.b.a qfP;
  public com.tencent.mm.media.g.d qfS;
  private XEffectConfig xOC;
  private com.tencent.mm.media.j.b.a xWG;
  private boolean xWH;
  public m<? super Integer, ? super Integer, z> xWI;
  private String xWJ;
  private float xWK;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(182865);
    this.xOC = new XEffectConfig();
    AppMethodBeat.o(182865);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(206657);
    p.h(paramXEffectConfig, "config");
    this.xOC = paramXEffectConfig;
    paramXEffectConfig = this.gvS;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.k(this.xOC.xOI, this.xOC.xOJ, this.xOC.xOK, this.xOC.xOL, this.xOC.xOM);
      AppMethodBeat.o(206657);
      return;
    }
    AppMethodBeat.o(206657);
  }
  
  public final com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(182860);
    if (this.hrS) {}
    for (com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, 2, this.scaleType);; locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gNs, this.gNt, this.gOm, this.gOn, 2, this.scaleType))
    {
      this.qfP = locala;
      Object localObject = this.qfP;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).hqm = true;
      }
      localObject = this.xWG;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).release();
      }
      this.xWG = ((com.tencent.mm.media.j.b.a)new e(this.gOm, this.gOn, this.gOm, this.gOn, this.hqd, 1));
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gvS = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).k(this.xOC.xOI, this.xOC.xOJ, this.xOC.xOK, this.xOC.xOL, this.xOC.xOM);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).pX(this.xWH);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).o(this.xWJ, this.xWK);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vJ(false);
      }
      localObject = this.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.gOm, this.gOn);
      }
      localObject = this.qfS;
      if (localObject != null) {
        ((com.tencent.mm.media.g.d)localObject).close();
      }
      this.qfS = com.tencent.mm.media.g.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void amH()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.amH();
    Object localObject1 = this.qfP;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hqi;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.gvS;
    if (localObject2 != null) {
      com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, (com.tencent.mm.media.g.d)localObject1);
    }
    localObject2 = this.qfS;
    if (localObject2 != null) {
      com.tencent.mm.media.g.d.a((com.tencent.mm.media.g.d)localObject2, this.gOm, this.gOn, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.g.d locald = this.qfS;
    localObject2 = localObject1;
    if (locald != null)
    {
      com.tencent.mm.plugin.xlabeffect.b localb = this.gvS;
      localObject2 = localObject3;
      if (localb != null) {
        localObject2 = Integer.valueOf(com.tencent.mm.plugin.xlabeffect.b.a(localb, (com.tencent.mm.media.g.d)localObject1, locald, false, 60));
      }
      if (localObject2 == null) {
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject1 = this.xWG;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).nQ(((com.tencent.mm.media.g.d)localObject2).hnc);
      }
      localObject1 = this.xWG;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.j.b.a)localObject1).amH();
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
  
  public final com.tencent.mm.media.g.d amI()
  {
    return this.qfS;
  }
  
  public final void auk()
  {
    com.tencent.mm.media.j.b.a locala = this.xWG;
    if (locala != null) {
      locala.hqr = true;
    }
  }
  
  public final int aul()
  {
    com.tencent.mm.media.j.b.a locala = this.xWG;
    if (locala != null) {
      return locala.hqt;
    }
    return 0;
  }
  
  public final int aum()
  {
    com.tencent.mm.media.j.b.a locala = this.xWG;
    if (locala != null) {
      return locala.hqu;
    }
    return 0;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.cT(paramInt1, paramInt2);
    Object localObject = this.xWG;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cU(this.gOm, this.gOn);
    }
    localObject = this.xWG;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cT(this.gOm, this.gOn);
    }
    localObject = this.gvS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.gOm, this.gOn);
    }
    localObject = this.xWI;
    if (localObject != null)
    {
      ((m)localObject).p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(182862);
      return;
    }
    AppMethodBeat.o(182862);
  }
  
  public final void m(d.g.a.b<? super IntBuffer, z> paramb)
  {
    AppMethodBeat.i(182861);
    p.h(paramb, "listener");
    com.tencent.mm.media.j.b.a locala = this.xWG;
    if (locala != null)
    {
      locala.hqo = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void pX(boolean paramBoolean)
  {
    AppMethodBeat.i(206658);
    this.xWH = paramBoolean;
    com.tencent.mm.plugin.xlabeffect.b localb = this.gvS;
    if (localb != null)
    {
      localb.pX(this.xWH);
      AppMethodBeat.o(206658);
      return;
    }
    AppMethodBeat.o(206658);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.xWG;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    this.xWG = null;
    localObject = this.gvS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.gvS = null;
    localObject = this.qfS;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    this.qfS = null;
    AppMethodBeat.o(182864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */