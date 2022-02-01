package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final c akaO;
  private static final Object akaP;
  private static final Object akaQ;
  
  static
  {
    AppMethodBeat.i(90234);
    akaO = new c();
    akaP = new c.1();
    akaQ = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == akaP)
    {
      parame.fvq();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == akaQ)
    {
      parame.jV(null);
      AppMethodBeat.o(90233);
      return false;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() == c.a.class)
      {
        parame.l(((c.a)paramObject).e);
        AppMethodBeat.o(90233);
        return true;
      }
      parame.jV(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static Object ak(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == akaQ) {
      localObject = null;
    }
    return localObject;
  }
  
  public static Object jY(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = akaQ;
    }
    return localObject;
  }
  
  public static <T> c<T> kKn()
  {
    return akaO;
  }
  
  public static Object kKo()
  {
    return akaP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */