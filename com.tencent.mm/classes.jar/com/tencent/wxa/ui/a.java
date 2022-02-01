package com.tencent.wxa.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.b.b;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.embedding.android.FlutterView.TransparencyMode;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.android.SplashScreenProvider;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.Arrays;

public final class a
{
  a aidU;
  private WxaFlutterSplashView aidV;
  public com.tencent.wxa.b.c aidW;
  private final FlutterUiDisplayListener aidX;
  public FlutterEngine flutterEngine;
  public FlutterView flutterView;
  private boolean hJi;
  private boolean isFlutterEngineFromHost;
  private PlatformPlugin platformPlugin;
  
  public a(a parama)
  {
    AppMethodBeat.i(210518);
    this.hJi = true;
    this.aidX = new FlutterUiDisplayListener()
    {
      public final void onFlutterUiDisplayed() {}
      
      public final void onFlutterUiNoLongerDisplayed() {}
    };
    this.aidU = parama;
    if (this.flutterEngine == null)
    {
      com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.", new Object[0]);
      ensureAlive();
      this.flutterEngine = this.aidU.provideFlutterEngine(this.aidU.getContext());
      if (this.flutterEngine == null) {
        break label117;
      }
    }
    for (this.isFlutterEngineFromHost = true;; this.isFlutterEngineFromHost = false)
    {
      this.aidW = new com.tencent.wxa.b.a(this.aidU.anM(), this.flutterEngine);
      AppMethodBeat.o(210518);
      return;
      label117:
      com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "flutter engine is null.", new Object[0]);
    }
  }
  
  private void doInitialFlutterViewRun()
  {
    AppMethodBeat.i(210527);
    if ((this.aidU.getCachedEngineId() == null) && (!this.flutterEngine.getDartExecutor().isExecutingDart()))
    {
      com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.aidU.getDartEntrypointFunctionName() + ", and sending initial route: " + this.aidU.getInitialRoute(), new Object[0]);
      if (this.aidU.getInitialRoute() != null) {
        this.flutterEngine.getNavigationChannel().setInitialRoute(this.aidU.getInitialRoute());
      }
      DartExecutor.DartEntrypoint localDartEntrypoint = new DartExecutor.DartEntrypoint(this.aidU.getAppBundlePath(), this.aidU.getDartEntrypointFunctionName());
      this.flutterEngine.getDartExecutor().executeDartEntrypoint(localDartEntrypoint);
    }
    AppMethodBeat.o(210527);
  }
  
  private void ensureAlive()
  {
    AppMethodBeat.i(210532);
    if (this.aidU == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(210532);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(210532);
  }
  
  public final void keU()
  {
    AppMethodBeat.i(210539);
    ensureAlive();
    com.tencent.wxa.c.keQ().a(this.aidU.anM(), this.flutterEngine);
    this.platformPlugin = this.aidU.providePlatformPlugin(this.aidU.getActivity(), this.flutterEngine);
    this.aidU.configureFlutterEngine(this.flutterEngine);
    AppMethodBeat.o(210539);
  }
  
  public final View keV()
  {
    AppMethodBeat.i(210545);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Creating FlutterView.", new Object[0]);
    ensureAlive();
    this.flutterEngine.getActivityControlSurface().attachToActivity(this.aidU.getActivity(), this.aidU.getLifecycle());
    this.aidW.onCreateView();
    this.flutterView = new FlutterView(this.aidU.getActivity(), this.aidU.anN(), this.aidU.anO());
    this.flutterView.addOnFirstFrameRenderedListener(this.aidX);
    this.aidV = new WxaFlutterSplashView(this.aidU.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.aidV.setId(View.generateViewId());
    }
    for (;;)
    {
      this.aidV.displayFlutterViewWithSplash(this.flutterView, this.aidU.provideSplashScreen());
      WxaFlutterSplashView localWxaFlutterSplashView = this.aidV;
      AppMethodBeat.o(210545);
      return localWxaFlutterSplashView;
      this.aidV.setId(0);
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(210612);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + paramInt1 + "\nresultCode: " + paramInt2 + "\ndata: " + paramIntent, new Object[0]);
      this.flutterEngine.getActivityControlSurface().onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(210612);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(210612);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(210583);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDestroyView()", new Object[0]);
    this.aidW.onDestroyView();
    ensureAlive();
    AppMethodBeat.o(210583);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(210589);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onDetach()", new Object[0]);
    ensureAlive();
    if (this.platformPlugin != null)
    {
      this.platformPlugin.destroy();
      this.platformPlugin = null;
    }
    com.tencent.wxa.c.keQ().b(this.aidU.anM(), this.flutterEngine);
    AppMethodBeat.o(210589);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(210606);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine.", new Object[0]);
      this.flutterEngine.getActivityControlSurface().onNewIntent(paramIntent);
      AppMethodBeat.o(210606);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(210606);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(210568);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPause()", new Object[0]);
    this.hJi = true;
    this.aidW.onPause();
    com.tencent.wxa.c.keQ().c(this.flutterView, this.flutterEngine);
    ensureAlive();
    AppMethodBeat.o(210568);
  }
  
  public final void onPostResume()
  {
    AppMethodBeat.i(210562);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume()", new Object[0]);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      if (this.platformPlugin != null)
      {
        this.platformPlugin.updateSystemUiOverlays();
        AppMethodBeat.o(210562);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(210562);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(210602);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + paramInt + "\npermissions: " + Arrays.toString(paramArrayOfString) + "\ngrantResults: " + Arrays.toString(paramArrayOfInt), new Object[0]);
      this.flutterEngine.getActivityControlSurface().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(210602);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(210602);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(210555);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onResume()", new Object[0]);
    if (this.hJi)
    {
      com.tencent.wxa.c.keQ().a(this.aidU.anM(), this.flutterEngine);
      com.tencent.wxa.c.keQ().a(this.flutterView, this.flutterEngine);
      com.tencent.wxa.c.keQ().d(this.flutterView, this.flutterEngine);
      com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "attachViewToFlutterEngine", new Object[0]);
      this.hJi = false;
    }
    this.aidW.onResume();
    ensureAlive();
    AppMethodBeat.o(210555);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(210551);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStart()", new Object[0]);
    ensureAlive();
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.", new Object[0]);
    com.tencent.wxa.c.keQ().a(this.aidU.anM(), this.flutterEngine);
    com.tencent.wxa.c.keQ().a(this.flutterView, this.flutterEngine);
    doInitialFlutterViewRun();
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "attachViewToFlutterEngine", new Object[0]);
    this.hJi = false;
    com.tencent.wxa.c.keQ().d(this.flutterView, this.flutterEngine);
    AppMethodBeat.o(210551);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(210575);
    com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onStop()", new Object[0]);
    ensureAlive();
    com.tencent.wxa.c.keQ().e(this.flutterView, this.flutterEngine);
    com.tencent.wxa.c.keQ().b(this.flutterView, this.flutterEngine);
    com.tencent.wxa.c.a.i("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "detachViewFromFlutterEngine", new Object[0]);
    AppMethodBeat.o(210575);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(210622);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      if (paramInt == 10)
      {
        com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: ".concat(String.valueOf(paramInt)), new Object[0]);
        this.flutterEngine.getSystemChannel().sendMemoryPressureWarning();
        AppMethodBeat.o(210622);
      }
    }
    else {
      com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    }
    AppMethodBeat.o(210622);
  }
  
  public final void onUserLeaveHint()
  {
    AppMethodBeat.i(210617);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.", new Object[0]);
      this.flutterEngine.getActivityControlSurface().onUserLeaveHint();
      AppMethodBeat.o(210617);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.", new Object[0]);
    AppMethodBeat.o(210617);
  }
  
  public final void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(210595);
    com.tencent.wxa.c.a.d("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "onBackPressed", new Object[0]);
    ensureAlive();
    if (this.flutterEngine != null)
    {
      com.tencent.wxa.c.a.v("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.", new Object[0]);
      this.aidW.a(paramBoolean, new MethodChannel.Result()
      {
        public final void error(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(210515);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() error. s:%s s1:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (a.this.aidU.getActivity() != null) {
            a.this.aidU.getActivity().finish();
          }
          AppMethodBeat.o(210515);
        }
        
        public final void notImplemented()
        {
          AppMethodBeat.i(210524);
          com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() notImplemented.", new Object[0]);
          if (a.this.aidU.getActivity() != null) {
            a.this.aidU.getActivity().finish();
          }
          AppMethodBeat.o(210524);
        }
        
        public final void success(Object paramAnonymousObject)
        {
          AppMethodBeat.i(210511);
          if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof Boolean)) && (((Boolean)paramAnonymousObject).booleanValue()))
          {
            com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() back press comsumed .", new Object[0]);
            AppMethodBeat.o(210511);
            return;
          }
          if (a.this.aidU.getActivity() != null) {
            a.this.aidU.getActivity().finish();
          }
          AppMethodBeat.o(210511);
        }
      });
      AppMethodBeat.o(210595);
      return;
    }
    com.tencent.wxa.c.a.w("WxaRouter.WxaFlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.", new Object[0]);
    if (this.aidU.getActivity() != null) {
      this.aidU.getActivity().finish();
    }
    AppMethodBeat.o(210595);
  }
  
  public static abstract interface a
    extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider
  {
    public abstract b anM();
    
    public abstract FlutterView.RenderMode anN();
    
    public abstract FlutterView.TransparencyMode anO();
    
    public abstract void configureFlutterEngine(FlutterEngine paramFlutterEngine);
    
    public abstract Activity getActivity();
    
    public abstract String getAppBundlePath();
    
    public abstract String getCachedEngineId();
    
    public abstract Context getContext();
    
    public abstract String getDartEntrypointFunctionName();
    
    public abstract String getInitialRoute();
    
    public abstract j getLifecycle();
    
    public abstract FlutterEngine provideFlutterEngine(Context paramContext);
    
    public abstract PlatformPlugin providePlatformPlugin(Activity paramActivity, FlutterEngine paramFlutterEngine);
    
    public abstract SplashScreen provideSplashScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.ui.a
 * JD-Core Version:    0.7.0.1
 */