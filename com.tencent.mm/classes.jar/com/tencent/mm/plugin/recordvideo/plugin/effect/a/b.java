package com.tencent.mm.plugin.recordvideo.plugin.effect.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.XEffectConfig;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.IntBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/render/FinderFilterRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "()V", "beautyEnable", "", "filterOutputTextureSmallObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "onDrawViewSizeUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "width", "height", "", "getOnDrawViewSizeUpdate", "()Lkotlin/jvm/functions/Function2;", "setOnDrawViewSizeUpdate", "(Lkotlin/jvm/functions/Function2;)V", "outputRenderProc", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/render/FilterRenderCornerProc;", "useCpuCrop", "getUseCpuCrop", "()Z", "setUseCpuCrop", "(Z)V", "xEffectConfig", "Lcom/tencent/mm/plugin/recordvideo/jumper/XEffectConfig;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getXEffect", "release", "shouldDestroySurfaceTexture", "render", "setBeautyConfig", "config", "setBeautyEnable", "enable", "setOnRGBDataAvailableListener", "listener", "Lkotlin/Function1;", "Ljava/nio/IntBuffer;", "buffer", "updateDrawViewSize", "plugin-recordvideo_release"})
public final class b
  extends com.tencent.mm.media.i.d
{
  private a Lol;
  private com.tencent.mm.media.f.d Lom;
  public XLabEffect fVU;
  private XEffectConfig vif;
  private boolean vpf;
  private m<? super Integer, ? super Integer, y> vpg;
  
  public b()
  {
    super(1);
    AppMethodBeat.i(204209);
    this.vif = new XEffectConfig();
    AppMethodBeat.o(204209);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(204204);
    Object localObject = this.Lol;
    if (localObject != null) {
      ((a)localObject).release();
    }
    this.Lol = new a(this.guK, this.guL, this.guK, this.guL, this.guM);
    localObject = this.Lol;
    if (localObject != null)
    {
      float f = com.tencent.mm.cd.a.ao(aj.getContext(), 2131165303);
      ((a)localObject).oSs = true;
      ((a)localObject).qs = f;
    }
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fVU = new XLabEffect(this.guK, this.guL, 0, false);
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
      ((XLabEffect)localObject).tP(false);
    }
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).setSize(this.guK, this.guL);
    }
    localObject = this.Lom;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    this.Lom = c.a(true, 16L);
    localObject = this.Lol;
    if (localObject == null) {
      k.fvU();
    }
    localObject = (com.tencent.mm.media.i.b.a)localObject;
    AppMethodBeat.o(204204);
    return localObject;
  }
  
  public final void akk()
  {
    AppMethodBeat.i(204207);
    Object localObject1 = this.fVU;
    if (localObject1 != null) {
      XLabEffect.a((XLabEffect)localObject1, this.guC);
    }
    localObject1 = this.Lom;
    if (localObject1 != null) {
      com.tencent.mm.media.f.d.a((com.tencent.mm.media.f.d)localObject1, this.guK, this.guL, 0, null, 0, 0, 60);
    }
    localObject1 = this.Lom;
    if (localObject1 != null)
    {
      int i = ((com.tencent.mm.media.f.d)localObject1).gro;
      localObject1 = this.fVU;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(XLabEffect.a((XLabEffect)localObject1, this.guC, i, 0L, false, 60));
        if (localObject1 != null) {
          break label143;
        }
        localObject2 = localObject1;
      }
      for (;;)
      {
        localObject1 = this.Lol;
        if (localObject1 != null)
        {
          if (localObject2 == null) {
            k.fvU();
          }
          ((a)localObject1).guC = ((Integer)localObject2).intValue();
        }
        localObject1 = this.Lol;
        if (localObject1 == null) {
          break label160;
        }
        ((a)localObject1).akk();
        AppMethodBeat.o(204207);
        return;
        localObject1 = null;
        break;
        label143:
        localObject2 = localObject1;
        if (((Integer)localObject1).intValue() == 0) {
          localObject2 = Integer.valueOf(i);
        }
      }
      label160:
      AppMethodBeat.o(204207);
      return;
    }
    AppMethodBeat.o(204207);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204206);
    super.cT(paramInt1, paramInt2);
    Object localObject = this.Lol;
    if (localObject != null) {
      ((a)localObject).cS(this.guK, this.guL);
    }
    localObject = this.Lol;
    if (localObject != null) {
      ((a)localObject).cT(this.guK, this.guL);
    }
    localObject = this.Lol;
    if (localObject != null)
    {
      int i = this.guK;
      int j = this.guL;
      ((a)localObject).oSt.set(0, 0, i, j);
    }
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).setSize(this.guK, this.guL);
    }
    localObject = this.vpg;
    if (localObject != null)
    {
      ((m)localObject).n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      AppMethodBeat.o(204206);
      return;
    }
    AppMethodBeat.o(204206);
  }
  
  public final void g(d.g.a.b<? super IntBuffer, y> paramb)
  {
    AppMethodBeat.i(204205);
    k.h(paramb, "listener");
    a locala = this.Lol;
    if (locala != null)
    {
      locala.gva = paramb;
      AppMethodBeat.o(204205);
      return;
    }
    AppMethodBeat.o(204205);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(204208);
    super.release(paramBoolean);
    Object localObject = this.Lol;
    if (localObject != null) {
      ((a)localObject).release();
    }
    this.Lol = null;
    localObject = this.fVU;
    if (localObject != null) {
      ((XLabEffect)localObject).destroy();
    }
    this.fVU = null;
    localObject = this.Lom;
    if (localObject != null) {
      ((com.tencent.mm.media.f.d)localObject).close();
    }
    this.Lom = null;
    AppMethodBeat.o(204208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.a.b
 * JD-Core Version:    0.7.0.1
 */