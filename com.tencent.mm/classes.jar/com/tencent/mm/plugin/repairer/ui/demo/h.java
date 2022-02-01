package com.tencent.mm.plugin.repairer.ui.demo;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.d;
import com.tencent.mm.plugin.ac.g.a;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem1;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "liveData", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveData", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "storage", "Lcom/tencent/mm/plugin/mvvmcomm/DefaultMvvmStorage;", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo1;", "getStorage", "()Lcom/tencent/mm/plugin/mvvmcomm/DefaultMvvmStorage;", "getDataList", "", "offset", "", "pageSize", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.mvvmlist.a.a<l>
{
  final MvvmList<l> MmE;
  private final com.tencent.mm.plugin.ab.b<t, l> OwJ;
  
  public h(e parame, q paramq)
  {
    AppMethodBeat.i(278105);
    this.MmE = new MvvmList((f)this, parame, paramq);
    parame = v.gNl();
    if (parame == null) {}
    for (parame = null;; parame = parame.a(this.MmE))
    {
      this.OwJ = parame;
      this.MmE.delay = 1L;
      parame = this.OwJ;
      if (parame != null) {
        parame.MmF = ((kotlin.g.a.b)1.OwK);
      }
      AppMethodBeat.o(278105);
      return;
    }
  }
  
  public final List<l> kj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(278118);
    Object localObject1 = com.tencent.mm.plugin.ac.a.MnH;
    localObject1 = ((g)a.a.bW(g.class)).omV;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.ab.b.MmD;
      localObject1 = (IMvvmDBProvider)new c((ISQLiteDatabase)localObject1);
      localObject2 = com.tencent.mm.plugin.ac.g.MnP;
      ((com.tencent.mm.plugin.ab.b)g.a.a(com.tencent.mm.plugin.ab.b.class, (IMvvmDBProvider)localObject1)).a(this.MmE);
    }
    localObject1 = ey.TABLE.selectAll().log("MicroMsg.DemoStorage").limit(paramInt2, paramInt1).build();
    Object localObject2 = com.tencent.mm.plugin.ac.a.MnH;
    localObject2 = (Iterable)((SelectSql)localObject1).multiQuery((ISQLiteDatabase)((g)a.a.bW(g.class)).omV, t.class);
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((t)((Iterator)localObject2).next()));
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(278118);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.h
 * JD-Core Version:    0.7.0.1
 */