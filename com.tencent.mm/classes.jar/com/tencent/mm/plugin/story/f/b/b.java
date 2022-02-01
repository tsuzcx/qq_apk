package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.v.e;
import d.v;
import d.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.al.g, h
{
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int rla = 2147483647;
  public static final String wJq;
  public static final String ygP;
  private static final int ygQ = 50;
  public static final cxx ygR;
  private static cxz ygS;
  private static a ygT;
  private static int ygU;
  private static final ArrayList<r<Long, Boolean, String, String, y>> ygV;
  private static final LinkedList<Object> ygW;
  private static final LinkedList<m<Boolean, Long, y>> ygX;
  public static final b ygY;
  
  static
  {
    AppMethodBeat.i(118882);
    ygY = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ygP = ((com.tencent.mm.kernel.e)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    wJq = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    ygQ = 50;
    rla = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    ygR = new cxx();
    ygU = -1;
    ygV = new ArrayList();
    ygW = new LinkedList();
    ygX = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  private static a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(118874);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dta() + bt.GC();
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
    localObject1 = new cxz();
    ((cxz)localObject1).clientId = ((String)localObject2);
    ((cxz)localObject1).dAu = paramLong;
    ((cxz)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.yfh;
    ((cxz)localObject1).dpv = j.b.dta();
    ((cxz)localObject1).toUser = paramString1;
    ((cxz)localObject1).hgr = ce.asT();
    ((cxz)localObject1).state = 1;
    ((cxz)localObject1).Eqd = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ((cxz)localObject1).Eqe = i;
      ((cxz)localObject1).sessionId = paramString3;
      ((cxz)localObject1).ygM = paramString4;
      ((cxz)localObject1).ygN = paramInt1;
      ((cxz)localObject1).xyh = paramInt2;
      ygR.EpX.add(localObject1);
      ygT = new a((cxz)localObject1);
      dup();
      paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dhI().post((Runnable)new g((cxz)localObject1));
      paramString1 = ygT;
      if (paramString1 == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118874);
      return paramString1;
      i = 0;
    }
  }
  
  private static cxy a(cxz paramcxz)
  {
    AppMethodBeat.i(118876);
    cxy localcxy = new cxy();
    localcxy.Id = paramcxz.dAu;
    localcxy.Ema = paramcxz.ygE;
    localcxy.sdQ = paramcxz.dpv;
    localcxy.sdP = paramcxz.toUser;
    localcxy.gKr = paramcxz.content;
    localcxy.CreateTime = paramcxz.hgr;
    localcxy.Eqb = paramcxz.Eqd;
    localcxy.Eqc = paramcxz.Eqe;
    localcxy.ElZ = paramcxz.ygN;
    localcxy.Eme = paramcxz.xyh;
    AppMethodBeat.o(118876);
    return localcxy;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    d.g.b.k.h(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    com.tencent.mm.plugin.story.i.c localc = j.b.dHg().tS(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.ygE;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.hgr;
    parama = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHg().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(cyt paramcyt)
  {
    AppMethodBeat.i(118877);
    if (paramcyt != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      Object localObject2 = j.b.dHd().tW(paramcyt.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      if (bt.kU(j.b.dta(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).qR(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      if (bt.kU(j.b.dta(), paramcyt.mAQ)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.yor;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.dJH();; i = com.tencent.mm.plugin.story.i.a.dJI())
      {
        localObject2 = com.tencent.mm.plugin.story.f.n.yfw;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, paramcyt, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.yor;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(cyz paramcyz)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    cxy localcxy1 = new cxy();
    localcxy1.Id = paramcyz.Id;
    localcxy1.Ema = paramcyz.EqX.Ema;
    localcxy1.sdQ = paramcyz.EqX.sdQ;
    localcxy1.sdP = paramcyz.EqX.sdP;
    localcxy1.gKr = paramcyz.EqX.gKr;
    localcxy1.CreateTime = paramcyz.EqX.CreateTime;
    localcxy1.Eqb = paramcyz.EqX.Eqb;
    localcxy1.ElZ = paramcyz.EqX.ElZ;
    if (paramcyz.EqX.mBH == 7)
    {
      localObject = a.e.yoC;
      localcxy1.Eme = a.e.dKr();
    }
    long l = localcxy1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
    localObject = j.b.dHd().tW(l);
    if (localObject == null)
    {
      a(paramcyz.EqX.Eqj);
      AppMethodBeat.o(118878);
      return;
    }
    cyt localcyt = new cyt();
    try
    {
      localcyt.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (bt.isNullOrNil(localcxy1.gKr))
      {
        i = localcxy1.Eme;
        paramcyz = a.e.yoC;
        if (i == a.e.dKr())
        {
          paramcyz = localcyt.EqS;
          d.g.b.k.g(paramcyz, "storyObj.VisitorList");
          localIterator = ((Iterable)paramcyz).iterator();
          if (localIterator.hasNext())
          {
            paramcyz = localIterator.next();
            cxy localcxy2 = (cxy)paramcyz;
            if ((localcxy2.Ema == localcxy1.Ema) || (bt.kU(localcxy2.sdQ, localcxy1.sdQ))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((cxy)paramcyz == null)
        {
          localcyt.EqS.add(localcxy1);
          i = 1;
        }
        label330:
        paramcyz = localcyt.EqS;
        d.g.b.k.g(paramcyz, "storyObj.VisitorList");
        localIterator = ((Iterable)paramcyz).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramcyz = localIterator.next();
            if (bt.kU(((cxy)paramcyz).sdQ, localcxy1.sdQ))
            {
              if ((cxy)paramcyz == null) {
                localcyt.EqS.add(localcxy1);
              }
              if (i != 0)
              {
                localcyt.CommentCount = localcyt.EqM.size();
                localcyt.EqN = localcyt.EqO.size();
                localcyt.EqR = localcyt.EqS.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localcyt.toByteArray();
          label461:
          paramcyz = com.tencent.mm.plugin.story.f.j.yfh;
          if (bt.kU(j.b.dta(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).qR(true);
          }
          paramcyz = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHd().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          paramcyz = null;
          break label308;
          if (bt.isNullOrNil(localcxy1.gKr))
          {
            if (localcxy1.Ema != 0)
            {
              paramcyz = localcyt.EqO;
              d.g.b.k.g(paramcyz, "storyObj.BubbleList");
              localIterator = ((Iterable)paramcyz).iterator();
              label558:
              if (localIterator.hasNext())
              {
                paramcyz = localIterator.next();
                if (((cxy)paramcyz).Ema == localcxy1.Ema)
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
                if ((cxy)paramcyz != null) {
                  break;
                }
                localcyt.EqO.add(localcxy1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                paramcyz = null;
              }
            }
            localcyt.EqO.add(localcxy1);
            i = 1;
            break label330;
          }
          if (localcxy1.Ema != 0)
          {
            paramcyz = localcyt.EqM;
            d.g.b.k.g(paramcyz, "storyObj.CommentList");
            localIterator = ((Iterable)paramcyz).iterator();
            label680:
            if (localIterator.hasNext())
            {
              paramcyz = localIterator.next();
              if (((cxy)paramcyz).Ema == localcxy1.Ema)
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
              if ((cxy)paramcyz != null) {
                break;
              }
              localcyt.EqM.add(localcxy1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              paramcyz = null;
            }
          }
          localcyt.EqM.add(localcxy1);
          i = 1;
          break label330;
          paramcyz = null;
        }
        catch (Exception paramcyz)
        {
          break label461;
        }
      }
    }
    catch (Exception paramcyz)
    {
      break label197;
    }
  }
  
  public static void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.z.c.adr().cI(352279, 266241);
    ad.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ad.c.g((d.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    d.g.b.k.h(paramString2, "content");
    ad.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = j.b.dta() + bt.GC();
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
      localObject1 = new cxz();
      ((cxz)localObject1).dAu = paramLong;
      ((cxz)localObject1).clientId = ((String)localObject2);
      ((cxz)localObject1).ygE = paramInt;
      ((cxz)localObject1).hgr = ce.asT();
      ((cxz)localObject1).state = 3;
      ((cxz)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
      ((cxz)localObject1).dpv = j.b.dta();
      ((cxz)localObject1).toUser = "";
      ygR.EpX.add(localObject1);
      dup();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dhI().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    d.g.b.k.h(parama, "commentDetail");
    v.e locale = new v.e();
    j.b localb = com.tencent.mm.plugin.story.f.j.yfh;
    locale.Jhw = j.b.dHg().tS(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)locale.Jhw == null)
    {
      locale.Jhw = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentId != parama.ygE) && (((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime < parama.hgr))
    {
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentId = parama.ygE;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime = parama.hgr;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).arQ(parama.dpv);
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).arC(parama.ygM);
      parama = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHg().update((com.tencent.mm.sdk.e.c)locale.Jhw, new String[0]);
      com.tencent.mm.ad.c.g((d.g.a.a)new i(locale));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void c(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(118863);
    d.g.b.k.h(paramr, "listener");
    if (!ygV.contains(paramr)) {
      ygV.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void d(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(118864);
    d.g.b.k.h(paramr, "listener");
    ygV.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void dHR()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = ygR.toByteArray();
    com.tencent.mm.vfs.i.B(wJq, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void dup()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = ygR.EpX.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (cxz)ygR.EpX.get(i);
      if ((((cxz)localObject2).state == 1) || (((cxz)localObject2).state == 3))
      {
        int m = ((cxz)localObject2).hgr;
        int n = ce.asT();
        localObject3 = com.tencent.mm.plugin.story.f.i.yeK;
        if (m > n - com.tencent.mm.plugin.story.f.i.dGU()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    ygR.EpX.clear();
    ygR.EpX.addAll((Collection)localObject1);
    ygU += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      ygU = -1;
      AppMethodBeat.o(118873);
      return;
    }
    ygU %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.fvx();
      }
      localObject4 = (cxz)localObject3;
      if ((i >= ygU) && (((cxz)localObject4).retryCount < rla)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (cxz)d.a.j.iz((List)localObject1);
    if ((localObject1 != null) && (((cxz)localObject1).state == 1))
    {
      ad.i(TAG, "postCommentToRemote " + ((cxz)localObject1).toUser + ' ' + ((cxz)localObject1).dAu + ' ' + ((cxz)localObject1).Eqd + ' ' + ((cxz)localObject1).hgr);
      ygS = (cxz)localObject1;
      localObject2 = a((cxz)localObject1);
      localObject3 = (CharSequence)((cxy)localObject2).gKr;
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
        localObject3 = com.tencent.mm.plugin.story.h.e.ymV;
        com.tencent.mm.plugin.story.h.e.dIY();
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.kernel.g.afA();
        d.g.b.k.g(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).aeS();
        localObject4 = ((cxz)localObject1).clientId;
        d.g.b.k.g(localObject4, "commentOp.clientId");
        ((q)localObject3).b((com.tencent.mm.al.n)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (cxy)localObject2, ((cxz)localObject1).sessionId, ygT));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.ymV;
        com.tencent.mm.plugin.story.h.e.dIZ();
      }
    }
    if ((localObject1 != null) && (((cxz)localObject1).state == 3))
    {
      ad.i(TAG, "deleteCommentToRemote " + ((cxz)localObject1).toUser + ' ' + ((cxz)localObject1).dAu + ' ' + ((cxz)localObject1).ygE + ' ' + ((cxz)localObject1).hgr);
      ygS = (cxz)localObject1;
      localObject2 = new ArrayList();
      long l = ((cxz)localObject1).dAu;
      localObject3 = com.tencent.mm.plugin.story.i.a.yor;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.dJW(), ((cxz)localObject1).ygE));
      localObject1 = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).aeS().b((com.tencent.mm.al.n)new f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void e(m<? super Boolean, ? super Long, y> paramm)
  {
    AppMethodBeat.i(118865);
    d.g.b.k.h(paramm, "listener");
    if (!ygX.contains(paramm)) {
      ygX.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void f(m<? super Boolean, ? super Long, y> paramm)
  {
    AppMethodBeat.i(118866);
    d.g.b.k.h(paramm, "listener");
    ygX.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void g(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHd().tW(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    cyt localcyt = new cyt();
    try
    {
      localcyt.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localcyt.EqM;
        d.g.b.k.g(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((cxy)paramString.next()).Ema == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localcyt.EqM.remove(i);
              localcyt.CommentCount = localcyt.EqM.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localcyt.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dHd().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localcyt.EqM;
          d.g.b.k.g(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!bt.kU(((cxy)((Iterator)localObject2).next()).gKr, paramString)) {}
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
  
  public static void tG(long paramLong)
  {
    AppMethodBeat.i(118871);
    v.e locale = new v.e();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    locale.Jhw = j.b.dHg().tS(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)locale.Jhw == null)
    {
      locale.Jhw = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    final com.tencent.mm.plugin.story.i.j localj = j.b.dHd().tW(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new cyt();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((cyt)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label118:
      int i;
      break label118;
    }
    localObject1 = ((cyt)localObject2).EqM;
    d.g.b.k.g(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label150:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((cxy)localObject1).Ema != 0)
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
      localObject2 = (cxy)localObject1;
      if (localObject2 == null) {
        break label395;
      }
      if ((((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentId != ((cxy)localObject2).Ema) && (((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime < ((cxy)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentId = ((cxy)localObject2).Ema;
        ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime = ((cxy)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
        localObject2 = ((cxy)localObject2).sdQ;
        d.g.b.k.g(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).arQ((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.arC((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHg().update((com.tencent.mm.sdk.e.c)locale.Jhw, new String[0]);
        com.tencent.mm.ad.c.g((d.g.a.a)new h(locale, localj));
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
  
  public static void tH(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    com.tencent.mm.plugin.story.i.j localj = j.b.dHd().tW(paramLong);
    v.e locale = new v.e();
    localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHg().tS(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    locale.Jhw = localObject1;
    if (localj == null)
    {
      ad.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).arQ("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
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
      ((com.tencent.mm.plugin.story.i.c)localObject3).arC((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHg().replace((com.tencent.mm.sdk.e.c)locale.Jhw);
      com.tencent.mm.ad.c.g((d.g.a.a)new k(locale));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new cyt();
      try
      {
        ((cyt)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((cyt)localObject3).EqM;
        d.g.b.k.g(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (cxy)localObject1;
          if ((((cxy)localObject4).Ema != 0) && (((cxy)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (cxy)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.ydS.dGh()) {
              break label782;
            }
            localObject1 = ((cyt)localObject3).EqS;
            d.g.b.k.g(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (cxy)localObject1;
            if ((((cxy)localObject4).Ema == 0) || (((cxy)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (cxy)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((cxy)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((cxy)localObject1).Ema);
            label495:
            ad.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
            if (localObject1 == null) {
              break label901;
            }
            i = ((cxy)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
            if (localObject1 == null) {
              break label906;
            }
            i = ((cxy)localObject1).Ema;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
            if (localObject1 == null) {
              break label911;
            }
            i = ((cxy)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
            if (localObject1 == null) {
              break label916;
            }
            i = ((cxy)localObject1).Ema;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
            if (localObject1 != null)
            {
              localObject2 = ((cxy)localObject1).sdQ;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).arQ((String)localObject1);
            localObject1 = ((cyt)localObject3).EqM;
            d.g.b.k.g(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (cxy)localObject1;
            if ((((cxy)localObject3).Ema == 0) || (((cxy)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((cxy)localObject1 == null)
        {
          localj.qR(false);
          localObject1 = com.tencent.mm.plugin.story.f.n.yfw;
          n.a.R(localj.field_storyID, localj.field_localFlag);
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
          localObject1 = ((cyt)localObject3).EqO;
          d.g.b.k.g(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (cxy)localObject1;
            if ((((cxy)localObject4).Ema != 0) && (((cxy)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime))
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
            localObject1 = (cxy)localObject1;
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
    ad.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    d.g.b.k.h(paramn, "scene");
    int j = paramn.getType();
    ad.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramn).rr.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (cyb)paramString;
      paramn = ((com.tencent.mm.plugin.story.f.a.c)paramn).ygm;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = ygS;
        if (paramString != null)
        {
          paramString = paramString.content;
          ad.i((String)localObject2, paramString + ' ' + ((cyb)localObject1).Ema);
          paramString = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new d((cyb)localObject1));
          if (paramn != null) {
            paramn.ygE = ((cyb)localObject1).Ema;
          }
          paramString = ((Iterable)ygX).iterator();
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
        for (l = paramn.dAu;; l = 0L)
        {
          ((m)localObject2).n(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = ygS;
        if (paramString != null) {
          paramString.ygE = ((cyb)localObject1).Ema;
        }
        paramString = ygS;
        if (paramString != null) {
          paramString.state = 2;
        }
        ygS = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dhI().postDelayed((Runnable)e.yhd, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = ygS;
        if (paramString != null)
        {
          paramString = paramString.content;
          ad.i((String)localObject1, paramString);
          paramString = ygS;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = ygS;
          if (paramString != null) {
            paramString.retryCount = rla;
          }
          label463:
          ygS = null;
          paramString = ((Iterable)ygX).iterator();
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
        for (l = paramn.dAu;; l = 0L)
        {
          ((m)localObject1).n(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = ygS;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((f)paramn).dHQ() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramn = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = ygS;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      ad.i(paramn, paramString);
      paramString = ygS;
      if (paramString != null) {
        paramString.state = 4;
      }
      ygS = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dhI().postDelayed((Runnable)f.yhe, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramn = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = ygS;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      ad.i(paramn, paramString);
      paramString = ygS;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = ygS;
      if (paramString != null) {
        paramString.retryCount = rla;
      }
    }
    for (;;)
    {
      ygS = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = ygS;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public a(v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.ygY;
      b.h(this.yha, paramString2, this.fOY);
      AppMethodBeat.o(118851);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(cyb paramcyb) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.ygY;
      b.b(this.yhc.Eqj);
      AppMethodBeat.o(118852);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e yhd;
    
    static
    {
      AppMethodBeat.i(118854);
      yhd = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b localb = b.ygY;
      b.dHU();
      AppMethodBeat.o(118853);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f yhe;
    
    static
    {
      AppMethodBeat.i(118856);
      yhe = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b localb = b.ygY;
      b.dHU();
      AppMethodBeat.o(118855);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(cxz paramcxz) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.ygY;
      b.a(b.b(this.yhf));
      AppMethodBeat.o(118857);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(v.e parame, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(v.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */