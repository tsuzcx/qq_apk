package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final kotlin.g.a.a<T> TSF;
  final b<T, T> TSG;
  
  public g(kotlin.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.TSF = parama;
    this.TSG = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
  public static final class a
    implements Iterator<T>, kotlin.g.b.a.a
  {
    private int TSy = -2;
    private T TSz;
    
    private final void hMe()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.TSy == -2)
      {
        localObject1 = this.TSH.TSF.invoke();
        this.TSz = localObject1;
        if (this.TSz != null) {
          break label83;
        }
      }
      label83:
      for (int i = 0;; i = 1)
      {
        this.TSy = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = this.TSH.TSG;
        Object localObject2 = this.TSz;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject1 = ((b)localObject1).invoke(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.TSy < 0) {
        hMe();
      }
      if (this.TSy == 1)
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
      if (this.TSy < 0) {
        hMe();
      }
      if (this.TSy == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.TSz;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.TSy = -1;
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
 * Qualified Name:     kotlin.m.g
 * JD-Core Version:    0.7.0.1
 */