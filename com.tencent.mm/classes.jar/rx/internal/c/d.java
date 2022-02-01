package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

public final class d
  implements j
{
  private static final ScheduledExecutorService[] Mei;
  private static final ScheduledExecutorService Mej;
  public static final d Mek;
  private static int Mem;
  private final AtomicReference<ScheduledExecutorService[]> Mel;
  
  static
  {
    AppMethodBeat.i(90373);
    Mei = new ScheduledExecutorService[0];
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(0);
    Mej = localScheduledExecutorService;
    localScheduledExecutorService.shutdown();
    Mek = new d();
    AppMethodBeat.o(90373);
  }
  
  private d()
  {
    AppMethodBeat.i(90369);
    this.Mel = new AtomicReference(Mei);
    start();
    AppMethodBeat.o(90369);
  }
  
  public static ScheduledExecutorService ggx()
  {
    AppMethodBeat.i(90372);
    Object localObject = (ScheduledExecutorService[])Mek.Mel.get();
    if (localObject == Mei)
    {
      localObject = Mej;
      AppMethodBeat.o(90372);
      return localObject;
    }
    int j = Mem + 1;
    int i = j;
    if (j >= localObject.length) {
      i = 0;
    }
    Mem = i;
    localObject = localObject[i];
    AppMethodBeat.o(90372);
    return localObject;
  }
  
  public final void shutdown()
  {
    AppMethodBeat.i(90371);
    ScheduledExecutorService[] arrayOfScheduledExecutorService;
    do
    {
      arrayOfScheduledExecutorService = (ScheduledExecutorService[])this.Mel.get();
      if (arrayOfScheduledExecutorService == Mei)
      {
        AppMethodBeat.o(90371);
        return;
      }
    } while (!this.Mel.compareAndSet(arrayOfScheduledExecutorService, Mei));
    int j = arrayOfScheduledExecutorService.length;
    int i = 0;
    while (i < j)
    {
      ScheduledExecutorService localScheduledExecutorService = arrayOfScheduledExecutorService[i];
      h.a(localScheduledExecutorService);
      localScheduledExecutorService.shutdownNow();
      i += 1;
    }
    AppMethodBeat.o(90371);
  }
  
  public final void start()
  {
    int j = 8;
    int k = 0;
    AppMethodBeat.i(90370);
    int m = Runtime.getRuntime().availableProcessors();
    int i = m;
    if (m > 4) {
      i = m / 2;
    }
    if (i > 8) {
      i = j;
    }
    for (;;)
    {
      ScheduledExecutorService[] arrayOfScheduledExecutorService = new ScheduledExecutorService[i];
      j = 0;
      while (j < i)
      {
        arrayOfScheduledExecutorService[j] = e.ggy();
        j += 1;
      }
      if (this.Mel.compareAndSet(Mei, arrayOfScheduledExecutorService))
      {
        j = arrayOfScheduledExecutorService.length;
        i = k;
        while (i < j)
        {
          ScheduledExecutorService localScheduledExecutorService = arrayOfScheduledExecutorService[i];
          if ((!h.b(localScheduledExecutorService)) && ((localScheduledExecutorService instanceof ScheduledThreadPoolExecutor))) {
            h.a((ScheduledThreadPoolExecutor)localScheduledExecutorService);
          }
          i += 1;
        }
        AppMethodBeat.o(90370);
        return;
      }
      j = arrayOfScheduledExecutorService.length;
      i = 0;
      while (i < j)
      {
        arrayOfScheduledExecutorService[i].shutdownNow();
        i += 1;
      }
      AppMethodBeat.o(90370);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     rx.internal.c.d
 * JD-Core Version:    0.7.0.1
 */