package com.tencent.wxa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d;
import io.flutter.plugin.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  private b SxZ;
  
  public a(b paramb)
  {
    this.SxZ = paramb;
  }
  
  private Map hrM()
  {
    AppMethodBeat.i(206316);
    HashMap localHashMap = new HashMap();
    String str1 = this.SxZ.KQ();
    String str2 = this.SxZ.KR();
    Map localMap = this.SxZ.KS();
    localHashMap.put("activityId", str1);
    localHashMap.put("name", str2);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(206316);
    return localHashMap;
  }
  
  public final void a(k.d paramd)
  {
    AppMethodBeat.i(206321);
    com.tencent.wxa.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    d.a("onBackPressed", paramd);
    AppMethodBeat.o(206321);
  }
  
  public final void hrN()
  {
    AppMethodBeat.i(206322);
    d.G("closeView", hrM());
    AppMethodBeat.o(206322);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(206317);
    d.G("onCreateView", hrM());
    AppMethodBeat.o(206317);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(206320);
    d.G("onDestroyView", hrM());
    AppMethodBeat.o(206320);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(206319);
    d.G("onPauseView", hrM());
    AppMethodBeat.o(206319);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206318);
    d.G("onResumeView", hrM());
    AppMethodBeat.o(206318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.b.a
 * JD-Core Version:    0.7.0.1
 */