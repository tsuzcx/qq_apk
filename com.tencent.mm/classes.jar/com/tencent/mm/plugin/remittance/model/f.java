package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b gPp;
  public px xXL;
  
  public f(String paramString1, String paramString2, String paramString3, int paramInt, com.tencent.mm.bx.b paramb, String paramString4)
  {
    AppMethodBeat.i(67840);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new pw();
    ((b.a)localObject).hNN = new px();
    ((b.a)localObject).funcId = 1680;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/busif2factqry";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gPp = ((b.a)localObject).aDC();
    localObject = (pw)this.gPp.hNK.hNQ;
    ((pw)localObject).xZb = paramString3;
    ((pw)localObject).FvH = paramString1;
    ((pw)localObject).FvI = paramString2;
    ((pw)localObject).FvL = paramInt;
    ((pw)localObject).FLc = paramb;
    ((pw)localObject).FvJ = paramString4;
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(67840);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(67841);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(67841);
    return i;
  }
  
  public final int getType()
  {
    return 1680;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67842);
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xXL = ((px)((com.tencent.mm.al.b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xXL.ozR), this.xXL.ozS });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.f
 * JD-Core Version:    0.7.0.1
 */