package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SkiaChannel;
import io.flutter.embedding.engine.systemchannels.StatChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public class FlutterEngine
{
  private static final String TAG = "FlutterEngine";
  private final AccessibilityChannel accessibilityChannel;
  private final DartExecutor dartExecutor;
  private final DeferredComponentChannel deferredComponentChannel;
  private final EngineLifecycleListener engineLifecycleListener;
  private final Set<EngineLifecycleListener> engineLifecycleListeners;
  private final FlutterJNI flutterJNI;
  private final KeyEventChannel keyEventChannel;
  private final LifecycleChannel lifecycleChannel;
  private final LocalizationChannel localizationChannel;
  private final LocalizationPlugin localizationPlugin;
  private final MouseCursorChannel mouseCursorChannel;
  private final NavigationChannel navigationChannel;
  private final PlatformChannel platformChannel;
  private final PlatformViewsController platformViewsController;
  private final FlutterEngineConnectionRegistry pluginRegistry;
  private final FlutterRenderer renderer;
  private final RestorationChannel restorationChannel;
  private final SettingsChannel settingsChannel;
  private final SkiaChannel skiaChannel;
  private final StatChannel statChannel;
  private final SystemChannel systemChannel;
  private final TextInputChannel textInputChannel;
  
  public FlutterEngine(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(10180);
    AppMethodBeat.o(10180);
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, null, true);
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, paramPlatformViewsController, paramArrayOfString, paramBoolean, false);
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI, PlatformViewsController paramPlatformViewsController, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190089);
    this.engineLifecycleListeners = new HashSet();
    this.engineLifecycleListener = new EngineLifecycleListener()
    {
      public void onEngineWillDestroy() {}
      
      public void onPreEngineRestart()
      {
        AppMethodBeat.i(10115);
        Log.v("FlutterEngine", "onPreEngineRestart()");
        Iterator localIterator = FlutterEngine.this.engineLifecycleListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterEngine.EngineLifecycleListener)localIterator.next()).onPreEngineRestart();
        }
        FlutterEngine.this.platformViewsController.onPreEngineRestart();
        FlutterEngine.this.restorationChannel.clearData();
        AppMethodBeat.o(10115);
      }
    };
    try
    {
      Object localObject = paramContext.createPackageContext(paramContext.getPackageName(), 0).getAssets();
      this.dartExecutor = new DartExecutor(paramFlutterJNI, (AssetManager)localObject);
      this.dartExecutor.onAttachedToJNI();
      localObject = FlutterInjector.instance().deferredComponentManager();
      this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, paramFlutterJNI);
      this.deferredComponentChannel = new DeferredComponentChannel(this.dartExecutor);
      this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
      this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
      this.localizationChannel = new LocalizationChannel(this.dartExecutor);
      this.mouseCursorChannel = new MouseCursorChannel(this.dartExecutor);
      this.navigationChannel = new NavigationChannel(this.dartExecutor);
      this.platformChannel = new PlatformChannel(this.dartExecutor);
      this.restorationChannel = new RestorationChannel(this.dartExecutor, paramBoolean2);
      this.settingsChannel = new SettingsChannel(this.dartExecutor);
      this.systemChannel = new SystemChannel(this.dartExecutor);
      this.textInputChannel = new TextInputChannel(this.dartExecutor);
      this.skiaChannel = new SkiaChannel(this.dartExecutor);
      this.statChannel = new StatChannel(this.dartExecutor);
      if (localObject != null) {
        ((DeferredComponentManager)localObject).setDeferredComponentChannel(this.deferredComponentChannel);
      }
      this.localizationPlugin = new LocalizationPlugin(paramContext, this.localizationChannel);
      this.flutterJNI = paramFlutterJNI;
      localObject = paramFlutterLoader;
      if (paramFlutterLoader == null) {
        localObject = FlutterInjector.instance().flutterLoader();
      }
      if (!paramFlutterJNI.isAttached())
      {
        ((FlutterLoader)localObject).startInitialization(paramContext.getApplicationContext());
        ((FlutterLoader)localObject).ensureInitializationComplete(paramContext, paramArrayOfString);
      }
      paramFlutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
      paramFlutterJNI.setPlatformViewsController(paramPlatformViewsController);
      paramFlutterJNI.setLocalizationPlugin(this.localizationPlugin);
      paramFlutterJNI.setDeferredComponentManager(FlutterInjector.instance().deferredComponentManager());
      if (!paramFlutterJNI.isAttached()) {
        attachToJni();
      }
      this.renderer = new FlutterRenderer(paramFlutterJNI);
      this.platformViewsController = paramPlatformViewsController;
      this.platformViewsController.onAttachedToJNI();
      this.pluginRegistry = new FlutterEngineConnectionRegistry(paramContext.getApplicationContext(), this, (FlutterLoader)localObject);
      if (paramBoolean1) {
        registerPlugins();
      }
      AppMethodBeat.o(190089);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        AssetManager localAssetManager = paramContext.getAssets();
      }
    }
  }
  
  public FlutterEngine(Context paramContext, FlutterLoader paramFlutterLoader, FlutterJNI paramFlutterJNI, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, new PlatformViewsController(), paramArrayOfString, paramBoolean);
    AppMethodBeat.i(190071);
    AppMethodBeat.o(190071);
  }
  
  public FlutterEngine(Context paramContext, String[] paramArrayOfString)
  {
    this(paramContext, null, new FlutterJNI(), paramArrayOfString, true);
    AppMethodBeat.i(190048);
    AppMethodBeat.o(190048);
  }
  
  public FlutterEngine(Context paramContext, String[] paramArrayOfString, boolean paramBoolean)
  {
    this(paramContext, null, new FlutterJNI(), paramArrayOfString, paramBoolean);
    AppMethodBeat.i(190054);
    AppMethodBeat.o(190054);
  }
  
  public FlutterEngine(Context paramContext, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, null, new FlutterJNI(), new PlatformViewsController(), paramArrayOfString, paramBoolean1, paramBoolean2);
    AppMethodBeat.i(190059);
    AppMethodBeat.o(190059);
  }
  
  private void attachToJni()
  {
    AppMethodBeat.i(190098);
    Log.v("FlutterEngine", "Attaching to JNI.");
    this.flutterJNI.attachToNative(false);
    if (!isAttachedToJni())
    {
      RuntimeException localRuntimeException = new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
      AppMethodBeat.o(190098);
      throw localRuntimeException;
    }
    AppMethodBeat.o(190098);
  }
  
  private boolean isAttachedToJni()
  {
    AppMethodBeat.i(190104);
    boolean bool = this.flutterJNI.isAttached();
    AppMethodBeat.o(190104);
    return bool;
  }
  
  private void registerPlugins()
  {
    AppMethodBeat.i(190114);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { this });
      AppMethodBeat.o(190114);
      return;
    }
    catch (Exception localException)
    {
      Log.w("FlutterEngine", "Tried to automatically register plugins with FlutterEngine (" + this + ") but could not find and invoke the GeneratedPluginRegistrant.");
      AppMethodBeat.o(190114);
    }
  }
  
  public void addDataReportListener(EngineDataReportListener paramEngineDataReportListener)
  {
    AppMethodBeat.i(190198);
    this.flutterJNI.addDataReportListener(paramEngineDataReportListener);
    AppMethodBeat.o(190198);
  }
  
  public void addEngineLifecycleListener(EngineLifecycleListener paramEngineLifecycleListener)
  {
    AppMethodBeat.i(190181);
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
    AppMethodBeat.o(190181);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(10181);
    Log.v("FlutterEngine", "Destroying.");
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((EngineLifecycleListener)localIterator.next()).onEngineWillDestroy();
    }
    this.pluginRegistry.destroy();
    this.platformViewsController.onDetachedFromJNI();
    this.dartExecutor.onDetachedFromJNI();
    this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
    this.flutterJNI.setDeferredComponentManager(null);
    this.flutterJNI.detachFromNativeAndReleaseResources();
    if (FlutterInjector.instance().deferredComponentManager() != null)
    {
      FlutterInjector.instance().deferredComponentManager().destroy();
      this.deferredComponentChannel.setDeferredComponentManager(null);
    }
    AppMethodBeat.o(10181);
  }
  
  public AccessibilityChannel getAccessibilityChannel()
  {
    return this.accessibilityChannel;
  }
  
  public ActivityControlSurface getActivityControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public ContentProviderControlSurface getContentProviderControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  public DeferredComponentChannel getDeferredComponentChannel()
  {
    return this.deferredComponentChannel;
  }
  
  public KeyEventChannel getKeyEventChannel()
  {
    return this.keyEventChannel;
  }
  
  public LifecycleChannel getLifecycleChannel()
  {
    return this.lifecycleChannel;
  }
  
  public LocalizationChannel getLocalizationChannel()
  {
    return this.localizationChannel;
  }
  
  public LocalizationPlugin getLocalizationPlugin()
  {
    return this.localizationPlugin;
  }
  
  public MouseCursorChannel getMouseCursorChannel()
  {
    return this.mouseCursorChannel;
  }
  
  public NavigationChannel getNavigationChannel()
  {
    return this.navigationChannel;
  }
  
  public PlatformChannel getPlatformChannel()
  {
    return this.platformChannel;
  }
  
  public PlatformViewsController getPlatformViewsController()
  {
    return this.platformViewsController;
  }
  
  public PluginRegistry getPlugins()
  {
    return this.pluginRegistry;
  }
  
  public FlutterRenderer getRenderer()
  {
    return this.renderer;
  }
  
  public RestorationChannel getRestorationChannel()
  {
    return this.restorationChannel;
  }
  
  public ServiceControlSurface getServiceControlSurface()
  {
    return this.pluginRegistry;
  }
  
  public SettingsChannel getSettingsChannel()
  {
    return this.settingsChannel;
  }
  
  public SkiaChannel getSkiaChannel()
  {
    return this.skiaChannel;
  }
  
  public StatChannel getStatChannel()
  {
    return this.statChannel;
  }
  
  public SystemChannel getSystemChannel()
  {
    return this.systemChannel;
  }
  
  public TextInputChannel getTextInputChannel()
  {
    return this.textInputChannel;
  }
  
  public void removeDataReportListener(EngineDataReportListener paramEngineDataReportListener)
  {
    AppMethodBeat.i(190213);
    this.flutterJNI.removeDataReportListener(paramEngineDataReportListener);
    AppMethodBeat.o(190213);
  }
  
  public void removeEngineLifecycleListener(EngineLifecycleListener paramEngineLifecycleListener)
  {
    AppMethodBeat.i(190186);
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
    AppMethodBeat.o(190186);
  }
  
  public void setBackgroundExecutor(Executor paramExecutor)
  {
    AppMethodBeat.i(190165);
    this.renderer.setBackgroundExecutor(paramExecutor);
    this.flutterJNI.setBackgroundExecutor(paramExecutor);
    AppMethodBeat.o(190165);
  }
  
  FlutterEngine spawn(Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint, String paramString)
  {
    AppMethodBeat.i(190158);
    if (!isAttachedToJni())
    {
      paramContext = new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
      AppMethodBeat.o(190158);
      throw paramContext;
    }
    paramContext = new FlutterEngine(paramContext, null, this.flutterJNI.spawn(paramDartEntrypoint.dartEntrypointFunctionName, paramDartEntrypoint.dartEntrypointLibrary, paramString));
    AppMethodBeat.o(190158);
    return paramContext;
  }
  
  public static abstract interface EngineLifecycleListener
  {
    public abstract void onEngineWillDestroy();
    
    public abstract void onPreEngineRestart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngine
 * JD-Core Version:    0.7.0.1
 */