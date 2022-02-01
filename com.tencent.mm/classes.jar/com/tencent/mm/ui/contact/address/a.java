package com.tencent.mm.ui.contact.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
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
import kotlin.n.n;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "()V", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "setContactList", "(Ljava/util/ArrayList;)V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a.a<d>
  implements IStorageObserver<au>
{
  public static final a.a afiZ;
  private ArrayList<String> BmO;
  private final j DHI;
  MvvmList<d> Mnt;
  
  static
  {
    AppMethodBeat.i(253260);
    afiZ = new a.a((byte)0);
    AppMethodBeat.o(253260);
  }
  
  public a()
  {
    AppMethodBeat.i(253246);
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.afja);
    this.BmO = new ArrayList();
    AppMethodBeat.o(253246);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(253251);
    s.u(paramd, "item");
    if ((com.tencent.mm.contact.d.rs(paramd.contact.field_type)) && (!paramd.contact.isHidden()) && (!paramd.contact.aSF()) && (!paramd.contact.iZC()))
    {
      paramd = paramd.contact.field_username;
      s.s(paramd, "item.contact.username");
      if (!n.a((CharSequence)paramd, (CharSequence)"@", false))
      {
        AppMethodBeat.o(253251);
        return true;
      }
    }
    AppMethodBeat.o(253251);
    return false;
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<d>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<d> paramc)
  {
    AppMethodBeat.i(253275);
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
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            localObject = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject).maN != 0)
            {
              paramLifecycleScope.pUj.add(new d((au)localObject, 2, ((az)localObject).field_showHead));
              continue;
              i = this.BmO.size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(253275);
        return paramLifecycleScope;
      }
      j = k;
    }
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(253268);
    this.BmO.clear();
    Object localObject2 = new ArrayList();
    bh.bCz();
    Object localObject1 = com.tencent.mm.model.c.bzJ().aMh("@t.qq.com");
    if (localObject1 != null) {
      ((ArrayList)localObject2).add(((cm)localObject1).name);
    }
    ((ArrayList)localObject2).add("blogapp");
    ((ArrayList)localObject2).add("tmessage");
    ((ArrayList)localObject2).add("officialaccounts");
    ((ArrayList)localObject2).add("helper_entry");
    boolean bool = com.tencent.mm.contact.b.maH.aRG();
    localObject1 = com.tencent.mm.plugin.ac.a.a.MnU;
    ISqlCondition localISqlCondition = com.tencent.mm.plugin.ac.a.a.a.gsD();
    if (bool) {}
    for (localObject1 = az.jZl.inString(p.listOf("0"));; localObject1 = az.USERNAME.notLike("'%@%'"))
    {
      localObject1 = localISqlCondition.and((ISqlCondition)localObject1).and((ISqlCondition)az.USERNAME.notInString((List)localObject2)).or((ISqlCondition)az.USERNAME.equal("weixin"));
      localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("MicroMsg.Mvvm.AddressDataSource").where((ISqlCondition)localObject1);
      localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
      localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(com.tencent.mm.plugin.ac.a.a.a.gsC()).build().multiQuery(((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB(), au.class)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (au)((Iterator)localObject1).next();
        this.BmO.add(((az)localObject2).field_username);
      }
    }
    AppMethodBeat.o(253268);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b afja;
    
    static
    {
      AppMethodBeat.i(253261);
      afja = new b();
      AppMethodBeat.o(253261);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.a
 * JD-Core Version:    0.7.0.1
 */