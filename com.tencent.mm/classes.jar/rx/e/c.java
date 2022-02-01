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
  boolean active;
  public final rx.internal.a.c<T> akaK;
  volatile Object akeD;
  b<b<T>> akeE;
  b<b<T>> akeF;
  public b<b<T>> akeG;
  
  public c()
  {
    super(a.akeM);
    AppMethodBeat.i(90418);
    this.active = true;
    this.akeE = rx.b.c.kKk();
    this.akeF = rx.b.c.kKk();
    this.akeG = rx.b.c.kKk();
    this.akaK = rx.internal.a.c.kKn();
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
    b[] arrayOfb = locala.akeJ;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.akeM;
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
        localObject = a.akeM;
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
  
  final b<T>[] jZ(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.akeD = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.akeK;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.akeL)).akeJ;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] akeK;
    static final a akeL;
    static final a akeM;
    final c.b[] akeJ;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      akeK = new c.b[0];
      akeL = new a(true, akeK);
      akeM = new a(false, akeK);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.akeJ = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    boolean akaI;
    final i<? super T> akaV;
    List<Object> akeN;
    boolean akeO;
    boolean lBW = true;
    
    public b(i<? super T> parami)
    {
      this.akaV = parami;
    }
    
    public final void fvq()
    {
      AppMethodBeat.i(90415);
      this.akaV.fvq();
      AppMethodBeat.o(90415);
    }
    
    public final void jV(T paramT)
    {
      AppMethodBeat.i(90413);
      this.akaV.jV(paramT);
      AppMethodBeat.o(90413);
    }
    
    final void ka(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.akeO) {}
      try
      {
        this.lBW = false;
        if (this.akaI)
        {
          if (this.akeN == null) {
            this.akeN = new ArrayList();
          }
          this.akeN.add(paramObject);
          return;
        }
        this.akeO = true;
        rx.internal.a.c.a(this.akaV, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void kb(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.akaV, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void l(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.akaV.l(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */