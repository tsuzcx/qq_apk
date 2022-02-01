package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import java.lang.ref.SoftReference;

public final class z
{
  public static <T> b<T> F(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> G(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      adP(2);
    }
    parama = a(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static <T> a<T> a(T paramT, a<T> parama)
  {
    AppMethodBeat.i(56519);
    if (parama == null) {
      adP(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static final class a<T>
    extends z.c<T>
  {
    private final a<T> JfO;
    private SoftReference<Object> Jky;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.Jky = null;
      this.JfO = parama;
      if (paramT != null) {
        this.Jky = new SoftReference(eS(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.Jky;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = eT(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.JfO.invoke();
      this.Jky = new SoftReference(eS(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends z.c<T>
  {
    private final a<T> JfO;
    private Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.JfO = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = eT(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.JfO.invoke();
      this.value = eS(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object Jkz = new Object() {};
    
    protected static Object eS(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = Jkz;
      }
      return localObject;
    }
    
    protected static T eT(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == Jkz) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.z
 * JD-Core Version:    0.7.0.1
 */