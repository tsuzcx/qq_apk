package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.a;
import com.tencent.mm.xeffect.effect.ae.a;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.j;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/BlendRenderProcessWrapper;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "blendEffect", "Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getBlendEffect", "()Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "onFrameStart", "onRelease", "uploadBitmap", "bitmap", "plugin-vlog_release"})
public final class e
  implements com.tencent.mm.videocomposition.b.e
{
  private final EffectManager AJU;
  private final a NkJ;
  private int NkK;
  private int height;
  private final b<Long, Bitmap> kVT;
  private int width;
  
  public e(b<? super Long, Bitmap> paramb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(246211);
    this.kVT = paramb;
    this.AJU = paramEffectManager;
    paramb = this.AJU;
    if (paramb != null) {}
    for (paramb = paramb.a(j.YZR);; paramb = null)
    {
      paramEffectManager = paramb;
      if (!(paramb instanceof a)) {
        paramEffectManager = null;
      }
      this.NkJ = ((a)paramEffectManager);
      AppMethodBeat.o(246211);
      return;
    }
  }
  
  public final void Sj(long paramLong)
  {
    AppMethodBeat.i(246209);
    Object localObject1 = (Bitmap)this.kVT.invoke(Long.valueOf(paramLong));
    Object localObject2;
    if (localObject1 != null)
    {
      this.width = ((Bitmap)localObject1).getWidth();
      this.height = ((Bitmap)localObject1).getHeight();
      if (this.NkK == 0)
      {
        localObject2 = new int[1];
        GLES20.glGenTextures(1, (int[])localObject2, 0);
        GLES20.glBindTexture(3553, localObject2[0]);
        GLES20.glBindTexture(3553, 0);
        this.NkK = localObject2[0];
      }
      GLES20.glBindTexture(3553, this.NkK);
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glBindTexture(3553, 0);
    }
    for (localObject1 = new c(this.NkK, this.width, this.height); localObject1 != null; localObject1 = null)
    {
      localObject2 = this.NkJ;
      if ((localObject2 != null) && (((af)localObject2).id == 0L))
      {
        localObject2 = this.AJU;
        if (localObject2 != null) {
          ((EffectManager)localObject2).b((af)this.NkJ);
        }
      }
      localObject2 = this.NkJ;
      if (localObject2 != null)
      {
        int i = ((c)localObject1).textureId;
        int j = ((c)localObject1).width;
        int k = ((c)localObject1).height;
        localObject1 = ((a)localObject2).YZx;
        ((ae.a)localObject1).textureId = i;
        ((ae.a)localObject1).width = j;
        ((ae.a)localObject1).height = k;
        VLogEffectJNI.INSTANCE.setEffectTexture$renderlib_release(((ae.a)localObject1).NnT.ptr, i, j, k);
      }
      localObject1 = this.NkJ;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((a)localObject1).YZx;
      VLogEffectJNI.INSTANCE.nSetEffectIsPreMultiplied(((ae.a)localObject1).NnT.ptr, true);
      AppMethodBeat.o(246209);
      return;
    }
    AppMethodBeat.o(246209);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(246210);
    if (this.NkK != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.NkK }, 0);
      this.NkK = 0;
    }
    AppMethodBeat.o(246210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */