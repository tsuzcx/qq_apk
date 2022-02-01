package com.tencent.mm.plugin.wallet_core.c.a;

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
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(69967);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cjp();
    ((b.a)localObject).hQG = new cjq();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
    ((b.a)localObject).funcId = 1767;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cjp)this.rr.hQD.hQJ;
    ((cjp)localObject).ikm = paramString1;
    ((cjp)localObject).GpE = paramString4;
    ((cjp)localObject).GpD = paramString2;
    ((cjp)localObject).GpF = paramString5;
    ((cjp)localObject).GpG = paramString6;
    ((cjp)localObject).FVY = paramString3;
    ((cjp)localObject).Goz = paramString7;
    AppMethodBeat.o(69967);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(69969);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = (cjq)((b)paramq).hQE.hQJ;
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramInt2 == 0)
      {
        paramInt1 = paramArrayOfByte.qkQ;
        paramq = paramArrayOfByte.qkR;
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