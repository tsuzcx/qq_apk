package com.tencent.skyline;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.skyline.jni.INativeHandler;
import com.tencent.skyline.jni.NativeHandler;
import com.tencent.skyline.jni.SkylineLibraryLoader;
import io.flutter.FlutterInjector;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterImageView.SurfaceKind;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.SkylinePlatformViewsController;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/SkylineLogic;", "", "()V", "SKYLINE_INIT_NAME", "", "SKYLINE_NAME", "TAG", "TYPE_IMAGE", "", "TYPE_SURFACE", "TYPE_TEXTURE", "activeEngines", "Ljava/util/HashMap;", "Lcom/tencent/skyline/FlutterEngineAddon;", "Lkotlin/collections/HashMap;", "firstEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "firstId", "isInit", "", "routeDoneCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/skyline/IRouteDoneCallback;", "sDoneCallbackMap", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "sDoneId", "sFlutterJNI", "Lio/flutter/embedding/engine/FlutterJNI;", "sFlutterUiDisplayListener", "com/tencent/skyline/SkylineLogic$sFlutterUiDisplayListener$1", "Lcom/tencent/skyline/SkylineLogic$sFlutterUiDisplayListener$1;", "taskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "appIsDetached", "flutterEngineId", "appIsInactive", "appIsPaused", "appIsResumed", "appLaunch", "id", "pageId", "attachFlutterEngine", "flutterView", "Lio/flutter/embedding/android/FlutterView;", "autoReLaunch", "createDartEntryPoint", "Lio/flutter/embedding/engine/dart/DartExecutor$DartEntrypoint;", "createFlutterEngine", "context", "Landroid/content/Context;", "config", "Lcom/tencent/skyline/SkylineConfig;", "createFlutterView", "width", "height", "type", "destroyFlutterEngine", "detachFlutterView", "init", "initJSEngine", "initJsEngine", "isolatePtr", "", "contextPtr", "initLibrary", "initNativeHandler", "iNativeHandler", "Lcom/tencent/skyline/jni/INativeHandler;", "nativeAppLaunch", "nativeAutoReLaunch", "nativeInit", "nativeInitJsEngine", "nativeNavigateBack", "delta", "animate", "nativeNavigateTo", "nativeNotifyJsEngineDone", "nativeReLaunch", "nativeRedirectTo", "nativeSwitchTab", "navigateBack", "callback", "navigateTo", "notifyRouteDone", "obtainBitmap", "Landroid/graphics/Bitmap;", "obtainRenderer", "Lio/flutter/embedding/engine/renderer/FlutterRenderer;", "reLaunch", "redirectTo", "spawnExport", "flutterJNI", "dartEntrypoint", "switchTab", "updateViewport", "windowWidth", "", "windowHeight", "waitForDone", "block", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylineLogic
{
  public static final SkylineLogic INSTANCE;
  private static final String SKYLINE_INIT_NAME = "Skyline_Invoke_MethodChannel";
  private static final String SKYLINE_NAME = "Skyline_MethodChannel";
  private static final String TAG = "SkylineLogic";
  public static final int TYPE_IMAGE = 3;
  public static final int TYPE_SURFACE = 2;
  public static final int TYPE_TEXTURE = 1;
  private static HashMap<Integer, FlutterEngineAddon> activeEngines;
  private static FlutterEngine firstEngine;
  private static int firstId;
  private static boolean isInit;
  private static ConcurrentHashMap<Integer, IRouteDoneCallback> routeDoneCallbacks;
  private static HashMap<Integer, ArrayList<a<ah>>> sDoneCallbackMap;
  private static ArrayList<Integer> sDoneId;
  private static FlutterJNI sFlutterJNI;
  private static final sFlutterUiDisplayListener.1 sFlutterUiDisplayListener;
  private static AtomicInteger taskId;
  
  static
  {
    AppMethodBeat.i(210760);
    INSTANCE = new SkylineLogic();
    sDoneId = new ArrayList();
    sDoneCallbackMap = new HashMap();
    sFlutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public final void onFlutterUiDisplayed() {}
      
      public final void onFlutterUiNoLongerDisplayed() {}
    };
    routeDoneCallbacks = new ConcurrentHashMap();
    taskId = new AtomicInteger();
    AppMethodBeat.o(210760);
  }
  
  private final DartExecutor.DartEntrypoint createDartEntryPoint()
  {
    AppMethodBeat.i(210710);
    Object localObject = FlutterInjector.instance().flutterLoader().findAppBundlePath();
    s.r(localObject, "FlutterInjector.instance…der().findAppBundlePath()");
    localObject = new DartExecutor.DartEntrypoint((String)localObject, "mainForSkyline");
    AppMethodBeat.o(210710);
    return localObject;
  }
  
  private final FlutterEngine createFlutterEngine(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(210695);
    FlutterJNI localFlutterJNI = sFlutterJNI;
    if (localFlutterJNI == null) {
      s.bIx("sFlutterJNI");
    }
    paramContext = new FlutterEngine(paramContext, null, localFlutterJNI, (PlatformViewsController)new SkylinePlatformViewsController(), null, true);
    AppMethodBeat.o(210695);
    return paramContext;
  }
  
  private final void initLibrary()
  {
    AppMethodBeat.i(210687);
    SkylineLibraryLoader.beforeLoad();
    SkylineLibraryLoader.load("skyline");
    SkylineLibraryLoader.afterLoad();
    AppMethodBeat.o(210687);
  }
  
  private final native void nativeAppLaunch(int paramInt1, int paramInt2);
  
  private final native void nativeAutoReLaunch(int paramInt1, int paramInt2);
  
  private final native void nativeInit();
  
  private final native void nativeInitJsEngine(long paramLong1, long paramLong2);
  
  private final native int nativeNavigateBack(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4);
  
  private final native void nativeNavigateTo(int paramInt1, int paramInt2, int paramInt3);
  
  private final native void nativeNotifyJsEngineDone(long paramLong1, long paramLong2);
  
  private final native void nativeReLaunch(int paramInt1, int paramInt2);
  
  private final native void nativeRedirectTo(int paramInt1, int paramInt2, int paramInt3);
  
  private final native void nativeSwitchTab(int paramInt1, int paramInt2);
  
  private final FlutterEngine spawnExport(Context paramContext, FlutterJNI paramFlutterJNI, DartExecutor.DartEntrypoint paramDartEntrypoint)
  {
    AppMethodBeat.i(210702);
    if (!paramFlutterJNI.isAttached())
    {
      paramContext = (Throwable)new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine".toString());
      AppMethodBeat.o(210702);
      throw paramContext;
    }
    paramFlutterJNI = paramFlutterJNI.spawn(paramDartEntrypoint.dartEntrypointFunctionName, paramDartEntrypoint.dartEntrypointLibrary, "");
    s.r(paramFlutterJNI, "flutterJNI.spawn(\n      …artEntrypointLibrary, \"\")");
    paramContext = new FlutterEngine(paramContext, null, paramFlutterJNI, (PlatformViewsController)new SkylinePlatformViewsController(), null, true);
    AppMethodBeat.o(210702);
    return paramContext;
  }
  
  public final void appIsDetached(int paramInt)
  {
    AppMethodBeat.i(210894);
    Object localObject = activeEngines;
    if (localObject != null) {}
    for (localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt)); localObject == null; localObject = null)
    {
      AppMethodBeat.o(210894);
      return;
    }
    ((FlutterEngineAddon)localObject).getFlutterEngine().getLifecycleChannel().appIsDetached();
    AppMethodBeat.o(210894);
  }
  
  public final void appIsInactive(int paramInt)
  {
    AppMethodBeat.i(210885);
    Object localObject = activeEngines;
    if (localObject != null) {}
    for (localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt)); localObject == null; localObject = null)
    {
      AppMethodBeat.o(210885);
      return;
    }
    ((FlutterEngineAddon)localObject).getFlutterEngine().getLifecycleChannel().appIsInactive();
    AppMethodBeat.o(210885);
  }
  
  public final void appIsPaused(int paramInt)
  {
    AppMethodBeat.i(210889);
    Object localObject = activeEngines;
    if (localObject != null) {}
    for (localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt)); localObject == null; localObject = null)
    {
      AppMethodBeat.o(210889);
      return;
    }
    ((FlutterEngineAddon)localObject).getFlutterEngine().getLifecycleChannel().appIsPaused();
    AppMethodBeat.o(210889);
  }
  
  public final void appIsResumed(int paramInt)
  {
    AppMethodBeat.i(210881);
    Object localObject = activeEngines;
    if (localObject != null) {}
    for (localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt)); localObject == null; localObject = null)
    {
      AppMethodBeat.o(210881);
      return;
    }
    ((FlutterEngineAddon)localObject).getFlutterEngine().getLifecycleChannel().appIsResumed();
    AppMethodBeat.o(210881);
  }
  
  public final void appLaunch(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210941);
    nativeAppLaunch(paramInt1, paramInt2);
    AppMethodBeat.o(210941);
  }
  
  public final void attachFlutterEngine(int paramInt, FlutterView paramFlutterView)
  {
    AppMethodBeat.i(210876);
    s.t(paramFlutterView, "flutterView");
    Object localObject = activeEngines;
    if (localObject != null) {}
    for (localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt)); localObject == null; localObject = null)
    {
      AppMethodBeat.o(210876);
      return;
    }
    paramFlutterView.attachToFlutterEngine(((FlutterEngineAddon)localObject).getFlutterEngine());
    paramFlutterView.addOnFirstFrameRenderedListener((FlutterUiDisplayListener)sFlutterUiDisplayListener);
    AppMethodBeat.o(210876);
  }
  
  public final void autoReLaunch(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210944);
    nativeAutoReLaunch(paramInt1, paramInt2);
    AppMethodBeat.o(210944);
  }
  
  public final boolean createFlutterEngine(Context paramContext, SkylineConfig paramSkylineConfig)
  {
    AppMethodBeat.i(210863);
    s.t(paramContext, "context");
    s.t(paramSkylineConfig, "config");
    int i = paramSkylineConfig.getId();
    Object localObject1 = activeEngines;
    if (localObject1 == null) {
      s.klw();
    }
    if (((HashMap)localObject1).isEmpty())
    {
      localObject1 = createFlutterEngine(paramContext, i);
      ((FlutterEngine)localObject1).getDartExecutor().executeDartEntrypoint(createDartEntryPoint());
      firstEngine = (FlutterEngine)localObject1;
      firstId = i;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(210863);
      return false;
      localObject1 = sFlutterJNI;
      if (localObject1 == null) {
        s.bIx("sFlutterJNI");
      }
      if (localObject1 == null) {
        s.klw();
      }
      localObject1 = spawnExport(paramContext, (FlutterJNI)localObject1, createDartEntryPoint());
    }
    Object localObject2 = activeEngines;
    if (localObject2 == null) {
      s.klw();
    }
    if (((HashMap)localObject2).containsKey(Integer.valueOf(i)))
    {
      AppMethodBeat.o(210863);
      return true;
    }
    localObject2 = ((FlutterEngine)localObject1).getDartExecutor();
    s.r(localObject2, "engine.dartExecutor");
    localObject2 = new MethodChannel(((DartExecutor)localObject2).getBinaryMessenger(), "Skyline_MethodChannel");
    Object localObject3 = ((FlutterEngine)localObject1).getDartExecutor();
    s.r(localObject3, "engine.dartExecutor");
    localObject3 = new MethodChannel(((DartExecutor)localObject3).getBinaryMessenger(), "Skyline_Invoke_MethodChannel");
    HashMap localHashMap = activeEngines;
    if (localHashMap == null) {
      s.klw();
    }
    ((Map)localHashMap).put(Integer.valueOf(i), new FlutterEngineAddon((FlutterEngine)localObject1, (MethodChannel)localObject3));
    ((FlutterEngine)localObject1).addEngineLifecycleListener((FlutterEngine.EngineLifecycleListener)new FlutterEngine.EngineLifecycleListener()
    {
      public final void onEngineWillDestroy()
      {
        AppMethodBeat.i(210680);
        new StringBuilder("onEngineWillDestroy id:").append(this.$id);
        if (this.$id == SkylineLogic.access$getFirstId$p(SkylineLogic.INSTANCE))
        {
          SkylineLogic.access$setFirstEngine$p(SkylineLogic.INSTANCE, null);
          SkylineLogic.access$setFirstId$p(SkylineLogic.INSTANCE, -1);
        }
        HashMap localHashMap = SkylineLogic.access$getActiveEngines$p(SkylineLogic.INSTANCE);
        if (localHashMap == null) {
          s.klw();
        }
        localHashMap.remove(Integer.valueOf(this.$id));
        SkylineLogic.access$getSDoneId$p(SkylineLogic.INSTANCE).remove(Integer.valueOf(this.$id));
        AppMethodBeat.o(210680);
      }
      
      public final void onPreEngineRestart() {}
    });
    ((MethodChannel)localObject2).setMethodCallHandler((MethodChannel.MethodCallHandler)createFlutterEngine.2.INSTANCE);
    ((MethodChannel)localObject3).invokeMethod("init", paramSkylineConfig.toMap());
    ((FlutterEngine)localObject1).getPlatformViewsController().attach(paramContext, (TextureRegistry)((FlutterEngine)localObject1).getRenderer(), ((FlutterEngine)localObject1).getDartExecutor());
    AppMethodBeat.o(210863);
    return true;
  }
  
  public final FlutterView createFlutterView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(210869);
    s.t(paramContext, "context");
    switch (paramInt3)
    {
    default: 
      paramContext = new FlutterView(paramContext, new FlutterTextureView(paramContext));
      AppMethodBeat.o(210869);
      return paramContext;
    case 1: 
      paramContext = new FlutterView(paramContext, new FlutterTextureView(paramContext));
      AppMethodBeat.o(210869);
      return paramContext;
    case 2: 
      paramContext = new FlutterView(paramContext, new FlutterSurfaceView(paramContext));
      AppMethodBeat.o(210869);
      return paramContext;
    }
    paramContext = new FlutterView(paramContext, new FlutterImageView(paramContext, paramInt1, paramInt2, FlutterImageView.SurfaceKind.background));
    AppMethodBeat.o(210869);
    return paramContext;
  }
  
  public final void destroyFlutterEngine(int paramInt)
  {
    AppMethodBeat.i(210901);
    Object localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((FlutterEngineAddon)localObject).getInvokeMethodChannel();
      if (localObject != null) {
        ((MethodChannel)localObject).invokeMethod("exit", new HashMap());
      }
    }
    localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((FlutterEngineAddon)localObject).getFlutterEngine();
      if (localObject != null) {
        ((FlutterEngine)localObject).destroy();
      }
    }
    localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    ((HashMap)localObject).remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(210901);
  }
  
  public final void detachFlutterView(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(210897);
    s.t(paramFlutterView, "flutterView");
    paramFlutterView.detachFromFlutterEngine();
    paramFlutterView.removeOnFirstFrameRenderedListener((FlutterUiDisplayListener)sFlutterUiDisplayListener);
    AppMethodBeat.o(210897);
  }
  
  public final void init(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(210830);
      s.t(paramContext, "context");
      if (!isInit)
      {
        isInit = true;
        sFlutterJNI = new FlutterJNI();
        initLibrary();
        nativeInit();
        NativeHandler.init();
        activeEngines = new HashMap();
        FlutterLoader localFlutterLoader = FlutterInjector.instance().flutterLoader();
        s.r(localFlutterLoader, "FlutterInjector.instance().flutterLoader()");
        if (!localFlutterLoader.initialized())
        {
          localFlutterLoader.startInitialization(paramContext.getApplicationContext());
          localFlutterLoader.ensureInitializationComplete(paramContext, null);
        }
      }
      AppMethodBeat.o(210830);
      return;
    }
    finally {}
  }
  
  public final void initJSEngine()
  {
    AppMethodBeat.i(210907);
    SkylineJSEngineFactory.INSTANCE.createJSEngine((ISkylineJSEngineCallback)new ISkylineJSEngineCallback()
    {
      public final void onDone(boolean paramAnonymousBoolean, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(210673);
        new StringBuilder("onDone isOk:").append(paramAnonymousBoolean).append(", isolatePtr:").append(paramAnonymousLong1).append(", contextPtr:").append(paramAnonymousLong2);
        if (paramAnonymousBoolean) {
          SkylineLogic.access$nativeNotifyJsEngineDone(SkylineLogic.INSTANCE, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(210673);
      }
    });
    AppMethodBeat.o(210907);
  }
  
  public final void initJsEngine(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210844);
    nativeInitJsEngine(paramLong1, paramLong2);
    AppMethodBeat.o(210844);
  }
  
  public final void initNativeHandler(INativeHandler paramINativeHandler)
  {
    AppMethodBeat.i(210836);
    s.t(paramINativeHandler, "iNativeHandler");
    NativeHandler.instance().init(paramINativeHandler);
    AppMethodBeat.o(210836);
  }
  
  public final int navigateBack(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, IRouteDoneCallback paramIRouteDoneCallback)
  {
    AppMethodBeat.i(210933);
    s.t(paramIRouteDoneCallback, "callback");
    int i = taskId.getAndIncrement();
    ((Map)routeDoneCallbacks).put(Integer.valueOf(i), paramIRouteDoneCallback);
    paramInt1 = nativeNavigateBack(paramInt1, paramInt2, paramInt3, paramBoolean, i);
    AppMethodBeat.o(210933);
    return paramInt1;
  }
  
  public final void navigateTo(int paramInt1, int paramInt2, IRouteDoneCallback paramIRouteDoneCallback)
  {
    AppMethodBeat.i(210926);
    s.t(paramIRouteDoneCallback, "callback");
    int i = taskId.getAndIncrement();
    ((Map)routeDoneCallbacks).put(Integer.valueOf(i), paramIRouteDoneCallback);
    nativeNavigateTo(paramInt1, paramInt2, i);
    AppMethodBeat.o(210926);
  }
  
  public final void notifyRouteDone(int paramInt)
  {
    AppMethodBeat.i(210937);
    IRouteDoneCallback localIRouteDoneCallback = (IRouteDoneCallback)routeDoneCallbacks.remove(Integer.valueOf(paramInt));
    if (localIRouteDoneCallback != null)
    {
      localIRouteDoneCallback.onDone();
      AppMethodBeat.o(210937);
      return;
    }
    AppMethodBeat.o(210937);
  }
  
  public final Bitmap obtainBitmap(int paramInt)
  {
    AppMethodBeat.i(210917);
    Object localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((FlutterEngineAddon)localObject).getFlutterEngine();
      if (localObject != null)
      {
        localObject = ((FlutterEngine)localObject).getRenderer();
        if (localObject != null)
        {
          localObject = ((FlutterRenderer)localObject).getBitmap();
          AppMethodBeat.o(210917);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(210917);
    return null;
  }
  
  public final FlutterRenderer obtainRenderer(int paramInt)
  {
    AppMethodBeat.i(210921);
    Object localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((FlutterEngineAddon)localObject).getFlutterEngine();
      if (localObject != null)
      {
        localObject = ((FlutterEngine)localObject).getRenderer();
        AppMethodBeat.o(210921);
        return localObject;
      }
    }
    AppMethodBeat.o(210921);
    return null;
  }
  
  public final void reLaunch(int paramInt1, int paramInt2, IRouteDoneCallback paramIRouteDoneCallback)
  {
    AppMethodBeat.i(210946);
    s.t(paramIRouteDoneCallback, "callback");
    nativeReLaunch(paramInt1, paramInt2);
    AppMethodBeat.o(210946);
  }
  
  public final void redirectTo(int paramInt1, int paramInt2, IRouteDoneCallback paramIRouteDoneCallback)
  {
    AppMethodBeat.i(210927);
    s.t(paramIRouteDoneCallback, "callback");
    int i = taskId.getAndIncrement();
    ((Map)routeDoneCallbacks).put(Integer.valueOf(i), paramIRouteDoneCallback);
    nativeRedirectTo(paramInt1, paramInt2, i);
    AppMethodBeat.o(210927);
  }
  
  public final void switchTab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210949);
    nativeSwitchTab(paramInt1, paramInt2);
    AppMethodBeat.o(210949);
  }
  
  public final void updateViewport(int paramInt, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(210912);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", Integer.valueOf(paramInt));
    localHashMap.put("windowWidth", Double.valueOf(paramDouble1));
    localHashMap.put("windowHeight", Double.valueOf(paramDouble2));
    Object localObject = activeEngines;
    if (localObject == null) {
      s.klw();
    }
    localObject = (FlutterEngineAddon)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((FlutterEngineAddon)localObject).getInvokeMethodChannel();
      if (localObject != null)
      {
        ((MethodChannel)localObject).invokeMethod("notifyViewportChange", localHashMap);
        AppMethodBeat.o(210912);
        return;
      }
    }
    AppMethodBeat.o(210912);
  }
  
  public final void waitForDone(int paramInt, a<ah> parama)
  {
    AppMethodBeat.i(210851);
    s.t(parama, "block");
    Object localObject1 = new ah.a();
    Object localObject2;
    try
    {
      ((ah.a)localObject1).aiwY = sDoneId.contains(Integer.valueOf(paramInt));
      localObject2 = ah.aiuX;
      if (((ah.a)localObject1).aiwY)
      {
        parama.invoke();
        AppMethodBeat.o(210851);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(210851);
    }
    try
    {
      localObject2 = (ArrayList)sDoneCallbackMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((Map)sDoneCallbackMap).put(Integer.valueOf(paramInt), localObject1);
      }
      ((ArrayList)localObject1).add(new SkylineLogic.waitForDone..inlined.synchronized.lambda.1(paramInt, parama));
      return;
    }
    finally
    {
      AppMethodBeat.o(210851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.skyline.SkylineLogic
 * JD-Core Version:    0.7.0.1
 */