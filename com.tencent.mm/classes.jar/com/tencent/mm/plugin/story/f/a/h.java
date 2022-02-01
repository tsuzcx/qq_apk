package com.tencent.mm.plugin.story.f.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.f.b.b.b;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddk;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.dem;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import d.g.b.v.f;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "processStoryVisit", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class h
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private static final LinkedList<Object> ztw;
  public static final h.a ztx;
  com.tencent.mm.ak.g callback;
  final com.tencent.mm.ak.b rr;
  private b ztu;
  private final int ztv;
  
  static
  {
    AppMethodBeat.i(118838);
    ztx = new h.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    ztw = new LinkedList();
    AppMethodBeat.o(118838);
  }
  
  public h()
  {
    AppMethodBeat.i(118837);
    this.ztu = new b();
    this.ztv = 10;
    Object localObject = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject).c((com.tencent.mm.bw.a)new den());
    ((com.tencent.mm.ak.b.a)localObject).d((com.tencent.mm.bw.a)new deo());
    ((com.tencent.mm.ak.b.a)localObject).Am("/cgi-bin/micromsg-bin/mmstorysync");
    ((com.tencent.mm.ak.b.a)localObject).op(513);
    ((com.tencent.mm.ak.b.a)localObject).or(0);
    ((com.tencent.mm.ak.b.a)localObject).os(0);
    localObject = ((com.tencent.mm.ak.b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject);
    localObject = this.rr.aBC();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118837);
      throw ((Throwable)localObject);
    }
    ((den)localObject).Ekh = 128;
    AppMethodBeat.o(118837);
  }
  
  public static boolean c(xv paramxv, ao paramao)
  {
    AppMethodBeat.i(118830);
    d.g.b.k.h(paramxv, "item");
    d.g.b.k.h(paramao, "h");
    try
    {
      localObject1 = new del();
      paramxv = paramxv.ErM;
      d.g.b.k.g(paramxv, "item.CmdBuf");
      paramxv = ((del)localObject1).parseFrom(paramxv.getBuffer().toByteArray());
      if (paramxv == null)
      {
        paramxv = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118830);
        throw paramxv;
      }
    }
    catch (Exception paramxv)
    {
      ac.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118830);
      return false;
    }
    paramxv = (del)paramxv;
    Object localObject1 = paramxv.FNZ.tlK;
    int i = paramxv.FNZ.CreateTime;
    long l = paramxv.Id;
    Object localObject2 = com.tencent.mm.plugin.story.f.n.zsw;
    d.g.b.k.g(localObject1, "username");
    com.tencent.mm.plugin.story.i.j localj = n.a.a((String)localObject1, l, i, paramxv.FNZ.FNl, false);
    localObject2 = com.tencent.mm.plugin.story.f.k.zsq;
    com.tencent.mm.plugin.story.f.k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramxv.FNZ.tlK).append(" createTime:").append(paramxv.FNZ.CreateTime).append(" id:").append(paramxv.Id).append(" scope:");
    if (localj != null)
    {
      paramxv = localj.dZi();
      if (paramxv == null) {}
    }
    for (paramxv = Integer.valueOf(paramxv.FOe);; paramxv = null)
    {
      ac.i((String)localObject1, paramxv);
      paramxv = ztw.iterator();
      while (paramxv.hasNext()) {
        paramxv.next();
      }
    }
    paramao.sendEmptyMessage(0);
    AppMethodBeat.o(118830);
    return true;
  }
  
  public static boolean d(xv paramxv, ao paramao)
  {
    AppMethodBeat.i(118831);
    d.g.b.k.h(paramxv, "item");
    d.g.b.k.h(paramao, "h");
    Object localObject1;
    try
    {
      localObject1 = new del();
      paramxv = paramxv.ErM;
      d.g.b.k.g(paramxv, "item.CmdBuf");
      paramxv = ((del)localObject1).parseFrom(paramxv.getBuffer().toByteArray());
      if (paramxv == null)
      {
        paramxv = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118831);
        throw paramxv;
      }
    }
    catch (Exception paramxv)
    {
      ac.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118831);
      return false;
    }
    paramxv = (del)paramxv;
    String str = paramxv.FNZ.tlK;
    int i = paramxv.FNZ.CreateTime;
    long l = paramxv.Id;
    paramxv = com.tencent.mm.plugin.story.f.n.zsw;
    d.g.b.k.g(str, "username");
    n.a.a(str, l, i, null, true);
    paramxv = com.tencent.mm.plugin.story.f.n.zsw;
    com.tencent.mm.plugin.story.i.j localj = n.a.awG(str);
    Object localObject2 = localj.dZi();
    paramxv = ((dep)localObject2).FOc;
    if (paramxv != null)
    {
      paramxv = paramxv.Etz;
      if (paramxv != null)
      {
        paramxv = (ddy)d.a.j.C((List)paramxv, 0);
        if (paramxv != null)
        {
          paramxv = paramxv.Fjh;
          localObject1 = ((dep)localObject2).FOc;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((ddp)localObject1).Etz;
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = (ddy)d.a.j.C((List)localObject1, 0);
          if (localObject1 == null) {
            break label444;
          }
          localObject1 = ((ddy)localObject1).Url;
          label248:
          localObject2 = ((dep)localObject2).FOc;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = ((ddp)localObject2).Etz;
          if (localObject2 == null) {
            break label450;
          }
          localObject2 = (ddy)d.a.j.C((List)localObject2, 0);
          if (localObject2 == null) {
            break label450;
          }
        }
      }
    }
    label444:
    label450:
    for (float f = ((ddy)localObject2).FNF;; f = 0.0F)
    {
      localObject2 = com.tencent.mm.plugin.story.f.k.zsq;
      com.tencent.mm.plugin.story.f.k.a(str, localj.field_storyID, localj.field_createTime, paramxv, (String)localObject1, (f * 1000.0F));
      ac.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ac.c.pb(l));
      paramxv = ztw.iterator();
      while (paramxv.hasNext()) {
        paramxv.next();
      }
      paramxv = null;
      break;
      localObject1 = null;
      break label248;
    }
    paramao.sendEmptyMessage(0);
    AppMethodBeat.o(118831);
    return true;
  }
  
  public static boolean e(xv paramxv, ao paramao)
  {
    AppMethodBeat.i(118832);
    d.g.b.k.h(paramxv, "item");
    d.g.b.k.h(paramao, "h");
    try
    {
      localObject1 = new del();
      paramxv = paramxv.ErM;
      d.g.b.k.g(paramxv, "item.CmdBuf");
      paramxv = ((del)localObject1).parseFrom(paramxv.getBuffer().toByteArray());
      if (paramxv == null)
      {
        paramxv = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118832);
        throw paramxv;
      }
    }
    catch (Exception paramxv)
    {
      ac.w(TAG, "StorySyncMsg parse error: " + paramxv.getMessage());
      AppMethodBeat.o(118832);
      return false;
    }
    paramxv = (del)paramxv;
    Object localObject1 = paramxv.FNZ.tlK;
    int i = paramxv.FNZ.CreateTime;
    long l = paramxv.Id;
    ac.i(TAG, "processStoryComment username:" + (String)localObject1 + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.c.pb(l));
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ztY;
    d.g.b.k.h(paramxv, "syncMsg");
    ac.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncComment " + paramxv.Id + ' ' + paramxv.FNZ.FIZ + ' ' + paramxv.FNZ.CreateTime);
    localObject1 = new v.f();
    Object localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    ((v.f)localObject1).KUQ = j.b.dVH().yv(paramxv.FNZ.Id);
    if ((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ == null)
    {
      ((v.f)localObject1).KUQ = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ).field_storyId = paramxv.Id;
    }
    com.tencent.mm.plugin.story.f.b.b.a(paramxv);
    if (((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ).field_readCommentTime == 0) {
      ((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ).field_readCommentTime = 1;
    }
    localObject2 = (com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ;
    String str = paramxv.FNZ.tlK;
    d.g.b.k.g(str, "syncMsg.SyncMsgDetail.FromUserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).awZ(str);
    localObject2 = (com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ;
    str = paramxv.FNZ.FNl.ncR;
    d.g.b.k.g(str, "syncMsg.SyncMsgDetail.StoryObject.UserName");
    ((com.tencent.mm.plugin.story.i.c)localObject2).awL(str);
    ((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ).field_syncCommentId = paramxv.FNZ.FIZ;
    ((com.tencent.mm.plugin.story.i.c)((v.f)localObject1).KUQ).field_syncCommentTime = paramxv.FNZ.CreateTime;
    paramxv = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVH().replace((com.tencent.mm.sdk.e.c)((v.f)localObject1).KUQ);
    com.tencent.mm.ac.c.g((d.g.a.a)new com.tencent.mm.plugin.story.f.b.b.a((v.f)localObject1));
    paramxv = ztw.iterator();
    while (paramxv.hasNext()) {
      paramxv.next();
    }
    paramao.sendEmptyMessage(0);
    AppMethodBeat.o(118832);
    return true;
  }
  
  public static boolean f(xv paramxv, ao paramao)
  {
    AppMethodBeat.i(118833);
    d.g.b.k.h(paramxv, "item");
    d.g.b.k.h(paramao, "h");
    try
    {
      localdel = new del();
      paramxv = paramxv.ErM;
      d.g.b.k.g(paramxv, "item.CmdBuf");
      paramxv = localdel.parseFrom(paramxv.getBuffer().toByteArray());
      if (paramxv == null)
      {
        paramxv = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118833);
        throw paramxv;
      }
    }
    catch (Exception paramxv)
    {
      ac.w(TAG, "StorySyncMsg parse error:  " + paramxv.getMessage());
      AppMethodBeat.o(118833);
      return false;
    }
    del localdel = (del)paramxv;
    paramxv = localdel.FNZ.tlK;
    int i = localdel.FNZ.CreateTime;
    long l = localdel.Id;
    ac.i(TAG, "processStoryVisit username:" + paramxv + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ac.c.pb(l));
    paramxv = com.tencent.mm.plugin.story.f.b.b.ztY;
    d.g.b.k.h(localdel, "syncMsg");
    boolean bool = com.tencent.mm.plugin.story.c.a.e.zqS.dUI();
    ac.i(com.tencent.mm.plugin.story.f.b.b.TAG, "addSyncVisit " + localdel.Id + ' ' + localdel.FNZ.FIZ + ' ' + localdel.FNZ.CreateTime + " enableVisit:" + bool);
    com.tencent.mm.plugin.story.f.b.b.a(localdel);
    v.f localf = new v.f();
    paramxv = com.tencent.mm.plugin.story.f.j.zsh;
    localf.KUQ = j.b.dVH().yv(localdel.FNZ.Id);
    if ((com.tencent.mm.plugin.story.i.c)localf.KUQ == null)
    {
      localf.KUQ = new com.tencent.mm.plugin.story.i.c();
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_storyId = localdel.Id;
    }
    Object localObject;
    if (((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_readCommentTime == 0)
    {
      if (!bs.isNullOrNil(localdel.FNZ.hkR)) {
        break label636;
      }
      paramxv = localdel.FNZ.FNl.FNQ;
      d.g.b.k.g(paramxv, "bubbleList");
      paramxv = (ddk)d.a.j.C((List)paramxv, paramxv.size() - 2);
      if (paramxv == null) {
        break label631;
      }
      paramxv = Integer.valueOf(paramxv.CreateTime);
      localObject = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
      if (paramxv == null) {
        break label694;
      }
    }
    label694:
    for (i = paramxv.intValue();; i = 1)
    {
      ((com.tencent.mm.plugin.story.i.c)localObject).field_readCommentTime = i;
      paramxv = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
      localObject = localdel.FNZ.tlK;
      d.g.b.k.g(localObject, "syncMsg.SyncMsgDetail.FromUserName");
      paramxv.awZ((String)localObject);
      paramxv = (com.tencent.mm.plugin.story.i.c)localf.KUQ;
      localObject = localdel.FNZ.FNl.ncR;
      d.g.b.k.g(localObject, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramxv.awL((String)localObject);
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_syncCommentId = localdel.FNZ.FIZ;
      ((com.tencent.mm.plugin.story.i.c)localf.KUQ).field_syncCommentTime = localdel.FNZ.CreateTime;
      paramxv = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVH().replace((com.tencent.mm.sdk.e.c)localf.KUQ);
      com.tencent.mm.ac.c.g((d.g.a.a)new b.b(localf));
      paramxv = ztw.iterator();
      while (paramxv.hasNext()) {
        paramxv.next();
      }
      label631:
      paramxv = null;
      break;
      label636:
      paramxv = localdel.FNZ.FNl.FNO;
      d.g.b.k.g(paramxv, "commentList");
      paramxv = (ddk)d.a.j.C((List)paramxv, paramxv.size() - 2);
      if (paramxv != null)
      {
        i = paramxv.CreateTime;
        paramxv = Integer.valueOf(i);
        break;
      }
      paramxv = null;
      break;
    }
    paramao.sendEmptyMessage(0);
    AppMethodBeat.o(118833);
    return true;
  }
  
  public static boolean g(xv paramxv, ao paramao)
  {
    AppMethodBeat.i(118834);
    d.g.b.k.h(paramxv, "item");
    d.g.b.k.h(paramao, "h");
    try
    {
      localObject = new del();
      paramxv = paramxv.ErM;
      d.g.b.k.g(paramxv, "item.CmdBuf");
      paramxv = ((del)localObject).parseFrom(paramxv.getBuffer().toByteArray());
      if (paramxv == null)
      {
        paramxv = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(118834);
        throw paramxv;
      }
    }
    catch (Exception paramxv)
    {
      ac.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(118834);
      return false;
    }
    paramxv = (del)paramxv;
    Object localObject = paramxv.FNZ.tlK;
    int i = paramxv.FNZ.CreateTime;
    long l = paramxv.Id;
    ac.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.f.b.b.ztY;
    d.g.b.k.h(paramxv, "syncMsg");
    ac.i(com.tencent.mm.plugin.story.f.b.b.TAG, "delSyncComment " + paramxv.Id + ' ' + paramxv.FNZ.FIZ);
    com.tencent.mm.plugin.story.f.b.b.j(paramxv.FNZ.Id, paramxv.FNZ.FIZ, paramxv.FNZ.hkR);
    com.tencent.mm.plugin.story.f.b.b.yk(paramxv.FNZ.Id);
    paramxv = ztw.iterator();
    while (paramxv.hasNext()) {
      paramxv.next();
    }
    paramao.sendEmptyMessage(0);
    AppMethodBeat.o(118834);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(118835);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    Object localObject1 = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject1, "MMKernel.storage()");
    Object localObject2 = bs.aLu(bs.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).agA().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.aBC();
    if (localObject2 == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(118835);
      throw parame;
    }
    ((den)localObject2).Eki = ((SKBuiltinBuffer_t)localObject1);
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
    ac.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118836);
      return;
    }
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(118836);
      throw paramString;
    }
    deo localdeo = (deo)paramq;
    paramq = localdeo.Ekl;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.ncM;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      paramq = new LinkedList();
    }
    if (paramq.size() > 0)
    {
      paramString = this.ztu;
      d.g.b.k.h(paramq, "cmdList");
      paramString.qrS = paramq;
      paramString.qJF.sendEmptyMessage(0);
      AppMethodBeat.o(118836);
      return;
    }
    if (localdeo.Eki != null)
    {
      paramq = localdeo.Eki;
      d.g.b.k.g(paramq, "resp.KeyBuf");
      if (paramq.getBuffer() != null)
      {
        paramq = localdeo.Eki;
        d.g.b.k.g(paramq, "resp.KeyBuf");
        paramq = paramq.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.aBC();
        if (paramArrayOfByte == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(118836);
          throw paramString;
        }
        paramq = ad.k(((den)paramArrayOfByte).Eki.getBuffer().toByteArray(), paramq);
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
        paramArrayOfByte = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.agA().set(8195, bs.cx(paramq));
      }
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
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
    return this.ztv;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "", "(Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;)V", "cmdList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "getCmdList", "()Ljava/util/LinkedList;", "setCmdList", "(Ljava/util/LinkedList;)V", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getH", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setH", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "delaWithCmdList", "", "plugin-story_release"})
  public final class b
  {
    ao qJF;
    LinkedList<xv> qrS;
    
    public b()
    {
      AppMethodBeat.i(118829);
      this.qJF = ((ao)new a(this));
      AppMethodBeat.o(118829);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler$h$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-story_release"})
    public static final class a
      extends ao
    {
      public final void handleMessage(final Message paramMessage)
      {
        AppMethodBeat.i(118828);
        d.g.b.k.h(paramMessage, "msg");
        if (!com.tencent.mm.kernel.g.agP().afY())
        {
          AppMethodBeat.o(118828);
          return;
        }
        if (this.ztz.qrS != null)
        {
          paramMessage = this.ztz.qrS;
          if (paramMessage == null) {
            d.g.b.k.fOy();
          }
          if (!paramMessage.isEmpty()) {}
        }
        else
        {
          paramMessage = this.ztz.zty;
          localObject1 = paramMessage.rr.aBD();
          if (localObject1 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject1 = (deo)localObject1;
          Object localObject2 = paramMessage.rr.aBC();
          if (localObject2 == null)
          {
            paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
            AppMethodBeat.o(118828);
            throw paramMessage;
          }
          localObject2 = (den)localObject2;
          byte[] arrayOfByte = ((deo)localObject1).Eki.getBuffer().toByteArray();
          arrayOfByte = ad.k(((den)localObject2).Eki.getBuffer().toByteArray(), arrayOfByte);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0))
          {
            com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(locale, "MMKernel.storage()");
            locale.agA().set(8195, bs.cx(arrayOfByte));
          }
          ((den)localObject2).Eki.setBuffer(arrayOfByte);
          if ((((deo)localObject1).EfS & ((den)localObject2).Ekh) == 0)
          {
            localObject1 = paramMessage.callback;
            if (localObject1 == null) {
              d.g.b.k.aVY("callback");
            }
            ((com.tencent.mm.ak.g)localObject1).onSceneEnd(0, 0, "", (com.tencent.mm.ak.n)paramMessage);
            AppMethodBeat.o(118828);
            return;
          }
          localObject1 = paramMessage.dispatcher();
          d.g.b.k.g(localObject1, "dispatcher()");
          localObject2 = paramMessage.callback;
          if (localObject2 == null) {
            d.g.b.k.aVY("callback");
          }
          paramMessage.doScene((com.tencent.mm.network.e)localObject1, (com.tencent.mm.ak.g)localObject2);
          AppMethodBeat.o(118828);
          return;
        }
        paramMessage = this.ztz.qrS;
        if (paramMessage == null) {
          d.g.b.k.fOy();
        }
        paramMessage = (xv)paramMessage.getFirst();
        ac.d(h.access$getTAG$cp(), "cmdId = " + paramMessage.ErL);
        Object localObject1 = this.ztz.qrS;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        ((LinkedList)localObject1).removeFirst();
        switch (paramMessage.ErL)
        {
        case 5: 
        case 6: 
        default: 
          sendEmptyMessage(0);
          AppMethodBeat.o(118828);
          return;
        case 1: 
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new a(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 2: 
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new b(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 3: 
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new c(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        case 7: 
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          j.b.dvq().post((Runnable)new d(this, paramMessage));
          AppMethodBeat.o(118828);
          return;
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dvq().post((Runnable)new e(this, paramMessage));
        AppMethodBeat.o(118828);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(h.b.a parama, xv paramxv) {}
        
        public final void run()
        {
          AppMethodBeat.i(118823);
          xv localxv = paramMessage;
          d.g.b.k.g(localxv, "item");
          if (!h.c(localxv, (ao)this.ztA)) {
            this.ztA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118823);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class b
        implements Runnable
      {
        b(h.b.a parama, xv paramxv) {}
        
        public final void run()
        {
          AppMethodBeat.i(118824);
          xv localxv = paramMessage;
          d.g.b.k.g(localxv, "item");
          if (!h.d(localxv, (ao)this.ztA)) {
            this.ztA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118824);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class c
        implements Runnable
      {
        c(h.b.a parama, xv paramxv) {}
        
        public final void run()
        {
          AppMethodBeat.i(118825);
          xv localxv = paramMessage;
          d.g.b.k.g(localxv, "item");
          if (!h.e(localxv, (ao)this.ztA)) {
            this.ztA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118825);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class d
        implements Runnable
      {
        d(h.b.a parama, xv paramxv) {}
        
        public final void run()
        {
          AppMethodBeat.i(118826);
          xv localxv = paramMessage;
          d.g.b.k.g(localxv, "item");
          if (!h.f(localxv, (ao)this.ztA)) {
            this.ztA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118826);
        }
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class e
        implements Runnable
      {
        e(h.b.a parama, xv paramxv) {}
        
        public final void run()
        {
          AppMethodBeat.i(118827);
          xv localxv = paramMessage;
          d.g.b.k.g(localxv, "item");
          if (!h.g(localxv, (ao)this.ztA)) {
            this.ztA.sendEmptyMessage(0);
          }
          AppMethodBeat.o(118827);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.h
 * JD-Core Version:    0.7.0.1
 */