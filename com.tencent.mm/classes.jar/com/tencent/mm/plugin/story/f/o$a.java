package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.a;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getFavResCount", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"})
public final class o$a
{
  private Map<String, Integer> xVh;
  public int xVk;
  
  public o$a()
  {
    AppMethodBeat.i(118757);
    this.xVh = ((Map)new HashMap());
    AppMethodBeat.o(118757);
  }
  
  public static int awH(String paramString)
  {
    AppMethodBeat.i(118756);
    k.h(paramString, "userName");
    paramString = a.zBQ;
    int i = a.dYn();
    AppMethodBeat.o(118756);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.o.a
 * JD-Core Version:    0.7.0.1
 */