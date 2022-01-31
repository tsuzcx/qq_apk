package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private f dIJ;
  private final com.tencent.mm.ah.b dmK;
  private long iYu = 0L;
  private byte[] iZM = null;
  private String iZO;
  private int iZz;
  int qYH = -1;
  boolean qYI = true;
  
  public b(int paramInt1, String paramString, byte[] paramArrayOfByte, int paramInt2, long paramLong)
  {
    b.a locala = new b.a();
    locala.ecH = new bnp();
    locala.ecI = new bnq();
    locala.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
    locala.ecG = 234;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZz = paramInt1;
    this.iZO = paramString;
    this.iZM = paramArrayOfByte;
    this.qYH = paramInt2;
    this.iYu = paramLong;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    bnp localbnp = (bnp)this.dmK.ecE.ecN;
    if (!bk.bE(this.iZM))
    {
      localbnp.tcI = aa.I(this.iZM);
      this.qYI = false;
      localbnp.tcL = this.iYu;
      if (localbnp.tcI != null) {
        break label115;
      }
    }
    label115:
    for (paramf = "Buf is NULL";; paramf = localbnp.tcI.toString())
    {
      y.d("MicroMsg.emoji.NetSceneSearchEmotion", paramf);
      localbnp.sAs = this.iZz;
      localbnp.tcJ = this.iZO;
      return a(parame, this.dmK, this);
      localbnp.tcI = new bmk();
      this.qYI = true;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bnq cax()
  {
    if (this.dmK == null) {
      return null;
    }
    return (bnq)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 234;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.b
 * JD-Core Version:    0.7.0.1
 */