package com.tencent.wax.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.e;
import io.flutter.plugin.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  b MkX;
  
  public a(b paramb)
  {
    this.MkX = paramb;
  }
  
  private Map fYV()
  {
    AppMethodBeat.i(217497);
    HashMap localHashMap = new HashMap();
    String str = this.MkX.dfV();
    Map localMap = this.MkX.dfW();
    localHashMap.put("name", str);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(217497);
    return localHashMap;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(217502);
    com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    e locale = e.fYT();
    k.d local1 = new k.d()
    {
      public final void de(Object paramAnonymousObject)
      {
        AppMethodBeat.i(217494);
        if ((paramAnonymousObject == null) || (!((Boolean)paramAnonymousObject).booleanValue())) {
          a.this.MkX.finish();
        }
        AppMethodBeat.o(217494);
      }
      
      public final void djR()
      {
        AppMethodBeat.i(217496);
        com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "notImplemented finish", new Object[0]);
        a.this.MkX.finish();
        AppMethodBeat.o(217496);
      }
      
      public final void f(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(217495);
        com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "error finish", new Object[0]);
        a.this.MkX.finish();
        AppMethodBeat.o(217495);
      }
    };
    locale.MkP.a("backPressed", null, local1);
    AppMethodBeat.o(217502);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(217498);
    e.fYT().A("onCreateView", fYV());
    AppMethodBeat.o(217498);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(217501);
    e.fYT().A("onDestroyView", fYV());
    AppMethodBeat.o(217501);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(217500);
    e.fYT().A("onPause", fYV());
    AppMethodBeat.o(217500);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(217499);
    e.fYT().A("onResume", fYV());
    AppMethodBeat.o(217499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wax.b.a
 * JD-Core Version:    0.7.0.1
 */