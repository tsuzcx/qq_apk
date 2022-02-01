package com.tencent.mm.plugin.story.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant;", "", "ElementName", "ModuleName", "plugin-story_release"})
public abstract interface a
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "", "(Ljava/lang/String;I)V", "ELEMENT_CAMERA", "ELEMENT_ENCODER", "ELEMENT_PROCESS_TYPE", "ELEMENT_ENTRANCE", "ELEMENT_POST", "ELEMENT_BASIC", "ELEMENT_VISITOR", "plugin-story_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118567);
      a locala1 = new a("ELEMENT_CAMERA", 0);
      AZO = locala1;
      a locala2 = new a("ELEMENT_ENCODER", 1);
      AZP = locala2;
      a locala3 = new a("ELEMENT_PROCESS_TYPE", 2);
      AZQ = locala3;
      a locala4 = new a("ELEMENT_ENTRANCE", 3);
      AZR = locala4;
      a locala5 = new a("ELEMENT_POST", 4);
      AZS = locala5;
      a locala6 = new a("ELEMENT_BASIC", 5);
      AZT = locala6;
      a locala7 = new a("ELEMENT_VISITOR", 6);
      AZU = locala7;
      AZV = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
      AppMethodBeat.o(118567);
    }
    
    private a() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ModuleName;", "", "(Ljava/lang/String;I)V", "MODEL_STORY", "plugin-story_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(118570);
      b localb = new b("MODEL_STORY");
      AZW = localb;
      AZX = new b[] { localb };
      AppMethodBeat.o(118570);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a
 * JD-Core Version:    0.7.0.1
 */