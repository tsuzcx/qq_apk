package com.tencent.mm.plugin.textstatus.h.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.ac;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "ALL_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getALL_CACHE", "()Ljava/util/concurrent/ConcurrentHashMap;", "ALL_CACHE$delegate", "Lkotlin/Lazy;", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "keys", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;[Ljava/lang/String;)Z", "deleteByCreateTime", "userName", "createTime", "", "deleteByStatusId", "statusId", "deleteByUserName", "doNotify", "", "name", "getAllTopic", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "excludeUserNames", "", "excludeTopicIDs", "getByStatusId", "getByTopicId", "topicId", "getHistoryItemByStatusId", "getLatest", "username", "getMostSameTopicInfo", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$PairSameTopic;", "getSameTopicInfos", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "excludeTopicId", "excludeUserName", "getStatusTotalNum", "insert", "markRead", "replace", "replaceWithoutCache", "update", "rowId", "", "Companion", "PairSameTopic", "SameTopicStruct", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MAutoStorage<b>
{
  public static final g.b TnO;
  public static final String ptT;
  private static final String[] ptU;
  private final j TnP;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(290712);
    TnO = new g.b((byte)0);
    ptT = "TextStatus";
    b.a locala = b.TnB;
    ptU = new String[] { MAutoStorage.getCreateSQLs(b.hHK(), "TextStatus") };
    AppMethodBeat.o(290712);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.hHK(), "TextStatus", null);
    AppMethodBeat.i(290702);
    this.db = paramISQLiteDatabase;
    this.TnP = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(290702);
  }
  
  public final boolean a(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(290749);
    s.u(paramb, "item");
    s.u(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)paramb, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    if (bool)
    {
      hHO().put(paramb.field_UserName, paramb);
      doNotify(paramb.field_UserName);
    }
    AppMethodBeat.o(290749);
    return bool;
  }
  
  public final void bdW(String paramString)
  {
    AppMethodBeat.i(290828);
    if (s.p(paramString, com.tencent.mm.plugin.auth.a.a.cUx()))
    {
      AppMethodBeat.o(290828);
      return;
    }
    Log.i("MicroMsg.TextStatus.TextStatusStorage", s.X("markRead ", paramString));
    paramString = bdY(paramString);
    if (paramString != null)
    {
      int i = paramString.field_state;
      b.a locala = b.TnB;
      if (i != b.hHL())
      {
        locala = b.TnB;
        paramString.field_state = b.hHL();
        a(paramString, new String[0]);
      }
    }
    AppMethodBeat.o(290828);
  }
  
  public final boolean bdX(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(290759);
    s.u(paramString, "userName");
    Log.i("MicroMsg.TextStatus.TextStatusStorage", s.X("delete ", paramString));
    if (this.db.delete(ptT, "UserName = ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      if (bool)
      {
        hHO().remove(paramString);
        doNotify(paramString);
      }
      AppMethodBeat.o(290759);
      return bool;
      bool = false;
    }
  }
  
  public final b bdY(String paramString)
  {
    AppMethodBeat.i(290789);
    if (paramString == null)
    {
      AppMethodBeat.o(290789);
      return null;
    }
    b localb = (b)hHO().get(paramString);
    if ((localb != null) && (!localb.isExpired()))
    {
      AppMethodBeat.o(290789);
      return localb;
    }
    hHO().remove(paramString);
    AppMethodBeat.o(290789);
    return null;
  }
  
  public final b bdZ(String paramString)
  {
    AppMethodBeat.i(290824);
    s.u(paramString, "statusId");
    Iterator localIterator = hHO().values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((s.p(localb.field_StatusID, paramString)) && (!localb.isExpired()))
      {
        AppMethodBeat.o(290824);
        return localb;
      }
    }
    AppMethodBeat.o(290824);
    return null;
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(290727);
    s.u(paramb, "item");
    boolean bool = super.insertNotify((IAutoDBItem)paramb, false);
    if (bool)
    {
      hHO().put(paramb.field_UserName, paramb);
      doNotify(paramb.field_UserName);
    }
    AppMethodBeat.o(290727);
    return bool;
  }
  
  public final boolean d(b paramb)
  {
    AppMethodBeat.i(290735);
    s.u(paramb, "item");
    if (super.replace((IAutoDBItem)paramb, false)) {
      doNotify(paramb.field_UserName);
    }
    AppMethodBeat.o(290735);
    return false;
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(290780);
    super.doNotify(paramString);
    AppMethodBeat.o(290780);
  }
  
  public final boolean e(b paramb)
  {
    AppMethodBeat.i(290740);
    s.u(paramb, "item");
    boolean bool = super.replace((IAutoDBItem)paramb, false);
    if (bool)
    {
      hHO().put(paramb.field_UserName, paramb);
      doNotify(paramb.field_UserName);
    }
    AppMethodBeat.o(290740);
    return bool;
  }
  
  public final ConcurrentHashMap<String, b> hHO()
  {
    AppMethodBeat.i(290721);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.TnP.getValue();
    AppMethodBeat.o(290721);
    return localConcurrentHashMap;
  }
  
  public final int hHP()
  {
    AppMethodBeat.i(290817);
    Iterator localIterator = hHO().values().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (!((b)localIterator.next()).isExpired()) {
        i += 1;
      }
    }
    AppMethodBeat.o(290817);
    return i;
  }
  
  public final boolean hq(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(290770);
    s.u(paramString, "userName");
    Log.i("MicroMsg.TextStatus.TextStatusStorage", "deleteByCreateTime " + paramString + ' ' + paramInt);
    if (this.db.delete(ptT, "UserName = ? and CreateTime<?", new String[] { paramString, String.valueOf(paramInt) }) > 0) {
      bool = true;
    }
    if (bool)
    {
      b localb = (b)hHO().get(paramString);
      if ((localb != null) && (localb.field_CreateTime < paramInt))
      {
        hHO().remove(paramString);
        doNotify(paramString);
      }
    }
    AppMethodBeat.o(290770);
    return bool;
  }
  
  public final List<c> nj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290808);
    Map localMap = (Map)new HashMap();
    Iterator localIterator = hHO().values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (b)localIterator.next();
      if ((!s.p(paramString1, ((b)localObject1).field_TopicId)) && (!s.p(paramString2, ((b)localObject1).field_UserName)))
      {
        Object localObject2;
        if ((!((b)localObject1).isExpired()) && (!TextUtils.isEmpty((CharSequence)((b)localObject1).field_TopicId)))
        {
          localObject2 = (c)localMap.get(((b)localObject1).field_TopicId);
          if (localObject2 != null) {
            break label241;
          }
          localObject2 = ((b)localObject1).field_TopicId;
          s.s(localObject2, "item.field_TopicId");
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(localObject1);
          ah localah = ah.aiuX;
          localObject2 = new c((String)localObject2, (List)localLinkedList);
          localObject1 = ((b)localObject1).field_TopicId;
          s.s(localObject1, "item.field_TopicId");
          localMap.put(localObject1, localObject2);
        }
        for (;;)
        {
          localObject1 = ((Iterable)localMap.values()).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((c)((Iterator)localObject1).next()).gfY();
          }
          break;
          label241:
          localObject2 = ((c)localObject2).bMQ;
          s.s(localObject1, "item");
          ((List)localObject2).add(localObject1);
        }
      }
    }
    paramString1 = (List)new LinkedList((Collection)p.a((Iterable)localMap.values(), (Comparator)new e()));
    AppMethodBeat.o(290808);
    return paramString1;
  }
  
  public final List<b> p(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(290800);
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      paramString = (List)localArrayList;
      AppMethodBeat.o(290800);
      return paramString;
    }
    Iterator localIterator = hHO().values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((s.p(localb.field_TopicId, paramString)) && (!localb.isExpired()) && ((paramArrayList == null) || (!paramArrayList.contains(localb.field_UserName)))) {
        localArrayList.add(localb);
      }
    }
    paramString = (List)localArrayList;
    if (paramString.size() > 1) {
      p.a(paramString, (Comparator)new d());
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(290800);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ConcurrentHashMap<String, b>>
  {
    a(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage$SameTopicStruct;", "", "topicId", "", "items", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "cloneItems", "", "isValid", "", "sort", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public List<b> bMQ;
    public String topicId;
    
    public c(String paramString, List<b> paramList)
    {
      AppMethodBeat.i(290676);
      this.topicId = paramString;
      this.bMQ = paramList;
      AppMethodBeat.o(290676);
    }
    
    public final void gfY()
    {
      AppMethodBeat.i(290690);
      this.bMQ = ((List)new LinkedList((Collection)p.a((Iterable)this.bMQ, (Comparator)new a())));
      AppMethodBeat.o(290690);
    }
    
    public final void hHQ()
    {
      AppMethodBeat.i(290694);
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((Iterable)this.bMQ).iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(((b)localIterator.next()).hHJ());
      }
      this.bMQ = ((List)localLinkedList);
      AppMethodBeat.o(290694);
    }
    
    public final boolean isValid()
    {
      AppMethodBeat.i(290683);
      if (this.bMQ.size() <= 0)
      {
        AppMethodBeat.o(290683);
        return false;
      }
      b localb = (b)this.bMQ.get(0);
      boolean bool = com.tencent.mm.plugin.textstatus.util.b.hKh().beh(localb.field_IconID);
      String str = com.tencent.mm.plugin.textstatus.util.b.hKh().f(b.b(localb));
      if ((ac.hGp()) && (s.p(localb.field_IconID, "userdefine")))
      {
        AppMethodBeat.o(290683);
        return bool;
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)str)))
      {
        AppMethodBeat.o(290683);
        return true;
      }
      AppMethodBeat.o(290683);
      return false;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(290693);
        int i = kotlin.b.a.b((Comparable)Integer.valueOf(((b)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((b)paramT1).field_CreateTime));
        AppMethodBeat.o(290693);
        return i;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class d<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(290686);
      int i = kotlin.b.a.b((Comparable)Integer.valueOf(((b)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((b)paramT1).field_CreateTime));
      AppMethodBeat.o(290686);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class e<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      int j = 0;
      AppMethodBeat.i(290698);
      paramT2 = (g.c)paramT2;
      if (paramT2.bMQ.size() > 0) {}
      for (int i = ((b)paramT2.bMQ.get(0)).field_CreateTime;; i = 0)
      {
        paramT2 = (Comparable)Integer.valueOf(i);
        paramT1 = (g.c)paramT1;
        i = j;
        if (paramT1.bMQ.size() > 0) {
          i = ((b)paramT1.bMQ.get(0)).field_CreateTime;
        }
        i = kotlin.b.a.b(paramT2, (Comparable)Integer.valueOf(i));
        AppMethodBeat.o(290698);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.g
 * JD-Core Version:    0.7.0.1
 */