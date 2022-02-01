package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.a.r;
import d.g.b.v.f;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.ak.g, h
{
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int stT = 2147483647;
  public static final String xVV;
  public static final String ztP;
  private static final int ztQ = 50;
  public static final ddj ztR;
  private static ddl ztS;
  private static a ztT;
  private static int ztU;
  private static final ArrayList<r<Long, Boolean, String, String, y>> ztV;
  private static final LinkedList<Object> ztW;
  private static final LinkedList<m<Boolean, Long, y>> ztX;
  public static final b ztY;
  
  static
  {
    AppMethodBeat.i(118882);
    ztY = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ztP = ((com.tencent.mm.kernel.e)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    xVV = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    ztQ = 50;
    stT = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    ztR = new ddj();
    ztU = -1;
    ztV = new ArrayList();
    ztW = new LinkedList();
    ztX = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  private static a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(118874);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dHx() + bs.Gn();
    localObject2 = d.n.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118874);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    d.g.b.k.g(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
    localObject1 = new ddl();
    ((ddl)localObject1).clientId = ((String)localObject2);
    ((ddl)localObject1).dyg = paramLong;
    ((ddl)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.zsh;
    ((ddl)localObject1).dng = j.b.dHx();
    ((ddl)localObject1).toUser = paramString1;
    ((ddl)localObject1).hGU = ce.azK();
    ((ddl)localObject1).state = 1;
    ((ddl)localObject1).FNf = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ((ddl)localObject1).FNg = i;
      ((ddl)localObject1).sessionId = paramString3;
      ((ddl)localObject1).ztM = paramString4;
      ((ddl)localObject1).ztN = paramInt1;
      ((ddl)localObject1).yKW = paramInt2;
      ztR.FMZ.add(localObject1);
      ztT = new a((ddl)localObject1);
      dIP();
      paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dvq().post((Runnable)new g((ddl)localObject1));
      paramString1 = ztT;
      if (paramString1 == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118874);
      return paramString1;
      i = 0;
    }
  }
  
  private static ddk a(ddl paramddl)
  {
    AppMethodBeat.i(118876);
    ddk localddk = new ddk();
    localddk.Id = paramddl.dyg;
    localddk.FIZ = paramddl.ztE;
    localddk.tlK = paramddl.dng;
    localddk.tlJ = paramddl.toUser;
    localddk.hkR = paramddl.content;
    localddk.CreateTime = paramddl.hGU;
    localddk.FNd = paramddl.FNf;
    localddk.FNe = paramddl.FNg;
    localddk.FIY = paramddl.ztN;
    localddk.FJd = paramddl.yKW;
    AppMethodBeat.o(118876);
    return localddk;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    d.g.b.k.h(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    com.tencent.mm.plugin.story.i.c localc = j.b.dVH().yv(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.ztE;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.hGU;
    parama = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVH().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(def paramdef)
  {
    AppMethodBeat.i(118877);
    if (paramdef != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      Object localObject2 = j.b.dVE().yz(paramdef.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      if (bs.lr(j.b.dHx(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).rP(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      if (bs.lr(j.b.dHx(), paramdef.ncR)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.dYi();; i = com.tencent.mm.plugin.story.i.a.dYj())
      {
        localObject2 = com.tencent.mm.plugin.story.f.n.zsw;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, paramdef, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(del paramdel)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    ddk localddk1 = new ddk();
    localddk1.Id = paramdel.Id;
    localddk1.FIZ = paramdel.FNZ.FIZ;
    localddk1.tlK = paramdel.FNZ.tlK;
    localddk1.tlJ = paramdel.FNZ.tlJ;
    localddk1.hkR = paramdel.FNZ.hkR;
    localddk1.CreateTime = paramdel.FNZ.CreateTime;
    localddk1.FNd = paramdel.FNZ.FNd;
    localddk1.FIY = paramdel.FNZ.FIY;
    if (paramdel.FNZ.ndI == 7)
    {
      localObject = a.e.zCb;
      localddk1.FJd = a.e.dYS();
    }
    long l = localddk1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.zsh;
    localObject = j.b.dVE().yz(l);
    if (localObject == null)
    {
      a(paramdel.FNZ.FNl);
      AppMethodBeat.o(118878);
      return;
    }
    def localdef = new def();
    try
    {
      localdef.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (bs.isNullOrNil(localddk1.hkR))
      {
        i = localddk1.FJd;
        paramdel = a.e.zCb;
        if (i == a.e.dYS())
        {
          paramdel = localdef.FNU;
          d.g.b.k.g(paramdel, "storyObj.VisitorList");
          localIterator = ((Iterable)paramdel).iterator();
          if (localIterator.hasNext())
          {
            paramdel = localIterator.next();
            ddk localddk2 = (ddk)paramdel;
            if ((localddk2.FIZ == localddk1.FIZ) || (bs.lr(localddk2.tlK, localddk1.tlK))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((ddk)paramdel == null)
        {
          localdef.FNU.add(localddk1);
          i = 1;
        }
        label330:
        paramdel = localdef.FNU;
        d.g.b.k.g(paramdel, "storyObj.VisitorList");
        localIterator = ((Iterable)paramdel).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramdel = localIterator.next();
            if (bs.lr(((ddk)paramdel).tlK, localddk1.tlK))
            {
              if ((ddk)paramdel == null) {
                localdef.FNU.add(localddk1);
              }
              if (i != 0)
              {
                localdef.CommentCount = localdef.FNO.size();
                localdef.FNP = localdef.FNQ.size();
                localdef.FNT = localdef.FNU.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localdef.toByteArray();
          label461:
          paramdel = com.tencent.mm.plugin.story.f.j.zsh;
          if (bs.lr(j.b.dHx(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).rP(true);
          }
          paramdel = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVE().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          paramdel = null;
          break label308;
          if (bs.isNullOrNil(localddk1.hkR))
          {
            if (localddk1.FIZ != 0)
            {
              paramdel = localdef.FNQ;
              d.g.b.k.g(paramdel, "storyObj.BubbleList");
              localIterator = ((Iterable)paramdel).iterator();
              label558:
              if (localIterator.hasNext())
              {
                paramdel = localIterator.next();
                if (((ddk)paramdel).FIZ == localddk1.FIZ)
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
                if ((ddk)paramdel != null) {
                  break;
                }
                localdef.FNQ.add(localddk1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                paramdel = null;
              }
            }
            localdef.FNQ.add(localddk1);
            i = 1;
            break label330;
          }
          if (localddk1.FIZ != 0)
          {
            paramdel = localdef.FNO;
            d.g.b.k.g(paramdel, "storyObj.CommentList");
            localIterator = ((Iterable)paramdel).iterator();
            label680:
            if (localIterator.hasNext())
            {
              paramdel = localIterator.next();
              if (((ddk)paramdel).FIZ == localddk1.FIZ)
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
              if ((ddk)paramdel != null) {
                break;
              }
              localdef.FNO.add(localddk1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              paramdel = null;
            }
          }
          localdef.FNO.add(localddk1);
          i = 1;
          break label330;
          paramdel = null;
        }
        catch (Exception paramdel)
        {
          break label461;
        }
      }
    }
    catch (Exception paramdel)
    {
      break label197;
    }
  }
  
  public static void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.y.c.aeH().cG(352279, 266241);
    ac.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ac.c.g((d.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    d.g.b.k.h(paramString2, "content");
    ac.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = j.b.dHx() + bs.Gn();
      localObject2 = d.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(118868);
        throw paramString1;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      d.g.b.k.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
      localObject1 = new ddl();
      ((ddl)localObject1).dyg = paramLong;
      ((ddl)localObject1).clientId = ((String)localObject2);
      ((ddl)localObject1).ztE = paramInt;
      ((ddl)localObject1).hGU = ce.azK();
      ((ddl)localObject1).state = 3;
      ((ddl)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
      ((ddl)localObject1).dng = j.b.dHx();
      ((ddl)localObject1).toUser = "";
      ztR.FMZ.add(localObject1);
      dIP();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dvq().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    d.g.b.k.h(parama, "commentDetail");
    v.f localf = new v.f();
    j.b localb = com.tencent.mm.plugin.story.f.j.zsh;
    localf.KUQ = j.b.dVH().yv(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.KUQ == null)
    {
      localf.KUQ = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentId != parama.ztE) && (((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime < parama.hGU))
    {
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentId = parama.ztE;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime = parama.hGU;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).awZ(parama.dng);
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).awL(parama.ztM);
      parama = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVH().update((com.tencent.mm.sdk.e.c)localf.KUQ, new String[0]);
      com.tencent.mm.ac.c.g((d.g.a.a)new i(localf));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void d(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(118863);
    d.g.b.k.h(paramr, "listener");
    if (!ztV.contains(paramr)) {
      ztV.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void dIP()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = ztR.FMZ.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (ddl)ztR.FMZ.get(i);
      if ((((ddl)localObject2).state == 1) || (((ddl)localObject2).state == 3))
      {
        int m = ((ddl)localObject2).hGU;
        int n = ce.azK();
        localObject3 = com.tencent.mm.plugin.story.f.i.zrK;
        if (m > n - com.tencent.mm.plugin.story.f.i.dVv()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    ztR.FMZ.clear();
    ztR.FMZ.addAll((Collection)localObject1);
    ztU += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      ztU = -1;
      AppMethodBeat.o(118873);
      return;
    }
    ztU %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.fOc();
      }
      localObject4 = (ddl)localObject3;
      if ((i >= ztU) && (((ddl)localObject4).retryCount < stT)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (ddl)d.a.j.iP((List)localObject1);
    if ((localObject1 != null) && (((ddl)localObject1).state == 1))
    {
      ac.i(TAG, "postCommentToRemote " + ((ddl)localObject1).toUser + ' ' + ((ddl)localObject1).dyg + ' ' + ((ddl)localObject1).FNf + ' ' + ((ddl)localObject1).hGU);
      ztS = (ddl)localObject1;
      localObject2 = a((ddl)localObject1);
      localObject3 = (CharSequence)((ddk)localObject2).hkR;
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
        localObject3 = com.tencent.mm.plugin.story.h.e.zAu;
        com.tencent.mm.plugin.story.h.e.dXz();
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.kernel.g.agQ();
        d.g.b.k.g(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).agi();
        localObject4 = ((ddl)localObject1).clientId;
        d.g.b.k.g(localObject4, "commentOp.clientId");
        ((q)localObject3).b((com.tencent.mm.ak.n)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (ddk)localObject2, ((ddl)localObject1).sessionId, ztT));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.zAu;
        com.tencent.mm.plugin.story.h.e.dXA();
      }
    }
    if ((localObject1 != null) && (((ddl)localObject1).state == 3))
    {
      ac.i(TAG, "deleteCommentToRemote " + ((ddl)localObject1).toUser + ' ' + ((ddl)localObject1).dyg + ' ' + ((ddl)localObject1).ztE + ' ' + ((ddl)localObject1).hGU);
      ztS = (ddl)localObject1;
      localObject2 = new ArrayList();
      long l = ((ddl)localObject1).dyg;
      localObject3 = com.tencent.mm.plugin.story.i.a.zBQ;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.dYx(), ((ddl)localObject1).ztE));
      localObject1 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).agi().b((com.tencent.mm.ak.n)new f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void dWs()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = ztR.toByteArray();
    com.tencent.mm.vfs.i.B(xVV, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void e(m<? super Boolean, ? super Long, y> paramm)
  {
    AppMethodBeat.i(118865);
    d.g.b.k.h(paramm, "listener");
    if (!ztX.contains(paramm)) {
      ztX.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void e(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(118864);
    d.g.b.k.h(paramr, "listener");
    ztV.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void f(m<? super Boolean, ? super Long, y> paramm)
  {
    AppMethodBeat.i(118866);
    d.g.b.k.h(paramm, "listener");
    ztX.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void j(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVE().yz(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    def localdef = new def();
    try
    {
      localdef.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localdef.FNO;
        d.g.b.k.g(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((ddk)paramString.next()).FIZ == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localdef.FNO.remove(i);
              localdef.CommentCount = localdef.FNO.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localdef.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dVE().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localdef.FNO;
          d.g.b.k.g(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!bs.lr(((ddk)((Iterator)localObject2).next()).hkR, paramString)) {}
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
  
  public static void yj(long paramLong)
  {
    AppMethodBeat.i(118871);
    v.f localf = new v.f();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localf.KUQ = j.b.dVH().yv(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.KUQ == null)
    {
      localf.KUQ = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    final com.tencent.mm.plugin.story.i.j localj = j.b.dVE().yz(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new def();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((def)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label118:
      int i;
      break label118;
    }
    localObject1 = ((def)localObject2).FNO;
    d.g.b.k.g(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label150:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((ddk)localObject1).FIZ != 0)
      {
        i = 1;
        label180:
        if (i == 0) {
          break label388;
        }
      }
    }
    for (;;)
    {
      localObject2 = (ddk)localObject1;
      if (localObject2 == null) {
        break label395;
      }
      if ((((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentId != ((ddk)localObject2).FIZ) && (((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime < ((ddk)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentId = ((ddk)localObject2).FIZ;
        ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime = ((ddk)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
        localObject2 = ((ddk)localObject2).tlK;
        d.g.b.k.g(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).awZ((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.awL((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVH().update((com.tencent.mm.sdk.e.c)localf.KUQ, new String[0]);
        com.tencent.mm.ac.c.g((d.g.a.a)new h(localf, localj));
      }
      AppMethodBeat.o(118871);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label180;
      label388:
      break label150;
      localObject1 = null;
    }
    label395:
    AppMethodBeat.o(118871);
  }
  
  public static void yk(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    com.tencent.mm.plugin.story.i.j localj = j.b.dVE().yz(paramLong);
    v.f localf = new v.f();
    localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVH().yv(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.KUQ = localObject1;
    if (localj == null)
    {
      ac.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).awZ("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
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
      ((com.tencent.mm.plugin.story.i.c)localObject3).awL((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVH().replace((com.tencent.mm.sdk.e.c)localf.KUQ);
      com.tencent.mm.ac.c.g((d.g.a.a)new k(localf));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new def();
      try
      {
        ((def)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((def)localObject3).FNO;
        d.g.b.k.g(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (ddk)localObject1;
          if ((((ddk)localObject4).FIZ != 0) && (((ddk)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (ddk)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.zqS.dUI()) {
              break label782;
            }
            localObject1 = ((def)localObject3).FNU;
            d.g.b.k.g(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (ddk)localObject1;
            if ((((ddk)localObject4).FIZ == 0) || (((ddk)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (ddk)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((ddk)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((ddk)localObject1).FIZ);
            label495:
            ac.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
            if (localObject1 == null) {
              break label901;
            }
            i = ((ddk)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
            if (localObject1 == null) {
              break label906;
            }
            i = ((ddk)localObject1).FIZ;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
            if (localObject1 == null) {
              break label911;
            }
            i = ((ddk)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
            if (localObject1 == null) {
              break label916;
            }
            i = ((ddk)localObject1).FIZ;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
            if (localObject1 != null)
            {
              localObject2 = ((ddk)localObject1).tlK;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).awZ((String)localObject1);
            localObject1 = ((def)localObject3).FNO;
            d.g.b.k.g(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (ddk)localObject1;
            if ((((ddk)localObject3).FIZ == 0) || (((ddk)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((ddk)localObject1 == null)
        {
          localj.rP(false);
          localObject1 = com.tencent.mm.plugin.story.f.n.zsw;
          n.a.U(localj.field_storyID, localj.field_localFlag);
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
          localObject1 = ((def)localObject3).FNQ;
          d.g.b.k.g(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (ddk)localObject1;
            if ((((ddk)localObject4).FIZ != 0) && (((ddk)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime))
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
            localObject1 = (ddk)localObject1;
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
  
  public final a b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(118867);
    d.g.b.k.h(paramString1, "content");
    d.g.b.k.h(paramString2, "toUsername");
    d.g.b.k.h(paramString4, "storyOwner");
    ac.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    d.g.b.k.h(paramn, "scene");
    int j = paramn.getType();
    ac.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramn).rr.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (ddn)paramString;
      paramn = ((com.tencent.mm.plugin.story.f.a.c)paramn).ztm;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = ztS;
        if (paramString != null)
        {
          paramString = paramString.content;
          ac.i((String)localObject2, paramString + ' ' + ((ddn)localObject1).FIZ);
          paramString = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new d((ddn)localObject1));
          if (paramn != null) {
            paramn.ztE = ((ddn)localObject1).FIZ;
          }
          paramString = ((Iterable)ztX).iterator();
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
        for (l = paramn.dyg;; l = 0L)
        {
          ((m)localObject2).n(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = ztS;
        if (paramString != null) {
          paramString.ztE = ((ddn)localObject1).FIZ;
        }
        paramString = ztS;
        if (paramString != null) {
          paramString.state = 2;
        }
        ztS = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dvq().postDelayed((Runnable)e.zud, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = ztS;
        if (paramString != null)
        {
          paramString = paramString.content;
          ac.i((String)localObject1, paramString);
          paramString = ztS;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = ztS;
          if (paramString != null) {
            paramString.retryCount = stT;
          }
          label463:
          ztS = null;
          paramString = ((Iterable)ztX).iterator();
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
        for (l = paramn.dyg;; l = 0L)
        {
          ((m)localObject1).n(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = ztS;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((f)paramn).dWr() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramn = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = ztS;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      ac.i(paramn, paramString);
      paramString = ztS;
      if (paramString != null) {
        paramString.state = 4;
      }
      ztS = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dvq().postDelayed((Runnable)f.zue, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramn = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = ztS;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      ac.i(paramn, paramString);
      paramString = ztS;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = ztS;
      if (paramString != null) {
        paramString.retryCount = stT;
      }
    }
    for (;;)
    {
      ztS = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = ztS;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public a(v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.ztY;
      b.k(this.zua, paramString2, this.gAl);
      AppMethodBeat.o(118851);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ddn paramddn) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.ztY;
      b.b(this.zuc.FNl);
      AppMethodBeat.o(118852);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e zud;
    
    static
    {
      AppMethodBeat.i(118854);
      zud = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b localb = b.ztY;
      b.dWv();
      AppMethodBeat.o(118853);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f zue;
    
    static
    {
      AppMethodBeat.i(118856);
      zue = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b localb = b.ztY;
      b.dWv();
      AppMethodBeat.o(118855);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(ddl paramddl) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.ztY;
      b.a(b.b(this.zuf));
      AppMethodBeat.o(118857);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(v.f paramf, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(v.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */