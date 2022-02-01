package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class b<T>
  implements c<T>
{
  private final h<T> ajtX;
  private final int count;
  
  public b(h<? extends T> paramh, int paramInt)
  {
    AppMethodBeat.i(129529);
    this.ajtX = paramh;
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
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129528);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(129528);
    return localIterator;
  }
  
  public final h<T> kBi()
  {
    AppMethodBeat.i(129527);
    int i = this.count + 1;
    if (i < 0) {}
    for (Object localObject = new b((h)this, 1);; localObject = new b(this.ajtX, i))
    {
      localObject = (h)localObject;
      AppMethodBeat.o(129527);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterator<T>, a
  {
    private final Iterator<T> atq;
    private int left;
    
    a()
    {
      AppMethodBeat.i(129480);
      this.atq = b.a(localb).iterator();
      this.left = b.b(localb);
      AppMethodBeat.o(129480);
    }
    
    private final void kBj()
    {
      AppMethodBeat.i(129477);
      while ((this.left > 0) && (this.atq.hasNext()))
      {
        this.atq.next();
        this.left -= 1;
      }
      AppMethodBeat.o(129477);
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(129479);
      kBj();
      boolean bool = this.atq.hasNext();
      AppMethodBeat.o(129479);
      return bool;
    }
    
    public final T next()
    {
      AppMethodBeat.i(129478);
      kBj();
      Object localObject = this.atq.next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.m.b
 * JD-Core Version:    0.7.0.1
 */