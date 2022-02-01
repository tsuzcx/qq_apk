package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class ab$c$2
  extends k
  implements m<aq, d<? super Bitmap>, Object>
{
  int label;
  
  ab$c$2(ah.f<Bitmap> paramf, int paramInt1, int paramInt2, Matrix paramMatrix, d<? super 2> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(282558);
    paramObject = (d)new 2(this.HaU, this.UjE, this.UjF, this.LGg, paramd);
    AppMethodBeat.o(282558);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(282548);
    a locala = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(282548);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    paramObject = Bitmap.createBitmap((Bitmap)this.HaU.aqH, (((Bitmap)this.HaU.aqH).getWidth() - this.UjE) / 2, (((Bitmap)this.HaU.aqH).getHeight() - this.UjF) / 2, this.UjE, this.UjF, this.LGg, true);
    AppMethodBeat.o(282548);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ab.c.2
 * JD-Core Version:    0.7.0.1
 */