package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.mm.plugin.mvvmlist.b;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "()V", "combine", "dataSource", "getData", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "getDataList", "", "offset", "", "pageSize", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T extends b<T>>
  implements f<T, c<T>, d<T>>
{
  public f<T, c<T>, d<T>> a(f<T, c<T>, d<T>> paramf)
  {
    s.u(paramf, "dataSource");
    return (f)new g(new f[] { (f)this, paramf });
  }
  
  public kotlinx.coroutines.b.g<d<T>> a(LifecycleScope paramLifecycleScope, c<T> paramc)
  {
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new d(paramc);
    q localq = new q();
    List localList = kj(paramc.offset, paramc.pageSize);
    if (localList != null) {
      if (localList.size() < paramc.pageSize) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      paramLifecycleScope.ABD = bool;
      paramLifecycleScope.pUj.addAll((Collection)localList);
      localq.offer(paramLifecycleScope);
      return k.a((kotlinx.coroutines.a.f)localq);
    }
  }
  
  public int getPriority()
  {
    s.u(this, "this");
    return 0;
  }
  
  public List<T> kj(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void onCreate()
  {
    s.u(this, "this");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.a
 * JD-Core Version:    0.7.0.1
 */