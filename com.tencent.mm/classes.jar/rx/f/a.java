package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class a
  implements j
{
  static final rx.b.a ObR;
  final AtomicReference<rx.b.a> ObQ;
  
  static
  {
    AppMethodBeat.i(90446);
    ObR = new rx.b.a()
    {
      public final void call() {}
    };
    AppMethodBeat.o(90446);
  }
  
  public a()
  {
    AppMethodBeat.i(90440);
    this.ObQ = new AtomicReference();
    AppMethodBeat.o(90440);
  }
  
  private a(rx.b.a parama)
  {
    AppMethodBeat.i(90441);
    this.ObQ = new AtomicReference(parama);
    AppMethodBeat.o(90441);
  }
  
  public static a d(rx.b.a parama)
  {
    AppMethodBeat.i(90443);
    parama = new a(parama);
    AppMethodBeat.o(90443);
    return parama;
  }
  
  public static a gzA()
  {
    AppMethodBeat.i(90442);
    a locala = new a();
    AppMethodBeat.o(90442);
    return locala;
  }
  
  public final void gyQ()
  {
    AppMethodBeat.i(90445);
    if ((rx.b.a)this.ObQ.get() != ObR)
    {
      rx.b.a locala = (rx.b.a)this.ObQ.getAndSet(ObR);
      if ((locala != null) && (locala != ObR)) {
        locala.call();
      }
    }
    AppMethodBeat.o(90445);
  }
  
  public final boolean gyR()
  {
    AppMethodBeat.i(90444);
    if (this.ObQ.get() == ObR)
    {
      AppMethodBeat.o(90444);
      return true;
    }
    AppMethodBeat.o(90444);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.f.a
 * JD-Core Version:    0.7.0.1
 */