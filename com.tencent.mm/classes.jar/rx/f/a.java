package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class a
  implements j
{
  static final rx.b.a akeQ;
  final AtomicReference<rx.b.a> akeP;
  
  static
  {
    AppMethodBeat.i(90446);
    akeQ = new rx.b.a()
    {
      public final void call() {}
    };
    AppMethodBeat.o(90446);
  }
  
  public a()
  {
    AppMethodBeat.i(90440);
    this.akeP = new AtomicReference();
    AppMethodBeat.o(90440);
  }
  
  private a(rx.b.a parama)
  {
    AppMethodBeat.i(90441);
    this.akeP = new AtomicReference(parama);
    AppMethodBeat.o(90441);
  }
  
  public static a d(rx.b.a parama)
  {
    AppMethodBeat.i(90443);
    parama = new a(parama);
    AppMethodBeat.o(90443);
    return parama;
  }
  
  public static a kKV()
  {
    AppMethodBeat.i(90442);
    a locala = new a();
    AppMethodBeat.o(90442);
    return locala;
  }
  
  public final void kKh()
  {
    AppMethodBeat.i(90445);
    if ((rx.b.a)this.akeP.get() != akeQ)
    {
      rx.b.a locala = (rx.b.a)this.akeP.getAndSet(akeQ);
      if ((locala != null) && (locala != akeQ)) {
        locala.call();
      }
    }
    AppMethodBeat.o(90445);
  }
  
  public final boolean kKi()
  {
    AppMethodBeat.i(90444);
    if (this.akeP.get() == akeQ)
    {
      AppMethodBeat.o(90444);
      return true;
    }
    AppMethodBeat.o(90444);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     rx.f.a
 * JD-Core Version:    0.7.0.1
 */