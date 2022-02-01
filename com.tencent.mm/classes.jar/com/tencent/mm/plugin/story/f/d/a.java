package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/AllFriendStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(JLjava/util/List;Ljava/util/Map;I)V", "getFilterList", "()Ljava/util/Map;", "getUserList", "()Ljava/util/List;", "plugin-story_release"})
public final class a
  extends p
{
  public final List<String> gYI;
  public final Map<String, ArrayList<Long>> yhu;
  
  public a(long paramLong, List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118906);
    this.gYI = paramList;
    this.yhu = paramMap;
    AppMethodBeat.o(118906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.a
 * JD-Core Version:    0.7.0.1
 */