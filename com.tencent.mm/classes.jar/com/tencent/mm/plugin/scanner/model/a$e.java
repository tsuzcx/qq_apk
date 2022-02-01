package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;

@f(c="com.tencent.mm.plugin.scanner.model.AIScanImageCdnUploadUtil$saveBitmapToFile$2", f="AIScanImageCdnUploadUtil.kt", hxM={}, m="invokeSuspend")
@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class a$e
  extends j
  implements m<ai, d<? super Boolean>, Object>
{
  int label;
  private ai p$;
  
  a$e(Bitmap paramBitmap, String paramString, d paramd)
  {
    super(2, paramd);
  }
  
  public final d<x> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(240366);
    p.h(paramd, "completion");
    paramd = new e(this.cKG, this.CEE, paramd);
    paramd.p$ = ((ai)paramObject);
    AppMethodBeat.o(240366);
    return paramd;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(240367);
    paramObject1 = ((e)create(paramObject1, (d)paramObject2)).invokeSuspend(x.SXb);
    AppMethodBeat.o(240367);
    return paramObject1;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(240365);
    a locala = a.SXO;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(240365);
      throw paramObject;
    }
    ResultKt.throwOnFailure(paramObject);
    boolean bool1 = false;
    try
    {
      boolean bool2 = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, this.CEE, true);
      bool1 = bool2;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        Log.i("MicroMsg.AIScanImageCdnUploader", "save bitmap to image fail:" + paramObject.getLocalizedMessage());
      }
    }
    AppMethodBeat.o(240365);
    return Boolean.valueOf(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a.e
 * JD-Core Version:    0.7.0.1
 */