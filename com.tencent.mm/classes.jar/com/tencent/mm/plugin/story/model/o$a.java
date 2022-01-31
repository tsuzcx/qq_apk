package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.a;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getFavResCount", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"})
public final class o$a
{
  private Map<String, Integer> rie;
  public int rif;
  
  public o$a()
  {
    AppMethodBeat.i(109134);
    this.rie = ((Map)new HashMap());
    AppMethodBeat.o(109134);
  }
  
  public static int adg(String paramString)
  {
    AppMethodBeat.i(109133);
    j.q(paramString, "userName");
    paramString = a.sFV;
    int i = a.cDT();
    AppMethodBeat.o(109133);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.o.a
 * JD-Core Version:    0.7.0.1
 */