package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.djb;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class b
  extends q
  implements m
{
  public static final a Bye;
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  private com.tencent.mm.ak.i callback;
  final int dJY;
  private final float dTj;
  private final int dTk;
  private final int dTl;
  private final String dTm;
  private final String dTn;
  private final float latitude;
  d rr;
  
  static
  {
    AppMethodBeat.i(138512);
    Bye = new a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.dJY = paramInt1;
    this.latitude = paramFloat1;
    this.dTj = paramFloat2;
    this.dTk = paramInt2;
    this.dTl = paramInt3;
    this.dTm = paramString1;
    this.dTn = paramString2;
    if (this.dJY == 0) {
      Log.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(138509);
    kotlin.g.b.p.h(paramg, "dispatcher");
    kotlin.g.b.p.h(parami, "callback");
    this.callback = parami;
    parami = new d.a();
    parami.c((a)new djc());
    parami.d((a)new djd());
    parami.MB("/cgi-bin/micromsg-bin/mmradarsearch");
    parami.sG(425);
    parami.sI(209);
    parami.sJ(1000000209);
    this.rr = parami.aXF();
    parami = this.rr;
    if (parami == null) {
      kotlin.g.b.p.hyc();
    }
    parami = parami.aYJ();
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw paramg;
    }
    parami = (djc)parami;
    parami.OpCode = this.dJY;
    parami.LuV = this.dTn;
    parami.LuW = this.dTl;
    parami.LbD = this.latitude;
    parami.LbC = this.dTj;
    parami.LuU = this.dTm;
    parami.LuT = this.dTk;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(138509);
    return i;
  }
  
  public final int getType()
  {
    return 425;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138508);
    Log.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.dJY == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      params = this.rr;
      if (params != null) {}
      for (params = params.aYK();; params = null)
      {
        paramArrayOfByte = params;
        if (!(params instanceof djd)) {
          paramArrayOfByte = null;
        }
        params = (djd)paramArrayOfByte;
        if (params == null) {
          break;
        }
        params = params.KGQ;
        if (params == null) {
          break;
        }
        params = ((Iterable)params).iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = (djb)params.next();
          com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
          com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.BAY;
          kotlin.g.b.p.g(paramArrayOfByte, "member");
          locali.setUsername(com.tencent.mm.plugin.radar.ui.g.b(paramArrayOfByte));
          locali.Mw(paramArrayOfByte.SmallImgUrl);
          locali.fv(true);
          localArrayList.add(locali);
        }
      }
      com.tencent.mm.aj.p.aYB().av((List)localArrayList);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(138508);
      return;
    }
    AppMethodBeat.o(138508);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.b
 * JD-Core Version:    0.7.0.1
 */