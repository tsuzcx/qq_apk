package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final a uRG;
  private com.tencent.mm.al.g callback;
  final int diR;
  private final float dpb;
  private final float dqQ;
  private final int dqR;
  private final int dqS;
  private final String dqT;
  private final String dqU;
  com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(138512);
    uRG = new a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.diR = paramInt1;
    this.dpb = paramFloat1;
    this.dqQ = paramFloat2;
    this.dqR = paramInt2;
    this.dqS = paramInt3;
    this.dqT = paramString1;
    this.dqU = paramString2;
    if (this.diR == 0) {
      ad.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(138509);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    paramg = new com.tencent.mm.al.b.a();
    paramg.c((a)new cgg());
    paramg.d((a)new cgh());
    paramg.wg("/cgi-bin/micromsg-bin/mmradarsearch");
    paramg.nB(425);
    paramg.nD(209);
    paramg.nE(1000000209);
    this.rr = paramg.atI();
    paramg = this.rr;
    if (paramg == null) {
      d.g.b.k.fvU();
    }
    paramg = paramg.auL();
    if (paramg == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw parame;
    }
    paramg = (cgg)paramg;
    paramg.OpCode = this.diR;
    paramg.DfG = this.dqU;
    paramg.DfH = this.dqS;
    paramg.COJ = this.dpb;
    paramg.COI = this.dqQ;
    paramg.DfF = this.dqT;
    paramg.DfE = this.dqR;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(138509);
    return i;
  }
  
  public final int getType()
  {
    return 425;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138508);
    ad.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.diR == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.auM();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof cgh)) {
          paramArrayOfByte = null;
        }
        paramq = (cgh)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.Cxd;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (cgf)paramq.next();
          i locali = new i();
          com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.uUC;
          d.g.b.k.g(paramArrayOfByte, "member");
          locali.setUsername(com.tencent.mm.plugin.radar.ui.g.b(paramArrayOfByte));
          locali.wd(paramArrayOfByte.SmallImgUrl);
          locali.ee(true);
          localArrayList.add(locali);
        }
      }
      p.auF().ao((List)localArrayList);
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(138508);
      return;
    }
    AppMethodBeat.o(138508);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */