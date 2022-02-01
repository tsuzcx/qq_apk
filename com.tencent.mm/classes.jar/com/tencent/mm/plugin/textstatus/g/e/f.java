package com.tencent.mm.plugin.textstatus.g.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "ALL_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getALL_CACHE", "()Ljava/util/concurrent/ConcurrentHashMap;", "ALL_CACHE$delegate", "Lkotlin/Lazy;", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "keys", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;[Ljava/lang/String;)Z", "deleteByCreateTime", "userName", "createTime", "", "deleteByStatusId", "statusId", "deleteByUserName", "doNotify", "", "name", "getAllTopic", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "excludeUserNames", "", "excludeTopicIDs", "getByStatusId", "getByTopicId", "topicId", "getLatest", "username", "getMostSameTopicInfo", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$PairSameTopic;", "getSameTopicInfos", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "excludeTopicId", "excludeUserName", "getStatusTotalNum", "insert", "markRead", "replace", "update", "rowId", "", "Companion", "PairSameTopic", "SameTopicStruct", "plugin-textstatus_release"})
public final class f
  extends MAutoStorage<a>
{
  public static final String Alf = "TextStatus";
  private static final String[] MDY;
  public static final f.b MEd;
  private final kotlin.f MEc;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(234881);
    MEd = new f.b((byte)0);
    Alf = "TextStatus";
    a.a locala = a.MDU;
    MDY = new String[] { MAutoStorage.getCreateSQLs(a.gmb(), "TextStatus") };
    AppMethodBeat.o(234881);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.gmb(), "TextStatus", null);
    AppMethodBeat.i(234880);
    this.db = paramISQLiteDatabase;
    this.MEc = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(234880);
  }
  
  public final LinkedHashMap<String, ArrayList<a>> A(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(234877);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = gmf().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((!paramList1.contains(locala.field_UserName)) && (!paramList2.contains(locala.field_TopicId)) && (!locala.isExpired()))
      {
        if (!((Map)localLinkedHashMap).containsKey(locala.field_TopicId)) {
          localLinkedHashMap.put(locala.field_TopicId, new ArrayList());
        }
        ArrayList localArrayList = (ArrayList)localLinkedHashMap.get(locala.field_TopicId);
        if (localArrayList != null) {
          localArrayList.add(locala);
        }
      }
    }
    AppMethodBeat.o(234877);
    return localLinkedHashMap;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(234857);
    p.k(parama, "item");
    boolean bool = super.insertNotify((IAutoDBItem)parama, false);
    if (bool)
    {
      gmf().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(234857);
    return bool;
  }
  
  public final boolean a(a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(234861);
    p.k(parama, "item");
    p.k(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)parama, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    if (bool)
    {
      gmf().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(234861);
    return bool;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(234859);
    p.k(parama, "item");
    boolean bool = super.replace((IAutoDBItem)parama, false);
    if (bool)
    {
      gmf().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(234859);
    return bool;
  }
  
  public final void bew(String paramString)
  {
    AppMethodBeat.i(234879);
    p.k(paramString, "userName");
    if (p.h(paramString, com.tencent.mm.plugin.auth.a.a.crN()))
    {
      AppMethodBeat.o(234879);
      return;
    }
    Log.i("MicroMsg.TextStatus.TextStatusStorage", "markRead ".concat(String.valueOf(paramString)));
    paramString = bey(paramString);
    if (paramString != null)
    {
      int i = paramString.field_state;
      a.a locala = a.MDU;
      if (i != a.gmc())
      {
        locala = a.MDU;
        paramString.field_state = a.gmc();
        a(paramString, new String[0]);
      }
      AppMethodBeat.o(234879);
      return;
    }
    AppMethodBeat.o(234879);
  }
  
  public final boolean bex(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(234865);
    p.k(paramString, "userName");
    Log.i("MicroMsg.TextStatus.TextStatusStorage", "delete ".concat(String.valueOf(paramString)));
    if (this.db.delete(Alf, "UserName = ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      if (bool)
      {
        gmf().remove(paramString);
        doNotify(paramString);
      }
      AppMethodBeat.o(234865);
      return bool;
      bool = false;
    }
  }
  
  public final a bey(String paramString)
  {
    AppMethodBeat.i(234869);
    p.k(paramString, "username");
    a locala = (a)gmf().get(paramString);
    if ((locala != null) && (!locala.isExpired()))
    {
      AppMethodBeat.o(234869);
      return locala;
    }
    gmf().remove(paramString);
    AppMethodBeat.o(234869);
    return null;
  }
  
  public final a bez(String paramString)
  {
    AppMethodBeat.i(234874);
    p.k(paramString, "statusId");
    Iterator localIterator = gmf().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((p.h(locala.field_StatusID, paramString)) && (!locala.isExpired()))
      {
        AppMethodBeat.o(234874);
        return locala;
      }
    }
    AppMethodBeat.o(234874);
    return null;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(234867);
    super.doNotify(paramString);
    AppMethodBeat.o(234867);
  }
  
  public final ConcurrentHashMap<String, a> gmf()
  {
    AppMethodBeat.i(234856);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.MEc.getValue();
    AppMethodBeat.o(234856);
    return localConcurrentHashMap;
  }
  
  public final int gmg()
  {
    AppMethodBeat.i(234873);
    Iterator localIterator = gmf().values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (((a)localIterator.next()).isExpired()) {
        break label60;
      }
      i += 1;
    }
    label60:
    for (;;)
    {
      break;
      AppMethodBeat.o(234873);
      return i;
    }
  }
  
  public final boolean gu(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(234866);
    p.k(paramString, "userName");
    Log.i("MicroMsg.TextStatus.TextStatusStorage", "deleteByCreateTime " + paramString + ' ' + paramInt);
    if (this.db.delete(Alf, "UserName = ? and CreateTime<?", new String[] { paramString, String.valueOf(paramInt) }) > 0) {
      bool = true;
    }
    if (bool)
    {
      a locala = (a)gmf().get(paramString);
      if ((locala != null) && (locala.field_CreateTime < paramInt))
      {
        gmf().remove(paramString);
        doNotify(paramString);
      }
    }
    AppMethodBeat.o(234866);
    return bool;
  }
  
  public final List<c> lA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234872);
    Map localMap = (Map)new HashMap();
    Iterator localIterator = gmf().values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (a)localIterator.next();
      if ((!p.h(paramString1, ((a)localObject1).field_TopicId)) && (!p.h(paramString2, ((a)localObject1).field_UserName)) && (!((a)localObject1).isExpired()) && (!TextUtils.isEmpty((CharSequence)((a)localObject1).field_TopicId)))
      {
        Object localObject2 = (c)localMap.get(((a)localObject1).field_TopicId);
        if (localObject2 == null)
        {
          localObject2 = ((a)localObject1).field_TopicId;
          p.j(localObject2, "item.field_TopicId");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(localObject1);
          localObject2 = new c((String)localObject2, (List)localLinkedList);
          localObject1 = ((a)localObject1).field_TopicId;
          p.j(localObject1, "item.field_TopicId");
          localMap.put(localObject1, localObject2);
        }
        else
        {
          localObject2 = ((c)localObject2).lxh;
          p.j(localObject1, "item");
          ((List)localObject2).add(localObject1);
        }
      }
    }
    paramString1 = (List)new LinkedList((Collection)j.a((Iterable)localMap.values(), (Comparator)new e()));
    AppMethodBeat.o(234872);
    return paramString1;
  }
  
  public final List<a> o(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(234871);
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      paramString = (List)localArrayList;
      AppMethodBeat.o(234871);
      return paramString;
    }
    Iterator localIterator = gmf().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((p.h(locala.field_TopicId, paramString)) && (!locala.isExpired()) && ((paramArrayList == null) || (!paramArrayList.contains(locala.field_UserName)))) {
        localArrayList.add(locala);
      }
    }
    paramString = (List)localArrayList;
    if (paramString.size() > 1) {
      j.a(paramString, (Comparator)new f.d());
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(234871);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ConcurrentHashMap<String, a>>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "", "topicId", "", "items", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "isValid", "", "plugin-textstatus_release"})
  public static final class c
  {
    public List<a> lxh;
    public String topicId;
    
    public c(String paramString, List<a> paramList)
    {
      AppMethodBeat.i(233685);
      this.topicId = paramString;
      this.lxh = paramList;
      AppMethodBeat.o(233685);
    }
    
    public final boolean isValid()
    {
      AppMethodBeat.i(233682);
      if (this.lxh.size() <= 0)
      {
        AppMethodBeat.o(233682);
        return false;
      }
      Object localObject = (a)this.lxh.get(0);
      boolean bool = c.gnz().beI(((a)localObject).field_IconID);
      localObject = c.gnz().d(((a)localObject).glY());
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        AppMethodBeat.o(233682);
        return true;
      }
      AppMethodBeat.o(233682);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class e<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(236919);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((f.c)paramT2).lxh.size()), (Comparable)Integer.valueOf(((f.c)paramT1).lxh.size()));
      AppMethodBeat.o(236919);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.f
 * JD-Core Version:    0.7.0.1
 */