package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import kotlin.g.a.a;

public final class ac
{
  public static <T> b<T> co(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> cp(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      aKu(2);
    }
    parama = d(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static <T> a<T> d(T paramT, a<T> parama)
  {
    AppMethodBeat.i(56519);
    if (parama == null) {
      aKu(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static final class a<T>
    extends ac.c<T>
    implements a<T>
  {
    private volatile SoftReference<Object> aiAo;
    private final a<T> aiuJ;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.aiAo = null;
      this.aiuJ = parama;
      if (paramT != null) {
        this.aiAo = new SoftReference(hM(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.aiAo;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = hN(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.aiuJ.invoke();
      this.aiAo = new SoftReference(hM(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends ac.c<T>
  {
    private final a<T> aiuJ;
    private volatile Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.aiuJ = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = hN(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.aiuJ.invoke();
      this.value = hM(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object aiAp = new Object() {};
    
    protected static Object hM(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = aiAp;
      }
      return localObject;
    }
    
    protected static T hN(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == aiAp) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.ac
 * JD-Core Version:    0.7.0.1
 */