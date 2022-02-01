package com.tencent.wxa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.b.g;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.view.FlutterMain;
import java.lang.reflect.Method;

public class c
{
  private static c ZYH;
  public c.a ZYI;
  public io.flutter.embedding.engine.a ZYJ;
  public com.tencent.wxa.b.b ZYK;
  private FlutterView ZYL;
  public d ZYM;
  
  private io.flutter.embedding.engine.a b(c.a parama)
  {
    AppMethodBeat.i(224787);
    FlutterMain.startInitialization(parama.mAppContext);
    FlutterMain.ensureInitializationComplete(parama.mAppContext, parama.ZYQ.toArray());
    this.ZYJ = new io.flutter.embedding.engine.a(parama.mAppContext, '\000');
    parama = this.ZYJ;
    AppMethodBeat.o(224787);
    return parama;
  }
  
  private void bSv()
  {
    AppMethodBeat.i(224780);
    if (this.ZYI.ZYS != null) {
      com.tencent.wxa.c.a.b(this.ZYI.ZYS);
    }
    AppMethodBeat.o(224780);
  }
  
  private void c(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(224790);
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "registerPlugins by wxa router", new Object[0]);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { io.flutter.embedding.engine.a.class }).invoke(null, new Object[] { parama });
      a.a(parama, this.ZYI.ZYT);
      AppMethodBeat.o(224790);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.wxa.c.a.w("WxaRouter.WxaRouter", "Tried to automatically register plugins with FlutterEngine (" + parama + ") but could not find and invoke the GeneratedPluginRegistrant.", new Object[0]);
      AppMethodBeat.o(224790);
    }
  }
  
  private void initFlutter()
  {
    AppMethodBeat.i(224783);
    if (this.ZYJ != null)
    {
      AppMethodBeat.o(224783);
      return;
    }
    io.flutter.embedding.engine.a locala = b(this.ZYI);
    locala.aaqb.setInitialRoute(this.ZYI.ZYO);
    if (locala.aapU.aaqG)
    {
      AppMethodBeat.o(224783);
      return;
    }
    DartExecutor.a locala1 = new DartExecutor.a(FlutterMain.findAppBundlePath(), this.ZYI.ZYN);
    locala.aapU.a(locala1);
    c(this.ZYJ);
    this.ZYM = ((d)this.ZYJ.aapV.bL(d.class));
    AppMethodBeat.o(224783);
  }
  
  public static c ivt()
  {
    AppMethodBeat.i(224768);
    if (ZYH == null) {}
    try
    {
      ZYH = new c();
      c localc = ZYH;
      AppMethodBeat.o(224768);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(224768);
    }
  }
  
  private void ivu()
  {
    AppMethodBeat.i(224788);
    if (c.a.c(this.ZYI) != null)
    {
      this.ZYM.l(c.a.c(this.ZYI));
      AppMethodBeat.o(224788);
      return;
    }
    com.tencent.wxa.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(224788);
  }
  
  public final void a(c.a parama)
  {
    this.ZYI = parama;
  }
  
  public final void a(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(224776);
    if (paramFlutterView == null)
    {
      AppMethodBeat.o(224776);
      return;
    }
    if (paramFlutterView != this.ZYL)
    {
      AppMethodBeat.o(224776);
      return;
    }
    paramFlutterView.iAm();
    this.ZYL = null;
    AppMethodBeat.o(224776);
  }
  
  public final void a(FlutterView paramFlutterView, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(224773);
    if (paramFlutterView == this.ZYL)
    {
      AppMethodBeat.o(224773);
      return;
    }
    if (this.ZYL != null) {
      this.ZYL.iAm();
    }
    if (paramFlutterView != null) {
      paramFlutterView.d(parama);
    }
    this.ZYL = paramFlutterView;
    AppMethodBeat.o(224773);
  }
  
  public final void b(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(224777);
    if (paramFlutterView != this.ZYL)
    {
      AppMethodBeat.o(224777);
      return;
    }
    this.ZYJ.aapY.iBe();
    AppMethodBeat.o(224777);
  }
  
  public final void c(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(224778);
    if (paramFlutterView != this.ZYL)
    {
      AppMethodBeat.o(224778);
      return;
    }
    this.ZYJ.aapY.iBf();
    AppMethodBeat.o(224778);
  }
  
  public final void init()
  {
    AppMethodBeat.i(224771);
    bSv();
    initFlutter();
    ivu();
    AppMethodBeat.o(224771);
  }
  
  public final com.tencent.wxa.b.b ivv()
  {
    return this.ZYK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.c
 * JD-Core Version:    0.7.0.1
 */