package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.ak.f callback;
  public int dKr;
  private long dLI;
  private final com.tencent.mm.ak.b rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.dKr = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bw.a)new dkr());
    ((b.a)localObject1).d((com.tencent.mm.bw.a)new dks());
    ((b.a)localObject1).DN("/cgi-bin/micromsg-bin/mmstorypost");
    ((b.a)localObject1).oS(351);
    ((b.a)localObject1).oU(0);
    ((b.a)localObject1).oV(0);
    localObject1 = ((b.a)localObject1).aDS();
    p.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject1);
    localObject1 = this.rr.aEU();
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (dkr)localObject1;
    Object localObject2 = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramString1);
    ((dkr)localObject1).HSj = ((SKBuiltinBuffer_t)localObject2);
    ((dkr)localObject1).hFO = paramString2;
    ((dkr)localObject1).FSi = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new cxn();
      ((cxn)localObject2).aQV(paramString2);
      ((dkr)localObject1).GroupUser.add(localObject2);
    }
    ((dkr)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new cxn();
      paramList1.aQV(paramString2);
      ((dkr)localObject1).BlackList.add(paramList1);
    }
    ((dkr)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, dkx paramdkx1, dkx paramdkx2)
  {
    AppMethodBeat.i(118821);
    if ((paramdkx1 == null) || (paramdkx2 == null) || (paramdkx1.HSy == null) || (paramdkx2.HSy == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str = paramdkx2.nIJ;
    int i = 0;
    while ((i < paramdkx1.HSy.Gtx.size()) && (i < paramdkx2.HSy.Gtx.size()))
    {
      Object localObject3 = (dkg)paramdkx1.HSy.Gtx.get(i);
      Object localObject1 = (dkg)paramdkx2.HSy.Gtx.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject2 = com.tencent.mm.plugin.story.f.l.aCZ(((dkg)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject3 = com.tencent.mm.plugin.story.f.l.aDa(((dkg)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject4 = com.tencent.mm.plugin.story.f.l.kj(((dkg)localObject1).Url, str);
      Object localObject5 = com.tencent.mm.plugin.story.f.l.BbR;
      localObject5 = com.tencent.mm.plugin.story.f.l.kk(((dkg)localObject1).Url, str);
      ae.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      ae.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + (String)localObject5);
      com.tencent.mm.vfs.o.aZI(com.tencent.mm.vfs.o.aZU((String)localObject5));
      com.tencent.mm.vfs.o.mG((String)localObject2, (String)localObject4);
      com.tencent.mm.vfs.o.mF((String)localObject3, (String)localObject5);
      localObject2 = s.BcG;
      p.g(localObject1, "mediaObjCnt");
      p.h(localObject1, "media");
      localObject2 = s.a((dkg)localObject1, str);
      int j = (int)com.tencent.mm.vfs.o.aZR((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
      if (j.b.elF().Bx(paramLong) == null)
      {
        localObject3 = new com.tencent.mm.plugin.story.i.n();
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_storyId = paramLong;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_url = ((dkg)localObject1).Url;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_cacheSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elF().a((com.tencent.mm.plugin.story.i.n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(118819);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    ae.d(this.TAG, "doScene");
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118819);
    return i;
  }
  
  public final int getType()
  {
    return 351;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118820);
    ae.i(this.TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    dks localdks = (dks)paramq;
    if (paramInt2 == 4)
    {
      paramq = com.tencent.mm.plugin.story.f.j.BbE;
      paramq = j.b.elB().Te(this.dKr);
      if (paramq != null)
      {
        try
        {
          paramArrayOfByte = new dkh().parseFrom(paramq.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localdks == null) {
          break label329;
        }
        paramArrayOfByte = localdks.HRH;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        paramq.field_storyID = l;
        paramq.ecs();
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elB().a(this.dKr, paramq);
        paramq = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elI().Qy(this.dKr);
        paramq = this.callback;
        if (paramq == null) {
          p.bdF("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (dkh)paramArrayOfByte;
        paramArrayOfByte.HmP = paramInt3;
        paramArrayOfByte.HSe = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        p.g(paramArrayOfByte, "postinfo.toByteArray()");
        paramq.bN(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      paramq = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elI().Qy(this.dKr);
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localdks.HRH == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localdks.HRH.HSj != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localdks.HRH.HSj.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      ae.i(paramq, bool);
      if ((localdks.HRH != null) && (localdks.HRH.HSj != null) && (localdks.HRH.HSj.getBuffer() != null)) {
        break label615;
      }
      ae.e(this.TAG, "err respone buffer is null ignore");
      paramq = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().Rx(this.dKr);
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
      bool = false;
      break;
      bool = false;
      break label452;
    }
    label615:
    paramq = com.tencent.mm.plugin.story.h.f.Bjs;
    com.tencent.mm.plugin.story.h.f.enF();
    paramq = localdks.HRH.HSj.getBuffer().toByteArray();
    p.g(paramq, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    paramq = new String(paramq, d.UTF_8);
    ae.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(paramq)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.BbV;
    dkx localdkx = q.a.aDg(paramq);
    if (localdkx == null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = com.tencent.mm.plugin.story.f.j.BbE;
    paramArrayOfByte = j.b.elB().Te(this.dKr);
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = new com.tencent.mm.plugin.story.i.j();
    }
    a(localdks.HRH.Id, paramq.epg(), localdkx);
    if (localdks.HRH.HSg == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.BkN;
      paramq.Tc(com.tencent.mm.plugin.story.i.a.eoG());
    }
    for (;;)
    {
      paramq.field_createTime = localdks.HRH.CreateTime;
      paramq.c(localdkx);
      paramInt1 = paramq.field_localFlag;
      paramArrayOfByte = a.d.BkW;
      paramq.field_localFlag = (paramInt1 & (a.d.eoM() ^ 0xFFFFFFFF));
      paramq.field_storyID = localdks.HRH.Id;
      paramArrayOfByte = localdks.HRH;
      paramArrayOfByte.HSj.setBuffer(new byte[0]);
      this.dLI = localdks.HRH.Id;
      paramq.field_attrBuf = paramArrayOfByte.toByteArray();
      paramq.ecr();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().Bu(localdks.HRH.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elB().a(this.dKr, paramq);
      paramq = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elI().Qy(this.dKr);
      paramq = com.tencent.mm.plugin.story.f.j.BbE;
      j.b.elH().checkPost();
      paramq = this.callback;
      if (paramq == null) {
        p.bdF("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.BkN;
      paramq.Td(com.tencent.mm.plugin.story.i.a.eoG());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */