package com.tencent.mm.plugin.story.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.h.a.e;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.protocal.protobuf.fie;
import com.tencent.mm.protocal.protobuf.fif;
import com.tencent.mm.protocal.protobuf.fih;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjf;
import com.tencent.mm.protocal.protobuf.fjg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.story.api.h
{
  public static final String Qxx;
  public static final b SlF;
  public static final String SlG;
  private static final int SlH;
  private static final int SlI;
  public static final fid SlJ;
  private static fif SlK;
  private static a SlL;
  private static int SlM;
  private static final ArrayList<r<Long, Boolean, String, String, ah>> SlN;
  private static final LinkedList<Object> SlO;
  private static final LinkedList<kotlin.g.a.m<Boolean, Long, ah>> SlP;
  public static final String TAG;
  
  static
  {
    AppMethodBeat.i(118882);
    SlF = new b();
    SlG = kotlin.g.b.s.X(com.tencent.mm.kernel.h.baE().mCJ, "story/commentCache.proto");
    Qxx = kotlin.g.b.s.X(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getAccStoryPath(), "commentCache.proto");
    SlH = 50;
    SlI = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    SlJ = new fid();
    SlM = -1;
    SlN = new ArrayList();
    SlO = new LinkedList();
    SlP = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  private final a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118874);
    Object localObject1 = new StringBuilder();
    Object localObject2 = StoryCore.SjP;
    localObject1 = StoryCore.b.hgg() + Util.currentTicks();
    localObject2 = kotlin.n.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118874);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
    localObject1 = new fif();
    ((fif)localObject1).clientId = ((String)localObject2);
    ((fif)localObject1).idH = paramLong;
    ((fif)localObject1).content = paramString2;
    paramString2 = StoryCore.SjP;
    ((fif)localObject1).hQQ = StoryCore.b.hgg();
    ((fif)localObject1).toUser = paramString1;
    ((fif)localObject1).createTime = cn.getSyncServerTimeSecond();
    ((fif)localObject1).state = 1;
    ((fif)localObject1).abJb = 0;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((fif)localObject1).abJc = i;
      ((fif)localObject1).sessionId = paramString3;
      ((fif)localObject1).SlC = paramString4;
      ((fif)localObject1).SlD = paramInt1;
      ((fif)localObject1).Rqx = paramInt2;
      SlJ.abIV.add(localObject1);
      SlL = new a((fif)localObject1);
      hhA();
      paramString1 = StoryCore.SjP;
      StoryCore.b.gHI().post(new b..ExternalSyntheticLambda1((fif)localObject1));
      paramString1 = SlL;
      kotlin.g.b.s.checkNotNull(paramString1);
      AppMethodBeat.o(118874);
      return paramString1;
    }
  }
  
  private static fie a(fif paramfif)
  {
    AppMethodBeat.i(118876);
    fie localfie = new fie();
    localfie.Id = paramfif.idH;
    localfie.abDh = paramfif.Slv;
    localfie.IMh = paramfif.hQQ;
    localfie.IMg = paramfif.toUser;
    localfie.nUB = paramfif.content;
    localfie.CreateTime = paramfif.createTime;
    localfie.abIZ = paramfif.abJb;
    localfie.abJa = paramfif.abJc;
    localfie.abDg = paramfif.SlD;
    localfie.abDl = paramfif.Rqx;
    AppMethodBeat.o(118876);
    return localfie;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    kotlin.g.b.s.u(parama, "commentItem");
    Object localObject = StoryCore.SjP;
    com.tencent.mm.plugin.story.h.c localc = StoryCore.b.hvU().vZ(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.h.c)localObject).field_readCommentId = parama.Slv;
    ((com.tencent.mm.plugin.story.h.c)localObject).field_readCommentTime = parama.createTime;
    parama = StoryCore.SjP;
    StoryCore.b.hvU().update((IAutoDBItem)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static final void a(fih paramfih)
  {
    AppMethodBeat.i(367146);
    kotlin.g.b.s.u(paramfih, "$resp");
    a(paramfih.abJh);
    AppMethodBeat.o(367146);
  }
  
  private static void a(fiz paramfiz)
  {
    AppMethodBeat.i(118877);
    Object localObject1;
    Object localObject2;
    if (paramfiz != null)
    {
      localObject1 = StoryCore.SjP;
      localObject2 = StoryCore.b.hvR().wd(paramfiz.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.h.j();
      }
      localObject2 = StoryCore.SjP;
      if (Util.isEqual(StoryCore.b.hgg(), ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.h.j)localObject1).ER(true);
      }
      localObject2 = StoryCore.SjP;
      if (!Util.isEqual(StoryCore.b.hgg(), paramfiz.UserName)) {
        break label104;
      }
      localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    }
    for (int i = com.tencent.mm.plugin.story.h.a.hyu();; i = com.tencent.mm.plugin.story.h.a.hyv())
    {
      localObject2 = com.tencent.mm.plugin.story.model.m.Sks;
      m.a.a((com.tencent.mm.plugin.story.h.j)localObject1, paramfiz, i);
      AppMethodBeat.o(118877);
      return;
      label104:
      localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    }
  }
  
  public static void a(fjf paramfjf)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    fie localfie1 = new fie();
    localfie1.Id = paramfjf.Id;
    localfie1.abDh = paramfjf.abJW.abDh;
    localfie1.IMh = paramfjf.abJW.IMh;
    localfie1.IMg = paramfjf.abJW.IMg;
    localfie1.nUB = paramfjf.abJW.nUB;
    localfie1.CreateTime = paramfjf.abJW.CreateTime;
    localfie1.abIZ = paramfjf.abJW.abIZ;
    localfie1.abDg = paramfjf.abJW.abDg;
    if (paramfjf.abJW.vhJ == 7)
    {
      localObject = a.e.SsC;
      localfie1.abDl = a.e.hze();
    }
    long l = localfie1.Id;
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvR().wd(l);
    if (localObject == null)
    {
      a(paramfjf.abJW.abJh);
      AppMethodBeat.o(118878);
      return;
    }
    fiz localfiz = new fiz();
    try
    {
      localfiz.parseFrom(((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (Util.isNullOrNil(localfie1.nUB))
      {
        i = localfie1.abDl;
        paramfjf = a.e.SsC;
        if (i == a.e.hze())
        {
          paramfjf = localfiz.abJR;
          kotlin.g.b.s.s(paramfjf, "storyObj.VisitorList");
          localIterator = ((Iterable)paramfjf).iterator();
          if (localIterator.hasNext())
          {
            paramfjf = localIterator.next();
            fie localfie2 = (fie)paramfjf;
            if ((localfie2.abDh == localfie1.abDh) || (Util.isEqual(localfie2.IMh, localfie1.IMh))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((fie)paramfjf == null)
        {
          localfiz.abJR.add(localfie1);
          i = 1;
        }
        label330:
        paramfjf = localfiz.abJR;
        kotlin.g.b.s.s(paramfjf, "storyObj.VisitorList");
        localIterator = ((Iterable)paramfjf).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            paramfjf = localIterator.next();
            if (Util.isEqual(((fie)paramfjf).IMh, localfie1.IMh))
            {
              if ((fie)paramfjf == null) {
                localfiz.abJR.add(localfie1);
              }
              if (i != 0)
              {
                localfiz.CommentCount = localfiz.abJL.size();
                localfiz.abJM = localfiz.abJN.size();
                localfiz.abJQ = localfiz.abJR.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf = localfiz.toByteArray();
          label461:
          paramfjf = StoryCore.SjP;
          if (Util.isEqual(StoryCore.b.hgg(), ((com.tencent.mm.plugin.story.h.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.h.j)localObject).ER(true);
          }
          paramfjf = StoryCore.SjP;
          StoryCore.b.hvR().e((com.tencent.mm.plugin.story.h.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          paramfjf = null;
          break label308;
          if (Util.isNullOrNil(localfie1.nUB))
          {
            if (localfie1.abDh != 0)
            {
              paramfjf = localfiz.abJN;
              kotlin.g.b.s.s(paramfjf, "storyObj.BubbleList");
              localIterator = ((Iterable)paramfjf).iterator();
              label558:
              if (localIterator.hasNext())
              {
                paramfjf = localIterator.next();
                if (((fie)paramfjf).abDh == localfie1.abDh)
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
                if ((fie)paramfjf != null) {
                  break;
                }
                localfiz.abJN.add(localfie1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                paramfjf = null;
              }
            }
            localfiz.abJN.add(localfie1);
            i = 1;
            break label330;
          }
          if (localfie1.abDh != 0)
          {
            paramfjf = localfiz.abJL;
            kotlin.g.b.s.s(paramfjf, "storyObj.CommentList");
            localIterator = ((Iterable)paramfjf).iterator();
            label680:
            if (localIterator.hasNext())
            {
              paramfjf = localIterator.next();
              if (((fie)paramfjf).abDh == localfie1.abDh)
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
              if ((fie)paramfjf != null) {
                break;
              }
              localfiz.abJL.add(localfie1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              paramfjf = null;
            }
          }
          localfiz.abJL.add(localfie1);
          i = 1;
          break label330;
          paramfjf = null;
        }
        catch (Exception paramfjf)
        {
          break label461;
        }
      }
    }
    catch (Exception paramfjf)
    {
      break label197;
    }
  }
  
  private static final void b(fif paramfif)
  {
    AppMethodBeat.i(367145);
    kotlin.g.b.s.u(paramfif, "$commentOp");
    fie localfie = a(paramfif);
    long l = localfie.Id;
    paramfif = StoryCore.SjP;
    Object localObject = StoryCore.b.hvR().wd(l);
    fiz localfiz;
    if (localObject != null) {
      localfiz = new fiz();
    }
    try
    {
      localfiz.parseFrom(((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf);
      Iterator localIterator;
      if (Util.isNullOrNil(localfie.nUB)) {
        if (localfie.abDh != 0)
        {
          paramfif = localfiz.abJN;
          kotlin.g.b.s.s(paramfif, "storyObj.BubbleList");
          localIterator = ((Iterable)paramfif).iterator();
          if (localIterator.hasNext())
          {
            paramfif = localIterator.next();
            if (((fie)paramfif).abDh == localfie.abDh) {
              i = 1;
            }
          }
        }
      }
      label391:
      while (i != 0) {
        label145:
        if ((fie)paramfif == null)
        {
          localfiz.abJN.add(localfie);
          i = 1;
          label165:
          if (i != 0)
          {
            localfiz.CommentCount = localfiz.abJL.size();
            localfiz.abJM = localfiz.abJN.size();
          }
          try
          {
            ((com.tencent.mm.plugin.story.h.j)localObject).field_attrBuf = localfiz.toByteArray();
            label205:
            paramfif = StoryCore.SjP;
            StoryCore.b.hvR().e((com.tencent.mm.plugin.story.h.j)localObject);
            paramfif = ((com.tencent.mm.plugin.story.h.j)localObject).field_userName;
            if (paramfif != null)
            {
              localObject = StoryCore.SjP;
              paramfif = StoryCore.b.hvS().bbJ(paramfif);
              paramfif.field_interactTime = cn.bDu();
              localObject = StoryCore.SjP;
              StoryCore.b.hvS().b(paramfif);
            }
            AppMethodBeat.o(367145);
            return;
            i = 0;
            continue;
            paramfif = null;
            break label145;
            localfiz.abJN.add(localfie);
            i = 1;
            break label165;
            if (localfie.abDh != 0)
            {
              paramfif = localfiz.abJL;
              kotlin.g.b.s.s(paramfif, "storyObj.CommentList");
              localIterator = ((Iterable)paramfif).iterator();
              label326:
              if (localIterator.hasNext())
              {
                paramfif = localIterator.next();
                if (((fie)paramfif).abDh == localfie.abDh)
                {
                  i = 1;
                  label361:
                  if (i == 0) {
                    break label391;
                  }
                }
              }
              for (;;)
              {
                if ((fie)paramfif != null) {
                  break label422;
                }
                localfiz.abJL.add(localfie);
                i = 1;
                break;
                i = 0;
                break label361;
                break label326;
                paramfif = null;
              }
            }
            localfiz.abJL.add(localfie);
            i = 1;
          }
          catch (Exception paramfif)
          {
            break label205;
          }
        }
      }
    }
    catch (Exception paramfif)
    {
      for (;;)
      {
        continue;
        label422:
        int i = 0;
      }
    }
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    kotlin.g.b.s.u(parama, "commentDetail");
    ah.f localf = new ah.f();
    StoryCore.b localb = StoryCore.SjP;
    localf.aqH = StoryCore.b.hvU().vZ(paramLong);
    if (localf.aqH == null)
    {
      localf.aqH = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentId != parama.Slv) && (((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime < parama.createTime))
    {
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentId = parama.Slv;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime = parama.createTime;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).bci(parama.hQQ);
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).bbU(parama.SlC);
      parama = StoryCore.SjP;
      StoryCore.b.hvU().update((IAutoDBItem)localf.aqH, new String[0]);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(localf));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.aa.c.aYo().dV(352279, 266241);
    Log.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static void g(r<? super Long, ? super Boolean, ? super String, ? super String, ah> paramr)
  {
    AppMethodBeat.i(118863);
    kotlin.g.b.s.u(paramr, "listener");
    if (!SlN.contains(paramr)) {
      SlN.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void h(r<? super Long, ? super Boolean, ? super String, ? super String, ah> paramr)
  {
    AppMethodBeat.i(118864);
    kotlin.g.b.s.u(paramr, "listener");
    SlN.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void hhA()
  {
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int k = SlJ.abIV.size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject2 = (fif)SlJ.abIV.get(i);
      Object localObject3;
      if ((((fif)localObject2).state == 1) || (((fif)localObject2).state == 3))
      {
        i = ((fif)localObject2).createTime;
        int m = cn.getSyncServerTimeSecond();
        localObject3 = i.SjL;
        if (i > m - i.hvz()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if (j >= k)
      {
        SlJ.abIV.clear();
        SlJ.abIV.addAll((Collection)localObject1);
        SlM += 1;
        if (((ArrayList)localObject1).size() == 0)
        {
          SlM = -1;
          AppMethodBeat.o(118873);
          return;
        }
        SlM %= ((ArrayList)localObject1).size();
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        i = 0;
        Object localObject4;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (i < 0) {
            kotlin.a.p.kkW();
          }
          localObject4 = (fif)localObject3;
          if ((i >= SlM) && (((fif)localObject4).retryCount < SlI)) {}
          for (j = 1;; j = 0)
          {
            if (j != 0) {
              ((Collection)localObject1).add(localObject3);
            }
            i += 1;
            break;
          }
        }
        localObject1 = (fif)kotlin.a.p.oL((List)localObject1);
        if ((localObject1 != null) && (((fif)localObject1).state == 1))
        {
          Log.i(TAG, "postCommentToRemote " + ((fif)localObject1).toUser + ' ' + ((fif)localObject1).idH + ' ' + ((fif)localObject1).abJb + ' ' + ((fif)localObject1).createTime);
          SlK = (fif)localObject1;
          localObject2 = a((fif)localObject1);
          localObject3 = (CharSequence)((fie)localObject2).nUB;
          if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
          {
            i = 1;
            if (i == 0) {
              break label485;
            }
            localObject3 = com.tencent.mm.plugin.story.g.e.SqW;
            com.tencent.mm.plugin.story.g.e.hxL();
          }
          for (;;)
          {
            localObject3 = com.tencent.mm.kernel.h.baD().mCm;
            localObject4 = ((fif)localObject1).clientId;
            kotlin.g.b.s.s(localObject4, "commentOp.clientId");
            ((com.tencent.mm.am.s)localObject3).a((com.tencent.mm.am.p)new com.tencent.mm.plugin.story.model.a.c((String)localObject4, (fie)localObject2, ((fif)localObject1).sessionId, SlL), 0);
            AppMethodBeat.o(118873);
            return;
            i = 0;
            break;
            label485:
            localObject3 = com.tencent.mm.plugin.story.g.e.SqW;
            com.tencent.mm.plugin.story.g.e.hxM();
          }
        }
        if ((localObject1 != null) && (((fif)localObject1).state == 3))
        {
          Log.i(TAG, "deleteCommentToRemote " + ((fif)localObject1).toUser + ' ' + ((fif)localObject1).idH + ' ' + ((fif)localObject1).Slv + ' ' + ((fif)localObject1).createTime);
          SlK = (fif)localObject1;
          localObject2 = new ArrayList();
          long l = ((fif)localObject1).idH;
          localObject3 = com.tencent.mm.plugin.story.h.a.Sry;
          ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.model.a.j(l, com.tencent.mm.plugin.story.h.a.hyJ(), ((fif)localObject1).Slv));
          com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)new com.tencent.mm.plugin.story.model.a.f((List)localObject2), 0);
        }
        AppMethodBeat.o(118873);
        return;
      }
    }
  }
  
  public static void hwF()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = SlJ.toByteArray();
    y.f(Qxx, arrayOfByte, arrayOfByte.length);
    AppMethodBeat.o(118862);
  }
  
  private static final void hwG()
  {
    AppMethodBeat.i(367147);
    hhA();
    AppMethodBeat.o(367147);
  }
  
  private static final void hwH()
  {
    AppMethodBeat.i(367148);
    hhA();
    AppMethodBeat.o(367148);
  }
  
  public static void l(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR().wd(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    fiz localfiz = new fiz();
    try
    {
      localfiz.parseFrom(((com.tencent.mm.plugin.story.h.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localfiz.abJL;
        kotlin.g.b.s.s(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((fie)paramString.next()).abDh == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localfiz.abJL.remove(i);
              localfiz.CommentCount = localfiz.abJL.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.h.j)localObject1).field_attrBuf = localfiz.toByteArray();
          label158:
          paramString = StoryCore.SjP;
          StoryCore.b.hvR().e((com.tencent.mm.plugin.story.h.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localfiz.abJL;
          kotlin.g.b.s.s(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!Util.isEqual(((fie)((Iterator)localObject2).next()).nUB, paramString)) {}
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
  
  private static final void m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(367144);
    kotlin.g.b.s.u(paramString, "$content");
    l(paramLong, paramInt, paramString);
    AppMethodBeat.o(367144);
  }
  
  public static void s(kotlin.g.a.m<? super Boolean, ? super Long, ah> paramm)
  {
    AppMethodBeat.i(118865);
    kotlin.g.b.s.u(paramm, "listener");
    if (!SlP.contains(paramm)) {
      SlP.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void t(kotlin.g.a.m<? super Boolean, ? super Long, ah> paramm)
  {
    AppMethodBeat.i(118866);
    kotlin.g.b.s.u(paramm, "listener");
    SlP.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void vN(long paramLong)
  {
    AppMethodBeat.i(118871);
    ah.f localf = new ah.f();
    Object localObject1 = StoryCore.SjP;
    localf.aqH = StoryCore.b.hvU().vZ(paramLong);
    if (localf.aqH == null)
    {
      localf.aqH = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_storyId = paramLong;
    }
    localObject1 = StoryCore.SjP;
    Object localObject2 = StoryCore.b.hvR().wd(paramLong);
    if (localObject2 == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    localObject1 = new fiz();
    try
    {
      ((fiz)localObject1).parseFrom(((com.tencent.mm.plugin.story.h.j)localObject2).field_attrBuf);
      label106:
      localObject1 = ((fiz)localObject1).abJL;
      kotlin.g.b.s.s(localObject1, "storyObj.CommentList");
      localObject1 = (List)localObject1;
      Object localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
      int i;
      if (((ListIterator)localObject3).hasPrevious())
      {
        localObject1 = ((ListIterator)localObject3).previous();
        if (((fie)localObject1).abDh != 0)
        {
          i = 1;
          label167:
          if (i == 0) {
            break label365;
          }
        }
      }
      for (;;)
      {
        localObject3 = (fie)localObject1;
        if ((localObject3 != null) && (((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentId != ((fie)localObject3).abDh) && (((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime < ((fie)localObject3).CreateTime))
        {
          ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentId = ((fie)localObject3).abDh;
          ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime = ((fie)localObject3).CreateTime;
          localObject1 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
          localObject3 = ((fie)localObject3).IMh;
          kotlin.g.b.s.s(localObject3, "it.FromUserName");
          ((com.tencent.mm.plugin.story.h.c)localObject1).bci((String)localObject3);
          localObject3 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
          localObject2 = ((com.tencent.mm.plugin.story.h.j)localObject2).field_userName;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ((com.tencent.mm.plugin.story.h.c)localObject3).bbU((String)localObject1);
          localObject1 = StoryCore.SjP;
          StoryCore.b.hvU().update((IAutoDBItem)localf.aqH, new String[0]);
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(localf));
        }
        AppMethodBeat.o(118871);
        return;
        i = 0;
        break label167;
        label365:
        break;
        localObject1 = null;
      }
    }
    catch (Exception localException)
    {
      break label106;
    }
  }
  
  public static void vO(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = StoryCore.SjP;
    com.tencent.mm.plugin.story.h.j localj = StoryCore.b.hvR().wd(paramLong);
    ah.f localf = new ah.f();
    localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvU().vZ(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.aqH = localObject1;
    if (localj == null)
    {
      Log.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.h.c)localf.aqH).bci("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
      if (localj == null)
      {
        localObject1 = "";
        label152:
        ((com.tencent.mm.plugin.story.h.c)localObject3).bbU((String)localObject1);
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvU().replace((IAutoDBItem)localf.aqH);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(localf));
        AppMethodBeat.o(118880);
        return;
        localObject3 = new fiz();
      }
      try
      {
        ((fiz)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((fiz)localObject3).abJL;
        kotlin.g.b.s.s(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        Object localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label251:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (fie)localObject1;
          if ((((fie)localObject4).abDh != 0) && (((fie)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime))
          {
            i = 1;
            label304:
            if (i == 0) {
              break label709;
            }
            label308:
            localObject1 = (fie)localObject1;
            if (localObject1 != null) {
              break label946;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.Sjb.huS()) {
              break label726;
            }
            localObject1 = ((fiz)localObject3).abJR;
            kotlin.g.b.s.s(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label358:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label721;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (fie)localObject1;
            if ((((fie)localObject4).abDh == 0) || (((fie)localObject4).CreateTime > ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime)) {
              break label716;
            }
            i = 1;
            label411:
            if (i == 0) {
              break label719;
            }
            label415:
            localObject1 = (fie)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 != null) {
              break label833;
            }
            localObject2 = null;
            label444:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 != null) {
              break label845;
            }
            localObject2 = null;
            label465:
            Log.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
            if (localObject1 != null) {
              break label857;
            }
            i = 0;
            label496:
            ((com.tencent.mm.plugin.story.h.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
            if (localObject1 != null) {
              break label865;
            }
            i = 0;
            label518:
            ((com.tencent.mm.plugin.story.h.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
            if (localObject1 != null) {
              break label873;
            }
            i = 0;
            label540:
            ((com.tencent.mm.plugin.story.h.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
            if (localObject1 != null) {
              break label881;
            }
            i = 0;
            label562:
            ((com.tencent.mm.plugin.story.h.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.h.c)localf.aqH;
            if (localObject1 != null) {
              break label889;
            }
            localObject1 = "";
            label586:
            ((com.tencent.mm.plugin.story.h.c)localObject4).bci((String)localObject1);
            localObject1 = ((fiz)localObject3).abJL;
            kotlin.g.b.s.s(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label616:
            if (!((Iterator)localObject2).hasNext()) {
              break label915;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (fie)localObject1;
            if ((((fie)localObject3).abDh == 0) || (((fie)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime)) {
              break label910;
            }
            i = 1;
            label669:
            if (i == 0) {
              break label913;
            }
          }
        }
        while ((fie)localObject1 == null)
        {
          localj.ER(false);
          localObject1 = com.tencent.mm.plugin.story.model.m.Sks;
          m.a.aB(localj.field_storyID, localj.field_localFlag);
          break;
          i = 0;
          break label304;
          label709:
          break label251;
          localObject1 = null;
          break label308;
          label716:
          i = 0;
          break label411;
          label719:
          break label358;
          label721:
          localObject1 = null;
          break label415;
          label726:
          localObject1 = ((fiz)localObject3).abJN;
          kotlin.g.b.s.s(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label758:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (fie)localObject1;
            if ((((fie)localObject4).abDh != 0) && (((fie)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.h.c)localf.aqH).field_readCommentTime))
            {
              i = 1;
              if (i == 0) {
                break label826;
              }
            }
          }
          for (;;)
          {
            label811:
            localObject1 = (fie)localObject1;
            break;
            i = 0;
            break label811;
            label826:
            break label758;
            localObject1 = null;
          }
          label833:
          localObject2 = Integer.valueOf(((fie)localObject1).CreateTime);
          break label444;
          label845:
          localObject2 = Integer.valueOf(((fie)localObject1).abDh);
          break label465;
          label857:
          i = ((fie)localObject1).CreateTime;
          break label496;
          label865:
          i = ((fie)localObject1).abDh;
          break label518;
          label873:
          i = ((fie)localObject1).CreateTime;
          break label540;
          label881:
          i = ((fie)localObject1).abDh;
          break label562;
          label889:
          localObject2 = ((fie)localObject1).IMh;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label586;
          }
          localObject1 = "";
          break label586;
          label910:
          i = 0;
          break label669;
          label913:
          break label616;
          label915:
          localObject1 = null;
        }
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label152;
        }
        localObject1 = "";
      }
      catch (Exception localException)
      {
        label946:
        for (;;) {}
      }
    }
  }
  
  public final a b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(118867);
    kotlin.g.b.s.u(paramString1, "content");
    kotlin.g.b.s.u(paramString2, "toUsername");
    kotlin.g.b.s.u(paramString4, "storyOwner");
    Log.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(this, paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void c(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(118868);
    kotlin.g.b.s.u(paramString2, "content");
    Log.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = StoryCore.SjP;
      localObject1 = StoryCore.b.hgg() + Util.currentTicks();
      localObject2 = kotlin.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(118868);
        throw paramString1;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      kotlin.g.b.s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
      localObject1 = new fif();
      ((fif)localObject1).idH = paramLong;
      ((fif)localObject1).clientId = ((String)localObject2);
      ((fif)localObject1).Slv = paramInt;
      ((fif)localObject1).createTime = cn.getSyncServerTimeSecond();
      ((fif)localObject1).state = 3;
      ((fif)localObject1).sessionId = paramString1;
      paramString1 = StoryCore.SjP;
      ((fif)localObject1).hQQ = StoryCore.b.hgg();
      ((fif)localObject1).toUser = "";
      SlJ.abIV.add(localObject1);
      hhA();
    }
    paramString1 = StoryCore.SjP;
    StoryCore.b.gHI().post(new b..ExternalSyntheticLambda0(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    kotlin.g.b.s.u(paramp, "scene");
    int j = paramp.getType();
    Log.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    switch (j)
    {
    }
    label278:
    long l;
    label337:
    label347:
    label483:
    do
    {
      AppMethodBeat.o(118881);
      return;
      paramString = c.c.b(((com.tencent.mm.plugin.story.model.a.c)paramp).rr.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      Object localObject1 = (fih)paramString;
      paramp = ((com.tencent.mm.plugin.story.model.a.c)paramp).Slg;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = SlK;
        if (paramString == null)
        {
          paramString = null;
          Log.i((String)localObject2, paramString + ' ' + ((fih)localObject1).abDh);
          paramString = StoryCore.SjP;
          StoryCore.b.gHI().post(new b..ExternalSyntheticLambda2((fih)localObject1));
          if (paramp != null) {
            paramp.Slv = ((fih)localObject1).abDh;
          }
          paramString = ((Iterable)SlP).iterator();
          if (!paramString.hasNext()) {
            break label347;
          }
          localObject2 = (kotlin.g.a.m)paramString.next();
          localObject3 = Boolean.TRUE;
          if (paramp != null) {
            break label337;
          }
        }
        for (l = 0L;; l = paramp.idH)
        {
          ((kotlin.g.a.m)localObject2).invoke(localObject3, Long.valueOf(l));
          break label278;
          paramString = paramString.content;
          break;
        }
        paramString = SlK;
        if (paramString != null) {
          paramString.Slv = ((fih)localObject1).abDh;
        }
        paramString = SlK;
        if (paramString != null) {
          paramString.state = 2;
        }
        SlK = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = StoryCore.SjP;
        StoryCore.b.gHI().postDelayed(b..ExternalSyntheticLambda4.INSTANCE, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        paramString = SlK;
        if (paramString == null)
        {
          paramString = null;
          Log.i((String)localObject1, kotlin.g.b.s.X("post comment fail ", paramString));
          paramString = SlK;
          if (paramString != null) {
            break label542;
          }
          paramInt2 = i;
          if (paramInt1 != 4) {
            break label550;
          }
          paramString = SlK;
          if (paramString != null) {
            paramString.retryCount = SlI;
          }
          SlK = null;
          paramString = ((Iterable)SlP).iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = (kotlin.g.a.m)paramString.next();
          localObject2 = Boolean.FALSE;
          if (paramp != null) {
            break label568;
          }
        }
        for (l = 0L;; l = paramp.idH)
        {
          ((kotlin.g.a.m)localObject1).invoke(localObject2, Long.valueOf(l));
          break label483;
          paramString = paramString.content;
          break;
          paramInt2 = paramString.retryCount;
          break label447;
          paramString = SlK;
          if (paramString == null) {
            break label467;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label467;
        }
      }
    } while (!(((com.tencent.mm.plugin.story.model.a.f)paramp).hwE() instanceof com.tencent.mm.plugin.story.model.a.j));
    label447:
    label467:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramp = TAG;
      paramString = SlK;
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.content)
      {
        Log.i(paramp, kotlin.g.b.s.X("delete comment success ", paramString));
        paramString = SlK;
        if (paramString != null) {
          paramString.state = 4;
        }
        SlK = null;
        l = 100L;
        paramString = StoryCore.SjP;
        StoryCore.b.gHI().postDelayed(b..ExternalSyntheticLambda3.INSTANCE, l);
        break;
      }
    }
    label542:
    label550:
    label568:
    paramp = TAG;
    paramString = SlK;
    if (paramString == null)
    {
      paramString = null;
      label699:
      Log.i(paramp, kotlin.g.b.s.X("delete comment fail ", paramString));
      paramString = SlK;
      if (paramString != null) {
        break label761;
      }
      paramInt2 = 0;
      label721:
      if (paramInt1 != 4) {
        break label769;
      }
      paramString = SlK;
      if (paramString != null) {
        paramString.retryCount = SlI;
      }
    }
    for (;;)
    {
      SlK = null;
      l = 60000L;
      break;
      paramString = paramString.content;
      break label699;
      label761:
      paramInt2 = paramString.retryCount;
      break label721;
      label769:
      paramString = SlK;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public a(ah.f<com.tencent.mm.plugin.story.h.c> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(ah.f<com.tencent.mm.plugin.story.h.c> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ah.f<com.tencent.mm.plugin.story.h.c> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ah.f<com.tencent.mm.plugin.story.h.c> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(ah.f<com.tencent.mm.plugin.story.h.c> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.b.b
 * JD-Core Version:    0.7.0.1
 */