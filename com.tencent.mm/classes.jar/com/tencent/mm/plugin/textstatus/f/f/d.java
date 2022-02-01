package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "ALL_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getALL_CACHE", "()Ljava/util/concurrent/ConcurrentHashMap;", "ALL_CACHE$delegate", "Lkotlin/Lazy;", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "delete", "", "item", "keys", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;[Ljava/lang/String;)Z", "deleteByCreateTime", "userName", "createTime", "", "deleteByStatusId", "statusId", "deleteByUserName", "getAllTopic", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "excludeUserNames", "", "excludeTopicIDs", "getByStatusId", "getByTopicId", "topicId", "getLatest", "username", "insert", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"})
public final class d
  extends MAutoStorage<a>
{
  private static final String[] FZH;
  public static final d.b FZK;
  public static final String TABLE = "TextStatus";
  private final f FZJ;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(216285);
    FZK = new d.b((byte)0);
    TABLE = "TextStatus";
    a.a locala = a.FZD;
    FZH = new String[] { MAutoStorage.getCreateSQLs(a.fvW(), "TextStatus") };
    AppMethodBeat.o(216285);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.fvW(), "TextStatus", null);
    AppMethodBeat.i(216284);
    this.db = paramISQLiteDatabase;
    this.FZJ = g.ah((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(216284);
  }
  
  public final boolean a(a parama, String... paramVarArgs)
  {
    AppMethodBeat.i(216275);
    p.h(parama, "item");
    p.h(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)parama, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    if (bool)
    {
      gWL().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(216275);
    return bool;
  }
  
  public final boolean aTk(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(216279);
    p.h(paramString, "userName");
    Log.i("MicroMsg.TxtStatus.TextStatusStorage", "delete ".concat(String.valueOf(paramString)));
    if (this.db.delete(TABLE, "UserName = ?", new String[] { paramString }) > 0) {}
    for (;;)
    {
      if (bool)
      {
        gWL().remove(paramString);
        doNotify(paramString);
      }
      AppMethodBeat.o(216279);
      return bool;
      bool = false;
    }
  }
  
  public final a aTl(String paramString)
  {
    AppMethodBeat.i(216280);
    p.h(paramString, "username");
    a locala = (a)gWL().get(paramString);
    if ((locala != null) && (locala.field_ExpireTime > cl.aWB()))
    {
      AppMethodBeat.o(216280);
      return locala;
    }
    gWL().remove(paramString);
    AppMethodBeat.o(216280);
    return null;
  }
  
  public final a aTm(String paramString)
  {
    AppMethodBeat.i(216282);
    p.h(paramString, "statusId");
    Iterator localIterator = gWL().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((p.j(locala.field_StatusID, paramString)) && (locala.field_ExpireTime > cl.aWB()))
      {
        AppMethodBeat.o(216282);
        return locala;
      }
    }
    AppMethodBeat.o(216282);
    return null;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(216271);
    p.h(parama, "item");
    boolean bool = super.insertNotify((IAutoDBItem)parama, false);
    if (bool)
    {
      gWL().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(216271);
    return bool;
  }
  
  public final boolean c(a parama)
  {
    AppMethodBeat.i(216273);
    p.h(parama, "item");
    boolean bool = super.replace((IAutoDBItem)parama, false);
    if (bool)
    {
      gWL().put(parama.field_UserName, parama);
      doNotify(parama.field_UserName);
    }
    AppMethodBeat.o(216273);
    return bool;
  }
  
  public final ConcurrentHashMap<String, a> gWL()
  {
    AppMethodBeat.i(258421);
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.FZJ.getValue();
    AppMethodBeat.o(258421);
    return localConcurrentHashMap;
  }
  
  public final boolean ie(String paramString, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(257985);
    p.h(paramString, "userName");
    Log.i("MicroMsg.TxtStatus.TextStatusStorage", "deleteByCreateTime " + paramString + ' ' + paramInt);
    if (this.db.delete(TABLE, "UserName = ? and CreateTime<?", new String[] { paramString, String.valueOf(paramInt) }) > 0) {
      bool = true;
    }
    if (bool)
    {
      a locala = (a)gWL().get(paramString);
      if ((locala != null) && (locala.field_CreateTime < paramInt))
      {
        gWL().remove(paramString);
        doNotify(paramString);
      }
    }
    AppMethodBeat.o(257985);
    return bool;
  }
  
  public final List<a> m(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(216281);
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      paramString = (List)localArrayList;
      AppMethodBeat.o(216281);
      return paramString;
    }
    Iterator localIterator = gWL().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((p.j(locala.field_TopicId, paramString)) && (locala.field_ExpireTime > cl.aWB()) && ((paramArrayList == null) || (!paramArrayList.contains(locala.field_UserName)))) {
        localArrayList.add(locala);
      }
    }
    paramString = (List)localArrayList;
    if (paramString.size() > 1) {
      j.a(paramString, (Comparator)new c());
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(216281);
    return paramString;
  }
  
  public final LinkedHashMap<String, ArrayList<a>> w(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(216283);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = gWL().values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((!paramList1.contains(locala.field_UserName)) && (!paramList2.contains(locala.field_TopicId)) && (locala.field_ExpireTime > cl.aWB()))
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
    AppMethodBeat.o(216283);
    return localLinkedHashMap;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ConcurrentHashMap<String, a>>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(216269);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((a)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((a)paramT1).field_CreateTime));
      AppMethodBeat.o(216269);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f.d
 * JD-Core Version:    0.7.0.1
 */