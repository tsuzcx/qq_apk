package io.flutter.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public class ImmediateExecutor
  implements Executor
{
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(189551);
    paramRunnable.run();
    AppMethodBeat.o(189551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.util.ImmediateExecutor
 * JD-Core Version:    0.7.0.1
 */