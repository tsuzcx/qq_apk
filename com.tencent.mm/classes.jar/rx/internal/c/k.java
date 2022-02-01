package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b.a;
import rx.e.a.1;
import rx.e.c;
import rx.g;
import rx.g.a;
import rx.j;

public final class k
  extends g
  implements j
{
  private static final j Krb;
  private static final j Krc;
  private final g KqY;
  private final rx.e<rx.d<rx.b>> KqZ;
  private final j Kra;
  
  static
  {
    AppMethodBeat.i(90399);
    Krb = new j()
    {
      public final void fNw() {}
      
      public final boolean fNx()
      {
        return false;
      }
    };
    Krc = rx.f.d.fOj();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.KqY = paramg;
    paramg = new c();
    paramg.KsW = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.KqZ = new rx.c.b(paramg);
    this.Kra = ((rx.b)parame.call(paramg.fNu())).fNr();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.KqY.createWorker();
    Object localObject2 = rx.internal.a.a.fNA();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean Krh;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.fV(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.fV(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void fNw()
      {
        AppMethodBeat.i(90389);
        if (this.Krh.compareAndSet(false, true))
        {
          this.Krd.fNw();
          localb.fNs();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean fNx()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.Krh.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.KqZ.fV(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void fNw()
  {
    AppMethodBeat.i(90396);
    this.Kra.fNw();
    AppMethodBeat.o(90396);
  }
  
  public final boolean fNx()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.Kra.fNx();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final long HOv;
    private final TimeUnit Kpe;
    private final rx.b.a KqS;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.KqS = parama;
      this.HOv = paramLong;
      this.Kpe = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.KqS, this.HOv, this.Kpe);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a KqS;
    
    public b(rx.b.a parama)
    {
      this.KqS = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.KqS);
      AppMethodBeat.o(90393);
      return parama;
    }
  }
  
  static abstract class c
    extends AtomicReference<j>
    implements j
  {
    public c()
    {
      super();
    }
    
    protected abstract j a(g.a parama);
    
    public final void fNw()
    {
      j localj2;
      do
      {
        j localj1 = k.fNL();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.fNL()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.fNK());
      localj2.fNw();
    }
    
    public final boolean fNx()
    {
      return ((j)get()).fNx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */