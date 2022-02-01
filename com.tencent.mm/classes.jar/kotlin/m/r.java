package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class r<T, R>
  implements h<R>
{
  public final h<T> ajtX;
  public final b<T, R> ajuf;
  
  public r(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129526);
    this.ajtX = paramh;
    this.ajuf = paramb;
    AppMethodBeat.o(129526);
  }
  
  public final Iterator<R> iterator()
  {
    AppMethodBeat.i(129525);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129525);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<R>, a
  {
    private final Iterator<T> atq;
    
    a()
    {
      AppMethodBeat.i(129484);
      this.atq = r.b(localr).iterator();
      AppMethodBeat.o(129484);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129483);
      boolean bool = this.atq.hasNext();
      AppMethodBeat.o(129483);
      return bool;
    }
    
    public final R next()
    {
      AppMethodBeat.i(129482);
      Object localObject = r.a(this.ajuy).invoke(this.atq.next());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.m.r
 * JD-Core Version:    0.7.0.1
 */