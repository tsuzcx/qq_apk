package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "memberList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "(Ljava/util/LinkedList;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "radarRelationChainResponse", "Lcom/tencent/mm/protocal/protobuf/RadarRelationChainResponse;", "getRadarRelationChainResponse", "()Lcom/tencent/mm/protocal/protobuf/RadarRelationChainResponse;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-radar_release"})
public final class a
  extends n
  implements com.tencent.mm.network.k
{
  private static final String TAG = "MicroMsg.Radar.NetSceneRadarRelationChain";
  public static final a wau;
  private g callback;
  final b rr;
  
  static
  {
    AppMethodBeat.i(138507);
    wau = new a((byte)0);
    TAG = "MicroMsg.Radar.NetSceneRadarRelationChain";
    AppMethodBeat.o(138507);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(138505);
    d.g.b.k.h(parame, "dispatcher");
    d.g.b.k.h(paramg, "callback");
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(138505);
    return i;
  }
  
  public final int getType()
  {
    return 602;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138506);
    ac.d(TAG, "netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = this.callback;
    if (paramq != null)
    {
      paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      AppMethodBeat.o(138506);
      return;
    }
    AppMethodBeat.o(138506);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.a
 * JD-Core Version:    0.7.0.1
 */