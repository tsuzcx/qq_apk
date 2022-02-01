package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dkw;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final LinkedList<Object> BcT;
  public static final h.a BcU;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private b BcR;
  private final int BcS;
  f callback;
  final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(118838);
    BcU = new h.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    BcT = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.BcR = new b();
    this.BcS = 10;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new dkv());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new dkw());
    ((com.tencent.mm.ak.b.a)localObject).DN("/cgi-bin/micromsg-bin/mmstorysync");
    ((com.tencent.mm.ak.b.a)localObject).oS(513);
    ((com.tencent.mm.ak.b.a)localObject).oU(0);
    ((com.tencent.mm.ak.b.a)localObject).oV(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aEU();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((dkv)localObject).GjP = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(zx paramzx, aq paramaq)
  {
    AppMethodBeat.i(118830);
    p.h(paramzx, "item");
    p.h(paramaq, "h");
    try
    {
      localObject1 = new dkt();
      paramzx = paramzx.Grv;
      p.g(paramzx, "item.CmdBuf");
      paramzx = ((dkt)localObject1).parseFrom(paramzx.getBuffer().toByteArray());
      if (paramzx == null)
      {
        paramzx = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramzx;
      }
    }
    catch (Exception paramzx)
    {
      ae.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramzx = (dkt)paramzx;
    Object localObject1 = paramzx.HSv.uvG;
    int i = paramzx.HSv.CreateTime;
    long l = paramzx.Id;
    Object localObject2 = com.tencent.mm.plugin.story.f.n.BbT;
    p.g(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramzx.HSv.HRH, false);
    localObject2 = com.tencent.mm.plugin.story.f.k.BbN;
    com.tencent.mm.plugin.story.f.k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramzx.HSv.uvG).append(" createTime:").append(paramzx.HSv.CreateTime).append(" id:").append(paramzx.Id).append(" scope:");
    if (localj != null)
    {
      paramzx = localj.epg();
      if (paramzx == null) {}
    }
    for (paramzx = Integer.valueOf(paramzx.HSA);; paramzx = null)
    {
      ae.i((String)localObject1, paramzx);
      paramzx = BcT.iterator();
      while (paramzx.hasNext()) {
        paramzx.next();
      }
    }
    paramaq.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(zx paramzx, aq paramaq)
  {
    AppMethodBeat.i(118831);
    p.h(paramzx, "item");
    p.h(paramaq, "h");
    Object localObject1;
    try
    {
      localObject1 = new dkt();
      paramzx = paramzx.Grv;
      p.g(paramzx, "item.CmdBuf");
      paramzx = ((dkt)localObject1).parseFrom(paramzx.getBuffer().toByteArray());
      if (paramzx == null)
      {
        paramzx = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramzx;
      }
    }
    catch (Exception paramzx)
    {
      ae.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramzx = (dkt)paramzx;
    String str = paramzx.HSv.uvG;
    int i = paramzx.HSv.CreateTime;
    long l = paramzx.Id;
    paramzx = com.tencent.mm.plugin.story.f.n.BbT;
    p.g(str, "username");
    n.a.a(str, l, i, null, true);
    paramzx = com.tencent.mm.plugin.story.f.n.BbT;
    com.tencent.mm.plugin.story.i.j localj = n.a.aDe(str);
    Object localObject2 = localj.epg();
    paramzx = ((dkx)localObject2).HSy;
    if (paramzx != null)
    {
      paramzx = paramzx.Gtx;
      if (paramzx != null)
      {
        paramzx = (dkg)d.a.j.F((List)paramzx, 0);
        if (paramzx != null)
        {
          paramzx = paramzx.Hmj;
          localObject1 = ((dkx)localObject2).HSy;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((djx)localObject1).Gtx;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = (dkg)d.a.j.F((List)localObject1, 0);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((dkg)localObject1).Url;
          label248:
          localObject2 = ((dkx)localObject2).HSy;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = ((djx)localObject2).Gtx;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = (dkg)d.a.j.F((List)localObject2, 0);
          if (localObject2 == null) {
            break label450;
          }
        }
      }
    }
    label444:
    label450:
    for (float f = ((dkg)localObject2).HSb;; f = 0.0F)
    {
      localObject2 = com.tencent.mm.plugin.story.f.k.BbN;
      com.tencent.mm.plugin.story.f.k.a(str, localj.field_storyID, localj.field_createTime, paramzx, (String)localObject1, (f * 1000.0F));
      ae.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ac.c.rp(l));
      paramzx = BcT.iterator();
      while (paramzx.hasNext()) {
        paramzx.next();
      }
      paramzx = null;
      break;
      localObject1 = null;
      break label248;
    }
    paramaq.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(zx paramzx, aq paramaq)
  {
    AppMethodBeat.i(118832);
    p.h(paramzx, "item");
    p.h(paramaq, "h");
    try
    {
      localObject1 = new dkt();
      paramzx = paramzx.Grv;
      p.g(paramzx, "item.CmdBuf");
      paramzx = ((dkt)localObject1).parseFrom(paramzx.getBuffer().toByteArray());
      if (paramzx == null)
      {
        paramzx = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramzx;
      }
    }
    catch (Exception paramzx)
    {
      ae.w(TAG, "StorySyncMsg parse error: " + paramzx.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramzx = (dkt)paramzx;
    Object localObject1 = paramzx.HSv.uvG;
    int i = paramzx.HSv.CreateTime;
    long l = paramzx.Id;
    ae.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.c.rp(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.Bdv;
    p.h(paramzx, "syncMsg");
    ae.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramzx.Id + ' ' + paramzx.HSv.HNk + ' ' + paramzx.HSv.CreateTime);
    localObject1 = new y.f();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    ((y.f)localObject1).NiY = j.b.elE().Br(paramzx.HSv.Id);
    if ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY == null)
    {
      ((y.f)localObject1).NiY = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY).field_storyId = paramzx.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramzx);
    if (((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY).field_readCommentTime == 0) {
      ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY).field_readCommentTime = 1;
    }
    localObject2 = (com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY;
    String str = paramzx.HSv.uvG;
    p.g(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).aDw(str);
    localObject2 = (com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY;
    str = paramzx.HSv.HRH.nIJ;
    p.g(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).aDi(str);
    ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY).field_syncCommentId = paramzx.HSv.HNk;
    ((com.tencent.mm.plugin.story.i.c)((y.f)localObject1).NiY).field_syncCommentTime = paramzx.HSv.CreateTime;
    paramzx = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elE().replace((com.tencent.mm.sdk.e.c)((y.f)localObject1).NiY);
    com.tencent.mm.ac.c.h((d.g.a.a)new com.tencent.mm.plugin.story.f.b.b.a((y.f)localObject1));
    paramzx = BcT.iterator();
    while (paramzx.hasNext()) {
      paramzx.next();
    }
    paramaq.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(zx paramzx, aq paramaq)
  {
    AppMethodBeat.i(118833);
    p.h(paramzx, "item");
    p.h(paramaq, "h");
    try
    {
      localdkt = new dkt();
      paramzx = paramzx.Grv;
      p.g(paramzx, "item.CmdBuf");
      paramzx = localdkt.parseFrom(paramzx.getBuffer().toByteArray());
      if (paramzx == null)
      {
        paramzx = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramzx;
      }
    }
    catch (Exception paramzx)
    {
      ae.w(TAG, "StorySyncMsg parse error:  " + paramzx.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    dkt localdkt = (dkt)paramzx;
    paramzx = localdkt.HSv.uvG;
    int i = localdkt.HSv.CreateTime;
    long l = localdkt.Id;
    ae.i(TAG, "processStoryVisit username:" + paramzx + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.c.rp(l));
    paramzx = com.tencent.mm.plugin.story.f.b.b.Bdv;
    p.h(localdkt, "syncMsg");
    boolean bool = com.tencent.mm.plugin.story.c.a.e.Bap.ekF();
    ae.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localdkt.Id + ' ' + localdkt.HSv.HNk + ' ' + localdkt.HSv.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localdkt);
    y.f localf = new y.f();
    paramzx = com.tencent.mm.plugin.story.f.j.BbE;
    localf.NiY = j.b.elE().Br(localdkt.HSv.Id);
    if ((com.tencent.mm.plugin.story.i.c)localf.NiY == null)
    {
      localf.NiY = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_storyId = localdkt.Id;
    }
    Object localObject;
    if (((com.tencent.mm.plugin.story.i.c)localf.NiY).field_readCommentTime == 0)
    {
      if (!bu.isNullOrNil(localdkt.HSv.hFS)) {
        break label636;
      }
      paramzx = localdkt.HSv.HRH.HSm;
      p.g(paramzx, "bubbleList");
      paramzx = (djs)d.a.j.F((List)paramzx, paramzx.size() - 2);
      if (paramzx == null) {
        break label631;
      }
      paramzx = Integer.valueOf(paramzx.CreateTime);
      localObject = (com.tencent.mm.plugin.story.i.c)localf.NiY;
      if (paramzx == null) {
        break label694;
      }
    }
    label694:
    for (i = paramzx.intValue();; i = 1)
    {
      ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = i;
      paramzx = (com.tencent.mm.plugin.story.i.c)localf.NiY;
      localObject = localdkt.HSv.uvG;
      p.g(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramzx.aDw((String)localObject);
      paramzx = (com.tencent.mm.plugin.story.i.c)localf.NiY;
      localObject = localdkt.HSv.HRH.nIJ;
      p.g(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramzx.aDi((String)localObject);
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_syncCommentId = localdkt.HSv.HNk;
      ((com.tencent.mm.plugin.story.i.c)localf.NiY).field_syncCommentTime = localdkt.HSv.CreateTime;
      paramzx = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elE().replace((com.tencent.mm.sdk.e.c)localf.NiY);
      com.tencent.mm.ac.c.h((d.g.a.a)new b.b(localf));
      paramzx = BcT.iterator();
      while (paramzx.hasNext()) {
        paramzx.next();
      }
      label631:
      paramzx = null;
      break;
      label636:
      paramzx = localdkt.HSv.HRH.HSk;
      p.g(paramzx, "commentList");
      paramzx = (djs)d.a.j.F((List)paramzx, paramzx.size() - 2);
      if (paramzx != null)
      {
        i = paramzx.CreateTime;
        paramzx = Integer.valueOf(i);
        break;
      }
      paramzx = null;
      break;
    }
    paramaq.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(zx paramzx, aq paramaq)
  {
    AppMethodBeat.i(118834);
    p.h(paramzx, "item");
    p.h(paramaq, "h");
    try
    {
      localObject = new dkt();
      paramzx = paramzx.Grv;
      p.g(paramzx, "item.CmdBuf");
      paramzx = ((dkt)localObject).parseFrom(paramzx.getBuffer().toByteArray());
      if (paramzx == null)
      {
        paramzx = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramzx;
      }
    }
    catch (Exception paramzx)
    {
      ae.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramzx = (dkt)paramzx;
    Object localObject = paramzx.HSv.uvG;
    int i = paramzx.HSv.CreateTime;
    long l = paramzx.Id;
    ae.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.Bdv;
    p.h(paramzx, "syncMsg");
    ae.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramzx.Id + ' ' + paramzx.HSv.HNk);
    com.tencent.mm.plugin.story.f.b.b.j(paramzx.HSv.Id, paramzx.HSv.HNk, paramzx.HSv.hFS);
    com.tencent.mm.plugin.story.f.b.b.Bg(paramzx.HSv.Id);
    paramzx = BcT.iterator();
    while (paramzx.hasNext()) {
      paramzx.next();
    }
    paramaq.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(118835);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    Object localObject1 = g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    Object localObject2 = bu.aSx(bu.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).ajA().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.aEU();
    if (localObject2 == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw parame;
    }
    ((dkv)localObject2).GjQ = ((SKBuiltinBuffer_t)localObject1);
    this.callback = paramf;
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
    ae.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118836);
      return;
    }
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    dkw localdkw = (dkw)paramq;
    paramq = localdkw.GjT;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.nIE;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      paramq = new LinkedList();
    }
    if (paramq.size() > 0)
    {
      paramString = this.BcR;
      p.h(paramq, "cmdList");
      paramString.rjr = paramq;
      paramString.rBT.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localdkw.GjQ != null)
    {
      paramq = localdkw.GjQ;
      p.g(paramq, "resp.KeyBuf");
      if (paramq.getBuffer() != null)
      {
        paramq = localdkw.GjQ;
        p.g(paramq, "resp.KeyBuf");
        paramq = paramq.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.aEU();
        if (paramArrayOfByte == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        paramq = ad.l(((dkv)paramArrayOfByte).GjQ.getBuffer().toByteArray(), paramq);
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
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(8195, bu.cH(paramq));
      }
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118836);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.BcS;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    aq rBT;
    LinkedList<zx> rjr;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.rBT = ((aq)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends aq
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        p.h(paramMessage, "msg");
        if (!g.ajP().aiZ())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.BcW.rjr != null)
        {
          paramMessage = this.BcW.rjr;
          if (paramMessage == null) {
            p.gkB();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.BcW.BcV;
          localObject1 = paramMessage.rr.aEV();
          if (localObject1 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (dkw)localObject1;
          Object localObject2 = paramMessage.rr.aEU();
          if (localObject2 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (dkv)localObject2;
          byte[] arrayOfByte = ((dkw)localObject1).GjQ.getBuffer().toByteArray();
          arrayOfByte = ad.l(((dkv)localObject2).GjQ.getBuffer().toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            com.tencent.mm.kernel.e locale = g.ajR();
            p.g(locale, "MMKernel.storage()");
            locale.ajA().set(8195, bu.cH(arrayOfByte));
          }
          ((dkv)localObject2).GjQ.setBuffer(arrayOfByte);
          if ((((dkw)localObject1).GeQ & ((dkv)localObject2).GjP) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              p.bdF("callback");
            }
            ((f)localObject1).onSceneEnd(0, 0, "", (com.tencent.mm.ak.n)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          p.g(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            p.bdF("callback");
          }
          paramMessage.doScene((com.tencent.mm.network.e)localObject1, (f)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.BcW.rjr;
        if (paramMessage == null) {
          p.gkB();
        }
        paramMessage = (zx)paramMessage.getFirst();
        ae.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.Gru);
        Object localObject1 = this.BcW.rjr;
        if (localObject1 == null) {
          p.gkB();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.Gru)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          j.b.dJc().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.dJc().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, zx paramzx) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          zx localzx = paramMessage;
          p.g(localzx, "item");
          if (!h.c(localzx, (aq)this.BcX)) {
            this.BcX.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, zx paramzx) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          zx localzx = paramMessage;
          p.g(localzx, "item");
          if (!h.d(localzx, (aq)this.BcX)) {
            this.BcX.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, zx paramzx) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          zx localzx = paramMessage;
          p.g(localzx, "item");
          if (!h.e(localzx, (aq)this.BcX)) {
            this.BcX.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, zx paramzx) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          zx localzx = paramMessage;
          p.g(localzx, "item");
          if (!h.f(localzx, (aq)this.BcX)) {
            this.BcX.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, zx paramzx) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          zx localzx = paramMessage;
          p.g(localzx, "item");
          if (!h.g(localzx, (aq)this.BcX)) {
            this.BcX.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118827);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.h
 * JD-Core Version:    0.7.0.1
 */