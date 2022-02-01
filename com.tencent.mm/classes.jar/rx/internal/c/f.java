package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import rx.f.d;
import rx.g;
import rx.g.a;
import rx.j;

public final class f
  extends g
{
  public static final f Oww;
  
  static
  {
    AppMethodBeat.i(90384);
    Oww = new f();
    AppMethodBeat.o(90384);
  }
  
  public final g.a createWorker()
  {
    AppMethodBeat.i(90383);
    a locala = new a((byte)0);
    AppMethodBeat.o(90383);
    return locala;
  }
  
  final class a
    extends g.a
    implements j
  {
    final rx.f.a Owx;
    
    private a()
    {
      AppMethodBeat.i(90378);
      this.Owx = new rx.f.a();
      AppMethodBeat.o(90378);
    }
    
    public final j a(rx.b.a parama)
    {
      AppMethodBeat.i(90380);
      parama.call();
      parama = d.gEf();
      AppMethodBeat.o(90380);
      return parama;
    }
    
    public final j a(rx.b.a parama, long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(90379);
      parama = a(new l(parama, this, f.this.now() + paramTimeUnit.toMillis(paramLong)));
      AppMethodBeat.o(90379);
      return parama;
    }
    
    public final void gDs()
    {
      AppMethodBeat.i(90381);
      this.Owx.gDs();
      AppMethodBeat.o(90381);
    }
    
    public final boolean gDt()
    {
      AppMethodBeat.i(90382);
      boolean bool = this.Owx.gDt();
      AppMethodBeat.o(90382);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.f
 * JD-Core Version:    0.7.0.1
 */