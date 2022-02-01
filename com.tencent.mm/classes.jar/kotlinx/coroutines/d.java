package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.l;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"awaitAll", "", "T", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class d
{
  public static final <T> Object a(Collection<? extends ap<? extends T>> paramCollection, d.d.d<? super List<? extends T>> paramd)
  {
    AppMethodBeat.i(191103);
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
      locala1 = a.KUd;
      switch (locala.label)
      {
      default: 
        paramCollection = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191103);
        throw paramCollection;
        locala = new a(paramd);
      }
    }
    if (paramCollection.isEmpty())
    {
      paramd = d.a.v.KTF;
      paramCollection = (List)paramd;
      AppMethodBeat.o(191103);
      return paramCollection;
    }
    paramd = paramCollection.toArray(new ap[0]);
    if (paramd == null)
    {
      paramCollection = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(191103);
      throw paramCollection;
    }
    paramd = new c((ap[])paramd);
    locala.nvt = paramCollection;
    locala.label = 1;
    paramCollection = new k(d.d.a.b.d(locala));
    j localj = (j)paramCollection;
    int j = c.a(paramd).length;
    c.a[] arrayOfa = new c.a[j];
    int i = 0;
    while (i < j)
    {
      int k = ((Number)Integer.valueOf(i)).intValue();
      ap localap = c.a(paramd)[k];
      localap.start();
      c.a locala2 = new c.a(paramd, localj, (bo)localap);
      locala2.LQD = localap.L((d.g.a.b)locala2);
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
    if (localj.isCompleted()) {
      paramd.gdk();
    }
    for (;;)
    {
      paramCollection = paramCollection.getResult();
      if (paramCollection == a.KUd) {
        d.g.b.k.h(locala, "frame");
      }
      paramd = paramCollection;
      if (paramCollection != locala1) {
        break;
      }
      AppMethodBeat.o(191103);
      return locala1;
      localj.K((d.g.a.b)paramd);
    }
  }
  
  @e(c="kotlinx.coroutines.AwaitKt", f="Await.kt", l={38}, m="awaitAll")
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"awaitAll", "", "T", "", "Lkotlinx/coroutines/Deferred;", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class a
    extends d.d.b.a.c
  {
    int label;
    Object nvt;
    
    a(d.d.d paramd)
    {
      super();
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(191254);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = d.a(null, this);
      AppMethodBeat.o(191254);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.d
 * JD-Core Version:    0.7.0.1
 */