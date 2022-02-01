package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import rx.b.d;
import rx.d.c;
import rx.internal.util.g;

 enum e
{
  static final g Owu;
  
  static
  {
    AppMethodBeat.i(90377);
    Owv = new e[0];
    Owu = new g("RxScheduledExecutorPool-");
    AppMethodBeat.o(90377);
  }
  
  public static ScheduledExecutorService gDE()
  {
    AppMethodBeat.i(90376);
    Object localObject = c.gDM();
    if (localObject == null)
    {
      localObject = Executors.newScheduledThreadPool(1, Owu);
      AppMethodBeat.o(90376);
      return localObject;
    }
    localObject = (ScheduledExecutorService)((d)localObject).call();
    AppMethodBeat.o(90376);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     rx.internal.c.e
 * JD-Core Version:    0.7.0.1
 */