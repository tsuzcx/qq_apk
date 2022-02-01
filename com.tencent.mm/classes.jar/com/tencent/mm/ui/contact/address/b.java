package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleCondition;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "()V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "setContactList", "(Ljava/util/ArrayList;)V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.mvvmlist.a.a<d>
  implements IStorageObserver<au>
{
  public static final b.a afjb;
  private ArrayList<String> BmO;
  private final j DHI;
  MvvmList<d> Mnt;
  
  static
  {
    AppMethodBeat.i(253245);
    afjb = new b.a((byte)0);
    AppMethodBeat.o(253245);
  }
  
  public b()
  {
    AppMethodBeat.i(253236);
    this.BmO = new ArrayList();
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.afjc);
    AppMethodBeat.o(253236);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(253241);
    s.u(paramd, "item");
    boolean bool = paramd.contact.aSK();
    AppMethodBeat.o(253241);
    return bool;
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<d>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<d> paramc)
  {
    AppMethodBeat.i(253265);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
    q localq = new q();
    int j = paramc.offset;
    int i = paramc.pageSize;
    if (j < this.BmO.size()) {
      if (this.BmO.size() > j + i)
      {
        paramLifecycleScope.ABD = true;
        i += j;
        paramc = new ArrayList();
        if (j >= i) {}
      }
    }
    for (;;)
    {
      int k = j + 1;
      paramc.add(this.BmO.get(j));
      if (k >= i)
      {
        Object localObject = com.tencent.mm.plugin.ac.b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)com.tencent.mm.plugin.ac.b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
            {
              paramLifecycleScope.pUj.add(new d((au)localObject, 1, 32));
              continue;
              i = this.BmO.size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(253265);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return 1;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(253255);
    this.BmO.clear();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(z.bAM());
    bh.bCz();
    Object localObject2 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(((cm)localObject2).name);
    }
    ((ArrayList)localObject1).add("blogapp");
    ((ArrayList)localObject1).add("tmessage");
    ((ArrayList)localObject1).add("officialaccounts");
    ((ArrayList)localObject1).add("helper_entry");
    ((ArrayList)localObject1).add("weixin");
    localObject1 = az.USERNAME.notInString((List)localObject1).and((ISqlCondition)az.TYPE.bitAndNotEqual(64, 0)).and((ISqlCondition)az.TYPE.largerEqual("64"));
    localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
    localObject1 = ((ISqlCondition)localObject1).and(a.a.gsD());
    localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("MicroMsg.Mvvm.AddressFavorDataSource").where((ISqlCondition)localObject1);
    localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
    localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(a.a.gsC()).build().multiQuery(((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB(), au.class)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (au)((Iterator)localObject1).next();
      this.BmO.add(((az)localObject2).field_username);
    }
    AppMethodBeat.o(253255);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b afjc;
    
    static
    {
      AppMethodBeat.i(253225);
      afjc = new b();
      AppMethodBeat.o(253225);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.b
 * JD-Core Version:    0.7.0.1
 */