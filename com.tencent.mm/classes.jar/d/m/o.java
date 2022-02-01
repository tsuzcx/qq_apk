package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class o<T>
  implements h<T>
{
  final h<T> Kcd;
  final b<T, Boolean> Kch;
  
  public o(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129542);
    this.Kcd = paramh;
    this.Kch = paramb;
    AppMethodBeat.o(129542);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129541);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129541);
    return localIterator;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> Jgp;
    private int Kci;
    private T Kcj;
    
    a()
    {
      AppMethodBeat.i(129523);
      this.Jgp = localObject.Kcd.iterator();
      this.Kci = -1;
      AppMethodBeat.o(129523);
    }
    
    private final void fKw()
    {
      AppMethodBeat.i(129520);
      if (this.Jgp.hasNext())
      {
        Object localObject = this.Jgp.next();
        if (((Boolean)this.KcA.Kch.aA(localObject)).booleanValue())
        {
          this.Kci = 1;
          this.Kcj = localObject;
          AppMethodBeat.o(129520);
          return;
        }
      }
      this.Kci = 0;
      AppMethodBeat.o(129520);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129522);
      if (this.Kci == -1) {
        fKw();
      }
      if (this.Kci == 1)
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
      if (this.Kci == -1) {
        fKw();
      }
      if (this.Kci == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129521);
        throw ((Throwable)localObject);
      }
      Object localObject = this.Kcj;
      this.Kcj = null;
      this.Kci = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.m.o
 * JD-Core Version:    0.7.0.1
 */