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
  private static final j akcT;
  private static final j akcU;
  private final g akcQ;
  private final rx.e<rx.d<rx.b>> akcR;
  private final j akcS;
  
  static
  {
    AppMethodBeat.i(90399);
    akcT = new j()
    {
      public final void kKh() {}
      
      public final boolean kKi()
      {
        return false;
      }
    };
    akcU = rx.f.d.kKY();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.akcQ = paramg;
    paramg = new c();
    paramg.akeG = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.akcR = new rx.c.b(paramg);
    this.akcS = ((rx.b)parame.call(paramg.kKg())).kKe();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.akcQ.createWorker();
    Object localObject2 = rx.internal.a.a.kKl();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean akcZ;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.jV(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.jV(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void kKh()
      {
        AppMethodBeat.i(90389);
        if (this.akcZ.compareAndSet(false, true))
        {
          this.akcV.kKh();
          localb.fvq();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean kKi()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.akcZ.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.akcR.jV(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90396);
    this.akcS.kKh();
    AppMethodBeat.o(90396);
  }
  
  public final boolean kKi()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.akcS.kKi();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final TimeUnit akaX;
    private final rx.b.a akcK;
    private final long delayTime;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.akcK = parama;
      this.delayTime = paramLong;
      this.akaX = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.akcK, this.delayTime, this.akaX);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a akcK;
    
    public b(rx.b.a parama)
    {
      this.akcK = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.akcK);
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
    
    public final void kKh()
    {
      j localj2;
      do
      {
        j localj1 = k.kKv();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.kKv()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.kKu());
      localj2.kKh();
    }
    
    public final boolean kKi()
    {
      return ((j)get()).kKi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */