package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class e<T>
  implements h<T>
{
  private final h<T> ajtX;
  private final boolean ajua;
  private final b<T, Boolean> ajub;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129494);
    this.ajtX = paramh;
    this.ajua = paramBoolean;
    this.ajub = paramb;
    AppMethodBeat.o(129494);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129493);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129493);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<T>, a
  {
    private int ajuc;
    private T ajud;
    private final Iterator<T> atq;
    
    a()
    {
      AppMethodBeat.i(129539);
      this.atq = e.c(locale).iterator();
      this.ajuc = -1;
      AppMethodBeat.o(129539);
    }
    
    private final void kBk()
    {
      AppMethodBeat.i(129536);
      while (this.atq.hasNext())
      {
        Object localObject = this.atq.next();
        if (((Boolean)e.b(this.ajue).invoke(localObject)).booleanValue() == e.a(this.ajue))
        {
          this.ajud = localObject;
          this.ajuc = 1;
          AppMethodBeat.o(129536);
          return;
        }
      }
      this.ajuc = 0;
      AppMethodBeat.o(129536);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129538);
      if (this.ajuc == -1) {
        kBk();
      }
      if (this.ajuc == 1)
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
      if (this.ajuc == -1) {
        kBk();
      }
      if (this.ajuc == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129537);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajud;
      this.ajud = null;
      this.ajuc = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.m.e
 * JD-Core Version:    0.7.0.1
 */