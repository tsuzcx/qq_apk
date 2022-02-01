package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.k;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "scaleType", "", "(I)V", "beautyEnable", "", "currentFilter", "", "filterOutputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getFilterOutputTextureObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setFilterOutputTextureObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "filterProcess", "", "inputRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getInputRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setInputRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "getOutputRenderProc", "setOutputRenderProc", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "doInitRenderProc", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setFilter", "filterPath", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "takePhoto", "updateDrawViewSize", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends com.tencent.mm.media.j.c
{
  private XEffectConfig NIn;
  private com.tencent.mm.media.j.b.a NQX;
  private boolean NQY;
  public m<? super Integer, ? super Integer, ah> NQZ;
  private String NRa;
  private float NRb;
  public k muW;
  private boolean nFT;
  private com.tencent.mm.media.j.b.a yom;
  private d yop;
  
  public c(int paramInt)
  {
    super(1, paramInt);
    AppMethodBeat.i(279399);
    this.NIn = new XEffectConfig();
    AppMethodBeat.o(279399);
  }
  
  public final void Be(boolean paramBoolean)
  {
    AppMethodBeat.i(279416);
    this.NQY = paramBoolean;
    k localk = this.muW;
    if (localk != null) {
      localk.Be(this.NQY);
    }
    AppMethodBeat.o(279416);
  }
  
  public final void G(b<? super IntBuffer, ah> paramb)
  {
    AppMethodBeat.i(182861);
    s.u(paramb, "listener");
    com.tencent.mm.media.j.b.a locala = this.NQX;
    if (locala != null) {
      locala.nDL = paramb;
    }
    AppMethodBeat.o(182861);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(279410);
    s.u(paramXEffectConfig, "config");
    this.NIn = paramXEffectConfig;
    k localk = this.muW;
    if (localk != null) {
      localk.a(this.NIn);
    }
    localk = this.muW;
    if (localk != null) {
      localk.Jm(true);
    }
    localk = this.muW;
    if (localk != null) {
      k.a(localk, true);
    }
    localk = this.muW;
    if (localk != null) {
      localk.Jl(true);
    }
    localk = this.muW;
    if (localk != null) {
      localk.avn(paramXEffectConfig.DpI);
    }
    paramXEffectConfig = this.muW;
    if (paramXEffectConfig != null) {
      paramXEffectConfig.Jn(true);
    }
    AppMethodBeat.o(279410);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(182860);
    if (this.nFT) {}
    for (com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.mVd, this.mVe, this.mWn, this.mWo, 2, getScaleType());; locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.mWn, this.mWo, 2, getScaleType()))
    {
      this.yom = locala;
      Object localObject = this.yom;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).gq(true);
      }
      localObject = this.NQX;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).release();
      }
      this.NQX = ((com.tencent.mm.media.j.b.a)new e(this.mWn, this.mWo, this.mWn, this.mWo, bpJ(), 1));
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).destroy();
      }
      this.muW = new k();
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).q(this.NIn.XKs, this.NIn.XKt, this.NIn.XKu, this.NIn.XKv, this.NIn.XKw);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Jm(true);
      }
      localObject = this.muW;
      if (localObject != null) {
        k.a((k)localObject, true);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Jl(true);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).avn(this.NIn.DpI);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Jn(true);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).n(this.NRa, this.NRb);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).Jo(false);
      }
      localObject = this.muW;
      if (localObject != null) {
        ((k)localObject).setSize(this.mWn, this.mWo);
      }
      localObject = this.yop;
      if (localObject != null) {
        ((d)localObject).close();
      }
      this.yop = com.tencent.mm.media.g.c.d(true, 16L);
      AppMethodBeat.o(182860);
      return locala;
    }
  }
  
  public void bgE()
  {
    Integer localInteger = null;
    AppMethodBeat.i(182863);
    super.bgE();
    Object localObject1 = this.yom;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).nDF)
    {
      AppMethodBeat.o(182863);
      return;
    }
    Object localObject2 = this.muW;
    if (localObject2 != null) {
      k.a((k)localObject2, (d)localObject1);
    }
    localObject2 = this.yop;
    if (localObject2 != null) {
      d.a((d)localObject2, this.mWn, this.mWo, 0, null, 0, 0, 60);
    }
    localObject2 = this.yop;
    k localk;
    if (localObject2 != null)
    {
      localk = this.muW;
      if (localk == null)
      {
        if (localInteger != null) {
          break label163;
        }
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localObject1 = this.NQX;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).uc(((d)localObject2).nAF);
      }
      localObject1 = this.NQX;
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.a)localObject1).bgE();
      }
      AppMethodBeat.o(182863);
      return;
      localInteger = Integer.valueOf(k.a(localk, (d)localObject1, (d)localObject2, false, 60));
      break;
      label163:
      if (localInteger.intValue() != 0) {
        localObject2 = localObject1;
      }
    }
  }
  
  public d bgF()
  {
    return this.yop;
  }
  
  public final void bpM()
  {
    com.tencent.mm.media.j.b.a locala = this.NQX;
    if (locala != null) {
      locala.nDP = true;
    }
  }
  
  public final int bpN()
  {
    com.tencent.mm.media.j.b.a locala = this.NQX;
    if (locala == null) {
      return 0;
    }
    return locala.nDR;
  }
  
  public final int bpO()
  {
    com.tencent.mm.media.j.b.a locala = this.NQX;
    if (locala == null) {
      return 0;
    }
    return locala.nDS;
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182862);
    super.ek(paramInt1, paramInt2);
    Object localObject = this.NQX;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).el(this.mWn, this.mWo);
    }
    localObject = this.NQX;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).ek(this.mWn, this.mWo);
    }
    localObject = this.muW;
    if (localObject != null) {
      ((k)localObject).setSize(this.mWn, this.mWo);
    }
    localObject = this.NQZ;
    if (localObject != null) {
      ((m)localObject).invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(182862);
  }
  
  protected final d gJc()
  {
    return this.yop;
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(182864);
    super.release(paramBoolean);
    Object localObject = this.NQX;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).release();
    }
    this.NQX = null;
    localObject = this.muW;
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    this.muW = null;
    localObject = this.yop;
    if (localObject != null) {
      ((d)localObject).close();
    }
    this.yop = null;
    AppMethodBeat.o(182864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c
 * JD-Core Version:    0.7.0.1
 */