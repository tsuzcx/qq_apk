package kotlin.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class b
{
  public static final Timer bIw(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.c.b
 * JD-Core Version:    0.7.0.1
 */