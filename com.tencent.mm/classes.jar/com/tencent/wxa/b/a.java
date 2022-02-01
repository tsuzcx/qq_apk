package com.tencent.wxa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.d;
import io.flutter.plugin.a.k.d;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  private b ZZg;
  
  public a(b paramb)
  {
    this.ZZg = paramb;
  }
  
  private Map ivy()
  {
    AppMethodBeat.i(224824);
    HashMap localHashMap = new HashMap();
    String str1 = this.ZZg.NE();
    String str2 = this.ZZg.NF();
    Map localMap = this.ZZg.NG();
    localHashMap.put("activityId", str1);
    localHashMap.put("name", str2);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(224824);
    return localHashMap;
  }
  
  public final void a(boolean paramBoolean, k.d paramd)
  {
    AppMethodBeat.i(224832);
    com.tencent.wxa.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    com.tencent.wxa.c.ivt().ZYM.ZYW.a("onBackPressed", Boolean.valueOf(paramBoolean), paramd);
    AppMethodBeat.o(224832);
  }
  
  public final void ivz()
  {
    AppMethodBeat.i(224834);
    com.tencent.wxa.c.ivt().ZYM.G("closeView", ivy());
    AppMethodBeat.o(224834);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(224826);
    com.tencent.wxa.c.ivt().ZYM.G("onCreateView", ivy());
    AppMethodBeat.o(224826);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(224831);
    com.tencent.wxa.c.ivt().ZYM.G("onDestroyView", ivy());
    AppMethodBeat.o(224831);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(224829);
    com.tencent.wxa.c.ivt().ZYM.G("onPauseView", ivy());
    AppMethodBeat.o(224829);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(224828);
    com.tencent.wxa.c.ivt().ZYM.G("onResumeView", ivy());
    AppMethodBeat.o(224828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.b.a
 * JD-Core Version:    0.7.0.1
 */