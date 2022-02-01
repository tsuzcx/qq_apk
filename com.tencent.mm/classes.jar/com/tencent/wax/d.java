package com.tencent.wax;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.m;
import io.flutter.view.FlutterMain;
import java.util.HashSet;

public class d
{
  private static d MkD;
  private d.a MkE;
  private m MkF;
  public Activity MkG;
  public io.flutter.embedding.engine.a cOY;
  
  public static d fYR()
  {
    AppMethodBeat.i(217482);
    if (MkD == null) {}
    try
    {
      MkD = new d();
      d locald = MkD;
      AppMethodBeat.o(217482);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(217482);
    }
  }
  
  public final void a(d.a parama)
  {
    this.MkE = parama;
  }
  
  public final void init()
  {
    AppMethodBeat.i(217483);
    if (this.MkE.MkN != null) {
      com.tencent.wax.c.a.b(this.MkE.MkN);
    }
    Object localObject1;
    Object localObject2;
    if (this.cOY == null)
    {
      localObject1 = this.MkE;
      FlutterMain.startInitialization(((d.a)localObject1).IR);
      FlutterMain.ensureInitializationComplete(((d.a)localObject1).IR, ((d.a)localObject1).MkK.toArray());
      this.cOY = new io.flutter.embedding.engine.a(((d.a)localObject1).IR);
      localObject1 = this.cOY;
      ((io.flutter.embedding.engine.a)localObject1).MCm.setInitialRoute(this.MkE.MkI);
      if (!((io.flutter.embedding.engine.a)localObject1).MCh.MCS)
      {
        localObject2 = new DartExecutor.a(FlutterMain.findAppBundlePath(), this.MkE.MkH);
        ((io.flutter.embedding.engine.a)localObject1).MCh.a((DartExecutor.a)localObject2);
      }
    }
    if (this.MkF == null) {
      this.MkF = new b(this.cOY, this.MkE.IR);
    }
    if (!this.MkF.bbH("WxaRouterPlugin"))
    {
      this.MkE.MkL.a(this.MkF);
      this.MkF.em("WxaRouterPlugin");
    }
    if (this.MkE.MkM != null)
    {
      localObject1 = e.fYT();
      localObject2 = this.MkE.MkM;
      if (!((e)localObject1).MkQ.contains(localObject2))
      {
        ((e)localObject1).MkQ.add(localObject2);
        AppMethodBeat.o(217483);
        return;
      }
      com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      AppMethodBeat.o(217483);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(217483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.d
 * JD-Core Version:    0.7.0.1
 */