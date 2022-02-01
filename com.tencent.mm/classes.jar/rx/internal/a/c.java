package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final c OuL;
  private static final Object OuM;
  private static final Object OuN;
  
  static
  {
    AppMethodBeat.i(90234);
    OuL = new c();
    OuM = new c.1();
    OuN = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static Object N(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == OuM)
    {
      parame.gDo();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == OuN)
    {
      parame.gC(null);
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
      parame.gC(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static <T> c<T> gDy()
  {
    return OuL;
  }
  
  public static Object gDz()
  {
    return OuM;
  }
  
  public static Object gE(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = OuN;
    }
    return localObject;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == OuN) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */