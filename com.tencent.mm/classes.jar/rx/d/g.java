package rx.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.c.b;

public class g
{
  private static final g Obr;
  
  static
  {
    AppMethodBeat.i(90499);
    Obr = new g();
    AppMethodBeat.o(90499);
  }
  
  @Deprecated
  public static rx.b.a c(rx.b.a parama)
  {
    return parama;
  }
  
  public static rx.g gzs()
  {
    AppMethodBeat.i(90496);
    b localb = new b(new rx.internal.util.g("RxComputationScheduler-"));
    AppMethodBeat.o(90496);
    return localb;
  }
  
  public static rx.g gzt()
  {
    AppMethodBeat.i(90497);
    rx.internal.c.a locala = new rx.internal.c.a(new rx.internal.util.g("RxIoScheduler-"));
    AppMethodBeat.o(90497);
    return locala;
  }
  
  public static rx.g gzu()
  {
    AppMethodBeat.i(90498);
    rx.internal.c.g localg = new rx.internal.c.g(new rx.internal.util.g("RxNewThreadScheduler-"));
    AppMethodBeat.o(90498);
    return localg;
  }
  
  public static g gzv()
  {
    return Obr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.d.g
 * JD-Core Version:    0.7.0.1
 */