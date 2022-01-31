package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.radar.ui.g;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends m
  implements k
{
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  public static final b.a pPJ;
  private final float cAH;
  private final int cAI;
  private final int cAJ;
  private final String cAK;
  private final String cAL;
  private f callback;
  final int ctW;
  private final float cyV;
  com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(102868);
    pPJ = new b.a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(102868);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102866);
    this.ctW = paramInt1;
    this.cyV = paramFloat1;
    this.cAH = paramFloat2;
    this.cAI = paramInt2;
    this.cAJ = paramInt3;
    this.cAK = paramString1;
    this.cAL = paramString2;
    if (this.ctW == 0) {
      ab.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(102866);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(102865);
    j.q(parame, "dispatcher");
    j.q(paramf, "callback");
    this.callback = paramf;
    paramf = new com.tencent.mm.ai.b.a();
    paramf.a((a)new brh());
    paramf.b((a)new bri());
    paramf.rl("/cgi-bin/micromsg-bin/mmradarsearch");
    paramf.kT(425);
    paramf.kU(209);
    paramf.kV(1000000209);
    this.rr = paramf.ado();
    paramf = this.rr;
    if (paramf == null) {
      j.ebi();
    }
    paramf = paramf.adm();
    if (paramf == null)
    {
      parame = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(102865);
      throw parame;
    }
    paramf = (brh)paramf;
    paramf.OpCode = this.ctW;
    paramf.wSm = this.cAL;
    paramf.wSn = this.cAJ;
    paramf.wDi = this.cyV;
    paramf.wDh = this.cAH;
    paramf.wSl = this.cAK;
    paramf.wSk = this.cAI;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(102865);
    return i;
  }
  
  public final int getType()
  {
    return 425;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102864);
    ab.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.ctW == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.adn();; paramq = null)
      {
        paramArrayOfByte = paramq;
        if (!(paramq instanceof bri)) {
          paramArrayOfByte = null;
        }
        paramq = (bri)paramArrayOfByte;
        if (paramq == null) {
          break;
        }
        paramq = paramq.wov;
        if (paramq == null) {
          break;
        }
        paramq = ((Iterable)paramq).iterator();
        while (paramq.hasNext())
        {
          paramArrayOfByte = (brg)paramq.next();
          h localh = new h();
          g localg = g.pSH;
          j.p(paramArrayOfByte, "member");
          localh.setUsername(g.b(paramArrayOfByte));
          localh.ri(paramArrayOfByte.SmallImgUrl);
          localh.cM(true);
          localArrayList.add(localh);
        }
      }
      o.adg().X((List)localArrayList);
    }
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (m)this);
      AppMethodBeat.o(102864);
      return;
    }
    AppMethodBeat.o(102864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */