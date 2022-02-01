package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final c NXG;
  private static final Object NXH;
  private static final Object NXI;
  
  static
  {
    AppMethodBeat.i(90234);
    NXG = new c();
    NXH = new c.1();
    NXI = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static Object M(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == NXH)
    {
      parame.gyM();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == NXI)
    {
      parame.gz(null);
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
      parame.gz(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static Object gB(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = NXI;
    }
    return localObject;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == NXI) {
      localObject = null;
    }
    return localObject;
  }
  
  public static <T> c<T> gyW()
  {
    return NXG;
  }
  
  public static Object gyX()
  {
    return NXH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */