package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
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
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, MStorage.IOnStorageChange
{
  public static final r<Long, Boolean, String, String, x> FpA;
  public static final a FpB;
  private static final Map<String, com.tencent.mm.plugin.story.i.f> Fpt;
  private static final Map<String, c> Fpu;
  private static final List<String> Fpv;
  private static final List<String> Fpw;
  private static final List<String> Fpx;
  private static final List<l.d> Fpy;
  public static final i Fpz;
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> ndV;
  
  static
  {
    AppMethodBeat.i(119022);
    FpB = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    Fpt = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    Fpu = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    Fpv = Collections.synchronizedList((List)new LinkedList());
    Fpw = Collections.synchronizedList((List)new LinkedList());
    Fpx = Collections.synchronizedList((List)new LinkedList());
    Fpy = Collections.synchronizedList((List)new LinkedList());
    ndV = new LinkedList();
    Fpz = new i();
    FpA = (r)j.FpN;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(edf paramedf, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramedf.MYT != 0) && (paramedf.CreateTime > paramc.field_readCommentTime))
    {
      paramedf = paramedf.xNH;
      paramc = com.tencent.mm.plugin.story.f.j.Fmy;
      if (!Util.isEqual(paramedf, j.b.fau()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean aSg(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.Fmy;
        if (!Util.isEqual(paramString, j.b.fau())) {
          break;
        }
      }
      AppMethodBeat.o(119017);
      return true;
    }
    AppMethodBeat.o(119017);
    return false;
  }
  
  private static boolean c(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119019);
    if (paramj != null)
    {
      if (paramj.frL())
      {
        boolean bool = paramj.frK();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      if (!Util.isEqual(paramj, j.b.fau()))
      {
        AppMethodBeat.o(119019);
        return true;
      }
      AppMethodBeat.o(119019);
      return false;
    }
    AppMethodBeat.o(119019);
    return false;
  }
  
  public static void fpb()
  {
    AppMethodBeat.i(119004);
    d.b("ContactSyncFetcher_pullTest", (kotlin.g.a.a)h.FpL);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> fpc()
  {
    AppMethodBeat.i(119010);
    Log.i(TAG, "displaySortedReplyUserList: size " + Fpx.size());
    List localList1 = Fpx;
    p.g(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)Fpx);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> fpd()
  {
    AppMethodBeat.i(119011);
    Log.i(TAG, "displayNewList: size " + Fpy.size());
    List localList1 = Fpy;
    p.g(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)Fpy);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void fpe()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = Fpt;
        p.g(localObject3, "userStateMap");
        try
        {
          localObject5 = Fpt.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (aSg((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.Fmy;
          bool1 = Util.isEqual(j.b.fau(), (String)((Map.Entry)localObject6).getKey());
          localObject7 = ((Map.Entry)localObject6).getValue();
          p.g(localObject7, "it.value");
          localObject7 = (com.tencent.mm.plugin.story.i.f)localObject7;
          if (bool1)
          {
            bool1 = false;
            if (!bool1) {
              continue;
            }
            localLinkedList.add(((Map.Entry)localObject6).getValue());
            continue;
            localObject2 = finally;
          }
        }
        finally
        {
          AppMethodBeat.o(119016);
        }
        bool1 = ((com.tencent.mm.plugin.story.i.f)localObject7).frA();
      }
      finally {}
    }
    Object localObject5 = x.SXb;
    Object localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).aqJ().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).aqJ().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    Log.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + Fpw.size() + ", displayOld:" + Fpv.size() + ", displayNewReply:" + Fpu.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng())
    {
      int j = 0;
      if (Fpw.size() + Fpv.size() + Fpu.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          h.CyF.n(1015L, 10L, 1L);
          i = 1;
        }
      }
      j = i;
      if (i == 0)
      {
        localObject3 = ((Iterable)localObject2).iterator();
        j = i;
        if (((Iterator)localObject3).hasNext())
        {
          localObject5 = (com.tencent.mm.plugin.story.i.f)((Iterator)localObject3).next();
          l2 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_updateTime;
          l1 = l2;
          if (l2 == 0L) {
            l1 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime * 1000L;
          }
          if (Util.secondsToNow(l1 / 1000L) < k) {
            break label1672;
          }
          h.CyF.n(1015L, 11L, 1L);
          i = 1;
          break label1672;
        }
      }
      if (j == 0)
      {
        AppMethodBeat.o(119016);
        label561:
        return;
      }
    }
    localObject3 = (List)localObject2;
    if (((List)localObject3).size() > 1) {
      kotlin.a.j.a((List)localObject3, (Comparator)new k());
    }
    localObject3 = (com.tencent.mm.plugin.story.i.f)kotlin.a.j.kt((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    Fpw.clear();
    Fpv.clear();
    Fpx.clear();
    Fpy.clear();
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.e)localObject3).azQ().a(ar.a.OiO, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Fpu.values());
    localObject3 = ((Iterable)kotlin.a.j.a((Iterable)localObject3, (Comparator)new l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      Fpx.add(((c)localObject5).Foa);
      if (((c)localObject5).iXu > l2 / 1000L) {
        Fpy.add(new l.d(((c)localObject5).Foa, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.e)localObject3).azQ().a(ar.a.OiM, 0L);
    for (;;)
    {
      synchronized ((Iterable)localObject2)
      {
        localObject3 = ???.iterator();
        label864:
        if (!((Iterator)localObject3).hasNext()) {
          break label1571;
        }
        localObject5 = (com.tencent.mm.plugin.story.i.f)((Iterator)localObject3).next();
        localObject6 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject6 = j.b.foc();
        localObject7 = ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName();
        i = cl.aWB();
        Object localObject8 = i.Fmb;
        localObject6 = ((k)localObject6).j((String)localObject7, false, i - i.fnT());
        localObject7 = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject7 = j.b.foc();
        localObject8 = ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName();
        i = cl.aWB();
        i.a locala = i.Fmb;
        if (k.a((k)localObject7, (String)localObject8, false, i - i.fnT()).size() != ((List)localObject6).size())
        {
          bool1 = true;
          if (!bool1) {
            break;
          }
          if (((List)localObject6).isEmpty()) {
            continue;
          }
          l1 = ((com.tencent.mm.plugin.story.i.j)((List)localObject6).get(0)).field_createTime * 1000L;
          if (l1 > ((com.tencent.mm.plugin.story.i.f)localObject5).field_readTime)
          {
            if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
              break label1236;
            }
            Fpw.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
            if (l1 > l2) {
              Fpy.add(new l.d(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName(), 0));
            }
          }
          localObject6 = TAG;
          localObject5 = new StringBuilder("make list username:").append(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName()).append(" updateTime:").append(((com.tencent.mm.plugin.story.i.f)localObject5).field_updateTime).append(" posTime:").append(((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
          if (l1 <= l3) {
            break label1675;
          }
          bool2 = true;
          label1176:
          Log.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
        }
      }
      bool1 = false;
      continue;
      label1236:
      if (l1 > l3) {
        Fpw.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      } else {
        Fpv.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.Fmy;
    if (Util.isEqual(j.b.fau(), ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName()))
    {
      l1 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
        break label1529;
      }
      Fpw.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      if (l1 > l2) {
        Fpy.add(new l.d(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName(), 0));
      }
      label1362:
      localObject6 = TAG;
      localObject5 = new StringBuilder("make list username:").append(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName()).append(" updateTime:").append(((com.tencent.mm.plugin.story.i.f)localObject5).field_updateTime).append(" posTime:").append(((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
      if (l1 <= l3) {
        break label1681;
      }
    }
    label1672:
    label1675:
    label1681:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
      break label864;
      if (((com.tencent.mm.plugin.story.i.f)localObject5).field_updateTime == 0L)
      {
        l1 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime * 1000L;
        break label1309;
      }
      l1 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_updateTime;
      break label1309;
      label1529:
      if (l1 > l3)
      {
        Fpw.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
        break label1362;
      }
      Fpv.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      break label1362;
      label1571:
      x localx = x.SXb;
      Log.i(TAG, "update time " + l3 + " displayUnreadUserList " + Fpw + " displayOlderUserList " + Fpv + " userReplyStateMap " + Fpu + " displaySortedReplyUserList:" + Fpx + " displayNewList:" + Fpy);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void fpf()
  {
    AppMethodBeat.i(119020);
    d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)e.FpG);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!ndV.contains(paramb)) {
      ndV.add(paramb);
    }
    AppMethodBeat.o(119005);
  }
  
  /* Error */
  public final int aSf(String paramString)
  {
    // Byte code:
    //   0: ldc_w 841
    //   3: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 842
    //   10: invokestatic 845	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 161	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 847
    //   19: aload_1
    //   20: invokestatic 850	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 854	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 176	com/tencent/mm/plugin/story/f/f/a:Fpu	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 798 2 0
    //   42: checkcast 541	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 812	com/tencent/mm/plugin/story/f/f/c:Fqa	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 166	java/util/Map
    //   63: invokeinterface 356 1 0
    //   68: invokeinterface 362 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 367 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 371 1 0
    //   90: checkcast 373	java/util/Map$Entry
    //   93: invokeinterface 381 1 0
    //   98: checkcast 856	java/lang/Number
    //   101: invokevirtual 859	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 398	kotlin/x:SXb	Lkotlin/x;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 841
    //   118: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 841
    //   134: invokestatic 209	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(119006);
    ndV.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final List<String> fnj()
  {
    AppMethodBeat.i(119008);
    Log.i(TAG, "getUnreadList: size " + Fpw.size());
    List localList1 = Fpw;
    p.g(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)Fpw);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> fnk()
  {
    AppMethodBeat.i(119009);
    Log.i(TAG, "getOlderList: size " + Fpv.size());
    List localList1 = Fpv;
    p.g(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)Fpv);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> fnl()
  {
    AppMethodBeat.i(119012);
    Log.i(TAG, "getNewReplyList: size " + Fpu.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = Fpu;
      p.g(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).Fqa.keySet());
        localObject3 = (Map)localLinkedHashMap;
        p.g(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = x.SXb;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int fnm()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)Fpu.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).Fqa).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = x.SXb;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> fnn()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)Fpt.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (aSg((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.Fmy;
        boolean bool = Util.isEqual(j.b.fau(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        p.g(localObject5, "it.value");
        localObject5 = (com.tencent.mm.plugin.story.i.f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime;
        Object localObject6 = i.Fmb;
        if (i + i.fnT() < cl.aWB())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.Fmy;
          if ((!Util.isEqual(j.b.fau(), ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName())) || (((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime <= ((com.tencent.mm.plugin.story.i.f)localObject5).field_readTime / 1000L)) {
            break label234;
          }
          i = 1;
          break label410;
          if (i == 0) {
            continue;
          }
          localLinkedList.add(localEntry.getValue());
        }
      }
      int i = 0;
      continue;
      label234:
      i = 0;
      label239:
      label244:
      while (i != 0)
      {
        i = 0;
        break;
        if ((!((com.tencent.mm.plugin.story.i.f)localObject5).isValid()) || (((com.tencent.mm.plugin.story.i.f)localObject5).frA())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = x.SXb;
        ??? = (List)localObject1;
        if (((List)???).size() > 1) {
          kotlin.a.j.a((List)???, (Comparator)new c());
        }
        Log.i(TAG, "getReadList: size " + localObject1.size());
        ??? = (Iterable)localObject1;
        Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)???, 10));
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((Collection)localObject2).add(((com.tencent.mm.plugin.story.i.f)((Iterator)???).next()).getUserName());
        }
        localObject2 = (List)localObject2;
        AppMethodBeat.o(119007);
        return localObject2;
      }
      label265:
      label410:
      i = 1;
      continue;
      label419:
      i = 0;
    }
  }
  
  public final void fno()
  {
    AppMethodBeat.i(119015);
    d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)a.FpC);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    Log.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fod().add((MStorage.IOnStorageChange)this);
    localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foc().add((MStorage.IOnStorageChange)this);
    d.a(1000L, (kotlin.g.a.a)a.d.FpF);
    Fpz.alive();
    localObject = b.Fom;
    b.f(FpA);
    AppMethodBeat.o(119003);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119021);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.i.f)))
    {
      switch (paramString.hashCode())
      {
      default: 
      case 632036207: 
        do
        {
          Log.i(TAG, "[StoryExtInfo] unknown event ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(119021);
          return;
        } while (!paramString.equals("notify_story_unread"));
      }
      for (;;)
      {
        paramMStorageEventData = paramMStorageEventData.obj;
        if (paramMStorageEventData != null) {
          break label193;
        }
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119021);
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
      label193:
      paramMStorageEventData = (com.tencent.mm.plugin.story.i.f)paramMStorageEventData;
      String str = paramMStorageEventData.getUserName();
      Log.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      Map localMap = Fpt;
      p.g(localMap, "userStateMap");
      localMap.put(str, paramMStorageEventData);
      if ((p.j(paramString, "notify_story_preload") ^ true))
      {
        d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)f.FpI);
        AppMethodBeat.o(119021);
      }
    }
    else if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.i.j)))
    {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      Log.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119021);
      return;
    } while (!paramString.equals("notify_story_info_delete"));
    d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)new g(paramMStorageEventData));
    AppMethodBeat.o(119021);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a FpC;
    
    static
    {
      AppMethodBeat.i(118975);
      FpC = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final b FpE;
    
    static
    {
      AppMethodBeat.i(118977);
      FpE = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
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
      AppMethodBeat.i(118978);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((com.tencent.mm.plugin.story.i.f)paramT2).field_readTime), (Comparable)Long.valueOf(((com.tencent.mm.plugin.story.i.f)paramT1).field_readTime));
      AppMethodBeat.o(118978);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final e FpG;
    
    static
    {
      AppMethodBeat.i(118984);
      FpG = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final f FpI;
    
    static
    {
      AppMethodBeat.i(118988);
      FpI = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(MStorageEventData paramMStorageEventData)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final h FpL;
    
    static
    {
      AppMethodBeat.i(118993);
      FpL = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class i
    extends IListener<vx>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(vx paramvx)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
  static final class j
    extends q
    implements r<Long, Boolean, String, String, x>
  {
    public static final j FpN;
    
    static
    {
      AppMethodBeat.i(119000);
      FpN = new j();
      AppMethodBeat.o(119000);
    }
    
    j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class k<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119001);
      paramT2 = (com.tencent.mm.plugin.story.i.f)paramT2;
      if (paramT2.field_updateTime == 0L)
      {
        l = paramT2.field_storyPostTime * 1000L;
        paramT2 = (Comparable)Long.valueOf(l);
        paramT1 = (com.tencent.mm.plugin.story.i.f)paramT1;
        if (paramT1.field_updateTime != 0L) {
          break label93;
        }
      }
      label93:
      for (long l = paramT1.field_storyPostTime * 1000L;; l = paramT1.field_updateTime)
      {
        int i = kotlin.b.a.a(paramT2, (Comparable)Long.valueOf(l));
        AppMethodBeat.o(119001);
        return i;
        l = paramT2.field_updateTime;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119002);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((c)paramT2).iXu), (Comparable)Integer.valueOf(((c)paramT1).iXu));
      AppMethodBeat.o(119002);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a
 * JD-Core Version:    0.7.0.1
 */