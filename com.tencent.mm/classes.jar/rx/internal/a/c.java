package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final c abNV;
  private static final Object abNW;
  private static final Object abNX;
  
  static
  {
    AppMethodBeat.i(90234);
    abNV = new c();
    abNW = new c.1();
    abNX = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static Object T(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == abNW)
    {
      parame.fUB();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == abNX)
    {
      parame.he(null);
      AppMethodBeat.o(90233);
      return false;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() == c.a.class)
      {
        parame.c(((c.a)paramObject).e);
        AppMethodBeat.o(90233);
        return true;
      }
      parame.he(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == abNX) {
      localObject = null;
    }
    return localObject;
  }
  
  public static Object hh(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = abNX;
    }
    return localObject;
  }
  
  public static <T> c<T> iVP()
  {
    return abNV;
  }
  
  public static Object iVQ()
  {
    return abNW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */