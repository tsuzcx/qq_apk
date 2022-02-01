package io.flutter.embedding.android;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.d;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import java.util.Arrays;

final class c
{
  a SMB;
  private FlutterSplashView SMC;
  private final io.flutter.embedding.engine.b.b SMD;
  boolean Syd;
  io.flutter.embedding.engine.a wJi;
  FlutterView wKM;
  io.flutter.plugin.platform.b wKN;
  
  c(a parama)
  {
    AppMethodBeat.i(10071);
    this.SMD = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215043);
        c.this.SMB.dLt();
        AppMethodBeat.o(215043);
      }
      
      public final void dLu()
      {
        AppMethodBeat.i(215044);
        c.this.SMB.dLu();
        AppMethodBeat.o(215044);
      }
    };
    this.SMB = parama;
    AppMethodBeat.o(10071);
  }
  
  private void hrP()
  {
    AppMethodBeat.i(10074);
    io.flutter.a.hwd();
    Object localObject = this.SMB.KJ();
    if (localObject != null)
    {
      this.wJi = io.flutter.embedding.engine.b.hwG().bta((String)localObject);
      this.Syd = true;
      if (this.wJi == null)
      {
        localObject = new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + (String)localObject + "'");
        AppMethodBeat.o(10074);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(10074);
      return;
    }
    localObject = this.SMB;
    this.SMB.getContext();
    this.wJi = ((a)localObject).KP();
    if (this.wJi != null)
    {
      this.Syd = true;
      AppMethodBeat.o(10074);
      return;
    }
    io.flutter.a.hwd();
    this.wJi = new io.flutter.embedding.engine.a(this.SMB.getContext(), this.SMB.hwl().toArray(), this.SMB.hwq());
    this.Syd = false;
    AppMethodBeat.o(10074);
  }
  
  private void hrR()
  {
    AppMethodBeat.i(215069);
    if (this.SMB.KJ() != null)
    {
      AppMethodBeat.o(215069);
      return;
    }
    if (this.wJi.SNW.SOI)
    {
      AppMethodBeat.o(215069);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(this.SMB.KK()).append(", and sending initial route: ").append(this.SMB.KM());
    io.flutter.a.hwd();
    if (this.SMB.KM() != null) {
      this.wJi.SOc.setInitialRoute(this.SMB.KM());
    }
    DartExecutor.a locala = new DartExecutor.a(this.SMB.KL(), this.SMB.KK());
    this.wJi.SNW.a(locala);
    AppMethodBeat.o(215069);
  }
  
  final void hrO()
  {
    AppMethodBeat.i(215067);
    hrS();
    if (this.wJi == null) {
      hrP();
    }
    this.wKN = this.SMB.a(this.SMB.getActivity(), this.wJi);
    if (this.SMB.hwp())
    {
      io.flutter.a.hwd();
      this.wJi.SNX.a(this.SMB.getActivity(), this.SMB.getLifecycle());
    }
    this.SMB.b(this.wJi);
    AppMethodBeat.o(215067);
  }
  
  final View hrQ()
  {
    AppMethodBeat.i(10075);
    io.flutter.a.hwd();
    hrS();
    Object localObject;
    boolean bool;
    if (this.SMB.hwn() == i.SNO)
    {
      localObject = this.SMB.getActivity();
      if (this.SMB.hwo() == l.SNT)
      {
        bool = true;
        localObject = new FlutterSurfaceView((Context)localObject, bool);
        this.wKM = new FlutterView(this.SMB.getActivity(), (FlutterSurfaceView)localObject);
        label86:
        this.wKM.a(this.SMD);
        this.SMC = new FlutterSplashView(this.SMB.getContext());
        if (Build.VERSION.SDK_INT < 17) {
          break label228;
        }
        this.SMC.setId(View.generateViewId());
      }
    }
    for (;;)
    {
      this.SMC.a(this.wKM, this.SMB.KF());
      io.flutter.a.hwd();
      this.wKM.d(this.wJi);
      localObject = this.SMC;
      AppMethodBeat.o(10075);
      return localObject;
      bool = false;
      break;
      localObject = new FlutterTextureView(this.SMB.getActivity());
      this.wKM = new FlutterView(this.SMB.getActivity(), (FlutterTextureView)localObject);
      break label86;
      label228:
      this.SMC.setId(486947586);
    }
  }
  
  final void hrS()
  {
    AppMethodBeat.i(10084);
    if (this.SMB == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
      AppMethodBeat.o(10084);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(10084);
  }
  
  final void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(215068);
    io.flutter.a.hwd();
    hrS();
    byte[] arrayOfByte = null;
    if (paramBundle != null)
    {
      paramBundle.getBundle("plugins");
      arrayOfByte = paramBundle.getByteArray("framework");
    }
    if (this.SMB.hwq()) {
      this.wJi.SOd.de(arrayOfByte);
    }
    if (this.SMB.hwp()) {
      this.wJi.SNX.hwM();
    }
    AppMethodBeat.o(215068);
  }
  
  final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(10083);
    hrS();
    if (this.wJi != null)
    {
      new StringBuilder("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ").append(paramInt1).append("\nresultCode: ").append(paramInt2).append("\ndata: ").append(paramIntent);
      io.flutter.a.hwd();
      this.wJi.SNX.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(10083);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(10083);
  }
  
  final void onBackPressed()
  {
    AppMethodBeat.i(215072);
    hrS();
    if (this.wJi != null)
    {
      io.flutter.a.hwd();
      this.wJi.SOc.dLr();
      AppMethodBeat.o(215072);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(215072);
  }
  
  final void onDestroyView()
  {
    AppMethodBeat.i(10080);
    io.flutter.a.hwd();
    hrS();
    this.wKM.hwy();
    this.wKM.b(this.SMD);
    AppMethodBeat.o(10080);
  }
  
  final void onDetach()
  {
    AppMethodBeat.i(10081);
    io.flutter.a.hwd();
    hrS();
    this.SMB.c(this.wJi);
    if (this.SMB.hwp())
    {
      io.flutter.a.hwd();
      if (!this.SMB.getActivity().isChangingConfigurations()) {
        break label155;
      }
      this.wJi.SNX.hwJ();
    }
    for (;;)
    {
      if (this.wKN != null)
      {
        this.wKN.destroy();
        this.wKN = null;
      }
      this.wJi.SNZ.hxf();
      if (this.SMB.hwm())
      {
        this.wJi.destroy();
        if (this.SMB.KJ() != null) {
          io.flutter.embedding.engine.b.hwG().btb(this.SMB.KJ());
        }
        this.wJi = null;
      }
      AppMethodBeat.o(10081);
      return;
      label155:
      this.wJi.SNX.hwK();
    }
  }
  
  final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(215073);
    hrS();
    if (this.wJi != null)
    {
      io.flutter.a.hwd();
      this.wJi.SNX.onNewIntent(paramIntent);
      AppMethodBeat.o(215073);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(215073);
  }
  
  final void onPause()
  {
    AppMethodBeat.i(10078);
    io.flutter.a.hwd();
    hrS();
    this.wJi.SNZ.hxc();
    AppMethodBeat.o(10078);
  }
  
  final void onPostResume()
  {
    AppMethodBeat.i(215070);
    io.flutter.a.hwd();
    hrS();
    if (this.wJi != null)
    {
      if (this.wKN != null)
      {
        this.wKN.hxp();
        AppMethodBeat.o(215070);
      }
    }
    else {
      io.flutter.a.hwf();
    }
    AppMethodBeat.o(215070);
  }
  
  final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(10082);
    hrS();
    if (this.wJi != null)
    {
      new StringBuilder("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ").append(paramInt).append("\npermissions: ").append(Arrays.toString(paramArrayOfString)).append("\ngrantResults: ").append(Arrays.toString(paramArrayOfInt));
      io.flutter.a.hwd();
      this.wJi.SNX.a(paramInt, paramArrayOfString, paramArrayOfInt);
      AppMethodBeat.o(10082);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(10082);
  }
  
  final void onResume()
  {
    AppMethodBeat.i(10077);
    io.flutter.a.hwd();
    hrS();
    this.wJi.SNZ.hxd();
    AppMethodBeat.o(10077);
  }
  
  final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(215071);
    io.flutter.a.hwd();
    hrS();
    if (this.SMB.hwq()) {
      paramBundle.putByteArray("framework", this.wJi.SOd.SRe);
    }
    if (this.SMB.hwp())
    {
      Bundle localBundle = new Bundle();
      this.wJi.SNX.hwL();
      paramBundle.putBundle("plugins", localBundle);
    }
    AppMethodBeat.o(215071);
  }
  
  final void onStart()
  {
    AppMethodBeat.i(10076);
    io.flutter.a.hwd();
    hrS();
    hrR();
    AppMethodBeat.o(10076);
  }
  
  final void onStop()
  {
    AppMethodBeat.i(10079);
    io.flutter.a.hwd();
    hrS();
    this.wJi.SNZ.hxe();
    AppMethodBeat.o(10079);
  }
  
  final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(215075);
    hrS();
    if (this.wJi != null)
    {
      this.wJi.SNW.notifyLowMemoryWarning();
      if (paramInt == 10)
      {
        io.flutter.a.hwd();
        this.wJi.SOh.hxj();
        AppMethodBeat.o(215075);
      }
    }
    else
    {
      io.flutter.a.hwf();
    }
    AppMethodBeat.o(215075);
  }
  
  final void onUserLeaveHint()
  {
    AppMethodBeat.i(215074);
    hrS();
    if (this.wJi != null)
    {
      io.flutter.a.hwd();
      this.wJi.SNX.onUserLeaveHint();
      AppMethodBeat.o(215074);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(215074);
  }
  
  static abstract interface a
    extends e, f, k
  {
    public abstract j KF();
    
    public abstract String KJ();
    
    public abstract String KK();
    
    public abstract String KL();
    
    public abstract String KM();
    
    public abstract io.flutter.embedding.engine.a KP();
    
    public abstract io.flutter.plugin.platform.b a(Activity paramActivity, io.flutter.embedding.engine.a parama);
    
    public abstract void b(io.flutter.embedding.engine.a parama);
    
    public abstract void c(io.flutter.embedding.engine.a parama);
    
    public abstract void dLt();
    
    public abstract void dLu();
    
    public abstract Activity getActivity();
    
    public abstract Context getContext();
    
    public abstract Lifecycle getLifecycle();
    
    public abstract d hwl();
    
    public abstract boolean hwm();
    
    public abstract i hwn();
    
    public abstract l hwo();
    
    public abstract boolean hwp();
    
    public abstract boolean hwq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.c
 * JD-Core Version:    0.7.0.1
 */