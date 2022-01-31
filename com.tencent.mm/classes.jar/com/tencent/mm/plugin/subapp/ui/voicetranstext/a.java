package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.protocal.c.cds;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  public static int pyq = 1;
  public static int pyr = 2;
  public static int pys = 3;
  private String bYR;
  private b ecz;
  private f mEe;
  private String mFileName;
  public int mState = -1;
  private String pyk;
  private int pyl;
  private cds pym;
  private long pyn;
  private int pyo;
  private String pyp;
  public cdx pyt;
  public cbr pyu;
  public bhy pyv;
  int pyw;
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, 0, "", "");
  }
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramString3, paramString4);
  }
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    a(paramString1, paramInt, -1, -1L, paramString2, 0, "", "");
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    a(paramString1, paramInt1, -1, -1L, paramString2, paramInt2, paramString3, paramString4);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    b.a locala = new b.a();
    locala.ecH = new qc();
    locala.ecI = new qd();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.ecG = 546;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.mFileName = paramString2;
    this.ecz = locala.Kt();
    y.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.pym = d.aK(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.pyn = paramLong;
    }
    this.pyk = paramString1;
    this.pyl = paramInt1;
    this.pyo = paramInt3;
    this.pyp = paramString3;
    this.bYR = paramString4;
  }
  
  public final int a(e parame, f paramf)
  {
    this.mEe = paramf;
    paramf = (qc)this.ecz.ecE.ecN;
    paramf.sNM = this.pyk;
    paramf.ndf = this.pyl;
    paramf.sNN = this.pym;
    paramf.ndp = this.pyn;
    paramf.pyo = this.pyo;
    paramf.kWn = this.pyp;
    paramf.kWm = this.bYR;
    return a(parame, this.ecz, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (qd)this.ecz.ecF.ecN;
      if (paramq == null) {
        return;
      }
      this.pyt = paramq.sNO;
      this.mState = paramq.hQq;
      this.pyu = paramq.sNP;
      this.pyv = paramq.sNQ;
      this.pyw = paramq.sNR;
    }
    for (;;)
    {
      this.mEe.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.pyk });
    }
  }
  
  public final boolean bMf()
  {
    return (this.pyt != null) && (!bk.bl(this.pyt.tSA));
  }
  
  public final int getType()
  {
    return 546;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */