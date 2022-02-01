package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import java.util.ArrayList;
import java.util.List;

public class WxaFlutterEngineGroup
{
  final List<FlutterEngine> activeEngines;
  
  public WxaFlutterEngineGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WxaFlutterEngineGroup(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(190018);
    this.activeEngines = new ArrayList();
    FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
    if (!localFlutterLoader.initialized())
    {
      localFlutterLoader.startInitialization(paramContext.getApplicationContext());
      localFlutterLoader.ensureInitializationComplete(paramContext, paramArrayOfString);
    }
    AppMethodBeat.o(190018);
  }
  
  public FlutterEngine createAndRunDefaultEngine(Context paramContext)
  {
    AppMethodBeat.i(190025);
    paramContext = createAndRunEngine(paramContext, null);
    AppMethodBeat.o(190025);
    return paramContext;
  }
  
  public FlutterEngine createAndRunEngine(Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint)
  {
    AppMethodBeat.i(190031);
    paramContext = createAndRunEngine(paramContext, paramDartEntrypoint, null);
    AppMethodBeat.o(190031);
    return paramContext;
  }
  
  public FlutterEngine createAndRunEngine(final Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint, String paramString)
  {
    AppMethodBeat.i(190036);
    DartExecutor.DartEntrypoint localDartEntrypoint = paramDartEntrypoint;
    if (paramDartEntrypoint == null) {
      localDartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
    }
    if (this.activeEngines.size() == 0)
    {
      paramDartEntrypoint = createEngine(paramContext);
      paramContext = paramDartEntrypoint;
      if (paramString != null) {
        paramDartEntrypoint.getNavigationChannel().setInitialRoute(paramString);
      }
    }
    for (paramContext = paramDartEntrypoint;; paramContext = ((FlutterEngine)this.activeEngines.get(0)).spawn(paramContext, localDartEntrypoint, paramString))
    {
      this.activeEngines.add(paramContext);
      paramContext.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener()
      {
        public void onEngineWillDestroy()
        {
          AppMethodBeat.i(190000);
          WxaFlutterEngineGroup.this.activeEngines.remove(paramContext);
          AppMethodBeat.o(190000);
        }
        
        public void onPreEngineRestart() {}
      });
      AppMethodBeat.o(190036);
      return paramContext;
    }
  }
  
  FlutterEngine createEngine(Context paramContext)
  {
    AppMethodBeat.i(190043);
    paramContext = new FlutterEngine(paramContext, new String[0]);
    AppMethodBeat.o(190043);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.WxaFlutterEngineGroup
 * JD-Core Version:    0.7.0.1
 */