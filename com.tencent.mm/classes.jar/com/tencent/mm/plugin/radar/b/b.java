package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.protobuf.crc;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends n
  implements k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final a xyb;
  private f callback;
  private final float dBu;
  private final int dBv;
  private final int dBw;
  private final String dBx;
  private final String dBy;
  final int dsO;
  private final float dzE;
  com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(138512);
    xyb = new a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.dsO = paramInt1;
    this.dzE = paramFloat1;
    this.dBu = paramFloat2;
    this.dBv = paramInt2;
    this.dBw = paramInt3;
    this.dBx = paramString1;
    this.dBy = paramString2;
    if (this.dsO == 0) {
      ae.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(138509);
    d.g.b.p.h(parame, "dispatcher");
    d.g.b.p.h(paramf, "callback");
    this.callback = paramf;
    paramf = new com.tencent.mm.ak.b.a();
    paramf.c((a)new crd());
    paramf.d((a)new cre());
    paramf.DN("/cgi-bin/micromsg-bin/mmradarsearch");
    paramf.oS(425);
    paramf.oU(209);
    paramf.oV(1000000209);
    this.rr = paramf.aDS();
    paramf = this.rr;
    if (paramf == null) {
      d.g.b.p.gkB();
    }
    paramf = paramf.aEU();
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw parame;
    }
    paramf = (crd)paramf;
    paramf.OpCode = this.dsO;
    paramf.Gzh = this.dBy;
    paramf.Gzi = this.dBw;
    paramf.Gha = this.dzE;
    paramf.GgZ = this.dBu;
    paramf.Gzg = this.dBx;
    paramf.Gzf = this.dBv;
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
    ae.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.dsO == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aEV();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof cre)) {
          paramArrayOfByte = null;
        }
        paramq = (cre)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.FNl;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (crc)paramq.next();
          i locali = new i();
          g localg = g.xAX;
          d.g.b.p.g(paramArrayOfByte, "member");
          locali.setUsername(g.b(paramArrayOfByte));
          locali.DK(paramArrayOfByte.SmallImgUrl);
          locali.eD(true);
          localArrayList.add(locali);
        }
      }
      com.tencent.mm.aj.p.aEN().am((List)localArrayList);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */