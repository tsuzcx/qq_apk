package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", "username", "isMultiSelected", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedList", "queryCondition", "", "(JLjava/util/List;Ljava/lang/String;ZLjava/util/Map;Ljava/util/ArrayList;I)V", "getCheckedList", "()Ljava/util/ArrayList;", "getDateList", "()Ljava/util/List;", "getFilterList", "()Ljava/util/Map;", "()Z", "getUsername", "()Ljava/lang/String;", "plugin-story_release"})
public final class c
  extends p
{
  public final boolean JkL;
  public final Map<String, ArrayList<Long>> LIK;
  final List<String> LIL;
  public final ArrayList<Long> LIM;
  public final String username;
  
  public c(long paramLong, List<String> paramList, String paramString, boolean paramBoolean, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118907);
    this.LIL = paramList;
    this.username = paramString;
    this.JkL = paramBoolean;
    this.LIK = paramMap;
    this.LIM = paramArrayList;
    AppMethodBeat.o(118907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.c
 * JD-Core Version:    0.7.0.1
 */