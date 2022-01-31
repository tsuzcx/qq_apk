package com.tencent.mm.plugin.story.model.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.api.o.a;
import com.tencent.mm.plugin.story.api.o.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "genKey", "plugin-story_release"})
public final class d
  implements o.b
{
  public static final d syp;
  
  static
  {
    AppMethodBeat.i(109307);
    syp = new d();
    AppMethodBeat.o(109307);
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(151073);
    j.q(paramList, "dateList");
    j.q(paramString, "username");
    j.q(paramMap, "filterList");
    j.q(paramArrayList, "checkedList");
    paramList = new c(cb.abq(), paramList, paramString, true, paramMap, paramArrayList);
    o.a.czC().a(paramList.key, (o)paramList);
    long l = paramList.key;
    AppMethodBeat.o(151073);
    return l;
  }
  
  public final long c(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap)
  {
    AppMethodBeat.i(138769);
    j.q(paramList, "userList");
    j.q(paramMap, "filterList");
    paramList = new a(cb.abq(), paramList, paramMap);
    o.a.czC().a(paramList.key, (o)paramList);
    long l = paramList.key;
    AppMethodBeat.o(138769);
    return l;
  }
  
  public final long j(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(109306);
    j.q(paramList, "dateList");
    j.q(paramString, "username");
    paramList = new c(cb.abq(), paramList, paramString);
    o.a.czC().a(paramList.key, (o)paramList);
    long l = paramList.key;
    AppMethodBeat.o(109306);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.d
 * JD-Core Version:    0.7.0.1
 */