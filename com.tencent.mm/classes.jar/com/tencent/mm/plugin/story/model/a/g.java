package com.tencent.mm.plugin.story.model.a;

import a.f.b.j;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.cht;
import com.tencent.mm.protocal.protobuf.chu;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class g
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  public static final g.a sxj;
  public f callback;
  private final b rr;
  private final List<a> sxh;
  public final List<Integer> sxi;
  
  static
  {
    AppMethodBeat.i(109234);
    sxj = new g.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(109234);
  }
  
  public g(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(151069);
    this.sxh = paramList;
    this.sxi = paramList1;
    paramList = new b.a();
    paramList.a((com.tencent.mm.bv.a)new chu());
    paramList.b((com.tencent.mm.bv.a)new chv());
    paramList.rl("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.kT(764);
    paramList.kU(0);
    paramList.kV(0);
    paramList = paramList.ado();
    j.p(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.adm();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(151069);
      throw paramList;
    }
    paramList = (chu)paramList;
    paramList.xOI = this.sxh.size();
    paramList1 = this.sxh.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      cht localcht = new cht();
      localcht.xRw = locala.cJA;
      localcht.nrS = locala.type;
      ab.i(TAG, "op.id:" + locala.cJA + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof m))
      {
        localObject = new chp();
        ((chp)localObject).xRw = locala.cJA;
        localcht.xSD = new SKBuiltinBuffer_t().setBuffer(((chp)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.xOJ.add(localcht);
        break;
        if ((locala instanceof k))
        {
          localObject = new chn();
          ((chn)localObject).xNY = ((k)locala).sxu;
          localcht.xSD = new SKBuiltinBuffer_t().setBuffer(((chn)localObject).toByteArray());
        }
        else if ((locala instanceof n))
        {
          localObject = new chq();
          ((chq)localObject).xSv = ((n)locala).sxw;
          ((chq)localObject).xRw = locala.cJA;
          localcht.xSD = new SKBuiltinBuffer_t().setBuffer(((chq)localObject).toByteArray());
        }
        else if ((locala instanceof l))
        {
          localObject = new cho();
          ((cho)localObject).xSu = ((l)locala).sxv;
          ((cho)localObject).xRw = locala.cJA;
          localcht.xSD = new SKBuiltinBuffer_t().setBuffer(((cho)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(151069);
  }
  
  public final a cBG()
  {
    AppMethodBeat.i(109232);
    if (this.sxh != null)
    {
      if (!((Collection)this.sxh).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.sxh.get(0);
        AppMethodBeat.o(109232);
        return locala;
      }
    }
    AppMethodBeat.o(109232);
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(109230);
    j.q(parame, "dispatcher");
    j.q(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(109230);
    return i;
  }
  
  public final int getType()
  {
    return 764;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109231);
    ab.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.adn();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(109231);
      throw paramString;
    }
    paramInt1 = ((chv)paramq).xSE;
    ab.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    paramq = this.callback;
    if (paramq == null) {
      j.ays("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ai.m)this);
    AppMethodBeat.o(109231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.g
 * JD-Core Version:    0.7.0.1
 */