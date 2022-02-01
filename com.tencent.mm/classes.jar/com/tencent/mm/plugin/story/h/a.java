package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.n.n;
import org.json.JSONArray;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
public final class a
{
  final Object lock;
  JSONArray wxW;
  
  public a()
  {
    AppMethodBeat.i(119385);
    this.wxW = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(119385);
  }
  
  public final String dwp()
  {
    AppMethodBeat.i(119384);
    synchronized (this.lock)
    {
      String str = this.wxW.toString();
      k.g(str, "traceJsonArray.toString()");
      str = n.h(str, ",", ";", false);
      this.wxW = new JSONArray();
      AppMethodBeat.o(119384);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.a
 * JD-Core Version:    0.7.0.1
 */