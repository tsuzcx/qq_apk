package com.tencent.wax;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.c.a.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterMain;

public class d
{
  private static d MHA;
  private a MHB;
  private m MHC;
  public com.tencent.wax.b.b MHD;
  private FlutterView MHE;
  public io.flutter.embedding.engine.a cPI;
  
  public static d gdr()
  {
    AppMethodBeat.i(195485);
    if (MHA == null) {}
    try
    {
      MHA = new d();
      d locald = MHA;
      AppMethodBeat.o(195485);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(195485);
    }
  }
  
  public final void a(a parama)
  {
    this.MHB = parama;
  }
  
  public final void a(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(195488);
    if ((paramFlutterView == null) || (paramFlutterView != this.MHE))
    {
      AppMethodBeat.o(195488);
      return;
    }
    paramFlutterView.giZ();
    this.MHE = null;
    AppMethodBeat.o(195488);
  }
  
  public final void a(FlutterView paramFlutterView, io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(195487);
    if (paramFlutterView == this.MHE)
    {
      AppMethodBeat.o(195487);
      return;
    }
    if (this.MHE != null) {
      this.MHE.giZ();
    }
    if (paramFlutterView != null) {
      paramFlutterView.c(parama);
    }
    this.MHE = paramFlutterView;
    AppMethodBeat.o(195487);
  }
  
  public final void b(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(195489);
    if (paramFlutterView != this.MHE)
    {
      AppMethodBeat.o(195489);
      return;
    }
    this.cPI.MZp.gjB();
    AppMethodBeat.o(195489);
  }
  
  public final void c(FlutterView paramFlutterView)
  {
    AppMethodBeat.i(195490);
    if (paramFlutterView != this.MHE)
    {
      AppMethodBeat.o(195490);
      return;
    }
    this.cPI.MZp.gjC();
    AppMethodBeat.o(195490);
  }
  
  public final void init()
  {
    AppMethodBeat.i(195486);
    if (this.MHB.MHL != null) {
      com.tencent.wax.c.a.b(this.MHB.MHL);
    }
    if (this.cPI == null)
    {
      Object localObject = this.MHB;
      FlutterMain.startInitialization(((a)localObject).IR);
      FlutterMain.ensureInitializationComplete(((a)localObject).IR, ((a)localObject).MHI.toArray());
      this.cPI = new io.flutter.embedding.engine.a(((a)localObject).IR);
      localObject = this.cPI;
      ((io.flutter.embedding.engine.a)localObject).MZr.setInitialRoute(this.MHB.MHG);
      if (!((io.flutter.embedding.engine.a)localObject).MZm.MZX)
      {
        DartExecutor.a locala = new DartExecutor.a(FlutterMain.findAppBundlePath(), this.MHB.MHF);
        ((io.flutter.embedding.engine.a)localObject).MZm.a(locala);
      }
    }
    if (this.MHC == null) {
      this.MHC = new b(this.cPI, this.MHB.IR);
    }
    if (!this.MHC.bdl("WxaRouterPlugin"))
    {
      this.MHB.MHJ.a(this.MHC);
      this.MHC.er("WxaRouterPlugin");
    }
    e.gdt().b(new com.tencent.wax.a.c());
    if (this.MHB.MHK != null)
    {
      e.gdt().b(this.MHB.MHK);
      AppMethodBeat.o(195486);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(195486);
  }
  
  public static final class a
  {
    public static final String vlc;
    public Context IR;
    public String MHF;
    public String MHG;
    public FlutterView.b MHH;
    public io.flutter.embedding.engine.d MHI;
    public c MHJ;
    public a MHK;
    public a.a MHL;
    
    static
    {
      AppMethodBeat.i(195484);
      vlc = io.flutter.embedding.android.d.a.MYs.name();
      AppMethodBeat.o(195484);
    }
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(195483);
      this.MHF = "main";
      this.MHG = "/";
      this.MHH = FlutterView.b.MZa;
      this.MHI = new io.flutter.embedding.engine.d(new String[0]);
      this.IR = paramContext;
      AppMethodBeat.o(195483);
    }
    
    public final a a(a parama)
    {
      this.MHK = parama;
      return this;
    }
    
    public final a a(a.a parama)
    {
      this.MHL = parama;
      return this;
    }
    
    public final a a(c paramc)
    {
      this.MHJ = paramc;
      return this;
    }
    
    public final a a(FlutterView.b paramb)
    {
      this.MHH = paramb;
      return this;
    }
    
    public final a bbz(String paramString)
    {
      this.MHF = paramString;
      return this;
    }
    
    public final a gds()
    {
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.d
 * JD-Core Version:    0.7.0.1
 */