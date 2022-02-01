package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.a.a;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
public final class f<T, R, E>
  implements h<E>
{
  final b<T, R> NGB;
  final b<R, Iterator<E>> NGC;
  final h<T> NGt;
  
  public f(h<? extends T> paramh, b<? super T, ? extends R> paramb, b<? super R, ? extends Iterator<? extends E>> paramb1)
  {
    AppMethodBeat.i(129490);
    this.NGt = paramh;
    this.NGB = paramb;
    this.NGC = paramb1;
    AppMethodBeat.o(129490);
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(129489);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129489);
    return localIterator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<E>
  {
    private final Iterator<T> MKI;
    private Iterator<? extends E> NGD;
    
    a()
    {
      AppMethodBeat.i(129499);
      this.MKI = localObject.NGt.iterator();
      AppMethodBeat.o(129499);
    }
    
    private final boolean guA()
    {
      AppMethodBeat.i(129498);
      Object localObject = this.NGD;
      if ((localObject != null) && (!((Iterator)localObject).hasNext())) {
        this.NGD = null;
      }
      while (this.NGD == null)
      {
        if (!this.MKI.hasNext())
        {
          AppMethodBeat.o(129498);
          return false;
        }
        localObject = this.MKI.next();
        localObject = (Iterator)this.NGE.NGC.invoke(this.NGE.NGB.invoke(localObject));
        if (((Iterator)localObject).hasNext())
        {
          this.NGD = ((Iterator)localObject);
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
      boolean bool = guA();
      AppMethodBeat.o(129497);
      return bool;
    }
    
    public final E next()
    {
      AppMethodBeat.i(129496);
      if (!guA())
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129496);
        throw ((Throwable)localObject);
      }
      Object localObject = this.NGD;
      if (localObject == null) {
        p.gfZ();
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
 * Qualified Name:     d.m.f
 * JD-Core Version:    0.7.0.1
 */