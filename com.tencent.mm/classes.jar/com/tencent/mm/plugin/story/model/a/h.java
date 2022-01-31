package com.tencent.mm.plugin.story.model.a;

import a.l.d;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.story.g.g;
import com.tencent.mm.plugin.story.h.a.d;
import com.tencent.mm.plugin.story.h.n;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.g.c;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class h
  extends m
  implements com.tencent.mm.network.k
{
  private final String TAG;
  public int cIp;
  private long cJA;
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109238);
    this.cIp = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject = new b.a();
    ((b.a)localObject).a((com.tencent.mm.bv.a)new chw());
    ((b.a)localObject).b((com.tencent.mm.bv.a)new chx());
    ((b.a)localObject).rl("/cgi-bin/micromsg-bin/mmstorypost");
    ((b.a)localObject).kT(351);
    ((b.a)localObject).kU(0);
    ((b.a)localObject).kV(0);
    localObject = ((b.a)localObject).ado();
    a.f.b.j.p(localObject, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ai.b)localObject);
    localObject = this.rr.adm();
    if (localObject == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(109238);
      throw paramString1;
    }
    localObject = (chw)localObject;
    SKBuiltinBuffer_t localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(d.UTF_8);
    a.f.b.j.p(paramString1, "(this as java.lang.String).getBytes(charset)");
    localSKBuiltinBuffer_t.setBuffer(paramString1);
    ((chw)localObject).xSx = localSKBuiltinBuffer_t;
    ((chw)localObject).pIw = paramString2;
    ((chw)localObject).wsr = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.bXq());
    AppMethodBeat.o(109238);
  }
  
  private final boolean a(long paramLong, cic paramcic1, cic paramcic2)
  {
    AppMethodBeat.i(109237);
    if ((paramcic1 == null) || (paramcic2 == null) || (paramcic1.xSK == null) || (paramcic2.xSK == null))
    {
      AppMethodBeat.o(109237);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.getAccStoryPath();
    localObject1 = paramcic2.jJA;
    int i = 0;
    while ((i < paramcic1.xSK.wOa.size()) && (i < paramcic2.xSK.wOa.size()))
    {
      Object localObject4 = (chl)paramcic1.xSK.wOa.get(i);
      Object localObject2 = (chl)paramcic2.xSK.wOa.get(i);
      Object localObject3 = com.tencent.mm.plugin.story.model.l.svv;
      localObject3 = com.tencent.mm.plugin.story.model.l.acX(((chl)localObject4).Id);
      Object localObject5 = com.tencent.mm.plugin.story.model.l.svv;
      localObject4 = com.tencent.mm.plugin.story.model.l.acY(((chl)localObject4).Id);
      localObject5 = com.tencent.mm.plugin.story.model.l.svv;
      localObject5 = com.tencent.mm.plugin.story.model.l.gM(((chl)localObject2).Url, (String)localObject1);
      Object localObject6 = com.tencent.mm.plugin.story.model.l.svv;
      localObject6 = com.tencent.mm.plugin.story.model.l.gN(((chl)localObject2).Url, (String)localObject1);
      ab.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + (String)localObject5);
      ab.d(this.TAG, "updateMediaFileName " + (String)localObject4 + " to " + (String)localObject6);
      com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK((String)localObject6));
      com.tencent.mm.vfs.e.aT((String)localObject3, (String)localObject5);
      com.tencent.mm.vfs.e.C((String)localObject4, (String)localObject6);
      localObject3 = s.swk;
      a.f.b.j.p(localObject2, "mediaObjCnt");
      a.f.b.j.q(localObject2, "media");
      localObject3 = s.a((chl)localObject2, (String)localObject1);
      int j = (int)com.tencent.mm.vfs.e.avI((String)localObject3);
      localObject4 = com.tencent.mm.plugin.story.model.j.svi;
      if (j.b.cAF().mX(paramLong) == null)
      {
        localObject4 = new n();
        ((n)localObject4).field_storyId = paramLong;
        ((n)localObject4).field_url = ((chl)localObject2).Url;
        ((n)localObject4).field_cacheSize = j;
        ((n)localObject4).field_totalSize = j;
        ((n)localObject4).field_filePath = ((String)localObject3);
        localObject2 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAF().a((n)localObject4);
      }
      i += 1;
    }
    AppMethodBeat.o(109237);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(109235);
    a.f.b.j.q(parame, "dispatcher");
    a.f.b.j.q(paramf, "callback");
    this.callback = paramf;
    ab.d(this.TAG, "doScene");
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109235);
    return i;
  }
  
  public final int getType()
  {
    return 351;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109236);
    ab.i(this.TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(109236);
      throw paramString;
    }
    chx localchx = (chx)paramq;
    if (paramInt2 == 4)
    {
      paramq = com.tencent.mm.plugin.story.model.j.svi;
      paramq = j.b.cAB().Gb(this.cIp);
      if (paramq != null)
      {
        try
        {
          paramArrayOfByte = new chm().parseFrom(paramq.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(109236);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localchx == null) {
          break label329;
        }
        paramArrayOfByte = localchx.xRP;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        paramq.field_storyID = l;
        paramq.csL();
        paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAB().a(this.cIp, paramq);
        paramq = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAJ().DI(this.cIp);
        paramq = this.callback;
        if (paramq == null) {
          a.f.b.j.ays("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
        AppMethodBeat.o(109236);
        return;
        paramArrayOfByte = (chm)paramArrayOfByte;
        paramArrayOfByte.xsx = paramInt3;
        paramArrayOfByte.xSs = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        a.f.b.j.p(paramArrayOfByte, "postinfo.toByteArray()");
        paramq.bl(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      paramq = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAJ().DI(this.cIp);
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109236);
      return;
    }
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localchx.xRP == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localchx.xRP.xSx != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localchx.xRP.xSx.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      ab.i(paramq, bool);
      if ((localchx.xRP != null) && (localchx.xRP.xSx != null) && (localchx.xRP.xSx.getBuffer() != null)) {
        break label615;
      }
      ab.e(this.TAG, "err respone buffer is null ignore");
      paramq = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().EA(this.cIp);
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109236);
      return;
      bool = false;
      break;
      bool = false;
      break label452;
    }
    label615:
    paramq = g.sEy;
    g.cDe();
    paramq = localchx.xRP.xSx.getBuffer().toByteArray();
    a.f.b.j.p(paramq, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    paramq = new String(paramq, d.UTF_8);
    ab.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(paramq)));
    paramArrayOfByte = com.tencent.mm.plugin.story.model.q.svz;
    cic localcic = q.a.adi(paramq);
    if (localcic == null)
    {
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109236);
      return;
    }
    paramq = com.tencent.mm.plugin.story.model.j.svi;
    paramArrayOfByte = j.b.cAB().Gb(this.cIp);
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = new com.tencent.mm.plugin.story.h.j();
    }
    a(localchx.xRP.Id, paramq.cEY(), localcic);
    if (localchx.xRP.xSu == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.h.a.sFV;
      paramq.FZ(com.tencent.mm.plugin.story.h.a.cEq());
    }
    for (;;)
    {
      paramq.field_createTime = localchx.xRP.CreateTime;
      paramq.c(localcic);
      paramInt1 = paramq.field_localFlag;
      paramArrayOfByte = a.d.sGd;
      paramq.field_localFlag = (paramInt1 & (a.d.cEy() ^ 0xFFFFFFFF));
      paramq.field_storyID = localchx.xRP.Id;
      paramArrayOfByte = localchx.xRP;
      paramArrayOfByte.xSx.setBuffer(new byte[0]);
      this.cJA = localchx.xRP.Id;
      paramq.field_attrBuf = paramArrayOfByte.toByteArray();
      paramq.csK();
      paramArrayOfByte = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAB().a(this.cIp, paramq);
      paramq = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAJ().DI(this.cIp);
      paramq = com.tencent.mm.plugin.story.model.j.svi;
      j.b.cAI().checkPost();
      paramq = this.callback;
      if (paramq == null) {
        a.f.b.j.ays("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(109236);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.h.a.sFV;
      paramq.Ga(com.tencent.mm.plugin.story.h.a.cEq());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.h
 * JD-Core Version:    0.7.0.1
 */