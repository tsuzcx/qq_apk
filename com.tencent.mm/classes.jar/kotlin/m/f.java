package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
public final class f<T, R, E>
  implements h<E>
{
  final b<T, R> TSB;
  final b<R, Iterator<E>> TSC;
  final h<T> TSt;
  
  public f(h<? extends T> paramh, b<? super T, ? extends R> paramb, b<? super R, ? extends Iterator<? extends E>> paramb1)
  {
    AppMethodBeat.i(129490);
    this.TSt = paramh;
    this.TSB = paramb;
    this.TSC = paramb1;
    AppMethodBeat.o(129490);
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(129489);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129489);
    return localIterator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements Iterator<E>, a
  {
    private Iterator<? extends E> TSD;
    private final Iterator<T> bXG;
    
    a()
    {
      AppMethodBeat.i(129499);
      this.bXG = localObject.TSt.iterator();
      AppMethodBeat.o(129499);
    }
    
    private final boolean hMf()
    {
      AppMethodBeat.i(129498);
      Object localObject = this.TSD;
      if ((localObject != null) && (!((Iterator)localObject).hasNext())) {
        this.TSD = null;
      }
      while (this.TSD == null)
      {
        if (!this.bXG.hasNext())
        {
          AppMethodBeat.o(129498);
          return false;
        }
        localObject = this.bXG.next();
        localObject = (Iterator)this.TSE.TSC.invoke(this.TSE.TSB.invoke(localObject));
        if (((Iterator)localObject).hasNext())
        {
          this.TSD = ((Iterator)localObject);
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
      boolean bool = hMf();
      AppMethodBeat.o(129497);
      return bool;
    }
    
    public final E next()
    {
      AppMethodBeat.i(129496);
      if (!hMf())
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129496);
        throw ((Throwable)localObject);
      }
      Object localObject = this.TSD;
      if (localObject == null) {
        p.hyc();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.f
 * JD-Core Version:    0.7.0.1
 */