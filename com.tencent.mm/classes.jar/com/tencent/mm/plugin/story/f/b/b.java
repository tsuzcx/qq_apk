package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import d.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.al.f, h
{
  public static final String ALJ;
  private static final int ALK = 50;
  public static final diw ALM;
  private static diy ALN;
  private static a ALO;
  private static int ALP = 0;
  private static final ArrayList<r<Long, Boolean, String, String, z>> ALQ;
  private static final LinkedList<Object> ALR;
  private static final LinkedList<m<Boolean, Long, z>> ALS;
  public static final b ALT;
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int tqv = 2147483647;
  public static final String zlT;
  
  static
  {
    AppMethodBeat.i(118882);
    ALT = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ALJ = ((com.tencent.mm.kernel.e)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    zlT = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    ALK = 50;
    tqv = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    ALM = new diw();
    ALP = -1;
    ALQ = new ArrayList();
    ALR = new LinkedList();
    ALS = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  public static void AH(long paramLong)
  {
    AppMethodBeat.i(118871);
    y.f localf = new y.f();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localf.MLV = j.b.ehW().AT(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.MLV == null)
    {
      localf.MLV = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    final com.tencent.mm.plugin.story.i.j localj = j.b.ehT().AX(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new djs();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((djs)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label116:
      int i;
      break label116;
    }
    localObject1 = ((djs)localObject2).Hyz;
    p.g(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label148:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((dix)localObject1).HtH != 0)
      {
        i = 1;
        label178:
        if (i == 0) {
          break label385;
        }
      }
    }
    for (;;)
    {
      localObject2 = (dix)localObject1;
      if (localObject2 == null) {
        break label392;
      }
      if ((((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentId != ((dix)localObject2).HtH) && (((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime < ((dix)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentId = ((dix)localObject2).HtH;
        ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime = ((dix)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
        localObject2 = ((dix)localObject2).ukj;
        p.g(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).aCd((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)localf.MLV;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.aBP((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehW().update((com.tencent.mm.sdk.e.c)localf.MLV, new String[0]);
        com.tencent.mm.ad.c.g((d.g.a.a)new h(localf, localj));
      }
      AppMethodBeat.o(118871);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label178;
      label385:
      break label148;
      localObject1 = null;
    }
    label392:
    AppMethodBeat.o(118871);
  }
  
  public static void AI(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    com.tencent.mm.plugin.story.i.j localj = j.b.ehT().AX(paramLong);
    y.f localf = new y.f();
    localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehW().AT(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.MLV = localObject1;
    if (localj == null)
    {
      ad.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).aCd("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
      Object localObject2;
      if (localj != null)
      {
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.story.i.c)localObject3).aBP((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehW().replace((com.tencent.mm.sdk.e.c)localf.MLV);
      com.tencent.mm.ad.c.g((d.g.a.a)new k(localf));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new djs();
      try
      {
        ((djs)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((djs)localObject3).Hyz;
        p.g(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (dix)localObject1;
          if ((((dix)localObject4).HtH != 0) && (((dix)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (dix)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.AIM.egX()) {
              break label782;
            }
            localObject1 = ((djs)localObject3).HyF;
            p.g(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (dix)localObject1;
            if ((((dix)localObject4).HtH == 0) || (((dix)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (dix)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((dix)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((dix)localObject1).HtH);
            label495:
            ad.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
            if (localObject1 == null) {
              break label901;
            }
            i = ((dix)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
            if (localObject1 == null) {
              break label906;
            }
            i = ((dix)localObject1).HtH;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
            if (localObject1 == null) {
              break label911;
            }
            i = ((dix)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
            if (localObject1 == null) {
              break label916;
            }
            i = ((dix)localObject1).HtH;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)localf.MLV;
            if (localObject1 != null)
            {
              localObject2 = ((dix)localObject1).ukj;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).aCd((String)localObject1);
            localObject1 = ((djs)localObject3).Hyz;
            p.g(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (dix)localObject1;
            if ((((dix)localObject3).HtH == 0) || (((dix)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((dix)localObject1 == null)
        {
          localj.sv(false);
          localObject1 = com.tencent.mm.plugin.story.f.n.AKq;
          n.a.Z(localj.field_storyID, localj.field_localFlag);
          break;
          i = 0;
          break label322;
          label765:
          break label269;
          localObject1 = null;
          break label326;
          label772:
          i = 0;
          break label429;
          label775:
          break label376;
          label777:
          localObject1 = null;
          break label433;
          label782:
          localObject1 = ((djs)localObject3).HyB;
          p.g(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (dix)localObject1;
            if ((((dix)localObject4).HtH != 0) && (((dix)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime))
            {
              i = 1;
              label867:
              if (i == 0) {
                break label882;
              }
            }
          }
          for (;;)
          {
            localObject1 = (dix)localObject1;
            break;
            i = 0;
            break label867;
            label882:
            break label814;
            localObject1 = null;
          }
          label889:
          localObject2 = null;
          break label468;
          label895:
          localObject2 = null;
          break label495;
          label901:
          i = 0;
          break label529;
          label906:
          i = 0;
          break label554;
          label911:
          i = 0;
          break label579;
          label916:
          i = 0;
          break label604;
          label921:
          i = 0;
          break label725;
          label924:
          break label672;
          label926:
          localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        label935:
        for (;;) {}
      }
    }
  }
  
  private static a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(118874);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.dTJ() + bt.HI();
    localObject2 = d.n.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118874);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
    localObject1 = new diy();
    ((diy)localObject1).clientId = ((String)localObject2);
    ((diy)localObject1).dKt = paramLong;
    ((diy)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.AKb;
    ((diy)localObject1).dyU = j.b.dTJ();
    ((diy)localObject1).toUser = paramString1;
    ((diy)localObject1).hZE = cf.aCN();
    ((diy)localObject1).state = 1;
    ((diy)localObject1).HxQ = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ((diy)localObject1).HxR = i;
      ((diy)localObject1).sessionId = paramString3;
      ((diy)localObject1).ALG = paramString4;
      ((diy)localObject1).ALH = paramInt1;
      ((diy)localObject1).Acs = paramInt2;
      ALM.HxK.add(localObject1);
      ALO = new a((diy)localObject1);
      dVc();
      paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.dFL().post((Runnable)new g((diy)localObject1));
      paramString1 = ALO;
      if (paramString1 == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118874);
      return paramString1;
      i = 0;
    }
  }
  
  private static dix a(diy paramdiy)
  {
    AppMethodBeat.i(118876);
    dix localdix = new dix();
    localdix.Id = paramdiy.dKt;
    localdix.HtH = paramdiy.ALy;
    localdix.ukj = paramdiy.dyU;
    localdix.uki = paramdiy.toUser;
    localdix.hDa = paramdiy.content;
    localdix.CreateTime = paramdiy.hZE;
    localdix.HxO = paramdiy.HxQ;
    localdix.HxP = paramdiy.HxR;
    localdix.HtG = paramdiy.ALH;
    localdix.HtL = paramdiy.Acs;
    AppMethodBeat.o(118876);
    return localdix;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    p.h(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    com.tencent.mm.plugin.story.i.c localc = j.b.ehW().AT(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.ALy;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.hZE;
    parama = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehW().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(djs paramdjs)
  {
    AppMethodBeat.i(118877);
    if (paramdjs != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      Object localObject2 = j.b.ehT().AX(paramdjs.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      if (bt.lQ(j.b.dTJ(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).sv(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      if (bt.lQ(j.b.dTJ(), paramdjs.nDo)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.ekx();; i = com.tencent.mm.plugin.story.i.a.eky())
      {
        localObject2 = com.tencent.mm.plugin.story.f.n.AKq;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, paramdjs, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(djy paramdjy)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    dix localdix1 = new dix();
    localdix1.Id = paramdjy.Id;
    localdix1.HtH = paramdjy.HyK.HtH;
    localdix1.ukj = paramdjy.HyK.ukj;
    localdix1.uki = paramdjy.HyK.uki;
    localdix1.hDa = paramdjy.HyK.hDa;
    localdix1.CreateTime = paramdjy.HyK.CreateTime;
    localdix1.HxO = paramdjy.HyK.HxO;
    localdix1.HtG = paramdjy.HyK.HtG;
    if (paramdjy.HyK.nEf == 7)
    {
      localObject = a.e.ATA;
      localdix1.HtL = a.e.elh();
    }
    long l = localdix1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.AKb;
    localObject = j.b.ehT().AX(l);
    if (localObject == null)
    {
      a(paramdjy.HyK.HxW);
      AppMethodBeat.o(118878);
      return;
    }
    djs localdjs = new djs();
    try
    {
      localdjs.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (bt.isNullOrNil(localdix1.hDa))
      {
        i = localdix1.HtL;
        paramdjy = a.e.ATA;
        if (i == a.e.elh())
        {
          paramdjy = localdjs.HyF;
          p.g(paramdjy, "storyObj.VisitorList");
          localIterator = ((Iterable)paramdjy).iterator();
          if (localIterator.hasNext())
          {
            paramdjy = localIterator.next();
            dix localdix2 = (dix)paramdjy;
            if ((localdix2.HtH == localdix1.HtH) || (bt.lQ(localdix2.ukj, localdix1.ukj))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((dix)paramdjy == null)
        {
          localdjs.HyF.add(localdix1);
          i = 1;
        }
        label330:
        paramdjy = localdjs.HyF;
        p.g(paramdjy, "storyObj.VisitorList");
        localIterator = ((Iterable)paramdjy).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramdjy = localIterator.next();
            if (bt.lQ(((dix)paramdjy).ukj, localdix1.ukj))
            {
              if ((dix)paramdjy == null) {
                localdjs.HyF.add(localdix1);
              }
              if (i != 0)
              {
                localdjs.CommentCount = localdjs.Hyz.size();
                localdjs.HyA = localdjs.HyB.size();
                localdjs.HyE = localdjs.HyF.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localdjs.toByteArray();
          label461:
          paramdjy = com.tencent.mm.plugin.story.f.j.AKb;
          if (bt.lQ(j.b.dTJ(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).sv(true);
          }
          paramdjy = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehT().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          paramdjy = null;
          break label308;
          if (bt.isNullOrNil(localdix1.hDa))
          {
            if (localdix1.HtH != 0)
            {
              paramdjy = localdjs.HyB;
              p.g(paramdjy, "storyObj.BubbleList");
              localIterator = ((Iterable)paramdjy).iterator();
              label558:
              if (localIterator.hasNext())
              {
                paramdjy = localIterator.next();
                if (((dix)paramdjy).HtH == localdix1.HtH)
                {
                  i = 1;
                  label593:
                  if (i == 0) {
                    break label625;
                  }
                }
              }
              for (;;)
              {
                i = j;
                if ((dix)paramdjy != null) {
                  break;
                }
                localdjs.HyB.add(localdix1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                paramdjy = null;
              }
            }
            localdjs.HyB.add(localdix1);
            i = 1;
            break label330;
          }
          if (localdix1.HtH != 0)
          {
            paramdjy = localdjs.Hyz;
            p.g(paramdjy, "storyObj.CommentList");
            localIterator = ((Iterable)paramdjy).iterator();
            label680:
            if (localIterator.hasNext())
            {
              paramdjy = localIterator.next();
              if (((dix)paramdjy).HtH == localdix1.HtH)
              {
                i = 1;
                label715:
                if (i == 0) {
                  break label747;
                }
              }
            }
            for (;;)
            {
              i = j;
              if ((dix)paramdjy != null) {
                break;
              }
              localdjs.Hyz.add(localdix1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              paramdjy = null;
            }
          }
          localdjs.Hyz.add(localdix1);
          i = 1;
          break label330;
          paramdjy = null;
        }
        catch (Exception paramdjy)
        {
          break label461;
        }
      }
    }
    catch (Exception paramdjy)
    {
      break label197;
    }
  }
  
  public static void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.z.c.aht().cI(352279, 266241);
    ad.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ad.c.g((d.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    p.h(paramString2, "content");
    ad.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = j.b.dTJ() + bt.HI();
      localObject2 = d.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(118868);
        throw paramString1;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
      localObject1 = new diy();
      ((diy)localObject1).dKt = paramLong;
      ((diy)localObject1).clientId = ((String)localObject2);
      ((diy)localObject1).ALy = paramInt;
      ((diy)localObject1).hZE = cf.aCN();
      ((diy)localObject1).state = 3;
      ((diy)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
      ((diy)localObject1).dyU = j.b.dTJ();
      ((diy)localObject1).toUser = "";
      ALM.HxK.add(localObject1);
      dVc();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.dFL().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    p.h(parama, "commentDetail");
    y.f localf = new y.f();
    j.b localb = com.tencent.mm.plugin.story.f.j.AKb;
    localf.MLV = j.b.ehW().AT(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.MLV == null)
    {
      localf.MLV = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentId != parama.ALy) && (((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime < parama.hZE))
    {
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentId = parama.ALy;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).field_readCommentTime = parama.hZE;
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).aCd(parama.dyU);
      ((com.tencent.mm.plugin.story.i.c)localf.MLV).aBP(parama.ALG);
      parama = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehW().update((com.tencent.mm.sdk.e.c)localf.MLV, new String[0]);
      com.tencent.mm.ad.c.g((d.g.a.a)new i(localf));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void d(r<? super Long, ? super Boolean, ? super String, ? super String, z> paramr)
  {
    AppMethodBeat.i(118863);
    p.h(paramr, "listener");
    if (!ALQ.contains(paramr)) {
      ALQ.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void dVc()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = ALM.HxK.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (diy)ALM.HxK.get(i);
      if ((((diy)localObject2).state == 1) || (((diy)localObject2).state == 3))
      {
        int m = ((diy)localObject2).hZE;
        int n = cf.aCN();
        localObject3 = com.tencent.mm.plugin.story.f.i.AJE;
        if (m > n - com.tencent.mm.plugin.story.f.i.ehK()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    ALM.HxK.clear();
    ALM.HxK.addAll((Collection)localObject1);
    ALP += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      ALP = -1;
      AppMethodBeat.o(118873);
      return;
    }
    ALP %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.gfB();
      }
      localObject4 = (diy)localObject3;
      if ((i >= ALP) && (((diy)localObject4).retryCount < tqv)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (diy)d.a.j.jd((List)localObject1);
    if ((localObject1 != null) && (((diy)localObject1).state == 1))
    {
      ad.i(TAG, "postCommentToRemote " + ((diy)localObject1).toUser + ' ' + ((diy)localObject1).dKt + ' ' + ((diy)localObject1).HxQ + ' ' + ((diy)localObject1).hZE);
      ALN = (diy)localObject1;
      localObject2 = a((diy)localObject1);
      localObject3 = (CharSequence)((dix)localObject2).hDa;
      if (localObject3 != null)
      {
        i = k;
        if (((CharSequence)localObject3).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        localObject3 = com.tencent.mm.plugin.story.h.e.ART;
        com.tencent.mm.plugin.story.h.e.ejO();
      }
      for (;;)
      {
        localObject3 = g.ajB();
        p.g(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).aiU();
        localObject4 = ((diy)localObject1).clientId;
        p.g(localObject4, "commentOp.clientId");
        ((com.tencent.mm.al.q)localObject3).b((com.tencent.mm.al.n)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (dix)localObject2, ((diy)localObject1).sessionId, ALO));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.ART;
        com.tencent.mm.plugin.story.h.e.ejP();
      }
    }
    if ((localObject1 != null) && (((diy)localObject1).state == 3))
    {
      ad.i(TAG, "deleteCommentToRemote " + ((diy)localObject1).toUser + ' ' + ((diy)localObject1).dKt + ' ' + ((diy)localObject1).ALy + ' ' + ((diy)localObject1).hZE);
      ALN = (diy)localObject1;
      localObject2 = new ArrayList();
      long l = ((diy)localObject1).dKt;
      localObject3 = com.tencent.mm.plugin.story.i.a.ATp;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.ekM(), ((diy)localObject1).ALy));
      localObject1 = g.ajB();
      p.g(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).aiU().b((com.tencent.mm.al.n)new com.tencent.mm.plugin.story.f.a.f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void e(r<? super Long, ? super Boolean, ? super String, ? super String, z> paramr)
  {
    AppMethodBeat.i(118864);
    p.h(paramr, "listener");
    ALQ.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void eiH()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = ALM.toByteArray();
    com.tencent.mm.vfs.i.C(zlT, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void f(m<? super Boolean, ? super Long, z> paramm)
  {
    AppMethodBeat.i(118865);
    p.h(paramm, "listener");
    if (!ALS.contains(paramm)) {
      ALS.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void g(m<? super Boolean, ? super Long, z> paramm)
  {
    AppMethodBeat.i(118866);
    p.h(paramm, "listener");
    ALS.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void k(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
    localObject1 = j.b.ehT().AX(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    djs localdjs = new djs();
    try
    {
      localdjs.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localdjs.Hyz;
        p.g(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((dix)paramString.next()).HtH == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localdjs.Hyz.remove(i);
              localdjs.CommentCount = localdjs.Hyz.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localdjs.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.ehT().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localdjs.Hyz;
          p.g(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!bt.lQ(((dix)((Iterator)localObject2).next()).hDa, paramString)) {}
          }
          for (;;)
          {
            i = paramInt;
            break;
            paramInt += 1;
            break label229;
            paramInt = -1;
          }
        }
        catch (Exception paramString)
        {
          break label158;
        }
      }
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public final a b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(118867);
    p.h(paramString1, "content");
    p.h(paramString2, "toUsername");
    p.h(paramString4, "storyOwner");
    ad.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    p.h(paramn, "scene");
    int j = paramn.getType();
    ad.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramn).rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (dja)paramString;
      paramn = ((com.tencent.mm.plugin.story.f.a.c)paramn).ALg;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = ALN;
        if (paramString != null)
        {
          paramString = paramString.content;
          ad.i((String)localObject2, paramString + ' ' + ((dja)localObject1).HtH);
          paramString = com.tencent.mm.plugin.story.f.j.AKb;
          j.b.dFL().post((Runnable)new d((dja)localObject1));
          if (paramn != null) {
            paramn.ALy = ((dja)localObject1).HtH;
          }
          paramString = ((Iterable)ALS).iterator();
          if (!paramString.hasNext()) {
            break label318;
          }
          localObject2 = (m)paramString.next();
          localObject3 = Boolean.TRUE;
          if (paramn == null) {
            break label312;
          }
        }
        label312:
        for (l = paramn.dKt;; l = 0L)
        {
          ((m)localObject2).p(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = ALN;
        if (paramString != null) {
          paramString.ALy = ((dja)localObject1).HtH;
        }
        paramString = ALN;
        if (paramString != null) {
          paramString.state = 2;
        }
        ALN = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.dFL().postDelayed((Runnable)e.ALY, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = ALN;
        if (paramString != null)
        {
          paramString = paramString.content;
          ad.i((String)localObject1, paramString);
          paramString = ALN;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = ALN;
          if (paramString != null) {
            paramString.retryCount = tqv;
          }
          label463:
          ALN = null;
          paramString = ((Iterable)ALS).iterator();
          label479:
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = (m)paramString.next();
          localObject2 = Boolean.FALSE;
          if (paramn == null) {
            break label557;
          }
        }
        label539:
        label557:
        for (l = paramn.dKt;; l = 0L)
        {
          ((m)localObject1).p(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = ALN;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((com.tencent.mm.plugin.story.f.a.f)paramn).eiG() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramn = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = ALN;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      ad.i(paramn, paramString);
      paramString = ALN;
      if (paramString != null) {
        paramString.state = 4;
      }
      ALN = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.dFL().postDelayed((Runnable)f.ALZ, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramn = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = ALN;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      ad.i(paramn, paramString);
      paramString = ALN;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = ALN;
      if (paramString != null) {
        paramString.retryCount = tqv;
      }
    }
    for (;;)
    {
      ALN = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = ALN;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public a(y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public b(y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.ALT;
      b.l(this.ALV, paramString2, this.fKu);
      AppMethodBeat.o(118851);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(dja paramdja) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.ALT;
      b.b(this.ALX.HxW);
      AppMethodBeat.o(118852);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e ALY;
    
    static
    {
      AppMethodBeat.i(118854);
      ALY = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b localb = b.ALT;
      b.eiK();
      AppMethodBeat.o(118853);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f ALZ;
    
    static
    {
      AppMethodBeat.i(118856);
      ALZ = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b localb = b.ALT;
      b.eiK();
      AppMethodBeat.o(118855);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(diy paramdiy) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.ALT;
      b.a(b.b(this.AMa));
      AppMethodBeat.o(118857);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    h(y.f paramf, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(y.f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    k(y.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */