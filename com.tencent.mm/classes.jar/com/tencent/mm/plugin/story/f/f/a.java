package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, k.a
{
  private static final Map<String, f> ANb;
  private static final Map<String, c> ANc;
  private static final List<String> ANd;
  private static final List<String> ANe;
  private static final List<String> ANf;
  private static final List<l.d> ANg;
  public static final i ANh;
  public static final r<Long, Boolean, String, String, z> ANi;
  public static final a ANj;
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> lRS;
  
  static
  {
    AppMethodBeat.i(119022);
    ANj = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    ANb = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    ANc = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    ANd = Collections.synchronizedList((List)new LinkedList());
    ANe = Collections.synchronizedList((List)new LinkedList());
    ANf = Collections.synchronizedList((List)new LinkedList());
    ANg = Collections.synchronizedList((List)new LinkedList());
    lRS = new LinkedList();
    ANh = new i();
    ANi = (r)a.j.ANv;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(dix paramdix, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramdix.HtH != 0) && (paramdix.CreateTime > paramc.field_readCommentTime))
    {
      paramdix = paramdix.ukj;
      paramc = com.tencent.mm.plugin.story.f.j.AKb;
      if (!bt.lQ(paramdix, j.b.dTJ()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean aBS(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.AKb;
        if (!bt.lQ(paramString, j.b.dTJ())) {
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
      if (paramj.elC())
      {
        boolean bool = paramj.elB();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
      if (!bt.lQ(paramj, j.b.dTJ()))
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
  
  public static void eiS()
  {
    AppMethodBeat.i(119004);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_pullTest", (d.g.a.a)h.ANt);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> eiT()
  {
    AppMethodBeat.i(119010);
    ad.i(TAG, "displaySortedReplyUserList: size " + ANf.size());
    List localList1 = ANf;
    p.g(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)ANf);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> eiU()
  {
    AppMethodBeat.i(119011);
    ad.i(TAG, "displayNewList: size " + ANg.size());
    List localList1 = ANg;
    p.g(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)ANg);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void eiV()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = ANb;
        p.g(localObject3, "userStateMap");
        try
        {
          localObject5 = ANb.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (aBS((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.AKb;
          bool1 = bt.lQ(j.b.dTJ(), (String)((Map.Entry)localObject6).getKey());
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
        bool1 = ((f)localObject7).elr();
      }
      finally {}
    }
    Object localObject5 = z.MKo;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).acA().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    p.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).acA().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    ad.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + ANe.size() + ", displayOld:" + ANd.size() + ", displayNewReply:" + ANc.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!com.tencent.mm.plugin.story.c.a.e.AIM.egX())
    {
      int j = 0;
      if (ANe.size() + ANd.size() + ANc.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 10L, 1L);
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
          if (bt.rM(l1 / 1000L) < k) {
            break label1672;
          }
          com.tencent.mm.plugin.report.service.g.yhR.n(1015L, 11L, 1L);
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
    localObject3 = (f)d.a.j.jd((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    ANe.clear();
    ANd.clear();
    ANf.clear();
    ANg.clear();
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.e)localObject3).ajl().a(al.a.IFI, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(ANc.values());
    localObject3 = ((Iterable)d.a.j.a((Iterable)localObject3, (Comparator)new a.l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      ANf.add(((c)localObject5).ALG);
      if (((c)localObject5).hZE > l2 / 1000L) {
        ANg.add(new l.d(((c)localObject5).ALG, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.e)localObject3).ajl().a(al.a.IFG, 0L);
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
        localObject6 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject6 = j.b.ehT();
        localObject7 = ((f)localObject5).getUserName();
        i = cf.aCN();
        Object localObject8 = i.AJE;
        localObject6 = ((k)localObject6).j((String)localObject7, false, i - i.ehK());
        localObject7 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject7 = j.b.ehT();
        localObject8 = ((f)localObject5).getUserName();
        i = cf.aCN();
        i.a locala = i.AJE;
        if (k.a((k)localObject7, (String)localObject8, false, i - i.ehK()).size() != ((List)localObject6).size())
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
            if (!com.tencent.mm.plugin.story.c.a.e.AIM.egX()) {
              break label1236;
            }
            ANe.add(((f)localObject5).getUserName());
            if (l1 > l2) {
              ANg.add(new l.d(((f)localObject5).getUserName(), 0));
            }
          }
          localObject6 = TAG;
          localObject5 = new StringBuilder("make list username:").append(((f)localObject5).getUserName()).append(" updateTime:").append(((f)localObject5).field_updateTime).append(" posTime:").append(((f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
          if (l1 <= l3) {
            break label1675;
          }
          bool2 = true;
          label1176:
          ad.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
        }
      }
      bool1 = false;
      continue;
      label1236:
      if (l1 > l3) {
        ANe.add(((f)localObject5).getUserName());
      } else {
        ANd.add(((f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.AKb;
    if (bt.lQ(j.b.dTJ(), ((f)localObject5).getUserName()))
    {
      l1 = ((f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!com.tencent.mm.plugin.story.c.a.e.AIM.egX()) {
        break label1529;
      }
      ANe.add(((f)localObject5).getUserName());
      if (l1 > l2) {
        ANg.add(new l.d(((f)localObject5).getUserName(), 0));
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
      ad.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
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
        ANe.add(((f)localObject5).getUserName());
        break label1362;
      }
      ANd.add(((f)localObject5).getUserName());
      break label1362;
      label1571:
      z localz = z.MKo;
      ad.i(TAG, "update time " + l3 + " displayUnreadUserList " + ANe + " displayOlderUserList " + ANd + " userReplyStateMap " + ANc + " displaySortedReplyUserList:" + ANf + " displayNewList:" + ANg);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void eiW()
  {
    AppMethodBeat.i(119020);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)e.ANo);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!lRS.contains(paramb)) {
      lRS.add(paramb);
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
          ad.i(TAG, "[StoryExtInfo] unknown event ".concat(String.valueOf(paramString)));
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
      ad.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      Map localMap = ANb;
      p.g(localMap, "userStateMap");
      localMap.put(str, paramm);
      if ((p.i(paramString, "notify_story_preload") ^ true))
      {
        com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)f.ANq);
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
      ad.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119021);
      return;
    } while (!paramString.equals("notify_story_info_delete"));
    com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)new g(paramm));
    AppMethodBeat.o(119021);
  }
  
  /* Error */
  public final int aBR(String paramString)
  {
    // Byte code:
    //   0: ldc_w 894
    //   3: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 895
    //   10: invokestatic 898	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 153	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 900
    //   19: aload_1
    //   20: invokestatic 850	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 854	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 324	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 168	com/tencent/mm/plugin/story/f/f/a:ANc	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 794 2 0
    //   42: checkcast 537	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 808	com/tencent/mm/plugin/story/f/f/c:ANI	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 158	java/util/Map
    //   63: invokeinterface 350 1 0
    //   68: invokeinterface 356 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 361 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 365 1 0
    //   90: checkcast 367	java/util/Map$Entry
    //   93: invokeinterface 375 1 0
    //   98: checkcast 902	java/lang/Number
    //   101: invokevirtual 905	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 392	d/z:MKo	Ld/z;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 894
    //   118: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 894
    //   134: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    lRS.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final List<String> eha()
  {
    AppMethodBeat.i(119008);
    ad.i(TAG, "getUnreadList: size " + ANe.size());
    List localList1 = ANe;
    p.g(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)ANe);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> ehb()
  {
    AppMethodBeat.i(119009);
    ad.i(TAG, "getOlderList: size " + ANd.size());
    List localList1 = ANd;
    p.g(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)ANd);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> ehc()
  {
    AppMethodBeat.i(119012);
    ad.i(TAG, "getNewReplyList: size " + ANc.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = ANc;
      p.g(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).ANI.keySet());
        localObject3 = (Map)localLinkedHashMap;
        p.g(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = z.MKo;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int ehd()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)ANc.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).ANI).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = z.MKo;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> ehe()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)ANb.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (aBS((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.AKb;
        boolean bool = bt.lQ(j.b.dTJ(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        p.g(localObject5, "it.value");
        localObject5 = (f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((f)localObject5).field_storyPostTime;
        Object localObject6 = i.AJE;
        if (i + i.ehK() < cf.aCN())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.AKb;
          if ((!bt.lQ(j.b.dTJ(), ((f)localObject5).getUserName())) || (((f)localObject5).field_storyPostTime <= ((f)localObject5).field_readTime / 1000L)) {
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
        if ((!((f)localObject5).isValid()) || (((f)localObject5).elr())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = z.MKo;
        ??? = (List)localObject1;
        if (((List)???).size() > 1) {
          d.a.j.a((List)???, (Comparator)new c());
        }
        ad.i(TAG, "getReadList: size " + localObject1.size());
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
  
  public final void ehf()
  {
    AppMethodBeat.i(119015);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.ANk);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    ad.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehU().add((k.a)this);
    localObject = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehT().add((k.a)this);
    com.tencent.mm.ad.c.a(1000L, (d.g.a.a)a.d.ANn);
    ANh.alive();
    localObject = b.ALT;
    b.d(ANi);
    AppMethodBeat.o(119003);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a ANk;
    
    static
    {
      AppMethodBeat.i(118975);
      ANk = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    public static final b ANm;
    
    static
    {
      AppMethodBeat.i(118977);
      ANm = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    public static final e ANo;
    
    static
    {
      AppMethodBeat.i(118984);
      ANo = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    public static final f ANq;
    
    static
    {
      AppMethodBeat.i(118988);
      ANq = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    public static final h ANt;
    
    static
    {
      AppMethodBeat.i(118993);
      ANt = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<uu>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(uu paramuu)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a
 * JD-Core Version:    0.7.0.1
 */