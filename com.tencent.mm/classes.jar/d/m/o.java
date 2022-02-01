package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class o<T>
  implements h<T>
{
  final b<T, Boolean> OdD;
  final h<T> Odz;
  
  public o(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129542);
    this.Odz = paramh;
    this.OdD = paramb;
    AppMethodBeat.o(129542);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129541);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129541);
    return localIterator;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> NhL;
    private int OdE;
    private T OdF;
    
    a()
    {
      AppMethodBeat.i(129523);
      this.NhL = localObject.Odz.iterator();
      this.OdE = -1;
      AppMethodBeat.o(129523);
    }
    
    private final void gzb()
    {
      AppMethodBeat.i(129520);
      if (this.NhL.hasNext())
      {
        Object localObject = this.NhL.next();
        if (((Boolean)this.OdW.OdD.invoke(localObject)).booleanValue())
        {
          this.OdE = 1;
          this.OdF = localObject;
          AppMethodBeat.o(129520);
          return;
        }
      }
      this.OdE = 0;
      AppMethodBeat.o(129520);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129522);
      if (this.OdE == -1) {
        gzb();
      }
      if (this.OdE == 1)
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
      if (this.OdE == -1) {
        gzb();
      }
      if (this.OdE == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129521);
        throw ((Throwable)localObject);
      }
      Object localObject = this.OdF;
      this.OdF = null;
      this.OdE = -1;
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