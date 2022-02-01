package io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.m;
import io.flutter.a.a.m.c;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.j;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.a;
import io.flutter.view.FlutterView.b;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements m, b, FlutterView.b
{
  private static final WindowManager.LayoutParams IWJ;
  private final a IWK;
  private FlutterView IWL;
  private View IWM;
  private final Activity activity;
  
  static
  {
    AppMethodBeat.i(9669);
    IWJ = new WindowManager.LayoutParams(-1, -1);
    AppMethodBeat.o(9669);
  }
  
  public a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(9648);
    this.activity = ((Activity)io.flutter.c.b.checkNotNull(paramActivity));
    this.IWK = ((a)io.flutter.c.b.checkNotNull(parama));
    AppMethodBeat.o(9648);
  }
  
  private void aPI(String paramString)
  {
    AppMethodBeat.i(9666);
    if (!this.IWL.getFlutterNativeView().Jfa)
    {
      io.flutter.view.c localc = new io.flutter.view.c();
      localc.Jfc = paramString;
      localc.Jfd = "main";
      this.IWL.a(localc);
    }
    AppMethodBeat.o(9666);
  }
  
  private boolean bu(Intent paramIntent)
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
        this.IWL.setInitialRoute(str2);
      }
      aPI(paramIntent);
      AppMethodBeat.o(9665);
      return true;
    }
    AppMethodBeat.o(9665);
    return false;
  }
  
  private Drawable ftY()
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
      AppMethodBeat.o(9667);
    }
    return null;
  }
  
  /* Error */
  private Boolean ftZ()
  {
    // Byte code:
    //   0: sipush 9668
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 60	io/flutter/app/a:activity	Landroid/app/Activity;
    //   10: invokevirtual 174	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: aload_0
    //   14: getfield 60	io/flutter/app/a:activity	Landroid/app/Activity;
    //   17: invokevirtual 178	android/app/Activity:getComponentName	()Landroid/content/ComponentName;
    //   20: sipush 129
    //   23: invokevirtual 184	android/content/pm/PackageManager:getActivityInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    //   26: getfield 190	android/content/pm/ActivityInfo:metaData	Landroid/os/Bundle;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +25 -> 56
    //   34: aload_2
    //   35: ldc 192
    //   37: invokevirtual 198	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   40: ifeq +16 -> 56
    //   43: iconst_1
    //   44: istore_1
    //   45: sipush 9668
    //   48: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iload_1
    //   52: invokestatic 204	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: areturn
    //   56: iconst_0
    //   57: istore_1
    //   58: goto -13 -> 45
    //   61: astore_2
    //   62: getstatic 208	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   65: astore_2
    //   66: sipush 9668
    //   69: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_2
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   44	14	1	bool	boolean
    //   29	6	2	localBundle	android.os.Bundle
    //   61	1	2	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   65	8	2	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   6	30	61	android/content/pm/PackageManager$NameNotFoundException
    //   34	43	61	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public final boolean a(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(9651);
    boolean bool = this.IWL.getPluginRegistry().a(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(9651);
    return bool;
  }
  
  public final boolean aPH(String paramString)
  {
    AppMethodBeat.i(9649);
    boolean bool = this.IWL.getPluginRegistry().aPH(paramString);
    AppMethodBeat.o(9649);
    return bool;
  }
  
  public final m.c dB(String paramString)
  {
    AppMethodBeat.i(9650);
    paramString = this.IWL.getPluginRegistry().dB(paramString);
    AppMethodBeat.o(9650);
    return paramString;
  }
  
  public final void ftX()
  {
    FlutterView.a local1 = null;
    AppMethodBeat.i(9653);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = this.activity.getWindow();
      ((Window)localObject1).addFlags(-2147483648);
      ((Window)localObject1).setStatusBarColor(1073741824);
      ((Window)localObject1).getDecorView().setSystemUiVisibility(1280);
    }
    Object localObject1 = this.activity.getIntent();
    Object localObject2 = new ArrayList();
    if (((Intent)localObject1).getBooleanExtra("trace-startup", false)) {
      ((ArrayList)localObject2).add("--trace-startup");
    }
    if (((Intent)localObject1).getBooleanExtra("start-paused", false)) {
      ((ArrayList)localObject2).add("--start-paused");
    }
    if (((Intent)localObject1).getBooleanExtra("disable-service-auth-codes", false)) {
      ((ArrayList)localObject2).add("--disable-service-auth-codes");
    }
    if (((Intent)localObject1).getBooleanExtra("use-test-fonts", false)) {
      ((ArrayList)localObject2).add("--use-test-fonts");
    }
    if (((Intent)localObject1).getBooleanExtra("enable-dart-profiling", false)) {
      ((ArrayList)localObject2).add("--enable-dart-profiling");
    }
    if (((Intent)localObject1).getBooleanExtra("enable-software-rendering", false)) {
      ((ArrayList)localObject2).add("--enable-software-rendering");
    }
    if (((Intent)localObject1).getBooleanExtra("skia-deterministic-rendering", false)) {
      ((ArrayList)localObject2).add("--skia-deterministic-rendering");
    }
    if (((Intent)localObject1).getBooleanExtra("trace-skia", false)) {
      ((ArrayList)localObject2).add("--trace-skia");
    }
    if (((Intent)localObject1).getBooleanExtra("trace-systrace", false)) {
      ((ArrayList)localObject2).add("--trace-systrace");
    }
    if (((Intent)localObject1).getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      ((ArrayList)localObject2).add("--dump-skp-on-shader-compilation");
    }
    if (((Intent)localObject1).getBooleanExtra("verbose-logging", false)) {
      ((ArrayList)localObject2).add("--verbose-logging");
    }
    int i = ((Intent)localObject1).getIntExtra("observatory-port", 0);
    if (i > 0) {
      ((ArrayList)localObject2).add("--observatory-port=" + Integer.toString(i));
    }
    if (((Intent)localObject1).getBooleanExtra("disable-service-auth-codes", false)) {
      ((ArrayList)localObject2).add("--disable-service-auth-codes");
    }
    if (((Intent)localObject1).hasExtra("dart-flags")) {
      ((ArrayList)localObject2).add("--dart-flags=" + ((Intent)localObject1).getStringExtra("dart-flags"));
    }
    if (!((ArrayList)localObject2).isEmpty())
    {
      localObject1 = (String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]);
      FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), (String[])localObject1);
      this.IWL = null;
      if (this.IWL == null)
      {
        this.IWL = new FlutterView(this.activity, null, null);
        this.IWL.setLayoutParams(IWJ);
        this.activity.setContentView(this.IWL);
        if (ftZ().booleanValue()) {
          break label573;
        }
        localObject1 = local1;
      }
    }
    for (;;)
    {
      this.IWM = ((View)localObject1);
      if ((this.IWM != null) && (this.IWM != null))
      {
        this.activity.addContentView(this.IWM, IWJ);
        localObject1 = this.IWL;
        local1 = new FlutterView.a()
        {
          public final void onFirstFrame()
          {
            AppMethodBeat.i(9594);
            a.a(a.this).animate().alpha(0.0F).setListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(9623);
                ((ViewGroup)a.a(a.this).getParent()).removeView(a.a(a.this));
                a.b(a.this);
                AppMethodBeat.o(9623);
              }
            });
            a.c(a.this).Jfk.remove(this);
            AppMethodBeat.o(9594);
          }
        };
        ((FlutterView)localObject1).Jfk.add(local1);
        this.activity.setTheme(16973833);
      }
      if (!bu(this.activity.getIntent())) {
        break label614;
      }
      AppMethodBeat.o(9653);
      return;
      localObject1 = null;
      break;
      label573:
      localObject2 = ftY();
      localObject1 = local1;
      if (localObject2 != null)
      {
        localObject1 = new View(this.activity);
        ((View)localObject1).setLayoutParams(IWJ);
        ((View)localObject1).setBackground((Drawable)localObject2);
      }
    }
    label614:
    localObject1 = FlutterMain.findAppBundlePath();
    if (localObject1 != null) {
      aPI((String)localObject1);
    }
    AppMethodBeat.o(9653);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(9652);
    boolean bool = this.IWL.getPluginRegistry().onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(9652);
    return bool;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(9661);
    if (this.IWL != null)
    {
      this.IWL.IYk.cuK();
      AppMethodBeat.o(9661);
      return true;
    }
    AppMethodBeat.o(9661);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
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
    if (this.IWL != null)
    {
      if (this.IWL.getPluginRegistry().a(this.IWL.getFlutterNativeView()))
      {
        localObject = this.IWL;
        if (((FlutterView)localObject).isAttached())
        {
          ((FlutterView)localObject).getHolder().removeCallback(((FlutterView)localObject).Jfh);
          FlutterNativeView localFlutterNativeView = ((FlutterView)localObject).IWP;
          c localc = localFlutterNativeView.JeY;
          localc.IWR.detach();
          localc.IWR.fvh();
          localc.IWQ = null;
          localc.mActivity = null;
          localFlutterNativeView.IWQ = null;
          ((FlutterView)localObject).IWP = null;
        }
        AppMethodBeat.o(9660);
        return;
      }
      this.IWL.destroy();
    }
    AppMethodBeat.o(9660);
  }
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(9664);
    this.IWL.IYo.fvb();
    AppMethodBeat.o(9664);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(9654);
    if ((this.activity.getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!bu(paramIntent))) {
        this.IWL.getPluginRegistry().onNewIntent(paramIntent);
      }
      AppMethodBeat.o(9654);
      return;
    }
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
    if (this.IWL != null) {
      this.IWL.IYi.fuV();
    }
    AppMethodBeat.o(9655);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(9659);
    if (this.IWL != null) {
      this.IWL.onPostResume();
    }
    AppMethodBeat.o(9659);
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
    if (this.IWL != null) {
      this.IWL.IYi.fuV();
    }
    AppMethodBeat.o(9656);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(9658);
    this.IWL.IYi.fuX();
    AppMethodBeat.o(9658);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(9663);
    if (paramInt == 10) {
      this.IWL.IYo.fvb();
    }
    AppMethodBeat.o(9663);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(9662);
    this.IWL.getPluginRegistry().onUserLeaveHint();
    AppMethodBeat.o(9662);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.app.a
 * JD-Core Version:    0.7.0.1
 */