package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  public static final a ygt;
  public g callback;
  private final b rr;
  private final List<a> ygr;
  public final List<Integer> ygs;
  
  static
  {
    AppMethodBeat.i(118818);
    ygt = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.ygr = paramList;
    this.ygs = paramList1;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bx.a)new cyv());
    paramList.d((com.tencent.mm.bx.a)new cyw());
    paramList.wg("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.nB(764);
    paramList.nD(0);
    paramList.nE(0);
    paramList = paramList.atI();
    d.g.b.k.g(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.auL();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (cyv)paramList;
    paramList.EmK = this.ygr.size();
    paramList1 = this.ygr.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      cyu localcyu = new cyu();
      localcyu.EpQ = locala.dAu;
      localcyu.fVE = locala.type;
      ad.i(TAG, "op.id:" + locala.dAu + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new cyq();
        ((cyq)localObject).EpQ = locala.dAu;
        localcyu.EqT = new SKBuiltinBuffer_t().setBuffer(((cyq)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.EmL.add(localcyu);
        break;
        if ((locala instanceof j))
        {
          localObject = new cyo();
          ((cyo)localObject).Ema = ((j)locala).ygE;
          localcyu.EqT = new SKBuiltinBuffer_t().setBuffer(((cyo)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new cyr();
          ((cyr)localObject).EqJ = ((m)locala).ygG;
          ((cyr)localObject).EpQ = locala.dAu;
          localcyu.EqT = new SKBuiltinBuffer_t().setBuffer(((cyr)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new cyp();
          ((cyp)localObject).EqI = ((k)locala).ygF;
          ((cyp)localObject).EpQ = locala.dAu;
          localcyu.EqT = new SKBuiltinBuffer_t().setBuffer(((cyp)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final a dHQ()
  {
    AppMethodBeat.i(118815);
    if (this.ygr != null)
    {
      if (!((Collection)this.ygr).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.ygr.get(0);
        AppMethodBeat.o(118815);
        return locala;
      }
    }
    AppMethodBeat.o(118815);
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(118813);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final int getType()
  {
    return 764;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118814);
    ad.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((cyw)paramq).EqU;
    ad.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aPZ("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118814);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */