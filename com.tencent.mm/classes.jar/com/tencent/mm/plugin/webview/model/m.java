package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  public final b fBd;
  
  public m(List<avv> paramList, String paramString)
  {
    AppMethodBeat.i(6598);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new agu();
    ((b.a)localObject).fsY = new agv();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
    ((b.a)localObject).funcId = 1704;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fBd = ((b.a)localObject).ado();
    localObject = (agu)this.fBd.fsV.fta;
    ((agu)localObject).wZt.addAll(paramList);
    ((agu)localObject).cwc = paramString;
    ab.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[] { Integer.valueOf(((agu)localObject).wZt.size()) });
    AppMethodBeat.o(6598);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6599);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(6599);
    return i;
  }
  
  public final int getType()
  {
    return 1704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6600);
    ab.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ab.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(6600);
      return;
      ab.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.m
 * JD-Core Version:    0.7.0.1
 */