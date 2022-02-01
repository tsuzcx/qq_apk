package io.flutter.view;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate;

public class VsyncWaiter
{
  private static VsyncWaiter instance;
  private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  private final WindowManager windowManager;
  
  private VsyncWaiter(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(9732);
    this.asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate()
    {
      public final void asyncWaitForVsync(final long paramAnonymousLong)
      {
        AppMethodBeat.i(9798);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback()
        {
          public final void doFrame(long paramAnonymous2Long)
          {
            AppMethodBeat.i(9684);
            FlutterJNI.nativeOnVsync(paramAnonymous2Long, paramAnonymous2Long + (1000000000.0D / VsyncWaiter.this.windowManager.getDefaultDisplay().getRefreshRate()), paramAnonymousLong);
            AppMethodBeat.o(9684);
          }
        });
        AppMethodBeat.o(9798);
      }
    };
    this.windowManager = paramWindowManager;
    AppMethodBeat.o(9732);
  }
  
  public static VsyncWaiter getInstance(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(9731);
    if (instance == null) {
      instance = new VsyncWaiter(paramWindowManager);
    }
    paramWindowManager = instance;
    AppMethodBeat.o(9731);
    return paramWindowManager;
  }
  
  public void init()
  {
    AppMethodBeat.i(9733);
    FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
    AppMethodBeat.o(9733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.VsyncWaiter
 * JD-Core Version:    0.7.0.1
 */