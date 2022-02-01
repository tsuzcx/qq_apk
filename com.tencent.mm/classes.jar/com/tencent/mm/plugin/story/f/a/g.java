package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.al.f callback;
  public int dJd;
  private long dKt;
  private final com.tencent.mm.al.b rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.dJd = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)new djw());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)new djx());
    ((b.a)localObject1).Dl("/cgi-bin/micromsg-bin/mmstorypost");
    ((b.a)localObject1).oP(351);
    ((b.a)localObject1).oR(0);
    ((b.a)localObject1).oS(0);
    localObject1 = ((b.a)localObject1).aDC();
    p.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.al.b)localObject1);
    localObject1 = this.rr.aEE();
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (djw)localObject1;
    Object localObject2 = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(d.UTF_8);
    p.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramString1);
    ((djw)localObject1).Hyy = ((SKBuiltinBuffer_t)localObject2);
    ((djw)localObject1).hCW = paramString2;
    ((djw)localObject1).FzK = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duO());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new cwt();
      ((cwt)localObject2).aPy(paramString2);
      ((djw)localObject1).GroupUser.add(localObject2);
    }
    ((djw)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new cwt();
      paramList1.aPy(paramString2);
      ((djw)localObject1).BlackList.add(paramList1);
    }
    ((djw)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, dkc paramdkc1, dkc paramdkc2)
  {
    AppMethodBeat.i(118821);
    if ((paramdkc1 == null) || (paramdkc2 == null) || (paramdkc1.HyN == null) || (paramdkc2.HyN == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str = paramdkc2.nDo;
    int i = 0;
    while ((i < paramdkc1.HyN.GaQ.size()) && (i < paramdkc2.HyN.GaQ.size()))
    {
      Object localObject3 = (djl)paramdkc1.HyN.GaQ.get(i);
      Object localObject1 = (djl)paramdkc2.HyN.GaQ.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject2 = com.tencent.mm.plugin.story.f.l.aBG(((djl)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject3 = com.tencent.mm.plugin.story.f.l.aBH(((djl)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject4 = com.tencent.mm.plugin.story.f.l.kc(((djl)localObject1).Url, str);
      Object localObject5 = com.tencent.mm.plugin.story.f.l.AKo;
      localObject5 = com.tencent.mm.plugin.story.f.l.kd(((djl)localObject1).Url, str);
      ad.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      ad.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + (String)localObject5);
      i.aYg(i.aYr((String)localObject5));
      i.mA((String)localObject2, (String)localObject4);
      i.mz((String)localObject3, (String)localObject5);
      localObject2 = s.ALd;
      p.g(localObject1, "mediaObjCnt");
      p.h(localObject1, "media");
      localObject2 = s.a((djl)localObject1, str);
      int j = (int)i.aYo((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
      if (j.b.ehX().AZ(paramLong) == null)
      {
        localObject3 = new com.tencent.mm.plugin.story.i.n();
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_storyId = paramLong;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_url = ((djl)localObject1).Url;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_cacheSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehX().a((com.tencent.mm.plugin.story.i.n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(118819);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
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
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    djx localdjx = (djx)paramq;
    if (paramInt2 == 4)
    {
      paramq = com.tencent.mm.plugin.story.f.j.AKb;
      paramq = j.b.ehT().Sx(this.dJd);
      if (paramq != null)
      {
        try
        {
          paramArrayOfByte = new djm().parseFrom(paramq.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localdjx == null) {
          break label329;
        }
        paramArrayOfByte = localdjx.HxW;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        paramq.field_storyID = l;
        paramq.dYO();
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehT().a(this.dJd, paramq);
        paramq = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.eia().PR(this.dJd);
        paramq = this.callback;
        if (paramq == null) {
          p.bcb("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (djm)paramArrayOfByte;
        paramArrayOfByte.GTo = paramInt3;
        paramArrayOfByte.Hyt = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        p.g(paramArrayOfByte, "postinfo.toByteArray()");
        paramq.bK(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      paramq = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.eia().PR(this.dJd);
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localdjx.HxW == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localdjx.HxW.Hyy != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localdjx.HxW.Hyy.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      ad.i(paramq, bool);
      if ((localdjx.HxW != null) && (localdjx.HxW.Hyy != null) && (localdjx.HxW.Hyy.getBuffer() != null)) {
        break label615;
      }
      ad.e(this.TAG, "err respone buffer is null ignore");
      paramq = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().QQ(this.dJd);
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
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
    paramq = com.tencent.mm.plugin.story.h.f.ARU;
    com.tencent.mm.plugin.story.h.f.ejW();
    paramq = localdjx.HxW.Hyy.getBuffer().toByteArray();
    p.g(paramq, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    paramq = new String(paramq, d.UTF_8);
    ad.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(paramq)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.AKs;
    dkc localdkc = q.a.aBN(paramq);
    if (localdkc == null)
    {
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = com.tencent.mm.plugin.story.f.j.AKb;
    paramArrayOfByte = j.b.ehT().Sx(this.dJd);
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = new com.tencent.mm.plugin.story.i.j();
    }
    a(localdjx.HxW.Id, paramq.elx(), localdkc);
    if (localdjx.HxW.Hyv == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.ATp;
      paramq.Sv(com.tencent.mm.plugin.story.i.a.ekX());
    }
    for (;;)
    {
      paramq.field_createTime = localdjx.HxW.CreateTime;
      paramq.c(localdkc);
      paramInt1 = paramq.field_localFlag;
      paramArrayOfByte = a.d.ATy;
      paramq.field_localFlag = (paramInt1 & (a.d.eld() ^ 0xFFFFFFFF));
      paramq.field_storyID = localdjx.HxW.Id;
      paramArrayOfByte = localdjx.HxW;
      paramArrayOfByte.Hyy.setBuffer(new byte[0]);
      this.dKt = localdjx.HxW.Id;
      paramq.field_attrBuf = paramArrayOfByte.toByteArray();
      paramq.dYN();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().AW(localdjx.HxW.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehT().a(this.dJd, paramq);
      paramq = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.eia().PR(this.dJd);
      paramq = com.tencent.mm.plugin.story.f.j.AKb;
      j.b.ehZ().checkPost();
      paramq = this.callback;
      if (paramq == null) {
        p.bcb("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.ATp;
      paramq.Sw(com.tencent.mm.plugin.story.i.a.ekX());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */