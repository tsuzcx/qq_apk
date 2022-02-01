package com.tencent.mm.sns_compose.c;

import androidx.paging.ay;
import androidx.paging.ay.a;
import androidx.paging.ay.a<Ljava.lang.Long;>;
import androidx.paging.ay.b;
import androidx.paging.ay.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sns_compose.a.e;
import com.tencent.mm.sns_compose.a.e.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.d.b.a.b;
import kotlin.d.d<-Landroidx.paging.ay.b<Ljava.lang.Long;Lcom.tencent.mm.sns_compose.a.f;>;>;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/page/WithTaDataSource;", "Landroidx/paging/PagingSource;", "", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "()V", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Long;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends ay<Long, com.tencent.mm.sns_compose.a.f>
{
  public static final f.a aczT;
  
  static
  {
    AppMethodBeat.i(235584);
    aczT = new f.a((byte)0);
    AppMethodBeat.o(235584);
  }
  
  public final Object a(ay.a<Long> parama, kotlin.d.d<? super ay.b<Long, com.tencent.mm.sns_compose.a.f>> paramd)
  {
    AppMethodBeat.i(235593);
    Object localObject;
    if ((paramd instanceof b))
    {
      localObject = (b)paramd;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ay.b<Long, com.tencent.mm.sns_compose.a.f>>)localObject;; paramd = new b(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235593);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject);
    parama = (Long)parama.getKey();
    if (parama == null) {}
    for (long l = -1L;; l = parama.longValue())
    {
      parama = com.tencent.mm.sns_compose.a.acyR;
      paramd.Yx = l;
      paramd.label = 1;
      paramd = parama.a(l, 40, paramd);
      parama = paramd;
      if (paramd != locala) {
        break;
      }
      AppMethodBeat.o(235593);
      return locala;
    }
    l = paramd.Yx;
    ResultKt.throwOnFailure(localObject);
    parama = (ay.a<Long>)localObject;
    parama = (e)parama;
    if ((parama instanceof e.b))
    {
      parama = (com.tencent.mm.sns_compose.a.d)((e.b)parama).cpt;
      Log.i("DemoDataSource", "ok curKey: " + l + ", nextKey: " + parama.aczg);
      if (parama.hasMore) {}
      for (parama = new ay.b.b(parama.bMf, b.BF(parama.aczg));; parama = new ay.b.b(parama.bMf, null))
      {
        parama = (ay.b)parama;
        AppMethodBeat.o(235593);
        return parama;
      }
    }
    Log.e("DemoDataSource", "error");
    parama = (ay.b)new ay.b.b((List)ab.aivy, null);
    AppMethodBeat.o(235593);
    return parama;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    long Yx;
    int label;
    
    b(f paramf, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235588);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aczU.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(235588);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.f
 * JD-Core Version:    0.7.0.1
 */