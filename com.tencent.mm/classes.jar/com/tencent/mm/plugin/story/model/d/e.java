package com.tencent.mm.plugin.story.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.api.p;
import com.tencent.mm.plugin.story.api.p.a;
import com.tencent.mm.plugin.story.api.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/gallery/StoryDataSeedFactory;", "Lcom/tencent/mm/plugin/story/api/StoryDataSeed$IFactory;", "()V", "createAllFriendDataSeed", "", "userList", "", "", "filterList", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "queryCondition", "", "createFavDataSeed", "dateList", "username", "createMultiSelectFavDataSeed", "checkedList", "createNewestDataSeed", "genKey", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements p.b
{
  public static final e Smg;
  
  static
  {
    AppMethodBeat.i(118914);
    Smg = new e();
    AppMethodBeat.o(118914);
  }
  
  public final long U(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(118913);
    s.u(paramList, "userList");
    paramList = new d(cn.bDv(), paramList, paramInt);
    p.a.hvc().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118913);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, int paramInt)
  {
    AppMethodBeat.i(118911);
    s.u(paramList, "dateList");
    s.u(paramString, "username");
    paramList = new c(cn.bDv(), paramList, paramString, paramInt);
    p.a.hvc().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118911);
    return l;
  }
  
  public final long a(List<String> paramList, String paramString, Map<String, ? extends ArrayList<Long>> paramMap, ArrayList<Long> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(118912);
    s.u(paramList, "dateList");
    s.u(paramString, "username");
    s.u(paramMap, "filterList");
    s.u(paramArrayList, "checkedList");
    paramList = new c(cn.bDv(), paramList, paramString, true, paramMap, paramArrayList, paramInt);
    p.a.hvc().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118912);
    return l;
  }
  
  public final long a(List<String> paramList, Map<String, ? extends ArrayList<Long>> paramMap, int paramInt)
  {
    AppMethodBeat.i(118910);
    s.u(paramList, "userList");
    s.u(paramMap, "filterList");
    paramList = new a(cn.bDv(), paramList, paramMap, paramInt);
    p.a.hvc().a(paramList.key, (p)paramList);
    long l = paramList.key;
    AppMethodBeat.o(118910);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.e
 * JD-Core Version:    0.7.0.1
 */