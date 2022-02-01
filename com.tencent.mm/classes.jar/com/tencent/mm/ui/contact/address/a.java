package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.p.i;
import com.tencent.mm.sdk.sql.ISqlCondition;
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
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "()V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "setContactList", "(Ljava/util/ArrayList;)V", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/livelist/MMLiveList;", "setLiveList", "(Lcom/tencent/mm/plugin/livelist/MMLiveList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.plugin.livelist.a.a<d>
  implements IStorageObserver<as>
{
  public static final a.a XwW;
  MMLiveList<d> Eit;
  private final f Ejb;
  private ArrayList<String> xMG;
  
  static
  {
    AppMethodBeat.i(286720);
    XwW = new a.a((byte)0);
    AppMethodBeat.o(286720);
  }
  
  public a()
  {
    AppMethodBeat.i(286719);
    this.Ejb = g.ar((kotlin.g.a.a)b.XwX);
    this.xMG = new ArrayList();
    AppMethodBeat.o(286719);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(286714);
    p.k(paramd, "item");
    if ((paramd.contact.axZ()) && (!paramd.contact.isHidden()) && (!paramd.contact.ayc()) && (!paramd.contact.hxX()))
    {
      paramd = paramd.contact.getUsername();
      p.j(paramd, "item.contact.username");
      if (!n.a((CharSequence)paramd, (CharSequence)"@", false))
      {
        AppMethodBeat.o(286714);
        return true;
      }
    }
    AppMethodBeat.o(286714);
    return false;
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(286715);
    this.xMG.clear();
    Object localObject2 = new ArrayList();
    p.j(bh.beI(), "MMCore.getAccStg()");
    Object localObject1 = c.bbU().aPi("@t.qq.com");
    if (localObject1 != null) {
      ((ArrayList)localObject2).add(((cj)localObject1).getName());
    }
    ((ArrayList)localObject2).add("blogapp");
    ((ArrayList)localObject2).add("tmessage");
    ((ArrayList)localObject2).add("officialaccounts");
    ((ArrayList)localObject2).add("helper_entry");
    boolean bool = b.jxn.axg();
    localObject1 = com.tencent.mm.plugin.p.a.a.Ejf;
    ISqlCondition localISqlCondition = com.tencent.mm.plugin.p.a.a.a.eLX();
    if (bool) {}
    for (localObject1 = ax.hCp.inString(j.listOf("0"));; localObject1 = ax.C_USERNAME.notLike("'%@%'"))
    {
      localObject1 = localISqlCondition.and((ISqlCondition)localObject1).and((ISqlCondition)ax.C_USERNAME.notInString((List)localObject2)).or((ISqlCondition)ax.C_USERNAME.equal("weixin"));
      localObject1 = ax.TABLE.select(j.listOf(ax.C_USERNAME)).log("MicroMsg.Mvvm.AddressDataSource").where((ISqlCondition)localObject1);
      localObject2 = com.tencent.mm.plugin.p.a.a.Ejf;
      localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(com.tencent.mm.plugin.p.a.a.a.eLW()).build().multiQuery(((i)this.Ejb.getValue()).eLT(), as.class)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        this.xMG.add(((as)localObject2).getUsername());
      }
    }
    AppMethodBeat.o(286715);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<i>
  {
    public static final b XwX;
    
    static
    {
      AppMethodBeat.i(265938);
      XwX = new b();
      AppMethodBeat.o(265938);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.a
 * JD-Core Version:    0.7.0.1
 */