package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.w;

public final class i
  extends w
{
  private com.tencent.mm.ak.i callback;
  private d rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72312);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dmw();
    ((d.a)localObject).iLO = new dmx();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
    ((d.a)localObject).funcId = 600;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dmw)this.rr.iLK.iLR;
    ((dmw)localObject).MQl = paramString1;
    ((dmw)localObject).MQk = Util.getInt(paramString2, 0);
    ((dmw)localObject).Lcc = k.fQy();
    AppMethodBeat.o(72312);
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(72314);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(72314);
    return i;
  }
  
  public final int getType()
  {
    return 600;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72313);
    Log.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.i
 * JD-Core Version:    0.7.0.1
 */