package com.tencent.mm.plugin.story.g;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"})
public enum b$b
{
  private final int s;
  
  static
  {
    AppMethodBeat.i(109765);
    b localb1 = new b("SHOW", 0, 1);
    sDY = localb1;
    b localb2 = new b("PLAY", 1, 2);
    sDZ = localb2;
    b localb3 = new b("WAIT", 2, 3);
    sEa = localb3;
    sEb = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(109765);
  }
  
  private b$b(int paramInt)
  {
    this.s = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.b.b
 * JD-Core Version:    0.7.0.1
 */