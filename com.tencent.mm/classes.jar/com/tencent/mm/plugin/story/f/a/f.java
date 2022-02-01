package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public static final a BcQ;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  private final List<a> BcO;
  public final List<Integer> BcP;
  public com.tencent.mm.ak.f callback;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(118818);
    BcQ = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.BcO = paramList;
    this.BcP = paramList1;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bw.a)new dkp());
    paramList.d((com.tencent.mm.bw.a)new dkq());
    paramList.DN("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.oS(764);
    paramList.oU(0);
    paramList.oV(0);
    paramList = paramList.aDS();
    p.g(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.aEU();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (dkp)paramList;
    paramList.HNU = this.BcO.size();
    paramList1 = this.BcO.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      dko localdko = new dko();
      localdko.HRo = locala.dLI;
      localdko.gvx = locala.type;
      ae.i(TAG, "op.id:" + locala.dLI + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new dkk();
        ((dkk)localObject).HRo = locala.dLI;
        localdko.HSr = new SKBuiltinBuffer_t().setBuffer(((dkk)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.HNV.add(localdko);
        break;
        if ((locala instanceof j))
        {
          localObject = new dki();
          ((dki)localObject).HNk = ((j)locala).Bdb;
          localdko.HSr = new SKBuiltinBuffer_t().setBuffer(((dki)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new dkl();
          ((dkl)localObject).HSh = ((m)locala).Bdd;
          ((dkl)localObject).HRo = locala.dLI;
          localdko.HSr = new SKBuiltinBuffer_t().setBuffer(((dkl)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new dkj();
          ((dkj)localObject).HSg = ((k)locala).Bdc;
          ((dkj)localObject).HRo = locala.dLI;
          localdko.HSr = new SKBuiltinBuffer_t().setBuffer(((dkj)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(118813);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final a emo()
  {
    AppMethodBeat.i(118815);
    if (this.BcO != null)
    {
      if (!((Collection)this.BcO).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.BcO.get(0);
        AppMethodBeat.o(118815);
        return locala;
      }
    }
    AppMethodBeat.o(118815);
    return null;
  }
  
  public final int getType()
  {
    return 764;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118814);
    ae.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.aEV();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((dkq)paramq).HSs;
    ae.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    paramq = this.callback;
    if (paramq == null) {
      p.bdF("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118814);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */