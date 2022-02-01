package com.tencent.mm.plugin.story.model.sync;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.api.l.a;
import com.tencent.mm.plugin.story.h.g;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.protocal.protobuf.fic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "talker", "", "(Ljava/lang/String;)V", "blackTagList", "", "chatRoomStgListener", "friendUnreadList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "kotlin.jvm.PlatformType", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasStory", "", "hasUnread", "isPause", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "nextFetchTime", "", "normalUnreadList", "readList", "roomMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roomMemberReady", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1;", "tryStartFetchRunnable", "Ljava/lang/Runnable;", "userUpdateMap", "", "", "addNewUserStory", "", "username", "extInfo", "checkChatRoomState", "checkExpire", "checkFetch", "checkStoryUnread", "destroy", "isRoomMember", "userName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "registerNotifyListener", "removeUserStory", "resume", "start", "tryStartFetch", "updateChatRoomState", "updateGalleryUserList", "updateUserState", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.story.api.l, MStorage.IOnStorageChange
{
  public static final d.a Snx;
  private static final String TAG;
  private boolean MVC;
  private List<String> QoT;
  private final List<r<String, com.tencent.mm.plugin.story.h.f>> SnA;
  private long SnB;
  private final Map<String, com.tencent.mm.plugin.story.h.f> SnC;
  private final Runnable SnD;
  private final ArrayList<String> SnE;
  private boolean SnF;
  private final MStorage.IOnStorageChange SnG;
  private final StoryStateFetcher.snsPermissionNotifyListener.1 SnH;
  public l.a Snp;
  private boolean Snr;
  private final List<r<String, com.tencent.mm.plugin.story.h.f>> Sny;
  private final List<r<String, com.tencent.mm.plugin.story.h.f>> Snz;
  private boolean hJi;
  private final MMHandler handler;
  private final String talker;
  
  static
  {
    AppMethodBeat.i(119070);
    Snx = new d.a((byte)0);
    TAG = "MicroMsg.StoryStateFetcher";
    AppMethodBeat.o(119070);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(119069);
    this.talker = paramString;
    this.Sny = Collections.synchronizedList((List)new ArrayList());
    this.Snz = Collections.synchronizedList((List)new ArrayList());
    this.SnA = Collections.synchronizedList((List)new ArrayList());
    this.SnC = Collections.synchronizedMap((Map)new HashMap());
    this.handler = new MMHandler(com.tencent.mm.kernel.h.baH().getLooper());
    this.SnD = new d..ExternalSyntheticLambda1(this);
    this.QoT = ((List)new LinkedList());
    this.SnE = new ArrayList();
    this.SnG = new d..ExternalSyntheticLambda0(this);
    this.SnH = new StoryStateFetcher.snsPermissionNotifyListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(119069);
  }
  
  private static final void a(d paramd)
  {
    int i = 1;
    AppMethodBeat.i(367171);
    kotlin.g.b.s.u(paramd, "this$0");
    StoryCore.b localb = StoryCore.SjP;
    if ((StoryCore.b.hwd()) && (!Util.isNullOrNil(paramd.talker)) && (au.bwG(paramd.talker)))
    {
      Log.i(TAG, kotlin.g.b.s.X("tryStartFetch ", paramd.talker));
      boolean bool;
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("StoryOpenRoomSync", 1) == 2)
      {
        bool = true;
        Log.i("LaunchStory", "isOpenRoomSync %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label173;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label178;
        }
        if (paramd.hJi) {
          break label187;
        }
        Log.i(TAG, kotlin.g.b.s.X("start fetch ", paramd.talker));
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)new com.tencent.mm.plugin.story.model.a.b(paramd.talker), 0);
        AppMethodBeat.o(367171);
        return;
        bool = false;
        break;
        label173:
        i = 0;
      }
      label178:
      Log.i(TAG, "filter RoomSync");
    }
    label187:
    AppMethodBeat.o(367171);
  }
  
  private static final void a(d paramd, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(367175);
    kotlin.g.b.s.u(paramd, "this$0");
    Log.i(TAG, kotlin.g.b.s.X("chatRoomStgListener ", paramString));
    if ((!paramd.SnF) && (kotlin.g.b.s.p(paramString, paramd.talker))) {
      com.tencent.mm.ae.d.d("StoryStateFetcher_updateChatRoom", (kotlin.g.a.a)new b(paramd));
    }
    AppMethodBeat.o(367175);
  }
  
  private final void a(String paramString, com.tencent.mm.plugin.story.h.f paramf)
  {
    AppMethodBeat.i(119064);
    if (this.QoT.contains(paramString))
    {
      AppMethodBeat.o(119064);
      return;
    }
    l.a locala = this.Snp;
    if (locala != null) {
      locala.dm(paramString, paramf.hzn());
    }
    bbZ(paramString);
    b(paramString, paramf);
    hxd();
    hxe();
    AppMethodBeat.o(119064);
  }
  
  private final void b(String paramString, com.tencent.mm.plugin.story.h.f paramf)
  {
    AppMethodBeat.i(119066);
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    boolean bool;
    if (localau == null) {
      bool = false;
    }
    while (paramf.hzn()) {
      if (bool)
      {
        this.SnA.add(new r(paramString, paramf));
        AppMethodBeat.o(119066);
        return;
        bool = com.tencent.mm.contact.d.rs(localau.field_type);
      }
      else
      {
        this.Snz.add(new r(paramString, paramf));
        AppMethodBeat.o(119066);
        return;
      }
    }
    if (paramf.isValid()) {
      this.Sny.add(new r(paramString, paramf));
    }
    AppMethodBeat.o(119066);
  }
  
  /* Error */
  private final void bbZ(String paramString)
  {
    // Byte code:
    //   0: ldc_w 466
    //   3: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 184	com/tencent/mm/plugin/story/model/sync/d:Snz	Ljava/util/List;
    //   10: astore_3
    //   11: aload_3
    //   12: ldc_w 467
    //   15: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 184	com/tencent/mm/plugin/story/model/sync/d:Snz	Ljava/util/List;
    //   24: astore_2
    //   25: aload_2
    //   26: ldc_w 467
    //   29: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload_2
    //   33: checkcast 409	java/lang/Iterable
    //   36: invokeinterface 413 1 0
    //   41: astore 4
    //   43: aload 4
    //   45: invokeinterface 418 1 0
    //   50: ifeq +238 -> 288
    //   53: aload 4
    //   55: invokeinterface 422 1 0
    //   60: astore_2
    //   61: aload_2
    //   62: checkcast 444	kotlin/r
    //   65: getfield 474	kotlin/r:bsC	Ljava/lang/Object;
    //   68: aload_1
    //   69: invokestatic 358	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   72: ifeq -29 -> 43
    //   75: aload_2
    //   76: checkcast 444	kotlin/r
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +14 -> 95
    //   84: aload_0
    //   85: getfield 184	com/tencent/mm/plugin/story/model/sync/d:Snz	Ljava/util/List;
    //   88: aload_2
    //   89: invokeinterface 477 2 0
    //   94: pop
    //   95: aload_3
    //   96: monitorexit
    //   97: aload_0
    //   98: getfield 186	com/tencent/mm/plugin/story/model/sync/d:SnA	Ljava/util/List;
    //   101: astore_3
    //   102: aload_3
    //   103: ldc_w 478
    //   106: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   109: aload_3
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield 186	com/tencent/mm/plugin/story/model/sync/d:SnA	Ljava/util/List;
    //   115: astore_2
    //   116: aload_2
    //   117: ldc_w 478
    //   120: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   123: aload_2
    //   124: checkcast 409	java/lang/Iterable
    //   127: invokeinterface 413 1 0
    //   132: astore 4
    //   134: aload 4
    //   136: invokeinterface 418 1 0
    //   141: ifeq +163 -> 304
    //   144: aload 4
    //   146: invokeinterface 422 1 0
    //   151: astore_2
    //   152: aload_2
    //   153: checkcast 444	kotlin/r
    //   156: getfield 474	kotlin/r:bsC	Ljava/lang/Object;
    //   159: aload_1
    //   160: invokestatic 358	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   163: ifeq -29 -> 134
    //   166: aload_2
    //   167: checkcast 444	kotlin/r
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +14 -> 186
    //   175: aload_0
    //   176: getfield 186	com/tencent/mm/plugin/story/model/sync/d:SnA	Ljava/util/List;
    //   179: aload_2
    //   180: invokeinterface 477 2 0
    //   185: pop
    //   186: aload_3
    //   187: monitorexit
    //   188: aload_0
    //   189: getfield 182	com/tencent/mm/plugin/story/model/sync/d:Sny	Ljava/util/List;
    //   192: astore_3
    //   193: aload_3
    //   194: ldc_w 479
    //   197: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   200: aload_3
    //   201: monitorenter
    //   202: aload_0
    //   203: getfield 182	com/tencent/mm/plugin/story/model/sync/d:Sny	Ljava/util/List;
    //   206: astore_2
    //   207: aload_2
    //   208: ldc_w 479
    //   211: invokestatic 470	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   214: aload_2
    //   215: checkcast 409	java/lang/Iterable
    //   218: invokeinterface 413 1 0
    //   223: astore 4
    //   225: aload 4
    //   227: invokeinterface 418 1 0
    //   232: ifeq +88 -> 320
    //   235: aload 4
    //   237: invokeinterface 422 1 0
    //   242: astore_2
    //   243: aload_2
    //   244: checkcast 444	kotlin/r
    //   247: getfield 474	kotlin/r:bsC	Ljava/lang/Object;
    //   250: aload_1
    //   251: invokestatic 358	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   254: ifeq -29 -> 225
    //   257: aload_2
    //   258: astore_1
    //   259: aload_1
    //   260: checkcast 444	kotlin/r
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +14 -> 279
    //   268: aload_0
    //   269: getfield 182	com/tencent/mm/plugin/story/model/sync/d:Sny	Ljava/util/List;
    //   272: aload_1
    //   273: invokeinterface 477 2 0
    //   278: pop
    //   279: aload_3
    //   280: monitorexit
    //   281: ldc_w 466
    //   284: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: return
    //   288: aconst_null
    //   289: astore_2
    //   290: goto -215 -> 75
    //   293: astore_1
    //   294: aload_3
    //   295: monitorexit
    //   296: ldc_w 466
    //   299: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: aload_1
    //   303: athrow
    //   304: aconst_null
    //   305: astore_2
    //   306: goto -140 -> 166
    //   309: astore_1
    //   310: aload_3
    //   311: monitorexit
    //   312: ldc_w 466
    //   315: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aload_1
    //   319: athrow
    //   320: aconst_null
    //   321: astore_1
    //   322: goto -63 -> 259
    //   325: astore_1
    //   326: aload_3
    //   327: monitorexit
    //   328: ldc_w 466
    //   331: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	d
    //   0	336	1	paramString	String
    //   24	282	2	localObject	Object
    //   10	317	3	localList	List
    //   41	195	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   20	43	293	finally
    //   43	75	293	finally
    //   75	80	293	finally
    //   84	95	293	finally
    //   111	134	309	finally
    //   134	166	309	finally
    //   166	171	309	finally
    //   175	186	309	finally
    //   202	225	325	finally
    //   225	257	325	finally
    //   259	264	325	finally
    //   268	279	325	finally
  }
  
  private final void hxd()
  {
    AppMethodBeat.i(119061);
    Object localObject = this.Snz;
    kotlin.g.b.s.s(localObject, "normalUnreadList");
    int i;
    label68:
    boolean bool1;
    if (!((Collection)localObject).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        localObject = this.SnA;
        kotlin.g.b.s.s(localObject, "friendUnreadList");
        if (((Collection)localObject).isEmpty()) {
          break label161;
        }
        i = 1;
        if (i == 0) {
          break label166;
        }
      }
      bool1 = true;
      label74:
      if (!bool1)
      {
        localObject = this.Sny;
        kotlin.g.b.s.s(localObject, "readList");
        if (((Collection)localObject).isEmpty()) {
          break label171;
        }
        i = 1;
        label107:
        if (i == 0) {
          break label176;
        }
      }
    }
    label161:
    label166:
    label171:
    label176:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((this.MVC != bool2) || (this.Snr != bool1))
      {
        localObject = this.Snp;
        if (localObject != null) {
          ((l.a)localObject).bb(bool2, bool1);
        }
      }
      AppMethodBeat.o(119061);
      return;
      i = 0;
      break;
      i = 0;
      break label68;
      bool1 = false;
      break label74;
      i = 0;
      break label107;
    }
  }
  
  private final void hxe()
  {
    AppMethodBeat.i(119062);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.SnA;
    kotlin.g.b.s.s(localObject1, "friendUnreadList");
    if (((List)localObject1).size() > 1) {
      kotlin.a.p.a((List)localObject1, (Comparator)new d.e());
    }
    localObject1 = this.Snz;
    kotlin.g.b.s.s(localObject1, "normalUnreadList");
    if (((List)localObject1).size() > 1) {
      kotlin.a.p.a((List)localObject1, (Comparator)new d.f());
    }
    localObject1 = "";
    ??? = ((d)this).Snz;
    kotlin.g.b.s.s(???, "normalUnreadList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        ??? = ((Iterable)???).iterator();
        i = 0;
        if (((Iterator)???).hasNext())
        {
          localObject11 = (r)((Iterator)???).next();
          localObject1 = (String)localObject1 + "unRead:" + i + ' ' + Util.getSizeKB(((com.tencent.mm.plugin.story.h.f)((r)localObject11).bsD).hzl()) + "  userName:" + ((com.tencent.mm.plugin.story.h.f)((r)localObject11).bsD).getUserName() + " |, ";
          if (i > 2)
          {
            Log.i(TAG, kotlin.g.b.s.X("unRead preLoadCache: ", localObject1));
            ??? = new ArrayList();
            localObject1 = null;
            ??? = this.SnA;
            kotlin.g.b.s.s(???, "friendUnreadList");
            if (!((Collection)???).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1020;
              }
              if (((com.tencent.mm.plugin.story.h.f)((r)this.SnA.get(0)).bsD).hzl() > 0L)
              {
                localObject1 = this.SnA.get(0);
                this.SnA.remove(localObject1);
              }
              ??? = this.SnA;
              kotlin.g.b.s.s(???, "friendUnreadList");
              Collections.shuffle((List)???, new Random());
              if ((r)localObject1 != null) {
                this.SnA.add(0, localObject1);
              }
              ??? = this.SnA;
              kotlin.g.b.s.s(???, "friendUnreadList");
              synchronized ((Iterable)???)
              {
                localObject11 = ((Iterable)???).iterator();
                if (!((Iterator)localObject11).hasNext()) {
                  break label493;
                }
                ((ArrayList)???).add(((r)((Iterator)localObject11).next()).bsC);
              }
            }
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          ??? = ah.aiuX;
        }
      }
      int i = 0;
      continue;
      label493:
      Object localObject11 = ah.aiuX;
      if (((ArrayList)???).isEmpty())
      {
        ??? = this.Snz;
        kotlin.g.b.s.s(???, "normalUnreadList");
        if (((Collection)???).isEmpty()) {
          break label681;
        }
        i = 1;
        if (i != 0)
        {
          if (((com.tencent.mm.plugin.story.h.f)((r)this.Snz.get(0)).bsD).hzl() <= 0L) {
            break label1017;
          }
          ??? = this.Snz.get(0);
          this.Snz.remove(???);
        }
      }
      label681:
      label686:
      label1017:
      for (;;)
      {
        ??? = (r)???;
        if (??? != null) {
          this.Snz.add(0, ???);
        }
        ??? = this.Snz;
        kotlin.g.b.s.s(???, "normalUnreadList");
        synchronized ((Iterable)???)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label686;
          }
          ((ArrayList)???).add(((r)((Iterator)???).next()).bsC);
        }
        i = 0;
        break;
        ??? = ah.aiuX;
        ??? = new ArrayList();
        ??? = this.Sny;
        kotlin.g.b.s.s(???, "readList");
        synchronized ((Iterable)???)
        {
          localObject11 = ((Iterable)???).iterator();
          if (((Iterator)localObject11).hasNext()) {
            ((ArrayList)???).add((r)((Iterator)localObject11).next());
          }
        }
        localObject11 = ah.aiuX;
        ??? = new ArrayList();
        localObject11 = (List)???;
        if (((List)localObject11).size() > 1) {
          kotlin.a.p.a((List)localObject11, (Comparator)new d.g());
        }
        synchronized ((Iterable)???)
        {
          localObject11 = ((Iterable)???).iterator();
          if (((Iterator)localObject11).hasNext()) {
            ((ArrayList)???).add(((r)((Iterator)localObject11).next()).bsC);
          }
        }
        localObject11 = ah.aiuX;
        ??? = ((Iterable)???).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject11 = (String)((Iterator)???).next();
          if (!localObject8.contains(localObject11)) {
            localObject8.add(localObject11);
          }
        }
        localObject6 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          ??? = (String)((Iterator)localObject6).next();
          if (!localObject8.contains(???)) {
            localObject8.add(???);
          }
        }
        localObject6 = this.Snp;
        if (localObject6 != null) {
          ((l.a)localObject6).a((List)localObject8, (ArrayList)???);
        }
        AppMethodBeat.o(119062);
        return;
      }
      label1020:
      Object localObject6 = null;
    }
  }
  
  private final void hxf()
  {
    long l1 = 0L;
    AppMethodBeat.i(119063);
    long l2 = this.SnB - System.currentTimeMillis();
    if (l2 < 0L) {
      this.SnB = System.currentTimeMillis();
    }
    for (;;)
    {
      this.handler.removeCallbacks(this.SnD);
      this.handler.postDelayed(this.SnD, l1);
      AppMethodBeat.o(119063);
      return;
      l1 = l2;
    }
  }
  
  public final void a(l.a parama)
  {
    this.Snp = parama;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(119059);
    Log.i(TAG, "endSession " + this.talker + ' ' + hashCode());
    com.tencent.mm.kernel.h.baD().mCm.b(998, (com.tencent.mm.am.h)this);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvS().remove((MStorage.IOnStorageChange)this);
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().remove(this.SnG);
    this.handler.removeCallbacks(this.SnD);
    this.SnH.dead();
    AppMethodBeat.o(119059);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(119067);
    if ((paramString != null) && (paramMStorageEventData != null) && ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.story.h.f)))
    {
      paramMStorageEventData = paramMStorageEventData.obj;
      if (paramMStorageEventData == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(119067);
        throw paramString;
      }
      paramMStorageEventData = (com.tencent.mm.plugin.story.h.f)paramMStorageEventData;
      if (!this.SnE.contains(paramMStorageEventData.getUserName()))
      {
        AppMethodBeat.o(119067);
        return;
      }
      if (com.tencent.mm.plugin.sns.easteregg.a.aXM(paramMStorageEventData.getUserName()))
      {
        AppMethodBeat.o(119067);
        return;
      }
      Map localMap = this.SnC;
      kotlin.g.b.s.s(localMap, "userUpdateMap");
      localMap.put(paramMStorageEventData.getUserName(), paramMStorageEventData);
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(119067);
      return;
      if (!paramString.equals("notify_story_unread"))
      {
        AppMethodBeat.o(119067);
        return;
        if (paramString.equals("notify_story_invalid")) {
          break label451;
        }
        AppMethodBeat.o(119067);
        return;
        if (paramString.equals("notify_story_valid")) {
          break label499;
        }
        AppMethodBeat.o(119067);
        return;
        if (!paramString.equals("notify_story_read"))
        {
          AppMethodBeat.o(119067);
          return;
          if (!paramString.equals("notify_story_preload")) {
            AppMethodBeat.o(119067);
          }
        }
        else
        {
          Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + " as read");
          a(paramMStorageEventData.getUserName(), paramMStorageEventData);
          AppMethodBeat.o(119067);
        }
      }
      else
      {
        Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + " as unread");
        a(paramMStorageEventData.getUserName(), paramMStorageEventData);
        AppMethodBeat.o(119067);
        return;
      }
      Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + ' ' + paramMStorageEventData.field_syncId + " as preload " + paramMStorageEventData.hzl());
      a(paramMStorageEventData.getUserName(), paramMStorageEventData);
      AppMethodBeat.o(119067);
      return;
      label451:
      Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + " as invalid");
      a(paramMStorageEventData.getUserName(), paramMStorageEventData);
      AppMethodBeat.o(119067);
      return;
      label499:
      Log.i(TAG, "update user " + paramMStorageEventData.getUserName() + " as valid");
      a(paramMStorageEventData.getUserName(), paramMStorageEventData);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(119068);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + paramp.getType());
    if ((paramp.getType() == 998) && ((paramp instanceof com.tencent.mm.plugin.story.model.a.b)))
    {
      if (!kotlin.g.b.s.p(((com.tencent.mm.plugin.story.model.a.b)paramp).pJq, this.talker))
      {
        AppMethodBeat.o(119068);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = c.c.b(((com.tencent.mm.plugin.story.model.a.b)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncResponse");
          AppMethodBeat.o(119068);
          throw paramString;
        }
        paramString = (fic)paramString;
        Log.i(TAG, "response: count " + paramString.abIS + ", interval " + paramString.abIU);
        paramString = StoryCore.SjP;
        this.SnB = StoryCore.b.hvT().bcr(this.talker).field_nextSyncTime;
        hxf();
        AppMethodBeat.o(119068);
        return;
      }
      paramString = StoryCore.SjP;
      this.SnB = StoryCore.b.hvT().bcr(this.talker).field_nextSyncTime;
      hxf();
    }
    AppMethodBeat.o(119068);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(119058);
    this.hJi = true;
    this.handler.removeCallbacks(this.SnD);
    AppMethodBeat.o(119058);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(119057);
    this.hJi = false;
    hxf();
    com.tencent.mm.ae.d.d("StoryStateFetcher_checkExpire", (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(119057);
  }
  
  public final void start()
  {
    AppMethodBeat.i(119056);
    com.tencent.mm.ae.d.d("StoryStateFetcher_updateChatRoom", (kotlin.g.a.a)new d(this));
    this.SnH.alive();
    com.tencent.mm.kernel.h.baD().mCm.a(998, (com.tencent.mm.am.h)this);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hvS().add((MStorage.IOnStorageChange)this, Looper.getMainLooper());
    ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().add(this.SnG);
    AppMethodBeat.o(119056);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.d
 * JD-Core Version:    0.7.0.1
 */