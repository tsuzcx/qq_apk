package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final List<String> a(p paramp)
  {
    AppMethodBeat.i(118915);
    s.u(paramp, "dataSeed");
    if ((paramp instanceof b))
    {
      AppMethodBeat.o(118915);
      throw null;
    }
    if ((paramp instanceof a))
    {
      paramp = ((a)paramp).oxE;
      AppMethodBeat.o(118915);
      return paramp;
    }
    if ((paramp instanceof c))
    {
      paramp = ((c)paramp).Sme;
      AppMethodBeat.o(118915);
      return paramp;
    }
    if ((paramp instanceof d))
    {
      paramp = ((d)paramp).oxE;
      AppMethodBeat.o(118915);
      return paramp;
    }
    paramp = (List)new ArrayList();
    AppMethodBeat.o(118915);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.f
 * JD-Core Version:    0.7.0.1
 */