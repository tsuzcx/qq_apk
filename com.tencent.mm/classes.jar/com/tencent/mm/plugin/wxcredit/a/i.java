package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.coh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.c.w;

public final class i
  extends w
{
  private g callback;
  private b rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72312);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cog();
    ((b.a)localObject).hvu = new coh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
    ((b.a)localObject).funcId = 600;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cog)this.rr.hvr.hvw;
    ((cog)localObject).FBq = paramString1;
    ((cog)localObject).FBp = bs.getInt(paramString2, 0);
    ((cog)localObject).EhT = k.ero();
    AppMethodBeat.o(72312);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(72314);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(72314);
    return i;
  }
  
  public final int getType()
  {
    return 600;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(72313);
    ac.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.i
 * JD-Core Version:    0.7.0.1
 */