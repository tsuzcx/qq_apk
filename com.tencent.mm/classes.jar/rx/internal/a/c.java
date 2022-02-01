package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final Object UkA;
  private static final Object UkB;
  private static final c Ukz;
  
  static
  {
    AppMethodBeat.i(90234);
    Ukz = new c();
    UkA = new c.1();
    UkB = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static Object P(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == UkA)
    {
      parame.hQw();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == UkB)
    {
      parame.gL(null);
      AppMethodBeat.o(90233);
      return false;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() == c.a.class)
      {
        parame.onError(((c.a)paramObject).e);
        AppMethodBeat.o(90233);
        return true;
      }
      parame.gL(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static Object gN(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = UkB;
    }
    return localObject;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == UkB) {
      localObject = null;
    }
    return localObject;
  }
  
  public static <T> c<T> hQG()
  {
    return Ukz;
  }
  
  public static Object hQH()
  {
    return UkA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */