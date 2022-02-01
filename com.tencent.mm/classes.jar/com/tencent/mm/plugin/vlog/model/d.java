package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c.e;
import com.tencent.mm.xeffect.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.a;
import com.tencent.mm.xeffect.effect.ae.a;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.j;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/BlendRenderProcessWrapper;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "(Lkotlin/jvm/functions/Function1;Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "getBlendBitmapProvider", "()Lkotlin/jvm/functions/Function1;", "blendEffect", "Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getBlendEffect", "()Lcom/tencent/mm/xeffect/effect/BlendEffect;", "getEffectMgr", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "texture", "width", "blendTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "ensureTexture", "", "onFrameStart", "onRelease", "uploadBitmap", "bitmap", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements e
{
  private final EffectManager GmF;
  private final a TXX;
  private int TXY;
  private int height;
  private final b<Long, Bitmap> nBp;
  private int width;
  
  public d(b<? super Long, Bitmap> paramb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283393);
    this.nBp = paramb;
    this.GmF = paramEffectManager;
    paramb = this.GmF;
    if (paramb == null)
    {
      paramb = null;
      if (!(paramb instanceof a)) {
        break label70;
      }
    }
    label70:
    for (paramb = (a)paramb;; paramb = null)
    {
      this.TXX = paramb;
      AppMethodBeat.o(283393);
      return;
      paramb = paramb.a(j.agYd);
      break;
    }
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(283417);
    if (this.TXY != 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.TXY }, 0);
      this.TXY = 0;
    }
    AppMethodBeat.o(283417);
  }
  
  public final void wx(long paramLong)
  {
    AppMethodBeat.i(283409);
    Object localObject1 = (Bitmap)this.nBp.invoke(Long.valueOf(paramLong));
    Object localObject2;
    if (localObject1 != null)
    {
      this.width = ((Bitmap)localObject1).getWidth();
      this.height = ((Bitmap)localObject1).getHeight();
      if (this.TXY == 0)
      {
        localObject2 = new int[1];
        GLES20.glGenTextures(1, (int[])localObject2, 0);
        GLES20.glBindTexture(3553, localObject2[0]);
        GLES20.glBindTexture(3553, 0);
        this.TXY = localObject2[0];
      }
      GLES20.glBindTexture(3553, this.TXY);
      GLUtils.texImage2D(3553, 0, (Bitmap)localObject1, 0);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 10497.0F);
      GLES20.glTexParameterf(3553, 10243, 10497.0F);
      GLES20.glBindTexture(3553, 0);
      localObject1 = new c(this.TXY, this.width, this.height);
      if (localObject1 != null)
      {
        localObject2 = this.TXX;
        if ((localObject2 == null) || (((af)localObject2).id != 0L)) {
          break label360;
        }
      }
    }
    label360:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = this.GmF;
        if (localObject2 != null) {
          ((EffectManager)localObject2).b((af)this.TXX);
        }
      }
      localObject2 = this.TXX;
      if (localObject2 != null)
      {
        i = ((c)localObject1).textureId;
        int j = ((c)localObject1).width;
        int k = ((c)localObject1).height;
        localObject1 = ((a)localObject2).agXJ;
        ((ae.a)localObject1).textureId = i;
        ((ae.a)localObject1).width = j;
        ((ae.a)localObject1).height = k;
        VLogEffectJNI.INSTANCE.setEffectTexture$renderlib_release(((ae.a)localObject1).Uby.ptr, i, j, k);
      }
      localObject1 = this.TXX;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).agXJ;
        VLogEffectJNI.INSTANCE.nSetEffectIsPreMultiplied(((ae.a)localObject1).Uby.ptr, true);
      }
      AppMethodBeat.o(283409);
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */