package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import kotlin.g.a.a;

public final class y
{
  public static <T> a<T> a(T paramT, a<T> parama)
  {
    AppMethodBeat.i(56519);
    if (parama == null) {
      aDG(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static <T> b<T> at(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> au(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      aDG(2);
    }
    parama = a(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static final class a<T>
    extends y.c<T>
  {
    private volatile SoftReference<Object> aaEw;
    private final a<T> aazF;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.aaEw = null;
      this.aazF = parama;
      if (paramT != null) {
        this.aaEw = new SoftReference(fm(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.aaEw;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = fn(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.aazF.invoke();
      this.aaEw = new SoftReference(fm(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends y.c<T>
  {
    private final a<T> aazF;
    private volatile Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.aazF = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = fn(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.aazF.invoke();
      this.value = fm(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object aaEx = new Object() {};
    
    protected static Object fm(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = aaEx;
      }
      return localObject;
    }
    
    protected static T fn(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == aaEx) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.y
 * JD-Core Version:    0.7.0.1
 */