package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.n.n;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
public final class e
{
  public static final e yjc;
  
  static
  {
    AppMethodBeat.i(119080);
    yjc = new e();
    AppMethodBeat.o(119080);
  }
  
  public static com.tencent.mm.plugin.story.api.l arI(String paramString)
  {
    AppMethodBeat.i(119079);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aC((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = g.afE();
        k.g(localObject, "MMKernel.getPizzaWorkerThread()");
        if (((aq)localObject).getLooper() != null) {
          break;
        }
      }
      AppMethodBeat.o(119079);
      return null;
    }
    if (w.sm(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.e
 * JD-Core Version:    0.7.0.1
 */