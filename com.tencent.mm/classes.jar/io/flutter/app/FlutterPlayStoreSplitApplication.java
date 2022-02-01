package io.flutter.app;

import com.google.android.play.core.splitcompat.SplitCompatApplication;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.FlutterInjector.Builder;
import io.flutter.embedding.engine.deferredcomponents.PlayStoreDeferredComponentManager;

public class FlutterPlayStoreSplitApplication
  extends SplitCompatApplication
{
  public void onCreate()
  {
    AppMethodBeat.i(189575);
    super.onCreate();
    PlayStoreDeferredComponentManager localPlayStoreDeferredComponentManager = new PlayStoreDeferredComponentManager(this, null);
    FlutterInjector.setInstance(new FlutterInjector.Builder().setDeferredComponentManager(localPlayStoreDeferredComponentManager).build());
    AppMethodBeat.o(189575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.app.FlutterPlayStoreSplitApplication
 * JD-Core Version:    0.7.0.1
 */