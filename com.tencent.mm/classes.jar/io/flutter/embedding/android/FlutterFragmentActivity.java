package io.flutter.embedding.android;

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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
{
  private static final int FRAGMENT_CONTAINER_ID = 609893468;
  private static final String TAG = "FlutterFragmentActivity";
  private static final String TAG_FLUTTER_FRAGMENT = "flutter_fragment";
  private FlutterFragment flutterFragment;
  
  private void configureStatusBarForFullscreenFlutterExperience()
  {
    AppMethodBeat.i(190507);
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = getWindow();
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(1073741824);
      localWindow.getDecorView().setSystemUiVisibility(1280);
    }
    AppMethodBeat.o(190507);
  }
  
  private void configureWindowForTransparency()
  {
    AppMethodBeat.i(190484);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }
    AppMethodBeat.o(190484);
  }
  
  public static Intent createDefaultIntent(Context paramContext)
  {
    AppMethodBeat.i(190440);
    paramContext = withNewEngine().build(paramContext);
    AppMethodBeat.o(190440);
    return paramContext;
  }
  
  private View createFragmentContainer()
  {
    AppMethodBeat.i(190488);
    FrameLayout localFrameLayout = provideRootLayout(this);
    localFrameLayout.setId(609893468);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(190488);
    return localFrameLayout;
  }
  
  private void ensureFlutterFragmentCreated()
  {
    AppMethodBeat.i(190497);
    FragmentManager localFragmentManager = getSupportFragmentManager();
    this.flutterFragment = ((FlutterFragment)localFragmentManager.findFragmentByTag("flutter_fragment"));
    if (this.flutterFragment == null)
    {
      this.flutterFragment = createFlutterFragment();
      localFragmentManager.beginTransaction().a(609893468, this.flutterFragment, "flutter_fragment").FW();
    }
    AppMethodBeat.o(190497);
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(190478);
    for (;;)
    {
      try
      {
        Object localObject1 = getMetaData();
        if (localObject1 == null) {
          break label93;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
            AppMethodBeat.o(190478);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(190478);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(190478);
        return null;
      }
      AppMethodBeat.o(190478);
      return null;
      label93:
      Object localObject2 = null;
    }
  }
  
  private boolean isDebuggable()
  {
    AppMethodBeat.i(190514);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(190514);
      return true;
    }
    AppMethodBeat.o(190514);
    return false;
  }
  
  private void switchLaunchThemeForNormalTheme()
  {
    AppMethodBeat.i(190466);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        int i = localBundle.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
        AppMethodBeat.o(190466);
        return;
      }
      Log.v("FlutterFragmentActivity", "Using the launch theme as normal theme.");
      AppMethodBeat.o(190466);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("FlutterFragmentActivity", "Could not read meta-data for FlutterFragmentActivity. Using the launch theme as normal theme.");
      AppMethodBeat.o(190466);
    }
  }
  
  public static FlutterFragmentActivity.CachedEngineIntentBuilder withCachedEngine(String paramString)
  {
    AppMethodBeat.i(190459);
    paramString = new FlutterFragmentActivity.CachedEngineIntentBuilder(FlutterFragmentActivity.class, paramString);
    AppMethodBeat.o(190459);
    return paramString;
  }
  
  public static FlutterFragmentActivity.NewEngineIntentBuilder withNewEngine()
  {
    AppMethodBeat.i(190450);
    FlutterFragmentActivity.NewEngineIntentBuilder localNewEngineIntentBuilder = new FlutterFragmentActivity.NewEngineIntentBuilder(FlutterFragmentActivity.class);
    AppMethodBeat.o(190450);
    return localNewEngineIntentBuilder;
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190637);
    GeneratedPluginRegister.registerGeneratedPlugins(paramFlutterEngine);
    AppMethodBeat.o(190637);
  }
  
  protected FlutterFragment createFlutterFragment()
  {
    AppMethodBeat.i(190538);
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = getBackgroundMode();
    RenderMode localRenderMode = getRenderMode();
    if (localBackgroundMode == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {}
    for (Object localObject = TransparencyMode.opaque; getCachedEngineId() != null; localObject = TransparencyMode.transparent)
    {
      Log.v("FlutterFragmentActivity", "Creating FlutterFragment with cached engine:\nCached engine ID: " + getCachedEngineId() + "\nWill destroy engine when Activity is destroyed: " + shouldDestroyEngineWithHost() + "\nBackground transparency mode: " + localBackgroundMode + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
      localObject = FlutterFragment.withCachedEngine(getCachedEngineId()).renderMode(localRenderMode).transparencyMode((TransparencyMode)localObject).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).destroyEngineWithFragment(shouldDestroyEngineWithHost()).build();
      AppMethodBeat.o(190538);
      return localObject;
    }
    Log.v("FlutterFragmentActivity", "Creating FlutterFragment with new engine:\nBackground transparency mode: " + localBackgroundMode + "\nDart entrypoint: " + getDartEntrypointFunctionName() + "\nInitial route: " + getInitialRoute() + "\nApp bundle path: " + getAppBundlePath() + "\nWill attach FlutterEngine to Activity: " + shouldAttachEngineToActivity());
    localObject = FlutterFragment.withNewEngine().dartEntrypoint(getDartEntrypointFunctionName()).initialRoute(getInitialRoute()).appBundlePath(getAppBundlePath()).flutterShellArgs(FlutterShellArgs.fromIntent(getIntent())).handleDeeplinking(Boolean.valueOf(shouldHandleDeeplinking())).renderMode(localRenderMode).transparencyMode((TransparencyMode)localObject).shouldAttachEngineToActivity(shouldAttachEngineToActivity()).build();
    AppMethodBeat.o(190538);
    return localObject;
  }
  
  protected String getAppBundlePath()
  {
    AppMethodBeat.i(190649);
    if ((isDebuggable()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      String str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(190649);
        return str;
      }
    }
    AppMethodBeat.o(190649);
    return null;
  }
  
  protected FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(190684);
    if (getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(190684);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(190684);
    return localBackgroundMode;
  }
  
  protected String getCachedEngineId()
  {
    AppMethodBeat.i(190679);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(190679);
    return str;
  }
  
  public String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(190667);
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
            AppMethodBeat.o(190667);
            return localObject1;
          }
          AppMethodBeat.o(190667);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(190667);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  protected FlutterEngine getFlutterEngine()
  {
    AppMethodBeat.i(190604);
    FlutterEngine localFlutterEngine = this.flutterFragment.getFlutterEngine();
    AppMethodBeat.o(190604);
    return localFlutterEngine;
  }
  
  protected String getInitialRoute()
  {
    AppMethodBeat.i(190672);
    Object localObject;
    if (getIntent().hasExtra("route"))
    {
      localObject = getIntent().getStringExtra("route");
      AppMethodBeat.o(190672);
      return localObject;
    }
    try
    {
      localObject = getMetaData();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.flutter.InitialRoute");
        AppMethodBeat.o(190672);
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(190672);
      return null;
    }
    AppMethodBeat.o(190672);
    return null;
  }
  
  protected Bundle getMetaData()
  {
    AppMethodBeat.i(190661);
    Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    AppMethodBeat.o(190661);
    return localBundle;
  }
  
  protected RenderMode getRenderMode()
  {
    AppMethodBeat.i(190688);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = RenderMode.surface;
      AppMethodBeat.o(190688);
      return localRenderMode;
    }
    RenderMode localRenderMode = RenderMode.texture;
    AppMethodBeat.o(190688);
    return localRenderMode;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(190596);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.flutterFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(190596);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(190557);
    this.flutterFragment.onBackPressed();
    AppMethodBeat.o(190557);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190522);
    switchLaunchThemeForNormalTheme();
    super.onCreate(paramBundle);
    configureWindowForTransparency();
    setContentView(createFragmentContainer());
    configureStatusBarForFullscreenFlutterExperience();
    ensureFlutterFragmentCreated();
    AppMethodBeat.o(190522);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(190552);
    this.flutterFragment.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(190552);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(190544);
    super.onPostResume();
    this.flutterFragment.onPostResume();
    AppMethodBeat.o(190544);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190567);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.flutterFragment.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(190567);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(190588);
    super.onTrimMemory(paramInt);
    this.flutterFragment.onTrimMemory(paramInt);
    AppMethodBeat.o(190588);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(190577);
    this.flutterFragment.onUserLeaveHint();
    AppMethodBeat.o(190577);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    return null;
  }
  
  protected FrameLayout provideRootLayout(Context paramContext)
  {
    AppMethodBeat.i(190694);
    paramContext = new FrameLayout(paramContext);
    AppMethodBeat.o(190694);
    return paramContext;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(190528);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(190528);
      return localObject;
    }
    AppMethodBeat.o(190528);
    return null;
  }
  
  protected boolean shouldAttachEngineToActivity()
  {
    return true;
  }
  
  public boolean shouldDestroyEngineWithHost()
  {
    AppMethodBeat.i(190613);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(190613);
    return bool;
  }
  
  protected boolean shouldHandleDeeplinking()
  {
    AppMethodBeat.i(190625);
    try
    {
      Bundle localBundle = getMetaData();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("flutter_deeplinking_enabled");
        AppMethodBeat.o(190625);
        return bool;
      }
      AppMethodBeat.o(190625);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(190625);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */