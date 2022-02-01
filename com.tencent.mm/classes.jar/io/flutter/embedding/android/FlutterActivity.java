package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public class FlutterActivity
  extends HellActivity
  implements q, FlutterActivityAndFragmentDelegate.Host
{
  private static final String TAG = "FlutterActivity";
  protected FlutterActivityAndFragmentDelegate delegate;
  private s lifecycle;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(10028);
    this.lifecycle = new s(this);
    AppMethodBeat.o(10028);
  }
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    AppMethodBeat.i(190579);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(1073741824);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
    AppMethodBeat.o(190579);
  }
  
  private void configureWindowForTransparency()
  {
    AppMethodBeat.i(190558);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    AppMethodBeat.o(190558);
  }
  
  public static Intent createDefaultIntent(Context paramContext)
  {
    AppMethodBeat.i(190517);
    paramContext = withNewEngine().build(paramContext);
    AppMethodBeat.o(190517);
    return paramContext;
  }
  
  private View createFlutterView()
  {
    AppMethodBeat.i(190569);
    View localView = this.delegate.onCreateView(null, null, null);
    AppMethodBeat.o(190569);
    return localView;
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(10031);
    for (;;)
    {
      try
      {
        Object localObject = getMetaData();
        if (localObject == null) {
          break label89;
        }
        i = ((Bundle)localObject).getInt("io.flutter.embedding.android.SplashScreenDrawable");
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject = getResources().getDrawable(i, getTheme());
            AppMethodBeat.o(10031);
            return localObject;
          }
          localObject = getResources().getDrawable(i);
          AppMethodBeat.o(10031);
          return localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10031);
        return null;
      }
      AppMethodBeat.o(10031);
      return null;
      label89:
      int i = 0;
    }
  }
  
  private boolean isDebuggable()
  {
    AppMethodBeat.i(190600);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(190600);
      return true;
    }
    AppMethodBeat.o(190600);
    return false;
  }
  
  private void release()
  {
    AppMethodBeat.i(190590);
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
    AppMethodBeat.o(190590);
  }
  
  private boolean stillAttachedForEvent(String paramString)
  {
    AppMethodBeat.i(190606);
    if (this.delegate == null)
    {
      Log.v("FlutterActivity", "FlutterActivity " + hashCode() + " " + paramString + " called after release.");
      AppMethodBeat.o(190606);
      return false;
    }
    AppMethodBeat.o(190606);
    return true;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    AppMethodBeat.i(190547);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        int i = localBundle.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
        AppMethodBeat.o(190547);
        return;
      }
      Log.v("FlutterActivity", "Using the launch theme as normal theme.");
      AppMethodBeat.o(190547);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
      AppMethodBeat.o(190547);
    }
  }
  
  public static FlutterActivity.CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    AppMethodBeat.i(190533);
    paramString = new FlutterActivity.CachedEngineIntentBuilder(FlutterActivity.class, paramString);
    AppMethodBeat.o(190533);
    return paramString;
  }
  
  public static FlutterActivity.NewEngineIntentBuilder withNewEngine()
  {
    AppMethodBeat.i(190525);
    FlutterActivity.NewEngineIntentBuilder localNewEngineIntentBuilder = new FlutterActivity.NewEngineIntentBuilder(FlutterActivity.class);
    AppMethodBeat.o(190525);
    return localNewEngineIntentBuilder;
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190782);
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
    AppMethodBeat.o(190782);
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(190666);
    Log.v("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    release();
    AppMethodBeat.o(190666);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public String getAppBundlePath()
  {
    AppMethodBeat.i(10049);
    if ((isDebuggable()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      String str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(10049);
        return str;
      }
    }
    AppMethodBeat.o(10049);
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(190750);
    if (getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(190750);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(190750);
    return localBackgroundMode;
  }
  
  public String getCachedEngineId()
  {
    AppMethodBeat.i(10045);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(10045);
    return str;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(10047);
    for (;;)
    {
      try
      {
        Object localObject1 = getMetaData();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 != null)
          {
            AppMethodBeat.o(10047);
            return localObject1;
          }
          AppMethodBeat.o(10047);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10047);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    AppMethodBeat.i(190762);
    FlutterEngine localFlutterEngine = this.delegate.getFlutterEngine();
    AppMethodBeat.o(190762);
    return localFlutterEngine;
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    AppMethodBeat.i(10044);
    FlutterShellArgs localFlutterShellArgs = FlutterShellArgs.fromIntent(getIntent());
    AppMethodBeat.o(10044);
    return localFlutterShellArgs;
  }
  
  public String getInitialRoute()
  {
    AppMethodBeat.i(10048);
    Object localObject;
    if (getIntent().hasExtra("route"))
    {
      localObject = getIntent().getStringExtra("route");
      AppMethodBeat.o(10048);
      return localObject;
    }
    try
    {
      localObject = getMetaData();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.flutter.InitialRoute");
        AppMethodBeat.o(10048);
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(10048);
      return null;
    }
    AppMethodBeat.o(10048);
    return null;
  }
  
  public j getLifecycle()
  {
    return this.lifecycle;
  }
  
  protected Bundle getMetaData()
  {
    AppMethodBeat.i(190772);
    Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    AppMethodBeat.o(190772);
    return localBundle;
  }
  
  public RenderMode getRenderMode()
  {
    AppMethodBeat.i(190738);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = RenderMode.surface;
      AppMethodBeat.o(190738);
      return localRenderMode;
    }
    RenderMode localRenderMode = RenderMode.texture;
    AppMethodBeat.o(190738);
    return localRenderMode;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    AppMethodBeat.i(190744);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localTransparencyMode = TransparencyMode.opaque;
      AppMethodBeat.o(190744);
      return localTransparencyMode;
    }
    TransparencyMode localTransparencyMode = TransparencyMode.transparent;
    AppMethodBeat.o(190744);
    return localTransparencyMode;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10038);
    if (stillAttachedForEvent("onActivityResult")) {
      this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(10038);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(10040);
    if (stillAttachedForEvent("onBackPressed")) {
      this.delegate.onBackPressed();
    }
    AppMethodBeat.o(10040);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(10029);
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this);
    this.delegate.onRestoreInstanceState(paramBundle);
    this.lifecycle.a(j.a.ON_CREATE);
    configureWindowForTransparency();
    setContentView(createFlutterView());
    configureStatusBarForFullscreenFlutterExperience();
    AppMethodBeat.o(10029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(10037);
    super.onDestroy();
    if (stillAttachedForEvent("onDestroy")) {
      release();
    }
    this.lifecycle.a(j.a.ON_DESTROY);
    AppMethodBeat.o(10037);
  }
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    AppMethodBeat.i(190827);
    if (Build.VERSION.SDK_INT >= 29) {
      reportFullyDrawn();
    }
    AppMethodBeat.o(190827);
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10039);
    super.onNewIntent(paramIntent);
    if (stillAttachedForEvent("onNewIntent")) {
      this.delegate.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(10039);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10035);
    super.onPause();
    this.delegate.onPause();
    this.lifecycle.a(j.a.ON_PAUSE);
    AppMethodBeat.o(10035);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(10034);
    super.onPostResume();
    this.delegate.onPostResume();
    AppMethodBeat.o(10034);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10041);
    if (stillAttachedForEvent("onRequestPermissionsResult")) {
      this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(10041);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10033);
    super.onResume();
    this.lifecycle.a(j.a.ON_RESUME);
    this.delegate.onResume();
    AppMethodBeat.o(10033);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190659);
    super.onSaveInstanceState(paramBundle);
    if (stillAttachedForEvent("onSaveInstanceState")) {
      this.delegate.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(190659);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(10032);
    super.onStart();
    this.lifecycle.a(j.a.ON_START);
    this.delegate.onStart();
    AppMethodBeat.o(10032);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10036);
    super.onStop();
    if (stillAttachedForEvent("onStop")) {
      this.delegate.onStop();
    }
    this.lifecycle.a(j.a.ON_STOP);
    AppMethodBeat.o(10036);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(10043);
    super.onTrimMemory(paramInt);
    if (stillAttachedForEvent("onTrimMemory")) {
      this.delegate.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(10043);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(10042);
    if (stillAttachedForEvent("onUserLeaveHint")) {
      this.delegate.onUserLeaveHint();
    }
    AppMethodBeat.o(10042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean popSystemNavigator()
  {
    return false;
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    return null;
  }
  
  public PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(10053);
    paramActivity = new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel(), this);
    AppMethodBeat.o(10053);
    return paramActivity;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(10030);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(10030);
      return localObject;
    }
    AppMethodBeat.o(10030);
    return null;
  }
  
  void setDelegate(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(10046);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost()))
    {
      AppMethodBeat.o(10046);
      return bool;
    }
    bool = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    AppMethodBeat.o(10046);
    return bool;
  }
  
  public boolean shouldHandleDeeplinking()
  {
    AppMethodBeat.i(190804);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("flutter_deeplinking_enabled");
        AppMethodBeat.o(190804);
        return bool;
      }
      AppMethodBeat.o(190804);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(190804);
    }
    return false;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    AppMethodBeat.i(190838);
    if (getIntent().hasExtra("enable_state_restoration"))
    {
      boolean bool = getIntent().getBooleanExtra("enable_state_restoration", false);
      AppMethodBeat.o(190838);
      return bool;
    }
    if (getCachedEngineId() != null)
    {
      AppMethodBeat.o(190838);
      return false;
    }
    AppMethodBeat.o(190838);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */