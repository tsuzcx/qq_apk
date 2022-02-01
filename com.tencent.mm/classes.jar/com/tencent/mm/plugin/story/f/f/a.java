package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, k.a
{
  private static final Map<String, f> BeC;
  private static final Map<String, c> BeD;
  private static final List<String> BeE;
  private static final List<String> BeF;
  private static final List<String> BeG;
  private static final List<l.d> BeH;
  public static final i BeI;
  public static final r<Long, Boolean, String, String, z> BeJ;
  public static final a BeK;
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> lWt;
  
  static
  {
    AppMethodBeat.i(119022);
    BeK = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    BeC = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    BeD = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    BeE = Collections.synchronizedList((List)new LinkedList());
    BeF = Collections.synchronizedList((List)new LinkedList());
    BeG = Collections.synchronizedList((List)new LinkedList());
    BeH = Collections.synchronizedList((List)new LinkedList());
    lWt = new LinkedList();
    BeI = new i();
    BeJ = (r)a.j.BeW;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(djs paramdjs, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramdjs.HNk != 0) && (paramdjs.CreateTime > paramc.field_readCommentTime))
    {
      paramdjs = paramdjs.uvG;
      paramc = com.tencent.mm.plugin.story.f.j.BbE;
      if (!bu.lX(paramdjs, j.b.dXj()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean aDl(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.BbE;
        if (!bu.lX(paramString, j.b.dXj())) {
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
      if (paramj.epl())
      {
        boolean bool = paramj.epk();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
      if (!bu.lX(paramj, j.b.dXj()))
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
  
  public static void emA()
  {
    AppMethodBeat.i(119004);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_pullTest", (d.g.a.a)h.BeU);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> emB()
  {
    AppMethodBeat.i(119010);
    ae.i(TAG, "displaySortedReplyUserList: size " + BeG.size());
    List localList1 = BeG;
    p.g(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)BeG);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> emC()
  {
    AppMethodBeat.i(119011);
    ae.i(TAG, "displayNewList: size " + BeH.size());
    List localList1 = BeH;
    p.g(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)BeH);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void emD()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = BeC;
        p.g(localObject3, "userStateMap");
        try
        {
          localObject5 = BeC.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (aDl((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.BbE;
          bool1 = bu.lX(j.b.dXj(), (String)((Map.Entry)localObject6).getKey());
          localObject7 = ((Map.Entry)localObject6).getValue();
          p.g(localObject7, "it.value");
          localObject7 = (f)localObject7;
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
        bool1 = ((f)localObject7).epa();
      }
      finally {}
    }
    Object localObject5 = z.Nhr;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).acL().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).acL().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    ae.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + BeF.size() + ", displayOld:" + BeE.size() + ", displayNewReply:" + BeD.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!com.tencent.mm.plugin.story.c.a.e.Bap.ekF())
    {
      int j = 0;
      if (BeF.size() + BeE.size() + BeD.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 10L, 1L);
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
          localObject5 = (f)((Iterator)localObject3).next();
          l2 = ((f)localObject5).field_updateTime;
          l1 = l2;
          if (l2 == 0L) {
            l1 = ((f)localObject5).field_storyPostTime * 1000L;
          }
          if (bu.rZ(l1 / 1000L) < k) {
            break label1672;
          }
          com.tencent.mm.plugin.report.service.g.yxI.n(1015L, 11L, 1L);
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
      d.a.j.a((List)localObject3, (Comparator)new k());
    }
    localObject3 = (f)d.a.j.jm((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    BeF.clear();
    BeE.clear();
    BeG.clear();
    BeH.clear();
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.e)localObject3).ajA().a(am.a.Jai, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(BeD.values());
    localObject3 = ((Iterable)d.a.j.a((Iterable)localObject3, (Comparator)new l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      BeG.add(((c)localObject5).Bdj);
      if (((c)localObject5).icw > l2 / 1000L) {
        BeH.add(new l.d(((c)localObject5).Bdj, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.e)localObject3).ajA().a(am.a.Jag, 0L);
    for (;;)
    {
      synchronized ((Iterable)localObject2)
      {
        localObject3 = ???.iterator();
        label864:
        if (!((Iterator)localObject3).hasNext()) {
          break label1571;
        }
        localObject5 = (f)((Iterator)localObject3).next();
        localObject6 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject6 = j.b.elB();
        localObject7 = ((f)localObject5).getUserName();
        i = ch.aDd();
        Object localObject8 = i.Bbh;
        localObject6 = ((k)localObject6).j((String)localObject7, false, i - i.els());
        localObject7 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject7 = j.b.elB();
        localObject8 = ((f)localObject5).getUserName();
        i = ch.aDd();
        i.a locala = i.Bbh;
        if (k.a((k)localObject7, (String)localObject8, false, i - i.els()).size() != ((List)localObject6).size())
        {
          bool1 = true;
          if (!bool1) {
            break;
          }
          if (((List)localObject6).isEmpty()) {
            continue;
          }
          l1 = ((com.tencent.mm.plugin.story.i.j)((List)localObject6).get(0)).field_createTime * 1000L;
          if (l1 > ((f)localObject5).field_readTime)
          {
            if (!com.tencent.mm.plugin.story.c.a.e.Bap.ekF()) {
              break label1236;
            }
            BeF.add(((f)localObject5).getUserName());
            if (l1 > l2) {
              BeH.add(new l.d(((f)localObject5).getUserName(), 0));
            }
          }
          localObject6 = TAG;
          localObject5 = new StringBuilder("make list username:").append(((f)localObject5).getUserName()).append(" updateTime:").append(((f)localObject5).field_updateTime).append(" posTime:").append(((f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
          if (l1 <= l3) {
            break label1675;
          }
          bool2 = true;
          label1176:
          ae.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
        }
      }
      bool1 = false;
      continue;
      label1236:
      if (l1 > l3) {
        BeF.add(((f)localObject5).getUserName());
      } else {
        BeE.add(((f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.BbE;
    if (bu.lX(j.b.dXj(), ((f)localObject5).getUserName()))
    {
      l1 = ((f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!com.tencent.mm.plugin.story.c.a.e.Bap.ekF()) {
        break label1529;
      }
      BeF.add(((f)localObject5).getUserName());
      if (l1 > l2) {
        BeH.add(new l.d(((f)localObject5).getUserName(), 0));
      }
      label1362:
      localObject6 = TAG;
      localObject5 = new StringBuilder("make list username:").append(((f)localObject5).getUserName()).append(" updateTime:").append(((f)localObject5).field_updateTime).append(" posTime:").append(((f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
      if (l1 <= l3) {
        break label1681;
      }
    }
    label1672:
    label1675:
    label1681:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
      break label864;
      if (((f)localObject5).field_updateTime == 0L)
      {
        l1 = ((f)localObject5).field_storyPostTime * 1000L;
        break label1309;
      }
      l1 = ((f)localObject5).field_updateTime;
      break label1309;
      label1529:
      if (l1 > l3)
      {
        BeF.add(((f)localObject5).getUserName());
        break label1362;
      }
      BeE.add(((f)localObject5).getUserName());
      break label1362;
      label1571:
      z localz = z.Nhr;
      ae.i(TAG, "update time " + l3 + " displayUnreadUserList " + BeF + " displayOlderUserList " + BeE + " userReplyStateMap " + BeD + " displaySortedReplyUserList:" + BeG + " displayNewList:" + BeH);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void emE()
  {
    AppMethodBeat.i(119020);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)e.BeP);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!lWt.contains(paramb)) {
      lWt.add(paramb);
    }
    AppMethodBeat.o(119005);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(119021);
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof f)))
    {
      switch (paramString.hashCode())
      {
      default: 
      case 632036207: 
        do
        {
          ae.i(TAG, "[StoryExtInfo] unknown event ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(119021);
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
      paramm = (f)paramm;
      String str = paramm.getUserName();
      ae.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      Map localMap = BeC;
      p.g(localMap, "userStateMap");
      localMap.put(str, paramm);
      if ((p.i(paramString, "notify_story_preload") ^ true))
      {
        com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)f.BeR);
        AppMethodBeat.o(119021);
      }
    }
    else if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof com.tencent.mm.plugin.story.i.j)))
    {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      ae.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119021);
      return;
    } while (!paramString.equals("notify_story_info_delete"));
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)new g(paramm));
    AppMethodBeat.o(119021);
  }
  
  /* Error */
  public final int aDk(String paramString)
  {
    // Byte code:
    //   0: ldc_w 894
    //   3: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 895
    //   10: invokestatic 898	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 155	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 900
    //   19: aload_1
    //   20: invokestatic 850	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 854	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 326	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 170	com/tencent/mm/plugin/story/f/f/a:BeD	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 794 2 0
    //   42: checkcast 537	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 808	com/tencent/mm/plugin/story/f/f/c:Bfj	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 160	java/util/Map
    //   63: invokeinterface 352 1 0
    //   68: invokeinterface 358 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 363 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 367 1 0
    //   90: checkcast 369	java/util/Map$Entry
    //   93: invokeinterface 377 1 0
    //   98: checkcast 902	java/lang/Number
    //   101: invokevirtual 905	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 394	d/z:Nhr	Ld/z;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 894
    //   118: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 894
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
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(119006);
    lWt.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final List<String> ekI()
  {
    AppMethodBeat.i(119008);
    ae.i(TAG, "getUnreadList: size " + BeF.size());
    List localList1 = BeF;
    p.g(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)BeF);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> ekJ()
  {
    AppMethodBeat.i(119009);
    ae.i(TAG, "getOlderList: size " + BeE.size());
    List localList1 = BeE;
    p.g(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)BeE);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> ekK()
  {
    AppMethodBeat.i(119012);
    ae.i(TAG, "getNewReplyList: size " + BeD.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = BeD;
      p.g(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).Bfj.keySet());
        localObject3 = (Map)localLinkedHashMap;
        p.g(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = z.Nhr;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int ekL()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)BeD.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).Bfj).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = z.Nhr;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> ekM()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)BeC.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (aDl((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.BbE;
        boolean bool = bu.lX(j.b.dXj(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        p.g(localObject5, "it.value");
        localObject5 = (f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((f)localObject5).field_storyPostTime;
        Object localObject6 = i.Bbh;
        if (i + i.els() < ch.aDd())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.BbE;
          if ((!bu.lX(j.b.dXj(), ((f)localObject5).getUserName())) || (((f)localObject5).field_storyPostTime <= ((f)localObject5).field_readTime / 1000L)) {
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
        if ((!((f)localObject5).isValid()) || (((f)localObject5).epa())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = z.Nhr;
        ??? = (List)localObject1;
        if (((List)???).size() > 1) {
          d.a.j.a((List)???, (Comparator)new c());
        }
        ae.i(TAG, "getReadList: size " + localObject1.size());
        ??? = (Iterable)localObject1;
        Object localObject2 = (Collection)new ArrayList(d.a.j.a((Iterable)???, 10));
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((Collection)localObject2).add(((f)((Iterator)???).next()).getUserName());
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
  
  public final void ekN()
  {
    AppMethodBeat.i(119015);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.BeL);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    ae.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elC().add((k.a)this);
    localObject = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elB().add((k.a)this);
    com.tencent.mm.ac.c.a(1000L, (d.g.a.a)a.d.BeO);
    BeI.alive();
    localObject = b.Bdv;
    b.d(BeJ);
    AppMethodBeat.o(119003);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a BeL;
    
    static
    {
      AppMethodBeat.i(118975);
      BeL = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    public static final b BeN;
    
    static
    {
      AppMethodBeat.i(118977);
      BeN = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118978);
      int i = d.b.a.a((Comparable)Long.valueOf(((f)paramT2).field_readTime), (Comparable)Long.valueOf(((f)paramT1).field_readTime));
      AppMethodBeat.o(118978);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    public static final e BeP;
    
    static
    {
      AppMethodBeat.i(118984);
      BeP = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    public static final f BeR;
    
    static
    {
      AppMethodBeat.i(118988);
      BeR = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    public static final h BeU;
    
    static
    {
      AppMethodBeat.i(118993);
      BeU = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<uy>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(uy paramuy)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class k<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119001);
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
        int i = d.b.a.a(paramT2, (Comparable)Long.valueOf(l));
        AppMethodBeat.o(119001);
        return i;
        l = paramT2.field_updateTime;
        break;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119002);
      int i = d.b.a.a((Comparable)Integer.valueOf(((c)paramT2).icw), (Comparable)Integer.valueOf(((c)paramT1).icw));
      AppMethodBeat.o(119002);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a
 * JD-Core Version:    0.7.0.1
 */