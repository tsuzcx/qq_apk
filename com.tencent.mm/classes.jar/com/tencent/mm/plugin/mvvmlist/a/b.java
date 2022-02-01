package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.mm.plugin.mvvmlist.h;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Q", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "()V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getSearchData", "Lcom/tencent/mm/plugin/mvvmlist/SearchDataRequest;", "stopSearch", "", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<T extends com.tencent.mm.plugin.mvvmlist.b<T>, Q>
  extends a<T>
{
  public final g<d<T>> a(LifecycleScope paramLifecycleScope, c<T> paramc)
  {
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    return a(paramLifecycleScope, (h)paramc);
  }
  
  public abstract g<d<T>> a(LifecycleScope paramLifecycleScope, h<T, Q> paramh);
  
  public abstract void eui();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.b
 * JD-Core Version:    0.7.0.1
 */