package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"})
public final class p<T, R>
  implements h<R>
{
  public final b<T, R> TSB;
  public final h<T> TSt;
  
  public p(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129526);
    this.TSt = paramh;
    this.TSB = paramb;
    AppMethodBeat.o(129526);
  }
  
  public final Iterator<R> iterator()
  {
    AppMethodBeat.i(129525);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129525);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements Iterator<R>, a
  {
    private final Iterator<T> bXG;
    
    a()
    {
      AppMethodBeat.i(129484);
      this.bXG = localObject.TSt.iterator();
      AppMethodBeat.o(129484);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129483);
      boolean bool = this.bXG.hasNext();
      AppMethodBeat.o(129483);
      return bool;
    }
    
    public final R next()
    {
      AppMethodBeat.i(129482);
      Object localObject = this.TSR.TSB.invoke(this.bXG.next());
      AppMethodBeat.o(129482);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129485);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129485);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.p
 * JD-Core Version:    0.7.0.1
 */