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
  public final rx.internal.a.c<T> KoR;
  volatile Object KsT;
  b<b<T>> KsU;
  b<b<T>> KsV;
  public b<b<T>> KsW;
  boolean active;
  
  public c()
  {
    super(a.Ktc);
    AppMethodBeat.i(90418);
    this.active = true;
    this.KsU = rx.b.c.fNz();
    this.KsV = rx.b.c.fNz();
    this.KsW = rx.b.c.fNz();
    this.KoR = rx.internal.a.c.fNC();
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
    b[] arrayOfb = locala.KsZ;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.Ktc;
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
        localObject = a.Ktc;
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
  
  final b<T>[] fY(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.KsT = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.Kta;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.Ktb)).KsZ;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] Kta;
    static final a Ktb;
    static final a Ktc;
    final c.b[] KsZ;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      Kta = new c.b[0];
      Ktb = new a(true, Kta);
      Ktc = new a(false, Kta);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.KsZ = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    boolean KoP;
    final i<? super T> Kpc;
    List<Object> Ktd;
    boolean Kte;
    boolean frM = true;
    
    public b(i<? super T> parami)
    {
      this.Kpc = parami;
    }
    
    public final void fNs()
    {
      AppMethodBeat.i(90415);
      this.Kpc.fNs();
      AppMethodBeat.o(90415);
    }
    
    public final void fV(T paramT)
    {
      AppMethodBeat.i(90413);
      this.Kpc.fV(paramT);
      AppMethodBeat.o(90413);
    }
    
    final void fZ(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.Kte) {}
      try
      {
        this.frM = false;
        if (this.KoP)
        {
          if (this.Ktd == null) {
            this.Ktd = new ArrayList();
          }
          this.Ktd.add(paramObject);
          return;
        }
        this.Kte = true;
        rx.internal.a.c.a(this.Kpc, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void ga(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.Kpc, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.Kpc.onError(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */