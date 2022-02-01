package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final d.g.a.a<T> LPK;
  final b<T, T> LPL;
  
  public g(d.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.LPK = parama;
    this.LPL = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements d.g.b.a.a, Iterator<T>
  {
    private int LPD = -2;
    private T LPE;
    
    private final void gcZ()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.LPD == -2)
      {
        localObject1 = this.LPM.LPK.invoke();
        this.LPE = localObject1;
        if (this.LPE != null) {
          break label83;
        }
      }
      label83:
      for (int i = 0;; i = 1)
      {
        this.LPD = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = this.LPM.LPL;
        Object localObject2 = this.LPE;
        if (localObject2 == null) {
          k.fOy();
        }
        localObject1 = ((b)localObject1).ay(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.LPD < 0) {
        gcZ();
      }
      if (this.LPD == 1)
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
      if (this.LPD < 0) {
        gcZ();
      }
      if (this.LPD == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.LPE;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.LPD = -1;
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