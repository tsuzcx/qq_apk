package d.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<E>
  implements Iterable<E>
{
  private static final a<Object> NGi;
  public final a<E> NGj;
  public final E first;
  public final int size;
  
  static
  {
    AppMethodBeat.i(61423);
    NGi = new a();
    AppMethodBeat.o(61423);
  }
  
  private a()
  {
    this.size = 0;
    this.first = null;
    this.NGj = null;
  }
  
  private a(E paramE, a<E> parama)
  {
    AppMethodBeat.i(61415);
    this.first = paramE;
    this.NGj = parama;
    parama.size += 1;
    AppMethodBeat.o(61415);
  }
  
  private Iterator<E> alu(int paramInt)
  {
    AppMethodBeat.i(61418);
    a locala = new a(alw(paramInt));
    AppMethodBeat.o(61418);
    return locala;
  }
  
  private a<E> alw(int paramInt)
  {
    AppMethodBeat.i(61422);
    Object localObject = this;
    for (;;)
    {
      if ((paramInt < 0) || (paramInt > ((a)localObject).size))
      {
        localObject = new IndexOutOfBoundsException();
        AppMethodBeat.o(61422);
        throw ((Throwable)localObject);
      }
      if (paramInt == 0)
      {
        AppMethodBeat.o(61422);
        return localObject;
      }
      localObject = ((a)localObject).NGj;
      paramInt -= 1;
    }
  }
  
  private a<E> fE(Object paramObject)
  {
    AppMethodBeat.i(61420);
    if (this.size == 0)
    {
      AppMethodBeat.o(61420);
      return this;
    }
    if (this.first.equals(paramObject))
    {
      paramObject = this.NGj;
      AppMethodBeat.o(61420);
      return paramObject;
    }
    paramObject = this.NGj.fE(paramObject);
    if (paramObject == this.NGj)
    {
      AppMethodBeat.o(61420);
      return this;
    }
    paramObject = new a(this.first, paramObject);
    AppMethodBeat.o(61420);
    return paramObject;
  }
  
  private E get(int paramInt)
  {
    AppMethodBeat.i(61416);
    Object localObject;
    if ((paramInt < 0) || (paramInt > this.size))
    {
      localObject = new IndexOutOfBoundsException();
      AppMethodBeat.o(61416);
      throw ((Throwable)localObject);
    }
    try
    {
      localObject = alu(paramInt).next();
      AppMethodBeat.o(61416);
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(61416);
      throw localIndexOutOfBoundsException;
    }
  }
  
  public static <E> a<E> guv()
  {
    return NGi;
  }
  
  public final a<E> alv(int paramInt)
  {
    AppMethodBeat.i(61421);
    a locala = fE(get(paramInt));
    AppMethodBeat.o(61421);
    return locala;
  }
  
  public final a<E> fD(E paramE)
  {
    AppMethodBeat.i(61419);
    paramE = new a(paramE, this);
    AppMethodBeat.o(61419);
    return paramE;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61417);
    Iterator localIterator = alu(0);
    AppMethodBeat.o(61417);
    return localIterator;
  }
  
  static final class a<E>
    implements Iterator<E>
  {
    private a<E> NGk;
    
    public a(a<E> parama)
    {
      this.NGk = parama;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(61413);
      if (a.a(this.NGk) > 0)
      {
        AppMethodBeat.o(61413);
        return true;
      }
      AppMethodBeat.o(61413);
      return false;
    }
    
    public final E next()
    {
      Object localObject = this.NGk.first;
      this.NGk = this.NGk.NGj;
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(61414);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(61414);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */