package com.tencent.mm.plugin.thumbplayer.c.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.e;
import com.tencent.mm.plugin.thumbplayer.downloader.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class c$g
  extends k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  Object L$0;
  Object Uf;
  int label;
  
  c$g(c paramc, kotlin.g.a.a<ah> parama, kotlin.d.d<? super g> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(272610);
    paramObject = (kotlin.d.d)new g(this.TEA, this.TEC, paramd);
    AppMethodBeat.o(272610);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    Object localObject2 = null;
    AppMethodBeat.i(272605);
    Object localObject3 = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(272605);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.TEA;
      localObject1 = (kotlin.d.d)this;
      this.label = 1;
      localObject1 = c.a(paramObject, (kotlin.d.d)localObject1);
      paramObject = localObject1;
      if (localObject1 == localObject3)
      {
        AppMethodBeat.o(272605);
        return localObject3;
      }
    case 1: 
      ResultKt.throwOnFailure(paramObject);
      if (((Boolean)paramObject).booleanValue())
      {
        c.c(this.TEA);
        paramObject = this.TEC;
        if (paramObject != null) {
          paramObject.invoke();
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(272605);
        return paramObject;
      }
      Log.i(c.b(this.TEA), "do loadImageBitmap");
      localObject1 = this.TEA;
      paramObject = this.TEA;
      this.L$0 = paramObject;
      this.Uf = localObject1;
      this.label = 2;
      h localh = new h(kotlin.d.a.b.au((kotlin.d.d)this));
      final kotlin.d.d locald = (kotlin.d.d)localh;
      com.tencent.mm.plugin.thumbplayer.downloader.b localb = com.tencent.mm.plugin.thumbplayer.downloader.b.TCf;
      com.tencent.mm.plugin.thumbplayer.downloader.b.eCl().dk(new g(c.e(paramObject), c.f(paramObject), c.g(paramObject), c.h(paramObject))).a((e)new a(paramObject, locald)).blg();
      paramObject = localh.kli();
      if (paramObject == kotlin.d.a.a.aiwj) {
        s.u((kotlin.d.d)this, "frame");
      }
      if (paramObject != localObject3) {
        break label472;
      }
      AppMethodBeat.o(272605);
      return localObject3;
    }
    Object localObject1 = (c)this.Uf;
    ResultKt.throwOnFailure(paramObject);
    label386:
    label461:
    label472:
    for (;;)
    {
      c.a((c)localObject1, (Bitmap)paramObject);
      if (c.d(this.TEA) == null) {
        break;
      }
      c.c(this.TEA);
      localObject1 = c.b(this.TEA);
      localObject3 = new StringBuilder("loadImageBitmap:").append(c.d(this.TEA)).append(" from network, size:[");
      paramObject = c.d(this.TEA);
      if (paramObject == null)
      {
        paramObject = null;
        localObject3 = ((StringBuilder)localObject3).append(paramObject).append(", ");
        paramObject = c.d(this.TEA);
        if (paramObject != null) {
          break label461;
        }
      }
      for (paramObject = localObject2;; paramObject = Integer.valueOf(paramObject.getHeight()))
      {
        Log.i((String)localObject1, paramObject + ']');
        paramObject = this.TEC;
        if (paramObject == null) {
          break;
        }
        paramObject.invoke();
        break;
        paramObject = Integer.valueOf(paramObject.getWidth());
        break label386;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a<T, R>
    implements e
  {
    a(c paramc, kotlin.d.d<? super Bitmap> paramd) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.c.g
 * JD-Core Version:    0.7.0.1
 */