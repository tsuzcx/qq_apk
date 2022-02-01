package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.f;
import d.g.b.p;
import java.util.Collection;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class d
{
  public static final <T> Object a(Collection<? extends aq<? extends T>> paramCollection, d.d.d<? super List<? extends T>> paramd)
  {
    AppMethodBeat.i(190713);
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
      locala1 = a.MLc;
      switch (locala.label)
      {
      default: 
        paramCollection = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190713);
        throw paramCollection;
        locala = new a(paramd);
      }
    }
    if (paramCollection.isEmpty())
    {
      paramd = d.a.v.MKE;
      paramCollection = (List)paramd;
      AppMethodBeat.o(190713);
      return paramCollection;
    }
    paramd = paramCollection.toArray(new aq[0]);
    if (paramd == null)
    {
      paramCollection = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(190713);
      throw paramCollection;
    }
    paramd = new c((aq[])paramd);
    locala.nWR = paramCollection;
    locala.label = 1;
    paramCollection = new l(d.d.a.b.d(locala));
    k localk = (k)paramCollection;
    int j = c.a(paramd).length;
    c.a[] arrayOfa = new c.a[j];
    int i = 0;
    while (i < j)
    {
      int k = ((Number)Integer.valueOf(i)).intValue();
      aq localaq = c.a(paramd)[k];
      localaq.start();
      c.a locala2 = new c.a(paramd, localk, (br)localaq);
      locala2.NHy = localaq.L((d.g.a.b)locala2);
      arrayOfa[i] = locala2;
      i += 1;
    }
    paramd = new c.b(paramd, arrayOfa);
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      arrayOfa[i]._disposer = paramd;
      i += 1;
    }
    if (localk.isCompleted()) {
      paramd.guK();
    }
    for (;;)
    {
      paramCollection = paramCollection.getResult();
      if (paramCollection == a.MLc) {
        p.h(locala, "frame");
      }
      paramd = paramCollection;
      if (paramCollection != locala1) {
        break;
      }
      AppMethodBeat.o(190713);
      return locala1;
      localk.K((d.g.a.b)paramd);
    }
  }
  
  @f(c="kotlinx.coroutines.AwaitKt", f="Await.kt", gfL={38}, m="awaitAll")
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"awaitAll", "", "T", "", "Lkotlinx/coroutines/Deferred;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class a
    extends d.d.b.a.d
  {
    int label;
    Object nWR;
    
    a(d.d.d paramd)
    {
      super();
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(190867);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, this);
      AppMethodBeat.o(190867);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.d
 * JD-Core Version:    0.7.0.1
 */