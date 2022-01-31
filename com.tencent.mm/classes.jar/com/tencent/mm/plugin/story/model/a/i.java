package com.tencent.mm.plugin.story.model.a;

import a.f.b.u.d;
import a.l;
import a.v;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.story.h.a.b;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.n;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "selector", "", "(I)V", "MAX_SYNC_COUNT", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "respHandler", "Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStorySync$RespHandler;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "processEnd", "processStoryComment", "", "item", "Lcom/tencent/mm/protocal/protobuf/CmdItem;", "h", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "processStoryCommentDel", "processStoryPost", "processStoryPostDel", "securityLimitCount", "securityVerificationChecked", "Lcom/tencent/mm/modelbase/NetSceneBase$SecurityCheckStatus;", "Companion", "RespHandler", "plugin-story_release"})
public final class i
  extends m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
  private static final LinkedList<Object> sxm;
  public static final i.a sxn;
  f callback;
  final com.tencent.mm.ai.b rr;
  private i.b sxk;
  private final int sxl;
  
  static
  {
    AppMethodBeat.i(109253);
    sxn = new i.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStorySync";
    sxm = new LinkedList();
    AppMethodBeat.o(109253);
  }
  
  public i()
  {
    AppMethodBeat.i(109252);
    this.sxk = new i.b(this);
    this.sxl = 10;
    Object localObject = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject).a((com.tencent.mm.bv.a)new cia());
    ((com.tencent.mm.ai.b.a)localObject).b((com.tencent.mm.bv.a)new cib());
    ((com.tencent.mm.ai.b.a)localObject).rl("/cgi-bin/micromsg-bin/mmstorysync");
    ((com.tencent.mm.ai.b.a)localObject).kT(513);
    ((com.tencent.mm.ai.b.a)localObject).kU(0);
    ((com.tencent.mm.ai.b.a)localObject).kV(0);
    localObject = ((com.tencent.mm.ai.b.a)localObject).ado();
    a.f.b.j.p(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ai.b)localObject);
    localObject = this.rr.adm();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(109252);
      throw ((Throwable)localObject);
    }
    ((cia)localObject).wFQ = 128;
    AppMethodBeat.o(109252);
  }
  
  public static boolean c(ud paramud, ak paramak)
  {
    AppMethodBeat.i(109245);
    a.f.b.j.q(paramud, "item");
    a.f.b.j.q(paramak, "h");
    try
    {
      localObject1 = new chy();
      paramud = paramud.wMD;
      a.f.b.j.p(paramud, "item.CmdBuf");
      paramud = ((chy)localObject1).parseFrom(paramud.getBuffer().toByteArray());
      if (paramud == null)
      {
        paramud = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(109245);
        throw paramud;
      }
    }
    catch (Exception paramud)
    {
      com.tencent.mm.sdk.platformtools.ab.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(109245);
      return false;
    }
    paramud = (chy)paramud;
    Object localObject1 = paramud.xSH.num;
    int i = paramud.xSH.CreateTime;
    long l = paramud.Id;
    Object localObject2 = n.svx;
    a.f.b.j.p(localObject1, "username");
    com.tencent.mm.plugin.story.h.j localj = n.a.a((String)localObject1, l, i, paramud.xSH.xRP, false);
    localObject2 = com.tencent.mm.plugin.story.model.k.svr;
    com.tencent.mm.plugin.story.model.k.a((String)localObject1, localj);
    localObject1 = TAG;
    localObject2 = new StringBuilder("processStoryPost username:").append(paramud.xSH.num).append(" createTime:").append(paramud.xSH.CreateTime).append(" id:").append(paramud.Id).append(" scope:");
    if (localj != null)
    {
      paramud = localj.cEY();
      if (paramud == null) {}
    }
    for (paramud = Integer.valueOf(paramud.xSM);; paramud = null)
    {
      com.tencent.mm.sdk.platformtools.ab.i((String)localObject1, paramud);
      paramud = sxm.iterator();
      while (paramud.hasNext()) {
        paramud.next();
      }
    }
    paramak.sendEmptyMessage(0);
    AppMethodBeat.o(109245);
    return true;
  }
  
  public static boolean d(ud paramud, ak paramak)
  {
    AppMethodBeat.i(109246);
    a.f.b.j.q(paramud, "item");
    a.f.b.j.q(paramak, "h");
    try
    {
      localObject1 = new chy();
      paramud = paramud.wMD;
      a.f.b.j.p(paramud, "item.CmdBuf");
      paramud = ((chy)localObject1).parseFrom(paramud.getBuffer().toByteArray());
      if (paramud == null)
      {
        paramud = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(109246);
        throw paramud;
      }
    }
    catch (Exception paramud)
    {
      com.tencent.mm.sdk.platformtools.ab.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(109246);
      return false;
    }
    paramud = (chy)paramud;
    String str = paramud.xSH.num;
    int i = paramud.xSH.CreateTime;
    long l = paramud.Id;
    paramud = n.svx;
    a.f.b.j.p(str, "username");
    n.a.a(str, l, i, null, true);
    paramud = n.svx;
    a.f.b.j.q(str, "username");
    paramud = com.tencent.mm.plugin.story.model.j.svi;
    Object localObject1 = j.b.cAB();
    paramud = com.tencent.mm.plugin.story.model.j.svi;
    boolean bool = bo.isEqual(j.b.coK(), str);
    a.f.b.j.q(str, "userName");
    com.tencent.mm.plugin.story.h.j localj = new com.tencent.mm.plugin.story.h.j();
    paramud = "select *,rowid from MMStoryInfo " + com.tencent.mm.plugin.story.h.k.bs(str, bool);
    Object localObject2 = new StringBuilder().append(paramud);
    if (bool)
    {
      paramud = com.tencent.mm.plugin.story.h.k.rDl;
      paramud = paramud;
      paramud = paramud + " limit 1";
      paramud = ((com.tencent.mm.plugin.story.h.k)localObject1).db.a(paramud, null, 2);
      if (paramud.moveToFirst())
      {
        a.f.b.j.p(paramud, "cu");
        localj.convertFrom(paramud);
      }
      paramud.close();
      localObject2 = localj.cEY();
      paramud = ((cic)localObject2).xSK;
      if (paramud == null) {
        break label627;
      }
      paramud = paramud.wOa;
      if (paramud == null) {
        break label627;
      }
      paramud = (chl)a.a.j.w((List)paramud, 0);
      if (paramud == null) {
        break label627;
      }
      paramud = paramud.xrS;
      label357:
      localObject1 = ((cic)localObject2).xSK;
      if (localObject1 == null) {
        break label632;
      }
      localObject1 = ((chb)localObject1).wOa;
      if (localObject1 == null) {
        break label632;
      }
      localObject1 = (chl)a.a.j.w((List)localObject1, 0);
      if (localObject1 == null) {
        break label632;
      }
      localObject1 = ((chl)localObject1).Url;
      label407:
      localObject2 = ((cic)localObject2).xSK;
      if (localObject2 == null) {
        break label638;
      }
      localObject2 = ((chb)localObject2).wOa;
      if (localObject2 == null) {
        break label638;
      }
      localObject2 = (chl)a.a.j.w((List)localObject2, 0);
      if (localObject2 == null) {
        break label638;
      }
    }
    label627:
    label632:
    label638:
    for (float f = ((chl)localObject2).duration;; f = 0.0F)
    {
      localObject2 = com.tencent.mm.plugin.story.model.k.svr;
      com.tencent.mm.plugin.story.model.k.a(str, localj.field_storyID, localj.field_createTime, paramud, (String)localObject1, (f * 1000.0F));
      com.tencent.mm.sdk.platformtools.ab.i(TAG, "processStoryPostDel username:" + str + " createTime:" + i + " id:" + l + " lastCreateTime:" + localj.field_createTime + " lastId:" + localj.field_storyID + "   ulonglong " + com.tencent.mm.ab.b.gj(l));
      paramud = sxm.iterator();
      while (paramud.hasNext()) {
        paramud.next();
      }
      paramud = " AND " + com.tencent.mm.plugin.story.h.k.sGU + com.tencent.mm.plugin.story.h.k.rDl;
      break;
      paramud = null;
      break label357;
      localObject1 = null;
      break label407;
    }
    paramak.sendEmptyMessage(0);
    AppMethodBeat.o(109246);
    return true;
  }
  
  public static boolean e(ud paramud, ak paramak)
  {
    AppMethodBeat.i(109247);
    a.f.b.j.q(paramud, "item");
    a.f.b.j.q(paramak, "h");
    try
    {
      localObject1 = new chy();
      paramud = paramud.wMD;
      a.f.b.j.p(paramud, "item.CmdBuf");
      paramud = ((chy)localObject1).parseFrom(paramud.getBuffer().toByteArray());
      if (paramud == null)
      {
        paramud = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(109247);
        throw paramud;
      }
    }
    catch (Exception paramud)
    {
      com.tencent.mm.sdk.platformtools.ab.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(109247);
      return false;
    }
    Object localObject2 = (chy)paramud;
    paramud = ((chy)localObject2).xSH.num;
    int i = ((chy)localObject2).xSH.CreateTime;
    long l = ((chy)localObject2).Id;
    com.tencent.mm.sdk.platformtools.ab.i(TAG, "processStoryComment username:" + paramud + " createTime:" + i + " id:" + l + " ulonglong " + com.tencent.mm.ab.b.gj(l));
    paramud = com.tencent.mm.plugin.story.model.b.b.sxN;
    a.f.b.j.q(localObject2, "syncMsg");
    com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.story.model.b.b.TAG, "addSyncComment " + ((chy)localObject2).Id + ' ' + ((chy)localObject2).xSH.xNY + ' ' + ((chy)localObject2).xSH.CreateTime);
    Object localObject1 = new u.d();
    paramud = com.tencent.mm.plugin.story.model.j.svi;
    ((u.d)localObject1).BNq = j.b.cAE().mP(((chy)localObject2).xSH.Id);
    if ((com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq == null)
    {
      ((u.d)localObject1).BNq = new com.tencent.mm.plugin.story.h.c();
      ((com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq).field_storyId = ((chy)localObject2).Id;
    }
    com.tencent.mm.plugin.story.model.b.b.a((chy)localObject2);
    Object localObject3;
    if (((com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq).field_readCommentTime == 0)
    {
      if (!bo.isNullOrNil(((chy)localObject2).xSH.ntu)) {
        break label627;
      }
      paramud = ((chy)localObject2).xSH.xRP.xSA;
      a.f.b.j.p(paramud, "bubbleList");
      paramud = (cgw)a.a.j.w((List)paramud, paramud.size() - 2);
      if (paramud == null) {
        break label622;
      }
      paramud = Integer.valueOf(paramud.CreateTime);
      localObject3 = (com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq;
      if (paramud == null) {
        break label685;
      }
    }
    label685:
    for (i = paramud.intValue();; i = 1)
    {
      ((com.tencent.mm.plugin.story.h.c)localObject3).field_readCommentTime = i;
      paramud = (com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq;
      localObject3 = ((chy)localObject2).xSH.num;
      a.f.b.j.p(localObject3, "syncMsg.SyncMsgDetail.FromUserName");
      paramud.adx((String)localObject3);
      paramud = (com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq;
      localObject3 = ((chy)localObject2).xSH.xRP.jJA;
      a.f.b.j.p(localObject3, "syncMsg.SyncMsgDetail.StoryObject.UserName");
      paramud.adk((String)localObject3);
      ((com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq).field_syncCommentId = ((chy)localObject2).xSH.xNY;
      ((com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq).field_syncCommentTime = ((chy)localObject2).xSH.CreateTime;
      paramud = (com.tencent.mm.plugin.story.h.c)((u.d)localObject1).BNq;
      i = paramud.field_commentFlag;
      localObject2 = a.b.sFX;
      paramud.field_commentFlag = (i | a.b.cEw());
      paramud = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAE().replace((com.tencent.mm.sdk.e.c)((u.d)localObject1).BNq);
      com.tencent.mm.ab.b.b((a.f.a.a)new com.tencent.mm.plugin.story.model.b.b.a((u.d)localObject1));
      paramud = sxm.iterator();
      while (paramud.hasNext()) {
        paramud.next();
      }
      label622:
      paramud = null;
      break;
      label627:
      paramud = ((chy)localObject2).xSH.xRP.xSy;
      a.f.b.j.p(paramud, "commentList");
      paramud = (cgw)a.a.j.w((List)paramud, paramud.size() - 2);
      if (paramud != null)
      {
        i = paramud.CreateTime;
        paramud = Integer.valueOf(i);
        break;
      }
      paramud = null;
      break;
    }
    paramak.sendEmptyMessage(0);
    AppMethodBeat.o(109247);
    return true;
  }
  
  public static boolean f(ud paramud, ak paramak)
  {
    AppMethodBeat.i(109248);
    a.f.b.j.q(paramud, "item");
    a.f.b.j.q(paramak, "h");
    try
    {
      localObject = new chy();
      paramud = paramud.wMD;
      a.f.b.j.p(paramud, "item.CmdBuf");
      paramud = ((chy)localObject).parseFrom(paramud.getBuffer().toByteArray());
      if (paramud == null)
      {
        paramud = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncMsg");
        AppMethodBeat.o(109248);
        throw paramud;
      }
    }
    catch (Exception paramud)
    {
      com.tencent.mm.sdk.platformtools.ab.w(TAG, "StorySyncMsg parse error!");
      AppMethodBeat.o(109248);
      return false;
    }
    paramud = (chy)paramud;
    Object localObject = paramud.xSH.num;
    int i = paramud.xSH.CreateTime;
    long l = paramud.Id;
    com.tencent.mm.sdk.platformtools.ab.i(TAG, "processStoryCommentDel username:" + (String)localObject + " createTime:" + i + " id:" + l);
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    a.f.b.j.q(paramud, "syncMsg");
    com.tencent.mm.sdk.platformtools.ab.i(com.tencent.mm.plugin.story.model.b.b.TAG, "delSyncComment " + paramud.Id + ' ' + paramud.xSH.xNY);
    com.tencent.mm.plugin.story.model.b.b.g(paramud.xSH.Id, paramud.xSH.xNY, paramud.xSH.ntu);
    com.tencent.mm.plugin.story.model.b.b.mz(paramud.xSH.Id);
    paramud = sxm.iterator();
    while (paramud.hasNext()) {
      paramud.next();
    }
    paramak.sendEmptyMessage(0);
    AppMethodBeat.o(109248);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109250);
    a.f.b.j.q(parame, "dispatcher");
    a.f.b.j.q(paramf, "callback");
    Object localObject1 = g.RL();
    a.f.b.j.p(localObject1, "MMKernel.storage()");
    Object localObject2 = bo.apQ(bo.nullAsNil((String)((com.tencent.mm.kernel.e)localObject1).Ru().get(8195)));
    localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = this.rr.adm();
    if (localObject2 == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
      AppMethodBeat.o(109250);
      throw parame;
    }
    ((cia)localObject2).wFR = ((SKBuiltinBuffer_t)localObject1);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109250);
    return i;
  }
  
  public final int getType()
  {
    return 513;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109251);
    com.tencent.mm.sdk.platformtools.ab.d(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109251);
      return;
    }
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncResponse");
      AppMethodBeat.o(109251);
      throw paramString;
    }
    cib localcib = (cib)paramq;
    paramq = localcib.wFU;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.jJv;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte != null) {}
    }
    else
    {
      paramq = new LinkedList();
    }
    if (paramq.size() > 0)
    {
      paramString = this.sxk;
      a.f.b.j.q(paramq, "cmdList");
      paramString.mcO = paramq;
      paramString.mur.sendEmptyMessage(0);
      AppMethodBeat.o(109251);
      return;
    }
    if (localcib.wFR != null)
    {
      paramq = localcib.wFR;
      a.f.b.j.p(paramq, "resp.KeyBuf");
      if (paramq.getBuffer() != null)
      {
        paramq = localcib.wFR;
        a.f.b.j.p(paramq, "resp.KeyBuf");
        paramq = paramq.getBuffer().toByteArray();
        paramArrayOfByte = this.rr.adm();
        if (paramArrayOfByte == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StorySyncRequest");
          AppMethodBeat.o(109251);
          throw paramString;
        }
        paramq = com.tencent.mm.protocal.ab.j(((cia)paramArrayOfByte).wFR.getBuffer().toByteArray(), paramq);
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
        paramArrayOfByte = g.RL();
        a.f.b.j.p(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.Ru().set(8195, bo.cg(paramq));
      }
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109251);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final int securityLimitCount()
  {
    return this.sxl;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.i
 * JD-Core Version:    0.7.0.1
 */