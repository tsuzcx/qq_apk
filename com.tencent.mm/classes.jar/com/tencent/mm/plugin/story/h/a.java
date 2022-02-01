package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONArray;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "lock", "Ljava/lang/Object;", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
public final class a
{
  JSONArray BXw;
  final Object lock;
  
  public a()
  {
    AppMethodBeat.i(119385);
    this.BXw = new JSONArray();
    this.lock = new Object();
    AppMethodBeat.o(119385);
  }
  
  public final String eKV()
  {
    AppMethodBeat.i(119384);
    synchronized (this.lock)
    {
      String str = this.BXw.toString();
      p.g(str, "traceJsonArray.toString()");
      str = n.j(str, ",", ";", false);
      this.BXw = new JSONArray();
      AppMethodBeat.o(119384);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.a
 * JD-Core Version:    0.7.0.1
 */