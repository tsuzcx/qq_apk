package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.eng;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, MStorage.IOnStorageChange
{
  private static final List<l.d> LJA;
  public static final i LJB;
  public static final r<Long, Boolean, String, String, x> LJC;
  public static final a LJD;
  private static final Map<String, com.tencent.mm.plugin.story.i.f> LJv;
  private static final Map<String, c> LJw;
  private static final List<String> LJx;
  private static final List<String> LJy;
  private static final List<String> LJz;
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> qem;
  
  static
  {
    AppMethodBeat.i(119022);
    LJD = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    LJv = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    LJw = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    LJx = Collections.synchronizedList((List)new LinkedList());
    LJy = Collections.synchronizedList((List)new LinkedList());
    LJz = Collections.synchronizedList((List)new LinkedList());
    LJA = Collections.synchronizedList((List)new LinkedList());
    qem = new LinkedList();
    LJB = new i();
    LJC = (r)a.j.LJP;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(eng parameng, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((parameng.Uln != 0) && (parameng.CreateTime > paramc.field_readCommentTime))
    {
      parameng = parameng.CRR;
      paramc = com.tencent.mm.plugin.story.f.j.LGA;
      if (!Util.isEqual(parameng, j.b.fOo()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean bdk(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.LGA;
        if (!Util.isEqual(paramString, j.b.fOo())) {
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
      if (paramj.ggh())
      {
        boolean bool = paramj.ggg();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
      if (!Util.isEqual(paramj, j.b.fOo()))
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
  
  public static void gdv()
  {
    AppMethodBeat.i(119004);
    d.b("ContactSyncFetcher_pullTest", (kotlin.g.a.a)h.LJN);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> gdw()
  {
    AppMethodBeat.i(119010);
    Log.i(TAG, "displaySortedReplyUserList: size " + LJz.size());
    List localList1 = LJz;
    p.j(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)LJz);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> gdx()
  {
    AppMethodBeat.i(119011);
    Log.i(TAG, "displayNewList: size " + LJA.size());
    List localList1 = LJA;
    p.j(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)LJA);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void gdy()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = LJv;
        p.j(localObject3, "userStateMap");
        try
        {
          localObject5 = LJv.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (bdk((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.LGA;
          bool1 = Util.isEqual(j.b.fOo(), (String)((Map.Entry)localObject6).getKey());
          localObject7 = ((Map.Entry)localObject6).getValue();
          p.j(localObject7, "it.value");
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
        bool1 = ((com.tencent.mm.plugin.story.i.f)localObject7).gfW();
      }
      finally {}
    }
    Object localObject5 = x.aazN;
    Object localObject3 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).axc().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
    p.j(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).axc().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    Log.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + LJy.size() + ", displayOld:" + LJx.size() + ", displayNewReply:" + LJw.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!e.LFp.gbz())
    {
      int j = 0;
      if (LJy.size() + LJx.size() + LJw.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 10L, 1L);
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
          com.tencent.mm.plugin.report.service.h.IzE.p(1015L, 11L, 1L);
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
    localObject3 = (com.tencent.mm.plugin.story.i.f)kotlin.a.j.lp((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    LJy.clear();
    LJx.clear();
    LJz.clear();
    LJA.clear();
    localObject3 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.f)localObject3).aHp().a(ar.a.Vxe, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(LJw.values());
    localObject3 = ((Iterable)kotlin.a.j.a((Iterable)localObject3, (Comparator)new l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      LJz.add(((c)localObject5).LIb);
      if (((c)localObject5).createTime > l2 / 1000L) {
        LJA.add(new l.d(((c)localObject5).LIb, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.f)localObject3).aHp().a(ar.a.Vxc, 0L);
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
        localObject6 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject6 = j.b.gcw();
        localObject7 = ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName();
        i = cm.bfF();
        Object localObject8 = i.LGd;
        localObject6 = ((k)localObject6).m((String)localObject7, false, i - i.gcn());
        localObject7 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject7 = j.b.gcw();
        localObject8 = ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName();
        i = cm.bfF();
        i.a locala = i.LGd;
        if (k.a((k)localObject7, (String)localObject8, false, i - i.gcn()).size() != ((List)localObject6).size())
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
            if (!e.LFp.gbz()) {
              break label1236;
            }
            LJy.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
            if (l1 > l2) {
              LJA.add(new l.d(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName(), 0));
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
        LJy.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      } else {
        LJx.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.LGA;
    if (Util.isEqual(j.b.fOo(), ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName()))
    {
      l1 = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!e.LFp.gbz()) {
        break label1529;
      }
      LJy.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      if (l1 > l2) {
        LJA.add(new l.d(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName(), 0));
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
        LJy.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
        break label1362;
      }
      LJx.add(((com.tencent.mm.plugin.story.i.f)localObject5).getUserName());
      break label1362;
      label1571:
      x localx = x.aazN;
      Log.i(TAG, "update time " + l3 + " displayUnreadUserList " + LJy + " displayOlderUserList " + LJx + " userReplyStateMap " + LJw + " displaySortedReplyUserList:" + LJz + " displayNewList:" + LJA);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void gdz()
  {
    AppMethodBeat.i(119020);
    d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)e.LJI);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!qem.contains(paramb)) {
      qem.add(paramb);
    }
    AppMethodBeat.o(119005);
  }
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(119006);
    qem.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  /* Error */
  public final int bdj(String paramString)
  {
    // Byte code:
    //   0: ldc_w 843
    //   3: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 844
    //   10: invokestatic 847	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 155	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 849
    //   19: aload_1
    //   20: invokestatic 852	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 856	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 170	com/tencent/mm/plugin/story/f/f/a:LJw	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 515 2 0
    //   42: checkcast 523	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 536	com/tencent/mm/plugin/story/f/f/c:LKd	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 160	java/util/Map
    //   63: invokeinterface 596 1 0
    //   68: invokeinterface 599 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 315 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 319 1 0
    //   90: checkcast 601	java/util/Map$Entry
    //   93: invokeinterface 609 1 0
    //   98: checkcast 858	java/lang/Number
    //   101: invokevirtual 861	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 621	kotlin/x:aazN	Lkotlin/x;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 843
    //   118: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 843
    //   134: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final List<String> gbC()
  {
    AppMethodBeat.i(119008);
    Log.i(TAG, "getUnreadList: size " + LJy.size());
    List localList1 = LJy;
    p.j(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)LJy);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> gbD()
  {
    AppMethodBeat.i(119009);
    Log.i(TAG, "getOlderList: size " + LJx.size());
    List localList1 = LJx;
    p.j(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)LJx);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> gbE()
  {
    AppMethodBeat.i(119012);
    Log.i(TAG, "getNewReplyList: size " + LJw.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = LJw;
      p.j(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).LKd.keySet());
        localObject3 = (Map)localLinkedHashMap;
        p.j(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = x.aazN;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int gbF()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)LJw.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).LKd).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = x.aazN;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> gbG()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)LJv.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (bdk((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.LGA;
        boolean bool = Util.isEqual(j.b.fOo(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        p.j(localObject5, "it.value");
        localObject5 = (com.tencent.mm.plugin.story.i.f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime;
        Object localObject6 = i.LGd;
        if (i + i.gcn() < cm.bfF())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.LGA;
          if ((!Util.isEqual(j.b.fOo(), ((com.tencent.mm.plugin.story.i.f)localObject5).getUserName())) || (((com.tencent.mm.plugin.story.i.f)localObject5).field_storyPostTime <= ((com.tencent.mm.plugin.story.i.f)localObject5).field_readTime / 1000L)) {
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
        if ((!((com.tencent.mm.plugin.story.i.f)localObject5).isValid()) || (((com.tencent.mm.plugin.story.i.f)localObject5).gfW())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = x.aazN;
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
  
  public final void gbH()
  {
    AppMethodBeat.i(119015);
    d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)a.LJE);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    Log.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcx().add((MStorage.IOnStorageChange)this);
    localObject = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcw().add((MStorage.IOnStorageChange)this);
    d.a(1000L, (kotlin.g.a.a)a.d.LJH);
    LJB.alive();
    localObject = b.LIo;
    b.f(LJC);
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
      Map localMap = LJv;
      p.j(localMap, "userStateMap");
      localMap.put(str, paramMStorageEventData);
      if ((p.h(paramString, "notify_story_preload") ^ true))
      {
        d.b("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)f.LJK);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a LJE;
    
    static
    {
      AppMethodBeat.i(118975);
      LJE = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final b LJG;
    
    static
    {
      AppMethodBeat.i(118977);
      LJG = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final e LJI;
    
    static
    {
      AppMethodBeat.i(118984);
      LJI = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final f LJK;
    
    static
    {
      AppMethodBeat.i(118988);
      LJK = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(MStorageEventData paramMStorageEventData)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final h LJN;
    
    static
    {
      AppMethodBeat.i(118993);
      LJN = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class i
    extends IListener<xc>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(xc paramxc)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119002);
      int i = kotlin.b.a.a((Comparable)Integer.valueOf(((c)paramT2).createTime), (Comparable)Integer.valueOf(((c)paramT1).createTime));
      AppMethodBeat.o(119002);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a
 * JD-Core Version:    0.7.0.1
 */