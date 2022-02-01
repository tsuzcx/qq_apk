package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"})
public enum b$b
{
  private final int s;
  
  static
  {
    AppMethodBeat.i(119387);
    b localb1 = new b("SHOW", 0, 1);
    ARE = localb1;
    b localb2 = new b("PLAY", 1, 2);
    ARF = localb2;
    b localb3 = new b("WAIT", 2, 3);
    ARG = localb3;
    ARH = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(119387);
  }
  
  private b$b(int paramInt)
  {
    this.s = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.b.b
 * JD-Core Version:    0.7.0.1
 */