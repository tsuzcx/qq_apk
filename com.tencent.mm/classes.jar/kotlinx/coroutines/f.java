package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;

@Metadata(d1={""}, d2={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final Object a(cb[] paramArrayOfcb, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188810);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(paramd))
    {
      localObject2 = paramd.result;
      localObject1 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramArrayOfcb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188810);
        throw paramArrayOfcb;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    int j = paramArrayOfcb.length;
    int i = 0;
    if (i < j)
    {
      localObject2 = paramArrayOfcb[i];
      paramd.L$0 = paramArrayOfcb;
      paramd.aai = j;
      paramd.asI = i;
      paramd.label = 1;
      if (((cb)localObject2).ay(paramd) != localObject1) {
        break label215;
      }
      AppMethodBeat.o(188810);
      return localObject1;
      i = paramd.asI;
      j = paramd.aai;
      paramArrayOfcb = (cb[])paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    label215:
    for (;;)
    {
      i += 1;
      break;
      paramArrayOfcb = ah.aiuX;
      AppMethodBeat.o(188810);
      return paramArrayOfcb;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int aai;
    int asI;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188865);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = f.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188865);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.f
 * JD-Core Version:    0.7.0.1
 */