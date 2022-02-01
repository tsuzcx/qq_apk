package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.api.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"})
public final class e
  implements p.b
{
  public static final e LIN;
  
  static
  {
    AppMethodBeat.i(118914);
    LIN = new e();
    AppMethodBeat.o(118914);
  }
  
  public final long C(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(118913);
    kotlin.g.b.p.k(paramList, "userList");
    paramList = new d(cm.bfD(), paramList, paramInt);
    p.a.gbL().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118913);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, int paramInt)
  {
    AppMethodBeat.i(118911);
    kotlin.g.b.p.k(paramList, "dateList");
    kotlin.g.b.p.k(paramString, "username");
    paramList = new c(cm.bfD(), paramList, paramString, paramInt);
    p.a.gbL().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118911);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(118912);
    kotlin.g.b.p.k(paramList, "dateList");
    kotlin.g.b.p.k(paramString, "username");
    kotlin.g.b.p.k(paramMap, "filterList");
    kotlin.g.b.p.k(paramArrayList, "checkedList");
    paramList = new c(cm.bfD(), paramList, paramString, true, paramMap, paramArrayList, paramInt);
    p.a.gbL().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118912);
    return l;
  }
  
  public final long a(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(118910);
    kotlin.g.b.p.k(paramList, "userList");
    kotlin.g.b.p.k(paramMap, "filterList");
    paramList = new a(cm.bfD(), paramList, paramMap, paramInt);
    p.a.gbL().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118910);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.e
 * JD-Core Version:    0.7.0.1
 */