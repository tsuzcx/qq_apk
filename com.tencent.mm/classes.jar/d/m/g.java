package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final d.g.a.a<T> Kcp;
  final b<T, T> Kcq;
  
  public g(d.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.Kcp = parama;
    this.Kcq = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements d.g.b.a.a, Iterator<T>
  {
    private int Kci = -2;
    private T Kcj;
    
    private final void fKw()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.Kci == -2)
      {
        localObject1 = this.Kcr.Kcp.invoke();
        this.Kcj = localObject1;
        if (this.Kcj != null) {
          break label83;
        }
      }
      label83:
      for (int i = 0;; i = 1)
      {
        this.Kci = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = this.Kcr.Kcq;
        Object localObject2 = this.Kcj;
        if (localObject2 == null) {
          k.fvU();
        }
        localObject1 = ((b)localObject1).aA(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.Kci < 0) {
        fKw();
      }
      if (this.Kci == 1)
      {
        AppMethodBeat.o(129503);
        return true;
      }
      AppMethodBeat.o(129503);
      return false;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129502);
      if (this.Kci < 0) {
        fKw();
      }
      if (this.Kci == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.Kcj;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.Kci = -1;
      AppMethodBeat.o(129502);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129504);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129504);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.m.g
 * JD-Core Version:    0.7.0.1
 */