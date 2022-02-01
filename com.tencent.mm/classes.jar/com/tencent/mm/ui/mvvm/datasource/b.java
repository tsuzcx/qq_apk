package com.tencent.mm.ui.mvvm.datasource;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleCondition;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.mvvm.a.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/datasource/SelectContactFavorDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "setContactList", "(Ljava/util/ArrayList;)V", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.ui.mvvm.item.b>
  implements IStorageObserver<au>
{
  public static final b.a afAx;
  private ArrayList<String> BmO;
  private final j DHI;
  private MvvmList<com.tencent.mm.ui.mvvm.item.b> Mnt;
  private final AppCompatActivity activity;
  
  static
  {
    AppMethodBeat.i(250675);
    afAx = new b.a((byte)0);
    AppMethodBeat.o(250675);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(250663);
    this.activity = paramAppCompatActivity;
    this.BmO = new ArrayList();
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.afAy);
    AppMethodBeat.o(250663);
  }
  
  private static boolean a(com.tencent.mm.ui.mvvm.item.b paramb)
  {
    AppMethodBeat.i(250670);
    s.u(paramb, "item");
    boolean bool = paramb.contact.aSK();
    AppMethodBeat.o(250670);
    return bool;
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.ui.mvvm.item.b> paramc)
  {
    AppMethodBeat.i(250693);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = com.tencent.mm.ui.component.k.aeZF;
    s.s(com.tencent.mm.ui.component.k.d(this.activity).q(com.tencent.mm.ui.mvvm.b.c.class), "UICProvider.of(activity)…ntactDataUIC::class.java)");
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
        Object localObject1 = com.tencent.mm.plugin.ac.b.MnM;
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)com.tencent.mm.plugin.ac.b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            Object localObject2 = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject2).maN != 0)
            {
              localObject1 = paramLifecycleScope.pUj;
              localObject2 = new com.tencent.mm.ui.mvvm.item.b((au)localObject2, 20, 32);
              if ((this.activity instanceof BaseMvvmActivity))
              {
                localObject3 = ((BaseMvvmActivity)this.activity).getStateCenter();
                if (localObject3 != null)
                {
                  localObject3 = (i)((UIStateCenter)localObject3).getState();
                  if (localObject3 != null)
                  {
                    ((com.tencent.mm.ui.mvvm.item.b)localObject2).afey = ((i)localObject3).gZe();
                    String str = ((com.tencent.mm.ui.mvvm.item.b)localObject2).contact.field_username;
                    s.s(str, "item.contact.username");
                    ((com.tencent.mm.ui.mvvm.item.b)localObject2).wwJ = ((i)localObject3).bCr(str);
                  }
                }
              }
              Object localObject3 = ah.aiuX;
              ((ArrayList)localObject1).add(localObject2);
              continue;
              i = this.BmO.size();
              break;
            }
          }
        }
        localq.offer(paramLifecycleScope);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((f)localq);
        AppMethodBeat.o(250693);
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
    AppMethodBeat.i(250683);
    this.BmO.clear();
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(z.bAM());
    Object localObject2 = ((n)h.ax(n.class)).bzJ().aMh("@t.qq.com");
    if (localObject2 != null) {
      ((ArrayList)localObject1).add(((cm)localObject2).name);
    }
    ((ArrayList)localObject1).add("blogapp");
    ((ArrayList)localObject1).add("tmessage");
    ((ArrayList)localObject1).add("officialaccounts");
    ((ArrayList)localObject1).add("helper_entry");
    localObject1 = az.USERNAME.notInString((List)localObject1).and((ISqlCondition)az.TYPE.bitAndNotEqual(64, 0)).and((ISqlCondition)az.TYPE.largerEqual("64"));
    localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
    localObject1 = ((ISqlCondition)localObject1).and(a.a.gsD());
    localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("MicroMsg.SelectContact.SelectContactFavorDataSource").where((ISqlCondition)localObject1);
    localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
    localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(a.a.gsC()).build().multiQuery(((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB(), au.class)).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (au)((Iterator)localObject1).next();
      this.BmO.add(((az)localObject2).field_username);
    }
    AppMethodBeat.o(250683);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b afAy;
    
    static
    {
      AppMethodBeat.i(250620);
      afAy = new b();
      AppMethodBeat.o(250620);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.datasource.b
 * JD-Core Version:    0.7.0.1
 */