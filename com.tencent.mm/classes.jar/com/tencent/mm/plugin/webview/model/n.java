package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private g callback;
  public final b hEg;
  
  public n(List<bks> paramList, String paramString)
  {
    AppMethodBeat.i(78879);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new atf();
    ((b.a)localObject).hvu = new atg();
    ((b.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
    ((b.a)localObject).funcId = 1704;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (atf)this.hEg.hvr.hvw;
    ((atf)localObject).EMk.addAll(paramList);
    ((atf)localObject).djj = paramString;
    ac.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[] { Integer.valueOf(((atf)localObject).EMk.size()) });
    AppMethodBeat.o(78879);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78880);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
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
    ac.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ac.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78881);
      return;
      ac.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */