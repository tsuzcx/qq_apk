package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.api.l.b;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.story.api.l.d;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.b.b;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", "listener", "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", "username", "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", "comment", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", "init", "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements l.c, MStorage.IOnStorageChange
{
  public static final a SmO;
  private static final Map<String, com.tencent.mm.plugin.story.h.f> SmP;
  private static final Map<String, c> SmQ;
  private static final List<String> SmR;
  private static final List<String> SmS;
  private static final List<String> SmT;
  private static final List<l.d> SmU;
  public static final ContactSyncFetcher.snsPermissionNotifyListener.1 SmV;
  public static final r<Long, Boolean, String, String, ah> SmW;
  public static final String TAG;
  public static final LinkedList<l.b> tjb;
  
  static
  {
    AppMethodBeat.i(119022);
    SmO = new a();
    TAG = "MicroMsg.ContactSyncFetcher";
    SmP = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    SmQ = Collections.synchronizedMap((Map)new ConcurrentHashMap());
    SmR = Collections.synchronizedList((List)new LinkedList());
    SmS = Collections.synchronizedList((List)new LinkedList());
    SmT = Collections.synchronizedList((List)new LinkedList());
    SmU = Collections.synchronizedList((List)new LinkedList());
    tjb = new LinkedList();
    SmV = new ContactSyncFetcher.snsPermissionNotifyListener.1(com.tencent.mm.app.f.hfK);
    SmW = (r)i.Sni;
    AppMethodBeat.o(119022);
  }
  
  private static boolean a(fie paramfie, com.tencent.mm.plugin.story.h.c paramc)
  {
    AppMethodBeat.i(119018);
    if ((paramfie.abDh != 0) && (paramfie.CreateTime > paramc.field_readCommentTime))
    {
      paramfie = paramfie.IMh;
      paramc = StoryCore.SjP;
      if (!Util.isEqual(paramfie, StoryCore.b.hgg()))
      {
        AppMethodBeat.o(119018);
        return true;
      }
    }
    AppMethodBeat.o(119018);
    return false;
  }
  
  private static boolean bbX(String paramString)
  {
    AppMethodBeat.i(119017);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = StoryCore.SjP;
        if (!Util.isEqual(paramString, StoryCore.b.hgg())) {
          break;
        }
      }
      AppMethodBeat.o(119017);
      return true;
    }
    AppMethodBeat.o(119017);
    return false;
  }
  
  private static boolean c(j paramj)
  {
    AppMethodBeat.i(119019);
    if (paramj == null)
    {
      AppMethodBeat.o(119019);
      return false;
    }
    if (paramj.hzy())
    {
      boolean bool = paramj.hzx();
      AppMethodBeat.o(119019);
      return bool;
    }
    paramj = paramj.field_userName;
    StoryCore.b localb = StoryCore.SjP;
    if (!Util.isEqual(paramj, StoryCore.b.hgg()))
    {
      AppMethodBeat.o(119019);
      return true;
    }
    AppMethodBeat.o(119019);
    return false;
  }
  
  public static void hwQ()
  {
    AppMethodBeat.i(119004);
    d.d("ContactSyncFetcher_pullTest", (kotlin.g.a.a)h.Sng);
    AppMethodBeat.o(119004);
  }
  
  public static List<String> hwR()
  {
    AppMethodBeat.i(119010);
    Log.i(TAG, s.X("displaySortedReplyUserList: size ", Integer.valueOf(SmT.size())));
    List localList1 = SmT;
    s.s(localList1, "displayReplyUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)SmT);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119010);
    }
  }
  
  public static List<l.d> hwS()
  {
    AppMethodBeat.i(119011);
    Log.i(TAG, s.X("displayNewList: size ", Integer.valueOf(SmU.size())));
    List localList1 = SmU;
    s.s(localList1, "displayNewList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)SmU);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119011);
    }
  }
  
  private final void hwT()
  {
    Object localObject7;
    boolean bool1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(119016);
        LinkedList localLinkedList = new LinkedList();
        localObject3 = SmP;
        s.s(localObject3, "userStateMap");
        try
        {
          localObject5 = SmP.entrySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (Map.Entry)((Iterator)localObject5).next();
          if (bbX((String)((Map.Entry)localObject6).getKey())) {
            continue;
          }
          localObject7 = StoryCore.SjP;
          bool1 = Util.isEqual(StoryCore.b.hgg(), (String)((Map.Entry)localObject6).getKey());
          localObject7 = ((Map.Entry)localObject6).getValue();
          s.s(localObject7, "it.value");
          localObject7 = (com.tencent.mm.plugin.story.h.f)localObject7;
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
        bool1 = ((com.tencent.mm.plugin.story.h.f)localObject7).hzn();
      }
      finally {}
    }
    Object localObject5 = ah.aiuX;
    int m = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
    int k = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", 3600);
    Log.i(TAG, "updateUnreadList: unread " + localObject2.size() + ", displayUnread:" + SmS.size() + ", displayOld:" + SmR.size() + ", displayNewReply:" + SmQ.size() + ", totalCount:" + m + ", showDuration:" + k);
    int i;
    long l1;
    if (!e.Sjb.huS())
    {
      int j = 0;
      if (SmS.size() + SmR.size() + SmQ.size() > 0) {
        j = 1;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (localObject2.size() >= m)
        {
          com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 10L, 1L);
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
          localObject5 = (com.tencent.mm.plugin.story.h.f)((Iterator)localObject3).next();
          l2 = ((com.tencent.mm.plugin.story.h.f)localObject5).field_updateTime;
          l1 = l2;
          if (l2 == 0L) {
            l1 = ((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime * 1000L;
          }
          if (Util.secondsToNow(l1 / 1000L) < k) {
            break label1624;
          }
          com.tencent.mm.plugin.report.service.h.OAn.p(1015L, 11L, 1L);
          i = 1;
          break label1624;
        }
      }
      if (j == 0)
      {
        AppMethodBeat.o(119016);
        label537:
        return;
      }
    }
    Object localObject3 = (List)localObject2;
    if (((List)localObject3).size() > 1) {
      p.a((List)localObject3, (Comparator)new a.j());
    }
    localObject3 = (com.tencent.mm.plugin.story.h.f)p.oL((List)localObject2);
    if (localObject3 != null)
    {
      localObject2.remove(localObject3);
      localObject2.add(0, localObject3);
    }
    SmS.clear();
    SmR.clear();
    SmT.clear();
    SmU.clear();
    long l2 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acYP, 0L);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(SmQ.values());
    localObject3 = ((Iterable)p.a((Iterable)localObject3, (Comparator)new a.k())).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (c)((Iterator)localObject3).next();
      SmT.add(((c)localObject5).SlC);
      if (((c)localObject5).createTime > l2 / 1000L) {
        SmU.add(new l.d(((c)localObject5).SlC, 1));
      }
    }
    long l3 = com.tencent.mm.kernel.h.baE().ban().a(at.a.acYN, 0L);
    for (;;)
    {
      synchronized ((Iterable)localObject2)
      {
        localObject3 = ???.iterator();
        label816:
        if (!((Iterator)localObject3).hasNext()) {
          break label1523;
        }
        localObject5 = (com.tencent.mm.plugin.story.h.f)((Iterator)localObject3).next();
        localObject6 = StoryCore.SjP;
        localObject6 = StoryCore.b.hvR();
        localObject7 = ((com.tencent.mm.plugin.story.h.f)localObject5).getUserName();
        i = cn.getSyncServerTimeSecond();
        Object localObject8 = i.SjL;
        localObject6 = ((k)localObject6).l((String)localObject7, false, i - i.hvz());
        localObject7 = StoryCore.SjP;
        localObject7 = StoryCore.b.hvR();
        localObject8 = ((com.tencent.mm.plugin.story.h.f)localObject5).getUserName();
        i = cn.getSyncServerTimeSecond();
        i.a locala = i.SjL;
        if (k.a((k)localObject7, (String)localObject8, false, i - i.hvz()).size() != ((List)localObject6).size())
        {
          bool1 = true;
          if (!bool1) {
            break;
          }
          if (((List)localObject6).isEmpty()) {
            continue;
          }
          l1 = ((j)((List)localObject6).get(0)).field_createTime * 1000L;
          if (l1 > ((com.tencent.mm.plugin.story.h.f)localObject5).field_readTime)
          {
            if (!e.Sjb.huS()) {
              break label1188;
            }
            SmS.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
            if (l1 > l2) {
              SmU.add(new l.d(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName(), 0));
            }
          }
          localObject6 = TAG;
          localObject5 = new StringBuilder("make list username:").append(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName()).append(" updateTime:").append(((com.tencent.mm.plugin.story.h.f)localObject5).field_updateTime).append(" posTime:").append(((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
          if (l1 <= l3) {
            break label1627;
          }
          bool2 = true;
          label1128:
          Log.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
        }
      }
      bool1 = false;
      continue;
      label1188:
      if (l1 > l3) {
        SmS.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
      } else {
        SmR.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
      }
    }
    Object localObject6 = StoryCore.SjP;
    if (Util.isEqual(StoryCore.b.hgg(), ((com.tencent.mm.plugin.story.h.f)localObject5).getUserName()))
    {
      l1 = ((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime * 1000L;
      label1261:
      if (!e.Sjb.huS()) {
        break label1481;
      }
      SmS.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
      if (l1 > l2) {
        SmU.add(new l.d(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName(), 0));
      }
      label1314:
      localObject6 = TAG;
      localObject5 = new StringBuilder("make list username:").append(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName()).append(" updateTime:").append(((com.tencent.mm.plugin.story.h.f)localObject5).field_updateTime).append(" posTime:").append(((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime).append(" makeTime:").append(l3).append(" itUpdateTime ").append(l1).append(" result ");
      if (l1 <= l3) {
        break label1633;
      }
    }
    label1481:
    label1624:
    label1627:
    label1633:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i((String)localObject6, bool2 + " hasInvisibleItem:" + bool1 + " lastShowEntranceTime:" + l2);
      break label816;
      if (((com.tencent.mm.plugin.story.h.f)localObject5).field_updateTime == 0L)
      {
        l1 = ((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime * 1000L;
        break label1261;
      }
      l1 = ((com.tencent.mm.plugin.story.h.f)localObject5).field_updateTime;
      break label1261;
      if (l1 > l3)
      {
        SmS.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
        break label1314;
      }
      SmR.add(((com.tencent.mm.plugin.story.h.f)localObject5).getUserName());
      break label1314;
      label1523:
      ah localah = ah.aiuX;
      Log.i(TAG, "update time " + l3 + " displayUnreadUserList " + SmS + " displayOlderUserList " + SmR + " userReplyStateMap " + SmQ + " displaySortedReplyUserList:" + SmT + " displayNewList:" + SmU);
      AppMethodBeat.o(119016);
      break label537;
      break;
      bool2 = false;
      break label1128;
    }
  }
  
  public static void hwU()
  {
    AppMethodBeat.i(119020);
    d.d("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)e.Snb);
    AppMethodBeat.o(119020);
  }
  
  public final void a(l.b paramb)
  {
    AppMethodBeat.i(119005);
    if (!tjb.contains(paramb)) {
      tjb.add(paramb);
    }
    AppMethodBeat.o(119005);
  }
  
  public final void b(l.b paramb)
  {
    AppMethodBeat.i(119006);
    tjb.remove(paramb);
    AppMethodBeat.o(119006);
  }
  
  public final int bbW(String paramString)
  {
    AppMethodBeat.i(119014);
    s.u(paramString, "storyOwner");
    Log.i(TAG, s.X("getNewReplyCount: storyOwner ", paramString));
    int i = 0;
    int j = 0;
    try
    {
      paramString = (c)SmQ.get(paramString);
      if (paramString != null)
      {
        paramString = ((Map)paramString.Snw).entrySet().iterator();
        i = j;
        while (paramString.hasNext()) {
          i += ((Number)((Map.Entry)paramString.next()).getValue()).intValue();
        }
        paramString = ah.aiuX;
      }
      return i;
    }
    finally
    {
      AppMethodBeat.o(119014);
    }
  }
  
  public final List<String> huV()
  {
    AppMethodBeat.i(119008);
    Log.i(TAG, s.X("getUnreadList: size ", Integer.valueOf(SmS.size())));
    List localList1 = SmS;
    s.s(localList1, "displayUnreadUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)SmS);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119008);
    }
  }
  
  public final List<String> huW()
  {
    AppMethodBeat.i(119009);
    Log.i(TAG, s.X("getOlderList: size ", Integer.valueOf(SmR.size())));
    List localList1 = SmR;
    s.s(localList1, "displayOlderUserList");
    try
    {
      List localList2 = (List)new LinkedList((Collection)SmR);
      return localList2;
    }
    finally
    {
      AppMethodBeat.o(119009);
    }
  }
  
  public final LinkedHashMap<String, ArrayList<Long>> huX()
  {
    AppMethodBeat.i(119012);
    Log.i(TAG, s.X("getNewReplyList: size ", Integer.valueOf(SmQ.size())));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = SmQ;
      s.s(localObject1, "userReplyStateMap");
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        Object localObject3 = (c)((Map.Entry)localObject2).getValue();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).addAll((Collection)((c)localObject3).Snw.keySet());
        localObject3 = (Map)localLinkedHashMap;
        s.s(str, "storyOwner");
        ((Map)localObject3).put(str, localObject2);
      }
      localObject1 = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(119012);
    }
    AppMethodBeat.o(119012);
    return localLinkedHashMap1;
  }
  
  public final int huY()
  {
    AppMethodBeat.i(119013);
    int i = 0;
    synchronized ((Iterable)SmQ.entrySet())
    {
      Object localObject1 = ???.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        Iterator localIterator = ((Map)((c)((Map.Entry)((Iterator)localObject1).next()).getValue()).Snw).entrySet().iterator();
        for (int j = i;; j = ((Number)((Map.Entry)localIterator.next()).getValue()).intValue() + j)
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      localObject1 = ah.aiuX;
      AppMethodBeat.o(119013);
      return i;
    }
  }
  
  public final List<String> huZ()
  {
    AppMethodBeat.i(119007);
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      synchronized ((Iterable)SmP.entrySet())
      {
        localObject4 = ((Iterable)???).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label265;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject4).next();
        if (bbX((String)localEntry.getKey())) {
          continue;
        }
        localObject5 = StoryCore.SjP;
        boolean bool = Util.isEqual(StoryCore.b.hgg(), (String)localEntry.getKey());
        localObject5 = localEntry.getValue();
        s.s(localObject5, "it.value");
        localObject5 = (com.tencent.mm.plugin.story.h.f)localObject5;
        if (!bool) {
          break label244;
        }
        i = ((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime;
        Object localObject6 = i.SjL;
        if (i + i.hvz() < cn.getSyncServerTimeSecond())
        {
          i = 1;
          if (i != 0) {
            break label239;
          }
          localObject6 = StoryCore.SjP;
          if ((!Util.isEqual(StoryCore.b.hgg(), ((com.tencent.mm.plugin.story.h.f)localObject5).getUserName())) || (((com.tencent.mm.plugin.story.h.f)localObject5).field_storyPostTime <= ((com.tencent.mm.plugin.story.h.f)localObject5).field_readTime / 1000L)) {
            break label234;
          }
          i = 1;
          break label403;
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
        if ((!((com.tencent.mm.plugin.story.h.f)localObject5).isValid()) || (((com.tencent.mm.plugin.story.h.f)localObject5).hzn())) {
          break label412;
        }
        i = 1;
        break;
        localObject4 = ah.aiuX;
        ??? = (List)localObject1;
        if (((List)???).size() > 1) {
          p.a((List)???, (Comparator)new a.c());
        }
        Log.i(TAG, s.X("getReadList: size ", Integer.valueOf(localObject1.size())));
        ??? = (Iterable)localObject1;
        Object localObject2 = (Collection)new ArrayList(p.a((Iterable)???, 10));
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((Collection)localObject2).add(((com.tencent.mm.plugin.story.h.f)((Iterator)???).next()).getUserName());
        }
        localObject2 = (List)localObject2;
        AppMethodBeat.o(119007);
        return localObject2;
      }
      label265:
      label403:
      i = 1;
      continue;
      label412:
      i = 0;
    }
  }
  
  public final void hva()
  {
    AppMethodBeat.i(119015);
    d.d("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)a.SmX);
    AppMethodBeat.o(119015);
  }
  
  public final void init()
  {
    AppMethodBeat.i(119003);
    Log.i(TAG, "init: ");
    Object localObject = StoryCore.SjP;
    StoryCore.b.hvS().add((MStorage.IOnStorageChange)this);
    localObject = StoryCore.SjP;
    StoryCore.b.hvR().add((MStorage.IOnStorageChange)this);
    d.a(1000L, (kotlin.g.a.a)a.d.Sna);
    SmV.alive();
    localObject = b.SlF;
    b.g(SmW);
    AppMethodBeat.o(119003);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119021);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.h.f)))
    {
      switch (paramString.hashCode())
      {
      default: 
      case 632036207: 
        do
        {
          Log.i(TAG, s.X("[StoryExtInfo] unknown event ", paramString));
          AppMethodBeat.o(119021);
          return;
        } while (!paramString.equals("notify_story_unread"));
      }
      for (;;)
      {
        paramMStorageEventData = paramMStorageEventData.obj;
        if (paramMStorageEventData != null) {
          break label190;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119021);
        throw paramString;
        if (!paramString.equals("notify_story_invalid"))
        {
          break;
          if (!paramString.equals("notify_story_valid"))
          {
            break;
            if (!paramString.equals("notify_story_read")) {
              if ((goto 80) || (!paramString.equals("notify_story_preload"))) {
                break;
              }
            }
          }
        }
      }
      label190:
      paramMStorageEventData = (com.tencent.mm.plugin.story.h.f)paramMStorageEventData;
      String str = paramMStorageEventData.getUserName();
      Log.i(TAG, "[StoryExtInfo] onNotifyChange: event " + paramString + ' ' + str);
      Map localMap = SmP;
      s.s(localMap, "userStateMap");
      localMap.put(str, paramMStorageEventData);
      if (!s.p(paramString, "notify_story_preload"))
      {
        d.d("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)f.Snd);
        AppMethodBeat.o(119021);
      }
    }
    else if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof j)))
    {
      if (s.p(paramString, "notify_story_info_delete"))
      {
        d.d("ContactSyncFetcher_checkContactState", (kotlin.g.a.a)new g(paramMStorageEventData));
        AppMethodBeat.o(119021);
        return;
      }
      Log.i(TAG, s.X("[StoryInfo] unknown event ", paramString));
    }
    AppMethodBeat.o(119021);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a SmX;
    
    static
    {
      AppMethodBeat.i(118975);
      SmX = new a();
      AppMethodBeat.o(118975);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b SmZ;
    
    static
    {
      AppMethodBeat.i(118977);
      SmZ = new b();
      AppMethodBeat.o(118977);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final e Snb;
    
    static
    {
      AppMethodBeat.i(118984);
      Snb = new e();
      AppMethodBeat.o(118984);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final f Snd;
    
    static
    {
      AppMethodBeat.i(118988);
      Snd = new f();
      AppMethodBeat.o(118988);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(MStorageEventData paramMStorageEventData)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final h Sng;
    
    static
    {
      AppMethodBeat.i(118993);
      Sng = new h();
      AppMethodBeat.o(118993);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements r<Long, Boolean, String, String, ah>
  {
    public static final i Sni;
    
    static
    {
      AppMethodBeat.i(119000);
      Sni = new i();
      AppMethodBeat.o(119000);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.a
 * JD-Core Version:    0.7.0.1
 */