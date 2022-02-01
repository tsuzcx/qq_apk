package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-recordvideo_release"})
public final class a
{
  private final Object lock;
  private JSONArray xWL;
  
  public a()
  {
    AppMethodBeat.i(75830);
    this.xWL = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(75830);
  }
  
  public final void Or(int paramInt)
  {
    AppMethodBeat.i(75828);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", this.xWL.length() + 1);
    if (this.xWL.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (this.lock)
      {
        this.xWL.put(localJSONObject);
        AppMethodBeat.o(75828);
        return;
        paramInt = 1;
      }
    }
  }
  
  public final String dKa()
  {
    AppMethodBeat.i(75829);
    synchronized (this.lock)
    {
      String str = this.xWL.toString();
      p.g(str, "traceJsonArray.toString()");
      str = n.h(str, ",", ";", false);
      AppMethodBeat.o(75829);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a
 * JD-Core Version:    0.7.0.1
 */