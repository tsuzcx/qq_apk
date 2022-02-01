package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.ak.f, h
{
  public static final String Bdm;
  private static final int Bdn = 50;
  public static final djr Bdo;
  private static djt Bdp;
  private static a Bdq;
  private static int Bdr = 0;
  private static final ArrayList<r<Long, Boolean, String, String, z>> Bds;
  private static final LinkedList<Object> Bdt;
  private static final LinkedList<m<Boolean, Long, z>> Bdu;
  public static final b Bdv;
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int tBm = 2147483647;
  public static final String zDi;
  
  static
  {
    AppMethodBeat.i(118882);
    Bdv = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    Bdm = ((com.tencent.mm.kernel.e)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    zDi = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    Bdn = 50;
    tBm = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    Bdo = new djr();
    Bdr = -1;
    Bds = new ArrayList();
    Bdt = new LinkedList();
    Bdu = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  public static void Bf(long paramLong)
  {
    AppMethodBeat.i(118871);
    y.f localf = new y.f();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localf.NiY = j.b.elE().Br(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.NiY == null)
    {
      localf.NiY = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    final com.tencent.mm.plugin.story.i.j localj = j.b.elB().Bv(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new dkn();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((dkn)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label116:
      int i;
      break label116;
    }
    localObject1 = ((dkn)localObject2).HSk;
    p.g(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label148:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((djs)localObject1).HNk != 0)
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
      localObject2 = (djs)localObject1;
      if (localObject2 == null) {
        break label392;
      }
      if ((((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentId != ((djs)localObject2).HNk) && (((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime < ((djs)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentId = ((djs)localObject2).HNk;
        ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime = ((djs)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
        localObject2 = ((djs)localObject2).uvG;
        p.g(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).aDw((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)localf.NiY;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.aDi((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elE().update((com.tencent.mm.sdk.e.c)localf.NiY, new String[0]);
        com.tencent.mm.ac.c.h((d.g.a.a)new h(localf, localj));
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
  
  public static void Bg(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    com.tencent.mm.plugin.story.i.j localj = j.b.elB().Bv(paramLong);
    y.f localf = new y.f();
    localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elE().Br(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.NiY = localObject1;
    if (localj == null)
    {
      ae.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).aDw("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
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
      ((com.tencent.mm.plugin.story.i.c)localObject3).aDi((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elE().replace((com.tencent.mm.sdk.e.c)localf.NiY);
      com.tencent.mm.ac.c.h((d.g.a.a)new k(localf));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new dkn();
      try
      {
        ((dkn)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((dkn)localObject3).HSk;
        p.g(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (djs)localObject1;
          if ((((djs)localObject4).HNk != 0) && (((djs)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (djs)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.Bap.ekF()) {
              break label782;
            }
            localObject1 = ((dkn)localObject3).HSq;
            p.g(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (djs)localObject1;
            if ((((djs)localObject4).HNk == 0) || (((djs)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (djs)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((djs)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((djs)localObject1).HNk);
            label495:
            ae.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
            if (localObject1 == null) {
              break label901;
            }
            i = ((djs)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
            if (localObject1 == null) {
              break label906;
            }
            i = ((djs)localObject1).HNk;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
            if (localObject1 == null) {
              break label911;
            }
            i = ((djs)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
            if (localObject1 == null) {
              break label916;
            }
            i = ((djs)localObject1).HNk;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)localf.NiY;
            if (localObject1 != null)
            {
              localObject2 = ((djs)localObject1).uvG;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).aDw((String)localObject1);
            localObject1 = ((dkn)localObject3).HSk;
            p.g(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (djs)localObject1;
            if ((((djs)localObject3).HNk == 0) || (((djs)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((djs)localObject1 == null)
        {
          localj.sC(false);
          localObject1 = com.tencent.mm.plugin.story.f.n.BbT;
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
          localObject1 = ((dkn)localObject3).HSm;
          p.g(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (djs)localObject1;
            if ((((djs)localObject4).HNk != 0) && (((djs)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime))
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
            localObject1 = (djs)localObject1;
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
    Object localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.dXj() + bu.HQ();
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
    localObject1 = new djt();
    ((djt)localObject1).clientId = ((String)localObject2);
    ((djt)localObject1).dLI = paramLong;
    ((djt)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.BbE;
    ((djt)localObject1).dzZ = j.b.dXj();
    ((djt)localObject1).toUser = paramString1;
    ((djt)localObject1).icw = ch.aDd();
    ((djt)localObject1).state = 1;
    ((djt)localObject1).HRB = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ((djt)localObject1).HRC = i;
      ((djt)localObject1).sessionId = paramString3;
      ((djt)localObject1).Bdj = paramString4;
      ((djt)localObject1).Bdk = paramInt1;
      ((djt)localObject1).AtF = paramInt2;
      Bdo.HRv.add(localObject1);
      Bdq = new a((djt)localObject1);
      dYC();
      paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.dJc().post((Runnable)new g((djt)localObject1));
      paramString1 = Bdq;
      if (paramString1 == null) {
        p.gkB();
      }
      AppMethodBeat.o(118874);
      return paramString1;
      i = 0;
    }
  }
  
  private static djs a(djt paramdjt)
  {
    AppMethodBeat.i(118876);
    djs localdjs = new djs();
    localdjs.Id = paramdjt.dLI;
    localdjs.HNk = paramdjt.Bdb;
    localdjs.uvG = paramdjt.dzZ;
    localdjs.uvF = paramdjt.toUser;
    localdjs.hFS = paramdjt.content;
    localdjs.CreateTime = paramdjt.icw;
    localdjs.HRz = paramdjt.HRB;
    localdjs.HRA = paramdjt.HRC;
    localdjs.HNj = paramdjt.Bdk;
    localdjs.HNo = paramdjt.AtF;
    AppMethodBeat.o(118876);
    return localdjs;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    p.h(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
    com.tencent.mm.plugin.story.i.c localc = j.b.elE().Br(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.Bdb;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.icw;
    parama = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elE().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(dkn paramdkn)
  {
    AppMethodBeat.i(118877);
    if (paramdkn != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      Object localObject2 = j.b.elB().Bv(paramdkn.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      if (bu.lX(j.b.dXj(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).sC(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      if (bu.lX(j.b.dXj(), paramdkn.nIJ)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.eog();; i = com.tencent.mm.plugin.story.i.a.eoh())
      {
        localObject2 = com.tencent.mm.plugin.story.f.n.BbT;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, paramdkn, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(dkt paramdkt)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    djs localdjs1 = new djs();
    localdjs1.Id = paramdkt.Id;
    localdjs1.HNk = paramdkt.HSv.HNk;
    localdjs1.uvG = paramdkt.HSv.uvG;
    localdjs1.uvF = paramdkt.HSv.uvF;
    localdjs1.hFS = paramdkt.HSv.hFS;
    localdjs1.CreateTime = paramdkt.HSv.CreateTime;
    localdjs1.HRz = paramdkt.HSv.HRz;
    localdjs1.HNj = paramdkt.HSv.HNj;
    if (paramdkt.HSv.nJA == 7)
    {
      localObject = a.e.BkY;
      localdjs1.HNo = a.e.eoQ();
    }
    long l = localdjs1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
    localObject = j.b.elB().Bv(l);
    if (localObject == null)
    {
      a(paramdkt.HSv.HRH);
      AppMethodBeat.o(118878);
      return;
    }
    dkn localdkn = new dkn();
    try
    {
      localdkn.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (bu.isNullOrNil(localdjs1.hFS))
      {
        i = localdjs1.HNo;
        paramdkt = a.e.BkY;
        if (i == a.e.eoQ())
        {
          paramdkt = localdkn.HSq;
          p.g(paramdkt, "storyObj.VisitorList");
          localIterator = ((Iterable)paramdkt).iterator();
          if (localIterator.hasNext())
          {
            paramdkt = localIterator.next();
            djs localdjs2 = (djs)paramdkt;
            if ((localdjs2.HNk == localdjs1.HNk) || (bu.lX(localdjs2.uvG, localdjs1.uvG))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((djs)paramdkt == null)
        {
          localdkn.HSq.add(localdjs1);
          i = 1;
        }
        label330:
        paramdkt = localdkn.HSq;
        p.g(paramdkt, "storyObj.VisitorList");
        localIterator = ((Iterable)paramdkt).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramdkt = localIterator.next();
            if (bu.lX(((djs)paramdkt).uvG, localdjs1.uvG))
            {
              if ((djs)paramdkt == null) {
                localdkn.HSq.add(localdjs1);
              }
              if (i != 0)
              {
                localdkn.CommentCount = localdkn.HSk.size();
                localdkn.HSl = localdkn.HSm.size();
                localdkn.HSp = localdkn.HSq.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localdkn.toByteArray();
          label461:
          paramdkt = com.tencent.mm.plugin.story.f.j.BbE;
          if (bu.lX(j.b.dXj(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).sC(true);
          }
          paramdkt = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elB().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          paramdkt = null;
          break label308;
          if (bu.isNullOrNil(localdjs1.hFS))
          {
            if (localdjs1.HNk != 0)
            {
              paramdkt = localdkn.HSm;
              p.g(paramdkt, "storyObj.BubbleList");
              localIterator = ((Iterable)paramdkt).iterator();
              label558:
              if (localIterator.hasNext())
              {
                paramdkt = localIterator.next();
                if (((djs)paramdkt).HNk == localdjs1.HNk)
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
                if ((djs)paramdkt != null) {
                  break;
                }
                localdkn.HSm.add(localdjs1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                paramdkt = null;
              }
            }
            localdkn.HSm.add(localdjs1);
            i = 1;
            break label330;
          }
          if (localdjs1.HNk != 0)
          {
            paramdkt = localdkn.HSk;
            p.g(paramdkt, "storyObj.CommentList");
            localIterator = ((Iterable)paramdkt).iterator();
            label680:
            if (localIterator.hasNext())
            {
              paramdkt = localIterator.next();
              if (((djs)paramdkt).HNk == localdjs1.HNk)
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
              if ((djs)paramdkt != null) {
                break;
              }
              localdkn.HSk.add(localdjs1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              paramdkt = null;
            }
          }
          localdkn.HSk.add(localdjs1);
          i = 1;
          break label330;
          paramdkt = null;
        }
        catch (Exception paramdkt)
        {
          break label461;
        }
      }
    }
    catch (Exception paramdkt)
    {
      break label197;
    }
  }
  
  public static void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.y.c.ahI().cI(352279, 266241);
    ae.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ac.c.h((d.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    p.h(paramString2, "content");
    ae.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = j.b.dXj() + bu.HQ();
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
      localObject1 = new djt();
      ((djt)localObject1).dLI = paramLong;
      ((djt)localObject1).clientId = ((String)localObject2);
      ((djt)localObject1).Bdb = paramInt;
      ((djt)localObject1).icw = ch.aDd();
      ((djt)localObject1).state = 3;
      ((djt)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
      ((djt)localObject1).dzZ = j.b.dXj();
      ((djt)localObject1).toUser = "";
      Bdo.HRv.add(localObject1);
      dYC();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.dJc().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    p.h(parama, "commentDetail");
    y.f localf = new y.f();
    j.b localb = com.tencent.mm.plugin.story.f.j.BbE;
    localf.NiY = j.b.elE().Br(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.NiY == null)
    {
      localf.NiY = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentId != parama.Bdb) && (((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime < parama.icw))
    {
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentId = parama.Bdb;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime = parama.icw;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).aDw(parama.dzZ);
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).aDi(parama.Bdj);
      parama = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elE().update((com.tencent.mm.sdk.e.c)localf.NiY, new String[0]);
      com.tencent.mm.ac.c.h((d.g.a.a)new i(localf));
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
    if (!Bds.contains(paramr)) {
      Bds.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void dYC()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = Bdo.HRv.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (djt)Bdo.HRv.get(i);
      if ((((djt)localObject2).state == 1) || (((djt)localObject2).state == 3))
      {
        int m = ((djt)localObject2).icw;
        int n = ch.aDd();
        localObject3 = i.Bbh;
        if (m > n - i.els()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    Bdo.HRv.clear();
    Bdo.HRv.addAll((Collection)localObject1);
    Bdr += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      Bdr = -1;
      AppMethodBeat.o(118873);
      return;
    }
    Bdr %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject4 = (djt)localObject3;
      if ((i >= Bdr) && (((djt)localObject4).retryCount < tBm)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (djt)d.a.j.jm((List)localObject1);
    if ((localObject1 != null) && (((djt)localObject1).state == 1))
    {
      ae.i(TAG, "postCommentToRemote " + ((djt)localObject1).toUser + ' ' + ((djt)localObject1).dLI + ' ' + ((djt)localObject1).HRB + ' ' + ((djt)localObject1).icw);
      Bdp = (djt)localObject1;
      localObject2 = a((djt)localObject1);
      localObject3 = (CharSequence)((djs)localObject2).hFS;
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
        localObject3 = com.tencent.mm.plugin.story.h.e.Bjr;
        com.tencent.mm.plugin.story.h.e.enx();
      }
      for (;;)
      {
        localObject3 = g.ajQ();
        p.g(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).ajj();
        localObject4 = ((djt)localObject1).clientId;
        p.g(localObject4, "commentOp.clientId");
        ((com.tencent.mm.ak.q)localObject3).b((com.tencent.mm.ak.n)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (djs)localObject2, ((djt)localObject1).sessionId, Bdq));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.Bjr;
        com.tencent.mm.plugin.story.h.e.eny();
      }
    }
    if ((localObject1 != null) && (((djt)localObject1).state == 3))
    {
      ae.i(TAG, "deleteCommentToRemote " + ((djt)localObject1).toUser + ' ' + ((djt)localObject1).dLI + ' ' + ((djt)localObject1).Bdb + ' ' + ((djt)localObject1).icw);
      Bdp = (djt)localObject1;
      localObject2 = new ArrayList();
      long l = ((djt)localObject1).dLI;
      localObject3 = com.tencent.mm.plugin.story.i.a.BkN;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.eov(), ((djt)localObject1).Bdb));
      localObject1 = g.ajQ();
      p.g(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).ajj().b((com.tencent.mm.ak.n)new com.tencent.mm.plugin.story.f.a.f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void e(r<? super Long, ? super Boolean, ? super String, ? super String, z> paramr)
  {
    AppMethodBeat.i(118864);
    p.h(paramr, "listener");
    Bds.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void emp()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = Bdo.toByteArray();
    o.C(zDi, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void f(m<? super Boolean, ? super Long, z> paramm)
  {
    AppMethodBeat.i(118865);
    p.h(paramm, "listener");
    if (!Bdu.contains(paramm)) {
      Bdu.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void g(m<? super Boolean, ? super Long, z> paramm)
  {
    AppMethodBeat.i(118866);
    p.h(paramm, "listener");
    Bdu.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void j(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elB().Bv(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    dkn localdkn = new dkn();
    try
    {
      localdkn.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localdkn.HSk;
        p.g(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((djs)paramString.next()).HNk == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localdkn.HSk.remove(i);
              localdkn.CommentCount = localdkn.HSk.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localdkn.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.elB().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localdkn.HSk;
          p.g(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!bu.lX(((djs)((Iterator)localObject2).next()).hFS, paramString)) {}
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
    ae.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    p.h(paramn, "scene");
    int j = paramn.getType();
    ae.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramn).rr.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (djv)paramString;
      paramn = ((com.tencent.mm.plugin.story.f.a.c)paramn).BcJ;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = Bdp;
        if (paramString != null)
        {
          paramString = paramString.content;
          ae.i((String)localObject2, paramString + ' ' + ((djv)localObject1).HNk);
          paramString = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new d((djv)localObject1));
          if (paramn != null) {
            paramn.Bdb = ((djv)localObject1).HNk;
          }
          paramString = ((Iterable)Bdu).iterator();
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
        for (l = paramn.dLI;; l = 0L)
        {
          ((m)localObject2).p(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = Bdp;
        if (paramString != null) {
          paramString.Bdb = ((djv)localObject1).HNk;
        }
        paramString = Bdp;
        if (paramString != null) {
          paramString.state = 2;
        }
        Bdp = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.dJc().postDelayed((Runnable)e.BdA, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = Bdp;
        if (paramString != null)
        {
          paramString = paramString.content;
          ae.i((String)localObject1, paramString);
          paramString = Bdp;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = Bdp;
          if (paramString != null) {
            paramString.retryCount = tBm;
          }
          label463:
          Bdp = null;
          paramString = ((Iterable)Bdu).iterator();
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
        for (l = paramn.dLI;; l = 0L)
        {
          ((m)localObject1).p(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = Bdp;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((com.tencent.mm.plugin.story.f.a.f)paramn).emo() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramn = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = Bdp;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      ae.i(paramn, paramString);
      paramString = Bdp;
      if (paramString != null) {
        paramString.state = 4;
      }
      Bdp = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.dJc().postDelayed((Runnable)f.BdB, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramn = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = Bdp;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      ae.i(paramn, paramString);
      paramString = Bdp;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = Bdp;
      if (paramString != null) {
        paramString.retryCount = tBm;
      }
    }
    for (;;)
    {
      Bdp = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = Bdp;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public a(y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    public b(y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.Bdv;
      b.k(this.Bdx, paramString2, this.fMx);
      AppMethodBeat.o(118851);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(djv paramdjv) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.Bdv;
      b.b(this.Bdz.HRH);
      AppMethodBeat.o(118852);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e BdA;
    
    static
    {
      AppMethodBeat.i(118854);
      BdA = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b localb = b.Bdv;
      b.ems();
      AppMethodBeat.o(118853);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f BdB;
    
    static
    {
      AppMethodBeat.i(118856);
      BdB = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b localb = b.Bdv;
      b.ems();
      AppMethodBeat.o(118855);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(djt paramdjt) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.Bdv;
      b.a(b.b(this.BdC));
      AppMethodBeat.o(118857);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    h(y.f paramf, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(y.f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */