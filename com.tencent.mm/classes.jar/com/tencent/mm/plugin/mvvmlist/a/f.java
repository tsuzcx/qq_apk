package com.tencent.mm.plugin.mvvmlist.a;

import com.tencent.mm.plugin.mvvmlist.b;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import kotlin.Metadata;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "Req", "Resp", "", "checkDataSourceCondition", "", "item", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Z", "combine", "dataSource", "getData", "Lkotlinx/coroutines/flow/Flow;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "(Lcom/tencent/mm/sdk/coroutines/LifecycleScope;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "getPriority", "", "isInDataSource", "onCreate", "", "plugin-mvvmlist_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f<T extends b<T>, Req, Resp>
{
  public abstract g<Resp> a(LifecycleScope paramLifecycleScope, Req paramReq);
  
  public abstract int getPriority();
  
  public abstract void onCreate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mvvmlist.a.f
 * JD-Core Version:    0.7.0.1
 */