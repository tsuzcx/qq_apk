package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import java.nio.IntBuffer;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.j.d
{
  private XEffectConfig BOJ;
  private com.tencent.mm.media.j.b.a BXr;
  private boolean BXs;
  public m<? super Integer, ? super Integer, x> BXt;
  private String BXu;
  private float BXv;
  public com.tencent.mm.plugin.xlabeffect.b hiH;
  private boolean ilO;
  private com.tencent.mm.media.j.b.a rwM;
  public com.tencent.mm.media.g.d rwP;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(182865);
    this.BOJ = new XEffectConfig();
    AppMethodBeat.o(182865);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(237432);
    p.h(paramXEffectConfig, "config");
    this.BOJ = paramXEffectConfig;
    paramXEffectConfig = this.hiH;
    if (paramXEffectConfig != null)
    {
      paramXEffectConfig.l(this.BOJ.hDb, this.BOJ.hDc, this.BOJ.hDd, this.BOJ.hDe, this.BOJ.hDf);
      AppMethodBeat.o(237432);
      return;
    }
    AppMethodBeat.o(237432);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(182860);
    if (this.ilO) {}
    for (com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, 2, this.scaleType);; locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, 2, this.scaleType))
    {
      this.rwM = locala;
      Object localObject = this.rwM;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).ijH = true;
      }
      localObject = this.BXr;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).release();
      }
      this.BXr = ((com.tencent.mm.media.j.b.a)new e(this.hEp, this.hEq, this.hEp, this.hEq, this.ijy, 1));
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.hiH = new com.tencent.mm.plugin.xlabeffect.b((byte)0);
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).l(this.BOJ.hDb, this.BOJ.hDc, this.BOJ.hDd, this.BOJ.hDe, this.BOJ.hDf);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).ti(this.BXs);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).m(this.BXu, this.BXv);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).zG(false);
      }
      localObject = this.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.hEp, this.hEq);
      }
      localObject = this.rwP;
      if (localObject != null) {
        ((com.tencent.mm.media.g.d)localObject).close();
      }
      this.rwP = com.tencent.mm.media.g.c.a(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public final void aED()
  {
    Object localObject3 = null;
    AppMethodBeat.i(182863);
    super.aED();
    Object localObject1 = this.rwM;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).ijD;
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.hiH;
    if (localObject2 != null) {
      com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)localObject2, (com.tencent.mm.media.g.d)localObject1);
    }
    localObject2 = this.rwP;
    if (localObject2 != null) {
      com.tencent.mm.media.g.d.a((com.tencent.mm.media.g.d)localObject2, this.hEp, this.hEq, 0, null, 0, 0, 60);
    }
    com.tencent.mm.media.g.d locald = this.rwP;
    localObject2 = localObject1;
    if (locald != null)
    {
      com.tencent.mm.plugin.xlabeffect.b localb = this.hiH;
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
      localObject1 = this.BXr;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).rl(((com.tencent.mm.media.g.d)localObject2).igv);
      }
      localObject1 = this.BXr;
      if (localObject1 == null) {
        break label174;
      }
      ((com.tencent.mm.media.j.b.a)localObject1).aED();
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
  
  public final com.tencent.mm.media.g.d aEE()
  {
    return this.rwP;
  }
  
  public final void aML()
  {
    com.tencent.mm.media.j.b.a locala = this.BXr;
    if (locala != null) {
      locala.ijM = true;
    }
  }
  
  public final int aMM()
  {
    com.tencent.mm.media.j.b.a locala = this.BXr;
    if (locala != null) {
      return locala.ijO;
    }
    return 0;
  }
  
  public final int aMN()
  {
    com.tencent.mm.media.j.b.a locala = this.BXr;
    if (locala != null) {
      return locala.ijP;
    }
    return 0;
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.cY(paramInt1, paramInt2);
    Object localObject = this.BXr;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cZ(this.hEp, this.hEq);
    }
    localObject = this.BXr;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).cY(this.hEp, this.hEq);
    }
    localObject = this.hiH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).setSize(this.hEp, this.hEq);
    }
    localObject = this.BXt;
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
    p.h(paramb, "listener");
    com.tencent.mm.media.j.b.a locala = this.BXr;
    if (locala != null)
    {
      locala.ijJ = paramb;
      AppMethodBeat.o(182861);
      return;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.BXr;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    this.BXr = null;
    localObject = this.hiH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.hiH = null;
    localObject = this.rwP;
    if (localObject != null) {
      ((com.tencent.mm.media.g.d)localObject).close();
    }
    this.rwP = null;
    AppMethodBeat.o(182864);
  }
  
  public final void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(237433);
    this.BXs = paramBoolean;
    com.tencent.mm.plugin.xlabeffect.b localb = this.hiH;
    if (localb != null)
    {
      localb.ti(this.BXs);
      AppMethodBeat.o(237433);
      return;
    }
    AppMethodBeat.o(237433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */