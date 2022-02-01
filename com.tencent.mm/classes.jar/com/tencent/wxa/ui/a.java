package com.tencent.wxa.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import androidx.lifecycle.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.f;
import io.flutter.embedding.android.j;
import io.flutter.embedding.android.k;
import io.flutter.embedding.engine.b.l;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.k.d;
import java.util.Arrays;

public final class a
{
  public FlutterView BCI;
  private io.flutter.plugin.platform.b BCJ;
  private io.flutter.embedding.engine.a BCx;
  a ZZi;
  private WxaFlutterSplashView ZZj;
  private boolean ZZk;
  public com.tencent.wxa.b.c ZZl;
  private final io.flutter.embedding.engine.renderer.b ZZm;
  private boolean fEs;
  
  public a(a parama)
  {
    AppMethodBeat.i(224938);
    this.fEs = true;
    this.ZZm = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX() {}
      
      public final void epY() {}
    };
    this.ZZi = parama;
    this.ZZl = new com.tencent.wxa.b.a(this.ZZi.Nv());
    AppMethodBeat.o(224938);
  }
  
  private void ivB()
  {
    AppMethodBeat.i(224941);
    com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
    ivE();
    a locala = this.ZZi;
    this.ZZi.getContext();
    this.BCx = locala.ND();
    if (this.BCx != null)
    {
      this.ZZk = true;
      AppMethodBeat.o(224941);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    this.ZZk = false;
    AppMethodBeat.o(224941);
  }
  
  private void ivD()
  {
    AppMethodBeat.i(224948);
    if ((this.ZZi.Nw() == null) && (!this.BCx.aapU.aaqG))
    {
      com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.ZZi.Nx() + ", and sending initial route: " + this.ZZi.Nz(), new Object[0]);
      if (this.ZZi.Nz() != null) {
        this.BCx.aaqb.setInitialRoute(this.ZZi.Nz());
      }
      DartExecutor.a locala = new DartExecutor.a(this.ZZi.Ny(), this.ZZi.Nx());
      this.BCx.aapU.a(locala);
    }
    AppMethodBeat.o(224948);
  }
  
  private void ivE()
  {
    AppMethodBeat.i(224976);
    if (this.ZZi == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(224976);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(224976);
  }
  
  public final void ivA()
  {
    AppMethodBeat.i(224939);
    ivE();
    com.tencent.wxa.c.ivt().init();
    com.tencent.wxa.c.ivt().ZYK = this.ZZi.Nv();
    if (this.BCx == null) {
      ivB();
    }
    this.BCJ = this.ZZi.a(this.ZZi.getActivity(), this.BCx);
    this.ZZi.a(this.BCx);
    AppMethodBeat.o(224939);
  }
  
  public final View ivC()
  {
    AppMethodBeat.i(224944);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    ivE();
    this.BCx.aapV.a(this.ZZi.getActivity(), this.ZZi.getLifecycle());
    this.ZZl.onCreateView();
    this.BCI = new FlutterView(this.ZZi.getActivity(), this.ZZi.NA(), this.ZZi.NB());
    this.BCI.a(this.ZZm);
    this.ZZj = new WxaFlutterSplashView(this.ZZi.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.ZZj.setId(View.generateViewId());
    }
    for (;;)
    {
      this.ZZj.a(this.BCI, this.ZZi.NC());
      WxaFlutterSplashView localWxaFlutterSplashView = this.ZZj;
      AppMethodBeat.o(224944);
      return localWxaFlutterSplashView;
      this.ZZj.setId(0);
    }
  }
  
  public final void oC(boolean paramBoolean)
  {
    AppMethodBeat.i(224961);
    com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    ivE();
    if (this.BCx != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.ZZl.a(paramBoolean, new k.d()
      {
        public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(224934);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() error. s:%s s1:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (a.this.ZZi.getActivity() != null) {
            a.this.ZZi.getActivity().finish();
          }
          AppMethodBeat.o(224934);
        }
        
        public final void bb(Object paramAnonymousObject)
        {
          AppMethodBeat.i(224931);
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Boolean)) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() back press comsumed .", new Object[0]);
            AppMethodBeat.o(224931);
            return;
          }
          if (a.this.ZZi.getActivity() != null) {
            a.this.ZZi.getActivity().finish();
          }
          AppMethodBeat.o(224931);
        }
        
        public final void epZ()
        {
          AppMethodBeat.i(224935);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() notImplemented.", new Object[0]);
          if (a.this.ZZi.getActivity() != null) {
            a.this.ZZi.getActivity().finish();
          }
          AppMethodBeat.o(224935);
        }
      });
      AppMethodBeat.o(224961);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    if (this.ZZi.getActivity() != null) {
      this.ZZi.getActivity().finish();
    }
    AppMethodBeat.o(224961);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(224971);
    ivE();
    if (this.BCx != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.BCx.aapV.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(224971);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(224971);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(224956);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.ZZl.onDestroyView();
    ivE();
    AppMethodBeat.o(224956);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(224958);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    ivE();
    if (this.BCJ != null)
    {
      this.BCJ.destroy();
      this.BCJ = null;
    }
    com.tencent.wxa.c.ivt().ZYK = null;
    AppMethodBeat.o(224958);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(224969);
    ivE();
    if (this.BCx != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.BCx.aapV.onNewIntent(paramIntent);
      AppMethodBeat.o(224969);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(224969);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(224954);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.fEs = true;
    this.ZZl.onPause();
    ivE();
    AppMethodBeat.o(224954);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(224951);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    ivE();
    if (this.BCx != null)
    {
      if (this.BCJ != null)
      {
        this.BCJ.iBs();
        AppMethodBeat.o(224951);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(224951);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224968);
    ivE();
    if (this.BCx != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.BCx.aapV.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(224968);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(224968);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(224949);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    if (this.fEs)
    {
      com.tencent.wxa.c.ivt().ZYK = this.ZZi.Nv();
      com.tencent.wxa.c.ivt().a(this.BCI, this.BCx);
      com.tencent.wxa.c.ivt().b(this.BCI);
      com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "attachViewToFlutterEngine", new Object[0]);
      this.fEs = false;
    }
    this.ZZl.onResume();
    ivE();
    AppMethodBeat.o(224949);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(224945);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    ivE();
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    com.tencent.wxa.c.ivt().ZYK = this.ZZi.Nv();
    com.tencent.wxa.c.ivt().a(this.BCI, this.BCx);
    ivD();
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "attachViewToFlutterEngine", new Object[0]);
    this.fEs = false;
    com.tencent.wxa.c.ivt().b(this.BCI);
    AppMethodBeat.o(224945);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(224955);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    ivE();
    com.tencent.wxa.c.ivt().a(this.BCI);
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "detachViewFromFlutterEngine", new Object[0]);
    com.tencent.wxa.c.ivt().c(this.BCI);
    AppMethodBeat.o(224955);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(224974);
    ivE();
    if (this.BCx != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.BCx.aaqf.iBl();
        AppMethodBeat.o(224974);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(224974);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(224972);
    ivE();
    if (this.BCx != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.BCx.aapV.onUserLeaveHint();
      AppMethodBeat.o(224972);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(224972);
  }
  
  public static abstract interface a
    extends f, io.flutter.embedding.android.g, k
  {
    public abstract FlutterView.b NA();
    
    public abstract FlutterView.c NB();
    
    public abstract j NC();
    
    public abstract io.flutter.embedding.engine.a ND();
    
    public abstract com.tencent.wxa.b.b Nv();
    
    public abstract String Nw();
    
    public abstract String Nx();
    
    public abstract String Ny();
    
    public abstract String Nz();
    
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract h getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.ui.a
 * JD-Core Version:    0.7.0.1
 */