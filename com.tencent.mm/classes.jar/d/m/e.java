package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T>
  implements h<T>
{
  final h<T> NGt;
  final boolean NGw;
  final b<T, Boolean> NGx;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129494);
    this.NGt = paramh;
    this.NGw = paramBoolean;
    this.NGx = paramb;
    AppMethodBeat.o(129494);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129493);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129493);
    return localIterator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> MKI;
    private int NGy;
    private T NGz;
    
    a()
    {
      AppMethodBeat.i(129539);
      this.MKI = localObject.NGt.iterator();
      this.NGy = -1;
      AppMethodBeat.o(129539);
    }
    
    private final void guz()
    {
      AppMethodBeat.i(129536);
      while (this.MKI.hasNext())
      {
        Object localObject = this.MKI.next();
        if (((Boolean)this.NGA.NGx.invoke(localObject)).booleanValue() == this.NGA.NGw)
        {
          this.NGz = localObject;
          this.NGy = 1;
          AppMethodBeat.o(129536);
          return;
        }
      }
      this.NGy = 0;
      AppMethodBeat.o(129536);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129538);
      if (this.NGy == -1) {
        guz();
      }
      if (this.NGy == 1)
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
      if (this.NGy == -1) {
        guz();
      }
      if (this.NGy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129537);
        throw ((Throwable)localObject);
      }
      Object localObject = this.NGz;
      this.NGz = null;
      this.NGy = -1;
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
 * Qualified Name:     d.m.e
 * JD-Core Version:    0.7.0.1
 */