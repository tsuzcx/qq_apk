package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.b.d;
import rx.d.c;
import rx.internal.util.g;

 enum e
{
  static final g KqE;
  
  static
  {
    AppMethodBeat.i(90377);
    KqF = new e[0];
    KqE = new g("RxScheduledExecutorPool-");
    AppMethodBeat.o(90377);
  }
  
  public static ScheduledExecutorService fNI()
  {
    AppMethodBeat.i(90376);
    Object localObject = c.fNQ();
    if (localObject == null)
    {
      localObject = Executors.newScheduledThreadPool(1, KqE);
      AppMethodBeat.o(90376);
      return localObject;
    }
    localObject = (ScheduledExecutorService)((d)localObject).call();
    AppMethodBeat.o(90376);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     rx.internal.c.e
 * JD-Core Version:    0.7.0.1
 */