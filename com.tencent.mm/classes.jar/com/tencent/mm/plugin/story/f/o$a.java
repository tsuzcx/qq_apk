package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.i.a;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getFavResCount", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"})
public final class o$a
{
  private Map<String, Integer> wIM;
  public int wIP;
  
  public o$a()
  {
    AppMethodBeat.i(118757);
    this.wIM = ((Map)new HashMap());
    AppMethodBeat.o(118757);
  }
  
  public static int ary(String paramString)
  {
    AppMethodBeat.i(118756);
    k.h(paramString, "userName");
    paramString = a.yor;
    int i = a.dJM();
    AppMethodBeat.o(118756);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.o.a
 * JD-Core Version:    0.7.0.1
 */