package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig$StoryNewFeatureConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "()V", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "visitorEnable", "", "StoryNewFeatureConfig", "plugin-story_release"})
public final class e
  extends com.tencent.mm.plugin.story.c.b<e.a>
  implements j
{
  public static final e zqS;
  
  static
  {
    AppMethodBeat.i(118610);
    zqS = new e();
    AppMethodBeat.o(118610);
  }
  
  public final void aqo()
  {
    AppMethodBeat.i(118608);
    if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      ((e.a)aqm()).zqT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qay, false);
      AppMethodBeat.o(118608);
      return;
    }
    ((e.a)aqm()).zqT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qay, false);
    AppMethodBeat.o(118608);
  }
  
  public final boolean dUI()
  {
    AppMethodBeat.i(118609);
    boolean bool = ((e.a)aqp()).zqT;
    AppMethodBeat.o(118609);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.e
 * JD-Core Version:    0.7.0.1
 */