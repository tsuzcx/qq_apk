package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final d.g.a.a<T> NGF;
  final b<T, T> NGG;
  
  public g(d.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.NGF = parama;
    this.NGG = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements d.g.b.a.a, Iterator<T>
  {
    private int NGy = -2;
    private T NGz;
    
    private final void guz()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.NGy == -2)
      {
        localObject1 = this.NGH.NGF.invoke();
        this.NGz = localObject1;
        if (this.NGz != null) {
          break label83;
        }
      }
      label83:
      for (int i = 0;; i = 1)
      {
        this.NGy = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = this.NGH.NGG;
        Object localObject2 = this.NGz;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject1 = ((b)localObject1).invoke(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.NGy < 0) {
        guz();
      }
      if (this.NGy == 1)
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
      if (this.NGy < 0) {
        guz();
      }
      if (this.NGy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.NGz;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.NGy = -1;
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