package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.p.a.a.a;
import com.tencent.mm.plugin.p.i;
import com.tencent.mm.sdk.sql.ISqlCondition;
import com.tencent.mm.sdk.sql.SingleCondition;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "()V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "setContactList", "(Ljava/util/ArrayList;)V", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/livelist/MMLiveList;", "setLiveList", "(Lcom/tencent/mm/plugin/livelist/MMLiveList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "app_release"})
public final class b
  extends com.tencent.mm.plugin.livelist.a.a<d>
  implements IStorageObserver<as>
{
  public static final b.a XwY;
  MMLiveList<d> Eit;
  private final f Ejb;
  private ArrayList<String> xMG;
  
  static
  {
    AppMethodBeat.i(264878);
    XwY = new b.a((byte)0);
    AppMethodBeat.o(264878);
  }
  
  public b()
  {
    AppMethodBeat.i(264877);
    this.xMG = new ArrayList();
    this.Ejb = g.ar((kotlin.g.a.a)b.XwZ);
    AppMethodBeat.o(264877);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(264872);
    p.k(paramd, "item");
    boolean bool = paramd.contact.ayh();
    AppMethodBeat.o(264872);
    return bool;
  }
  
  public final int getPriority()
  {
    return 1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(264873);
    this.xMG.clear();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(z.bcZ());
    p.j(bh.beI(), "MMCore.getAccStg()");
    Object localObject2 = c.bbU().aPi("@t.qq.com");
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(((cj)localObject2).getName());
    }
    ((ArrayList)localObject1).add("blogapp");
    ((ArrayList)localObject1).add("tmessage");
    ((ArrayList)localObject1).add("officialaccounts");
    ((ArrayList)localObject1).add("helper_entry");
    ((ArrayList)localObject1).add("weixin");
    localObject1 = ax.C_USERNAME.notInString((List)localObject1).and((ISqlCondition)ax.C_TYPE.bitAndNotEqual(64, 0)).and((ISqlCondition)ax.C_TYPE.largerEqual("64"));
    localObject2 = com.tencent.mm.plugin.p.a.a.Ejf;
    localObject1 = ((ISqlCondition)localObject1).and(a.a.eLX());
    localObject1 = ax.TABLE.select(j.listOf(ax.C_USERNAME)).log("MicroMsg.Mvvm.AddressFavorDataSource").where((ISqlCondition)localObject1);
    localObject2 = com.tencent.mm.plugin.p.a.a.Ejf;
    localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(a.a.eLW()).build().multiQuery(((i)this.Ejb.getValue()).eLT(), as.class)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (as)((Iterator)localObject1).next();
      this.xMG.add(((as)localObject2).getUsername());
    }
    AppMethodBeat.o(264873);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<i>
  {
    public static final b XwZ;
    
    static
    {
      AppMethodBeat.i(276295);
      XwZ = new b();
      AppMethodBeat.o(276295);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.b
 * JD-Core Version:    0.7.0.1
 */