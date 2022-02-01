package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class j
{
  private static final Object KXT;
  public static volatile boolean LPm;
  
  static
  {
    AppMethodBeat.i(61411);
    KXT = new Object()
    {
      public final String toString()
      {
        return "NULL_VALUE";
      }
    };
    LPm = false;
    AppMethodBeat.o(61411);
  }
  
  public static <V> Object fx(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = KXT;
      if (paramV == null) {
        agL(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      agL(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V fy(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      agL(4);
    }
    paramObject = fz(paramObject);
    if (paramObject == null) {
      agL(0);
    }
    if (paramObject == KXT)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V fz(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).gcU();
      if ((LPm) && (c.r(paramObject)))
      {
        paramObject = new b(paramObject);
        AppMethodBeat.o(61410);
        throw paramObject;
      }
      k.h(paramObject, "e");
      AppMethodBeat.o(61410);
      throw paramObject;
    }
    AppMethodBeat.o(61410);
    return paramObject;
  }
  
  public static Object s(Throwable paramThrowable)
  {
    AppMethodBeat.i(61408);
    paramThrowable = new a(paramThrowable, (byte)0);
    AppMethodBeat.o(61408);
    return paramThrowable;
  }
  
  static final class a
  {
    private final Throwable KbB;
    
    private a(Throwable paramThrowable)
    {
      AppMethodBeat.i(61403);
      this.KbB = paramThrowable;
      AppMethodBeat.o(61403);
    }
    
    public final Throwable gcU()
    {
      AppMethodBeat.i(61404);
      Throwable localThrowable = this.KbB;
      if (localThrowable == null) {
        agL(1);
      }
      AppMethodBeat.o(61404);
      return localThrowable;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(61405);
      String str = this.KbB.toString();
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
 * Qualified Name:     d.l.b.a.b.o.j
 * JD-Core Version:    0.7.0.1
 */