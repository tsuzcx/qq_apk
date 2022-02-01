package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.a;
import com.tencent.mm.xeffect.effect.ac.a;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.mm.xeffect.effect.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/BlendRenderProcessWrapper;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "blendEffect", "Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getBlendEffect", "()Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "onFrameStart", "onRelease", "uploadBitmap", "bitmap", "plugin-vlog_release"})
public final class e
  implements com.tencent.mm.videocomposition.b.e
{
  private final a Gxh;
  private int Gxi;
  private int height;
  private final kotlin.g.a.b<Long, Bitmap> ihf;
  private final EffectManager wbk;
  private int width;
  
  public e(kotlin.g.a.b<? super Long, Bitmap> paramb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190490);
    this.ihf = paramb;
    this.wbk = paramEffectManager;
    paramb = this.wbk;
    if (paramb != null) {}
    for (paramb = paramb.a(j.Ryl);; paramb = null)
    {
      paramEffectManager = paramb;
      if (!(paramb instanceof a)) {
        paramEffectManager = null;
      }
      this.Gxh = ((a)paramEffectManager);
      AppMethodBeat.o(190490);
      return;
    }
  }
  
  public final void KM(long paramLong)
  {
    AppMethodBeat.i(190488);
    Object localObject1 = (Bitmap)this.ihf.invoke(Long.valueOf(paramLong));
    Object localObject2;
    if (localObject1 != null)
    {
      this.width = ((Bitmap)localObject1).getWidth();
      this.height = ((Bitmap)localObject1).getHeight();
      if (this.Gxi == 0)
      {
        localObject2 = new int[1];
        GLES20.glGenTextures(1, (int[])localObject2, 0);
        GLES20.glBindTexture(3553, localObject2[0]);
        GLES20.glBindTexture(3553, 0);
        this.Gxi = localObject2[0];
      }
      GLES20.glBindTexture(3553, this.Gxi);
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glBindTexture(3553, 0);
    }
    for (localObject1 = new com.tencent.mm.xeffect.b(this.Gxi, this.width, this.height); localObject1 != null; localObject1 = null)
    {
      localObject2 = this.Gxh;
      if ((localObject2 != null) && (((ad)localObject2).id == 0L))
      {
        localObject2 = this.wbk;
        if (localObject2 != null) {
          ((EffectManager)localObject2).a((ad)this.Gxh);
        }
      }
      localObject2 = this.Gxh;
      if (localObject2 == null) {
        break;
      }
      int i = ((com.tencent.mm.xeffect.b)localObject1).textureId;
      int j = ((com.tencent.mm.xeffect.b)localObject1).width;
      int k = ((com.tencent.mm.xeffect.b)localObject1).height;
      localObject1 = ((a)localObject2).RxR;
      ((ac.a)localObject1).textureId = i;
      ((ac.a)localObject1).width = j;
      ((ac.a)localObject1).height = k;
      VLogEffectJNI.INSTANCE.setEffectTexture$renderlib_release(((ac.a)localObject1).GAn.ptr, i, j, k);
      AppMethodBeat.o(190488);
      return;
    }
    AppMethodBeat.o(190488);
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(190489);
    if (this.Gxi != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.Gxi }, 0);
      this.Gxi = 0;
    }
    AppMethodBeat.o(190489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */