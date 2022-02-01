package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends q
  implements m
{
  public qt Ilv;
  private i callback;
  private d kwO;
  
  public h(String paramString1, String paramString2, String paramString3, int paramInt, b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new qs();
    ((d.a)localObject).lBV = new qt();
    ((d.a)localObject).funcId = 1680;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.kwO = ((d.a)localObject).bgN();
    localObject = (qs)d.b.b(this.kwO.lBR);
    ((qs)localObject).ImY = paramString3;
    ((qs)localObject).RJf = paramString1;
    ((qs)localObject).InV = paramString2;
    ((qs)localObject).RJi = paramInt;
    ((qs)localObject).RZb = paramb;
    ((qs)localObject).RJg = paramString4;
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(67841);
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Ilv = ((qt)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Ilv.tqa), this.Ilv.tqb });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.h
 * JD-Core Version:    0.7.0.1
 */