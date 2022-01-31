package com.tencent.mm.plugin.story.model.f;

import a.o;
import a.v;
import a.y;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
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

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "talker", "", "(Ljava/lang/String;)V", "blackTagList", "", "chatRoomStgListener", "friendUnreadList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "kotlin.jvm.PlatformType", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasStory", "", "hasUnread", "isPause", "listener", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "nextFetchTime", "", "normalUnreadList", "readList", "roomMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roomMemberReady", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1;", "tryStartFetchRunnable", "Ljava/lang/Runnable;", "userUpdateMap", "", "", "addNewUserStory", "", "username", "extInfo", "checkChatRoomState", "checkExpire", "checkFetch", "checkStoryUnread", "destroy", "isRoomMember", "userName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "registerNotifyListener", "removeUserStory", "resume", "start", "tryStartFetch", "updateChatRoomState", "updateGalleryUserList", "updateUserState", "Companion", "plugin-story_release"})
public final class d
  implements com.tencent.mm.ai.f, k, com.tencent.mm.sdk.e.k.a
{
  private static final String TAG = "MicroMsg.StoryStateFetcher";
  public static final d.a szK;
  private boolean cvo;
  private final ak handler;
  private boolean pyz;
  private List<String> rbE;
  private final List<o<String, com.tencent.mm.plugin.story.h.f>> szA;
  private final List<o<String, com.tencent.mm.plugin.story.h.f>> szB;
  private final List<o<String, com.tencent.mm.plugin.story.h.f>> szC;
  private long szD;
  private final Map<String, com.tencent.mm.plugin.story.h.f> szE;
  private final Runnable szF;
  private final ArrayList<String> szG;
  private boolean szH;
  private final com.tencent.mm.sdk.e.k.a szI;
  private final d.d szJ;
  public com.tencent.mm.plugin.story.api.k.a szs;
  private boolean szu;
  private final String talker;
  
  static
  {
    AppMethodBeat.i(109416);
    szK = new d.a((byte)0);
    TAG = "MicroMsg.StoryStateFetcher";
    AppMethodBeat.o(109416);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(109415);
    this.talker = paramString;
    this.szA = Collections.synchronizedList((List)new ArrayList());
    this.szB = Collections.synchronizedList((List)new ArrayList());
    this.szC = Collections.synchronizedList((List)new ArrayList());
    this.szE = Collections.synchronizedMap((Map)new HashMap());
    paramString = com.tencent.mm.kernel.g.RO();
    a.f.b.j.p(paramString, "MMKernel.getPizzaWorkerThread()");
    this.handler = new ak(paramString.getLooper());
    this.szF = ((Runnable)new d.f(this));
    this.rbE = ((List)new LinkedList());
    this.szG = new ArrayList();
    this.szI = ((com.tencent.mm.sdk.e.k.a)new d.b(this));
    this.szJ = new d.d(this);
    AppMethodBeat.o(109415);
  }
  
  private final void a(String paramString, com.tencent.mm.plugin.story.h.f paramf)
  {
    AppMethodBeat.i(109410);
    if (this.rbE.contains(paramString))
    {
      AppMethodBeat.o(109410);
      return;
    }
    com.tencent.mm.plugin.story.api.k.a locala = this.szs;
    if (locala != null) {
      locala.by(paramString, paramf.cEU());
    }
    adq(paramString);
    b(paramString, paramf);
    cCb();
    cCc();
    AppMethodBeat.o(109410);
  }
  
  /* Error */
  private final void adq(String paramString)
  {
    // Byte code:
    //   0: ldc_w 301
    //   3: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 164	com/tencent/mm/plugin/story/model/f/d:szB	Ljava/util/List;
    //   10: astore_3
    //   11: aload_3
    //   12: ldc_w 302
    //   15: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 164	com/tencent/mm/plugin/story/model/f/d:szB	Ljava/util/List;
    //   24: astore_2
    //   25: aload_2
    //   26: ldc_w 302
    //   29: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload_2
    //   33: checkcast 279	java/lang/Iterable
    //   36: invokeinterface 283 1 0
    //   41: astore 4
    //   43: aload 4
    //   45: invokeinterface 288 1 0
    //   50: ifeq +247 -> 297
    //   53: aload 4
    //   55: invokeinterface 292 1 0
    //   60: astore_2
    //   61: aload_2
    //   62: checkcast 304	a/o
    //   65: getfield 308	a/o:first	Ljava/lang/Object;
    //   68: checkcast 294	java/lang/String
    //   71: aload_1
    //   72: invokestatic 298	a/f/b/j:e	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   75: ifeq -32 -> 43
    //   78: aload_2
    //   79: checkcast 304	a/o
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +14 -> 98
    //   87: aload_0
    //   88: getfield 164	com/tencent/mm/plugin/story/model/f/d:szB	Ljava/util/List;
    //   91: aload_2
    //   92: invokeinterface 311 2 0
    //   97: pop
    //   98: aload_3
    //   99: monitorexit
    //   100: aload_0
    //   101: getfield 166	com/tencent/mm/plugin/story/model/f/d:szC	Ljava/util/List;
    //   104: astore_3
    //   105: aload_3
    //   106: ldc_w 312
    //   109: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   112: aload_3
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 166	com/tencent/mm/plugin/story/model/f/d:szC	Ljava/util/List;
    //   118: astore_2
    //   119: aload_2
    //   120: ldc_w 312
    //   123: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload_2
    //   127: checkcast 279	java/lang/Iterable
    //   130: invokeinterface 283 1 0
    //   135: astore 4
    //   137: aload 4
    //   139: invokeinterface 288 1 0
    //   144: ifeq +169 -> 313
    //   147: aload 4
    //   149: invokeinterface 292 1 0
    //   154: astore_2
    //   155: aload_2
    //   156: checkcast 304	a/o
    //   159: getfield 308	a/o:first	Ljava/lang/Object;
    //   162: checkcast 294	java/lang/String
    //   165: aload_1
    //   166: invokestatic 298	a/f/b/j:e	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   169: ifeq -32 -> 137
    //   172: aload_2
    //   173: checkcast 304	a/o
    //   176: astore_2
    //   177: aload_2
    //   178: ifnull +14 -> 192
    //   181: aload_0
    //   182: getfield 166	com/tencent/mm/plugin/story/model/f/d:szC	Ljava/util/List;
    //   185: aload_2
    //   186: invokeinterface 311 2 0
    //   191: pop
    //   192: aload_3
    //   193: monitorexit
    //   194: aload_0
    //   195: getfield 162	com/tencent/mm/plugin/story/model/f/d:szA	Ljava/util/List;
    //   198: astore_3
    //   199: aload_3
    //   200: ldc_w 313
    //   203: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   206: aload_3
    //   207: monitorenter
    //   208: aload_0
    //   209: getfield 162	com/tencent/mm/plugin/story/model/f/d:szA	Ljava/util/List;
    //   212: astore_2
    //   213: aload_2
    //   214: ldc_w 313
    //   217: invokestatic 188	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   220: aload_2
    //   221: checkcast 279	java/lang/Iterable
    //   224: invokeinterface 283 1 0
    //   229: astore 4
    //   231: aload 4
    //   233: invokeinterface 288 1 0
    //   238: ifeq +91 -> 329
    //   241: aload 4
    //   243: invokeinterface 292 1 0
    //   248: astore_2
    //   249: aload_2
    //   250: checkcast 304	a/o
    //   253: getfield 308	a/o:first	Ljava/lang/Object;
    //   256: checkcast 294	java/lang/String
    //   259: aload_1
    //   260: invokestatic 298	a/f/b/j:e	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   263: ifeq -32 -> 231
    //   266: aload_2
    //   267: astore_1
    //   268: aload_1
    //   269: checkcast 304	a/o
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +14 -> 288
    //   277: aload_0
    //   278: getfield 162	com/tencent/mm/plugin/story/model/f/d:szA	Ljava/util/List;
    //   281: aload_1
    //   282: invokeinterface 311 2 0
    //   287: pop
    //   288: aload_3
    //   289: monitorexit
    //   290: ldc_w 301
    //   293: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: return
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -221 -> 78
    //   302: astore_1
    //   303: aload_3
    //   304: monitorexit
    //   305: ldc_w 301
    //   308: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_1
    //   312: athrow
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -143 -> 172
    //   318: astore_1
    //   319: aload_3
    //   320: monitorexit
    //   321: ldc_w 301
    //   324: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   327: aload_1
    //   328: athrow
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -63 -> 268
    //   334: astore_1
    //   335: aload_3
    //   336: monitorexit
    //   337: ldc_w 301
    //   340: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_1
    //   344: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	d
    //   0	345	1	paramString	String
    //   24	291	2	localObject	Object
    //   10	326	3	localList	List
    //   41	201	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   20	43	302	finally
    //   43	78	302	finally
    //   78	83	302	finally
    //   87	98	302	finally
    //   114	137	318	finally
    //   137	172	318	finally
    //   172	177	318	finally
    //   181	192	318	finally
    //   208	231	334	finally
    //   231	266	334	finally
    //   268	273	334	finally
    //   277	288	334	finally
  }
  
  private final void b(String paramString, com.tencent.mm.plugin.story.h.f paramf)
  {
    AppMethodBeat.i(109412);
    Object localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(paramString);
    boolean bool;
    if (localObject != null) {
      bool = ((ad)localObject).NT();
    }
    while (paramf.cEU()) {
      if (bool)
      {
        this.szC.add(new o(paramString, paramf));
        AppMethodBeat.o(109412);
        return;
        bool = false;
      }
      else
      {
        this.szB.add(new o(paramString, paramf));
        AppMethodBeat.o(109412);
        return;
      }
    }
    if (paramf.isValid()) {
      this.szA.add(new o(paramString, paramf));
    }
    AppMethodBeat.o(109412);
  }
  
  private final void cCb()
  {
    AppMethodBeat.i(109407);
    Object localObject = this.szB;
    a.f.b.j.p(localObject, "normalUnreadList");
    int i;
    label68:
    boolean bool1;
    if (!((Collection)localObject).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        localObject = this.szC;
        a.f.b.j.p(localObject, "friendUnreadList");
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
        localObject = this.szA;
        a.f.b.j.p(localObject, "readList");
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
      if ((this.pyz == bool2) && (this.szu == bool1)) {
        break label181;
      }
      localObject = this.szs;
      if (localObject == null) {
        break label181;
      }
      ((com.tencent.mm.plugin.story.api.k.a)localObject).L(bool2, bool1);
      AppMethodBeat.o(109407);
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
    label181:
    AppMethodBeat.o(109407);
  }
  
  private final void cCc()
  {
    AppMethodBeat.i(109408);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.szC;
    a.f.b.j.p(localObject1, "friendUnreadList");
    if (((List)localObject1).size() > 1) {
      a.a.j.a((List)localObject1, (Comparator)new d.g());
    }
    localObject1 = this.szB;
    a.f.b.j.p(localObject1, "normalUnreadList");
    if (((List)localObject1).size() > 1) {
      a.a.j.a((List)localObject1, (Comparator)new d.h());
    }
    localObject1 = "";
    ??? = ((d)this).szB;
    a.f.b.j.p(???, "normalUnreadList");
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        ??? = ((Iterable)???).iterator();
        i = 0;
        if (((Iterator)???).hasNext())
        {
          localObject11 = (o)((Iterator)???).next();
          localObject1 = (String)localObject1 + "unRead:" + i + ' ' + bo.hk(((com.tencent.mm.plugin.story.h.f)((o)localObject11).second).cES()) + "  userName:" + ((com.tencent.mm.plugin.story.h.f)((o)localObject11).second).getUserName() + " |, ";
          if (i > 2)
          {
            ab.i(TAG, "unRead preLoadCache: ".concat(String.valueOf(localObject1)));
            ??? = new ArrayList();
            localObject1 = this.szC;
            a.f.b.j.p(localObject1, "friendUnreadList");
            if (!((Collection)localObject1).isEmpty())
            {
              i = 1;
              if (i == 0) {
                break label1028;
              }
              if (((com.tencent.mm.plugin.story.h.f)((o)this.szC.get(0)).second).cES() <= 0L) {
                break label1023;
              }
              localObject1 = (o)this.szC.get(0);
              this.szC.remove(localObject1);
              ??? = this.szC;
              a.f.b.j.p(???, "friendUnreadList");
              Collections.shuffle((List)???, new Random());
              if (localObject1 != null) {
                this.szC.add(0, localObject1);
              }
              ??? = this.szC;
              a.f.b.j.p(???, "friendUnreadList");
              synchronized ((Iterable)???)
              {
                localObject11 = ((Iterable)???).iterator();
                if (!((Iterator)localObject11).hasNext()) {
                  break label491;
                }
                ((ArrayList)???).add(((o)((Iterator)localObject11).next()).first);
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
          ??? = y.BMg;
        }
      }
      int i = 0;
      continue;
      label491:
      Object localObject11 = y.BMg;
      if (((ArrayList)???).isEmpty())
      {
        ??? = this.szB;
        a.f.b.j.p(???, "normalUnreadList");
        if (((Collection)???).isEmpty()) {
          break label677;
        }
        i = 1;
        if (i != 0)
        {
          if (((com.tencent.mm.plugin.story.h.f)((o)this.szB.get(0)).second).cES() <= 0L) {
            break label1020;
          }
          ??? = (o)this.szB.get(0);
          this.szB.remove(???);
        }
      }
      label677:
      label682:
      label1020:
      for (;;)
      {
        if (??? != null) {
          this.szB.add(0, ???);
        }
        ??? = this.szB;
        a.f.b.j.p(???, "normalUnreadList");
        synchronized ((Iterable)???)
        {
          ??? = ((Iterable)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break label682;
          }
          ((ArrayList)???).add(((o)((Iterator)???).next()).first);
        }
        i = 0;
        break;
        ??? = y.BMg;
        ??? = new ArrayList();
        ??? = this.szA;
        a.f.b.j.p(???, "readList");
        synchronized ((Iterable)???)
        {
          localObject11 = ((Iterable)???).iterator();
          if (((Iterator)localObject11).hasNext()) {
            ((ArrayList)???).add((o)((Iterator)localObject11).next());
          }
        }
        localObject11 = y.BMg;
        ??? = new ArrayList();
        localObject11 = (List)???;
        if (((List)localObject11).size() > 1) {
          a.a.j.a((List)localObject11, (Comparator)new d.i());
        }
        synchronized ((Iterable)???)
        {
          localObject11 = ((Iterable)???).iterator();
          if (((Iterator)localObject11).hasNext()) {
            ((ArrayList)???).add(((o)((Iterator)localObject11).next()).first);
          }
        }
        localObject11 = y.BMg;
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
        localObject6 = this.szs;
        if (localObject6 != null)
        {
          ((com.tencent.mm.plugin.story.api.k.a)localObject6).a((List)localObject8, (ArrayList)???);
          AppMethodBeat.o(109408);
          return;
        }
        AppMethodBeat.o(109408);
        return;
      }
      label1023:
      Object localObject6 = null;
      continue;
      label1028:
      localObject6 = null;
    }
  }
  
  private final void cCd()
  {
    long l1 = 0L;
    AppMethodBeat.i(109409);
    long l2 = this.szD - System.currentTimeMillis();
    if (l2 < 0L) {
      this.szD = System.currentTimeMillis();
    }
    for (;;)
    {
      this.handler.removeCallbacks(this.szF);
      this.handler.postDelayed(this.szF, l1);
      AppMethodBeat.o(109409);
      return;
      l1 = l2;
    }
  }
  
  public final void a(com.tencent.mm.plugin.story.api.k.a parama)
  {
    this.szs = parama;
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(109413);
    if ((paramString != null) && (paramm != null) && ((paramm.obj instanceof com.tencent.mm.plugin.story.h.f)))
    {
      paramm = paramm.obj;
      if (paramm == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        AppMethodBeat.o(109413);
        throw paramString;
      }
      paramm = (com.tencent.mm.plugin.story.h.f)paramm;
      if (!this.szG.contains(paramm.getUserName()))
      {
        AppMethodBeat.o(109413);
        return;
      }
      if (com.tencent.mm.plugin.sns.e.a.ZT(paramm.getUserName()))
      {
        AppMethodBeat.o(109413);
        return;
      }
      Map localMap = this.szE;
      a.f.b.j.p(localMap, "userUpdateMap");
      localMap.put(paramm.getUserName(), paramm);
      if (a.f.b.j.e(paramString, "notify_story_read"))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + " as read");
        a(paramm.getUserName(), paramm);
        AppMethodBeat.o(109413);
        return;
      }
      if (a.f.b.j.e(paramString, "notify_story_unread"))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + " as unread");
        a(paramm.getUserName(), paramm);
        AppMethodBeat.o(109413);
        return;
      }
      if (a.f.b.j.e(paramString, "notify_story_preload"))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + ' ' + paramm.field_syncId + " as preload " + paramm.cES());
        a(paramm.getUserName(), paramm);
        AppMethodBeat.o(109413);
        return;
      }
      if (a.f.b.j.e(paramString, "notify_story_invalid"))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + " as invalid");
        a(paramm.getUserName(), paramm);
        AppMethodBeat.o(109413);
        return;
      }
      if (a.f.b.j.e(paramString, "notify_story_valid"))
      {
        ab.i(TAG, "update user " + paramm.getUserName() + " as valid");
        a(paramm.getUserName(), paramm);
      }
    }
    AppMethodBeat.o(109413);
  }
  
  public final boolean acA(String paramString)
  {
    AppMethodBeat.i(109406);
    a.f.b.j.q(paramString, "username");
    if (this.szE.get(paramString) == null)
    {
      Map localMap = this.szE;
      a.f.b.j.p(localMap, "userUpdateMap");
      j.b localb = com.tencent.mm.plugin.story.model.j.svi;
      localMap.put(paramString, j.b.cAC().acU(paramString));
    }
    paramString = (com.tencent.mm.plugin.story.h.f)this.szE.get(paramString);
    if ((paramString != null) && (paramString.cEU()))
    {
      AppMethodBeat.o(109406);
      return true;
    }
    AppMethodBeat.o(109406);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(109405);
    ab.i(TAG, "endSession " + this.talker + ' ' + hashCode());
    Object localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().b(998, (com.tencent.mm.ai.f)this);
    localObject = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().remove((com.tencent.mm.sdk.e.k.a)this);
    localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class);
    a.f.b.j.p(localObject, "MMKernel.service(IChatroomService::class.java)");
    ((com.tencent.mm.plugin.chatroom.a.c)localObject).YJ().remove(this.szI);
    this.handler.removeCallbacks(this.szF);
    this.szJ.dead();
    AppMethodBeat.o(109405);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(109414);
    a.f.b.j.q(paramm, "scene");
    ab.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + paramm.getType());
    if ((paramm.getType() == 998) && ((paramm instanceof com.tencent.mm.plugin.story.model.a.c)))
    {
      if ((a.f.b.j.e(((com.tencent.mm.plugin.story.model.a.c)paramm).grA, this.talker) ^ true))
      {
        AppMethodBeat.o(109414);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.story.model.a.c)paramm).rr.adn();
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncResponse");
          AppMethodBeat.o(109414);
          throw paramString;
        }
        paramString = (cgu)paramString;
        ab.i(TAG, "response: count " + paramString.xRA + ", interval " + paramString.xRC);
        paramString = com.tencent.mm.plugin.story.model.j.svi;
        this.szD = j.b.cAD().adH(this.talker).field_nextSyncTime;
        cCd();
        AppMethodBeat.o(109414);
        return;
      }
      paramString = com.tencent.mm.plugin.story.model.j.svi;
      this.szD = j.b.cAD().adH(this.talker).field_nextSyncTime;
      cCd();
    }
    AppMethodBeat.o(109414);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(109404);
    this.cvo = true;
    this.handler.removeCallbacks(this.szF);
    AppMethodBeat.o(109404);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(109403);
    this.cvo = false;
    cCd();
    com.tencent.mm.ab.b.a("StoryStateFetcher_checkExpire", (a.f.a.a)new d.c(this));
    AppMethodBeat.o(109403);
  }
  
  public final void start()
  {
    AppMethodBeat.i(109402);
    com.tencent.mm.ab.b.a("StoryStateFetcher_start", (a.f.a.a)new d.e(this));
    this.szJ.alive();
    Object localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().a(998, (com.tencent.mm.ai.f)this);
    localObject = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAC().add((com.tencent.mm.sdk.e.k.a)this, Looper.getMainLooper());
    localObject = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class);
    a.f.b.j.p(localObject, "MMKernel.service(IChatroomService::class.java)");
    ((com.tencent.mm.plugin.chatroom.a.c)localObject).YJ().add(this.szI);
    AppMethodBeat.o(109402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.d
 * JD-Core Version:    0.7.0.1
 */