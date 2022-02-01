package com.tencent.wxa.ui;

import android.app.Activity;
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
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity
  extends AppCompatActivity
  implements q, b, a.a
{
  public static final String DEFAULT_BACKGROUND_MODE;
  protected String egQ;
  protected a egR;
  private s lifecycle;
  public Toolbar yi;
  
  static
  {
    AppMethodBeat.i(210541);
    DEFAULT_BACKGROUND_MODE = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
    AppMethodBeat.o(210541);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(210519);
    this.lifecycle = new s(this);
    AppMethodBeat.o(210519);
  }
  
  private FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode()
  {
    AppMethodBeat.i(210535);
    if (getIntent().hasExtra("background_mode"))
    {
      localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(210535);
      return localBackgroundMode;
    }
    FlutterActivityLaunchConfigs.BackgroundMode localBackgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    AppMethodBeat.o(210535);
    return localBackgroundMode;
  }
  
  private Drawable getSplashScreenFromManifest()
  {
    AppMethodBeat.i(210530);
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
            AppMethodBeat.o(210530);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(210530);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(210530);
        return null;
      }
      AppMethodBeat.o(210530);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  public final b anM()
  {
    return this;
  }
  
  public final FlutterView.RenderMode anN()
  {
    AppMethodBeat.i(210656);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localRenderMode = FlutterView.RenderMode.surface;
      AppMethodBeat.o(210656);
      return localRenderMode;
    }
    FlutterView.RenderMode localRenderMode = FlutterView.RenderMode.texture;
    AppMethodBeat.o(210656);
    return localRenderMode;
  }
  
  public final FlutterView.TransparencyMode anO()
  {
    AppMethodBeat.i(210660);
    if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque)
    {
      localTransparencyMode = FlutterView.TransparencyMode.opaque;
      AppMethodBeat.o(210660);
      return localTransparencyMode;
    }
    FlutterView.TransparencyMode localTransparencyMode = FlutterView.TransparencyMode.transparent;
    AppMethodBeat.o(210660);
    return localTransparencyMode;
  }
  
  public final String anP()
  {
    AppMethodBeat.i(210669);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(210669);
      return str;
    }
    if (TextUtils.isEmpty(this.egQ)) {
      this.egQ = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.egQ;
    AppMethodBeat.o(210669);
    return str;
  }
  
  public final String anQ()
  {
    AppMethodBeat.i(210670);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(210670);
      return str;
    }
    AppMethodBeat.o(210670);
    return "";
  }
  
  public final Map anR()
  {
    AppMethodBeat.i(210675);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(210675);
      return localMap;
    }
    AppMethodBeat.o(210675);
    return null;
  }
  
  public final void cG(boolean paramBoolean)
  {
    AppMethodBeat.i(210667);
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivity", "setIsPopGestureEnabled value:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(210667);
  }
  
  public void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public void configureFlutterEngine(FlutterEngine paramFlutterEngine) {}
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public final String getAppBundlePath()
  {
    AppMethodBeat.i(210648);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(210648);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(210648);
    return str;
  }
  
  public final String getCachedEngineId()
  {
    AppMethodBeat.i(210638);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(210638);
    return str;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public final String getDartEntrypointFunctionName()
  {
    AppMethodBeat.i(210642);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(210642);
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
          AppMethodBeat.o(210642);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(210642);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(210642);
    return "main";
  }
  
  public final String getInitialRoute()
  {
    AppMethodBeat.i(210653);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(210653);
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
          AppMethodBeat.o(210653);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(210653);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(210653);
    return "/";
  }
  
  public j getLifecycle()
  {
    return this.lifecycle;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(210597);
    this.egR.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(210597);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(210607);
    this.egR.qf(true);
    AppMethodBeat.o(210607);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210550);
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
        com.tencent.wxa.c.a.e("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.", new Object[0]);
        continue;
      }
      super.onCreate(paramBundle);
      this.lifecycle.a(j.a.ON_CREATE);
      this.egR = new a(this);
      this.egR.keU();
      paramBundle = new LinearLayout(getContext());
      paramBundle.setOrientation(1);
      localObject = new Toolbar(this);
      ((Toolbar)localObject).setLayoutParams(new Toolbar.LayoutParams(-1));
      ((Toolbar)localObject).fs();
      ((Toolbar)localObject).setVisibility(8);
      this.yi = ((Toolbar)localObject);
      if (this.yi != null)
      {
        paramBundle.addView(this.yi);
        setSupportActionBar(this.yi);
      }
      paramBundle.addView(this.egR.keV(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(210550);
      return;
      com.tencent.wxa.c.a.d("FlutterActivity", "Using the launch theme as normal theme.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(210591);
    super.onDestroy();
    this.egR.onDestroyView();
    this.egR.onDetach();
    this.lifecycle.a(j.a.ON_DESTROY);
    AppMethodBeat.o(210591);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(210604);
    super.onNewIntent(paramIntent);
    this.egR.onNewIntent(paramIntent);
    AppMethodBeat.o(210604);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(210579);
    super.onPause();
    this.egR.onPause();
    this.lifecycle.a(j.a.ON_PAUSE);
    AppMethodBeat.o(210579);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(210574);
    super.onPostResume();
    this.egR.onPostResume();
    AppMethodBeat.o(210574);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(210611);
    this.egR.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(210611);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(210567);
    super.onResume();
    this.lifecycle.a(j.a.ON_RESUME);
    this.egR.onResume();
    AppMethodBeat.o(210567);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(210560);
    super.onStart();
    this.lifecycle.a(j.a.ON_START);
    this.egR.onStart();
    AppMethodBeat.o(210560);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(210586);
    super.onStop();
    this.egR.onStop();
    this.lifecycle.a(j.a.ON_STOP);
    AppMethodBeat.o(210586);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(210619);
    this.egR.onTrimMemory(paramInt);
    AppMethodBeat.o(210619);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(210615);
    this.egR.onUserLeaveHint();
    AppMethodBeat.o(210615);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public FlutterEngine provideFlutterEngine(Context paramContext)
  {
    AppMethodBeat.i(210664);
    paramContext = c.keQ().keR();
    AppMethodBeat.o(210664);
    return paramContext;
  }
  
  public final PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine)
  {
    return null;
  }
  
  public SplashScreen provideSplashScreen()
  {
    AppMethodBeat.i(210554);
    Object localObject = getSplashScreenFromManifest();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(210554);
      return localObject;
    }
    AppMethodBeat.o(210554);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterActivity
 * JD-Core Version:    0.7.0.1
 */