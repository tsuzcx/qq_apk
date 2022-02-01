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
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c;
import io.flutter.embedding.android.DrawableSplashScreen;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.e.a;
import io.flutter.embedding.android.j;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class WxaFlutterActivity
  extends AppCompatActivity
  implements l, com.tencent.wxa.b.b, a.a
{
  public static final String cpb;
  private m BCL;
  protected String cpc;
  protected a cpd;
  public Toolbar xn;
  
  static
  {
    AppMethodBeat.i(224927);
    cpb = e.a.aaoG.name();
    AppMethodBeat.o(224927);
  }
  
  public WxaFlutterActivity()
  {
    AppMethodBeat.i(224858);
    this.BCL = new m(this);
    AppMethodBeat.o(224858);
  }
  
  private e.a Ns()
  {
    AppMethodBeat.i(224871);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = e.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(224871);
      return locala;
    }
    e.a locala = e.a.aaoG;
    AppMethodBeat.o(224871);
    return locala;
  }
  
  private Drawable Nt()
  {
    AppMethodBeat.i(224869);
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
            AppMethodBeat.o(224869);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(224869);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(224869);
        return null;
      }
      AppMethodBeat.o(224869);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  public final FlutterView.b NA()
  {
    AppMethodBeat.i(224907);
    if (Ns() == e.a.aaoG)
    {
      localb = FlutterView.b.aapw;
      AppMethodBeat.o(224907);
      return localb;
    }
    FlutterView.b localb = FlutterView.b.aapx;
    AppMethodBeat.o(224907);
    return localb;
  }
  
  public final FlutterView.c NB()
  {
    AppMethodBeat.i(224909);
    if (Ns() == e.a.aaoG)
    {
      localc = FlutterView.c.aapA;
      AppMethodBeat.o(224909);
      return localc;
    }
    FlutterView.c localc = FlutterView.c.aapB;
    AppMethodBeat.o(224909);
    return localc;
  }
  
  public final j NC()
  {
    AppMethodBeat.i(224863);
    Object localObject = Nt();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(224863);
      return localObject;
    }
    AppMethodBeat.o(224863);
    return null;
  }
  
  public final io.flutter.embedding.engine.a ND()
  {
    AppMethodBeat.i(224910);
    io.flutter.embedding.engine.a locala = c.ivt().ZYJ;
    AppMethodBeat.o(224910);
    return locala;
  }
  
  public final String NE()
  {
    AppMethodBeat.i(224918);
    if ((getIntent().hasExtra("activityId")) && (!TextUtils.isEmpty(getIntent().getStringExtra("activityId"))))
    {
      str = getIntent().getStringExtra("activityId");
      AppMethodBeat.o(224918);
      return str;
    }
    if (TextUtils.isEmpty(this.cpc)) {
      this.cpc = String.format("%d-%d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()) });
    }
    String str = this.cpc;
    AppMethodBeat.o(224918);
    return str;
  }
  
  public final String NF()
  {
    AppMethodBeat.i(224920);
    if (getIntent().hasExtra("name"))
    {
      String str = getIntent().getStringExtra("name");
      AppMethodBeat.o(224920);
      return str;
    }
    AppMethodBeat.o(224920);
    return "";
  }
  
  public final Map NG()
  {
    AppMethodBeat.i(224922);
    if ((getIntent().hasExtra("params")) && ((getIntent().getSerializableExtra("params") instanceof com.tencent.wxa.d.a)))
    {
      Map localMap = ((com.tencent.wxa.d.a)getIntent().getSerializableExtra("params")).map;
      AppMethodBeat.o(224922);
      return localMap;
    }
    AppMethodBeat.o(224922);
    return null;
  }
  
  public final com.tencent.wxa.b.b Nv()
  {
    return this;
  }
  
  public final String Nw()
  {
    AppMethodBeat.i(224897);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(224897);
    return str;
  }
  
  public final String Nx()
  {
    AppMethodBeat.i(224898);
    Object localObject1;
    if (getIntent().hasExtra("dart_entrypoint"))
    {
      localObject1 = getIntent().getStringExtra("dart_entrypoint");
      AppMethodBeat.o(224898);
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
          AppMethodBeat.o(224898);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(224898);
        return "main";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(224898);
    return "main";
  }
  
  public final String Ny()
  {
    AppMethodBeat.i(224900);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(224900);
      return str;
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(224900);
    return str;
  }
  
  public final String Nz()
  {
    AppMethodBeat.i(224904);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(224904);
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
          AppMethodBeat.o(224904);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(224904);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(224904);
    return "/";
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void bZ(boolean paramBoolean)
  {
    AppMethodBeat.i(224913);
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivity", "setIsPopGestureEnabled value:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(224913);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public h getLifecycle()
  {
    return this.BCL;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(224883);
    this.cpd.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(224883);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(224887);
    this.cpd.oC(true);
    AppMethodBeat.o(224887);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(224862);
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
      this.BCL.a(h.a.ON_CREATE);
      this.cpd = new a(this);
      this.cpd.ivA();
      paramBundle = new LinearLayout(getContext());
      paramBundle.setOrientation(1);
      localObject = new Toolbar(this);
      ((Toolbar)localObject).setLayoutParams(new Toolbar.LayoutParams(-1));
      ((Toolbar)localObject).ev();
      ((Toolbar)localObject).setVisibility(8);
      this.xn = ((Toolbar)localObject);
      if (this.xn != null)
      {
        paramBundle.addView(this.xn);
        setSupportActionBar(this.xn);
      }
      paramBundle.addView(this.cpd.ivC(), new LinearLayout.LayoutParams(-1, -1));
      setContentView(paramBundle);
      AppMethodBeat.o(224862);
      return;
      com.tencent.wxa.c.a.d("FlutterActivity", "Using the launch theme as normal theme.", new Object[0]);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(224882);
    super.onDestroy();
    this.cpd.onDestroyView();
    this.cpd.onDetach();
    this.BCL.a(h.a.ON_DESTROY);
    AppMethodBeat.o(224882);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(224886);
    super.onNewIntent(paramIntent);
    this.cpd.onNewIntent(paramIntent);
    AppMethodBeat.o(224886);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(224878);
    super.onPause();
    this.cpd.onPause();
    this.BCL.a(h.a.ON_PAUSE);
    AppMethodBeat.o(224878);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(224876);
    super.onPostResume();
    this.cpd.onPostResume();
    AppMethodBeat.o(224876);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224888);
    this.cpd.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(224888);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(224874);
    super.onResume();
    this.BCL.a(h.a.ON_RESUME);
    this.cpd.onResume();
    AppMethodBeat.o(224874);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(224872);
    super.onStart();
    this.BCL.a(h.a.ON_START);
    this.cpd.onStart();
    AppMethodBeat.o(224872);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(224880);
    super.onStop();
    this.cpd.onStop();
    this.BCL.a(h.a.ON_STOP);
    AppMethodBeat.o(224880);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(224892);
    this.cpd.onTrimMemory(paramInt);
    AppMethodBeat.o(224892);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(224891);
    this.cpd.onUserLeaveHint();
    AppMethodBeat.o(224891);
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