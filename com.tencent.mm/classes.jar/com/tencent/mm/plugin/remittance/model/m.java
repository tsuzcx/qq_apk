package com.tencent.mm.plugin.remittance.model;

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
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public ui xYa;
  private uh xYb;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199129);
    b.a locala = new b.a();
    locala.hNM = new uh();
    locala.hNN = new ui();
    locala.funcId = 2850;
    locala.uri = "/cgi-bin/mmpay-bin/f2fminiprogramconfirmrcvr";
    this.rr = locala.aDC();
    this.xYb = ((uh)this.rr.hNK.hNQ);
    this.xYb.xZI = paramString1;
    this.xYb.duW = paramString2;
    AppMethodBeat.o(199129);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(199130);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(199130);
    return i;
  }
  
  public final int getType()
  {
    return 2850;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199131);
    ad.i("MicroMsg.NetSceneF2FMinniProgramConfirm", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.xYa = ((ui)((b)paramq).hNL.hNQ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(199131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.m
 * JD-Core Version:    0.7.0.1
 */