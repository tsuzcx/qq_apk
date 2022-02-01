package com.tencent.wxa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements c
{
  private b aidR;
  private FlutterEngine aidS;
  
  public a(b paramb, FlutterEngine paramFlutterEngine)
  {
    this.aidR = paramb;
    this.aidS = paramFlutterEngine;
  }
  
  private Map dyX()
  {
    AppMethodBeat.i(210473);
    HashMap localHashMap = new HashMap();
    String str1 = this.aidR.anP();
    String str2 = this.aidR.anQ();
    Map localMap = this.aidR.anR();
    localHashMap.put("activityId", str1);
    localHashMap.put("name", str2);
    localHashMap.put("params", localMap);
    AppMethodBeat.o(210473);
    return localHashMap;
  }
  
  public final void a(boolean paramBoolean, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(210495);
    com.tencent.wxa.c.a.d("WxaRouter.DefaultFlutterViewLifecycle", "onBackPressed", new Object[0]);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "onBackPressed", Boolean.valueOf(paramBoolean), paramResult);
    AppMethodBeat.o(210495);
  }
  
  public final void keT()
  {
    AppMethodBeat.i(210501);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "closeView", dyX());
    AppMethodBeat.o(210501);
  }
  
  public final void onCreateView()
  {
    AppMethodBeat.i(210476);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "onCreateView", dyX());
    AppMethodBeat.o(210476);
  }
  
  public final void onDestroyView()
  {
    AppMethodBeat.i(210488);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "onDestroyView", dyX());
    AppMethodBeat.o(210488);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(210483);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "onPauseView", dyX());
    AppMethodBeat.o(210483);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(210480);
    com.tencent.wxa.c.keQ();
    com.tencent.wxa.c.a(this.aidS, "onResumeView", dyX());
    AppMethodBeat.o(210480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.wxa.b.a
 * JD-Core Version:    0.7.0.1
 */