package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;
import org.json.JSONArray;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
public final class a
{
  final Object lock;
  JSONArray xWL;
  
  public a()
  {
    AppMethodBeat.i(119385);
    this.xWL = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(119385);
  }
  
  public final String dKa()
  {
    AppMethodBeat.i(119384);
    synchronized (this.lock)
    {
      String str = this.xWL.toString();
      p.g(str, "traceJsonArray.toString()");
      str = n.h(str, ",", ";", false);
      this.xWL = new JSONArray();
      AppMethodBeat.o(119384);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.a
 * JD-Core Version:    0.7.0.1
 */