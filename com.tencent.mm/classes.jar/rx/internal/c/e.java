package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.b.d;
import rx.d.c;
import rx.internal.util.g;

 enum e
{
  static final g Men;
  
  static
  {
    AppMethodBeat.i(90377);
    Meo = new e[0];
    Men = new g("RxScheduledExecutorPool-");
    AppMethodBeat.o(90377);
  }
  
  public static ScheduledExecutorService ggy()
  {
    AppMethodBeat.i(90376);
    Object localObject = c.ggG();
    if (localObject == null)
    {
      localObject = Executors.newScheduledThreadPool(1, Men);
      AppMethodBeat.o(90376);
      return localObject;
    }
    localObject = (ScheduledExecutorService)((d)localObject).call();
    AppMethodBeat.o(90376);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.e
 * JD-Core Version:    0.7.0.1
 */