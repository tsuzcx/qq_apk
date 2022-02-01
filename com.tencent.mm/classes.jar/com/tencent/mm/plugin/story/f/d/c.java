package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", "username", "isMultiSelected", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedList", "queryCondition", "", "(JLjava/util/List;Ljava/lang/String;ZLjava/util/Map;Ljava/util/ArrayList;I)V", "getCheckedList", "()Ljava/util/ArrayList;", "getDateList", "()Ljava/util/List;", "getFilterList", "()Ljava/util/Map;", "()Z", "getUsername", "()Ljava/lang/String;", "plugin-story_release"})
public final class c
  extends p
{
  public final Map<String, ArrayList<Long>> BdR;
  final List<String> BdS;
  public final ArrayList<Long> BdT;
  public final String username;
  public final boolean zan;
  
  public c(long paramLong, List<String> paramList, String paramString, boolean paramBoolean, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118907);
    this.BdS = paramList;
    this.username = paramString;
    this.zan = paramBoolean;
    this.BdR = paramMap;
    this.BdT = paramArrayList;
    AppMethodBeat.o(118907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.c
 * JD-Core Version:    0.7.0.1
 */