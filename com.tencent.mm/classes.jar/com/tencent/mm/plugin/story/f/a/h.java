package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import d.g.b.v.e;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private static final LinkedList<Object> ygw;
  public static final a ygx;
  com.tencent.mm.al.g callback;
  final com.tencent.mm.al.b rr;
  private b ygu;
  private final int ygv;
  
  static
  {
    AppMethodBeat.i(118838);
    ygx = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    ygw = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.ygu = new b();
    this.ygv = 10;
    Object localObject = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject).c((com.tencent.mm.bx.a)new czb());
    ((com.tencent.mm.al.b.a)localObject).d((com.tencent.mm.bx.a)new czc());
    ((com.tencent.mm.al.b.a)localObject).wg("/cgi-bin/micromsg-bin/mmstorysync");
    ((com.tencent.mm.al.b.a)localObject).nB(513);
    ((com.tencent.mm.al.b.a)localObject).nD(0);
    ((com.tencent.mm.al.b.a)localObject).nE(0);
    localObject = ((com.tencent.mm.al.b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject);
    localObject = this.rr.auL();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((czb)localObject).CRw = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(xd paramxd, ap paramap)
  {
    AppMethodBeat.i(118830);
    d.g.b.k.h(paramxd, "item");
    d.g.b.k.h(paramap, "h");
    try
    {
      localObject1 = new cyz();
      paramxd = paramxd.CYZ;
      d.g.b.k.g(paramxd, "item.CmdBuf");
      paramxd = ((cyz)localObject1).parseFrom(paramxd.getBuffer().toByteArray());
      if (paramxd == null)
      {
        paramxd = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramxd;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramxd = (cyz)paramxd;
    Object localObject1 = paramxd.EqX.sdQ;
    int i = paramxd.EqX.CreateTime;
    long l = paramxd.Id;
    Object localObject2 = com.tencent.mm.plugin.story.f.n.yfw;
    d.g.b.k.g(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramxd.EqX.Eqj, false);
    localObject2 = com.tencent.mm.plugin.story.f.k.yfq;
    com.tencent.mm.plugin.story.f.k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramxd.EqX.sdQ).append(" createTime:").append(paramxd.EqX.CreateTime).append(" id:").append(paramxd.Id).append(" scope:");
    if (localj != null)
    {
      paramxd = localj.dKH();
      if (paramxd == null) {}
    }
    for (paramxd = Integer.valueOf(paramxd.Erc);; paramxd = null)
    {
      com.tencent.mm.sdk.platformtools.ad.i((String)localObject1, paramxd);
      paramxd = ygw.iterator();
      while (paramxd.hasNext()) {
        paramxd.next();
      }
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(xd paramxd, ap paramap)
  {
    AppMethodBeat.i(118831);
    d.g.b.k.h(paramxd, "item");
    d.g.b.k.h(paramap, "h");
    Object localObject1;
    try
    {
      localObject1 = new cyz();
      paramxd = paramxd.CYZ;
      d.g.b.k.g(paramxd, "item.CmdBuf");
      paramxd = ((cyz)localObject1).parseFrom(paramxd.getBuffer().toByteArray());
      if (paramxd == null)
      {
        paramxd = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramxd;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramxd = (cyz)paramxd;
    String str = paramxd.EqX.sdQ;
    int i = paramxd.EqX.CreateTime;
    long l = paramxd.Id;
    paramxd = com.tencent.mm.plugin.story.f.n.yfw;
    d.g.b.k.g(str, "username");
    n.a.a(str, l, i, null, true);
    paramxd = com.tencent.mm.plugin.story.f.n.yfw;
    com.tencent.mm.plugin.story.i.j localj = n.a.arx(str);
    Object localObject2 = localj.dKH();
    paramxd = ((czd)localObject2).Era;
    if (paramxd != null)
    {
      paramxd = paramxd.DaC;
      if (paramxd != null)
      {
        paramxd = (cym)d.a.j.C((List)paramxd, 0);
        if (paramxd != null)
        {
          paramxd = paramxd.DMQ;
          localObject1 = ((czd)localObject2).Era;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((cyd)localObject1).DaC;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = (cym)d.a.j.C((List)localObject1, 0);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((cym)localObject1).Url;
          label248:
          localObject2 = ((czd)localObject2).Era;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = ((cyd)localObject2).DaC;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = (cym)d.a.j.C((List)localObject2, 0);
          if (localObject2 == null) {
            break label450;
          }
        }
      }
    }
    label444:
    label450:
    for (float f = ((cym)localObject2).EqD;; f = 0.0F)
    {
      localObject2 = com.tencent.mm.plugin.story.f.k.yfq;
      com.tencent.mm.plugin.story.f.k.a(str, localj.field_storyID, localj.field_createTime, paramxd, (String)localObject1, (f * 1000.0F));
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ad.c.ly(l));
      paramxd = ygw.iterator();
      while (paramxd.hasNext()) {
        paramxd.next();
      }
      paramxd = null;
      break;
      localObject1 = null;
      break label248;
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(xd paramxd, ap paramap)
  {
    AppMethodBeat.i(118832);
    d.g.b.k.h(paramxd, "item");
    d.g.b.k.h(paramap, "h");
    try
    {
      localObject1 = new cyz();
      paramxd = paramxd.CYZ;
      d.g.b.k.g(paramxd, "item.CmdBuf");
      paramxd = ((cyz)localObject1).parseFrom(paramxd.getBuffer().toByteArray());
      if (paramxd == null)
      {
        paramxd = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramxd;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error: " + paramxd.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramxd = (cyz)paramxd;
    Object localObject1 = paramxd.EqX.sdQ;
    int i = paramxd.EqX.CreateTime;
    long l = paramxd.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ad.c.ly(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ygY;
    d.g.b.k.h(paramxd, "syncMsg");
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramxd.Id + ' ' + paramxd.EqX.Ema + ' ' + paramxd.EqX.CreateTime);
    localObject1 = new v.e();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    ((v.e)localObject1).Jhw = j.b.dHg().tS(paramxd.EqX.Id);
    if ((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw == null)
    {
      ((v.e)localObject1).Jhw = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw).field_storyId = paramxd.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramxd);
    if (((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw).field_readCommentTime == 0) {
      ((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw).field_readCommentTime = 1;
    }
    localObject2 = (com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw;
    String str = paramxd.EqX.sdQ;
    d.g.b.k.g(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).arQ(str);
    localObject2 = (com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw;
    str = paramxd.EqX.Eqj.mAQ;
    d.g.b.k.g(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).arC(str);
    ((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw).field_syncCommentId = paramxd.EqX.Ema;
    ((com.tencent.mm.plugin.story.i.c)((v.e)localObject1).Jhw).field_syncCommentTime = paramxd.EqX.CreateTime;
    paramxd = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHg().replace((com.tencent.mm.sdk.e.c)((v.e)localObject1).Jhw);
    com.tencent.mm.ad.c.g((d.g.a.a)new com.tencent.mm.plugin.story.f.b.b.a((v.e)localObject1));
    paramxd = ygw.iterator();
    while (paramxd.hasNext()) {
      paramxd.next();
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(xd paramxd, ap paramap)
  {
    AppMethodBeat.i(118833);
    d.g.b.k.h(paramxd, "item");
    d.g.b.k.h(paramap, "h");
    try
    {
      localcyz = new cyz();
      paramxd = paramxd.CYZ;
      d.g.b.k.g(paramxd, "item.CmdBuf");
      paramxd = localcyz.parseFrom(paramxd.getBuffer().toByteArray());
      if (paramxd == null)
      {
        paramxd = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramxd;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error:  " + paramxd.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    cyz localcyz = (cyz)paramxd;
    paramxd = localcyz.EqX.sdQ;
    int i = localcyz.EqX.CreateTime;
    long l = localcyz.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryVisit username:" + paramxd + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ad.c.ly(l));
    paramxd = com.tencent.mm.plugin.story.f.b.b.ygY;
    d.g.b.k.h(localcyz, "syncMsg");
    boolean bool = com.tencent.mm.plugin.story.c.a.e.ydS.dGh();
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localcyz.Id + ' ' + localcyz.EqX.Ema + ' ' + localcyz.EqX.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localcyz);
    v.e locale = new v.e();
    paramxd = com.tencent.mm.plugin.story.f.j.yfh;
    locale.Jhw = j.b.dHg().tS(localcyz.EqX.Id);
    if ((com.tencent.mm.plugin.story.i.c)locale.Jhw == null)
    {
      locale.Jhw = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_storyId = localcyz.Id;
    }
    Object localObject;
    if (((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_readCommentTime == 0)
    {
      if (!bt.isNullOrNil(localcyz.EqX.gKr)) {
        break label636;
      }
      paramxd = localcyz.EqX.Eqj.EqO;
      d.g.b.k.g(paramxd, "bubbleList");
      paramxd = (cxy)d.a.j.C((List)paramxd, paramxd.size() - 2);
      if (paramxd == null) {
        break label631;
      }
      paramxd = Integer.valueOf(paramxd.CreateTime);
      localObject = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
      if (paramxd == null) {
        break label694;
      }
    }
    label694:
    for (i = paramxd.intValue();; i = 1)
    {
      ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = i;
      paramxd = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
      localObject = localcyz.EqX.sdQ;
      d.g.b.k.g(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramxd.arQ((String)localObject);
      paramxd = (com.tencent.mm.plugin.story.i.c)locale.Jhw;
      localObject = localcyz.EqX.Eqj.mAQ;
      d.g.b.k.g(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramxd.arC((String)localObject);
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_syncCommentId = localcyz.EqX.Ema;
      ((com.tencent.mm.plugin.story.i.c)locale.Jhw).field_syncCommentTime = localcyz.EqX.CreateTime;
      paramxd = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHg().replace((com.tencent.mm.sdk.e.c)locale.Jhw);
      com.tencent.mm.ad.c.g((d.g.a.a)new b.b(locale));
      paramxd = ygw.iterator();
      while (paramxd.hasNext()) {
        paramxd.next();
      }
      label631:
      paramxd = null;
      break;
      label636:
      paramxd = localcyz.EqX.Eqj.EqM;
      d.g.b.k.g(paramxd, "commentList");
      paramxd = (cxy)d.a.j.C((List)paramxd, paramxd.size() - 2);
      if (paramxd != null)
      {
        i = paramxd.CreateTime;
        paramxd = Integer.valueOf(i);
        break;
      }
      paramxd = null;
      break;
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(xd paramxd, ap paramap)
  {
    AppMethodBeat.i(118834);
    d.g.b.k.h(paramxd, "item");
    d.g.b.k.h(paramap, "h");
    try
    {
      localObject = new cyz();
      paramxd = paramxd.CYZ;
      d.g.b.k.g(paramxd, "item.CmdBuf");
      paramxd = ((cyz)localObject).parseFrom(paramxd.getBuffer().toByteArray());
      if (paramxd == null)
      {
        paramxd = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramxd;
      }
    }
    catch (Exception paramxd)
    {
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramxd = (cyz)paramxd;
    Object localObject = paramxd.EqX.sdQ;
    int i = paramxd.EqX.CreateTime;
    long l = paramxd.Id;
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.ygY;
    d.g.b.k.h(paramxd, "syncMsg");
    com.tencent.mm.sdk.platformtools.ad.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramxd.Id + ' ' + paramxd.EqX.Ema);
    com.tencent.mm.plugin.story.f.b.b.g(paramxd.EqX.Id, paramxd.EqX.Ema, paramxd.EqX.gKr);
    com.tencent.mm.plugin.story.f.b.b.tH(paramxd.EqX.Id);
    paramxd = ygw.iterator();
    while (paramxd.hasNext()) {
      paramxd.next();
    }
    paramap.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(118835);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    Object localObject1 = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    Object localObject2 = bt.aGd(bt.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).afk().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.auL();
    if (localObject2 == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw parame;
    }
    ((czb)localObject2).CRx = ((SKBuiltinBuffer_t)localObject1);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118835);
    return i;
  }
  
  public final int getType()
  {
    return 513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118836);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118836);
      return;
    }
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    czc localczc = (czc)paramq;
    paramq = localczc.CRA;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.mAL;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      paramq = new LinkedList();
    }
    if (paramq.size() > 0)
    {
      paramString = this.ygu;
      d.g.b.k.h(paramq, "cmdList");
      paramString.pJl = paramq;
      paramString.qaZ.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localczc.CRx != null)
    {
      paramq = localczc.CRx;
      d.g.b.k.g(paramq, "resp.KeyBuf");
      if (paramq.getBuffer() != null)
      {
        paramq = localczc.CRx;
        d.g.b.k.g(paramq, "resp.KeyBuf");
        paramq = paramq.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.auL();
        if (paramArrayOfByte == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        paramq = com.tencent.mm.protocal.ad.k(((czb)paramArrayOfByte).CRx.getBuffer().toByteArray(), paramq);
        if (paramq != null)
        {
          if (paramq.length != 0) {
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
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(8195, bt.cy(paramq));
      }
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118836);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.ygv;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$Companion;", "", "()V", "MM_STORY_SYNCCMD_COMMENT", "", "MM_STORY_SYNCCMD_COMMENT_DEL", "MM_STORY_SYNCCMD_POST", "MM_STORY_SYNCCMD_POST_DEL", "MM_STORY_SYNCCMD_VISIT", "TAG", "", "notifyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/model/IOnStoryNotify;", "addNotifyListener", "", "listener", "removeNotifyListener", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    LinkedList<xd> pJl;
    ap qaZ;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.qaZ = ((ap)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends ap
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        d.g.b.k.h(paramMessage, "msg");
        if (!com.tencent.mm.kernel.g.afz().aeI())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.ygz.pJl != null)
        {
          paramMessage = this.ygz.pJl;
          if (paramMessage == null) {
            d.g.b.k.fvU();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.ygz.ygy;
          localObject1 = paramMessage.rr.auM();
          if (localObject1 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (czc)localObject1;
          Object localObject2 = paramMessage.rr.auL();
          if (localObject2 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (czb)localObject2;
          byte[] arrayOfByte = ((czc)localObject1).CRx.getBuffer().toByteArray();
          arrayOfByte = com.tencent.mm.protocal.ad.k(((czb)localObject2).CRx.getBuffer().toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(locale, "MMKernel.storage()");
            locale.afk().set(8195, bt.cy(arrayOfByte));
          }
          ((czb)localObject2).CRx.setBuffer(arrayOfByte);
          if ((((czc)localObject1).CNq & ((czb)localObject2).CRw) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              d.g.b.k.aPZ("callback");
            }
            ((com.tencent.mm.al.g)localObject1).onSceneEnd(0, 0, "", (com.tencent.mm.al.n)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          d.g.b.k.g(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            d.g.b.k.aPZ("callback");
          }
          paramMessage.doScene((com.tencent.mm.network.e)localObject1, (com.tencent.mm.al.g)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.ygz.pJl;
        if (paramMessage == null) {
          d.g.b.k.fvU();
        }
        paramMessage = (xd)paramMessage.getFirst();
        com.tencent.mm.sdk.platformtools.ad.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.CYY);
        Object localObject1 = this.ygz.pJl;
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.CYY)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          j.b.dhI().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dhI().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, xd paramxd) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          xd localxd = paramMessage;
          d.g.b.k.g(localxd, "item");
          if (!h.c(localxd, (ap)this.ygA)) {
            this.ygA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, xd paramxd) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          xd localxd = paramMessage;
          d.g.b.k.g(localxd, "item");
          if (!h.d(localxd, (ap)this.ygA)) {
            this.ygA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, xd paramxd) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          xd localxd = paramMessage;
          d.g.b.k.g(localxd, "item");
          if (!h.e(localxd, (ap)this.ygA)) {
            this.ygA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, xd paramxd) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          xd localxd = paramMessage;
          d.g.b.k.g(localxd, "item");
          if (!h.f(localxd, (ap)this.ygA)) {
            this.ygA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, xd paramxd) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          xd localxd = paramMessage;
          d.g.b.k.g(localxd, "item");
          if (!h.g(localxd, (ap)this.ygA)) {
            this.ygA.sendEmptyMessage(0);
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