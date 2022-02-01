package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class b<T>
  implements c<T>, h<T>
{
  final h<T> LPy;
  final int count;
  
  public b(h<? extends T> paramh, int paramInt)
  {
    AppMethodBeat.i(129529);
    this.LPy = paramh;
    this.count = paramInt;
    if (this.count >= 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramh = (Throwable)new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
      AppMethodBeat.o(129529);
      throw paramh;
    }
    AppMethodBeat.o(129529);
  }
  
  public final h<T> gcY()
  {
    AppMethodBeat.i(129527);
    int i = this.count + 1;
    if (i < 0)
    {
      localh = (h)new b((h)this, 1);
      AppMethodBeat.o(129527);
      return localh;
    }
    h localh = (h)new b(this.LPy, i);
    AppMethodBeat.o(129527);
    return localh;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129528);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129528);
    return localIterator;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    implements a, Iterator<T>
  {
    private final Iterator<T> KTJ;
    private int left;
    
    a()
    {
      AppMethodBeat.i(129480);
      this.KTJ = localObject.LPy.iterator();
      this.left = localObject.count;
      AppMethodBeat.o(129480);
    }
    
    private final void drop()
    {
      AppMethodBeat.i(129477);
      while ((this.left > 0) && (this.KTJ.hasNext()))
      {
        this.KTJ.next();
        this.left -= 1;
      }
      AppMethodBeat.o(129477);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129479);
      drop();
      boolean bool = this.KTJ.hasNext();
      AppMethodBeat.o(129479);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129478);
      drop();
      Object localObject = this.KTJ.next();
      AppMethodBeat.o(129478);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(129481);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129481);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.m.b
 * JD-Core Version:    0.7.0.1
 */