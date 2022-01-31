package com.tencent.mm.plugin.story.model.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getGalleryFilterList", "", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "dataSeed", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "getGalleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "getGalleryUserList", "", "plugin-story_release"})
public final class e
{
  public static final List<String> a(o paramo)
  {
    AppMethodBeat.i(109308);
    j.q(paramo, "dataSeed");
    if ((paramo instanceof b))
    {
      paramo = ((b)paramo).fxt;
      AppMethodBeat.o(109308);
      return paramo;
    }
    if ((paramo instanceof a))
    {
      paramo = ((a)paramo).fxt;
      AppMethodBeat.o(109308);
      return paramo;
    }
    if ((paramo instanceof c))
    {
      paramo = ((c)paramo).syn;
      AppMethodBeat.o(109308);
      return paramo;
    }
    paramo = (List)new ArrayList();
    AppMethodBeat.o(109308);
    return paramo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.e
 * JD-Core Version:    0.7.0.1
 */