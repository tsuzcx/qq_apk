package d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Timer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"})
public final class b
{
  public static final Timer aPY(String paramString)
  {
    AppMethodBeat.i(129472);
    if (paramString == null)
    {
      paramString = new Timer(false);
      AppMethodBeat.o(129472);
      return paramString;
    }
    paramString = new Timer(paramString, false);
    AppMethodBeat.o(129472);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.c.b
 * JD-Core Version:    0.7.0.1
 */