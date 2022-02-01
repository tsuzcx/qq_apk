package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final b.a xif;
  private f callback;
  private final float dAp;
  private final int dAq;
  private final int dAr;
  private final String dAs;
  private final String dAt;
  final int drI;
  private final float dyz;
  com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(138512);
    xif = new b.a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.drI = paramInt1;
    this.dyz = paramFloat1;
    this.dAp = paramFloat2;
    this.dAq = paramInt2;
    this.dAr = paramInt3;
    this.dAs = paramString1;
    this.dAt = paramString2;
    if (this.drI == 0) {
      ad.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(138509);
    d.g.b.p.h(parame, "dispatcher");
    d.g.b.p.h(paramf, "callback");
    this.callback = paramf;
    paramf = new com.tencent.mm.al.b.a();
    paramf.c((a)new cqj());
    paramf.d((a)new cqk());
    paramf.Dl("/cgi-bin/micromsg-bin/mmradarsearch");
    paramf.oP(425);
    paramf.oR(209);
    paramf.oS(1000000209);
    this.rr = paramf.aDC();
    paramf = this.rr;
    if (paramf == null) {
      d.g.b.p.gfZ();
    }
    paramf = paramf.aEE();
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw parame;
    }
    paramf = (cqj)paramf;
    paramf.OpCode = this.drI;
    paramf.Ggy = this.dAt;
    paramf.Ggz = this.dAr;
    paramf.FOB = this.dyz;
    paramf.FOA = this.dAp;
    paramf.Ggx = this.dAs;
    paramf.Ggw = this.dAq;
    int i = dispatch(parame, (q)this.rr, (k)this);
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
    if ((this.drI == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aEF();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof cqk)) {
          paramArrayOfByte = null;
        }
        paramq = (cqk)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.FuN;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (cqi)paramq.next();
          i locali = new i();
          g localg = g.xla;
          d.g.b.p.g(paramArrayOfByte, "member");
          locali.setUsername(g.b(paramArrayOfByte));
          locali.Di(paramArrayOfByte.SmallImgUrl);
          locali.eB(true);
          localArrayList.add(locali);
        }
      }
      com.tencent.mm.ak.p.aEx().am((List)localArrayList);
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