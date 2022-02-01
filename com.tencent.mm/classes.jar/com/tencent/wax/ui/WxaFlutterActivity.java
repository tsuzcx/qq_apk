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
  public static final String uYZ;
  public Toolbar azm;
  protected a uZa;
  private LifecycleRegistry uZb;
  
  static
  {
    AppMethodBeat.i(217538);
    uYZ = d.a.MBn.name();
    AppMethodBeat.o(217538);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(217512);
    this.uZb = new LifecycleRegistry(this);
    AppMethodBeat.o(217512);
  }
  
  private Drawable dfM()
  {
    AppMethodBeat.i(217515);
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
            AppMethodBeat.o(217515);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(217515);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(217515);
        return null;
      }
      AppMethodBeat.o(217515);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a dfN()
  {
    AppMethodBeat.i(217516);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(217516);
      return locala;
    }
    d.a locala = d.a.MBn;
    AppMethodBeat.o(217516);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final h dfL()
  {
    AppMethodBeat.i(217514);
    Object localObject = dfM();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(217514);
      return localObject;
    }
    AppMethodBeat.o(217514);
    return null;
  }
  
  public final String dfO()
  {
    AppMethodBeat.i(217529);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(217529);
    return str;
  }
  
  public final String dfP()
  {
    AppMethodBeat.i(217530);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(217530);
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
          AppMethodBeat.o(217530);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(217530);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(217530);
    return "main";
  }
  
  public final String dfQ()
  {
    AppMethodBeat.i(217531);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(217531);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(217531);
    return str;
  }
  
  public final String dfR()
  {
    AppMethodBeat.i(217532);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(217532);
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
          AppMethodBeat.o(217532);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(217532);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(217532);
    return "/";
  }
  
  public final FlutterView.b dfS()
  {
    AppMethodBeat.i(217533);
    if (dfN() == d.a.MBn)
    {
      localb = FlutterView.b.MBU;
      AppMethodBeat.o(217533);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.MBV;
    AppMethodBeat.o(217533);
    return localb;
  }
  
  public final FlutterView.c dfT()
  {
    AppMethodBeat.i(217534);
    if (dfN() == d.a.MBn)
    {
      localc = FlutterView.c.MBX;
      AppMethodBeat.o(217534);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.MBY;
    AppMethodBeat.o(217534);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a dfU()
  {
    AppMethodBeat.i(217535);
    io.flutter.embedding.engine.a locala = d.fYR().cOY;
    AppMethodBeat.o(217535);
    return locala;
  }
  
  public final String dfV()
  {
    AppMethodBeat.i(217536);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(217536);
      return str;
    }
    AppMethodBeat.o(217536);
    return "";
  }
  
  public final Map dfW()
  {
    AppMethodBeat.i(217537);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(217537);
      return localMap;
    }
    AppMethodBeat.o(217537);
    return null;
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public final Context getContext()
  {
    return this;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.uZb;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217523);
    this.uZa.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(217523);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(217525);
    this.uZa.onBackPressed();
    AppMethodBeat.o(217525);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217513);
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
        io.flutter.a.gee();
        continue;
      }
      super.onCreate(paramBundle);
      this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.uZa = new a(this);
      this.uZa.fYW();
      paramBundle = new LinearLayout(this);
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
      paramBundle.addView(this.uZa.fYY(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(217513);
      return;
      io.flutter.a.gec();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(217522);
    super.onDestroy();
    this.uZa.onDestroyView();
    this.uZa.onDetach();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(217522);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(217524);
    super.onNewIntent(paramIntent);
    this.uZa.onNewIntent(paramIntent);
    AppMethodBeat.o(217524);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217520);
    super.onPause();
    this.uZa.onPause();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(217520);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(217519);
    super.onPostResume();
    this.uZa.onPostResume();
    AppMethodBeat.o(217519);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217526);
    this.uZa.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(217526);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(217518);
    super.onResume();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.uZa.onResume();
    AppMethodBeat.o(217518);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(217517);
    super.onStart();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.uZa.onStart();
    AppMethodBeat.o(217517);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(217521);
    super.onStop();
    this.uZa.onStop();
    this.uZb.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(217521);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(217528);
    this.uZa.onTrimMemory(paramInt);
    AppMethodBeat.o(217528);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(217527);
    this.uZa.onUserLeaveHint();
    AppMethodBeat.o(217527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.ui.WxaFlutterActivity
 * JD-Core Version:    0.7.0.1
 */