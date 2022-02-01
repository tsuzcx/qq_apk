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
  a MBj;
  private FlutterSplashView MBk;
  private final io.flutter.embedding.engine.b.b MBl;
  io.flutter.plugin.platform.b Mlc;
  boolean Mld;
  FlutterView tiF;
  io.flutter.embedding.engine.a tiq;
  
  c(a parama)
  {
    AppMethodBeat.i(10071);
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213318);
        c.this.MBj.cQm();
        AppMethodBeat.o(213318);
      }
      
      public final void cQn()
      {
        AppMethodBeat.i(213319);
        c.this.MBj.cQn();
        AppMethodBeat.o(213319);
      }
    };
    this.MBj = parama;
    AppMethodBeat.o(10071);
  }
  
  private void fYX()
  {
    AppMethodBeat.i(10074);
    io.flutter.a.gea();
    Object localObject = this.MBj.dfO();
    if (localObject != null)
    {
      this.tiq = io.flutter.embedding.engine.b.geD().bbK((String)localObject);
      this.Mld = true;
      if (this.tiq == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.MBj;
    this.MBj.getContext();
    this.tiq = ((a)localObject).dfU();
    if (this.tiq != null)
    {
      this.Mld = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.a.gea();
    this.tiq = new io.flutter.embedding.engine.a(this.MBj.getContext(), this.MBj.gej().toArray());
    this.Mld = false;
    AppMethodBeat.o(10074);
  }
  
  private void fYZ()
  {
    AppMethodBeat.i(213340);
    if (this.MBj.dfO() != null)
    {
      AppMethodBeat.o(213340);
      return;
    }
    if (this.tiq.MCh.MCS)
    {
      AppMethodBeat.o(213340);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(this.MBj.dfP()).append(", and sending initial route: ").append(this.MBj.dfR());
    io.flutter.a.gea();
    if (this.MBj.dfR() != null) {
      this.tiq.MCm.setInitialRoute(this.MBj.dfR());
    }
    DartExecutor.a locala = new DartExecutor.a(this.MBj.dfQ(), this.MBj.dfP());
    this.tiq.MCh.a(locala);
    AppMethodBeat.o(213340);
  }
  
  final void fYW()
  {
    AppMethodBeat.i(213338);
    fZa();
    if (this.tiq == null) {
      fYX();
    }
    this.Mlc = this.MBj.a(this.MBj.getActivity(), this.tiq);
    if (this.MBj.gen())
    {
      io.flutter.a.gea();
      this.tiq.MCi.a(this.MBj.getActivity(), this.MBj.getLifecycle());
    }
    this.MBj.a(this.tiq);
    AppMethodBeat.o(213338);
  }
  
  final View fYY()
  {
    AppMethodBeat.i(10075);
    io.flutter.a.gea();
    fZa();
    Object localObject;
    boolean bool;
    if (this.MBj.gel() == g.MCa)
    {
      localObject = this.MBj.getActivity();
      if (this.MBj.gem() == j.MCe)
      {
        bool = true;
        localObject = new FlutterSurfaceView((Context)localObject, bool);
        this.tiF = new FlutterView(this.MBj.getActivity(), (FlutterSurfaceView)localObject);
        label86:
        this.tiF.a(this.MBl);
        this.MBk = new FlutterSplashView(this.MBj.getContext());
        if (Build.VERSION.SDK_INT < 17) {
          break label228;
        }
        this.MBk.setId(View.generateViewId());
      }
    }
    for (;;)
    {
      this.MBk.a(this.tiF, this.MBj.dfL());
      io.flutter.a.gea();
      this.tiF.c(this.tiq);
      localObject = this.MBk;
      AppMethodBeat.o(10075);
      return localObject;
      bool = false;
      break;
      localObject = new FlutterTextureView(this.MBj.getActivity());
      this.tiF = new FlutterView(this.MBj.getActivity(), (FlutterTextureView)localObject);
      break label86;
      label228:
      this.MBk.setId(486947586);
    }
  }
  
  final void fZa()
  {
    AppMethodBeat.i(10084);
    if (this.MBj == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  final void geo()
  {
    AppMethodBeat.i(213339);
    io.flutter.a.gea();
    fZa();
    if (this.MBj.gen()) {
      this.tiq.MCi.geI();
    }
    AppMethodBeat.o(213339);
  }
  
  final void gep()
  {
    AppMethodBeat.i(213342);
    io.flutter.a.gea();
    fZa();
    if (this.MBj.gen()) {
      this.tiq.MCi.gep();
    }
    AppMethodBeat.o(213342);
  }
  
  final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    fZa();
    if (this.tiq != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.a.gea();
      this.tiq.MCi.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(10083);
  }
  
  final void onBackPressed()
  {
    AppMethodBeat.i(213343);
    fZa();
    if (this.tiq != null)
    {
      io.flutter.a.gea();
      this.tiq.MCm.cQl();
      AppMethodBeat.o(213343);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(213343);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.a.gea();
    fZa();
    this.tiF.gex();
    this.tiF.b(this.MBl);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.a.gea();
    fZa();
    this.MBj.b(this.tiq);
    if (this.MBj.gen())
    {
      io.flutter.a.gea();
      if (!this.MBj.getActivity().isChangingConfigurations()) {
        break label155;
      }
      this.tiq.MCi.geG();
    }
    for (;;)
    {
      if (this.Mlc != null)
      {
        this.Mlc.destroy();
        this.Mlc = null;
      }
      this.tiq.MCk.gfb();
      if (this.MBj.gek())
      {
        this.tiq.destroy();
        if (this.MBj.dfO() != null) {
          io.flutter.embedding.engine.b.geD().bbL(this.MBj.dfO());
        }
        this.tiq = null;
      }
      AppMethodBeat.o(10081);
      return;
      label155:
      this.tiq.MCi.geH();
    }
  }
  
  final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(213344);
    fZa();
    if (this.tiq != null)
    {
      io.flutter.a.gea();
      this.tiq.MCi.onNewIntent(paramIntent);
      AppMethodBeat.o(213344);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(213344);
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.a.gea();
    fZa();
    this.tiq.MCk.geY();
    AppMethodBeat.o(10078);
  }
  
  final void onPostResume()
  {
    AppMethodBeat.i(213341);
    io.flutter.a.gea();
    fZa();
    if (this.tiq != null)
    {
      if (this.Mlc != null)
      {
        this.Mlc.gfj();
        AppMethodBeat.o(213341);
      }
    }
    else {
      io.flutter.a.ged();
    }
    AppMethodBeat.o(213341);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    fZa();
    if (this.tiq != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.a.gea();
      this.tiq.MCi.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(10082);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.a.gea();
    fZa();
    this.tiq.MCk.geZ();
    AppMethodBeat.o(10077);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.a.gea();
    fZa();
    fYZ();
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.a.gea();
    fZa();
    this.tiq.MCk.gfa();
    AppMethodBeat.o(10079);
  }
  
  final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(213346);
    fZa();
    if (this.tiq != null)
    {
      if (paramInt == 10)
      {
        io.flutter.a.gea();
        this.tiq.MCq.gfg();
        AppMethodBeat.o(213346);
      }
    }
    else {
      io.flutter.a.ged();
    }
    AppMethodBeat.o(213346);
  }
  
  final void onUserLeaveHint()
  {
    AppMethodBeat.i(213345);
    fZa();
    if (this.tiq != null)
    {
      io.flutter.a.gea();
      this.tiq.MCi.onUserLeaveHint();
      AppMethodBeat.o(213345);
      return;
    }
    io.flutter.a.ged();
    AppMethodBeat.o(213345);
  }
  
  static abstract interface a
    extends e, f, i
  {
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract void cQm();
    
    public abstract void cQn();
    
    public abstract h dfL();
    
    public abstract String dfO();
    
    public abstract String dfP();
    
    public abstract String dfQ();
    
    public abstract String dfR();
    
    public abstract io.flutter.embedding.engine.a dfU();
    
    public abstract d gej();
    
    public abstract boolean gek();
    
    public abstract g gel();
    
    public abstract j gem();
    
    public abstract boolean gen();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.c
 * JD-Core Version:    0.7.0.1
 */