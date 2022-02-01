package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T>
  implements h<T>
{
  final h<T> TSt;
  final boolean TSw;
  final b<T, Boolean> TSx;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129494);
    this.TSt = paramh;
    this.TSw = paramBoolean;
    this.TSx = paramb;
    AppMethodBeat.o(129494);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129493);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129493);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<T>, a
  {
    private int TSy;
    private T TSz;
    private final Iterator<T> bXG;
    
    a()
    {
      AppMethodBeat.i(129539);
      this.bXG = localObject.TSt.iterator();
      this.TSy = -1;
      AppMethodBeat.o(129539);
    }
    
    private final void hMe()
    {
      AppMethodBeat.i(129536);
      while (this.bXG.hasNext())
      {
        Object localObject = this.bXG.next();
        if (((Boolean)this.TSA.TSx.invoke(localObject)).booleanValue() == this.TSA.TSw)
        {
          this.TSz = localObject;
          this.TSy = 1;
          AppMethodBeat.o(129536);
          return;
        }
      }
      this.TSy = 0;
      AppMethodBeat.o(129536);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129538);
      if (this.TSy == -1) {
        hMe();
      }
      if (this.TSy == 1)
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
      if (this.TSy == -1) {
        hMe();
      }
      if (this.TSy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129537);
        throw ((Throwable)localObject);
      }
      Object localObject = this.TSz;
      this.TSz = null;
      this.TSy = -1;
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