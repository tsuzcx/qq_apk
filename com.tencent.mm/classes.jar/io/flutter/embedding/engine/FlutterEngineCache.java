package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class FlutterEngineCache
{
  private static FlutterEngineCache instance;
  private final Map<String, FlutterEngine> cachedEngines;
  
  FlutterEngineCache()
  {
    AppMethodBeat.i(10117);
    this.cachedEngines = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static FlutterEngineCache getInstance()
  {
    AppMethodBeat.i(10116);
    if (instance == null) {
      instance = new FlutterEngineCache();
    }
    FlutterEngineCache localFlutterEngineCache = instance;
    AppMethodBeat.o(10116);
    return localFlutterEngineCache;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(190111);
    boolean bool = this.cachedEngines.containsKey(paramString);
    AppMethodBeat.o(190111);
    return bool;
  }
  
  public FlutterEngine get(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (FlutterEngine)this.cachedEngines.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public void put(String paramString, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190128);
    if (paramFlutterEngine != null)
    {
      this.cachedEngines.put(paramString, paramFlutterEngine);
      AppMethodBeat.o(190128);
      return;
    }
    this.cachedEngines.remove(paramString);
    AppMethodBeat.o(190128);
  }
  
  public void remove(String paramString)
  {
    AppMethodBeat.i(190140);
    put(paramString, null);
    AppMethodBeat.o(190140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineCache
 * JD-Core Version:    0.7.0.1
 */