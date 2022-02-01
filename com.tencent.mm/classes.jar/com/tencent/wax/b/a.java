package com.tencent.wax.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.e;
import io.flutter.plugin.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  private b MHV;
  
  public a(b paramb)
  {
    this.MHV = paramb;
  }
  
  private Map gdv()
  {
    AppMethodBeat.i(195503);
    HashMap localHashMap = new HashMap();
    String str1 = this.MHV.diR();
    String str2 = this.MHV.diS();
    Map localMap = this.MHV.diT();
    localHashMap.put("activityId", str1);
    localHashMap.put("name", str2);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(195503);
    return localHashMap;
  }
  
  public final void a(k.d paramd)
  {
    AppMethodBeat.i(195508);
    com.tencent.wax.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    e.gdt().MHN.a("onBackPressed", null, paramd);
    AppMethodBeat.o(195508);
  }
  
  public final void gdw()
  {
    AppMethodBeat.i(195509);
    e.gdt().A("closeView", gdv());
    AppMethodBeat.o(195509);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(195504);
    e.gdt().A("onCreateView", gdv());
    AppMethodBeat.o(195504);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(195507);
    e.gdt().A("onDestroyView", gdv());
    AppMethodBeat.o(195507);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(195506);
    e.gdt().A("onPauseView", gdv());
    AppMethodBeat.o(195506);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195505);
    e.gdt().A("onResumeView", gdv());
    AppMethodBeat.o(195505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.b.a
 * JD-Core Version:    0.7.0.1
 */