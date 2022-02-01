package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private f callback;
  public final b hWL;
  
  public n(List<bpc> paramList, String paramString)
  {
    AppMethodBeat.i(78879);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new axd();
    ((b.a)localObject).hNN = new axe();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
    ((b.a)localObject).funcId = 1704;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hWL = ((b.a)localObject).aDC();
    localObject = (axd)this.hWL.hNK.hNQ;
    ((axd)localObject).Gvo.addAll(paramList);
    ((axd)localObject).duW = paramString;
    ad.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[] { Integer.valueOf(((axd)localObject).Gvo.size()) });
    AppMethodBeat.o(78879);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78880);
    this.callback = paramf;
    int i = dispatch(parame, this.hWL, this);
    AppMethodBeat.o(78880);
    return i;
  }
  
  public final int getType()
  {
    return 1704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78881);
    ad.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78881);
      return;
      ad.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */