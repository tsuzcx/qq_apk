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
  private FlutterFragment MBy;
  
  private Drawable dfM()
  {
    AppMethodBeat.i(213323);
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
            AppMethodBeat.o(213323);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(213323);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(213323);
        return null;
      }
      AppMethodBeat.o(213323);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a dfN()
  {
    AppMethodBeat.i(213336);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(213336);
      return locala;
    }
    d.a locala = d.a.MBn;
    AppMethodBeat.o(213336);
    return locala;
  }
  
  private String dfO()
  {
    AppMethodBeat.i(213335);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(213335);
    return str;
  }
  
  private String dfP()
  {
    AppMethodBeat.i(213333);
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
            AppMethodBeat.o(213333);
            return localObject1;
          }
          AppMethodBeat.o(213333);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(213333);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  private String dfQ()
  {
    AppMethodBeat.i(213332);
    if ((ges()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(213332);
        return str;
      }
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(213332);
    return str;
  }
  
  private String dfR()
  {
    AppMethodBeat.i(213334);
    Object localObject1;
    if (getIntent().hasExtra("route"))
    {
      localObject1 = getIntent().getStringExtra("route");
      AppMethodBeat.o(213334);
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
          AppMethodBeat.o(213334);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(213334);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(213334);
    return "/";
  }
  
  private boolean gek()
  {
    AppMethodBeat.i(213331);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(213331);
    return bool;
  }
  
  private boolean ges()
  {
    AppMethodBeat.i(213337);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(213337);
      return true;
    }
    AppMethodBeat.o(213337);
    return false;
  }
  
  public final void a(io.flutter.embedding.engine.a parama) {}
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final h dfL()
  {
    AppMethodBeat.i(213322);
    Object localObject = dfM();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(213322);
      return localObject;
    }
    AppMethodBeat.o(213322);
    return null;
  }
  
  public final io.flutter.embedding.engine.a dfU()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(213330);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.MBy.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(213330);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(213326);
    this.MBy.MBi.onBackPressed();
    AppMethodBeat.o(213326);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213321);
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
        io.flutter.a.gee();
        continue;
        paramBundle = g.MCb;
        continue;
        j localj = j.MCe;
        continue;
        new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(localObject2).append("\nDart entrypoint: ").append(dfP()).append("\nInitial route: ").append(dfR()).append("\nApp bundle path: ").append(dfQ()).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.gea();
        Object localObject2 = FlutterFragment.geq();
        ((FlutterFragment.b)localObject2).MkH = dfP();
        ((FlutterFragment.b)localObject2).MkI = dfR();
        ((FlutterFragment.b)localObject2).MBw = dfQ();
        ((FlutterFragment.b)localObject2).MBx = d.bB(getIntent());
        ((FlutterFragment.b)localObject2).MBt = paramBundle;
        ((FlutterFragment.b)localObject2).MBu = localj;
        ((FlutterFragment.b)localObject2).MBv = true;
        paramBundle = ((FlutterFragment.b)localObject2).ger();
        continue;
      }
      super.onCreate(paramBundle);
      if (dfN() == d.a.MBo) {
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
      this.MBy = ((FlutterFragment)localg.findFragmentByTag("flutter_fragment"));
      if (this.MBy == null)
      {
        localObject2 = dfN();
        if (localObject2 != d.a.MBn) {
          continue;
        }
        paramBundle = g.MCa;
        if (localObject2 != d.a.MBn) {
          continue;
        }
        localObject1 = j.MCd;
        if (dfO() == null) {
          continue;
        }
        new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(dfO()).append("\nWill destroy engine when Activity is destroyed: ").append(gek()).append("\nBackground transparency mode: ").append(localObject2).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.gea();
        localObject2 = FlutterFragment.bbJ(dfO());
        ((FlutterFragment.a)localObject2).MBt = paramBundle;
        ((FlutterFragment.a)localObject2).MBu = ((j)localObject1);
        ((FlutterFragment.a)localObject2).MBv = true;
        ((FlutterFragment.a)localObject2).MBs = gek();
        paramBundle = ((FlutterFragment.a)localObject2).ger();
        this.MBy = paramBundle;
        localg.beginTransaction().a(609893468, this.MBy, "flutter_fragment").commit();
      }
      AppMethodBeat.o(213321);
      return;
      io.flutter.a.gea();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(213325);
    this.MBy.MBi.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(213325);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(213324);
    super.onPostResume();
    this.MBy.MBi.onPostResume();
    AppMethodBeat.o(213324);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(213327);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.MBy.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(213327);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(213329);
    super.onTrimMemory(paramInt);
    this.MBy.MBi.onTrimMemory(paramInt);
    AppMethodBeat.o(213329);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(213328);
    this.MBy.MBi.onUserLeaveHint();
    AppMethodBeat.o(213328);
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