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
import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.b;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Method;

public class FlutterActivity
  extends HellActivity
  implements LifecycleOwner, c.a
{
  protected c SMA;
  private LifecycleRegistry crq;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(10028);
    this.crq = new LifecycleRegistry(this);
    AppMethodBeat.o(10028);
  }
  
  private Drawable KG()
  {
    AppMethodBeat.i(10031);
    for (;;)
    {
      try
      {
        Object localObject = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject == null) {
          break label102;
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
      label102:
      int i = 0;
    }
  }
  
  private d.a KH()
  {
    AppMethodBeat.i(215113);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(215113);
      return locala;
    }
    d.a locala = d.a.SMF;
    AppMethodBeat.o(215113);
    return locala;
  }
  
  public final j KF()
  {
    AppMethodBeat.i(10030);
    Object localObject = KG();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(10030);
      return localObject;
    }
    AppMethodBeat.o(10030);
    return null;
  }
  
  public final String KJ()
  {
    AppMethodBeat.i(10045);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(10045);
    return str;
  }
  
  public final String KK()
  {
    AppMethodBeat.i(10047);
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
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
  
  public final String KL()
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
  
  public final String KM()
  {
    AppMethodBeat.i(10048);
    Object localObject1;
    if (getIntent().hasExtra("route"))
    {
      localObject1 = getIntent().getStringExtra("route");
      AppMethodBeat.o(10048);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
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
  
  public final io.flutter.embedding.engine.a KP()
  {
    return null;
  }
  
  public final b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10053);
    if (paramActivity != null)
    {
      paramActivity = new b(this, parama.SOe);
      AppMethodBeat.o(10053);
      return paramActivity;
    }
    AppMethodBeat.o(10053);
    return null;
  }
  
  public final void b(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(215114);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
      AppMethodBeat.o(215114);
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("Tried to automatically register plugins with FlutterEngine (").append(parama).append(") but could not find and invoke the GeneratedPluginRegistrant.");
      io.flutter.a.hwf();
      AppMethodBeat.o(215114);
    }
  }
  
  public final void c(io.flutter.embedding.engine.a parama) {}
  
  public final void dLt()
  {
    AppMethodBeat.i(215115);
    if (Build.VERSION.SDK_INT >= 21) {
      reportFullyDrawn();
    }
    AppMethodBeat.o(215115);
  }
  
  public final void dLu() {}
  
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
    return this.crq;
  }
  
  public final d hwl()
  {
    AppMethodBeat.i(10044);
    d locald = d.bO(getIntent());
    AppMethodBeat.o(10044);
    return locald;
  }
  
  public final boolean hwm()
  {
    AppMethodBeat.i(10046);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((KJ() != null) || (this.SMA.Syd))
    {
      AppMethodBeat.o(10046);
      return bool;
    }
    bool = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    AppMethodBeat.o(10046);
    return bool;
  }
  
  public final i hwn()
  {
    AppMethodBeat.i(215111);
    if (KH() == d.a.SMF)
    {
      locali = i.SNO;
      AppMethodBeat.o(215111);
      return locali;
    }
    i locali = i.SNP;
    AppMethodBeat.o(215111);
    return locali;
  }
  
  public final l hwo()
  {
    AppMethodBeat.i(215112);
    if (KH() == d.a.SMF)
    {
      locall = l.SNS;
      AppMethodBeat.o(215112);
      return locall;
    }
    l locall = l.SNT;
    AppMethodBeat.o(215112);
    return locall;
  }
  
  public final boolean hwp()
  {
    return true;
  }
  
  public final boolean hwq()
  {
    AppMethodBeat.i(215116);
    if (getIntent().hasExtra("enable_state_restoration"))
    {
      boolean bool = getIntent().getBooleanExtra("enable_state_restoration", false);
      AppMethodBeat.o(215116);
      return bool;
    }
    if (KJ() != null)
    {
      AppMethodBeat.o(215116);
      return false;
    }
    AppMethodBeat.o(215116);
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10038);
    this.SMA.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(10038);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(10040);
    this.SMA.onBackPressed();
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
        io.flutter.a.hwg();
        continue;
      }
      super.onCreate(paramBundle);
      this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.SMA = new c(this);
      this.SMA.hrO();
      this.SMA.onActivityCreated(paramBundle);
      if (KH() == d.a.SMG) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      setContentView(this.SMA.hrQ());
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      AppMethodBeat.o(10029);
      return;
      io.flutter.a.hwd();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(10037);
    super.onDestroy();
    this.SMA.onDestroyView();
    this.SMA.onDetach();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(10037);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10039);
    super.onNewIntent(paramIntent);
    this.SMA.onNewIntent(paramIntent);
    AppMethodBeat.o(10039);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10035);
    super.onPause();
    this.SMA.onPause();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(10035);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(10034);
    super.onPostResume();
    this.SMA.onPostResume();
    AppMethodBeat.o(10034);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10041);
    this.SMA.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(10041);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10033);
    super.onResume();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.SMA.onResume();
    AppMethodBeat.o(10033);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(215110);
    super.onSaveInstanceState(paramBundle);
    this.SMA.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(215110);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(10032);
    super.onStart();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.SMA.onStart();
    AppMethodBeat.o(10032);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10036);
    super.onStop();
    this.SMA.onStop();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(10036);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(10043);
    super.onTrimMemory(paramInt);
    this.SMA.onTrimMemory(paramInt);
    AppMethodBeat.o(10043);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(10042);
    this.SMA.onUserLeaveHint();
    AppMethodBeat.o(10042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */