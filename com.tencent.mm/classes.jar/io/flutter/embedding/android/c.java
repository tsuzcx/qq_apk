package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.util.Arrays;

final class c
{
  a IXp;
  private FlutterSplashView IXq;
  io.flutter.a.c.b IXr;
  private boolean IXs;
  private final io.flutter.embedding.engine.b.b rdC;
  FlutterView rdJ;
  io.flutter.embedding.engine.a rdu;
  
  c(a parama)
  {
    AppMethodBeat.i(10071);
    this.rdC = new io.flutter.embedding.engine.b.b()
    {
      public final void onFirstFrameRendered()
      {
        AppMethodBeat.i(10112);
        c.this.IXp.onFirstFrameRendered();
        AppMethodBeat.o(10112);
      }
    };
    this.IXp = parama;
    AppMethodBeat.o(10071);
  }
  
  private void fun()
  {
    AppMethodBeat.i(10074);
    io.flutter.a.ftT();
    Object localObject = this.IXp.fud();
    if (localObject != null)
    {
      this.rdu = io.flutter.embedding.engine.c.fuE().aPJ((String)localObject);
      this.IXs = true;
      if (this.rdu == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.IXp;
    this.IXp.getContext();
    this.rdu = ((a)localObject).ful();
    if (this.rdu != null)
    {
      this.IXs = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.a.ftT();
    this.rdu = new io.flutter.embedding.engine.a(this.IXp.getContext());
    this.IXs = false;
    AppMethodBeat.o(10074);
  }
  
  private void li(Context paramContext)
  {
    AppMethodBeat.i(10073);
    FlutterMain.ensureInitializationComplete(paramContext.getApplicationContext(), this.IXp.fuc().fuP());
    AppMethodBeat.o(10073);
  }
  
  final View fuo()
  {
    AppMethodBeat.i(10075);
    io.flutter.a.ftS();
    fup();
    this.rdJ = new FlutterView(this.IXp.getActivity(), this.IXp.fui(), this.IXp.fuj());
    this.rdJ.addOnFirstFrameRenderedListener(this.rdC);
    this.IXq = new FlutterSplashView(this.IXp.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.IXq.setId(View.generateViewId());
    }
    for (;;)
    {
      this.IXq.a(this.rdJ, this.IXp.fua());
      FlutterSplashView localFlutterSplashView = this.IXq;
      AppMethodBeat.o(10075);
      return localFlutterSplashView;
      this.IXq.setId(486947586);
    }
  }
  
  final void fup()
  {
    AppMethodBeat.i(10084);
    if (this.IXp == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    fup();
    if (this.rdu != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.a.ftS();
      this.rdu.IYf.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10083);
  }
  
  final void onAttach(Context paramContext)
  {
    AppMethodBeat.i(10072);
    fup();
    li(paramContext);
    if (this.rdu == null) {
      fun();
    }
    this.IXr = this.IXp.a(this.IXp.getActivity(), this.rdu);
    if (this.IXp.fum())
    {
      io.flutter.a.ftT();
      this.rdu.IYf.a(this.IXp.getActivity(), this.IXp.getLifecycle());
    }
    this.IXp.a(this.rdu);
    AppMethodBeat.o(10072);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.a.ftS();
    fup();
    this.rdJ.removeOnFirstFrameRenderedListener(this.rdC);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.a.ftS();
    fup();
    if (this.IXp.fum())
    {
      io.flutter.a.ftT();
      if (!this.IXp.getActivity().isChangingConfigurations()) {
        break label132;
      }
      this.rdu.IYf.fuH();
    }
    for (;;)
    {
      if (this.IXr != null)
      {
        this.IXr.destroy();
        this.IXr = null;
      }
      if (this.IXp.fue())
      {
        this.rdu.destroy();
        if (this.IXp.fud() != null) {
          io.flutter.embedding.engine.c.fuE().aPK(this.IXp.fud());
        }
        this.rdu = null;
      }
      AppMethodBeat.o(10081);
      return;
      label132:
      this.rdu.IYf.fuI();
    }
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.a.ftS();
    fup();
    this.rdu.IYi.fuV();
    AppMethodBeat.o(10078);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    fup();
    if (this.rdu != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.a.ftS();
      this.rdu.IYf.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.a.ftU();
    AppMethodBeat.o(10082);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.a.ftS();
    fup();
    this.rdu.IYi.fuW();
    AppMethodBeat.o(10077);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.a.ftS();
    fup();
    new Handler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9982);
        io.flutter.a.ftS();
        c.this.rdJ.b(c.this.rdu);
        c localc = c.this;
        if ((localc.IXp.fud() == null) && (!localc.rdu.IYe.IYQ))
        {
          new StringBuilder("Executing Dart entrypoint: ").append(localc.IXp.fuf()).append(", and sending initial route: ").append(localc.IXp.fug());
          io.flutter.a.ftT();
          if (localc.IXp.fug() != null) {
            localc.rdu.IYk.setInitialRoute(localc.IXp.fug());
          }
          DartExecutor.a locala = new DartExecutor.a(localc.IXp.fuh(), localc.IXp.fuf());
          localc.rdu.IYe.a(locala);
        }
        AppMethodBeat.o(9982);
      }
    });
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.a.ftS();
    fup();
    this.rdu.IYi.fuX();
    this.rdJ.fuw();
    AppMethodBeat.o(10079);
  }
  
  static abstract interface a
    extends d, e, g
  {
    public abstract io.flutter.a.c.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract f fua();
    
    public abstract io.flutter.embedding.engine.e fuc();
    
    public abstract String fud();
    
    public abstract boolean fue();
    
    public abstract String fuf();
    
    public abstract String fug();
    
    public abstract String fuh();
    
    public abstract FlutterView.b fui();
    
    public abstract FlutterView.c fuj();
    
    public abstract io.flutter.embedding.engine.a ful();
    
    public abstract boolean fum();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
    
    public abstract void onFirstFrameRendered();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.c
 * JD-Core Version:    0.7.0.1
 */