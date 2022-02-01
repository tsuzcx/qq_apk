package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", "username", "isMultiSelected", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedList", "queryCondition", "", "(JLjava/util/List;Ljava/lang/String;ZLjava/util/Map;Ljava/util/ArrayList;I)V", "getCheckedList", "()Ljava/util/ArrayList;", "getDateList", "()Ljava/util/List;", "getFilterList", "()Ljava/util/Map;", "()Z", "getUsername", "()Ljava/lang/String;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends p
{
  public final boolean Pxk;
  public final Map<String, ArrayList<Long>> Smd;
  final List<String> Sme;
  public final ArrayList<Long> Smf;
  public final String username;
  
  public c(long paramLong, List<String> paramList, String paramString, boolean paramBoolean, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    super(paramLong, paramInt);
    AppMethodBeat.i(118907);
    this.Sme = paramList;
    this.username = paramString;
    this.Pxk = paramBoolean;
    this.Smd = paramMap;
    this.Smf = paramArrayList;
    AppMethodBeat.o(118907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.c
 * JD-Core Version:    0.7.0.1
 */