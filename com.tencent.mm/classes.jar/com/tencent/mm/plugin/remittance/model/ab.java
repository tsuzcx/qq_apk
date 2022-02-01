package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.Log;

public final class ab
  extends q
  implements m
{
  public xd Imi;
  private i callback;
  private d kwO;
  
  public ab(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    AppMethodBeat.i(67877);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new xc();
    ((d.a)localObject).lBV = new xd();
    ((d.a)localObject).funcId = 1779;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (xc)d.b.b(this.kwO.lBR);
    ((xc)localObject).fHb = paramString1;
    ((xc)localObject).Inf = paramString2;
    ((xc)localObject).Ine = paramString3;
    ((xc)localObject).ImY = paramString4;
    ((xc)localObject).Ipu = paramLong;
    ((xc)localObject).SiM = paramString5;
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[] { paramString1, paramString2, Long.valueOf(paramLong) });
    AppMethodBeat.o(67877);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67878);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
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
    this.Imi = ((xd)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Imi.fwx), this.Imi.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ab
 * JD-Core Version:    0.7.0.1
 */