package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryNewFeatureElementConfig$StoryNewFeatureConfig;", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "()V", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "visitorEnable", "", "StoryNewFeatureConfig", "plugin-story_release"})
public final class e
  extends com.tencent.mm.plugin.story.c.b<e.a>
  implements j
{
  public static final e ydS;
  
  static
  {
    AppMethodBeat.i(118610);
    ydS = new e();
    AppMethodBeat.o(118610);
  }
  
  public final void ajo()
  {
    AppMethodBeat.i(118608);
    if ((h.IS_FLAVOR_PURPLE) || (h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      ((e.a)ajm()).ydT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwk, false);
      AppMethodBeat.o(118608);
      return;
    }
    ((e.a)ajm()).ydT = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwk, false);
    AppMethodBeat.o(118608);
  }
  
  public final boolean dGh()
  {
    AppMethodBeat.i(118609);
    boolean bool = ((e.a)ajp()).ydT;
    AppMethodBeat.o(118609);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.c.a.e
 * JD-Core Version:    0.7.0.1
 */