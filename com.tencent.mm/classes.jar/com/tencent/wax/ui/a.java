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
import io.flutter.embedding.android.h;
import io.flutter.embedding.android.i;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import java.util.Arrays;

public final class a
{
  private a Mla;
  private WxaFlutterSplashView Mlb;
  private io.flutter.plugin.platform.b Mlc;
  private boolean Mld;
  private com.tencent.wax.b.c Mle;
  private final io.flutter.embedding.engine.b.b Mlf;
  public FlutterView tiF;
  private io.flutter.embedding.engine.a tiq;
  
  public a(a parama)
  {
    AppMethodBeat.i(217539);
    this.Mlf = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm() {}
      
      public final void cQn() {}
    };
    this.Mla = parama;
    this.Mle = new com.tencent.wax.b.a((com.tencent.wax.b.b)this.Mla.getActivity());
    AppMethodBeat.o(217539);
  }
  
  private void fYX()
  {
    AppMethodBeat.i(217541);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
    fZa();
    a locala = this.Mla;
    this.Mla.getContext();
    this.tiq = locala.dfU();
    if (this.tiq != null)
    {
      this.Mld = true;
      AppMethodBeat.o(217541);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    this.Mld = false;
    AppMethodBeat.o(217541);
  }
  
  private void fYZ()
  {
    AppMethodBeat.i(217544);
    if ((this.Mla.dfO() == null) && (!this.tiq.MCh.MCS))
    {
      com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.Mla.dfP() + ", and sending initial route: " + this.Mla.dfR(), new Object[0]);
      if (this.Mla.dfR() != null) {
        this.tiq.MCm.setInitialRoute(this.Mla.dfR());
      }
      DartExecutor.a locala = new DartExecutor.a(this.Mla.dfQ(), this.Mla.dfP());
      this.tiq.MCh.a(locala);
    }
    AppMethodBeat.o(217544);
  }
  
  private void fZa()
  {
    AppMethodBeat.i(217557);
    if (this.Mla == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(217557);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(217557);
  }
  
  public final void fYW()
  {
    AppMethodBeat.i(217540);
    fZa();
    d.fYR().init();
    d.fYR().MkG = this.Mla.getActivity();
    if (this.tiq == null) {
      fYX();
    }
    this.Mlc = null;
    this.Mla.a(this.tiq);
    AppMethodBeat.o(217540);
  }
  
  public final View fYY()
  {
    AppMethodBeat.i(217542);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    fZa();
    this.tiq.MCi.a(this.Mla.getActivity(), this.Mla.getLifecycle());
    this.Mle.onCreateView();
    this.tiF = new FlutterView(this.Mla.getActivity(), this.Mla.dfS(), this.Mla.dfT());
    this.tiF.a(this.Mlf);
    this.Mlb = new WxaFlutterSplashView(this.Mla.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.Mlb.setId(View.generateViewId());
    }
    for (;;)
    {
      this.Mlb.a(this.tiF, this.Mla.dfL());
      WxaFlutterSplashView localWxaFlutterSplashView = this.Mlb;
      AppMethodBeat.o(217542);
      return localWxaFlutterSplashView;
      this.Mlb.setId(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217554);
    fZa();
    if (this.tiq != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.tiq.MCi.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(217554);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(217554);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(217551);
    com.tencent.wax.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    this.Mle.onBackPressed();
    fZa();
    if (this.tiq != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.tiq.MCm.cQl();
      AppMethodBeat.o(217551);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(217551);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(217549);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.Mle.onDestroyView();
    fZa();
    this.tiF.b(this.Mlf);
    AppMethodBeat.o(217549);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(217550);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    fZa();
    if (this.Mlc != null)
    {
      this.Mlc.destroy();
      this.Mlc = null;
    }
    d.fYR().MkG = null;
    AppMethodBeat.o(217550);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(217553);
    fZa();
    if (this.tiq != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.tiq.MCi.onNewIntent(paramIntent);
      AppMethodBeat.o(217553);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(217553);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(217547);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.Mle.onPause();
    fZa();
    this.tiq.MCk.geY();
    AppMethodBeat.o(217547);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(217546);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    fZa();
    if (this.tiq != null)
    {
      if (this.Mlc != null)
      {
        this.Mlc.gfj();
        AppMethodBeat.o(217546);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(217546);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217552);
    fZa();
    if (this.tiq != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.tiq.MCi.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(217552);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(217552);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(217545);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    this.Mle.onResume();
    fZa();
    this.tiq.MCk.geZ();
    AppMethodBeat.o(217545);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(217543);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    fZa();
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    this.tiF.c(this.tiq);
    fYZ();
    AppMethodBeat.o(217543);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(217548);
    com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    fZa();
    AppMethodBeat.o(217548);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(217556);
    fZa();
    if (this.tiq != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.tiq.MCq.gfg();
        AppMethodBeat.o(217556);
      }
    }
    else {
      com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(217556);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(217555);
    fZa();
    if (this.tiq != null)
    {
      com.tencent.wax.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.tiq.MCi.onUserLeaveHint();
      AppMethodBeat.o(217555);
      return;
    }
    com.tencent.wax.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(217555);
  }
  
  public static abstract interface a
    extends io.flutter.embedding.android.e, f, i
  {
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract h dfL();
    
    public abstract String dfO();
    
    public abstract String dfP();
    
    public abstract String dfQ();
    
    public abstract String dfR();
    
    public abstract FlutterView.b dfS();
    
    public abstract FlutterView.c dfT();
    
    public abstract io.flutter.embedding.engine.a dfU();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.ui.a
 * JD-Core Version:    0.7.0.1
 */