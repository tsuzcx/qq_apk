package com.tencent.mm.plugin.recordvideo.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private JSONArray NRc;
  private final Object lock;
  
  public a()
  {
    AppMethodBeat.i(75830);
    this.NRc = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(75830);
  }
  
  public final void agF(int paramInt)
  {
    AppMethodBeat.i(75828);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", this.NRc.length() + 1);
    if (this.NRc.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (this.lock)
      {
        this.NRc.put(localJSONObject);
        AppMethodBeat.o(75828);
        return;
        paramInt = 1;
      }
    }
  }
  
  public final String gJd()
  {
    AppMethodBeat.i(75829);
    synchronized (this.lock)
    {
      String str = this.NRc.toString();
      s.s(str, "traceJsonArray.toString()");
      str = n.m(str, ",", ";", false);
      AppMethodBeat.o(75829);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.a
 * JD-Core Version:    0.7.0.1
 */