package com.tencent.mm.plugin.story.c.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
public enum f$a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(108981);
    a locala1 = new a("FORWARD", 0, 0);
    ssi = locala1;
    a locala2 = new a("BACKGROUND", 1, 1);
    ssj = locala2;
    ssk = new a[] { locala1, locala2 };
    AppMethodBeat.o(108981);
  }
  
  private f$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.f.a
 * JD-Core Version:    0.7.0.1
 */