package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkg;
import com.tencent.mm.protocal.c.bkh;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cdt;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends com.tencent.mm.ah.m
  implements k
{
  int Do = 0;
  private int El = 0;
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private String filename;
  public boolean pLi = false;
  private boolean pLj = false;
  private Handler pLk = null;
  int pLl = 0;
  private int pLm = 0;
  int pLn = 0;
  
  public f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pLn = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkg();
    ((b.a)localObject).ecI = new bkh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/registervoiceprint";
    ((b.a)localObject).ecG = 612;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bkg)this.dmK.ecE.ecN;
    this.filename = paramString;
    this.El = 0;
    ((bkg)localObject).tDZ = paramInt2;
    ((bkg)localObject).hQP = paramInt1;
    this.pLl = paramInt3;
    ((bkg)localObject).tDX = paramInt3;
    y.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.pLi = true;
    bOZ();
  }
  
  private int bOZ()
  {
    bkg localbkg = (bkg)this.dmK.ecE.ecN;
    cdt localcdt = new cdt();
    new g();
    localbkg.tDY = localcdt;
    Object localObject = new l(m.bh(this.filename, false));
    int i = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
    if (i - this.El >= 6000) {}
    for (localObject = ((l)localObject).bz(this.El, 6000);; localObject = ((l)localObject).bz(this.El, i - this.El))
    {
      y.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.El), Integer.valueOf(((g)localObject).ret), Integer.valueOf(((g)localObject).bDu), Integer.valueOf(i), Boolean.valueOf(this.pLi) });
      if (((g)localObject).bDu != 0) {
        break;
      }
      return -2;
    }
    if (((g)localObject).ret < 0)
    {
      y.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((g)localObject).ret) });
      return -1;
    }
    if (this.El >= 469000)
    {
      y.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.El) });
      return -1;
    }
    localcdt.tSv = new bmk().bs(((g)localObject).buf);
    localcdt.ndg = this.El;
    localcdt.tSt = ((g)localObject).bDu;
    localcdt.tSu = 0;
    localbkg.tDX = this.pLl;
    if (this.pLi)
    {
      int j = (int)com.tencent.mm.vfs.e.aeQ(m.bh(this.filename, false));
      if (((g)localObject).eIh >= j)
      {
        localcdt.tSu = 1;
        this.pLj = true;
        y.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.El = ((g)localObject).eIh;
    localbkg.tDY = localcdt;
    return 0;
  }
  
  protected final int Ka()
  {
    return 240;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (bkh)((b)paramq).ecF.ecN;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[] { Integer.valueOf(paramq.tDX), Integer.valueOf(paramq.tEa), Integer.valueOf(paramq.tEb), Integer.valueOf(paramq.tEa) });
    this.pLl = paramq.tDX;
    this.pLm = paramq.tEb;
    this.Do = paramq.tEa;
    if (this.pLj)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(bOZ()) });
    a(this.edc, this.dmL);
    y.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.f
 * JD-Core Version:    0.7.0.1
 */