package com.tencent.wxa;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.android.d.a;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Method;
import java.util.HashSet;

public class c
{
  private static c SxD;
  private a SxE;
  public io.flutter.embedding.engine.a SxF;
  public com.tencent.wxa.b.b SxG;
  private FlutterView SxH;
  
  private void PP()
  {
    AppMethodBeat.i(206297);
    if (this.SxE.SxO != null) {
      com.tencent.wxa.c.a.b(this.SxE.SxO);
    }
    AppMethodBeat.o(206297);
  }
  
  private void a(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(206301);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "registerPlugins by wxa router", new Object[0]);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
      if (this.SxE.SxM != null) {
        this.SxE.SxM.a(parama);
      }
      AppMethodBeat.o(206301);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "Tried to automatically register plugins with FlutterEngine (" + parama + ") but could not find and invoke the GeneratedPluginRegistrant.", new Object[0]);
      AppMethodBeat.o(206301);
    }
  }
  
  private io.flutter.embedding.engine.a b(a parama)
  {
    AppMethodBeat.i(206299);
    FlutterMain.startInitialization(parama.mAppContext);
    FlutterMain.ensureInitializationComplete(parama.mAppContext, parama.SxL.toArray());
    this.SxF = new io.flutter.embedding.engine.a(parama.mAppContext, '\000');
    parama = this.SxF;
    AppMethodBeat.o(206299);
    return parama;
  }
  
  public static c hrH()
  {
    AppMethodBeat.i(206291);
    if (SxD == null) {}
    try
    {
      SxD = new c();
      c localc = SxD;
      AppMethodBeat.o(206291);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(206291);
    }
  }
  
  private void hrI()
  {
    AppMethodBeat.i(206300);
    if (a.c(this.SxE) != null)
    {
      d.k(a.c(this.SxE));
      AppMethodBeat.o(206300);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(206300);
  }
  
  private void initFlutter()
  {
    AppMethodBeat.i(206298);
    if (this.SxF != null)
    {
      AppMethodBeat.o(206298);
      return;
    }
    io.flutter.embedding.engine.a locala = b(this.SxE);
    locala.SOc.setInitialRoute(this.SxE.SxJ);
    if (locala.SNW.SOI)
    {
      AppMethodBeat.o(206298);
      return;
    }
    DartExecutor.a locala1 = new DartExecutor.a(FlutterMain.findAppBundlePath(), this.SxE.SxI);
    locala.SNW.a(locala1);
    a(this.SxF);
    AppMethodBeat.o(206298);
  }
  
  public final void a(a parama)
  {
    this.SxE = parama;
  }
  
  public final void a(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(206294);
    if (paramFlutterView == null)
    {
      AppMethodBeat.o(206294);
      return;
    }
    if (paramFlutterView != this.SxH)
    {
      AppMethodBeat.o(206294);
      return;
    }
    paramFlutterView.hwy();
    this.SxH = null;
    AppMethodBeat.o(206294);
  }
  
  public final void a(FlutterView paramFlutterView, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(206293);
    if (paramFlutterView == this.SxH)
    {
      AppMethodBeat.o(206293);
      return;
    }
    if (this.SxH != null) {
      this.SxH.hwy();
    }
    if (paramFlutterView != null) {
      paramFlutterView.d(parama);
    }
    this.SxH = paramFlutterView;
    AppMethodBeat.o(206293);
  }
  
  public final void b(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(206295);
    if (paramFlutterView != this.SxH)
    {
      AppMethodBeat.o(206295);
      return;
    }
    this.SxF.SNZ.hxd();
    AppMethodBeat.o(206295);
  }
  
  public final void c(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(206296);
    if (paramFlutterView != this.SxH)
    {
      AppMethodBeat.o(206296);
      return;
    }
    this.SxF.SNZ.hxe();
    AppMethodBeat.o(206296);
  }
  
  public final com.tencent.wxa.b.b hrJ()
  {
    return this.SxG;
  }
  
  public final void init()
  {
    AppMethodBeat.i(206292);
    PP();
    initFlutter();
    hrI();
    AppMethodBeat.o(206292);
  }
  
  public static final class a
  {
    public static final String crl;
    public String SxI;
    public String SxJ;
    public FlutterView.b SxK;
    public io.flutter.embedding.engine.d SxL;
    public b SxM;
    private HashSet<a> SxN;
    public a.a SxO;
    public Context mAppContext;
    
    static
    {
      AppMethodBeat.i(206290);
      crl = d.a.SMF.name();
      AppMethodBeat.o(206290);
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(206288);
      this.SxI = "main";
      this.SxJ = "/";
      this.SxK = FlutterView.b.SNz;
      this.SxL = new io.flutter.embedding.engine.d(new String[0]);
      this.SxN = new HashSet();
      this.mAppContext = paramContext;
      AppMethodBeat.o(206288);
    }
    
    public final a a(a parama)
    {
      AppMethodBeat.i(206289);
      if (!this.SxN.contains(parama)) {
        this.SxN.add(parama);
      }
      AppMethodBeat.o(206289);
      return this;
    }
    
    public final a a(b paramb)
    {
      this.SxM = paramb;
      return this;
    }
    
    public final a a(a.a parama)
    {
      this.SxO = parama;
      return this;
    }
    
    public final a brB(String paramString)
    {
      this.SxI = paramString;
      return this;
    }
    
    public final a hrK()
    {
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.c
 * JD-Core Version:    0.7.0.1
 */