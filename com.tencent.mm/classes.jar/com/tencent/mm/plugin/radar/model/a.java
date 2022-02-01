package com.tencent.mm.plugin.radar.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.radar.ui.d;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "opCode", "", "latitude", "", "longitude", "precision", "gpsSource", "macAddr", "", "cellId", "(IFFIILjava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpCode", "()I", "radarSearchMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getRadarSearchMembers", "()Ljava/util/LinkedList;", "radarSearchMembersCount", "getRadarSearchMembersCount", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "irr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends p
  implements m
{
  public static final a.a Nrr;
  private static final String TAG;
  private h callback;
  final int hHC;
  private final int hSp;
  private final int hSq;
  private final String hSr;
  private final String hSs;
  private final float latitude;
  private final float longitude;
  c rr;
  
  static
  {
    AppMethodBeat.i(138512);
    Nrr = new a.a((byte)0);
    TAG = "MicroMsg.NetSceneRadarSearch";
    AppMethodBeat.o(138512);
  }
  
  public a(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(138510);
    this.hHC = paramInt1;
    this.latitude = paramFloat1;
    this.longitude = paramFloat2;
    this.hSp = paramInt2;
    this.hSq = paramInt3;
    this.hSr = paramString1;
    this.hSs = paramString2;
    if (this.hHC == 0) {
      Log.e(TAG, "opcode is wrong!");
    }
    AppMethodBeat.o(138510);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(138509);
    kotlin.g.b.s.u(paramg, "dispatcher");
    kotlin.g.b.s.u(paramh, "callback");
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = ((com.tencent.mm.bx.a)new elm());
    paramh.otF = ((com.tencent.mm.bx.a)new eln());
    paramh.uri = "/cgi-bin/micromsg-bin/mmradarsearch";
    paramh.funcId = 425;
    paramh.otG = 209;
    paramh.respCmdId = 1000000209;
    ah localah = ah.aiuX;
    this.rr = paramh.bEF();
    paramh = this.rr;
    kotlin.g.b.s.checkNotNull(paramh);
    paramh = c.b.b(paramh.otB);
    if (paramh == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarSearchRequest");
      AppMethodBeat.o(138509);
      throw paramg;
    }
    paramh = (elm)paramh;
    paramh.YIq = this.hHC;
    paramh.Zyn = this.hSs;
    paramh.Zyo = this.hSq;
    paramh.ZaH = this.latitude;
    paramh.ZaG = this.longitude;
    paramh.Zym = this.hSr;
    paramh.Zyl = this.hSp;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(138509);
    return i;
  }
  
  public final int gEV()
  {
    AppMethodBeat.i(267194);
    Object localObject = this.rr;
    if (localObject == null) {}
    for (localObject = null;; localObject = c.c.b(((c)localObject).otC))
    {
      localObject = (eln)localObject;
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(267194);
      return 0;
    }
    int i = ((eln)localObject).lyF;
    AppMethodBeat.o(267194);
    return i;
  }
  
  public final int getType()
  {
    return 425;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138508);
    Log.d(TAG, "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    if ((this.hHC == 1) && (paramInt2 == 0))
    {
      paramArrayOfByte = new ArrayList();
      params = this.rr;
      if (params == null)
      {
        params = null;
        if (!(params instanceof eln)) {
          break label221;
        }
      }
      label221:
      for (params = (eln)params;; params = null)
      {
        if (params == null) {
          break label227;
        }
        params = params.YFm;
        if (params == null) {
          break label227;
        }
        params = ((Iterable)params).iterator();
        while (params.hasNext())
        {
          ell localell = (ell)params.next();
          j localj = new j();
          d locald = d.Nua;
          kotlin.g.b.s.s(localell, "member");
          localj.username = d.a(localell);
          localj.osM = localell.Zui;
          localj.gX(true);
          paramArrayOfByte.add(localj);
        }
        params = c.c.b(params.otC);
        break;
      }
      label227:
      q.bFE().bY((List)paramArrayOfByte);
    }
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(138508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.a
 * JD-Core Version:    0.7.0.1
 */