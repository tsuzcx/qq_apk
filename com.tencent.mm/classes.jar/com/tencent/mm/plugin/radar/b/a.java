package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "memberList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "radarRelationChainResponse", "Lcom/tencent/mm/protocal/protobuf/RadarRelationChainResponse;", "getRadarRelationChainResponse", "()Lcom/tencent/mm/protocal/protobuf/RadarRelationChainResponse;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class a
  extends q
  implements m
{
  public static final a Byd;
  private static final String TAG = "MicroMsg.Radar.NetSceneRadarRelationChain";
  private i callback;
  final d rr;
  
  static
  {
    AppMethodBeat.i(138507);
    Byd = new a((byte)0);
    TAG = "MicroMsg.Radar.NetSceneRadarRelationChain";
    AppMethodBeat.o(138507);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(138505);
    p.h(paramg, "dispatcher");
    p.h(parami, "callback");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(138505);
    return i;
  }
  
  public final int getType()
  {
    return 602;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138506);
    Log.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(138506);
      return;
    }
    AppMethodBeat.o(138506);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.a
 * JD-Core Version:    0.7.0.1
 */