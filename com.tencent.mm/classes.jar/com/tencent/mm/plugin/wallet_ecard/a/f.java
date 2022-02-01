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
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  public dgz IpX;
  private i callback;
  private d rr;
  
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(71698);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dgy();
    ((d.a)localObject).iLO = new dgz();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dgy)this.rr.iLK.iLR;
    ((dgy)localObject).KPu = paramString;
    ((dgy)localObject).dUS = paramInt;
    Log.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(71698);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71700);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71700);
    return i;
  }
  
  public final int getType()
  {
    return 1988;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71699);
    Log.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.IpX = ((dgz)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.IpX.pTZ), this.IpX.pUa });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.f
 * JD-Core Version:    0.7.0.1
 */