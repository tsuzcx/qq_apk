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
  private static final j UmF;
  private static final j UmG;
  private final g UmC;
  private final rx.e<rx.d<rx.b>> UmD;
  private final j UmE;
  
  static
  {
    AppMethodBeat.i(90399);
    UmF = new j()
    {
      public final void hQA() {}
      
      public final boolean hQB()
      {
        return false;
      }
    };
    UmG = rx.f.d.hRn();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.UmC = paramg;
    paramg = new c();
    paramg.UoA = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.UmD = new rx.c.b(paramg);
    this.UmE = ((rx.b)parame.call(paramg.hQy())).hQv();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.UmC.createWorker();
    Object localObject2 = rx.internal.a.a.hQE();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean UmL;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.gL(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.gL(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void hQA()
      {
        AppMethodBeat.i(90389);
        if (this.UmL.compareAndSet(false, true))
        {
          this.UmH.hQA();
          localb.hQw();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean hQB()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.UmL.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.UmD.gL(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void hQA()
  {
    AppMethodBeat.i(90396);
    this.UmE.hQA();
    AppMethodBeat.o(90396);
  }
  
  public final boolean hQB()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.UmE.hQB();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final TimeUnit UkI;
    private final rx.b.a Umw;
    private final long delayTime;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.Umw = parama;
      this.delayTime = paramLong;
      this.UkI = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.Umw, this.delayTime, this.UkI);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a Umw;
    
    public b(rx.b.a parama)
    {
      this.Umw = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.Umw);
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
    
    public final void hQA()
    {
      j localj2;
      do
      {
        j localj1 = k.hQP();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.hQP()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.hQO());
      localj2.hQA();
    }
    
    public final boolean hQB()
    {
      return ((j)get()).hQB();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */