package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.e;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import java.util.Iterator;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, gkc=1)
public class l
  extends k
{
  public static final <T> h<T> V(d.g.a.a<? extends T> parama)
  {
    AppMethodBeat.i(129532);
    p.h(parama, "nextFunction");
    parama = i.a((h)new g(parama, (b)new d(parama)));
    AppMethodBeat.o(129532);
    return parama;
  }
  
  public static final <T> h<T> a(h<? extends T> paramh)
  {
    AppMethodBeat.i(129531);
    p.h(paramh, "$this$constrainOnce");
    if ((paramh instanceof a))
    {
      AppMethodBeat.o(129531);
      return paramh;
    }
    paramh = (h)new a(paramh);
    AppMethodBeat.o(129531);
    return paramh;
  }
  
  public static final <T> h<T> ah(T... paramVarArgs)
  {
    AppMethodBeat.i(129530);
    p.h(paramVarArgs, "elements");
    if (paramVarArgs.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramVarArgs = (h)d.OdB;
      AppMethodBeat.o(129530);
      return paramVarArgs;
    }
    paramVarArgs = e.Z(paramVarArgs);
    AppMethodBeat.o(129530);
    return paramVarArgs;
  }
  
  public static final <T> h<T> b(T paramT, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129533);
    p.h(paramb, "nextFunction");
    if (paramT == null)
    {
      paramT = (h)d.OdB;
      AppMethodBeat.o(129533);
      return paramT;
    }
    paramT = (h)new g((d.g.a.a)new e(paramT), paramb);
    AppMethodBeat.o(129533);
    return paramT;
  }
  
  public static final <T> h<T> d(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(188735);
    p.h(paramIterator, "$this$asSequence");
    paramIterator = i.a((h)new a(paramIterator));
    AppMethodBeat.o(188735);
    return paramIterator;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
  public static final class a
    implements h<T>
  {
    public a(Iterator paramIterator) {}
    
    public final Iterator<T> iterator()
    {
      return this.OdO;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class c
    extends q
    implements b<T, T>
  {
    public static final c OdQ;
    
    static
    {
      AppMethodBeat.i(129488);
      OdQ = new c();
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends q
    implements b<T, T>
  {
    d(d.g.a.a parama)
    {
      super();
    }
    
    public final T invoke(T paramT)
    {
      AppMethodBeat.i(129473);
      p.h(paramT, "it");
      paramT = this.OdR.invoke();
      AppMethodBeat.o(129473);
      return paramT;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
  static final class e
    extends q
    implements d.g.a.a<T>
  {
    e(Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      return this.OdS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.m.l
 * JD-Core Version:    0.7.0.1
 */