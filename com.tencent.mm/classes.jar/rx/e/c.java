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
  public final rx.internal.a.c<T> Ukv;
  public b<b<T>> UoA;
  volatile Object Uox;
  b<b<T>> Uoy;
  b<b<T>> Uoz;
  boolean active;
  
  public c()
  {
    super(a.UoG);
    AppMethodBeat.i(90418);
    this.active = true;
    this.Uoy = rx.b.c.hQD();
    this.Uoz = rx.b.c.hQD();
    this.UoA = rx.b.c.hQD();
    this.Ukv = rx.internal.a.c.hQG();
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
    b[] arrayOfb = locala.UoD;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.UoG;
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
        localObject = a.UoG;
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
  
  final b<T>[] gO(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.Uox = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.UoE;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.UoF)).UoD;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] UoE;
    static final a UoF;
    static final a UoG;
    final c.b[] UoD;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      UoE = new c.b[0];
      UoF = new a(true, UoE);
      UoG = new a(false, UoE);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.UoD = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    final i<? super T> UkG;
    boolean Ukt;
    boolean UoH;
    boolean gvP = true;
    List<Object> kwB;
    
    public b(i<? super T> parami)
    {
      this.UkG = parami;
    }
    
    public final void gL(T paramT)
    {
      AppMethodBeat.i(90413);
      this.UkG.gL(paramT);
      AppMethodBeat.o(90413);
    }
    
    final void gP(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.UoH) {}
      try
      {
        this.gvP = false;
        if (this.Ukt)
        {
          if (this.kwB == null) {
            this.kwB = new ArrayList();
          }
          this.kwB.add(paramObject);
          return;
        }
        this.UoH = true;
        rx.internal.a.c.a(this.UkG, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void gQ(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.UkG, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void hQw()
    {
      AppMethodBeat.i(90415);
      this.UkG.hQw();
      AppMethodBeat.o(90415);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.UkG.onError(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */