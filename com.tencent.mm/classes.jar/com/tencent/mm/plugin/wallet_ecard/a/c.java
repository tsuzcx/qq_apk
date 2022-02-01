package com.tencent.mm.plugin.wallet_ecard.a;

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
import com.tencent.mm.protocal.protobuf.lv;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends q
  implements m
{
  public lw IpR;
  private i callback;
  private d rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(71688);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new lv();
    ((d.a)localObject).iLO = new lw();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/bindecard";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (lv)this.rr.iLK.iLR;
    ((lv)localObject).KPu = paramString1;
    ((lv)localObject).KPv = paramString2;
    ((lv)localObject).IaW = paramString3;
    ((lv)localObject).KPw = paramString4;
    ((lv)localObject).dUS = paramInt;
    Log.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(71688);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71690);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71690);
    return i;
  }
  
  public final int getType()
  {
    return 1986;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71689);
    Log.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IpR = ((lw)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.IpR.pTZ), this.IpR.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.c
 * JD-Core Version:    0.7.0.1
 */