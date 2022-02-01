package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final d.g.a.a<T> OdL;
  final b<T, T> OdM;
  
  public g(d.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.OdL = parama;
    this.OdM = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements d.g.b.a.a, Iterator<T>
  {
    private int OdE = -2;
    private T OdF;
    
    private final void gzb()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.OdE == -2)
      {
        localObject1 = this.OdN.OdL.invoke();
        this.OdF = localObject1;
        if (this.OdF != null) {
          break label83;
        }
      }
      label83:
      for (int i = 0;; i = 1)
      {
        this.OdE = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = this.OdN.OdM;
        Object localObject2 = this.OdF;
        if (localObject2 == null) {
          p.gkB();
        }
        localObject1 = ((b)localObject1).invoke(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.OdE < 0) {
        gzb();
      }
      if (this.OdE == 1)
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
      if (this.OdE < 0) {
        gzb();
      }
      if (this.OdE == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.OdF;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.OdE = -1;
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