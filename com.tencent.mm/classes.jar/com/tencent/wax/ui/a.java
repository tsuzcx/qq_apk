package com.tencent.wax.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.d;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.f;
import io.flutter.embedding.android.g;
import io.flutter.embedding.android.h;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import java.util.Arrays;

public final class a
{
  private a KuZ;
  private WxaFlutterSplashView Kva;
  private io.flutter.plugin.platform.b Kvb;
  private boolean Kvc;
  private com.tencent.wax.b.c Kvd;
  private final io.flutter.embedding.engine.b.b Kve;
  private io.flutter.embedding.engine.a slN;
  public FlutterView smb;
  
  public a(a parama)
  {
    AppMethodBeat.i(191742);
    this.Kve = new io.flutter.embedding.engine.b.b()
    {
      public final void cHX() {}
      
      public final void cHY() {}
    };
    this.KuZ = parama;
    this.Kvd = new com.tencent.wax.b.a((com.tencent.wax.b.b)this.KuZ.getActivity());
    AppMethodBeat.o(191742);
  }
  
  private void fHG()
  {
    AppMethodBeat.i(191744);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
    fHJ();
    a locala = this.KuZ;
    this.KuZ.getContext();
    this.slN = locala.cWI();
    if (this.slN != null)
    {
      this.Kvc = true;
      AppMethodBeat.o(191744);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    this.Kvc = false;
    AppMethodBeat.o(191744);
  }
  
  private void fHI()
  {
    AppMethodBeat.i(191747);
    if ((this.KuZ.cWC() == null) && (!this.slN.KLk.KLV))
    {
      com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.KuZ.cWD() + ", and sending initial route: " + this.KuZ.cWF(), new Object[0]);
      if (this.KuZ.cWF() != null) {
        this.slN.KLp.setInitialRoute(this.KuZ.cWF());
      }
      DartExecutor.a locala = new DartExecutor.a(this.KuZ.cWE(), this.KuZ.cWD());
      this.slN.KLk.a(locala);
    }
    AppMethodBeat.o(191747);
  }
  
  private void fHJ()
  {
    AppMethodBeat.i(191760);
    if (this.KuZ == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(191760);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(191760);
  }
  
  public final void fHF()
  {
    AppMethodBeat.i(191743);
    fHJ();
    d.fHA().init();
    d.fHA().KuF = this.KuZ.getActivity();
    if (this.slN == null) {
      fHG();
    }
    this.Kvb = null;
    this.KuZ.a(this.slN);
    AppMethodBeat.o(191743);
  }
  
  public final View fHH()
  {
    AppMethodBeat.i(191745);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    fHJ();
    this.slN.KLl.a(this.KuZ.getActivity(), this.KuZ.getLifecycle());
    this.Kvd.onCreateView();
    this.smb = new FlutterView(this.KuZ.getActivity(), this.KuZ.cWG(), this.KuZ.cWH());
    this.smb.a(this.Kve);
    this.Kva = new WxaFlutterSplashView(this.KuZ.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.Kva.setId(View.generateViewId());
    }
    for (;;)
    {
      this.Kva.a(this.smb, this.KuZ.cWz());
      WxaFlutterSplashView localWxaFlutterSplashView = this.Kva;
      AppMethodBeat.o(191745);
      return localWxaFlutterSplashView;
      this.Kva.setId(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(191757);
    fHJ();
    if (this.slN != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.slN.KLl.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(191757);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(191757);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(191754);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    this.Kvd.onBackPressed();
    fHJ();
    if (this.slN != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.slN.KLp.cHW();
      AppMethodBeat.o(191754);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(191754);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(191752);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.Kvd.onDestroyView();
    fHJ();
    this.smb.b(this.Kve);
    AppMethodBeat.o(191752);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(191753);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    fHJ();
    if (this.Kvb != null)
    {
      this.Kvb.destroy();
      this.Kvb = null;
    }
    d.fHA().KuF = null;
    AppMethodBeat.o(191753);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(191756);
    fHJ();
    if (this.slN != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.slN.KLl.onNewIntent(paramIntent);
      AppMethodBeat.o(191756);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(191756);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(191750);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.Kvd.onPause();
    fHJ();
    this.slN.KLn.fNz();
    AppMethodBeat.o(191750);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(191749);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    fHJ();
    if (this.slN != null)
    {
      if (this.Kvb != null)
      {
        this.Kvb.fNK();
        AppMethodBeat.o(191749);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(191749);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191755);
    fHJ();
    if (this.slN != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.slN.KLl.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(191755);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(191755);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(191748);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    this.Kvd.onResume();
    fHJ();
    this.slN.KLn.fNA();
    AppMethodBeat.o(191748);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(191746);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    fHJ();
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    this.smb.c(this.slN);
    fHI();
    AppMethodBeat.o(191746);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(191751);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    fHJ();
    AppMethodBeat.o(191751);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(191759);
    fHJ();
    if (this.slN != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.slN.KLt.fNH();
        AppMethodBeat.o(191759);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(191759);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(191758);
    fHJ();
    if (this.slN != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.slN.KLl.onUserLeaveHint();
      AppMethodBeat.o(191758);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(191758);
  }
  
  public static abstract interface a
    extends io.flutter.embedding.android.e, f, h
  {
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract String cWC();
    
    public abstract String cWD();
    
    public abstract String cWE();
    
    public abstract String cWF();
    
    public abstract FlutterView.b cWG();
    
    public abstract FlutterView.c cWH();
    
    public abstract io.flutter.embedding.engine.a cWI();
    
    public abstract g cWz();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.ui.a
 * JD-Core Version:    0.7.0.1
 */