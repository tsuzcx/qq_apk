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
  public final rx.internal.a.c<T> NXC;
  volatile Object ObE;
  b<b<T>> ObF;
  b<b<T>> ObG;
  public b<b<T>> ObH;
  boolean active;
  
  public c()
  {
    super(a.ObN);
    AppMethodBeat.i(90418);
    this.active = true;
    this.ObF = rx.b.c.gyT();
    this.ObG = rx.b.c.gyT();
    this.ObH = rx.b.c.gyT();
    this.NXC = rx.internal.a.c.gyW();
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
    b[] arrayOfb = locala.ObK;
    int m = arrayOfb.length;
    Object localObject;
    if ((m == 1) && (arrayOfb[0] == paramb)) {
      localObject = a.ObN;
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
        localObject = a.ObN;
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
  
  final b<T>[] gC(Object paramObject)
  {
    AppMethodBeat.i(90420);
    this.ObE = paramObject;
    this.active = false;
    if (((a)get()).terminated)
    {
      paramObject = a.ObL;
      AppMethodBeat.o(90420);
      return paramObject;
    }
    paramObject = ((a)getAndSet(a.ObM)).ObK;
    AppMethodBeat.o(90420);
    return paramObject;
  }
  
  protected static final class a<T>
  {
    static final c.b[] ObL;
    static final a ObM;
    static final a ObN;
    final c.b[] ObK;
    final boolean terminated;
    
    static
    {
      AppMethodBeat.i(90412);
      ObL = new c.b[0];
      ObM = new a(true, ObL);
      ObN = new a(false, ObL);
      AppMethodBeat.o(90412);
    }
    
    public a(boolean paramBoolean, c.b[] paramArrayOfb)
    {
      this.terminated = paramBoolean;
      this.ObK = paramArrayOfb;
    }
  }
  
  protected static final class b<T>
    implements e<T>
  {
    boolean NXA;
    final i<? super T> NXN;
    List<Object> ObO;
    boolean ObP;
    boolean fOA = true;
    
    public b(i<? super T> parami)
    {
      this.NXN = parami;
    }
    
    final void gD(Object paramObject)
    {
      AppMethodBeat.i(90416);
      if (!this.ObP) {}
      try
      {
        this.fOA = false;
        if (this.NXA)
        {
          if (this.ObO == null) {
            this.ObO = new ArrayList();
          }
          this.ObO.add(paramObject);
          return;
        }
        this.ObP = true;
        rx.internal.a.c.a(this.NXN, paramObject);
        AppMethodBeat.o(90416);
        return;
      }
      finally
      {
        AppMethodBeat.o(90416);
      }
    }
    
    final void gE(Object paramObject)
    {
      AppMethodBeat.i(90417);
      if (paramObject != null) {
        rx.internal.a.c.a(this.NXN, paramObject);
      }
      AppMethodBeat.o(90417);
    }
    
    public final void gyM()
    {
      AppMethodBeat.i(90415);
      this.NXN.gyM();
      AppMethodBeat.o(90415);
    }
    
    public final void gz(T paramT)
    {
      AppMethodBeat.i(90413);
      this.NXN.gz(paramT);
      AppMethodBeat.o(90413);
    }
    
    public final void onError(Throwable paramThrowable)
    {
      AppMethodBeat.i(90414);
      this.NXN.onError(paramThrowable);
      AppMethodBeat.o(90414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.e.c
 * JD-Core Version:    0.7.0.1
 */