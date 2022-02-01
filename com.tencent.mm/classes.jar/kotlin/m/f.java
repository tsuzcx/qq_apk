package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class f<T, R, E>
  implements h<E>
{
  private final h<T> ajtX;
  private final b<T, R> ajuf;
  private final b<R, Iterator<E>> ajug;
  
  public f(h<? extends T> paramh, b<? super T, ? extends R> paramb, b<? super R, ? extends Iterator<? extends E>> paramb1)
  {
    AppMethodBeat.i(129490);
    this.ajtX = paramh;
    this.ajuf = paramb;
    this.ajug = paramb1;
    AppMethodBeat.o(129490);
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(129489);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129489);
    return localIterator;
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<E>, a
  {
    private Iterator<? extends E> ajuh;
    private final Iterator<T> atq;
    
    a()
    {
      AppMethodBeat.i(129499);
      this.atq = f.c(localf).iterator();
      AppMethodBeat.o(129499);
    }
    
    private final boolean kBl()
    {
      AppMethodBeat.i(129498);
      Object localObject = this.ajuh;
      if ((localObject != null) && (!((Iterator)localObject).hasNext())) {
        this.ajuh = null;
      }
      while (this.ajuh == null)
      {
        if (!this.atq.hasNext())
        {
          AppMethodBeat.o(129498);
          return false;
        }
        localObject = this.atq.next();
        localObject = (Iterator)f.a(this.ajui).invoke(f.b(this.ajui).invoke(localObject));
        if (((Iterator)localObject).hasNext())
        {
          this.ajuh = ((Iterator)localObject);
          AppMethodBeat.o(129498);
          return true;
        }
      }
      AppMethodBeat.o(129498);
      return true;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129497);
      boolean bool = kBl();
      AppMethodBeat.o(129497);
      return bool;
    }
    
    public final E next()
    {
      AppMethodBeat.i(129496);
      if (!kBl())
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129496);
        throw ((Throwable)localObject);
      }
      Object localObject = this.ajuh;
      s.checkNotNull(localObject);
      localObject = ((Iterator)localObject).next();
      AppMethodBeat.o(129496);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129500);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129500);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.m.f
 * JD-Core Version:    0.7.0.1
 */