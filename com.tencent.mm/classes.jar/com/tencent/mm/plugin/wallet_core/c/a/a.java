package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69967);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bza();
    ((b.a)localObject).gUV = new bzb();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
    ((b.a)localObject).funcId = 1767;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bza)this.rr.gUS.gUX;
    ((bza)localObject).hnC = paramString1;
    ((bza)localObject).CXl = paramString4;
    ((bza)localObject).CXk = paramString2;
    ((bza)localObject).CXm = paramString5;
    ((bza)localObject).CXn = paramString6;
    ((bza)localObject).CFH = paramString3;
    ((bza)localObject).CWf = paramString7;
    AppMethodBeat.o(69967);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(69969);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(69969);
    return i;
  }
  
  public final int getType()
  {
    return 1767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69968);
    ad.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (bzb)((b)paramq).gUT.gUX;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.oXv;
        paramq = paramArrayOfByte.oXw;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(69968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a.a
 * JD-Core Version:    0.7.0.1
 */