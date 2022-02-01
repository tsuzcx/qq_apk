package com.tencent.wxa.ui;

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
import com.tencent.wxa.b.b;
import com.tencent.wxa.c;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity
  extends AppCompatActivity
  implements LifecycleOwner, b, a.a
{
  public static final String crl;
  public Toolbar azk;
  protected String crm;
  protected a crn;
  private LifecycleRegistry crq;
  
  static
  {
    AppMethodBeat.i(206362);
    crl = d.a.SMF.name();
    AppMethodBeat.o(206362);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(206334);
    this.crq = new LifecycleRegistry(this);
    AppMethodBeat.o(206334);
  }
  
  private Drawable KG()
  {
    AppMethodBeat.i(206337);
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
            AppMethodBeat.o(206337);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(206337);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(206337);
        return null;
      }
      AppMethodBeat.o(206337);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a KH()
  {
    AppMethodBeat.i(206338);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(206338);
      return locala;
    }
    d.a locala = d.a.SMF;
    AppMethodBeat.o(206338);
    return locala;
  }
  
  public final j KF()
  {
    AppMethodBeat.i(206336);
    Object localObject = KG();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(206336);
      return localObject;
    }
    AppMethodBeat.o(206336);
    return null;
  }
  
  public final b KI()
  {
    return this;
  }
  
  public final String KJ()
  {
    AppMethodBeat.i(206351);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(206351);
    return str;
  }
  
  public final String KK()
  {
    AppMethodBeat.i(206352);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(206352);
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
          AppMethodBeat.o(206352);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(206352);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(206352);
    return "main";
  }
  
  public final String KL()
  {
    AppMethodBeat.i(206353);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(206353);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(206353);
    return str;
  }
  
  public final String KM()
  {
    AppMethodBeat.i(206354);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(206354);
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
          AppMethodBeat.o(206354);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(206354);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(206354);
    return "/";
  }
  
  public final FlutterView.b KN()
  {
    AppMethodBeat.i(206355);
    if (KH() == d.a.SMF)
    {
      localb = FlutterView.b.SNy;
      AppMethodBeat.o(206355);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.SNz;
    AppMethodBeat.o(206355);
    return localb;
  }
  
  public final FlutterView.c KO()
  {
    AppMethodBeat.i(206356);
    if (KH() == d.a.SMF)
    {
      localc = FlutterView.c.SNC;
      AppMethodBeat.o(206356);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.SND;
    AppMethodBeat.o(206356);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a KP()
  {
    AppMethodBeat.i(206357);
    io.flutter.embedding.engine.a locala = c.hrH().SxF;
    AppMethodBeat.o(206357);
    return locala;
  }
  
  public final String KQ()
  {
    AppMethodBeat.i(206359);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(206359);
      return str;
    }
    if (TextUtils.isEmpty(this.crm)) {
      this.crm = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.crm;
    AppMethodBeat.o(206359);
    return str;
  }
  
  public final String KR()
  {
    AppMethodBeat.i(206360);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(206360);
      return str;
    }
    AppMethodBeat.o(206360);
    return "";
  }
  
  public final Map KS()
  {
    AppMethodBeat.i(206361);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(206361);
      return localMap;
    }
    AppMethodBeat.o(206361);
    return null;
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bP(boolean paramBoolean)
  {
    AppMethodBeat.i(206358);
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivity", "setIsPopGestureEnabled value:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(206358);
  }
  
  public final void c(io.flutter.embedding.engine.a parama) {}
  
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
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206345);
    this.crn.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(206345);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(206347);
    this.crn.onBackPressed();
    AppMethodBeat.o(206347);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206335);
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
      this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.crn = new a(this);
      this.crn.hrO();
      paramBundle = new LinearLayout(getContext());
      paramBundle.setOrientation(1);
      localObject = new Toolbar(this);
      ((Toolbar)localObject).setLayoutParams(new Toolbar.LayoutParams(-1));
      ((Toolbar)localObject).mY();
      ((Toolbar)localObject).setVisibility(8);
      this.azk = ((Toolbar)localObject);
      if (this.azk != null)
      {
        paramBundle.addView(this.azk);
        setSupportActionBar(this.azk);
      }
      paramBundle.addView(this.crn.hrQ(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(206335);
      return;
      com.tencent.wxa.c.a.d("FlutterActivity", "Using the launch theme as normal theme.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(206344);
    super.onDestroy();
    this.crn.onDestroyView();
    this.crn.onDetach();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(206344);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(206346);
    super.onNewIntent(paramIntent);
    this.crn.onNewIntent(paramIntent);
    AppMethodBeat.o(206346);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(206342);
    super.onPause();
    this.crn.onPause();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(206342);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(206341);
    super.onPostResume();
    this.crn.onPostResume();
    AppMethodBeat.o(206341);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206348);
    this.crn.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206348);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(206340);
    super.onResume();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.crn.onResume();
    AppMethodBeat.o(206340);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(206339);
    super.onStart();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.crn.onStart();
    AppMethodBeat.o(206339);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(206343);
    super.onStop();
    this.crn.onStop();
    this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(206343);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(206350);
    this.crn.onTrimMemory(paramInt);
    AppMethodBeat.o(206350);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(206349);
    this.crn.onUserLeaveHint();
    AppMethodBeat.o(206349);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.ui.WxaFlutterActivity
 * JD-Core Version:    0.7.0.1
 */