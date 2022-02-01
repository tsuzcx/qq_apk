package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class o<T>
  implements h<T>
{
  final h<T> NGt;
  final b<T, Boolean> NGx;
  
  public o(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129542);
    this.NGt = paramh;
    this.NGx = paramb;
    AppMethodBeat.o(129542);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129541);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129541);
    return localIterator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> MKI;
    private int NGy;
    private T NGz;
    
    a()
    {
      AppMethodBeat.i(129523);
      this.MKI = localObject.NGt.iterator();
      this.NGy = -1;
      AppMethodBeat.o(129523);
    }
    
    private final void guz()
    {
      AppMethodBeat.i(129520);
      if (this.MKI.hasNext())
      {
        Object localObject = this.MKI.next();
        if (((Boolean)this.NGQ.NGx.invoke(localObject)).booleanValue())
        {
          this.NGy = 1;
          this.NGz = localObject;
          AppMethodBeat.o(129520);
          return;
        }
      }
      this.NGy = 0;
      AppMethodBeat.o(129520);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129522);
      if (this.NGy == -1) {
        guz();
      }
      if (this.NGy == 1)
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
      if (this.NGy == -1) {
        guz();
      }
      if (this.NGy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129521);
        throw ((Throwable)localObject);
      }
      Object localObject = this.NGz;
      this.NGz = null;
      this.NGy = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.m.o
 * JD-Core Version:    0.7.0.1
 */