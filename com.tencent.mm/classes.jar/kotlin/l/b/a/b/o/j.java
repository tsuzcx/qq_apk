package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class j
{
  private static final Object aaEx;
  public static volatile boolean abuG;
  
  static
  {
    AppMethodBeat.i(61411);
    aaEx = new Object()
    {
      public final String toString()
      {
        return "NULL_VALUE";
      }
    };
    abuG = false;
    AppMethodBeat.o(61411);
  }
  
  public static <V> Object fN(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = aaEx;
      if (paramV == null) {
        aDG(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      aDG(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V fO(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      aDG(4);
    }
    paramObject = fP(paramObject);
    if (paramObject == null) {
      aDG(0);
    }
    if (paramObject == aaEx)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V fP(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).getThrowable();
      if ((abuG) && (c.u(paramObject)))
      {
        paramObject = new b(paramObject);
        AppMethodBeat.o(61410);
        throw paramObject;
      }
      p.k(paramObject, "e");
      AppMethodBeat.o(61410);
      throw paramObject;
    }
    AppMethodBeat.o(61410);
    return paramObject;
  }
  
  public static Object v(Throwable paramThrowable)
  {
    AppMethodBeat.i(61408);
    paramThrowable = new a(paramThrowable, (byte)0);
    AppMethodBeat.o(61408);
    return paramThrowable;
  }
  
  static final class a
  {
    private final Throwable throwable;
    
    private a(Throwable paramThrowable)
    {
      AppMethodBeat.i(61403);
      this.throwable = paramThrowable;
      AppMethodBeat.o(61403);
    }
    
    public final Throwable getThrowable()
    {
      AppMethodBeat.i(61404);
      Throwable localThrowable = this.throwable;
      if (localThrowable == null) {
        aDG(1);
      }
      AppMethodBeat.o(61404);
      return localThrowable;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(61405);
      String str = this.throwable.toString();
      AppMethodBeat.o(61405);
      return str;
    }
  }
  
  public static final class b
    extends RuntimeException
  {
    public b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.o.j
 * JD-Core Version:    0.7.0.1
 */