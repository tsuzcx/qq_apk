package com.tencent.mm.plugin.story.model.b;

import a.f.a.r;
import a.f.b.u.d;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.i.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "", "", "", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "postCommentToRemote", "removeCommentChangeListener", "removeStoryCommentChangeListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.ai.f, h
{
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int mOi = 2147483647;
  public static final String sxF;
  private static final int sxG = 50;
  public static final cgv sxH;
  private static cgx sxI;
  private static a sxJ;
  private static int sxK;
  private static final ArrayList<r<Long, Boolean, String, String, y>> sxL;
  private static final LinkedList<Object> sxM;
  public static final b sxN;
  
  static
  {
    AppMethodBeat.i(109281);
    sxN = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    i.a locala = i.suJ;
    sxF = i.cAr() + "commentCache.proto";
    sxG = 50;
    mOi = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    sxH = new cgv();
    sxK = -1;
    sxL = new ArrayList();
    sxM = new LinkedList();
    AppMethodBeat.o(109281);
  }
  
  public static void M(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109274);
    boolean bool = com.tencent.mm.x.c.PJ().cc(352279, 266241);
    ab.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ab.b.b((a.f.a.a)new b.i(paramBoolean1));
    }
    AppMethodBeat.o(109274);
  }
  
  public static a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(138761);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.coK() + bo.yB();
    localObject2 = a.l.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(138761);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    a.f.b.j.p(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.xweb.util.d.w((byte[])localObject1);
    localObject1 = new cgx();
    ((cgx)localObject1).clientId = ((String)localObject2);
    ((cgx)localObject1).cJA = paramLong;
    ((cgx)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.model.j.svi;
    ((cgx)localObject1).czp = j.b.coK();
    ((cgx)localObject1).toUser = paramString1;
    ((cgx)localObject1).fDT = cb.abr();
    ((cgx)localObject1).state = 1;
    ((cgx)localObject1).xRJ = 0;
    if (paramBoolean) {}
    for (;;)
    {
      ((cgx)localObject1).xRK = i;
      ((cgx)localObject1).cpW = paramString3;
      ((cgx)localObject1).sxC = paramString4;
      ((cgx)localObject1).sxD = paramInt;
      sxH.xRD.add(localObject1);
      sxJ = new a((cgx)localObject1);
      cpL();
      paramString1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().post((Runnable)new b.f((cgx)localObject1));
      paramString1 = sxJ;
      if (paramString1 == null) {
        a.f.b.j.ebi();
      }
      AppMethodBeat.o(138761);
      return paramString1;
      i = 0;
    }
  }
  
  private static cgw a(cgx paramcgx)
  {
    AppMethodBeat.i(109277);
    cgw localcgw = new cgw();
    localcgw.Id = paramcgx.cJA;
    localcgw.xNY = paramcgx.sxu;
    localcgw.num = paramcgx.czp;
    localcgw.nul = paramcgx.toUser;
    localcgw.ntu = paramcgx.content;
    localcgw.CreateTime = paramcgx.fDT;
    localcgw.xRH = paramcgx.xRJ;
    localcgw.xRI = paramcgx.xRK;
    localcgw.xNX = paramcgx.sxD;
    AppMethodBeat.o(109277);
    return localcgw;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(109272);
    a.f.b.j.q(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.h.c localc = j.b.cAE().mP(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.h.c)localObject).field_readCommentId = parama.sxu;
    ((com.tencent.mm.plugin.story.h.c)localObject).field_readCommentTime = parama.fDT;
    parama = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAE().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    AppMethodBeat.o(109272);
  }
  
  private static void a(chs paramchs)
  {
    AppMethodBeat.i(138762);
    if (paramchs != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      Object localObject2 = j.b.cAB().mV(paramchs.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.h.j();
      }
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      if (bo.isEqual(j.b.coK(), paramchs.jJA)) {
        localObject2 = com.tencent.mm.plugin.story.h.a.sFV;
      }
      for (int i = com.tencent.mm.plugin.story.h.a.cDO();; i = com.tencent.mm.plugin.story.h.a.cDP())
      {
        localObject2 = n.svx;
        n.a.a((com.tencent.mm.plugin.story.h.j)localObject1, paramchs, i);
        AppMethodBeat.o(138762);
        return;
        localObject2 = com.tencent.mm.plugin.story.h.a.sFV;
      }
    }
    AppMethodBeat.o(138762);
  }
  
  public static void a(chy paramchy)
  {
    AppMethodBeat.i(138763);
    cgw localcgw = new cgw();
    localcgw.Id = paramchy.Id;
    localcgw.xNY = paramchy.xSH.xNY;
    localcgw.num = paramchy.xSH.num;
    localcgw.nul = paramchy.xSH.nul;
    localcgw.ntu = paramchy.xSH.ntu;
    localcgw.CreateTime = paramchy.xSH.CreateTime;
    localcgw.xRH = paramchy.xSH.xRH;
    localcgw.xNX = paramchy.xSH.xNX;
    long l = localcgw.Id;
    Object localObject = com.tencent.mm.plugin.story.model.j.svi;
    localObject = j.b.cAB().mV(l);
    if (localObject == null)
    {
      a(paramchy.xSH.xRP);
      AppMethodBeat.o(138763);
      return;
    }
    chs localchs = new chs();
    try
    {
      localchs.parseFrom(((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf);
      Iterator localIterator;
      if (bo.isNullOrNil(localcgw.ntu)) {
        if (localcgw.xNY != 0)
        {
          paramchy = localchs.xSA;
          a.f.b.j.p(paramchy, "storyObj.BubbleList");
          localIterator = ((Iterable)paramchy).iterator();
          if (localIterator.hasNext())
          {
            paramchy = localIterator.next();
            if (((cgw)paramchy).xNY == localcgw.xNY) {
              i = 1;
            }
          }
        }
      }
      label272:
      label312:
      label456:
      while (i != 0) {
        label252:
        if ((cgw)paramchy == null)
        {
          localchs.xSA.add(localcgw);
          i = 1;
          if (i != 0)
          {
            localchs.CommentCount = localchs.xSy.size();
            localchs.xSz = localchs.xSA.size();
          }
          try
          {
            ((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf = localchs.toByteArray();
            paramchy = com.tencent.mm.plugin.story.model.j.svi;
            j.b.cAB().a(l, (com.tencent.mm.plugin.story.h.j)localObject);
            AppMethodBeat.o(138763);
            return;
            i = 0;
            continue;
            paramchy = null;
            break label252;
            localchs.xSA.add(localcgw);
            i = 1;
            break label272;
            if (localcgw.xNY != 0)
            {
              paramchy = localchs.xSy;
              a.f.b.j.p(paramchy, "storyObj.CommentList");
              localIterator = ((Iterable)paramchy).iterator();
              if (localIterator.hasNext())
              {
                paramchy = localIterator.next();
                if (((cgw)paramchy).xNY == localcgw.xNY)
                {
                  i = 1;
                  if (i == 0) {
                    break label456;
                  }
                }
              }
              for (;;)
              {
                if ((cgw)paramchy != null) {
                  break label487;
                }
                localchs.xSy.add(localcgw);
                i = 1;
                break;
                i = 0;
                break label426;
                break label391;
                paramchy = null;
              }
            }
            localchs.xSy.add(localcgw);
            i = 1;
          }
          catch (Exception paramchy)
          {
            break label312;
          }
        }
      }
    }
    catch (Exception paramchy)
    {
      for (;;)
      {
        label391:
        label426:
        continue;
        label487:
        int i = 0;
      }
    }
  }
  
  public static a b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(151071);
    a.f.b.j.q(paramString1, "content");
    a.f.b.j.q(paramString2, "toUsername");
    a.f.b.j.q(paramString4, "storyOwner");
    ab.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt);
    AppMethodBeat.o(151071);
    return paramString1;
  }
  
  public static void b(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(138758);
    a.f.b.j.q(paramr, "listener");
    if (!sxL.contains(paramr)) {
      sxL.add(paramr);
    }
    AppMethodBeat.o(138758);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(109273);
    a.f.b.j.q(parama, "commentDetail");
    u.d locald = new u.d();
    j.b localb = com.tencent.mm.plugin.story.model.j.svi;
    locald.BNq = j.b.cAE().mP(paramLong);
    if ((com.tencent.mm.plugin.story.h.c)locald.BNq == null)
    {
      locald.BNq = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentId != parama.sxu) && (((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime < parama.fDT))
    {
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentId = parama.sxu;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime = parama.fDT;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).adx(parama.czp);
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).adk(parama.sxC);
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).cEL();
      parama = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAE().update((com.tencent.mm.sdk.e.c)locald.BNq, new String[0]);
      com.tencent.mm.ab.b.b((a.f.a.a)new b.h(locald));
      AppMethodBeat.o(109273);
      return true;
    }
    AppMethodBeat.o(109273);
    return false;
  }
  
  public static void c(r<? super Long, ? super Boolean, ? super String, ? super String, y> paramr)
  {
    AppMethodBeat.i(138759);
    a.f.b.j.q(paramr, "listener");
    sxL.remove(paramr);
    AppMethodBeat.o(138759);
  }
  
  public static void cBH()
  {
    AppMethodBeat.i(109268);
    byte[] arrayOfByte = sxH.toByteArray();
    e.q(sxF, arrayOfByte);
    AppMethodBeat.o(109268);
  }
  
  public static void cpL()
  {
    int k = 0;
    AppMethodBeat.i(109275);
    Object localObject1 = new ArrayList();
    int j = sxH.xRD.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (cgx)sxH.xRD.get(i);
      if ((((cgx)localObject2).state == 1) || (((cgx)localObject2).state == 3))
      {
        int m = ((cgx)localObject2).fDT;
        int n = cb.abr();
        localObject3 = i.suJ;
        if (m > n - i.cAp()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    sxH.xRD.clear();
    sxH.xRD.addAll((Collection)localObject1);
    sxK += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      sxK = -1;
      AppMethodBeat.o(109275);
      return;
    }
    sxK %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        a.a.j.eaS();
      }
      localObject4 = (cgx)localObject3;
      if ((i >= sxK) && (((cgx)localObject4).retryCount < mOi)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (cgx)a.a.j.fR((List)localObject1);
    if ((localObject1 != null) && (((cgx)localObject1).state == 1))
    {
      ab.i(TAG, "postCommentToRemote " + ((cgx)localObject1).toUser + ' ' + ((cgx)localObject1).cJA + ' ' + ((cgx)localObject1).xRJ + ' ' + ((cgx)localObject1).fDT);
      sxI = (cgx)localObject1;
      localObject2 = a((cgx)localObject1);
      localObject3 = (CharSequence)((cgw)localObject2).ntu;
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
        localObject3 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.cCS();
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.kernel.g.RK();
        a.f.b.j.p(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).Rc();
        localObject4 = ((cgx)localObject1).clientId;
        a.f.b.j.p(localObject4, "commentOp.clientId");
        ((p)localObject3).b((m)new com.tencent.mm.plugin.story.model.a.d((String)localObject4, (cgw)localObject2, ((cgx)localObject1).cpW, sxJ));
        AppMethodBeat.o(109275);
        return;
        localObject3 = com.tencent.mm.plugin.story.g.f.sEx;
        com.tencent.mm.plugin.story.g.f.cCT();
      }
    }
    if ((localObject1 != null) && (((cgx)localObject1).state == 3))
    {
      ab.i(TAG, "deleteCommentToRemote " + ((cgx)localObject1).toUser + ' ' + ((cgx)localObject1).cJA + ' ' + ((cgx)localObject1).sxu + ' ' + ((cgx)localObject1).fDT);
      sxI = (cgx)localObject1;
      localObject2 = new ArrayList();
      long l = ((cgx)localObject1).cJA;
      localObject3 = com.tencent.mm.plugin.story.h.a.sFV;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.model.a.k(l, com.tencent.mm.plugin.story.h.a.cEd(), ((cgx)localObject1).sxu));
      localObject1 = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).Rc().b((m)new com.tencent.mm.plugin.story.model.a.g((List)localObject2));
    }
    AppMethodBeat.o(109275);
  }
  
  public static void g(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138764);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAB().mV(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(138764);
      return;
    }
    chs localchs = new chs();
    try
    {
      localchs.parseFrom(((com.tencent.mm.plugin.story.h.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localchs.xSy;
        a.f.b.j.p(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((cgw)paramString.next()).xNY == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label185;
            }
            label118:
            if (i != -1)
            {
              localchs.xSy.remove(i);
              localchs.CommentCount = localchs.xSy.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.h.j)localObject1).field_attrBuf = localchs.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.model.j.svi;
          j.b.cAB().a(paramLong, (com.tencent.mm.plugin.story.h.j)localObject1);
          AppMethodBeat.o(138764);
          return;
          j = 0;
          break label113;
          label185:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localchs.xSy;
          a.f.b.j.p(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label230:
          if (((Iterator)localObject2).hasNext()) {
            if (!bo.isEqual(((cgw)((Iterator)localObject2).next()).ntu, paramString)) {}
          }
          for (;;)
          {
            i = paramInt;
            break;
            paramInt += 1;
            break label230;
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
  
  public static void my(long paramLong)
  {
    AppMethodBeat.i(138760);
    u.d locald = new u.d();
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    locald.BNq = j.b.cAE().mP(paramLong);
    if ((com.tencent.mm.plugin.story.h.c)locald.BNq == null)
    {
      locald.BNq = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.h.j localj = j.b.cAB().mV(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(138760);
      return;
    }
    Object localObject2 = new chs();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((chs)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label118:
      int i;
      break label118;
    }
    localObject1 = ((chs)localObject2).xSy;
    a.f.b.j.p(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label150:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((cgw)localObject1).xNY != 0)
      {
        i = 1;
        label180:
        if (i == 0) {
          break label399;
        }
      }
    }
    for (;;)
    {
      localObject2 = (cgw)localObject1;
      if (localObject2 == null) {
        break label406;
      }
      if ((((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentId != ((cgw)localObject2).xNY) && (((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime < ((cgw)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentId = ((cgw)localObject2).xNY;
        ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime = ((cgw)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
        localObject2 = ((cgw)localObject2).num;
        a.f.b.j.p(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.h.c)localObject1).adx((String)localObject2);
        com.tencent.mm.plugin.story.h.c localc = (com.tencent.mm.plugin.story.h.c)locald.BNq;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.adk((String)localObject1);
        ((com.tencent.mm.plugin.story.h.c)locald.BNq).cEL();
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAE().update((com.tencent.mm.sdk.e.c)locald.BNq, new String[0]);
        com.tencent.mm.ab.b.b((a.f.a.a)new b.g(locald, localj));
      }
      AppMethodBeat.o(138760);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label180;
      label399:
      break label150;
      localObject1 = null;
    }
    label406:
    AppMethodBeat.o(138760);
  }
  
  public static void mz(long paramLong)
  {
    String str = null;
    int j = 0;
    AppMethodBeat.i(138765);
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    com.tencent.mm.plugin.story.h.j localj = j.b.cAB().mV(paramLong);
    u.d locald = new u.d();
    localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAE().mP(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(138765);
      return;
    }
    locald.BNq = localObject1;
    if (localj == null)
    {
      ab.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.h.c)locald.BNq).adx("");
    }
    for (;;)
    {
      Object localObject2 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
      if (localj != null)
      {
        str = localj.field_userName;
        localObject1 = str;
        if (str != null) {}
      }
      else
      {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.story.h.c)localObject2).adk((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAE().replace((com.tencent.mm.sdk.e.c)locald.BNq);
      com.tencent.mm.ab.b.b((a.f.a.a)new b.j(locald));
      AppMethodBeat.o(138765);
      return;
      localObject1 = new chs();
      try
      {
        ((chs)localObject1).parseFrom(localj.field_attrBuf);
        label251:
        localObject1 = ((chs)localObject1).xSy;
        a.f.b.j.p(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label289:
        Object localObject3;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject3 = (cgw)localObject1;
          if ((((cgw)localObject3).xNY != 0) && (((cgw)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.h.c)locald.BNq).field_readCommentTime))
          {
            i = 1;
            label344:
            if (i == 0) {
              break label594;
            }
            label348:
            localObject2 = (cgw)localObject1;
            localObject3 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject2 == null) {
              break label602;
            }
            localObject1 = Integer.valueOf(((cgw)localObject2).CreateTime);
            label387:
            localStringBuilder = localStringBuilder.append(localObject1).append(' ');
            localObject1 = str;
            if (localObject2 != null) {
              localObject1 = Integer.valueOf(((cgw)localObject2).xNY);
            }
            ab.i((String)localObject3, localObject1);
            localObject1 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
            if (localObject2 == null) {
              break label608;
            }
            i = ((cgw)localObject2).CreateTime;
            label456:
            ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentTime = i;
            localObject1 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
            if (localObject2 == null) {
              break label613;
            }
            i = ((cgw)localObject2).xNY;
            label483:
            ((com.tencent.mm.plugin.story.h.c)localObject1).field_readCommentId = i;
            localObject1 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
            if (localObject2 == null) {
              break label618;
            }
          }
        }
        label594:
        label602:
        label608:
        label613:
        label618:
        for (int i = ((cgw)localObject2).CreateTime;; i = 0)
        {
          ((com.tencent.mm.plugin.story.h.c)localObject1).field_syncCommentTime = i;
          localObject1 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
          i = j;
          if (localObject2 != null) {
            i = ((cgw)localObject2).xNY;
          }
          ((com.tencent.mm.plugin.story.h.c)localObject1).field_syncCommentId = i;
          localObject3 = (com.tencent.mm.plugin.story.h.c)locald.BNq;
          if (localObject2 != null)
          {
            str = ((cgw)localObject2).num;
            localObject1 = str;
            if (str != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.story.h.c)localObject3).adx((String)localObject1);
          break;
          i = 0;
          break label344;
          break label289;
          localObject1 = null;
          break label348;
          localObject1 = null;
          break label387;
          i = 0;
          break label456;
          i = 0;
          break label483;
        }
      }
      catch (Exception localException)
      {
        break label251;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    long l = 100L;
    int i = 0;
    AppMethodBeat.i(109280);
    a.f.b.j.q(paramm, "scene");
    int j = paramm.getType();
    ab.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.model.a.d)paramm).rr.adn();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(109280);
        throw paramString;
      }
      localObject = (cgz)paramString;
      paramm = ((com.tencent.mm.plugin.story.model.a.d)paramm).sxc;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("post comment success ");
        paramString = sxI;
        if (paramString != null) {}
        for (paramString = paramString.content;; paramString = null)
        {
          ab.i(str, paramString + ' ' + ((cgz)localObject).xNY);
          paramString = com.tencent.mm.plugin.story.model.j.svi;
          j.b.coO().post((Runnable)new c((cgz)localObject));
          if (paramm != null) {
            paramm.sxu = ((cgz)localObject).xNY;
          }
          paramString = sxI;
          if (paramString != null) {
            paramString.sxu = ((cgz)localObject).xNY;
          }
          paramString = sxI;
          if (paramString != null) {
            paramString.state = 2;
          }
          sxI = null;
          l = 100L;
          paramString = com.tencent.mm.plugin.story.model.j.svi;
          j.b.coO().postDelayed((Runnable)b.d.sxT, l);
          AppMethodBeat.o(109280);
          return;
        }
      }
      paramm = TAG;
      localObject = new StringBuilder("post comment fail ");
      paramString = sxI;
      if (paramString != null)
      {
        paramString = paramString.content;
        label342:
        ab.i(paramm, paramString);
        paramString = sxI;
        paramInt2 = i;
        if (paramString != null) {
          paramInt2 = paramString.retryCount;
        }
        if (paramInt1 != 4) {
          break label409;
        }
        paramString = sxI;
        if (paramString != null) {
          paramString.retryCount = mOi;
        }
      }
      for (;;)
      {
        sxI = null;
        l = 300000L;
        break;
        paramString = null;
        break label342;
        label409:
        paramString = sxI;
        if (paramString != null) {
          paramString.retryCount = (paramInt2 + 1);
        }
      }
    }
    if ((j == 764) && ((((com.tencent.mm.plugin.story.model.a.g)paramm).cBG() instanceof com.tencent.mm.plugin.story.model.a.k)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label549;
      }
      paramm = TAG;
      localObject = new StringBuilder("delete comment success ");
      paramString = sxI;
      if (paramString == null) {
        break label544;
      }
    }
    label544:
    for (paramString = paramString.content;; paramString = null)
    {
      ab.i(paramm, paramString);
      paramString = sxI;
      if (paramString != null) {
        paramString.state = 4;
      }
      sxI = null;
      paramString = com.tencent.mm.plugin.story.model.j.svi;
      j.b.coO().postDelayed((Runnable)b.e.sxU, l);
      AppMethodBeat.o(109280);
      return;
    }
    label549:
    paramm = TAG;
    Object localObject = new StringBuilder("delete comment fail ");
    paramString = sxI;
    if (paramString != null)
    {
      paramString = paramString.content;
      label579:
      ab.i(paramm, paramString);
      paramString = sxI;
      if (paramString == null) {
        break label643;
      }
      paramInt2 = paramString.retryCount;
      label606:
      if (paramInt1 != 4) {
        break label648;
      }
      paramString = sxI;
      if (paramString != null) {
        paramString.retryCount = mOi;
      }
    }
    for (;;)
    {
      sxI = null;
      l = 60000L;
      break;
      paramString = null;
      break label579;
      label643:
      paramInt2 = 0;
      break label606;
      label648:
      paramString = sxI;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(cgz paramcgz) {}
    
    public final void run()
    {
      AppMethodBeat.i(109263);
      b localb = b.sxN;
      b.b(this.sxS.xRP);
      AppMethodBeat.o(109263);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b.b
 * JD-Core Version:    0.7.0.1
 */