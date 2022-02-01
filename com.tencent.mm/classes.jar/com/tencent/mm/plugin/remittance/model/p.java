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
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private uj xYe;
  public uk xYf;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    b.a locala = new b.a();
    locala.hNM = new uj();
    locala.hNN = new uk();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.gPp = locala.aDC();
    this.xYe = ((uj)this.gPp.hNK.hNQ);
    this.xYe.FvH = paramString1;
    this.xYe.FvI = paramString2;
    this.xYe.vls = paramInt1;
    this.xYe.xYV = paramString3;
    this.xYe.xYU = paramString4;
    this.xYe.channel = paramInt2;
    this.xYe.xXA = paramInt3;
    this.xYe.FTH = paramString5;
    this.xYe.FTI = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(67869);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(67869);
    return i;
  }
  
  public final int getType()
  {
    return 2773;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67870);
    ad.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.xYf = ((uk)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.xYf.dlw), this.xYf.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(67870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.p
 * JD-Core Version:    0.7.0.1
 */