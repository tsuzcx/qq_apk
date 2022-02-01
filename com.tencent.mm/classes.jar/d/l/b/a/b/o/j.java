package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class j
{
  private static final Object MOQ;
  public static volatile boolean NGh;
  
  static
  {
    AppMethodBeat.i(61411);
    MOQ = new Object()
    {
      public final String toString()
      {
        return "NULL_VALUE";
      }
    };
    NGh = false;
    AppMethodBeat.o(61411);
  }
  
  public static <V> Object fA(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = MOQ;
      if (paramV == null) {
        ajm(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      ajm(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V fB(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      ajm(4);
    }
    paramObject = fC(paramObject);
    if (paramObject == null) {
      ajm(0);
    }
    if (paramObject == MOQ)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V fC(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).getThrowable();
      if ((NGh) && (c.s(paramObject)))
      {
        paramObject = new b(paramObject);
        AppMethodBeat.o(61410);
        throw paramObject;
      }
      p.h(paramObject, "e");
      AppMethodBeat.o(61410);
      throw paramObject;
    }
    AppMethodBeat.o(61410);
    return paramObject;
  }
  
  public static Object t(Throwable paramThrowable)
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
        ajm(1);
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
 * Qualified Name:     d.l.b.a.b.o.j
 * JD-Core Version:    0.7.0.1
 */