package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.f.b.b;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.i.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.r;
import d.v;
import d.y;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, k.a
{
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> kRj;
  private static final Map<String, f> yig;
  private static final Map<String, c> yih;
  private static final List<String> yii;
  private static final List<String> yij;
  private static final List<String> yik;
  private static final List<l.d> yil;
  public static final a.i yim;
  public static final r<Long, Boolean, String, String, y> yin;
  public static final a yio;
  
  static
  {
    AppMethodBeat.i(119022);
    yio = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    yig = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    yih = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    yii = Collections.synchronizedList((List)new LinkedList());
    yij = Collections.synchronizedList((List)new LinkedList());
    yik = Collections.synchronizedList((List)new LinkedList());
    yil = Collections.synchronizedList((List)new LinkedList());
    kRj = new LinkedList();
    yim = new a.i();
    yin = (r)a.j.yiA;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(cxy paramcxy, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramcxy.Ema != 0) && (paramcxy.CreateTime > paramc.field_readCommentTime))
    {
      paramcxy = paramcxy.sdQ;
      paramc = com.tencent.mm.plugin.story.f.j.yfh;
      if (!bt.kU(paramcxy, j.b.dta()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean arF(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.yfh;
        if (!bt.kU(paramString, j.b.dta())) {
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
      if (paramj.dKM())
      {
        boolean bool = paramj.dKL();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
      if (!bt.kU(paramj, j.b.dta()))
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
  
  public static void dIc()
  {
    AppMethodBeat.i(119004);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_pullTest", (d.g.a.a)h.yiy);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> dId()
  {
    AppMethodBeat.i(119010);
    ad.i(TAG, "displaySortedReplyUserList: size " + yik.size());
    List localList1 = yik;
    d.g.b.k.g(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)yik);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> dIe()
  {
    AppMethodBeat.i(119011);
    ad.i(TAG, "displayNewList: size " + yil.size());
    List localList1 = yil;
    d.g.b.k.g(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)yil);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void dIf()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = yig;
        d.g.b.k.g(localObject3, "userStateMap");
        try
        {
          localObject5 = yig.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (arF((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.yfh;
          bool1 = bt.kU(j.b.dta(), (String)((Map.Entry)localObject6).getKey());
          localObject7 = ((Map.Entry)localObject6).getValue();
          d.g.b.k.g(localObject7, "it.value");
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
        bool1 = ((f)localObject7).dKB();
      }
      finally {}
    }
    Object localObject5 = y.JfV;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).Zd().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).Zd().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    ad.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + yij.size() + ", displayOld:" + yii.size() + ", displayNewReply:" + yih.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!com.tencent.mm.plugin.story.c.a.e.ydS.dGh())
    {
      int j = 0;
      if (yij.size() + yii.size() + yih.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          h.vKh.m(1015L, 10L, 1L);
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
          if (bt.lZ(l1 / 1000L) < k) {
            break label1672;
          }
          h.vKh.m(1015L, 11L, 1L);
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
    localObject3 = (f)d.a.j.iz((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    yij.clear();
    yii.clear();
    yik.clear();
    yil.clear();
    localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.e)localObject3).afk().a(ae.a.Fvj, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(yih.values());
    localObject3 = ((Iterable)d.a.j.a((Iterable)localObject3, (Comparator)new l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      yik.add(((c)localObject5).ygM);
      if (((c)localObject5).hgr > l2 / 1000L) {
        yil.add(new l.d(((c)localObject5).ygM, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.e)localObject3).afk().a(ae.a.Fvh, 0L);
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
        localObject6 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject6 = j.b.dHd();
        localObject7 = ((f)localObject5).getUserName();
        i = ce.asT();
        Object localObject8 = i.yeK;
        localObject6 = ((com.tencent.mm.plugin.story.i.k)localObject6).j((String)localObject7, false, i - i.dGU());
        localObject7 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject7 = j.b.dHd();
        localObject8 = ((f)localObject5).getUserName();
        i = ce.asT();
        i.a locala = i.yeK;
        if (com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject7, (String)localObject8, false, i - i.dGU()).size() != ((List)localObject6).size())
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
            if (!com.tencent.mm.plugin.story.c.a.e.ydS.dGh()) {
              break label1236;
            }
            yij.add(((f)localObject5).getUserName());
            if (l1 > l2) {
              yil.add(new l.d(((f)localObject5).getUserName(), 0));
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
        yij.add(((f)localObject5).getUserName());
      } else {
        yii.add(((f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.yfh;
    if (bt.kU(j.b.dta(), ((f)localObject5).getUserName()))
    {
      l1 = ((f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!com.tencent.mm.plugin.story.c.a.e.ydS.dGh()) {
        break label1529;
      }
      yij.add(((f)localObject5).getUserName());
      if (l1 > l2) {
        yil.add(new l.d(((f)localObject5).getUserName(), 0));
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
        yij.add(((f)localObject5).getUserName());
        break label1362;
      }
      yii.add(((f)localObject5).getUserName());
      break label1362;
      label1571:
      y localy = y.JfV;
      ad.i(TAG, "update time " + l3 + " displayUnreadUserList " + yij + " displayOlderUserList " + yii + " userReplyStateMap " + yih + " displaySortedReplyUserList:" + yik + " displayNewList:" + yil);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void dIg()
  {
    AppMethodBeat.i(119020);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.e.yit);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!kRj.contains(paramb)) {
      kRj.add(paramb);
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
      Map localMap = yig;
      d.g.b.k.g(localMap, "userStateMap");
      localMap.put(str, paramm);
      if ((d.g.b.k.g(paramString, "notify_story_preload") ^ true))
      {
        com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.f.yiv);
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
  public final int arE(String paramString)
  {
    // Byte code:
    //   0: ldc_w 884
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 885
    //   10: invokestatic 888	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 139	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 890
    //   19: aload_1
    //   20: invokestatic 838	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 842	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 312	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 154	com/tencent/mm/plugin/story/f/f/a:yih	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 782 2 0
    //   42: checkcast 523	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 796	com/tencent/mm/plugin/story/f/f/c:yiN	Ljava/util/HashMap;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +67 -> 123
    //   59: aload_1
    //   60: checkcast 144	java/util/Map
    //   63: invokeinterface 338 1 0
    //   68: invokeinterface 344 1 0
    //   73: astore_1
    //   74: aload_1
    //   75: invokeinterface 349 1 0
    //   80: ifeq +29 -> 109
    //   83: iload_2
    //   84: aload_1
    //   85: invokeinterface 353 1 0
    //   90: checkcast 355	java/util/Map$Entry
    //   93: invokeinterface 363 1 0
    //   98: checkcast 892	java/lang/Number
    //   101: invokevirtual 895	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 380	d/y:JfV	Ld/y;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 884
    //   118: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 884
    //   134: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    kRj.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final List<String> dGk()
  {
    AppMethodBeat.i(119008);
    ad.i(TAG, "getUnreadList: size " + yij.size());
    List localList1 = yij;
    d.g.b.k.g(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)yij);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> dGl()
  {
    AppMethodBeat.i(119009);
    ad.i(TAG, "getOlderList: size " + yii.size());
    List localList1 = yii;
    d.g.b.k.g(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)yii);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> dGm()
  {
    AppMethodBeat.i(119012);
    ad.i(TAG, "getNewReplyList: size " + yih.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = yih;
      d.g.b.k.g(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).yiN.keySet());
        localObject3 = (Map)localLinkedHashMap;
        d.g.b.k.g(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = y.JfV;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int dGn()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)yih.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).yiN).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = y.JfV;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> dGo()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)yig.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (arF((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.yfh;
        boolean bool = bt.kU(j.b.dta(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        d.g.b.k.g(localObject5, "it.value");
        localObject5 = (f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((f)localObject5).field_storyPostTime;
        Object localObject6 = i.yeK;
        if (i + i.dGU() < ce.asT())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.yfh;
          if ((!bt.kU(j.b.dta(), ((f)localObject5).getUserName())) || (((f)localObject5).field_storyPostTime <= ((f)localObject5).field_readTime / 1000L)) {
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
        if ((!((f)localObject5).isValid()) || (((f)localObject5).dKB())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = y.JfV;
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
  
  public final void dGp()
  {
    AppMethodBeat.i(119015);
    com.tencent.mm.ad.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.a.yip);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    ad.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHe().add((k.a)this);
    localObject = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHd().add((k.a)this);
    com.tencent.mm.ad.c.a(1000L, (d.g.a.a)d.yis);
    yim.alive();
    localObject = b.ygY;
    b.c(yin);
    AppMethodBeat.o(119003);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final b yir;
    
    static
    {
      AppMethodBeat.i(118977);
      yir = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final d yis;
    
    static
    {
      AppMethodBeat.i(118980);
      yis = new d();
      AppMethodBeat.o(118980);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final h yiy;
    
    static
    {
      AppMethodBeat.i(118993);
      yiy = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class l<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(119002);
      int i = d.b.a.a((Comparable)Integer.valueOf(((c)paramT2).hgr), (Comparable)Integer.valueOf(((c)paramT1).hgr));
      AppMethodBeat.o(119002);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a
 * JD-Core Version:    0.7.0.1
 */