package com.tencent.wax.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.b.c;
import com.tencent.wax.d;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.f;
import io.flutter.embedding.android.h;
import io.flutter.embedding.android.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.k.d;
import java.util.Arrays;

public final class a
{
  a MHX;
  private WxaFlutterSplashView MHY;
  private io.flutter.plugin.platform.b MHZ;
  private boolean MIa;
  public c MIb;
  private final io.flutter.embedding.engine.b.b MIc;
  private io.flutter.embedding.engine.a tti;
  public FlutterView ttx;
  
  public a(a parama)
  {
    AppMethodBeat.i(195553);
    this.MIc = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR() {}
      
      public final void cSS() {}
    };
    this.MHX = parama;
    this.MIb = new com.tencent.wax.b.a(this.MHX.diH());
    AppMethodBeat.o(195553);
  }
  
  private void gdA()
  {
    AppMethodBeat.i(195558);
    if ((this.MHX.diI() == null) && (!this.tti.MZm.MZX))
    {
      com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.MHX.diJ() + ", and sending initial route: " + this.MHX.diL(), new Object[0]);
      if (this.MHX.diL() != null) {
        this.tti.MZr.setInitialRoute(this.MHX.diL());
      }
      DartExecutor.a locala = new DartExecutor.a(this.MHX.diK(), this.MHX.diJ());
      this.tti.MZm.a(locala);
    }
    AppMethodBeat.o(195558);
  }
  
  private void gdB()
  {
    AppMethodBeat.i(195571);
    if (this.MHX == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(195571);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(195571);
  }
  
  private void gdy()
  {
    AppMethodBeat.i(195555);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
    gdB();
    a locala = this.MHX;
    this.MHX.getContext();
    this.tti = locala.diO();
    if (this.tti != null)
    {
      this.MIa = true;
      AppMethodBeat.o(195555);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    this.MIa = false;
    AppMethodBeat.o(195555);
  }
  
  public final void gdx()
  {
    AppMethodBeat.i(195554);
    gdB();
    d.gdr().init();
    d.gdr().MHD = this.MHX.diH();
    if (this.tti == null) {
      gdy();
    }
    this.MHX.getActivity();
    this.MHZ = null;
    this.MHX.a(this.tti);
    AppMethodBeat.o(195554);
  }
  
  public final View gdz()
  {
    AppMethodBeat.i(195556);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    gdB();
    this.tti.MZn.a(this.MHX.getActivity(), this.MHX.getLifecycle());
    this.MIb.onCreateView();
    this.ttx = new FlutterView(this.MHX.getActivity(), this.MHX.diM(), this.MHX.diN());
    this.ttx.a(this.MIc);
    this.MHY = new WxaFlutterSplashView(this.MHX.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.MHY.setId(View.generateViewId());
    }
    for (;;)
    {
      this.MHY.a(this.ttx, this.MHX.diP());
      WxaFlutterSplashView localWxaFlutterSplashView = this.MHY;
      AppMethodBeat.o(195556);
      return localWxaFlutterSplashView;
      this.MHY.setId(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(195568);
    gdB();
    if (this.tti != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.tti.MZn.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(195568);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(195568);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(195565);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    gdB();
    if (this.tti != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.MIb.a(new k.d()
      {
        public final void df(Object paramAnonymousObject)
        {
          AppMethodBeat.i(195550);
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Boolean)) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() back press comsumed .", new Object[0]);
            AppMethodBeat.o(195550);
            return;
          }
          if (a.this.MHX.getActivity() != null) {
            a.this.MHX.getActivity().finish();
          }
          AppMethodBeat.o(195550);
        }
        
        public final void dmQ()
        {
          AppMethodBeat.i(195552);
          com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() notImplemented.", new Object[0]);
          if (a.this.MHX.getActivity() != null) {
            a.this.MHX.getActivity().finish();
          }
          AppMethodBeat.o(195552);
        }
        
        public final void f(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(195551);
          com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() error. s:%s s1:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (a.this.MHX.getActivity() != null) {
            a.this.MHX.getActivity().finish();
          }
          AppMethodBeat.o(195551);
        }
      });
      AppMethodBeat.o(195565);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    if (this.MHX.getActivity() != null) {
      this.MHX.getActivity().finish();
    }
    AppMethodBeat.o(195565);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(195563);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.MIb.onDestroyView();
    gdB();
    d.gdr().a(this.ttx);
    AppMethodBeat.o(195563);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(195564);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    gdB();
    if (this.MHZ != null)
    {
      this.MHZ.destroy();
      this.MHZ = null;
    }
    d.gdr().MHD = null;
    AppMethodBeat.o(195564);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(195567);
    gdB();
    if (this.tti != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.tti.MZn.onNewIntent(paramIntent);
      AppMethodBeat.o(195567);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(195567);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(195561);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.MIb.onPause();
    gdB();
    AppMethodBeat.o(195561);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(195560);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    gdB();
    if (this.tti != null)
    {
      if (this.MHZ != null)
      {
        this.MHZ.gjL();
        AppMethodBeat.o(195560);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(195560);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(195566);
    gdB();
    if (this.tti != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.tti.MZn.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(195566);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(195566);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195559);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    this.MIb.onResume();
    gdB();
    AppMethodBeat.o(195559);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(195557);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    gdB();
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    d.gdr().MHD = this.MHX.diH();
    d.gdr().a(this.ttx, this.tti);
    gdA();
    d.gdr().b(this.ttx);
    AppMethodBeat.o(195557);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(195562);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    gdB();
    d.gdr().c(this.ttx);
    AppMethodBeat.o(195562);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(195570);
    gdB();
    if (this.tti != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.tti.MZv.gjI();
        AppMethodBeat.o(195570);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(195570);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(195569);
    gdB();
    if (this.tti != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.tti.MZn.onUserLeaveHint();
      AppMethodBeat.o(195569);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(195569);
  }
  
  public static abstract interface a
    extends io.flutter.embedding.android.e, f, i
  {
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract com.tencent.wax.b.b diH();
    
    public abstract String diI();
    
    public abstract String diJ();
    
    public abstract String diK();
    
    public abstract String diL();
    
    public abstract FlutterView.b diM();
    
    public abstract FlutterView.c diN();
    
    public abstract io.flutter.embedding.engine.a diO();
    
    public abstract h diP();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.ui.a
 * JD-Core Version:    0.7.0.1
 */