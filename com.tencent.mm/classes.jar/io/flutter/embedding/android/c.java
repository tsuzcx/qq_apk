package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import java.util.Arrays;

final class c
{
  io.flutter.plugin.platform.b MHZ;
  boolean MIa;
  a MYo;
  private FlutterSplashView MYp;
  private final io.flutter.embedding.engine.b.b MYq;
  io.flutter.embedding.engine.a tti;
  FlutterView ttx;
  
  c(a parama)
  {
    AppMethodBeat.i(10071);
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197900);
        c.this.MYo.cSR();
        AppMethodBeat.o(197900);
      }
      
      public final void cSS()
      {
        AppMethodBeat.i(197901);
        c.this.MYo.cSS();
        AppMethodBeat.o(197901);
      }
    };
    this.MYo = parama;
    AppMethodBeat.o(10071);
  }
  
  private void gdA()
  {
    AppMethodBeat.i(197922);
    if (this.MYo.diI() != null)
    {
      AppMethodBeat.o(197922);
      return;
    }
    if (this.tti.MZm.MZX)
    {
      AppMethodBeat.o(197922);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(this.MYo.diJ()).append(", and sending initial route: ").append(this.MYo.diL());
    io.flutter.a.giD();
    if (this.MYo.diL() != null) {
      this.tti.MZr.setInitialRoute(this.MYo.diL());
    }
    DartExecutor.a locala = new DartExecutor.a(this.MYo.diK(), this.MYo.diJ());
    this.tti.MZm.a(locala);
    AppMethodBeat.o(197922);
  }
  
  private void gdy()
  {
    AppMethodBeat.i(10074);
    io.flutter.a.giD();
    Object localObject = this.MYo.diI();
    if (localObject != null)
    {
      this.tti = io.flutter.embedding.engine.b.gjf().bdo((String)localObject);
      this.MIa = true;
      if (this.tti == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.MYo;
    this.MYo.getContext();
    this.tti = ((a)localObject).diO();
    if (this.tti != null)
    {
      this.MIa = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.a.giD();
    this.tti = new io.flutter.embedding.engine.a(this.MYo.getContext(), this.MYo.giM().toArray());
    this.MIa = false;
    AppMethodBeat.o(10074);
  }
  
  final void gdB()
  {
    AppMethodBeat.i(10084);
    if (this.MYo == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  final void gdx()
  {
    AppMethodBeat.i(197920);
    gdB();
    if (this.tti == null) {
      gdy();
    }
    this.MHZ = this.MYo.a(this.MYo.getActivity(), this.tti);
    if (this.MYo.giQ())
    {
      io.flutter.a.giD();
      this.tti.MZn.a(this.MYo.getActivity(), this.MYo.getLifecycle());
    }
    this.MYo.a(this.tti);
    AppMethodBeat.o(197920);
  }
  
  final View gdz()
  {
    AppMethodBeat.i(10075);
    io.flutter.a.giD();
    gdB();
    Object localObject;
    boolean bool;
    if (this.MYo.giO() == g.MZf)
    {
      localObject = this.MYo.getActivity();
      if (this.MYo.giP() == j.MZj)
      {
        bool = true;
        localObject = new FlutterSurfaceView((Context)localObject, bool);
        this.ttx = new FlutterView(this.MYo.getActivity(), (FlutterSurfaceView)localObject);
        label86:
        this.ttx.a(this.MYq);
        this.MYp = new FlutterSplashView(this.MYo.getContext());
        if (Build.VERSION.SDK_INT < 17) {
          break label228;
        }
        this.MYp.setId(View.generateViewId());
      }
    }
    for (;;)
    {
      this.MYp.a(this.ttx, this.MYo.diP());
      io.flutter.a.giD();
      this.ttx.c(this.tti);
      localObject = this.MYp;
      AppMethodBeat.o(10075);
      return localObject;
      bool = false;
      break;
      localObject = new FlutterTextureView(this.MYo.getActivity());
      this.ttx = new FlutterView(this.MYo.getActivity(), (FlutterTextureView)localObject);
      break label86;
      label228:
      this.MYp.setId(486947586);
    }
  }
  
  final void giR()
  {
    AppMethodBeat.i(197921);
    io.flutter.a.giD();
    gdB();
    if (this.MYo.giQ()) {
      this.tti.MZn.gjk();
    }
    AppMethodBeat.o(197921);
  }
  
  final void giS()
  {
    AppMethodBeat.i(197924);
    io.flutter.a.giD();
    gdB();
    if (this.MYo.giQ()) {
      this.tti.MZn.giS();
    }
    AppMethodBeat.o(197924);
  }
  
  final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    gdB();
    if (this.tti != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.a.giD();
      this.tti.MZn.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(10083);
  }
  
  final void onBackPressed()
  {
    AppMethodBeat.i(197925);
    gdB();
    if (this.tti != null)
    {
      io.flutter.a.giD();
      this.tti.MZr.cSQ();
      AppMethodBeat.o(197925);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(197925);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.a.giD();
    gdB();
    this.ttx.giZ();
    this.ttx.b(this.MYq);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.a.giD();
    gdB();
    this.MYo.b(this.tti);
    if (this.MYo.giQ())
    {
      io.flutter.a.giD();
      if (!this.MYo.getActivity().isChangingConfigurations()) {
        break label155;
      }
      this.tti.MZn.gji();
    }
    for (;;)
    {
      if (this.MHZ != null)
      {
        this.MHZ.destroy();
        this.MHZ = null;
      }
      this.tti.MZp.gjD();
      if (this.MYo.giN())
      {
        this.tti.destroy();
        if (this.MYo.diI() != null) {
          io.flutter.embedding.engine.b.gjf().bdp(this.MYo.diI());
        }
        this.tti = null;
      }
      AppMethodBeat.o(10081);
      return;
      label155:
      this.tti.MZn.gjj();
    }
  }
  
  final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(197926);
    gdB();
    if (this.tti != null)
    {
      io.flutter.a.giD();
      this.tti.MZn.onNewIntent(paramIntent);
      AppMethodBeat.o(197926);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(197926);
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.a.giD();
    gdB();
    this.tti.MZp.gjA();
    AppMethodBeat.o(10078);
  }
  
  final void onPostResume()
  {
    AppMethodBeat.i(197923);
    io.flutter.a.giD();
    gdB();
    if (this.tti != null)
    {
      if (this.MHZ != null)
      {
        this.MHZ.gjL();
        AppMethodBeat.o(197923);
      }
    }
    else {
      io.flutter.a.giG();
    }
    AppMethodBeat.o(197923);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    gdB();
    if (this.tti != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.a.giD();
      this.tti.MZn.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(10082);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.a.giD();
    gdB();
    this.tti.MZp.gjB();
    AppMethodBeat.o(10077);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.a.giD();
    gdB();
    gdA();
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.a.giD();
    gdB();
    this.tti.MZp.gjC();
    AppMethodBeat.o(10079);
  }
  
  final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(197928);
    gdB();
    if (this.tti != null)
    {
      if (paramInt == 10)
      {
        io.flutter.a.giD();
        this.tti.MZv.gjI();
        AppMethodBeat.o(197928);
      }
    }
    else {
      io.flutter.a.giG();
    }
    AppMethodBeat.o(197928);
  }
  
  final void onUserLeaveHint()
  {
    AppMethodBeat.i(197927);
    gdB();
    if (this.tti != null)
    {
      io.flutter.a.giD();
      this.tti.MZn.onUserLeaveHint();
      AppMethodBeat.o(197927);
      return;
    }
    io.flutter.a.giG();
    AppMethodBeat.o(197927);
  }
  
  static abstract interface a
    extends e, f, i
  {
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract void cSR();
    
    public abstract void cSS();
    
    public abstract String diI();
    
    public abstract String diJ();
    
    public abstract String diK();
    
    public abstract String diL();
    
    public abstract io.flutter.embedding.engine.a diO();
    
    public abstract h diP();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
    
    public abstract d giM();
    
    public abstract boolean giN();
    
    public abstract g giO();
    
    public abstract j giP();
    
    public abstract boolean giQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.c
 * JD-Core Version:    0.7.0.1
 */