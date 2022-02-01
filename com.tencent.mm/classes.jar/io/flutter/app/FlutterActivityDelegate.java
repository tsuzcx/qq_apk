package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.util.Preconditions;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.FirstFrameListener;
import io.flutter.view.FlutterView.Provider;
import java.util.ArrayList;

@Deprecated
public final class FlutterActivityDelegate
  implements FlutterActivityEvents, PluginRegistry, FlutterView.Provider
{
  private static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.app.android.SplashScreenUntilFirstFrame";
  private static final String TAG = "FlutterActivityDelegate";
  private static final WindowManager.LayoutParams matchParent;
  private final Activity activity;
  private FlutterView flutterView;
  private View launchView;
  private final ViewFactory viewFactory;
  
  static
  {
    AppMethodBeat.i(9669);
    matchParent = new WindowManager.LayoutParams(-1, -1);
    AppMethodBeat.o(9669);
  }
  
  public FlutterActivityDelegate(Activity paramActivity, ViewFactory paramViewFactory)
  {
    AppMethodBeat.i(9648);
    this.activity = ((Activity)Preconditions.checkNotNull(paramActivity));
    this.viewFactory = ((ViewFactory)Preconditions.checkNotNull(paramViewFactory));
    AppMethodBeat.o(9648);
  }
  
  private void addLaunchView()
  {
    AppMethodBeat.i(189636);
    if (this.launchView == null)
    {
      AppMethodBeat.o(189636);
      return;
    }
    this.activity.addContentView(this.launchView, matchParent);
    this.flutterView.addFirstFrameListener(new FlutterView.FirstFrameListener()
    {
      public void onFirstFrame()
      {
        AppMethodBeat.i(9594);
        FlutterActivityDelegate.this.launchView.animate().alpha(0.0F).setListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(9623);
            ((ViewGroup)FlutterActivityDelegate.this.launchView.getParent()).removeView(FlutterActivityDelegate.this.launchView);
            FlutterActivityDelegate.access$002(FlutterActivityDelegate.this, null);
            AppMethodBeat.o(9623);
          }
        });
        FlutterActivityDelegate.this.flutterView.removeFirstFrameListener(this);
        AppMethodBeat.o(9594);
      }
    });
    this.activity.setTheme(16973833);
    AppMethodBeat.o(189636);
  }
  
  private View createLaunchView()
  {
    AppMethodBeat.i(189610);
    if (!showSplashScreenUntilFirstFrame().booleanValue())
    {
      AppMethodBeat.o(189610);
      return null;
    }
    Drawable localDrawable = getLaunchScreenDrawableFromActivityTheme();
    if (localDrawable == null)
    {
      AppMethodBeat.o(189610);
      return null;
    }
    View localView = new View(this.activity);
    localView.setLayoutParams(matchParent);
    localView.setBackground(localDrawable);
    AppMethodBeat.o(189610);
    return localView;
  }
  
  private static String[] getArgsFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(189588);
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("trace-systrace", false)) {
      localArrayList.add("--trace-systrace");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("cache-sksl", false)) {
      localArrayList.add("--cache-sksl");
    }
    if (paramIntent.getBooleanExtra("purge-persistent-cache", false)) {
      localArrayList.add("--purge-persistent-cache");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    if (i > 0) {
      localArrayList.add("--observatory-port=" + Integer.toString(i));
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("endless-trace-buffer", false)) {
      localArrayList.add("--endless-trace-buffer");
    }
    if (paramIntent.hasExtra("dart-flags")) {
      localArrayList.add("--dart-flags=" + paramIntent.getStringExtra("dart-flags"));
    }
    if (!localArrayList.isEmpty())
    {
      paramIntent = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      AppMethodBeat.o(189588);
      return paramIntent;
    }
    AppMethodBeat.o(189588);
    return null;
  }
  
  private Drawable getLaunchScreenDrawableFromActivityTheme()
  {
    AppMethodBeat.i(9667);
    Object localObject = new TypedValue();
    if (!this.activity.getTheme().resolveAttribute(16842836, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(9667);
      return null;
    }
    if (((TypedValue)localObject).resourceId == 0)
    {
      AppMethodBeat.o(9667);
      return null;
    }
    try
    {
      localObject = this.activity.getResources().getDrawable(((TypedValue)localObject).resourceId);
      AppMethodBeat.o(9667);
      return localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("FlutterActivityDelegate", "Referenced launch screen windowBackground resource does not exist");
      AppMethodBeat.o(9667);
    }
    return null;
  }
  
  private boolean isDebuggable()
  {
    AppMethodBeat.i(189579);
    if ((this.activity.getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(189579);
      return true;
    }
    AppMethodBeat.o(189579);
    return false;
  }
  
  private boolean loadIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9665);
    if ("android.intent.action.RUN".equals(paramIntent.getAction()))
    {
      String str2 = paramIntent.getStringExtra("route");
      String str1 = paramIntent.getDataString();
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = FlutterMain.findAppBundlePath();
      }
      if (str2 != null) {
        this.flutterView.setInitialRoute(str2);
      }
      runBundle(paramIntent);
      AppMethodBeat.o(9665);
      return true;
    }
    AppMethodBeat.o(9665);
    return false;
  }
  
  private void runBundle(String paramString)
  {
    AppMethodBeat.i(9666);
    if (!this.flutterView.getFlutterNativeView().isApplicationRunning())
    {
      FlutterRunArguments localFlutterRunArguments = new FlutterRunArguments();
      localFlutterRunArguments.bundlePath = paramString;
      localFlutterRunArguments.entrypoint = "main";
      this.flutterView.runFromBundle(localFlutterRunArguments);
    }
    AppMethodBeat.o(9666);
  }
  
  /* Error */
  private Boolean showSplashScreenUntilFirstFrame()
  {
    // Byte code:
    //   0: sipush 9668
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 68	io/flutter/app/FlutterActivityDelegate:activity	Landroid/app/Activity;
    //   10: invokevirtual 359	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: aload_0
    //   14: getfield 68	io/flutter/app/FlutterActivityDelegate:activity	Landroid/app/Activity;
    //   17: invokevirtual 363	android/app/Activity:getComponentName	()Landroid/content/ComponentName;
    //   20: sipush 129
    //   23: invokevirtual 369	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   26: getfield 375	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +25 -> 56
    //   34: aload_2
    //   35: ldc 22
    //   37: invokevirtual 380	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   40: ifeq +16 -> 56
    //   43: iconst_1
    //   44: istore_1
    //   45: sipush 9668
    //   48: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iload_1
    //   52: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: areturn
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -13 -> 45
    //   61: astore_2
    //   62: getstatic 388	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   65: astore_2
    //   66: sipush 9668
    //   69: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_2
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	FlutterActivityDelegate
    //   44	14	1	bool	boolean
    //   29	6	2	localBundle	Bundle
    //   61	1	2	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   65	8	2	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   6	30	61	android/content/pm/PackageManager$NameNotFoundException
    //   34	43	61	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final FlutterView getFlutterView()
  {
    return this.flutterView;
  }
  
  public final boolean hasPlugin(String paramString)
  {
    AppMethodBeat.i(9649);
    boolean bool = this.flutterView.getPluginRegistry().hasPlugin(paramString);
    AppMethodBeat.o(9649);
    return bool;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9652);
    boolean bool = this.flutterView.getPluginRegistry().onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(9652);
    return bool;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(9661);
    if (this.flutterView != null)
    {
      this.flutterView.popRoute();
      AppMethodBeat.o(9661);
      return true;
    }
    AppMethodBeat.o(9661);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189733);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = this.activity.getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(1073741824);
      paramBundle.getDecorView().setSystemUiVisibility(1280);
    }
    paramBundle = getArgsFromIntent(this.activity.getIntent());
    FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), paramBundle);
    this.flutterView = this.viewFactory.createFlutterView(this.activity);
    if (this.flutterView == null)
    {
      paramBundle = this.viewFactory.createFlutterNativeView();
      this.flutterView = new FlutterView(this.activity, null, paramBundle);
      this.flutterView.setLayoutParams(matchParent);
      this.activity.setContentView(this.flutterView);
      this.launchView = createLaunchView();
      if (this.launchView != null) {
        addLaunchView();
      }
    }
    if (loadIntent(this.activity.getIntent()))
    {
      AppMethodBeat.o(189733);
      return;
    }
    paramBundle = FlutterMain.findAppBundlePath();
    if (paramBundle != null) {
      runBundle(paramBundle);
    }
    AppMethodBeat.o(189733);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9660);
    Object localObject = (Application)this.activity.getApplicationContext();
    if ((localObject instanceof FlutterApplication))
    {
      localObject = (FlutterApplication)localObject;
      if (this.activity.equals(((FlutterApplication)localObject).getCurrentActivity())) {
        ((FlutterApplication)localObject).setCurrentActivity(null);
      }
    }
    if (this.flutterView != null)
    {
      if ((this.flutterView.getPluginRegistry().onViewDestroy(this.flutterView.getFlutterNativeView())) || (this.viewFactory.retainFlutterNativeView()))
      {
        this.flutterView.detach();
        AppMethodBeat.o(9660);
        return;
      }
      this.flutterView.destroy();
    }
    AppMethodBeat.o(9660);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(9664);
    this.flutterView.onMemoryPressure();
    AppMethodBeat.o(9664);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9654);
    if ((!isDebuggable()) || (!loadIntent(paramIntent))) {
      this.flutterView.getPluginRegistry().onNewIntent(paramIntent);
    }
    AppMethodBeat.o(9654);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(9655);
    Object localObject = (Application)this.activity.getApplicationContext();
    if ((localObject instanceof FlutterApplication))
    {
      localObject = (FlutterApplication)localObject;
      if (this.activity.equals(((FlutterApplication)localObject).getCurrentActivity())) {
        ((FlutterApplication)localObject).setCurrentActivity(null);
      }
    }
    if (this.flutterView != null) {
      this.flutterView.onPause();
    }
    AppMethodBeat.o(9655);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(9659);
    if (this.flutterView != null) {
      this.flutterView.onPostResume();
    }
    AppMethodBeat.o(9659);
  }
  
  public final boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9651);
    boolean bool = this.flutterView.getPluginRegistry().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9651);
    return bool;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(9657);
    Application localApplication = (Application)this.activity.getApplicationContext();
    if ((localApplication instanceof FlutterApplication)) {
      ((FlutterApplication)localApplication).setCurrentActivity(this.activity);
    }
    AppMethodBeat.o(9657);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(9656);
    if (this.flutterView != null) {
      this.flutterView.onStart();
    }
    AppMethodBeat.o(9656);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(9658);
    this.flutterView.onStop();
    AppMethodBeat.o(9658);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9663);
    if (paramInt == 10) {
      this.flutterView.onMemoryPressure();
    }
    AppMethodBeat.o(9663);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(9662);
    this.flutterView.getPluginRegistry().onUserLeaveHint();
    AppMethodBeat.o(9662);
  }
  
  public final PluginRegistry.Registrar registrarFor(String paramString)
  {
    AppMethodBeat.i(9650);
    paramString = this.flutterView.getPluginRegistry().registrarFor(paramString);
    AppMethodBeat.o(9650);
    return paramString;
  }
  
  public final <T> T valuePublishedByPlugin(String paramString)
  {
    AppMethodBeat.i(189701);
    paramString = this.flutterView.getPluginRegistry().valuePublishedByPlugin(paramString);
    AppMethodBeat.o(189701);
    return paramString;
  }
  
  public static abstract interface ViewFactory
  {
    public abstract FlutterNativeView createFlutterNativeView();
    
    public abstract FlutterView createFlutterView(Context paramContext);
    
    public abstract boolean retainFlutterNativeView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.app.FlutterActivityDelegate
 * JD-Core Version:    0.7.0.1
 */