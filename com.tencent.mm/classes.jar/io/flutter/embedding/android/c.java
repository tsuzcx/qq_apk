package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import java.util.Arrays;

final class c
{
  a KKv;
  private FlutterSplashView KKw;
  private final io.flutter.embedding.engine.b.b KKx;
  io.flutter.plugin.platform.b Kvb;
  boolean Kvc;
  io.flutter.embedding.engine.a slN;
  FlutterView smb;
  
  c(a parama)
  {
    AppMethodBeat.i(10071);
    this.KKx = new io.flutter.embedding.engine.b.b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(192861);
        c.this.KKv.cHX();
        AppMethodBeat.o(192861);
      }
      
      public final void cHY()
      {
        AppMethodBeat.i(192862);
        c.this.KKv.cHY();
        AppMethodBeat.o(192862);
      }
    };
    this.KKv = parama;
    AppMethodBeat.o(10071);
  }
  
  private void fHG()
  {
    AppMethodBeat.i(10074);
    io.flutter.a.fMF();
    Object localObject = this.KKv.cWC();
    if (localObject != null)
    {
      this.slN = io.flutter.embedding.engine.b.fNd().aVH((String)localObject);
      this.Kvc = true;
      if (this.slN == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.KKv;
    this.KKv.getContext();
    this.slN = ((a)localObject).cWI();
    if (this.slN != null)
    {
      this.Kvc = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.a.fMF();
    this.slN = new io.flutter.embedding.engine.a(this.KKv.getContext(), this.KKv.fMM().fNp());
    this.Kvc = false;
    AppMethodBeat.o(10074);
  }
  
  final void fHF()
  {
    AppMethodBeat.i(192881);
    fHJ();
    if (this.slN == null) {
      fHG();
    }
    this.Kvb = this.KKv.a(this.KKv.getActivity(), this.slN);
    if (this.KKv.fMO())
    {
      io.flutter.a.fMF();
      this.slN.KLl.a(this.KKv.getActivity(), this.KKv.getLifecycle());
    }
    this.KKv.a(this.slN);
    AppMethodBeat.o(192881);
  }
  
  final View fHH()
  {
    AppMethodBeat.i(10075);
    io.flutter.a.fMD();
    fHJ();
    this.smb = new FlutterView(this.KKv.getActivity(), this.KKv.cWG(), this.KKv.cWH());
    this.smb.a(this.KKx);
    this.KKw = new FlutterSplashView(this.KKv.getContext());
    if (Build.VERSION.SDK_INT >= 17) {
      this.KKw.setId(View.generateViewId());
    }
    for (;;)
    {
      this.KKw.a(this.smb, this.KKv.cWz());
      FlutterSplashView localFlutterSplashView = this.KKw;
      AppMethodBeat.o(10075);
      return localFlutterSplashView;
      this.KKw.setId(486947586);
    }
  }
  
  final void fHJ()
  {
    AppMethodBeat.i(10084);
    if (this.KKv == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  final void fMP()
  {
    AppMethodBeat.i(192882);
    io.flutter.a.fMD();
    fHJ();
    if (this.KKv.fMO()) {
      this.slN.KLl.fNi();
    }
    AppMethodBeat.o(192882);
  }
  
  final void fMQ()
  {
    AppMethodBeat.i(192884);
    io.flutter.a.fMD();
    fHJ();
    if (this.KKv.fMO()) {
      this.slN.KLl.fMQ();
    }
    AppMethodBeat.o(192884);
  }
  
  final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    fHJ();
    if (this.slN != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.a.fMD();
      this.slN.KLl.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(10083);
  }
  
  final void onBackPressed()
  {
    AppMethodBeat.i(192885);
    fHJ();
    if (this.slN != null)
    {
      io.flutter.a.fMD();
      this.slN.KLp.cHW();
      AppMethodBeat.o(192885);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(192885);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.a.fMD();
    fHJ();
    this.smb.b(this.KKx);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.a.fMD();
    fHJ();
    this.KKv.b(this.slN);
    if (this.KKv.fMO())
    {
      io.flutter.a.fMF();
      if (!this.KKv.getActivity().isChangingConfigurations()) {
        break label155;
      }
      this.slN.KLl.fNg();
    }
    for (;;)
    {
      if (this.Kvb != null)
      {
        this.Kvb.destroy();
        this.Kvb = null;
      }
      this.slN.KLn.fNC();
      if (this.KKv.fMN())
      {
        this.slN.destroy();
        if (this.KKv.cWC() != null) {
          io.flutter.embedding.engine.b.fNd().aVI(this.KKv.cWC());
        }
        this.slN = null;
      }
      AppMethodBeat.o(10081);
      return;
      label155:
      this.slN.KLl.fNh();
    }
  }
  
  final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(192886);
    fHJ();
    if (this.slN != null)
    {
      io.flutter.a.fMD();
      this.slN.KLl.onNewIntent(paramIntent);
      AppMethodBeat.o(192886);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(192886);
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.a.fMD();
    fHJ();
    this.slN.KLn.fNz();
    AppMethodBeat.o(10078);
  }
  
  final void onPostResume()
  {
    AppMethodBeat.i(192883);
    io.flutter.a.fMD();
    fHJ();
    if (this.slN != null)
    {
      if (this.Kvb != null)
      {
        this.Kvb.fNK();
        AppMethodBeat.o(192883);
      }
    }
    else {
      io.flutter.a.fMG();
    }
    AppMethodBeat.o(192883);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    fHJ();
    if (this.slN != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.a.fMD();
      this.slN.KLl.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(10082);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.a.fMD();
    fHJ();
    this.slN.KLn.fNA();
    AppMethodBeat.o(10077);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.a.fMD();
    fHJ();
    new Handler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9982);
        io.flutter.a.fMD();
        c.this.smb.c(c.this.slN);
        c localc = c.this;
        if ((localc.KKv.cWC() == null) && (!localc.slN.KLk.KLV))
        {
          new StringBuilder("Executing Dart entrypoint: ").append(localc.KKv.cWD()).append(", and sending initial route: ").append(localc.KKv.cWF());
          io.flutter.a.fMF();
          if (localc.KKv.cWF() != null) {
            localc.slN.KLp.setInitialRoute(localc.KKv.cWF());
          }
          DartExecutor.a locala = new DartExecutor.a(localc.KKv.cWE(), localc.KKv.cWD());
          localc.slN.KLk.a(locala);
        }
        AppMethodBeat.o(9982);
      }
    });
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.a.fMD();
    fHJ();
    this.slN.KLn.fNB();
    this.smb.fMX();
    AppMethodBeat.o(10079);
  }
  
  final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(192888);
    fHJ();
    if (this.slN != null)
    {
      if (paramInt == 10)
      {
        io.flutter.a.fMD();
        this.slN.KLt.fNH();
        AppMethodBeat.o(192888);
      }
    }
    else {
      io.flutter.a.fMG();
    }
    AppMethodBeat.o(192888);
  }
  
  final void onUserLeaveHint()
  {
    AppMethodBeat.i(192887);
    fHJ();
    if (this.slN != null)
    {
      io.flutter.a.fMD();
      this.slN.KLl.onUserLeaveHint();
      AppMethodBeat.o(192887);
      return;
    }
    io.flutter.a.fMG();
    AppMethodBeat.o(192887);
  }
  
  static abstract interface a
    extends e, f, h
  {
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract void cHX();
    
    public abstract void cHY();
    
    public abstract String cWC();
    
    public abstract String cWD();
    
    public abstract String cWE();
    
    public abstract String cWF();
    
    public abstract FlutterView.b cWG();
    
    public abstract FlutterView.c cWH();
    
    public abstract io.flutter.embedding.engine.a cWI();
    
    public abstract g cWz();
    
    public abstract d fMM();
    
    public abstract boolean fMN();
    
    public abstract boolean fMO();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.c
 * JD-Core Version:    0.7.0.1
 */