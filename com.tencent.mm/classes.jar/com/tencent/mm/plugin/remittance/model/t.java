package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
  extends q
  implements m
{
  public wz CoT;
  private i callback;
  private d hJu;
  
  public t(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new wy();
    ((d.a)localObject).iLO = new wz();
    ((d.a)localObject).funcId = 1779;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hJu = ((d.a)localObject).aXF();
    localObject = (wy)this.hJu.iLK.iLR;
    ((wy)localObject).dNQ = paramString1;
    ((wy)localObject).CpQ = paramString2;
    ((wy)localObject).CpP = paramString3;
    ((wy)localObject).CpJ = paramString4;
    ((wy)localObject).CrW = paramLong;
    ((wy)localObject).Lhy = paramString5;
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67878);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(67878);
    return i;
  }
  
  public final int getType()
  {
    return 1779;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67879);
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.CoT = ((wz)((d)params).iLL.iLR);
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.CoT.dDN), this.CoT.qwn });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.t
 * JD-Core Version:    0.7.0.1
 */