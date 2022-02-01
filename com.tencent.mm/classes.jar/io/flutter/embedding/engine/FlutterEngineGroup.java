package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import java.util.ArrayList;
import java.util.List;

public class FlutterEngineGroup
{
  final List<FlutterEngine> activeEngines;
  
  public FlutterEngineGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterEngineGroup(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(189970);
    this.activeEngines = new ArrayList();
    FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
    if (!localFlutterLoader.initialized())
    {
      localFlutterLoader.startInitialization(paramContext.getApplicationContext());
      localFlutterLoader.ensureInitializationComplete(paramContext, paramArrayOfString);
    }
    AppMethodBeat.o(189970);
  }
  
  public FlutterEngine createAndRunDefaultEngine(Context paramContext)
  {
    AppMethodBeat.i(189977);
    paramContext = createAndRunEngine(paramContext, null);
    AppMethodBeat.o(189977);
    return paramContext;
  }
  
  public FlutterEngine createAndRunEngine(Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint)
  {
    AppMethodBeat.i(189987);
    paramContext = createAndRunEngine(paramContext, paramDartEntrypoint, null);
    AppMethodBeat.o(189987);
    return paramContext;
  }
  
  public FlutterEngine createAndRunEngine(final Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint, String paramString)
  {
    AppMethodBeat.i(189999);
    DartExecutor.DartEntrypoint localDartEntrypoint = paramDartEntrypoint;
    if (paramDartEntrypoint == null) {
      localDartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
    }
    if (this.activeEngines.size() == 0)
    {
      paramContext = createEngine(paramContext);
      if (paramString != null) {
        paramContext.getNavigationChannel().setInitialRoute(paramString);
      }
      paramContext.getDartExecutor().executeDartEntrypoint(localDartEntrypoint);
    }
    for (;;)
    {
      this.activeEngines.add(paramContext);
      paramContext.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener()
      {
        public void onEngineWillDestroy()
        {
          AppMethodBeat.i(189995);
          FlutterEngineGroup.this.activeEngines.remove(paramContext);
          AppMethodBeat.o(189995);
        }
        
        public void onPreEngineRestart() {}
      });
      AppMethodBeat.o(189999);
      return paramContext;
      paramContext = ((FlutterEngine)this.activeEngines.get(0)).spawn(paramContext, localDartEntrypoint, paramString);
    }
  }
  
  FlutterEngine createEngine(Context paramContext)
  {
    AppMethodBeat.i(190009);
    paramContext = new FlutterEngine(paramContext);
    AppMethodBeat.o(190009);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineGroup
 * JD-Core Version:    0.7.0.1
 */