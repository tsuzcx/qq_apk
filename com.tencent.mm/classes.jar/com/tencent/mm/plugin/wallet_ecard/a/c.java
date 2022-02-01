package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  public lf DoZ;
  private f callback;
  private b rr;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(71688);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new le();
    ((b.a)localObject).hNN = new lf();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/bindecard";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (le)this.rr.hNK.hNQ;
    ((le)localObject).FDo = paramString1;
    ((le)localObject).FDp = paramString2;
    ((le)localObject).Daf = paramString3;
    ((le)localObject).FDq = paramString4;
    ((le)localObject).dBY = paramInt;
    ad.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
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
    ad.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.DoZ = ((lf)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[] { Integer.valueOf(this.DoZ.ozR), this.DoZ.ozS });
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