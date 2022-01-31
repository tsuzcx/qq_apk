package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
public final class a
{
  private final Object lock;
  private JSONArray qfr;
  
  public a()
  {
    AppMethodBeat.i(109763);
    this.qfr = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(109763);
  }
  
  public final void FR(int paramInt)
  {
    AppMethodBeat.i(109761);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", this.qfr.length() + 1);
    if (this.qfr.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (this.lock)
      {
        this.qfr.put(localJSONObject);
        AppMethodBeat.o(109761);
        return;
        paramInt = 1;
      }
    }
  }
  
  public final String cgA()
  {
    AppMethodBeat.i(109762);
    synchronized (this.lock)
    {
      String str = this.qfr.toString();
      j.p(str, "traceJsonArray.toString()");
      str = m.h(str, ",", ";", false);
      this.qfr = new JSONArray();
      AppMethodBeat.o(109762);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.a
 * JD-Core Version:    0.7.0.1
 */