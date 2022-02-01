package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collection<+Lkotlinx.coroutines.ar<+TT;>;>;
import java.util.List;
import kotlin.ResultKt;
import kotlin.a.v;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.d<-Ljava.util.List<+TT;>;>;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class d
{
  public static final <T> Object a(Collection<? extends ar<? extends T>> paramCollection, kotlin.d.d<? super List<? extends T>> paramd)
  {
    AppMethodBeat.i(192333);
    Object localObject;
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super List<? extends T>>)localObject;; paramd = new a(paramd))
    {
      localObject = paramd.result;
      locala = a.SXO;
      switch (paramd.label)
      {
      default: 
        paramCollection = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192333);
        throw paramCollection;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramCollection.isEmpty()) {
      paramCollection = v.SXr;
    }
    for (;;)
    {
      paramCollection = (List)paramCollection;
      AppMethodBeat.o(192333);
      return paramCollection;
      localObject = paramCollection.toArray(new ar[0]);
      if (localObject == null)
      {
        paramCollection = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(192333);
        throw paramCollection;
      }
      localObject = new c((ar[])localObject);
      paramd.L$0 = paramCollection;
      paramd.label = 1;
      paramCollection = new l(kotlin.d.a.b.e(paramd));
      k localk = (k)paramCollection;
      int j = c.a((c)localObject).length;
      c.a[] arrayOfa = new c.a[j];
      int i = 0;
      while (i < j)
      {
        int k = ((Number)Integer.valueOf(i)).intValue();
        ar localar = c.a(localObject)[k];
        localar.start();
        c.a locala1 = new c.a((c)localObject, localk, (bu)localar);
        locala1.TTy = localar.X((kotlin.g.a.b)locala1);
        arrayOfa[i] = locala1;
        i += 1;
      }
      localObject = new c.b((c)localObject, arrayOfa);
      j = arrayOfa.length;
      i = 0;
      while (i < j)
      {
        arrayOfa[i]._disposer = localObject;
        i += 1;
      }
      if (localk.isCompleted()) {
        ((c.b)localObject).hMq();
      }
      for (;;)
      {
        localObject = paramCollection.getResult();
        if (localObject == a.SXO) {
          p.h(paramd, "frame");
        }
        paramCollection = (Collection<? extends ar<? extends T>>)localObject;
        if (localObject != locala) {
          break;
        }
        AppMethodBeat.o(192333);
        return locala;
        localk.W((kotlin.g.a.b)localObject);
      }
      ResultKt.throwOnFailure(localObject);
      paramCollection = (Collection<? extends ar<? extends T>>)localObject;
    }
  }
  
  @f(c="kotlinx.coroutines.AwaitKt", f="Await.kt", hxM={38}, m="awaitAll")
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"awaitAll", "", "T", "", "Lkotlinx/coroutines/Deferred;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(192510);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, this);
      AppMethodBeat.o(192510);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.d
 * JD-Core Version:    0.7.0.1
 */