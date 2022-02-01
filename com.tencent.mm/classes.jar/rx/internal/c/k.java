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
  private static final j NZM;
  private static final j NZN;
  private final g NZJ;
  private final rx.e<rx.d<rx.b>> NZK;
  private final j NZL;
  
  static
  {
    AppMethodBeat.i(90399);
    NZM = new j()
    {
      public final void gyQ() {}
      
      public final boolean gyR()
      {
        return false;
      }
    };
    NZN = rx.f.d.gzD();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.NZJ = paramg;
    paramg = new c();
    paramg.ObH = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.NZK = new rx.c.b(paramg);
    this.NZL = ((rx.b)parame.call(paramg.gyO())).gyL();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.NZJ.createWorker();
    Object localObject2 = rx.internal.a.a.gyU();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean NZS;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.gz(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.gz(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void gyQ()
      {
        AppMethodBeat.i(90389);
        if (this.NZS.compareAndSet(false, true))
        {
          this.NZO.gyQ();
          localb.gyM();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean gyR()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.NZS.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.NZK.gz(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90396);
    this.NZL.gyQ();
    AppMethodBeat.o(90396);
  }
  
  public final boolean gyR()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.NZL.gyR();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final long Lgo;
    private final TimeUnit NXP;
    private final rx.b.a NZD;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.NZD = parama;
      this.Lgo = paramLong;
      this.NXP = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.NZD, this.Lgo, this.NXP);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a NZD;
    
    public b(rx.b.a parama)
    {
      this.NZD = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.NZD);
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
    
    public final void gyQ()
    {
      j localj2;
      do
      {
        j localj1 = k.gzf();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.gzf()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.gze());
      localj2.gyQ();
    }
    
    public final boolean gyR()
    {
      return ((j)get()).gyR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */