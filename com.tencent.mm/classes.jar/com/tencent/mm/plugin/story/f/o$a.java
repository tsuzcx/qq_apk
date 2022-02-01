package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getFavResCount", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"})
public final class o$a
{
  private Map<String, Integer> DMs;
  public int DMv;
  
  public o$a()
  {
    AppMethodBeat.i(118757);
    this.DMs = ((Map)new HashMap());
    AppMethodBeat.o(118757);
  }
  
  public static int aSa(String paramString)
  {
    AppMethodBeat.i(118756);
    p.h(paramString, "userName");
    paramString = a.FvD;
    int i = a.fqL();
    AppMethodBeat.o(118756);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.o.a
 * JD-Core Version:    0.7.0.1
 */