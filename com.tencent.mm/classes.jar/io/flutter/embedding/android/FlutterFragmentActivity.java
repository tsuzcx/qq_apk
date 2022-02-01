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
  implements e, f, h
{
  private FlutterFragment KKJ;
  
  private Drawable cWA()
  {
    AppMethodBeat.i(192866);
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
            AppMethodBeat.o(192866);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(192866);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(192866);
        return null;
      }
      AppMethodBeat.o(192866);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a cWB()
  {
    AppMethodBeat.i(192879);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(192879);
      return locala;
    }
    d.a locala = d.a.KKz;
    AppMethodBeat.o(192879);
    return locala;
  }
  
  private String cWC()
  {
    AppMethodBeat.i(192878);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(192878);
    return str;
  }
  
  private String cWD()
  {
    AppMethodBeat.i(192876);
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
            AppMethodBeat.o(192876);
            return localObject1;
          }
          AppMethodBeat.o(192876);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(192876);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  private String cWE()
  {
    AppMethodBeat.i(192875);
    if ((fMT()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(192875);
        return str;
      }
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(192875);
    return str;
  }
  
  private String cWF()
  {
    AppMethodBeat.i(192877);
    Object localObject1;
    if (getIntent().hasExtra("initial_route"))
    {
      localObject1 = getIntent().getStringExtra("initial_route");
      AppMethodBeat.o(192877);
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
          AppMethodBeat.o(192877);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(192877);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(192877);
    return "/";
  }
  
  private boolean fMN()
  {
    AppMethodBeat.i(192874);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(192874);
    return bool;
  }
  
  private boolean fMT()
  {
    AppMethodBeat.i(192880);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(192880);
      return true;
    }
    AppMethodBeat.o(192880);
    return false;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final io.flutter.embedding.engine.a cWI()
  {
    return null;
  }
  
  public final g cWz()
  {
    AppMethodBeat.i(192865);
    Object localObject = cWA();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(192865);
      return localObject;
    }
    AppMethodBeat.o(192865);
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192873);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.KKJ.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(192873);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(192869);
    this.KKJ.KKu.onBackPressed();
    AppMethodBeat.o(192869);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192864);
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
        io.flutter.a.fMH();
        continue;
        paramBundle = FlutterView.b.KLe;
        continue;
        FlutterView.c localc = FlutterView.c.KLh;
        continue;
        new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(localObject2).append("\nDart entrypoint: ").append(cWD()).append("\nInitial route: ").append(cWF()).append("\nApp bundle path: ").append(cWE()).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.fMF();
        Object localObject2 = FlutterFragment.fMR();
        ((FlutterFragment.b)localObject2).KuG = cWD();
        ((FlutterFragment.b)localObject2).KuH = cWF();
        ((FlutterFragment.b)localObject2).KKH = cWE();
        ((FlutterFragment.b)localObject2).KKI = d.bw(getIntent());
        ((FlutterFragment.b)localObject2).KuI = paramBundle;
        ((FlutterFragment.b)localObject2).KKF = localc;
        ((FlutterFragment.b)localObject2).KKG = true;
        paramBundle = ((FlutterFragment.b)localObject2).fMS();
        continue;
      }
      super.onCreate(paramBundle);
      if (cWB() == d.a.KKA)
      {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setFlags(512, 512);
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
      this.KKJ = ((FlutterFragment)localg.findFragmentByTag("flutter_fragment"));
      if (this.KKJ == null)
      {
        localObject2 = cWB();
        if (localObject2 != d.a.KKz) {
          continue;
        }
        paramBundle = FlutterView.b.KLd;
        if (localObject2 != d.a.KKz) {
          continue;
        }
        localObject1 = FlutterView.c.KLg;
        if (cWC() == null) {
          continue;
        }
        new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(cWC()).append("\nWill destroy engine when Activity is destroyed: ").append(fMN()).append("\nBackground transparency mode: ").append(localObject2).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.fMF();
        localObject2 = FlutterFragment.aVG(cWC());
        ((FlutterFragment.a)localObject2).KuI = paramBundle;
        ((FlutterFragment.a)localObject2).KKF = ((FlutterView.c)localObject1);
        ((FlutterFragment.a)localObject2).KKG = true;
        ((FlutterFragment.a)localObject2).KKE = fMN();
        paramBundle = ((FlutterFragment.a)localObject2).fMS();
        this.KKJ = paramBundle;
        localg.beginTransaction().a(609893468, this.KKJ, "flutter_fragment").commit();
      }
      AppMethodBeat.o(192864);
      return;
      io.flutter.a.fMF();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(192868);
    this.KKJ.KKu.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(192868);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(192867);
    super.onPostResume();
    this.KKJ.KKu.onPostResume();
    AppMethodBeat.o(192867);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192870);
    this.KKJ.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(192870);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(192872);
    super.onTrimMemory(paramInt);
    this.KKJ.KKu.onTrimMemory(paramInt);
    AppMethodBeat.o(192872);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(192871);
    this.KKJ.KKu.onUserLeaveHint();
    AppMethodBeat.o(192871);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */