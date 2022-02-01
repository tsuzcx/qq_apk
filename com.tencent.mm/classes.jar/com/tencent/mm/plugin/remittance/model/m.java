package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.platformtools.ae;

public final class m
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public uk ynS;
  private uj ynT;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189986);
    b.a locala = new b.a();
    locala.hQF = new uj();
    locala.hQG = new uk();
    locala.funcId = 2850;
    locala.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
    this.rr = locala.aDS();
    this.ynT = ((uj)this.rr.hQD.hQJ);
    this.ynT.ypA = paramString1;
    this.ynT.dwb = paramString2;
    AppMethodBeat.o(189986);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(189987);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(189987);
    return i;
  }
  
  public final int getType()
  {
    return 2850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189988);
    ae.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.ynS = ((uk)((b)paramq).hQE.hQJ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(189988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */