package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final b.a wav;
  private com.tencent.mm.ak.g callback;
  final int dgm;
  private final float dmL;
  private final float doB;
  private final int doC;
  private final int doD;
  private final String doE;
  private final String doF;
  com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(138512);
    wav = new b.a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.dgm = paramInt1;
    this.dmL = paramFloat1;
    this.doB = paramFloat2;
    this.doC = paramInt2;
    this.doD = paramInt3;
    this.doE = paramString1;
    this.doF = paramString2;
    if (this.dgm == 0) {
      ac.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(138509);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    paramg = new com.tencent.mm.ak.b.a();
    paramg.c((a)new clj());
    paramg.d((a)new clk());
    paramg.Am("/cgi-bin/micromsg-bin/mmradarsearch");
    paramg.op(425);
    paramg.or(209);
    paramg.os(1000000209);
    this.rr = paramg.aAz();
    paramg = this.rr;
    if (paramg == null) {
      d.g.b.k.fOy();
    }
    paramg = paramg.aBC();
    if (paramg == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw parame;
    }
    paramg = (clj)paramg;
    paramg.OpCode = this.dgm;
    paramg.EyM = this.doF;
    paramg.EyN = this.doD;
    paramg.Ehu = this.dmL;
    paramg.Eht = this.doB;
    paramg.EyL = this.doE;
    paramg.EyK = this.doC;
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
    ac.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.dgm == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aBD();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof clk)) {
          paramArrayOfByte = null;
        }
        paramq = (clk)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.DPz;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (cli)paramq.next();
          i locali = new i();
          com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.wdr;
          d.g.b.k.g(paramArrayOfByte, "member");
          locali.setUsername(com.tencent.mm.plugin.radar.ui.g.b(paramArrayOfByte));
          locali.Aj(paramArrayOfByte.SmallImgUrl);
          locali.ez(true);
          localArrayList.add(locali);
        }
      }
      p.aBw().al((List)localArrayList);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */