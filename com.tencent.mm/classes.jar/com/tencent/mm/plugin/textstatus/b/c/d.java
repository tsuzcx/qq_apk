package com.tencent.mm.plugin.textstatus.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.a;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/textstatus/convert/topic/SameTopicFriendData;", "list", "", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a<c>
{
  public static final d.a Tks;
  private final List<c> list;
  
  static
  {
    AppMethodBeat.i(290237);
    Tks = new d.a((byte)0);
    AppMethodBeat.o(290237);
  }
  
  public d(List<c> paramList)
  {
    AppMethodBeat.i(290236);
    this.list = paramList;
    AppMethodBeat.o(290236);
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<c>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<c> paramc)
  {
    AppMethodBeat.i(290241);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    paramc = new q();
    paramLifecycleScope.pUj.addAll((Collection)this.list);
    paramc.offer(paramLifecycleScope);
    paramLifecycleScope = k.a((f)paramc);
    AppMethodBeat.o(290241);
    return paramLifecycleScope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.c.d
 * JD-Core Version:    0.7.0.1
 */