package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.protocal.protobuf.sd;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public sd vAo;
  private sc vAp;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187053);
    b.a locala = new b.a();
    locala.gUU = new sc();
    locala.gUV = new sd();
    locala.funcId = 2850;
    locala.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
    this.rr = locala.atI();
    this.vAp = ((sc)this.rr.gUS.gUX);
    this.vAp.vBW = paramString1;
    this.vAp.dlB = paramString2;
    AppMethodBeat.o(187053);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(187054);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(187054);
    return i;
  }
  
  public final int getType()
  {
    return 2850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187055);
    ad.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.vAo = ((sd)((b)paramq).gUT.gUX);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(187055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */