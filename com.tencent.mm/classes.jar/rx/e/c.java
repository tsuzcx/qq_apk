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
  public final rx.internal.a.c<T> OuH;
  volatile Object OyJ;
  b<b<T>> OyK;
  b<b<T>> OyL;
  public b<b<T>> OyM;
  boolean active;
  
  public c()
  {
    super(a.OyS);
    AppMethodBeat.i(90418);
    this.active = true;
    this.OyK = rx.b.c.gDv();
    this.OyL = rx.b.c.gDv();
    this.OyM = rx.b.c.gDv();
    this.OuH = rx.internal.a.c.gDy();
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
    b[] arrayOfb = locala.OyP;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.OyS;
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
        localObject = a.OyS;
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
  
  final b<T>[] gF(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.OyJ = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.OyQ;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.OyR)).OyP;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] OyQ;
    static final a OyR;
    static final a OyS;
    final c.b[] OyP;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      OyQ = new c.b[0];
      OyR = new a(true, OyQ);
      OyS = new a(false, OyQ);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.OyP = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    boolean OuF;
    final i<? super T> OuS;
    List<Object> OyT;
    boolean OyU;
    boolean fQG = true;
    
    public b(i<? super T> parami)
    {
      this.OuS = parami;
    }
    
    public final void gC(T paramT)
    {
      AppMethodBeat.i(90413);
      this.OuS.gC(paramT);
      AppMethodBeat.o(90413);
    }
    
    public final void gDo()
    {
      AppMethodBeat.i(90415);
      this.OuS.gDo();
      AppMethodBeat.o(90415);
    }
    
    final void gG(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.OyU) {}
      try
      {
        this.fQG = false;
        if (this.OuF)
        {
          if (this.OyT == null) {
            this.OyT = new ArrayList();
          }
          this.OyT.add(paramObject);
          return;
        }
        this.OyU = true;
        rx.internal.a.c.a(this.OuS, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void gH(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.OuS, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.OuS.onError(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */