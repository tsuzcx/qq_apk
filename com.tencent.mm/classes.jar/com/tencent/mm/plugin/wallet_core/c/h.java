package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;

public final class h
  extends q
  implements m
{
  public biw HPF;
  private i callback;
  private d rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(69902);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new biv();
    ((d.a)localObject).iLO = new biw();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).routeInfo = f.bpA(paramString);
    this.rr = ((d.a)localObject).aXF();
    localObject = (biv)this.rr.iLK.iLR;
    Log.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[] { paramString });
    ((biv)localObject).dNQ = paramString;
    AppMethodBeat.o(69902);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69903);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69903);
    return i;
  }
  
  public final int getType()
  {
    return 1667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69904);
    Log.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.HPF = ((biw)this.rr.iLL.iLR);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(69904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.h
 * JD-Core Version:    0.7.0.1
 */