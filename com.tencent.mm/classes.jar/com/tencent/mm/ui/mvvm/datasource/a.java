package com.tencent.mm.ui.mvvm.datasource;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ac.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.mvvm.a.i;
import java.util.ArrayList;
import java.util.HashSet;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/datasource/SelectContactDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;", "Lcom/tencent/mm/sdk/storage/observer/IStorageObserver;", "Lcom/tencent/mm/storage/Contact;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "contactList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getContactList", "()Ljava/util/ArrayList;", "contactSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getContactSet", "()Ljava/util/HashSet;", "dbProvider", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "getDbProvider", "()Lcom/tencent/mm/kernel/mvvm/MainDBProvider;", "dbProvider$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "getLiveList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setLiveList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "checkDataSourceCondition", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getPriority", "", "isInDataSource", "onChanged", "", "event", "Lcom/tencent/mm/sdk/storage/observer/StorageObserverEvent;", "onCreate", "Companion", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.ui.mvvm.item.b>
  implements IStorageObserver<au>
{
  public static final a.a afAu;
  private final ArrayList<String> BmO;
  private final j DHI;
  private MvvmList<com.tencent.mm.ui.mvvm.item.b> Mnt;
  private final AppCompatActivity activity;
  private final HashSet<String> afAv;
  
  static
  {
    AppMethodBeat.i(250661);
    afAu = new a.a((byte)0);
    AppMethodBeat.o(250661);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(250644);
    this.activity = paramAppCompatActivity;
    this.DHI = kotlin.k.cm((kotlin.g.a.a)b.afAw);
    this.BmO = new ArrayList();
    this.afAv = new HashSet();
    AppMethodBeat.o(250644);
  }
  
  private static boolean a(com.tencent.mm.ui.mvvm.item.b paramb)
  {
    AppMethodBeat.i(250653);
    s.u(paramb, "item");
    if ((com.tencent.mm.contact.d.rs(paramb.contact.field_type)) && (!paramb.contact.isHidden()) && (!paramb.contact.aSF()) && (!paramb.contact.iZC()))
    {
      paramb = paramb.contact.field_username;
      s.s(paramb, "item.contact.username");
      if (!kotlin.n.n.a((CharSequence)paramb, (CharSequence)"@", false))
      {
        AppMethodBeat.o(250653);
        return true;
      }
    }
    AppMethodBeat.o(250653);
    return false;
  }
  
  public final g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.ui.mvvm.item.b>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.ui.mvvm.item.b> paramc)
  {
    AppMethodBeat.i(250679);
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
        paramc = ((Iterable)((com.tencent.mm.plugin.ac.a.a)b.a.q(com.tencent.mm.plugin.ac.a.a.class)).jh((List)paramc)).iterator();
        for (;;)
        {
          if (paramc.hasNext())
          {
            Object localObject2 = (au)paramc.next();
            if ((int)((com.tencent.mm.contact.d)localObject2).maN != 0)
            {
              localObject1 = paramLifecycleScope.pUj;
              localObject2 = new com.tencent.mm.ui.mvvm.item.b((au)localObject2, 30, ((az)localObject2).field_showHead);
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
        AppMethodBeat.o(250679);
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
    AppMethodBeat.i(250673);
    this.BmO.clear();
    this.afAv.clear();
    Object localObject2 = new ArrayList();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzJ().aMh("@t.qq.com");
    if (localObject1 != null) {
      ((ArrayList)localObject2).add(((cm)localObject1).name);
    }
    ((ArrayList)localObject2).add("blogapp");
    ((ArrayList)localObject2).add("tmessage");
    ((ArrayList)localObject2).add("officialaccounts");
    ((ArrayList)localObject2).add("helper_entry");
    ((ArrayList)localObject2).add(z.bAM());
    boolean bool = com.tencent.mm.contact.b.maH.aRG();
    localObject1 = com.tencent.mm.plugin.ac.a.a.MnU;
    ISqlCondition localISqlCondition = com.tencent.mm.plugin.ac.a.a.a.gsD();
    if (bool) {}
    for (localObject1 = az.jZl.inString(p.listOf("0"));; localObject1 = az.USERNAME.notLike("'%@%'"))
    {
      localObject1 = localISqlCondition.and((ISqlCondition)localObject1).and((ISqlCondition)az.USERNAME.notInString((List)localObject2)).or((ISqlCondition)az.USERNAME.equal("weixin"));
      localObject1 = az.TABLE.select(p.listOf(az.USERNAME)).log("MicroMsg.SelectContact.SelectContactDataSource").where((ISqlCondition)localObject1);
      localObject2 = com.tencent.mm.plugin.ac.a.a.MnU;
      localObject1 = ((Iterable)((SelectSql.Builder)localObject1).orderBy(com.tencent.mm.plugin.ac.a.a.a.gsC()).build().multiQuery(((com.tencent.mm.kernel.mvvm.b)this.DHI.getValue()).getDB(), au.class)).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (au)((Iterator)localObject1).next();
        this.BmO.add(((az)localObject2).field_username);
        this.afAv.add(((az)localObject2).field_username);
      }
    }
    AppMethodBeat.o(250673);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/kernel/mvvm/MainDBProvider;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.kernel.mvvm.b>
  {
    public static final b afAw;
    
    static
    {
      AppMethodBeat.i(250647);
      afAw = new b();
      AppMethodBeat.o(250647);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.datasource.a
 * JD-Core Version:    0.7.0.1
 */