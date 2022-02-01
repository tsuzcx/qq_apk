package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.td;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  public LinkedList<String> HPE;
  private i callback;
  private d rr;
  
  public f(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(69897);
    Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjb();
    ((d.a)localObject).iLO = new bjc();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/bankresource";
    ((d.a)localObject).funcId = getType();
    this.rr = ((d.a)localObject).aXF();
    this.rr.setIsUserCmd(true);
    localObject = (bjb)this.rr.iLK.iLR;
    ((bjb)localObject).LSP = paramLinkedList;
    ((bjb)localObject).Lcc = k.fQy();
    if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
      ((bjb)localObject).LhT = com.tencent.mm.pluginsdk.wallet.e.gsR();
    }
    com.tencent.mm.wallet_core.ui.f.aqm(42);
    AppMethodBeat.o(69897);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(69898);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69898);
    return i;
  }
  
  public final int getType()
  {
    return 1650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69899);
    Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + paramInt2 + "errCode=" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bjc)((d)params).iLL.iLR;
      Log.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", new Object[] { params.LSQ });
      this.HPE = params.HPE;
      paramArrayOfByte = this.HPE;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
      {
        Log.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXo, Util.nullAs(params.LSQ, ""));
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXp, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(69899);
      return;
      td localtd = new td();
      localtd.dZA.dZC = paramArrayOfByte;
      EventCenter.instance.publish(localtd);
      break;
      com.tencent.mm.wallet_core.ui.f.aqm(43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.f
 * JD-Core Version:    0.7.0.1
 */