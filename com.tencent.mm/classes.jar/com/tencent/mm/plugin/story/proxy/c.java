package com.tencent.mm.plugin.story.proxy;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.h;
import com.tencent.mm.plugin.story.h.e;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler;", "", "()V", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "reStartMix", "", "storyEditorItem", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "Companion", "MixTask", "plugin-story_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Media.StoryMixHandler";
  private static final a.f eOH;
  public static final c.a sDq;
  private com.tencent.mm.loader.g.d<c.c> luA;
  
  static
  {
    AppMethodBeat.i(109755);
    sDq = new c.a((byte)0);
    eOH = a.g.j((a.f.a.a)c.b.sDr);
    TAG = "MicroMsg.Media.StoryMixHandler";
    AppMethodBeat.o(109755);
  }
  
  private c()
  {
    AppMethodBeat.i(109754);
    this.luA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.g((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(5), new h(1, (byte)0), 1, "storyMixTask"));
    AppMethodBeat.o(109754);
  }
  
  public final boolean a(com.tencent.mm.plugin.story.h.d paramd)
  {
    AppMethodBeat.i(109753);
    a.f.b.j.q(paramd, "storyEditorItem");
    ab.i(TAG, "reStart background mix2 " + paramd.systemRowid + " it " + paramd);
    this.luA.a((com.tencent.mm.loader.g.c)new c.c(paramd), (com.tencent.mm.loader.g.f)new c.e(this, paramd));
    AppMethodBeat.o(109753);
    return true;
  }
  
  public final boolean cCx()
  {
    AppMethodBeat.i(109752);
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAG().cEO();
    if (localObject != null)
    {
      ab.i(TAG, "reStart background mix1 " + ((com.tencent.mm.plugin.story.h.d)localObject).systemRowid + " it " + localObject);
      this.luA.a((com.tencent.mm.loader.g.c)new c.c((com.tencent.mm.plugin.story.h.d)localObject), (com.tencent.mm.loader.g.f)new c.d(this, (com.tencent.mm.plugin.story.h.d)localObject));
      AppMethodBeat.o(109752);
      return true;
    }
    ab.d(TAG, "mix task is empty");
    AppMethodBeat.o(109752);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */