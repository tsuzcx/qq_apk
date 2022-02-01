package rx.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import rx.j;

public final class a
  implements j
{
  static final rx.b.a abRY;
  final AtomicReference<rx.b.a> abRX;
  
  static
  {
    AppMethodBeat.i(90446);
    abRY = new rx.b.a()
    {
      public final void call() {}
    };
    AppMethodBeat.o(90446);
  }
  
  public a()
  {
    AppMethodBeat.i(90440);
    this.abRX = new AtomicReference();
    AppMethodBeat.o(90440);
  }
  
  private a(rx.b.a parama)
  {
    AppMethodBeat.i(90441);
    this.abRX = new AtomicReference(parama);
    AppMethodBeat.o(90441);
  }
  
  public static a d(rx.b.a parama)
  {
    AppMethodBeat.i(90443);
    parama = new a(parama);
    AppMethodBeat.o(90443);
    return parama;
  }
  
  public static a iWu()
  {
    AppMethodBeat.i(90442);
    a locala = new a();
    AppMethodBeat.o(90442);
    return locala;
  }
  
  public final void iVJ()
  {
    AppMethodBeat.i(90445);
    if ((rx.b.a)this.abRX.get() != abRY)
    {
      rx.b.a locala = (rx.b.a)this.abRX.getAndSet(abRY);
      if ((locala != null) && (locala != abRY)) {
        locala.call();
      }
    }
    AppMethodBeat.o(90445);
  }
  
  public final boolean iVK()
  {
    AppMethodBeat.i(90444);
    if (this.abRX.get() == abRY)
    {
      AppMethodBeat.o(90444);
      return true;
    }
    AppMethodBeat.o(90444);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     rx.f.a
 * JD-Core Version:    0.7.0.1
 */