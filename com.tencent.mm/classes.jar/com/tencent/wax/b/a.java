package com.tencent.wax.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.e;
import io.flutter.plugin.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  b KuW;
  
  public a(b paramb)
  {
    this.KuW = paramb;
  }
  
  private Map fHE()
  {
    AppMethodBeat.i(191700);
    HashMap localHashMap = new HashMap();
    String str = this.KuW.cWJ();
    Map localMap = this.KuW.cWK();
    localHashMap.put("name", str);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(191700);
    return localHashMap;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(191705);
    com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    e locale = e.fHC();
    k.d local1 = new k.d()
    {
      public final void daE()
      {
        AppMethodBeat.i(191699);
        com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "notImplemented finish", new Object[0]);
        a.this.KuW.finish();
        AppMethodBeat.o(191699);
      }
      
      public final void db(Object paramAnonymousObject)
      {
        AppMethodBeat.i(191697);
        if ((paramAnonymousObject == null) || (!((Boolean)paramAnonymousObject).booleanValue())) {
          a.this.KuW.finish();
        }
        AppMethodBeat.o(191697);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(191698);
        com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "error finish", new Object[0]);
        a.this.KuW.finish();
        AppMethodBeat.o(191698);
      }
    };
    locale.KuO.a("backPressed", null, local1);
    AppMethodBeat.o(191705);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(191701);
    e.fHC().C("onCreateView", fHE());
    AppMethodBeat.o(191701);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(191704);
    e.fHC().C("onDestroyView", fHE());
    AppMethodBeat.o(191704);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(191703);
    e.fHC().C("onPause", fHE());
    AppMethodBeat.o(191703);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(191702);
    e.fHC().C("onResume", fHE());
    AppMethodBeat.o(191702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.b.a
 * JD-Core Version:    0.7.0.1
 */