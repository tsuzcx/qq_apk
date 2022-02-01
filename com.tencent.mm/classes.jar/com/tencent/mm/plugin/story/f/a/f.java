package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.edw;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.protocal.protobuf.edy;
import com.tencent.mm.protocal.protobuf.eeb;
import com.tencent.mm.protocal.protobuf.eec;
import com.tencent.mm.protocal.protobuf.eed;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends q
  implements com.tencent.mm.network.m
{
  public static final a FnI;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  private final List<a> FnG;
  public final List<Integer> FnH;
  public i callback;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(118818);
    FnI = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.FnG = paramList;
    this.FnH = paramList1;
    paramList = new d.a();
    paramList.c((com.tencent.mm.bw.a)new eec());
    paramList.d((com.tencent.mm.bw.a)new eed());
    paramList.MB("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.sG(764);
    paramList.sI(0);
    paramList.sJ(0);
    paramList = paramList.aXF();
    p.g(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.aYJ();
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (eec)paramList;
    paramList.MZB = this.FnG.size();
    paramList1 = this.FnG.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      eeb localeeb = new eeb();
      localeeb.Nds = locala.edx;
      localeeb.him = locala.type;
      Log.i(TAG, "op.id:" + locala.edx + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new edx();
        ((edx)localObject).Nds = locala.edx;
        localeeb.Neu = new SKBuiltinBuffer_t().setBuffer(((edx)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.MZC.add(localeeb);
        break;
        if ((locala instanceof j))
        {
          localObject = new edv();
          ((edv)localObject).MYT = ((j)locala).FnS;
          localeeb.Neu = new SKBuiltinBuffer_t().setBuffer(((edv)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new edy();
          ((edy)localObject).Nek = ((m)locala).FnU;
          ((edy)localObject).Nds = locala.edx;
          localeeb.Neu = new SKBuiltinBuffer_t().setBuffer(((edy)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new edw();
          ((edw)localObject).Nej = ((k)locala).FnT;
          ((edw)localObject).Nds = locala.edx;
          localeeb.Neu = new SKBuiltinBuffer_t().setBuffer(((edw)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118813);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final a foQ()
  {
    AppMethodBeat.i(118815);
    if (this.FnG != null)
    {
      if (!((Collection)this.FnG).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.FnG.get(0);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(118814);
    Log.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((eed)params).Nev;
    Log.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    params = this.callback;
    if (params == null) {
      p.btv("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118814);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */