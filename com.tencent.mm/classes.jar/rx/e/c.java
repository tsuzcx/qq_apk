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
  public final rx.internal.a.c<T> abNR;
  volatile Object abRL;
  b<b<T>> abRM;
  b<b<T>> abRN;
  public b<b<T>> abRO;
  boolean active;
  
  public c()
  {
    super(a.abRU);
    AppMethodBeat.i(90418);
    this.active = true;
    this.abRM = rx.b.c.iVM();
    this.abRN = rx.b.c.iVM();
    this.abRO = rx.b.c.iVM();
    this.abNR = rx.internal.a.c.iVP();
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
    b[] arrayOfb = locala.abRR;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.abRU;
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
        localObject = a.abRU;
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
  
  final b<T>[] hi(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.abRL = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.abRS;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.abRT)).abRR;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] abRS;
    static final a abRT;
    static final a abRU;
    final c.b[] abRR;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      abRS = new c.b[0];
      abRT = new a(true, abRS);
      abRU = new a(false, abRS);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.abRR = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    boolean abNP;
    final i<? super T> abOc;
    List<Object> abRV;
    boolean abRW;
    boolean jab = true;
    
    public b(i<? super T> parami)
    {
      this.abOc = parami;
    }
    
    public final void c(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.abOc.c(paramThrowable);
      AppMethodBeat.o(90414);
    }
    
    public final void fUB()
    {
      AppMethodBeat.i(90415);
      this.abOc.fUB();
      AppMethodBeat.o(90415);
    }
    
    public final void he(T paramT)
    {
      AppMethodBeat.i(90413);
      this.abOc.he(paramT);
      AppMethodBeat.o(90413);
    }
    
    final void hj(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.abRW) {}
      try
      {
        this.jab = false;
        if (this.abNP)
        {
          if (this.abRV == null) {
            this.abRV = new ArrayList();
          }
          this.abRV.add(paramObject);
          return;
        }
        this.abRW = true;
        rx.internal.a.c.a(this.abOc, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void hk(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.abOc, paramObject);
      }
      AppMethodBeat.o(90417);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */