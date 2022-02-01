package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class i
  extends w
{
  public se Oim;
  private h callback;
  private c nao;
  
  public i(String paramString1, String paramString2, String paramString3, int paramInt, b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new sd();
    ((c.a)localObject).otF = new se();
    ((c.a)localObject).funcId = 1680;
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.nao = ((c.a)localObject).bEF();
    localObject = (sd)c.b.b(this.nao.otB);
    ((sd)localObject).Oiw = paramString3;
    ((sd)localObject).YGt = paramString1;
    ((sd)localObject).Oln = paramString2;
    ((sd)localObject).YGv = paramInt;
    ((sd)localObject).YXb = paramb;
    ((sd)localObject).YGu = paramString4;
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(67841);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(288825);
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.Oim = ((se)c.c.b(((c)params).otC));
    Log.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.Oim.wuz), this.Oim.wuA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(288825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.i
 * JD-Core Version:    0.7.0.1
 */