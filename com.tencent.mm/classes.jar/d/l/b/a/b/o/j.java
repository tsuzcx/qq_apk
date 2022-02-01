package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class j
{
  private static final Object NlV;
  public static volatile boolean Odn;
  
  static
  {
    AppMethodBeat.i(61411);
    NlV = new Object()
    {
      public final String toString()
      {
        return "NULL_VALUE";
      }
    };
    Odn = false;
    AppMethodBeat.o(61411);
  }
  
  public static <V> Object fD(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = NlV;
      if (paramV == null) {
        ajW(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      ajW(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V fE(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      ajW(4);
    }
    paramObject = fF(paramObject);
    if (paramObject == null) {
      ajW(0);
    }
    if (paramObject == NlV)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V fF(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).getThrowable();
      if ((Odn) && (c.t(paramObject)))
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
  
  public static Object u(Throwable paramThrowable)
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
        ajW(1);
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