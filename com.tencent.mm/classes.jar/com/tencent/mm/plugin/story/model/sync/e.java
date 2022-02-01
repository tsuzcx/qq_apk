package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcherFactory;", "", "()V", "getFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e SnJ;
  
  static
  {
    AppMethodBeat.i(119080);
    SnJ = new e();
    AppMethodBeat.o(119080);
  }
  
  public static l bca(String paramString)
  {
    AppMethodBeat.i(119079);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; (i != 0) || (h.baH().getLooper() == null); i = 0)
    {
      AppMethodBeat.o(119079);
      return null;
    }
    if (au.bwG(paramString))
    {
      paramString = (l)new d(paramString);
      AppMethodBeat.o(119079);
      return paramString;
    }
    paramString = (l)new b(paramString);
    AppMethodBeat.o(119079);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.e
 * JD-Core Version:    0.7.0.1
 */