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
import android.support.v4.app.g;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.d;
import io.flutter.view.FlutterMain;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements e, f, k
{
  private FlutterFragment SMQ;
  
  private Drawable KG()
  {
    AppMethodBeat.i(215051);
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
            AppMethodBeat.o(215051);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(215051);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(215051);
        return null;
      }
      AppMethodBeat.o(215051);
      return null;
      label106:
      Object localObject2 = null;
    }
  }
  
  private d.a KH()
  {
    AppMethodBeat.i(215064);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = d.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(215064);
      return locala;
    }
    d.a locala = d.a.SMF;
    AppMethodBeat.o(215064);
    return locala;
  }
  
  private String KJ()
  {
    AppMethodBeat.i(215063);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(215063);
    return str;
  }
  
  private String KK()
  {
    AppMethodBeat.i(215061);
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
            AppMethodBeat.o(215061);
            return localObject1;
          }
          AppMethodBeat.o(215061);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(215061);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  private String KL()
  {
    AppMethodBeat.i(215060);
    if ((hwt()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(215060);
        return str;
      }
    }
    String str = FlutterMain.findAppBundlePath();
    AppMethodBeat.o(215060);
    return str;
  }
  
  private String KM()
  {
    AppMethodBeat.i(215062);
    Object localObject1;
    if (getIntent().hasExtra("route"))
    {
      localObject1 = getIntent().getStringExtra("route");
      AppMethodBeat.o(215062);
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
          AppMethodBeat.o(215062);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(215062);
        return "/";
      }
      Object localObject2 = null;
    }
    AppMethodBeat.o(215062);
    return "/";
  }
  
  private boolean hwm()
  {
    AppMethodBeat.i(215059);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(215059);
    return bool;
  }
  
  private boolean hwt()
  {
    AppMethodBeat.i(215065);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(215065);
      return true;
    }
    AppMethodBeat.o(215065);
    return false;
  }
  
  public final j KF()
  {
    AppMethodBeat.i(215050);
    Object localObject = KG();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(215050);
      return localObject;
    }
    AppMethodBeat.o(215050);
    return null;
  }
  
  public final io.flutter.embedding.engine.a KP()
  {
    return null;
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void c(io.flutter.embedding.engine.a parama) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(215058);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.SMQ.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(215058);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(215054);
    this.SMQ.SMA.onBackPressed();
    AppMethodBeat.o(215054);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215049);
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
        g localg;
        io.flutter.a.hwg();
        continue;
        paramBundle = i.SNP;
        continue;
        l locall = l.SNT;
        continue;
        new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(localObject2).append("\nDart entrypoint: ").append(KK()).append("\nInitial route: ").append(KM()).append("\nApp bundle path: ").append(KL()).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.hwd();
        Object localObject2 = FlutterFragment.hwr();
        ((FlutterFragment.b)localObject2).SxI = KK();
        ((FlutterFragment.b)localObject2).SxJ = KM();
        ((FlutterFragment.b)localObject2).SMO = KL();
        ((FlutterFragment.b)localObject2).SMP = d.bO(getIntent());
        ((FlutterFragment.b)localObject2).SML = paramBundle;
        ((FlutterFragment.b)localObject2).SMM = locall;
        ((FlutterFragment.b)localObject2).SMN = true;
        paramBundle = ((FlutterFragment.b)localObject2).hws();
        continue;
      }
      super.onCreate(paramBundle);
      if (KH() == d.a.SMG) {
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
      this.SMQ = ((FlutterFragment)localg.findFragmentByTag("flutter_fragment"));
      if (this.SMQ == null)
      {
        localObject2 = KH();
        if (localObject2 != d.a.SMF) {
          continue;
        }
        paramBundle = i.SNO;
        if (localObject2 != d.a.SMF) {
          continue;
        }
        localObject1 = l.SNS;
        if (KJ() == null) {
          continue;
        }
        new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(KJ()).append("\nWill destroy engine when Activity is destroyed: ").append(hwm()).append("\nBackground transparency mode: ").append(localObject2).append("\nWill attach FlutterEngine to Activity: true");
        io.flutter.a.hwd();
        localObject2 = FlutterFragment.bsZ(KJ());
        ((FlutterFragment.a)localObject2).SML = paramBundle;
        ((FlutterFragment.a)localObject2).SMM = ((l)localObject1);
        ((FlutterFragment.a)localObject2).SMN = true;
        ((FlutterFragment.a)localObject2).SMK = hwm();
        paramBundle = ((FlutterFragment.a)localObject2).hws();
        this.SMQ = paramBundle;
        localg.beginTransaction().a(609893468, this.SMQ, "flutter_fragment").commit();
      }
      AppMethodBeat.o(215049);
      return;
      io.flutter.a.hwd();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(215053);
    this.SMQ.SMA.onNewIntent(paramIntent);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(215053);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(215052);
    super.onPostResume();
    this.SMQ.SMA.onPostResume();
    AppMethodBeat.o(215052);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(215055);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.SMQ.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(215055);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(215057);
    super.onTrimMemory(paramInt);
    this.SMQ.SMA.onTrimMemory(paramInt);
    AppMethodBeat.o(215057);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(215056);
    this.SMQ.SMA.onUserLeaveHint();
    AppMethodBeat.o(215056);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */