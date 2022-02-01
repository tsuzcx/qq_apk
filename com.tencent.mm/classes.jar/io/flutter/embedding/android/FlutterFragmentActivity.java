package io.flutter.embedding.android;

import android.app.Activity;
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
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.k;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.d;
import io.flutter.view.FlutterMain;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements e, f, i
{
  private FlutterFragment MYD;
  
  private String diI()
  {
    AppMethodBeat.i(197917);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(197917);
    return str;
  }
  
  private String diJ()
  {
    AppMethodBeat.i(197915);
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
            AppMethodBeat.o(197915);
            return localObject1;
          }
          AppMethodBeat.o(197915);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197915);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  private String diK()
  {
    AppMethodBeat.i(197914);
    if ((giV()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(197914);
        return str;
      }
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(197914);
    return str;
  }
  
  private String diL()
  {
    AppMethodBeat.i(197916);
    Object localObject1;
    if (getIntent().hasExtra("route"))
    {
      localObject1 = getIntent().getStringExtra("route");
      AppMethodBeat.o(197916);
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
          AppMethodBeat.o(197916);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197916);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(197916);
    return "/";
  }
  
  private Drawable diQ()
  {
    AppMethodBeat.i(197905);
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
            AppMethodBeat.o(197905);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(197905);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(197905);
        return null;
      }
      AppMethodBeat.o(197905);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a diU()
  {
    AppMethodBeat.i(197918);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(197918);
      return locala;
    }
    d.a locala = d.a.MYs;
    AppMethodBeat.o(197918);
    return locala;
  }
  
  private boolean giN()
  {
    AppMethodBeat.i(197913);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(197913);
    return bool;
  }
  
  private boolean giV()
  {
    AppMethodBeat.i(197919);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(197919);
      return true;
    }
    AppMethodBeat.o(197919);
    return false;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final io.flutter.embedding.engine.a diO()
  {
    return null;
  }
  
  public final h diP()
  {
    AppMethodBeat.i(197904);
    Object localObject = diQ();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(197904);
      return localObject;
    }
    AppMethodBeat.o(197904);
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(197912);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.MYD.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(197912);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(197908);
    this.MYD.MYn.onBackPressed();
    AppMethodBeat.o(197908);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(197903);
    for (;;)
    {
      try
      {
        localObject1 = getPackageManager().getActivityInfo(getComponentName(), 128);
        if (((ActivityInfo)localObject1).metaData == null) {
          continue;
        }
        int i = ((ActivityInfo)localObject1).metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject1;
        android.support.v4.app.g localg;
        io.flutter.a.giH();
        continue;
        paramBundle = g.MZg;
        continue;
        j localj = j.MZj;
        continue;
        new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(localObject2).append("\nDart entrypoint: ").append(diJ()).append("\nInitial route: ").append(diL()).append("\nApp bundle path: ").append(diK()).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.giD();
        Object localObject2 = FlutterFragment.giT();
        ((FlutterFragment.b)localObject2).MHF = diJ();
        ((FlutterFragment.b)localObject2).MHG = diL();
        ((FlutterFragment.b)localObject2).MYB = diK();
        ((FlutterFragment.b)localObject2).MYC = d.bC(getIntent());
        ((FlutterFragment.b)localObject2).MYy = paramBundle;
        ((FlutterFragment.b)localObject2).MYz = localj;
        ((FlutterFragment.b)localObject2).MYA = true;
        paramBundle = ((FlutterFragment.b)localObject2).giU();
        continue;
      }
      super.onCreate(paramBundle);
      if (diU() == d.a.MYt) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      paramBundle = new FrameLayout(this);
      paramBundle.setId(609893468);
      paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      setContentView(paramBundle);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      localg = getSupportFragmentManager();
      this.MYD = ((FlutterFragment)localg.findFragmentByTag("flutter_fragment"));
      if (this.MYD == null)
      {
        localObject2 = diU();
        if (localObject2 != d.a.MYs) {
          continue;
        }
        paramBundle = g.MZf;
        if (localObject2 != d.a.MYs) {
          continue;
        }
        localObject1 = j.MZi;
        if (diI() == null) {
          continue;
        }
        new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(diI()).append("\nWill destroy engine when Activity is destroyed: ").append(giN()).append("\nBackground transparency mode: ").append(localObject2).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.giD();
        localObject2 = FlutterFragment.bdn(diI());
        ((FlutterFragment.a)localObject2).MYy = paramBundle;
        ((FlutterFragment.a)localObject2).MYz = ((j)localObject1);
        ((FlutterFragment.a)localObject2).MYA = true;
        ((FlutterFragment.a)localObject2).MYx = giN();
        paramBundle = ((FlutterFragment.a)localObject2).giU();
        this.MYD = paramBundle;
        localg.beginTransaction().a(609893468, this.MYD, "flutter_fragment").commit();
      }
      AppMethodBeat.o(197903);
      return;
      io.flutter.a.giD();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(197907);
    this.MYD.MYn.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(197907);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(197906);
    super.onPostResume();
    this.MYD.MYn.onPostResume();
    AppMethodBeat.o(197906);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(197909);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.MYD.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(197909);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(197911);
    super.onTrimMemory(paramInt);
    this.MYD.MYn.onTrimMemory(paramInt);
    AppMethodBeat.o(197911);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(197910);
    this.MYD.MYn.onUserLeaveHint();
    AppMethodBeat.o(197910);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */