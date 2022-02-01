package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-recordvideo_release"})
public final class a
{
  private JSONArray BXw;
  private final Object lock;
  
  public a()
  {
    AppMethodBeat.i(75830);
    this.BXw = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(75830);
  }
  
  public final void VG(int paramInt)
  {
    AppMethodBeat.i(75828);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", this.BXw.length() + 1);
    if (this.BXw.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (this.lock)
      {
        this.BXw.put(localJSONObject);
        AppMethodBeat.o(75828);
        return;
        paramInt = 1;
      }
    }
  }
  
  public final String eKV()
  {
    AppMethodBeat.i(75829);
    synchronized (this.lock)
    {
      String str = this.BXw.toString();
      p.g(str, "traceJsonArray.toString()");
      str = n.j(str, ",", ";", false);
      AppMethodBeat.o(75829);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.a
 * JD-Core Version:    0.7.0.1
 */