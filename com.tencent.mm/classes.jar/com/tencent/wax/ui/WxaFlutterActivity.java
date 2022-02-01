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
import io.flutter.embedding.android.g;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity
  extends AppCompatActivity
  implements LifecycleOwner, b, a.a
{
  public static final String tWq;
  public Toolbar axv;
  protected a tWr;
  private LifecycleRegistry tWs;
  
  static
  {
    AppMethodBeat.i(191741);
    tWq = d.a.KKz.name();
    AppMethodBeat.o(191741);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(191715);
    this.tWs = new LifecycleRegistry(this);
    AppMethodBeat.o(191715);
  }
  
  private Drawable cWA()
  {
    AppMethodBeat.i(191718);
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
            AppMethodBeat.o(191718);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(191718);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(191718);
        return null;
      }
      AppMethodBeat.o(191718);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a cWB()
  {
    AppMethodBeat.i(191719);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(191719);
      return locala;
    }
    d.a locala = d.a.KKz;
    AppMethodBeat.o(191719);
    return locala;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final String cWC()
  {
    AppMethodBeat.i(191732);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(191732);
    return str;
  }
  
  public final String cWD()
  {
    AppMethodBeat.i(191733);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(191733);
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
          AppMethodBeat.o(191733);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(191733);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(191733);
    return "main";
  }
  
  public final String cWE()
  {
    AppMethodBeat.i(191734);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(191734);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(191734);
    return str;
  }
  
  public final String cWF()
  {
    AppMethodBeat.i(191735);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(191735);
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
          AppMethodBeat.o(191735);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(191735);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(191735);
    return "/";
  }
  
  public final FlutterView.b cWG()
  {
    AppMethodBeat.i(191736);
    if (cWB() == d.a.KKz)
    {
      localb = FlutterView.b.KLd;
      AppMethodBeat.o(191736);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.KLe;
    AppMethodBeat.o(191736);
    return localb;
  }
  
  public final FlutterView.c cWH()
  {
    AppMethodBeat.i(191737);
    if (cWB() == d.a.KKz)
    {
      localc = FlutterView.c.KLg;
      AppMethodBeat.o(191737);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.KLh;
    AppMethodBeat.o(191737);
    return localc;
  }
  
  public final io.flutter.embedding.engine.a cWI()
  {
    AppMethodBeat.i(191738);
    io.flutter.embedding.engine.a locala = d.fHA().cDT;
    AppMethodBeat.o(191738);
    return locala;
  }
  
  public final String cWJ()
  {
    AppMethodBeat.i(191739);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(191739);
      return str;
    }
    AppMethodBeat.o(191739);
    return "";
  }
  
  public final Map cWK()
  {
    AppMethodBeat.i(191740);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wax.d.a)))
    {
      Map localMap = ((com.tencent.wax.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(191740);
      return localMap;
    }
    AppMethodBeat.o(191740);
    return null;
  }
  
  public final g cWz()
  {
    AppMethodBeat.i(191717);
    Object localObject = cWA();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(191717);
      return localObject;
    }
    AppMethodBeat.o(191717);
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
    return this.tWs;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(191726);
    this.tWr.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(191726);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(191728);
    this.tWr.onBackPressed();
    AppMethodBeat.o(191728);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191716);
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
        io.flutter.a.fMH();
        continue;
      }
      super.onCreate(paramBundle);
      this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
      this.tWr = new a(this);
      this.tWr.fHF();
      paramBundle = new LinearLayout(this);
      paramBundle.setOrientation(1);
      localObject = new Toolbar(this);
      ((Toolbar)localObject).setLayoutParams(new Toolbar.LayoutParams(-1));
      ((Toolbar)localObject).mE();
      ((Toolbar)localObject).setVisibility(8);
      this.axv = ((Toolbar)localObject);
      if (this.axv != null)
      {
        paramBundle.addView(this.axv);
        setSupportActionBar(this.axv);
      }
      paramBundle.addView(this.tWr.fHH(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(191716);
      return;
      io.flutter.a.fMF();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191725);
    super.onDestroy();
    this.tWr.onDestroyView();
    this.tWr.onDetach();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    AppMethodBeat.o(191725);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(191727);
    super.onNewIntent(paramIntent);
    this.tWr.onNewIntent(paramIntent);
    AppMethodBeat.o(191727);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(191723);
    super.onPause();
    this.tWr.onPause();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    AppMethodBeat.o(191723);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(191722);
    super.onPostResume();
    this.tWr.onPostResume();
    AppMethodBeat.o(191722);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191729);
    this.tWr.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191729);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(191721);
    super.onResume();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    this.tWr.onResume();
    AppMethodBeat.o(191721);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(191720);
    super.onStart();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_START);
    this.tWr.onStart();
    AppMethodBeat.o(191720);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(191724);
    super.onStop();
    this.tWr.onStop();
    this.tWs.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    AppMethodBeat.o(191724);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(191731);
    this.tWr.onTrimMemory(paramInt);
    AppMethodBeat.o(191731);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(191730);
    this.tWr.onUserLeaveHint();
    AppMethodBeat.o(191730);
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