package com.tencent.mm.plugin.story.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.api.p.b;
import d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"})
public final class e
  implements p.b
{
  public static final e AMs;
  
  static
  {
    AppMethodBeat.i(118914);
    AMs = new e();
    AppMethodBeat.o(118914);
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(118912);
    d.g.b.p.h(paramList, "dateList");
    d.g.b.p.h(paramString, "username");
    d.g.b.p.h(paramMap, "filterList");
    d.g.b.p.h(paramArrayList, "checkedList");
    paramList = new c(cf.aCL(), paramList, paramString, true, paramMap, paramArrayList, paramInt);
    p.a.ehj().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118912);
    return l;
  }
  
  public final long a(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(118910);
    d.g.b.p.h(paramList, "userList");
    d.g.b.p.h(paramMap, "filterList");
    paramList = new a(cf.aCL(), paramList, paramMap, paramInt);
    p.a.ehj().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118910);
    return l;
  }
  
  public final long b(List<String> paramList, String paramString, int paramInt)
  {
    AppMethodBeat.i(118911);
    d.g.b.p.h(paramList, "dateList");
    d.g.b.p.h(paramString, "username");
    paramList = new c(cf.aCL(), paramList, paramString, paramInt);
    p.a.ehj().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118911);
    return l;
  }
  
  public final long v(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(118913);
    d.g.b.p.h(paramList, "userList");
    paramList = new d(cf.aCL(), paramList, paramInt);
    p.a.ehj().a(paramList.key, (com.tencent.mm.plugin.story.api.p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118913);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.d.e
 * JD-Core Version:    0.7.0.1
 */