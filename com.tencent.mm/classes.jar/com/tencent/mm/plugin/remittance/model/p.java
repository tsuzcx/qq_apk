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
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
  extends n
  implements k
{
  private g callback;
  private b iaa;
  private se vAs;
  public sf vAt;
  
  public p(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(67868);
    b.a locala = new b.a();
    locala.gUU = new se();
    locala.gUV = new sf();
    locala.funcId = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.iaa = locala.atI();
    this.vAs = ((se)this.iaa.gUS.gUX);
    this.vAs.CxW = paramString1;
    this.vAs.CxX = paramString2;
    this.vAs.tav = paramInt1;
    this.vAs.vBj = paramString3;
    this.vAs.vBi = paramString4;
    this.vAs.channel = paramInt2;
    this.vAs.vzO = paramInt3;
    this.vAs.CTN = paramString5;
    this.vAs.CTO = paramString6;
    AppMethodBeat.o(67868);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(67869);
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
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
    this.vAt = ((sf)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.vAt.dcG), this.vAt.nTK });
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