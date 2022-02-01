package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
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
import com.tencent.mm.plugin.flutter.c.b;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.plugin.platform.PlatformPlugin;

public abstract class PatchedFlutterActivityController
  implements q, a, FlutterActivityAndFragmentDelegate.Host
{
  private static final String TAG = "PatchedFlutterActivityController";
  protected FlutterActivityAndFragmentDelegate delegate;
  private s lifecycle = new s(this);
  protected VideoActivity vActivity;
  
  private PatchedFlutterActivityController() {}
  
  public PatchedFlutterActivityController(VideoActivity paramVideoActivity)
  {
    this();
    this.vActivity = paramVideoActivity;
  }
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = this.vActivity.getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(1073741824);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
  }
  
  private void configureWindowForTransparency()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      this.vActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  public static Intent createDefaultIntent(Context paramContext)
  {
    return withNewEngine().build(paramContext);
  }
  
  private View createFlutterView()
  {
    return this.delegate.onCreateView(null, null, null);
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    for (;;)
    {
      try
      {
        Object localObject = getMetaData();
        if (localObject == null) {
          break label64;
        }
        i = ((Bundle)localObject).getInt("io.flutter.embedding.android.SplashScreenDrawable");
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT > 21) {
            return this.vActivity.getResources().getDrawable(i, this.vActivity.getTheme());
          }
          localObject = this.vActivity.getResources().getDrawable(i);
          return localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return null;
      label64:
      int i = 0;
    }
  }
  
  private boolean isDebuggable()
  {
    return (this.vActivity.getApplicationInfo().flags & 0x2) != 0;
  }
  
  private void release()
  {
    this.delegate.onDestroyView();
    this.delegate.onDetach();
    this.delegate.release();
    this.delegate = null;
  }
  
  private boolean stillAttachedForEvent(String paramString)
  {
    if (this.delegate == null)
    {
      Log.i("PatchedFlutterActivityController", "FlutterActivity " + hashCode() + " " + paramString + " called after release.");
      return false;
    }
    return true;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        int i = localBundle.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          this.vActivity.setTheme(i);
        }
      }
      else
      {
        Log.i("PatchedFlutterActivityController", "Using the launch theme as normal theme.");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("PatchedFlutterActivityController", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
    }
  }
  
  public static PatchedFlutterActivityController.CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    return new PatchedFlutterActivityController.CachedEngineIntentBuilder(PatchedFlutterActivity.class, paramString);
  }
  
  public static PatchedFlutterActivityController.NewEngineIntentBuilder withNewEngine()
  {
    return new PatchedFlutterActivityController.NewEngineIntentBuilder(FlutterActivity.class);
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
  }
  
  public void detachFromFlutterEngine()
  {
    Log.i("PatchedFlutterActivityController", "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    release();
  }
  
  public void fixResources(Resources paramResources)
  {
    setupConfiguration(paramResources.getConfiguration());
  }
  
  public Activity getActivity()
  {
    return this.vActivity;
  }
  
  public String getAppBundlePath()
  {
    if ((isDebuggable()) && ("android.intent.action.RUN".equals(this.vActivity.getIntent().getAction())))
    {
      String str = this.vActivity.getIntent().getDataString();
      if (str != null) {
        return str;
      }
    }
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    if (this.vActivity.getIntent().hasExtra("background_mode")) {
      return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(this.vActivity.getIntent().getStringExtra("background_mode"));
    }
    return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
  }
  
  public String getCachedEngineId()
  {
    return this.vActivity.getIntent().getStringExtra("cached_engine_id");
  }
  
  public Context getContext()
  {
    return this.vActivity;
  }
  
  public String getDartEntrypointFunctionName()
  {
    try
    {
      Object localObject1 = getMetaData();
      if (localObject1 == null) {
        break label35;
      }
      localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return "main";
    }
    return "main";
    while (localNameNotFoundException != null)
    {
      return localNameNotFoundException;
      label35:
      Object localObject2 = null;
    }
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    return this.delegate.getFlutterEngine();
  }
  
  public FlutterShellArgs getFlutterShellArgs()
  {
    return FlutterShellArgs.fromIntent(this.vActivity.getIntent());
  }
  
  public String getInitialRoute()
  {
    String str = null;
    if (this.vActivity.getIntent().hasExtra("route")) {
      str = this.vActivity.getIntent().getStringExtra("route");
    }
    for (;;)
    {
      return str;
      try
      {
        Bundle localBundle = getMetaData();
        if (localBundle != null)
        {
          str = localBundle.getString("io.flutter.InitialRoute");
          return str;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
    return null;
  }
  
  public j getLifecycle()
  {
    return this.lifecycle;
  }
  
  protected Bundle getMetaData()
  {
    return this.vActivity.getPackageManager().getActivityInfo(this.vActivity.getComponentName(), 128).metaData;
  }
  
  public RenderMode getRenderMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return RenderMode.surface;
    }
    return RenderMode.texture;
  }
  
  public TransparencyMode getTransparencyMode()
  {
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
      return TransparencyMode.opaque;
    }
    return TransparencyMode.transparent;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (stillAttachedForEvent("onActivityResult")) {
      this.delegate.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPressed()
  {
    if (stillAttachedForEvent("onBackPressed")) {
      this.delegate.onBackPressed();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    switchLaunchThemeForNormalTheme();
    this.vActivity.setTheme(c.b.MMTheme_Flutter);
    this.vActivity.bf(paramBundle);
    this.delegate = new FlutterActivityAndFragmentDelegate(this);
    this.delegate.onAttach(this.vActivity);
    this.delegate.onRestoreInstanceState(paramBundle);
    this.lifecycle.a(j.a.ON_CREATE);
    configureWindowForTransparency();
    this.vActivity.setContentView(createFlutterView());
    configureStatusBarForFullscreenFlutterExperience();
  }
  
  public void onDestroy()
  {
    if (stillAttachedForEvent("onDestroy")) {
      release();
    }
    this.lifecycle.a(j.a.ON_DESTROY);
  }
  
  public void onFlutterSurfaceViewCreated(FlutterSurfaceView paramFlutterSurfaceView) {}
  
  public void onFlutterTextureViewCreated(FlutterTextureView paramFlutterTextureView) {}
  
  public void onFlutterUiDisplayed()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      this.vActivity.reportFullyDrawn();
    }
  }
  
  public void onFlutterUiNoLongerDisplayed() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    if (stillAttachedForEvent("onNewIntent")) {
      this.delegate.onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    if (stillAttachedForEvent("onPause")) {
      this.delegate.onPause();
    }
    this.lifecycle.a(j.a.ON_PAUSE);
  }
  
  public void onPostResume()
  {
    if (stillAttachedForEvent("onPostResume")) {
      this.delegate.onPostResume();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (stillAttachedForEvent("onRequestPermissionsResult")) {
      this.delegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    this.lifecycle.a(j.a.ON_RESUME);
    if (stillAttachedForEvent("onResume")) {
      this.delegate.onResume();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (stillAttachedForEvent("onSaveInstanceState")) {
      this.delegate.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    this.lifecycle.a(j.a.ON_START);
    if (stillAttachedForEvent("onStart")) {
      this.delegate.onStart();
    }
  }
  
  public void onStop()
  {
    if (stillAttachedForEvent("onStop")) {
      this.delegate.onStop();
    }
    this.lifecycle.a(j.a.ON_STOP);
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (stillAttachedForEvent("onTrimMemory")) {
      this.delegate.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUserLeaveHint()
  {
    if (stillAttachedForEvent("onUserLeaveHint")) {
      this.delegate.onUserLeaveHint();
    }
    return true;
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
    return new PlatformPlugin(getActivity(), paramFlutterEngine.getPlatformChannel(), this);
  }
  
  public SplashScreen provideSplashScreen()
  {
    Drawable localDrawable = getSplashScreenFromManifest();
    if (localDrawable != null) {
      return new DrawableSplashScreen(localDrawable);
    }
    return null;
  }
  
  void setDelegate(FlutterActivityAndFragmentDelegate paramFlutterActivityAndFragmentDelegate)
  {
    this.delegate = paramFlutterActivityAndFragmentDelegate;
  }
  
  protected abstract void setupConfiguration(Configuration paramConfiguration);
  
  public boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    boolean bool = this.vActivity.getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((getCachedEngineId() != null) || (this.delegate.isFlutterEngineFromHost())) {
      return bool;
    }
    return this.vActivity.getIntent().getBooleanExtra("destroy_engine_with_activity", true);
  }
  
  public boolean shouldHandleDeeplinking()
  {
    boolean bool = false;
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null) {
        bool = localBundle.getBoolean("flutter_deeplinking_enabled");
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public boolean shouldRestoreAndSaveState()
  {
    boolean bool = false;
    if (this.vActivity.getIntent().hasExtra("enable_state_restoration")) {
      bool = this.vActivity.getIntent().getBooleanExtra("enable_state_restoration", false);
    }
    while (getCachedEngineId() != null) {
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.PatchedFlutterActivityController
 * JD-Core Version:    0.7.0.1
 */