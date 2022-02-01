package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class g<T>
  implements h<T>
{
  private final kotlin.g.a.a<T> ajuj;
  private final b<T, T> ajuk;
  
  public g(kotlin.g.a.a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(129487);
    this.ajuj = parama;
    this.ajuk = paramb;
    AppMethodBeat.o(129487);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129486);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129486);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<T>, kotlin.g.b.a.a
  {
    private int ajuc = -2;
    private T ajud;
    
    private final void kBk()
    {
      AppMethodBeat.i(129501);
      Object localObject1;
      if (this.ajuc == -2)
      {
        localObject1 = g.a(this.ajul).invoke();
        this.ajud = localObject1;
        if (this.ajud != null) {
          break label80;
        }
      }
      label80:
      for (int i = 0;; i = 1)
      {
        this.ajuc = i;
        AppMethodBeat.o(129501);
        return;
        localObject1 = g.b(this.ajul);
        Object localObject2 = this.ajud;
        s.checkNotNull(localObject2);
        localObject1 = ((b)localObject1).invoke(localObject2);
        break;
      }
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129503);
      if (this.ajuc < 0) {
        kBk();
      }
      if (this.ajuc == 1)
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
      if (this.ajuc < 0) {
        kBk();
      }
      if (this.ajuc == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajud;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type T");
        AppMethodBeat.o(129502);
        throw ((Throwable)localObject);
      }
      this.ajuc = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.m.g
 * JD-Core Version:    0.7.0.1
 */