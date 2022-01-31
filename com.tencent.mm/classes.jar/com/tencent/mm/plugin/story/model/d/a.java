package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/AllFriendStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(JLjava/util/List;Ljava/util/Map;)V", "getFilterList", "()Ljava/util/Map;", "getUserList", "()Ljava/util/List;", "plugin-story_release"})
public final class a
  extends o
{
  public final List<String> fxt;
  public final Map<String, ArrayList<Long>> sym;
  
  public a(long paramLong, List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap)
  {
    super(paramLong);
    AppMethodBeat.i(138768);
    this.fxt = paramList;
    this.sym = paramMap;
    AppMethodBeat.o(138768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.a
 * JD-Core Version:    0.7.0.1
 */