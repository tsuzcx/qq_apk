package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/report/StoryBrowseDetailIDKeyStat$State;", "", "s", "", "(Ljava/lang/String;II)V", "getS", "()I", "SHOW", "PLAY", "WAIT", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b$b
{
  private final int s;
  
  static
  {
    AppMethodBeat.i(119387);
    SqH = new b("SHOW", 0, 1);
    SqI = new b("PLAY", 1, 2);
    SqJ = new b("WAIT", 2, 3);
    SqK = new b[] { SqH, SqI, SqJ };
    AppMethodBeat.o(119387);
  }
  
  private b$b(int paramInt)
  {
    this.s = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.b.b
 * JD-Core Version:    0.7.0.1
 */