package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.al.g callback;
  private long dAu;
  public int dzf;
  private final com.tencent.mm.al.b rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.dzf = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)new cyx());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)new cyy());
    ((b.a)localObject1).wg("/cgi-bin/micromsg-bin/mmstorypost");
    ((b.a)localObject1).nB(351);
    ((b.a)localObject1).nD(0);
    ((b.a)localObject1).nE(0);
    localObject1 = ((b.a)localObject1).atI();
    d.g.b.k.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject1);
    localObject1 = this.rr.auL();
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (cyx)localObject1;
    Object localObject2 = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(d.UTF_8);
    d.g.b.k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramString1);
    ((cyx)localObject1).EqL = ((SKBuiltinBuffer_t)localObject2);
    ((cyx)localObject1).gKn = paramString2;
    ((cyx)localObject1).CBT = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWU());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new cmf();
      ((cmf)localObject2).aEE(paramString2);
      ((cyx)localObject1).GroupUser.add(localObject2);
    }
    ((cyx)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new cmf();
      paramList1.aEE(paramString2);
      ((cyx)localObject1).BlackList.add(paramList1);
    }
    ((cyx)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, czd paramczd1, czd paramczd2)
  {
    AppMethodBeat.i(118821);
    if ((paramczd1 == null) || (paramczd2 == null) || (paramczd1.Era == null) || (paramczd2.Era == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str = paramczd2.mAQ;
    int i = 0;
    while ((i < paramczd1.Era.DaC.size()) && (i < paramczd2.Era.DaC.size()))
    {
      Object localObject3 = (cym)paramczd1.Era.DaC.get(i);
      Object localObject1 = (cym)paramczd2.Era.DaC.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject2 = com.tencent.mm.plugin.story.f.l.ars(((cym)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject3 = com.tencent.mm.plugin.story.f.l.art(((cym)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject4 = com.tencent.mm.plugin.story.f.l.jp(((cym)localObject1).Url, str);
      Object localObject5 = com.tencent.mm.plugin.story.f.l.yfu;
      localObject5 = com.tencent.mm.plugin.story.f.l.jq(((cym)localObject1).Url, str);
      ad.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      ad.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + (String)localObject5);
      i.aMF(i.aMQ((String)localObject5));
      i.lD((String)localObject2, (String)localObject4);
      i.lC((String)localObject3, (String)localObject5);
      localObject2 = s.ygj;
      d.g.b.k.g(localObject1, "mediaObjCnt");
      d.g.b.k.h(localObject1, "media");
      localObject2 = s.a((cym)localObject1, str);
      int j = (int)i.aMN((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
      if (j.b.dHh().tY(paramLong) == null)
      {
        localObject3 = new com.tencent.mm.plugin.story.i.n();
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_storyId = paramLong;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_url = ((cym)localObject1).Url;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_cacheSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHh().a((com.tencent.mm.plugin.story.i.n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(118819);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    ad.d(this.TAG, "doScene");
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
    ad.i(this.TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    cyy localcyy = (cyy)paramq;
    if (paramInt2 == 4)
    {
      paramq = com.tencent.mm.plugin.story.f.j.yfh;
      paramq = j.b.dHd().OI(this.dzf);
      if (paramq != null)
      {
        try
        {
          paramArrayOfByte = new cyn().parseFrom(paramq.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localcyy == null) {
          break label329;
        }
        paramArrayOfByte = localcyy.Eqj;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        paramq.field_storyID = l;
        paramq.dyb();
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHd().a(this.dzf, paramq);
        paramq = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHk().Mi(this.dzf);
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aPZ("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (cyn)paramArrayOfByte;
        paramArrayOfByte.DNw = paramInt3;
        paramArrayOfByte.EqG = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        d.g.b.k.g(paramArrayOfByte, "postinfo.toByteArray()");
        paramq.bE(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      paramq = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHk().Mi(this.dzf);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localcyy.Eqj == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localcyy.Eqj.EqL != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localcyy.Eqj.EqL.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      ad.i(paramq, bool);
      if ((localcyy.Eqj != null) && (localcyy.Eqj.EqL != null) && (localcyy.Eqj.EqL.getBuffer() != null)) {
        break label615;
      }
      ad.e(this.TAG, "err respone buffer is null ignore");
      paramq = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().Nf(this.dzf);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
      bool = false;
      break;
      bool = false;
      break label452;
    }
    label615:
    paramq = f.ymW;
    f.dJg();
    paramq = localcyy.Eqj.EqL.getBuffer().toByteArray();
    d.g.b.k.g(paramq, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    paramq = new String(paramq, d.UTF_8);
    ad.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(paramq)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.yfy;
    czd localczd = q.a.arA(paramq);
    if (localczd == null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = com.tencent.mm.plugin.story.f.j.yfh;
    paramArrayOfByte = j.b.dHd().OI(this.dzf);
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = new com.tencent.mm.plugin.story.i.j();
    }
    a(localcyy.Eqj.Id, paramq.dKH(), localczd);
    if (localcyy.Eqj.EqI == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.yor;
      paramq.OG(com.tencent.mm.plugin.story.i.a.dKh());
    }
    for (;;)
    {
      paramq.field_createTime = localcyy.Eqj.CreateTime;
      paramq.c(localczd);
      paramInt1 = paramq.field_localFlag;
      paramArrayOfByte = a.d.yoA;
      paramq.field_localFlag = (paramInt1 & (a.d.dKn() ^ 0xFFFFFFFF));
      paramq.field_storyID = localcyy.Eqj.Id;
      paramArrayOfByte = localcyy.Eqj;
      paramArrayOfByte.EqL.setBuffer(new byte[0]);
      this.dAu = localcyy.Eqj.Id;
      paramq.field_attrBuf = paramArrayOfByte.toByteArray();
      paramq.dya();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().tV(localcyy.Eqj.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHd().a(this.dzf, paramq);
      paramq = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHk().Mi(this.dzf);
      paramq = com.tencent.mm.plugin.story.f.j.yfh;
      j.b.dHj().checkPost();
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aPZ("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.yor;
      paramq.OH(com.tencent.mm.plugin.story.i.a.dKh());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */