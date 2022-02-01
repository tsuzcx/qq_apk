package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.b.b.a;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.protocal.protobuf.eok;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends q
  implements m
{
  private static final LinkedList<Object> LHN;
  public static final a LHO;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private b LHL;
  private final int LHM;
  i callback;
  final com.tencent.mm.an.d rr;
  
  static
  {
    AppMethodBeat.i(118838);
    LHO = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    LHN = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.LHL = new b();
    this.LHM = 10;
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.cd.a)new eoj());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new eok());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/mmstorysync");
    ((d.a)localObject).vD(513);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.an.d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((eoj)localObject).SfH = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(abu paramabu, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118830);
    p.k(paramabu, "item");
    p.k(paramMMHandler, "h");
    try
    {
      localObject1 = new eoh();
      paramabu = paramabu.SnH;
      p.j(paramabu, "item.CmdBuf");
      paramabu = ((eoh)localObject1).parseFrom(paramabu.Tkb.toByteArray());
      if (paramabu == null)
      {
        paramabu = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramabu;
      }
    }
    catch (Exception paramabu)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramabu = (eoh)paramabu;
    Object localObject1 = paramabu.UqX.CRR;
    int i = paramabu.UqX.CreateTime;
    long l = paramabu.Id;
    Object localObject2 = n.LGO;
    p.j(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramabu.UqX.Uqi, false);
    localObject2 = k.LGJ;
    k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramabu.UqX.CRR).append(" createTime:").append(paramabu.UqX.CreateTime).append(" id:").append(paramabu.Id).append(" scope:");
    if (localj != null)
    {
      paramabu = localj.ggc();
      if (paramabu == null) {}
    }
    for (paramabu = Integer.valueOf(paramabu.Urc);; paramabu = null)
    {
      Log.i((String)localObject1, paramabu);
      paramabu = LHN.iterator();
      while (paramabu.hasNext()) {
        paramabu.next();
      }
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(abu paramabu, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118831);
    p.k(paramabu, "item");
    p.k(paramMMHandler, "h");
    Object localObject1;
    try
    {
      localObject1 = new eoh();
      paramabu = paramabu.SnH;
      p.j(paramabu, "item.CmdBuf");
      paramabu = ((eoh)localObject1).parseFrom(paramabu.Tkb.toByteArray());
      if (paramabu == null)
      {
        paramabu = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramabu;
      }
    }
    catch (Exception paramabu)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramabu = (eoh)paramabu;
    String str = paramabu.UqX.CRR;
    int i = paramabu.UqX.CreateTime;
    long l = paramabu.Id;
    paramabu = n.LGO;
    p.j(str, "username");
    n.a.a(str, l, i, null, true);
    paramabu = n.LGO;
    com.tencent.mm.plugin.story.i.j localj = n.a.bdd(str);
    Object localObject2 = localj.ggc();
    paramabu = ((eol)localObject2).Ura;
    if (paramabu != null)
    {
      paramabu = paramabu.Sqr;
      if (paramabu != null)
      {
        paramabu = (enu)kotlin.a.j.M((List)paramabu, 0);
        if (paramabu != null)
        {
          paramabu = paramabu.TDF;
          localObject1 = ((eol)localObject2).Ura;
          if (localObject1 == null) {
            break label445;
          }
          localObject1 = ((enl)localObject1).Sqr;
          if (localObject1 == null) {
            break label445;
          }
          localObject1 = (enu)kotlin.a.j.M((List)localObject1, 0);
          if (localObject1 == null) {
            break label445;
          }
          localObject1 = ((enu)localObject1).Url;
          label249:
          localObject2 = ((eol)localObject2).Ura;
          if (localObject2 == null) {
            break label451;
          }
          localObject2 = ((enl)localObject2).Sqr;
          if (localObject2 == null) {
            break label451;
          }
          localObject2 = (enu)kotlin.a.j.M((List)localObject2, 0);
          if (localObject2 == null) {
            break label451;
          }
        }
      }
    }
    label445:
    label451:
    for (float f = ((enu)localObject2).UqC;; f = 0.0F)
    {
      localObject2 = k.LGJ;
      k.a(str, localj.field_storyID, localj.field_createTime, paramabu, (String)localObject1, (f * 1000.0F));
      Log.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ae.d.Fw(l));
      paramabu = LHN.iterator();
      while (paramabu.hasNext()) {
        paramabu.next();
      }
      paramabu = null;
      break;
      localObject1 = null;
      break label249;
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(abu paramabu, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118832);
    p.k(paramabu, "item");
    p.k(paramMMHandler, "h");
    try
    {
      localObject1 = new eoh();
      paramabu = paramabu.SnH;
      p.j(paramabu, "item.CmdBuf");
      paramabu = ((eoh)localObject1).parseFrom(paramabu.Tkb.toByteArray());
      if (paramabu == null)
      {
        paramabu = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramabu;
      }
    }
    catch (Exception paramabu)
    {
      Log.w(TAG, "StorySyncMsg parse error: " + paramabu.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramabu = (eoh)paramabu;
    Object localObject1 = paramabu.UqX.CRR;
    int i = paramabu.UqX.CreateTime;
    long l = paramabu.Id;
    Log.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ae.d.Fw(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.LIo;
    p.k(paramabu, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramabu.Id + ' ' + paramabu.UqX.Uln + ' ' + paramabu.UqX.CreateTime);
    localObject1 = new aa.f();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    ((aa.f)localObject1).aaBC = j.b.gcz().RQ(paramabu.UqX.Id);
    if ((c)((aa.f)localObject1).aaBC == null)
    {
      ((aa.f)localObject1).aaBC = new c();
      ((c)((aa.f)localObject1).aaBC).field_storyId = paramabu.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramabu);
    if (((c)((aa.f)localObject1).aaBC).field_readCommentTime == 0) {
      ((c)((aa.f)localObject1).aaBC).field_readCommentTime = 1;
    }
    localObject2 = (c)((aa.f)localObject1).aaBC;
    String str = paramabu.UqX.CRR;
    p.j(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((c)localObject2).bdv(str);
    localObject2 = (c)((aa.f)localObject1).aaBC;
    str = paramabu.UqX.Uqi.UserName;
    p.j(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((c)localObject2).bdh(str);
    ((c)((aa.f)localObject1).aaBC).field_syncCommentId = paramabu.UqX.Uln;
    ((c)((aa.f)localObject1).aaBC).field_syncCommentTime = paramabu.UqX.CreateTime;
    paramabu = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcz().replace((IAutoDBItem)((aa.f)localObject1).aaBC);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.a((aa.f)localObject1));
    paramabu = LHN.iterator();
    while (paramabu.hasNext()) {
      paramabu.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(abu paramabu, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118833);
    p.k(paramabu, "item");
    p.k(paramMMHandler, "h");
    try
    {
      localeoh = new eoh();
      paramabu = paramabu.SnH;
      p.j(paramabu, "item.CmdBuf");
      paramabu = localeoh.parseFrom(paramabu.Tkb.toByteArray());
      if (paramabu == null)
      {
        paramabu = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramabu;
      }
    }
    catch (Exception paramabu)
    {
      Log.w(TAG, "StorySyncMsg parse error:  " + paramabu.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    eoh localeoh = (eoh)paramabu;
    paramabu = localeoh.UqX.CRR;
    int i = localeoh.UqX.CreateTime;
    long l = localeoh.Id;
    Log.i(TAG, "processStoryVisit username:" + paramabu + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ae.d.Fw(l));
    paramabu = com.tencent.mm.plugin.story.f.b.b.LIo;
    p.k(localeoh, "syncMsg");
    boolean bool = e.LFp.gbz();
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localeoh.Id + ' ' + localeoh.UqX.Uln + ' ' + localeoh.UqX.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localeoh);
    aa.f localf = new aa.f();
    paramabu = com.tencent.mm.plugin.story.f.j.LGA;
    localf.aaBC = j.b.gcz().RQ(localeoh.UqX.Id);
    if ((c)localf.aaBC == null)
    {
      localf.aaBC = new c();
      ((c)localf.aaBC).field_storyId = localeoh.Id;
    }
    Object localObject;
    if (((c)localf.aaBC).field_readCommentTime == 0)
    {
      if (!Util.isNullOrNil(localeoh.UqX.lpy)) {
        break label636;
      }
      paramabu = localeoh.UqX.Uqi.UqO;
      p.j(paramabu, "bubbleList");
      paramabu = (eng)kotlin.a.j.M((List)paramabu, paramabu.size() - 2);
      if (paramabu == null) {
        break label631;
      }
      paramabu = Integer.valueOf(paramabu.CreateTime);
      localObject = (c)localf.aaBC;
      if (paramabu == null) {
        break label694;
      }
    }
    label694:
    for (i = paramabu.intValue();; i = 1)
    {
      ((c)localObject).field_readCommentTime = i;
      paramabu = (c)localf.aaBC;
      localObject = localeoh.UqX.CRR;
      p.j(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramabu.bdv((String)localObject);
      paramabu = (c)localf.aaBC;
      localObject = localeoh.UqX.Uqi.UserName;
      p.j(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramabu.bdh((String)localObject);
      ((c)localf.aaBC).field_syncCommentId = localeoh.UqX.Uln;
      ((c)localf.aaBC).field_syncCommentTime = localeoh.UqX.CreateTime;
      paramabu = com.tencent.mm.plugin.story.f.j.LGA;
      j.b.gcz().replace((IAutoDBItem)localf.aaBC);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.b(localf));
      paramabu = LHN.iterator();
      while (paramabu.hasNext()) {
        paramabu.next();
      }
      label631:
      paramabu = null;
      break;
      label636:
      paramabu = localeoh.UqX.Uqi.UqM;
      p.j(paramabu, "commentList");
      paramabu = (eng)kotlin.a.j.M((List)paramabu, paramabu.size() - 2);
      if (paramabu != null)
      {
        i = paramabu.CreateTime;
        paramabu = Integer.valueOf(i);
        break;
      }
      paramabu = null;
      break;
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(abu paramabu, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118834);
    p.k(paramabu, "item");
    p.k(paramMMHandler, "h");
    try
    {
      localObject = new eoh();
      paramabu = paramabu.SnH;
      p.j(paramabu, "item.CmdBuf");
      paramabu = ((eoh)localObject).parseFrom(paramabu.Tkb.toByteArray());
      if (paramabu == null)
      {
        paramabu = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramabu;
      }
    }
    catch (Exception paramabu)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramabu = (eoh)paramabu;
    Object localObject = paramabu.UqX.CRR;
    int i = paramabu.UqX.CreateTime;
    long l = paramabu.Id;
    Log.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.LIo;
    p.k(paramabu, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramabu.Id + ' ' + paramabu.UqX.Uln);
    com.tencent.mm.plugin.story.f.b.b.j(paramabu.UqX.Id, paramabu.UqX.Uln, paramabu.UqX.lpy);
    com.tencent.mm.plugin.story.f.b.b.RF(paramabu.UqX.Id);
    paramabu = LHN.iterator();
    while (paramabu.hasNext()) {
      paramabu.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118835);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    Object localObject1 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    Object localObject2 = Util.decodeHexString(Util.nullAsNil((String)((f)localObject1).aHp().get(8195)));
    localObject1 = new eae();
    ((eae)localObject1).dc((byte[])localObject2);
    localObject2 = this.rr.bhX();
    if (localObject2 == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw paramg;
    }
    ((eoj)localObject2).SfI = ((eae)localObject1);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(118835);
    return i;
  }
  
  public final int getType()
  {
    return 513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118836);
    Log.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118836);
      return;
    }
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    eok localeok = (eok)params;
    params = localeok.SfL;
    if (params != null)
    {
      paramArrayOfByte = params.rVy;
      params = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      params = new LinkedList();
    }
    if (params.size() > 0)
    {
      paramString = this.LHL;
      p.k(params, "cmdList");
      paramString.wqP = params;
      paramString.wHD.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localeok.SfI != null)
    {
      params = localeok.SfI;
      p.j(params, "resp.KeyBuf");
      if (params.Tkb != null)
      {
        params = localeok.SfI;
        p.j(params, "resp.KeyBuf");
        params = params.Tkb.toByteArray();
        paramArrayOfByte = this.rr.bhX();
        if (paramArrayOfByte == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        params = ad.n(((eoj)paramArrayOfByte).SfI.Tkb.toByteArray(), params);
        if (params != null)
        {
          if (params.length != 0) {
            break label434;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label439;
          }
        }
      }
    }
    label434:
    label439:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        paramArrayOfByte = com.tencent.mm.kernel.h.aHG();
        p.j(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.aHp().i(8195, Util.encodeHexString(params));
      }
      params = this.callback;
      if (params == null) {
        p.bGy("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118836);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.LHM;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "MM_STORY_SYNCCMD_VISIT", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", "listener", "removeNotifyListener", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    MMHandler wHD;
    LinkedList<abu> wqP;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.wHD = ((MMHandler)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends MMHandler
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        p.k(paramMessage, "msg");
        if (!com.tencent.mm.kernel.h.aHE().aGM())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.LHQ.wqP != null)
        {
          paramMessage = this.LHQ.wqP;
          if (paramMessage == null) {
            p.iCn();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.LHQ.LHP;
          localObject1 = paramMessage.rr.bhY();
          if (localObject1 == null)
          {
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (eok)localObject1;
          Object localObject2 = paramMessage.rr.bhX();
          if (localObject2 == null)
          {
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (eoj)localObject2;
          byte[] arrayOfByte = ((eok)localObject1).SfI.Tkb.toByteArray();
          arrayOfByte = ad.n(((eoj)localObject2).SfI.Tkb.toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            f localf = com.tencent.mm.kernel.h.aHG();
            p.j(localf, "MMKernel.storage()");
            localf.aHp().i(8195, Util.encodeHexString(arrayOfByte));
          }
          ((eoj)localObject2).SfI.dc(arrayOfByte);
          if ((((eok)localObject1).Saq & ((eoj)localObject2).SfH) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              p.bGy("callback");
            }
            ((i)localObject1).onSceneEnd(0, 0, "", (q)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          p.j(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            p.bGy("callback");
          }
          paramMessage.doScene((g)localObject1, (i)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.LHQ.wqP;
        if (paramMessage == null) {
          p.iCn();
        }
        paramMessage = (abu)paramMessage.getFirst();
        Log.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.SnG);
        Object localObject1 = this.LHQ.wqP;
        if (localObject1 == null) {
          p.iCn();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.SnG)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          j.b.fwa().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.fwa().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, abu paramabu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          abu localabu = paramMessage;
          p.j(localabu, "item");
          if (!h.c(localabu, (MMHandler)this.LHR)) {
            this.LHR.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, abu paramabu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          abu localabu = paramMessage;
          p.j(localabu, "item");
          if (!h.d(localabu, (MMHandler)this.LHR)) {
            this.LHR.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, abu paramabu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          abu localabu = paramMessage;
          p.j(localabu, "item");
          if (!h.e(localabu, (MMHandler)this.LHR)) {
            this.LHR.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, abu paramabu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          abu localabu = paramMessage;
          p.j(localabu, "item");
          if (!h.f(localabu, (MMHandler)this.LHR)) {
            this.LHR.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, abu paramabu) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          abu localabu = paramMessage;
          p.j(localabu, "item");
          if (!h.g(localabu, (MMHandler)this.LHR)) {
            this.LHR.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118827);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.h
 * JD-Core Version:    0.7.0.1
 */