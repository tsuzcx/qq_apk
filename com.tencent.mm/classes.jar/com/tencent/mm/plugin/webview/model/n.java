package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  public final b hZD;
  
  public n(List<bpu> paramList, String paramString)
  {
    AppMethodBeat.i(78879);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new axt();
    ((b.a)localObject).hQG = new axu();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
    ((b.a)localObject).funcId = 1704;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (axt)this.hZD.hQD.hQJ;
    ((axt)localObject).GON.addAll(paramList);
    ((axt)localObject).dwb = paramString;
    ae.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[] { Integer.valueOf(((axt)localObject).GON.size()) });
    AppMethodBeat.o(78879);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78880);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ae.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78881);
      return;
      ae.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */