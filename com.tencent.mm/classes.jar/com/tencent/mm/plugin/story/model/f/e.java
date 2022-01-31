package com.tencent.mm.plugin.story.model.f;

import a.f.b.j;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.sdk.platformtools.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"})
public final class e
{
  public static final e szO;
  
  static
  {
    AppMethodBeat.i(109426);
    szO = new e();
    AppMethodBeat.o(109426);
  }
  
  public static k adr(String paramString)
  {
    AppMethodBeat.i(109425);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (m.ap((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = g.RO();
        j.p(localObject, "MMKernel.getPizzaWorkerThread()");
        if (((al)localObject).getLooper() != null) {
          break;
        }
      }
      AppMethodBeat.o(109425);
      return null;
    }
    if (t.nJ(paramString))
    {
      paramString = (k)new d(paramString);
      AppMethodBeat.o(109425);
      return paramString;
    }
    paramString = (k)new b(paramString);
    AppMethodBeat.o(109425);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.e
 * JD-Core Version:    0.7.0.1
 */