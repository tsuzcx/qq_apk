package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@f(c="com.tencent.mm.plugin.vlog.ui.plugin.ThumbLoadingPlugin$showThumbLoading$1$2", f="ThumbLoadingPlugin.kt", hxM={}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class ad$d$2
  extends j
  implements m<ai, d<? super Bitmap>, Object>
{
  int label;
  private ai p$;
  
  ad$d$2(z.f paramf, int paramInt1, int paramInt2, Matrix paramMatrix, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(191485);
    p.h(paramd, "completion");
    paramd = new 2(this.wDx, this.GIH, this.GII, this.Aey, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(191485);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191486);
    paramObject1 = ((2)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(191486);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(191484);
    Object localObject = a.SXO;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(191484);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = (Bitmap)this.wDx.SYG;
    localObject = (Bitmap)this.wDx.SYG;
    p.g(localObject, "thumb");
    int i = (((Bitmap)localObject).getWidth() - this.GIH) / 2;
    localObject = (Bitmap)this.wDx.SYG;
    p.g(localObject, "thumb");
    paramObject = Bitmap.createBitmap(paramObject, i, (((Bitmap)localObject).getHeight() - this.GII) / 2, this.GIH, this.GII, this.Aey, true);
    AppMethodBeat.o(191484);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ad.d.2
 * JD-Core Version:    0.7.0.1
 */