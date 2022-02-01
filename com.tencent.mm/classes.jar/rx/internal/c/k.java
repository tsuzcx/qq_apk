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
  private static final j MeK;
  private static final j MeL;
  private final g MeH;
  private final rx.e<rx.d<rx.b>> MeI;
  private final j MeJ;
  
  static
  {
    AppMethodBeat.i(90399);
    MeK = new j()
    {
      public final void ggm() {}
      
      public final boolean ggn()
      {
        return false;
      }
    };
    MeL = rx.f.d.ggZ();
    AppMethodBeat.o(90399);
  }
  
  public k(rx.b.e<rx.d<rx.d<rx.b>>, rx.b> parame, g paramg)
  {
    AppMethodBeat.i(90395);
    this.MeH = paramg;
    paramg = new c();
    paramg.MgF = new a.1(paramg);
    paramg = new rx.e.a(paramg, paramg);
    this.MeI = new rx.c.b(paramg);
    this.MeJ = ((rx.b)parame.call(paramg.ggk())).ggh();
    AppMethodBeat.o(90395);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90398);
    Object localObject1 = this.MeH.createWorker();
    Object localObject2 = rx.internal.a.a.ggq();
    final rx.c.b localb = new rx.c.b((rx.e)localObject2);
    localObject2 = ((rx.internal.a.a)localObject2).a(new rx.b.e() {});
    localObject1 = new g.a()
    {
      private final AtomicBoolean MeQ;
      
      public final j a(rx.b.a paramAnonymousa)
      {
        AppMethodBeat.i(90392);
        paramAnonymousa = new k.b(paramAnonymousa);
        localb.gd(paramAnonymousa);
        AppMethodBeat.o(90392);
        return paramAnonymousa;
      }
      
      public final j a(rx.b.a paramAnonymousa, long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
      {
        AppMethodBeat.i(90391);
        paramAnonymousa = new k.a(paramAnonymousa, paramAnonymousLong, paramAnonymousTimeUnit);
        localb.gd(paramAnonymousa);
        AppMethodBeat.o(90391);
        return paramAnonymousa;
      }
      
      public final void ggm()
      {
        AppMethodBeat.i(90389);
        if (this.MeQ.compareAndSet(false, true))
        {
          this.MeM.ggm();
          localb.ggi();
        }
        AppMethodBeat.o(90389);
      }
      
      public final boolean ggn()
      {
        AppMethodBeat.i(90390);
        boolean bool = this.MeQ.get();
        AppMethodBeat.o(90390);
        return bool;
      }
    };
    this.MeI.gd(localObject2);
    AppMethodBeat.o(90398);
    return localObject1;
  }
  
  public final void ggm()
  {
    AppMethodBeat.i(90396);
    this.MeJ.ggm();
    AppMethodBeat.o(90396);
  }
  
  public final boolean ggn()
  {
    AppMethodBeat.i(90397);
    boolean bool = this.MeJ.ggn();
    AppMethodBeat.o(90397);
    return bool;
  }
  
  static final class a
    extends k.c
  {
    private final long JoQ;
    private final TimeUnit McN;
    private final rx.b.a MeB;
    
    public a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      this.MeB = parama;
      this.JoQ = paramLong;
      this.McN = paramTimeUnit;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90394);
      parama = parama.a(this.MeB, this.JoQ, this.McN);
      AppMethodBeat.o(90394);
      return parama;
    }
  }
  
  static final class b
    extends k.c
  {
    private final rx.b.a MeB;
    
    public b(rx.b.a parama)
    {
      this.MeB = parama;
    }
    
    protected final j a(g.a parama)
    {
      AppMethodBeat.i(90393);
      parama = parama.a(this.MeB);
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
    
    public final void ggm()
    {
      j localj2;
      do
      {
        j localj1 = k.ggB();
        do
        {
          localj2 = (j)get();
          if (localj2 == k.ggB()) {
            return;
          }
        } while (!compareAndSet(localj2, localj1));
      } while (localj2 == k.ggA());
      localj2.ggm();
    }
    
    public final boolean ggn()
    {
      return ((j)get()).ggn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.k
 * JD-Core Version:    0.7.0.1
 */