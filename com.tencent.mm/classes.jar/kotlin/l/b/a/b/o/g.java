package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class g
{
  private static final Object aiAp;
  public static volatile boolean ajtL;
  
  static
  {
    AppMethodBeat.i(61411);
    aiAp = new Object()
    {
      public final String toString()
      {
        return "NULL_VALUE";
      }
    };
    ajtL = false;
    AppMethodBeat.o(61411);
  }
  
  public static Object L(Throwable paramThrowable)
  {
    AppMethodBeat.i(61408);
    paramThrowable = new a(paramThrowable, (byte)0);
    AppMethodBeat.o(61408);
    return paramThrowable;
  }
  
  public static <V> Object ip(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = aiAp;
      if (paramV == null) {
        aKu(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      aKu(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V iq(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      aKu(4);
    }
    paramObject = ir(paramObject);
    if (paramObject == null) {
      aKu(0);
    }
    if (paramObject == aiAp)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V ir(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).getThrowable();
      if ((ajtL) && (c.K(paramObject)))
      {
        paramObject = new b(paramObject);
        AppMethodBeat.o(61410);
        throw paramObject;
      }
      s.u(paramObject, "e");
      AppMethodBeat.o(61410);
      throw paramObject;
    }
    AppMethodBeat.o(61410);
    return paramObject;
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
        aKu(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.o.g
 * JD-Core Version:    0.7.0.1
 */