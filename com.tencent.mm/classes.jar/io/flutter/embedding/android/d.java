package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.platform.b.a;
import java.util.Arrays;

final class d
  implements c<Activity>
{
  private FlutterView BCI;
  private io.flutter.plugin.platform.b BCJ;
  io.flutter.embedding.engine.a BCx;
  boolean ZZk;
  a aaoC;
  private FlutterSplashView aaoD;
  private final io.flutter.embedding.engine.renderer.b aaoE;
  
  d(a parama)
  {
    AppMethodBeat.i(10071);
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(254255);
        d.this.aaoC.epX();
        AppMethodBeat.o(254255);
      }
      
      public final void epY()
      {
        AppMethodBeat.i(254258);
        d.this.aaoC.epY();
        AppMethodBeat.o(254258);
      }
    };
    this.aaoC = parama;
    AppMethodBeat.o(10071);
  }
  
  private String bS(Intent paramIntent)
  {
    AppMethodBeat.i(253347);
    if (this.aaoC.iAu())
    {
      Uri localUri = paramIntent.getData();
      if ((localUri != null) && (!localUri.getPath().isEmpty()))
      {
        String str = localUri.getPath();
        paramIntent = str;
        if (!localUri.getQuery().isEmpty()) {
          paramIntent = str + "?" + localUri.getQuery();
        }
        AppMethodBeat.o(253347);
        return paramIntent;
      }
    }
    AppMethodBeat.o(253347);
    return null;
  }
  
  private void ivB()
  {
    AppMethodBeat.i(10074);
    io.flutter.b.iAd();
    Object localObject = this.aaoC.Nw();
    if (localObject != null)
    {
      this.BCx = io.flutter.embedding.engine.b.iAJ().bGc((String)localObject);
      this.ZZk = true;
      if (this.BCx == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.aaoC;
    this.aaoC.getContext();
    this.BCx = ((a)localObject).ND();
    if (this.BCx != null)
    {
      this.ZZk = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.b.iAd();
    this.BCx = new io.flutter.embedding.engine.a(this.aaoC.getContext(), this.aaoC.iAo().toArray(), this.aaoC.iAv());
    this.ZZk = false;
    AppMethodBeat.o(10074);
  }
  
  private void ivD()
  {
    AppMethodBeat.i(253344);
    if (this.aaoC.Nw() != null)
    {
      AppMethodBeat.o(253344);
      return;
    }
    if (this.BCx.aapU.aaqG)
    {
      AppMethodBeat.o(253344);
      return;
    }
    String str = this.aaoC.Nz();
    Object localObject = str;
    if (str == null)
    {
      str = bS(this.aaoC.getActivity().getIntent());
      localObject = str;
      if (str == null) {
        localObject = "/";
      }
    }
    new StringBuilder("Executing Dart entrypoint: ").append(this.aaoC.Nx()).append(", and sending initial route: ").append((String)localObject);
    io.flutter.b.iAd();
    this.BCx.aaqb.setInitialRoute((String)localObject);
    str = this.aaoC.Ny();
    if (str != null)
    {
      localObject = str;
      if (!str.isEmpty()) {}
    }
    else
    {
      localObject = io.flutter.a.iAc().aanR.aarr.aarl;
    }
    localObject = new DartExecutor.a((String)localObject, this.aaoC.Nx());
    this.BCx.aapU.a((DartExecutor.a)localObject);
    AppMethodBeat.o(253344);
  }
  
  public final void iAm()
  {
    AppMethodBeat.i(253354);
    if (this.aaoC.iAp())
    {
      AssertionError localAssertionError = new AssertionError("The internal FlutterEngine created by " + this.aaoC + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
      AppMethodBeat.o(253354);
      throw localAssertionError;
    }
    this.aaoC.iAm();
    AppMethodBeat.o(253354);
  }
  
  final void ivA()
  {
    AppMethodBeat.i(253339);
    ivE();
    if (this.BCx == null) {
      ivB();
    }
    if (this.aaoC.iAt())
    {
      io.flutter.b.iAd();
      this.BCx.aapV.a(this, this.aaoC.getLifecycle());
    }
    this.BCJ = this.aaoC.a(this.aaoC.getActivity(), this.BCx);
    this.aaoC.a(this.BCx);
    AppMethodBeat.o(253339);
  }
  
  final View ivC()
  {
    AppMethodBeat.i(10075);
    io.flutter.b.iAd();
    ivE();
    Object localObject;
    boolean bool;
    if (this.aaoC.iAq() == i.aapM)
    {
      localObject = this.aaoC.getActivity();
      if (this.aaoC.iAr() == l.aapR)
      {
        bool = true;
        localObject = new FlutterSurfaceView((Context)localObject, bool);
        this.BCI = new FlutterView(this.aaoC.getActivity(), (FlutterSurfaceView)localObject);
        label86:
        this.BCI.a(this.aaoE);
        this.aaoD = new FlutterSplashView(this.aaoC.getContext());
        if (Build.VERSION.SDK_INT < 17) {
          break label228;
        }
        this.aaoD.setId(View.generateViewId());
      }
    }
    for (;;)
    {
      this.aaoD.a(this.BCI, this.aaoC.NC());
      io.flutter.b.iAd();
      this.BCI.d(this.BCx);
      localObject = this.aaoD;
      AppMethodBeat.o(10075);
      return localObject;
      bool = false;
      break;
      localObject = new FlutterTextureView(this.aaoC.getActivity());
      this.BCI = new FlutterView(this.aaoC.getActivity(), (FlutterTextureView)localObject);
      break label86;
      label228:
      this.aaoD.setId(486947586);
    }
  }
  
  final void ivE()
  {
    AppMethodBeat.i(10084);
    if (this.aaoC == null)
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
    ivE();
    if (this.BCx != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.b.iAd();
      this.BCx.aapV.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(10083);
  }
  
  final void onBackPressed()
  {
    AppMethodBeat.i(253356);
    ivE();
    if (this.BCx != null)
    {
      io.flutter.b.iAd();
      this.BCx.aaqb.epW();
      AppMethodBeat.o(253356);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(253356);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.b.iAd();
    ivE();
    this.BCI.iAm();
    this.BCI.b(this.aaoE);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.b.iAd();
    ivE();
    this.aaoC.b(this.BCx);
    if (this.aaoC.iAt())
    {
      io.flutter.b.iAd();
      if (!this.aaoC.getActivity().isChangingConfigurations()) {
        break label155;
      }
      this.BCx.aapV.iAN();
    }
    for (;;)
    {
      if (this.BCJ != null)
      {
        this.BCJ.destroy();
        this.BCJ = null;
      }
      this.BCx.aapY.iBg();
      if (this.aaoC.iAp())
      {
        this.BCx.destroy();
        if (this.aaoC.Nw() != null) {
          io.flutter.embedding.engine.b.iAJ().bGd(this.aaoC.Nw());
        }
        this.BCx = null;
      }
      AppMethodBeat.o(10081);
      return;
      label155:
      this.BCx.aapV.iAO();
    }
  }
  
  final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(253360);
    ivE();
    if (this.BCx != null)
    {
      io.flutter.b.iAd();
      this.BCx.aapV.onNewIntent(paramIntent);
      paramIntent = bS(paramIntent);
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        this.BCx.aaqb.bGj(paramIntent);
      }
      AppMethodBeat.o(253360);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(253360);
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.b.iAd();
    ivE();
    this.BCx.aapY.iBd();
    AppMethodBeat.o(10078);
  }
  
  final void onPostResume()
  {
    AppMethodBeat.i(253350);
    io.flutter.b.iAd();
    ivE();
    if (this.BCx != null)
    {
      if (this.BCJ != null)
      {
        this.BCJ.iBs();
        AppMethodBeat.o(253350);
      }
    }
    else {
      io.flutter.b.iAf();
    }
    AppMethodBeat.o(253350);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    ivE();
    if (this.BCx != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.b.iAd();
      this.BCx.aapV.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(10082);
  }
  
  final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(253343);
    io.flutter.b.iAd();
    ivE();
    byte[] arrayOfByte = null;
    if (paramBundle != null)
    {
      paramBundle.getBundle("plugins");
      arrayOfByte = paramBundle.getByteArray("framework");
    }
    if (this.aaoC.iAv()) {
      this.BCx.aaqc.dB(arrayOfByte);
    }
    if (this.aaoC.iAt()) {
      this.BCx.aapV.iAR();
    }
    AppMethodBeat.o(253343);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.b.iAd();
    ivE();
    this.BCx.aapY.iBe();
    AppMethodBeat.o(10077);
  }
  
  final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(253353);
    io.flutter.b.iAd();
    ivE();
    if (this.aaoC.iAv()) {
      paramBundle.putByteArray("framework", this.BCx.aaqc.aatD);
    }
    if (this.aaoC.iAt())
    {
      Bundle localBundle = new Bundle();
      this.BCx.aapV.iAQ();
      paramBundle.putBundle("plugins", localBundle);
    }
    AppMethodBeat.o(253353);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.b.iAd();
    ivE();
    ivD();
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.b.iAd();
    ivE();
    this.BCx.aapY.iBf();
    AppMethodBeat.o(10079);
  }
  
  final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(253364);
    ivE();
    if (this.BCx != null)
    {
      this.BCx.aapU.notifyLowMemoryWarning();
      if (paramInt == 10)
      {
        io.flutter.b.iAd();
        this.BCx.aaqf.iBl();
        AppMethodBeat.o(253364);
      }
    }
    else
    {
      io.flutter.b.iAf();
    }
    AppMethodBeat.o(253364);
  }
  
  final void onUserLeaveHint()
  {
    AppMethodBeat.i(253363);
    ivE();
    if (this.BCx != null)
    {
      io.flutter.b.iAd();
      this.BCx.aapV.onUserLeaveHint();
      AppMethodBeat.o(253363);
      return;
    }
    io.flutter.b.iAf();
    AppMethodBeat.o(253363);
  }
  
  final void release()
  {
    this.aaoC = null;
    this.BCx = null;
    this.BCI = null;
    this.BCJ = null;
  }
  
  static abstract interface a
    extends f, g, k, b.a
  {
    public abstract j NC();
    
    public abstract io.flutter.embedding.engine.a ND();
    
    public abstract String Nw();
    
    public abstract String Nx();
    
    public abstract String Ny();
    
    public abstract String Nz();
    
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void a(io.flutter.embedding.engine.a parama);
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract void epX();
    
    public abstract void epY();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract h getLifecycle();
    
    public abstract void iAm();
    
    public abstract io.flutter.embedding.engine.d iAo();
    
    public abstract boolean iAp();
    
    public abstract i iAq();
    
    public abstract l iAr();
    
    public abstract boolean iAt();
    
    public abstract boolean iAu();
    
    public abstract boolean iAv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.d
 * JD-Core Version:    0.7.0.1
 */