package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class o<T>
  implements h<T>
{
  final h<T> TSt;
  final b<T, Boolean> TSx;
  
  public o(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129542);
    this.TSt = paramh;
    this.TSx = paramb;
    AppMethodBeat.o(129542);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129541);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129541);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<T>, a
  {
    private int TSy;
    private T TSz;
    private final Iterator<T> bXG;
    
    a()
    {
      AppMethodBeat.i(129523);
      this.bXG = localObject.TSt.iterator();
      this.TSy = -1;
      AppMethodBeat.o(129523);
    }
    
    private final void hMe()
    {
      AppMethodBeat.i(129520);
      if (this.bXG.hasNext())
      {
        Object localObject = this.bXG.next();
        if (((Boolean)this.TSQ.TSx.invoke(localObject)).booleanValue())
        {
          this.TSy = 1;
          this.TSz = localObject;
          AppMethodBeat.o(129520);
          return;
        }
      }
      this.TSy = 0;
      AppMethodBeat.o(129520);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129522);
      if (this.TSy == -1) {
        hMe();
      }
      if (this.TSy == 1)
      {
        AppMethodBeat.o(129522);
        return true;
      }
      AppMethodBeat.o(129522);
      return false;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129521);
      if (this.TSy == -1) {
        hMe();
      }
      if (this.TSy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129521);
        throw ((Throwable)localObject);
      }
      Object localObject = this.TSz;
      this.TSz = null;
      this.TSy = -1;
      AppMethodBeat.o(129521);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129524);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129524);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.m.o
 * JD-Core Version:    0.7.0.1
 */