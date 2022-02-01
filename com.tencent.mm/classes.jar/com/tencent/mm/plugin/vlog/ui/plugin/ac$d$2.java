package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class ac$d$2
  extends j
  implements m<ak, d<? super Bitmap>, Object>
{
  int label;
  private ak p$;
  
  ac$d$2(aa.f paramf1, aa.d paramd1, aa.d paramd2, aa.f paramf2, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(230020);
    p.k(paramd, "completion");
    paramd = new 2(this.Buf, this.Nwv, this.Nww, this.Nwx, paramd);
    paramd.p$ = ((ak)paramObject);
    AppMethodBeat.o(230020);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(230023);
    paramObject1 = ((2)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
    AppMethodBeat.o(230023);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(230017);
    Object localObject = a.aaAA;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(230017);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = (Bitmap)this.Buf.aaBC;
    localObject = (Bitmap)this.Buf.aaBC;
    p.j(localObject, "thumb");
    int i = (((Bitmap)localObject).getWidth() - this.Nwv.aaBA) / 2;
    localObject = (Bitmap)this.Buf.aaBC;
    p.j(localObject, "thumb");
    paramObject = Bitmap.createBitmap(paramObject, i, (((Bitmap)localObject).getHeight() - this.Nww.aaBA) / 2, this.Nwv.aaBA, this.Nww.aaBA, (Matrix)this.Nwx.aaBC, true);
    AppMethodBeat.o(230017);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ac.d.2
 * JD-Core Version:    0.7.0.1
 */