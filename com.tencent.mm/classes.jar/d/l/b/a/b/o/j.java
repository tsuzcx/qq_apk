package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;

public final class j
{
  private static final Object Jkz;
  public static volatile boolean KbR;
  
  static
  {
    AppMethodBeat.i(61411);
    Jkz = new j.1();
    KbR = false;
    AppMethodBeat.o(61411);
  }
  
  public static <V> Object fu(V paramV)
  {
    AppMethodBeat.i(61407);
    if (paramV == null)
    {
      paramV = Jkz;
      if (paramV == null) {
        adP(1);
      }
      AppMethodBeat.o(61407);
      return paramV;
    }
    if (paramV == null) {
      adP(2);
    }
    AppMethodBeat.o(61407);
    return paramV;
  }
  
  public static <V> V fv(Object paramObject)
  {
    AppMethodBeat.i(61409);
    if (paramObject == null) {
      adP(4);
    }
    paramObject = fw(paramObject);
    if (paramObject == null) {
      adP(0);
    }
    if (paramObject == Jkz)
    {
      AppMethodBeat.o(61409);
      return null;
    }
    AppMethodBeat.o(61409);
    return paramObject;
  }
  
  public static <V> V fw(Object paramObject)
  {
    AppMethodBeat.i(61410);
    if ((paramObject instanceof a))
    {
      paramObject = ((a)paramObject).fKr();
      if ((KbR) && (c.r(paramObject)))
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
    private final Throwable IzS;
    
    private a(Throwable paramThrowable)
    {
      AppMethodBeat.i(61403);
      this.IzS = paramThrowable;
      AppMethodBeat.o(61403);
    }
    
    public final Throwable fKr()
    {
      AppMethodBeat.i(61404);
      Throwable localThrowable = this.IzS;
      if (localThrowable == null) {
        adP(1);
      }
      AppMethodBeat.o(61404);
      return localThrowable;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(61405);
      String str = this.IzS.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.o.j
 * JD-Core Version:    0.7.0.1
 */