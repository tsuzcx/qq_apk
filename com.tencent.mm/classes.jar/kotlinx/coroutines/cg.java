package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.f;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class cg
{
  public static final <T> Object a(Collection<? extends al<? extends T>> paramCollection, d.d.d<? super List<? extends T>> paramd)
  {
    AppMethodBeat.i(202325);
    a locala;
    if ((paramd instanceof a))
    {
      locala = (a)paramd;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    a locala1;
    for (;;)
    {
      paramd = locala.result;
      locala1 = a.JgJ;
      switch (locala.label)
      {
      default: 
        paramCollection = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(202325);
        throw paramCollection;
        locala = new a(paramd);
      }
    }
    if (paramCollection.isEmpty())
    {
      paramd = d.a.v.Jgl;
      paramCollection = (List)paramd;
      AppMethodBeat.o(202325);
      return paramCollection;
    }
    paramd = paramCollection.toArray(new al[0]);
    if (paramd == null)
    {
      paramCollection = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(202325);
      throw paramCollection;
    }
    paramd = new cf((al[])paramd);
    locala.mTb = paramCollection;
    locala.label = 1;
    paramCollection = new i(d.d.a.b.d(locala));
    h localh = (h)paramCollection;
    int j = cf.a(paramd).length;
    cf.a[] arrayOfa = new cf.a[j];
    int i = 0;
    while (i < j)
    {
      int k = ((Number)Integer.valueOf(i)).intValue();
      al localal = cf.a(paramd)[k];
      localal.start();
      cf.a locala2 = new cf.a(paramd, localh, (bj)localal);
      locala2.KdY = localal.L((d.g.a.b)locala2);
      arrayOfa[i] = locala2;
      i += 1;
    }
    paramd = new cf.b(paramd, arrayOfa);
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      arrayOfa[i]._disposer = paramd;
      i += 1;
    }
    if (localh.isCompleted()) {
      paramd.gaD();
    }
    for (;;)
    {
      paramCollection = paramCollection.getResult();
      if (paramCollection == a.JgJ) {
        k.h(locala, "frame");
      }
      paramd = paramCollection;
      if (paramCollection != locala1) {
        break;
      }
      AppMethodBeat.o(202325);
      return locala1;
      localh.C((d.g.a.b)paramd);
    }
  }
  
  @f(c="kotlinx.coroutines.AwaitKt", f="Await.kt", l={38}, m="awaitAll")
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"awaitAll", "", "T", "", "Lkotlinx/coroutines/Deferred;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class a
    extends d.d.b.a.d
  {
    int label;
    Object mTb;
    
    a(d.d.d paramd)
    {
      super();
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(202372);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = cg.a(null, this);
      AppMethodBeat.o(202372);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.cg
 * JD-Core Version:    0.7.0.1
 */