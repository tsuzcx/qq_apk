package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  public static final f.a ztt;
  public g callback;
  private final b rr;
  private final List<a> ztr;
  public final List<Integer> zts;
  
  static
  {
    AppMethodBeat.i(118818);
    ztt = new f.a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.ztr = paramList;
    this.zts = paramList1;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bw.a)new deh());
    paramList.d((com.tencent.mm.bw.a)new dei());
    paramList.Am("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.op(764);
    paramList.or(0);
    paramList.os(0);
    paramList = paramList.aAz();
    d.g.b.k.g(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.aBC();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (deh)paramList;
    paramList.FJJ = this.ztr.size();
    paramList1 = this.ztr.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      deg localdeg = new deg();
      localdeg.FMS = locala.dyg;
      localdeg.fZz = locala.type;
      ac.i(TAG, "op.id:" + locala.dyg + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new dec();
        ((dec)localObject).FMS = locala.dyg;
        localdeg.FNV = new SKBuiltinBuffer_t().setBuffer(((dec)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.FJK.add(localdeg);
        break;
        if ((locala instanceof j))
        {
          localObject = new dea();
          ((dea)localObject).FIZ = ((j)locala).ztE;
          localdeg.FNV = new SKBuiltinBuffer_t().setBuffer(((dea)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new ded();
          ((ded)localObject).FNL = ((m)locala).ztG;
          ((ded)localObject).FMS = locala.dyg;
          localdeg.FNV = new SKBuiltinBuffer_t().setBuffer(((ded)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new deb();
          ((deb)localObject).FNK = ((k)locala).ztF;
          ((deb)localObject).FMS = locala.dyg;
          localdeg.FNV = new SKBuiltinBuffer_t().setBuffer(((deb)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final a dWr()
  {
    AppMethodBeat.i(118815);
    if (this.ztr != null)
    {
      if (!((Collection)this.ztr).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.ztr.get(0);
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
    ac.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((dei)paramq).FNW;
    ac.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    paramq = this.callback;
    if (paramq == null) {
      d.g.b.k.aVY("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */