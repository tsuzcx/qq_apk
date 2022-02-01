package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"})
public final class f
{
  public static final List<String> a(p paramp)
  {
    AppMethodBeat.i(118915);
    k.h(paramp, "dataSeed");
    if ((paramp instanceof b))
    {
      paramp = ((b)paramp).gYI;
      AppMethodBeat.o(118915);
      return paramp;
    }
    if ((paramp instanceof a))
    {
      paramp = ((a)paramp).gYI;
      AppMethodBeat.o(118915);
      return paramp;
    }
    if ((paramp instanceof c))
    {
      paramp = ((c)paramp).yhv;
      AppMethodBeat.o(118915);
      return paramp;
    }
    if ((paramp instanceof d))
    {
      paramp = ((d)paramp).gYI;
      AppMethodBeat.o(118915);
      return paramp;
    }
    paramp = (List)new ArrayList();
    AppMethodBeat.o(118915);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.f
 * JD-Core Version:    0.7.0.1
 */