package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T>
  implements h<T>
{
  final boolean OdC;
  final b<T, Boolean> OdD;
  final h<T> Odz;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129494);
    this.Odz = paramh;
    this.OdC = paramBoolean;
    this.OdD = paramb;
    AppMethodBeat.o(129494);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129493);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129493);
    return localIterator;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> NhL;
    private int OdE;
    private T OdF;
    
    a()
    {
      AppMethodBeat.i(129539);
      this.NhL = localObject.Odz.iterator();
      this.OdE = -1;
      AppMethodBeat.o(129539);
    }
    
    private final void gzb()
    {
      AppMethodBeat.i(129536);
      while (this.NhL.hasNext())
      {
        Object localObject = this.NhL.next();
        if (((Boolean)this.OdG.OdD.invoke(localObject)).booleanValue() == this.OdG.OdC)
        {
          this.OdF = localObject;
          this.OdE = 1;
          AppMethodBeat.o(129536);
          return;
        }
      }
      this.OdE = 0;
      AppMethodBeat.o(129536);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129538);
      if (this.OdE == -1) {
        gzb();
      }
      if (this.OdE == 1)
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
      if (this.OdE == -1) {
        gzb();
      }
      if (this.OdE == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129537);
        throw ((Throwable)localObject);
      }
      Object localObject = this.OdF;
      this.OdF = null;
      this.OdE = -1;
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