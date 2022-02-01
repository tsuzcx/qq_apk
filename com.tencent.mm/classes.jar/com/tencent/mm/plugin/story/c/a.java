package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant;", "", "ElementName", "ModuleName", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "", "(Ljava/lang/String;I)V", "ELEMENT_CAMERA", "ELEMENT_ENCODER", "ELEMENT_PROCESS_TYPE", "ELEMENT_ENTRANCE", "ELEMENT_POST", "ELEMENT_BASIC", "ELEMENT_VISITOR", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118567);
      Siz = new a("ELEMENT_CAMERA", 0);
      SiA = new a("ELEMENT_ENCODER", 1);
      SiB = new a("ELEMENT_PROCESS_TYPE", 2);
      SiC = new a("ELEMENT_ENTRANCE", 3);
      SiD = new a("ELEMENT_POST", 4);
      SiE = new a("ELEMENT_BASIC", 5);
      SiF = new a("ELEMENT_VISITOR", 6);
      SiG = new a[] { Siz, SiA, SiB, SiC, SiD, SiE, SiF };
      AppMethodBeat.o(118567);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ModuleName;", "", "(Ljava/lang/String;I)V", "MODEL_STORY", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(118570);
      SiH = new b("MODEL_STORY");
      SiI = new b[] { SiH };
      AppMethodBeat.o(118570);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a
 * JD-Core Version:    0.7.0.1
 */