package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/sequences/SequencesKt")
public class n
  extends m
{
  public static final <T> h<T> a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129531);
    s.u(paramh, "$this$constrainOnce");
    if ((paramh instanceof a))
    {
      AppMethodBeat.o(129531);
      return paramh;
    }
    paramh = (h)new a(paramh);
    AppMethodBeat.o(129531);
    return paramh;
  }
  
  public static final <T> h<T> as(T... paramVarArgs)
  {
    AppMethodBeat.i(129530);
    s.u(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramVarArgs = (h)d.ajtZ;
      AppMethodBeat.o(129530);
      return paramVarArgs;
    }
    paramVarArgs = kotlin.a.k.aj(paramVarArgs);
    AppMethodBeat.o(129530);
    return paramVarArgs;
  }
  
  public static final <T> h<T> b(T paramT, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129533);
    s.u(paramb, "nextFunction");
    if (paramT == null)
    {
      paramT = (h)d.ajtZ;
      AppMethodBeat.o(129533);
      return paramT;
    }
    paramT = (h)new g((kotlin.g.a.a)new e(paramT), paramb);
    AppMethodBeat.o(129533);
    return paramT;
  }
  
  public static final <T> h<T> ct(kotlin.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(129532);
    s.u(parama, "nextFunction");
    parama = k.a((h)new g(parama, (b)new d(parama)));
    AppMethodBeat.o(129532);
    return parama;
  }
  
  public static final <T> h<T> d(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(190934);
    s.u(paramIterator, "$this$asSequence");
    paramIterator = k.a((h)new a(paramIterator));
    AppMethodBeat.o(190934);
    return paramIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements h<T>
  {
    public a(Iterator paramIterator) {}
    
    public final Iterator<T> iterator()
    {
      return this.ajup;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, k=3, mv={1, 5, 1})
  public static final class b
    extends u
    implements b<h<? extends T>, Iterator<? extends T>>
  {
    public static final b ajuq;
    
    static
    {
      AppMethodBeat.i(129476);
      ajuq = new b();
      AppMethodBeat.o(129476);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
  public static final class c
    extends u
    implements b<T, T>
  {
    public static final c ajur;
    
    static
    {
      AppMethodBeat.i(129488);
      ajur = new c();
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
  static final class d
    extends u
    implements b<T, T>
  {
    d(kotlin.g.a.a parama)
    {
      super();
    }
    
    public final T invoke(T paramT)
    {
      AppMethodBeat.i(129473);
      s.u(paramT, "it");
      paramT = this.ajus.invoke();
      AppMethodBeat.o(129473);
      return paramT;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
  static final class e
    extends u
    implements kotlin.g.a.a<T>
  {
    e(Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      return this.ajut;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.n
 * JD-Core Version:    0.7.0.1
 */