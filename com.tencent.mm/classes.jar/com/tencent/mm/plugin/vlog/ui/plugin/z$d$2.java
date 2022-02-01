package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.f;
import d.d.b.a.j;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.z;
import kotlinx.coroutines.ah;

@f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1$2", f="ThumbLoadingPlugin.kt", gkn={}, m="invokeSuspend")
@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class z$d$2
  extends j
  implements m<ah, d<? super Bitmap>, Object>
{
  int label;
  private ah ocz;
  
  z$d$2(y.f paramf, int paramInt1, int paramInt2, Matrix paramMatrix, d paramd)
  {
    super(paramd);
  }
  
  public final d<z> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(191817);
    p.h(paramd, "completion");
    paramd = new 2(this.tqr, this.CfO, this.CfP, this.CfQ, paramd);
    paramd.ocz = ((ah)paramObject);
    AppMethodBeat.o(191817);
    return paramd;
  }
  
  public final Object cR(Object paramObject)
  {
    AppMethodBeat.i(191816);
    paramObject = a.Nif;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(191816);
      throw paramObject;
    }
    paramObject = (Bitmap)this.tqr.NiY;
    Bitmap localBitmap = (Bitmap)this.tqr.NiY;
    p.g(localBitmap, "thumb");
    int i = (localBitmap.getWidth() - this.CfO) / 2;
    localBitmap = (Bitmap)this.tqr.NiY;
    p.g(localBitmap, "thumb");
    paramObject = Bitmap.createBitmap(paramObject, i, (localBitmap.getHeight() - this.CfP) / 2, this.CfO, this.CfP, this.CfQ, true);
    AppMethodBeat.o(191816);
    return paramObject;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191818);
    paramObject1 = ((2)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
    AppMethodBeat.o(191818);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z.d.2
 * JD-Core Version:    0.7.0.1
 */