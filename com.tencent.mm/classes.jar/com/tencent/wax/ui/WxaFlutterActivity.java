package com.tencent.wax.ui;

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
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.b.b;
import com.tencent.wax.d;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.h;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity
  extends AppCompatActivity
  implements LifecycleOwner, b, a.a
{
  public static final String vlc;
  public Toolbar azm;
  protected a vkX;
  protected String vla;
  private LifecycleRegistry vld;
  
  static
  {
    AppMethodBeat.i(195549);
    vlc = d.a.MYs.name();
    AppMethodBeat.o(195549);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(195521);
    this.vld = new LifecycleRegistry(this);
    AppMethodBeat.o(195521);
  }
  
  private Drawable diQ()
  {
    AppMethodBeat.i(195524);
    for (;;)
    {
      try
      {
        Object localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject1 == null) {
          break label106;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
            AppMethodBeat.o(195524);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(195524);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(195524);
        return null;
      }
      AppMethodBeat.o(195524);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a diU()
  {
    AppMethodBeat.i(195525);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(195525);
      return locala;
    }
    d.a locala = d.a.MYs;
    AppMethodBeat.o(195525);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final b diH()
  {
    return this;
  }
  
  public final String diI()
  {
    AppMethodBeat.i(195538);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(195538);
    return str;
  }
  
  public final String diJ()
  {
    AppMethodBeat.i(195539);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(195539);
      return localObject1;
    }
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 == null) {
            break;
          }
          AppMethodBeat.o(195539);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(195539);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(195539);
    return "main";
  }
  
  public final String diK()
  {
    AppMethodBeat.i(195540);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(195540);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(195540);
    return str;
  }
  
  public final String diL()
  {
    AppMethodBeat.i(195541);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(195541);
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
          AppMethodBeat.o(195541);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(195541);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(195541);
    return "/";
  }
  
  public final FlutterView.b diM()
  {
    AppMethodBeat.i(195542);
    if (diU() == d.a.MYs)
    {
      localb = FlutterView.b.MYZ;
      AppMethodBeat.o(195542);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.MZa;
    AppMethodBeat.o(195542);
    return localb;
  }
  
  public final FlutterView.c diN()
  {
    AppMethodBeat.i(195543);
    if (diU() == d.a.MYs)
    {
      localc = FlutterView.c.MZc;
      AppMethodBeat.o(195543);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.MZd;
    AppMethodBeat.o(195543);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a diO()
  {
    AppMethodBeat.i(195544);
    io.flutter.embedding.engine.a locala = d.gdr().cPI;
    AppMethodBeat.o(195544);
    return locala;
  }
  
  public final h diP()
  {
    AppMethodBeat.i(195523);
    Object localObject = diQ();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(195523);
      return localObject;
    }
    AppMethodBeat.o(195523);
    return null;
  }
  
  public final String diR()
  {
    AppMethodBeat.i(195546);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(195546);
      return str;
    }
    if (TextUtils.isEmpty(this.vla)) {
      this.vla = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.vla;
    AppMethodBeat.o(195546);
    return str;
  }
  
  public final String diS()
  {
    AppMethodBeat.i(195547);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(195547);
      return str;
    }
    AppMethodBeat.o(195547);
    return "";
  }
  
  public final Map diT()
  {
    AppMethodBeat.i(195548);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(195548);
      return localMap;
    }
    AppMethodBeat.o(195548);
    return null;
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
    return this.vld;
  }
  
  public final void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(195545);
    com.tencent.wax.c.a.i("WxaRouter.WxaFlutterActivity", "setIsPopGestureEnabled value:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(195545);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(195532);
    this.vkX.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(195532);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(195534);
    this.vkX.onBackPressed();
    AppMethodBeat.o(195534);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195522);
    for (;;)
    {
      try
      {
        localObject = getPackageManager().getActivityInfo(getComponentName(), 128);
        if (((ActivityInfo)localObject).metaData == null) {
          continue;
        }
        int i = ((ActivityInfo)localObject).metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject;
        com.tencent.wax.c.a.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.", new Object[0]);
        continue;
      }
      super.onCreate(paramBundle);
      this.vld.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.vkX = new a(this);
      this.vkX.gdx();
      paramBundle = new LinearLayout(getContext());
      paramBundle.setOrientation(1);
      localObject = new Toolbar(this);
      ((Toolbar)localObject).setLayoutParams(new Toolbar.LayoutParams(-1));
      ((Toolbar)localObject).mW();
      ((Toolbar)localObject).setVisibility(8);
      this.azm = ((Toolbar)localObject);
      if (this.azm != null)
      {
        paramBundle.addView(this.azm);
        setSupportActionBar(this.azm);
      }
      paramBundle.addView(this.vkX.gdz(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(195522);
      return;
      com.tencent.wax.c.a.d("FlutterActivity", "Using the launch theme as normal theme.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(195531);
    super.onDestroy();
    this.vkX.onDestroyView();
    this.vkX.onDetach();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(195531);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(195533);
    super.onNewIntent(paramIntent);
    this.vkX.onNewIntent(paramIntent);
    AppMethodBeat.o(195533);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(195529);
    super.onPause();
    this.vkX.onPause();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(195529);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(195528);
    super.onPostResume();
    this.vkX.onPostResume();
    AppMethodBeat.o(195528);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195535);
    this.vkX.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(195535);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(195527);
    super.onResume();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.vkX.onResume();
    AppMethodBeat.o(195527);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(195526);
    super.onStart();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.vkX.onStart();
    AppMethodBeat.o(195526);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(195530);
    super.onStop();
    this.vkX.onStop();
    this.vld.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(195530);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(195537);
    this.vkX.onTrimMemory(paramInt);
    AppMethodBeat.o(195537);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(195536);
    this.vkX.onUserLeaveHint();
    AppMethodBeat.o(195536);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.ui.WxaFlutterActivity
 * JD-Core Version:    0.7.0.1
 */