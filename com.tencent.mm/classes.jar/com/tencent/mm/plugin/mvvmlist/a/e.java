package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.b;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/EmptyDataSource;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "()V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T extends b<T>>
  extends a<T>
{
  public final g<d<T>> a(LifecycleScope paramLifecycleScope, c<T> paramc)
  {
    AppMethodBeat.i(278746);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new q();
    paramLifecycleScope.offer(new d(paramc));
    paramLifecycleScope = k.a((f)paramLifecycleScope);
    AppMethodBeat.o(278746);
    return paramLifecycleScope;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.e
 * JD-Core Version:    0.7.0.1
 */