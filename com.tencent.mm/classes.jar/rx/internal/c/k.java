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
  private static final j abQb;
  private static final j abQc;
  private final g abPY;
  private final rx.e<rx.d<rx.b>> abPZ;
  private final j abQa;
  
  static
  {
    AppMethodBeat.i(90399);
    abQb = new j()
    {
      public final void iVJ() {}
      
      public final boolean iVK()
      {
        return false;
      }
    };
    abQc = rx.f.d.iWx();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.abPY = paramg;
    paramg = new c();
    paramg.abRO = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.abPZ = new rx.c.b(paramg);
    this.abQa = ((rx.b)parame.call(paramg.iVH())).iVF();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.abPY.createWorker();
    Object localObject2 = rx.internal.a.a.iVN();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean abQh;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.he(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.he(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void iVJ()
      {
        AppMethodBeat.i(90389);
        if (this.abQh.compareAndSet(false, true))
        {
          this.abQd.iVJ();
          localb.fUB();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean iVK()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.abQh.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.abPZ.he(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void iVJ()
  {
    AppMethodBeat.i(90396);
    this.abQa.iVJ();
    AppMethodBeat.o(90396);
  }
  
  public final boolean iVK()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.abQa.iVK();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final TimeUnit abOe;
    private final rx.b.a abPS;
    private final long delayTime;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.abPS = parama;
      this.delayTime = paramLong;
      this.abOe = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.abPS, this.delayTime, this.abOe);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a abPS;
    
    public b(rx.b.a parama)
    {
      this.abPS = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.abPS);
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
    
    public final void iVJ()
    {
      j localj2;
      do
      {
        j localj1 = k.iVY();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.iVY()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.iVX());
      localj2.iVJ();
    }
    
    public final boolean iVK()
    {
      return ((j)get()).iVK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */