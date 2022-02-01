package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import io.flutter.embedding.engine.c.j;
import io.flutter.view.FlutterMain;
import java.util.ArrayList;

public class FlutterActivity
  extends HellActivity
  implements LifecycleOwner, c.a
{
  protected static final String IXj;
  private c IXk;
  private LifecycleRegistry IXl;
  
  static
  {
    AppMethodBeat.i(10054);
    IXj = FlutterActivity.a.IXm.name();
    AppMethodBeat.o(10054);
  }
  
  public FlutterActivity()
  {
    AppMethodBeat.i(10028);
    this.IXl = new LifecycleRegistry(this);
    AppMethodBeat.o(10028);
  }
  
  private Drawable fub()
  {
    AppMethodBeat.i(10031);
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 == null) {
          break label111;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
            AppMethodBeat.o(10031);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(10031);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10031);
        return null;
      }
      AppMethodBeat.o(10031);
      return null;
      label111:
      Object localObject2 = null;
    }
  }
  
  private FlutterActivity.a fuk()
  {
    AppMethodBeat.i(10052);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = FlutterActivity.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(10052);
      return locala;
    }
    FlutterActivity.a locala = FlutterActivity.a.IXm;
    AppMethodBeat.o(10052);
    return locala;
  }
  
  public final io.flutter.a.c.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10053);
    if (paramActivity != null)
    {
      paramActivity = new io.flutter.a.c.b(this, parama.IYm);
      AppMethodBeat.o(10053);
      return paramActivity;
    }
    AppMethodBeat.o(10053);
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final f fua()
  {
    AppMethodBeat.i(10030);
    Object localObject = fub();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(10030);
      return localObject;
    }
    AppMethodBeat.o(10030);
    return null;
  }
  
  public final io.flutter.embedding.engine.e fuc()
  {
    AppMethodBeat.i(10044);
    Object localObject = getIntent();
    ArrayList localArrayList = new ArrayList();
    if (((Intent)localObject).getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (((Intent)localObject).getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    int i = ((Intent)localObject).getIntExtra("observatory-port", 0);
    if (i > 0) {
      localArrayList.add("--observatory-port=" + Integer.toString(i));
    }
    if (((Intent)localObject).getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (((Intent)localObject).getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (((Intent)localObject).getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (((Intent)localObject).getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (((Intent)localObject).getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (((Intent)localObject).getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (((Intent)localObject).getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("dump-skp-on-shader-compilation");
    }
    if (((Intent)localObject).getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    localObject = new io.flutter.embedding.engine.e(localArrayList);
    AppMethodBeat.o(10044);
    return localObject;
  }
  
  public final String fud()
  {
    AppMethodBeat.i(10045);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(10045);
    return str;
  }
  
  public final boolean fue()
  {
    AppMethodBeat.i(10046);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(10046);
    return bool;
  }
  
  public final String fuf()
  {
    AppMethodBeat.i(10047);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(10047);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(10047);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10047);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(10047);
    return "main";
  }
  
  public final String fug()
  {
    AppMethodBeat.i(10048);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(10048);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 129).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.InitialRoute");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(10048);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10048);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(10048);
    return "/";
  }
  
  public final String fuh()
  {
    AppMethodBeat.i(10049);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(10049);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(10049);
    return str;
  }
  
  public final FlutterView.b fui()
  {
    AppMethodBeat.i(10050);
    if (fuk() == FlutterActivity.a.IXm)
    {
      localb = FlutterView.b.IXX;
      AppMethodBeat.o(10050);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.IXY;
    AppMethodBeat.o(10050);
    return localb;
  }
  
  public final FlutterView.c fuj()
  {
    AppMethodBeat.i(10051);
    if (fuk() == FlutterActivity.a.IXm)
    {
      localc = FlutterView.c.IYa;
      AppMethodBeat.o(10051);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.IYb;
    AppMethodBeat.o(10051);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a ful()
  {
    return null;
  }
  
  public final boolean fum()
  {
    return true;
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.IXl;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10038);
    this.IXk.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10038);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(10040);
    c localc = this.IXk;
    localc.fup();
    if (localc.rdu != null)
    {
      io.flutter.a.ftS();
      localc.rdu.IYk.cuK();
      AppMethodBeat.o(10040);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10040);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(10029);
    for (;;)
    {
      try
      {
        ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
        if (localActivityInfo.metaData == null) {
          continue;
        }
        int i = localActivityInfo.metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        io.flutter.a.ftV();
        continue;
      }
      super.onCreate(paramBundle);
      this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.IXk = new c(this);
      this.IXk.onAttach(this);
      if (fuk() == FlutterActivity.a.IXn)
      {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
      }
      setContentView(this.IXk.fuo());
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      AppMethodBeat.o(10029);
      return;
      io.flutter.a.ftT();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(10037);
    super.onDestroy();
    this.IXk.onDestroyView();
    this.IXk.onDetach();
    this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(10037);
  }
  
  public final void onFirstFrameRendered() {}
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10039);
    super.onNewIntent(paramIntent);
    c localc = this.IXk;
    localc.fup();
    if (localc.rdu != null)
    {
      io.flutter.a.ftS();
      localc.rdu.IYf.onNewIntent(paramIntent);
      AppMethodBeat.o(10039);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10039);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10035);
    super.onPause();
    this.IXk.onPause();
    this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(10035);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(10034);
    super.onPostResume();
    c localc = this.IXk;
    io.flutter.a.ftS();
    localc.fup();
    if (localc.rdu != null)
    {
      if (localc.IXr != null)
      {
        localc.IXr.fve();
        AppMethodBeat.o(10034);
      }
    }
    else {
      io.flutter.a.ftU();
    }
    AppMethodBeat.o(10034);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10041);
    this.IXk.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10041);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10033);
    super.onResume();
    this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.IXk.onResume();
    AppMethodBeat.o(10033);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(10032);
    super.onStart();
    this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.IXk.onStart();
    AppMethodBeat.o(10032);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10036);
    super.onStop();
    this.IXk.onStop();
    this.IXl.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(10036);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(10043);
    super.onTrimMemory(paramInt);
    c localc = this.IXk;
    localc.fup();
    if (localc.rdu != null)
    {
      if (paramInt == 10)
      {
        io.flutter.a.ftS();
        localc.rdu.IYo.fvb();
        AppMethodBeat.o(10043);
      }
    }
    else {
      io.flutter.a.ftU();
    }
    AppMethodBeat.o(10043);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(10042);
    c localc = this.IXk;
    localc.fup();
    if (localc.rdu != null)
    {
      io.flutter.a.ftS();
      localc.rdu.IYf.onUserLeaveHint();
      AppMethodBeat.o(10042);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */