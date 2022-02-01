package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "()V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.plugin.mvvmlist.a.a<k>
{
  public final kotlinx.coroutines.b.g<d<k>> a(LifecycleScope paramLifecycleScope, c<k> paramc)
  {
    AppMethodBeat.i(278093);
    kotlin.g.b.s.u(paramLifecycleScope, "scope");
    kotlin.g.b.s.u(paramc, "request");
    d locald = new d(paramc);
    q localq = new q();
    paramLifecycleScope = com.tencent.mm.plugin.ac.a.MnH;
    paramLifecycleScope = (p)((f)a.a.bW(f.class)).bV(p.class);
    int i = paramc.offset;
    int j = paramc.pageSize;
    paramLifecycleScope = ey.TABLE.selectAll().log("MicroMsg.DemoStorage").limit(j, i).build().multiQuery(paramLifecycleScope.MnQ.getDB(), s.class);
    if (!((Collection)paramLifecycleScope).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label207;
      }
    }
    label121:
    ArrayList localArrayList;
    for (;;)
    {
      if (paramLifecycleScope != null)
      {
        localArrayList = locald.pUj;
        Object localObject = (Iterable)paramLifecycleScope;
        paramLifecycleScope = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramLifecycleScope.add(new k((s)((Iterator)localObject).next()));
            continue;
            i = 0;
            break;
            label207:
            paramLifecycleScope = null;
            break label121;
          }
        }
        paramLifecycleScope = (List)paramLifecycleScope;
        if (paramLifecycleScope.size() <= paramc.pageSize) {
          break label278;
        }
      }
    }
    label278:
    for (boolean bool = true;; bool = false)
    {
      locald.ABD = bool;
      paramc = ah.aiuX;
      localArrayList.addAll((Collection)paramLifecycleScope);
      localq.offer(locald);
      paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)localq);
      AppMethodBeat.o(278093);
      return paramLifecycleScope;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.j
 * JD-Core Version:    0.7.0.1
 */