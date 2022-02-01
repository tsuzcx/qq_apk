package kotlin.l.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<E>
  implements Iterable<E>
{
  private static final a<Object> ajtM;
  public final a<E> ajtN;
  public final E bsC;
  public final int size;
  
  static
  {
    AppMethodBeat.i(61423);
    ajtM = new a();
    AppMethodBeat.o(61423);
  }
  
  private a()
  {
    this.size = 0;
    this.bsC = null;
    this.ajtN = null;
  }
  
  private a(E paramE, a<E> parama)
  {
    AppMethodBeat.i(61415);
    this.bsC = paramE;
    this.ajtN = parama;
    parama.size += 1;
    AppMethodBeat.o(61415);
  }
  
  private Iterator<E> aMu(int paramInt)
  {
    AppMethodBeat.i(61418);
    a locala = new a(aMw(paramInt));
    AppMethodBeat.o(61418);
    return locala;
  }
  
  private a<E> aMw(int paramInt)
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
      localObject = ((a)localObject).ajtN;
      paramInt -= 1;
    }
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
      localObject = aMu(paramInt).next();
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
  
  private a<E> it(Object paramObject)
  {
    AppMethodBeat.i(61420);
    if (this.size == 0)
    {
      AppMethodBeat.o(61420);
      return this;
    }
    if (this.bsC.equals(paramObject))
    {
      paramObject = this.ajtN;
      AppMethodBeat.o(61420);
      return paramObject;
    }
    paramObject = this.ajtN.it(paramObject);
    if (paramObject == this.ajtN)
    {
      AppMethodBeat.o(61420);
      return this;
    }
    paramObject = new a(this.bsC, paramObject);
    AppMethodBeat.o(61420);
    return paramObject;
  }
  
  public static <E> a<E> kBf()
  {
    return ajtM;
  }
  
  public final a<E> aMv(int paramInt)
  {
    AppMethodBeat.i(61421);
    a locala = it(get(paramInt));
    AppMethodBeat.o(61421);
    return locala;
  }
  
  public final a<E> is(E paramE)
  {
    AppMethodBeat.i(61419);
    paramE = new a(paramE, this);
    AppMethodBeat.o(61419);
    return paramE;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(61417);
    Iterator localIterator = aMu(0);
    AppMethodBeat.o(61417);
    return localIterator;
  }
  
  static final class a<E>
    implements Iterator<E>
  {
    private a<E> ajtO;
    
    public a(a<E> parama)
    {
      this.ajtO = parama;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(61413);
      if (a.a(this.ajtO) > 0)
      {
        AppMethodBeat.o(61413);
        return true;
      }
      AppMethodBeat.o(61413);
      return false;
    }
    
    public final E next()
    {
      Object localObject = this.ajtO.bsC;
      this.ajtO = this.ajtO.ajtN;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */