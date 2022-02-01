package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.protocal.protobuf.sn;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public sn wKt;
  private sm wKu;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207134);
    b.a locala = new b.a();
    locala.hvt = new sm();
    locala.hvu = new sn();
    locala.funcId = 2850;
    locala.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
    this.rr = locala.aAz();
    this.wKu = ((sm)this.rr.hvr.hvw);
    this.wKu.wMb = paramString1;
    this.wKu.djj = paramString2;
    AppMethodBeat.o(207134);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(207135);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(207135);
    return i;
  }
  
  public final int getType()
  {
    return 2850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207136);
    ac.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.wKt = ((sn)((b)paramq).hvs.hvw);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(207136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */