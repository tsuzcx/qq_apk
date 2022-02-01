package io.flutter.plugins.pathprovider;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

class PathProviderPlugin$UiThreadExecutor
  implements Executor
{
  private final Handler handler;
  
  private PathProviderPlugin$UiThreadExecutor()
  {
    AppMethodBeat.i(189691);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(189691);
  }
  
  public void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(189706);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(189706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.plugins.pathprovider.PathProviderPlugin.UiThreadExecutor
 * JD-Core Version:    0.7.0.1
 */