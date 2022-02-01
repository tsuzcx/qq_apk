package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "", "()V", "timelineRespCount", "", "userRespCounts", "", "", "getFavResCount", "getHistoryResCount", "userName", "getResPCount", "getUserPageResCount", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n$a
{
  private Map<String, Integer> QwC;
  public int QwF;
  
  public n$a()
  {
    AppMethodBeat.i(118757);
    this.QwC = ((Map)new HashMap());
    AppMethodBeat.o(118757);
  }
  
  public static int bbR(String paramString)
  {
    AppMethodBeat.i(118756);
    s.u(paramString, "userName");
    paramString = a.Sry;
    int i = a.hyz();
    AppMethodBeat.o(118756);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.n.a
 * JD-Core Version:    0.7.0.1
 */