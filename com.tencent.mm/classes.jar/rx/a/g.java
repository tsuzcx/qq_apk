package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends RuntimeException
{
  public static Throwable a(Throwable paramThrowable, Object paramObject)
  {
    AppMethodBeat.i(90054);
    Object localObject = paramThrowable;
    if (paramThrowable == null) {
      localObject = new NullPointerException();
    }
    paramThrowable = b.K((Throwable)localObject);
    if (((paramThrowable instanceof a)) && (((a)paramThrowable).value == paramObject))
    {
      AppMethodBeat.o(90054);
      return localObject;
    }
    b.d((Throwable)localObject, new a(paramObject));
    AppMethodBeat.o(90054);
    return localObject;
  }
  
  public static final class a
    extends RuntimeException
  {
    final Object value;
    
    public a(Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.a.g
 * JD-Core Version:    0.7.0.1
 */