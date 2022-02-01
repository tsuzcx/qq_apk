package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.eny;
import com.tencent.mm.protocal.protobuf.enz;
import com.tencent.mm.protocal.protobuf.eoc;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends q
  implements com.tencent.mm.network.m
{
  public static final a LHK;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  private final List<a> LHI;
  public final List<Integer> LHJ;
  public i callback;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(118818);
    LHK = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.LHI = paramList;
    this.LHJ = paramList1;
    paramList = new d.a();
    paramList.c((com.tencent.mm.cd.a)new eod());
    paramList.d((com.tencent.mm.cd.a)new eoe());
    paramList.TW("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.vD(764);
    paramList.vF(0);
    paramList.vG(0);
    paramList = paramList.bgN();
    p.j(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.bhX();
    if (paramList == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (eod)paramList;
    paramList.UlV = this.LHI.size();
    paramList1 = this.LHI.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      eoc localeoc = new eoc();
      localeoc.UpP = locala.fXG;
      localeoc.jUk = locala.type;
      Log.i(TAG, "op.id:" + locala.fXG + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new eny();
        ((eny)localObject).UpP = locala.fXG;
        localeoc.UqT = new eae().dc(((eny)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.UlW.add(localeoc);
        break;
        if ((locala instanceof j))
        {
          localObject = new enw();
          ((enw)localObject).Uln = ((j)locala).LHU;
          localeoc.UqT = new eae().dc(((enw)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new enz();
          ((enz)localObject).UqJ = ((m)locala).LHV;
          ((enz)localObject).UpP = locala.fXG;
          localeoc.UqT = new eae().dc(((enz)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new enx();
          ((enx)localObject).UqI = ((k)locala).favorite;
          ((enx)localObject).UpP = locala.fXG;
          localeoc.UqT = new eae().dc(((enx)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(118813);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final a gdk()
  {
    AppMethodBeat.i(118815);
    if (this.LHI != null)
    {
      if (!((Collection)this.LHI).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.LHI.get(0);
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
    params = this.rr.bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((eoe)params).UqU;
    Log.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    params = this.callback;
    if (params == null) {
      p.bGy("callback");
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    AppMethodBeat.o(118814);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */