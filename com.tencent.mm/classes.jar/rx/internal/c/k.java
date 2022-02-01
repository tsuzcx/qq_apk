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
  private static final j OwR;
  private static final j OwS;
  private final g OwO;
  private final rx.e<rx.d<rx.b>> OwP;
  private final j OwQ;
  
  static
  {
    AppMethodBeat.i(90399);
    OwR = new j()
    {
      public final void gDs() {}
      
      public final boolean gDt()
      {
        return false;
      }
    };
    OwS = rx.f.d.gEf();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.OwO = paramg;
    paramg = new c();
    paramg.OyM = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.OwP = new rx.c.b(paramg);
    this.OwQ = ((rx.b)parame.call(paramg.gDq())).gDn();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.OwO.createWorker();
    Object localObject2 = rx.internal.a.a.gDw();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean OwX;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.gC(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.gC(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void gDs()
      {
        AppMethodBeat.i(90389);
        if (this.OwX.compareAndSet(false, true))
        {
          this.OwT.gDs();
          localb.gDo();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean gDt()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.OwX.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.OwP.gC(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void gDs()
  {
    AppMethodBeat.i(90396);
    this.OwQ.gDs();
    AppMethodBeat.o(90396);
  }
  
  public final boolean gDt()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.OwQ.gDt();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final long LCQ;
    private final TimeUnit OuU;
    private final rx.b.a OwI;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.OwI = parama;
      this.LCQ = paramLong;
      this.OuU = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.OwI, this.LCQ, this.OuU);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a OwI;
    
    public b(rx.b.a parama)
    {
      this.OwI = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.OwI);
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
    
    public final void gDs()
    {
      j localj2;
      do
      {
        j localj1 = k.gDH();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.gDH()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.gDG());
      localj2.gDs();
    }
    
    public final boolean gDt()
    {
      return ((j)get()).gDt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */