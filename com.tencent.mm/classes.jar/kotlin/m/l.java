package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, iBN=1)
public class l
  extends k
{
  public static final <T> h<T> a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129531);
    p.k(paramh, "$this$constrainOnce");
    if ((paramh instanceof a))
    {
      AppMethodBeat.o(129531);
      return paramh;
    }
    paramh = (h)new a(paramh);
    AppMethodBeat.o(129531);
    return paramh;
  }
  
  public static final <T> h<T> an(T... paramVarArgs)
  {
    AppMethodBeat.i(129530);
    p.k(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramVarArgs = (h)d.abuU;
      AppMethodBeat.o(129530);
      return paramVarArgs;
    }
    paramVarArgs = e.ae(paramVarArgs);
    AppMethodBeat.o(129530);
    return paramVarArgs;
  }
  
  public static final <T> h<T> ay(kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(129532);
    p.k(parama, "nextFunction");
    parama = i.a((h)new g(parama, (b)new d(parama)));
    AppMethodBeat.o(129532);
    return parama;
  }
  
  public static final <T> h<T> b(T paramT, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129533);
    p.k(paramb, "nextFunction");
    if (paramT == null)
    {
      paramT = (h)d.abuU;
      AppMethodBeat.o(129533);
      return paramT;
    }
    paramT = (h)new g((kotlin.g.a.a)new e(paramT), paramb);
    AppMethodBeat.o(129533);
    return paramT;
  }
  
  public static final <T> h<T> d(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(218471);
    p.k(paramIterator, "$this$asSequence");
    paramIterator = i.a((h)new a(paramIterator));
    AppMethodBeat.o(218471);
    return paramIterator;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
  public static final class a
    implements h<T>
  {
    public a(Iterator paramIterator) {}
    
    public final Iterator<T> iterator()
    {
      return this.abvh;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"})
  public static final class b
    extends q
    implements b<h<? extends T>, Iterator<? extends T>>
  {
    public static final b abvi;
    
    static
    {
      AppMethodBeat.i(129476);
      abvi = new b();
      AppMethodBeat.o(129476);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class c
    extends q
    implements b<T, T>
  {
    public static final c abvj;
    
    static
    {
      AppMethodBeat.i(129488);
      abvj = new c();
      AppMethodBeat.o(129488);
    }
    
    c()
    {
      super();
    }
    
    public final T invoke(T paramT)
    {
      return paramT;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends q
    implements b<T, T>
  {
    d(kotlin.g.a.a parama)
    {
      super();
    }
    
    public final T invoke(T paramT)
    {
      AppMethodBeat.i(129473);
      p.k(paramT, "it");
      paramT = this.abvk.invoke();
      AppMethodBeat.o(129473);
      return paramT;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
  static final class e
    extends q
    implements kotlin.g.a.a<T>
  {
    e(Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      return this.abvl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.l
 * JD-Core Version:    0.7.0.1
 */