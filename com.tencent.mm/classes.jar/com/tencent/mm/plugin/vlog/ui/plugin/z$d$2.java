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

@f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1$2", f="ThumbLoadingPlugin.kt", gfL={}, m="invokeSuspend")
@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class z$d$2
  extends j
  implements m<ah, d<? super Bitmap>, Object>
{
  int label;
  private ah nWQ;
  
  z$d$2(y.f paramf, int paramInt1, int paramInt2, Matrix paramMatrix, d paramd)
  {
    super(paramd);
  }
  
  public final d<z> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196358);
    p.h(paramd, "completion");
    paramd = new 2(this.tfy, this.BOp, this.BOq, this.BOr, paramd);
    paramd.nWQ = ((ah)paramObject);
    AppMethodBeat.o(196358);
    return paramd;
  }
  
  public final Object cQ(Object paramObject)
  {
    AppMethodBeat.i(196357);
    paramObject = a.MLc;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196357);
      throw paramObject;
    }
    paramObject = (Bitmap)this.tfy.MLV;
    Bitmap localBitmap = (Bitmap)this.tfy.MLV;
    p.g(localBitmap, "thumb");
    int i = (localBitmap.getWidth() - this.BOp) / 2;
    localBitmap = (Bitmap)this.tfy.MLV;
    p.g(localBitmap, "thumb");
    paramObject = Bitmap.createBitmap(paramObject, i, (localBitmap.getHeight() - this.BOq) / 2, this.BOp, this.BOq, this.BOr, true);
    AppMethodBeat.o(196357);
    return paramObject;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196359);
    paramObject1 = ((2)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
    AppMethodBeat.o(196359);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.z.d.2
 * JD-Core Version:    0.7.0.1
 */