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
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements f, g, k
{
  private FlutterFragment aaoO;
  
  private e.a Ns()
  {
    AppMethodBeat.i(254724);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = e.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(254724);
      return locala;
    }
    e.a locala = e.a.aaoG;
    AppMethodBeat.o(254724);
    return locala;
  }
  
  private Drawable Nt()
  {
    AppMethodBeat.i(254694);
    for (;;)
    {
      try
      {
        Object localObject1 = iAs();
        if (localObject1 == null) {
          break label93;
        }
        localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("io.flutter.embedding.android.SplashScreenDrawable"));
        if (localObject1 != null)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject1 = getResources().getDrawable(((Integer)localObject1).intValue(), getTheme());
            AppMethodBeat.o(254694);
            return localObject1;
          }
          localObject1 = getResources().getDrawable(((Integer)localObject1).intValue());
          AppMethodBeat.o(254694);
          return localObject1;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(254694);
        return null;
      }
      AppMethodBeat.o(254694);
      return null;
      label93:
      Object localObject2 = null;
    }
  }
  
  private String Nw()
  {
    AppMethodBeat.i(254723);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(254723);
    return str;
  }
  
  private String Nx()
  {
    AppMethodBeat.i(254721);
    for (;;)
    {
      try
      {
        Object localObject1 = iAs();
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getString("io.flutter.Entrypoint");
          if (localObject1 != null)
          {
            AppMethodBeat.o(254721);
            return localObject1;
          }
          AppMethodBeat.o(254721);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(254721);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  private String Ny()
  {
    AppMethodBeat.i(254716);
    if ((iAy()) && ("android.intent.action.RUN".equals(getIntent().getAction())))
    {
      String str = getIntent().getDataString();
      if (str != null)
      {
        AppMethodBeat.o(254716);
        return str;
      }
    }
    AppMethodBeat.o(254716);
    return null;
  }
  
  private String Nz()
  {
    AppMethodBeat.i(254722);
    Object localObject;
    if (getIntent().hasExtra("route"))
    {
      localObject = getIntent().getStringExtra("route");
      AppMethodBeat.o(254722);
      return localObject;
    }
    try
    {
      localObject = iAs();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.flutter.InitialRoute");
        AppMethodBeat.o(254722);
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(254722);
      return null;
    }
    AppMethodBeat.o(254722);
    return null;
  }
  
  private boolean iAp()
  {
    AppMethodBeat.i(254711);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    AppMethodBeat.o(254711);
    return bool;
  }
  
  private Bundle iAs()
  {
    AppMethodBeat.i(254719);
    Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    AppMethodBeat.o(254719);
    return localBundle;
  }
  
  private boolean iAu()
  {
    AppMethodBeat.i(254712);
    try
    {
      Bundle localBundle = iAs();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("flutter_deeplinking_enabled");
        AppMethodBeat.o(254712);
        return bool;
      }
      AppMethodBeat.o(254712);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(254712);
    }
    return false;
  }
  
  private boolean iAy()
  {
    AppMethodBeat.i(254727);
    if ((getApplicationInfo().flags & 0x2) != 0)
    {
      AppMethodBeat.o(254727);
      return true;
    }
    AppMethodBeat.o(254727);
    return false;
  }
  
  public final j NC()
  {
    AppMethodBeat.i(254693);
    Object localObject = Nt();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(254693);
      return localObject;
    }
    AppMethodBeat.o(254693);
    return null;
  }
  
  public final io.flutter.embedding.engine.a ND()
  {
    return null;
  }
  
  public final void a(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(254713);
    io.flutter.embedding.engine.plugins.e.a.h(parama);
    AppMethodBeat.o(254713);
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(254708);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.aaoO.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(254708);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(254699);
    FlutterFragment localFlutterFragment = this.aaoO;
    if (localFlutterFragment.bGa("onBackPressed")) {
      localFlutterFragment.aaoB.onBackPressed();
    }
    AppMethodBeat.o(254699);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(254691);
    for (;;)
    {
      try
      {
        localObject1 = iAs();
        if (localObject1 == null) {
          continue;
        }
        int i = ((Bundle)localObject1).getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Object localObject1;
        e locale;
        b.iAh();
        continue;
        paramBundle = i.aapN;
        continue;
        l locall = l.aapR;
        continue;
        new StringBuilder("Creating FlutterFragment with new engine:\nBackground transparency mode: ").append(localObject2).append("\nDart entrypoint: ").append(Nx()).append("\nInitial route: ").append(Nz()).append("\nApp bundle path: ").append(Ny()).append("\nWill attach FlutterEngine to Activity: true");
        b.iAd();
        Object localObject2 = FlutterFragment.iAw();
        ((FlutterFragment.b)localObject2).ZYN = Nx();
        ((FlutterFragment.b)localObject2).ZYO = Nz();
        ((FlutterFragment.b)localObject2).aaoM = Ny();
        ((FlutterFragment.b)localObject2).aaoN = io.flutter.embedding.engine.d.bT(getIntent());
        ((FlutterFragment.b)localObject2).aaoL = Boolean.valueOf(iAu()).booleanValue();
        ((FlutterFragment.b)localObject2).cpj = paramBundle;
        ((FlutterFragment.b)localObject2).cpk = locall;
        ((FlutterFragment.b)localObject2).cpl = true;
        paramBundle = ((FlutterFragment.b)localObject2).iAx();
        continue;
      }
      super.onCreate(paramBundle);
      if (Ns() == e.a.aaoH) {
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
      locale = getSupportFragmentManager();
      this.aaoO = ((FlutterFragment)locale.findFragmentByTag("flutter_fragment"));
      if (this.aaoO == null)
      {
        localObject2 = Ns();
        if (Ns() != e.a.aaoG) {
          continue;
        }
        paramBundle = i.aapM;
        if (localObject2 != e.a.aaoG) {
          continue;
        }
        localObject1 = l.aapQ;
        if (Nw() == null) {
          continue;
        }
        new StringBuilder("Creating FlutterFragment with cached engine:\nCached engine ID: ").append(Nw()).append("\nWill destroy engine when Activity is destroyed: ").append(iAp()).append("\nBackground transparency mode: ").append(localObject2).append("\nWill attach FlutterEngine to Activity: true");
        b.iAd();
        localObject2 = FlutterFragment.bGb(Nw());
        ((FlutterFragment.a)localObject2).cpj = paramBundle;
        ((FlutterFragment.a)localObject2).cpk = ((l)localObject1);
        ((FlutterFragment.a)localObject2).aaoL = Boolean.valueOf(iAu()).booleanValue();
        ((FlutterFragment.a)localObject2).cpl = true;
        ((FlutterFragment.a)localObject2).aaoK = iAp();
        paramBundle = ((FlutterFragment.a)localObject2).iAx();
        this.aaoO = paramBundle;
        locale.beginTransaction().a(609893468, this.aaoO, "flutter_fragment").in();
      }
      AppMethodBeat.o(254691);
      return;
      b.iAd();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(254698);
    FlutterFragment localFlutterFragment = this.aaoO;
    if (localFlutterFragment.bGa("onNewIntent")) {
      localFlutterFragment.aaoB.onNewIntent(paramIntent);
    }
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(254698);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(254696);
    super.onPostResume();
    this.aaoO.aaoB.onPostResume();
    AppMethodBeat.o(254696);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254701);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.aaoO.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(254701);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(254705);
    super.onTrimMemory(paramInt);
    FlutterFragment localFlutterFragment = this.aaoO;
    if (localFlutterFragment.bGa("onTrimMemory")) {
      localFlutterFragment.aaoB.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(254705);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(254703);
    FlutterFragment localFlutterFragment = this.aaoO;
    if (localFlutterFragment.bGa("onUserLeaveHint")) {
      localFlutterFragment.aaoB.onUserLeaveHint();
    }
    AppMethodBeat.o(254703);
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