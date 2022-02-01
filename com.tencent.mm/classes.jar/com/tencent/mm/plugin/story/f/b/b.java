package com.tencent.mm.plugin.story.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.a.e;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.enf;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enh;
import com.tencent.mm.protocal.protobuf.enj;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", "listener", "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", "init", "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.story.api.h
{
  public static final String Kao;
  public static final String LIe;
  private static final int LIf = 50;
  private static final int LIg = 2147483647;
  public static final enf LIh;
  private static enh LIi;
  private static a LIj;
  private static int LIk = 0;
  private static final ArrayList<r<Long, Boolean, String, String, x>> LIl;
  private static final LinkedList<Object> LIm;
  private static final LinkedList<m<Boolean, Long, x>> LIn;
  public static final b LIo;
  public static final String TAG = "MicroMsg.StoryCommentLogic";
  
  static
  {
    AppMethodBeat.i(118882);
    LIo = new b();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    LIe = ((com.tencent.mm.kernel.f)localObject).getAccPath() + "story/commentCache.proto";
    localStringBuilder = new StringBuilder();
    localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class);
    p.j(localObject, "MMKernel.plugin(IPluginStory::class.java)");
    Kao = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath() + "commentCache.proto";
    LIf = 50;
    LIg = 2147483647;
    TAG = "MicroMsg.StoryCommentLogic";
    LIh = new enf();
    LIk = -1;
    LIl = new ArrayList();
    LIm = new LinkedList();
    LIn = new LinkedList();
    AppMethodBeat.o(118882);
  }
  
  public static void RE(long paramLong)
  {
    AppMethodBeat.i(118871);
    aa.f localf = new aa.f();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localf.aaBC = j.b.gcz().RQ(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.aaBC == null)
    {
      localf.aaBC = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_storyId = paramLong;
    }
    localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    final com.tencent.mm.plugin.story.i.j localj = j.b.gcw().RU(paramLong);
    if (localj == null)
    {
      AppMethodBeat.o(118871);
      return;
    }
    Object localObject2 = new eob();
    if (localj != null) {}
    try
    {
      localObject1 = localj.field_attrBuf;
      ((eob)localObject2).parseFrom((byte[])localObject1);
    }
    catch (Exception localException)
    {
      label116:
      int i;
      break label116;
    }
    localObject1 = ((eob)localObject2).UqM;
    p.j(localObject1, "storyObj.CommentList");
    localObject1 = (List)localObject1;
    localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
    label148:
    if (((ListIterator)localObject2).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject2).previous();
      if (((eng)localObject1).Uln != 0)
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
      localObject2 = (eng)localObject1;
      if (localObject2 == null) {
        break label392;
      }
      if ((((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentId != ((eng)localObject2).Uln) && (((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime < ((eng)localObject2).CreateTime))
      {
        ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentId = ((eng)localObject2).Uln;
        ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime = ((eng)localObject2).CreateTime;
        localObject1 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
        localObject2 = ((eng)localObject2).CRR;
        p.j(localObject2, "it.FromUserName");
        ((com.tencent.mm.plugin.story.i.c)localObject1).bdv((String)localObject2);
        com.tencent.mm.plugin.story.i.c localc = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
        localObject2 = localj.field_userName;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localc.bdh((String)localObject1);
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcz().update((IAutoDBItem)localf.aaBC, new String[0]);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(localf, localj));
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
  
  public static void RF(long paramLong)
  {
    AppMethodBeat.i(118880);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    com.tencent.mm.plugin.story.i.j localj = j.b.gcw().RU(paramLong);
    aa.f localf = new aa.f();
    localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.gcz().RQ(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118880);
      return;
    }
    localf.aaBC = localObject1;
    if (localj == null)
    {
      Log.i(TAG, "updateLastCommentSync will reset to 0 0");
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_syncCommentTime = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_syncCommentId = 0;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).bdv("");
    }
    for (;;)
    {
      Object localObject3 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
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
      ((com.tencent.mm.plugin.story.i.c)localObject3).bdh((String)localObject1);
      localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcz().replace((IAutoDBItem)localf.aaBC);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new k(localf));
      AppMethodBeat.o(118880);
      return;
      localObject3 = new eob();
      try
      {
        ((eob)localObject3).parseFrom(localj.field_attrBuf);
        localObject1 = ((eob)localObject3).UqM;
        p.j(localObject1, "storyObj.CommentList");
        localObject1 = (List)localObject1;
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        label269:
        Object localObject4;
        int i;
        if (((ListIterator)localObject2).hasPrevious())
        {
          localObject1 = ((ListIterator)localObject2).previous();
          localObject4 = (eng)localObject1;
          if ((((eng)localObject4).Uln != 0) && (((eng)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime))
          {
            i = 1;
            label322:
            if (i == 0) {
              break label765;
            }
            label326:
            localObject1 = (eng)localObject1;
            if (localObject1 != null) {
              break label935;
            }
            if (!com.tencent.mm.plugin.story.c.a.e.LFp.gbz()) {
              break label782;
            }
            localObject1 = ((eob)localObject3).UqS;
            p.j(localObject1, "storyObj.VisitorList");
            localObject1 = (List)localObject1;
            localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
            label376:
            if (!((ListIterator)localObject2).hasPrevious()) {
              break label777;
            }
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (eng)localObject1;
            if ((((eng)localObject4).Uln == 0) || (((eng)localObject4).CreateTime > ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime)) {
              break label772;
            }
            i = 1;
            label429:
            if (i == 0) {
              break label775;
            }
            label433:
            localObject1 = (eng)localObject1;
            localObject4 = TAG;
            StringBuilder localStringBuilder = new StringBuilder("updateLastCommentSync will reset to ");
            if (localObject1 == null) {
              break label889;
            }
            localObject2 = Integer.valueOf(((eng)localObject1).CreateTime);
            label468:
            localStringBuilder = localStringBuilder.append(localObject2).append(' ');
            if (localObject1 == null) {
              break label895;
            }
            localObject2 = Integer.valueOf(((eng)localObject1).Uln);
            label495:
            Log.i((String)localObject4, localObject2);
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
            if (localObject1 == null) {
              break label901;
            }
            i = ((eng)localObject1).CreateTime;
            label529:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
            if (localObject1 == null) {
              break label906;
            }
            i = ((eng)localObject1).Uln;
            label554:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_readCommentId = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
            if (localObject1 == null) {
              break label911;
            }
            i = ((eng)localObject1).CreateTime;
            label579:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentTime = i;
            localObject2 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
            if (localObject1 == null) {
              break label916;
            }
            i = ((eng)localObject1).Uln;
            label604:
            ((com.tencent.mm.plugin.story.i.c)localObject2).field_syncCommentId = i;
            localObject4 = (com.tencent.mm.plugin.story.i.c)localf.aaBC;
            if (localObject1 != null)
            {
              localObject2 = ((eng)localObject1).CRR;
              localObject1 = localObject2;
              if (localObject2 != null) {}
            }
            else
            {
              localObject1 = "";
            }
            ((com.tencent.mm.plugin.story.i.c)localObject4).bdv((String)localObject1);
            localObject1 = ((eob)localObject3).UqM;
            p.j(localObject1, "storyObj.CommentList");
            localObject2 = ((Iterable)localObject1).iterator();
            label672:
            if (!((Iterator)localObject2).hasNext()) {
              break label926;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject3 = (eng)localObject1;
            if ((((eng)localObject3).Uln == 0) || (((eng)localObject3).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime)) {
              break label921;
            }
            i = 1;
            label725:
            if (i == 0) {
              break label924;
            }
          }
        }
        while ((eng)localObject1 == null)
        {
          localj.zB(false);
          localObject1 = n.LGO;
          n.a.aj(localj.field_storyID, localj.field_localFlag);
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
          localObject1 = ((eob)localObject3).UqO;
          p.j(localObject1, "storyObj.BubbleList");
          localObject1 = (List)localObject1;
          localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
          label814:
          if (((ListIterator)localObject2).hasPrevious())
          {
            localObject1 = ((ListIterator)localObject2).previous();
            localObject4 = (eng)localObject1;
            if ((((eng)localObject4).Uln != 0) && (((eng)localObject4).CreateTime <= ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime))
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
            localObject1 = (eng)localObject1;
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
    Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.fOo() + Util.currentTicks();
    localObject2 = kotlin.n.d.UTF_8;
    if (localObject1 == null)
    {
      paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(118874);
      throw paramString1;
    }
    localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
    p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
    localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
    localObject1 = new enh();
    ((enh)localObject1).clientId = ((String)localObject2);
    ((enh)localObject1).fXG = paramLong;
    ((enh)localObject1).content = paramString2;
    paramString2 = com.tencent.mm.plugin.story.f.j.LGA;
    ((enh)localObject1).fLi = j.b.fOo();
    ((enh)localObject1).toUser = paramString1;
    ((enh)localObject1).createTime = cm.bfF();
    ((enh)localObject1).state = 1;
    ((enh)localObject1).Uqc = 0;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((enh)localObject1).Uqd = i;
      ((enh)localObject1).sessionId = paramString3;
      ((enh)localObject1).LIb = paramString4;
      ((enh)localObject1).LIc = paramInt1;
      ((enh)localObject1).KQF = paramInt2;
      LIh.UpW.add(localObject1);
      LIj = new a((enh)localObject1);
      fPI();
      paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.fwa().post((Runnable)new g((enh)localObject1));
      paramString1 = LIj;
      if (paramString1 == null) {
        p.iCn();
      }
      AppMethodBeat.o(118874);
      return paramString1;
    }
  }
  
  private static eng a(enh paramenh)
  {
    AppMethodBeat.i(118876);
    eng localeng = new eng();
    localeng.Id = paramenh.fXG;
    localeng.Uln = paramenh.LHU;
    localeng.CRR = paramenh.fLi;
    localeng.CRQ = paramenh.toUser;
    localeng.lpy = paramenh.content;
    localeng.CreateTime = paramenh.createTime;
    localeng.Uqa = paramenh.Uqc;
    localeng.Uqb = paramenh.Uqd;
    localeng.Ulm = paramenh.LIc;
    localeng.Ulr = paramenh.KQF;
    AppMethodBeat.o(118876);
    return localeng;
  }
  
  public static void a(long paramLong, a parama)
  {
    AppMethodBeat.i(118869);
    p.k(parama, "commentItem");
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    com.tencent.mm.plugin.story.i.c localc = j.b.gcz().RQ(paramLong);
    localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localObject).field_storyId = paramLong;
    }
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentId = parama.LHU;
    ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = parama.createTime;
    parama = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcz().update((IAutoDBItem)localObject, new String[0]);
    AppMethodBeat.o(118869);
  }
  
  private static void a(eob parameob)
  {
    AppMethodBeat.i(118877);
    if (parameob != null)
    {
      Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      Object localObject2 = j.b.gcw().RU(parameob.Id);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      if (Util.isEqual(j.b.fOo(), ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName)) {
        ((com.tencent.mm.plugin.story.i.j)localObject1).zB(true);
      }
      localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      if (Util.isEqual(j.b.fOo(), parameob.UserName)) {
        localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
      }
      for (int i = com.tencent.mm.plugin.story.i.a.gfc();; i = com.tencent.mm.plugin.story.i.a.gfd())
      {
        localObject2 = n.LGO;
        n.a.a((com.tencent.mm.plugin.story.i.j)localObject1, parameob, i);
        AppMethodBeat.o(118877);
        return;
        localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
      }
    }
    AppMethodBeat.o(118877);
  }
  
  public static void a(eoh parameoh)
  {
    int j = 0;
    AppMethodBeat.i(118878);
    eng localeng1 = new eng();
    localeng1.Id = parameoh.Id;
    localeng1.Uln = parameoh.UqX.Uln;
    localeng1.CRR = parameoh.UqX.CRR;
    localeng1.CRQ = parameoh.UqX.CRQ;
    localeng1.lpy = parameoh.UqX.lpy;
    localeng1.CreateTime = parameoh.UqX.CreateTime;
    localeng1.Uqa = parameoh.UqX.Uqa;
    localeng1.Ulm = parameoh.UqX.Ulm;
    if (parameoh.UqX.rWu == 7)
    {
      localObject = a.e.LPR;
      localeng1.Ulr = a.e.gfM();
    }
    long l = localeng1.Id;
    Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
    localObject = j.b.gcw().RU(l);
    if (localObject == null)
    {
      a(parameoh.UqX.Uqi);
      AppMethodBeat.o(118878);
      return;
    }
    eob localeob = new eob();
    try
    {
      localeob.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf);
      label197:
      int i;
      Iterator localIterator;
      if (Util.isNullOrNil(localeng1.lpy))
      {
        i = localeng1.Ulr;
        parameoh = a.e.LPR;
        if (i == a.e.gfM())
        {
          parameoh = localeob.UqS;
          p.j(parameoh, "storyObj.VisitorList");
          localIterator = ((Iterable)parameoh).iterator();
          if (localIterator.hasNext())
          {
            parameoh = localIterator.next();
            eng localeng2 = (eng)parameoh;
            if ((localeng2.Uln == localeng1.Uln) || (Util.isEqual(localeng2.CRR, localeng1.CRR))) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        label308:
        i = j;
        if ((eng)parameoh == null)
        {
          localeob.UqS.add(localeng1);
          i = 1;
        }
        label330:
        parameoh = localeob.UqS;
        p.j(parameoh, "storyObj.VisitorList");
        localIterator = ((Iterable)parameoh).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            parameoh = localIterator.next();
            if (Util.isEqual(((eng)parameoh).CRR, localeng1.CRR))
            {
              if ((eng)parameoh == null) {
                localeob.UqS.add(localeng1);
              }
              if (i != 0)
              {
                localeob.CommentCount = localeob.UqM.size();
                localeob.UqN = localeob.UqO.size();
                localeob.UqR = localeob.UqS.size();
              }
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject).field_attrBuf = localeob.toByteArray();
          label461:
          parameoh = com.tencent.mm.plugin.story.f.j.LGA;
          if (Util.isEqual(j.b.fOo(), ((com.tencent.mm.plugin.story.i.j)localObject).field_userName)) {
            ((com.tencent.mm.plugin.story.i.j)localObject).zB(true);
          }
          parameoh = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcw().e((com.tencent.mm.plugin.story.i.j)localObject);
          AppMethodBeat.o(118878);
          return;
          i = 0;
          continue;
          parameoh = null;
          break label308;
          if (Util.isNullOrNil(localeng1.lpy))
          {
            if (localeng1.Uln != 0)
            {
              parameoh = localeob.UqO;
              p.j(parameoh, "storyObj.BubbleList");
              localIterator = ((Iterable)parameoh).iterator();
              label558:
              if (localIterator.hasNext())
              {
                parameoh = localIterator.next();
                if (((eng)parameoh).Uln == localeng1.Uln)
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
                if ((eng)parameoh != null) {
                  break;
                }
                localeob.UqO.add(localeng1);
                i = 1;
                break;
                i = 0;
                break label593;
                label625:
                break label558;
                parameoh = null;
              }
            }
            localeob.UqO.add(localeng1);
            i = 1;
            break label330;
          }
          if (localeng1.Uln != 0)
          {
            parameoh = localeob.UqM;
            p.j(parameoh, "storyObj.CommentList");
            localIterator = ((Iterable)parameoh).iterator();
            label680:
            if (localIterator.hasNext())
            {
              parameoh = localIterator.next();
              if (((eng)parameoh).Uln == localeng1.Uln)
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
              if ((eng)parameoh != null) {
                break;
              }
              localeob.UqM.add(localeng1);
              i = 1;
              break;
              i = 0;
              break label715;
              label747:
              break label680;
              parameoh = null;
            }
          }
          localeob.UqM.add(localeng1);
          i = 1;
          break label330;
          parameoh = null;
        }
        catch (Exception parameoh)
        {
          break label461;
        }
      }
    }
    catch (Exception parameoh)
    {
      break label197;
    }
  }
  
  public static void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(118872);
    boolean bool = com.tencent.mm.aa.c.aFn().dj(352279, 266241);
    Log.i(TAG, "updateCommentRead: " + bool + ", " + paramBoolean1);
    if ((bool != paramBoolean1) || (paramBoolean2)) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(paramBoolean1));
    }
    AppMethodBeat.o(118872);
  }
  
  public static boolean b(long paramLong, a parama)
  {
    AppMethodBeat.i(118870);
    p.k(parama, "commentDetail");
    aa.f localf = new aa.f();
    j.b localb = com.tencent.mm.plugin.story.f.j.LGA;
    localf.aaBC = j.b.gcz().RQ(paramLong);
    if ((com.tencent.mm.plugin.story.i.c)localf.aaBC == null)
    {
      localf.aaBC = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_storyId = paramLong;
    }
    if ((((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentId != parama.LHU) && (((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime < parama.createTime))
    {
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentId = parama.LHU;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).field_readCommentTime = parama.createTime;
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).bdv(parama.fLi);
      ((com.tencent.mm.plugin.story.i.c)localf.aaBC).bdh(parama.LIb);
      parama = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcz().update((IAutoDBItem)localf.aaBC, new String[0]);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(localf));
      AppMethodBeat.o(118870);
      return true;
    }
    AppMethodBeat.o(118870);
    return false;
  }
  
  public static void f(r<? super Long, ? super Boolean, ? super String, ? super String, x> paramr)
  {
    AppMethodBeat.i(118863);
    p.k(paramr, "listener");
    if (!LIl.contains(paramr)) {
      LIl.add(paramr);
    }
    AppMethodBeat.o(118863);
  }
  
  public static void fPI()
  {
    int k = 0;
    AppMethodBeat.i(118873);
    Object localObject1 = new ArrayList();
    int j = LIh.UpW.size();
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = (enh)LIh.UpW.get(i);
      if ((((enh)localObject2).state == 1) || (((enh)localObject2).state == 3))
      {
        int m = ((enh)localObject2).createTime;
        int n = cm.bfF();
        localObject3 = com.tencent.mm.plugin.story.f.i.LGd;
        if (m > n - com.tencent.mm.plugin.story.f.i.gcn()) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      i += 1;
    }
    LIh.UpW.clear();
    LIh.UpW.addAll((Collection)localObject1);
    LIk += 1;
    if (((ArrayList)localObject1).size() == 0)
    {
      LIk = -1;
      AppMethodBeat.o(118873);
      return;
    }
    LIk %= ((ArrayList)localObject1).size();
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    i = 0;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject4 = (enh)localObject3;
      if ((i >= LIk) && (((enh)localObject4).retryCount < LIg)) {}
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        i += 1;
        break;
      }
    }
    localObject1 = (enh)kotlin.a.j.lp((List)localObject1);
    if ((localObject1 != null) && (((enh)localObject1).state == 1))
    {
      Log.i(TAG, "postCommentToRemote " + ((enh)localObject1).toUser + ' ' + ((enh)localObject1).fXG + ' ' + ((enh)localObject1).Uqc + ' ' + ((enh)localObject1).createTime);
      LIi = (enh)localObject1;
      localObject2 = a((enh)localObject1);
      localObject3 = (CharSequence)((eng)localObject2).lpy;
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
        localObject3 = com.tencent.mm.plugin.story.h.e.LOi;
        com.tencent.mm.plugin.story.h.e.ges();
      }
      for (;;)
      {
        localObject3 = com.tencent.mm.kernel.h.aHF();
        p.j(localObject3, "network()");
        localObject3 = ((com.tencent.mm.kernel.c)localObject3).aGY();
        localObject4 = ((enh)localObject1).clientId;
        p.j(localObject4, "commentOp.clientId");
        ((com.tencent.mm.an.t)localObject3).b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.c((String)localObject4, (eng)localObject2, ((enh)localObject1).sessionId, LIj));
        AppMethodBeat.o(118873);
        return;
        localObject3 = com.tencent.mm.plugin.story.h.e.LOi;
        com.tencent.mm.plugin.story.h.e.geu();
      }
    }
    if ((localObject1 != null) && (((enh)localObject1).state == 3))
    {
      Log.i(TAG, "deleteCommentToRemote " + ((enh)localObject1).toUser + ' ' + ((enh)localObject1).fXG + ' ' + ((enh)localObject1).LHU + ' ' + ((enh)localObject1).createTime);
      LIi = (enh)localObject1;
      localObject2 = new ArrayList();
      long l = ((enh)localObject1).fXG;
      localObject3 = com.tencent.mm.plugin.story.i.a.LPG;
      ((ArrayList)localObject2).add(new com.tencent.mm.plugin.story.f.a.j(l, com.tencent.mm.plugin.story.i.a.gfr(), ((enh)localObject1).LHU));
      localObject1 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject1, "network()");
      ((com.tencent.mm.kernel.c)localObject1).aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.story.f.a.f((List)localObject2));
    }
    AppMethodBeat.o(118873);
  }
  
  public static void g(r<? super Long, ? super Boolean, ? super String, ? super String, x> paramr)
  {
    AppMethodBeat.i(118864);
    p.k(paramr, "listener");
    LIl.remove(paramr);
    AppMethodBeat.o(118864);
  }
  
  public static void gdl()
  {
    AppMethodBeat.i(118862);
    byte[] arrayOfByte = LIh.toByteArray();
    u.H(Kao, arrayOfByte);
    AppMethodBeat.o(118862);
  }
  
  public static void i(m<? super Boolean, ? super Long, x> paramm)
  {
    AppMethodBeat.i(118865);
    p.k(paramm, "listener");
    if (!LIn.contains(paramm)) {
      LIn.add(paramm);
    }
    AppMethodBeat.o(118865);
  }
  
  public static void j(long paramLong, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(118879);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
    localObject1 = j.b.gcw().RU(paramLong);
    if (localObject1 == null)
    {
      AppMethodBeat.o(118879);
      return;
    }
    eob localeob = new eob();
    try
    {
      localeob.parseFrom(((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf);
      label55:
      if (paramInt != 0)
      {
        paramString = localeob.UqM;
        p.j(paramString, "storyObj.CommentList");
        paramString = ((List)paramString).iterator();
        i = 0;
      }
      for (;;)
      {
        int j;
        if (paramString.hasNext()) {
          if (((eng)paramString.next()).Uln == paramInt)
          {
            j = 1;
            label113:
            if (j == 0) {
              break label184;
            }
            label118:
            if (i != -1)
            {
              localeob.UqM.remove(i);
              localeob.CommentCount = localeob.UqM.size();
            }
          }
        }
        try
        {
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_attrBuf = localeob.toByteArray();
          label158:
          paramString = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.gcw().e((com.tencent.mm.plugin.story.i.j)localObject1);
          AppMethodBeat.o(118879);
          return;
          j = 0;
          break label113;
          label184:
          i += 1;
          continue;
          i = -1;
          break label118;
          Object localObject2 = localeob.UqM;
          p.j(localObject2, "storyObj.CommentList");
          localObject2 = ((List)localObject2).iterator();
          paramInt = i;
          label229:
          if (((Iterator)localObject2).hasNext()) {
            if (!Util.isEqual(((eng)((Iterator)localObject2).next()).lpy, paramString)) {}
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
  
  public static void j(m<? super Boolean, ? super Long, x> paramm)
  {
    AppMethodBeat.i(118866);
    p.k(paramm, "listener");
    LIn.remove(paramm);
    AppMethodBeat.o(118866);
  }
  
  public final a b(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(118867);
    p.k(paramString1, "content");
    p.k(paramString2, "toUsername");
    p.k(paramString4, "storyOwner");
    Log.i(TAG, "postComment: " + paramLong + ' ' + paramString1 + ' ' + paramString2);
    paramString1 = a(this, paramLong, paramString2, paramString1, false, paramString3, paramString4, paramInt, 0, 256);
    AppMethodBeat.o(118867);
    return paramString1;
  }
  
  public final void b(long paramLong, int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(118868);
    p.k(paramString2, "content");
    Log.i(TAG, "deleteComment storyId:" + paramLong + " commentId:" + paramInt + " sessionId:" + paramString1 + " content:" + paramString2);
    if (paramInt != 0)
    {
      Object localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = j.b.fOo() + Util.currentTicks();
      localObject2 = kotlin.n.d.UTF_8;
      if (localObject1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(118868);
        throw paramString1;
      }
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
      localObject1 = new enh();
      ((enh)localObject1).fXG = paramLong;
      ((enh)localObject1).clientId = ((String)localObject2);
      ((enh)localObject1).LHU = paramInt;
      ((enh)localObject1).createTime = cm.bfF();
      ((enh)localObject1).state = 3;
      ((enh)localObject1).sessionId = paramString1;
      paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
      ((enh)localObject1).fLi = j.b.fOo();
      ((enh)localObject1).toUser = "";
      LIh.UpW.add(localObject1);
      fPI();
    }
    paramString1 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.fwa().post((Runnable)new c(paramLong, paramInt, paramString2));
    AppMethodBeat.o(118868);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(118881);
    p.k(paramq, "scene");
    int j = paramq.getType();
    Log.i(TAG, "onSceneEnd " + paramInt1 + ", " + paramInt2 + ", " + paramString + ", " + j);
    label252:
    long l;
    if (j == 354)
    {
      paramString = ((com.tencent.mm.plugin.story.f.a.c)paramq).rr.bhY();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
        AppMethodBeat.o(118881);
        throw paramString;
      }
      localObject1 = (enj)paramString;
      paramq = ((com.tencent.mm.plugin.story.f.a.c)paramq).LHD;
      Object localObject2;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject2 = TAG;
        Object localObject3 = new StringBuilder("post comment success ");
        paramString = LIi;
        if (paramString != null)
        {
          paramString = paramString.content;
          Log.i((String)localObject2, paramString + ' ' + ((enj)localObject1).Uln);
          paramString = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new d((enj)localObject1));
          if (paramq != null) {
            paramq.LHU = ((enj)localObject1).Uln;
          }
          paramString = ((Iterable)LIn).iterator();
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
        for (l = paramq.fXG;; l = 0L)
        {
          ((m)localObject2).invoke(localObject3, Long.valueOf(l));
          break label252;
          paramString = null;
          break;
        }
        label318:
        paramString = LIi;
        if (paramString != null) {
          paramString.LHU = ((enj)localObject1).Uln;
        }
        paramString = LIi;
        if (paramString != null) {
          paramString.state = 2;
        }
        LIi = null;
      }
      for (l = 100L;; l = 300000L)
      {
        paramString = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.fwa().postDelayed((Runnable)e.LIt, l);
        AppMethodBeat.o(118881);
        return;
        localObject1 = TAG;
        localObject2 = new StringBuilder("post comment fail ");
        paramString = LIi;
        if (paramString != null)
        {
          paramString = paramString.content;
          Log.i((String)localObject1, paramString);
          paramString = LIi;
          paramInt2 = i;
          if (paramString != null) {
            paramInt2 = paramString.retryCount;
          }
          if (paramInt1 != 4) {
            break label539;
          }
          paramString = LIi;
          if (paramString != null) {
            paramString.retryCount = LIg;
          }
          label463:
          LIi = null;
          paramString = ((Iterable)LIn).iterator();
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
        for (l = paramq.fXG;; l = 0L)
        {
          ((m)localObject1).invoke(localObject2, Long.valueOf(l));
          break label479;
          paramString = null;
          break;
          paramString = LIi;
          if (paramString == null) {
            break label463;
          }
          paramString.retryCount = (paramInt2 + 1);
          break label463;
        }
      }
    }
    if ((j == 764) && ((((com.tencent.mm.plugin.story.f.a.f)paramq).gdk() instanceof com.tencent.mm.plugin.story.f.a.j)))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label698;
      }
      paramq = TAG;
      localObject1 = new StringBuilder("delete comment success ");
      paramString = LIi;
      if (paramString == null) {
        break label693;
      }
    }
    label693:
    for (paramString = paramString.content;; paramString = null)
    {
      Log.i(paramq, paramString);
      paramString = LIi;
      if (paramString != null) {
        paramString.state = 4;
      }
      LIi = null;
      l = 100L;
      paramString = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.fwa().postDelayed((Runnable)f.LIu, l);
      AppMethodBeat.o(118881);
      return;
    }
    label698:
    paramq = TAG;
    Object localObject1 = new StringBuilder("delete comment fail ");
    paramString = LIi;
    if (paramString != null)
    {
      paramString = paramString.content;
      label728:
      Log.i(paramq, paramString);
      paramString = LIi;
      if (paramString == null) {
        break label792;
      }
      paramInt2 = paramString.retryCount;
      label755:
      if (paramInt1 != 4) {
        break label797;
      }
      paramString = LIi;
      if (paramString != null) {
        paramString.retryCount = LIg;
      }
    }
    for (;;)
    {
      LIi = null;
      l = 60000L;
      break;
      paramString = null;
      break label728;
      label792:
      paramInt2 = 0;
      break label755;
      label797:
      paramString = LIi;
      if (paramString != null) {
        paramString.retryCount = (paramInt2 + 1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public a(aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public b(aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(long paramLong, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(118851);
      b localb = b.LIo;
      b.k(this.LIq, paramString2, this.iVV);
      AppMethodBeat.o(118851);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(enj paramenj) {}
    
    public final void run()
    {
      AppMethodBeat.i(118852);
      b localb = b.LIo;
      b.b(this.LIs.Uqi);
      AppMethodBeat.o(118852);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    public static final e LIt;
    
    static
    {
      AppMethodBeat.i(118854);
      LIt = new e();
      AppMethodBeat.o(118854);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118853);
      b.a(b.LIo);
      AppMethodBeat.o(118853);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    public static final f LIu;
    
    static
    {
      AppMethodBeat.i(118856);
      LIu = new f();
      AppMethodBeat.o(118856);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118855);
      b.a(b.LIo);
      AppMethodBeat.o(118855);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(enh paramenh) {}
    
    public final void run()
    {
      AppMethodBeat.i(118857);
      b localb = b.LIo;
      b.a(b.b(this.LIv));
      AppMethodBeat.o(118857);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(aa.f paramf, com.tencent.mm.plugin.story.i.j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(aa.f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(aa.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.b.b
 * JD-Core Version:    0.7.0.1
 */