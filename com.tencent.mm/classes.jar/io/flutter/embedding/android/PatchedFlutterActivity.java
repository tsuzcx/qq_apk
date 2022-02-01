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
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public class PatchedFlutterActivity
  extends HellActivity
  implements q, FlutterActivityAndFragmentDelegate.Host
{
  private static final String TAG = "FlutterActivity";
  protected FlutterActivityAndFragmentDelegate delegate;
  private s lifecycle;
  
  public PatchedFlutterActivity()
  {
    AppMethodBeat.i(190441);
    this.lifecycle = new s(this);
    AppMethodBeat.o(190441);
  }
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    AppMethodBeat.i(190481);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(1073741824);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
    AppMethodBeat.o(190481);
  }
  
  private void configureWindowForTransparency()
  {
    AppMethodBeat.i(190465);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    AppMethodBeat.o(190465);
  }
  
  public static Intent createDefaultIntent(Context paramContext)
  {
    AppMethodBeat.i(190418);
    paramContext = withNewEngine().build(paramContext);
    AppMethodBeat.o(190418);
    return paramContext;
  }
  
  private View createFlutterView()
  {
    AppMethodBeat.i(190470);
    View localView = this.delegate.onCreateView(null, null, null);
    AppMethodBeat.o(190470);
    return localView;
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(190458);
    for (;;)
    {
      try
      {
        Object localObject = getMetaData();
        if (localObject == null) {
          break label84;
        }
        i = ((Bundle)localObject).getInt("io.flutter.embedding.android.SplashScreenDrawable");
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject = getResources().getDrawable(i, getTheme());
            AppMethodBeat.o(190458);
            return localObject;
          }
          localObject = getResources().getDrawable(i);
          AppMethodBeat.o(190458);
          return localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(190458);
        return null;
      }
      AppMethodBeat.o(190458);
      return null;
      label84:
      int i = 0;
    }
  }
  
  private boolean isDebuggable()
  {
    AppMethodBeat.i(190489);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(190489);
      return true;
    }
    AppMethodBeat.o(190489);
    return false;
  }
  
  private void release()
  {
    AppMethodBeat.i(190485);
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
    AppMethodBeat.o(190485);
  }
  
  private boolean stillAttachedForEvent(String paramString)
  {
    AppMethodBeat.i(190498);
    if (this.delegate == null)
    {
      Log.i("FlutterActivity", "FlutterActivity " + hashCode() + " " + paramString + " called after release.");
      AppMethodBeat.o(190498);
      return false;
    }
    AppMethodBeat.o(190498);
    return true;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    AppMethodBeat.i(190448);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        int i = localBundle.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
        AppMethodBeat.o(190448);
        return;
      }
      Log.i("FlutterActivity", "Using the launch theme as normal theme.");
      AppMethodBeat.o(190448);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
      AppMethodBeat.o(190448);
    }
  }
  
  public static PatchedFlutterActivity.CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    AppMethodBeat.i(190432);
    paramString = new PatchedFlutterActivity.CachedEngineIntentBuilder(PatchedFlutterActivity.class, paramString);
    AppMethodBeat.o(190432);
    return paramString;
  }
  
  public static PatchedFlutterActivity.NewEngineIntentBuilder withNewEngine()
  {
    AppMethodBeat.i(190426);
    PatchedFlutterActivity.NewEngineIntentBuilder localNewEngineIntentBuilder = new PatchedFlutterActivity.NewEngineIntentBuilder(FlutterActivity.class);
    AppMethodBeat.o(190426);
    return localNewEngineIntentBuilder;
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190703);
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
    AppMethodBeat.o(190703);
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(190559);
    Log.i("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    release();
    AppMethodBeat.o(190559);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public String getAppBundlePath()
  {
    AppMethodBeat.i(190665);
    if ((isDebuggable()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      String str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(190665);
        return str;
      }
    }
    AppMethodBeat.o(190665);
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(190682);
    if (getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(190682);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(190682);
    return localBackgroundMode;
  }
  
  public String getCachedEngineId()
  {
    AppMethodBeat.i(190640);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(190640);
    return str;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(190650);
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
            AppMethodBeat.o(190650);
            return localObject1;
          }
          AppMethodBeat.o(190650);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(190650);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    AppMethodBeat.i(190689);
    FlutterEngine localFlutterEngine = this.delegate.getFlutterEngine();
    AppMethodBeat.o(190689);
    return localFlutterEngine;
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    AppMethodBeat.i(190634);
    FlutterShellArgs localFlutterShellArgs = FlutterShellArgs.fromIntent(getIntent());
    AppMethodBeat.o(190634);
    return localFlutterShellArgs;
  }
  
  public String getInitialRoute()
  {
    AppMethodBeat.i(190657);
    Object localObject;
    if (getIntent().hasExtra("route"))
    {
      localObject = getIntent().getStringExtra("route");
      AppMethodBeat.o(190657);
      return localObject;
    }
    try
    {
      localObject = getMetaData();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.flutter.InitialRoute");
        AppMethodBeat.o(190657);
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(190657);
      return null;
    }
    AppMethodBeat.o(190657);
    return null;
  }
  
  public j getLifecycle()
  {
    return this.lifecycle;
  }
  
  protected Bundle getMetaData()
  {
    AppMethodBeat.i(190692);
    Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    AppMethodBeat.o(190692);
    return localBundle;
  }
  
  public RenderMode getRenderMode()
  {
    AppMethodBeat.i(190670);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = RenderMode.surface;
      AppMethodBeat.o(190670);
      return localRenderMode;
    }
    RenderMode localRenderMode = RenderMode.texture;
    AppMethodBeat.o(190670);
    return localRenderMode;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    AppMethodBeat.i(190675);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localTransparencyMode = TransparencyMode.opaque;
      AppMethodBeat.o(190675);
      return localTransparencyMode;
    }
    TransparencyMode localTransparencyMode = TransparencyMode.transparent;
    AppMethodBeat.o(190675);
    return localTransparencyMode;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190578);
    if (stillAttachedForEvent("onActivityResult")) {
      this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(190578);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190595);
    if (stillAttachedForEvent("onBackPressed")) {
      this.delegate.onBackPressed();
    }
    AppMethodBeat.o(190595);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190512);
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this);
    this.delegate.onRestoreInstanceState(paramBundle);
    this.lifecycle.a(j.a.ON_CREATE);
    configureWindowForTransparency();
    setContentView(createFlutterView());
    configureStatusBarForFullscreenFlutterExperience();
    AppMethodBeat.o(190512);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190568);
    super.onDestroy();
    if (stillAttachedForEvent("onDestroy")) {
      release();
    }
    this.lifecycle.a(j.a.ON_DESTROY);
    AppMethodBeat.o(190568);
  }
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    AppMethodBeat.i(190725);
    if (Build.VERSION.SDK_INT >= 29) {
      reportFullyDrawn();
    }
    AppMethodBeat.o(190725);
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190587);
    super.onNewIntent(paramIntent);
    if (stillAttachedForEvent("onNewIntent")) {
      this.delegate.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(190587);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190543);
    super.onPause();
    if (stillAttachedForEvent("onPause")) {
      this.delegate.onPause();
    }
    this.lifecycle.a(j.a.ON_PAUSE);
    AppMethodBeat.o(190543);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(190537);
    super.onPostResume();
    if (stillAttachedForEvent("onPostResume")) {
      this.delegate.onPostResume();
    }
    AppMethodBeat.o(190537);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190601);
    if (stillAttachedForEvent("onRequestPermissionsResult")) {
      this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(190601);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190531);
    super.onResume();
    this.lifecycle.a(j.a.ON_RESUME);
    if (stillAttachedForEvent("onResume")) {
      this.delegate.onResume();
    }
    AppMethodBeat.o(190531);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(190553);
    super.onSaveInstanceState(paramBundle);
    if (stillAttachedForEvent("onSaveInstanceState")) {
      this.delegate.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(190553);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(190524);
    super.onStart();
    this.lifecycle.a(j.a.ON_START);
    if (stillAttachedForEvent("onStart")) {
      this.delegate.onStart();
    }
    AppMethodBeat.o(190524);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(190549);
    super.onStop();
    if (stillAttachedForEvent("onStop")) {
      this.delegate.onStop();
    }
    this.lifecycle.a(j.a.ON_STOP);
    AppMethodBeat.o(190549);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(190614);
    super.onTrimMemory(paramInt);
    if (stillAttachedForEvent("onTrimMemory")) {
      this.delegate.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(190614);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(190607);
    if (stillAttachedForEvent("onUserLeaveHint")) {
      this.delegate.onUserLeaveHint();
    }
    AppMethodBeat.o(190607);
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
    AppMethodBeat.i(190697);
    paramActivity = new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel(), this);
    AppMethodBeat.o(190697);
    return paramActivity;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(190518);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(190518);
      return localObject;
    }
    AppMethodBeat.o(190518);
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
    AppMethodBeat.i(190644);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost()))
    {
      AppMethodBeat.o(190644);
      return bool;
    }
    bool = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    AppMethodBeat.o(190644);
    return bool;
  }
  
  public boolean shouldHandleDeeplinking()
  {
    AppMethodBeat.i(190716);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("flutter_deeplinking_enabled");
        AppMethodBeat.o(190716);
        return bool;
      }
      AppMethodBeat.o(190716);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(190716);
    }
    return false;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    AppMethodBeat.i(190731);
    if (getIntent().hasExtra("enable_state_restoration"))
    {
      boolean bool = getIntent().getBooleanExtra("enable_state_restoration", false);
      AppMethodBeat.o(190731);
      return bool;
    }
    if (getCachedEngineId() != null)
    {
      AppMethodBeat.o(190731);
      return false;
    }
    AppMethodBeat.o(190731);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.PatchedFlutterActivity
 * JD-Core Version:    0.7.0.1
 */