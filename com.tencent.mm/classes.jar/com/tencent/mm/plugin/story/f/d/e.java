package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.api.p.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"})
public final class e
  implements p.b
{
  public static final e yhx;
  
  static
  {
    AppMethodBeat.i(118914);
    yhx = new e();
    AppMethodBeat.o(118914);
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(118912);
    k.h(paramList, "dateList");
    k.h(paramString, "username");
    k.h(paramMap, "filterList");
    k.h(paramArrayList, "checkedList");
    paramList = new c(ce.asR(), paramList, paramString, true, paramMap, paramArrayList, paramInt);
    p.a.dGt().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118912);
    return l;
  }
  
  public final long a(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(118910);
    k.h(paramList, "userList");
    k.h(paramMap, "filterList");
    paramList = new a(ce.asR(), paramList, paramMap, paramInt);
    p.a.dGt().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118910);
    return l;
  }
  
  public final long b(List<String> paramList, String paramString, int paramInt)
  {
    AppMethodBeat.i(118911);
    k.h(paramList, "dateList");
    k.h(paramString, "username");
    paramList = new c(ce.asR(), paramList, paramString, paramInt);
    p.a.dGt().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118911);
    return l;
  }
  
  public final long t(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(118913);
    k.h(paramList, "userList");
    paramList = new d(ce.asR(), paramList, paramInt);
    p.a.dGt().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118913);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.e
 * JD-Core Version:    0.7.0.1
 */