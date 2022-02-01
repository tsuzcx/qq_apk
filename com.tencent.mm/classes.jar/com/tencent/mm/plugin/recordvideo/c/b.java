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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.j.d
{
  public com.tencent.mm.plugin.xlabeffect.b gtl;
  private boolean hpe;
  private com.tencent.mm.media.j.b.a pZk;
  public com.tencent.mm.media.g.d pZn;
  private com.tencent.mm.media.j.b.a xGL;
  private boolean xGM;
  public m<? super Integer, ? super Integer, z> xGN;
  private String xGO;
  private float xGP;
  private XEffectConfig xyG;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(182865);
    this.xyG = new XEffectConfig();
    AppMethodBeat.o(182865);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(200396);
    p.h(paramXEffectConfig, "config");
    this.xyG = paramXEffectConfig;
    paramXEffectConfig = this.gtl;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.k(this.xyG.xyM, this.xyG.xyN, this.xyG.xyO, this.xyG.xyP, this.xyG.xyQ);
      AppMethodBeat.o(200396);
      return;
    }
    AppMethodBeat.o(200396);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(182860);
    if (this.hpe) {}
    for (com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, 2, this.scaleType);; locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gKJ, this.gKK, this.gLD, this.gLE, 2, this.scaleType))
    {
      this.pZk = locala;
      Object localObject = this.pZk;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).hny = true;
      }
      localObject = this.xGL;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).release();
      }
      this.xGL = ((com.tencent.mm.media.j.b.a)new e(this.gLD, this.gLE, this.gLD, this.gLE, this.hnp, 1));
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gtl = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 0, 15);
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).k(this.xyG.xyM, this.xyG.xyN, this.xyG.xyO, this.xyG.xyP, this.xyG.xyQ);
      }
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).pP(this.xGM);
      }
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).n(this.xGO, this.xGP);
      }
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vB(false);
      }
      localObject = this.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.gLD, this.gLE);
      }
      localObject = this.pZn;
      if (localObject != null) {
        ((com.tencent.mm.media.g.d)localObject).close();
      }
      this.pZn = com.tencent.mm.media.g.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void ams()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.ams();
    Object localObject1 = this.pZk;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hnu;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.gtl;
    if (localObject2 != null) {
      com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, (com.tencent.mm.media.g.d)localObject1);
    }
    localObject2 = this.pZn;
    if (localObject2 != null) {
      com.tencent.mm.media.g.d.a((com.tencent.mm.media.g.d)localObject2, this.gLD, this.gLE, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.g.d locald = this.pZn;
    localObject2 = localObject1;
    if (locald != null)
    {
      com.tencent.mm.plugin.xlabeffect.b localb = this.gtl;
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
      localObject1 = this.xGL;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).nN(((com.tencent.mm.media.g.d)localObject2).hko);
      }
      localObject1 = this.xGL;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.j.b.a)localObject1).ams();
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
  
  public final com.tencent.mm.media.g.d amt()
  {
    return this.pZn;
  }
  
  public final void atV()
  {
    com.tencent.mm.media.j.b.a locala = this.xGL;
    if (locala != null) {
      locala.hnD = true;
    }
  }
  
  public final int atW()
  {
    com.tencent.mm.media.j.b.a locala = this.xGL;
    if (locala != null) {
      return locala.hnF;
    }
    return 0;
  }
  
  public final int atX()
  {
    com.tencent.mm.media.j.b.a locala = this.xGL;
    if (locala != null) {
      return locala.hnG;
    }
    return 0;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.cT(paramInt1, paramInt2);
    Object localObject = this.xGL;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cU(this.gLD, this.gLE);
    }
    localObject = this.xGL;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cT(this.gLD, this.gLE);
    }
    localObject = this.gtl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.gLD, this.gLE);
    }
    localObject = this.xGN;
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
    com.tencent.mm.media.j.b.a locala = this.xGL;
    if (locala != null)
    {
      locala.hnA = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void pP(boolean paramBoolean)
  {
    AppMethodBeat.i(200397);
    this.xGM = paramBoolean;
    com.tencent.mm.plugin.xlabeffect.b localb = this.gtl;
    if (localb != null)
    {
      localb.pP(this.xGM);
      AppMethodBeat.o(200397);
      return;
    }
    AppMethodBeat.o(200397);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.xGL;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    this.xGL = null;
    localObject = this.gtl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.gtl = null;
    localObject = this.pZn;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    this.pZn = null;
    AppMethodBeat.o(182864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */