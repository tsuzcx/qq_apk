package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.api.h;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edi;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.eeh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.ak.i, h
{
  public static final String DNm;
  public static final String Fod;
  private static final int Foe = 50;
  public static final ede Fof;
  private static edg Fog;
  private static a Foh;
  private static int Foi = 0;
  private static final ArrayList<r<Long, Boolean, String, String, x>> Foj;
  private static final LinkedList<Object> Fok;
  private static final LinkedList<m<Boolean, Long, x>> Fol;
  public static final b Fom;
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  private static final int wSn = 2147483647;
  
  static
  {
    AppMethodBeat.i(118882);
    Fom = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    Fod = ((com.tencent.mm.kernel.e)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = g.ah(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    DNm = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    Foe = 50;
    wSn = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    Fof = new ede();
    Foi = -1;
    Foj = new ArrayList();
    Fok = new LinkedList();
    Fol = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  public static void Kk(long paramLong)
  {
    AppMethodBeat.i(118871);
    z.f localf = new z.f();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localf.SYG = j.b.fof().Kw(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.SYG == null)
    {
      localf.SYG = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    final com.tencent.mm.plugin.story.i.j localj = j.b.foc().KA(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new eea();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((eea)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label116:
      int i;
      break label116;
    }
    localObject1 = ((eea)localObject2).Nen;
    p.g(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label148:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((edf)localObject1).MYT != 0)
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
      localObject2 = (edf)localObject1;
      if (localObject2 == null) {
        break label392;
      }
      if ((((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentId != ((edf)localObject2).MYT) && (((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime < ((edf)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentId = ((edf)localObject2).MYT;
        ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime = ((edf)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
        localObject2 = ((edf)localObject2).xNH;
        p.g(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).aSr((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)localf.SYG;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.aSd((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fof().update((IAutoDBItem)localf.SYG, new String[0]);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(localf, localj));
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
  
  public static void Kl(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    com.tencent.mm.plugin.story.i.j localj = j.b.foc().KA(paramLong);
    z.f localf = new z.f();
    localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.fof().Kw(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.SYG = localObject1;
    if (localj == null)
    {
      Log.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).aSr("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
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
      ((com.tencent.mm.plugin.story.i.c)localObject3).aSd((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.fof().replace((IAutoDBItem)localf.SYG);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new k(localf));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new eea();
      try
      {
        ((eea)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((eea)localObject3).Nen;
        p.g(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (edf)localObject1;
          if ((((edf)localObject4).MYT != 0) && (((edf)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (edf)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
              break label782;
            }
            localObject1 = ((eea)localObject3).Net;
            p.g(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (edf)localObject1;
            if ((((edf)localObject4).MYT == 0) || (((edf)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (edf)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((edf)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((edf)localObject1).MYT);
            label495:
            Log.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
            if (localObject1 == null) {
              break label901;
            }
            i = ((edf)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
            if (localObject1 == null) {
              break label906;
            }
            i = ((edf)localObject1).MYT;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
            if (localObject1 == null) {
              break label911;
            }
            i = ((edf)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
            if (localObject1 == null) {
              break label916;
            }
            i = ((edf)localObject1).MYT;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)localf.SYG;
            if (localObject1 != null)
            {
              localObject2 = ((edf)localObject1).xNH;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).aSr((String)localObject1);
            localObject1 = ((eea)localObject3).Nen;
            p.g(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (edf)localObject1;
            if ((((edf)localObject3).MYT == 0) || (((edf)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((edf)localObject1 == null)
        {
          localj.vX(false);
          localObject1 = n.FmM;
          n.a.aa(localj.field_storyID, localj.field_localFlag);
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
          localObject1 = ((eea)localObject3).Nep;
          p.g(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (edf)localObject1;
            if ((((edf)localObject4).MYT != 0) && (((edf)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime))
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
            localObject1 = (edf)localObject1;
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
  
  private final a a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118874);
    Object localObject1 = new StringBuilder();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.fau() + Util.currentTicks();
    localObject2 = kotlin.n.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118874);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
    localObject1 = new edg();
    ((edg)localObject1).clientId = ((String)localObject2);
    ((edg)localObject1).edx = paramLong;
    ((edg)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.Fmy;
    ((edg)localObject1).dRL = j.b.fau();
    ((edg)localObject1).toUser = paramString1;
    ((edg)localObject1).iXu = cl.aWB();
    ((edg)localObject1).state = 1;
    ((edg)localObject1).NdF = 0;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((edg)localObject1).NdG = i;
      ((edg)localObject1).sessionId = paramString3;
      ((edg)localObject1).Foa = paramString4;
      ((edg)localObject1).Fob = paramInt1;
      ((edg)localObject1).ECO = paramInt2;
      Fof.Ndz.add(localObject1);
      Foh = new a((edg)localObject1);
      fbQ();
      paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.eJP().post((Runnable)new g((edg)localObject1));
      paramString1 = Foh;
      if (paramString1 == null) {
        p.hyc();
      }
      AppMethodBeat.o(118874);
      return paramString1;
    }
  }
  
  private static edf a(edg paramedg)
  {
    AppMethodBeat.i(118876);
    edf localedf = new edf();
    localedf.Id = paramedg.edx;
    localedf.MYT = paramedg.FnS;
    localedf.xNH = paramedg.dRL;
    localedf.xNG = paramedg.toUser;
    localedf.iAc = paramedg.content;
    localedf.CreateTime = paramedg.iXu;
    localedf.NdD = paramedg.NdF;
    localedf.NdE = paramedg.NdG;
    localedf.MYS = paramedg.Fob;
    localedf.MYX = paramedg.ECO;
    AppMethodBeat.o(118876);
    return localedf;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    p.h(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    com.tencent.mm.plugin.story.i.c localc = j.b.fof().Kw(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.FnS;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.iXu;
    parama = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fof().update((IAutoDBItem)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(eea parameea)
  {
    AppMethodBeat.i(118877);
    if (parameea != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      Object localObject2 = j.b.foc().KA(parameea.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      if (Util.isEqual(j.b.fau(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).vX(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      if (Util.isEqual(j.b.fau(), parameea.UserName)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.fqG();; i = com.tencent.mm.plugin.story.i.a.fqH())
      {
        localObject2 = n.FmM;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, parameea, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(eeg parameeg)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    edf localedf1 = new edf();
    localedf1.Id = parameeg.Id;
    localedf1.MYT = parameeg.Ney.MYT;
    localedf1.xNH = parameeg.Ney.xNH;
    localedf1.xNG = parameeg.Ney.xNG;
    localedf1.iAc = parameeg.Ney.iAc;
    localedf1.CreateTime = parameeg.Ney.CreateTime;
    localedf1.NdD = parameeg.Ney.NdD;
    localedf1.MYS = parameeg.Ney.MYS;
    if (parameeg.Ney.oUv == 7)
    {
      localObject = a.e.FvO;
      localedf1.MYX = a.e.frq();
    }
    long l = localedf1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject = j.b.foc().KA(l);
    if (localObject == null)
    {
      a(parameeg.Ney.NdL);
      AppMethodBeat.o(118878);
      return;
    }
    eea localeea = new eea();
    try
    {
      localeea.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (Util.isNullOrNil(localedf1.iAc))
      {
        i = localedf1.MYX;
        parameeg = a.e.FvO;
        if (i == a.e.frq())
        {
          parameeg = localeea.Net;
          p.g(parameeg, "storyObj.VisitorList");
          localIterator = ((Iterable)parameeg).iterator();
          if (localIterator.hasNext())
          {
            parameeg = localIterator.next();
            edf localedf2 = (edf)parameeg;
            if ((localedf2.MYT == localedf1.MYT) || (Util.isEqual(localedf2.xNH, localedf1.xNH))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((edf)parameeg == null)
        {
          localeea.Net.add(localedf1);
          i = 1;
        }
        label330:
        parameeg = localeea.Net;
        p.g(parameeg, "storyObj.VisitorList");
        localIterator = ((Iterable)parameeg).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            parameeg = localIterator.next();
            if (Util.isEqual(((edf)parameeg).xNH, localedf1.xNH))
            {
              if ((edf)parameeg == null) {
                localeea.Net.add(localedf1);
              }
              if (i != 0)
              {
                localeea.CommentCount = localeea.Nen.size();
                localeea.Neo = localeea.Nep.size();
                localeea.Nes = localeea.Net.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localeea.toByteArray();
          label461:
          parameeg = com.tencent.mm.plugin.story.f.j.Fmy;
          if (Util.isEqual(j.b.fau(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).vX(true);
          }
          parameeg = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.foc().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          parameeg = null;
          break label308;
          if (Util.isNullOrNil(localedf1.iAc))
          {
            if (localedf1.MYT != 0)
            {
              parameeg = localeea.Nep;
              p.g(parameeg, "storyObj.BubbleList");
              localIterator = ((Iterable)parameeg).iterator();
              label558:
              if (localIterator.hasNext())
              {
                parameeg = localIterator.next();
                if (((edf)parameeg).MYT == localedf1.MYT)
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
                if ((edf)parameeg != null) {
                  break;
                }
                localeea.Nep.add(localedf1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                parameeg = null;
              }
            }
            localeea.Nep.add(localedf1);
            i = 1;
            break label330;
          }
          if (localedf1.MYT != 0)
          {
            parameeg = localeea.Nen;
            p.g(parameeg, "storyObj.CommentList");
            localIterator = ((Iterable)parameeg).iterator();
            label680:
            if (localIterator.hasNext())
            {
              parameeg = localIterator.next();
              if (((edf)parameeg).MYT == localedf1.MYT)
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
              if ((edf)parameeg != null) {
                break;
              }
              localeea.Nen.add(localedf1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              parameeg = null;
            }
          }
          localeea.Nen.add(localedf1);
          i = 1;
          break label330;
          parameeg = null;
        }
        catch (Exception parameeg)
        {
          break label461;
        }
      }
    }
    catch (Exception parameeg)
    {
      break label197;
    }
  }
  
  public static void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.y.c.axV().cO(352279, 266241);
    Log.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    p.h(parama, "commentDetail");
    z.f localf = new z.f();
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    localf.SYG = j.b.fof().Kw(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.SYG == null)
    {
      localf.SYG = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentId != parama.FnS) && (((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime < parama.iXu))
    {
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentId = parama.FnS;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).field_readCommentTime = parama.iXu;
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).aSr(parama.dRL);
      ((com.tencent.mm.plugin.story.i.c)localf.SYG).aSd(parama.Foa);
      parama = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.fof().update((IAutoDBItem)localf.SYG, new String[0]);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new i(localf));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void f(r<? super Long, ? super Boolean, ? super String, ? super String, x> paramr)
  {
    AppMethodBeat.i(118863);
    p.h(paramr, "listener");
    if (!Foj.contains(paramr)) {
      Foj.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void fbQ()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = Fof.Ndz.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (edg)Fof.Ndz.get(i);
      if ((((edg)localObject2).state == 1) || (((edg)localObject2).state == 3))
      {
        int m = ((edg)localObject2).iXu;
        int n = cl.aWB();
        localObject3 = com.tencent.mm.plugin.story.f.i.Fmb;
        if (m > n - com.tencent.mm.plugin.story.f.i.fnT()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    Fof.Ndz.clear();
    Fof.Ndz.addAll((Collection)localObject1);
    Foi += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      Foi = -1;
      AppMethodBeat.o(118873);
      return;
    }
    Foi %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject4 = (edg)localObject3;
      if ((i >= Foi) && (((edg)localObject4).retryCount < wSn)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (edg)kotlin.a.j.kt((List)localObject1);
    if ((localObject1 != null) && (((edg)localObject1).state == 1))
    {
      Log.i(TAG, "postCommentToRemote " + ((edg)localObject1).toUser + ' ' + ((edg)localObject1).edx + ' ' + ((edg)localObject1).NdF + ' ' + ((edg)localObject1).iXu);
      Fog = (edg)localObject1;
      localObject2 = a((edg)localObject1);
      localObject3 = (CharSequence)((edf)localObject2).iAc;
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
        localObject3 = com.tencent.mm.plugin.story.h.e.Fuh;
        com.tencent.mm.plugin.story.h.e.fpX();
      }
      for (;;)
      {
        localObject3 = g.aAg();
        p.g(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.b)localObject3).azz();
        localObject4 = ((edg)localObject1).clientId;
        p.g(localObject4, "commentOp.clientId");
        ((com.tencent.mm.ak.t)localObject3).b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (edf)localObject2, ((edg)localObject1).sessionId, Foh));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.Fuh;
        com.tencent.mm.plugin.story.h.e.fpY();
      }
    }
    if ((localObject1 != null) && (((edg)localObject1).state == 3))
    {
      Log.i(TAG, "deleteCommentToRemote " + ((edg)localObject1).toUser + ' ' + ((edg)localObject1).edx + ' ' + ((edg)localObject1).FnS + ' ' + ((edg)localObject1).iXu);
      Fog = (edg)localObject1;
      localObject2 = new ArrayList();
      long l = ((edg)localObject1).edx;
      localObject3 = com.tencent.mm.plugin.story.i.a.FvD;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.fqV(), ((edg)localObject1).FnS));
      localObject1 = g.aAg();
      p.g(localObject1, "network()");
      ((com.tencent.mm.kernel.b)localObject1).azz().b((com.tencent.mm.ak.q)new f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void foR()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = Fof.toByteArray();
    s.C(DNm, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void g(r<? super Long, ? super Boolean, ? super String, ? super String, x> paramr)
  {
    AppMethodBeat.i(118864);
    p.h(paramr, "listener");
    Foj.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void i(m<? super Boolean, ? super Long, x> paramm)
  {
    AppMethodBeat.i(118865);
    p.h(paramm, "listener");
    if (!Fol.contains(paramm)) {
      Fol.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void j(m<? super Boolean, ? super Long, x> paramm)
  {
    AppMethodBeat.i(118866);
    p.h(paramm, "listener");
    Fol.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public static void k(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.foc().KA(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    eea localeea = new eea();
    try
    {
      localeea.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localeea.Nen;
        p.g(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((edf)paramString.next()).MYT == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localeea.Nen.remove(i);
              localeea.CommentCount = localeea.Nen.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localeea.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.foc().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localeea.Nen;
          p.g(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!Util.isEqual(((edf)((Iterator)localObject2).next()).iAc, paramString)) {}
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
    Log.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(this, paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    p.h(paramString2, "content");
    Log.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.fau() + Util.currentTicks();
      localObject2 = kotlin.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(118868);
        throw paramString1;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
      localObject1 = new edg();
      ((edg)localObject1).edx = paramLong;
      ((edg)localObject1).clientId = ((String)localObject2);
      ((edg)localObject1).FnS = paramInt;
      ((edg)localObject1).iXu = cl.aWB();
      ((edg)localObject1).state = 3;
      ((edg)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
      ((edg)localObject1).dRL = j.b.fau();
      ((edg)localObject1).toUser = "";
      Fof.Ndz.add(localObject1);
      fbQ();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    p.h(paramq, "scene");
    int j = paramq.getType();
    Log.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramq).rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (edi)paramString;
      paramq = ((com.tencent.mm.plugin.story.f.a.c)paramq).FnB;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = Fog;
        if (paramString != null)
        {
          paramString = paramString.content;
          Log.i((String)localObject2, paramString + ' ' + ((edi)localObject1).MYT);
          paramString = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new d((edi)localObject1));
          if (paramq != null) {
            paramq.FnS = ((edi)localObject1).MYT;
          }
          paramString = ((Iterable)Fol).iterator();
          if (!paramString.hasNext()) {
            break label318;
          }
          localObject2 = (m)paramString.next();
          localObject3 = Boolean.TRUE;
          if (paramq == null) {
            break label312;
          }
        }
        label312:
        for (l = paramq.edx;; l = 0L)
        {
          ((m)localObject2).invoke(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = Fog;
        if (paramString != null) {
          paramString.FnS = ((edi)localObject1).MYT;
        }
        paramString = Fog;
        if (paramString != null) {
          paramString.state = 2;
        }
        Fog = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().postDelayed((Runnable)e.For, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = Fog;
        if (paramString != null)
        {
          paramString = paramString.content;
          Log.i((String)localObject1, paramString);
          paramString = Fog;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = Fog;
          if (paramString != null) {
            paramString.retryCount = wSn;
          }
          label463:
          Fog = null;
          paramString = ((Iterable)Fol).iterator();
          label479:
          if (!paramString.hasNext()) {
            continue;
          }
          localObject1 = (m)paramString.next();
          localObject2 = Boolean.FALSE;
          if (paramq == null) {
            break label557;
          }
        }
        label539:
        label557:
        for (l = paramq.edx;; l = 0L)
        {
          ((m)localObject1).invoke(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = Fog;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((f)paramq).foQ() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramq = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = Fog;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      Log.i(paramq, paramString);
      paramString = Fog;
      if (paramString != null) {
        paramString.state = 4;
      }
      Fog = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.eJP().postDelayed((Runnable)f.Fos, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramq = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = Fog;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      Log.i(paramq, paramString);
      paramString = Fog;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = Fog;
      if (paramString != null) {
        paramString.retryCount = wSn;
      }
    }
    for (;;)
    {
      Fog = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = Fog;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public a(z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.Fom;
      b.l(this.Foo, paramString2, this.grJ);
      AppMethodBeat.o(118851);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(edi paramedi) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.Fom;
      b.b(this.Foq.NdL);
      AppMethodBeat.o(118852);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e For;
    
    static
    {
      AppMethodBeat.i(118854);
      For = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b.a(b.Fom);
      AppMethodBeat.o(118853);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f Fos;
    
    static
    {
      AppMethodBeat.i(118856);
      Fos = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b.a(b.Fom);
      AppMethodBeat.o(118855);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(edg paramedg) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.Fom;
      b.a(b.b(this.Fot));
      AppMethodBeat.o(118857);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(z.f paramf, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(z.f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(z.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */