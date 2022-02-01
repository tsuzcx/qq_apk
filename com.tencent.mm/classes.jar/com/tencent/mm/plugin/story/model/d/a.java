package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/AllFriendStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(JLjava/util/List;Ljava/util/Map;I)V", "getFilterList", "()Ljava/util/Map;", "getUserList", "()Ljava/util/List;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
{
  public final Map<String, ArrayList<Long>> Smd;
  public final List<String> oxE;
  
  public a(long paramLong, List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118906);
    this.oxE = paramList;
    this.Smd = paramMap;
    AppMethodBeat.o(118906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.a
 * JD-Core Version:    0.7.0.1
 */