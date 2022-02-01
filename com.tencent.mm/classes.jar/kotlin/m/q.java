package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class q<T>
  implements h<T>
{
  private final h<T> ajtX;
  private final b<T, Boolean> ajub;
  
  public q(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129542);
    this.ajtX = paramh;
    this.ajub = paramb;
    AppMethodBeat.o(129542);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129541);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129541);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<T>, a
  {
    private int ajuc;
    private T ajud;
    private final Iterator<T> atq;
    
    a()
    {
      AppMethodBeat.i(129523);
      this.atq = q.b(localq).iterator();
      this.ajuc = -1;
      AppMethodBeat.o(129523);
    }
    
    private final void kBk()
    {
      AppMethodBeat.i(129520);
      if (this.atq.hasNext())
      {
        Object localObject = this.atq.next();
        if (((Boolean)q.a(this.ajux).invoke(localObject)).booleanValue())
        {
          this.ajuc = 1;
          this.ajud = localObject;
          AppMethodBeat.o(129520);
          return;
        }
      }
      this.ajuc = 0;
      AppMethodBeat.o(129520);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129522);
      if (this.ajuc == -1) {
        kBk();
      }
      if (this.ajuc == 1)
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
      if (this.ajuc == -1) {
        kBk();
      }
      if (this.ajuc == 0)
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129521);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajud;
      this.ajud = null;
      this.ajuc = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.m.q
 * JD-Core Version:    0.7.0.1
 */