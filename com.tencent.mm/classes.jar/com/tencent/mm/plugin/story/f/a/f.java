package com.tencent.mm.plugin.story.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opList", "", "Lcom/tencent/mm/plugin/story/model/cgi/BaseStoryOpItem;", "localIdList", "", "(Ljava/util/List;Ljava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getCallback", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "setCallback", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "getLocalIdList", "()Ljava/util/List;", "getOpList", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getOp", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-story_release"})
public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public static final a ALn;
  private static final String TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
  private final List<a> ALl;
  public final List<Integer> ALm;
  public com.tencent.mm.al.f callback;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(118818);
    ALn = new a((byte)0);
    TAG = "MicroMsg.StoryCgi.NetSceneStoryObjectOp";
    AppMethodBeat.o(118818);
  }
  
  public f(List<? extends a> paramList, List<Integer> paramList1)
  {
    AppMethodBeat.i(118816);
    this.ALl = paramList;
    this.ALm = paramList1;
    paramList = new b.a();
    paramList.c((com.tencent.mm.bx.a)new dju());
    paramList.d((com.tencent.mm.bx.a)new djv());
    paramList.Dl("/cgi-bin/micromsg-bin/mmstoryobjectop");
    paramList.oP(764);
    paramList.oR(0);
    paramList.oS(0);
    paramList = paramList.aDC();
    p.g(paramList, "builder.buildInstance()");
    this.rr = paramList;
    paramList = this.rr.aEE();
    if (paramList == null)
    {
      paramList = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpRequest");
      AppMethodBeat.o(118816);
      throw paramList;
    }
    paramList = (dju)paramList;
    paramList.Hur = this.ALl.size();
    paramList1 = this.ALl.iterator();
    if (paramList1.hasNext())
    {
      a locala = (a)paramList1.next();
      djt localdjt = new djt();
      localdjt.HxD = locala.dKt;
      localdjt.gsV = locala.type;
      ad.i(TAG, "op.id:" + locala.dKt + " op.type:" + locala.type);
      Object localObject;
      if ((locala instanceof l))
      {
        localObject = new djp();
        ((djp)localObject).HxD = locala.dKt;
        localdjt.HyG = new SKBuiltinBuffer_t().setBuffer(((djp)localObject).toByteArray());
      }
      for (;;)
      {
        paramList.Hus.add(localdjt);
        break;
        if ((locala instanceof j))
        {
          localObject = new djn();
          ((djn)localObject).HtH = ((j)locala).ALy;
          localdjt.HyG = new SKBuiltinBuffer_t().setBuffer(((djn)localObject).toByteArray());
        }
        else if ((locala instanceof m))
        {
          localObject = new djq();
          ((djq)localObject).Hyw = ((m)locala).ALA;
          ((djq)localObject).HxD = locala.dKt;
          localdjt.HyG = new SKBuiltinBuffer_t().setBuffer(((djq)localObject).toByteArray());
        }
        else if ((locala instanceof k))
        {
          localObject = new djo();
          ((djo)localObject).Hyv = ((k)locala).ALz;
          ((djo)localObject).HxD = locala.dKt;
          localdjt.HyG = new SKBuiltinBuffer_t().setBuffer(((djo)localObject).toByteArray());
        }
      }
    }
    AppMethodBeat.o(118816);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(118813);
    p.h(parame, "dispatcher");
    p.h(paramf, "callback");
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(118813);
    return i;
  }
  
  public final a eiG()
  {
    AppMethodBeat.i(118815);
    if (this.ALl != null)
    {
      if (!((Collection)this.ALl).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        a locala = (a)this.ALl.get(0);
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
    ad.i(TAG, "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = this.rr.aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryOpResponse");
      AppMethodBeat.o(118814);
      throw paramString;
    }
    paramInt1 = ((djv)paramq).HyH;
    ad.i(TAG, "respCount=".concat(String.valueOf(paramInt1)));
    paramq = this.callback;
    if (paramq == null) {
      p.bcb("callback");
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
    AppMethodBeat.o(118814);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/cgi/NetSceneStoryObjectOp$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.f
 * JD-Core Version:    0.7.0.1
 */