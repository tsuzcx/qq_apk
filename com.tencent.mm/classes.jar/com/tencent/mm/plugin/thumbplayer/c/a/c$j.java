package com.tencent.mm.plugin.thumbplayer.c.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$j
  extends k
  implements m<aq, d<? super Boolean>, Object>
{
  int label;
  
  c$j(c paramc, d<? super j> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(272611);
    paramObject = (d)new j(this.TEA, paramd);
    AppMethodBeat.o(272611);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject1 = null;
    AppMethodBeat.i(272606);
    Object localObject2 = a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(272606);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    if (y.ZC(c.f(this.TEA)))
    {
      c.a(this.TEA, BitmapUtil.decodeFileWithSample(c.f(this.TEA)));
      localObject2 = c.b(this.TEA);
      StringBuilder localStringBuilder = new StringBuilder("loadImageBitmap file already exist: ").append(c.d(this.TEA)).append(", size:[");
      paramObject = c.d(this.TEA);
      if (paramObject == null)
      {
        paramObject = null;
        localStringBuilder = localStringBuilder.append(paramObject).append(", ");
        paramObject = c.d(this.TEA);
        if (paramObject != null) {
          break label218;
        }
      }
      label218:
      for (paramObject = localObject1;; paramObject = Integer.valueOf(paramObject.getHeight()))
      {
        Log.i((String)localObject2, paramObject + "], path:" + c.f(this.TEA));
        if (c.d(this.TEA) == null) {
          break label229;
        }
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(272606);
        return paramObject;
        paramObject = Integer.valueOf(paramObject.getWidth());
        break;
      }
    }
    label229:
    paramObject = Boolean.FALSE;
    AppMethodBeat.o(272606);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.c.j
 * JD-Core Version:    0.7.0.1
 */