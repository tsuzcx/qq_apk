package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.w;

public final class i
  extends w
{
  private f callback;
  private b rr;
  
  public i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(72312);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cud();
    ((b.a)localObject).hQG = new cue();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
    ((b.a)localObject).funcId = 600;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cud)this.rr.hQD.hQJ;
    ((cud)localObject).HFd = paramString1;
    ((cud)localObject).HFc = bu.getInt(paramString2, 0);
    ((cud)localObject).Ghz = k.eIV();
    AppMethodBeat.o(72312);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(72314);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(72313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.a.i
 * JD-Core Version:    0.7.0.1
 */