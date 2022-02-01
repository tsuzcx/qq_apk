package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import java.lang.ref.SoftReference;

public final class z
{
  public static <T> b<T> M(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> N(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      agL(2);
    }
    parama = a(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static <T> a<T> a(T paramT, a<T> parama)
  {
    AppMethodBeat.i(56519);
    if (parama == null) {
      agL(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static final class a<T>
    extends z.c<T>
  {
    private final a<T> KTi;
    private SoftReference<Object> KXS;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.KXS = null;
      this.KTi = parama;
      if (paramT != null) {
        this.KXS = new SoftReference(eV(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.KXS;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = eW(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.KTi.invoke();
      this.KXS = new SoftReference(eV(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends z.c<T>
  {
    private final a<T> KTi;
    private Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.KTi = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = eW(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.KTi.invoke();
      this.value = eV(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object KXT = new Object() {};
    
    protected static Object eV(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = KXT;
      }
      return localObject;
    }
    
    protected static T eW(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == KXT) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.z
 * JD-Core Version:    0.7.0.1
 */