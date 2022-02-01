package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.n.n;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
public final class e
{
  public static final e ANX;
  
  static
  {
    AppMethodBeat.i(119080);
    ANX = new e();
    AppMethodBeat.o(119080);
  }
  
  public static com.tencent.mm.plugin.story.api.l aBV(String paramString)
  {
    AppMethodBeat.i(119079);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aE((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = g.ajF();
        p.g(localObject, "MMKernel.getPizzaWorkerThread()");
        if (((aq)localObject).getLooper() != null) {
          break;
        }
      }
      AppMethodBeat.o(119079);
      return null;
    }
    if (w.zk(paramString))
    {
      paramString = (com.tencent.mm.plugin.story.api.l)new d(paramString);
      AppMethodBeat.o(119079);
      return paramString;
    }
    paramString = (com.tencent.mm.plugin.story.api.l)new b(paramString);
    AppMethodBeat.o(119079);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.e
 * JD-Core Version:    0.7.0.1
 */