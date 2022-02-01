package io.flutter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;

public final class FlutterInjector
{
  private static boolean accessed;
  private static FlutterInjector instance;
  private DeferredComponentManager deferredComponentManager;
  private FlutterLoader flutterLoader;
  
  private FlutterInjector(FlutterLoader paramFlutterLoader, DeferredComponentManager paramDeferredComponentManager)
  {
    this.flutterLoader = paramFlutterLoader;
    this.deferredComponentManager = paramDeferredComponentManager;
  }
  
  public static FlutterInjector instance()
  {
    AppMethodBeat.i(189531);
    accessed = true;
    if (instance == null) {
      instance = new Builder().build();
    }
    FlutterInjector localFlutterInjector = instance;
    AppMethodBeat.o(189531);
    return localFlutterInjector;
  }
  
  public static void reset()
  {
    accessed = false;
    instance = null;
  }
  
  public static void setInstance(FlutterInjector paramFlutterInjector)
  {
    AppMethodBeat.i(189522);
    if (accessed)
    {
      paramFlutterInjector = new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
      AppMethodBeat.o(189522);
      throw paramFlutterInjector;
    }
    instance = paramFlutterInjector;
    AppMethodBeat.o(189522);
  }
  
  public final DeferredComponentManager deferredComponentManager()
  {
    return this.deferredComponentManager;
  }
  
  public final FlutterLoader flutterLoader()
  {
    return this.flutterLoader;
  }
  
  public static final class Builder
  {
    private DeferredComponentManager deferredComponentManager;
    private FlutterLoader flutterLoader;
    
    private void fillDefaults()
    {
      AppMethodBeat.i(189530);
      if (this.flutterLoader == null) {
        this.flutterLoader = new FlutterLoader();
      }
      AppMethodBeat.o(189530);
    }
    
    public final FlutterInjector build()
    {
      AppMethodBeat.i(189558);
      fillDefaults();
      FlutterInjector localFlutterInjector = new FlutterInjector(this.flutterLoader, this.deferredComponentManager, null);
      AppMethodBeat.o(189558);
      return localFlutterInjector;
    }
    
    public final Builder setDeferredComponentManager(DeferredComponentManager paramDeferredComponentManager)
    {
      this.deferredComponentManager = paramDeferredComponentManager;
      return this;
    }
    
    public final Builder setFlutterLoader(FlutterLoader paramFlutterLoader)
    {
      this.flutterLoader = paramFlutterLoader;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.FlutterInjector
 * JD-Core Version:    0.7.0.1
 */