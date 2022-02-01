package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import rx.e;

public final class c<T>
{
  private static final c KoV;
  private static final Object KoW;
  private static final Object KoX;
  
  static
  {
    AppMethodBeat.i(90234);
    KoV = new c();
    KoW = new Serializable()
    {
      public final String toString()
      {
        return "Notification=>Completed";
      }
    };
    KoX = new Serializable()
    {
      public final String toString()
      {
        return "Notification=>NULL";
      }
    };
    AppMethodBeat.o(90234);
  }
  
  public static Object K(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == KoW)
    {
      parame.fNs();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == KoX)
    {
      parame.fV(null);
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
      parame.fV(paramObject);
      AppMethodBeat.o(90233);
      return false;
    }
    parame = new IllegalArgumentException("The lite notification can not be null");
    AppMethodBeat.o(90233);
    throw parame;
  }
  
  public static <T> c<T> fNC()
  {
    return KoV;
  }
  
  public static Object fND()
  {
    return KoW;
  }
  
  public static Object fX(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = KoX;
    }
    return localObject;
  }
  
  public static T getValue(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == KoX) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */