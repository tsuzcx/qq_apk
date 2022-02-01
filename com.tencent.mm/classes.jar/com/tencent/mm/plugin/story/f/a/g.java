package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.i.a.d;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.n.d;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "content", "", "clientId", "localId", "", "groupList", "", "blackList", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "TAG", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "isDel", "", "()Z", "setDel", "(Z)V", "getLocalId", "()I", "setLocalId", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "storyId", "", "getStoryId", "()J", "setStoryId", "(J)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getStoryLocalId", "getType", "onError", "", "onErrorServer", "errCode", "storyPostResponse", "Lcom/tencent/mm/protocal/protobuf/StoryPostResponse;", "errmsg", "onGYNetEnd", "netId", "errType", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateMediaFileName", "old", "Lcom/tencent/mm/protocal/protobuf/StoryTimelineObject;", "cnt", "plugin-story_release"})
public final class g
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private final String TAG;
  private com.tencent.mm.ak.g callback;
  public int dwR;
  private long dyg;
  private final com.tencent.mm.ak.b rr;
  
  public g(String paramString1, String paramString2, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(118822);
    this.dwR = paramInt;
    this.TAG = "MicroMsg.StoryCgi.StoryNetSceneStoryPost";
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bw.a)new dej());
    ((b.a)localObject1).d((com.tencent.mm.bw.a)new dek());
    ((b.a)localObject1).Am("/cgi-bin/micromsg-bin/mmstorypost");
    ((b.a)localObject1).op(351);
    ((b.a)localObject1).or(0);
    ((b.a)localObject1).os(0);
    localObject1 = ((b.a)localObject1).aAz();
    d.g.b.k.g(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.ak.b)localObject1);
    localObject1 = this.rr.aBC();
    if (localObject1 == null)
    {
      paramString1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostRequest");
      AppMethodBeat.o(118822);
      throw paramString1;
    }
    localObject1 = (dej)localObject1;
    Object localObject2 = new SKBuiltinBuffer_t();
    paramString1 = paramString1.getBytes(d.UTF_8);
    d.g.b.k.g(paramString1, "(this as java.lang.String).getBytes(charset)");
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramString1);
    ((dej)localObject1).FNN = ((SKBuiltinBuffer_t)localObject2);
    ((dej)localObject1).hkN = paramString2;
    ((dej)localObject1).DUq = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkC());
    paramString1 = ((Iterable)paramList1).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      localObject2 = new crm();
      ((crm)localObject2).aJV(paramString2);
      ((dej)localObject1).GroupUser.add(localObject2);
    }
    ((dej)localObject1).GroupUserCount = paramList1.size();
    paramString1 = ((Iterable)paramList2).iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramList1 = new crm();
      paramList1.aJV(paramString2);
      ((dej)localObject1).BlackList.add(paramList1);
    }
    ((dej)localObject1).BlackListCount = paramList2.size();
    AppMethodBeat.o(118822);
  }
  
  private final boolean a(long paramLong, dep paramdep1, dep paramdep2)
  {
    AppMethodBeat.i(118821);
    if ((paramdep1 == null) || (paramdep2 == null) || (paramdep1.FOc == null) || (paramdep2.FOc == null))
    {
      AppMethodBeat.o(118821);
      return false;
    }
    String str = paramdep2.ncR;
    int i = 0;
    while ((i < paramdep1.FOc.Etz.size()) && (i < paramdep2.FOc.Etz.size()))
    {
      Object localObject3 = (ddy)paramdep1.FOc.Etz.get(i);
      Object localObject1 = (ddy)paramdep2.FOc.Etz.get(i);
      Object localObject2 = com.tencent.mm.plugin.story.f.l.zsu;
      localObject2 = com.tencent.mm.plugin.story.f.l.awB(((ddy)localObject3).Id);
      Object localObject4 = com.tencent.mm.plugin.story.f.l.zsu;
      localObject3 = com.tencent.mm.plugin.story.f.l.awC(((ddy)localObject3).Id);
      localObject4 = com.tencent.mm.plugin.story.f.l.zsu;
      localObject4 = com.tencent.mm.plugin.story.f.l.jN(((ddy)localObject1).Url, str);
      Object localObject5 = com.tencent.mm.plugin.story.f.l.zsu;
      localObject5 = com.tencent.mm.plugin.story.f.l.jO(((ddy)localObject1).Url, str);
      ac.d(this.TAG, "updateMediaFileName " + (String)localObject2 + " to " + (String)localObject4);
      ac.d(this.TAG, "updateMediaFileName " + (String)localObject3 + " to " + (String)localObject5);
      i.aSh(i.aSs((String)localObject5));
      i.ma((String)localObject2, (String)localObject4);
      i.lZ((String)localObject3, (String)localObject5);
      localObject2 = s.ztj;
      d.g.b.k.g(localObject1, "mediaObjCnt");
      d.g.b.k.h(localObject1, "media");
      localObject2 = s.a((ddy)localObject1, str);
      int j = (int)i.aSp((String)localObject2);
      localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
      if (j.b.dVI().yB(paramLong) == null)
      {
        localObject3 = new com.tencent.mm.plugin.story.i.n();
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_storyId = paramLong;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_url = ((ddy)localObject1).Url;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_cacheSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_totalSize = j;
        ((com.tencent.mm.plugin.story.i.n)localObject3).field_filePath = ((String)localObject2);
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVI().a((com.tencent.mm.plugin.story.i.n)localObject3);
      }
      i += 1;
    }
    AppMethodBeat.o(118821);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(118819);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    ac.d(this.TAG, "doScene");
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
    ac.i(this.TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryPostResponse");
      AppMethodBeat.o(118820);
      throw paramString;
    }
    dek localdek = (dek)paramq;
    if (paramInt2 == 4)
    {
      paramq = com.tencent.mm.plugin.story.f.j.zsh;
      paramq = j.b.dVE().QO(this.dwR);
      if (paramq != null)
      {
        try
        {
          paramArrayOfByte = new ddz().parseFrom(paramq.field_postBuf);
          if (paramArrayOfByte != null) {
            break label284;
          }
          paramArrayOfByte = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
          AppMethodBeat.o(118820);
          throw paramArrayOfByte;
        }
        catch (Exception paramArrayOfByte) {}
        if (localdek == null) {
          break label329;
        }
        paramArrayOfByte = localdek.FNl;
        if (paramArrayOfByte == null) {
          break label329;
        }
      }
      label284:
      label329:
      for (long l = paramArrayOfByte.Id;; l = 0L)
      {
        paramq.field_storyID = l;
        paramq.dMy();
        paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVE().a(this.dwR, paramq);
        paramq = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVL().Ok(this.dwR);
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.aVY("callback");
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        AppMethodBeat.o(118820);
        return;
        paramArrayOfByte = (ddz)paramArrayOfByte;
        paramArrayOfByte.FjN = paramInt3;
        paramArrayOfByte.FNI = paramString;
        paramArrayOfByte = paramArrayOfByte.toByteArray();
        d.g.b.k.g(paramArrayOfByte, "postinfo.toByteArray()");
        paramq.bD(paramArrayOfByte);
        break;
      }
    }
    if (paramInt3 != 0)
    {
      paramq = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVL().Ok(this.dwR);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = this.TAG;
    paramArrayOfByte = new StringBuilder("resp.StoryObject==null ");
    if (localdek.FNl == null)
    {
      bool = true;
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc==null ");
      if (localdek.FNl.FNN != null) {
        break label603;
      }
      bool = true;
      label452:
      paramArrayOfByte = paramArrayOfByte.append(bool).append(" resp.StoryObject.ObjDesc.getBuffer()==null ");
      if (localdek.FNl.FNN.getBuffer() != null) {
        break label609;
      }
    }
    label603:
    label609:
    for (boolean bool = true;; bool = false)
    {
      ac.i(paramq, bool);
      if ((localdek.FNl != null) && (localdek.FNl.FNN != null) && (localdek.FNl.FNN.getBuffer() != null)) {
        break label615;
      }
      ac.e(this.TAG, "err respone buffer is null ignore");
      paramq = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().Pi(this.dwR);
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
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
    paramq = f.zAv;
    f.dXH();
    paramq = localdek.FNl.FNN.getBuffer().toByteArray();
    d.g.b.k.g(paramq, "resp.StoryObject.ObjDesc.getBuffer().toByteArray()");
    paramq = new String(paramq, d.UTF_8);
    ac.d(this.TAG, "resp.xml:\n ".concat(String.valueOf(paramq)));
    paramArrayOfByte = com.tencent.mm.plugin.story.f.q.zsy;
    dep localdep = q.a.awJ(paramq);
    if (localdep == null)
    {
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
    }
    paramq = com.tencent.mm.plugin.story.f.j.zsh;
    paramArrayOfByte = j.b.dVE().QO(this.dwR);
    paramq = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      paramq = new com.tencent.mm.plugin.story.i.j();
    }
    a(localdek.FNl.Id, paramq.dZi(), localdep);
    if (localdek.FNl.FNK == 1)
    {
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.zBQ;
      paramq.QM(com.tencent.mm.plugin.story.i.a.dYI());
    }
    for (;;)
    {
      paramq.field_createTime = localdek.FNl.CreateTime;
      paramq.c(localdep);
      paramInt1 = paramq.field_localFlag;
      paramArrayOfByte = a.d.zBZ;
      paramq.field_localFlag = (paramInt1 & (a.d.dYO() ^ 0xFFFFFFFF));
      paramq.field_storyID = localdek.FNl.Id;
      paramArrayOfByte = localdek.FNl;
      paramArrayOfByte.FNN.setBuffer(new byte[0]);
      this.dyg = localdek.FNl.Id;
      paramq.field_attrBuf = paramArrayOfByte.toByteArray();
      paramq.dMx();
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().yy(localdek.FNl.Id);
      paramArrayOfByte = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVE().a(this.dwR, paramq);
      paramq = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVL().Ok(this.dwR);
      paramq = com.tencent.mm.plugin.story.f.j.zsh;
      j.b.dVK().checkPost();
      paramq = this.callback;
      if (paramq == null) {
        d.g.b.k.aVY("callback");
      }
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      AppMethodBeat.o(118820);
      return;
      paramArrayOfByte = com.tencent.mm.plugin.story.i.a.zBQ;
      paramq.QN(com.tencent.mm.plugin.story.i.a.dYI());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.g
 * JD-Core Version:    0.7.0.1
 */