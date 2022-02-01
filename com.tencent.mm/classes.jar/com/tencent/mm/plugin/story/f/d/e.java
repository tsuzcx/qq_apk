package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.api.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"})
public final class e
  implements p.b
{
  public static final e FoL;
  
  static
  {
    AppMethodBeat.i(118914);
    FoL = new e();
    AppMethodBeat.o(118914);
  }
  
  public final long B(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(118913);
    kotlin.g.b.p.h(paramList, "userList");
    paramList = new d(cl.aWz(), paramList, paramInt);
    p.a.fns().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118913);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, int paramInt)
  {
    AppMethodBeat.i(118911);
    kotlin.g.b.p.h(paramList, "dateList");
    kotlin.g.b.p.h(paramString, "username");
    paramList = new c(cl.aWz(), paramList, paramString, paramInt);
    p.a.fns().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118911);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(118912);
    kotlin.g.b.p.h(paramList, "dateList");
    kotlin.g.b.p.h(paramString, "username");
    kotlin.g.b.p.h(paramMap, "filterList");
    kotlin.g.b.p.h(paramArrayList, "checkedList");
    paramList = new c(cl.aWz(), paramList, paramString, true, paramMap, paramArrayList, paramInt);
    p.a.fns().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118912);
    return l;
  }
  
  public final long a(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(118910);
    kotlin.g.b.p.h(paramList, "userList");
    kotlin.g.b.p.h(paramMap, "filterList");
    paramList = new a(cl.aWz(), paramList, paramMap, paramInt);
    p.a.fns().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118910);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.e
 * JD-Core Version:    0.7.0.1
 */