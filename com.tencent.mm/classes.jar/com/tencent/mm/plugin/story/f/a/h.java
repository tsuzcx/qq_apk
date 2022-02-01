package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.story.f.b.b.a;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.plugin.story.i.c;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.eeh;
import com.tencent.mm.protocal.protobuf.eei;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends q
  implements m
{
  private static final LinkedList<Object> FnL;
  public static final a FnM;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private b FnJ;
  private final int FnK;
  i callback;
  final com.tencent.mm.ak.d rr;
  
  static
  {
    AppMethodBeat.i(118838);
    FnM = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    FnL = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.FnJ = new b();
    this.FnK = 10;
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.bw.a)new eei());
    ((d.a)localObject).d((com.tencent.mm.bw.a)new eej());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/mmstorysync");
    ((d.a)localObject).sG(513);
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.d)localObject);
    localObject = this.rr.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((eei)localObject).Leu = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(abn paramabn, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118830);
    p.h(paramabn, "item");
    p.h(paramMMHandler, "h");
    try
    {
      localObject1 = new eeg();
      paramabn = paramabn.Lmt;
      p.g(paramabn, "item.CmdBuf");
      paramabn = ((eeg)localObject1).parseFrom(paramabn.getBuffer().toByteArray());
      if (paramabn == null)
      {
        paramabn = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramabn;
      }
    }
    catch (Exception paramabn)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramabn = (eeg)paramabn;
    Object localObject1 = paramabn.Ney.xNH;
    int i = paramabn.Ney.CreateTime;
    long l = paramabn.Id;
    Object localObject2 = n.FmM;
    p.g(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramabn.Ney.NdL, false);
    localObject2 = k.FmH;
    k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramabn.Ney.xNH).append(" createTime:").append(paramabn.Ney.CreateTime).append(" id:").append(paramabn.Id).append(" scope:");
    if (localj != null)
    {
      paramabn = localj.frG();
      if (paramabn == null) {}
    }
    for (paramabn = Integer.valueOf(paramabn.NeD);; paramabn = null)
    {
      Log.i((String)localObject1, paramabn);
      paramabn = FnL.iterator();
      while (paramabn.hasNext()) {
        paramabn.next();
      }
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(abn paramabn, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118831);
    p.h(paramabn, "item");
    p.h(paramMMHandler, "h");
    Object localObject1;
    try
    {
      localObject1 = new eeg();
      paramabn = paramabn.Lmt;
      p.g(paramabn, "item.CmdBuf");
      paramabn = ((eeg)localObject1).parseFrom(paramabn.getBuffer().toByteArray());
      if (paramabn == null)
      {
        paramabn = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramabn;
      }
    }
    catch (Exception paramabn)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramabn = (eeg)paramabn;
    String str = paramabn.Ney.xNH;
    int i = paramabn.Ney.CreateTime;
    long l = paramabn.Id;
    paramabn = n.FmM;
    p.g(str, "username");
    n.a.a(str, l, i, null, true);
    paramabn = n.FmM;
    com.tencent.mm.plugin.story.i.j localj = n.a.aRZ(str);
    Object localObject2 = localj.frG();
    paramabn = ((eek)localObject2).NeB;
    if (paramabn != null)
    {
      paramabn = paramabn.LoV;
      if (paramabn != null)
      {
        paramabn = (edt)kotlin.a.j.L((List)paramabn, 0);
        if (paramabn != null)
        {
          paramabn = paramabn.Msz;
          localObject1 = ((eek)localObject2).NeB;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((edk)localObject1).LoV;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = (edt)kotlin.a.j.L((List)localObject1, 0);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((edt)localObject1).Url;
          label248:
          localObject2 = ((eek)localObject2).NeB;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = ((edk)localObject2).LoV;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = (edt)kotlin.a.j.L((List)localObject2, 0);
          if (localObject2 == null) {
            break label450;
          }
        }
      }
    }
    label444:
    label450:
    for (float f = ((edt)localObject2).Ned;; f = 0.0F)
    {
      localObject2 = k.FmH;
      k.a(str, localj.field_storyID, localj.field_createTime, paramabn, (String)localObject1, (f * 1000.0F));
      Log.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ac.d.zs(l));
      paramabn = FnL.iterator();
      while (paramabn.hasNext()) {
        paramabn.next();
      }
      paramabn = null;
      break;
      localObject1 = null;
      break label248;
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(abn paramabn, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118832);
    p.h(paramabn, "item");
    p.h(paramMMHandler, "h");
    try
    {
      localObject1 = new eeg();
      paramabn = paramabn.Lmt;
      p.g(paramabn, "item.CmdBuf");
      paramabn = ((eeg)localObject1).parseFrom(paramabn.getBuffer().toByteArray());
      if (paramabn == null)
      {
        paramabn = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramabn;
      }
    }
    catch (Exception paramabn)
    {
      Log.w(TAG, "StorySyncMsg parse error: " + paramabn.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramabn = (eeg)paramabn;
    Object localObject1 = paramabn.Ney.xNH;
    int i = paramabn.Ney.CreateTime;
    long l = paramabn.Id;
    Log.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.d.zs(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.Fom;
    p.h(paramabn, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramabn.Id + ' ' + paramabn.Ney.MYT + ' ' + paramabn.Ney.CreateTime);
    localObject1 = new z.f();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    ((z.f)localObject1).SYG = j.b.fof().Kw(paramabn.Ney.Id);
    if ((c)((z.f)localObject1).SYG == null)
    {
      ((z.f)localObject1).SYG = new c();
      ((c)((z.f)localObject1).SYG).field_storyId = paramabn.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramabn);
    if (((c)((z.f)localObject1).SYG).field_readCommentTime == 0) {
      ((c)((z.f)localObject1).SYG).field_readCommentTime = 1;
    }
    localObject2 = (c)((z.f)localObject1).SYG;
    String str = paramabn.Ney.xNH;
    p.g(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((c)localObject2).aSr(str);
    localObject2 = (c)((z.f)localObject1).SYG;
    str = paramabn.Ney.NdL.UserName;
    p.g(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((c)localObject2).aSd(str);
    ((c)((z.f)localObject1).SYG).field_syncCommentId = paramabn.Ney.MYT;
    ((c)((z.f)localObject1).SYG).field_syncCommentTime = paramabn.Ney.CreateTime;
    paramabn = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fof().replace((IAutoDBItem)((z.f)localObject1).SYG);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b.a((z.f)localObject1));
    paramabn = FnL.iterator();
    while (paramabn.hasNext()) {
      paramabn.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(abn paramabn, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118833);
    p.h(paramabn, "item");
    p.h(paramMMHandler, "h");
    try
    {
      localeeg = new eeg();
      paramabn = paramabn.Lmt;
      p.g(paramabn, "item.CmdBuf");
      paramabn = localeeg.parseFrom(paramabn.getBuffer().toByteArray());
      if (paramabn == null)
      {
        paramabn = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramabn;
      }
    }
    catch (Exception paramabn)
    {
      Log.w(TAG, "StorySyncMsg parse error:  " + paramabn.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    eeg localeeg = (eeg)paramabn;
    paramabn = localeeg.Ney.xNH;
    int i = localeeg.Ney.CreateTime;
    long l = localeeg.Id;
    Log.i(TAG, "processStoryVisit username:" + paramabn + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.d.zs(l));
    paramabn = com.tencent.mm.plugin.story.f.b.b.Fom;
    p.h(localeeg, "syncMsg");
    boolean bool = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localeeg.Id + ' ' + localeeg.Ney.MYT + ' ' + localeeg.Ney.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localeeg);
    z.f localf = new z.f();
    paramabn = com.tencent.mm.plugin.story.f.j.Fmy;
    localf.SYG = j.b.fof().Kw(localeeg.Ney.Id);
    if ((c)localf.SYG == null)
    {
      localf.SYG = new c();
      ((c)localf.SYG).field_storyId = localeeg.Id;
    }
    Object localObject;
    if (((c)localf.SYG).field_readCommentTime == 0)
    {
      if (!Util.isNullOrNil(localeeg.Ney.iAc)) {
        break label636;
      }
      paramabn = localeeg.Ney.NdL.Nep;
      p.g(paramabn, "bubbleList");
      paramabn = (edf)kotlin.a.j.L((List)paramabn, paramabn.size() - 2);
      if (paramabn == null) {
        break label631;
      }
      paramabn = Integer.valueOf(paramabn.CreateTime);
      localObject = (c)localf.SYG;
      if (paramabn == null) {
        break label694;
      }
    }
    label694:
    for (i = paramabn.intValue();; i = 1)
    {
      ((c)localObject).field_readCommentTime = i;
      paramabn = (c)localf.SYG;
      localObject = localeeg.Ney.xNH;
      p.g(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramabn.aSr((String)localObject);
      paramabn = (c)localf.SYG;
      localObject = localeeg.Ney.NdL.UserName;
      p.g(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramabn.aSd((String)localObject);
      ((c)localf.SYG).field_syncCommentId = localeeg.Ney.MYT;
      ((c)localf.SYG).field_syncCommentTime = localeeg.Ney.CreateTime;
      paramabn = com.tencent.mm.plugin.story.f.j.Fmy;
      j.b.fof().replace((IAutoDBItem)localf.SYG);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new b.b(localf));
      paramabn = FnL.iterator();
      while (paramabn.hasNext()) {
        paramabn.next();
      }
      label631:
      paramabn = null;
      break;
      label636:
      paramabn = localeeg.Ney.NdL.Nen;
      p.g(paramabn, "commentList");
      paramabn = (edf)kotlin.a.j.L((List)paramabn, paramabn.size() - 2);
      if (paramabn != null)
      {
        i = paramabn.CreateTime;
        paramabn = Integer.valueOf(i);
        break;
      }
      paramabn = null;
      break;
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(abn paramabn, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(118834);
    p.h(paramabn, "item");
    p.h(paramMMHandler, "h");
    try
    {
      localObject = new eeg();
      paramabn = paramabn.Lmt;
      p.g(paramabn, "item.CmdBuf");
      paramabn = ((eeg)localObject).parseFrom(paramabn.getBuffer().toByteArray());
      if (paramabn == null)
      {
        paramabn = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramabn;
      }
    }
    catch (Exception paramabn)
    {
      Log.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramabn = (eeg)paramabn;
    Object localObject = paramabn.Ney.xNH;
    int i = paramabn.Ney.CreateTime;
    long l = paramabn.Id;
    Log.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.Fom;
    p.h(paramabn, "syncMsg");
    Log.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramabn.Id + ' ' + paramabn.Ney.MYT);
    com.tencent.mm.plugin.story.f.b.b.k(paramabn.Ney.Id, paramabn.Ney.MYT, paramabn.Ney.iAc);
    com.tencent.mm.plugin.story.f.b.b.Kl(paramabn.Ney.Id);
    paramabn = FnL.iterator();
    while (paramabn.hasNext()) {
      paramabn.next();
    }
    paramMMHandler.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(118835);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    Object localObject1 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject2 = Util.decodeHexString(Util.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).azQ().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.aYJ();
    if (localObject2 == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw paramg;
    }
    ((eei)localObject2).Lev = ((SKBuiltinBuffer_t)localObject1);
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
        p.btv("callback");
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(118836);
      return;
    }
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    eej localeej = (eej)params;
    params = localeej.Ley;
    if (params != null)
    {
      paramArrayOfByte = params.oTA;
      params = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      params = new LinkedList();
    }
    if (params.size() > 0)
    {
      paramString = this.FnJ;
      p.h(params, "cmdList");
      paramString.sKS = params;
      paramString.tby.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localeej.Lev != null)
    {
      params = localeej.Lev;
      p.g(params, "resp.KeyBuf");
      if (params.getBuffer() != null)
      {
        params = localeej.Lev;
        p.g(params, "resp.KeyBuf");
        params = params.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.aYJ();
        if (paramArrayOfByte == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        params = ad.l(((eei)paramArrayOfByte).Lev.getBuffer().toByteArray(), params);
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
        paramArrayOfByte = com.tencent.mm.kernel.g.aAh();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.azQ().set(8195, Util.encodeHexString(params));
      }
      params = this.callback;
      if (params == null) {
        p.btv("callback");
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
    return this.FnK;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "MM_STORY_SYNCCMD_VISIT", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", "listener", "removeNotifyListener", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    LinkedList<abn> sKS;
    MMHandler tby;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.tby = ((MMHandler)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends MMHandler
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        p.h(paramMessage, "msg");
        if (!com.tencent.mm.kernel.g.aAf().azp())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.FnO.sKS != null)
        {
          paramMessage = this.FnO.sKS;
          if (paramMessage == null) {
            p.hyc();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.FnO.FnN;
          localObject1 = paramMessage.rr.aYK();
          if (localObject1 == null)
          {
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (eej)localObject1;
          Object localObject2 = paramMessage.rr.aYJ();
          if (localObject2 == null)
          {
            paramMessage = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (eei)localObject2;
          byte[] arrayOfByte = ((eej)localObject1).Lev.getBuffer().toByteArray();
          arrayOfByte = ad.l(((eei)localObject2).Lev.getBuffer().toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
            p.g(locale, "MMKernel.storage()");
            locale.azQ().set(8195, Util.encodeHexString(arrayOfByte));
          }
          ((eei)localObject2).Lev.setBuffer(arrayOfByte);
          if ((((eej)localObject1).KZh & ((eei)localObject2).Leu) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              p.btv("callback");
            }
            ((i)localObject1).onSceneEnd(0, 0, "", (q)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          p.g(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            p.btv("callback");
          }
          paramMessage.doScene((com.tencent.mm.network.g)localObject1, (i)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.FnO.sKS;
        if (paramMessage == null) {
          p.hyc();
        }
        paramMessage = (abn)paramMessage.getFirst();
        Log.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.Lms);
        Object localObject1 = this.FnO.sKS;
        if (localObject1 == null) {
          p.hyc();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.Lms)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, abn paramabn) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          abn localabn = paramMessage;
          p.g(localabn, "item");
          if (!h.c(localabn, (MMHandler)this.FnP)) {
            this.FnP.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, abn paramabn) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          abn localabn = paramMessage;
          p.g(localabn, "item");
          if (!h.d(localabn, (MMHandler)this.FnP)) {
            this.FnP.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, abn paramabn) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          abn localabn = paramMessage;
          p.g(localabn, "item");
          if (!h.e(localabn, (MMHandler)this.FnP)) {
            this.FnP.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, abn paramabn) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          abn localabn = paramMessage;
          p.g(localabn, "item");
          if (!h.f(localabn, (MMHandler)this.FnP)) {
            this.FnP.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, abn paramabn) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          abn localabn = paramMessage;
          p.g(localabn, "item");
          if (!h.g(localabn, (MMHandler)this.FnP)) {
            this.FnP.sendEmptyMessage(0);
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