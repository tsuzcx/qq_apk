package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformPlugin.PlatformPluginDelegate;
import java.util.Arrays;

class FlutterActivityAndFragmentDelegate
  implements ExclusiveAppComponent<Activity>
{
  private static final String FRAMEWORK_RESTORATION_BUNDLE_KEY = "framework";
  private static final String PLUGINS_RESTORATION_BUNDLE_KEY = "plugins";
  private static final String TAG = "FlutterActivityAndFragmentDelegate";
  private FlutterEngine flutterEngine;
  private FlutterSplashView flutterSplashView;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private FlutterView flutterView;
  private Host host;
  private boolean isFlutterEngineFromHost;
  private PlatformPlugin platformPlugin;
  
  FlutterActivityAndFragmentDelegate(Host paramHost)
  {
    AppMethodBeat.i(10071);
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190395);
        FlutterActivityAndFragmentDelegate.this.host.onFlutterUiDisplayed();
        AppMethodBeat.o(190395);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190403);
        FlutterActivityAndFragmentDelegate.this.host.onFlutterUiNoLongerDisplayed();
        AppMethodBeat.o(190403);
      }
    };
    this.host = paramHost;
    AppMethodBeat.o(10071);
  }
  
  private void doInitialFlutterViewRun()
  {
    AppMethodBeat.i(190369);
    if (this.host.getCachedEngineId() != null)
    {
      AppMethodBeat.o(190369);
      return;
    }
    if (this.flutterEngine.getDartExecutor().isExecutingDart())
    {
      AppMethodBeat.o(190369);
      return;
    }
    String str = this.host.getInitialRoute();
    Object localObject = str;
    if (str == null)
    {
      str = maybeGetInitialRouteFromIntent(this.host.getActivity().getIntent());
      localObject = str;
      if (str == null) {
        localObject = "/";
      }
    }
    Log.v("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.host.getDartEntrypointFunctionName() + ", and sending initial route: " + (String)localObject);
    this.flutterEngine.getNavigationChannel().setInitialRoute((String)localObject);
    str = this.host.getAppBundlePath();
    if (str != null)
    {
      localObject = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      localObject = FlutterInjector.instance().flutterLoader().findAppBundlePath();
    }
    localObject = new DartExecutor.DartEntrypoint((String)localObject, this.host.getDartEntrypointFunctionName());
    this.flutterEngine.getDartExecutor().executeDartEntrypoint((DartExecutor.DartEntrypoint)localObject);
    AppMethodBeat.o(190369);
  }
  
  private void ensureAlive()
  {
    AppMethodBeat.i(10084);
    if (this.host == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  private String maybeGetInitialRouteFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190373);
    if (this.host.shouldHandleDeeplinking())
    {
      Uri localUri = paramIntent.getData();
      if ((localUri != null) && (!localUri.getPath().isEmpty()))
      {
        String str = localUri.getPath();
        paramIntent = str;
        if (!localUri.getQuery().isEmpty()) {
          paramIntent = str + "?" + localUri.getQuery();
        }
        AppMethodBeat.o(190373);
        return paramIntent;
      }
    }
    AppMethodBeat.o(190373);
    return null;
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(190519);
    if (this.host.shouldDestroyEngineWithHost())
    {
      AssertionError localAssertionError = new AssertionError("The internal FlutterEngine created by " + this.host + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
      AppMethodBeat.o(190519);
      throw localAssertionError;
    }
    this.host.detachFromFlutterEngine();
    AppMethodBeat.o(190519);
  }
  
  public Activity getAppComponent()
  {
    AppMethodBeat.i(190427);
    Object localObject = this.host.getActivity();
    if (localObject == null)
    {
      localObject = new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
      AppMethodBeat.o(190427);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(190427);
    return localObject;
  }
  
  FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  boolean isFlutterEngineFromHost()
  {
    return this.isFlutterEngineFromHost;
  }
  
  void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent);
      this.flutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    AppMethodBeat.o(10083);
  }
  
  void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10072);
    ensureAlive();
    if (this.flutterEngine == null) {
      setupFlutterEngine();
    }
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
      this.flutterEngine.getActivityControlSurface().attachToActivity(this, this.host.getLifecycle());
    }
    this.platformPlugin = this.host.providePlatformPlugin(this.host.getActivity(), this.flutterEngine);
    this.host.configureFlutterEngine(this.flutterEngine);
    AppMethodBeat.o(10072);
  }
  
  void onBackPressed()
  {
    AppMethodBeat.i(190535);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
      this.flutterEngine.getNavigationChannel().popRoute();
      AppMethodBeat.o(190535);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    AppMethodBeat.o(190535);
  }
  
  View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(190447);
    Log.v("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
    ensureAlive();
    boolean bool;
    if (this.host.getRenderMode() == RenderMode.surface)
    {
      paramLayoutInflater = this.host.getActivity();
      if (this.host.getTransparencyMode() == TransparencyMode.transparent)
      {
        bool = true;
        paramLayoutInflater = new FlutterSurfaceView(paramLayoutInflater, bool);
        this.host.onFlutterSurfaceViewCreated(paramLayoutInflater);
        this.flutterView = new FlutterView(this.host.getActivity(), paramLayoutInflater);
        label103:
        this.flutterView.addOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
        this.flutterSplashView = new FlutterSplashView(this.host.getContext());
        if (Build.VERSION.SDK_INT < 17) {
          break label261;
        }
        this.flutterSplashView.setId(View.generateViewId());
      }
    }
    for (;;)
    {
      this.flutterSplashView.displayFlutterViewWithSplash(this.flutterView, this.host.provideSplashScreen());
      Log.v("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
      this.flutterView.attachToFlutterEngine(this.flutterEngine);
      paramLayoutInflater = this.flutterSplashView;
      AppMethodBeat.o(190447);
      return paramLayoutInflater;
      bool = false;
      break;
      paramLayoutInflater = new FlutterTextureView(this.host.getActivity());
      this.host.onFlutterTextureViewCreated(paramLayoutInflater);
      this.flutterView = new FlutterView(this.host.getActivity(), paramLayoutInflater);
      break label103;
      label261:
      this.flutterSplashView.setId(486947586);
    }
  }
  
  void onDestroyView()
  {
    AppMethodBeat.i(10080);
    Log.v("FlutterActivityAndFragmentDelegate", "onDestroyView()");
    ensureAlive();
    this.flutterView.detachFromFlutterEngine();
    this.flutterView.removeOnFirstFrameRenderedListener(this.flutterUiDisplayListener);
    AppMethodBeat.o(10080);
  }
  
  void onDetach()
  {
    AppMethodBeat.i(10081);
    Log.v("FlutterActivityAndFragmentDelegate", "onDetach()");
    ensureAlive();
    this.host.cleanUpFlutterEngine(this.flutterEngine);
    if (this.host.shouldAttachEngineToActivity())
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
      if (!this.host.getActivity().isChangingConfigurations()) {
        break label165;
      }
      this.flutterEngine.getActivityControlSurface().detachFromActivityForConfigChanges();
    }
    for (;;)
    {
      if (this.platformPlugin != null)
      {
        this.platformPlugin.destroy();
        this.platformPlugin = null;
      }
      this.flutterEngine.getLifecycleChannel().appIsDetached();
      if (this.host.shouldDestroyEngineWithHost())
      {
        this.flutterEngine.destroy();
        if (this.host.getCachedEngineId() != null) {
          FlutterEngineCache.getInstance().remove(this.host.getCachedEngineId());
        }
        this.flutterEngine = null;
      }
      AppMethodBeat.o(10081);
      return;
      label165:
      this.flutterEngine.getActivityControlSurface().detachFromActivity();
    }
  }
  
  void onLowMemory()
  {
    AppMethodBeat.i(190584);
    Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onLowMemory() to FlutterEngine.");
    ensureAlive();
    this.flutterEngine.getDartExecutor().notifyLowMemoryWarning();
    this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
    AppMethodBeat.o(190584);
  }
  
  void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190548);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
      this.flutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
      paramIntent = maybeGetInitialRouteFromIntent(paramIntent);
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        this.flutterEngine.getNavigationChannel().pushRoute(paramIntent);
      }
      AppMethodBeat.o(190548);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    AppMethodBeat.o(190548);
  }
  
  void onPause()
  {
    AppMethodBeat.i(10078);
    Log.v("FlutterActivityAndFragmentDelegate", "onPause()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsInactive();
    AppMethodBeat.o(10078);
  }
  
  void onPostResume()
  {
    AppMethodBeat.i(190482);
    Log.v("FlutterActivityAndFragmentDelegate", "onPostResume()");
    ensureAlive();
    if (this.flutterEngine != null)
    {
      if (this.platformPlugin != null)
      {
        this.platformPlugin.updateSystemUiOverlays();
        AppMethodBeat.o(190482);
      }
    }
    else {
      Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }
    AppMethodBeat.o(190482);
  }
  
  void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt));
      this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    AppMethodBeat.o(10082);
  }
  
  void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190456);
    Log.v("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
    ensureAlive();
    Bundle localBundle;
    if (paramBundle != null)
    {
      localBundle = paramBundle.getBundle("plugins");
      paramBundle = paramBundle.getByteArray("framework");
    }
    for (;;)
    {
      if (this.host.shouldRestoreAndSaveState()) {
        this.flutterEngine.getRestorationChannel().setRestorationData(paramBundle);
      }
      if (this.host.shouldAttachEngineToActivity()) {
        this.flutterEngine.getActivityControlSurface().onRestoreInstanceState(localBundle);
      }
      AppMethodBeat.o(190456);
      return;
      paramBundle = null;
      localBundle = null;
    }
  }
  
  void onResume()
  {
    AppMethodBeat.i(10077);
    Log.v("FlutterActivityAndFragmentDelegate", "onResume()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsResumed();
    AppMethodBeat.o(10077);
  }
  
  void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190511);
    Log.v("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
    ensureAlive();
    if (this.host.shouldRestoreAndSaveState()) {
      paramBundle.putByteArray("framework", this.flutterEngine.getRestorationChannel().getRestorationData());
    }
    if (this.host.shouldAttachEngineToActivity())
    {
      Bundle localBundle = new Bundle();
      this.flutterEngine.getActivityControlSurface().onSaveInstanceState(localBundle);
      paramBundle.putBundle("plugins", localBundle);
    }
    AppMethodBeat.o(190511);
  }
  
  void onStart()
  {
    AppMethodBeat.i(10076);
    Log.v("FlutterActivityAndFragmentDelegate", "onStart()");
    ensureAlive();
    doInitialFlutterViewRun();
    AppMethodBeat.o(10076);
  }
  
  void onStop()
  {
    AppMethodBeat.i(10079);
    Log.v("FlutterActivityAndFragmentDelegate", "onStop()");
    ensureAlive();
    this.flutterEngine.getLifecycleChannel().appIsPaused();
    AppMethodBeat.o(10079);
  }
  
  void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(190571);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      this.flutterEngine.getDartExecutor().notifyLowMemoryWarning();
      if (paramInt == 10)
      {
        Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)));
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        AppMethodBeat.o(190571);
      }
    }
    else
    {
      Log.w("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
    }
    AppMethodBeat.o(190571);
  }
  
  void onUserLeaveHint()
  {
    AppMethodBeat.i(190562);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      Log.v("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
      this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
      AppMethodBeat.o(190562);
      return;
    }
    Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    AppMethodBeat.o(190562);
  }
  
  void release()
  {
    this.host = null;
    this.flutterEngine = null;
    this.flutterView = null;
    this.platformPlugin = null;
  }
  
  void setupFlutterEngine()
  {
    AppMethodBeat.i(10074);
    Log.v("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
    Object localObject = this.host.getCachedEngineId();
    if (localObject != null)
    {
      this.flutterEngine = FlutterEngineCache.getInstance().get((String)localObject);
      this.isFlutterEngineFromHost = true;
      if (this.flutterEngine == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    this.flutterEngine = this.host.provideFlutterEngine(this.host.getContext());
    if (this.flutterEngine != null)
    {
      this.isFlutterEngineFromHost = true;
      AppMethodBeat.o(10074);
      return;
    }
    Log.v("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
    this.flutterEngine = new FlutterEngine(this.host.getContext(), this.host.getFlutterShellArgs().toArray(), false, this.host.shouldRestoreAndSaveState());
    this.isFlutterEngineFromHost = false;
    AppMethodBeat.o(10074);
  }
  
  static abstract interface Host
    extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider, PlatformPlugin.PlatformPluginDelegate
  {
    public abstract void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract void configureFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract void detachFromFlutterEngine();
    
    public abstract Activity getActivity();
    
    public abstract String getAppBundlePath();
    
    public abstract String getCachedEngineId();
    
    public abstract Context getContext();
    
    public abstract String getDartEntrypointFunctionName();
    
    public abstract FlutterShellArgs getFlutterShellArgs();
    
    public abstract String getInitialRoute();
    
    public abstract j getLifecycle();
    
    public abstract RenderMode getRenderMode();
    
    public abstract TransparencyMode getTransparencyMode();
    
    public abstract void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView);
    
    public abstract void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView);
    
    public abstract void onFlutterUiDisplayed();
    
    public abstract void onFlutterUiNoLongerDisplayed();
    
    public abstract FlutterEngine provideFlutterEngine(Context paramContext);
    
    public abstract PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine);
    
    public abstract SplashScreen provideSplashScreen();
    
    public abstract boolean shouldAttachEngineToActivity();
    
    public abstract boolean shouldDestroyEngineWithHost();
    
    public abstract boolean shouldHandleDeeplinking();
    
    public abstract boolean shouldRestoreAndSaveState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivityAndFragmentDelegate
 * JD-Core Version:    0.7.0.1
 */