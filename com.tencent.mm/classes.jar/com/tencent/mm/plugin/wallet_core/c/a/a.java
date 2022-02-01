package com.tencent.mm.plugin.wallet_core.c.a;

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
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69967);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new czx();
    ((d.a)localObject).iLO = new czy();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
    ((d.a)localObject).funcId = 1767;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (czx)this.rr.iLK.iLR;
    ((czx)localObject).jfi = paramString1;
    ((czx)localObject).Lkq = paramString4;
    ((czx)localObject).Lkp = paramString2;
    ((czx)localObject).Lkr = paramString5;
    ((czx)localObject).Lks = paramString6;
    ((czx)localObject).KPJ = paramString3;
    ((czx)localObject).Ljk = paramString7;
    AppMethodBeat.o(69967);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69969);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69969);
    return i;
  }
  
  public final int getType()
  {
    return 1767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69968);
    Log.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (czy)((d)params).iLL.iLR;
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.rBL;
        params = paramArrayOfByte.rBM;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(69968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.a
 * JD-Core Version:    0.7.0.1
 */