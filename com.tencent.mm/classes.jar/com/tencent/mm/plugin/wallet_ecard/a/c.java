package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends n
  implements k
{
  public lf DGF;
  private f callback;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(71688);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new le();
    ((b.a)localObject).hQG = new lf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bindecard";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (le)this.rr.hQD.hQJ;
    ((le)localObject).FVJ = paramString1;
    ((le)localObject).FVK = paramString2;
    ((le)localObject).DrK = paramString3;
    ((le)localObject).FVL = paramString4;
    ((le)localObject).dDd = paramInt;
    ae.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    AppMethodBeat.o(71688);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71690);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71690);
    return i;
  }
  
  public final int getType()
  {
    return 1986;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71689);
    ae.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DGF = ((lf)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.DGF.oGt), this.DGF.oGu });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(71689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a.c
 * JD-Core Version:    0.7.0.1
 */