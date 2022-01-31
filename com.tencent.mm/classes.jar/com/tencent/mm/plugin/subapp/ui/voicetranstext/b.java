package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amf;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class b
  extends m
  implements k
{
  private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
  private com.tencent.mm.ah.b ecz;
  private f mEe;
  private String pyk;
  public cdx pyt;
  public int pyx = -1;
  
  public b(String paramString)
  {
    if (!bk.bl(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.pyk = paramString;
      paramString = new b.a();
      paramString.ecH = new amf();
      paramString.ecI = new amg();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.ecG = 548;
      paramString.ecJ = 0;
      paramString.ecK = 0;
      this.ecz = paramString.Kt();
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.mEe = paramf;
    ((amf)this.ecz.ecE.ecN).sNM = this.pyk;
    return a(parame, this.ecz, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (amg)this.ecz.ecF.ecN;
      if (paramq.sNQ != null) {
        this.pyx = paramq.sNQ.tCw;
      }
      this.pyt = paramq.sNO;
    }
    for (;;)
    {
      this.mEe.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
  
  public final boolean bMf()
  {
    return (this.pyt != null) && (!bk.bl(this.pyt.tSA));
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean isComplete()
  {
    return (this.pyt != null) && (this.pyt.euw == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */