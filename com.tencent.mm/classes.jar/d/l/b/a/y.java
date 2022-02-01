package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import java.lang.ref.SoftReference;

public final class y
{
  public static <T> b<T> Q(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> R(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      ajm(2);
    }
    parama = a(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static <T> a<T> a(T paramT, a<T> parama)
  {
    AppMethodBeat.i(56519);
    if (parama == null) {
      ajm(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static final class a<T>
    extends y.c<T>
  {
    private final a<T> MKg;
    private volatile SoftReference<Object> MOP;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.MOP = null;
      this.MKg = parama;
      if (paramT != null) {
        this.MOP = new SoftReference(eX(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.MOP;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = eY(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.MKg.invoke();
      this.MOP = new SoftReference(eX(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends y.c<T>
  {
    private final a<T> MKg;
    private volatile Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.MKg = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = eY(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.MKg.invoke();
      this.value = eX(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object MOQ = new Object() {};
    
    protected static Object eX(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = MOQ;
      }
      return localObject;
    }
    
    protected static T eY(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == MOQ) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.y
 * JD-Core Version:    0.7.0.1
 */