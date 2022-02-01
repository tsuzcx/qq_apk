package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ub;
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
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a
  implements l.c, k.a
{
  public static final String TAG = "MicroMsg.ContactSyncFetcher";
  public static final LinkedList<l.b> lsJ;
  private static final Map<String, f> zvf;
  private static final Map<String, c> zvg;
  private static final List<String> zvh;
  private static final List<String> zvi;
  private static final List<String> zvj;
  private static final List<l.d> zvk;
  public static final i zvl;
  public static final r<Long, Boolean, String, String, y> zvm;
  public static final a zvn;
  
  static
  {
    AppMethodBeat.i(119022);
    zvn = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    zvf = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    zvg = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    zvh = Collections.synchronizedList((List)new LinkedList());
    zvi = Collections.synchronizedList((List)new LinkedList());
    zvj = Collections.synchronizedList((List)new LinkedList());
    zvk = Collections.synchronizedList((List)new LinkedList());
    lsJ = new LinkedList();
    zvl = new i();
    zvm = (r)a.j.zvz;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(ddk paramddk, com.tencent.mm.plugin.story.i.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramddk.FIZ != 0) && (paramddk.CreateTime > paramc.field_readCommentTime))
    {
      paramddk = paramddk.tlK;
      paramc = com.tencent.mm.plugin.story.f.j.zsh;
      if (!bs.lr(paramddk, j.b.dHx()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean awO(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.story.f.j.zsh;
        if (!bs.lr(paramString, j.b.dHx())) {
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
      if (paramj.dZn())
      {
        boolean bool = paramj.dZm();
        AppMethodBeat.o(119019);
        return bool;
      }
      paramj = paramj.field_userName;
      j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
      if (!bs.lr(paramj, j.b.dHx()))
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
  
  public static void dWD()
  {
    AppMethodBeat.i(119004);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_pullTest", (d.g.a.a)h.zvx);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> dWE()
  {
    AppMethodBeat.i(119010);
    ac.i(TAG, "displaySortedReplyUserList: size " + zvj.size());
    List localList1 = zvj;
    d.g.b.k.g(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)zvj);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> dWF()
  {
    AppMethodBeat.i(119011);
    ac.i(TAG, "displayNewList: size " + zvk.size());
    List localList1 = zvk;
    d.g.b.k.g(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)zvk);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void dWG()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = zvf;
        d.g.b.k.g(localObject3, "userStateMap");
        try
        {
          localObject5 = zvf.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (awO((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = com.tencent.mm.plugin.story.f.j.zsh;
          bool1 = bs.lr(j.b.dHx(), (String)((Map.Entry)localObject6).getKey());
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
        bool1 = ((f)localObject7).dZc();
      }
      finally {}
    }
    Object localObject5 = y.KTp;
    Object localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int m = ((com.tencent.mm.plugin.zero.b.a)localObject3).ZY().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    localObject3 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
    d.g.b.k.g(localObject3, "MMKernel.service<IConfig…onfigService::class.java)");
    int k = ((com.tencent.mm.plugin.zero.b.a)localObject3).ZY().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    ac.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + zvi.size() + ", displayOld:" + zvh.size() + ", displayNewReply:" + zvg.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!com.tencent.mm.plugin.story.c.a.e.zqS.dUI())
    {
      int j = 0;
      if (zvi.size() + zvh.size() + zvg.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          h.wUl.n(1015L, 10L, 1L);
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
          if (bs.pN(l1 / 1000L) < k) {
            break label1672;
          }
          h.wUl.n(1015L, 11L, 1L);
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
    localObject3 = (f)d.a.j.iP((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    zvi.clear();
    zvh.clear();
    zvj.clear();
    zvk.clear();
    localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    long l2 = ((com.tencent.mm.kernel.e)localObject3).agA().a(ah.a.GTd, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(zvg.values());
    localObject3 = ((Iterable)d.a.j.a((Iterable)localObject3, (Comparator)new a.l())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      zvj.add(((c)localObject5).ztM);
      if (((c)localObject5).hGU > l2 / 1000L) {
        zvk.add(new l.d(((c)localObject5).ztM, 1));
      }
    }
    localObject3 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject3, "MMKernel.storage()");
    long l3 = ((com.tencent.mm.kernel.e)localObject3).agA().a(ah.a.GTb, 0L);
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
        localObject6 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject6 = j.b.dVE();
        localObject7 = ((f)localObject5).getUserName();
        i = ce.azK();
        Object localObject8 = i.zrK;
        localObject6 = ((com.tencent.mm.plugin.story.i.k)localObject6).j((String)localObject7, false, i - i.dVv());
        localObject7 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject7 = j.b.dVE();
        localObject8 = ((f)localObject5).getUserName();
        i = ce.azK();
        i.a locala = i.zrK;
        if (com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject7, (String)localObject8, false, i - i.dVv()).size() != ((List)localObject6).size())
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
            if (!com.tencent.mm.plugin.story.c.a.e.zqS.dUI()) {
              break label1236;
            }
            zvi.add(((f)localObject5).getUserName());
            if (l1 > l2) {
              zvk.add(new l.d(((f)localObject5).getUserName(), 0));
            }
          }
          localObject6 = TAG;
          localObject5 = new StringBuilder("make list username:").append(((f)localObject5).getUserName()).append(" updateTime:").append(((f)localObject5).field_updateTime).append(" posTime:").append(((f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
          if (l1 <= l3) {
            break label1675;
          }
          bool2 = true;
          label1176:
          ac.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
        }
      }
      bool1 = false;
      continue;
      label1236:
      if (l1 > l3) {
        zvi.add(((f)localObject5).getUserName());
      } else {
        zvh.add(((f)localObject5).getUserName());
      }
    }
    Object localObject6 = com.tencent.mm.plugin.story.f.j.zsh;
    if (bs.lr(j.b.dHx(), ((f)localObject5).getUserName()))
    {
      l1 = ((f)localObject5).field_storyPostTime * 1000L;
      label1309:
      if (!com.tencent.mm.plugin.story.c.a.e.zqS.dUI()) {
        break label1529;
      }
      zvi.add(((f)localObject5).getUserName());
      if (l1 > l2) {
        zvk.add(new l.d(((f)localObject5).getUserName(), 0));
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
      ac.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
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
        zvi.add(((f)localObject5).getUserName());
        break label1362;
      }
      zvh.add(((f)localObject5).getUserName());
      break label1362;
      label1571:
      y localy = y.KTp;
      ac.i(TAG, "update time " + l3 + " displayUnreadUserList " + zvi + " displayOlderUserList " + zvh + " userReplyStateMap " + zvg + " displaySortedReplyUserList:" + zvj + " displayNewList:" + zvk);
      AppMethodBeat.o(119016);
      break label561;
      break;
      bool2 = false;
      break label1176;
    }
  }
  
  public static void dWH()
  {
    AppMethodBeat.i(119020);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)e.zvs);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!lsJ.contains(paramb)) {
      lsJ.add(paramb);
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
          ac.i(TAG, "[StoryExtInfo] unknown event ".concat(String.valueOf(paramString)));
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
      ac.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      Map localMap = zvf;
      d.g.b.k.g(localMap, "userStateMap");
      localMap.put(str, paramm);
      if ((d.g.b.k.g(paramString, "notify_story_preload") ^ true))
      {
        com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)f.zvu);
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
      ac.i(TAG, "[StoryInfo] unknown event ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(119021);
      return;
    } while (!paramString.equals("notify_story_info_delete"));
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)new g(paramm));
    AppMethodBeat.o(119021);
  }
  
  /* Error */
  public final int awN(String paramString)
  {
    // Byte code:
    //   0: ldc_w 896
    //   3: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 897
    //   10: invokestatic 900	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 155	com/tencent/mm/plugin/story/f/f/a:TAG	Ljava/lang/String;
    //   16: ldc_w 902
    //   19: aload_1
    //   20: invokestatic 852	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: invokevirtual 856	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 326	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: iconst_0
    //   30: istore_2
    //   31: aload_0
    //   32: monitorenter
    //   33: getstatic 170	com/tencent/mm/plugin/story/f/f/a:zvg	Ljava/util/Map;
    //   36: aload_1
    //   37: invokeinterface 796 2 0
    //   42: checkcast 539	com/tencent/mm/plugin/story/f/f/c
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +76 -> 123
    //   50: aload_1
    //   51: getfield 810	com/tencent/mm/plugin/story/f/f/c:zvM	Ljava/util/HashMap;
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
    //   98: checkcast 904	java/lang/Number
    //   101: invokevirtual 907	java/lang/Number:intValue	()I
    //   104: iadd
    //   105: istore_2
    //   106: goto -32 -> 74
    //   109: getstatic 394	d/y:KTp	Ld/y;
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: ldc_w 896
    //   118: invokestatic 205	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -12 -> 113
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: ldc_w 896
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
    lsJ.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final List<String> dUL()
  {
    AppMethodBeat.i(119008);
    ac.i(TAG, "getUnreadList: size " + zvi.size());
    List localList1 = zvi;
    d.g.b.k.g(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)zvi);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> dUM()
  {
    AppMethodBeat.i(119009);
    ac.i(TAG, "getOlderList: size " + zvh.size());
    List localList1 = zvh;
    d.g.b.k.g(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)zvh);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> dUN()
  {
    AppMethodBeat.i(119012);
    ac.i(TAG, "getNewReplyList: size " + zvg.size());
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = zvg;
      d.g.b.k.g(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).zvM.keySet());
        localObject3 = (Map)localLinkedHashMap;
        d.g.b.k.g(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = y.KTp;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int dUO()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)zvg.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).zvM).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = y.KTp;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> dUP()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)zvf.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (awO((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = com.tencent.mm.plugin.story.f.j.zsh;
        boolean bool = bs.lr(j.b.dHx(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        d.g.b.k.g(localObject5, "it.value");
        localObject5 = (f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((f)localObject5).field_storyPostTime;
        Object localObject6 = i.zrK;
        if (i + i.dVv() < ce.azK())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = com.tencent.mm.plugin.story.f.j.zsh;
          if ((!bs.lr(j.b.dHx(), ((f)localObject5).getUserName())) || (((f)localObject5).field_storyPostTime <= ((f)localObject5).field_readTime / 1000L)) {
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
        if ((!((f)localObject5).isValid()) || (((f)localObject5).dZc())) {
          break label419;
        }
        i = 1;
        break;
        localObject4 = y.KTp;
        ??? = (List)localObject1;
        if (((List)???).size() > 1) {
          d.a.j.a((List)???, (Comparator)new c());
        }
        ac.i(TAG, "getReadList: size " + localObject1.size());
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
  
  public final void dUQ()
  {
    AppMethodBeat.i(119015);
    com.tencent.mm.ac.c.b("ContactSyncFetcher_checkContactState", (d.g.a.a)a.zvo);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    ac.i(TAG, "init: ");
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVF().add((k.a)this);
    localObject = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVE().add((k.a)this);
    com.tencent.mm.ac.c.a(1000L, (d.g.a.a)d.zvr);
    zvl.alive();
    localObject = b.ztY;
    b.d(zvm);
    AppMethodBeat.o(119003);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a zvo;
    
    static
    {
      AppMethodBeat.i(118975);
      zvo = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final b zvq;
    
    static
    {
      AppMethodBeat.i(118977);
      zvq = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final d zvr;
    
    static
    {
      AppMethodBeat.i(118980);
      zvr = new d();
      AppMethodBeat.o(118980);
    }
    
    d()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final e zvs;
    
    static
    {
      AppMethodBeat.i(118984);
      zvs = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final f zvu;
    
    static
    {
      AppMethodBeat.i(118988);
      zvu = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(m paramm)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final h zvx;
    
    static
    {
      AppMethodBeat.i(118993);
      zvx = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class i
    extends com.tencent.mm.sdk.b.c<ub>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(ub paramub)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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