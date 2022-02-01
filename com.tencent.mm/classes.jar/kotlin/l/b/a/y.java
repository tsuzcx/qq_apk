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
      atM(1);
    }
    paramT = new a(paramT, parama);
    AppMethodBeat.o(56519);
    return paramT;
  }
  
  public static <T> b<T> aj(a<T> parama)
  {
    AppMethodBeat.i(56518);
    parama = new b(parama);
    AppMethodBeat.o(56518);
    return parama;
  }
  
  public static <T> a<T> ak(a<T> parama)
  {
    AppMethodBeat.i(56520);
    if (parama == null) {
      atM(2);
    }
    parama = a(null, parama);
    AppMethodBeat.o(56520);
    return parama;
  }
  
  public static final class a<T>
    extends y.c<T>
  {
    private final a<T> SWT;
    private volatile SoftReference<Object> TbC;
    
    public a(T paramT, a<T> parama)
    {
      AppMethodBeat.i(56514);
      this.TbC = null;
      this.SWT = parama;
      if (paramT != null) {
        this.TbC = new SoftReference(ff(paramT));
      }
      AppMethodBeat.o(56514);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56515);
      Object localObject = this.TbC;
      if (localObject != null)
      {
        localObject = ((SoftReference)localObject).get();
        if (localObject != null)
        {
          localObject = fg(localObject);
          AppMethodBeat.o(56515);
          return localObject;
        }
      }
      localObject = this.SWT.invoke();
      this.TbC = new SoftReference(ff(localObject));
      AppMethodBeat.o(56515);
      return localObject;
    }
  }
  
  public static final class b<T>
    extends y.c<T>
  {
    private final a<T> SWT;
    private volatile Object value;
    
    public b(a<T> parama)
    {
      AppMethodBeat.i(56516);
      this.value = null;
      this.SWT = parama;
      AppMethodBeat.o(56516);
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(56517);
      Object localObject = this.value;
      if (localObject != null)
      {
        localObject = fg(localObject);
        AppMethodBeat.o(56517);
        return localObject;
      }
      localObject = this.SWT.invoke();
      this.value = ff(localObject);
      AppMethodBeat.o(56517);
      return localObject;
    }
  }
  
  public static abstract class c<T>
  {
    private static final Object TbD = new Object() {};
    
    protected static Object ff(T paramT)
    {
      Object localObject = paramT;
      if (paramT == null) {
        localObject = TbD;
      }
      return localObject;
    }
    
    protected static T fg(Object paramObject)
    {
      Object localObject = paramObject;
      if (paramObject == TbD) {
        localObject = null;
      }
      return localObject;
    }
    
    public abstract T invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.l.b.a.y
 * JD-Core Version:    0.7.0.1
 */