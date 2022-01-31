package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private mt nyr;
  public mu nys;
  
  public o(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    b.a locala = new b.a();
    locala.ecH = new mt();
    locala.ecI = new mu();
    locala.ecG = 2773;
    locala.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.nyr = ((mt)this.eWr.ecE.ecN);
    this.nyr.swc = paramString1;
    this.nyr.swd = paramString2;
    this.nyr.amount = paramInt1;
    this.nyr.nzf = paramString3;
    this.nyr.nze = paramString4;
    this.nyr.bUR = paramInt2;
    this.nyr.nxO = paramInt3;
    this.nyr.sKq = paramString5;
    this.nyr.sKr = paramString6;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nys = ((mu)((b)paramq).ecF.ecN);
    y.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.nys.iHq), this.nys.iHr });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 2773;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.o
 * JD-Core Version:    0.7.0.1
 */