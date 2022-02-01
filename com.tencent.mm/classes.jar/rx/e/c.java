package rx.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.b.a;
import rx.b.b;
import rx.d.a;
import rx.e;
import rx.i;

public final class c<T>
  extends AtomicReference<a<T>>
  implements d.a<T>
{
  public final rx.internal.a.c<T> McA;
  volatile Object MgC;
  b<b<T>> MgD;
  b<b<T>> MgE;
  public b<b<T>> MgF;
  boolean active;
  
  public c()
  {
    super(a.MgL);
    AppMethodBeat.i(90418);
    this.active = true;
    this.MgD = rx.b.c.ggp();
    this.MgE = rx.b.c.ggp();
    this.MgF = rx.b.c.ggp();
    this.McA = rx.internal.a.c.ggs();
    AppMethodBeat.o(90418);
  }
  
  final void a(b<T> paramb)
  {
    AppMethodBeat.i(90419);
    a locala = (a)get();
    if (locala.terminated)
    {
      AppMethodBeat.o(90419);
      return;
    }
    b[] arrayOfb = locala.MgI;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.MgL;
    }
    label59:
    int j;
    int i;
    for (;;)
    {
      if ((localObject == locala) || (compareAndSet(locala, localObject)))
      {
        AppMethodBeat.o(90419);
        return;
        if (m == 0)
        {
          localObject = locala;
        }
        else
        {
          localObject = new b[m - 1];
          j = 0;
          i = 0;
          label108:
          if (j < m)
          {
            b localb = arrayOfb[j];
            if (localb == paramb) {
              break label224;
            }
            if (i == m - 1)
            {
              localObject = locala;
              continue;
            }
            int k = i + 1;
            localObject[i] = localb;
            i = k;
          }
        }
      }
    }
    label224:
    for (;;)
    {
      j += 1;
      break label108;
      if (i == 0)
      {
        localObject = a.MgL;
        break label59;
      }
      if (i < m - 1)
      {
        arrayOfb = new b[i];
        System.arraycopy(localObject, 0, arrayOfb, 0, i);
        localObject = arrayOfb;
      }
      for (;;)
      {
        localObject = new a(locala.terminated, (b[])localObject);
        break label59;
        break;
      }
    }
  }
  
  final b<T>[] gg(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.MgC = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.MgJ;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.MgK)).MgI;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] MgJ;
    static final a MgK;
    static final a MgL;
    final c.b[] MgI;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      MgJ = new c.b[0];
      MgK = new a(true, MgJ);
      MgL = new a(false, MgJ);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.MgI = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    final i<? super T> McL;
    boolean Mcy;
    List<Object> MgM;
    boolean MgN;
    boolean fvt = true;
    
    public b(i<? super T> parami)
    {
      this.McL = parami;
    }
    
    public final void gd(T paramT)
    {
      AppMethodBeat.i(90413);
      this.McL.gd(paramT);
      AppMethodBeat.o(90413);
    }
    
    public final void ggi()
    {
      AppMethodBeat.i(90415);
      this.McL.ggi();
      AppMethodBeat.o(90415);
    }
    
    final void gh(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.MgN) {}
      try
      {
        this.fvt = false;
        if (this.Mcy)
        {
          if (this.MgM == null) {
            this.MgM = new ArrayList();
          }
          this.MgM.add(paramObject);
          return;
        }
        this.MgN = true;
        rx.internal.a.c.a(this.McL, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void gi(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.McL, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.McL.onError(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */