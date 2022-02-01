package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends p
  implements m
{
  private h callback;
  public final c oDw;
  
  public n(List<daw> paramList, String paramString)
  {
    AppMethodBeat.i(78879);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfd();
    ((c.a)localObject).otF = new cfe();
    ((c.a)localObject).uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
    ((c.a)localObject).funcId = 1704;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (cfd)c.b.b(this.oDw.otB);
    ((cfd)localObject).aaoO.addAll(paramList);
    ((cfd)localObject).appid = paramString;
    Log.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[] { Integer.valueOf(((cfd)localObject).aaoO.size()) });
    AppMethodBeat.o(78879);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78880);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(78880);
    return i;
  }
  
  public final int getType()
  {
    return 1704;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78881);
    Log.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      Log.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78881);
      return;
      Log.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.n
 * JD-Core Version:    0.7.0.1
 */