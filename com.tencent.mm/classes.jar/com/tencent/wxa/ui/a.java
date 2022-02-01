package com.tencent.wxa.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.FlutterView.c;
import io.flutter.embedding.android.e;
import io.flutter.embedding.android.j;
import io.flutter.embedding.android.k;
import io.flutter.embedding.engine.c.l;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.k.d;
import java.util.Arrays;

public final class a
{
  a Syb;
  private WxaFlutterSplashView Syc;
  private boolean Syd;
  public com.tencent.wxa.b.c Sye;
  private final io.flutter.embedding.engine.b.b Syf;
  private io.flutter.embedding.engine.a wJi;
  public FlutterView wKM;
  private io.flutter.plugin.platform.b wKN;
  
  public a(a parama)
  {
    AppMethodBeat.i(206366);
    this.Syf = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt() {}
      
      public final void dLu() {}
    };
    this.Syb = parama;
    this.Sye = new com.tencent.wxa.b.a(this.Syb.KI());
    AppMethodBeat.o(206366);
  }
  
  private void hrP()
  {
    AppMethodBeat.i(206368);
    com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
    hrS();
    a locala = this.Syb;
    this.Syb.getContext();
    this.wJi = locala.KP();
    if (this.wJi != null)
    {
      this.Syd = true;
      AppMethodBeat.o(206368);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    this.Syd = false;
    AppMethodBeat.o(206368);
  }
  
  private void hrR()
  {
    AppMethodBeat.i(206371);
    if ((this.Syb.KJ() == null) && (!this.wJi.SNW.SOI))
    {
      com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.Syb.KK() + ", and sending initial route: " + this.Syb.KM(), new Object[0]);
      if (this.Syb.KM() != null) {
        this.wJi.SOc.setInitialRoute(this.Syb.KM());
      }
      DartExecutor.a locala = new DartExecutor.a(this.Syb.KL(), this.Syb.KK());
      this.wJi.SNW.a(locala);
    }
    AppMethodBeat.o(206371);
  }
  
  private void hrS()
  {
    AppMethodBeat.i(206384);
    if (this.Syb == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(206384);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(206384);
  }
  
  public final void hrO()
  {
    AppMethodBeat.i(206367);
    hrS();
    com.tencent.wxa.c.hrH().init();
    com.tencent.wxa.c.hrH().SxG = this.Syb.KI();
    if (this.wJi == null) {
      hrP();
    }
    this.Syb.getActivity();
    this.wKN = null;
    this.Syb.b(this.wJi);
    AppMethodBeat.o(206367);
  }
  
  public final View hrQ()
  {
    AppMethodBeat.i(206369);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    hrS();
    this.wJi.SNX.a(this.Syb.getActivity(), this.Syb.getLifecycle());
    this.Sye.onCreateView();
    this.wKM = new FlutterView(this.Syb.getActivity(), this.Syb.KN(), this.Syb.KO());
    this.wKM.a(this.Syf);
    this.Syc = new WxaFlutterSplashView(this.Syb.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.Syc.setId(View.generateViewId());
    }
    for (;;)
    {
      this.Syc.a(this.wKM, this.Syb.KF());
      WxaFlutterSplashView localWxaFlutterSplashView = this.Syc;
      AppMethodBeat.o(206369);
      return localWxaFlutterSplashView;
      this.Syc.setId(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206381);
    hrS();
    if (this.wJi != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.wJi.SNX.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(206381);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(206381);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(206378);
    com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    hrS();
    if (this.wJi != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.Sye.a(new k.d()
      {
        public final void b(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(206364);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() error. s:%s s1:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (a.this.Syb.getActivity() != null) {
            a.this.Syb.getActivity().finish();
          }
          AppMethodBeat.o(206364);
        }
        
        public final void ba(Object paramAnonymousObject)
        {
          AppMethodBeat.i(206363);
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Boolean)) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() back press comsumed .", new Object[0]);
            AppMethodBeat.o(206363);
            return;
          }
          if (a.this.Syb.getActivity() != null) {
            a.this.Syb.getActivity().finish();
          }
          AppMethodBeat.o(206363);
        }
        
        public final void dLv()
        {
          AppMethodBeat.i(206365);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() notImplemented.", new Object[0]);
          if (a.this.Syb.getActivity() != null) {
            a.this.Syb.getActivity().finish();
          }
          AppMethodBeat.o(206365);
        }
      });
      AppMethodBeat.o(206378);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    if (this.Syb.getActivity() != null) {
      this.Syb.getActivity().finish();
    }
    AppMethodBeat.o(206378);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(206376);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.Sye.onDestroyView();
    hrS();
    com.tencent.wxa.c.hrH().a(this.wKM);
    AppMethodBeat.o(206376);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(206377);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    hrS();
    if (this.wKN != null)
    {
      this.wKN.destroy();
      this.wKN = null;
    }
    com.tencent.wxa.c.hrH().SxG = null;
    AppMethodBeat.o(206377);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(206380);
    hrS();
    if (this.wJi != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.wJi.SNX.onNewIntent(paramIntent);
      AppMethodBeat.o(206380);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(206380);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206374);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.Sye.onPause();
    hrS();
    AppMethodBeat.o(206374);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(206373);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    hrS();
    if (this.wJi != null)
    {
      if (this.wKN != null)
      {
        this.wKN.hxp();
        AppMethodBeat.o(206373);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(206373);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206379);
    hrS();
    if (this.wJi != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.wJi.SNX.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(206379);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(206379);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206372);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    this.Sye.onResume();
    hrS();
    AppMethodBeat.o(206372);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(206370);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    hrS();
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    com.tencent.wxa.c.hrH().SxG = this.Syb.KI();
    com.tencent.wxa.c.hrH().a(this.wKM, this.wJi);
    hrR();
    com.tencent.wxa.c.hrH().b(this.wKM);
    AppMethodBeat.o(206370);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(206375);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    hrS();
    com.tencent.wxa.c.hrH().c(this.wKM);
    AppMethodBeat.o(206375);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(206383);
    hrS();
    if (this.wJi != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.wJi.SOh.hxj();
        AppMethodBeat.o(206383);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(206383);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(206382);
    hrS();
    if (this.wJi != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.wJi.SNX.onUserLeaveHint();
      AppMethodBeat.o(206382);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(206382);
  }
  
  public static abstract interface a
    extends e, io.flutter.embedding.android.f, k
  {
    public abstract j KF();
    
    public abstract com.tencent.wxa.b.b KI();
    
    public abstract String KJ();
    
    public abstract String KK();
    
    public abstract String KL();
    
    public abstract String KM();
    
    public abstract FlutterView.b KN();
    
    public abstract FlutterView.c KO();
    
    public abstract io.flutter.embedding.engine.a KP();
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.ui.a
 * JD-Core Version:    0.7.0.1
 */