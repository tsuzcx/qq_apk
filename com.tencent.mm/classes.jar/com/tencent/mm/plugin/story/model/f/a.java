package com.tencent.mm.plugin.story.model.f;

import a.f.a.r;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.api.k.b;
import com.tencent.mm.plugin.story.api.k.c;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayOlderUserList", "", "kotlin.jvm.PlatformType", "", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "updateUser", "plugin-story_release"})
public final class a
  implements k.c, k.a
{
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<k.b> ipW;
  private static final Map<String, f> syW;
  private static final Map<String, c> syX;
  private static final List<String> syY;
  private static final List<String> syZ;
  public static final a.i sza;
  public static final r<Long, Boolean, String, String, y> szb;
  public static final a szc;
  
  static
  {
    AppMethodBeat.i(109374);
    szc = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    syW = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    syX = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    syY = Collections.synchronizedList((List)new LinkedList());
    syZ = Collections.synchronizedList((List)new LinkedList());
    ipW = new LinkedList();
    sza = new a.i();
    szb = (r)a.j.szo;
    AppMethodBeat.o(109374);
  }
  
  private static boolean a(cgw paramcgw, com.tencent.mm.plugin.story.h.c paramc)
  {
    AppMethodBeat.i(138790);
    if ((paramcgw.xNY != 0) && (paramcgw.CreateTime > paramc.field_readCommentTime))
    {
      paramcgw = paramcgw.num;
      paramc = com.tencent.mm.plugin.story.model.j.svi;
      if (!bo.isEqual(paramcgw, j.b.coK()))
      {
        AppMethodBeat.o(138790);
        return true;
      }
    }
    AppMethodBeat.o(138790);
    return false;
  }
  
  private static boolean adn(String paramString)
  {
    AppMethodBeat.i(109371);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.model.j.svi;
        if (!a.f.b.j.e(paramString, j.b.coK())) {
          break;
        }
      }
      AppMethodBeat.o(109371);
      return true;
    }
    AppMethodBeat.o(109371);
    return false;
  }
  
  private static boolean c(com.tencent.mm.plugin.story.h.j paramj)
  {
    AppMethodBeat.i(151081);
    if (paramj != null)
    {
      if (paramj.cFe())
      {
        boolean bool = paramj.cFd();
        AppMethodBeat.o(151081);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      if (!bo.isEqual(paramj, j.b.coK()))
      {
        AppMethodBeat.o(151081);
        return true;
      }
      AppMethodBeat.o(151081);
      return false;
    }
    AppMethodBeat.o(151081);
    return false;
  }
  
  public static void cBQ()
  {
    AppMethodBeat.i(109364);
    com.tencent.mm.ab.b.a("ContactSyncFetcher_pullTest", (a.f.a.a)a.h.szm);
    AppMethodBeat.o(109364);
  }
  
  public static void cBR()
  {
    AppMethodBeat.i(109372);
    com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a)a.e.szh);
    AppMethodBeat.o(109372);
  }
  
  public final void a(k.b paramb)
  {
    AppMethodBeat.i(109365);
    if (!ipW.contains(paramb)) {
      ipW.add(paramb);
    }
    AppMethodBeat.o(109365);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(109373);
    label193:
    String str;
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f)))
    {
      switch (paramString.hashCode())
      {
      default: 
      case 632036207: 
        do
        {
          ab.i(TAG, "[StoryExtInfo] unknown event ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(109373);
          return;
        } while (!paramString.equals("notify_story_unread"));
      }
      for (;;)
      {
        paramm = paramm.obj;
        if (paramm != null) {
          break label193;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(109373);
        throw paramString;
        if (!paramString.equals("notify_story_invalid")) {
          break;
        }
        continue;
        if (!paramString.equals("notify_story_valid")) {
          break;
        }
        continue;
        if (!paramString.equals("notify_story_read")) {
          break;
        }
        continue;
        if (!paramString.equals("notify_story_preload")) {
          break;
        }
      }
      paramm = (f)paramm;
      str = paramm.getUserName();
      ab.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      if (paramm.isValid())
      {
        Map localMap = syW;
        a.f.b.j.p(localMap, "userStateMap");
        localMap.put(str, paramm);
      }
    }
    while ((a.f.b.j.e(paramString, "notify_story_preload") ^ true)) {
      if ((a.f.b.j.e(paramString, "notify_story_read")) || (a.f.b.j.e(paramString, "notify_story_invalid")))
      {
        syZ.remove(str);
        syY.remove(str);
        AppMethodBeat.o(109373);
        return;
        syW.remove(str);
      }
      else
      {
        com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a)new a.f(str));
        AppMethodBeat.o(109373);
        return;
        if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof com.tencent.mm.plugin.story.h.j))) {
          switch (paramString.hashCode())
          {
          }
        }
      }
    }
    do
    {
      ab.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(109373);
      return;
    } while (!paramString.equals("notify_story_info_delete"));
    com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a)new a.g(paramm));
    AppMethodBeat.o(109373);
  }
  
  /* Error */
  public final int adm(String paramString)
  {
    // Byte code:
    //   0: ldc_w 794
    //   3: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 795
    //   10: invokestatic 798	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 116	com/tencent/mm/plugin/story/model/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 800
    //   19: aload_1
    //   20: invokestatic 746	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 750	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 399	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 131	com/tencent/mm/plugin/story/model/f/a:syX	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 226 2 0
    //   42: checkcast 697	com/tencent/mm/plugin/story/model/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 702	com/tencent/mm/plugin/story/model/f/c:szz	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 121	java/util/Map
    //   63: invokeinterface 316 1 0
    //   68: invokeinterface 319 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 243 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 247 1 0
    //   90: checkcast 321	java/util/Map$Entry
    //   93: invokeinterface 329 1 0
    //   98: checkcast 802	java/lang/Number
    //   101: invokevirtual 805	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 339	a/y:BMg	La/y;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 794
    //   118: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 794
    //   134: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	a
    //   0	139	1	paramString	String
    //   30	95	2	i	int
    // Exception table:
    //   from	to	target	type
    //   33	46	128	finally
    //   50	55	128	finally
    //   59	74	128	finally
    //   74	106	128	finally
    //   109	113	128	finally
  }
  
  public final void b(k.b paramb)
  {
    AppMethodBeat.i(109366);
    ipW.remove(paramb);
    AppMethodBeat.o(109366);
  }
  
  public final List<String> czu()
  {
    AppMethodBeat.i(109368);
    ab.i(TAG, "getUnreadList: size " + syZ.size());
    List localList1 = syZ;
    a.f.b.j.p(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)syZ);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(109368);
    }
  }
  
  public final List<String> czv()
  {
    AppMethodBeat.i(109369);
    ab.i(TAG, "getOlderList: size " + syY.size());
    List localList1 = syY;
    a.f.b.j.p(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)syY);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(109369);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> czw()
  {
    AppMethodBeat.i(138787);
    ab.i(TAG, "getNewReplyList: size " + syX.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = syX;
      a.f.b.j.p(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).szz.keySet());
        localObject3 = (Map)localLinkedHashMap;
        a.f.b.j.p(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = y.BMg;
    }
    finally
    {
      AppMethodBeat.o(138787);
    }
    AppMethodBeat.o(138787);
    return localLinkedHashMap1;
  }
  
  public final int czx()
  {
    AppMethodBeat.i(138788);
    int i = 0;
    synchronized ((Iterable)syX.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).szz).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = y.BMg;
      AppMethodBeat.o(138788);
      return i;
    }
  }
  
  public final List<String> czy()
  {
    AppMethodBeat.i(109367);
    LinkedList localLinkedList = new LinkedList();
    synchronized ((Iterable)syW.entrySet())
    {
      localObject4 = ((Iterable)???).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if ((!adn((String)localEntry.getKey())) && (((f)localEntry.getValue()).isValid()) && (!((f)localEntry.getValue()).cEU())) {
          localLinkedList.add(localEntry.getValue());
        }
      }
    }
    Object localObject4 = y.BMg;
    ??? = (List)localObject1;
    if (((List)???).size() > 1) {
      a.a.j.a((List)???, (Comparator)new a.c());
    }
    ab.i(TAG, "getReadList: size " + localObject1.size());
    ??? = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)???));
    ??? = ((Iterable)???).iterator();
    while (((Iterator)???).hasNext()) {
      ((Collection)localObject2).add(((f)((Iterator)???).next()).getUserName());
    }
    localObject2 = (List)localObject2;
    AppMethodBeat.o(109367);
    return localObject2;
  }
  
  public final void czz()
  {
    AppMethodBeat.i(109370);
    com.tencent.mm.ab.b.a("ContactSyncFetcher_checkContactState", (a.f.a.a)a.a.szd);
    AppMethodBeat.o(109370);
  }
  
  public final void init()
  {
    AppMethodBeat.i(109363);
    ab.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().add((k.a)this);
    localObject = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().add((k.a)this);
    com.tencent.mm.ab.b.a(1000L, (a.f.a.a)a.d.szg);
    sza.alive();
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.b(szb);
    AppMethodBeat.o(109363);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class k<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(109362);
      paramT2 = (f)paramT2;
      if (paramT2.field_updateTime == 0L)
      {
        l = paramT2.field_storyPostTime * 1000L;
        paramT2 = (Comparable)Long.valueOf(l);
        paramT1 = (f)paramT1;
        if (paramT1.field_updateTime != 0L) {
          break label93;
        }
      }
      label93:
      for (long l = paramT1.field_storyPostTime * 1000L;; l = paramT1.field_updateTime)
      {
        int i = a.b.a.a(paramT2, (Comparable)Long.valueOf(l));
        AppMethodBeat.o(109362);
        return i;
        l = paramT2.field_updateTime;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.a
 * JD-Core Version:    0.7.0.1
 */