package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, fvw=1)
public class l
  extends k
{
  public static final <T> h<T> K(d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(129532);
    d.g.b.k.h(parama, "nextFunction");
    parama = i.a((h)new g(parama, (b)new d(parama)));
    AppMethodBeat.o(129532);
    return parama;
  }
  
  public static final <T> h<T> a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129531);
    d.g.b.k.h(paramh, "$this$constrainOnce");
    if ((paramh instanceof a))
    {
      AppMethodBeat.o(129531);
      return paramh;
    }
    paramh = (h)new a(paramh);
    AppMethodBeat.o(129531);
    return paramh;
  }
  
  public static final <T> h<T> af(T... paramVarArgs)
  {
    AppMethodBeat.i(129530);
    d.g.b.k.h(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramVarArgs = (h)d.Kcf;
      AppMethodBeat.o(129530);
      return paramVarArgs;
    }
    paramVarArgs = e.X(paramVarArgs);
    AppMethodBeat.o(129530);
    return paramVarArgs;
  }
  
  public static final <T> h<T> b(T paramT, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129533);
    d.g.b.k.h(paramb, "nextFunction");
    if (paramT == null)
    {
      paramT = (h)d.Kcf;
      AppMethodBeat.o(129533);
      return paramT;
    }
    paramT = (h)new g((d.g.a.a)new e(paramT), paramb);
    AppMethodBeat.o(129533);
    return paramT;
  }
  
  public static final <T> h<T> d(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(202426);
    d.g.b.k.h(paramIterator, "$this$asSequence");
    paramIterator = i.a((h)new a(paramIterator));
    AppMethodBeat.o(202426);
    return paramIterator;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
  public static final class a
    implements h<T>
  {
    public a(Iterator paramIterator) {}
    
    public final Iterator<T> iterator()
    {
      return this.Kcs;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class c
    extends d.g.b.l
    implements b<T, T>
  {
    public static final c Kcu;
    
    static
    {
      AppMethodBeat.i(129488);
      Kcu = new c();
      AppMethodBeat.o(129488);
    }
    
    c()
    {
      super();
    }
    
    public final T aA(T paramT)
    {
      return paramT;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends d.g.b.l
    implements b<T, T>
  {
    d(d.g.a.a parama)
    {
      super();
    }
    
    public final T aA(T paramT)
    {
      AppMethodBeat.i(129473);
      d.g.b.k.h(paramT, "it");
      paramT = this.Kcv.invoke();
      AppMethodBeat.o(129473);
      return paramT;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<T>
  {
    e(Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      return this.Kcw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.m.l
 * JD-Core Version:    0.7.0.1
 */