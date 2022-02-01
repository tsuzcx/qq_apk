package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
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
import android.view.Window;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class FlutterActivity
  extends HellActivity
  implements androidx.lifecycle.l, d.a
{
  private m BCL;
  protected d aaoB;
  
  public FlutterActivity()
  {
    AppMethodBeat.i(10028);
    this.BCL = new m(this);
    AppMethodBeat.o(10028);
  }
  
  private e.a Ns()
  {
    AppMethodBeat.i(255703);
    if (getIntent().hasExtra("background_mode"))
    {
      locala = e.a.valueOf(getIntent().getStringExtra("background_mode"));
      AppMethodBeat.o(255703);
      return locala;
    }
    e.a locala = e.a.aaoG;
    AppMethodBeat.o(255703);
    return locala;
  }
  
  private Drawable Nt()
  {
    AppMethodBeat.i(10031);
    for (;;)
    {
      try
      {
        Object localObject = iAs();
        if (localObject == null) {
          break label89;
        }
        i = ((Bundle)localObject).getInt("io.flutter.embedding.android.SplashScreenDrawable");
        if (i != 0)
        {
          if (Build.VERSION.SDK_INT > 21)
          {
            localObject = getResources().getDrawable(i, getTheme());
            AppMethodBeat.o(10031);
            return localObject;
          }
          localObject = getResources().getDrawable(i);
          AppMethodBeat.o(10031);
          return localObject;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10031);
        return null;
      }
      AppMethodBeat.o(10031);
      return null;
      label89:
      int i = 0;
    }
  }
  
  private boolean bGa(String paramString)
  {
    AppMethodBeat.i(255715);
    if (this.aaoB == null)
    {
      new StringBuilder("FlutterActivity ").append(hashCode()).append(" ").append(paramString).append(" called after release.");
      io.flutter.b.iAd();
      AppMethodBeat.o(255715);
      return false;
    }
    AppMethodBeat.o(255715);
    return true;
  }
  
  private Bundle iAs()
  {
    AppMethodBeat.i(255706);
    Bundle localBundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    AppMethodBeat.o(255706);
    return localBundle;
  }
  
  private void release()
  {
    AppMethodBeat.i(255694);
    this.aaoB.onDestroyView();
    this.aaoB.onDetach();
    this.aaoB.release();
    this.aaoB = null;
    AppMethodBeat.o(255694);
  }
  
  public final j NC()
  {
    AppMethodBeat.i(10030);
    Object localObject = Nt();
    if (localObject != null)
    {
      localObject = new DrawableSplashScreen((Drawable)localObject);
      AppMethodBeat.o(10030);
      return localObject;
    }
    AppMethodBeat.o(10030);
    return null;
  }
  
  public final io.flutter.embedding.engine.a ND()
  {
    return null;
  }
  
  public final String Nw()
  {
    AppMethodBeat.i(10045);
    String str = getIntent().getStringExtra("cached_engine_id");
    AppMethodBeat.o(10045);
    return str;
  }
  
  public final String Nx()
  {
    AppMethodBeat.i(10047);
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
            AppMethodBeat.o(10047);
            return localObject1;
          }
          AppMethodBeat.o(10047);
          return "main";
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        AppMethodBeat.o(10047);
        return "main";
      }
      Object localObject2 = null;
    }
  }
  
  public final String Ny()
  {
    AppMethodBeat.i(10049);
    if ((getApplicationInfo().flags & 0x2) != 0) {}
    for (int i = 1; (i != 0) && ("android.intent.action.RUN".equals(getIntent().getAction())); i = 0)
    {
      String str = getIntent().getDataString();
      if (str == null) {
        break;
      }
      AppMethodBeat.o(10049);
      return str;
    }
    AppMethodBeat.o(10049);
    return null;
  }
  
  public final String Nz()
  {
    AppMethodBeat.i(10048);
    Object localObject;
    if (getIntent().hasExtra("route"))
    {
      localObject = getIntent().getStringExtra("route");
      AppMethodBeat.o(10048);
      return localObject;
    }
    try
    {
      localObject = iAs();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("io.flutter.InitialRoute");
        AppMethodBeat.o(10048);
        return localObject;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(10048);
      return null;
    }
    AppMethodBeat.o(10048);
    return null;
  }
  
  public final io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10053);
    paramActivity = new io.flutter.plugin.platform.b(this, parama.aaqd, this);
    AppMethodBeat.o(10053);
    return paramActivity;
  }
  
  public final void a(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(255711);
    io.flutter.embedding.engine.plugins.e.a.h(parama);
    AppMethodBeat.o(255711);
  }
  
  public final void b(io.flutter.embedding.engine.a parama) {}
  
  public final void epX()
  {
    AppMethodBeat.i(255713);
    if (Build.VERSION.SDK_INT >= 21) {
      reportFullyDrawn();
    }
    AppMethodBeat.o(255713);
  }
  
  public final void epY() {}
  
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
  
  public final void iAm()
  {
    AppMethodBeat.i(255695);
    new StringBuilder("FlutterActivity ").append(this).append(" connection to the engine ").append(this.aaoB.BCx).append(" evicted by another attaching activity");
    io.flutter.b.iAd();
    release();
    AppMethodBeat.o(255695);
  }
  
  public final io.flutter.embedding.engine.d iAo()
  {
    AppMethodBeat.i(10044);
    io.flutter.embedding.engine.d locald = io.flutter.embedding.engine.d.bT(getIntent());
    AppMethodBeat.o(10044);
    return locald;
  }
  
  public final boolean iAp()
  {
    AppMethodBeat.i(10046);
    boolean bool = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
    if ((Nw() != null) || (this.aaoB.ZZk))
    {
      AppMethodBeat.o(10046);
      return bool;
    }
    bool = getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    AppMethodBeat.o(10046);
    return bool;
  }
  
  public final i iAq()
  {
    AppMethodBeat.i(255700);
    if (Ns() == e.a.aaoG)
    {
      locali = i.aapM;
      AppMethodBeat.o(255700);
      return locali;
    }
    i locali = i.aapN;
    AppMethodBeat.o(255700);
    return locali;
  }
  
  public final l iAr()
  {
    AppMethodBeat.i(255702);
    if (Ns() == e.a.aaoG)
    {
      locall = l.aapQ;
      AppMethodBeat.o(255702);
      return locall;
    }
    l locall = l.aapR;
    AppMethodBeat.o(255702);
    return locall;
  }
  
  public final boolean iAt()
  {
    return true;
  }
  
  public final boolean iAu()
  {
    AppMethodBeat.i(255712);
    try
    {
      Bundle localBundle = iAs();
      if (localBundle != null)
      {
        boolean bool = localBundle.getBoolean("flutter_deeplinking_enabled");
        AppMethodBeat.o(255712);
        return bool;
      }
      AppMethodBeat.o(255712);
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      AppMethodBeat.o(255712);
    }
    return false;
  }
  
  public final boolean iAv()
  {
    AppMethodBeat.i(255714);
    if (getIntent().hasExtra("enable_state_restoration"))
    {
      boolean bool = getIntent().getBooleanExtra("enable_state_restoration", false);
      AppMethodBeat.o(255714);
      return bool;
    }
    if (Nw() != null)
    {
      AppMethodBeat.o(255714);
      return false;
    }
    AppMethodBeat.o(255714);
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10038);
    if (bGa("onActivityResult")) {
      this.aaoB.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(10038);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(10040);
    if (bGa("onBackPressed")) {
      this.aaoB.onBackPressed();
    }
    AppMethodBeat.o(10040);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(10029);
    for (;;)
    {
      try
      {
        Bundle localBundle = iAs();
        if (localBundle == null) {
          continue;
        }
        int i = localBundle.getInt("io.flutter.embedding.android.NormalTheme", -1);
        if (i != -1) {
          setTheme(i);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        io.flutter.b.iAh();
        continue;
      }
      super.onCreate(paramBundle);
      this.aaoB = new d(this);
      this.aaoB.ivA();
      this.aaoB.onRestoreInstanceState(paramBundle);
      this.BCL.a(h.a.ON_CREATE);
      if (Ns() == e.a.aaoH) {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
      }
      setContentView(this.aaoB.ivC());
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = getWindow();
        paramBundle.addFlags(-2147483648);
        paramBundle.setStatusBarColor(1073741824);
        paramBundle.getDecorView().setSystemUiVisibility(1280);
      }
      AppMethodBeat.o(10029);
      return;
      io.flutter.b.iAd();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(10037);
    super.onDestroy();
    if (bGa("onDestroy")) {
      release();
    }
    this.BCL.a(h.a.ON_DESTROY);
    AppMethodBeat.o(10037);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(10039);
    super.onNewIntent(paramIntent);
    if (bGa("onNewIntent")) {
      this.aaoB.onNewIntent(paramIntent);
    }
    AppMethodBeat.o(10039);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(10035);
    super.onPause();
    this.aaoB.onPause();
    this.BCL.a(h.a.ON_PAUSE);
    AppMethodBeat.o(10035);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(10034);
    super.onPostResume();
    this.aaoB.onPostResume();
    AppMethodBeat.o(10034);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10041);
    if (bGa("onRequestPermissionsResult")) {
      this.aaoB.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(10041);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(10033);
    super.onResume();
    this.BCL.a(h.a.ON_RESUME);
    this.aaoB.onResume();
    AppMethodBeat.o(10033);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(255693);
    super.onSaveInstanceState(paramBundle);
    if (bGa("onSaveInstanceState")) {
      this.aaoB.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(255693);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(10032);
    super.onStart();
    this.BCL.a(h.a.ON_START);
    this.aaoB.onStart();
    AppMethodBeat.o(10032);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(10036);
    super.onStop();
    if (bGa("onStop")) {
      this.aaoB.onStop();
    }
    this.BCL.a(h.a.ON_STOP);
    AppMethodBeat.o(10036);
  }
  
  public void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(10043);
    super.onTrimMemory(paramInt);
    if (bGa("onTrimMemory")) {
      this.aaoB.onTrimMemory(paramInt);
    }
    AppMethodBeat.o(10043);
  }
  
  public void onUserLeaveHint()
  {
    AppMethodBeat.i(10042);
    if (bGa("onUserLeaveHint")) {
      this.aaoB.onUserLeaveHint();
    }
    AppMethodBeat.o(10042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterActivity
 * JD-Core Version:    0.7.0.1
 */