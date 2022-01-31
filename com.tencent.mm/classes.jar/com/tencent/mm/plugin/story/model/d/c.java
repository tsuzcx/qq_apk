package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/FavStoryDataSeed;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed;", "key", "", "dateList", "", "", "username", "isMultiSelected", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "checkedList", "(JLjava/util/List;Ljava/lang/String;ZLjava/util/Map;Ljava/util/ArrayList;)V", "getCheckedList", "()Ljava/util/ArrayList;", "getDateList", "()Ljava/util/List;", "getFilterList", "()Ljava/util/Map;", "()Z", "getUsername", "()Ljava/lang/String;", "plugin-story_release"})
public final class c
  extends o
{
  public final boolean qLh;
  public final Map<String, ArrayList<Long>> sym;
  final List<String> syn;
  public final ArrayList<Long> syo;
  public final String username;
  
  public c(long paramLong, List<String> paramList, String paramString, boolean paramBoolean, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList)
  {
    super(paramLong);
    AppMethodBeat.i(151072);
    this.syn = paramList;
    this.username = paramString;
    this.qLh = paramBoolean;
    this.sym = paramMap;
    this.syo = paramArrayList;
    AppMethodBeat.o(151072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.c
 * JD-Core Version:    0.7.0.1
 */