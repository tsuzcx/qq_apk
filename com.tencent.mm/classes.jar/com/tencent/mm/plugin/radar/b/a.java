package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class a
  extends com.tencent.mm.an.q
  implements m
{
  public static final a HtB;
  private static final String TAG = "MicroMsg.NetSceneRadarSearch";
  private i callback;
  final int fCN;
  private final int fMF;
  private final int fMG;
  private final String fMH;
  private final String fMI;
  private final float latitude;
  private final float longitude;
  d rr;
  
  static
  {
    AppMethodBeat.i(138512);
    HtB = new a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.fCN = paramInt1;
    this.latitude = paramFloat1;
    this.longitude = paramFloat2;
    this.fMF = paramInt2;
    this.fMG = paramInt3;
    this.fMH = paramString1;
    this.fMI = paramString2;
    if (this.fCN == 0) {
      Log.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(138509);
    p.k(paramg, "dispatcher");
    p.k(parami, "callback");
    this.callback = parami;
    parami = new d.a();
    parami.c((com.tencent.mm.cd.a)new dsr());
    parami.d((com.tencent.mm.cd.a)new dss());
    parami.TW("/cgi-bin/micromsg-bin/mmradarsearch");
    parami.vD(425);
    parami.vF(209);
    parami.vG(1000000209);
    this.rr = parami.bgN();
    parami = this.rr;
    if (parami == null) {
      p.iCn();
    }
    parami = parami.bhX();
    if (parami == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw paramg;
    }
    parami = (dsr)parami;
    parami.RLe = this.fCN;
    parami.Sxv = this.fMI;
    parami.Sxw = this.fMG;
    parami.ScP = this.latitude;
    parami.ScO = this.longitude;
    parami.Sxu = this.fMH;
    parami.Sxt = this.fMF;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(138509);
    return i;
  }
  
  public final int ftj()
  {
    AppMethodBeat.i(216443);
    Object localObject = this.rr;
    if (localObject != null) {}
    for (localObject = ((d)localObject).bhY();; localObject = null)
    {
      localObject = (dss)localObject;
      if (localObject == null) {
        break;
      }
      int i = ((dss)localObject).iWB;
      AppMethodBeat.o(216443);
      return i;
    }
    AppMethodBeat.o(216443);
    return 0;
  }
  
  public final int getType()
  {
    return 425;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138508);
    Log.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.fCN == 1) && (paramInt2 == 0))
    {
      ArrayList localArrayList = new ArrayList();
      params = this.rr;
      if (params != null) {}
      for (params = params.bhY();; params = null)
      {
        paramArrayOfByte = params;
        if (!(params instanceof dss)) {
          paramArrayOfByte = null;
        }
        params = (dss)paramArrayOfByte;
        if (params == null) {
          break;
        }
        params = params.RIk;
        if (params == null) {
          break;
        }
        params = ((Iterable)params).iterator();
        while (params.hasNext())
        {
          paramArrayOfByte = (dsq)params.next();
          j localj = new j();
          com.tencent.mm.plugin.radar.ui.g localg = com.tencent.mm.plugin.radar.ui.g.Hwt;
          p.j(paramArrayOfByte, "member");
          localj.setUsername(com.tencent.mm.plugin.radar.ui.g.a(paramArrayOfByte));
          localj.TR(paramArrayOfByte.Sus);
          localj.gg(true);
          localArrayList.add(localj);
        }
      }
      com.tencent.mm.am.q.bhP().at((List)localArrayList);
    }
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.an.q)this);
      AppMethodBeat.o(138508);
      return;
    }
    AppMethodBeat.o(138508);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.a
 * JD-Core Version:    0.7.0.1
 */