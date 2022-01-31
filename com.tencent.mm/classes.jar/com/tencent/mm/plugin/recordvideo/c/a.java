package com.tencent.mm.plugin.recordvideo.c;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-recordvideo_release"})
public final class a
{
  final Object lock;
  JSONArray qfr;
  
  public a()
  {
    AppMethodBeat.i(154638);
    this.qfr = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(154638);
  }
  
  public final String cgA()
  {
    AppMethodBeat.i(154637);
    synchronized (this.lock)
    {
      String str = this.qfr.toString();
      j.p(str, "traceJsonArray.toString()");
      str = m.h(str, ",", ";", false);
      AppMethodBeat.o(154637);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.a
 * JD-Core Version:    0.7.0.1
 */