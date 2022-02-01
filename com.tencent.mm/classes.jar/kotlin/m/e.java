package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T>
  implements h<T>
{
  final h<T> abuS;
  final boolean abuV;
  final b<T, Boolean> abuW;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129494);
    this.abuS = paramh;
    this.abuV = paramBoolean;
    this.abuW = paramb;
    AppMethodBeat.o(129494);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129493);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129493);
    return localIterator;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<T>, a
  {
    private int abuX;
    private T abuY;
    private final Iterator<T> bZx;
    
    a()
    {
      AppMethodBeat.i(129539);
      this.bZx = localObject.abuS.iterator();
      this.abuX = -1;
      AppMethodBeat.o(129539);
    }
    
    private final void iQw()
    {
      AppMethodBeat.i(129536);
      while (this.bZx.hasNext())
      {
        Object localObject = this.bZx.next();
        if (((Boolean)this.abuZ.abuW.invoke(localObject)).booleanValue() == this.abuZ.abuV)
        {
          this.abuY = localObject;
          this.abuX = 1;
          AppMethodBeat.o(129536);
          return;
        }
      }
      this.abuX = 0;
      AppMethodBeat.o(129536);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129538);
      if (this.abuX == -1) {
        iQw();
      }
      if (this.abuX == 1)
      {
        AppMethodBeat.o(129538);
        return true;
      }
      AppMethodBeat.o(129538);
      return false;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129537);
      if (this.abuX == -1) {
        iQw();
      }
      if (this.abuX == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129537);
        throw ((Throwable)localObject);
      }
      Object localObject = this.abuY;
      this.abuY = null;
      this.abuX = -1;
      AppMethodBeat.o(129537);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129540);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129540);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.e
 * JD-Core Version:    0.7.0.1
 */