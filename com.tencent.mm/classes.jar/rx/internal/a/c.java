package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.e;

public final class c<T>
{
  private static final c McE;
  private static final Object McF;
  private static final Object McG;
  
  static
  {
    AppMethodBeat.i(90234);
    McE = new c();
    McF = new c.1();
    McG = new c.2();
    AppMethodBeat.o(90234);
  }
  
  public static Object L(Throwable paramThrowable)
  {
    AppMethodBeat.i(90232);
    paramThrowable = new c.a(paramThrowable);
    AppMethodBeat.o(90232);
    return paramThrowable;
  }
  
  public static boolean a(e<? super T> parame, Object paramObject)
  {
    AppMethodBeat.i(90233);
    if (paramObject == McF)
    {
      parame.ggi();
      AppMethodBeat.o(90233);
      return true;
    }
    if (paramObject == McG)
    {
      parame.gd(null);
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
      parame.gd(paramObject);
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
    if (paramObject == McG) {
      localObject = null;
    }
    return localObject;
  }
  
  public static Object gf(T paramT)
  {
    Object localObject = paramT;
    if (paramT == null) {
      localObject = McG;
    }
    return localObject;
  }
  
  public static <T> c<T> ggs()
  {
    return McE;
  }
  
  public static Object ggt()
  {
    return McF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.a.c
 * JD-Core Version:    0.7.0.1
 */