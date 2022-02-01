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
  private static d KuC;
  private d.a KuD;
  private m KuE;
  public Activity KuF;
  public io.flutter.embedding.engine.a cDT;
  
  public static d fHA()
  {
    AppMethodBeat.i(191685);
    if (KuC == null) {}
    try
    {
      KuC = new d();
      d locald = KuC;
      AppMethodBeat.o(191685);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(191685);
    }
  }
  
  public final void a(d.a parama)
  {
    this.KuD = parama;
  }
  
  public final void init()
  {
    AppMethodBeat.i(191686);
    if (this.KuD.KuM != null) {
      com.tencent.wax.c.a.b(this.KuD.KuM);
    }
    Object localObject1;
    Object localObject2;
    if (this.cDT == null)
    {
      localObject1 = this.KuD;
      FlutterMain.startInitialization(((d.a)localObject1).GX);
      FlutterMain.ensureInitializationComplete(((d.a)localObject1).GX, ((d.a)localObject1).KuJ.fNp());
      this.cDT = new io.flutter.embedding.engine.a(((d.a)localObject1).GX);
      localObject1 = this.cDT;
      ((io.flutter.embedding.engine.a)localObject1).KLp.setInitialRoute(this.KuD.KuH);
      if (!((io.flutter.embedding.engine.a)localObject1).KLk.KLV)
      {
        localObject2 = new DartExecutor.a(FlutterMain.findAppBundlePath(), this.KuD.KuG);
        ((io.flutter.embedding.engine.a)localObject1).KLk.a((DartExecutor.a)localObject2);
      }
    }
    if (this.KuE == null) {
      this.KuE = new b(this.cDT, this.KuD.GX);
    }
    if (!this.KuE.aVE("WxaRouterPlugin"))
    {
      this.KuD.KuK.a(this.KuE);
      this.KuE.dq("WxaRouterPlugin");
    }
    if (this.KuD.KuL != null)
    {
      localObject1 = e.fHC();
      localObject2 = this.KuD.KuL;
      if (!((e)localObject1).KuP.contains(localObject2))
      {
        ((e)localObject1).KuP.add(localObject2);
        AppMethodBeat.o(191686);
        return;
      }
      com.tencent.wax.c.a.i("WxaRouter.WxaRouterPlugin", "had add method call handler %s", new Object[] { Integer.valueOf(localObject2.hashCode()) });
      AppMethodBeat.o(191686);
      return;
    }
    com.tencent.wax.c.a.i("WxaRouter.WxaRouter", "no method call handler.", new Object[0]);
    AppMethodBeat.o(191686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.d
 * JD-Core Version:    0.7.0.1
 */